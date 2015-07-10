/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2009RentaiGimusha;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT2009RentaiGimusha.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT2009RentaiGimusha.shoriTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2009RentaiGimushaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 連帯納付義務者のデータアクセスクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class DbT2009RentaiGimushaDac implements IModifiable<DbT2009RentaiGimushaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで連帯納付義務者を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 処理日時 ShoriTimestamp
     * @return DbT2009RentaiGimushaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2009RentaiGimushaEntity selectByKey(
            HihokenshaNo 被保険者番号,
            RDateTime 処理日時) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2009RentaiGimusha.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT2009RentaiGimushaEntity.class);
    }

    /**
     * 連帯納付義務者を全件返します。
     *
     * @return List<DbT2009RentaiGimushaEntity>
     */
    @Transaction
    public List<DbT2009RentaiGimushaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2009RentaiGimusha.class).
                toList(DbT2009RentaiGimushaEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT2009RentaiGimushaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT2009RentaiGimushaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT2009RentaiGimushaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT2009RentaiGimushaEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT2009RentaiGimushaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
