package com.example.springbootintegrationtest.hadoop.mapreduce.partition;

import com.example.springbootintegrationtest.hadoop.mapreduce.model.UserInfo;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * 自定义分区
 * @author wuxinxin
 */
public class MyPartition extends Partitioner<Text, UserInfo> {
    @Override
    public int getPartition(Text o, UserInfo o2, int numPartitions) {
        if("吉安".equals(o.toString())){
            return 0;
        }else if("抚州".equals(o.toString())){
            return 1;
        }else if("赣州".equals(o.toString())){
            return 2;
        }else if("上饶".equals(o.toString())){
            return 3;
        }else if("宜春".equals(o.toString())){
            return 4;
        }
        return 0;
    }
}
