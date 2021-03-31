package com.example.springbootintegrationtest.hadoop.mapreduce.partition;

import com.example.springbootintegrationtest.hadoop.mapreduce.model.UserInfo;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author wuxinxin
 *
 * 对单词做map操作
 */
public class PartitionMap extends Mapper<LongWritable,Text, Text, UserInfo> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //数据是按照行获取的 value,先按照分隔符进行拆分

        String s = value.toString();
        String[] split = s.split(" ");

        //序列化，根据地址进行分组
        Text address=new Text(split[split.length-1]);

        UserInfo userInfo = new UserInfo();

        userInfo.setId(Integer.valueOf(split[0]));
        userInfo.setName(split[1]);
        userInfo.setJob(split[2]);
        userInfo.setAddress(split[3]);

        context.write(address,userInfo);
    }
}
