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

package com.gerenvip.messenger.sample.handler;

import com.gerenvip.messenger.fm.FMClient;
import com.gerenvip.messenger.fm.command.FMCommand;
import com.gerenvip.messenger.fm.command.FMCommandInvoker;
import com.gerenvip.messenger.fm.entity.FMReceiveMessage;
import com.gerenvip.messenger.fm.handler.message.FMMessageHandler;
import com.gerenvip.messenger.fm.parser.FMCommandParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author wangwei on 2019/2/19.
 * wangwei@jiandaola.com
 */
@Slf4j
@Component
public class MessageHandler extends FMMessageHandler {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void handleMessage(FMReceiveMessage.Messaging messaging) {
        String id = messaging.getSender().id;
        FMReceiveMessage.Messaging.Message message = messaging.getMessage();
        FMCommandParser parser = FMClient.getInstance().getFmCommandParser();
        FMCommandParser parse = parser.parse(message.getText());
        FMCommand command = FMCommandInvoker.getInstance().invoke(parse);
        command.execute(id, parse.getParams());
    }

    /**
     * 处理 QuickReply 消息
     *
     * @param messaging  {@link FMReceiveMessage.Messaging}
     * @param quickReply {@link FMReceiveMessage.Messaging.Message.QuickReply}
     */
    @Override
    protected void handleQuickReply(FMReceiveMessage.Messaging messaging, FMReceiveMessage.Messaging.Message.QuickReply quickReply) {
        String payload = quickReply.getPayload();
        FMCommandParser parser = FMClient.getInstance().getFmCommandParser();
        FMCommandParser parse = parser.parse(payload);

        FMCommand command = FMCommandInvoker.getInstance().invoke(parse);
        command.execute(messaging.getSender().id, parse.getParams());
    }

}
