// Copyright 2000-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.example.demo;

import com.intellij.CommonBundle;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.ResourceBundle;

public class MavenVersionInspectionBundle {
    private static Reference<ResourceBundle> ourBundle;

    @NonNls
    private static final String BUNDLE = "MavenVersionInspectionBundle";

    private MavenVersionInspectionBundle() {

    }


    // BUNDLE에 빨간 줄이 나오는 이유
    public static String message(@NotNull @PropertyKey(resourceBundle = BUNDLE) String key, @NotNull Object... params) {
        return CommonBundle.message(getBundle(), key, params);
    }

    private static ResourceBundle getBundle() {
        ResourceBundle bundle = com.intellij.reference.SoftReference.dereference(ourBundle);
        if (bundle == null) {
            bundle = ResourceBundle.getBundle(BUNDLE);
            ourBundle = new SoftReference<>(bundle);
        }
        return bundle;
    }
}

//    @PropertyKey 어노테이션에서 BUNDLE에 빨간 줄이 쳐지고 "Invalid resource bundle reference 'MavenDomBundle'"라는 메시지가 나오는 이유는 해당 BUNDLE 값이 올바른 리소스 번들을 참조하지 않기 때문입니다.
//
//@PropertyKey 어노테이션은 리소스 번들의 키 값을 참조하여 해당 키에 대응하는 메시지를 가져올 때 사용됩니다. 그렇기 때문에 BUNDLE 값은 실제 리소스 번들의 이름이어야 합니다.
//
//        만약 MavenDomBundle이 실제로 리소스 번들의 이름이 아니라면, 해당 값을 리소스 번들의 이름으로 바꾸어주어야 합니다. 리소스 번들의 이름은 일반적으로 properties 파일과 같은 리소스 파일과 관련이 있습니다. 이 파일들은 다국어 지원을 위한 메시지를 포함하고 있으며, 파일 이름은 리소스 번들의 이름과 일치해야 합니다.
//
//        따라서 BUNDLE 값은 실제로 사용하고 있는 리소스 번들 파일의 이름으로 수정해야 합니다. 해당 리소스 번들 파일이 MavenDomBundle.properties라면 BUNDLE 값을 "MavenDomBundle"로 설정해주어야 합니다.