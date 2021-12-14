package com.example.natourapp.ui.preference

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.natourapp.R

class SettingsFragment1 : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}