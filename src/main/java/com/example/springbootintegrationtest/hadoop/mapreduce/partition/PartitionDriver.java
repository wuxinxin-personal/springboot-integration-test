package com.example.springbootintegrationtest.hadoop.mapreduce.partition;

import com.example.springbootintegrationtest.hadoop.mapreduce.model.UserInfo;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * 实现WordCount
 * @author wuxinxin
 */
public class PartitionDriver {

    public static void main(String[] args) throws Exception {

        /**
         * 创建一个job
         */
        Configuration conf=new Configuration();
        Job job = Job.getInstance(conf);

        //设置jar存储位置
        job.setJarByClass(PartitionDriver.class);

        //关联map和reduce程序
        job.setMapperClass(PartitionMap.class);
        job.setReducerClass(PartitionReduce.class);

        //设置map阶段输出key,value类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(UserInfo.class);

        //设置最终输出结果的key,value类型
        job.setOutputKeyClass(UserInfo.class);
        job.setOutputValueClass(NullWritable.class);

        //设置分区
        job.setPartitionerClass(MyPartition.class);
        job.setNumReduceTasks(5);
        //设置输出路径和输入路径
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        //提交job
        job.waitForCompletion(true);
    }
}
