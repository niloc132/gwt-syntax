package com.colinalworth.gwt.calc.client;

import com.colinalworth.gwt.calc.shared.Calc;
import com.colinalworth.gwt.calc.shared.ParseException;
import com.colinalworth.gwt.calc.shared.TokenMgrError;
import elemental2.dom.Document;
import elemental2.dom.Element;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.KeyboardEvent;
import jsinterop.annotations.JsType;

import java.io.StringReader;

import static elemental2.dom.DomGlobal.document;
import static elemental2.dom.DomGlobal.window;

@JsType
public class SampleParser {
  private HTMLDivElement panel;

  public void onModuleLoad() {
    panel = (HTMLDivElement) document.createElement("div");

    final HTMLInputElement entry = (HTMLInputElement) document.createElement("input");
    entry.type = "text";
    document.body.append(panel, entry);

    entry.onkeydown = e -> {
      KeyboardEvent keyboardEvent = (KeyboardEvent) e;

      if (keyboardEvent.code.equals("Enter")) {
        process(entry.value);
        entry.value = "";
        entry.scrollIntoView();
        e.preventDefault();
      }

      return null;
    };
  }

  private void process(String input) {

    Calc calc = new Calc(new StringReader(input + "\n"));
    String output;
    try {
      output = calc.expr() + "";
    } catch (ParseException ex) {
      output = ex.getMessage();
    } catch (TokenMgrError ex) {
      output = ex.getMessage();
    } catch (Exception ex) {
      window.alert(ex.getMessage());
      return;
    }

    Element br = document.createElement("br");
    panel.append(
            Element.AppendNodesUnionType.of(input),
            Element.AppendNodesUnionType.of(document.createElement("br")),
            Element.AppendNodesUnionType.of(String.valueOf(output)),
            Element.AppendNodesUnionType.of(document.createElement("br"))
    );

  }
}
