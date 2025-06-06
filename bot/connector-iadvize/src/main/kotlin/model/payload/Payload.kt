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

package ai.tock.bot.connector.iadvize.model.payload

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "contentType"
)
@JsonSubTypes(
    JsonSubTypes.Type(name = "bundle/card", value = CardBundlePayload::class),
    JsonSubTypes.Type(name = "file", value = FilePayload::class),
    JsonSubTypes.Type(name = "card/content", value = GenericCardPayload::class),
    JsonSubTypes.Type(name = "bundle/product-offer", value = ProductOfferBundlePayload::class),
    JsonSubTypes.Type(name = "product-offer", value = ProductOfferPayload::class),
    JsonSubTypes.Type(name = "text", value = TextPayload::class)
)
abstract class Payload(val contentType: String) {

}
