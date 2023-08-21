package com.example.demo.componentImpl;

import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.components.JBPanel

import javax.swing.*;

class TestView(toolWindow:ToolWindow) {
    var view:JPanel? = null
    var btn1:JButton? = null
    var btn2: JButton? = null

    fun getContent() = JBPanel<JBPanel<*>>().apply {
        btn1 = JButton("btn1")
        btn2 = JButton("btn2")
        add(btn1)
        add(btn2)
    }
}
