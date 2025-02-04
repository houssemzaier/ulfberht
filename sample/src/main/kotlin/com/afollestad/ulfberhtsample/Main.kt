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
package com.afollestad.ulfberhtsample

import com.afollestad.ulfberht.annotation.Inject
import com.afollestad.ulfberht.common.Logger
import com.afollestad.ulfberht.component
import com.afollestad.ulfberht.getScope
import com.afollestad.ulfberhtsample.Qualifiers.MAIN
import com.afollestad.ulfberhtsample.Scopes.PARENT
import com.afollestad.ulfberhtsample.api.RealCalculator
import com.afollestad.ulfberhtsample.components.ComponentTwo

class Main {
  @Inject lateinit var calculator: RealCalculator
  @Inject(MAIN) lateinit var someString: String

  init {
    component<ComponentTwo>().inject(this)
  }
}

fun main() {
  Logger.install { println("[LOG] $it") }
  val main1 = Main()
  val main2 = Main()
  val parentScope = getScope(PARENT)

  check(main1.calculator.doSomething(4) == 12)
  println(main1.calculator.doSomething(4))

  check(main1.calculator == main2.calculator) {
    "Instances should be the same since the calculator is a singleton."
  }

  parentScope.exit()
}
