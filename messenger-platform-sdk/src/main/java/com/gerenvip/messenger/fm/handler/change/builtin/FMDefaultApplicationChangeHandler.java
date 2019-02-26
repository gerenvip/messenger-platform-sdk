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

package com.gerenvip.messenger.fm.handler.change.builtin;

import com.gerenvip.messenger.fm.entity.FMReceiveMessage;
import com.gerenvip.messenger.fm.handler.change.FMSubscribedApplicationChangeHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * 在 Facebook 应用后台 Webhook 配置时，如果订阅了 Application 的变化。当 Application 的 一些配置字段发生变化时，就会触发 change 类型的 Webhook Event
 * <br/>
 * 该类似默认处理 订阅的 Application 的字段变化
 *
 * @author wangwei on 2018/9/27.
 * wangwei@jiandaola.com
 */
@Slf4j
public class FMDefaultApplicationChangeHandler extends FMSubscribedApplicationChangeHandler {

    public void handle(FMReceiveMessage.Change change) {
        log.info("Subscribed Application Changed -> {} ", change);
    }

}
