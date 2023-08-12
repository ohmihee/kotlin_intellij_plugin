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
        val project: Project? = e.project
        if (project != null) {
            val filePath = "./mpsmeta-facade/src/main/java/io/naraway/mpsmeta/facade/api/MpsMetaRole.java"
            val file = project.baseDir?.findFileByRelativePath(filePath)
            if (file != null) {
                FileEditorManager.getInstance(project).openFile(file, true)
            }
        }
    }
}

