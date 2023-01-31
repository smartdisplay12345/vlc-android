package org.videolan.vlc.items;

public class FileItem implements Comparable<FileItem> {
	public String name;
	public int type;
	public int fileCnt;
	public String path;
	public String path_parrent;
	
	public int index = 0;

	public boolean isVisble = false;
	public boolean isSelect = false;
	
	public String getName(){
		return name;
	}
	
	@Override
	public int compareTo(FileItem o) {
		if(this.name != null)
			return this.name.toLowerCase().compareTo(o.getName().toLowerCase()); 
		else 
			throw new IllegalArgumentException();
	}
}
