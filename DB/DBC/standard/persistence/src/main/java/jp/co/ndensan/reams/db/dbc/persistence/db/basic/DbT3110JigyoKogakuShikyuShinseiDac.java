/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3110JigyoKogakuShikyuShinsei;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbT3110JigyoKogakuShikyuShinsei.*;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3110JigyoKogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 事業高額介護サービス費支給申請のデータアクセスクラスです。
 */
public class DbT3110JigyoKogakuShikyuShinseiDac implements ISaveable<DbT3110JigyoKogakuShikyuShinseiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで事業高額介護サービス費支給申請を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 履歴番号 RirekiNo
     * @return DbT3110JigyoKogakuShikyuShinseiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3110JigyoKogakuShikyuShinseiEntity selectByKey(
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
                table(DbT3110JigyoKogakuShikyuShinsei.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3110JigyoKogakuShikyuShinseiEntity.class);
    }

    /**
     * 事業高額介護サービス費支給申請を全件返します。
     *
     * @return List<DbT3110JigyoKogakuShikyuShinseiEntity>
     */
    @Transaction
    public List<DbT3110JigyoKogakuShikyuShinseiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3110JigyoKogakuShikyuShinsei.class).
                toList(DbT3110JigyoKogakuShikyuShinseiEntity.class);
    }

    /**
     * DbT3110JigyoKogakuShikyuShinseiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3110JigyoKogakuShikyuShinseiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("事業高額介護サービス費支給申請エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
