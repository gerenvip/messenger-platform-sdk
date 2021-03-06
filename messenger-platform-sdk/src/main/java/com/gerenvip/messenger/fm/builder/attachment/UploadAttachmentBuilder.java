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


import com.gerenvip.messenger.fm.entity.FMUploadMessage;

/**
 * @author wangwei on 2018/9/7.
 * wangwei@jiandaola.com
 */
public class UploadAttachmentBuilder {

    private FMUploadMessage.UploadAttachment attachment;

    private UploadAttachmentBuilder() {
        this.attachment = new FMUploadMessage.UploadAttachment();
        this.attachment.setPayload(new FMUploadMessage.UploadAttachment.UploadPaylod());
    }

    public static UploadAttachmentBuilder defaultBuilder() {
        return new UploadAttachmentBuilder();
    }

    /**
     * The type of the attachment. Must be one of the following:
     * <ul>
     * <li>image</li>
     * <li>video</li>
     * <li>audio</li>
     * <li>file</li>
     * </ul>
     */
    public UploadAttachmentBuilder withAttachmentType(FMUploadMessage.UploadAttachmentType type) {
        this.attachment.setType(type);
        return this;
    }

    public UploadAttachmentBuilder withAllowReuse(boolean reuse) {
        this.attachment.getPayload().set_reusable(reuse);
        return this;
    }

    public UploadAttachmentBuilder withAttachmentUrl(String url) {
        this.attachment.getPayload().setUrl(url);
        return this;
    }

    public FMUploadMessage.UploadAttachment build() {
        return attachment;
    }
}
