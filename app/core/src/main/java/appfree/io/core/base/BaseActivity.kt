package appfree.io.core.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T: ViewDataBinding>: AppCompatActivity() {

    lateinit var binding: T

    open fun layoutResId(): Int = -1

    abstract fun viewDidLoad()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (layoutResId()!=-1) {
            binding = DataBindingUtil.setContentView<T>(this, layoutResId())
            binding.lifecycleOwner = this
        }
        viewDidLoad()
    }
}