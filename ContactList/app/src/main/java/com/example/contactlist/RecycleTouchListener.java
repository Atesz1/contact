package com.example.contactlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;


public class RecycleTouchListener implements RecyclerView.OnItemTouchListener {
    private OnItemClickListener mListener;

    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        View childview = view.findChildViewUnder(e.getX(), e.getY());
        if (childview != null && mListener != null && mGestureDetector.onTouchEvent(e)){
            mListener.onItemClick(childview, view.getChildAdapterPosition(childview));
            return true;
        }
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {

    }

    public interface OnItemClickListener{
            public void onItemClick(View view, int position);
            public void onLongItemClick(View view, int position);
    }

    GestureDetector mGestureDetector;

    public RecycleTouchListener(Context context,
                                final RecyclerView recyclerView,
                                OnItemClickListener listener){
        mListener = listener;
        mGestureDetector = new GestureDetector(context,
               new GestureDetector.SimpleOnGestureListener(){

                   @Override
                   public boolean onSingleTapUp(MotionEvent e) {
                       return true; }

                   @Override
                   public void onLongPress(MotionEvent e){
                       View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                       if (child != null && mListener != null) {
                           mListener.onLongItemClick(child, recyclerView.getChildAdapterPosition(child));
                       }
                   }

               });


    }
}
