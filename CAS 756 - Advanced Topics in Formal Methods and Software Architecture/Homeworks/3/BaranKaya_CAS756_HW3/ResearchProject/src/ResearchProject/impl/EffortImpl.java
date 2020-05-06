/**
 */
package ResearchProject.impl;

import ResearchProject.Effort;
import ResearchProject.ResearchProjectPackage;
import ResearchProject.Workpackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Effort</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ResearchProject.impl.EffortImpl#getPersonMonths <em>Person Months</em>}</li>
 *   <li>{@link ResearchProject.impl.EffortImpl#getFor_Workpackage <em>For Workpackage</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EffortImpl extends EObjectImpl implements Effort {
	/**
	 * The default value of the '{@link #getPersonMonths() <em>Person Months</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersonMonths()
	 * @generated
	 * @ordered
	 */
	protected static final Integer PERSON_MONTHS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPersonMonths() <em>Person Months</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersonMonths()
	 * @generated
	 * @ordered
	 */
	protected Integer personMonths = PERSON_MONTHS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFor_Workpackage() <em>For Workpackage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFor_Workpackage()
	 * @generated
	 * @ordered
	 */
	protected Workpackage for_Workpackage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EffortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResearchProjectPackage.Literals.EFFORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getPersonMonths() {
		return personMonths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPersonMonths(Integer newPersonMonths) {
		Integer oldPersonMonths = personMonths;
		personMonths = newPersonMonths;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResearchProjectPackage.EFFORT__PERSON_MONTHS, oldPersonMonths, personMonths));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Workpackage getFor_Workpackage() {
		if (for_Workpackage != null && for_Workpackage.eIsProxy()) {
			InternalEObject oldFor_Workpackage = (InternalEObject)for_Workpackage;
			for_Workpackage = (Workpackage)eResolveProxy(oldFor_Workpackage);
			if (for_Workpackage != oldFor_Workpackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResearchProjectPackage.EFFORT__FOR_WORKPACKAGE, oldFor_Workpackage, for_Workpackage));
			}
		}
		return for_Workpackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Workpackage basicGetFor_Workpackage() {
		return for_Workpackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFor_Workpackage(Workpackage newFor_Workpackage, NotificationChain msgs) {
		Workpackage oldFor_Workpackage = for_Workpackage;
		for_Workpackage = newFor_Workpackage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResearchProjectPackage.EFFORT__FOR_WORKPACKAGE, oldFor_Workpackage, newFor_Workpackage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFor_Workpackage(Workpackage newFor_Workpackage) {
		if (newFor_Workpackage != for_Workpackage) {
			NotificationChain msgs = null;
			if (for_Workpackage != null)
				msgs = ((InternalEObject)for_Workpackage).eInverseRemove(this, ResearchProjectPackage.WORKPACKAGE__PACKAGE_EFFORT, Workpackage.class, msgs);
			if (newFor_Workpackage != null)
				msgs = ((InternalEObject)newFor_Workpackage).eInverseAdd(this, ResearchProjectPackage.WORKPACKAGE__PACKAGE_EFFORT, Workpackage.class, msgs);
			msgs = basicSetFor_Workpackage(newFor_Workpackage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResearchProjectPackage.EFFORT__FOR_WORKPACKAGE, newFor_Workpackage, newFor_Workpackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResearchProjectPackage.EFFORT__FOR_WORKPACKAGE:
				if (for_Workpackage != null)
					msgs = ((InternalEObject)for_Workpackage).eInverseRemove(this, ResearchProjectPackage.WORKPACKAGE__PACKAGE_EFFORT, Workpackage.class, msgs);
				return basicSetFor_Workpackage((Workpackage)otherEnd, msgs);
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
			case ResearchProjectPackage.EFFORT__FOR_WORKPACKAGE:
				return basicSetFor_Workpackage(null, msgs);
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
			case ResearchProjectPackage.EFFORT__PERSON_MONTHS:
				return getPersonMonths();
			case ResearchProjectPackage.EFFORT__FOR_WORKPACKAGE:
				if (resolve) return getFor_Workpackage();
				return basicGetFor_Workpackage();
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
			case ResearchProjectPackage.EFFORT__PERSON_MONTHS:
				setPersonMonths((Integer)newValue);
				return;
			case ResearchProjectPackage.EFFORT__FOR_WORKPACKAGE:
				setFor_Workpackage((Workpackage)newValue);
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
			case ResearchProjectPackage.EFFORT__PERSON_MONTHS:
				setPersonMonths(PERSON_MONTHS_EDEFAULT);
				return;
			case ResearchProjectPackage.EFFORT__FOR_WORKPACKAGE:
				setFor_Workpackage((Workpackage)null);
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
			case ResearchProjectPackage.EFFORT__PERSON_MONTHS:
				return PERSON_MONTHS_EDEFAULT == null ? personMonths != null : !PERSON_MONTHS_EDEFAULT.equals(personMonths);
			case ResearchProjectPackage.EFFORT__FOR_WORKPACKAGE:
				return for_Workpackage != null;
		}
		return super.eIsSet(featureID);
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
		result.append(" (PersonMonths: ");
		result.append(personMonths);
		result.append(')');
		return result.toString();
	}

} //EffortImpl
