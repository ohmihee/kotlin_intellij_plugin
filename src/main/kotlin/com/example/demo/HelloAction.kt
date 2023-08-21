package com.example.demo

import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.ui.showYesNoDialog


class HelloAction:AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
    }

    private fun showInputDialog(e: AnActionEvent) {
        val userInput = Messages.showInputDialog(
            e.project,
            "please enter value",
            "test title",
            AllIcons.Ide.Gift,
            "initial value",
            null
        )
        println(userInput)
    }

    private fun showYesOrNoDialog(e: AnActionEvent) {
        showYesNoDialog("test", "test message", e.project)
    }
}
/**알림참---
 * Messages.showMessageDialog(e.project, "Hello world", "MyIdeaDemo", Messages.getInformationIcon())
 * */

/**파일 경로 알림-----* */
//        val fileChooserDescriptor = FileChooserDescriptor(
//            false,
//            true,
//            false,
//            false,
//            false,
//            false
//        )
//        fileChooserDescriptor.title = "MyIdeaDemo Pick Directory"
//        fileChooserDescriptor.description = "My file chooser demo"
//
//        FileChooser.chooseFile(fileChooserDescriptor, e.project, null, Consumer {
//            Messages.showMessageDialog(e.project, it.path, "Path", Messages.getInformationIcon())
//        })

//        val fileChooserDescriptor = FileChooserDescriptor(
//            false,
//            true,
//            false,
//            false,
//            false,
//            false
//        )
//        fileChooserDescriptor.title = "MyIdeaDemo Pick Directory"
//        fileChooserDescriptor.description = "My file chooser demo"
//
//        FileChooser.chooseFile(fileChooserDescriptor, e.project, null, Consumer {
//            Messages.showMessageDialog(e.project, it.path, "Path", Messages.getInformationIcon())
//        })
