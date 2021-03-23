package com.example.springbootintegrationtest.hadoop.mapreduce.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author wuxinxin
 *
 * 对map结果做reduce
 */
public class WordCountReduce extends Reducer<Text, IntWritable,Text,IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        //对map好的结果进行合并操作（reduce）

        // key是代表的单词， values代表数量
        int sum=0;

        for(IntWritable intWritable:values){
            sum+=intWritable.get();
        }

        //写入reduce的结果
        context.write(key,new IntWritable(sum));
    }
}
