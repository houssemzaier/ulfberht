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
package com.afollestad.ulfberhtsample.api

import android.util.Log
import com.afollestad.ulfberht.annotation.Param
import com.afollestad.ulfberhtsample.Qualifiers.API_KEY

interface Authenticator {
  fun login(
    username: String,
    password: String
  ): String
}

class RealAuthenticator(
  @Param(API_KEY) private val apiKey: String,
  private val session: Session
) : Authenticator {
  override fun login(
    username: String,
    password: String
  ): String {
    Log.d("Authenticator", "Logging into $username/$password with API key $apiKey")
    return "${username}_$password".also {
      session.setAuthToken(it)
    }
  }
}
