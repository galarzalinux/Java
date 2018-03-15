public class TestException {
	
	public void algo() throws GalarzaException{
		int sum=0;
		String[] args={"1","2","3","4","5","Dah"};
		for (String arg : args) {
			sum+=Integer.parseInt(arg);
			throw new GalarzaException();
		}
		System.out.println("Sum= "+sum);
	}
	
      public static void main(String[] args) throws GalarzaException   {
		new TestException().algo();
      /*	try {
      		int sum=0;
			String[] argus={"1","2","3","4","5","Dah"};
			for (String arg : argus) {
				sum+=Integer.parseInt(arg);
			}
		} catch (NumberFormatException e) {
			System.out.println("Error: " + e.getMessage());
		}catch(Exception e){
			
		}
		*/
	}
}
