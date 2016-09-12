/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 過誤決定集計一時TBL
 *
 * @reamsid_L DBC-0980-302 surun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT3060KagoKetteiShukeiTempEntity {

    private FlexibleYearMonth 取扱年月;
    private int 履歴番号;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private RString 証記載保険者名;
    private FlexibleDate 作成年月日;
    private int 介護給付費件数;
    private Decimal 介護給付費単位数;
    private Decimal 介護給付費保険者負担額;
    private int 高額介護サービス費件数;
    private Decimal 高額介護サービス費単位数;
    private Decimal 高額介護サービス費保険者負担額;
    private int 特定入所者介護サービス費等件数;
    private Decimal 特定入所者介護サービス費等費用額;
    private Decimal 特定入所者介護サービス費等保険者負担額;
    private FlexibleYearMonth 取込年月;
    private ShoKisaiHokenshaNo 保険者番号;
    private RString 保険者名;

}
