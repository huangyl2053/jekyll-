/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.fuka;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;

/**
 *
 * @author n3509
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class SetaiHaakuMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final UaFt200FindShikibetsuTaishoParam shikibetsutaishoParam;

    /**
     * コンストラクタです
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     */
    public SetaiHaakuMybatisParameter(IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
        this.shikibetsutaishoParam = new UaFt200FindShikibetsuTaishoParam(searchKey);
    }
}
