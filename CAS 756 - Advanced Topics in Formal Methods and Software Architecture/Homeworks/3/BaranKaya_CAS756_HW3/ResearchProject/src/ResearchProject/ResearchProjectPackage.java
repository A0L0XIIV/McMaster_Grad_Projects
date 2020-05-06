/**
 */
package ResearchProject;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see ResearchProject.ResearchProjectFactory
 * @model kind="package"
 * @generated
 */
public interface ResearchProjectPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ResearchProject";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "ResearchProject";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResearchProjectPackage eINSTANCE = ResearchProject.impl.ResearchProjectPackageImpl.init();

	/**
	 * The meta object id for the '{@link ResearchProject.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ResearchProject.impl.NamedElementImpl
	 * @see ResearchProject.impl.ResearchProjectPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link ResearchProject.impl.TimedElementImpl <em>Timed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ResearchProject.impl.TimedElementImpl
	 * @see ResearchProject.impl.ResearchProjectPackageImpl#getTimedElement()
	 * @generated
	 */
	int TIMED_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_ELEMENT__START = 0;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_ELEMENT__END = 1;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_ELEMENT__DURATION = 2;

	/**
	 * The number of structural features of the '<em>Timed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link ResearchProject.impl.ProjectImpl <em>Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ResearchProject.impl.ProjectImpl
	 * @see ResearchProject.impl.ResearchProjectPackageImpl#getProject()
	 * @generated
	 */
	int PROJECT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__START = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__END = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__DURATION = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Partners</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__PARTNERS = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Workpackages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__WORKPACKAGES = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link ResearchProject.impl.PartnerImpl <em>Partner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ResearchProject.impl.PartnerImpl
	 * @see ResearchProject.impl.ResearchProjectPackageImpl#getPartner()
	 * @generated
	 */
	int PARTNER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Efforts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER__EFFORTS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Partner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ResearchProject.impl.EffortImpl <em>Effort</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ResearchProject.impl.EffortImpl
	 * @see ResearchProject.impl.ResearchProjectPackageImpl#getEffort()
	 * @generated
	 */
	int EFFORT = 4;

	/**
	 * The feature id for the '<em><b>Person Months</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFORT__PERSON_MONTHS = 0;

	/**
	 * The feature id for the '<em><b>For Workpackage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFORT__FOR_WORKPACKAGE = 1;

	/**
	 * The number of structural features of the '<em>Effort</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFORT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link ResearchProject.impl.WorkpackageImpl <em>Workpackage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ResearchProject.impl.WorkpackageImpl
	 * @see ResearchProject.impl.ResearchProjectPackageImpl#getWorkpackage()
	 * @generated
	 */
	int WORKPACKAGE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKPACKAGE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKPACKAGE__START = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKPACKAGE__END = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKPACKAGE__DURATION = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Package Effort</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKPACKAGE__PACKAGE_EFFORT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Deliverables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKPACKAGE__DELIVERABLES = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Tasks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKPACKAGE__TASKS = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Workpackage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKPACKAGE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link ResearchProject.impl.TaskImpl <em>Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ResearchProject.impl.TaskImpl
	 * @see ResearchProject.impl.ResearchProjectPackageImpl#getTask()
	 * @generated
	 */
	int TASK = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__START = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__END = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__DURATION = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link ResearchProject.impl.DeliverableImpl <em>Deliverable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ResearchProject.impl.DeliverableImpl
	 * @see ResearchProject.impl.ResearchProjectPackageImpl#getDeliverable()
	 * @generated
	 */
	int DELIVERABLE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIVERABLE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIVERABLE__START = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIVERABLE__END = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIVERABLE__DURATION = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Deliverable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIVERABLE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link ResearchProject.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see ResearchProject.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link ResearchProject.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ResearchProject.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link ResearchProject.TimedElement <em>Timed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timed Element</em>'.
	 * @see ResearchProject.TimedElement
	 * @generated
	 */
	EClass getTimedElement();

	/**
	 * Returns the meta object for the attribute '{@link ResearchProject.TimedElement#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see ResearchProject.TimedElement#getStart()
	 * @see #getTimedElement()
	 * @generated
	 */
	EAttribute getTimedElement_Start();

	/**
	 * Returns the meta object for the attribute '{@link ResearchProject.TimedElement#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End</em>'.
	 * @see ResearchProject.TimedElement#getEnd()
	 * @see #getTimedElement()
	 * @generated
	 */
	EAttribute getTimedElement_End();

	/**
	 * Returns the meta object for the attribute '{@link ResearchProject.TimedElement#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see ResearchProject.TimedElement#getDuration()
	 * @see #getTimedElement()
	 * @generated
	 */
	EAttribute getTimedElement_Duration();

	/**
	 * Returns the meta object for class '{@link ResearchProject.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see ResearchProject.Project
	 * @generated
	 */
	EClass getProject();

	/**
	 * Returns the meta object for the containment reference list '{@link ResearchProject.Project#getPartners <em>Partners</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Partners</em>'.
	 * @see ResearchProject.Project#getPartners()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Partners();

	/**
	 * Returns the meta object for the containment reference list '{@link ResearchProject.Project#getWorkpackages <em>Workpackages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Workpackages</em>'.
	 * @see ResearchProject.Project#getWorkpackages()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Workpackages();

	/**
	 * Returns the meta object for class '{@link ResearchProject.Partner <em>Partner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Partner</em>'.
	 * @see ResearchProject.Partner
	 * @generated
	 */
	EClass getPartner();

	/**
	 * Returns the meta object for the containment reference list '{@link ResearchProject.Partner#getEfforts <em>Efforts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Efforts</em>'.
	 * @see ResearchProject.Partner#getEfforts()
	 * @see #getPartner()
	 * @generated
	 */
	EReference getPartner_Efforts();

	/**
	 * Returns the meta object for class '{@link ResearchProject.Effort <em>Effort</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Effort</em>'.
	 * @see ResearchProject.Effort
	 * @generated
	 */
	EClass getEffort();

	/**
	 * Returns the meta object for the attribute '{@link ResearchProject.Effort#getPersonMonths <em>Person Months</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Person Months</em>'.
	 * @see ResearchProject.Effort#getPersonMonths()
	 * @see #getEffort()
	 * @generated
	 */
	EAttribute getEffort_PersonMonths();

	/**
	 * Returns the meta object for the reference '{@link ResearchProject.Effort#getFor_Workpackage <em>For Workpackage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>For Workpackage</em>'.
	 * @see ResearchProject.Effort#getFor_Workpackage()
	 * @see #getEffort()
	 * @generated
	 */
	EReference getEffort_For_Workpackage();

	/**
	 * Returns the meta object for class '{@link ResearchProject.Workpackage <em>Workpackage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Workpackage</em>'.
	 * @see ResearchProject.Workpackage
	 * @generated
	 */
	EClass getWorkpackage();

	/**
	 * Returns the meta object for the reference list '{@link ResearchProject.Workpackage#getPackageEffort <em>Package Effort</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Package Effort</em>'.
	 * @see ResearchProject.Workpackage#getPackageEffort()
	 * @see #getWorkpackage()
	 * @generated
	 */
	EReference getWorkpackage_PackageEffort();

	/**
	 * Returns the meta object for the containment reference list '{@link ResearchProject.Workpackage#getDeliverables <em>Deliverables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Deliverables</em>'.
	 * @see ResearchProject.Workpackage#getDeliverables()
	 * @see #getWorkpackage()
	 * @generated
	 */
	EReference getWorkpackage_Deliverables();

	/**
	 * Returns the meta object for the containment reference list '{@link ResearchProject.Workpackage#getTasks <em>Tasks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tasks</em>'.
	 * @see ResearchProject.Workpackage#getTasks()
	 * @see #getWorkpackage()
	 * @generated
	 */
	EReference getWorkpackage_Tasks();

	/**
	 * Returns the meta object for class '{@link ResearchProject.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task</em>'.
	 * @see ResearchProject.Task
	 * @generated
	 */
	EClass getTask();

	/**
	 * Returns the meta object for class '{@link ResearchProject.Deliverable <em>Deliverable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deliverable</em>'.
	 * @see ResearchProject.Deliverable
	 * @generated
	 */
	EClass getDeliverable();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ResearchProjectFactory getResearchProjectFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link ResearchProject.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ResearchProject.impl.NamedElementImpl
		 * @see ResearchProject.impl.ResearchProjectPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link ResearchProject.impl.TimedElementImpl <em>Timed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ResearchProject.impl.TimedElementImpl
		 * @see ResearchProject.impl.ResearchProjectPackageImpl#getTimedElement()
		 * @generated
		 */
		EClass TIMED_ELEMENT = eINSTANCE.getTimedElement();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMED_ELEMENT__START = eINSTANCE.getTimedElement_Start();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMED_ELEMENT__END = eINSTANCE.getTimedElement_End();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMED_ELEMENT__DURATION = eINSTANCE.getTimedElement_Duration();

		/**
		 * The meta object literal for the '{@link ResearchProject.impl.ProjectImpl <em>Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ResearchProject.impl.ProjectImpl
		 * @see ResearchProject.impl.ResearchProjectPackageImpl#getProject()
		 * @generated
		 */
		EClass PROJECT = eINSTANCE.getProject();

		/**
		 * The meta object literal for the '<em><b>Partners</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__PARTNERS = eINSTANCE.getProject_Partners();

		/**
		 * The meta object literal for the '<em><b>Workpackages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__WORKPACKAGES = eINSTANCE.getProject_Workpackages();

		/**
		 * The meta object literal for the '{@link ResearchProject.impl.PartnerImpl <em>Partner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ResearchProject.impl.PartnerImpl
		 * @see ResearchProject.impl.ResearchProjectPackageImpl#getPartner()
		 * @generated
		 */
		EClass PARTNER = eINSTANCE.getPartner();

		/**
		 * The meta object literal for the '<em><b>Efforts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTNER__EFFORTS = eINSTANCE.getPartner_Efforts();

		/**
		 * The meta object literal for the '{@link ResearchProject.impl.EffortImpl <em>Effort</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ResearchProject.impl.EffortImpl
		 * @see ResearchProject.impl.ResearchProjectPackageImpl#getEffort()
		 * @generated
		 */
		EClass EFFORT = eINSTANCE.getEffort();

		/**
		 * The meta object literal for the '<em><b>Person Months</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFFORT__PERSON_MONTHS = eINSTANCE.getEffort_PersonMonths();

		/**
		 * The meta object literal for the '<em><b>For Workpackage</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EFFORT__FOR_WORKPACKAGE = eINSTANCE.getEffort_For_Workpackage();

		/**
		 * The meta object literal for the '{@link ResearchProject.impl.WorkpackageImpl <em>Workpackage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ResearchProject.impl.WorkpackageImpl
		 * @see ResearchProject.impl.ResearchProjectPackageImpl#getWorkpackage()
		 * @generated
		 */
		EClass WORKPACKAGE = eINSTANCE.getWorkpackage();

		/**
		 * The meta object literal for the '<em><b>Package Effort</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKPACKAGE__PACKAGE_EFFORT = eINSTANCE.getWorkpackage_PackageEffort();

		/**
		 * The meta object literal for the '<em><b>Deliverables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKPACKAGE__DELIVERABLES = eINSTANCE.getWorkpackage_Deliverables();

		/**
		 * The meta object literal for the '<em><b>Tasks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKPACKAGE__TASKS = eINSTANCE.getWorkpackage_Tasks();

		/**
		 * The meta object literal for the '{@link ResearchProject.impl.TaskImpl <em>Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ResearchProject.impl.TaskImpl
		 * @see ResearchProject.impl.ResearchProjectPackageImpl#getTask()
		 * @generated
		 */
		EClass TASK = eINSTANCE.getTask();

		/**
		 * The meta object literal for the '{@link ResearchProject.impl.DeliverableImpl <em>Deliverable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ResearchProject.impl.DeliverableImpl
		 * @see ResearchProject.impl.ResearchProjectPackageImpl#getDeliverable()
		 * @generated
		 */
		EClass DELIVERABLE = eINSTANCE.getDeliverable();

	}

} //ResearchProjectPackage
