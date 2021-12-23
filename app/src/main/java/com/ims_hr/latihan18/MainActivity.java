package com.ims_hr.latihan18;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button B_OK1, B_OK2;
    ClassAlert classAlert;

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
        classAlert = new ClassAlert(MainActivity.this);
    }

    private void Listen_B_OK2() {
        B_OK2.setOnClickListener(v -> {
            Intent In = new Intent(MainActivity.this,DuaActivity.class);
            startActivity(In);
        });
    }

    private void Listen_B_OK1(){
        B_OK1.setOnClickListener(v -> {
            String namaActivity = "com.ims_hr.latihan177.SatuActivity";
            String namaPackage = "com.ims_hr.latihan177";
            if(cekPackage(namaPackage) == true) {
                Intent In = new Intent(namaActivity);
                startActivity(In);
            } else {
                classAlert.TampilAlert("Aplikasi tidak ditemukan.");
                /*
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Aplikasi tidak ditemukan.");
                builder.setTitle("Informasi");
                builder.setPositiveButton("Okesip", (dialog, which) -> dialog.dismiss());
                AlertDialog dialog = builder.create(); dialog.show();
                */
            }

        });
    }

    public boolean cekPackage(String namaPackage) {
        boolean Hasil = false;
        List<ApplicationInfo> ListAplikasi;
        PackageManager packageManager = getPackageManager();
        //https://developer.android.com/reference/android/content/pm/PackageManager#getInstalledApplications(int)
        ListAplikasi = packageManager.getInstalledApplications(0);
        for(ApplicationInfo info : ListAplikasi) {
            if(info.packageName.equals(namaPackage)) {
                Hasil = true;
                return Hasil;
            }
        }
        return Hasil;
    }

}
