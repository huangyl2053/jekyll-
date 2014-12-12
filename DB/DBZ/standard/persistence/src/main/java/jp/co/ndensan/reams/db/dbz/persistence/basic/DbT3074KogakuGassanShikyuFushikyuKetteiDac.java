/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3074KogakuGassanShikyuFushikyuKettei;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3074KogakuGassanShikyuFushikyuKettei.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3074KogakuGassanShikyuFushikyuKettei.hokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3074KogakuGassanShikyuFushikyuKettei.shikyuSeiriNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3074KogakuGassanShikyuFushikyuKettei.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3074KogakuGassanShikyuFushikyuKettei.taishoNendo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3074KogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額合算支給不支給決定のデータアクセスクラスです。
 *
 * @author LDNS 周杏月
 */
public class DbT3074KogakuGassanShikyuFushikyuKetteiDac implements IModifiable<DbT3074KogakuGassanShikyuFushikyuKetteiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで高額合算支給不支給決定を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 TaishoNendo
     * @param 保険者番号 HokenshaNo
     * @param 支給申請書整理番号 ShikyuSeiriNo
     * @param 処理日時 ShoriTimestamp
     * @return DbT3074KogakuGassanShikyuFushikyuKetteiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3074KogakuGassanShikyuFushikyuKetteiEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 支給申請書整理番号,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3074KogakuGassanShikyuFushikyuKettei.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoNendo, 対象年度),
                                eq(hokenshaNo, 保険者番号),
                                eq(shikyuSeiriNo, 支給申請書整理番号),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3074KogakuGassanShikyuFushikyuKetteiEntity.class);
    }

    /**
     * 高額合算支給不支給決定を全件返します。
     *
     * @return List<DbT3074KogakuGassanShikyuFushikyuKetteiEntity>
     */
    @Transaction
    public List<DbT3074KogakuGassanShikyuFushikyuKetteiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3074KogakuGassanShikyuFushikyuKettei.class).
                toList(DbT3074KogakuGassanShikyuFushikyuKetteiEntity.class);
    }

    /**
     * 高額合算支給不支給決定を追加します。
     *
     * @param entity 高額合算支給不支給決定
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT3074KogakuGassanShikyuFushikyuKetteiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 高額合算支給不支給決定をDBに更新します。
     *
     * @param entity 高額合算支給不支給決定
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT3074KogakuGassanShikyuFushikyuKetteiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 高額合算支給不支給決定をDBから削除します。（論理削除）
     *
     * @param entity 高額合算支給不支給決定
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT3074KogakuGassanShikyuFushikyuKetteiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 高額合算支給不支給決定を物理削除。
     *
     * @param entity 高額合算支給不支給決定
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT3074KogakuGassanShikyuFushikyuKetteiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
