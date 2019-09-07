package com.chenghao;

import com.chenghao.domain.Person;
import com.chenghao.product.Send;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SendTest {
	@Autowired
	private Send send;

	@Test
	public void send() throws Exception{

		send.sendMsg(new Person("chenghao",18));
	}

}
