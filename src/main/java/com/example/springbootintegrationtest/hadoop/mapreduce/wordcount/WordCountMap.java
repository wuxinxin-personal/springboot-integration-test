package com.example.springbootintegrationtest.hadoop.mapreduce.wordcount;

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
public class WordCountMap extends Mapper<LongWritable,Text, Text, IntWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //数据是按照行获取的 value,先按照分隔符进行拆分

        String s = value.toString();

        String[] split = s.split(" ");

        //拆分完后，开始做map操作
        Text k = new Text();
        IntWritable v = new IntWritable();
        v.set(1);
        for(String temp:split){
            //输出map结果
            k.set(temp);
            context.write(k,v);
        }
    }
}
