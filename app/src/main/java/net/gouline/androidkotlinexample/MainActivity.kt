package net.gouline.androidkotlinexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*
import net.gouline.androidkotlinexample.model.RealmBookmark

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_test_realm.setOnClickListener { testRealm() }
    }

    private fun testRealm() {
        val r = Realm.getDefaultInstance()

        // Creating
        r.beginTransaction()

        r.where(RealmBookmark::class.java).findAll().clear()

        val createdBookmark = RealmBookmark()
        createdBookmark.title = "Example Bookmark"
        createdBookmark.url = "http://www.example.com"
        r.copyToRealm(createdBookmark)

        r.commitTransaction()

        // Reading
        val retrievedBookmark = r.where(RealmBookmark::class.java).findFirst()

        if (retrievedBookmark != null) {
            Toast.makeText(this, "Title: " + retrievedBookmark.title, Toast.LENGTH_SHORT).show()
        }
    }
}