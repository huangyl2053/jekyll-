/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4038ShogaishaKoujo;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4038ShogaishaKoujoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 障がい書控除のデータアクセスクラスです。
 */
public class DbT4038ShogaishaKoujoDac implements ISaveable<DbT4038ShogaishaKoujoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * DbT4038ShogaishaKoujoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT4038ShogaishaKoujoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("障がい書控除"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        if (entity.getLastUpdateTimestamp() != null && !EntityDataState.Deleted.equals(entity.getState())) {
            entity.setState(EntityDataState.Modified);
        }
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 障がい書控除を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return DbT4038ShogaishaKoujoEntity
     */
    @Transaction
    public DbT4038ShogaishaKoujoEntity selectBy被保険者番号(HihokenshaNo 被保険者番号) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4038ShogaishaKoujo.class).
                where(eq(DbT4038ShogaishaKoujo.hihokenshaNo, 被保険者番号)).
                order(by(DbT4038ShogaishaKoujo.rirekiNo, Order.DESC)).limit(1).
                toObject(DbT4038ShogaishaKoujoEntity.class);
    }

    /**
     * 障がい書控除を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<DbT4038ShogaishaKoujoEntity>
     */
    @Transaction
    public List<DbT4038ShogaishaKoujoEntity> selectListBy被保険者番号(HihokenshaNo 被保険者番号) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4038ShogaishaKoujo.class).
                where(eq(DbT4038ShogaishaKoujo.hihokenshaNo, 被保険者番号)).
                order(by(DbT4038ShogaishaKoujo.rirekiNo, Order.DESC)).
                toList(DbT4038ShogaishaKoujoEntity.class);
    }

    /**
     * キーで障がい書控除を削除します。
     *
     * @param entity entity
     * @return 削除件数
     */
    @Transaction
    public int delete(DbT4038ShogaishaKoujoEntity entity) {

        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("障がい書控除エンティティ"));
        entity.setState(EntityDataState.Deleted);
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

}
