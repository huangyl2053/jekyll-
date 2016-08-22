/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhishinsaketteiseikyumeisaihyo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 審査決定請求明細一時TBL
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT1611SinsaKetteiSeikyuMeisai {

    private int 履歴番号;
    private JigyoshaNo 事業所番号;
    private RString 事業所名;
    private FlexibleYearMonth サービス提供年月;
    private ServiceShuruiCode サービス種類コード;
    private RString サービス種類名;
    private Decimal 件数;
    private Decimal 日数_回数;
    private Decimal 単位数;
    private Decimal 金額;
    private Decimal 介護給付費_総合事業費;
    private Decimal 利用者負担額;
    private Decimal 公費負担額;
}
