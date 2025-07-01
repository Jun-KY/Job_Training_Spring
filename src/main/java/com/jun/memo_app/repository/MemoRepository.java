package com.jun.memo_app.repository;

import com.jun.memo_app.model.Memo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemoRepository {
    private final JdbcTemplate jdbcTemplate;

    public MemoRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Memo> memoRowMapper = (resultSet, rowNum) ->
        new Memo(
                resultSet.getInt("id"),
                resultSet.getString("title"),
                resultSet.getString("content")
        );

    public List<Memo> findAll(){
        return jdbcTemplate.query(
                "SELECT * FROM memo ORDER BY id DESC",memoRowMapper
        );
    }
    public void save(String title, String content){
        jdbcTemplate.update(
                "INSERT INTO memo (title, content) VALUES (?, ?)",
                title, content
        );
    }

    public void delete(int id){
        jdbcTemplate.update(
                "DELETE FROM memo WHERE id = ?",
                id
        );
    }
}
