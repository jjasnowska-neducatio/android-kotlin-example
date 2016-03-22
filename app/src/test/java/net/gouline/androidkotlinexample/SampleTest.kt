package net.gouline.androidkotlinexample

import android.content.Context
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmResults
import io.realm.internal.RealmCore
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Matchers
import org.powermock.api.mockito.PowerMockito
import org.powermock.api.mockito.PowerMockito.*
import org.powermock.core.classloader.annotations.PowerMockIgnore
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
@PowerMockIgnore("org.mockito.*", "org.robolectric.*", "android.*")
@PrepareForTest(Realm::class, RealmConfiguration::class, RealmResults::class, RealmCore::class)
class SampleTest {

    @Before
    @Throws(Exception::class)
    fun setup() {
        mockStatic(Realm::class.java)
        mockStatic(RealmConfiguration::class.java)
        mockStatic(RealmCore::class.java)

        // Create the mock
        val mockRealm = PowerMockito.mock(Realm::class.java)
        val mockRealmConfig = PowerMockito.mock(RealmConfiguration::class.java)

        // TODO: Better solution would be just mock the RealmConfiguration.Builder class. But it seems there is some
        // problems for powermock to mock it (static inner class). We just mock the RealmCore.loadLibrary(Context) which
        // will be called by RealmConfiguration.Builder's constructor.
        doNothing().`when`(RealmCore::class.java)
        RealmCore.loadLibrary(Matchers.any(Context::class.java))

        // TODO: Mock the RealmConfiguration's constructor. If the RealmConfiguration.Builder.build can be mocked, this
        // is not necessary anymore.
        whenNew(RealmConfiguration::class.java).withAnyArguments().thenReturn(mockRealmConfig)

        // Anytime getInstance is called with any configuration, then return the mockRealm
        `when`(Realm.getInstance(Matchers.any(RealmConfiguration::class.java))).thenReturn(mockRealm)
    }

    @Test
    fun testPointlessness() {
        assertEquals("Sample meaningless test", true, true)
    }
}
