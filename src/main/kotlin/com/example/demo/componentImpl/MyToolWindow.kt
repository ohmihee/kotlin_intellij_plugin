package com.example.demo.componentImpl

import com.example.demo.services.MyProjectService
import com.intellij.openapi.components.service
import com.intellij.openapi.components.services
import com.intellij.openapi.wm.ToolWindow
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBPanel
import javax.swing.JButton


class MyToolWindow(toolWindow: ToolWindow) {
    private val myProjectService = toolWindow.project.service<MyProjectService>()

    fun getContent() = JBPanel<JBPanel<*>>().apply {
        val label = JBLabel("label")
        add(label)
        add(JButton("shuffle").apply {
            addActionListener {
                label.text = myProjectService.getRandomNumber().toString()
            }
        })
    }
}