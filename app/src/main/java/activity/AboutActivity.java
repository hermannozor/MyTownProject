package activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by herma on 06/06/2016.
 */
public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //setContentView(R.layout.tow_pharma_activity);

        System.out.println("dans about");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
