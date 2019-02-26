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
import com.gerenvip.messenger.fm.command.FMCommand;
import com.gerenvip.messenger.fm.entity.FMReplyMessage;
import com.gerenvip.messenger.fm.parser.FMCommandParser;
import com.gerenvip.messenger.fm.parser.builtin.FMCommandDefaultParser;
import com.gerenvip.messenger.fm.provider.FMProvider;
import org.springframework.stereotype.Component;

/**
 * @author wangwei on 2019/2/19.
 * wangwei@jiandaola.com
 */
@Component("errorCommand")
public class ErrorCommand implements FMCommand {

    private static final String ERROR_COMMAND_NAME = "ERROR";

    /**
     * 返回一个带参数的 Command 有效负载。
     * 一般会调用 {@link FMCommandParser#toCommand(String, String...)}
     * 方法 ，通过编码生成一个 payload 字符串
     *
     * @param params Command 参数
     * @return payload 字符串
     */
    @Override
    public String command(String... params) {
        return FMCommandDefaultParser.getDefault().toCommand(ERROR_COMMAND_NAME, params);
    }

    /**
     * 执行 该 Command
     *
     * @param recipient 消息接收者Id，就是和 Bold 对话的 用户Id
     * @param params    有效负载中携带的 参数信息
     */
    @Override
    public void execute(String recipient, String... params) {
        FMReplyMessage replyMessage = FMReplyMessageBuilder.textBuilder(recipient, "Error Command execute ...").build();

        FMProvider.sendMessage(replyMessage);
    }
}
