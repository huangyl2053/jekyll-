/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshainmasutatoroku;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 再審査決定集計一時TBL Entity
 *
 * @reamsid_L DBC-2520-011 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaiShinsaKetteiShukeiTempEntity extends
        DbTableEntityBase<SaiShinsaKetteiShukeiTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private FlexibleYearMonth 取扱年月;
    @TempTableColumnOrder(2)
    private Decimal 履歴番号;
    @TempTableColumnOrder(3)
    private RString 証記載保険者番号;
    @TempTableColumnOrder(4)
    private RString 証記載保険者名;
    @TempTableColumnOrder(5)
    private FlexibleDate 作成年月日;
    @TempTableColumnOrder(6)
    private RString 国保連合会名;
    @TempTableColumnOrder(7)
    private RString 審査委員会名;
    @TempTableColumnOrder(8)
    private int 介護給付費_請求_件数;
    @TempTableColumnOrder(9)
    private Decimal 介護給付費_請求_単位数;
    @TempTableColumnOrder(10)
    private Decimal 介護給付費_請求_保険者負担額;
    @TempTableColumnOrder(11)
    private int 介護給付費_決定_件数;
    @TempTableColumnOrder(12)
    private Decimal 介護給付費_決定_単位数;
    @TempTableColumnOrder(13)
    private Decimal 介護給付費_決定_保険者負担額;
    @TempTableColumnOrder(14)
    private int 介護給付費_調整_件数;
    @TempTableColumnOrder(15)
    private Decimal 介護給付費_調整_単位数;
    @TempTableColumnOrder(16)
    private Decimal 介護給付費_調整_保険者負担額;
    @TempTableColumnOrder(17)
    private int 高額介護サービス費_請求_件数;
    @TempTableColumnOrder(18)
    private Decimal 高額介護サービス費_請求_単位数;
    @TempTableColumnOrder(19)
    private Decimal 高額介護サービス費_請求_保険者負担額;
    @TempTableColumnOrder(20)
    private int 高額介護サービス費_決定_件数;
    @TempTableColumnOrder(21)
    private Decimal 高額介護サービス費_決定_単位数;
    @TempTableColumnOrder(22)
    private Decimal 高額介護サービス費_決定_保険者負担額;
    @TempTableColumnOrder(23)
    private int 高額介護サービス費_調整_件数;
    @TempTableColumnOrder(24)
    private Decimal 高額介護サービス費_調整_単位数;
    @TempTableColumnOrder(25)
    private Decimal 高額介護サービス費_調整_保険者負担額;
    @TempTableColumnOrder(26)
    private FlexibleYearMonth 取込年月;
    @TempTableColumnOrder(27)
    private RString 保険者番号;
    @TempTableColumnOrder(28)
    private RString 保険者名;
}
