/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.dbamn71001;

import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 宛名識別対象PSM_DB検索用のパラメータです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class AtenaMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

      private final List<ShikibetsuCode> 識別コード;
    
    /**
     * 宛名識別対象PSMの取得のパラメータ作成を行います。
     * @param shikibetsuTaishoPSMSearchKey 宛名識別対象PSM検索キー
     * @param 識別コード 識別コード
     */
    public AtenaMybatisParameter(IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey, List<ShikibetsuCode> 識別コード) {
        super(shikibetsuTaishoPSMSearchKey);
        this.識別コード = 識別コード;
    }
}
