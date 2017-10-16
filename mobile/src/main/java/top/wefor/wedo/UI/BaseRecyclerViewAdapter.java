package top.wefor.wedo.UI;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ice on 15/12/10.
 */
public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter {
    protected Context context;
    protected LayoutInflater inflater;
    protected List<T> mList;
    protected View mRootView;
    protected OnAdapterItemClickListener mOnItemClickListener;

    public BaseRecyclerViewAdapter(Context context, RecyclerView recyclerView) {
        recyclerView.setAdapter(this);
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public BaseRecyclerViewAdapter(Context context, List<T> list) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        mList = list;
    }

    public BaseRecyclerViewAdapter(Context context, List<T> list, RecyclerView recyclerView) {
        recyclerView.setAdapter(this);

        this.context = context;
        inflater = LayoutInflater.from(context);
        mList = list;
//        setAnimation();
    }

    protected abstract int getLayoutRes();

    protected abstract RecyclerView.ViewHolder getViewHolder(View view);

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mRootView = inflater.inflate(getLayoutRes(), parent, false);
        return getViewHolder(mRootView);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setList(List<T> list) {
        mList = list;
        this.notifyDataSetChanged();
    }

    public List<T> getList() {
        return mList;
    }

    public void setOnItemClickListener(OnAdapterItemClickListener onAdapterItemClickListener) {
        mOnItemClickListener = onAdapterItemClickListener;
    }

    public OnAdapterItemClickListener getOnItemClickListener() {
        return mOnItemClickListener;
    }

    public void update(List<T> newList) {
        mList.clear();
        mList.addAll(newList);
        this.notifyDataSetChanged();
    }

    protected String pass(String anyStr) {
        if (anyStr == null)
            anyStr = "";
        return anyStr;
    }

    protected void go(Class clazz) {
        context.startActivity(new Intent(context, clazz));
    }

    public interface OnAdapterItemClickListener {
        void onItemClick(int position);
    }

    // 确保activty或者fragment实现了OnAdapterItemClickListener 接口。BaseRecyclerView...都已经实现了的。
    protected void setItemClick(final RecyclerView.ViewHolder viewHolder) {
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null && viewHolder.getAdapterPosition() != RecyclerView.NO_POSITION)
                    mOnItemClickListener.onItemClick(viewHolder.getAdapterPosition());
            }
        });
    }

}
