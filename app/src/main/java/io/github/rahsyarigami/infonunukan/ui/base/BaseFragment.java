package io.github.rahsyarigami.infonunukan.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class BaseFragment extends Fragment {

    private Field bindingField;
    private Method inflate;

    {
        for (Field declaredField : this.getClass().getDeclaredFields()) {
            if (ViewBinding.class.isAssignableFrom(declaredField.getType())) {
                bindingField = declaredField;
                bindingField.setAccessible(true);

                for (Method method : bindingField.getType().getMethods()) {
                    if (method.getGenericParameterTypes().length == 3) {
                        inflate = method;
                        break;
                    }
                }

                break;
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        try {
            ViewBinding binding = (ViewBinding) inflate.invoke(null, inflater, container, false);
            bindingField.set(this, binding);
            assert binding != null;
            return binding.getRoot();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initEvents();
    }

    protected abstract void initEvents();

    @Override
    public void onDestroyView() {

        try {
            bindingField.set(this, null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        super.onDestroyView();
    }


}
