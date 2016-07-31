/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenko;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenko.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenko.kanriKubun;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenko.rirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenko.shoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 支払方法変更データアクセスクラスです。
 */
public class DbT4021ShiharaiHohoHenkoDac implements ISaveable<DbT4021ShiharaiHohoHenkoEntity> {

    @InjectSession
    private SqlSession session;

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
     * 支払方法変更の更新。
     *
     * @param shoKisaiHokenshaNo shoKisaiHokenshaNo
     * @param hihokenshaNo hihokenshaNo
     * @param kanriKubun kanriKubun
     * @param rirekiNo rirekiNo
     * @param yokokuTsuchiHakkoYMD yokokuTsuchiHakkoYMD
     */
    @Transaction
    public void updateYokokuTsuchiHakkoYMD(ShoKisaiHokenshaNo shoKisaiHokenshaNo, HihokenshaNo hihokenshaNo, RString kanriKubun,
            int rirekiNo, FlexibleDate yokokuTsuchiHakkoYMD) {
        DbT4021ShiharaiHohoHenkoEntity entity = selectByKey(shoKisaiHokenshaNo, hihokenshaNo, kanriKubun, rirekiNo);
        entity.setYokoku_TsuchiHakkoYMD(yokokuTsuchiHakkoYMD);
        save(entity);
    }

    /**
     * 支払方法変更の更新。
     *
     * @param shoKisaiHokenshaNo shoKisaiHokenshaNo
     * @param hihokenshaNo kanriKubun
     * @param kanriKubun kanriKubun
     * @param rirekiNo rirekiNo
     * @param shokanTsuchiHakkoYMD shokanTsuchiHakkoYMD
     */
    @Transaction
    public void updateShokanTsuchiHakkoYMD(ShoKisaiHokenshaNo shoKisaiHokenshaNo, HihokenshaNo hihokenshaNo, RString kanriKubun,
            int rirekiNo, FlexibleDate shokanTsuchiHakkoYMD) {
        DbT4021ShiharaiHohoHenkoEntity entity = selectByKey(shoKisaiHokenshaNo, hihokenshaNo, kanriKubun, rirekiNo);
        entity.setShokan_TsuchiHakkoYMD(shokanTsuchiHakkoYMD);
        save(entity);

    }

    /**
     * 支払方法変更の更新。
     *
     * @param shoKisaiHokenshaNo shoKisaiHokenshaNo
     * @param hihokenshaNo hihokenshaNo
     * @param kanriKubun kanriKubun
     * @param rirekiNo rirekiNo
     * @param gemmenTsuchiHakkoYMD gemmenTsuchiHakkoYMD
     */
    @Transaction
    public void updateGemmen_TsuchiHakkoYMD(ShoKisaiHokenshaNo shoKisaiHokenshaNo, HihokenshaNo hihokenshaNo, RString kanriKubun,
            int rirekiNo, FlexibleDate gemmenTsuchiHakkoYMD) {
        DbT4021ShiharaiHohoHenkoEntity entity = selectByKey(shoKisaiHokenshaNo, hihokenshaNo, kanriKubun, rirekiNo);
        entity.setGemmen_TsuchiHakkoYMD(gemmenTsuchiHakkoYMD);
        save(entity);
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
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
