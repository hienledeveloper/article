package appfree.io.core.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<_Data, _ViewHolder : BaseViewHolder<_Data>> :
    RecyclerView.Adapter<_ViewHolder>() {

    private var onScrollToBottomListener: (() -> Unit)? = null
    private var items: ArrayList<_Data> = ArrayList<_Data>()
    private var iTempPositionOfLoadMore = -1

    fun pushAll(data: List<_Data>?) {
        data?.let {
            val oldPosition = items.size
            items.addAll(data)
            val count = items.size
            notifyItemRangeInserted(oldPosition, count)
        }
    }

    fun push(t: _Data?) {
        t?.let {
            val oldPosition = items.size
            items.add(t)
            val count = items.size
            notifyItemRangeInserted(oldPosition, count)
        }
    }

    fun fetch(data: List<_Data>?) {
        data?.let {
            items.clear()
            items.addAll(data)
            notifyDataSetChanged()
        }
    }

    fun clear(position: Int, data: List<_Data>?) {
        data?.let {
            val oldSize = items.size
            val newSize = data.size
            items.clear()
            items.addAll(data)
            if (oldSize > newSize) {
                notifyItemRangeRemoved(position, oldSize - newSize)
            } else {
                notifyDataSetChanged()
            }
        }
    }

    open fun clearAll() {
        items.clear() // clear list
        notifyDataSetChanged() // let your adapter know about the changes and reload view.
    }

    fun valueAt(position: Int) = if (position < items.size) items[position] else null

    fun setOnScrollToBottomListener(onScrollToBottomListener: (() -> Unit), iPositionFromBottom: Int) {
        this.onScrollToBottomListener = onScrollToBottomListener
        this.iTempPositionOfLoadMore = iPositionFromBottom
    }

    abstract fun getViewHolder(binding: ViewDataBinding): _ViewHolder

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): _ViewHolder {
        val binding: ViewDataBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), viewType, parent, false)
        return getViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: _ViewHolder, position: Int) {

        items.let {
            val t = it[position]
            holder.bind(t)
        }
    }

    override fun onViewAttachedToWindow(holder: _ViewHolder) {
        super.onViewAttachedToWindow(holder)
        if (holder.adapterPosition > (items.size - iTempPositionOfLoadMore)) {
            // scroll to near bottom
            onScrollToBottomListener?.invoke()
        }

        holder.onAppear()
    }

    override fun onViewDetachedFromWindow(holder: _ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.onDisappear()
    }
}