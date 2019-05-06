package com.will_russell.myfeed

import android.graphics.Bitmap
import java.util.ArrayList

class Story(var title: String?, var content: String?, var images: ArrayList<Bitmap>?) {
    companion object {
        var stories: List<Story> = ArrayList()
    }
}
