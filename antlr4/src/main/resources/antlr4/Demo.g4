grammar Demo;

file : NL+ ;
STUFF : ~'\n'+ -> skip ;
NL : '\n' ;