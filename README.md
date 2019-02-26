# messenger-platform-sdk
Unofficial SDK of Facebook Messenger Platform API

[messenger platform official doc](https://developers.facebook.com/docs/messenger-platform/)

## Usage

### Add the maven dependency

Add repository  

```xml
<repositories>
    <repository>
            <id>jitpack.io</id>
            <url>https://www.jitpack.io</url>
</repository>
</repositories>
```
Add dependency  

```xml
<dependency>
  <groupId>com.gerenvip.messenger</groupId>
  <artifactId>messenger-platform-sdk</artifactId>
  <version>1.0.0</version>
</dependency>
```

Use in Code  

Start with FMClient instance, get FMClient instance in FMClicent.getInstance().

```java
 FMClient fmClient = FMClient.getInstance();
```

Use with* methods set parameters to FMClient instance. 

```java
//new PostBack Handler to receive the postback message from facebook
public class PostbackHandler extends FMMessagePostBackHandler {
    @Override
    public void handle(FMReceiveMessage.Messaging message) {
        log.debug("PostbackHandler handlePostBack, sender -> {}, postback -> {}", message.getSender(), message);
    }
}
```
```java
//get FMClient instance, and set token, secret, handler paramter.
FMClient fmClient = FMClient.getInstance();
PostbackHandler postbackHandler = new PostbackHandler();
fmClient.withAccessToken("your_token")
        .withAccessSecret("your_secret")
        .withFmMessagePostBackHandler(postbackHandler);
```

Use signature method to valid the payload.

```java

String xHubSignature = request.getHeader("X-Hub-Signature");
StringBuilder buffer = new StringBuilder();
BufferedReader reader = request.getReader();
String line;
while ((line = reader.readLine()) != null) {
    buffer.append(line);
}
String payload = buffer.toString();
boolean signature = fmClient.signature(payload, xHubSignature);
if(signature){
  //do
} else {
  //forbid
}
```

Use dispatch method to dispatch payload message.

```java
fmClient.dispatch(payload);
```

# Quick Start

### Create Facebook Page

`https://www.facebook.com/pages/create`

### Create Facebook Developer Account

`https://developers.facebook.com/`

### Create Facebook App

`https://developers.facebook.com/apps`

### Add the Messenger Platform to your Facebook app

 1. In the sidebar of your app settings under 'PRODUCTS', click '+ Add Product'.
 2. Hover over 'Messenger' to display options.
 3. Click the 'Set Up' button.
 
### Configure the webhook for your app  

1. In the 'Webhooks' section of the Messenger settings console, click the 'Setup Webhooks' button.
2. In the 'Callback URL' field, enter the public URL for your webhook.
3. In the 'Verify Token' field, enter the verify token for your webhook.
Under 'Subscription Fields', select the webhook events you want delivered to you webhook. At a minimum, we recommend you choose messages and messaging_postbacks to get started.
4. Click the 'Verify and Save' button.

### Subscribe your app to a Facebook Page

 1. In the 'Token Generation' section of the Messenger settings console, click the 'Select a Page' dropdown and select the Facebook Page you want to subscribe this app to. This is the Page that you want your webhook to receive events for when people on Messenger chat with it.
 2. Copy the token that appears in the 'Page Access Token' field. You will use this token later to make API requests.
 3. In the 'Webhook' section of the Messenger settings console, click the 'Select a Page' dropdown and select the same Facebook Page you generated a Page access token for. This will subscribe your app to receive webhook events for the Page.
 4. Click the 'Subscribe' button next to the dropdown.

### Test your app subscription

To test that your app set up was successful, send a message to your Page from facebook.com or in Messenger. If your webhook receives a webhook event, you have fully set up your app!

## Apache License
Copyright 2018 gerenvip

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
