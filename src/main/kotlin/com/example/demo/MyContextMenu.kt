package com.example.demo

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class MyContextMenu: AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        //Messages.showMessageDialog(e.project)
        Messages.showMessageDialog("Hello from Context Menu!", "Context Menu Action", Messages.getInformationIcon())


    }
}