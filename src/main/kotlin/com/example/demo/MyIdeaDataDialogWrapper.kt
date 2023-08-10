package com.example.demo

import com.intellij.credentialStore.CredentialAttributes
import com.intellij.credentialStore.Credentials
import com.intellij.ide.passwordSafe.PasswordSafe
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.ui.components.JBLabel
import com.intellij.uiDesigner.core.AbstractLayout
import com.intellij.util.ui.GridBag
import com.intellij.util.ui.JBUI
import com.intellij.util.ui.UIUtil
import java.awt.Dimension
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Insets
import javax.swing.JComponent
import javax.swing.JPanel
import javax.swing.JPasswordField
import javax.swing.JTextField

class MyIdeaDataDialogWrapper: DialogWrapper(true) {
    private val panel = JPanel(GridBagLayout())
    private val textMode = JTextField();
    private val textUsername = JTextField();
    private var textPassword = JPasswordField()

    init {
        init()
        title = "MyIdeaDemo Data"
        val state =MyIdeaDemoPluginSettings.genInstance().state
        if (state!=null) {
            textMode.text = state.mode
        }
        try {
            val credentialAttributes = CredentialAttributes("MyIdeaPlugin", "mykey")
            val credentials = PasswordSafe.instance.get(credentialAttributes)
            textPassword.text = credentials?.getPasswordAsString()
            textUsername.text = credentials?.userName.toString()
            PasswordSafe.instance.set(credentialAttributes, credentials)
        }catch(e:Exception) {
            print(e)
        }
    }
    override fun createCenterPanel(): JComponent? {
        val gb = GridBag()
            .setDefaultInsets(Insets(0,0, AbstractLayout.DEFAULT_VGAP, AbstractLayout.DEFAULT_HGAP))
            .setDefaultWeightX(1.0)
            .setDefaultFill(GridBagConstraints.HORIZONTAL)

        panel.preferredSize = Dimension(400, 400)

        panel.add(label("mode"), gb.nextLine().next().weightx(0.2))
        panel.add(textMode, gb.next().weightx(0.8))
        panel.add(label("username"), gb.nextLine().next().weightx(0.2))
        panel.add(textUsername, gb.next().weightx(0.8))
        panel.add(label("password"), gb.nextLine().next().weightx(0.2))
        panel.add(textPassword, gb.next().weightx(0.8))

        return panel
    }

    override fun doOKAction() {
        val mode = textMode.text
        val username = textUsername.text
        val password = textPassword.text
        val state = MyIdeaDemoPluginSettings.genInstance().state
        state?.mode = mode

        val credentialAttributes = CredentialAttributes("MyIdeaPlugin", "mykey")
        val credentials = Credentials(username, password)
        PasswordSafe.instance.set(credentialAttributes, credentials)
    }

    private fun label(text: String):JComponent {
        val label = JBLabel(text);
        label.componentStyle = UIUtil.ComponentStyle.SMALL
        label.fontColor = UIUtil.FontColor.BRIGHTER
        label.border = JBUI.Borders.empty(0,5,2,0)
        return label
    }


}