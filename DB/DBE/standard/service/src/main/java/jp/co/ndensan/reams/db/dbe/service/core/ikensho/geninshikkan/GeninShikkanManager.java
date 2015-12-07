/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ikensho.geninshikkan;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.geninshikkan.GeninShikkan;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5300GeninShikkanDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 原因疾患を管理するクラスです。
 */
public class GeninShikkanManager {

    private final DbT5300GeninShikkanDac dac;

    /**
     * コンストラクタです。
     */
    public GeninShikkanManager() {
        dac = InstanceProvider.create(DbT5300GeninShikkanDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5300GeninShikkanDac}
     */
    GeninShikkanManager(DbT5300GeninShikkanDac dac) {
        this.dac = dac;
    }

    /**
     * 原因疾患{@link GeninShikkan}を保存します。
     *
     * @param 原因疾患 {@link GeninShikkan}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save原因疾患(GeninShikkan 原因疾患) {
        requireNonNull(原因疾患, UrSystemErrorMessages.値がnull.getReplacedMessage("原因疾患"));
        if (!原因疾患.hasChanged()) {
            return false;
        }
        return 1 == dac.save(原因疾患.toEntity());
    }
}
