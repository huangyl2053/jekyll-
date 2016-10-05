/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shoukanbaraishikyuketteitsuchisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBCMN12028_償還払い支給（不支給）決定通知書作成（単）のパラメータ。
 *
 * @reamsid_L DBC-5310-030 jinge
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoukanbaraiShikyuKetteiTsuchishoParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private RString 整理番号;

    /**
     * コンストラクタです。
     *
     * @param searchKey searchKey
     */
    public ShoukanbaraiShikyuKetteiTsuchishoParameter(IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
    }
}
