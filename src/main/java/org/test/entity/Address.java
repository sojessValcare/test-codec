package org.test.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;
import org.bson.codecs.pojo.annotations.BsonProperty;

@RegisterForReflection
public class Address {

    @BsonProperty("address1")
    private String address1;

    @BsonProperty("address2")
    private String address2;

    @BsonProperty("state")
    private String state;

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
