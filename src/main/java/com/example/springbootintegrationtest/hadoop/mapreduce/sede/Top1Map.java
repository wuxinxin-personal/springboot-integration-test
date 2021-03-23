package com.example.springbootintegrationtest.hadoop.mapreduce.sede;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author wuxinxin
 *
 * 对单词做map操作
 */
public class Top1Map extends Mapper<LongWritable,Text, UserInfo, NullWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //数据是按照行获取的 value,先按照分隔符进行拆分

        String s = value.toString();

        String[] split = s.split(",");

        //拆分完后，开始做map操作
        UserInfo userInfo = new UserInfo();
        userInfo.setId(Integer.valueOf(split[0]));
        userInfo.setName(split[1]);
        userInfo.setScore(Integer.valueOf(split[2]));

        context.write(userInfo,NullWritable.get());
    }
}
