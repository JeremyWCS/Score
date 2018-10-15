package fr.wildcodeschool.score;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static java.lang.Integer.getInteger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSend = findViewById(R.id.button_send);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText name = findViewById(R.id.editText_name);
                String nameValue = name.getText().toString();

                EditText score = findViewById(R.id.editText_score);
                int scoreValue = Integer.parseInt(score.getText().toString());

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                Player player = new Player(nameValue, scoreValue);
                DatabaseReference scoreRef = database.getReference("Best score");
                String playerKey = scoreRef.push().getKey();
                scoreRef.child(playerKey).setValue(player);

                Intent goToListActivity = new Intent(MainActivity.this,
                        ListActivity.class);
                MainActivity.this.startActivity(goToListActivity);

            }
        });

    }
}
