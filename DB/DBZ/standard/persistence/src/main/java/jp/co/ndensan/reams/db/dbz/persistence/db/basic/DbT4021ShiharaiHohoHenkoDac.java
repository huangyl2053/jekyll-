/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.jukyu.shiharaihohohenko.ShuryoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoKanriKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoMukoKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenko;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenko.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenko.kanriKubun;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenko.logicalDeletedFlag;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenko.mukoKubun;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenko.rirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenko.shoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenko.shuryoKubun;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenko.tekiyoKaishiYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenko.tekiyoShuryoYMD;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Order.DESC;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.isNULL;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.not;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.substr;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 支払方法変更のデータアクセスクラスです。
 *
 * @reamsid_L DBC-9999-012 xicongwang
 */
public class DbT4021ShiharaiHohoHenkoDac implements ISaveable<DbT4021ShiharaiHohoHenkoEntity> {

    @InjectSession
    private SqlSession session;
    private static final int NUM = 6;
    private static final int INT_3 = 3;
    private static final int INT_1 = 1;

    /**
     * 主キーで支払方法変更を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 管理区分 管理区分
     * @param 履歴番号 履歴番号
     * @return DbT4021ShiharaiHohoHenkoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4021ShiharaiHohoHenkoEntity selectByKey(
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            RString 管理区分,
            int 履歴番号) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(管理区分, UrSystemErrorMessages.値がnull.getReplacedMessage("管理区分"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4021ShiharaiHohoHenko.class).
                where(and(
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(kanriKubun, 管理区分),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT4021ShiharaiHohoHenkoEntity.class);
    }

    /**
     * 支払方法変更を全件返します。
     *
     * @return DbT4021ShiharaiHohoHenkoEntityの{@code list}
     */
    @Transaction
    public List<DbT4021ShiharaiHohoHenkoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4021ShiharaiHohoHenko.class).
                toList(DbT4021ShiharaiHohoHenkoEntity.class);
    }

    /**
     * DbT4021ShiharaiHohoHenkoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT4021ShiharaiHohoHenkoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("支払方法変更エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 給付率取得用支払方法変更給付率。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @return List<DbT4021ShiharaiHohoHenkoEntity>
     */
    @Transaction
    public List<DbT4021ShiharaiHohoHenkoEntity> get支払方法変更給付率(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT4021ShiharaiHohoHenko.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(kanriKubun, ShiharaiHenkoKanriKubun._１号給付額減額.getコード()),
                                not(eq(mukoKubun, ShiharaiHenkoMukoKubun.無効.getコード())),
                                leq(substr(tekiyoKaishiYMD, 1, NUM), サービス提供年月),
                                leq(サービス提供年月, substr(tekiyoShuryoYMD, 1, NUM)))).
                order(by(rirekiNo, DESC)).
                toList(DbT4021ShiharaiHohoHenkoEntity.class);
    }

    /**
     * 支払方法変更リストの取得。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<DbT4021ShiharaiHohoHenkoEntity>
     */
    @Transaction
    public List<DbT4021ShiharaiHohoHenkoEntity> get支支払方法変更(HihokenshaNo 被保険者番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT4021ShiharaiHohoHenko.class).
                where(
                        eq(hihokenshaNo, 被保険者番号)).
                order(by(rirekiNo, DESC)).
                toList(DbT4021ShiharaiHohoHenkoEntity.class);
    }

    /**
     * 支払方法変更リストの取得。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<DbT4021ShiharaiHohoHenkoEntity>
     */
    @Transaction
    public List<DbT4021ShiharaiHohoHenkoEntity> get支払方法変更For給付制限データ(HihokenshaNo 被保険者番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT4021ShiharaiHohoHenko.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(logicalDeletedFlag, false),
                                eq(mukoKubun, ShiharaiHenkoMukoKubun.有効.getコード()),
                                eq(shuryoKubun, ShuryoKubun.EMPTY.code()),
                                not(isNULL(tekiyoKaishiYMD)))).
                order(by(kanriKubun, DESC), by(tekiyoKaishiYMD, DESC)).limit(INT_3).
                toList(DbT4021ShiharaiHohoHenkoEntity.class);
    }

    /**
     * 被保険者番号、管理区分、適用年月日により、支払方法変更データを取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 基準日 FlexibleDate
     * @param 管理区分 RString
     * @return DbT4021ShiharaiHohoHenkoEntity
     */
    @Transaction
    public DbT4021ShiharaiHohoHenkoEntity get支払方法変更(HihokenshaNo 被保険者番号, FlexibleDate 基準日, RString 管理区分) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT4021ShiharaiHohoHenko.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                leq(tekiyoKaishiYMD, 基準日),
                                leq(基準日, tekiyoShuryoYMD),
                                eq(kanriKubun, 管理区分))).
                order(by(rirekiNo, DESC)).limit(INT_1).
                toObject(DbT4021ShiharaiHohoHenkoEntity.class);
    }
}
