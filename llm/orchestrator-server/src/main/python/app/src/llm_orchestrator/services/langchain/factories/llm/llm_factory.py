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
from abc import ABC, abstractmethod

from langchain.base_language import BaseLanguageModel
from pydantic import BaseModel

from llm_orchestrator.models.llm.llm_setting import BaseLLMSetting


class LangChainLLMFactory(ABC, BaseModel):
    setting: BaseLLMSetting

    @abstractmethod
    def get_language_model(self) -> BaseLanguageModel:
        """
        Fabric the language model to call.
        :return: BaseLanguageModel the interface for Language models.
        """
        pass

    def check_llm_setting(self) -> bool:
        """
        check the LLM setting validity, by pinging the AI provider API
        :return: True if the setting is valid.
        :raises BusinessException: For incorrect setting
        """
        self.get_language_model().invoke('Hi, are you there?')
        return True