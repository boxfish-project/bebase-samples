package cn.boxfish.samples.odps;

import com.aliyun.odps.data.Record;
import com.aliyun.odps.mapred.ReducerBase;

import java.io.IOException;
import java.util.Iterator;

public class MyReducer extends ReducerBase {

    private Record result;

    public void setup(TaskContext context) throws IOException {
        result = context.createOutputRecord();
    }

    public void reduce(Record key, Iterator<Record> values, TaskContext context) throws IOException {
        long count = 0;
        while (values.hasNext()) {
            Record value = values.next();
            count += value.getBigint(0);
        }
        result.set(new Object[]{key.getString(0), count});
        context.write(result);
    }

    public void cleanup(TaskContext context) throws IOException {
    }

}
