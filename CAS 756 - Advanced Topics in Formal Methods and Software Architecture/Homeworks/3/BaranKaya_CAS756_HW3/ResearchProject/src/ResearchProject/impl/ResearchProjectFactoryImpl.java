/**
 */
package ResearchProject.impl;

import ResearchProject.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResearchProjectFactoryImpl extends EFactoryImpl implements ResearchProjectFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ResearchProjectFactory init() {
		try {
			ResearchProjectFactory theResearchProjectFactory = (ResearchProjectFactory)EPackage.Registry.INSTANCE.getEFactory(ResearchProjectPackage.eNS_URI);
			if (theResearchProjectFactory != null) {
				return theResearchProjectFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ResearchProjectFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResearchProjectFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ResearchProjectPackage.PROJECT: return createProject();
			case ResearchProjectPackage.PARTNER: return createPartner();
			case ResearchProjectPackage.EFFORT: return createEffort();
			case ResearchProjectPackage.WORKPACKAGE: return createWorkpackage();
			case ResearchProjectPackage.TASK: return createTask();
			case ResearchProjectPackage.DELIVERABLE: return createDeliverable();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project createProject() {
		ProjectImpl project = new ProjectImpl();
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Partner createPartner() {
		PartnerImpl partner = new PartnerImpl();
		return partner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Effort createEffort() {
		EffortImpl effort = new EffortImpl();
		return effort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Workpackage createWorkpackage() {
		WorkpackageImpl workpackage = new WorkpackageImpl();
		return workpackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task createTask() {
		TaskImpl task = new TaskImpl();
		return task;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Deliverable createDeliverable() {
		DeliverableImpl deliverable = new DeliverableImpl();
		return deliverable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResearchProjectPackage getResearchProjectPackage() {
		return (ResearchProjectPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ResearchProjectPackage getPackage() {
		return ResearchProjectPackage.eINSTANCE;
	}

} //ResearchProjectFactoryImpl
