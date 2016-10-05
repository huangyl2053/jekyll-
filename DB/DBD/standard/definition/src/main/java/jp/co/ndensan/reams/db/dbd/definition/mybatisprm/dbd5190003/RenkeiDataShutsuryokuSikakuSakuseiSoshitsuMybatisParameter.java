/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5190003;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Getter;

/**
 * 資格喪失（死亡）データ作成のMybatisパラメータ。
 *
 * @reamsid_L DBD-2110-010 LDNS shaotw
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RenkeiDataShutsuryokuSikakuSakuseiSoshitsuMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final FlexibleDate 今回開始日時;
    private final FlexibleDate 今回終了日時;

    /**
     * コンストラクタ。
     *
     * @param 今回開始日時 RDateTime
     * @param 今回終了日時 RDateTime
     * @param searchKey 宛名識別対象PSM検索キー
     */
    public RenkeiDataShutsuryokuSikakuSakuseiSoshitsuMybatisParameter(FlexibleDate 今回開始日時, FlexibleDate 今回終了日時,
            IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
        this.今回開始日時 = 今回開始日時;
        this.今回終了日時 = 今回終了日時;
    }
}
