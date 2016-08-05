/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishosha;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishosha.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishosha.rirekiNo;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 総合事業対象者のデータアクセスクラスです。
 *
 * @reamsid_L DBC-4800-010 huzongcheng
 */
public class DbT3105SogoJigyoTaishoshaDac implements ISaveable<DbT3105SogoJigyoTaishoshaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで総合事業対象者を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @return DbT3105SogoJigyoTaishoshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3105SogoJigyoTaishoshaEntity selectByKey(
            HihokenshaNo 被保険者番号,
            int 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3105SogoJigyoTaishosha.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3105SogoJigyoTaishoshaEntity.class);
    }

    /**
     * 総合事業対象者を全件返します。
     *
     * @return List<DbT3105SogoJigyoTaishoshaEntity>
     */
    @Transaction
    public List<DbT3105SogoJigyoTaishoshaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3105SogoJigyoTaishosha.class).
                toList(DbT3105SogoJigyoTaishoshaEntity.class);
    }

    /**
     * DbT3105SogoJigyoTaishoshaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3105SogoJigyoTaishoshaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("総合事業対象者エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 被保険者番号より事業対象者を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return DbT3105SogoJigyoTaishoshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT3105SogoJigyoTaishoshaEntity> selectBy被保険者番号(
            HihokenshaNo 被保険者番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3105SogoJigyoTaishosha.class).
                where(eq(hihokenshaNo, 被保険者番号)).
                toList(DbT3105SogoJigyoTaishoshaEntity.class);
    }
}
