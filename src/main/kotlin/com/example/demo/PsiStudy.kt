package com.example.demo

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiFile
import com.intellij.psi.search.FilenameIndex
import com.intellij.psi.search.GlobalSearchScope
import java.io.File

class PsiStudy:AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        findRelativePath(e)
    }

    private fun findRelativePath(e: AnActionEvent) {
        val project = e.project ?: return
        val projectBasePath = project.basePath ?: return

        val targetClassName = "MpsmetaRole" // 찾고자 하는 클래스 이름

        val psiFiles =
            FilenameIndex.getFilesByName(project, "$targetClassName.java", GlobalSearchScope.projectScope(project))
        for (psiFile in psiFiles) {
            val psiClass = findPsiClassInFile(psiFile, targetClassName)
            if (psiClass != null) {
                val classFilePath = psiClass.containingFile.virtualFile.path
                val relativePath = getRelativePath(projectBasePath, classFilePath)
                println("Class '$targetClassName' found at relative path: $relativePath")
            }
        }
    }

    private fun findFullPath(e: AnActionEvent) {
        val project = e.project ?: return

        val targetClassName = "MpsmetaRole" // 찾고자 하는 클래스 이름

        val psiFiles =
            FilenameIndex.getFilesByName(project, "$targetClassName.java", GlobalSearchScope.projectScope(project))
        for (psiFile in psiFiles) {
            val psiClass = findPsiClassInFile(psiFile, targetClassName)
            if (psiClass != null) {
                val classFilePath = psiClass.containingFile.virtualFile.path
                println("Class '$targetClassName' found at: $classFilePath")
            }
        }
    }

    private fun findPsiClassInFile(psiFile: PsiFile, targetClassName: String ): PsiClass? {
        return psiFile.children
            .filterIsInstance<PsiClass>()
            .firstOrNull { it.name == targetClassName }
    }

    private fun getRelativePath(basePath: String, filePath: String): String {
        val baseDir = LocalFileSystem.getInstance().findFileByIoFile(File(basePath))
        val file = LocalFileSystem.getInstance().findFileByIoFile(File(filePath))
        if (baseDir != null && file != null) {
            return file.path.substringAfter(baseDir.path).removePrefix("/")
        }
        return filePath
    }
}