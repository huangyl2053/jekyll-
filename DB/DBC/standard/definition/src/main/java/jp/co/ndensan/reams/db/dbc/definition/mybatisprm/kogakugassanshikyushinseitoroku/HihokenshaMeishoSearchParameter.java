/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassanshikyushinseitoroku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;

/**
 * 被保険者名の取得用パラメータクラスです。
 *
 * @reamsid_L DBC-2040-040 huzongcheng
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class HihokenshaMeishoSearchParameter {

    private final UaFt200FindShikibetsuTaishoParam shikibetsutaishoParam;
    private final HihokenshaNo 被保険者番号;

    /**
     * コンストラクタです。
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param 被保険者番号 HihokenshaNo
     */
    private HihokenshaMeishoSearchParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            HihokenshaNo 被保険者番号) {
        this.shikibetsutaishoParam = new UaFt200FindShikibetsuTaishoParam(searchKey);
        this.被保険者番号 = 被保険者番号;
    }

    /**
     * コンストラクタです。
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param 被保険者番号 HihokenshaNo
     * @return HihokenshaMeishoSearchParameter
     */
    public static HihokenshaMeishoSearchParameter
            createSelectByKeyParam(IShikibetsuTaishoPSMSearchKey searchKey, HihokenshaNo 被保険者番号) {
        return new HihokenshaMeishoSearchParameter(searchKey, 被保険者番号);
    }

}
