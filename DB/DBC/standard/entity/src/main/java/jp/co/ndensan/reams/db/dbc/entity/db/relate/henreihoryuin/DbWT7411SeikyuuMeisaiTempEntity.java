/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.henreihoryuin;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 請求明細一時TBL Entity。
 *
 * @reamsid_L DBC-2830-010 yaodongsheng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT7411SeikyuuMeisaiTempEntity extends
        DbTableEntityBase<DbWT7411SeikyuuMeisaiTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private int renban;
    @TempTableColumnOrder(2)
    private int meisaiRirekiNo;
    @TempTableColumnOrder(3)
    private RString jigyoshaNo;
    @TempTableColumnOrder(4)
    private RString jigyoshaName;
    @TempTableColumnOrder(5)
    private RString shubetsu;
    @TempTableColumnOrder(6)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(7)
    private RString serviceShuruiCode;
    @TempTableColumnOrder(8)
    private RString serviceKoumokuCode;
    @TempTableColumnOrder(9)
    private Decimal tanisu;
    @TempTableColumnOrder(10)
    private RString jiyu;
    @TempTableColumnOrder(11)
    private RString naiyo;
    @TempTableColumnOrder(12)
    private RString biko;

}
