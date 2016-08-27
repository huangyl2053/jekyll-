/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3005KyotakuKeikakuTodokede;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3005KyotakuKeikakuTodokede.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3005KyotakuKeikakuTodokede.rirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3005KyotakuKeikakuTodokede.taishoYM;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3005KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 居宅給付計画届出のデータアクセスクラスです。
 */
public class DbT3005KyotakuKeikakuTodokedeDac implements ISaveable<DbT3005KyotakuKeikakuTodokedeEntity>,
        IDeletable<DbT3005KyotakuKeikakuTodokedeEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで居宅給付計画届出を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 TaishoYM
     * @param 履歴番号 RirekiNo
     * @return DbT3005KyotakuKeikakuTodokedeEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3005KyotakuKeikakuTodokedeEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            int 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3005KyotakuKeikakuTodokede.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoYM, 対象年月),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3005KyotakuKeikakuTodokedeEntity.class);
    }

    /**
     * 最大履歴番号居宅給付計画届出を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return DbT3005KyotakuKeikakuTodokedeEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3005KyotakuKeikakuTodokedeEntity select最大履歴番号(HihokenshaNo 被保険者番号)
            throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3005KyotakuKeikakuTodokede.class).
                where(eq(hihokenshaNo, 被保険者番号)).
                order(by(rirekiNo, Order.DESC)).
                limit(1).
                toObject(DbT3005KyotakuKeikakuTodokedeEntity.class);
    }

    /**
     * 居宅給付計画届出を全件返します。
     *
     * @return List<DbT3005KyotakuKeikakuTodokedeEntity>
     */
    @Transaction
    public List<DbT3005KyotakuKeikakuTodokedeEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3005KyotakuKeikakuTodokede.class).
                toList(DbT3005KyotakuKeikakuTodokedeEntity.class);
    }

    /**
     * DbT3005KyotakuKeikakuTodokedeEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3005KyotakuKeikakuTodokedeEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画届出エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT3005KyotakuKeikakuTodokedeEntityを物理削除します。
     *
     * @param entity entity
     * @return 削除件数
     */
    @Override
    public int delete(DbT3005KyotakuKeikakuTodokedeEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画届出エンティティ"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
