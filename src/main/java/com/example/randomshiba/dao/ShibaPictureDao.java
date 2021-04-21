package com.example.randomshiba.dao;

import com.example.randomshiba.dto.ShibaPicture;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

import static com.example.randomshiba.dao.ShibaPictureDaoSqls.*;

@Repository
public class ShibaPictureDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<ShibaPicture> rowMapper = BeanPropertyRowMapper.newInstance(ShibaPicture.class);

    public  ShibaPictureDao(DataSource dataSource){
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("SHIBA")
                .usingGeneratedKeyColumns("id");
    }

    public List<ShibaPicture> selectAll(){
        return jdbc.query(SELECT_ALL, rowMapper);
    }

    public int insert(ShibaPicture shibaPicture){
        SqlParameterSource params = new BeanPropertySqlParameterSource(shibaPicture);
        return insertAction.executeAndReturnKey(params).intValue();
    }

    public ShibaPicture selectRandomOne(){
        return jdbc.queryForObject(SELECT_RANDOM_ONE,Collections.emptyMap(), rowMapper);
    }
}
