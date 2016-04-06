/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanfushikyuketteiin;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;

/**
 * psm Parameter
 */
public class ShokanFushikyuKetteiInPSMParameter extends UaFt200FindShikibetsuTaishoParam {

    /**
     * ShokanFushikyuKetteiInPSMParameter
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     */
    public ShokanFushikyuKetteiInPSMParameter(IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
    }

    /**
     * createSelectByKeyParam
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @return ShokanFushikyuKetteiInPSMParameter
     */
    public static ShokanFushikyuKetteiInPSMParameter createSelectByKeyParam(IShikibetsuTaishoPSMSearchKey searchKey) {
        return new ShokanFushikyuKetteiInPSMParameter(searchKey);
    }
}
