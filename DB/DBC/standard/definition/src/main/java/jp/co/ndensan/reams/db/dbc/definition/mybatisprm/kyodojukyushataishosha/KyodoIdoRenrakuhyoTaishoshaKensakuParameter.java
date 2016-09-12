/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyodojukyushataishosha;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;

/**
 * 宛名取得PSM取得用MyBatisパラメータクラスです。
 *
 * @reamsid_L DBC-1951-010 wangkanglei
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KyodoIdoRenrakuhyoTaishoshaKensakuParameter {

    private final UaFt200FindShikibetsuTaishoParam shikibetsutaishoParam;
    private final HihokenshaNo 被保険者番号;

    /**
     * コンストラクタです。
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param 被保険者番号 HihokenshaNo
     */
    private KyodoIdoRenrakuhyoTaishoshaKensakuParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            HihokenshaNo 被保険者番号) {
        this.shikibetsutaishoParam = new UaFt200FindShikibetsuTaishoParam(searchKey);
        this.被保険者番号 = 被保険者番号;
    }

    /**
     * コンストラクタです。
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param 被保険者番号 HihokenshaNo
     * @return KyodoIdoRenrakuhyoTaishoshaKensakuParameter
     */
    public static KyodoIdoRenrakuhyoTaishoshaKensakuParameter
            createSelectByKeyParam(IShikibetsuTaishoPSMSearchKey searchKey, HihokenshaNo 被保険者番号) {
        return new KyodoIdoRenrakuhyoTaishoshaKensakuParameter(searchKey, 被保険者番号);
    }
}
