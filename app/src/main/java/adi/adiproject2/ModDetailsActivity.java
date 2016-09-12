package adi.adiproject2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ModDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_details);

        TextView modName = (TextView) findViewById(R.id.detailsName);
        TextView modEndorsements = (TextView) findViewById(R.id.detailsEndorsements);
        TextView modCategory = (TextView) findViewById(R.id.detailsCategory);
        TextView modDescription = (TextView) findViewById(R.id.detailsDescription);
//        TextView modUrl = (TextView) findViewById(R.id.detailsUrl);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Intent intent = getIntent();
        String name = intent.getStringExtra("MODNAME");
        Cursor cursor = dbHelper.getModDetailed(name);
        ModDetailsCursorAdapter adapter = new ModDetailsCursorAdapter(this, cursor);

        if (cursor.getCount()>0) {


            modName.setText(cursor.getString(cursor.getColumnIndex("name")));
            modEndorsements.setText("Nexus Endorsements: "+cursor.getString(cursor.getColumnIndex("endorsements")));
            modCategory.setText("Category: "+cursor.getString(cursor.getColumnIndex("category")));
            modDescription.setText(cursor.getString(cursor.getColumnIndex("description")));
        }
    }
}
