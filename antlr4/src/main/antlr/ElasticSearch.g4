grammar ElasticSearch;



// 条件: 表达式, 多个表达式通过逻辑运算符连接
condition: condition ('and'|'or') condition
    | '(' condition ')'
    | Id ('='|'!='|'like') Value
    | Value
    ;

// identifier '"' ('\\"'|~["])* '"' ;
Value: '"' ('\\"'|~["])* '"' ;
Id  :   [a-zA-Z0-9_.]+;      // match identifiers <label id="code.tour.expr.3"/>
WS  :   [ \t]+ -> skip ; // toss out whitespace