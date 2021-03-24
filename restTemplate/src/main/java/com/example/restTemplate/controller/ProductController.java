package com.example.restTemplate.controller;

import com.example.restTemplate.entity.Product;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import java.math.BigDecimal;

/**
 * @author xstoop
 * @date 2021/3/8 上午10:50
 */
@RequestMapping("/product")
@RestController
public class ProductController {

    @GetMapping("/product1")
    public Product getProduct1() {
        return new Product(1, "ProductA", BigDecimal.valueOf(6666.0));
    }

    @GetMapping("/product2")
    public Product getProduct2(@RequestParam("id") Integer id) {
        return new Product(id, "ProductC", BigDecimal.valueOf(6666.0));
    }

    @GetMapping("/product3")
    public String getProduct3(Product product) {
        return product.toString();
    }


    @PostMapping("/product1")
    public String postProduct1(Product product) {
        return product.toString();
    }

    @PostMapping("/product2")
    public String postProduct2(@RequestBody Product product) {
        return product.toString();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        String result = String.format("编号为%s的产品删除成功", id);
        System.out.println(result);
        return result;
    }

    @PutMapping("/update")
    public String updateByPut(Product product) {
        String result = product.toString() + " 更新成功";
        System.out.println(result);
        return result;
    }

    @PostMapping("/upload")
    public String upload(MultipartRequest request) {
        // Spring MVC 使用 MultipartRequest 接受带文件的 HTTP 请求
        MultipartFile file = request.getFile("file");
        String originalFilename = file.getOriginalFilename();
        return "upload success filename: " + originalFilename;
    }
}
