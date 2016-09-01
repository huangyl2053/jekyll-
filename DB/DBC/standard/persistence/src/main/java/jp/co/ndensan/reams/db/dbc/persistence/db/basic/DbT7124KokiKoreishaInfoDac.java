/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7124KokiKoreishaInfo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7124KokiKoreishaInfo.shikibetsuCd;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7124KokiKoreishaInfoEntity;
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
 * 後期高齢者情報テーブルのデータアクセスクラスです。
 *
 * @reamsid_L DBD-5740-010 liuyl
 */
public class DbT7124KokiKoreishaInfoDac implements ISaveable<DbT7124KokiKoreishaInfoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 後期高齢者情報を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @return 後期高齢者情報
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7124KokiKoreishaInfoEntity selectByKey(ShikibetsuCode 識別コード) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7124KokiKoreishaInfo.class).
                where(
                        eq(shikibetsuCd, 識別コード)).
                order(by(DbT7124KokiKoreishaInfo.rirekiNo, Order.DESC)).
                limit(1).
                toObject(DbT7124KokiKoreishaInfoEntity.class);
    }

    /**
     * 後期高齢者情報を登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity DbT7124KokiKoreishaInfoEntity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7124KokiKoreishaInfoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("後期高齢者情報エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
