/**
 */
package ResearchProject;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Timed Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ResearchProject.TimedElement#getStart <em>Start</em>}</li>
 *   <li>{@link ResearchProject.TimedElement#getEnd <em>End</em>}</li>
 *   <li>{@link ResearchProject.TimedElement#getDuration <em>Duration</em>}</li>
 * </ul>
 *
 * @see ResearchProject.ResearchProjectPackage#getTimedElement()
 * @model abstract="true"
 * @generated
 */
public interface TimedElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see #setStart(Integer)
	 * @see ResearchProject.ResearchProjectPackage#getTimedElement_Start()
	 * @model
	 * @generated
	 */
	Integer getStart();

	/**
	 * Sets the value of the '{@link ResearchProject.TimedElement#getStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' attribute.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(Integer value);

	/**
	 * Returns the value of the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' attribute.
	 * @see #setEnd(Integer)
	 * @see ResearchProject.ResearchProjectPackage#getTimedElement_End()
	 * @model
	 * @generated
	 */
	Integer getEnd();

	/**
	 * Sets the value of the '{@link ResearchProject.TimedElement#getEnd <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' attribute.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(Integer value);

	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see #setDuration(Integer)
	 * @see ResearchProject.ResearchProjectPackage#getTimedElement_Duration()
	 * @model
	 * @generated
	 */
	Integer getDuration();

	/**
	 * Sets the value of the '{@link ResearchProject.TimedElement#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(Integer value);

} // TimedElement
