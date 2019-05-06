package com.will_russell.myfeed

import java.util.ArrayList

class Story(var title: String?, var content: String?) {
    companion object {

        var stories: List<Story> = ArrayList()
    }
}
