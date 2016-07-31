/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinsei;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinsei.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinsei.rirekiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinsei.serviceTeikyoYM;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinsei.shoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額介護サービス費支給申請のデータアクセスクラスです。
 *
 * @reamsid_L DBC-9999-012 quxiaodong
 */
public class DbT3056KogakuShikyuShinseiDac implements ISaveable<DbT3056KogakuShikyuShinseiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで高額介護サービス費支給申請を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 履歴番号 RirekiNo
     * @return DbT3056KogakuShikyuShinseiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3056KogakuShikyuShinseiEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            HokenshaNo 証記載保険者番号,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3056KogakuShikyuShinsei.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3056KogakuShikyuShinseiEntity.class);
    }

    /**
     * 主キーで高額介護サービス費支給申請を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @return DbT3056KogakuShikyuShinseiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT3056KogakuShikyuShinseiEntity> selectAllByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3056KogakuShikyuShinsei.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月))).
                toList(DbT3056KogakuShikyuShinseiEntity.class);
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
     * DbT3056KogakuShikyuShinseiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3056KogakuShikyuShinseiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費支給申請エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT3056KogakuShikyuShinseiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int delete(DbT3056KogakuShikyuShinseiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費支給申請エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }
}
