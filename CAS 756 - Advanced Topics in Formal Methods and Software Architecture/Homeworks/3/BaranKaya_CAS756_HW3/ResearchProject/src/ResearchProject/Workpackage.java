/**
 */
package ResearchProject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workpackage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ResearchProject.Workpackage#getPackageEffort <em>Package Effort</em>}</li>
 *   <li>{@link ResearchProject.Workpackage#getDeliverables <em>Deliverables</em>}</li>
 *   <li>{@link ResearchProject.Workpackage#getTasks <em>Tasks</em>}</li>
 * </ul>
 *
 * @see ResearchProject.ResearchProjectPackage#getWorkpackage()
 * @model annotation="gmf.node label='name'"
 * @generated
 */
public interface Workpackage extends NamedElement, TimedElement {
	/**
	 * Returns the value of the '<em><b>Package Effort</b></em>' reference list.
	 * The list contents are of type {@link ResearchProject.Effort}.
	 * It is bidirectional and its opposite is '{@link ResearchProject.Effort#getFor_Workpackage <em>For Workpackage</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package Effort</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Effort</em>' reference list.
	 * @see ResearchProject.ResearchProjectPackage#getWorkpackage_PackageEffort()
	 * @see ResearchProject.Effort#getFor_Workpackage
	 * @model opposite="for_Workpackage" required="true"
	 * @generated
	 */
	EList<Effort> getPackageEffort();

	/**
	 * Returns the value of the '<em><b>Deliverables</b></em>' containment reference list.
	 * The list contents are of type {@link ResearchProject.Deliverable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deliverables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deliverables</em>' containment reference list.
	 * @see ResearchProject.ResearchProjectPackage#getWorkpackage_Deliverables()
	 * @model containment="true" required="true"
	 *        annotation="gmf.compartment layout='list' collapsible='false'"
	 * @generated
	 */
	EList<Deliverable> getDeliverables();

	/**
	 * Returns the value of the '<em><b>Tasks</b></em>' containment reference list.
	 * The list contents are of type {@link ResearchProject.Task}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tasks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tasks</em>' containment reference list.
	 * @see ResearchProject.ResearchProjectPackage#getWorkpackage_Tasks()
	 * @model containment="true" required="true"
	 *        annotation="gmf.compartment layout='list' collapsible='false'"
	 * @generated
	 */
	EList<Task> getTasks();

} // Workpackage
