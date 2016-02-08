// Generated code from Butter Knife. Do not modify!
package com.asclav.people.fragments;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainActivityFragment$$ViewBinder<T extends com.asclav.people.fragments.MainActivityFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492979, "field 'mRecyclerView'");
    target.mRecyclerView = finder.castView(view, 2131492979, "field 'mRecyclerView'");
    view = finder.findRequiredView(source, 2131492978, "method 'onButtonClicked'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onButtonClicked();
        }
      });
  }

  @Override public void unbind(T target) {
    target.mRecyclerView = null;
  }
}
