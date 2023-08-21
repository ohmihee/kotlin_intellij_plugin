package com.example.demo.component;

import com.intellij.openapi.extensions.ExtensionPointName;

public interface MyCustomExtension {
    //ExtensionPointName<MyCustomExtension> EP_NAME = ExtensionPointName.create("example.group.myCustomExtension");

    void doSomething();
}
