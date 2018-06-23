package com.test.servicebuilder.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.test.servicebuilder.service.ClpSerializer;
import com.test.servicebuilder.service.FooLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class FooClp extends BaseModelImpl<Foo> implements Foo {
    private String _uuid;
    private long _fooId;
    private String _userName;
    private BaseModel<?> _fooRemoteModel;
    private Class<?> _clpSerializerClass = com.test.servicebuilder.service.ClpSerializer.class;

    public FooClp() {
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
    public long getPrimaryKey() {
        return _fooId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setFooId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _fooId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_fooRemoteModel != null) {
            try {
                Class<?> clazz = _fooRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_fooRemoteModel, uuid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getFooId() {
        return _fooId;
    }

    @Override
    public void setFooId(long fooId) {
        _fooId = fooId;

        if (_fooRemoteModel != null) {
            try {
                Class<?> clazz = _fooRemoteModel.getClass();

                Method method = clazz.getMethod("setFooId", long.class);

                method.invoke(_fooRemoteModel, fooId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserName() {
        return _userName;
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;

        if (_fooRemoteModel != null) {
            try {
                Class<?> clazz = _fooRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_fooRemoteModel, userName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getFooRemoteModel() {
        return _fooRemoteModel;
    }

    public void setFooRemoteModel(BaseModel<?> fooRemoteModel) {
        _fooRemoteModel = fooRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _fooRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_fooRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            FooLocalServiceUtil.addFoo(this);
        } else {
            FooLocalServiceUtil.updateFoo(this);
        }
    }

    @Override
    public Foo toEscapedModel() {
        return (Foo) ProxyUtil.newProxyInstance(Foo.class.getClassLoader(),
            new Class[] { Foo.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        FooClp clone = new FooClp();

        clone.setUuid(getUuid());
        clone.setFooId(getFooId());
        clone.setUserName(getUserName());

        return clone;
    }

    @Override
    public int compareTo(Foo foo) {
        int value = 0;

        if (getFooId() < foo.getFooId()) {
            value = -1;
        } else if (getFooId() > foo.getFooId()) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof FooClp)) {
            return false;
        }

        FooClp foo = (FooClp) obj;

        long primaryKey = foo.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", fooId=");
        sb.append(getFooId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("com.test.servicebuilder.model.Foo");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fooId</column-name><column-value><![CDATA[");
        sb.append(getFooId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
