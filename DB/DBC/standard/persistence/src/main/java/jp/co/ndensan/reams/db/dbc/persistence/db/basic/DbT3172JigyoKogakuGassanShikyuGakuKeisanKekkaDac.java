/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3172JigyoKogakuGassanShikyuGakuKeisanKekka;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3172JigyoKogakuGassanShikyuGakuKeisanKekka.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3172JigyoKogakuGassanShikyuGakuKeisanKekka.isDeleted;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3172JigyoKogakuGassanShikyuGakuKeisanKekka.rirekiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3172JigyoKogakuGassanShikyuGakuKeisanKekka.shikyuShinseishoSeiriNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3172JigyoKogakuGassanShikyuGakuKeisanKekka.shoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3172JigyoKogakuGassanShikyuGakuKeisanKekka.taishoNendo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 事業高額合算支給額計算結果情報取得のDacです。
 *
 * @reamsid_L DBC-4840-010 lihang
 */
public class DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaDac {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで事業高額合算支給額計算結果を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年度 対象年度
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支給申請書整理番号 支給申請書整理番号
     * @param 履歴番号 履歴番号
     * @return DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 証記載保険者番号,
            RString 支給申請書整理番号,
            int 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3172JigyoKogakuGassanShikyuGakuKeisanKekka.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoNendo, 対象年度),
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(shikyuShinseishoSeiriNo, 支給申請書整理番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity.class);
    }

    /**
     * 被保険者番号を全件返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity>
     */
    @Transaction
    public List<DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity> select被保険者番号(HihokenshaNo 被保険者番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT3172JigyoKogakuGassanShikyuGakuKeisanKekka.class).
                where(and(
                                eq(isDeleted, false),
                                eq(hihokenshaNo, 被保険者番号))).
                toList(DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity.class);
    }

    /**
     * 事業高額合算支給額計算結果を全件返します。
     *
     * @return DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntityの{@code list}
     */
    @Transaction
    public List<DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3172JigyoKogakuGassanShikyuGakuKeisanKekka.class).
                toList(DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity.class);
    }

    /**
     * 事業高額合算支給額計算結果を全件返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 TaishoNendo
     * @param 証記載保険者番号 HokenshaNo
     * @param 支給申請書整理番号 ShikyuShinseishoSeiriNo
     * @return DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntityの{@code list}
     */
    @Transaction
    public List<DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity> selectAll(HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度, HokenshaNo 証記載保険者番号, RString 支給申請書整理番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        return accessor.select().
                table(DbT3172JigyoKogakuGassanShikyuGakuKeisanKekka.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoNendo, 対象年度),
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(shikyuShinseishoSeiriNo, 支給申請書整理番号))).
                order(by(taishoNendo, Order.DESC), by(shikyuShinseishoSeiriNo, Order.DESC), by(rirekiNo, Order.DESC)).
                toList(DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity.class);
    }
}
