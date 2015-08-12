/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiChosaHoshuTanka;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5031NinteiChosaHoshuTankaEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.DbT5031NinteiChosaHoshuTankaDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査報酬単価を管理するクラスです。
 */
public class NinteiChosaHoshuTankaManager {

    private final DbT5031NinteiChosaHoshuTankaDac dac;

    /**
     * コンストラクタです。
     */
    public NinteiChosaHoshuTankaManager() {
        dac = InstanceProvider.create(DbT5031NinteiChosaHoshuTankaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5031NinteiChosaHoshuTankaDac}
     */
    NinteiChosaHoshuTankaManager(DbT5031NinteiChosaHoshuTankaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する認定調査報酬単価を返します。
     *
     * @param 調査区分 調査区分
     * @param 訪問種別 訪問種別
     * @param 意見書入手パターン 意見書入手パターン
     * @param 開始年月 開始年月
     * @param 終了年月 終了年月
     * @return NinteiChosaHoshuTanka
     */
    @Transaction
    public NinteiChosaHoshuTanka get認定調査報酬単価(
            Code 調査区分,
            Code 訪問種別,
            Code 意見書入手パターン,
            FlexibleYearMonth 開始年月,
            FlexibleYearMonth 終了年月) {
        requireNonNull(調査区分, UrSystemErrorMessages.値がnull.getReplacedMessage("調査区分"));
        requireNonNull(訪問種別, UrSystemErrorMessages.値がnull.getReplacedMessage("訪問種別"));
        requireNonNull(意見書入手パターン, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書入手パターン"));
        requireNonNull(開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月"));
        requireNonNull(終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("終了年月"));

        DbT5031NinteiChosaHoshuTankaEntity entity = dac.selectByKey(
                調査区分,
                訪問種別,
                意見書入手パターン,
                開始年月,
                終了年月);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NinteiChosaHoshuTanka(entity);
    }

    /**
     * 認定調査報酬単価を全件返します。
     *
     * @return NinteiChosaHoshuTankaの{@code list}
     */
    @Transaction
    public List<NinteiChosaHoshuTanka> get認定調査報酬単価一覧() {
        List<NinteiChosaHoshuTanka> businessList = new ArrayList<>();

        for (DbT5031NinteiChosaHoshuTankaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new NinteiChosaHoshuTanka(entity));
        }

        return businessList;
    }

    /**
     * 認定調査報酬単価{@link NinteiChosaHoshuTanka}を保存します。
     *
     * @param 認定調査報酬単価 {@link NinteiChosaHoshuTanka}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査報酬単価(NinteiChosaHoshuTanka 認定調査報酬単価) {
        requireNonNull(認定調査報酬単価, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査報酬単価"));
        if (!認定調査報酬単価.hasChanged()) {
            return false;
        }
        return 1 == dac.save(認定調査報酬単価.toEntity());
    }
}
