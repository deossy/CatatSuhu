package com.dessy.catatsuhu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class LihatDataSuhu extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView listView;
    private String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data_suhu);

        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener((AdapterView.OnItemClickListener) this);
        getJSON();
    }

    private void showChachacha() {
        JSONObject jsonObject = null;
        ArrayList<HashMap<String, String>> list = new
                ArrayList<HashMap<String, String>>();
        try {
            try {
                jsonObject = new JSONObject(JSON_STRING);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray result =
                    jsonObject.getJSONArray(Konfigurasi.TAG_JSON_ARRAY);

            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                String nis = jo.getString(Konfigurasi.TAG_ID);
                String suhu = jo.getString(Konfigurasi.TAG_SUHU);
                HashMap<String, String> lihatdatasuhu = new HashMap<>();
                lihatdatasuhu.put(Konfigurasi.TAG_ID, nis);
                lihatdatasuhu.put(Konfigurasi.TAG_SUHU, suhu);
                list.add(lihatdatasuhu);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                LihatDataSuhu.this, list, R.layout.list_item,
                new String[]{Konfigurasi.TAG_ID, Konfigurasi.TAG_SUHU},
                new int[]{R.id.nis, R.id.suhu});

        listView.setAdapter(adapter);
    }

    private void getJSON() {
        class GetJSON extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatDataSuhu.this, "Mengambil Data", "Mohon Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showChachacha();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(Konfigurasi.URL_GET_SUHU);
                return s;
            }

        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

    //@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, MainActivity.class);
        HashMap <String, String> map = (HashMap) parent.getItemAtPosition(position);
        String Idsiswa = map.get(Konfigurasi.TAG_ID).toString();
        intent.putExtra(Konfigurasi.KEY_NIS, Idsiswa);
        startActivity(intent);
        finish();
    }

    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
    }

}