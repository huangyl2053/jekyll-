/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kijunsyunyunenji;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票出力、CSV作成ののパラメータです
 *
 * @reamsid_L DBC-4630-060 jiangwenkai
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class InsTaishoSeitaiyinTempProcessMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    /**
     * コンストラクタ。
     *
     * @param searchKey 宛名識別対象PSM検索キー
     */
    public InsTaishoSeitaiyinTempProcessMybatisParameter(IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
    }

}
