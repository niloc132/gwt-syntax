## JavaCC in GWT

This repository is a quick set of examples of how to get going with JavaCC in a GWT application. Basic inspiration
came from http://cs.jsu.edu/wordpress/?p=72 and http://cs.jsu.edu/wordpress/?p=100, though since then GWT has solved
one of the stumbling blocks mentioned, and I'm leaning on work done by https://github.com/restlet/restlet-framework-java
and for the other (under the Apache2 license).

## Repo summary

There are three interesting branches here, following a quick talk I gave as part of a GWT Community Hangout, starting
with two sample grammars from http://www.cs.rit.edu/~ats/java/html/skript/8_JavaCC.htmld/, and ending with a sample
Java syntax highlighter.

 * calc0, based mostly on http://www.cs.rit.edu/~ats/java/code/programs/javacc/Calc0.jj, is a simple webapp that lets
 you type in simple math expressions and see if they are valid or not, based on the rules of the grammar.

 * calc2, based mostly on http://www.cs.rit.edu/~ats/java/code/programs/javacc/Calc2.jj, is a slightly more useful
 webapp that acts as a calculator, based on the expressions entered

 * java, is a simple (yet slightly buggy) take at the interesting keywords in Java, where the parser wraps keywords or
 other special tokens in html tags so that they can be syntax highlighted easily. This grammar is compiled in two forms,
 a basic webapp that lets you toggle between a textarea and highlighted code, and a GWT library compiled to JS, suitable
 for providing syntax highlighting to other JS apps.