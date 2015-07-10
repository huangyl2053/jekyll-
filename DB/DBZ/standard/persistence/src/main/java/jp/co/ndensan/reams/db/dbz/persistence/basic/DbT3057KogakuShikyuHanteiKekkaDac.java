/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3057KogakuShikyuHanteiKekka;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3057KogakuShikyuHanteiKekka.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3057KogakuShikyuHanteiKekka.serviceTeikyoYM;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3057KogakuShikyuHanteiKekka.shoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3057KogakuShikyuHanteiKekka.shoriTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
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
 * 高額介護サービス費支給判定結果のデータアクセスクラスです。
 *
 * @author LDNS 周杏月
 */
public class DbT3057KogakuShikyuHanteiKekkaDac implements IModifiable<DbT3057KogakuShikyuHanteiKekkaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで高額介護サービス費支給判定結果を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 処理日時 ShoriTimestamp
     * @return DbT3057KogakuShikyuHanteiKekkaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3057KogakuShikyuHanteiKekkaEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            HokenshaNo 証記載保険者番号,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3057KogakuShikyuHanteiKekka.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3057KogakuShikyuHanteiKekkaEntity.class);
    }

    /**
     * 高額介護サービス費支給判定結果を全件返します。
     *
     * @return List<DbT3057KogakuShikyuHanteiKekkaEntity>
     */
    @Transaction
    public List<DbT3057KogakuShikyuHanteiKekkaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3057KogakuShikyuHanteiKekka.class).
                toList(DbT3057KogakuShikyuHanteiKekkaEntity.class);
    }

    /**
     * 高額介護サービス費支給判定結果を追加します。
     *
     * @param entity 高額介護サービス費支給判定結果
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT3057KogakuShikyuHanteiKekkaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 高額介護サービス費支給判定結果をDBに更新します。
     *
     * @param entity 高額介護サービス費支給判定結果
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT3057KogakuShikyuHanteiKekkaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 高額介護サービス費支給判定結果をDBから削除します。（論理削除）
     *
     * @param entity 高額介護サービス費支給判定結果
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT3057KogakuShikyuHanteiKekkaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 高額介護サービス費支給判定結果を物理削除。
     *
     * @param entity 高額介護サービス費支給判定結果
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT3057KogakuShikyuHanteiKekkaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
