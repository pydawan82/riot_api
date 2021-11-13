package com.pydawan.dto;

import java.lang.reflect.Field;
import java.util.List;

import org.json.JSONObject;
import org.json.JSONArray;

/**
 * This class is used to convert a Java object to a JSON object and vice versa.
 * <ul>
 * <li> Extension classes may be used to add fields to the JSON object.
 * <li> If the JSON object contains a field that is not in the Java object, the
 * field will be ignored.</li>
 * <li> If the Java object contains a list of objects, the JSON object will contain
 * a list of JSON objects.</li>
 * <li> List elements must be annotated with the {@link ListOf} annotation using the correct Dto type.</li>
 * <li> Optional fields may be annotated with the {@link Optional} annotation.</li>
 * <li> Extending classes should provided a static method fromJson(JSONObject json) that calls
 * {@link #fromJson(JSONObject, Class)} with the correct class.</li>
 * </ul>
 * 
 * @author David Birtles
 */
public abstract class Dto {

    /**
     * Converts this data object to a JSONObject. Handles nested objects. List are
     * converted to JSONArray.
     */
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        for (Field field : getClass().getDeclaredFields()) {
            try {
                Object value = field.get(this);
                if (value instanceof Dto) {
                    json.put(field.getName(), ((Dto) value).toJson());
                } else if (value instanceof List) {
                    JSONArray array = new JSONArray();
                    for (Object item : (List<?>) value) {
                        if (item instanceof Dto) {
                            array.put(((Dto) item).toJson());
                        } else {
                            array.put(item);
                        }
                    }
                    json.put(field.getName(), array);
                } else {
                    json.put(field.getName(), value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return json;
    }

    /**
     * A static method that converts a JSONObject to a Dto. For each field in the
     * JSONObject, the field name is used as the key and the field value is used as
     * the value. Handles nested objects. JSON Array are converted to List.
     */
    @SuppressWarnings("unchecked")
    public static <T extends Dto> T fromJson(JSONObject json, Class<T> clazz) {
        try {
            T dto = clazz.getConstructor().newInstance();
            for (Field field : clazz.getDeclaredFields()) {
                if (json.has(field.getName())) {
                    Object value = json.get(field.getName());
                    switch (value) {
                    case JSONObject object:
                        if (!field.getType().isAssignableFrom(Dto.class))
                            throw new DtoException("JSONObject value for field " + field.getName() + " is not a Dto");
                        field.set(dto, fromJson(object, (Class<? extends Dto>) field.getType()));
                        break;
                    case JSONArray array:
                        if (!field.getType().isAssignableFrom(List.class))
                            throw new DtoException("JSONArray value for field " + field.getName() + " is not a List");
                        if(!field.isAnnotationPresent(ListOf.class))
                            throw new DtoException("JSONArray value for field " + field.getName() + " is not annotated with @ListOf");

                        field.set(dto,
                                fromJsonArray(array, (Class<? extends Dto>) field.getAnnotation(ListOf.class).value()));
                        break;
                    default:
                        field.set(dto, value);

                    }
                }
            }
            return dto;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * A static method that converts a JSONArray to a List. Handles nested objects.
     * Handles non json objects.
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T extends Dto> List<T> fromJsonArray(JSONArray json, Class<T> clazz) {
        if(clazz.isAssignableFrom(Dto.class))
            return json.toList().stream()
                    .map(item -> fromJson(new JSONObject(item), clazz))
                    .toList();

        List<Object> list = json.toList();
        if (!list.stream().map(Object::getClass).allMatch(c -> c.isAssignableFrom(clazz))) {
            throw new DtoException("JSONArray value for field " + clazz.getName() + " is not a List of " + clazz.getName());
        }
        return (List) json.toList();
    }

    /**
     * Override the toString method to return the JSON representation of this Dto.
     */
    @Override
    public String toString() {
        return toJson().toString(4);
    }
}
