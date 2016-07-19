package com.flipkart.protobufexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.flipkart.dinosaurs.Dinosaur;
import com.flipkart.events.Event;
import com.flipkart.geology.Period;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.wire.WireTypeAdapterFactory;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final Gson gson = new GsonBuilder()
            .registerTypeAdapterFactory(new WireTypeAdapterFactory())
            .disableHtmlEscaping()
            .create();

    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compareProtoToGson(Integer.valueOf(editText1.getText().toString()), Integer.valueOf(editText2.getText().toString()));
            }
        });

        Dinosaur stegosaurus = new Dinosaur.Builder()
                .name("Stegosaurus")
                .period(Period.JURASSIC)
                .length_meters(200.00)
                .mass_kilograms(3000.00)
                .build();

        System.out.println("(Check) My favorite dinosaur " + stegosaurus.name + " existed in the " + stegosaurus.period + " period.");

        byte[] stegosaurusBytes = Dinosaur.ADAPTER.encode(stegosaurus);

        try {
            Dinosaur stegosaurusDeSe = Dinosaur.ADAPTER.decode(stegosaurusBytes);
            System.out.println("(Proto) My favorite dinosaur " + stegosaurusDeSe.name + " existed in the " + stegosaurusDeSe.period + " period.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String json = gson.toJson(stegosaurus, Dinosaur.class);
        Dinosaur fromJson = gson.fromJson(json, Dinosaur.class);
        System.out.println("(GsonJ) My favorite dinosaur " + fromJson.name + " existed in the " + fromJson.period + " period.");
    }

    private void compareProtoToGson(int numberVisitId, int numberEventData) {
        ArrayList<Event.Data> eventDataList = new ArrayList<>();
        ArrayList<Event.VisitData> eventVisitIdList = new ArrayList<>();

        for (int i = 0; i < numberEventData; i++) {
            eventDataList.add(new Event.Data.Builder().listingId("abc" + i).productId("def" + i).requestId("ghi" + i).timestamp(System.currentTimeMillis()).build());
        }
        for (int i = 0; i < numberVisitId; i++) {
            eventVisitIdList.add(new Event.VisitData.Builder().data(eventDataList).build());
        }

        Event event = new Event.Builder().event("PRODUCT_VIEW").visitData(eventVisitIdList).build();

        long inTime;
        long outTime;
        Event fromByteArray = null;
        long protoDecode = 0;

        inTime = System.nanoTime();
        byte[] eventByteArray = Event.ADAPTER.encode(event);
        outTime = System.nanoTime();

        long protoEncode = (outTime - inTime);
        Log.e("Proto Encode Time", protoEncode + " ns");

        try {
            inTime = System.nanoTime();
            fromByteArray = Event.ADAPTER.decode(eventByteArray);
            outTime = System.nanoTime();
            protoDecode = (outTime - inTime);
            Log.e("Proto Decode Time", protoDecode + " ns");
        } catch (IOException e) {
            e.printStackTrace();
        }

        inTime = System.nanoTime();
        String eventJsonString = gson.toJson(event, Event.class);
        byte[] eventJsonStringBytes = eventJsonString.getBytes();
        outTime = System.nanoTime();
        long gsonEncode = (outTime - inTime);
        Log.e("Gson Encode Time", gsonEncode + " ns");

        inTime = System.nanoTime();
        Event fromJsonEvent = gson.fromJson(new String(eventJsonStringBytes), Event.class);
        outTime = System.nanoTime();
        long gsonDecode = (outTime - inTime);
        Log.e("Gson Decode Time", gsonDecode + " ns");

        long protoTotalTime = protoEncode + protoDecode;
        long gsonTotalTime = gsonEncode + gsonDecode;

        Log.e("Gain in encoding ", (double) gsonEncode / protoEncode + " times");
        Log.e("Gain in decode ", (double) gsonDecode / protoDecode + " times");
        Log.e("Protobuf is ", (double) gsonTotalTime / protoTotalTime + " times faster than Gson for " + editText1.getText().toString() + " data points. And equals : " + fromJsonEvent.equals(fromByteArray));

        Log.e("Data over wire", eventJsonString);

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
}
