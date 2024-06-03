grammar Demo;


row: field (',' field)*;

field: INT;

INT: [0-9];


TEST: 'a' | 'b';


WS  :   [ \t]+ -> skip ; // toss out whitespace