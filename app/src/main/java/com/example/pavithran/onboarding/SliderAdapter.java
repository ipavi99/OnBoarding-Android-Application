package com.example.pavithran.onboarding;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.zip.Inflater;

public class SliderAdapter extends PagerAdapter {
    @Override
    public int getCount() {
        return slide_headings.length;
    }
    Context context;
    LayoutInflater layoutInflater;
    public SliderAdapter(Context context){
        this.context=context;
    }

    //Arrays
    public int[] slide_images={
            R.drawable.eat_icon,
            R.drawable.eat_icon2,
            R.drawable.eat_icon3
};
    public String[] slide_headings={
            "EAT",
            "SLEEP",
            "CODE"
    };

    public String[] slide_desc={
            "What does PAGE 1 do",
            "What does PAGE 2 do",
            "What does PAGE 3 do"
    };



    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==(RelativeLayout)o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView=(ImageView) view.findViewById(R.id.slide_image);
        TextView slideheading=view.findViewById(R.id.slide_heading);
        TextView slidedesc = view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideheading.setText(slide_headings[position]);
        slidedesc.setText(slide_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);
    }
}
