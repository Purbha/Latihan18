package com.ims_hr.latihan18;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button B_OK1, B_OK2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Inisial();
        Listen_B_OK1();
        Listen_B_OK2();
    }

    private void Inisial(){
        B_OK1 = findViewById(R.id.button_Main_OK1);
        B_OK2 = findViewById(R.id.button_Main_OK2);
    }

    private void Listen_B_OK2() {
        B_OK2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent In = new Intent(MainActivity.this,DuaActivity.class);
                startActivity(In);
            }
        });
    }

    private void Listen_B_OK1(){
        B_OK1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaActivity = "com.ims_hr.latihan17.SatuActivity";
                String namaPackage = "com.ims_hr.latihan17";
                if(cekPackage(namaPackage) == true) {
                    Intent In = new Intent(namaActivity);
                    startActivity(In);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Aplikasi tidak ditemukan.");
                    builder.setTitle("Informasi");
                    builder.setPositiveButton("Okesip", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog dialog = builder.create(); dialog.show();
                }
            }
        });
    }

    public boolean cekPackage(String namaPackage) {
        boolean Hasil = false;
        List<ApplicationInfo> ListAplikasi;
        PackageManager packageManager = getPackageManager();
        ListAplikasi = packageManager.getInstalledApplications(0);
        for(ApplicationInfo info : ListAplikasi) {
            if(info.packageName.equals(namaPackage)) {
                Hasil = true;
            }
        }
        return Hasil;
    }

}
