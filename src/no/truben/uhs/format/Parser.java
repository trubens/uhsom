package no.truben.uhs.format;

import java.io.File;
import java.io.IOException;

public interface Parser {

	public abstract Hunk parse(File file) throws IOException;

}