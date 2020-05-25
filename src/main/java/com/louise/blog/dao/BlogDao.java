package com.louise.blog.dao;

import com.louise.blog.model.Blog;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Repository("BlogDao")
public class BlogDao implements IBlogDao{

    private JdbcTemplate jdbcTemplate;


    public BlogDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean insertBlog(Blog blog) {
        String sql = "INSERT INTO blog (article,blogtitle) VALUES (?,?)";
        jdbcTemplate.update(sql,blog.getBody(),blog.getTitle());
        return true;
    }

    @Override
    public List<Blog> selectAllBlogs() {
        String sql = "SELECT * FROM blog";
        List<Blog> blogList = jdbcTemplate.query(sql, new RowMapper<Blog>() {

            @Override
            public Blog mapRow(ResultSet rs, int rowNum) throws SQLException {
                Blog aBlog = new Blog();

                aBlog.setBody(rs.getString("article"));
                aBlog.setTitle(rs.getString("blogtitle"));
                aBlog.setId(rs.getInt("blogid"));

                return aBlog;
            }

        });
        return blogList;
    }

    private Blog selectBlogBySingleID(int id){
        String sql = "SELECT * FROM blog WHERE blogid=" + id;
        Blog b = new Blog();
        return jdbcTemplate.query(sql, new ResultSetExtractor<Blog>() {

            @Override
            public Blog extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    b.setId(rs.getInt("blogid"));
                    b.setTitle(rs.getString("blogtitle"));
                    b.setBody(rs.getString("article"));
                }

                return b;
            }
        });
    }

    @Override
    public Optional<Blog> selectBlogById(int id) {
        Blog blog = selectBlogBySingleID(id);
        return Optional.ofNullable(blog);
    }

    @Override
    public boolean updateBlog(Blog blog) {
        String sql = "UPDATE blog SET article=?, blogtitle=?"
                + "WHERE blogid=?";
        jdbcTemplate.update(sql,blog.getBody(),blog.getTitle(),blog.getId());
        return true;
    }

    @Override
    public boolean deleteBlog(int id) {
        String sql = "DELETE FROM blog WHERE blogid=?";
        jdbcTemplate.update(sql, id);
        return true;
    }
}
