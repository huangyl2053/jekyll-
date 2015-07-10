/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3055KogakuKyufuTaishoshaGokei;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3055KogakuKyufuTaishoshaGokei.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3055KogakuKyufuTaishoshaGokei.serviceTeikyoYM;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3055KogakuKyufuTaishoshaGokei.shoriTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額介護サービス費給付対象者合計のデータアクセスクラスです。
 *
 * @author LDNS 周杏月
 */
public class DbT3055KogakuKyufuTaishoshaGokeiDac implements IModifiable<DbT3055KogakuKyufuTaishoshaGokeiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで高額介護サービス費給付対象者合計を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 処理日時 ShoriTimestamp
     * @return DbT3055KogakuKyufuTaishoshaGokeiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3055KogakuKyufuTaishoshaGokeiEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3055KogakuKyufuTaishoshaGokei.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3055KogakuKyufuTaishoshaGokeiEntity.class);
    }

    /**
     * 高額介護サービス費給付対象者合計を全件返します。
     *
     * @return List<DbT3055KogakuKyufuTaishoshaGokeiEntity>
     */
    @Transaction
    public List<DbT3055KogakuKyufuTaishoshaGokeiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3055KogakuKyufuTaishoshaGokei.class).
                toList(DbT3055KogakuKyufuTaishoshaGokeiEntity.class);
    }

    /**
     * 高額介護サービス費給付対象者合計を追加します。
     *
     * @param entity 高額介護サービス費給付対象者合計
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT3055KogakuKyufuTaishoshaGokeiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 高額介護サービス費給付対象者合計をDBに更新します。
     *
     * @param entity 高額介護サービス費給付対象者合計
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT3055KogakuKyufuTaishoshaGokeiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 高額介護サービス費給付対象者合計をDBから削除します。（論理削除）
     *
     * @param entity 高額介護サービス費給付対象者合計
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT3055KogakuKyufuTaishoshaGokeiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 高額介護サービス費給付対象者合計を物理削除。
     *
     * @param entity 高額介護サービス費給付対象者合計
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT3055KogakuKyufuTaishoshaGokeiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
