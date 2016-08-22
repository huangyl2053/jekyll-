/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1004ShisetsuNyutaisho;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1004ShisetsuNyutaisho.daichoShubetsu;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1004ShisetsuNyutaisho.rirekiNo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1004ShisetsuNyutaisho.shikibetsuCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.NullsOrder;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.db.OrderBy;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護保険施設入退所Aliveのデータアクセスクラスです。
 */
public class DbV1004ShisetsuNyutaishoAliveDac implements ISaveable<DbV1004ShisetsuNyutaishoEntity> {

    private static final int 件数_1 = 1;
    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護保険施設入退所Aliveを取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 履歴番号 RirekiNo
     * @return DbV1004ShisetsuNyutaishoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbV1004ShisetsuNyutaishoEntity selectByKey(
            ShikibetsuCode 識別コード,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV1004ShisetsuNyutaisho.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbV1004ShisetsuNyutaishoEntity.class);
    }

    /**
     * 介護保険施設入退所Aliveを全件返します。
     *
     * @return List<DbV1004ShisetsuNyutaishoEntity>
     */
    @Transaction
    public List<DbV1004ShisetsuNyutaishoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV1004ShisetsuNyutaisho.class).
                toList(DbV1004ShisetsuNyutaishoEntity.class);
    }

    /**
     * DbV1004ShisetsuNyutaishoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbV1004ShisetsuNyutaishoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護保険施設入退所Aliveエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 介護保険施設入退所の取得
     *
     * @param 識別コード ShikibetsuCode
     * @return DbT1004ShisetsuNyutaishoEntity
     */
    @Transaction
    public DbT1004ShisetsuNyutaishoEntity get施設入退所(ShikibetsuCode 識別コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV1004ShisetsuNyutaisho.class).
                where(eq(shikibetsuCode, 識別コード)).
                toObject(DbT1004ShisetsuNyutaishoEntity.class);
    }

    /**
     * 介護保険施設入退所の取得
     *
     * @param 識別コード ShikibetsuCode
     * @param 台帳種別 DaichoType
     * @return DbT1004ShisetsuNyutaishoEntity
     */
    @Transaction
    public DbT1004ShisetsuNyutaishoEntity get施設入退所Order(ShikibetsuCode 識別コード, RString 台帳種別) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV1004ShisetsuNyutaisho.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(daichoShubetsu, 台帳種別))).
                order(new OrderBy(rirekiNo, Order.DESC, NullsOrder.LAST)).
                limit(件数_1).
                toObject(DbT1004ShisetsuNyutaishoEntity.class);
    }
}
