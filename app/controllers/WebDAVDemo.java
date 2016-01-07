package controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.dav.DefaultResource;
import model.dav.DefaultResourceDescription;
import model.dav.DefaultResourceProperties;
import model.dav.Resource;
import model.dav.ResourceProperties;
import model.dav.ResourceDescription;

import play.api.routing.Router;
import router.dav.SimpleWebDAV;

import views.xml.resource;

/**
 * Demo WebDAV endpoint
 *
 */
public class WebDAVDemo extends SimpleWebDAV {
	
	private static final String[] RESOURCE_NAMES = {"a.xml", "b.xml", "c.xml"};
	
	public WebDAVDemo() {
		
	}
	
	public WebDAVDemo(String prefix) {
		super(prefix);
	}
	
	@Override
	public Router withPrefix(String prefix) {
		return new WebDAVDemo(prefix);
	}
	
	@Override
	public List<ResourceDescription> descriptions() {
		return Stream.of(RESOURCE_NAMES)
			.map(resourceName -> new DefaultResourceDescription(
				resourceName, 
				new DefaultResourceProperties()))
			.collect(Collectors.toList());
	}
	
	@Override
	public Optional<Resource> resource(String name) {
		return Optional.ofNullable(
			new DefaultResource(
				"application/xml;charset=utf-8", 
				resource.render(name).body()));
	}
	
	@Override
	public Optional<ResourceProperties> properties(String name) {
		return Stream.of(RESOURCE_NAMES)
			.filter(name::equals)			
			.findAny()
			.map(resourceName -> new DefaultResourceProperties());
	}
}
