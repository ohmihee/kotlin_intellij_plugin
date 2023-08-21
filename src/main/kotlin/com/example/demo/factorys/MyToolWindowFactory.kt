package com.example.demo.factorys

import com.example.demo.componentImpl.MyToolWindow
import com.example.demo.componentImpl.TestView
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import com.intellij.util.ui.JBUI

class MyToolWindowFactory :ToolWindowFactory{
    init {
        thisLogger().warn("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.")
    }

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val myToolWindow = MyToolWindow(toolWindow)
        val testView = TestView(toolWindow)
        val myContent = ContentFactory.getInstance().createContent(myToolWindow.getContent(), "shuffle", false)
        val testContent = ContentFactory.getInstance().createContent(testView.getContent(),"test", false)
        toolWindow.contentManager.addContent(myContent)
        toolWindow.contentManager.addContent(testContent)
    }

}