package model.dav;

public class DefaultResource implements Resource {
	
	private final String contentType, content;
	
	public DefaultResource(String contentType, String content) {
		this.contentType = contentType;
		this.content = content;
	}

	@Override
	public String contentType() {		
		return contentType;
	}

	@Override
	public String content() {
		return content;
	}

}
