/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3097TandokuJoseikinKyufuKettei;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3097TandokuJoseikinKyufuKettei.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3097TandokuJoseikinKyufuKettei.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3097TandokuJoseikinKyufuKettei.uketsukeYMD;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3097TandokuJoseikinKyufuKetteiEntity;
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
 * 市町村単独助成金給付決定のデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT3097TandokuJoseikinKyufuKetteiDac implements IModifiable<DbT3097TandokuJoseikinKyufuKetteiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで市町村単独助成金給付決定を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 受付年月日 UketsukeYMD
     * @param 処理日時 ShoriTimestamp
     * @return DbT3097TandokuJoseikinKyufuKetteiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3097TandokuJoseikinKyufuKetteiEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleDate 受付年月日,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3097TandokuJoseikinKyufuKettei.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(uketsukeYMD, 受付年月日),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3097TandokuJoseikinKyufuKetteiEntity.class);
    }

    /**
     * 市町村単独助成金給付決定を全件返します。
     *
     * @return List<DbT3097TandokuJoseikinKyufuKetteiEntity>
     */
    @Transaction
    public List<DbT3097TandokuJoseikinKyufuKetteiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3097TandokuJoseikinKyufuKettei.class).
                toList(DbT3097TandokuJoseikinKyufuKetteiEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT3097TandokuJoseikinKyufuKetteiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT3097TandokuJoseikinKyufuKetteiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT3097TandokuJoseikinKyufuKetteiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT3097TandokuJoseikinKyufuKetteiEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT3097TandokuJoseikinKyufuKetteiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
