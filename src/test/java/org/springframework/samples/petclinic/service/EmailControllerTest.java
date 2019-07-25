package org.springframework.samples.petclinic.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmailControllerTest {

//	@Autowired
//	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;	
	
	
	@Test
    public void testSendEmail() throws Exception {
//		ResponseEntity<String> responde = restTemplate.getForEntity("http://localhost:" + port + "/email-send", String.class);
//		Assertions.assertThat(responde.getStatusCodeValue()).isEqualTo(200);
    }
	
}
