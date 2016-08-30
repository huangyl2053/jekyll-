/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.nenreitotatsushikakuido;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 宛名識別対象PSM_DB検索用のパラメータです。
 *
 * @reamsid_L DBA-0330-010 xuyue
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class AtenaMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final FlexibleDate 開始日;
    private final FlexibleDate 終了日;

    /**
     * 宛名識別対象PSMの取得のパラメータ作成を行います。
     *
     * @param shikibetsuTaishoPSMSearchKey 宛名識別対象PSM検索キー
     * @param 開始日
     * @param 終了日
     */
    public AtenaMybatisParameter(IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey, FlexibleDate 開始日, FlexibleDate 終了日) {
        super(shikibetsuTaishoPSMSearchKey);
        this.開始日 = 開始日;
        this.終了日 = 終了日;
    }
}
