package io.github.rahsyarigami.infonunukan.util.decoration;

import android.content.Context;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AutoFitGridLayoutManager extends GridLayoutManager {
    private int columnWidth;
    private boolean columnWidthChanged = true;

    public AutoFitGridLayoutManager(Context context, int columnWidth) {
        super(context, 2);
        setColumnWidth(columnWidth);
    }

    private void setColumnWidth(int newColumWidth) {
        if (newColumWidth > 0 && newColumWidth != columnWidth) {
            columnWidth = newColumWidth;
            columnWidthChanged = true;
        }
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (columnWidthChanged && columnWidth > 0) {
            int totalSpace;
            if (getOrientation() == VERTICAL) {
                totalSpace = getWidth() - getPaddingRight() - getPaddingLeft();
            } else {
                totalSpace = getHeight() - getPaddingTop() - getPaddingBottom();
            }
            int spanCount = Math.max(2, totalSpace / columnWidth);
            setSpanCount(spanCount);
            columnWidthChanged = false;


        }
        super.onLayoutChildren(recycler, state);
    }
}
