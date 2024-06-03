## 功能目标

简化es查询

- [ ] 提示功能及错误提示;
- [ ] 查询和聚合;
- [ ] 格式化

## 学习资料

- The Definitive ANTLR 4 Reference, 2nd Edition
- https://github.com/antlr/grammars-v4/tree/master/sql/mysql/Oracle

## common language patterns with ANTLR Grammars

### Pattern: Sequence

```antlrv4
grammar SequenceDemos;
// csv数据通过逗号分割 
row: field (',' field)*;

// 使用分号分割的java语句
stats: (stat ';')*;

// java中调用参数传参
exprList: expr (',' expr)*;

// 特殊例子: 表达zero-or-one sequence, 例如java中变量声明
stats: ('='expr)?;

// antlr的metalanguage也用到了sequence patterns
rule: ID ':' alternative ('|' alternative)*;

```

### Pattern: Choice(Alternative)

use "|" as the "or" operator.

```antlrv4
grammar ChoiceDemos;

// 例如csv中的field rule支持Int和String两种类型
field: INT | STRING;
```

### Pattern: Token Dependency

Token Dependency描述了不同token之间的依赖关系。例如，一个token的识别可能依赖于先前识别的token。具体来说：

- 相邻token之间的依赖：一个token的模式可能依赖于其前后的token。例如，在解析有嵌套结构的语言时，左括号和右括号之间的匹配就是一种依赖关系。

```antlrv4
grammar JSON;

object
    : '{' pair (',' pair)* '}'
    | '{' '}' // empty object
    ;
    
pair: STRING ':' value;
```

- 上下文敏感的依赖：某些token的识别可能依赖于其上下文。例如，在SQL语句中，关键字SELECT和标识符之间可能存在依赖关系。


### Pattern: Nested Phrase

```antlrv4
grammar Java;

// 例如while循环
stat: 'while' '(' ')' stat
    |  
```


## Lexical Structures
