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

import com.alibaba.fastjson.JSON;
import com.gerenvip.messenger.fm.FMClient;
import com.gerenvip.messenger.fm.command.FMCommand;
import com.gerenvip.messenger.fm.command.FMCommandInvoker;
import com.gerenvip.messenger.fm.entity.FMReceiveMessage;
import com.gerenvip.messenger.fm.handler.message.FMMessagePostBackHandler;
import com.gerenvip.messenger.fm.parser.FMCommandParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author wangwei on 2019/2/23.
 * wangwei@jiandaola.com
 */
@Slf4j
@Component
public class PostbackHandler extends FMMessagePostBackHandler {

    @Override
    public void handle(FMReceiveMessage.Messaging messaging) {
        log.info("PostbackHandler -> handle, sender -> {}, postback -> {}", JSON.toJSONString(messaging.getSender()), JSON.toJSONString(messaging));

        FMCommandParser parser = FMClient.getInstance().getFmCommandParser();
        FMCommandParser parse = parser.parse(messaging.getPostback().getPayload());

        FMCommand command = FMCommandInvoker.getInstance().invoke(parse);

        String id = messaging.getSender().getId();
        command.execute(id, parse.getParams());
    }
}
