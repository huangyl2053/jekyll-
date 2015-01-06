/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3058KogakuShikyuShinsaKettei;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3058KogakuShikyuShinsaKettei.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3058KogakuShikyuShinsaKettei.ketteishaUketoriYM;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3058KogakuShikyuShinsaKettei.serviceTeikyoYM;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3058KogakuShikyuShinsaKettei.shoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3058KogakuShikyuShinsaKettei.tsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3058KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額介護サービス費支給審査決定のデータアクセスクラスです。
 *
 * @author LDNS 周杏月
 */
public class DbT3058KogakuShikyuShinsaKetteiDac implements IModifiable<DbT3058KogakuShikyuShinsaKetteiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで高額介護サービス費支給審査決定を取得します。
     *
     * @param 決定者受取年月 KetteishaUketoriYM
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 通知書番号 TsuchishoNo
     * @return DbT3058KogakuShikyuShinsaKetteiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3058KogakuShikyuShinsaKetteiEntity selectByKey(
            FlexibleYearMonth 決定者受取年月,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 通知書番号) throws NullPointerException {
        requireNonNull(決定者受取年月, UrSystemErrorMessages.値がnull.getReplacedMessage("決定者受取年月"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3058KogakuShikyuShinsaKettei.class).
                where(and(
                                eq(ketteishaUketoriYM, 決定者受取年月),
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(tsuchishoNo, 通知書番号))).
                toObject(DbT3058KogakuShikyuShinsaKetteiEntity.class);
    }

    /**
     * 高額介護サービス費支給審査決定を全件返します。
     *
     * @return List<DbT3058KogakuShikyuShinsaKetteiEntity>
     */
    @Transaction
    public List<DbT3058KogakuShikyuShinsaKetteiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3058KogakuShikyuShinsaKettei.class).
                toList(DbT3058KogakuShikyuShinsaKetteiEntity.class);
    }

    /**
     * 高額介護サービス費支給審査決定を追加します。
     *
     * @param entity 高額介護サービス費支給審査決定
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT3058KogakuShikyuShinsaKetteiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 高額介護サービス費支給審査決定をDBに更新します。
     *
     * @param entity 高額介護サービス費支給審査決定
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT3058KogakuShikyuShinsaKetteiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 高額介護サービス費支給審査決定をDBから削除します。（論理削除）
     *
     * @param entity 高額介護サービス費支給審査決定
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT3058KogakuShikyuShinsaKetteiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 高額介護サービス費支給審査決定を物理削除。
     *
     * @param entity 高額介護サービス費支給審査決定
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT3058KogakuShikyuShinsaKetteiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
