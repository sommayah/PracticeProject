package com.sommayah.practiceproject;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class MyJobService extends JobService {
    public MyJobService() {
    }

    private Handler mJobHandler = new Handler( new Handler.Callback() {

        @Override
        public boolean handleMessage( Message msg ) {
            Toast.makeText( getApplicationContext(),
                    "JobService task running", Toast.LENGTH_SHORT )
                    .show();
            jobFinished( (JobParameters) msg.obj, false );
            return true;
        }

    } );

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        mJobHandler.sendMessage(Message.obtain(mJobHandler, 1, jobParameters));

        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        mJobHandler.removeMessages(1);
        return false;
    }


}
