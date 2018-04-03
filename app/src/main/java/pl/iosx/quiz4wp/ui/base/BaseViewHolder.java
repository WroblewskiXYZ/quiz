package pl.iosx.quiz4wp.ui.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder{

    int curPosition;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    protected abstract void clear();

    public void onBind(int position)
    {
        curPosition = position;
        clear();
    }
}
