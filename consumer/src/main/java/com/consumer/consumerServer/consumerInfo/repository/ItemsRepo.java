package com.consumer.consumerServer.consumerInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consumer.consumerServer.consumerInfo.entity.Items;

@Repository
public interface ItemsRepo extends JpaRepository<Items, Integer> {

}
