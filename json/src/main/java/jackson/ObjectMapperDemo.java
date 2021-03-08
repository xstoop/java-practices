package jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * ObjectMapper 将java对象序列化为json，将json反序列化为java对象
 *
 * @author xstoop
 */
public class ObjectMapperDemo {

    public static void main(String[] args) {
        ObjectMapperDemo objectMapperDemo = new ObjectMapperDemo();
        objectMapperDemo.jsonToJavaClass();
    }

    /**
     * 将json转换成java对象
     */
    public void jsonToJavaClass() {
        String json = "{\"age\": 32, \"name\": \"叶小敏\"}";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Person person = objectMapper.readValue(json, Person.class);
            System.out.println(person);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 转换json的数组对象到list
        String jsonArray = "[{\"age\": 33, \"name\": \"叶小敏\"}, {\"age\": 32, \"name\": \"叶敏\"}]";
        try {
            List<Person> personList = objectMapper.readValue(jsonArray, new TypeReference<List<Person>>() {});
            System.out.println(personList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 转换json到map
        String jsonMap = "{\"age\": 33, \"name\": \"叶小敏\"}";
        try {
            Map<String, Object> objectMap = objectMapper.readValue(jsonMap, new TypeReference<Map<String, Object>>() {});
            System.out.println(objectMap);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 忽略多余的属性
        objectMapper = objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String json2 = "{\"age\": 32, \"name\": \"叶小敏\", \"id\": 123}";

        try {
            Person person = objectMapper.readValue(json2, Person.class);
            System.out.println(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Person {
        private int age;

        private String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
