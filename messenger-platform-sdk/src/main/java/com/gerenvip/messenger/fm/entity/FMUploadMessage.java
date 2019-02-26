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

package com.gerenvip.messenger.fm.entity;

import lombok.Data;

/**
 * entity for UPLOAD API
 *
 * @author wangwei on 2018/9/7.
 * wangwei@jiandaola.com
 */
@Data
public class FMUploadMessage {

    private UploadMessage message;

    @Data
    public static class UploadMessage {
        private UploadAttachment attachment;
    }

    @Data
    public static class UploadAttachment {
        private UploadAttachmentType type;
        private UploadPaylod payload;

        @Data
        public static class UploadPaylod {
            /**
             * 设置为 true 后，即可将已保存的素材发送给其他消息接收人。默认为 false。
             */
            private boolean is_reusable = true;
            /**
             * URL of the file to upload. Max file size is 25MB.
             */
            private String url;
        }

    }

    public enum UploadAttachmentType {
        image,
        video,
        audio,
        file
    }


}
