package com.example.readnpass.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.readnpass.R;
import com.example.readnpass.ViewModel.BookPhotoViewModel;
import com.example.readnpass.ViewModel.BookViewModel;

import java.util.List;

public class BookDetailViewPagerAdapter  extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<BookPhotoViewModel> bookPhotoViewModel;

    public BookDetailViewPagerAdapter(Context context, List<BookPhotoViewModel> bookPhotoViewModel) {
        this.context = context;
        this.bookPhotoViewModel = bookPhotoViewModel;
    }

    @Override
    public int getCount() {
        return bookPhotoViewModel.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.book_detail_item, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        Glide.with(context).load(bookPhotoViewModel.get(position).getBookPhotoUrl()).into(imageView);



        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}
