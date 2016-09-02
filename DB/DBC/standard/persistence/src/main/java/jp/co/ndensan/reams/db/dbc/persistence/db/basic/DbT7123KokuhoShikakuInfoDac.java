/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7123KokuhoShikakuInfo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7123KokuhoShikakuInfo.shikibetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7123KokuhoShikakuInfoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 国保資格詳細情報のデータアクセスクラスです。
 *
 * @reamsid_L DBD-5730-010 tianyh
 */
public class DbT7123KokuhoShikakuInfoDac implements ISaveable<DbT7123KokuhoShikakuInfoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで特定診療サービスコードを取得します。
     *
     * @param 識別コード shikibetsuCode
     * @return DbT7123KokuhoShikakuInfoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7123KokuhoShikakuInfoEntity selectByKey(
            ShikibetsuCode 識別コード
    ) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7123KokuhoShikakuInfo.class).
                where(
                        eq(shikibetsuCode, 識別コード)).
                order(by(DbT7123KokuhoShikakuInfo.rirekiNo, Order.DESC)).
                limit(1).
                toObject(DbT7123KokuhoShikakuInfoEntity.class);
    }

    @Override
    public int save(DbT7123KokuhoShikakuInfoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("国保資格情報テーブルエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

}
