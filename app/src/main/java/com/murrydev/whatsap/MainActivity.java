package com.murrydev.whatsap;

import static com.murrydev.whatsap.R.color.*;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    List<ListElement> elements;

    public ImageView iconMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
            getWindow().setTitleColor(ContextCompat.getColor(this, R.color.white));
            iconMsg = findViewById(R.id.iconMsgChat);
            iconMsg.setColorFilter(ContextCompat.getColor(this, R.color.black), PorterDuff.Mode.SRC_IN);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        init();

    }

    public  void init(){
        elements = new ArrayList<>();
        elements.add(new ListElement("Rafael", "@drawable/profile1", "Hola, como estas? 👍🏻","#A8A9AB","12:12 am","2"));
        elements.add(new ListElement("Rafael", "@drawable/profile1", "Hola, como estas?","#5E96D7","12:12 am","2"));
        elements.add(new ListElement("Rafael", "@drawable/profile1", "Hola, como estas?","#5E96D7","12:12 am","2"));
        elements.add(new ListElement("Rafael", "@drawable/profile1", "Hola, como estas?","#5E96D7","12:12 am","2"));
        elements.add(new ListElement("Rafael", "@drawable/profile1", "Hola, como estas?","#5E96D7","12:12 am","2"));
        elements.add(new ListElement("Rafael", "", "Este es un mensaje largo que ocupa todo el espa...","#5E96D7","12:12 am","2"));
        elements.add(new ListElement("Rafael", "", "Este es un mensaje largo que ocupa todo el espa...","#5E96D7","12:12 am","2"));
        elements.add(new ListElement("Rafael", "", "Este es un mensaje largo que ocupa todo el espa...","#5E96D7","12:12 am","2"));
        elements.add(new ListElement("Rafael", "", "Este es un mensaje largo que ocupa todo el espa...","#5E96D7","12:12 am","2"));
        elements.add(new ListElement("Rafael", "", "Este es un mensaje largo que ocupa todo el espa...","#5E96D7","12:12 am","2"));
        elements.add(new ListElement("Rafael", "", "Este es un mensaje largo que ocupa todo el espa...","#5E96D7","12:12 am","2"));
        elements.add(new ListElement("Rafael", "", "Este es un mensaje largo que ocupa todo el espa...","#5E96D7","12:12 am","2"));
        ListAdapter listAdapter = new ListAdapter(elements,this);
        RecyclerView recyclerView = findViewById(R.id.chatsP);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
        Log.d("lista", listAdapter.toString());
        Log.d("Lista de elementos", "Tamaño de la lista: " + elements.size());

    }
}