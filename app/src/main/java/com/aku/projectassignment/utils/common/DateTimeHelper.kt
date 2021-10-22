package com.aku.projectassignment.utils.common

import java.text.SimpleDateFormat
import java.util.*

class DateTimeHelper {

    companion object{

     fun convertLongToDate(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("dd-MMM-yyyy")
        return format.format(date)
     }
    }
}