/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.shiharaihohohenko.sashitome;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.sashitome.ShiharaiHohoHenkoSashitome;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4024ShiharaiHohoHenkoSashitomeDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 支払方法変更差止を管理するクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class ShiharaiHohoHenkoSashitomeManager {

    private final DbT4024ShiharaiHohoHenkoSashitomeDac dac;

    /**
     * コンストラクタです。
     */
    public ShiharaiHohoHenkoSashitomeManager() {
        dac = InstanceProvider.create(DbT4024ShiharaiHohoHenkoSashitomeDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT4024ShiharaiHohoHenkoSashitomeDac}
     */
    ShiharaiHohoHenkoSashitomeManager(DbT4024ShiharaiHohoHenkoSashitomeDac dac) {
        this.dac = dac;
    }

    /**
     * 支払方法変更差止{@link ShiharaiHohoHenkoSashitome}を保存します。
     *
     * @param 支払方法変更差止 {@link ShiharaiHohoHenkoSashitome}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public int save(ShiharaiHohoHenkoSashitome 支払方法変更差止) {
        requireNonNull(支払方法変更差止, UrSystemErrorMessages.値がnull.getReplacedMessage("支払方法変更差止"));
        return dac.save(支払方法変更差止.toEntity());
    }
}
