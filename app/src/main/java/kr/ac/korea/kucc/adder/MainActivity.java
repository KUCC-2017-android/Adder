package kr.ac.korea.kucc.adder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int result = 0;
    private int current = 0;
    private TextView resultView;
    private TextView historyView;
    private boolean flushHistory = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultView = (TextView) findViewById(R.id.text_result);
        historyView = (TextView) findViewById(R.id.text_history);
    }

    public void onNumpadButtonClick(View v) {
        if (flushHistory) {
            result = 0;
        }
        Button button = (Button)v;
        int num = Integer.parseInt(button.getText().toString());
        current *= 10;
        current += num;
        resultView.setText(String.valueOf(current));
    }

    public void onPlusButtonClick(View v) {
        if (flushHistory) {
            flushHistory = false;
        }

        if (resultView.getText().length() != 0) {
            result += current;
            current = 0;
            historyView.setText(historyView.getText().toString() + resultView.getText() + " + ");
            resultView.setText("");
        }
    }

    public void onResultButtonClick(View v) {
        result += current;
        current = 0;
        historyView.setText("");
        resultView.setText(String.valueOf(result));
        flushHistory = true;
    }
}
