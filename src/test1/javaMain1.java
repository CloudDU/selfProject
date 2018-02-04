package test1;

/**
 * Created by ducheng on 2018/1/30.
 */
public class javaMain1{
	public static void main(String[] args){

		String is = null;
		System.out.println(is);
		//System.out.println(is.toString());

		Long irs = 555L;
		System.out.println(irs);
		if(irs == null){
			irs = 11111L;
		}
		System.out.println(irs.toString());
		//System.out.println(irs == null ? "ddddd":irs.toString());
	}
}
