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

package com.gerenvip.messenger.fm.builder.msg;


import com.gerenvip.messenger.fm.entity.FMReplyMessage;
import com.gerenvip.messenger.fm.builder.attachment.GenericAttachmentBuilder;
import com.gerenvip.messenger.fm.builder.attachment.MediaAttachmentBuilder;

/**
 * for media template message
 *
 * @author wangwei on 2018/9/5.
 * wangwei@jiandaola.com
 */
public class MediaMessageBuilder extends MessageBuilder {

    public MediaMessageBuilder() {
    }

    /**
     * create instance
     */
    public static MediaMessageBuilder defaultBuilder() {
        return new MediaMessageBuilder();
    }

    /**
     * set attachment for media template
     *
     * @param builder {@link GenericAttachmentBuilder}
     * @return GenericMessageBuilder
     */
    public MediaMessageBuilder withAttachment(MediaAttachmentBuilder builder) {
        super.withAttachment(builder.build());
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MessageBuilder withQuickReplies(FMReplyMessage.QuickReply... quickReplies) {
        return super.withQuickReplies(quickReplies);
    }
}
