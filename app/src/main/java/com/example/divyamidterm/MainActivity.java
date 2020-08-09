package com.example.divyamidterm;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ListView repolistv;
    ListviewAdapter listviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repolistv = findViewById(R.id.listview);

        String apiurl = getResources().getString(R.string.repourl);

        listviewAdapter = new ListviewAdapter(MainActivity.this,getData(apiurl));

        repolistv.setAdapter(listviewAdapter);


    }

    public ArrayList<Repositories> getData(String url) {

        ArrayList<Repositories> pokemonArrayList = new ArrayList<>();

        try {
            String jsondata = new AsyncData().execute(url).get();

            JSONObject mainobj = new JSONObject(jsondata);
            JSONArray pokemonArray = mainobj.getJSONArray("Repositories");

            String name;
            String login;
            for (int i = 0; i < pokemonArray.length(); i++) {
                JSONObject childobj = pokemonArray.getJSONObject(i);
                System.out.println(childobj);
                JSONObject owner = childobj.getJSONObject("owner");
                System.out.println(owner);
                name = childobj.getString("name");
                login = owner.getString("login");
                System.out.println(login);
                pokemonArrayList.add(new Repositories(name, login));

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println("Size of Arraylist(Outside try) :"+pokemonArrayList.size());
        return  pokemonArrayList;
    }
}