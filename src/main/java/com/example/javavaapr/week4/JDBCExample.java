package com.example.javavaapr.week4;

/**
 * import java.sql.Connection;
 * import java.sql.DriverManager;
 * import java.sql.PreparedStatement;
 * import java.sql.SQLException;
 *
 * public class JdbcTransactionExample {
 *
 *     public static void main(String[] args) {
 *         String url = "jdbc:mysql://localhost:3306/testdb";
 *         String username = "root";
 *         String password = "password";
 *
 *         Connection conn = null;
 *
 *         try {
 *             conn = DriverManager.getConnection(url, username, password);
 *
 *             // Start transaction manually
 *             conn.setAutoCommit(false);
 *
 *             String updateUserSql = """
 *                 UPDATE users
 *                 SET balance = balance - ?
 *                 WHERE id = ?
 *             """;
 *
 *             try (PreparedStatement ps = conn.prepareStatement(updateUserSql)) {
 *                 ps.setBigDecimal(1, new java.math.BigDecimal("100.00"));
 *                 ps.setInt(2, 1);
 *
 *                 int rows = ps.executeUpdate();
 *
 *                 if (rows != 1) {
 *                     throw new SQLException("User update failed");
 *                 }
 *             }
 *
 *             String updateReceiverSql = """
 *                 UPDATE users
 *                 SET balance = balance + ?
 *                 WHERE id = ?
 *             """;
 *
 *             try (PreparedStatement ps = conn.prepareStatement(updateReceiverSql)) {
 *                 ps.setBigDecimal(1, new java.math.BigDecimal("100.00"));
 *                 ps.setInt(2, 2);
 *
 *                 int rows = ps.executeUpdate();
 *
 *                 if (rows != 1) {
 *                     throw new SQLException("Receiver update failed");
 *                 }
 *             }
 *
 *             //select -> result set -> iterate result set , get each value by column name
 *
 *             // If everything succeeds, commit transaction
 *             conn.commit();
 *             System.out.println("Transaction committed successfully");
 *
 *         } catch (SQLException e) {
 *             System.out.println("Transaction failed: " + e.getMessage());
 *
 *             if (conn != null) {
 *                 try {
 *                     conn.rollback();
 *                     System.out.println("Transaction rolled back");
 *                 } catch (SQLException rollbackEx) {
 *                     System.out.println("Rollback failed: " + rollbackEx.getMessage());
 *                 }
 *             }
 *
 *         } finally {
 *             if (conn != null) {
 *                 try {
 *                     conn.setAutoCommit(true); // optional, useful if connection is reused
 *                     conn.close();
 *                 } catch (SQLException closeEx) {
 *                     System.out.println("Connection close failed: " + closeEx.getMessage());
 *                 }
 *             }
 *         }
 *     }
 * }
 */