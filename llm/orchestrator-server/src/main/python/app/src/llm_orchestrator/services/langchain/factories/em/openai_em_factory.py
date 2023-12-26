#   Copyright (C) 2023 Credit Mutuel Arkea
#
#   Licensed under the Apache License, Version 2.0 (the "License");
#   you may not use this file except in compliance with the License.
#   You may obtain a copy of the License at
#
#   http://www.apache.org/licenses/LICENSE-2.0
#
#   Unless required by applicable law or agreed to in writing, software
#   distributed under the License is distributed on an "AS IS" BASIS,
#   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#   See the License for the specific language governing permissions and
#   limitations under the License.
#

from langchain.embeddings import OpenAIEmbeddings
from langchain.embeddings.base import Embeddings

from llm_orchestrator.errors.handlers.openai.openai_exception_handler import (
    factory_openai_exception_handler,
)
from llm_orchestrator.models.em.openai.openai_em_setting import OpenAIEMSetting
from llm_orchestrator.services.langchain.factories.em.em_factory import (
    LangChainEMFactory,
)


class OpenAIEMFactory(LangChainEMFactory):
    setting: OpenAIEMSetting

    def get_embedding_model(self) -> Embeddings:
        return OpenAIEmbeddings(
            openai_api_key=self.setting.api_key, model=self.setting.model
        )

    @factory_openai_exception_handler
    def check_embedding_model_setting(self) -> bool:
        return super().check_embedding_model_setting()