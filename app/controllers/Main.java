package controllers;

import play.mvc.*;

public class Main extends Controller {
	
	public Result hello() {
		return ok("Hello, world!");
	}

}