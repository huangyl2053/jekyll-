/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.basic.helper;

import jp.co.ndensan.reams.db.dbx.entity.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.ur.urz.persistence.db.IInsertable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;

/**
 * 高額介護サービス費のテストで使用するInserterです。
 *
 * @author n8178 城間篤人
 */
public class KogakuKaigoServiceHiInserter implements IInsertable<DbT3057KogakuShikyuHanteiKekkaEntity> {

    @InjectSession
    private static SqlSession session;

    @Override
    public int insert(DbT3057KogakuShikyuHanteiKekkaEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(data).execute();
    }
}
