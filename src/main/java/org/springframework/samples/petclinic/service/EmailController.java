package org.springframework.samples.petclinic.service;

import javax.mail.internet.MimeMessage;

//import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.samples.petclinic.plant.Plant;
import org.springframework.samples.petclinic.sensor.HumiditySensor;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

	@Autowired
	private JavaMailSender mailSender;

	private Plant plant;
	private HumiditySensor humiditySensor;

	//@RequestMapping(path = "/email-send")
	public String sendMail() {
		try {
			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			helper.setTo("desafiodb2019@gmail.com");
			helper.setSubject("Plant humidity warning: " + plant.getName());
			helper.setText("<p>The sensor " + humiditySensor.getName() + " id: " + humiditySensor.getId()
					+ " is indicating that the moisture of the plant " + plant.getName()
					+ " is outside the ideal range.</p>" + "<p>Current humidity: " + humiditySensor.getHumidity() + "%" + "."
					+ "</p><p>Ideal humidity range " + "minimum humidity: " + plant.getHumidity_minimum() + "%"
					+ " maximum humidity: " + plant.getHumidity_maximum() + "%" + "." + "</p>", true);
			mailSender.send(mail);
			return "Email successfully sent!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error sending email.";
		}
	}
	
	public void setPlantAndSensor(Plant plant, HumiditySensor sensor) {
		this.plant = plant;
		this.humiditySensor = sensor;
	}

}