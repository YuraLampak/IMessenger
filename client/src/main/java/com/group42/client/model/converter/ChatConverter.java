package com.group42.client.model.converter;

/*
 * Class for custom serialize and deserialize fx objects
 * to correct write/read to/from json file.
 */

import com.google.gson.*;
import com.group42.client.model.Chat;
import java.lang.reflect.Type;

public class ChatConverter implements JsonSerializer<Chat>, JsonDeserializer<Chat> {

    /**
     * Custom serializes object to json format.
     *
     * @param chat
     * @param type
     * @param jsonSerializationContext
     * @return
     */
    @Override
    public JsonElement serialize(Chat chat, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject object = new JsonObject();
        object.addProperty("chatId", chat.getChatId());
        object.addProperty("chatName", chat.getChatName());
        object.addProperty("chatType", chat.getIsPrivate());
        return object;
    }

    /**
     * Custom deserializes object from json.
     * @param jsonElement
     * @param type
     * @param jsonDeserializationContext
     */
    @Override
    public Chat deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();
        Integer chatId = object.get("chatId").getAsInt();
        String chatName = object.get("chatName").getAsString();
        String chatType = object.get("chatType").getAsString();
        return new Chat(chatId, chatName, chatType);
    }
}
