package com.example.springbootintegrationtest.hadoop.mapreduce.sede;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * 序列化和反序列化
 * @author wuxinxin
 */
public class UserInfo implements WritableComparable<UserInfo> {

    private int id;

    private String name;

    private int score;

    @Override
    public int compareTo(UserInfo o) {
        if(score>o.score){
            return 1;
        }else if(score<o.score){
            return -1;
        }
        return 0;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(id);
        out.writeUTF(name);
        out.writeInt(score);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.id=in.readInt();
        this.name=in.readUTF();
        this.score=in.readInt();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
