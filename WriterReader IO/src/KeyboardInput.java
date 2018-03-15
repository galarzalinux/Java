import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardInput {

	public static void main(String[] args) {
		try {
			String s1,s2,r;
			int i,j,k;
			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(isr);
			System.out.println("Teclea primer valor");
			s1=br.readLine();
			i=Integer.parseInt(s1);
			System.out.println("Teclea segundo valor");
			s2=br.readLine();
			j=Integer.parseInt(s2);
			k=i*j;
			System.out.println("resultado "+k);
			r=String.format("Resultado= %d",k );
			System.out.println(r);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
