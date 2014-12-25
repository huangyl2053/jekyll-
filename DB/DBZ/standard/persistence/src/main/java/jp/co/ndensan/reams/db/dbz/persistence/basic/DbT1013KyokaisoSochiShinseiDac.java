/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1013KyokaisoSochiShinsei;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1013KyokaisoSochiShinsei.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1013KyokaisoSochiShinsei.shinseiYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1013KyokaisoSochiShinsei.shoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1013KyokaisoSochiShinsei.shoriTimeStamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1013KyokaisoSochiShinseiEntity;
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
 * 境界層措置申請のデータアクセスクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class DbT1013KyokaisoSochiShinseiDac implements IModifiable<DbT1013KyokaisoSochiShinseiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで境界層措置申請を取得します。
     *
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 被保険者番号 HihokenshaNo
     * @param 申請年月日 ShinseiYMD
     * @param 処理日時 ShoriTimeStamp
     * @return DbT1013KyokaisoSochiShinseiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1013KyokaisoSochiShinseiEntity selectByKey(
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleDate 申請年月日,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請年月日"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1013KyokaisoSochiShinsei.class).
                where(and(
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(shinseiYMD, 申請年月日),
                                eq(shoriTimeStamp, 処理日時))).
                toObject(DbT1013KyokaisoSochiShinseiEntity.class);
    }

    /**
     * 境界層措置申請を全件返します。
     *
     * @return List<DbT1013KyokaisoSochiShinseiEntity>
     */
    @Transaction
    public List<DbT1013KyokaisoSochiShinseiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1013KyokaisoSochiShinsei.class).
                toList(DbT1013KyokaisoSochiShinseiEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT1013KyokaisoSochiShinseiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT1013KyokaisoSochiShinseiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT1013KyokaisoSochiShinseiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT1013KyokaisoSochiShinseiEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT1013KyokaisoSochiShinseiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
