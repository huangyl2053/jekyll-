/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanfushikyuketteiin;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;

/**
 * 宛名識別対象PSMにデータの取得Parameter
 *
 * @reamsid_L DBC-2590-030 xuhao
 */
public class ShokanFushikyuKetteiInPSMParameter extends UaFt200FindShikibetsuTaishoParam {

    /**
     * 宛名識別対象PSMにデータの取得Parameter
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     */
    public ShokanFushikyuKetteiInPSMParameter(IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
    }

    /**
     * 宛名識別対象PSMにデータの取得Parameter
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @return ShokanFushikyuKetteiInPSMParameter
     */
    public static ShokanFushikyuKetteiInPSMParameter createSelectByKeyParam(IShikibetsuTaishoPSMSearchKey searchKey) {
        return new ShokanFushikyuKetteiInPSMParameter(searchKey);
    }
}
