/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyo.hiHokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyo.idoYMD;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.lt;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受給者訂正連絡票データ作成です
 *
 * @reamsid_L DBC-2102-010 fangyuan
 */
public class DbT3001JukyushaIdoRenrakuhyoSakuseiDac {

    @InjectSession
    private SqlSession session;

    /**
     * 受給者異動送付を全件返します。
     *
     * @param 被保険者番号 hiHokenshaNo
     * @param 異動年月日 idoYMD
     * @return List<DbT3001JukyushaIdoRenrakuhyoEntity>
     */
    @Transaction
    public DbT3001JukyushaIdoRenrakuhyoEntity select受給者訂正情報を取得(RString 被保険者番号, RString 異動年月日) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動年月日"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT3001JukyushaIdoRenrakuhyo.class).
                where(and(
                                eq(hiHokenshaNo, 被保険者番号),
                                lt(idoYMD, 異動年月日))).
                order(by(DbT3001JukyushaIdoRenrakuhyo.rirekiNo, Order.DESC)).
                limit(2).
                toObject(DbT3001JukyushaIdoRenrakuhyoEntity.class);
    }

}
