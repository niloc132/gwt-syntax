package com.colinalworth.gwt.java.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;

public interface CodeStyles extends ClientBundle {
  @NotStrict
  CssResource code();

  FormatterStyles formatter();

  public interface FormatterStyles extends CssResource {
    String input();

    String output();

    String button();
  }
}
