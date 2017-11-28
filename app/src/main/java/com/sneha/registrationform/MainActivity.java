package com.sneha.registrationform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private EditText mFirstNameEt, mLastNameEt;
    private RadioButton male_rb, female_rb;
    private CheckBox mAgreeCb;
    private Button btn;
    private String mFirstName, mLastName, mGender;
    private RadioGroup gender_rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirstNameEt = findViewById(R.id.first_name_et);
        mLastNameEt = findViewById(R.id.last_name_et);

        mAgreeCb = findViewById(R.id.agree_cb);

        gender_rg = findViewById(R.id.gender_rg);
        male_rb = findViewById(R.id.male_rb);
        female_rb = findViewById(R.id.female_rb);

        btn = findViewById(R.id.continue_btn);
        btn.setOnClickListener(this);

        mAgreeCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Toast.makeText(MainActivity.this, "Thanks for Agreeing!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Please agree!", Toast.LENGTH_SHORT).show();

            }
        });

        gender_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (R.id.male_rb == checkedId)
                    Toast.makeText(MainActivity.this, "You are Male!", Toast.LENGTH_SHORT).show();
                else if (R.id.female_rb == checkedId)
                    Toast.makeText(MainActivity.this, "You are Female!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onClick(View v) {
        mFirstName = mFirstNameEt.getText().toString();
        mLastName = mLastNameEt.getText().toString();
        int cRb = gender_rg.getCheckedRadioButtonId();

        if (TextUtils.isEmpty(mFirstName)) {
            Toast.makeText(this, "First name Empty!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(mLastName)) {
            Toast.makeText(this, "Last name is empty!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (cRb == -1) {
            Toast.makeText(this, "Select gender!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (R.id.male_rb == cRb)
            mGender = "Male";
        else if (R.id.female_rb == cRb)
            mGender = "Female";

        if (!mAgreeCb.isChecked()) {
            Toast.makeText(this, "Not agreed!", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, mFirstName + "\n" + mLastName + "\n" + mGender, Toast.LENGTH_SHORT).show();
    }
}
