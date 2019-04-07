package com.buchdemo.buchcontrol;

import com.buchdemo.buchcontrol.control.BuchController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuchcontrolApplicationTests {

	@Autowired
	BuchController buchController;

	@Test
	public void contextLoads() {
		assertThat(buchController).isNotNull();
	}

}
