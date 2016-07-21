/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.shiharaihohohenko.shiharaihohohenkogengaku.meisai;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.gengaku.meisai.ShiharaiHohoHenkoGengakuMeisai;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4026ShiharaiHohoHenkoGengakuMeisaiDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 支払方法変更減額明細を管理するクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class ShiharaiHohoHenkoGengakuMeisaiManager {

    private final DbT4026ShiharaiHohoHenkoGengakuMeisaiDac dac;

    /**
     * コンストラクタです。
     */
    public ShiharaiHohoHenkoGengakuMeisaiManager() {
        dac = InstanceProvider.create(DbT4026ShiharaiHohoHenkoGengakuMeisaiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT4026ShiharaiHohoHenkoGengakuMeisaiDac}
     */
    ShiharaiHohoHenkoGengakuMeisaiManager(DbT4026ShiharaiHohoHenkoGengakuMeisaiDac dac) {
        this.dac = dac;
    }

    /**
     * 支払方法変更減額明細{@link ShiharaiHohoHenkoGengakuMeisai}を保存します。
     *
     * @param 支払方法変更減額明細 {@link ShiharaiHohoHenkoGengakuMeisai}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public int save(ShiharaiHohoHenkoGengakuMeisai 支払方法変更減額明細) {
        requireNonNull(支払方法変更減額明細, UrSystemErrorMessages.値がnull.getReplacedMessage("支払方法変更減額明細"));
        int saveCount = dac.save(支払方法変更減額明細.toEntity());
        return saveCount;
    }
}
