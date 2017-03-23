package com.example.user.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String SAVED_TEXT = "saved_text" ;
    EditText etText;
    Button btSave, btLoad;
    SharedPreferences sPref;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etText = (EditText)findViewById(R.id.editText);
        btSave = (Button)findViewById(R.id.btn_save);
        btSave.setOnClickListener(this);
        btLoad = (Button)findViewById(R.id.btn_zagr);
        btLoad = (Button)findViewById(R.id.btn_zagr);
        btLoad.setOnClickListener(this);
        loadText();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_save:
                saveText();
                break;
            case R.id.btn_zagr:
                loadText();
                break;
            default:
                break;
        }
    }
    // метод загрузки текста из встроенной памяти приложения
    private void loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        String saveText = sPref.getString(SAVED_TEXT, "");
        text = (TextView)findViewById(R.id.textView);
        text.setText(saveText);
        Toast.makeText(MainActivity.this, "Данные загружены!", Toast.LENGTH_SHORT).show();
    }
    // метод загрузки в память приложения
    private void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, etText.getText().toString());
        // загружаем в память
        ed.commit();
        Toast.makeText(MainActivity.this, "Текст сохранен", Toast.LENGTH_SHORT).show();
    }
}
