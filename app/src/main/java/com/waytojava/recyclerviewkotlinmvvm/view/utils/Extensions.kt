package com.waytojava.recyclerviewkotlinmvvm.view.utils

import android.content.Context
import android.widget.Toast

/**
 * Created by Manish Kumar on 12/2/2018
 */

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}