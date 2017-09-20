package br.com.restaurant.controller.rest.test;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.restaurant.ApiRestauranteApplication;
import br.com.restaurant.controller.rest.RestaurantController;
import br.com.restaurant.model.Restaurant;

import org.springframework.boot.test.json.JacksonTester;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiRestauranteApplication.class, webEnvironment = RANDOM_PORT)
// @SpringBootTest
// @AutoConfigureMockMvc
// @WebMvcTest(RestaurantController.class)
public class RestaurantTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private TestRestTemplate restTemplate;

	// @Autowired
	// private MockMvc mockMvc;

	private JacksonTester<Restaurant> json;

	@Before
	public void setUp() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.findAndRegisterModules();
		JacksonTester.initFields(this, objectMapper);
	}
	@Test
	public void save() throws RestClientException, IOException {
		Restaurant restaurant = new Restaurant();
		restaurant.setName("Meu Restaurante");
		restaurant.setCategory("bread-bakery");
		restaurant.setHours("24");
		restaurant.setDeliveryEstimate("15 min");
		restaurant.setRating(4.5);
		restaurant.setAbout("n/a");
		restaurant.setImagePath("imagem");
		
		//ResponseEntity<Restaurant> 	r = restTemplate.postForEntity("http://localhost:8080/ApiRestaurant/restaurants/", this.json.write(restaurant), Restaurant.class);
		
		
		final ResponseEntity<Restaurant> salvar = this.restTemplate.postForEntity("http://localhost:8080/ApiRestaurant/restaurants/", this.json.write(restaurant), Restaurant.class);
		assertThat(salvar.getStatusCode()).isEqualTo(HttpStatus.CREATED);		
		
		
		/*Restaurant r = this.restTemplate.postForObject("http://localhost:8080/ApiRestaurant/restaurants/", restaurant, Restaurant.class);
		System.out.println("ID: "+r.getId()); */
		
		 /* final ResponseEntity<String> usuarioAdministrativoSaved = this.restTemplate.postForEntity("/api/usuario-tecnico",usuarioAdministrativoMapper.fromUsuarioAdministrativo(new UsuarioAdministrativoBuilder().buildWithNullIds()),String.class);
	        assertThat(usuarioAdministrativoSaved.getStatusCode()).isEqualTo(HttpStatus.OK);
	        UsuarioAdministrativoDTO dto = json.parseObject(usuarioAdministrativoSaved.getBody());

	        assertThat(dto).isNotNull();
		
			*/
		
	}

	@Test
	@Ignore
	public void getRestaurantById() throws Exception {

		final ResponseEntity<String> rest = this.restTemplate
				.getForEntity("http://localhost:8080/ApiRestaurant/restaurants/{id}", String.class, "bread-bakery");
		assertThat(rest.getStatusCode()).isEqualTo(HttpStatus.OK);

		Restaurant dto = json.parseObject(rest.getBody());
		assertThat(dto).isNotNull();
		assertThat(dto.getId()).isNotNull();
		assertThat(dto.getCategory()).isEqualTo("Bakery");

		System.out.println("MEU TESTE: " + dto.getCategory());

	}

	@Test
	@Ignore
	public void validarHeader() {
		HttpHeaders h = this.restTemplate.getForEntity("http://localhost:8080/ApiRestaurant/restaurants/", String.class)
				.getHeaders();
		System.out.println("Murilo TESTE: " + h.getContentType());
		assertThat(h.getContentType()).isEqualTo("application/json;charset=UTF-8");
	}
}
