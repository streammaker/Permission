package com.example.librarylzf

import androidx.fragment.app.FragmentActivity

object PermissionX {

    private const val TAG = "InvisibleFragment"

    fun request(activity : FragmentActivity, vararg permission : String, callback: PermissionCallback) {
        val fragmentManager = activity.supportFragmentManager
        val existFragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if (existFragment != null) {
            existFragment as InvisibleFragment
        } else {
            val invisibleFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback, *permission)
    }
}