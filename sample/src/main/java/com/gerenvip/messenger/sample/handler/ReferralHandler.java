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
import com.gerenvip.messenger.fm.entity.FMReceiveMessage;
import com.gerenvip.messenger.fm.handler.message.FMMessageReferralHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author wangwei on 2019/2/23.
 * wangwei@jiandaola.com
 */
@Slf4j
@Component
public class ReferralHandler extends FMMessageReferralHandler {


    @Override
    public boolean canHandle(FMReceiveMessage.Messaging message) {
        if (message != null && message.getReferral() != null) {
            return true;
        }
        if (message != null && message.getPostback() != null && message.getPostback().getReferral() != null) {
            return true;
        }
        return false;
    }


    @Override
    public void handle(FMReceiveMessage.Messaging messaging) {
        if (messaging == null) {
            return;
        }
        log.info("ReferralHandler -> handle messaging {}", JSON.toJSONString(messaging));

        FMReceiveMessage.Messaging.Referral referral = null;
        if (messaging.getReferral() != null) {
            referral = messaging.getReferral();
        } else if (messaging.getPostback() != null && messaging.getPostback().getReferral() != null) {
            referral = messaging.getPostback().getReferral();
        }
        if (referral == null) {
            log.info("ReferralHandler -> handle null Referral");
            return;
        }
        String ref = referral.getRef();
        log.info("ref : {}", ref);
    }
}
