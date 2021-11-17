package rgame1;

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
	
	
	public Story (String storyImage, String storyMusic, String Cname) {
		
		this.storyImage=storyImage;
		this.storyMusic=storyMusic;
		this.Cname=Cname;
		
		
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
