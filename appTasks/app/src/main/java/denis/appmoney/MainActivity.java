package denis.appmoney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import static denis.appmoney.Controller.GetData.readFileFromAssets;

public class MainActivity extends AppCompatActivity {
    private Button buttonAdd;
    private LinearLayout linearLayout;

    private final int USERID = 6000;
    private int countID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonAdd = (Button) findViewById(R.id.addButton);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btnObjects = new Button(getApplicationContext());
                btnObjects.setText("Удалить данную кнопку №" + Integer.toString(countID + 1));
                btnObjects.setLayoutParams(
                        new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT)
                );
                btnObjects.setId(USERID + countID);
                btnObjects.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        linearLayout.removeView(v);
                    }
                });
                linearLayout.addView(btnObjects);
                countID++;
            }
        });

    }

    public void openText(View view) {
        TextView textView = (TextView) findViewById(R.id.textView);

        String json = readFileFromAssets(this, "listbox.json");

        textView.setText(json);

        Toast toast = Toast.makeText(getApplicationContext(),
                        json,
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
    }
}