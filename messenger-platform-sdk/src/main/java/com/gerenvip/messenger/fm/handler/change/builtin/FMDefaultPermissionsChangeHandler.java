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
import com.gerenvip.messenger.fm.handler.change.FMSubscribedPermissionsChangeHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * 默认处理 订阅的 Permissions 变化信息
 *
 * @author wangwei on 2018/9/27.
 * wangwei@jiandaola.com
 */
@Slf4j
public class FMDefaultPermissionsChangeHandler extends FMSubscribedPermissionsChangeHandler {

    public void handle(FMReceiveMessage.Change change) {
        log.info("Subscribed Permissions Changed -> {} ", change);
    }

}
