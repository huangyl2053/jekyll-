/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4012HyojunFutangakuGemmen;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4012HyojunFutangakuGemmen.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4012HyojunFutangakuGemmen.rirekiNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4012HyojunFutangakuGemmen.shoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4012HyojunFutangakuGemmenEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 標準負担額減免のデータアクセスクラスです。
 *
 * @reamsid_L DBC-9999-012 xicongwang
 */
public class DbT4012HyojunFutangakuGemmenDac {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで支払方法変更を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @return DbT4012HyojunFutangakuGemmenEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4012HyojunFutangakuGemmenEntity selectByKey(
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            int 履歴番号) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4012HyojunFutangakuGemmen.class).
                where(and(
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT4012HyojunFutangakuGemmenEntity.class);
    }

    /**
     * 支払方法変更を全件返します。
     *
     * @return DbT4012HyojunFutangakuGemmenEntityの{@code list}
     */
    @Transaction
    public List<DbT4012HyojunFutangakuGemmenEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4012HyojunFutangakuGemmen.class).
                toList(DbT4012HyojunFutangakuGemmenEntity.class);
    }

    /**
     * DbT4012HyojunFutangakuGemmenEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int save(DbT4012HyojunFutangakuGemmenEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("支払方法変更エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * キーで支払方法変更を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @return DbT4012HyojunFutangakuGemmenEntity
     */
    @Transaction
    public DbT4012HyojunFutangakuGemmenEntity selectByKey(
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4012HyojunFutangakuGemmen.class).
                where(and(
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(hihokenshaNo, 被保険者番号))).
                order(by(rirekiNo, Order.DESC)).limit(1).
                toObject(DbT4012HyojunFutangakuGemmenEntity.class);
    }

    /**
     * 標準負担額減免情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return DbT4012HyojunFutangakuGemmenEntity
     */
    @Transaction
    public List<DbT4012HyojunFutangakuGemmenEntity> select標準負担額減免申請情報(HihokenshaNo 被保険者番号) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT4012HyojunFutangakuGemmen.class).
                where(eq(DbT4012HyojunFutangakuGemmen.hihokenshaNo, 被保険者番号)).
                order(by(DbT4012HyojunFutangakuGemmen.shinseiYMD, Order.DESC)).
                toList(DbT4012HyojunFutangakuGemmenEntity.class);
    }
}
