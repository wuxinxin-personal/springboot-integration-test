package com.example.springbootintegrationtest.hadoop.mapreduce.partition;

import com.example.springbootintegrationtest.hadoop.mapreduce.model.UserInfo;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author wuxinxin
 *
 * 对map结果做reduce
 */
public class PartitionReduce extends Reducer<Text, UserInfo,UserInfo, NullWritable> {
    @Override
    protected void reduce(Text key, Iterable<UserInfo> values, Context context) throws IOException, InterruptedException {
        //对map好的结果进行合并操作（reduce）
        for(UserInfo userInfo:values) {
            context.write(userInfo,NullWritable.get());
        }
    }
}
