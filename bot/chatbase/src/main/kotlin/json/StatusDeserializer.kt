/*
 * Copyright (C) 2017/2021 e-voyageurs technologies
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

package ai.tock.analytics.chatbase.json

import ai.tock.analytics.chatbase.model.Status
import ai.tock.shared.jackson.JacksonDeserializer
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode

internal class StatusDeserializer : JacksonDeserializer<Status>() {

    override fun deserialize(jp: JsonParser, ctxt: DeserializationContext): Status? {
        val node: JsonNode = jp.codec.readTree(jp)
        val code: Int = node.asInt()
        return Status.findByCode(code)
    }
}
