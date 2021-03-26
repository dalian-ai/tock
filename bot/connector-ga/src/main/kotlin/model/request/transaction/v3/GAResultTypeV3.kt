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

package ai.tock.bot.connector.ga.model.request.transaction.v3

/**
 * @see https://developers.google.com/actions/transactions/reference/physical/rest/v3/ResultType
 */
enum class GAResultTypeV3 {
    RESULT_TYPE_UNSPECIFIED,
    CANNOT_TRANSACT,
    CAN_TRANSACT
}
