/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc710100;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc710100.HanyoListKagoKekkaMybatisParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト出力(過誤結果情報)ProcessParameterのクラスです。
 *
 * @reamsid_L DBC-3094-020 qinzhen
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HanyoListKagoKekkaProcessParameter implements IBatchProcessParameter {

    private FlexibleYearMonth 国保連取扱年月From;
    private FlexibleYearMonth 国保連取扱年月To;
    private RString 保険者区分;
    private FlexibleYearMonth サービス提供年月From;
    private FlexibleYearMonth サービス提供年月To;
    private JigyoshaNo 事業者コード;
    private RString 事業者名;
    private boolean 項目名付加;
    private boolean 連番付加;
    private boolean 日付スラッシュ付加;
    private LasdecCode 保険者コード;
    private RString 出力順;
    private RString 出力項目;

    private IShikibetsuTaishoPSMSearchKey searchKey;

    private RDateTime システム日時;
    private FlexibleDate システム日付;

    /**
     * toMyBatisParameterのメソッドです。
     *
     * @return {@link HanyoListKagoKekkaMybatisParameter}
     */
    public HanyoListKagoKekkaMybatisParameter toMybatisParameter() {
        return new HanyoListKagoKekkaMybatisParameter(国保連取扱年月From, 国保連取扱年月To, 保険者区分,
                サービス提供年月From, サービス提供年月To, 事業者コード, 保険者コード, searchKey);
    }

}
