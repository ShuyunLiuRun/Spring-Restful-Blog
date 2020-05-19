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
import java.util.UUID;

@Repository("BlogDao")
public class BlogDao implements IBlogDao{

    private JdbcTemplate jdbcTemplate;

    public BlogDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean insertBlog(Blog blog) {
        String sql = "INSERT INTO blog (article,blogtitle,uuid) VALUES (?,?,?)";
        jdbcTemplate.update(sql,blog.getBody(),blog.getTitle(),blog.getId());
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

                return aBlog;
            }

        });
        return blogList;
    }

    private Blog selectBlogBySingleID(UUID id){
        String sql = "SELECT * FROM blog WHERE uuid=" + id;

        return jdbcTemplate.query(sql, new ResultSetExtractor<Blog>() {

            @Override
            public Blog extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Blog b = new Blog();

                    return b;
                }

                return null;
            }
        });
    }

    @Override
    public Optional<Blog> selectBlogById(UUID id) {
        Blog blog = selectBlogBySingleID(id);
        return Optional.ofNullable(blog);
    }

    @Override
    public boolean updateBlog(UUID id, Blog blog) {
        String sql = "UPDATE blog SET article=?, blogtitle=?, "
                + "WHERE uuid=?";
        jdbcTemplate.update(sql,blog.getBody(),blog.getTitle());
        return true;
    }

    @Override
    public boolean deleteBlog(UUID id) {
        String sql = "DELETE FROM blog WHERE uuid=?";
        jdbcTemplate.update(sql, id);
        return true;
    }
}
