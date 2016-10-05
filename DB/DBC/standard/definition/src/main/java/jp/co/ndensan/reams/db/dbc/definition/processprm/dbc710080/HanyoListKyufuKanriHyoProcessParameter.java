/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc710080;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc710080.HanyoListKyufuKanriHyoMybatisParameter;
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
 * 汎用リスト(給付管理票)ProcessParameterのクラスです。
 *
 * @reamsid_L DBC-3096-020 pengxingyi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HanyoListKyufuKanriHyoProcessParameter implements IBatchProcessParameter {

    private FlexibleYearMonth 給付対象年月From;
    private FlexibleYearMonth 給付対象年月To;
    private RString 居宅支援事業者コード;
    private RString 居宅支援事業者名;
    private RString 委託先支援事業者コード;
    private RString 委託先支援事業者名;
    private RString 明細行出力有無;
    private boolean 項目名付加;
    private boolean 連番付加;
    private boolean 日付スラッシュ付加;
    private LasdecCode 保険者コード;
    private Long 出力順;
    private RString 出力項目;

    private IShikibetsuTaishoPSMSearchKey searchKey;

    private RDateTime システム日時;
    private FlexibleDate システム日付;

    /**
     * toMyBatisParameterのメソッドです。
     *
     * @return {@link HanyoListKagoMoshitateMybatisParameter}
     */
    public HanyoListKyufuKanriHyoMybatisParameter toMybatisParameter() {
        HanyoListKyufuKanriHyoMybatisParameter param = new HanyoListKyufuKanriHyoMybatisParameter(searchKey);
        param.set給付対象年月From(給付対象年月From);
        param.set給付対象年月To(給付対象年月To);
        param.set居宅支援事業者コード(居宅支援事業者コード);
        param.set委託先支援事業者コード(委託先支援事業者コード);
        param.set明細行出力有無(明細行出力有無);
        param.set出力順(出力項目);
        return param;
    }
}
