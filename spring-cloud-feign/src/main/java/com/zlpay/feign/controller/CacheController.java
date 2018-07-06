package com.zlpay.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zlpay.feign.service.CacheService;


@RestController
public class CacheController {
	
	@Autowired
    private CacheService cacheService;

    /**
     * 根据ID获取信息
     * 
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public String test(@PathVariable("id") String id) {
        return cacheService.get(id);
    }

    /**
     * 删除某个ID的信息
     * 
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") String id) {
        return cacheService.delete(id);
    }

    /**
     * 保存某个ID的信息
     * 
     * @param id
     * @return
     */
    @PostMapping
    public String save(@RequestParam("id") String id, @RequestParam("value") String value) {
        return cacheService.save(id, value);
    }

    /**
     * 跟新某个ID的信息
     * 
     * @param id
     * @return
     */
    @PutMapping("{id}")
    public String update(@PathVariable("id") String id, @RequestParam("value") String value) {
        return cacheService.update(id, value);
    }

}
