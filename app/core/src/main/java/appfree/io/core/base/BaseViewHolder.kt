package appfree.io.core.base

import android.os.Handler
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(data: T)

    open fun onAppear(){}

    open fun onDisappear(){}


}