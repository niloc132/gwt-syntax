package com.colinalworth.gwt.calc.client;

import com.colinalworth.gwt.calc.shared.Calc;
import com.colinalworth.gwt.calc.shared.ParseException;
import com.colinalworth.gwt.calc.shared.TokenMgrError;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

import java.io.StringReader;

public class SampleParser implements EntryPoint {
  private FlowPanel panel;
  @Override
  public void onModuleLoad() {
    panel = new FlowPanel();

    final TextBox entry = new TextBox();
    panel.add(entry);
    RootPanel.get().add(panel);

    entry.addKeyDownHandler(new KeyDownHandler() {
      @Override
      public void onKeyDown(KeyDownEvent event) {
        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
          process(entry.getValue());
          entry.setValue("");
          entry.getElement().scrollIntoView();
          event.preventDefault();
        }
      }
    });
  }


  interface Template extends SafeHtmlTemplates {
    @SafeHtmlTemplates.Template("<div><div class='{2}'>{0}</div><div class='{3}'>{1}</div></div>")
    SafeHtml render(String input, String output, String inputStyleName, String outputStyleName);
  }
  private void process(String input) {
    Template template = GWT.create(Template.class);

    Calc calc = new Calc(new StringReader(input + "\n"));
    String output;
    try {
      output = calc.expr() + "";
    } catch (ParseException ex) {
      output = ex.getMessage();
    } catch (TokenMgrError ex) {
      output = ex.getMessage();
    } catch (Exception ex) {
      Window.alert(ex.getMessage());
      return;
    }

    panel.insert(new HTML(template.render(input, output, "", "")), panel.getWidgetCount() - 1);

  }
}
