/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitosha;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitosha.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitosha.linkNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitosha.logicalDeletedFlag;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitosha.rirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitosha.tekiyoKaishiYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitosha.tekiyoShuryoYMD;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 境界層該当者のデータアクセスクラスです。
 *
 * @reamsid_L DBZ-9999-012 xicongwang
 *
 */
public class DbT1006KyokaisoGaitoshaDac implements ISaveable<DbT1006KyokaisoGaitoshaEntity> {

    private static final RString TXT被保険者番号 = new RString("被保険者番号");

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで境界層該当者を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @return DbT1006KyokaisoGaitoshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1006KyokaisoGaitoshaEntity selectByKey(
            HihokenshaNo 被保険者番号,
            int 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(TXT被保険者番号.toString()));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1006KyokaisoGaitosha.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT1006KyokaisoGaitoshaEntity.class);
    }

    /**
     * 境界層該当者を全件返します。
     *
     * @return List<DbT1006KyokaisoGaitoshaEntity>
     */
    @Transaction
    public List<DbT1006KyokaisoGaitoshaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1006KyokaisoGaitosha.class).
                toList(DbT1006KyokaisoGaitoshaEntity.class);
    }

    /**
     * DbT1006KyokaisoGaitoshaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT1006KyokaisoGaitoshaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("境界層該当者エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 境界層の判断します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 適用日 FlexibleDate
     * @return DbT1006KyokaisoGaitoshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT1006KyokaisoGaitoshaEntity> select境界層該当者(
            HihokenshaNo 被保険者番号,
            FlexibleDate 適用日) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(TXT被保険者番号.toString()));
        requireNonNull(適用日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1006KyokaisoGaitosha.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                leq(適用日, tekiyoShuryoYMD),
                                leq(tekiyoKaishiYMD, 適用日),
                                eq(logicalDeletedFlag, false)
                        )).
                toList(DbT1006KyokaisoGaitoshaEntity.class);
    }

    /**
     * 境界層の判断します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return DbT1006KyokaisoGaitoshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1006KyokaisoGaitoshaEntity select境界層該当者情報(
            HihokenshaNo 被保険者番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(TXT被保険者番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1006KyokaisoGaitosha.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(logicalDeletedFlag, false)
                        )).
                order(by(rirekiNo, Order.DESC), by(linkNo, Order.DESC)).limit(1).
                toObject(DbT1006KyokaisoGaitoshaEntity.class);
    }
}
