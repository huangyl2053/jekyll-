/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3112KogakuShikyuShinsaKettei;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbT3112KogakuShikyuShinsaKettei.*;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3112KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 事業高額介護サービス費支給審査決定のデータアクセスクラスです。
 */
public class DbT3112KogakuShikyuShinsaKetteiDac implements ISaveable<DbT3112KogakuShikyuShinsaKetteiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで事業高額介護サービス費支給審査決定を取得します。
     *
     * @param 決定者受取年月 KetteishaUketoriYM
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 通知書番号 TsuchishoNo
     * @return DbT3112KogakuShikyuShinsaKetteiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3112KogakuShikyuShinsaKetteiEntity selectByKey(
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
                table(DbT3112KogakuShikyuShinsaKettei.class).
                where(and(
                                eq(ketteishaUketoriYM, 決定者受取年月),
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(tsuchishoNo, 通知書番号))).
                toObject(DbT3112KogakuShikyuShinsaKetteiEntity.class);
    }

    /**
     * 事業高額介護サービス費支給審査決定を全件返します。
     *
     * @return List<DbT3112KogakuShikyuShinsaKetteiEntity>
     */
    @Transaction
    public List<DbT3112KogakuShikyuShinsaKetteiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3112KogakuShikyuShinsaKettei.class).
                toList(DbT3112KogakuShikyuShinsaKetteiEntity.class);
    }

    /**
     * DbT3112KogakuShikyuShinsaKetteiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3112KogakuShikyuShinsaKetteiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("事業高額介護サービス費支給審査決定エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
