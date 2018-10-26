package ua.edu.ukma.e_oss.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import javax.servlet.Filter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MainPageControllerTest {

    @Autowired
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getUserPage() throws Exception {
        // todo - bypass the login page
//        mvc
//                .perform(get("/userPage"))
//                .andExpect(status().isOk());
    }

    @Test
    public void getMainPage() throws Exception {
        mvc
                .perform(get("/mainPage"))
                .andExpect(status().isOk());
    }

    @Test
    public void postMainPage() {
    }
}