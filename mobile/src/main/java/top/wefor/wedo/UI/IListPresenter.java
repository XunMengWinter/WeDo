package top.wefor.wedo.UI;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created on 16/6/21 09:38.
 *
 * @author ice, GitHub: https://github.com/XunMengWinter
 */
public interface IListPresenter<T> {

    @DrawableRes
    int getEmptyImageRes();

    @StringRes
    int getEmptyTextRes();

    BaseRecyclerViewAdapter<T> getAdapter(ArrayList<T> list, RecyclerView recyclerView);

    void putDataToList(ArrayList<T> list);

    void loadMore();

    void refresh();
}
