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

package ai.tock.bot.mongo

import ai.tock.bot.admin.bot.rag.BotRAGConfiguration
import ai.tock.bot.admin.bot.rag.BotRAGConfigurationDAO
import ai.tock.bot.mongo.MongoBotConfiguration.asyncDatabase
import ai.tock.bot.mongo.MongoBotConfiguration.database
import ai.tock.shared.ensureUniqueIndex
import ai.tock.shared.watch
import org.litote.kmongo.*
import org.litote.kmongo.reactivestreams.getCollectionOfName

internal object BotRAGConfigurationMongoDAO : BotRAGConfigurationDAO {

    private const val COLLECTION_NAME = "bot_rag_configuration"
    internal val col = database.getCollection<BotRAGConfiguration>(COLLECTION_NAME)
    private val asyncCol = asyncDatabase.getCollectionOfName<BotRAGConfiguration>(COLLECTION_NAME)

    init {
        col.ensureUniqueIndex(BotRAGConfiguration::namespace, BotRAGConfiguration::botId)
    }

    override fun listenChanges(listener: () -> Unit) {
        asyncCol.watch { listener() }
    }

    override fun findByNamespaceAndBotId(
        namespace: String,
        botId: String
    ): BotRAGConfiguration? {
        return col.findOne(
            BotRAGConfiguration::namespace eq namespace,
            BotRAGConfiguration::botId eq botId
        )
    }

    override fun findByNamespaceAndBotIdAndEnabled(
        namespace: String,
        botId: String,
        enabled: Boolean
    ): BotRAGConfiguration? {
        return col.findOne(
            BotRAGConfiguration::namespace eq namespace,
            BotRAGConfiguration::botId eq botId,
            BotRAGConfiguration::enabled eq enabled
        )
    }

    override fun save(conf: BotRAGConfiguration): BotRAGConfiguration {
        col.save(conf)
        return conf
    }

    override fun delete(id: Id<BotRAGConfiguration>) {
        col.deleteOneById(id)
    }

}
