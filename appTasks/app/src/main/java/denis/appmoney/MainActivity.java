package denis.appmoney;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static denis.appmoney.Controller.GetData.readFileFromAssets;

public class MainActivity extends AppCompatActivity {
    private Button buttonAdd;
    private LinearLayout linearLayoutOne;
    private LinearLayout linearLayoutTwo;

    private final int USERID = 6000;
    private int countID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = (Button) findViewById(R.id.addButton);
        linearLayoutOne = (LinearLayout) findViewById(R.id.linearLayout);
        linearLayoutTwo = (LinearLayout) findViewById(R.id.linearLayouTwo);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btnObjects = new Button(getApplicationContext());
                btnObjects.setText("Удалить данную кнопку №" + Integer.toString(countID + 1));
                btnObjects.setMaxWidth(50);

                btnObjects.setLayoutParams(
                        new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT)
                );
                btnObjects.setId(USERID + countID);
                btnObjects.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            linearLayoutOne.removeView(v);
                            linearLayoutTwo.removeView(v);
                    }
                });
                if(countID%2==0){
                    linearLayoutOne.addView(btnObjects);
                }else{
                    linearLayoutTwo.addView(btnObjects);
                }
                countID++;
                messageAdd();
            }
        });

    }

    public void openText(View view) {
        TextView textView = (TextView) findViewById(R.id.textView);
        String json = readFileFromAssets(this, "listbox.json");
        textView.setText(json);
    }

    private void messageAdd(){
        Toast toast = Toast.makeText(getApplicationContext(),
                "Вы добавили событие.",
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}