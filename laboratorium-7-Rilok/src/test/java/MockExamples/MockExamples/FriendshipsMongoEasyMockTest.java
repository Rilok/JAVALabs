package MockExamples.MockExamples;

import org.easymock.*;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RunWith(EasyMockRunner.class)
public class FriendshipsMongoEasyMockTest {

	@TestSubject
	FriendshipsMongo friendships = new FriendshipsMongo();
	
	//A nice mock expects recorded calls in any order and returning null for other calls
	@Mock(type = MockType.NICE)
	FriendsCollection friends;
	
	@Test
	public void mockingWorksAsExpected(){
		Person joe = new Person("Joe");
		//Zapisanie zachowania - co sie ma stac
		expect(friends.findByName("Joe")).andReturn(joe);
		//Odpalenie obiektu do sprawdzenia zachowania
		replay(friends);
		assertThat(friends.findByName("Joe")).isEqualTo(joe);
	}
	
	@Test
	public void alexDoesNotHaveFriends(){
		assertThat(friendships.getFriendsList("Alex")).isEmpty();
	}
	
	@Test
	public void joeHas5Friends(){
		List<String> expected = Arrays.asList(new String[]{"Karol","Dawid","Maciej","Tomek","Adam"});
		Person joe = createMock(Person.class);
		expect(friends.findByName("Joe")).andReturn(joe);
		expect(joe.getFriends()).andReturn(expected);
		replay(friends);
		replay(joe);
		assertThat(friendships.getFriendsList("Joe")).hasSize(5).containsOnly("Karol","Dawid","Maciej","Tomek","Adam");
	}

	@Test
	@DisplayName("Check if Joe is Zenon's friend")
	public void areFriends(){
		List<String> expected = Arrays.asList(new String[]{"Zenon","Dawid","Maciej","Tomek","Adam"});
		Person joe = createMock(Person.class);
		expect(friends.findByName("Joe")).andReturn(joe);
		expect(joe.getFriends()).andReturn(expected);
		replay(friends);
		replay(joe);

		assertThat(friendships.areFriends("Joe", "Zenon"));
	}

	@Test
	@DisplayName("Make friends")
	public void makeFriends(){
		Person joe = createMock(Person.class);
		Person zenon = createMock(Person.class);
		expect(friends.findByName("Joe")).andReturn(joe);
		expect(friends.findByName("Zenon")).andReturn(zenon);
		replay(friends);

		expect(joe.getFriends()).andReturn(Arrays.asList(new String[]{ "Zenon"}));
		replay(joe);

		expect(zenon.getFriends()).andReturn(Arrays.asList(new String[] {"Joe"}));
		replay(zenon);

		assertThat(friendships.getFriendsList("Joe")).contains("Zenon");

	}
}
