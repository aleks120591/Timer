package kr.aleks.timer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;
    protected CountDownTimer mTimer;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView=(TextView)findViewById(R.id.rest_timer);
        mTimer=new timerCounter(300000,1000);
        mTimer.start();

        mButton=(Button)findViewById(R.id.rest);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTimer.start();
            }
        });
    }

    public class timerCounter extends CountDownTimer{

        public timerCounter(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            mTextView.setText(getTime((int)l / 1000));
        }

        @Override
        public void onFinish() {
            mTextView.setText("Load Activity...");
        }
    }

    private String getTime(int time) {
        String result = "";
        int hours = time / 3600;
        int minutes = (time - (hours * 3600)) / 60;
        int seconds = (time - (hours * 3600) - (minutes * 60));
        result = String.valueOf(hours) + ":";
        if (minutes < 10) {
            result += "0" + String.valueOf(minutes) + ":";
        } else {
            result += String.valueOf(minutes) + ":";
        }
        if (seconds < 10) {
            result += "0" + String.valueOf(seconds);
        } else {
            result += String.valueOf(seconds);
        }
        return result;
    }
}
