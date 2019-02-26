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

package com.gerenvip.messenger.sample.commands;

import com.gerenvip.messenger.fm.builder.FMReplyMessageBuilder;
import com.gerenvip.messenger.fm.builder.msg.TextMessageBuilder;
import com.gerenvip.messenger.fm.command.FMCommand;
import com.gerenvip.messenger.fm.entity.FMReplyMessage;
import com.gerenvip.messenger.fm.entity.RawFMUser;
import com.gerenvip.messenger.fm.parser.builtin.FMCommandDefaultParser;
import com.gerenvip.messenger.fm.provider.FMProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author wangwei on 2018/8/20.
 * wangwei@jiandaola.com
 */
@Slf4j
@Component("getStartedCommand")
public class GetStartedCommand implements FMCommand {


    @Override
    public String command(String... params) {
        return FMCommandDefaultParser.getDefault().toCommand("GETSTARTED", params);
    }

    @Override
    public void execute(String recipient, String... params) {

        log.info("GetStartedCommand -> execute ");

        RawFMUser user = FMProvider.getUserProfile(recipient);

        String text = user != null ? "Hello " + user.getLast_name() : "Hello";
        FMReplyMessage startMessage = FMReplyMessageBuilder
                .defaultBuilder(recipient)
                .withMessage(TextMessageBuilder
                        .defaultBuilder()
                        .withText(text)
                        .build())
                .build();
        FMProvider.sendMessage(startMessage);
    }
}
