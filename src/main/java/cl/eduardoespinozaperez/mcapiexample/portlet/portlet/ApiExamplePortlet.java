package cl.eduardoespinozaperez.mcapiexample.portlet.portlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import cl.eduardoespinozaperez.mcapiexample.portlet.constants.ApiExamplePortletKeys;
import cl.eduardoespinozaperez.mcapiexample.portlet.data.CityProvider;

/**
 * @author Eduardo Espinoza Pérez
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Eduardo Espinoza Pérez API Example",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"com.liferay.portlet.header-portlet-javascript=/js/main.js",
		"javax.portlet.name=" + ApiExamplePortletKeys.ApiExample,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ApiExamplePortlet extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		CityProvider cp = new CityProvider();
		renderRequest.setAttribute("citiesList", cp.getCities());
		
		super.doView(renderRequest, renderResponse);
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		
		try {
			String zona = ParamUtil.getString(resourceRequest, "zona");
			System.out.println(zona);
			
			CityProvider cp = new CityProvider();
			resourceRequest.setAttribute("citiesList", cp.getCities(x -> x.getZona().equals(zona)));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		super.serveResource(resourceRequest, resourceResponse);
	}
	
}