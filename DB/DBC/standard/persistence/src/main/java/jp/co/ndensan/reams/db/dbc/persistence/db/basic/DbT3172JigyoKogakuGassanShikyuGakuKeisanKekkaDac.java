/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3172JigyoKogakuGassanShikyuGakuKeisanKekka;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3172JigyoKogakuGassanShikyuGakuKeisanKekka.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3172JigyoKogakuGassanShikyuGakuKeisanKekka.isDeleted;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo; 
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 事業高額合算支給額計算結果情報取得のDacです。
 *
 * @reamsid_L DBC-4840-010 lihang
 */
public class DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaDac {

    @InjectSession
    private SqlSession session;

    /**
     * 被保険者番号を全件返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity>
     */
    @Transaction
    public List<DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity> select被保険者番号(HihokenshaNo 被保険者番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT3172JigyoKogakuGassanShikyuGakuKeisanKekka.class).
                where(and(
                                eq(isDeleted, false),
                                eq(hihokenshaNo, 被保険者番号))).
                toList(DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity.class);
    }

}
