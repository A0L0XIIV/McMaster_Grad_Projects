/**
 */
package ResearchProject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ResearchProject.Project#getPartners <em>Partners</em>}</li>
 *   <li>{@link ResearchProject.Project#getWorkpackages <em>Workpackages</em>}</li>
 * </ul>
 *
 * @see ResearchProject.ResearchProjectPackage#getProject()
 * @model
 * @generated
 */
public interface Project extends NamedElement, TimedElement {
	/**
	 * Returns the value of the '<em><b>Partners</b></em>' containment reference list.
	 * The list contents are of type {@link ResearchProject.Partner}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partners</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partners</em>' containment reference list.
	 * @see ResearchProject.ResearchProjectPackage#getProject_Partners()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Partner> getPartners();

	/**
	 * Returns the value of the '<em><b>Workpackages</b></em>' containment reference list.
	 * The list contents are of type {@link ResearchProject.Workpackage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workpackages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workpackages</em>' containment reference list.
	 * @see ResearchProject.ResearchProjectPackage#getProject_Workpackages()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Workpackage> getWorkpackages();

} // Project
