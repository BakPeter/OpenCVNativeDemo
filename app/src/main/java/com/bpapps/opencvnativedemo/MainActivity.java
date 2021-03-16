package com.bpapps.opencvnativedemo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

public class MainActivity extends AppCompatActivity {

    private AppCompatTextView mTvResult;
    private AppCompatEditText mEtN;
    private AppCompatEditText mEtM;
    private AppCompatButton mBtnEquals;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvResult = findViewById(R.id.tvResult);
        mEtN = findViewById(R.id.etN);
        mEtM = findViewById(R.id.etM);

        mBtnEquals = findViewById(R.id.btnEquals);
        mBtnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double n = Double.parseDouble(mEtN.getText().toString());
                double m = Double.parseDouble(mEtM.getText().toString());

                // Example of a call to a native method
                TextView tv = findViewById(R.id.tvResult);
                double result = getSRnPowM(n, m);
                tv.setText("cpp : pow(sqrt(" + n + "), " + m + ")  = " + result);
            }
        });
    }


    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    //native
    public native double getSRnPowM(double n, double m);

    //my native lib
    public native int getSumPlusOne(int num);

    //native.lib
    public native double getSquareRoot(double num);

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
}