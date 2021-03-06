/*
 * Copyright 2017 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.orca.pipeline;

import com.netflix.spinnaker.orca.StageResolver;
import com.netflix.spinnaker.orca.api.pipeline.graph.StageDefinitionBuilder;
import com.netflix.spinnaker.orca.api.pipeline.models.StageExecution;
import javax.annotation.Nonnull;

public class DefaultStageDefinitionBuilderFactory implements StageDefinitionBuilderFactory {
  private final StageResolver stageResolver;

  public DefaultStageDefinitionBuilderFactory(StageResolver stageResolver) {
    this.stageResolver = stageResolver;
  }

  @Override
  public @Nonnull StageDefinitionBuilder builderFor(@Nonnull StageExecution stage) {
    return stageResolver.getStageDefinitionBuilder(
        stage.getType(), (String) stage.getContext().get("alias"));
  }
}
