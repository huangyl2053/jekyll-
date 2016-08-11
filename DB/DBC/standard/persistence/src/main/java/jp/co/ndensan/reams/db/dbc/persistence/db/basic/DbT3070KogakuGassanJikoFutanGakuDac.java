/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGaku;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGaku.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGaku.hokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGaku.rirekiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGaku.shikyuShinseishoSeiriNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGaku.taishoNendo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
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
 * 高額合算自己負担額のデータアクセスクラスです。
 *
 * @reamsid_L DBC-4800-010 huzongcheng
 */
public class DbT3070KogakuGassanJikoFutanGakuDac implements ISaveable<DbT3070KogakuGassanJikoFutanGakuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで高額合算自己負担額を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 TaishoNendo
     * @param 保険者番号 HokenshaNo
     * @param 支給申請書整理番号 ShikyuShinseishoSeiriNo
     * @param 履歴番号 RirekiNo
     * @return DbT3070KogakuGassanJikoFutanGakuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3070KogakuGassanJikoFutanGakuEntity selectByKey(
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
                table(DbT3070KogakuGassanJikoFutanGaku.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoNendo, 対象年度),
                                eq(hokenshaNo, 保険者番号),
                                eq(shikyuShinseishoSeiriNo, 支給申請書整理番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3070KogakuGassanJikoFutanGakuEntity.class);
    }

    /**
     * 被保険者番号で高額合算自己負担額を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<DbT3070KogakuGassanJikoFutanGakuEntity>
     */
    @Transaction
    public List<DbT3070KogakuGassanJikoFutanGakuEntity> selectByHihokenshaNo(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3070KogakuGassanJikoFutanGaku.class).
                where(eq(hihokenshaNo, 被保険者番号)).
                order(by(DbT3070KogakuGassanJikoFutanGaku.hihokenshaNo, Order.DESC),
                        by(DbT3070KogakuGassanJikoFutanGaku.taishoNendo, Order.DESC),
                        by(DbT3070KogakuGassanJikoFutanGaku.hokenshaNo, Order.DESC),
                        by(DbT3070KogakuGassanJikoFutanGaku.shikyuShinseishoSeiriNo, Order.DESC),
                        by(DbT3070KogakuGassanJikoFutanGaku.rirekiNo, Order.DESC)).
                toList(DbT3070KogakuGassanJikoFutanGakuEntity.class);
    }

    /**
     * 履歴番号Maxで高額合算自己負担額を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 FlexibleYear
     * @param 保険者番号 HokenshaNo
     * @param 支給申請書整理番号 RString
     * @return List<DbT3070KogakuGassanJikoFutanGakuEntity>
     */
    @Transaction
    public DbT3070KogakuGassanJikoFutanGakuEntity selectMaxRirekiNo(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 支給申請書整理番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3070KogakuGassanJikoFutanGaku.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoNendo, 対象年度),
                                eq(hokenshaNo, 保険者番号),
                                eq(shikyuShinseishoSeiriNo, 支給申請書整理番号))).
                order(by(DbT3070KogakuGassanJikoFutanGaku.rirekiNo, Order.DESC)).limit(1).
                toObject(DbT3070KogakuGassanJikoFutanGakuEntity.class);
    }

    /**
     * 高額合算自己負担額を全件返します。
     *
     * @return List<DbT3070KogakuGassanJikoFutanGakuEntity>
     */
    @Transaction
    public List<DbT3070KogakuGassanJikoFutanGakuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3070KogakuGassanJikoFutanGaku.class).
                toList(DbT3070KogakuGassanJikoFutanGakuEntity.class);
    }

    /**
     * DbT3070KogakuGassanJikoFutanGakuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3070KogakuGassanJikoFutanGakuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("高額合算自己負担額エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
