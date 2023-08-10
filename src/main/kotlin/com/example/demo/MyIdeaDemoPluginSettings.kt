package com.example.demo

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage

@State(
    name ="MyIdeaDemo",
    storages = [Storage("my-idea-demo.xml")]
)
class MyIdeaDemoPluginSettings:PersistentStateComponent<MyIdeaDemoPluginState> {
    private var pluginState = MyIdeaDemoPluginState()
    override fun getState(): MyIdeaDemoPluginState? {
        return pluginState
    }

    override fun loadState(state: MyIdeaDemoPluginState) {
        pluginState = state
    }

    companion object{
        @JvmStatic
        fun genInstance(): PersistentStateComponent<MyIdeaDemoPluginState> {
            return ServiceManager.getService(MyIdeaDemoPluginSettings::class.java)
        }
    }
}