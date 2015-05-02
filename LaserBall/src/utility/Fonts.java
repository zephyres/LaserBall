package utility;

import java.awt.Font;
import java.io.InputStream;

import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

public class Fonts {
	public static TrueTypeFont getRoboto(float size) {
		TrueTypeFont font = null;
		
		try {
			InputStream in = ResourceLoader.getResourceAsStream("fonts/roboto.ttf");
			Font f = Font.createFont(Font.TRUETYPE_FONT, in);
			
			f = f.deriveFont(size);
			font = new TrueTypeFont(f, false);
		} catch(Exception e) {}
		
		return font;
	}
}
