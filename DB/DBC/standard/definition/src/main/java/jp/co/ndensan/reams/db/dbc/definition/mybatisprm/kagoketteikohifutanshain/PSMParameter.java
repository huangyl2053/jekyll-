/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kagoketteikohifutanshain;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;

/**
 * PSMParameter
 */
public class PSMParameter extends UaFt200FindShikibetsuTaishoParam {

    /**
     * コンストラクタです。
     *
     * @param searchKey searchKey
     */
    public PSMParameter(IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
    }

    /**
     * コンストラクタです。
     *
     * @param searchKey searchKey
     * @return PSMParameter
     */
    public static PSMParameter
            createSelectByKeyParam(IShikibetsuTaishoPSMSearchKey searchKey) {
        return new PSMParameter(searchKey);
    }

}
