package com.vdcodeassociate.retrofittest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewHeroes);

        getHeroes();

    }

    private void getHeroes(){
        Call<List<Hero>> call = RetrofitClient.getInstance().getApi().getHeroes();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                List<Hero> heroList = response.body();

                String[] heroes = new String[heroList.size()];

                for (int i=0;i<heroList.size();i++){
                    heroes[i] = heroList.get(i).getName();
                }

                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(),
                        android.R.layout.simple_list_item_1,heroes));

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(MainActivity.this,DetailedActivity.class);
//                        intent.putExtra("data", (Parcelable) heroList);
                        intent.putExtra("LIST", (Serializable) heroList);
                        intent.putExtra("position",position);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Faliure! :(",Toast.LENGTH_SHORT).show();
            }
        });
    }
}