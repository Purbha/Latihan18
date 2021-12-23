package com.ims_hr.latihan18;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

public class ClassAlert {

    Context context;

    public ClassAlert(Context context) {
        this.context = context;
    }

    public void TampilAlert(String Pesan) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(Pesan);
        builder.setTitle("Informasi");
        builder.setPositiveButton("Okesip", (dialog, which) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
