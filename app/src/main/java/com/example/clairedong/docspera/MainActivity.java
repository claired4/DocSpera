package com.example.clairedong.docspera;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ColorItem> colorItems;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        colorItems = new ArrayList<>();

        getJSON();

        adapter = new ColorAdapter(colorItems, this);
        recyclerView.setAdapter(adapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void getJSON() {

        String json = null;
        try {

            InputStream is = getAssets().open("colors.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");

            JSONObject jsonObj = new JSONObject(json);
            JSONArray jsonColors = jsonObj.getJSONArray("colors");

            for (int i = 0; i < jsonColors.length(); i++) {
                JSONObject obj = jsonColors.getJSONObject(i);

                ColorItem c = new ColorItem(obj.getString("color"), obj.getString("category"));

                if (obj.has("type")) {
                    c.setType(obj.getString("type"));
                }

                colorItems.add(c);
            }


        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
