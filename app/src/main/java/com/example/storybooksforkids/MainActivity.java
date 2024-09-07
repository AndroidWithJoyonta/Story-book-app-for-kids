package com.example.storybooksforkids;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HashMap<String ,String > hashMap;
    ArrayList<HashMap<String ,String >> arrayList;

    DrawerLayout drawerLayout;
    MaterialToolbar toolbar;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigationView);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                MainActivity.this,drawerLayout,toolbar,R.string.drawer_close,R.string.drawer_open
        );
        drawerLayout.addDrawerListener(toggle);



        //Navigation item adds

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();

                if (itemId==R.id.icon_share) {
                    ShareApp(MainActivity.this);
                    drawerLayout.closeDrawer(GravityCompat.START);

                } else if (itemId==R.id.icon_policy) {

                    gotoLink();

                    drawerLayout.closeDrawer(GravityCompat.START);

                }else if (itemId==R.id.icon_rate) {

                    final String appName = getPackageName();
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appName)));

                    drawerLayout.closeDrawer(GravityCompat.START);

                }

                return true;
            }
        });
        //=======================================================


        MyAdapter myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        createTable();
    }



    //RecyclerView method Here

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myViewHolder> {


        public class myViewHolder extends RecyclerView.ViewHolder{

            ImageView tvImage;
            TextView tvTitle;

            RelativeLayout main_item;

            public myViewHolder(@NonNull View itemView) {
                super(itemView);

                tvImage  = itemView.findViewById(R.id.tvImage);
                tvTitle  = itemView.findViewById(R.id.tvTitle);
                main_item  = itemView.findViewById(R.id.main_item);


            }
        }

        @NonNull
        @Override
        public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = getLayoutInflater();
            View myView = inflater.inflate(R.layout.item,parent,false);

            return new myViewHolder(myView);
        }

        @Override
        public void onBindViewHolder(@NonNull myViewHolder holder, int position) {



            hashMap = arrayList.get(position);

            String title = hashMap.get("title");
            String icon = hashMap.get("icon");
            String Story = hashMap.get("Story");
            String moral_story = hashMap.get("moral_story");


            int myDrawable = Integer.parseInt(icon);


            holder.tvTitle.setText(title);
            holder.tvImage.setImageResource(myDrawable);

            holder.main_item.setOnClickListener(v -> {

                story_Activity.image_story = myDrawable;
                story_Activity.TITLE=title;
                story_Activity.STORY=Story;
                story_Activity.MORAL=moral_story;

                startActivity(new Intent(MainActivity.this,story_Activity.class));

            });


        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }


    }

    private void createTable(){




        arrayList = new ArrayList<>();

        hashMap= new HashMap<>();
        hashMap.put("title",getString(R.string.title1));
        hashMap.put("icon",""+ R.drawable.rv_image1);
        hashMap.put("Story",getString(R.string.story1));
        hashMap.put("moral_story" ,getString(R.string.moral1));
        arrayList.add(hashMap);

        hashMap= new HashMap<>();
        hashMap.put("title",getString(R.string.title2));
        hashMap.put("icon",""+ R.drawable.rv_image2);
        hashMap.put("Story",getString(R.string.story2));
        hashMap.put("moral_story" ,getString(R.string.moral2));
        arrayList.add(hashMap);

        hashMap= new HashMap<>();
        hashMap.put("title",getString(R.string.title3));
        hashMap.put("icon",""+ R.drawable.rv_image3);
        hashMap.put("Story",getString(R.string.story3));
        hashMap.put("moral_story" ,getString(R.string.moral3));
        arrayList.add(hashMap);

        hashMap= new HashMap<>();
        hashMap.put("title",getString(R.string.title4));
        hashMap.put("icon",""+ R.drawable.rv_image4);
        hashMap.put("Story",getString(R.string.story4));
        hashMap.put("moral_story" ,getString(R.string.moral4));
        arrayList.add(hashMap);

        hashMap= new HashMap<>();
        hashMap.put("title",getString(R.string.title5));
        hashMap.put("icon",""+ R.drawable.rv_image5);
        hashMap.put("Story",getString(R.string.story5));
        hashMap.put("moral_story" ,getString(R.string.moral5));
        arrayList.add(hashMap);

        hashMap= new HashMap<>();
        hashMap.put("title",getString(R.string.title6));
        hashMap.put("icon",""+ R.drawable.rv_image6);
        hashMap.put("Story",getString(R.string.story6));
        hashMap.put("moral_story" ,getString(R.string.moral6));
        arrayList.add(hashMap);

        hashMap= new HashMap<>();
        hashMap.put("title",getString(R.string.title7));
        hashMap.put("icon",""+ R.drawable.rv_image7);
        hashMap.put("Story",getString(R.string.story7));
        hashMap.put("moral_story" ,getString(R.string.moral7));
        arrayList.add(hashMap);

        hashMap= new HashMap<>();
        hashMap.put("title",getString(R.string.title8));
        hashMap.put("icon",""+ R.drawable.rv_image8);
        hashMap.put("Story",getString(R.string.story8));
        hashMap.put("moral_story" ,getString(R.string.moral8));
        arrayList.add(hashMap);

        hashMap= new HashMap<>();
        hashMap.put("title",getString(R.string.title9));
        hashMap.put("icon",""+ R.drawable.rv_image9);
        hashMap.put("Story",getString(R.string.story9));
        hashMap.put("moral_story" ,getString(R.string.moral9));
        arrayList.add(hashMap);

        hashMap= new HashMap<>();
        hashMap.put("title",getString(R.string.title10));
        hashMap.put("icon",""+ R.drawable.rv_image10);
        hashMap.put("Story",getString(R.string.story10));
        hashMap.put("moral_story" ,getString(R.string.moral10));
        arrayList.add(hashMap);

    }

    //Share App code
    private void ShareApp(Context context){
        // code here
        final String appPakageName = context.getPackageName();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Download Now : https://play.google.com/store/apps/details?id=" + appPakageName );
        sendIntent.setType("text/plain");
        context.startActivity(sendIntent);
    }

    //privacy_policy_link_open_code
    private void gotoLink(){
        try {

            String download_link = "https://sites.google.com/view/privacy-policy-2048-puzzle/home";
            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(download_link));
            startActivity(myIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No application can handle this request."
                    + " Please install a webbrowser",  Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

}