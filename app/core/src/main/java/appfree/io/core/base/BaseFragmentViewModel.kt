package appfree.io.core.base

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.reflect.KClass

abstract class BaseFragmentViewModel<T: ViewDataBinding, VM: ViewModel>(clazz : KClass<VM>): BaseFragment<T>() {

    val viewModel: VM by viewModel(clazz)

}