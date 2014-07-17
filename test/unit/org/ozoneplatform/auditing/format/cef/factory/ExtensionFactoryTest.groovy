package org.ozoneplatform.auditing.format.cef.factory
import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

import javax.servlet.http.HttpServletRequest;

import groovy.mock.interceptor.MockFor
import groovy.mock.interceptor.StubFor
import org.junit.Test
import org.ozoneplatform.auditing.format.cef.Extension
import org.ozoneplatform.auditing.enums.*

class ExtensionFactoryTest extends GroovyTestCase{

	
	
	@Test
	void testGetBaseExtensionFields(){
		HttpServletRequest mock = getHttpMock()
		def model = [:]
		model['searchResults'] = ["one", "two", "three"]
		def ext = ExtensionFactory.getBaseExtensionFields(mock, "YO.NAME", "7.0.0-GA", "U")
		assertThat(ext.size(), is(equalTo(14)))
	}
	
		
	
	private def getHttpMock(){
		return [
			getHeader: { return "some.remote.host" },
			getLocalAddr: { return "111.10.40.312" },
			getRequestedSessionId: { return "ABC123"},
			getParameterMap: {return [:] },
			getQueryString: { return "/url?foo=bar" },
			getRemoteHost: { return "http://server.com" },
			getRequestURL: {return new StringBuffer("http://server/path/list")},
			getRequestURI: {return "/server/path/list"}
		] as HttpServletRequest;
	}
	
}
