package net.gouline.androidkotlinexample.test

import android.app.Application
import net.gouline.androidkotlinexample.TestApp
import org.junit.runners.model.InitializationError
import org.robolectric.DefaultTestLifecycle
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.manifest.AndroidManifest
import org.robolectric.res.Fs
import java.lang.reflect.Method

class TestRunner @Throws(InitializationError::class)
constructor(testClass: Class<*>) : RobolectricTestRunner(testClass) {

    override fun getAppManifest(config: Config): AndroidManifest {
        return object : AndroidManifest(
                Fs.fileFromPath("src/test/AndroidManifest.xml"),
                Fs.fileFromPath("src/main/res"),
                Fs.fileFromPath("src/main/assets")) {
            override fun getTargetSdkVersion(): Int {
                return 18
            }
        }
    }

    override fun getTestLifecycleClass(): Class<out TestLifecycle>? {
        return TestLifecycle::class.java
    }

    open class TestLifecycle : DefaultTestLifecycle() {
        override fun createApplication(method: Method?, appManifest: AndroidManifest?, config: Config?): Application? {
            return TestApp()
        }
    }
}
