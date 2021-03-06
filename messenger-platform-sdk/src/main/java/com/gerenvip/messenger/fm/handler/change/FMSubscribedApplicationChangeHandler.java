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

package com.gerenvip.messenger.fm.handler.change;

import com.gerenvip.messenger.fm.entity.FMReceiveMessage;
import com.gerenvip.messenger.fm.handler.FMSubscriptionChangeHandler;
import org.apache.commons.lang3.StringUtils;

/**
 * 在 Facebook 应用后台 Webhook 配置时，如果订阅了 Application 的变化。当 Application 的 一些配置字段发生变化时，就会触发 change 类型的 Webhook Event
 * <br/>
 *
 * @author wangwei on 2018/9/27.
 * wangwei@jiandaola.com
 */
public abstract class FMSubscribedApplicationChangeHandler implements FMSubscriptionChangeHandler {

    public boolean canHandle(FMReceiveMessage.Change change) {
        return change != null && change.getField() != null;
    }

    public boolean canHandle(FMReceiveMessage.Change change, String object) {
        return StringUtils.equalsIgnoreCase("application", object) && canHandle(change);
    }
}
