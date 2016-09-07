/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3174JigyoKogakuGassanShikyuFushikyuKettei;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3174JigyoKogakuGassanShikyuFushikyuKettei.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3174JigyoKogakuGassanShikyuFushikyuKettei.hokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3174JigyoKogakuGassanShikyuFushikyuKettei.isDeleted;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3174JigyoKogakuGassanShikyuFushikyuKettei.rirekiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3174JigyoKogakuGassanShikyuFushikyuKettei.shikyuSeiriNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3174JigyoKogakuGassanShikyuFushikyuKettei.taishoNendo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 事業高額合算支給不支給決定のデータアクセスクラスです。
 *
 * @reamsid_L DBC-9999-012 chenyadong
 */
public class DbT3174JigyoKogakuGassanShikyuFushikyuKetteiDac implements ISaveable<DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで事業高額合算支給不支給決定を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年度 対象年度
     * @param 保険者番号 保険者番号
     * @param 支給申請書整理番号 支給申請書整理番号
     * @param 履歴番号 履歴番号
     * @return DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 支給申請書整理番号,
            int 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3174JigyoKogakuGassanShikyuFushikyuKettei.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoNendo, 対象年度),
                                eq(hokenshaNo, 保険者番号),
                                eq(shikyuSeiriNo, 支給申請書整理番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity.class);
    }

    /**
     * 事業高額合算支給不支給決定を全件返します。
     *
     * @return DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntityの{@code list}
     */
    @Transaction
    public List<DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3174JigyoKogakuGassanShikyuFushikyuKettei.class).
                toList(DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity.class);
    }

    /**
     * DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("事業高額合算支給不支給決定エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 事業高額合算支給不支給決定を全件返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity>
     */
    @Transaction
    public List<DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity> selectAll(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3174JigyoKogakuGassanShikyuFushikyuKettei.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(isDeleted, false))).
                order(by(taishoNendo, Order.DESC), by(shikyuSeiriNo, Order.DESC), by(rirekiNo, Order.DESC)).
                toList(DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity.class);
    }
}
