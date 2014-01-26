package com.colinalworth.gwt.java.client;

import com.colinalworth.gwt.java.shared.JavaParser;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;

import java.io.StringReader;

public class SampleJavaParser implements EntryPoint {

  private CodeStyles bundle = GWT.create(CodeStyles.class);
  @Override
  public void onModuleLoad() {
    reset("", 0);
  }

  public void reset(String content, int offset) {
    bundle.formatter().ensureInjected();
    final TextArea code = new TextArea();
    code.addStyleName(bundle.formatter().input());
    code.setValue(content);

    Button format = new Button("Format", new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        format(code.getValue(), code.getElement().getScrollTop());
      }
    });
    format.addStyleName(bundle.formatter().button());

    RootPanel.get().clear();
    RootPanel.get().add(code);
    RootPanel.get().add(format);

    code.getElement().setScrollTop(offset);
  }

  public void format(final String java, int offset) {
    final SafeHtml content;
    try {
      content = new JavaParser(new StringReader(java)).compilationUnit();
    } catch (Exception ex) {
      Window.alert(ex.getMessage());
      return;
    }
    RootPanel.get().clear();

    bundle.code().ensureInjected();

    final HTML output = new HTML(content);
    output.addStyleName(bundle.formatter().output());

    Button startOver = new Button("Start over", new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        reset(java, output.getElement().getScrollTop());
      }
    });
    startOver.addStyleName(bundle.formatter().button());

    RootPanel.get().add(output);
    RootPanel.get().add(startOver);

    output.getElement().setScrollTop(offset);
  }
}
