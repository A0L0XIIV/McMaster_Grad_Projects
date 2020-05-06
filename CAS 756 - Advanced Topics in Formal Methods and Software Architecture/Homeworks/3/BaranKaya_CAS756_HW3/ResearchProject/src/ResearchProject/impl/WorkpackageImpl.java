/**
 */
package ResearchProject.impl;

import ResearchProject.Deliverable;
import ResearchProject.Effort;
import ResearchProject.ResearchProjectPackage;
import ResearchProject.Task;
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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Workpackage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ResearchProject.impl.WorkpackageImpl#getStart <em>Start</em>}</li>
 *   <li>{@link ResearchProject.impl.WorkpackageImpl#getEnd <em>End</em>}</li>
 *   <li>{@link ResearchProject.impl.WorkpackageImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link ResearchProject.impl.WorkpackageImpl#getPackageEffort <em>Package Effort</em>}</li>
 *   <li>{@link ResearchProject.impl.WorkpackageImpl#getDeliverables <em>Deliverables</em>}</li>
 *   <li>{@link ResearchProject.impl.WorkpackageImpl#getTasks <em>Tasks</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WorkpackageImpl extends NamedElementImpl implements Workpackage {
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
	 * The cached value of the '{@link #getPackageEffort() <em>Package Effort</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageEffort()
	 * @generated
	 * @ordered
	 */
	protected EList<Effort> packageEffort;

	/**
	 * The cached value of the '{@link #getDeliverables() <em>Deliverables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeliverables()
	 * @generated
	 * @ordered
	 */
	protected EList<Deliverable> deliverables;

	/**
	 * The cached value of the '{@link #getTasks() <em>Tasks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTasks()
	 * @generated
	 * @ordered
	 */
	protected EList<Task> tasks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkpackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResearchProjectPackage.Literals.WORKPACKAGE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResearchProjectPackage.WORKPACKAGE__START, oldStart, start));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResearchProjectPackage.WORKPACKAGE__END, oldEnd, end));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResearchProjectPackage.WORKPACKAGE__DURATION, oldDuration, duration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Effort> getPackageEffort() {
		if (packageEffort == null) {
			packageEffort = new EObjectWithInverseResolvingEList<Effort>(Effort.class, this, ResearchProjectPackage.WORKPACKAGE__PACKAGE_EFFORT, ResearchProjectPackage.EFFORT__FOR_WORKPACKAGE);
		}
		return packageEffort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Deliverable> getDeliverables() {
		if (deliverables == null) {
			deliverables = new EObjectContainmentEList<Deliverable>(Deliverable.class, this, ResearchProjectPackage.WORKPACKAGE__DELIVERABLES);
		}
		return deliverables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Task> getTasks() {
		if (tasks == null) {
			tasks = new EObjectContainmentEList<Task>(Task.class, this, ResearchProjectPackage.WORKPACKAGE__TASKS);
		}
		return tasks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResearchProjectPackage.WORKPACKAGE__PACKAGE_EFFORT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPackageEffort()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResearchProjectPackage.WORKPACKAGE__PACKAGE_EFFORT:
				return ((InternalEList<?>)getPackageEffort()).basicRemove(otherEnd, msgs);
			case ResearchProjectPackage.WORKPACKAGE__DELIVERABLES:
				return ((InternalEList<?>)getDeliverables()).basicRemove(otherEnd, msgs);
			case ResearchProjectPackage.WORKPACKAGE__TASKS:
				return ((InternalEList<?>)getTasks()).basicRemove(otherEnd, msgs);
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
			case ResearchProjectPackage.WORKPACKAGE__START:
				return getStart();
			case ResearchProjectPackage.WORKPACKAGE__END:
				return getEnd();
			case ResearchProjectPackage.WORKPACKAGE__DURATION:
				return getDuration();
			case ResearchProjectPackage.WORKPACKAGE__PACKAGE_EFFORT:
				return getPackageEffort();
			case ResearchProjectPackage.WORKPACKAGE__DELIVERABLES:
				return getDeliverables();
			case ResearchProjectPackage.WORKPACKAGE__TASKS:
				return getTasks();
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
			case ResearchProjectPackage.WORKPACKAGE__START:
				setStart((Integer)newValue);
				return;
			case ResearchProjectPackage.WORKPACKAGE__END:
				setEnd((Integer)newValue);
				return;
			case ResearchProjectPackage.WORKPACKAGE__DURATION:
				setDuration((Integer)newValue);
				return;
			case ResearchProjectPackage.WORKPACKAGE__PACKAGE_EFFORT:
				getPackageEffort().clear();
				getPackageEffort().addAll((Collection<? extends Effort>)newValue);
				return;
			case ResearchProjectPackage.WORKPACKAGE__DELIVERABLES:
				getDeliverables().clear();
				getDeliverables().addAll((Collection<? extends Deliverable>)newValue);
				return;
			case ResearchProjectPackage.WORKPACKAGE__TASKS:
				getTasks().clear();
				getTasks().addAll((Collection<? extends Task>)newValue);
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
			case ResearchProjectPackage.WORKPACKAGE__START:
				setStart(START_EDEFAULT);
				return;
			case ResearchProjectPackage.WORKPACKAGE__END:
				setEnd(END_EDEFAULT);
				return;
			case ResearchProjectPackage.WORKPACKAGE__DURATION:
				setDuration(DURATION_EDEFAULT);
				return;
			case ResearchProjectPackage.WORKPACKAGE__PACKAGE_EFFORT:
				getPackageEffort().clear();
				return;
			case ResearchProjectPackage.WORKPACKAGE__DELIVERABLES:
				getDeliverables().clear();
				return;
			case ResearchProjectPackage.WORKPACKAGE__TASKS:
				getTasks().clear();
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
			case ResearchProjectPackage.WORKPACKAGE__START:
				return START_EDEFAULT == null ? start != null : !START_EDEFAULT.equals(start);
			case ResearchProjectPackage.WORKPACKAGE__END:
				return END_EDEFAULT == null ? end != null : !END_EDEFAULT.equals(end);
			case ResearchProjectPackage.WORKPACKAGE__DURATION:
				return DURATION_EDEFAULT == null ? duration != null : !DURATION_EDEFAULT.equals(duration);
			case ResearchProjectPackage.WORKPACKAGE__PACKAGE_EFFORT:
				return packageEffort != null && !packageEffort.isEmpty();
			case ResearchProjectPackage.WORKPACKAGE__DELIVERABLES:
				return deliverables != null && !deliverables.isEmpty();
			case ResearchProjectPackage.WORKPACKAGE__TASKS:
				return tasks != null && !tasks.isEmpty();
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
				case ResearchProjectPackage.WORKPACKAGE__START: return ResearchProjectPackage.TIMED_ELEMENT__START;
				case ResearchProjectPackage.WORKPACKAGE__END: return ResearchProjectPackage.TIMED_ELEMENT__END;
				case ResearchProjectPackage.WORKPACKAGE__DURATION: return ResearchProjectPackage.TIMED_ELEMENT__DURATION;
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
				case ResearchProjectPackage.TIMED_ELEMENT__START: return ResearchProjectPackage.WORKPACKAGE__START;
				case ResearchProjectPackage.TIMED_ELEMENT__END: return ResearchProjectPackage.WORKPACKAGE__END;
				case ResearchProjectPackage.TIMED_ELEMENT__DURATION: return ResearchProjectPackage.WORKPACKAGE__DURATION;
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

} //WorkpackageImpl
