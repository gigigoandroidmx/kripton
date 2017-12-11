/* Copyright (c) 2016 Gigigo Android Development Team México
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package gigigo.com.kmvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Defines the Fragment with base functionality, must be inherited from {@link Fragment}
 *
 * @param <V> view interface, must be inherited from {@link IView}
 * @param <P> presenter interface, must be inherited from {@link IPresenter}
 *
 * @author Juan Godínez Vera - 28/04/2017
 * @version 2.0.0
 * @since 1.0.0
 */
public abstract class KFragment<V extends IView, P extends IPresenter<V>> extends Fragment {

    protected P presenter;
    protected Context context;
    protected KNavigationFragmentListener navigationFragmentListener;
    protected View mViewRoot;

    @LayoutRes
    protected abstract int getLayoutResourceId();
    protected abstract void onInitialize();
    protected abstract void onBindView(View root);
    protected abstract void onUnbindView();
    protected abstract P createPresenter();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mViewRoot = inflater.inflate(getLayoutResourceId(), container, false);
        onBindView(mViewRoot);
        return mViewRoot;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getBaseActivity() != null){
            navigationFragmentListener = getBaseActivity().getNavigationFragmentListener();
        }

        if(presenter == null)
            presenter = createPresenter();

        if(presenter == null)
            throw new NullPointerException("The presenter must not be null.");

        if(!(this instanceof IView))
            throw new ClassCastException("The fragment must implement IView. This is required by the presenter.");

        presenter.attachView((V) this);
    }

    //region Handling Lifecycle Fragment

    // -------------------------------------------------------
    // ----------------------- Created -----------------------
    // -------------------------------------------------------
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onInitialize();
    }

    // -------------------------------------------------------
    // ---------------------- Destroyed ----------------------
    // -------------------------------------------------------
    @Override
    public void onDestroy() {
        super.onDestroy();

        if(presenter != null)
            presenter.detachView();

        onUnbindView();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.context = null;
    }

    //endregion

    public KActivity getBaseActivity() {
        if(this.context instanceof KActivity) {
            return (KActivity)this.context;
        }

        return null;
    }

    public KNavigationManager getNavigationManager(){
        return getBaseActivity() != null
                ? (getBaseActivity()).getNavigationManager()
                : null;
    }

    public int getFragmentIdContainer(){
        return getBaseActivity() != null
                ? (getBaseActivity()).getIdFragmentContainer()
                : null;
    }

    public Context getFragmentContext() {
        return this.context;
    }
}