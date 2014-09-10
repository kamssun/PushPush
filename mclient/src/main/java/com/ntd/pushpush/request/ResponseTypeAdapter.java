package com.ntd.pushpush.request;

import java.lang.reflect.Type;

import com.google.mygson.JsonDeserializationContext;
import com.google.mygson.JsonDeserializer;
import com.google.mygson.JsonElement;
import com.google.mygson.JsonObject;
import com.google.mygson.JsonParseException;
import com.google.mygson.JsonPrimitive;
import com.google.mygson.JsonSerializationContext;
import com.google.mygson.JsonSerializer;

/**
 * JsonAdapter for {@link Response}.
 *
 */
public class ResponseTypeAdapter implements JsonSerializer<Response>, JsonDeserializer<Response> {

  private final static String TYPE_FIELD = "_TYPE";

  @Override
  public Response deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context)
      throws JsonParseException {
    final Class<?> clazz = getType(jsonElement);
    if (clazz == null) {
      return null;
    } else {
      return context.deserialize(jsonElement, clazz);
    }
  }

  private Class<?> getType(JsonElement json) {
    final JsonObject jsonObject = (JsonObject) json;
    final JsonElement jsonElement = jsonObject.get(TYPE_FIELD);
    try {
      return Class.forName(jsonElement.getAsString());
    } catch (final ClassNotFoundException e) {
    }
    return null;
  }

  @Override
  public JsonElement serialize(Response response, Type type, JsonSerializationContext context) {
    final JsonElement result = context.serialize(response);
    ((JsonObject) result).add(TYPE_FIELD, new JsonPrimitive(response.getClass().getName()));
    return result;
  }

}
