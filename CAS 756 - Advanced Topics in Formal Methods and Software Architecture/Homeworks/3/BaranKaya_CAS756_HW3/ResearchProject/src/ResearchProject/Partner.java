/**
 */
package ResearchProject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Partner</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ResearchProject.Partner#getEfforts <em>Efforts</em>}</li>
 * </ul>
 *
 * @see ResearchProject.ResearchProjectPackage#getPartner()
 * @model annotation="gmf.node label='name' figure='rectangle' color='255,200,200'"
 * @generated
 */
public interface Partner extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Efforts</b></em>' containment reference list.
	 * The list contents are of type {@link ResearchProject.Effort}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Efforts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Efforts</em>' containment reference list.
	 * @see ResearchProject.ResearchProjectPackage#getPartner_Efforts()
	 * @model containment="true" required="true"
	 *        annotation="gmf.link target.decoration='arrow' color='0,0,0' label='Person/Months'"
	 * @generated
	 */
	EList<Effort> getEfforts();

} // Partner
