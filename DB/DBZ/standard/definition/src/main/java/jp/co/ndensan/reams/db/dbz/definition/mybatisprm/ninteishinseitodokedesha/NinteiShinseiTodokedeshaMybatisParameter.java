/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.ninteishinseitodokedesha;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;

/**
 * 介護認定申請届出者の宛名検索条件。
 *
 * @reamsid_L DBZ-1300-110 yaodongsheng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class NinteiShinseiTodokedeshaMybatisParameter extends UaFt200FindShikibetsuTaishoParam {

    /**
     * コンストラクタです
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     */
    public NinteiShinseiTodokedeshaMybatisParameter(IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
    }

}
