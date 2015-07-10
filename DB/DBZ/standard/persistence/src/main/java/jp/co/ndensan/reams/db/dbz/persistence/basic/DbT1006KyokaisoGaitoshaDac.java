/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1006KyokaisoGaitosha;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1006KyokaisoGaitosha.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1006KyokaisoGaitosha.kyokaisoSochiKetteiYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1006KyokaisoGaitosha.shoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1006KyokaisoGaitosha.shoriTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 境界層該当者のデータアクセスクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class DbT1006KyokaisoGaitoshaDac implements IModifiable<DbT1006KyokaisoGaitoshaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで境界層該当者を取得します。
     *
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 被保険者番号 HihokenshaNo
     * @param 境界層措置決定年月日 KyokaisoSochiKetteiYMD
     * @param 処理日時 ShoriTimestamp
     * @return DbT1006KyokaisoGaitoshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1006KyokaisoGaitoshaEntity selectByKey(
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleDate 境界層措置決定年月日,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(境界層措置決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("境界層措置決定年月日"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1006KyokaisoGaitosha.class).
                where(and(
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(kyokaisoSochiKetteiYMD, 境界層措置決定年月日),
                                eq(shoriTimestamp, 処理日時))).
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

    @Transaction
    @Override
    public int insert(DbT1006KyokaisoGaitoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT1006KyokaisoGaitoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT1006KyokaisoGaitoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT1006KyokaisoGaitoshaEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT1006KyokaisoGaitoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
