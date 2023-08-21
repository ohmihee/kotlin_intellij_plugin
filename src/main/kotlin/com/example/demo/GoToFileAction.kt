package com.example.demo

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileManager
import java.io.File

class GoToFileAction:AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        goToFile(e)
    }

    private fun goToFile(e: AnActionEvent) {
        val project: Project? = e.project
//        if (project!=ㅜㅕㅣ) {
//            val filePath = ""
//            val file = project.baseDir?.findFileByRelativePath(filePath)
//            if (file != null) {
//                FileEditorManager.getInstance(project).openFile(file, true)
//            }
//        }
    }
}

