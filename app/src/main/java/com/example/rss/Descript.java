package com.example.rss;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Descript extends AppCompatActivity {

    TextView title;
    TextView summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descript);

        title = findViewById(R.id.header);
        summary = findViewById(R.id.summary);

        Bundle getData = getIntent().getExtras();
        String header = getData.getString("head");
        String desc = getData.getString("sum");

        title.setText(header);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            summary.setText(Html.fromHtml(desc, Html.FROM_HTML_MODE_LEGACY));
        }
        else {
            summary.setText(Html.fromHtml(desc));
        }

        summary.setMovementMethod(new ScrollingMovementMethod());
    }
}