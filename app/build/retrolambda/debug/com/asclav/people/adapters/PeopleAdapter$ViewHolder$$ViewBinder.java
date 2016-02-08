// Generated code from Butter Knife. Do not modify!
package com.asclav.people.adapters;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class PeopleAdapter$ViewHolder$$ViewBinder<T extends com.asclav.people.adapters.PeopleAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492994, "field 'mUserName'");
    target.mUserName = finder.castView(view, 2131492994, "field 'mUserName'");
    view = finder.findRequiredView(source, 2131492993, "field 'mUserPic'");
    target.mUserPic = finder.castView(view, 2131492993, "field 'mUserPic'");
  }

  @Override public void unbind(T target) {
    target.mUserName = null;
    target.mUserPic = null;
  }
}
