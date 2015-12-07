package cn.boxfish.samples.odps;

import com.aliyun.odps.Odps;
import com.aliyun.odps.OdpsException;
import com.aliyun.odps.account.Account;
import com.aliyun.odps.account.AliyunAccount;
import com.aliyun.odps.data.TableInfo;
import com.aliyun.odps.mapred.JobClient;
import com.aliyun.odps.mapred.RunningJob;
import com.aliyun.odps.mapred.conf.JobConf;
import com.aliyun.odps.mapred.conf.SessionState;
import com.aliyun.odps.mapred.utils.InputUtils;
import com.aliyun.odps.mapred.utils.OutputUtils;
import com.aliyun.odps.mapred.utils.SchemaUtils;

public class JobLauncher {

    public static void main(String[] args) throws OdpsException {


        JobConf job = new JobConf();

        // TODO: specify map output types
        job.setMapOutputKeySchema(SchemaUtils.fromString("word:string"));
        job.setMapOutputValueSchema(SchemaUtils.fromString("count:bigint"));

        // TODO: specify input and output tables
        InputUtils.addTable(TableInfo.builder().tableName("wc_in").build(), job);
        OutputUtils.addTable(TableInfo.builder().tableName("rs_out").build(), job);

        job.setMapperClass(cn.boxfish.samples.odps.MyMapper.class);
        job.setReducerClass(cn.boxfish.samples.odps.MyReducer.class);


        Account account = new AliyunAccount("22stee7bkfs8phyn5pbkfwuc", "e4m4bWoosdcSlF4aFpJLZAAYylw=");
        Odps odps = new Odps(account);
        odps.setDefaultProject("bebase");
        SessionState sessionState = SessionState.get();
        sessionState.setLocalRun(true);
        sessionState.setOdps(odps);


        RunningJob rj = JobClient.runJob(job);
        rj.waitForCompletion();
    }

}
