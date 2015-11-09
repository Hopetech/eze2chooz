package toucoumer.eze2chooz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class choices extends AppCompatActivity {

    final String EXTRA_CHOICE1 = "user_choice1";
    final String EXTRA_CHOICE2 = "user_choice2";
    final String EXTRA_CHOICE3 = "user_choice3";
    final String EXTRA_CHOICE4 = "user_choice4";
    final String EXTRA_CHOICE5 = "user_choice5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choices);

        final EditText choice1 = (EditText) findViewById(R.id.editTextChoice1);
        final EditText choice2 = (EditText) findViewById(R.id.editTextChoice2);
        final EditText choice3 = (EditText) findViewById(R.id.editTextChoice3);
        final EditText choice4 = (EditText) findViewById(R.id.editTextChoice4);
        final EditText choice5 = (EditText) findViewById(R.id.editTextChoice5);

        choice2.setVisibility(View.INVISIBLE);
        choice3.setVisibility(View.INVISIBLE);
        choice4.setVisibility(View.INVISIBLE);
        choice5.setVisibility(View.INVISIBLE);

        choice1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                choice2.setVisibility(View.VISIBLE);
                return false;
            }
        });

        choice2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                choice3.setVisibility(View.VISIBLE);
                return false;
            }
        });

        choice3.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                choice4.setVisibility(View.VISIBLE);
                return false;
            }
        });

        choice4.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                choice5.setVisibility(View.VISIBLE);
                return false;
            }
        });

        final ImageButton ButtonGoNext = (ImageButton) findViewById(R.id.imageButtonNext);
        ButtonGoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(choices.this, shake.class);
                intent.putExtra(EXTRA_CHOICE1, choice1.getText().toString());
                intent.putExtra(EXTRA_CHOICE2, choice2.getText().toString());
                intent.putExtra(EXTRA_CHOICE3, choice3.getText().toString());
                intent.putExtra(EXTRA_CHOICE4, choice4.getText().toString());
                intent.putExtra(EXTRA_CHOICE5, choice5.getText().toString());

                // Check that the two first editText are fill
                if (choice1.getText().toString().equals("") || choice2.getText().toString().equals("")) {
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.activity_custom__toast,
                            (ViewGroup) findViewById(R.id.toast_layout_root));

                    TextView text = (TextView) layout.findViewById(R.id.text);
                    text.setText(R.string.Error_nb_choices);

                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setView(layout);
                    toast.show();
                    return;
                }

                startActivity(intent);
            }
        });

        final ImageButton ButtonGoHome = (ImageButton) findViewById(R.id.imageButtonHome);
        ButtonGoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(choices.this, home.class);
                startActivity(intent);
            }
        });

    }
}
