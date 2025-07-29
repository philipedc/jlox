package src.tool;

import java.sql.Statement;
import src.lox.Stmt;


class AstPrinter implements Stmt.Visitor<String> {
	String print(Stmt statement) {
		return statement.accept(this);
	}

	@Override
	public String visitExpressionStmt(Stmt.Expression stmt) {
		return parenthesize("expression", stmt.expression);
	}

	public static void main(String[] args) {
		Expr expression = new Expr.Binary(
			new Expr.Unary(
				new Token(TokenType.MINUS, "-", null, 1),
				new Expr.Literal(123)),
			new Token(TokenType.STAR, "*", null, 1),
			new Expr.Grouping(
				new Expr.Literal(45.67)));
	
		System.out.println(new AstPrinter().print(expression));
	  }
}