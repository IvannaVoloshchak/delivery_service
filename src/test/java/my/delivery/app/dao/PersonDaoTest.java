package my.delivery.app.dao;

import my.delivery.app.dao.impl.UserDaoImpl;
import my.delivery.app.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PersonDaoTest {

    @Mock
    private DataSource ds;

    @Mock
    private Connection c;

    @Mock
    //@InjectMocks
    private PreparedStatement preparedStatement;

    @Mock
    private Statement statement;
    @Mock
    private ResultSet rs;

    private User user;

    @Before
    public void setUp() throws Exception {
        assertNotNull(ds);
        when(c.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(c.createStatement()).thenReturn(statement);
        when(ds.getConnection()).thenReturn(c);

        user = new User();
        user.setId(56);
        user.setFirstName("Johannes");
        user.setLastName("Smythe");
        user.setLogin("kjffwej");
        user.setEmail("badbjwhbcq");
        user.setPhoneNumber("badbjwhbcq");
        user.setPassword("badbjwhbcq");
        user.setTypeId(1);

        when(rs.first()).thenReturn(true);
        when(rs.getString("first_name")).thenReturn(user.getFirstName());
        when(rs.getString("last_name")).thenReturn(user.getLastName());
        when(rs.getInt("id")).thenReturn(user.getId());
        when(rs.getInt("typeId")).thenReturn(user.getTypeId());
        when(rs.getString("login")).thenReturn(user.getLogin());
        when(rs.getString("password")).thenReturn(user.getPassword());
        when(rs.getString("phone_number")).thenReturn(user.getPhoneNumber());
        when(rs.getString("email")).thenReturn(user.getEmail());


        when(preparedStatement.executeQuery()).thenReturn(rs);
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void nullCreateThrowsException() {
//        new UserDaoImpl(ds).create(null);
//    }
//
//    @Test
//    public void createPerson() {
//        new UserDaoImpl(ds).create(user);
//    }
//
//    @Test
//    public void createAndRetrievePerson() throws Exception {
//        UserDaoImpl dao = new UserDaoImpl(c);
//        dao.addUser(user);
//        User user = dao.getUserById(56);
//        assertEquals(this.user, user);
//    }

}