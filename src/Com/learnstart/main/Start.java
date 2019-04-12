package Com.learnstart.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import Com.learnstart.Inputs.Handler;

public class Start extends JPanel {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static ArrayList<String> variables;
	public boolean read;
	public String msg;
	public static JTextPane txt;
	public String s;
	public Handler h = new Handler();

	private int findLastNonWordChar(String text, int index) {
		while (--index >= 0) {
			if (String.valueOf(text.charAt(index)).matches("\\W")) {
				break;
			}
		}
		return index;
	}

	private int findFirstNonWordChar(String text, int index) {
		while (index < text.length()) {
			if (String.valueOf(text.charAt(index)).matches("\\W")) {
				break;
			}
			index++;
		}
		return index;
	}

	public Start() {
		s = "";
		setPreferredSize(new Dimension(King.WIDTH, King.HEIGHT));
		final StyleContext cont = StyleContext.getDefaultStyleContext();
		final AttributeSet attr = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.ORANGE);
		final AttributeSet attr2 = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.CYAN);
		final AttributeSet attr3 = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLUE);
		final AttributeSet attr4 = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.GREEN);
		final AttributeSet attridle = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.WHITE);
		DefaultStyledDocument doc = new DefaultStyledDocument() {
			private static final long serialVersionUID = 1L;

			public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
				super.insertString(offset, str, a);

				String text = getText(0, getLength());

				variables = new ArrayList<String>();

				int before = findLastNonWordChar(text, offset);
				if (before < 0)
					before = 0;
				int after = findFirstNonWordChar(text, offset + str.length());
				int wordL = before;
				int wordR = before;

				while (wordR <= after) {
					if (wordR == after || String.valueOf(text.charAt(wordR)).matches("\\W")) {
						if (text.substring(wordL, wordR).matches("(\\W)*(private|public|String|import|protected|main|class|for|while|if|package|throws|static|false|this|true|else|new|void|int|boolean|break|String|double|char)"))
							setCharacterAttributes(wordL, wordR - wordL, attr, false);
						else if (text.substring(wordL, wordR).matches("(\\W)*(out|println|var)"))
							setCharacterAttributes(wordL, wordR - wordL, attr2, false);
						else if (text.substring(wordL, wordR).matches("(\\W)*(System|Hello_World|Hello|World|!|\")"))
							setCharacterAttributes(wordL, wordR - wordL, attr3, false);
						else if (text.substring(wordL, wordR).matches("(\\W)*(get|matches|length|substring)"))
							setCharacterAttributes(wordL, wordR - wordL, attr4, false);
						else
							setCharacterAttributes(wordL, wordR - wordL, attridle, false);
						wordL = wordR;
					}
					wordR++;
				}
			}

			public void remove(int offs, int len) throws BadLocationException {
				super.remove(offs, len);

				String text = getText(0, getLength());
				int before = findLastNonWordChar(text, offs);
				if (before < 0)
					before = 0;
				int after = findFirstNonWordChar(text, offs);

				if (text.substring(before, after).matches("(\\W)*(private|public|String|import|protected|if|throws|false|true|else|else if|new|void|int|boolean|String)")) {
					setCharacterAttributes(before, after - before, attr, false);
				} else {
					setCharacterAttributes(before, after - before, attridle, false);
				}
			}
		};
		setLayout(new BorderLayout());
		txt = new JTextPane(doc);
		JButton comp = new JButton("Run");
		comp.setPreferredSize(new Dimension(King.WIDTH / 2, King.HEIGHT / 20));
		add(comp, BorderLayout.SOUTH);
		comp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println(Screen.current);
				Screen.c.requestFocus();
//				if (Screen.current == 2) {
				name();
//				} else {
				try {
					write();
				} catch (FileNotFoundException e1) {
					System.exit(0);
				}
//				}
			}
		});
		txt.setEditable(false);
		txt.setBackground(new Color(51, 51, 51));
		txt.setText(s);
		txt.setCaretColor(new Color(179, 255, 214));
		txt.setPreferredSize(new Dimension(King.WIDTH / 2, King.HEIGHT * 19 / 20));
		add(new JScrollPane(txt, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		setVisible(true);
	}

	public static void editon(boolean b) {
		txt.setEditable(b);
	}

	public void tick() {

	}

	public Handler geth() {
		return h;
	}

	public static void clear() {
		txt.setText("");
	}

	public static void main() {
		txt.setText("package Com.Create; \n \n public class User { \n \t  public static void main(String[] args) { \n \n \t  } \n }");
	}

	public static void setTxt(String t) {
		txt.setText(t);
	}

	@SuppressWarnings("unchecked")
	public void name() {
		if (txt.getText().indexOf("System.out.println(\"Hello World!\");") >= 0 || txt.getText().indexOf("System.out.println(\"Hello World\");") >= 0) {
			Screen.setNext(true);
			h.getL().set(2, true);
			Screen.can = true;
		}
	}

	public void write() throws FileNotFoundException {
//		System.out.println(Start.class.getResource("/Com/Create").toString() + "/User.java");
		PrintWriter pw = new PrintWriter("src/Com/Create/User.java");
		pw.write(txt.getText());
		pw.close();
//		try {
//			runProcess("javac User.java");
//			runProcess("java User");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//		Com.Create.write.createTxt("User.java", txt.getText());
//		Compiler.enable();
//		System.out.println(Compiler.compileClass(User.class));
//		System.out.println(Compiler.compileClasses("User"));
//		System.out.println(Compiler.command("System.out.println(\"Hello World!\");"));
	}

//	private static void runProcess(String command) throws Exception {
//		Process pro = Runtime.getRuntime().exec("javac User.class");
//		PrintLines(command + " stdout:", pro.getInputStream());
//		System.out.printf(command + " stderr:", pro.getErrorStream());
//		pro.waitFor();
//		System.out.println(command + " exitValue() " + pro.exitValue());
//	}

}
