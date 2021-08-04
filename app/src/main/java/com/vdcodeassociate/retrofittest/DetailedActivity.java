package com.vdcodeassociate.retrofittest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class DetailedActivity extends AppCompatActivity {

    private TextView heroName;
    private TextView realname;
    private TextView team;
    private TextView firstappearance;
    private TextView createdby;
    private TextView publisher;
    private TextView bio;
    private String imageurl;
    private ImageView imageView;

    private List<Hero> list;

    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        heroName = findViewById(R.id.name);
        realname = findViewById(R.id.realname);
        team = findViewById(R.id.team);
        firstappearance = findViewById(R.id.firstappearance);
        createdby = findViewById(R.id.createdby);
        publisher = findViewById(R.id.publisher);
        bio = findViewById(R.id.bio);
        imageView = findViewById(R.id.imageView);

        Intent intent = getIntent();
        list = (List<Hero>) intent.getSerializableExtra("LIST");
        position = intent.getIntExtra("position",0);

        heroName.setText(list.get(position).getName());
        realname.setText("Real Name : "+list.get(position).getRealname());
        team.setText("Team : "+list.get(position).getTeam());
        firstappearance.setText("First Appearance : "+list.get(position).getFirstappearance());
        createdby.setText("Created By : "+list.get(position).getCreatedby());
        publisher.setText("Publisher : "+list.get(position).getPublisher());
        bio.setText("Bio : "+list.get(position).getBio());

        imageurl = list.get(position).getImageurl();

        Glide.with(getApplicationContext())
                .load(imageurl)
                .into(imageView);
    }
}