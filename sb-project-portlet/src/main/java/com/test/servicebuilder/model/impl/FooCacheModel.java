package com.test.servicebuilder.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.test.servicebuilder.model.Foo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Foo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Foo
 * @generated
 */
public class FooCacheModel implements CacheModel<Foo>, Externalizable {
    public String uuid;
    public long fooId;
    public String userName;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", fooId=");
        sb.append(fooId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Foo toEntityModel() {
        FooImpl fooImpl = new FooImpl();

        if (uuid == null) {
            fooImpl.setUuid(StringPool.BLANK);
        } else {
            fooImpl.setUuid(uuid);
        }

        fooImpl.setFooId(fooId);

        if (userName == null) {
            fooImpl.setUserName(StringPool.BLANK);
        } else {
            fooImpl.setUserName(userName);
        }

        fooImpl.resetOriginalValues();

        return fooImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        fooId = objectInput.readLong();
        userName = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(fooId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }
    }
}
