package com.beaven.daggerstudy.widget.dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.beaven.daggerstudy.R;

/**
 * @author : Beaven
 * @date : 2017-12-19
 */

public class DialogLoading extends DialogFragment {

  public static DialogLoading dialogLoading() {
    return new DialogLoading();
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.dialog_loading, container);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
  }

  @Override
  public void onResume() {
    Window window = getDialog().getWindow();
    if (window != null) {
      window.setLayout(400, 400);
    }
    super.onResume();
  }

  public void show(FragmentActivity activity) {
    FragmentManager manager = activity.getSupportFragmentManager();
    if (manager != null) {
      show(manager, "dialog_loading");
    }
  }
}
