/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.choshuyuyo.choteikyotsu;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.choteikyotsu.ChoteiKyotsu;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.UrT0705ChoteiKyotsuDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 調定共通（介護継承）を管理するクラスです。
 *
 * @reamsid_L DBB-9999-022 xuxin
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

    /**
     * 主キーに合致する調定共通（介護継承）を返します。
     *
     * @param 調定ID Decimal
     * @return ChoteiKyotsu
     */
    @Transaction
    public ChoteiKyotsu get調定共通情報(Decimal 調定ID) {
        requireNonNull(調定ID, UrSystemErrorMessages.値がnull.getReplacedMessage("調定ID"));

        UrT0705ChoteiKyotsuEntity entity = dac.selectByKey(調定ID.longValue());
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ChoteiKyotsu(entity);
    }

}
