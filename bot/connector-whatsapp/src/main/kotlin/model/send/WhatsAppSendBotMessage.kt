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

package ai.tock.bot.connector.whatsapp.model.send

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "type"
)
@JsonSubTypes(
    JsonSubTypes.Type(value = WhatsAppSendBotTextMessage::class, name = "text"),
    JsonSubTypes.Type(value = WhatsAppSendBotImageMessage::class, name = "image"),
    JsonSubTypes.Type(value = WhatsAppSendBotInteractiveMessage::class, name = "template"),
    JsonSubTypes.Type(value = WhatsAppSendBotMessageInteractiveMessage::class, name = "interactive")
)
abstract class WhatsAppSendBotMessage(val type: WhatsAppBotMessageType) {

    abstract val to: String

    @get:JsonProperty("recipient_type")
    abstract val recipientType: WhatsAppBotRecipientType
}
