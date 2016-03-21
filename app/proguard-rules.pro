# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Applications/Android Studio.app/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Global
-keepattributes Signature

# Models
-keepclasseswithmembers class net.gouline.androidkotlinexample.model.** { *; }
-keepclasseswithmembernames class net.gouline.androidkotlinexample.model.** { *; }

# Support
-dontwarn android.support.v7.**
-keep class android.support.v7.** { *; }
-keep interface android.support.v7.** { *; }

# Kotlin
-dontwarn kotlin.ExceptionsKt
-dontwarn kotlin.MathKt
-dontwarn kotlin.PreconditionsKt
-dontwarn kotlin.StandardKt
-dontwarn kotlin.collections.**
-dontwarn kotlin.io.FilesKt
-dontwarn kotlin.sequences.SequencesKt
-dontwarn kotlin.text.CharsKt
-dontwarn kotlin.text.StringsKt

# Realm
-keep class io.realm.annotations.RealmModule
-keep @io.realm.annotations.RealmModule class *
-keep class io.realm.internal.Keep
-keep @io.realm.internal.Keep class * { *; }
-dontwarn javax.**
-dontwarn io.realm.**
