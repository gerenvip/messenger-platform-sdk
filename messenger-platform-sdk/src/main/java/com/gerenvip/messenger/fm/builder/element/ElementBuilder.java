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

package com.gerenvip.messenger.fm.builder.element;

import com.gerenvip.messenger.fm.entity.FMReplyMessage;
import com.gerenvip.messenger.fm.exception.ButtonsOutOfBoundException;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * {@link FMReplyMessage.Element} Helper
 *
 * @author wangwei on 2018/8/24.
 * wangwei@jiandaola.com
 */
public class ElementBuilder {

    protected FMReplyMessage.Element element;

    public ElementBuilder() {
        this.element = new FMReplyMessage.Element();
    }

    public static ElementBuilder defaultBuilder() {
        return new ElementBuilder();
    }

    /**
     * Set the title displayed in the template. No more than 80 characters
     */
    public ElementBuilder withTitle(String title) {
        if (StringUtils.length(title) > FMReplyMessage.TITLE_MAX_SIZE) {
            title = title.substring(0, 77) + "...";
        }
        this.element.setTitle(title);
        return this;
    }

    /**
     * Set the subtitles that appear in the template. No more than 80 characters
     */
    public ElementBuilder withSubtitle(String subtitle) {
        if (StringUtils.length(subtitle) > FMReplyMessage.TITLE_MAX_SIZE) {
            subtitle = subtitle.substring(0, 77) + "...";
        }
        this.element.setSubtitle(subtitle);
        return this;
    }

    /**
     * Set the URL that opens after clicking the bubble
     *
     * @deprecated
     */
    @Deprecated
    public ElementBuilder withItemUrl(String itemUrl) {
        this.element.setItem_url(itemUrl);
        return this;
    }

    /**
     * Set the image URL displayed in the template
     */
    public ElementBuilder withImageUrl(String imageUrl) {
        this.element.setImage_url(imageUrl);
        return this;
    }

    /**
     * Set the array of buttons to add to the template. Each element supports up to 3 buttons.
     */
    public ElementBuilder withButtons(FMReplyMessage.Button... buttons) {
        if (buttons == null || buttons.length == 0) {
            return this;
        }
        if (buttons.length > FMReplyMessage.BUTTON_MAX_SIZE) {
            throw new ButtonsOutOfBoundException();
        }
        if (this.element.getButtons() == null) {
            this.element.setButtons(new ArrayList<>(Arrays.asList(buttons)));
        } else {
            if (this.element.getButtons().size() + buttons.length > FMReplyMessage.BUTTON_MAX_SIZE) {
                throw new ButtonsOutOfBoundException();
            }
            this.element.getButtons().addAll(new ArrayList<>(Arrays.asList(buttons)));
        }
        return this;
    }

    /**
     * default action performed when when user taps the template or Messenger bubble
     *
     * @param defaultAction accept a button except for title attributes
     */
    public ElementBuilder withDefaultAction(FMReplyMessage.Button defaultAction) {
        this.element.setDefault_action(defaultAction);
        //noinspection deprecation
        withItemUrl(null);
        return this;
    }

    public FMReplyMessage.Element build() {
        return this.element;
    }
}
