package io.github.rahsyarigami.infonunukan.ui.base;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBinding;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

import io.github.rahsyarigami.infonunukan.R;

public abstract class BaseDialogFragment extends DialogFragment {

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
        initStyle();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        try {
            ViewBinding binding = (ViewBinding) inflate.invoke(null, inflater, container, false);
            bindingField.set(this, binding);
            if (binding != null) {
                return binding.getRoot();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getDialog().getWindow())
                    .getAttributes()
                    .windowAnimations = R.style.DialogAnimation;
        }

        initEvents();

    }

    protected abstract void initEvents();

    protected abstract  void initStyle();

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
