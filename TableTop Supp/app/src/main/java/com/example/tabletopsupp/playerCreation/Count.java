package com.example.tabletopsupp.playerCreation;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.Toast;

public class Count {


    public int checked (int count, CheckBox checkBox) {

        if (count == 0) {

            checkBox.setEnabled(false);
            return count;
        }
        else {
            if (checkBox.isChecked()) {
                count -= 1;

                return count;
            } else {
                if (count > 0) {
                    count += 1;
                } else {

                }
                return count;
            }
        }
    }

}
