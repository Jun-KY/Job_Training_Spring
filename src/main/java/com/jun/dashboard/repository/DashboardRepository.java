package com.jun.dashboard.repository;

import com.jun.dashboard.model.CustomerRank;
import com.jun.dashboard.model.DailySales;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public class DashboardRepository {
    private final JdbcTemplate jdbcTemplate;

    public DashboardRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<DailySales> dailySalesRowMapper = (resultSet, RowNum) ->
            new DailySales(
                    resultSet.getDate("sale_date").toLocalDate(),
                    resultSet.getBigDecimal("total_amount"),
                    resultSet.getInt("order_count")
            );

    private final RowMapper<CustomerRank> customerRankRowMapper = (resultSet, rowNum) ->
            new CustomerRank(
                    resultSet.getInt("customer_id"),
                    resultSet.getBigDecimal("total_spent"),
                    resultSet.getInt("rank")
                    );


    public List<DailySales> findDailySales(){
        return jdbcTemplate.query(
                "SELECT * FROM daily_sales",
                dailySalesRowMapper
        );
    }

    public List<CustomerRank> findCustomerRankings(){
        String sql = """
                SELECT customer_id,
                       total_spent,
                       RANK() OVER (ORDER BY total_spent DESC) AS rank
                FROM customer_spending
                """;

        return jdbcTemplate.query(sql, customerRankRowMapper);
    }

    public void saveSale(LocalDate saleDate, int customerId, BigDecimal amount){
        jdbcTemplate.update(
                "INSERT INTO sales (sale_data, customer_id, amount) VALUES (?, ?, ?)",
                saleDate, customerId, amount);

    }
}

