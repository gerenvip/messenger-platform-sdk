/*
 * Copyright [2018] gerenvip
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gerenvip.messenger.sample.util;

import com.gerenvip.messenger.fm.builder.FMProfileSettingMessengeBuilder;
import com.gerenvip.messenger.fm.entity.FMProfileSettingMessage;
import com.gerenvip.messenger.sample.commands.GetStartedCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wangwei on 2019/2/23.
 * wangwei@jiandaola.com
 */
@Slf4j
@Component
public class SettingMessageHelper {

    /**
     * 这是 messenger 上 page 的欢迎语
     */
    public FMProfileSettingMessage greetingSetting() {
        log.info("greetingSetting =>");
        return FMProfileSettingMessengeBuilder
                .defaultBuilder()
                .withGreeting("Hi {{user_first_name}}, We're happy to have you here! ❤️\n")
                .build();
    }

    /**
     * 设置进入聊天列表中的欢迎开始语
     */
    public FMProfileSettingMessage getStartedSetting() {
        log.info("getStartedSetting =>");
        return FMProfileSettingMessengeBuilder
                .defaultBuilder()
                .withGetStartedPayload(getStartedCommand.command())
                .build();
    }

    private GetStartedCommand getStartedCommand;

    @Autowired
    public SettingMessageHelper(GetStartedCommand getStartedCommand) {
        this.getStartedCommand = getStartedCommand;
    }
}
