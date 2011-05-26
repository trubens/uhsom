package no.truben.uhs.view.impl;

import no.truben.uhs.format.Hunk;
import no.truben.uhs.format.HunkType;
import no.truben.uhs.view.HintView;

public class HierarchicalText implements HintView {

	public void DisplayHints(Hunk hunk) {
		display(hunk, 0);
	}
	
	private void display(Hunk hunk, int indents) {
		String indent = createIndents(indents);
		System.out.println(indent + hunk.getMainLabel());
		System.out.println(indent + "======================================================");
		for(String s : hunk.getHints()) {
			System.out.println(indent + createIndents(indents) + s);
		}
		for(Hunk h : hunk.getSubHunk()) {
			if(h.getHunkType() != HunkType.BLANK)
				display(h, indents + 1);
		}
	}
	
	private static String createIndents(int number) {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < number; i++)
			sb.append("  ");
		return sb.toString();
		
	}

}
