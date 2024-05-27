package fisikes.calc;

import fisikes.antlr4.LabeledExprBaseVisitor;
import fisikes.antlr4.LabeledExprParser;

import java.util.HashMap;
import java.util.Map;

public class EvalVisitor extends LabeledExprBaseVisitor<Integer> {

    /**
     * "memory" for our calculator; variable/value pairs go here
     */
    Map<String, Integer> memory = new HashMap<>();

    @Override
    public Integer visitProg(LabeledExprParser.ProgContext ctx) {
        return super.visitProg(ctx);
    }


    /**
     * expr NEWLINE
     */
    @Override
    public Integer visitPrintExpr(LabeledExprParser.PrintExprContext ctx) {

        Integer value = visit(ctx.expr()); // evaluate the expr child
        System.out.println(value); // print the result
        return 0; // return dummy value
    }


    /**
     * ID '=' expr NEWLINE         # assign
     */
    @Override
    public Integer visitAssign(LabeledExprParser.AssignContext ctx) {
        String id = ctx.ID().getText();// id is left-hand side of '='
        int value = visit(ctx.expr()); // compute value of expression on right
        memory.put(id, value); // store it in our memory
        return value;
    }

    @Override
    public Integer visitBlank(LabeledExprParser.BlankContext ctx) {

        return super.visitBlank(ctx);
    }

    /**
     * '(' expr ')'
     */
    @Override
    public Integer visitParens(LabeledExprParser.ParensContext ctx) {
        return visit(ctx.expr());
    }

    /**
     * expr op=('*'|'/') expr
     */
    @Override
    public Integer visitMulDiv(LabeledExprParser.MulDivContext ctx) {
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        if (ctx.op.getType() == LabeledExprParser.MUL) {
            return left * right;
        }
        return left / right;
    }

    /**
     * expr op=('+'|'-') expr
     */
    @Override
    public Integer visitAddSub(LabeledExprParser.AddSubContext ctx) {
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        if (ctx.op.getType() == LabeledExprParser.ADD) return left + right;
        return left - right;
    }

    // ID
    @Override
    public Integer visitId(LabeledExprParser.IdContext ctx) {
        String id = ctx.ID().getText();
        if (memory.containsKey(id)) {
            return memory.get(id);
        }
        return 0;
    }

    // INT
    @Override
    public Integer visitInt(LabeledExprParser.IntContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }
}
