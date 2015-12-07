package cn.boxfish.samples.odps;

import com.aliyun.odps.Column;
import com.aliyun.odps.data.Record;
import com.aliyun.odps.mapred.MapperBase;

import java.io.IOException;

public class MyMapper extends MapperBase {

    private Record word;
    private Record one;

    public void setup(TaskContext context) throws IOException {
        word = context.createMapOutputKeyRecord();
        one = context.createMapOutputValueRecord();
        one.set(new Object[]{1l});
    }

    public void map(long recordNum, Record record, TaskContext context) throws IOException {
        for (Column column : record.getColumns()) {
            String[] words = record.getString(column.getName()).split("\\s+");
            for (String _word : words) {
                word = context.createMapOutputKeyRecord();
                word.set(new Object[]{_word});
                context.write(record, one);
            }
        }
    }

    public void cleanup(TaskContext context) throws IOException {
    }

}
