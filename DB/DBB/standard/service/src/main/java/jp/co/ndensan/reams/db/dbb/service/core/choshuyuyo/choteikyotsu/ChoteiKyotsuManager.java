/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.choshuyuyo.choteikyotsu;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.choteikyotsu.ChoteiKyotsu;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.UrT0705ChoteiKyotsuDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 調定共通（介護継承）を管理するクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class ChoteiKyotsuManager {

    private final UrT0705ChoteiKyotsuDac dac;

    /**
     * コンストラクタです。
     */
    public ChoteiKyotsuManager() {
        dac = InstanceProvider.create(UrT0705ChoteiKyotsuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link UrT0705ChoteiKyotsuDac}
     */
    ChoteiKyotsuManager(UrT0705ChoteiKyotsuDac dac) {
        this.dac = dac;
    }

    /**
     * 調定共通{@link ChoteiKyotsu}を保存します。
     *
     * @param 調定共通 {@link ChoteiKyotsu}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save調定共通(ChoteiKyotsu 調定共通) {
        requireNonNull(調定共通, UrSystemErrorMessages.値がnull.getReplacedMessage("調定共通"));
        if (!調定共通.hasChanged()) {
            return false;
        }
        return 1 == dac.save(調定共通.toEntity());
    }
}
