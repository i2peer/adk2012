/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.android.apps.adk2.activity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.apps.adk2.Preferences;
import com.google.android.apps.adk2.R;
import com.google.android.apps.adk2.widget.SeekBarPreference;

public class BrightnessActivity extends Adk2PreferenceActivity {

	public static final int MAX_BRIGHTNESS = 255;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.brightness_preferences);
		updatePreferencesDisplay();
	}

	private void updatePreferencesDisplay() {
		SeekBarPreference brightness = (SeekBarPreference) mPreferenceManager
				.findPreference(Preferences.PREF_BRIGHTNESS);

		if (brightness != null) {
			brightness.setValue(mPreferences.getInt(
					Preferences.PREF_BRIGHTNESS, MAX_BRIGHTNESS));
			brightness.setEnabled(true);
		}
	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
		if (Preferences.PREF_BRIGHTNESS.equals(key))
			updatePreferencesDisplay();

	}

}
