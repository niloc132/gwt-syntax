package com.colinalworth.gwt.java.client;

import com.colinalworth.gwt.java.shared.JavaParser;
import com.colinalworth.gwt.java.shared.ParseException;
import com.google.gwt.core.client.EntryPoint;

import java.io.StringReader;

public class ExportedJavaToHtml implements EntryPoint {
  @Override
  public native void onModuleLoad() /*-{
      $wnd.java2html = $entry(@com.colinalworth.gwt.java.client.ExportedJavaToHtml::parse(Ljava/lang/String;));
  }-*/;
  public static String parse(String java) throws ParseException {
    //comment this out to provide styles outside the compiled js
//    GWT.<CodeStyles>create(CodeStyles.class).code().ensureInjected();
    return new JavaParser(new StringReader(java)).compilationUnit().asString();
  }
}
