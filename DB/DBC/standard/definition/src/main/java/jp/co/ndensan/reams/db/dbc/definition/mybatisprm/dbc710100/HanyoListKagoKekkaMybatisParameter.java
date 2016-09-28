/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc710100;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト出力(過誤結果情報)MyBatisParameterのクラスです。
 *
 * @reamsid_L DBC-3094-020 qinzhen
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HanyoListKagoKekkaMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private FlexibleYearMonth 国保連取扱年月From;
    private FlexibleYearMonth 国保連取扱年月To;
    private RString 保険者区分;
    private FlexibleYearMonth サービス提供年月From;
    private FlexibleYearMonth サービス提供年月To;
    private JigyoshaNo 事業者コード;
    private LasdecCode 保険者コード;

    /**
     * ンストラクタです。
     *
     * @param 国保連取扱年月From 国保連取扱年月From
     * @param 国保連取扱年月To 国保連取扱年月To
     * @param 保険者区分 保険者区分
     * @param サービス提供年月From サービス提供年月From
     * @param サービス提供年月To サービス提供年月To
     * @param 事業者コード 事業者コード
     * @param 保険者コード 保険者コード
     * @param searchKey searchKey
     */
    public HanyoListKagoKekkaMybatisParameter(FlexibleYearMonth 国保連取扱年月From, FlexibleYearMonth 国保連取扱年月To,
            RString 保険者区分, FlexibleYearMonth サービス提供年月From, FlexibleYearMonth サービス提供年月To,
            JigyoshaNo 事業者コード, LasdecCode 保険者コード, IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
        this.国保連取扱年月From = 国保連取扱年月From;
        this.国保連取扱年月To = 国保連取扱年月To;
        this.保険者区分 = 保険者区分;
        this.サービス提供年月From = サービス提供年月From;
        this.サービス提供年月To = サービス提供年月To;
        this.事業者コード = 事業者コード;
        this.保険者コード = 保険者コード;
    }
}
