/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3056KogakuShikyuShinsei;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3056KogakuShikyuShinsei.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3056KogakuShikyuShinsei.serviceTeikyoYM;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3056KogakuShikyuShinsei.shoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3056KogakuShikyuShinsei.shoriTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3056KogakuShikyuShinseiEntity;
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
 * 高額介護サービス費支給申請のデータアクセスクラスです。
 *
 * @author LDNS 周杏月
 */
public class DbT3056KogakuShikyuShinseiDac implements IModifiable<DbT3056KogakuShikyuShinseiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで高額介護サービス費支給申請を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 処理日時 ShoriTimestamp
     * @return DbT3056KogakuShikyuShinseiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3056KogakuShikyuShinseiEntity selectByKey(
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
                table(DbT3056KogakuShikyuShinsei.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3056KogakuShikyuShinseiEntity.class);
    }

    /**
     * 高額介護サービス費支給申請を全件返します。
     *
     * @return List<DbT3056KogakuShikyuShinseiEntity>
     */
    @Transaction
    public List<DbT3056KogakuShikyuShinseiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3056KogakuShikyuShinsei.class).
                toList(DbT3056KogakuShikyuShinseiEntity.class);
    }

    /**
     * 高額介護サービス費支給申請を追加します。
     *
     * @param entity 高額介護サービス費支給申請
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT3056KogakuShikyuShinseiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 高額介護サービス費支給申請をDBに更新します。
     *
     * @param entity 高額介護サービス費支給申請
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT3056KogakuShikyuShinseiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 高額介護サービス費支給申請をDBから削除します。（論理削除）
     *
     * @param entity 高額介護サービス費支給申請
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT3056KogakuShikyuShinseiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 高額介護サービス費支給申請を物理削除。
     *
     * @param entity 高額介護サービス費支給申請
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT3056KogakuShikyuShinseiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
