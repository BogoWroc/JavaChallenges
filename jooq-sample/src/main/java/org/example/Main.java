package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.jooq.CrudExamples;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Dotenv dotenv = Dotenv.load();
        String mysqlJdbcUrl = dotenv.get("MYSQL_JDBC_URL");
        String database = dotenv.get("MYSQL_DATABASE");
        String mysqlUser = dotenv.get("MYSQL_USER");
        String mysqlPassword = dotenv.get("MYSQL_PASSWORD");

        Connection conn = DriverManager.getConnection("%s/%s".formatted(mysqlJdbcUrl,database), mysqlUser, mysqlPassword);
        DSLContext context = DSL.using(conn, SQLDialect.MYSQL);

        new CrudExamples(context).crudExamples();
    }
}