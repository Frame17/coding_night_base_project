package ua.edu.ukma.e_oss.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class AnswerRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AnswerRepository answerRepository;

    @Test
    void save() {

    }

    @Test
    void saveAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void existsById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findAllById() {
    }

    @Test
    void count() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void deleteAll1() {
    }

    @Test
    void findAllByUser() {
    }

    @Test
    void findAllByTicket() {
    }

    @Test
    void findAllByScId() {
    }
}