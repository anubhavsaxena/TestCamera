package com.example.anubhav.testcam;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;

/**
 * Created by Anubhav on 27-12-2014.
 */
public class AutoFitTextureView extends TextureView {
    private int widthComponent;
    private int heightComponent;

    public AutoFitTextureView(Context cont){
        this(cont, null);
    }

    public AutoFitTextureView(Context cont, AttributeSet attr){
        this(cont, attr, 0);
    }

    public AutoFitTextureView(Context cont, AttributeSet attr, int defStyle){
        super(cont, attr, defStyle);
    }

    public void setAspectRatio(int width, int height){
        if (width<0 || height<0){
            throw new IllegalArgumentException();
        }

        widthComponent = width;
        heightComponent=height;

        //called when something has changed which invalidates the layout of the view
        requestLayout();
    }

    //This method is invoked by measure(int, int) and should be overriden by subclasses to provide accurate and efficient measurement of their contents.
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        if (widthComponent==0 || heightComponent==0){
            setMeasuredDimension(width, height);
        }else if(width<height*widthComponent/heightComponent){
            setMeasuredDimension(width, width*heightComponent/widthComponent);
        }else{
            setMeasuredDimension(height*widthComponent/heightComponent, height);
        }
    }
}
