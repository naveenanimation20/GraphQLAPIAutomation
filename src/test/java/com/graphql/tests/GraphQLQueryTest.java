package com.graphql.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class GraphQLQueryTest {
	
	
	@Test
	public void getAllFilmsTest() {
		
		//https://swapi-graphql.netlify.app/.netlify/functions/index
		
		RestAssured.baseURI ="https://swapi-graphql.netlify.app";
		String query = "{\"query\":\"{\\n  allFilms {\\n    films {\\n      title\\n    }\\n  }\\n}\\n\",\"variables\":null}";
		
		given().log().all()
			.contentType("application/json")
			.body(query)
				.when().log().all()
					.post("/.netlify/functions/index")
						.then().log().all()	
							.assertThat()
								.statusCode(200)
									.and()
										.body("data.allFilms.films[0].title", equalTo("A New Hope"));
					
	}
	
	
	@Test
	public void getAllUsersTest() {
		RestAssured.baseURI ="https://hasura.io";
		String query = "{\"query\":\"{\\n  users(limit: 10) {\\n    id\\n    name\\n  }\\n}\\n\",\"variables\":null}";
		
		given().log().all()
			.contentType("application/json")
			.header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDYwYzYyMzlhNGQ1OTVkMDA2Nzg0NjEzYyJ9LCJuaWNrbmFtZSI6Im5hdmVlbmFuaW1hdGlvbjIwIiwibmFtZSI6Im5hdmVlbmFuaW1hdGlvbjIwQGdtYWlsLmNvbSIsInBpY3R1cmUiOiJodHRwczovL3MuZ3JhdmF0YXIuY29tL2F2YXRhci82MTVjNTVlNjBiZTU2N2ZmMDRiZTBjYTUwMmM5ZWExMz9zPTQ4MCZyPXBnJmQ9aHR0cHMlM0ElMkYlMkZjZG4uYXV0aDAuY29tJTJGYXZhdGFycyUyRm5hLnBuZyIsInVwZGF0ZWRfYXQiOiIyMDIxLTA2LTEzVDE1OjI2OjIwLjM4M1oiLCJpc3MiOiJodHRwczovL2dyYXBocWwtdHV0b3JpYWxzLmF1dGgwLmNvbS8iLCJzdWIiOiJhdXRoMHw2MGM2MjM5YTRkNTk1ZDAwNjc4NDYxM2MiLCJhdWQiOiJQMzhxbkZvMWxGQVFKcnprdW4tLXdFenFsalZOR2NXVyIsImlhdCI6MTYyNDAxMjI3NiwiZXhwIjoxNjI0MDQ4Mjc2LCJhdF9oYXNoIjoiS2dRZU91MlBqc2s0MEhsUFc2QnRWQSIsIm5vbmNlIjoibEo4TE9lQkh3SkQxWUZzSHRjRFhuOF9HY2U1Ny5BeGgifQ.eMbPodGaehaZfHFTYsf4cFHXRRAxwNPBzxU9w2XGI9D7N3Uu0J6wfF_Lm2IGEQZo4VNC-Mt9yUfwq4W0vFvV3TeTFrfBkGMoT6dEVqqvA8ZhpUD327aiLJXm6WioGPj-7tMhZrfDhLgTuo4lqhUCtxzc-d5K9Aye7xpXvDD6LJ6PNYaBvXu7Cl8O5o2iDUrFKl3-XSoGNqFhqnDWVXDEMIbCSM-XI0KA1o3iKEby5AFWN-VfDo2ULXaL4C2RT0jAkH90_VEHb4ukzLak2IzUtJtc8p7j8znmvObuHW7-WQNCbyAnhHFa43qwT75KGMx-gu__Uai0eJovxhE_zzynTQ")
				
				.body(query)
					.when().log().all()
						.post("/learn/graphql")
							.then().log().all()
								.assertThat()
									.statusCode(200)
										.body("data.users[0].name", equalTo("tui.glen"));	
			
	}
	

}
