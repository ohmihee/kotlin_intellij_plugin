package com.example.demo

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.fileChooser.FileChooser
import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.ui.JBPopupMenu
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.ui.popup.JBPopupFactory
import com.intellij.util.Consumer

class MyIdeaDataDialogAction:AnAction("text") {
    override fun actionPerformed(e: AnActionEvent) {
    }

    private fun myIdeaDemoPopupListDialog(e: AnActionEvent) {
        val myIdeaDemoPopupList =
            MyIdeaDemoPopupList("my-idea-list", mutableListOf("apple", "orange", "pineapple", "guava"))
        if (e.project != null) {
            JBPopupFactory.getInstance().createListPopup(myIdeaDemoPopupList, 5)
                .showCenteredInCurrentWindow(e.project!!)
        }
    }

    private fun showCustomDialog() {
        val myIdeaDataDialogWrapper = MyIdeaDataDialogWrapper()
        if (MyIdeaDataDialogWrapper().showAndGet()) {
            myIdeaDataDialogWrapper.close(23)
        }
    }

    private fun getUserNAme(e: AnActionEvent) {
        val name =
            Messages.showInputDialog(e.project, "En ter your name", "FileChooser data", Messages.getQuestionIcon())
        Messages.showMessageDialog(e.project, "your name is $name", "FileChooser data", Messages.getInformationIcon())
    }

    private fun showFileDialog(e: AnActionEvent) {
        val fileChooserDescriptor = FileChooserDescriptor(
            false,
            true,
            false,
            false,
            false,
            false
        )
        fileChooserDescriptor.title = "MyIdeaDemo Pick Directory"
        fileChooserDescriptor.description = "My file chooser demo"

        FileChooser.chooseFile(fileChooserDescriptor, e.project, null, Consumer {
            Messages.showMessageDialog(e.project, it.path, "Path", Messages.getInformationIcon())
        })
    }
}