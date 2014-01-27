## JavaCC in GWT

This repository is a quick set of examples of how to get going with JavaCC in a GWT application. Basic inspiration
came from http://cs.jsu.edu/wordpress/?p=72 and http://cs.jsu.edu/wordpress/?p=100, though since then GWT has solved
one of the stumbling blocks mentioned, and I'm leaning on work done by https://github.com/restlet/restlet-framework-java
and for the other (under the Apache2 license).

Slides from the GWT Community Hangout topic on this https://docs.google.com/presentation/d/1pFWFe5SBVf_B06V8wEteaxQ2RO3wHaf51m7nPZ0VRAE/edit?usp=sharing

## Repo summary

There are three interesting branches here, following a quick talk I gave as part of a GWT Community Hangout, starting
with two sample grammars from http://www.cs.rit.edu/~ats/java/html/skript/8_JavaCC.htmld/, and ending with a sample
Java syntax highlighter.

Check out the branches from git, or click the links to download the source:

 * [calc0](https://github.com/niloc132/gwt-syntax/archive/calc0.zip), based mostly on
 http://www.cs.rit.edu/~ats/java/code/programs/javacc/Calc0.jj, is a simple webapp that lets you type in simple math
 expressions and see if they are valid or not, based on the rules of the grammar.

 * [calc2](https://github.com/niloc132/gwt-syntax/archive/calc2.zip), based mostly on
 http://www.cs.rit.edu/~ats/java/code/programs/javacc/Calc2.jj, is a slightly more useful webapp that acts as a
 calculator, based on the expressions entered (skipped exercise 1 with error handling, removed that from this sample)

 * [java](https://github.com/niloc132/gwt-syntax/archive/java.zip), is a simple (yet slightly buggy) take at the
 interesting keywords in Java, where the parser wraps keywords or other special tokens in html tags so that they can be
 syntax highlighted easily. This grammar is compiled in two forms, a basic webapp that lets you toggle between a
 textarea and highlighted code, and a GWT library compiled to JS, suitable for providing syntax highlighting to other
 JS apps.


## Running example apps

 * [GwtCalc0Parser](http://niloc132.github.io/gwt-syntax/GwtCalc0Parser/) app - type in simple arithmetic expressions and get feedback if they are accepted or not
 * [GwtCalc2Parser](http://niloc132.github.io/gwt-syntax/GwtCalc2Parser/) app - type in simple arithmetic expressions and see them evaluated (or get an error message)
 * [GwtJavaParser](http://niloc132.github.io/gwt-syntax/GwtJavaParser/) app - simple Java syntax highlighter (though it doesn't like `_`s in variable or class names...)
 * [java2html](http://niloc132.github.io/gwt-syntax/java2html/java2html.nocache.js) JS file - invoke `java2html(javaSource)` get a syntax-highlighted html string (provide your own css).
 This sample app can be recompiled to include its own CSS.
