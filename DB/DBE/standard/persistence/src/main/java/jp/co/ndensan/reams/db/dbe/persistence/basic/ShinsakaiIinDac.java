/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5102ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5102ShinsakaiIinJoho;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5102ShinsakaiIinJoho.*;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 審査会委員情報の取得を行うDacです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiIinDac {

    @InjectSession
    private SqlSession session;

    /**
     * 審査会委員コードのListを元に、複数の審査会委員の情報を取得します。
     *
     * @param 審査会委員コードList 審査会委員コードList
     * @return 審査会委員EntityList
     */
    @Transaction
    public List<DbT5102ShinsakaiIinJohoEntity> select審査会委員(List<ShinsakaiIinCode> 審査会委員コードList) {
        //TODO n8178 城間篤人 審査会委員本実装の際に実装予定 2014年9月末
        return null;
    }

    /**
     * 審査会委員コードを元に、審査会委員の情報を取得します。
     *
     * @param 審査会委員コード 審査会委員コード
     * @return 審査会委員Entity
     */
    @Transaction
    public DbT5102ShinsakaiIinJohoEntity select審査会委員(ShinsakaiIinCode 審査会委員コード) {
        return null;
    }

    /**
     * 委員状況を調べて、現在有効な審査会委員の情報を全て取得します。
     *
     * @return 現在有効な審査会委員EntityのList
     */
    @Transaction
    public List<DbT5102ShinsakaiIinJohoEntity> select有効審査会委員List() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5102ShinsakaiIinJoho.class)
                .where(eq(shinsakaiIinJokyo, true))
                .toList(DbT5102ShinsakaiIinJohoEntity.class);
    }
}
