package com.example.springbootintegrationtest.hadoop.mapreduce.sede;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author wuxinxin
 *
 * 对map结果做reduce
 */
public class Top1Reduce extends Reducer<UserInfo, NullWritable,UserInfo,NullWritable> {
    @Override
    protected void reduce(UserInfo key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
        //对map好的结果进行合并操作（reduce）
        //写入reduce的结果
        context.write(key,NullWritable.get());
    }
}
