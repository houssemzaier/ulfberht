/**
 * Designed and developed by Aidan Follestad (@afollestad)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.afollestad.ulfberhtsample.app

import android.app.Application
import android.util.Log
import com.afollestad.ulfberht.common.Logger
import com.afollestad.ulfberhtsample.BuildConfig.DEBUG

class App : Application() {

  override fun onCreate() {
    super.onCreate()
    // component<AppComponent>().inject(this)
    if (DEBUG) {
      Logger.install { Log.d("Ulfberht", it) }
    }
  }
}
