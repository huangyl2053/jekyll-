/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.syokanbaraishikyukettekyufujssekihensyu;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;

/**
 * 宛名取得PSM取得用MyBatisパラメータクラスです。
 *
 */
public class SyokanbaraiShikyuKetteKyufuJssekiHensyuParameter extends UaFt200FindShikibetsuTaishoParam {

    /**
     * コンストラクタです。
     *
     * @param searchKey
     */
    public SyokanbaraiShikyuKetteKyufuJssekiHensyuParameter(IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
    }

    /**
     * コンストラクタです。
     *
     * @param searchKey
     * @return
     */
    public static SyokanbaraiShikyuKetteKyufuJssekiHensyuParameter
            createSelectByKeyParam(IShikibetsuTaishoPSMSearchKey searchKey) {
        return new SyokanbaraiShikyuKetteKyufuJssekiHensyuParameter(searchKey);
    }
}
