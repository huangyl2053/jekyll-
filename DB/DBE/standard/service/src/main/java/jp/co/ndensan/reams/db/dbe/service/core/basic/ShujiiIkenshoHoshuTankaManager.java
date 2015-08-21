/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShujiiIkenshoHoshuTanka;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5032ShujiiIkenshoHoshuTankaEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.DbT5032ShujiiIkenshoHoshuTankaDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 意見書作成報酬単価を管理するクラスです。
 */
public class ShujiiIkenshoHoshuTankaManager {

    private final DbT5032ShujiiIkenshoHoshuTankaDac dac;

    /**
     * コンストラクタです。
     */
    public ShujiiIkenshoHoshuTankaManager() {
        dac = InstanceProvider.create(DbT5032ShujiiIkenshoHoshuTankaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5032ShujiiIkenshoHoshuTankaDac}
     */
    ShujiiIkenshoHoshuTankaManager(DbT5032ShujiiIkenshoHoshuTankaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する意見書作成報酬単価を返します。
     *
     * @param 在宅施設区分 在宅施設区分
     * @param 意見書作成回数区分 意見書作成回数区分
     * @param 開始年月 開始年月
     * @return ShujiiIkenshoHoshuTanka
     */
    @Transaction
    public ShujiiIkenshoHoshuTanka get意見書作成報酬単価(
            Code 在宅施設区分,
            Code 意見書作成回数区分,
            FlexibleYearMonth 開始年月) {
        requireNonNull(在宅施設区分, UrSystemErrorMessages.値がnull.getReplacedMessage("在宅施設区分"));
        requireNonNull(意見書作成回数区分, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書作成回数区分"));
        requireNonNull(開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月"));

        DbT5032ShujiiIkenshoHoshuTankaEntity entity = dac.selectByKey(
                在宅施設区分,
                意見書作成回数区分,
                開始年月);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShujiiIkenshoHoshuTanka(entity);
    }

    /**
     * 意見書作成報酬単価を全件返します。
     *
     * @return ShujiiIkenshoHoshuTankaの{@code list}
     */
    @Transaction
    public List<ShujiiIkenshoHoshuTanka> get意見書作成報酬単価一覧() {
        List<ShujiiIkenshoHoshuTanka> businessList = new ArrayList<>();

        for (DbT5032ShujiiIkenshoHoshuTankaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShujiiIkenshoHoshuTanka(entity));
        }

        return businessList;
    }

    /**
     * 意見書作成報酬単価{@link ShujiiIkenshoHoshuTanka}を保存します。
     *
     * @param 意見書作成報酬単価 {@link ShujiiIkenshoHoshuTanka}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save意見書作成報酬単価(ShujiiIkenshoHoshuTanka 意見書作成報酬単価) {
        requireNonNull(意見書作成報酬単価, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書作成報酬単価"));
        if (!意見書作成報酬単価.hasChanged()) {
            return false;
        }
        return 1 == dac.save(意見書作成報酬単価.toEntity());
    }
}
