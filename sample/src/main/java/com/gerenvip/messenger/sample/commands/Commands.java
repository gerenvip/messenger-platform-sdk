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

import com.gerenvip.messenger.fm.FMClient;
import com.gerenvip.messenger.fm.command.FMCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wangwei on 2019/2/19.
 * wangwei@jiandaola.com
 */
@Component("commands")
public class Commands {

    private List<FMCommand> commands;

    @Autowired
    public Commands(List<FMCommand> commands) {
        this.commands = commands;
        if (this.commands != null && !this.commands.isEmpty()) {
            FMCommand[] fmCommands = this.commands.toArray(new FMCommand[0]);
            FMClient.getInstance().withFMCommands(fmCommands);
        }
    }
}
