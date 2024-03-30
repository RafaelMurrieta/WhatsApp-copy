package com.murrydev.whatsap;

import static com.murrydev.whatsap.R.color.*;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
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

        TypedArray barC = obtainStyledAttributes(new int[]{R.attr.barcolor});
        int barTint = barC.getColor(0, 0);
        barC.recycle();
        getWindow().setStatusBarColor(barTint);

        TypedArray typedArray = obtainStyledAttributes(new int[]{R.attr.ovaloTint});
        int ovaloTint = typedArray.getColor(0, 0);
        typedArray.recycle();
        ImageView iconMsgChat = findViewById(R.id.iconMsgChat);
        iconMsgChat.setColorFilter(ovaloTint);

        TypedArray typedArray1 = obtainStyledAttributes(new int[]{R.attr.msjTint});
        int msjfill = typedArray1.getColor(0,0);
        typedArray1.recycle();
        ImageView iconMsgChatfondo = findViewById(R.id.imageButton);
        iconMsgChatfondo.setColorFilter(msjfill);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        init();

    }

    public  void init(){
        elements = new ArrayList<>();
        elements.add(new ListElement("Amoicito 🤎", "@drawable/profile1", " Hola, como estas? 👍🏻","#A8A9AB","12:12 am","set", "setChat"));
        elements.add(new ListElement("familia loca", "@drawable/profile1", "Hola, como estas?","#5E96D7","12:12 am","2","setChat"));
        elements.add(new ListElement("Mom ♥", "@drawable/profile1", "Hola, como estas?","#5E96D7","12:12 am","1", "setChat"));
        elements.add(new ListElement("Antonio", "", "Este es un mensaje largo que ocupa todo el espa...","#5E96D7","12:12 am","2","setChat"));
        elements.add(new ListElement("Edgar", "@drawable/profile1", "Hola, como estas?","#5E96D7","12:12 am","set",null));
        elements.add(new ListElement("Sister 🖤", "@drawable/profile1", "Hola, como estas?","#5E96D7","12:12 am","2",null));
        elements.add(new ListElement("🤖☠VALORANT🔫💤", "", "Este es un mensaje largo que ocupa todo el espa...","#5E96D7","12:12 am",null,null));
        elements.add(new ListElement("TópicosBaseA", "", "Este es un mensaje largo que ocupa todo el espa...","#5E96D7","12:12 am",null,null));
        elements.add(new ListElement("2024 B Móviles I", "", "Este es un mensaje largo que ocupa todo el espa...","#5E96D7","12:12 am",null,null));
        elements.add(new ListElement("Rafael", "", "Este es un mensaje largo que ocupa todo el espa...","#5E96D7","12:12 am",null,null));
        elements.add(new ListElement("Rafael", "", "Este es un mensaje largo que ocupa todo el espa...","#5E96D7","12:12 am",null,null));
        elements.add(new ListElement("Rafael", "", "Este es un mensaje largo que ocupa todo el espa...","#5E96D7","12:12 am","2",null));
        ListAdapter listAdapter = new ListAdapter(elements,this);
        RecyclerView recyclerView = findViewById(R.id.chatsP);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
        Log.d("lista", listAdapter.toString());
        Log.d("Lista de elementos", "Tamaño de la lista: " + elements.size());

    }
}