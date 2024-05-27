grammar Expr;


/** In English,
 a program in our expression language is a sequence of statements terminated by newlines.
 A statement is either an expression, an assignment, or a blank line. */

/** the start rule; begin parsing here */


// Rules starting with a lowercase letter comprise the parser rules.
/*
解析规则（Parser Rules）：
解析规则用于定义如何将词法分析器生成的标记（tokens）组合成更高层次的结构，通常是语法树的一部分。解析规则描述了编程语言或数据格式的语法结构。
作用: 解析整个输入序列，并将其组织成语法结构。例如，一个解析规则可以定义一个表达式（expression）如何由操作符和操作数组合而成。
*/

// Rules starting with an uppercase letter comprise the lexical (token) rules.
/*
词法规则（Lexical (Token) Rules）：
词法规则用于定义如何从输入字符串中识别和提取基本的词法单位（标记），即tokens。每个词法规则描述一种特定类型的标记，如关键字、标识符、运算符、数字等。

规则命名：词法规则的名称以大写字母开头。通过这种命名约定，可以直观地区分词法规则和解析规则。
作用：词法规则用于扫描输入字符串，并根据定义的模式生成标记。例如，词法规则可以定义如何识别整数、标识符和运算符。
*/
prog: stat+ ;

stat: expr NEWLINE
    | ID '=' expr NEWLINE
    | NEWLINE
    ;

expr: expr ('*'|'/') expr
    | expr ('+'|'-') expr
    | INT
    | ID
    | '(' expr ')'
    ;

ID  :   [a-zA-Z]+ ;      // match identifiers <label id="code.tour.expr.3"/>
INT :   [0-9]+ ;         // match integers
NEWLINE:'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
WS  :   [ \t]+ -> skip ; // toss out whitespace