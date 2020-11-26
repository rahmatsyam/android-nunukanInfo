package io.github.rahsyarigami.infonunukan.util.decoration;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import android.util.TypedValue;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class CustomDividerItemDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS = new int[]{
            android.R.attr.listDivider
    };

    private static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    private static final  int VERTICAL_LIST = LinearLayoutManager.VERTICAL;

    private final Drawable divider;
    private int mOrientation;
    private final Context context;
    private final int margin;

    public CustomDividerItemDecoration(Context context, int orientation, int margin){
        this.context = context;
        this.margin = margin;
        final TypedArray a = context.obtainStyledAttributes(ATTRS);
        divider = a.getDrawable(0);
        a.recycle();
        setOrientation(orientation);
    }

    private void setOrientation(int orientation){
        if(orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST){
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation = orientation;
    }

    @Override
    public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView parent, @NonNull RecyclerView.State state){
        if(mOrientation == VERTICAL_LIST){
            drawVertical(canvas,parent);
        } else {
            drawHorizontal(canvas,parent);
        }
    }

    private void drawVertical(Canvas canvas, RecyclerView parent){
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();

        final int childCount = parent.getChildCount();
        for(int i = 0; i < childCount; i++){
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + divider.getIntrinsicHeight();
            divider.setBounds(left + dpToPx(margin), top, right - dpToPx(margin),bottom);
            divider.draw(canvas);
        }
    }

    private void drawHorizontal(Canvas canvas, RecyclerView parent){
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight() - parent.getPaddingBottom();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++){
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams)child.getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            final int right = left + divider.getIntrinsicHeight();
            divider.setBounds(left, top + dpToPx(margin), right, bottom - dpToPx(margin));
            divider.draw(canvas);
        }


    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state){
        if(mOrientation == VERTICAL_LIST){
            outRect.set(0, 0, 0, divider.getIntrinsicHeight());
        } else {
            outRect.set(0, 0, divider.getIntrinsicWidth(), 0);
        }
    }

    private int dpToPx(int dp){
        Resources resources = context.getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics()));
    }



}
