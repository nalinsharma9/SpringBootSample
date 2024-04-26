package com.telusko.springjdbcdemo.DAO;

import java.util.ArrayList;
import java.util.List;

//import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telusko.springjdbcdemo.model.Alien;

@Repository
public class AlienDAO {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    

    public void save (Alien alien){
        String sql = "insert into alien (id, name ,tech) values(?,?,?)";
        
        int rows = template.update(sql,alien.getId(),alien.getName(),alien.getTech());
        System.out.println(rows+ " rows affected");

    }

    public List<Alien> findAll(){
        return new ArrayList<Alien>();
    }

    
    
}
