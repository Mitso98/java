public class Example {

	public static void main(String args[]) {
		String result;
		System.out.println(args[0]);

		if (args[0].equals("CoreJava")) // "string"=="string" will compare refrance .equals compares values
			result = "true";
		else
			result = "false";

		result += " value " + args[0];

		System.out.println(result);

	}
}