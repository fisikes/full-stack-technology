grammar ElasticSearch;

// 条件: 表达式, 多个表达式通过逻辑运算符连接
condition: condition ('&'|'|') condition
    | '(' condition ')'
    | id ('='|'!='|'like') STRING
    | (TEXT|STRING)
    ;

Equels: '=';

NotEquels: '!=';

// identifier '"' ('\\"'|~["])* '"' ;
TEXT: ~[\n\r"]+;
STRING: '"' ('\\"'|~["])* '"' ;
id: ID_SUB ('.' ID_SUB)*;
ID_SUB : ID_LETTER (ID_LETTER | DIGIT)* ; // From C language fragment
fragment ID_LETTER : 'a'..'z'|'A'..'Z'|'_' ;
fragment DIGIT : '0'..'9' ;

WS : (' '|'\t'|'\r'|'\n')+ -> skip ;
LINE_COMMENT : '//' .*? '\r'? '\n' -> skip ;
COMMENT : '/*' .*? '*/' -> skip ;