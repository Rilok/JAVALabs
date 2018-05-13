package exampleTableJBehabe.steps;

import java.util.ArrayList;
import java.util.Map;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.model.ExamplesTable;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import exampleTableJBehabe.Power;
import org.jbehave.core.steps.Parameters;

public class TabularSteps{
	
	ExamplesTable table;
	ArrayList<String> numbers;
	ArrayList<String> powerNumbers;
	Power power;

	@Given("the numbers: $ranksTable")
	public void givenTheNumbersnumber(ExamplesTable ranksTable){
		  this.table = ranksTable;
		  this.numbers = toNumbers(ranksTable);
		  System.out.println("Rows: " + ranksTable.getRowCount());
		  System.out.println("Numbers are: " + numbers);
	}

	private ArrayList<String> toNumbers(ExamplesTable table){
		ArrayList<String> result = new ArrayList<String>();
		for (Map<String, String> row: table.getRows()){
			result.add(row.get("left"));
			result.add(row.get("right"));
		}
		return result;
	}

	private ArrayList<String> toPowerNumbers(ExamplesTable table){
		String result = "";
		for (Map<String, String> row: table.getRows()){
			result = row.get("powers");
		}
		String[] powers = result.split(", ");
		ArrayList<String> output = new ArrayList<String>();
		for (int i = 0; i < powers.length; i++){
			output.add(powers[i]);
		}
		return output;
	}

	private ArrayList<Integer> toIntegersList(ArrayList<String> powerTable){
		ArrayList<Integer> powerNumbers = new ArrayList<Integer>();
		for (String number : powerTable){
			powerNumbers.add(Integer.parseInt(number));
		}
		return powerNumbers;
	}

	@Then("powers are: $table")
	public void thenPowersAndSizeIssizepowers(ExamplesTable table){
		this.powerNumbers = toPowerNumbers(table);
		Power power = new Power();
		ArrayList<Integer> input = toIntegersList(numbers);
		ArrayList<Integer> output = toIntegersList(powerNumbers);
		System.out.println("Powers are: " + output);

		assertThat(power.powers(input.get(0), input.get(1)), contains(output.toArray()));
	}
	
}