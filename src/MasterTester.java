import java.util.*;

public class MasterTester {
	public static void main (String args[]) throws Exception
	{
		String out = "Added: One trueContains: One true[One]Added: Two trueContains: Two true[One, Two]Added: Three trueContains: Three true[One, Three, Two]Added: Four trueContains: Four true[Four, One, Three, Two]Added: Five trueContains: Five true[Five, Four, One, Three, Two]Added: Six trueContains: Six true[Five, Four, One, Six, Three, Two]Added: Seven trueContains: Seven true[Five, Four, One, Seven, Six, Three, Two]Added: Eight trueContains: Eight true[Eight, Five, Four, One, Seven, Six, Three, Two]Added: Nine trueContains: Nine true[Eight, Five, Four, Nine, One, Seven, Six, Three, Two]Added: Ten trueContains: Ten true[Eight, Five, Four, Nine, One, Seven, Six, Ten, Three, Two]Removed: One true[Eight, Five, Four, Nine, Seven, Six, Ten, Three, Two]Removed: Two true[Eight, Five, Four, Nine, Seven, Six, Ten, Three]Removed: Three true[Eight, Five, Four, Nine, Seven, Six, Ten]Removed: Four true[Eight, Five, Nine, Seven, Six, Ten]Removed: Five true[Eight, Nine, Seven, Six, Ten]Removed: Six true[Eight, Nine, Seven, Ten]Removed: Seven true[Eight, Nine, Ten]Removed: Eight true[Nine, Ten]Removed: Nine true[Ten]Removed: Ten true[]";
		String[] words = {"One", "Two", "Three", "Four", "Five",
				"Six", "Seven", "Eight", "Nine", "Ten"};
		StringBuilder sb = new StringBuilder();
		MyBST bst = new MyBST();

		for (String word : words)
		{
			sb.append("Added: " + word + " " + bst.add(word));
			sb.append("Contains: " + word + " " + bst.contains(word));
			if(bst.add(word))
				sb.append("*** Added a duplicate value ***");
			sb.append(bst);
		}



		for (String word : words)
		{

			sb.append("Removed: " + word + " " + bst.remove(word));
			if(bst.remove(word))
				sb.append("*** Removed a non-existent value ***");
			sb.append(bst);
		}

		if(!(out.equals(sb.toString()))
			throw new IncorrectlyCompletedException();
	}
}
