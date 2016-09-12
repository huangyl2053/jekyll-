/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshainmasutatoroku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 再審査決定明細一時TBL Entity
 *
 * @reamsid_L DBC-2520-011 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT3064SaishinsaKetteiMeisai extends
        DbTableEntityBase<DbWT3064SaishinsaKetteiMeisai> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private FlexibleYearMonth 取扱年月;
    @TempTableColumnOrder(2)
    private Decimal 履歴番号;
    @TempTableColumnOrder(3)
    private Decimal 決定明細連番;
    @TempTableColumnOrder(4)
    private JigyoshaNo 事業所番号;
    @TempTableColumnOrder(5)
    private RString 事業所名;
    @TempTableColumnOrder(6)
    private RString 公費負担者番号;
    @TempTableColumnOrder(7)
    private RString 公費受給者番号;
    @TempTableColumnOrder(8)
    private HokenshaNo 公費証記載保険者番号;
    @TempTableColumnOrder(9)
    private FlexibleYearMonth サービス提供年月;
    @TempTableColumnOrder(10)
    private ServiceShuruiCode サービス種類コード;
    @TempTableColumnOrder(11)
    private RString サービス種類名;
    @TempTableColumnOrder(12)
    private RString 申立事由コード;
    @TempTableColumnOrder(13)
    private RString 申立事由;
    @TempTableColumnOrder(14)
    private RString 再審査結果コード;
    @TempTableColumnOrder(15)
    private Decimal 当初請求単位数;
    @TempTableColumnOrder(16)
    private Decimal 原審単位数;
    @TempTableColumnOrder(17)
    private Decimal 申立単位数;
    @TempTableColumnOrder(18)
    private Decimal 決定単位数;
    @TempTableColumnOrder(19)
    private Decimal 調整単位数;
    @TempTableColumnOrder(20)
    private Decimal 保険者負担額;
    @TempTableColumnOrder(21)
    private FlexibleYearMonth 取込年月;
}
