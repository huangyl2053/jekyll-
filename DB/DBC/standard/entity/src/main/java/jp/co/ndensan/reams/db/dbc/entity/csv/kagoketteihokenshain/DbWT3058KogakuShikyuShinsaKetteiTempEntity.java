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
 * 高額介護サービス費支給審査決定一時TBL
 *
 * @reamsid_L DBC-0980-390 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT3058KogakuShikyuShinsaKetteiTempEntity {

    private int 連番;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private RString 証記載保険者名;
    private FlexibleDate 作成年月日;
    private RString 国保連合会名;
    private RString no;
    private FlexibleYearMonth サービス提供年月;
    private Decimal 利用者負担額;
    private RString 支給区分コード;
    private FlexibleYearMonth 決定年月;
    private Decimal 高額支給額;
    private RString 支払方法区分コード;
    private boolean 更新済フラグ;

}
