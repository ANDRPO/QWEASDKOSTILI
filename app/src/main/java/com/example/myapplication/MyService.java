package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    class MyTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            Toast.makeText(MyService.this, "Работаю1", Toast.LENGTH_LONG).show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(5000);
                Log.d("MYSERVICE", "Работаю");
                this.publishProgress();

            } catch (InterruptedException e) {

                e.printStackTrace();

            }
            return null;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        MyTask task = new MyTask();
        task.execute();

        return START_STICKY;
    }
}
