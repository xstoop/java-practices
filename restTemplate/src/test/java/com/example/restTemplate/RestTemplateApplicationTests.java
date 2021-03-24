package com.example.restTemplate;

import com.example.restTemplate.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class RestTemplateApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testRestTemplateGet() {
        /* RestTemplate 发起 get 请求*/
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://127.0.0.1:8090/product/product1";

        // get 请求获取json数据
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);
        Assert.hasText(result, "get 请求返回为空");

        // get 使用实体类接收 json
        Product product = restTemplate.getForObject(url, Product.class);
        System.out.println(product);
        Assert.notNull(product, "get 请求返回为空");

        // get 请求，使用ResponseEntity接收
        ResponseEntity<Product> productResponseEntity = restTemplate.getForEntity(url, Product.class);
        System.out.println(productResponseEntity);
        Assert.isTrue(productResponseEntity.getStatusCode().equals(HttpStatus.OK), "返回状态错误");

        /* 使用exchange execute 方法请求，可以细粒度地设置请求 */

        // 1. 使用 HttpEntity 构建请求头、请求参数相关信息
        //   先设置请求头
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        header.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        //   使用请求头初始化HttpEntity
        HttpEntity<Object> httpEntity = new HttpEntity<>(header);

        // 2. 使用 exchange 方法执行请求，指定请求类 httpEntity ，使用 ResponseEntity 接收响应
        ResponseEntity<Product> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Product.class);
        System.out.println(responseEntity);
        Assert.isTrue(responseEntity.getStatusCode().equals(HttpStatus.OK), "响应状态错误");

        // 3. 使用getBody方法获取响应的实体类
        System.out.println(responseEntity.getBody());

        /* 使用 execute 方法执行请求，使用 Lambda 表达式组装请求与处理响应*/
        String executeResult = restTemplate.execute(url, HttpMethod.GET, request -> {
            request.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        }, (clientHttpResponse) -> {
            InputStream body = clientHttpResponse.getBody();
            byte[] bytes = new byte[body.available()];
            body.read(bytes);
            return new String(bytes);
        });

        System.out.println("execute 执行结果" + executeResult);

        /* 设置请求参数 */

        String urlWithQueryParam = "http://127.0.0.1:8090/product/product2?id={id}";

        // 直接设置
        ResponseEntity<Product> responseEntity1 = restTemplate.getForEntity(urlWithQueryParam, Product.class, 2);
        System.out.println("url带参数" + responseEntity1);

        // 使用map设置
        Map<String, Object> params = new HashMap<>();
        params.put("id", 2);
        ResponseEntity<Product> responseEntity2 = restTemplate.getForEntity(urlWithQueryParam, Product.class, params);
        System.out.println("url带参数使用map" + responseEntity2);
    }

    @Test
    public void testRestTemplatePost() {
        /* 使用 RestTemplate 发送 post 请求*/
        String url = "http://127.0.0.1:8090/product/product1";
        Product product = new Product(13, "苹果", BigDecimal.TEN);

        // 使用 application/x-www-form-urlencoded 类型提交 post
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        header.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);

        // 拼装 key=value & 方式
        String productStr = String.format("id=%s&name=%s&price=%s", product.getId(), product.getName(), product.getPrice());
        HttpEntity<String> request = new HttpEntity<>(productStr, header);

        RestTemplate restTemplate = new RestTemplate();
        // product1接口返回的是product.toString
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        System.out.println("application/x-www-form-urlencoded post 返回 " + responseEntity.getBody());

        // 使用 MultiValueMap 组装提交参数
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("id", product.getId());
        map.add("name", product.getName());
        map.add("price", product.getPrice());

        HttpEntity<MultiValueMap<String, Object>> request2 = new HttpEntity<>(map, header);
        ResponseEntity<String> responseEntity1 = restTemplate.exchange(url, HttpMethod.POST, request2, String.class);
        System.out.println("application/x-www-form-urlencoded post 返回 " + responseEntity1);

        // 使用 application/json 提交 post
        url = "http://127.0.0.1:8090/product/product2";

        MultiValueMap<String, String> header1 = new LinkedMultiValueMap<>();
        header1.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<Product> httpEntity = new HttpEntity<>(product, header1);
        ResponseEntity<String> responseEntity2 = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
        System.out.println("使用 application/json 提交 post 返回 " + responseEntity2);
    }

    @Test
    public void testDelete() {
        /* 删除请求 */
        String url = "http://127.0.0.1:8090/product/delete/{id}";
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.delete(url, 2);
    }

    @Test
    public void testPut() {
        /* put请求 */
        String url = "http://127.0.0.1:8090/product/update";
        Map<String, ?> variables = new HashMap<>();

        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        header.put(HttpHeaders.CONTENT_TYPE, Arrays.asList(MediaType.APPLICATION_FORM_URLENCODED_VALUE));
        Product product = new Product(2, "Book", BigDecimal.valueOf(123));

        String productStr = "id=" + product.getId() + "&name=" + product.getName() + "&price=" + product.getPrice();
        HttpEntity<String> request = new HttpEntity<>(productStr, header);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(url, request);
    }

    @Test
    public void testUpload() {
        /* 上传文件 */
        // 请求头需要 multipart/form-data
        String url = "http://127.0.0.1:8090/product/upload";
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        FileSystemResource file = new FileSystemResource(new File("/aa.tt"));
        body.add("file", file);

        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        header.put(HttpHeaders.CONTENT_TYPE, Arrays.asList(MediaType.MULTIPART_FORM_DATA_VALUE));
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, header);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestEntity, String.class);

        System.out.println("upload: " + responseEntity);
        Assert.isTrue(responseEntity.getStatusCode().equals(HttpStatus.OK), "upload 请求不成功");
    }
}
