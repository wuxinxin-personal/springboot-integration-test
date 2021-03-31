package com.example.springbootintegrationtest.hadoop.mapreduce.model;


import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * 使用测试的bean
 * @author wuxinxin
 */
public class UserInfo implements WritableComparable<UserInfo> {

    private Integer id;

    private String name;

    private String job;

    private String address;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int compareTo(UserInfo o) {
        if(id<o.id){
            return 1;
        }else if(id>o.id){
            return -1;
        }
        return 0;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(id);
        out.writeUTF(name);
        out.writeUTF(job);
        out.writeUTF(address);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.id=in.readInt();
        this.name=in.readUTF();
        this.job=in.readUTF();
        this.address=in.readUTF();
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
