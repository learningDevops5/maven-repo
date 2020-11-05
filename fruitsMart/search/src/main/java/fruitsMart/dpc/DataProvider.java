package fruitsMart.dpc;

import org.apache.olingo.commons.api.edm.provider.CsdlEdmProvider;
import org.apache.olingo.server.api.uri.UriInfo;

import com.sap.gateway.v4.rt.cds.CDSDataProvider;
import com.sap.gateway.v4.rt.cds.ODataToCDSProcessor;

public class DataProvider extends CDSDataProvider {
	
	

	public DataProvider(ODataToCDSProcessor jdbcProcessor, CsdlEdmProvider edmProvider) {
		super(jdbcProcessor, edmProvider);
	}
	
	public DataProvider(CsdlEdmProvider edmProvider) {
		super(edmProvider);
	}
	
	@Override
	public Long getPageSize(UriInfo uriInfo) {
		return (long)1000;
	}
}
