package com.consumer.consumerServer.consumerInfo.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "consumer")
// @TypeDef(name = "json", typeClass = JsonStringType.class)
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int consumerId;
    String consumerKind;
    String consumerLogin;
    String consumerName;
    int consumerAge;
    String consumerFoodHabbits;
    String consumerSex;
    String consumerOrder;

    @Column(columnDefinition = "TEXT")
    private String consumerAddress;

    public int getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(int consumerId) {
        this.consumerId = consumerId;
    }

    public String getConsumerKind() {
        return consumerKind;
    }

    public void setConsumerKind(String consumerKind) {
        this.consumerKind = consumerKind;
    }

    public String getConsumerLogin() {
        return consumerLogin;
    }

    public void setConsumerLogin(String consumerLogin) {
        this.consumerLogin = consumerLogin;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public int getConsumerAge() {
        return consumerAge;
    }

    public void setConsumerAge(int consumerAge) {
        this.consumerAge = consumerAge;
    }

    public String getConsumerFoodHabbits() {
        return consumerFoodHabbits;
    }

    public void setConsumerFoodHabbits(String consumerFoodHabbits) {
        this.consumerFoodHabbits = consumerFoodHabbits;
    }

    public String getConsumerSex() {
        return consumerSex;
    }

    public void setConsumerSex(String consumerSex) {
        this.consumerSex = consumerSex;
    }

    public String getConsumerOrder() {
        return consumerOrder;
    }

    public void setConsumerOrder(String consumerOrder) {
        this.consumerOrder = consumerOrder;
    }

}
