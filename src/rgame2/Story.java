package rgame2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

public class Story {

	private String storyImage;
	private String storyMusic;
	private String Cname ;
	private String text ;
	
	public Story (String storyImage, String storyMusic, String Cname, String text) {
		
		this.storyImage=storyImage;
		this.storyMusic=storyMusic;
		this.Cname=Cname;
		this.text=text;
		
	}
	
	

	
	public String getStoryImage() {
		return storyImage;
	}
	public void setStoryImage(String storyImage) {
		this.storyImage = storyImage;
	}
	public String getStoryMusic() {
		return storyMusic;
	}
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setStoryMusic(String storyMusic) {
		this.storyMusic = storyMusic;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	
	
	
}
