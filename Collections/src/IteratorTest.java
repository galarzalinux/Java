import java.util.Arrays;
import java.util.List;

public class IteratorTest {

	public static void main(String[] args) {
		List<String> collect = Arrays.asList("red","blue","yellow","orange","green","violet");
		java.util.Iterator<String> iter=collect.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
