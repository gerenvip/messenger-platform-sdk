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

package com.gerenvip.messenger.sample.util;

import com.gerenvip.messenger.fm.builder.FMProfileSettingMessengeBuilder;
import com.gerenvip.messenger.fm.builder.menu.MenuItemBuilder;
import com.gerenvip.messenger.fm.builder.menu.PersistentMenuBuilder;
import com.gerenvip.messenger.fm.entity.FMEnum;
import com.gerenvip.messenger.fm.entity.FMProfileSettingMessage;
import com.gerenvip.messenger.sample.commands.GetStartedCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wangwei on 2019/2/23.
 * wangwei@jiandaola.com
 */
@Slf4j
@Component
public class PersistentMenuCreator {

    private GetStartedCommand startedCommand;

    @Autowired
    public PersistentMenuCreator(GetStartedCommand startedCommand) {
        this.startedCommand = startedCommand;
    }

    public FMProfileSettingMessage createPersistentMenu() {
        log.info("PersistentMenuCreator =>");
        FMProfileSettingMessage.MenuItem firstMenuItem = this.createFirstMenu();
        FMProfileSettingMessage.MenuItem secondMenuItem = this.createSecondMenu();
        FMProfileSettingMessage.MenuItem thirdMenuItem = this.createThirdMenu();
        FMProfileSettingMessage.PersistentMenu persistentMenu = PersistentMenuBuilder.defaultBuilder()
                .withMenu(firstMenuItem, secondMenuItem, thirdMenuItem)
                .build();
        return FMProfileSettingMessengeBuilder.defaultBuilder()
                .withPersistentMenu(persistentMenu)
                .build();
    }

    /**
     * 创建第一个菜单
     */
    private FMProfileSettingMessage.MenuItem createFirstMenu() {
        return MenuItemBuilder.defaultBuilder()
                .withTitle("Menu One")
                .withCallActionType(FMProfileSettingMessage.CallActionType.nested)
                .withSubMenu(
                        MenuItemBuilder
                                .defaultBuilder()
                                .withTitle("MENU_SUB_1")
                                .withCallActionType(FMProfileSettingMessage.CallActionType.postback)
                                .withPayload(startedCommand.command())
                                .build(),
                        MenuItemBuilder
                                .defaultBuilder()
                                .withTitle("MENU_SUB_2")
                                .withCallActionType(FMProfileSettingMessage.CallActionType.web_url)
                                .withUrl("https://www.google.com")
                                .withWebViewHeightRatio(FMEnum.WebViewHeightRatio.full)
                                .withMessengerExtensions(true)
                                .build()
                ).build();
    }

    private FMProfileSettingMessage.MenuItem createSecondMenu() {
        return MenuItemBuilder.defaultBuilder()
                .withUrl("https://m.baidu.com")
                .withTitle("Menu Second")
                .withCallActionType(FMProfileSettingMessage.CallActionType.web_url)
                .withWebViewHeightRatio(FMEnum.WebViewHeightRatio.full)
                .withMessengerExtensions(true)
                .build();
    }

    private FMProfileSettingMessage.MenuItem createThirdMenu() {
        return MenuItemBuilder.defaultBuilder()
                .withTitle("Menu Thirf")
                .withCallActionType(FMProfileSettingMessage.CallActionType.nested)
                .withSubMenu(
                        //二级菜单
                        MenuItemBuilder
                                .defaultBuilder()
                                .withTitle("MENU_SUB_2")
                                .withCallActionType(FMProfileSettingMessage.CallActionType.postback)
                                .withPayload(startedCommand.command())
                                .build(),
                        MenuItemBuilder
                                .defaultBuilder()
                                .withTitle("MENU_SUB_3")
                                .withCallActionType(FMProfileSettingMessage.CallActionType.web_url)
                                .withWebViewHeightRatio(FMEnum.WebViewHeightRatio.full)
                                .withMessengerExtensions(true)
                                .withUrl("http://aicoding.tech/")
                                .build()
                )
                .build();
    }
}
