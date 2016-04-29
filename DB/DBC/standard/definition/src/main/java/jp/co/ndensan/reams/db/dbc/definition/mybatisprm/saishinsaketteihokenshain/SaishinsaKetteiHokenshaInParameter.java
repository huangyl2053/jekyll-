/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.saishinsaketteihokenshain;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;

/**
 * 再審査決定通知書情報取込（保険者分）のパラメータです。
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
public class SaishinsaKetteiHokenshaInParameter extends UaFt200FindShikibetsuTaishoParam {

    /**
     * コンストラクタです。
     *
     * @param searchKey 宛名検索条件
     */
    public SaishinsaKetteiHokenshaInParameter(IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
    }
}
