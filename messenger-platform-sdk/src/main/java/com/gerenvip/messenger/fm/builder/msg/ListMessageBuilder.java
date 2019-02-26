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
import com.gerenvip.messenger.fm.builder.attachment.ListAttachmentBuilder;

/**
 * for list template message
 *
 * @author wangwei on 2018/9/5.
 * wangwei@jiandaola.com
 */
public class ListMessageBuilder extends MessageBuilder {

    private ListMessageBuilder() {
    }

    /**
     * create instance
     */
    public static ListMessageBuilder defaultBuilder() {
        return new ListMessageBuilder();
    }

    /**
     * set attachment for list template
     *
     * @param builder {@link ListAttachmentBuilder}
     * @return ListAttachmentBuilder
     */
    public ListMessageBuilder withAttachment(ListAttachmentBuilder builder) {
        super.withAttachment(builder.build());
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListMessageBuilder withQuickReplies(FMReplyMessage.QuickReply... quick_replies) {
        super.withQuickReplies(quick_replies);
        return this;
    }

}
