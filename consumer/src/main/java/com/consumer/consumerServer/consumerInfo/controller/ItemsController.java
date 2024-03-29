package com.consumer.consumerServer.consumerInfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.consumer.consumerServer.consumerInfo.entity.Items;
import com.consumer.consumerServer.consumerInfo.service.ItemsService;

@RestController
public class ItemsController {

    @Autowired

    public ItemsService ItemsServiceObject;

    @PostMapping("/item")
    public Items saveItem(@RequestBody Items item) {
        return ItemsServiceObject.saveItem(item);
    }

    @GetMapping("/item")
    public List<Items> getAllItems() {
        return ItemsServiceObject.fetchAllItems();
    }

    @GetMapping("/item/{id}")
    public Items getItemById(@PathVariable("id") int id) {
        return ItemsServiceObject.getItemById(id);
    }

    @DeleteMapping("/item/{id}")
    public void deleteItemById(@PathVariable("id") int id) {
        ItemsServiceObject.deleteItemById(id);
    }
}
