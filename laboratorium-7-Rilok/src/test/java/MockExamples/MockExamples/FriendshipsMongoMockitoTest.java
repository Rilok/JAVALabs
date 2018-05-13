package MockExamples.MockExamples;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// Ta linia jest wymagana
@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class FriendshipsMongoMockitoTest {
	
	//Co zastepujemy
	@Mock
	FriendsCollection friends;
	
	//Nasza atrapa
	@InjectMocks
	FriendshipsMongo friendships;
	
	@Test
	public void mockingWorskAsExpected(){
		Person joe = new Person("Joe");
		doReturn(joe).when(friends).findByName("Joe");
		assertThat(friends.findByName("Joe")).isEqualTo(joe);
	}
	
	@Test
	public void alexDoesNotHaveFriends(){
		assertThat(friendships.getFriendsList("Alex")).isEmpty();
	}
	
	@Test
	public void joeHas5Friends(){
		List<String> expected = Arrays.asList(new String[]{"Karol","Dawid","Maciej","Tomek","Adam"});
		//Spy przechwytuje wywołania z przekazywanymi pośrednio danymi w celu
		// późniejszego zbadania tych danych w teście - tutaj w przykładzie lista przyjaciół Joe
		Person joe = spy(new Person("Joe"));
		doReturn(joe).when(friends).findByName("Joe");
		doReturn(expected).when(joe).getFriends();
		assertThat(friendships.getFriendsList("Joe")).hasSize(5).containsOnly("Karol","Dawid","Maciej","Tomek","Adam");
	}

	@Test
	public void makeFriends(){
		Person joe = new Person("Joe");
		doReturn(joe).when(friends).findByName("Joe");
		Person zenon = new Person("Zenon");
		doReturn(zenon).when(friends).findByName("Zenon");
		friendships.makeFriends("Joe", "Zenon");

		assertThat(friendships.getFriendsList("Joe")).hasSize(1).containsOnly("Zenon");
	}

	@Test
	public void makeMoreFriends(){
		Person joe = new Person("Joe");
		doReturn(joe).when(friends).findByName("Joe");
		Person zenon = new Person("Zenon");
		doReturn(zenon).when(friends).findByName("Zenon");
		Person jarek = new Person("Jarek");
		doReturn(jarek).when(friends).findByName("Jarek");

		friendships.makeFriends("Joe", "Zenon");
		friendships.makeFriends("Jarek", "Joe");

		assertThat(friendships.getFriendsList("Joe")).hasSize(2).containsOnly("Zenon", "Jarek");
	}

}