package net.gouline.androidkotlinexample.test

import org.junit.runners.model.InitializationError
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.manifest.AndroidManifest
import org.robolectric.res.Fs

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
}
