package com.cwp.study.springcloud.provider.dao.hive.test;

import com.cwp.study.springcloud.provider.dao.hive.HiveJdbcBaseDaoImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class TestHiveDao extends HiveJdbcBaseDaoImpl {

    /**
     * 测试获取hive数据库数据信息
     * @return
     */
    public String test() {
        String sql = "SELECT * from pokes limit 100 ";
        String param = this.getJdbcTemplate().queryForObject(sql,String.class);
        return param;
    }


    public void testCreateTable(){
        StringBuffer sql = new StringBuffer("create table IF NOT EXISTS ");
        sql.append("HIVE_TEST");
        sql.append("(age INT, username STRING)");
        sql.append("ROW FORMAT DELIMITED FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' "); // 定义分隔符
        sql.append("STORED AS TEXTFILE"); // 作为文本存储

        // drop table
        // StringBuffer sql = new StringBuffer("DROP TABLE IF EXISTS ");
        // sql.append("HIVE_TEST1");
        log.info(sql.toString());
        this.getJdbcTemplate().execute(sql.toString());

    }

    public void testInsert() {
        this.getJdbcTemplate().execute("insert into hive_test(age, username)  values('Neo','Chen')");
    }


    public void testSelect() {
        String sql = "select * from HIVE_TEST";
        List<Map<String, Object>> rows = this.getJdbcTemplate().queryForList(sql);
        Iterator<Map<String, Object>> it = rows.iterator();		while (it.hasNext()) {
            Map<String, Object> row = it.next();
            System.out.println(String.format("%s\t%s", row.get("age"), row.get("username")));
        }
    }

    public void testDelete() {
        StringBuffer sql = new StringBuffer("DROP TABLE IF EXISTS ");
        sql.append("HIVE_TEST");
        log.info(sql.toString());
        this.getJdbcTemplate().execute(sql.toString());
    }


}
