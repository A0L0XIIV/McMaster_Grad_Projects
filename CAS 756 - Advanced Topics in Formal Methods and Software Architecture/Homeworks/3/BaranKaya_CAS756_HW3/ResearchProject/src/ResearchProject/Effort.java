/**
 */
package ResearchProject;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Effort</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ResearchProject.Effort#getPersonMonths <em>Person Months</em>}</li>
 *   <li>{@link ResearchProject.Effort#getFor_Workpackage <em>For Workpackage</em>}</li>
 * </ul>
 *
 * @see ResearchProject.ResearchProjectPackage#getEffort()
 * @model annotation="gmf.node label='PersonMonths' figure='ellipse' color='200,255,200' phantom='true'"
 * @generated
 */
public interface Effort extends EObject {
	/**
	 * Returns the value of the '<em><b>Person Months</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Person Months</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Person Months</em>' attribute.
	 * @see #setPersonMonths(Integer)
	 * @see ResearchProject.ResearchProjectPackage#getEffort_PersonMonths()
	 * @model
	 * @generated
	 */
	Integer getPersonMonths();

	/**
	 * Sets the value of the '{@link ResearchProject.Effort#getPersonMonths <em>Person Months</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Person Months</em>' attribute.
	 * @see #getPersonMonths()
	 * @generated
	 */
	void setPersonMonths(Integer value);

	/**
	 * Returns the value of the '<em><b>For Workpackage</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link ResearchProject.Workpackage#getPackageEffort <em>Package Effort</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>For Workpackage</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>For Workpackage</em>' reference.
	 * @see #setFor_Workpackage(Workpackage)
	 * @see ResearchProject.ResearchProjectPackage#getEffort_For_Workpackage()
	 * @see ResearchProject.Workpackage#getPackageEffort
	 * @model opposite="packageEffort" required="true"
	 *        annotation="gmf.link target.decoration='arrow' color='0,0,0' label='for'"
	 * @generated
	 */
	Workpackage getFor_Workpackage();

	/**
	 * Sets the value of the '{@link ResearchProject.Effort#getFor_Workpackage <em>For Workpackage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>For Workpackage</em>' reference.
	 * @see #getFor_Workpackage()
	 * @generated
	 */
	void setFor_Workpackage(Workpackage value);

} // Effort
