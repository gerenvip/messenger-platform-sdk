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

package com.gerenvip.messenger.fm.builder.attachment;


import com.gerenvip.messenger.fm.builder.ButtonBuilder;
import com.gerenvip.messenger.fm.builder.msg.ButtonMessageBuilder;
import com.gerenvip.messenger.fm.entity.FMReplyMessage;

/**
 * for button template message 's attachment
 * use in {@link ButtonMessageBuilder}
 *
 * @author wangwei on 2018/9/5.
 * wangwei@jiandaola.com
 */
public class ButtonAttachmentBuilder extends AttachmentBuilder {

    private ButtonAttachmentBuilder() {
        super();
        forceSetPayloadTemplateType();
    }

    /**
     * create builder instance
     */
    public static ButtonAttachmentBuilder defaultBuilder() {
        return new ButtonAttachmentBuilder();
    }

    /**
     * Under Button Template， template_type must be {@link FMReplyMessage.TemplateType#button}.
     * force set.
     */
    private void forceSetPayloadTemplateType() {
        withPayloadType(FMReplyMessage.TemplateType.button);
    }

    /**
     * implement {@link AttachmentBuilder#withPayloadType(FMReplyMessage.TemplateType)}， force set type with {@link FMReplyMessage.TemplateType#button}
     * {@inheritDoc}
     *
     * @param type {@link FMReplyMessage.TemplateType },you can set anything of {FMReplyMessage.TemplateType}，but it is invalid
     * @return this instance
     */
    @Override
    public ButtonAttachmentBuilder withPayloadType(FMReplyMessage.TemplateType type) {
        super.withPayloadType(FMReplyMessage.TemplateType.button);
        return this;
    }

    /**
     * Text is displayed above the button.
     * UTF-8 encoded text, up to 640 characters.
     */
    @Override
    public ButtonAttachmentBuilder withPayloadText(String text) {
        super.withPayloadText(text);
        return this;
    }

    /**
     * Set a set of buttons that appear as action calls, including 1-3 buttons
     */
    @Override
    public ButtonAttachmentBuilder withPayloadButtons(FMReplyMessage.Button... buttons) {
        super.withPayloadButtons(buttons);
        return this;
    }

    /**
     * Set a action Button with ButtonBuilder
     */
    public ButtonAttachmentBuilder withPayloadButtons(ButtonBuilder buttonBuilder) {
        withPayloadButtons(buttonBuilder.build());
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ButtonAttachmentBuilder withPayloadSharable(boolean sharable) {
        super.withPayloadSharable(sharable);
        return this;
    }
}
