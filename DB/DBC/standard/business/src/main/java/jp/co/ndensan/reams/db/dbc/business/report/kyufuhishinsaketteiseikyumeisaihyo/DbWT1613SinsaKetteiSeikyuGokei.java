/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhishinsaketteiseikyumeisaihyo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * DB出力(審査決定請求合計一時TBL)
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT1613SinsaKetteiSeikyuGokei {

    private int 履歴番号;
    private HokenshaNo 保険者番号;
    private RString 保険者名;
    private FlexibleYearMonth 審査年月;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private RString 国保連合会名;
    private Decimal 合計_件数;
    private Decimal 合計_単位数;
    private Decimal 合計_金額;
    private Decimal 合計_介護給付費_総合事業費;
    private Decimal 合計_利用者負担額;
    private Decimal 合計_公費負担額;
}
