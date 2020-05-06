/**
 */
package ResearchProject.impl;

import ResearchProject.Deliverable;
import ResearchProject.Effort;
import ResearchProject.NamedElement;
import ResearchProject.Partner;
import ResearchProject.Project;
import ResearchProject.ResearchProjectFactory;
import ResearchProject.ResearchProjectPackage;
import ResearchProject.Task;
import ResearchProject.TimedElement;
import ResearchProject.Workpackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResearchProjectPackageImpl extends EPackageImpl implements ResearchProjectPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partnerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass effortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass workpackageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deliverableEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see ResearchProject.ResearchProjectPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ResearchProjectPackageImpl() {
		super(eNS_URI, ResearchProjectFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link ResearchProjectPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ResearchProjectPackage init() {
		if (isInited) return (ResearchProjectPackage)EPackage.Registry.INSTANCE.getEPackage(ResearchProjectPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredResearchProjectPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ResearchProjectPackageImpl theResearchProjectPackage = registeredResearchProjectPackage instanceof ResearchProjectPackageImpl ? (ResearchProjectPackageImpl)registeredResearchProjectPackage : new ResearchProjectPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theResearchProjectPackage.createPackageContents();

		// Initialize created meta-data
		theResearchProjectPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theResearchProjectPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ResearchProjectPackage.eNS_URI, theResearchProjectPackage);
		return theResearchProjectPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimedElement() {
		return timedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimedElement_Start() {
		return (EAttribute)timedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimedElement_End() {
		return (EAttribute)timedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimedElement_Duration() {
		return (EAttribute)timedElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProject() {
		return projectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_Partners() {
		return (EReference)projectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_Workpackages() {
		return (EReference)projectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPartner() {
		return partnerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartner_Efforts() {
		return (EReference)partnerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEffort() {
		return effortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEffort_PersonMonths() {
		return (EAttribute)effortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEffort_For_Workpackage() {
		return (EReference)effortEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWorkpackage() {
		return workpackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkpackage_PackageEffort() {
		return (EReference)workpackageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkpackage_Deliverables() {
		return (EReference)workpackageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkpackage_Tasks() {
		return (EReference)workpackageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTask() {
		return taskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeliverable() {
		return deliverableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResearchProjectFactory getResearchProjectFactory() {
		return (ResearchProjectFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		timedElementEClass = createEClass(TIMED_ELEMENT);
		createEAttribute(timedElementEClass, TIMED_ELEMENT__START);
		createEAttribute(timedElementEClass, TIMED_ELEMENT__END);
		createEAttribute(timedElementEClass, TIMED_ELEMENT__DURATION);

		projectEClass = createEClass(PROJECT);
		createEReference(projectEClass, PROJECT__PARTNERS);
		createEReference(projectEClass, PROJECT__WORKPACKAGES);

		partnerEClass = createEClass(PARTNER);
		createEReference(partnerEClass, PARTNER__EFFORTS);

		effortEClass = createEClass(EFFORT);
		createEAttribute(effortEClass, EFFORT__PERSON_MONTHS);
		createEReference(effortEClass, EFFORT__FOR_WORKPACKAGE);

		workpackageEClass = createEClass(WORKPACKAGE);
		createEReference(workpackageEClass, WORKPACKAGE__PACKAGE_EFFORT);
		createEReference(workpackageEClass, WORKPACKAGE__DELIVERABLES);
		createEReference(workpackageEClass, WORKPACKAGE__TASKS);

		taskEClass = createEClass(TASK);

		deliverableEClass = createEClass(DELIVERABLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		projectEClass.getESuperTypes().add(this.getNamedElement());
		projectEClass.getESuperTypes().add(this.getTimedElement());
		partnerEClass.getESuperTypes().add(this.getNamedElement());
		workpackageEClass.getESuperTypes().add(this.getNamedElement());
		workpackageEClass.getESuperTypes().add(this.getTimedElement());
		taskEClass.getESuperTypes().add(this.getNamedElement());
		taskEClass.getESuperTypes().add(this.getTimedElement());
		deliverableEClass.getESuperTypes().add(this.getNamedElement());
		deliverableEClass.getESuperTypes().add(this.getTimedElement());

		// Initialize classes and features; add operations and parameters
		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(timedElementEClass, TimedElement.class, "TimedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimedElement_Start(), ecorePackage.getEIntegerObject(), "start", null, 0, 1, TimedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimedElement_End(), ecorePackage.getEIntegerObject(), "end", null, 0, 1, TimedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimedElement_Duration(), ecorePackage.getEIntegerObject(), "duration", null, 0, 1, TimedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(projectEClass, Project.class, "Project", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProject_Partners(), this.getPartner(), null, "partners", null, 1, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_Workpackages(), this.getWorkpackage(), null, "workpackages", null, 1, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(partnerEClass, Partner.class, "Partner", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPartner_Efforts(), this.getEffort(), null, "efforts", null, 1, -1, Partner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(effortEClass, Effort.class, "Effort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEffort_PersonMonths(), ecorePackage.getEIntegerObject(), "PersonMonths", null, 0, 1, Effort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEffort_For_Workpackage(), this.getWorkpackage(), this.getWorkpackage_PackageEffort(), "for_Workpackage", null, 1, 1, Effort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(workpackageEClass, Workpackage.class, "Workpackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWorkpackage_PackageEffort(), this.getEffort(), this.getEffort_For_Workpackage(), "packageEffort", null, 1, -1, Workpackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWorkpackage_Deliverables(), this.getDeliverable(), null, "deliverables", null, 1, -1, Workpackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWorkpackage_Tasks(), this.getTask(), null, "tasks", null, 1, -1, Workpackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskEClass, Task.class, "Task", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(deliverableEClass, Deliverable.class, "Deliverable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// gmf.diagram
		createGmfAnnotations();
		// gmf.node
		createGmf_1Annotations();
		// gmf.link
		createGmf_2Annotations();
		// gmf.compartment
		createGmf_3Annotations();
	}

	/**
	 * Initializes the annotations for <b>gmf.diagram</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmfAnnotations() {
		String source = "gmf.diagram";
		addAnnotation
		  (projectEClass,
		   source,
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.node</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_1Annotations() {
		String source = "gmf.node";
		addAnnotation
		  (partnerEClass,
		   source,
		   new String[] {
			   "label", "name",
			   "figure", "rectangle",
			   "color", "255,200,200"
		   });
		addAnnotation
		  (effortEClass,
		   source,
		   new String[] {
			   "label", "PersonMonths",
			   "figure", "ellipse",
			   "color", "200,255,200",
			   "phantom", "true"
		   });
		addAnnotation
		  (workpackageEClass,
		   source,
		   new String[] {
			   "label", "name"
		   });
		addAnnotation
		  (taskEClass,
		   source,
		   new String[] {
			   "label", "name",
			   "figure", "rectangle",
			   "color", "200,200,255"
		   });
		addAnnotation
		  (deliverableEClass,
		   source,
		   new String[] {
			   "label", "name",
			   "figure", "rectangle",
			   "color", "255,255,200"
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.link</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_2Annotations() {
		String source = "gmf.link";
		addAnnotation
		  (getPartner_Efforts(),
		   source,
		   new String[] {
			   "target.decoration", "arrow",
			   "color", "0,0,0",
			   "label", "Person/Months"
		   });
		addAnnotation
		  (getEffort_For_Workpackage(),
		   source,
		   new String[] {
			   "target.decoration", "arrow",
			   "color", "0,0,0",
			   "label", "for"
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.compartment</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_3Annotations() {
		String source = "gmf.compartment";
		addAnnotation
		  (getWorkpackage_Deliverables(),
		   source,
		   new String[] {
			   "layout", "list",
			   "collapsible", "false"
		   });
		addAnnotation
		  (getWorkpackage_Tasks(),
		   source,
		   new String[] {
			   "layout", "list",
			   "collapsible", "false"
		   });
	}

} //ResearchProjectPackageImpl
