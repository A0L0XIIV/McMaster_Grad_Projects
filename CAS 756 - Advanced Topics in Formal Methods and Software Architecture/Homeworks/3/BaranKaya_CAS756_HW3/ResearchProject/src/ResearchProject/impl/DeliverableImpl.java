/**
 */
package ResearchProject.impl;

import ResearchProject.Deliverable;
import ResearchProject.ResearchProjectPackage;
import ResearchProject.TimedElement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deliverable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ResearchProject.impl.DeliverableImpl#getStart <em>Start</em>}</li>
 *   <li>{@link ResearchProject.impl.DeliverableImpl#getEnd <em>End</em>}</li>
 *   <li>{@link ResearchProject.impl.DeliverableImpl#getDuration <em>Duration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeliverableImpl extends NamedElementImpl implements Deliverable {
	/**
	 * The default value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected static final Integer START_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected Integer start = START_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnd() <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd()
	 * @generated
	 * @ordered
	 */
	protected static final Integer END_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnd() <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd()
	 * @generated
	 * @ordered
	 */
	protected Integer end = END_EDEFAULT;

	/**
	 * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected static final Integer DURATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected Integer duration = DURATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeliverableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResearchProjectPackage.Literals.DELIVERABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getStart() {
		return start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStart(Integer newStart) {
		Integer oldStart = start;
		start = newStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResearchProjectPackage.DELIVERABLE__START, oldStart, start));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getEnd() {
		return end;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnd(Integer newEnd) {
		Integer oldEnd = end;
		end = newEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResearchProjectPackage.DELIVERABLE__END, oldEnd, end));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDuration(Integer newDuration) {
		Integer oldDuration = duration;
		duration = newDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResearchProjectPackage.DELIVERABLE__DURATION, oldDuration, duration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResearchProjectPackage.DELIVERABLE__START:
				return getStart();
			case ResearchProjectPackage.DELIVERABLE__END:
				return getEnd();
			case ResearchProjectPackage.DELIVERABLE__DURATION:
				return getDuration();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ResearchProjectPackage.DELIVERABLE__START:
				setStart((Integer)newValue);
				return;
			case ResearchProjectPackage.DELIVERABLE__END:
				setEnd((Integer)newValue);
				return;
			case ResearchProjectPackage.DELIVERABLE__DURATION:
				setDuration((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ResearchProjectPackage.DELIVERABLE__START:
				setStart(START_EDEFAULT);
				return;
			case ResearchProjectPackage.DELIVERABLE__END:
				setEnd(END_EDEFAULT);
				return;
			case ResearchProjectPackage.DELIVERABLE__DURATION:
				setDuration(DURATION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ResearchProjectPackage.DELIVERABLE__START:
				return START_EDEFAULT == null ? start != null : !START_EDEFAULT.equals(start);
			case ResearchProjectPackage.DELIVERABLE__END:
				return END_EDEFAULT == null ? end != null : !END_EDEFAULT.equals(end);
			case ResearchProjectPackage.DELIVERABLE__DURATION:
				return DURATION_EDEFAULT == null ? duration != null : !DURATION_EDEFAULT.equals(duration);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == TimedElement.class) {
			switch (derivedFeatureID) {
				case ResearchProjectPackage.DELIVERABLE__START: return ResearchProjectPackage.TIMED_ELEMENT__START;
				case ResearchProjectPackage.DELIVERABLE__END: return ResearchProjectPackage.TIMED_ELEMENT__END;
				case ResearchProjectPackage.DELIVERABLE__DURATION: return ResearchProjectPackage.TIMED_ELEMENT__DURATION;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == TimedElement.class) {
			switch (baseFeatureID) {
				case ResearchProjectPackage.TIMED_ELEMENT__START: return ResearchProjectPackage.DELIVERABLE__START;
				case ResearchProjectPackage.TIMED_ELEMENT__END: return ResearchProjectPackage.DELIVERABLE__END;
				case ResearchProjectPackage.TIMED_ELEMENT__DURATION: return ResearchProjectPackage.DELIVERABLE__DURATION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (start: ");
		result.append(start);
		result.append(", end: ");
		result.append(end);
		result.append(", duration: ");
		result.append(duration);
		result.append(')');
		return result.toString();
	}

} //DeliverableImpl
