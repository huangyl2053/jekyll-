/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020070;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import lombok.Getter;
import lombok.Setter;

/**
 * 更新用一時の内容を更新する処理のMYBATIS用パラメータクラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AtenaJohoMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final IShikibetsuTaishoPSMSearchKey searchKey;

    /**
     *
     * コンストラクタです。
     *
     * @param searchKey searchKey
     */
    public AtenaJohoMybatisParameter(IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);

        this.searchKey = searchKey;
    }
}
