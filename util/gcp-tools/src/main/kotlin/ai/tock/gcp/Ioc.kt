/*
 * Copyright (C) 2017/2025 SNCF Connect & Tech
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ai.tock.gcp

import ai.tock.gcp.secretmanager.GcpSecretManagerService
import ai.tock.shared.security.SecretManagerService
import ai.tock.shared.security.SecretManagerProviderType
import ai.tock.shared.service.BotAdditionalModulesService
import com.github.salomonbrys.kodein.Kodein.Module
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.singleton

class IOCModulesService : BotAdditionalModulesService {
    override fun customModules(): Set<Module> = setOf(gcpModules)
}

val gcpModules = Module {
    bind<SecretManagerService>(tag = SecretManagerProviderType.GCP_SECRET_MANAGER.name) with singleton {
        GcpSecretManagerService()
    }
}
