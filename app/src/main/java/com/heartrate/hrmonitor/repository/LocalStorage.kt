package com.heartrate.hrmonitor.repository


import android.os.Environment
import com.heartrate.hrmonitor.model.HeartRate
import com.heartrate.hrmonitor.model.TMT
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.sql.DriverManager.println

class LocalStorage{
    companion object {
        fun saveToCsv(data:List<HeartRate>){
            val CSV_HEADER = "timestamp,red"
            var fileWriter: FileWriter? = null
            val fielName : String = System.currentTimeMillis().toString()+"_heart_rate.csv"
            try {
                var f = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                var file = File(f,fielName)
                println("file is exist "+file.exists())
                fileWriter = FileWriter(file)

                fileWriter.append(CSV_HEADER)
                fileWriter.append('\n')

                for (item in data) {
                    fileWriter.append(item.timestampString.toString())
                    fileWriter.append(',')
                    //fileWriter.append(item.img_avg.toString())
                    //fileWriter.append(',')
                    fileWriter.append(item.img_avg.toString())
                    fileWriter.append('\n')
                }

                println("Write CSV successfully!")
            } catch (e: Exception) {
                println("Writing CSV error!")
                e.printStackTrace()
            } finally {
                try {
                    fileWriter!!.flush()
                    fileWriter.close()
                } catch (e: IOException) {
                    println("Flushing/closing error!")
                    e.printStackTrace()
                }
            }
        }

        fun saveToCSVTMT(data:List<TMT>, difficulty:String){
            val CSV_HEADER = "timestamp,value"
            var fileWriter: FileWriter? = null
            val fielName : String = System.currentTimeMillis().toString()+"_tmt_"+difficulty+".csv"
            try {
                var f = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                var file = File(f,fielName)
                println("file is exist "+file.exists())
                fileWriter = FileWriter(file)

                fileWriter.append(CSV_HEADER)
                fileWriter.append('\n')

                for (item in data) {
                    fileWriter.append(item.timestampString.toString())
                    fileWriter.append(',')
                    fileWriter.append(item.value.toString())
                    fileWriter.append('\n')
                }

                println("Write CSV successfully!")
            } catch (e: Exception) {
                println("Writing CSV error!")
                e.printStackTrace()
            } finally {
                try {
                    fileWriter!!.flush()
                    fileWriter.close()
                } catch (e: IOException) {
                    println("Flushing/closing error!")
                    e.printStackTrace()
                }
            }
        }
    }
}