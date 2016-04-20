/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.entity.db.basic.DbT1006KyokaisoGaitosha;
import static jp.co.ndensan.reams.db.dba.entity.db.basic.DbT1006KyokaisoGaitosha.hihokenshaNo;
import static jp.co.ndensan.reams.db.dba.entity.db.basic.DbT1006KyokaisoGaitosha.linkNo;
import static jp.co.ndensan.reams.db.dba.entity.db.basic.DbT1006KyokaisoGaitosha.rirekiNo;
import jp.co.ndensan.reams.db.dba.entity.db.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 境界層該当者のデータアクセスクラスです。
 *
 * @reamsid_L DBA-9999-013 huangh
 */
public class DbT1006KyokaisoGaitoshaDac implements ISaveable<DbT1006KyokaisoGaitoshaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで境界層該当者を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @param リンク番号 LinkNo
     * @return DbT1006KyokaisoGaitoshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1006KyokaisoGaitoshaEntity selectByKey(
            HihokenshaNo 被保険者番号,
            Decimal 履歴番号,
            Decimal リンク番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(リンク番号, UrSystemErrorMessages.値がnull.getReplacedMessage("リンク番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1006KyokaisoGaitosha.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(rirekiNo, 履歴番号),
                                eq(linkNo, リンク番号))).
                toObject(DbT1006KyokaisoGaitoshaEntity.class);
    }

    /**
     * 境界層該当者を全件返します。
     *
     * @return DbT1006KyokaisoGaitoshaEntityの{@code list}
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
        //return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
