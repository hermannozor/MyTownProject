package activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hermannozor.com.mytown_cameroon.R;

public class MainActivity extends AppCompatActivity {

    GridView gd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        gd=(GridView)findViewById(R.id.gridview);
        gd.setAdapter(new MyAdapter(this));

        gd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // this 'mActivity' parameter is Activity object, you can send the current activity.
          /*    Intent i = new Intent(this, ActvityToCall.class);
                mActivity.startActivity(i);*/

                if (position==0) {


                    startActivity(new Intent(getApplicationContext(), HotelMapActivity.class));

                }else if(position == 1) {

                    startActivity(new Intent(getApplicationContext(), PharmaActivity.class));

                }else if(position == 2) {

                    startActivity(new Intent(getApplicationContext(), RestoActivity.class));

                }else if(position == 3) {

                    startActivity(new Intent(getApplicationContext(), StationActivity.class));

                }else if(position == 4) {

                    startActivity(new Intent(getApplicationContext(),BankActivity.class));

                }else if(position == 5){

                    startActivity(new Intent(getApplicationContext(), AboutActivity.class));

                }

            }
        });
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

    private class MyAdapter extends BaseAdapter
    {
        private List<Item> items = new ArrayList<Item>();
        private LayoutInflater inflater;

        public MyAdapter(Context context)
        {
            inflater = LayoutInflater.from(context);

            items.add(new Item("Hôtels", R.drawable.hotel512));
            items.add(new Item("Pharmacies", R.drawable.pharmacy512));
            items.add(new Item("Restaurants de la ville", R.drawable.restaurant512));
            items.add(new Item("Stations Services", R.drawable.fuel512));
            items.add(new Item("Banques et Microfinances", R.drawable.bank512));
            items.add(new Item("A Propos de Nous ", R.drawable.about512));
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i)
        {
            return items.get(i);
        }

        @Override
        public long getItemId(int i)
        {
            return items.get(i).drawableId;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup)
        {
            View v = view;
            ImageView picture;
            TextView name;

            if(v == null)
            {
                v = inflater.inflate(R.layout.grid_item, viewGroup, false);
                v.setTag(R.id.picture, v.findViewById(R.id.picture));
                v.setTag(R.id.text, v.findViewById(R.id.text));
            }

            picture = (ImageView)v.getTag(R.id.picture);
            name = (TextView)v.getTag(R.id.text);

            Item item = (Item)getItem(i);

            picture.setImageResource(item.drawableId);
            name.setText(item.name);

            return v;
        }

        private class Item
        {
            final String name;
            final int drawableId;

            Item(String name, int drawableId)
            {
                this.name = name;
                this.drawableId = drawableId;
            }
        }



    }

}
