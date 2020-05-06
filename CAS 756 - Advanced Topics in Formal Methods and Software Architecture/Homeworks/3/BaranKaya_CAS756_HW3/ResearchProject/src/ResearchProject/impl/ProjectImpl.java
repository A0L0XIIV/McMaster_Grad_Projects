/**
 */
package ResearchProject.impl;

import ResearchProject.Partner;
import ResearchProject.Project;
import ResearchProject.ResearchProjectPackage;
import ResearchProject.TimedElement;
import ResearchProject.Workpackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ResearchProject.impl.ProjectImpl#getStart <em>Start</em>}</li>
 *   <li>{@link ResearchProject.impl.ProjectImpl#getEnd <em>End</em>}</li>
 *   <li>{@link ResearchProject.impl.ProjectImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link ResearchProject.impl.ProjectImpl#getPartners <em>Partners</em>}</li>
 *   <li>{@link ResearchProject.impl.ProjectImpl#getWorkpackages <em>Workpackages</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProjectImpl extends NamedElementImpl implements Project {
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
	 * The cached value of the '{@link #getPartners() <em>Partners</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartners()
	 * @generated
	 * @ordered
	 */
	protected EList<Partner> partners;

	/**
	 * The cached value of the '{@link #getWorkpackages() <em>Workpackages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkpackages()
	 * @generated
	 * @ordered
	 */
	protected EList<Workpackage> workpackages;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResearchProjectPackage.Literals.PROJECT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResearchProjectPackage.PROJECT__START, oldStart, start));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResearchProjectPackage.PROJECT__END, oldEnd, end));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResearchProjectPackage.PROJECT__DURATION, oldDuration, duration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Partner> getPartners() {
		if (partners == null) {
			partners = new EObjectContainmentEList<Partner>(Partner.class, this, ResearchProjectPackage.PROJECT__PARTNERS);
		}
		return partners;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Workpackage> getWorkpackages() {
		if (workpackages == null) {
			workpackages = new EObjectContainmentEList<Workpackage>(Workpackage.class, this, ResearchProjectPackage.PROJECT__WORKPACKAGES);
		}
		return workpackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResearchProjectPackage.PROJECT__PARTNERS:
				return ((InternalEList<?>)getPartners()).basicRemove(otherEnd, msgs);
			case ResearchProjectPackage.PROJECT__WORKPACKAGES:
				return ((InternalEList<?>)getWorkpackages()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResearchProjectPackage.PROJECT__START:
				return getStart();
			case ResearchProjectPackage.PROJECT__END:
				return getEnd();
			case ResearchProjectPackage.PROJECT__DURATION:
				return getDuration();
			case ResearchProjectPackage.PROJECT__PARTNERS:
				return getPartners();
			case ResearchProjectPackage.PROJECT__WORKPACKAGES:
				return getWorkpackages();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ResearchProjectPackage.PROJECT__START:
				setStart((Integer)newValue);
				return;
			case ResearchProjectPackage.PROJECT__END:
				setEnd((Integer)newValue);
				return;
			case ResearchProjectPackage.PROJECT__DURATION:
				setDuration((Integer)newValue);
				return;
			case ResearchProjectPackage.PROJECT__PARTNERS:
				getPartners().clear();
				getPartners().addAll((Collection<? extends Partner>)newValue);
				return;
			case ResearchProjectPackage.PROJECT__WORKPACKAGES:
				getWorkpackages().clear();
				getWorkpackages().addAll((Collection<? extends Workpackage>)newValue);
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
			case ResearchProjectPackage.PROJECT__START:
				setStart(START_EDEFAULT);
				return;
			case ResearchProjectPackage.PROJECT__END:
				setEnd(END_EDEFAULT);
				return;
			case ResearchProjectPackage.PROJECT__DURATION:
				setDuration(DURATION_EDEFAULT);
				return;
			case ResearchProjectPackage.PROJECT__PARTNERS:
				getPartners().clear();
				return;
			case ResearchProjectPackage.PROJECT__WORKPACKAGES:
				getWorkpackages().clear();
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
			case ResearchProjectPackage.PROJECT__START:
				return START_EDEFAULT == null ? start != null : !START_EDEFAULT.equals(start);
			case ResearchProjectPackage.PROJECT__END:
				return END_EDEFAULT == null ? end != null : !END_EDEFAULT.equals(end);
			case ResearchProjectPackage.PROJECT__DURATION:
				return DURATION_EDEFAULT == null ? duration != null : !DURATION_EDEFAULT.equals(duration);
			case ResearchProjectPackage.PROJECT__PARTNERS:
				return partners != null && !partners.isEmpty();
			case ResearchProjectPackage.PROJECT__WORKPACKAGES:
				return workpackages != null && !workpackages.isEmpty();
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
				case ResearchProjectPackage.PROJECT__START: return ResearchProjectPackage.TIMED_ELEMENT__START;
				case ResearchProjectPackage.PROJECT__END: return ResearchProjectPackage.TIMED_ELEMENT__END;
				case ResearchProjectPackage.PROJECT__DURATION: return ResearchProjectPackage.TIMED_ELEMENT__DURATION;
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
				case ResearchProjectPackage.TIMED_ELEMENT__START: return ResearchProjectPackage.PROJECT__START;
				case ResearchProjectPackage.TIMED_ELEMENT__END: return ResearchProjectPackage.PROJECT__END;
				case ResearchProjectPackage.TIMED_ELEMENT__DURATION: return ResearchProjectPackage.PROJECT__DURATION;
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

} //ProjectImpl
