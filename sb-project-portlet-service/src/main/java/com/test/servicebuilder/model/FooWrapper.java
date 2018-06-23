package com.test.servicebuilder.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Foo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Foo
 * @generated
 */
public class FooWrapper implements Foo, ModelWrapper<Foo> {
    private Foo _foo;

    public FooWrapper(Foo foo) {
        _foo = foo;
    }

    @Override
    public Class<?> getModelClass() {
        return Foo.class;
    }

    @Override
    public String getModelClassName() {
        return Foo.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("fooId", getFooId());
        attributes.put("userName", getUserName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long fooId = (Long) attributes.get("fooId");

        if (fooId != null) {
            setFooId(fooId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }
    }

    /**
    * Returns the primary key of this foo.
    *
    * @return the primary key of this foo
    */
    @Override
    public long getPrimaryKey() {
        return _foo.getPrimaryKey();
    }

    /**
    * Sets the primary key of this foo.
    *
    * @param primaryKey the primary key of this foo
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _foo.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this foo.
    *
    * @return the uuid of this foo
    */
    @Override
    public java.lang.String getUuid() {
        return _foo.getUuid();
    }

    /**
    * Sets the uuid of this foo.
    *
    * @param uuid the uuid of this foo
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _foo.setUuid(uuid);
    }

    /**
    * Returns the foo ID of this foo.
    *
    * @return the foo ID of this foo
    */
    @Override
    public long getFooId() {
        return _foo.getFooId();
    }

    /**
    * Sets the foo ID of this foo.
    *
    * @param fooId the foo ID of this foo
    */
    @Override
    public void setFooId(long fooId) {
        _foo.setFooId(fooId);
    }

    /**
    * Returns the user name of this foo.
    *
    * @return the user name of this foo
    */
    @Override
    public java.lang.String getUserName() {
        return _foo.getUserName();
    }

    /**
    * Sets the user name of this foo.
    *
    * @param userName the user name of this foo
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _foo.setUserName(userName);
    }

    @Override
    public boolean isNew() {
        return _foo.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _foo.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _foo.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _foo.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _foo.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _foo.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _foo.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _foo.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _foo.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _foo.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _foo.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new FooWrapper((Foo) _foo.clone());
    }

    @Override
    public int compareTo(com.test.servicebuilder.model.Foo foo) {
        return _foo.compareTo(foo);
    }

    @Override
    public int hashCode() {
        return _foo.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.test.servicebuilder.model.Foo> toCacheModel() {
        return _foo.toCacheModel();
    }

    @Override
    public com.test.servicebuilder.model.Foo toEscapedModel() {
        return new FooWrapper(_foo.toEscapedModel());
    }

    @Override
    public com.test.servicebuilder.model.Foo toUnescapedModel() {
        return new FooWrapper(_foo.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _foo.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _foo.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _foo.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof FooWrapper)) {
            return false;
        }

        FooWrapper fooWrapper = (FooWrapper) obj;

        if (Validator.equals(_foo, fooWrapper._foo)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Foo getWrappedFoo() {
        return _foo;
    }

    @Override
    public Foo getWrappedModel() {
        return _foo;
    }

    @Override
    public void resetOriginalValues() {
        _foo.resetOriginalValues();
    }
}
