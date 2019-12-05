package restdemo.application;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;
import servicebuilderdemo.service.ProductLocalServiceUtil;

/**
 * @author pierremellet
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/retails",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Greetings.Rest"
	},
	service = Application.class
)
public class RESTDemoApplication extends Application {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Path("/products")
	@Produces("application/json")
	public String listProducts() throws JsonProcessingException {
		return OBJECT_MAPPER.writeValueAsString(
				ProductLocalServiceUtil.getProducts(QueryUtil.ALL_POS, QueryUtil.ALL_POS)
				.stream()
				.map(product -> new ProductDTO(product.getProductId(), product.getProductName()))
				.collect(Collectors.toList())
		);
	}


	public static final class ProductDTO{

		private long id;
		private String name;

		public ProductDTO(long id, String name) {
			this.id = id;
			this.name = name;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

}