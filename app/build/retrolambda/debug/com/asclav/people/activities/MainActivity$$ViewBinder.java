// Generated code from Butter Knife. Do not modify!
package com.asclav.people.activities;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainActivity$$ViewBinder<T extends com.asclav.people.activities.MainActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492969, "field 'mToolbar'");
    target.mToolbar = finder.castView(view, 2131492969, "field 'mToolbar'");
  }

  @Override public void unbind(T target) {
    target.mToolbar = null;
  }
}
