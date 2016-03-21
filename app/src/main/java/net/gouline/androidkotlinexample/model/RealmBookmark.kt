package net.gouline.androidkotlinexample.model

import io.realm.RealmObject

open class RealmBookmark : RealmObject() {

    open var title: String? = null
    open var url: String? = null
}
