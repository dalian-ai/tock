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

package ai.tock.bot.admin.annotation

import com.fasterxml.jackson.annotation.JsonTypeName
import org.litote.kmongo.Id
import java.time.Instant

data class BotAnnotationEventComment(
    override val eventId: Id<BotAnnotationEvent>,
    override val creationDate: Instant,
    override val lastUpdateDate: Instant,
    override val user: String,
    val comment: String,
    val canEdit: Boolean = false,
) : BotAnnotationEvent(eventId, BotAnnotationEventType.COMMENT, creationDate, lastUpdateDate, user)
