package com.test.servicebuilder.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.test.servicebuilder.service.http.FooServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.test.servicebuilder.service.http.FooServiceSoap
 * @generated
 */
public class FooSoap implements Serializable {
    private String _uuid;
    private long _fooId;
    private String _userName;

    public FooSoap() {
    }

    public static FooSoap toSoapModel(Foo model) {
        FooSoap soapModel = new FooSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setFooId(model.getFooId());
        soapModel.setUserName(model.getUserName());

        return soapModel;
    }

    public static FooSoap[] toSoapModels(Foo[] models) {
        FooSoap[] soapModels = new FooSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static FooSoap[][] toSoapModels(Foo[][] models) {
        FooSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new FooSoap[models.length][models[0].length];
        } else {
            soapModels = new FooSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static FooSoap[] toSoapModels(List<Foo> models) {
        List<FooSoap> soapModels = new ArrayList<FooSoap>(models.size());

        for (Foo model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new FooSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _fooId;
    }

    public void setPrimaryKey(long pk) {
        setFooId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getFooId() {
        return _fooId;
    }

    public void setFooId(long fooId) {
        _fooId = fooId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }
}
