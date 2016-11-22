/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3170JigyoKogakuGassanJikoFutanGaku;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3170JigyoKogakuGassanJikoFutanGaku.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3170JigyoKogakuGassanJikoFutanGaku.hokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3170JigyoKogakuGassanJikoFutanGaku.jikoFutanSeiriNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3170JigyoKogakuGassanJikoFutanGaku.rirekiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3170JigyoKogakuGassanJikoFutanGaku.shikyuShinseishoSeiriNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3170JigyoKogakuGassanJikoFutanGaku.shomeiShoSakuseiYMD;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3170JigyoKogakuGassanJikoFutanGaku.taishoNendo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3170JigyoKogakuGassanJikoFutanGakuEntity;
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
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.max;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 事業事業高額合算自己負担額のデータアクセスクラスです。
 *
 * @reamsid_L DBC-4810-010 yaoyahui
 */
public class DbT3170JigyoKogakuGassanJikoFutanGakuDac implements ISaveable<DbT3170JigyoKogakuGassanJikoFutanGakuEntity> {

    @InjectSession
    private SqlSession session;

    public static final RString 被保険者番号STR = new RString("被保険者番号");
    public static final RString 対象年度STR = new RString("対象年度");
    public static final RString 保険者番号STR = new RString("保険者番号");
    public static final RString 支給申請書整理番号STR = new RString("支給申請書整理番号");

    /**
     * 主キーで事業高額合算申請書を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 TaishoNendo
     * @param 保険者番号 RString
     * @param 支給申請書整理番号 shikyuShinseishoSeiriNo
     * @return DbT3170JigyoKogakuGassanJikoFutanGakuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3170JigyoKogakuGassanJikoFutanGakuEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            RString 保険者番号,
            RString 支給申請書整理番号
    ) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号STR.toString()));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage(対象年度STR.toString()));
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(保険者番号STR.toString()));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(支給申請書整理番号STR.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(jikoFutanSeiriNo, shomeiShoSakuseiYMD, max(rirekiNo)).table(DbT3170JigyoKogakuGassanJikoFutanGaku.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoNendo, 対象年度),
                                eq(hokenshaNo, 保険者番号),
                                eq(shikyuShinseishoSeiriNo, 支給申請書整理番号))).groupBy(jikoFutanSeiriNo, shomeiShoSakuseiYMD).
                toObject(DbT3170JigyoKogakuGassanJikoFutanGakuEntity.class);
    }

    /**
     * 主キーで事業高額合算自己負担額を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 TaishoNendo
     * @param 保険者番号 HokenshaNo
     * @param 支給申請書整理番号 ShikyuShinseishoSeiriNo
     * @param 履歴番号 RirekiNo
     * @return DbT3170JigyoKogakuGassanJikoFutanGakuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3170JigyoKogakuGassanJikoFutanGakuEntity selectByKeys(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 支給申請書整理番号,
            int 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号STR.toString()));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage(対象年度STR.toString()));
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(保険者番号STR.toString()));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(支給申請書整理番号STR.toString()));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3170JigyoKogakuGassanJikoFutanGaku.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoNendo, 対象年度),
                                eq(hokenshaNo, 保険者番号),
                                eq(shikyuShinseishoSeiriNo, 支給申請書整理番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3170JigyoKogakuGassanJikoFutanGakuEntity.class);
    }

    /**
     * 被保険者番号で事業高額合算自己負担額を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<DbT3170JigyoKogakuGassanJikoFutanGakuEntity>
     */
    @Transaction
    public List<DbT3170JigyoKogakuGassanJikoFutanGakuEntity> selectByHihokenshaNo(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号STR.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3170JigyoKogakuGassanJikoFutanGaku.class).
                where(eq(hihokenshaNo, 被保険者番号)).
                order(by(DbT3170JigyoKogakuGassanJikoFutanGaku.hihokenshaNo, Order.DESC),
                        by(DbT3170JigyoKogakuGassanJikoFutanGaku.taishoNendo, Order.DESC),
                        by(DbT3170JigyoKogakuGassanJikoFutanGaku.hokenshaNo, Order.DESC),
                        by(DbT3170JigyoKogakuGassanJikoFutanGaku.shikyuShinseishoSeiriNo, Order.DESC),
                        by(DbT3170JigyoKogakuGassanJikoFutanGaku.rirekiNo, Order.DESC)).
                toList(DbT3170JigyoKogakuGassanJikoFutanGakuEntity.class);
    }

    /**
     * 履歴番号Maxで事業高額合算自己負担額を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 FlexibleYear
     * @param 保険者番号 HokenshaNo
     * @param 支給申請書整理番号 RString
     * @return List<DbT3170JigyoKogakuGassanJikoFutanGakuEntity>
     */
    @Transaction
    public DbT3170JigyoKogakuGassanJikoFutanGakuEntity selectMaxRirekiNo(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 支給申請書整理番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号STR.toString()));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage(対象年度STR.toString()));
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(保険者番号STR.toString()));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(支給申請書整理番号STR.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3170JigyoKogakuGassanJikoFutanGaku.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoNendo, 対象年度),
                                eq(hokenshaNo, 保険者番号),
                                eq(shikyuShinseishoSeiriNo, 支給申請書整理番号))).
                order(by(DbT3170JigyoKogakuGassanJikoFutanGaku.rirekiNo, Order.DESC)).limit(1).
                toObject(DbT3170JigyoKogakuGassanJikoFutanGakuEntity.class);
    }

    /**
     * 事業高額合算自己負担額を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 FlexibleYear
     * @param 保険者番号 RString
     * @param 支給申請書整理番号 RString
     * @return List<DbT3170JigyoKogakuGassanJikoFutanGakuEntity>
     */
    @Transaction
    public DbT3170JigyoKogakuGassanJikoFutanGakuEntity selectJikoFutanGaku(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            RString 保険者番号,
            RString 支給申請書整理番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号STR.toString()));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage(対象年度STR.toString()));
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(保険者番号STR.toString()));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(支給申請書整理番号STR.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(jikoFutanSeiriNo, shomeiShoSakuseiYMD, max(rirekiNo)).
                table(DbT3170JigyoKogakuGassanJikoFutanGaku.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoNendo, 対象年度),
                                eq(hokenshaNo, 保険者番号),
                                eq(shikyuShinseishoSeiriNo, 支給申請書整理番号))).groupBy(jikoFutanSeiriNo, shomeiShoSakuseiYMD).
                toObject(DbT3170JigyoKogakuGassanJikoFutanGakuEntity.class);
    }

    /**
     * 事業高額合算自己負担額を全件返します。
     *
     * @return List<DbT3170JigyoKogakuGassanJikoFutanGakuEntity>
     */
    @Transaction
    public List<DbT3170JigyoKogakuGassanJikoFutanGakuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3170JigyoKogakuGassanJikoFutanGaku.class).
                toList(DbT3170JigyoKogakuGassanJikoFutanGakuEntity.class);
    }

    /**
     * DbT3170JigyoKogakuGassanJikoFutanGakuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3170JigyoKogakuGassanJikoFutanGakuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("事業事業高額合算自己負担額エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
