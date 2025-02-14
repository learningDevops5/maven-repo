/*
 
// * This sample code is an extension for the sample model available in the SampleCDS folder.
// * Take the contents in the CDS folder and paste it in the DB module.

package fruitsMart.extensiontemplate;

import java.util.ArrayList;
import java.util.List;

import org.apache.olingo.commons.api.edm.EdmPrimitiveTypeKind;
import org.apache.olingo.commons.api.edm.provider.CsdlAction;
import org.apache.olingo.commons.api.edm.provider.CsdlFunction;
import org.apache.olingo.commons.api.edm.provider.CsdlOperation;
import org.apache.olingo.commons.api.edm.provider.CsdlParameter;
import org.apache.olingo.commons.api.edm.provider.CsdlReturnType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sap.gateway.v4.rt.api.extensions.ExtendMetadata;

public class SampleServiceModelExt {
	//Create logger
	final Logger logger = LoggerFactory.getLogger("SampleServiceModelExt");

	 // Annotation which defines the list of functions and actions for the service name.
	 // serviceName parameter denotes the fully qualified namespace of your schema. It is optional.
	 // The method should return List<CsdlOperation> which contains all the actions and functions.
	@ExtendMetadata(serviceName = "SampleService")
	public List<CsdlOperation> createOps() {
		// Create a list of all operations
		List<CsdlOperation> opList = new ArrayList<CsdlOperation>();
		//Sequence for creating an operation
		// 1) Set the parameter(s) for the function/ action. Operations might not have input parameters. So this step is optional
		// 2) Set the return type for the operation. Return Type is MUST for a function but not for Action
		// 3) Using above, create the Operation. 

	    //  Creating a bound function
	    //  Return Type Entity Collection 
		//  Without Input Parameter
		//  The first parameter of a function is taken as the bound parameter if the function is bound.

		// Set the return type as Collection of Entity (Customer)
		CsdlReturnType retTypePremium = new CsdlReturnType();
		retTypePremium.setCollection(true).setType("Customer");

		// Set the input parameter list
		final List<CsdlParameter> premiumParamList = new ArrayList<CsdlParameter>();
		CsdlParameter isPremium = new CsdlParameter();
		isPremium.setName("IsPremium").setNullable(false);
		isPremium.setType(EdmPrimitiveTypeKind.Boolean.getFullQualifiedName());
		premiumParamList.add(isPremium);

		// Now create the function and add return type, input parameter list and specify if it is bound
		final CsdlFunction getPremiumCusts = new CsdlFunction();
		getPremiumCusts.setName("GetPremiumCustomers").setBound(false).setReturnType(retTypePremium)
				.setParameters(premiumParamList);
		
		//Add the newly created function to the list
		opList.add(getPremiumCusts);

		// Create Bound Action: Return Type Entity

		// Create the list of action parameters
		List<CsdlParameter> actParamList = new ArrayList<CsdlParameter>();

		// This is a bound function, which is bound to an entity (Customer)
		CsdlParameter bindParam = new CsdlParameter();
		// Name MUST be same as the entity set
		bindParam.setName("Customer");
		
		// Type MUST be same as fully qualified name of the entity which is like
		// <namespace>._.<servicename>.<EntitySetName>. Since binding is with
		// single entity, collection is set as false
		bindParam.setType("SampleService.Customer");
		bindParam.setCollection(false);
		actParamList.add(bindParam);

		// Set the input parameter
		CsdlParameter setPremium = new CsdlParameter();
		setPremium.setName("SetPremium");
		setPremium.setType(EdmPrimitiveTypeKind.Boolean.getFullQualifiedName());
		actParamList.add(setPremium);

		// set the return type
		CsdlReturnType setPremRetType = new CsdlReturnType();
		setPremRetType.setCollection(false).setType("Customer");

		// Create the action
		CsdlAction setPremiumCust = new CsdlAction();
		setPremiumCust.setBound(true).setName("SetPremiumStatus").setParameters(actParamList)
				.setReturnType(setPremRetType);

		//Add action to operation list
		opList.add(setPremiumCust);

		return opList;
	}

}
*/
