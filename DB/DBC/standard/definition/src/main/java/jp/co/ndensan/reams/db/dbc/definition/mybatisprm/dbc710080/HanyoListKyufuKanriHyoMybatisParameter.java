/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc710080;

import jp.co.ndensan.reams.db.dbc.definition.core.kyufukanrihyo.Kyufukanrihyo_MeisaigyoBango;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト(給付管理票)ProcessParameterのクラスです。
 *
 * @reamsid_L DBC-3096-020 pengxingyi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HanyoListKyufuKanriHyoMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private FlexibleYearMonth 給付対象年月From;
    private FlexibleYearMonth 給付対象年月To;
    private RString 居宅支援事業者コード;
    private RString 委託先支援事業者コード;
    private RString 明細行出力有無;
    private LasdecCode 保険者コード;
    private RString 出力順;

    private final RString 給付管理票明細行番号;

    /**
     * ンストラクタです。
     *
     * @param searchKey searchKey
     */
    public HanyoListKyufuKanriHyoMybatisParameter(IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
        給付管理票明細行番号 = Kyufukanrihyo_MeisaigyoBango.終端行.getコード();
    }

}
