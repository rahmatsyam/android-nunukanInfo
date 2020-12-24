package io.github.rahsyarigami.infonunukan.ui.main;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.denzcoskun.imageslider.constants.ScaleTypes;

import java.util.List;

import io.github.rahsyarigami.infonunukan.data.local.RepoLocal;
import io.github.rahsyarigami.infonunukan.data.model.ItemTentang;
import io.github.rahsyarigami.infonunukan.databinding.FragmentHomeBinding;
import io.github.rahsyarigami.infonunukan.databinding.LayoutRecylerviewBinding;
import io.github.rahsyarigami.infonunukan.ui.adapter.TentangNunukanAdapter;
import io.github.rahsyarigami.infonunukan.ui.base.BaseFragment;

public class HomeFragment extends BaseFragment implements iMainView {

    public static final String FIRST_FRAGMENT = "first_fragment";

    private FragmentHomeBinding binding;
    private LayoutRecylerviewBinding rvBinding;

    private TentangNunukanAdapter adapter;

    private HomePresenter presenter;

    private List<ItemTentang> aboutList;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initEvents() {
        rvBinding = binding.rvAboutNunukan;

        presenter = new HomePresenter(this);
        presenter.onCreateView();
        presenter.loadData();
    }

    @Override
    public void displayData(List<ItemTentang> list) {
        this.aboutList = list;
        adapter = new TentangNunukanAdapter(aboutList, getActivity());
        rvBinding.recyclerview.setAdapter(adapter);
    }

    @Override
    public void setUpView() {
        binding.imageSlider.setImageList(RepoLocal.getSlideModel(), ScaleTypes.FIT);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvBinding.recyclerview.setLayoutManager(layoutManager);
        rvBinding.recyclerview.setHasFixedSize(true);

    }


}