package com.h7d1w0

import java.text.SimpleDateFormat
import java.util.TimeZone



object TestPlace {

  def main(args: Array[String]):Unit = {
    val unixDtm = 1462165434162L
    val isoFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    isoFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"))
//    isoFormat.setTimeZone(TimeZone.getTimeZone("GMT"))
    val timeStr = isoFormat.format(unixDtm)
    println(timeStr)
//    println(pageOriginal)

  }
}