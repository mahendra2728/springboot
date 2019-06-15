package com.springboot.pm.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.springboot.pm.model.Student;

@Service
public class StudentServiceImpl implements StudentService{

	
	private JdbcTemplate jdbcTemp;

	public StudentServiceImpl(DataSource dataSource) {
		jdbcTemp = new JdbcTemplate(dataSource);
	}
	
	private final String INSERT_SQL = "INSERT INTO Student(userName, PASSWORD, firstName,lastName,dateOfBirth,emailAddress,submitted) values(?,?,?,?,?,?,?)";
	private final String STATUS_UPDATE_SQL = "UPDATE Student SET submitted=? WHERE id=? ";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Student addStudent(final Student student) {
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, student.getUserName());
				ps.setString(2, student.getPASSWORD());
				ps.setString(3, student.getFirstName());
				ps.setString(4, student.getLastName());
				ps.setString(5, student.getDateOfBirth());
				ps.setString(6, student.getEmailAddress());
				ps.setBoolean(7, student.isSubmitted());
				return ps;
				
			}
		}, holder);
		student.setId(holder.getKey().intValue());
		System.out.println("student inserted sucessfully");
		return student;
	}

	@Override
	public List<Student> listOfStudents() {
		List<Student> list = jdbcTemp.query("SELECT id,userName,firstName,lastName,dateOfBirth,emailAddress,submitted FROM student", new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student stud = new Student();

				stud.setId(rs.getInt("id"));
				stud.setUserName(rs.getString("userName"));
				//stud.setPASSWORD(rs.getString("PASSWORD"));
				stud.setFirstName(rs.getString("firstName"));
				stud.setLastName(rs.getString("lastName"));
				stud.setDateOfBirth(rs.getString("dateOfBirth"));		
				stud.setEmailAddress(rs.getString("emailAddress"));
				stud.setSubmitted(rs.getBoolean("submitted"));

				return stud;
			}

		});

		return list;
	}
	
	public boolean updateStatus(int id) {
		boolean flag=false;
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(STATUS_UPDATE_SQL);
				ps.setBoolean(1, true);
				ps.setString(2,String.valueOf(id));
				return ps;
				
			}
		});
		flag=true;
		System.out.println("student updated sucessfully");
		return flag;
	}

}
