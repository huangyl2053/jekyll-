/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.saishinsaketteihokenshain;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 再審査決定集計一時TBL
 *
 * @reamsid_L DBC-2520-012 surun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT3063SaishinsaKetteiShukeiTempEntity {

    private FlexibleYearMonth 取扱年月;
    private int 履歴番号;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private RString 証記載保険者名;
    private FlexibleDate 作成年月日;
    private RString 国保連合会名;
    private RString 審査委員会名;
    private int 介護給付費請求件数;
    private Decimal 介護給付費請求単位数;
    private Decimal 介護給付費請求保険者負担額;
    private int 介護給付費決定件数;
    private Decimal 介護給付費決定単位数;
    private Decimal 介護給付費決定保険者負担額;
    private int 介護給付費調整件数;
    private Decimal 介護給付費調整単位数;
    private Decimal 介護給付費調整保険者負担額;
    private int 高額介護サービス費請求件数;
    private Decimal 高額介護サービス費請求単位数;
    private Decimal 高額介護サービス費請求保険者負担額;
    private int 高額介護サービス費決定件数;
    private Decimal 高額介護サービス費決定単位数;
    private Decimal 高額介護サービス費決定保険者負担額;
    private int 高額介護サービス費調整件数;
    private Decimal 高額介護サービス費調整単位数;
    private Decimal 高額介護サービス費調整保険者負担額;
    private FlexibleYearMonth 取込年月;
    private ShoKisaiHokenshaNo 保険者番号;
    private RString 保険者名;

}
