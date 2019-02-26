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

package com.gerenvip.messenger.fm.command;

import com.gerenvip.messenger.fm.FMClient;

/**
 * @author wangwei on 2019/2/19.
 * wangwei@jiandaola.com
 */
public abstract class AbsDefaultCommand extends FMAbstractCommand {

    public static final String DEFAULT_COMMAND_NAME = "DEFAULT";

    @Override
    public final String command(String... params) {
        return super.command(params);
    }

    @Override
    String commandInternal(String... params) {
        return FMClient.getInstance().getFmCommandParser().toCommand(DEFAULT_COMMAND_NAME, params);
    }
}
