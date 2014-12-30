package com.example.anubhav.testcam.imagemanipulators;

import android.os.Environment;

import com.example.anubhav.testcam.constants.Constants;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Anubhav on 30-12-2014.
 */
public class FileOperations {
    private File storageDirectory;

    private File file;

    private String getImageFileName()
    {
        StringBuilder builder = new StringBuilder();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        builder.append("JPEG");
        builder.append(Constants.AppName);
        builder.append(timeStamp);
        builder.append(".jpg");
        return builder.toString();
    }

    public File GetImageFile(){
        storageDirectory = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File imageFolder = new File(storageDirectory, Constants.AppName);
        if (!imageFolder.exists()){
            Boolean result = imageFolder.mkdir();
            if (!result){
                throw new IllegalStateException();
            }
        }
        String filename = getImageFileName();
        file = new File(imageFolder, filename);
        return file;
    }
}
