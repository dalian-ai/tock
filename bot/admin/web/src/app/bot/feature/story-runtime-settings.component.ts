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

import {Component, OnInit} from '@angular/core';
import {BotService} from '../bot-service';
import {StoryDefinitionConfiguration} from '../model/story';
import {StateService} from '../../core-nlp/state.service';


@Component({
  selector: 'tock-story-runtime-settings',
  templateUrl: './story-runtime-settings.component.html',
  styleUrls: ['./story-runtime-settings.component.css']
})
export class StoryRuntimeSettingsComponent implements OnInit {
  storyPluralMapping = {
    'story': {
      '=0': '0 stories',
      '=1': '1 story',
      'other': '# stories'
    }
  };
  displayedColumns: string[] = ['storyTag', 'storyName'];
  disableStories: StoryDefinitionConfiguration[];
  enableStories: StoryDefinitionConfiguration[];

  constructor(
    private state: StateService,
    private botService: BotService) {
  }

  ngOnInit(): void {
    if (this.state.currentApplication) {
      this.botService.findRuntimeStorySettings(this.state.currentApplication.name).subscribe(
        stories => {
          this.disableStories = stories.filter(story => story.tags.some(tag => tag === 'DISABLE'));
          this.enableStories = stories.filter(story => story.tags.some(tag => tag === 'ENABLE'));
        }
      );
    }
  }
}
