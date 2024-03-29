package com.consumer.consumerServer.consumerInfo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consumer.consumerServer.consumerInfo.entity.Items;
import com.consumer.consumerServer.consumerInfo.repository.ItemsRepo;

@Service
public class ItemsService {

    @Autowired

    public ItemsRepo ItemsRepoObject;

    public Items saveItem(Items item) {
        return ItemsRepoObject.save(item);
    }

    public List<Items> fetchAllItems() {
        List<Items> allItems = ItemsRepoObject.findAll();
        return allItems;
    }

    public Items getItemById(int id) {
        Optional<Items> item = ItemsRepoObject.findById(id);
        if (item.isPresent()) {
            return item.get();
        }
        return null;
    }

    public void deleteItemById(int id) {
        if (ItemsRepoObject.findById(id).isPresent()) {
            ItemsRepoObject.deleteById(id);
        }
    }

}
