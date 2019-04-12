package Com.learnstart.Inputs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Handler {
	@SuppressWarnings("rawtypes")
	private List l;

	@SuppressWarnings("unchecked")
	public Handler() {
		l = new ArrayList<Objects>();
		l.add("Hello Newcomer I've Never Seen You Before. Can You Talk? \n (Pro Tip Press \"Enter\" To Continue The Chat)");
		l.add("Hmm Thats Weird You Can't Speak? Try This \"System.out.println(\"Hello World!\");\"?");
		l.add(false);
		l.add("Perfect! You Can Talk!");
		l.add("I Guess You Need A Little Lesson");
		l.add("But First Let Me Interduce Myself. My Name Is Olga I Was Designed By GrafxKid On opengameart.org");
		l.add("Let Me Be The First To Welcome You To Learn.Start()");
		l.add("What's That You Ask?... Well Its The Game We Are A Part Of");
		l.add("You Must Be Part Of An Update");
		l.add("We Don't Get Those To Much The Devs Are Lazy Here");
		l.add("Either Way Back To That Lesson!");
		l.add("The Command You Just Wrote");
		l.add("In The Lanauge \"Java\" It Prints A Statement To The Console");
		l.add("In Java There Exists A Thing Called \"Escape Sequences\"");
		l.add("Java Takes Everything Between The \"\" As A Message So How Do You Display Them?");
		l.add("You Use A Backslash Before The Quote");
		l.add("E.X \\\" These Sequences Help Us Display All Characters");
		l.add("You Can Even Use Things Like \\n For A New Line Or \\t For A Tab");
		l.add("More On All This Latter I Have So Much To Show You If You're Going To Start Here!");
		l.add("Lets Head To The Hub!");
		l.add(false);
		l.add("Welcome To The Hub!");
		l.add(false);
		l.add("Hm It Looks Like The Virus Has Just Gotten Here");
		l.add("Doesn't Seem He's Done To Much Damage");
		l.add("But Hes Broken A Fundemental Of How We Work We Must Start There!");
		l.add("He's Mixed Up And Broken Our Data Types!");
		l.add("What Are Data Types?? The Devs Must Have Sent The Update Too Soon");
		l.add("Besides the point...");
		l.add("Data Types Are The Storage Method For Diffrent Data Structures");
		l.add("For Example Our Speach! We Speak Using Strings");
		l.add("What's A String? A String Is One Or More Letters Strung Together");
		l.add("In Our Case Its Words But It Doesn't Have To Be");
		l.add("It Can Be Numbers Such As 10 Or Letters By It's Self");
		l.add("But Those Are Only Strings! Next Up We Have Chars");
		l.add("Strings Are Composed Of Chars Whats A Char? They're Single Letters");
		l.add("For Example 'A' Is A Char By It's Self");
		l.add("So Is Any Individual Letter");
		l.add("The Next Type We Will Do Is Ints");
		l.add("Ints Are Number Values But Whole Numbers No Decimal Values");
		l.add("For Example 1 Is An Int But 1.0 Is NOT An Int");
		l.add("But What About The Decimal Values? Those Are Doubles");
		l.add("While There Are Other Types That Take Decimals For Now We Will Use Doubles");
		l.add("The Last Type We Will Learn Is Boolean");
		l.add("Boolean Is The Simplest");
		l.add("Its As Easy As True Or False Thats All It Can Have");
//		l.add("Your Task: Asign Values Of String Int Double And Boolean  \n Recap: \n String: Words Letters Or Phrases Strung Together. \n Ints Numbers With Out Decimals. \n Double: Numbers With Decimals. \n Boolean True Or False. \n ");
		l.add("Sadly This Is As Far As The Beta Goes I Just Wanted To Let You Guys Have A Feel For The Style And Learning Process There Will Be A Task Here Soon Enough");
		l.add("Thank You For Testing! Let Us Know What You Think Use The '#' #LearnStart, @ Us, Or Goto Learnstart.com/Contact.html To Let Us Know Thank You For Your Time!");
		l.add(false);

	}

	@SuppressWarnings("rawtypes")
	public List getL() {
		return l;
	}
}