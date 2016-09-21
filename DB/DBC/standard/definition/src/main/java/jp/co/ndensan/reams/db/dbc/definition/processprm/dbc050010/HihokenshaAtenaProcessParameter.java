/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050010;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc050010.HihokenshaAtenaMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import lombok.Getter;
import lombok.Setter;

/**
 * 一時TBLに登録する_Process処理パラメタークラスです．
 *
 * @reamsid_L DBC-5010-030 donghj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HihokenshaAtenaProcessParameter implements IBatchProcessParameter {

    /**
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @return HihokenshaAtenaMybatisParameter
     */
    public HihokenshaAtenaMybatisParameter toHihokenshaAtenaMybatisParameter(IShikibetsuTaishoPSMSearchKey searchKey) {
        return new HihokenshaAtenaMybatisParameter(searchKey);
    }

}
