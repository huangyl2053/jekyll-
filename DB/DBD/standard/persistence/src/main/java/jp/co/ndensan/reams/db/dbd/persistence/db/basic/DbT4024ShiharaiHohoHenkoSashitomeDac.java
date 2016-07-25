/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4024ShiharaiHohoHenkoSashitome;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4024ShiharaiHohoHenkoSashitome.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4024ShiharaiHohoHenkoSashitome.johoBunruiKubun;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4024ShiharaiHohoHenkoSashitome.kanriKubun;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4024ShiharaiHohoHenkoSashitome.renNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4024ShiharaiHohoHenkoSashitome.rirekiNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4024ShiharaiHohoHenkoSashitome.sashitomeKojoJotaiKubun;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4024ShiharaiHohoHenkoSashitome.sashitome_ServiceTeikyoYM;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4024ShiharaiHohoHenkoSashitome.sashitome_ShokanSeiriNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4024ShiharaiHohoHenkoSashitome.shoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4024ShiharaiHohoHenkoSashitomeEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 支払方法変更差止のデータアクセスクラスです。
 */
public class DbT4024ShiharaiHohoHenkoSashitomeDac implements ISaveable<DbT4024ShiharaiHohoHenkoSashitomeEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで支払方法変更差止を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 管理区分 管理区分
     * @param 履歴番号 履歴番号
     * @param 情報分類区分 情報分類区分
     * @param 連番 連番
     * @return DbT4024ShiharaiHohoHenkoSashitomeEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4024ShiharaiHohoHenkoSashitomeEntity selectByKey(
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            RString 管理区分,
            int 履歴番号,
            RString 情報分類区分,
            int 連番) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(管理区分, UrSystemErrorMessages.値がnull.getReplacedMessage("管理区分"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(情報分類区分, UrSystemErrorMessages.値がnull.getReplacedMessage("情報分類区分"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4024ShiharaiHohoHenkoSashitome.class).
                where(and(
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(kanriKubun, 管理区分),
                                eq(rirekiNo, 履歴番号),
                                eq(johoBunruiKubun, 情報分類区分),
                                eq(renNo, 連番))).
                toObject(DbT4024ShiharaiHohoHenkoSashitomeEntity.class);
    }

    /**
     * 支払方法変更差止を全件返します。
     *
     * @return DbT4024ShiharaiHohoHenkoSashitomeEntityの{@code list}
     */
    @Transaction
    public List<DbT4024ShiharaiHohoHenkoSashitomeEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4024ShiharaiHohoHenkoSashitome.class).
                toList(DbT4024ShiharaiHohoHenkoSashitomeEntity.class);
    }

    /**
     * DbT4024ShiharaiHohoHenkoSashitomeEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT4024ShiharaiHohoHenkoSashitomeEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("支払方法変更差止エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 支払方法変更差止を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @return 支払方法変更差止
     */
    @Transaction
    public DbT4024ShiharaiHohoHenkoSashitomeEntity get支払方法変更差止(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4024ShiharaiHohoHenkoSashitome.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(johoBunruiKubun, new RString("1")),
                                eq(sashitomeKojoJotaiKubun, new RString("01")),
                                eq(sashitome_ShokanSeiriNo, 整理番号),
                                eq(sashitome_ServiceTeikyoYM, サービス提供年月))).
                toObject(DbT4024ShiharaiHohoHenkoSashitomeEntity.class);
    }

    /**
     * 支払方法変更差止を更新。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     * @param hihokenshaNo 被保険者番号
     * @param kanriKubun 管理区分
     * @param rirekiNo 履歴番号
     * @param johoBunruiKubun 情報分類区分
     * @param renNo 連番
     * @param sashitomeTsuchiHakkoYMD　差止通知書発行年月日
     */
    @Transaction
    public void updateSashitomeTsuchiHakkoYMD(ShoKisaiHokenshaNo shoKisaiHokenshaNo, HihokenshaNo hihokenshaNo, RString kanriKubun,
            int rirekiNo, RString johoBunruiKubun, int renNo, FlexibleDate sashitomeTsuchiHakkoYMD) {
        DbT4024ShiharaiHohoHenkoSashitomeEntity entity = selectByKey(shoKisaiHokenshaNo, hihokenshaNo, kanriKubun, rirekiNo, johoBunruiKubun, renNo);
        entity.setSashitome_TsuchiHakkoYMD(sashitomeTsuchiHakkoYMD);
        save(entity);
    }

    /**
     * 支払方法変更差止を更新。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     * @param hihokenshaNo 被保険者番号
     * @param kanriKubun 管理区分
     * @param rirekiNo 履歴番号
     * @param johoBunruiKubun 情報分類区分
     * @param renNo 連番
     * @param KojoTsuchiHakkoYMD　控除通知書発行年月日
     */
    @Transaction
    public void updateKojoTsuchiHakkoYMD(ShoKisaiHokenshaNo shoKisaiHokenshaNo, HihokenshaNo hihokenshaNo, RString kanriKubun,
            int rirekiNo, RString johoBunruiKubun, int renNo, FlexibleDate KojoTsuchiHakkoYMD) {
        DbT4024ShiharaiHohoHenkoSashitomeEntity entity = selectByKey(shoKisaiHokenshaNo, hihokenshaNo, kanriKubun, rirekiNo, johoBunruiKubun, renNo);
        entity.setKojo_TsuchiHakkoYMD(KojoTsuchiHakkoYMD);
        save(entity);
    }
}
