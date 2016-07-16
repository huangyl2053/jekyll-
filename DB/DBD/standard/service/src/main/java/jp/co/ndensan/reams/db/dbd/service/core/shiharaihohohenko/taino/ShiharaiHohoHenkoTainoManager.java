/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.shiharaihohohenko.taino;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.taino.ShiharaiHohoHenkoTaino;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4022ShiharaiHohoHenkoTainoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 支払方法変更滞納を管理するクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class ShiharaiHohoHenkoTainoManager {

    private final DbT4022ShiharaiHohoHenkoTainoDac dac;

    /**
     * コンストラクタです。
     */
    public ShiharaiHohoHenkoTainoManager() {
        dac = InstanceProvider.create(DbT4022ShiharaiHohoHenkoTainoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT4022ShiharaiHohoHenkoTainoDac}
     */
    ShiharaiHohoHenkoTainoManager(DbT4022ShiharaiHohoHenkoTainoDac dac) {
        this.dac = dac;
    }

    /**
     * 支払方法変更滞納{@link ShiharaiHohoHenkoTaino}を保存します。
     *
     * @param 支払方法変更滞納 {@link ShiharaiHohoHenkoTaino}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public int save(ShiharaiHohoHenkoTaino 支払方法変更滞納) {
        requireNonNull(支払方法変更滞納, UrSystemErrorMessages.値がnull.getReplacedMessage("支払方法変更滞納"));
        int saveCount = dac.save(支払方法変更滞納.toEntity());
        return saveCount;
    }
}
