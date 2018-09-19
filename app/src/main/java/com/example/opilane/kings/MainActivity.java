package com.example.opilane.kings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public void update(King king){
        String line = toString(king);
        if (!lines.remove(line)) lines.add(line);
        listView.setAdapter(new ArrayAdapter<String>
                (contextMainActivity.this,android.R.layout.simple_list_item_1,lines));
    }

    private String toString(King king){
        if(king.getFrom() != 0 && king.getTo() != 9999)
            return String.format("%s: %d - %d", king.getName(), king.getFrom(), king.getTo());
        if(king.getFrom() != 0)
            return String.format("%s: %d -", king.getName(), king.getFrom());
        if(king.getTo() != 9999)
            return String.format("%s: -%d", king.getName(), king.getTo());
        return king.getName();
    }

    public void next(View view) {
        Intent nextPage = new Intent(packageContext MainActivity.this, SpinnerKings.class);
        sratActivity(nextPage);
    }
}



