package no.truben.uhs.format;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Hunk {
	
	private List<Hunk> subHunk = new ArrayList<Hunk>();
	private HunkType hunkType;
	private String mainLabel;
	private int lines;
	private int link;
	private int lineNumber;
	private Hunk linkedHunk;
	private List<String> hints = new ArrayList<String>();
	
	public void addHunk(Hunk hunk) {
		subHunk.add(hunk);
	}
	
	public void addHint(String s) {
		hints.add(s);
	}

}
