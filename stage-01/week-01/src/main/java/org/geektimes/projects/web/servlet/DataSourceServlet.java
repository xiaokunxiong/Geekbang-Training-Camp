package org.geektimes.projects.web.servlet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

/**
 * @title: DataSourceServlet
 * @Author sean
 * @Date: 2021/6/19 12:13 下午
 */
@WebServlet("/getConnection")
public class DataSourceServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Context initCtx;
        PrintWriter writer;
        try {
            // Obtain our environment naming context
            initCtx = new InitialContext();
//            initCtx.lookup("java:comp/env/jdbc/PoolPlatformDataSource");
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            // Look up our data source
            DataSource ds = (DataSource) envCtx.lookup("/jdbc/derby");
            // Allocate and use a connection from the pool
            Connection conn = ds.getConnection();
            if (Objects.nonNull(conn)) {
                writer = response.getWriter();
                writer.write("get connection success!");
                writer.flush();
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
