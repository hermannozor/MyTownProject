package activity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import hermannozor.com.mytown_cameroon.R;

/**
 * Created by herma on 06/06/2016.
 */
public class HotelMapActivity extends AppCompatActivity implements
        FragmentDrawer.FragmentDrawerListener {

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_fragment);

        mToolbar = (Toolbar) findViewById(R.id.toolbar2);

//
        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {

        displayView(position);

    }

    private void displayView(int position) {

        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();

        String title = getString(R.string.app_name);

        android.support.v4.app.Fragment objFragment  = null;

        //   int id = item.getItemId();

        if (position== 0)

           /* Toast.makeText(getApplicationContext(),
                    "dans la deuxième selection", Toast.LENGTH_LONG).show();*/
            objFragment= new HotelFragment();
        title = getString(R.string.title_yaounde);

        if (objFragment != null) {

            fm.beginTransaction().replace(R.id.container_body, objFragment).commit();
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);



        }

    }

}
