package com.ims_hr.app_dua;

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

    Button B_OK1;
    Button B_OK2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Inisial();
        Listen_B_OK1();
        Listen_B_OK2();
    }

    private void Inisial(){
        B_OK1 = (Button) findViewById(R.id.button_Main_OK1);
        B_OK2 = (Button) findViewById(R.id.button_Main_OK2);
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
                String namaActivity = "com.ims_hr.app_satu.SatuActivity";
                String namaPackage = "com.ims_hr.app_satu";
                //Intent In = new Intent(namaDicari);
                //startActivity(In);
                if(cekPackage(namaPackage) == true) {
                    Intent In = new Intent(namaActivity); startActivity(In);
                } else {
                    //Instantiate an AlertDialog.Builder with its constructor
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    //Chain together various setter methods to set the dialog characteristics
                    builder.setMessage("Aplikasi tidak ditemukan.");
                    builder.setTitle("Informasi");
                    //Add the buttons
                    builder.setPositiveButton("Okesip", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    //Get the AlertDialog from create()
                    AlertDialog dialog = builder.create(); dialog.show();
                }
            }
        });
    }

    public boolean cekPackage(String namaPackage) {
        boolean Hasil = false;
        List<ApplicationInfo> ListAplikasi;
        PackageManager packageManager = getPackageManager();
        /*
        getInstalledApplications --> added in API level 1
        public abstract List<ApplicationInfo> getInstalledApplications (int flags)
        Return a List of all application packages that are installed for the current user.
        If flag GET_UNINSTALLED_PACKAGES has been set, a list of all applications including those
            deleted with DONT_DELETE_DATA (partially installed apps with data directory)
            will be returned.
        */
        ListAplikasi = packageManager.getInstalledApplications(0);
        for(ApplicationInfo info : ListAplikasi) {
            if(info.packageName.equals(namaPackage)) {
                Hasil = true;
            }
        }
        return Hasil;
    }

}
