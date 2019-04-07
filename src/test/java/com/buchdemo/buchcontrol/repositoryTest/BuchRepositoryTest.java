package com.buchdemo.buchcontrol.repositoryTest;

import com.buchdemo.buchcontrol.model.Buch;
import com.buchdemo.buchcontrol.repository.BuchRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class BuchRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BuchRepository buchRepository;

    @Test
    public void test_findAllBuch () {
        entityManager.persist(new Buch("Foo", "Horror", "abc" ));
        entityManager.persist(new Buch("Foo1", "Horror", "abc1" ));
        entityManager.persist(new Buch("Foo2", "Horror", "abc2" ));

        assertThat(buchRepository.findAll().size()==3);
    }

    @Test
    public void test_findByAuthor () {
        entityManager.persist(new Buch("Foo", "Horror", "abc" ));

        assertThat(buchRepository.findByAuthor("abc").get(0).getTitel().equals("Foo"));
    }

    @Test
    public void testFindByTitel() {
        entityManager.persist(new Buch("Foo", "Horror", "abc" ));
        entityManager.flush();

        List<Buch> found = buchRepository.findByTitel("Foo");
        assertThat("Foo".equals(found.get(0).getTitel()));
    }

}
