/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc710090;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト(過誤申立情報)MyBatisParameterのクラスです。
 *
 * @reamsid_L DBC-3095-020 pengxingyi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HanyoListKagoMoshitateMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private FlexibleYearMonth 国保連送付年月From;
    private FlexibleYearMonth 国保連送付年月To;
    private RString 過誤申立給付区分;
    private FlexibleYearMonth サービス提供年月From;
    private FlexibleYearMonth サービス提供年月To;
    private RString 事業者コード;
    private RString 保険者コード;
    private RString 出力順;

    /**
     * ンストラクタです。
     *
     * @param 国保連送付年月From 国保連送付年月From
     * @param 国保連送付年月To 国保連送付年月To
     * @param 過誤申立給付区分 過誤申立給付区分
     * @param サービス提供年月From サービス提供年月From
     * @param サービス提供年月To サービス提供年月To
     * @param 事業者コード 事業者コード
     * @param 保険者コード 保険者コード
     * @param searchKey searchKey
     */
    public HanyoListKagoMoshitateMybatisParameter(FlexibleYearMonth 国保連送付年月From, FlexibleYearMonth 国保連送付年月To,
            RString 過誤申立給付区分, FlexibleYearMonth サービス提供年月From, FlexibleYearMonth サービス提供年月To,
            RString 事業者コード, RString 保険者コード, IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
        this.国保連送付年月From = 国保連送付年月From;
        this.国保連送付年月To = 国保連送付年月To;
        this.過誤申立給付区分 = 過誤申立給付区分;
        this.サービス提供年月From = サービス提供年月From;
        this.サービス提供年月To = サービス提供年月To;
        this.事業者コード = 事業者コード;
        this.保険者コード = 保険者コード;
    }

}
