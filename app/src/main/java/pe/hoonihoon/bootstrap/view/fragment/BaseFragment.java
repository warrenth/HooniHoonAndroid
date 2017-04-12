package pe.hoonihoon.bootstrap.view.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by 152317 on 2017-04-12.
 */

public abstract class BaseFragment extends Fragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();

    }

    protected abstract void initView(View contentView);

    protected abstract void initData();
}
