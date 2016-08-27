/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 審査決定請求明細一時
 *
 * @reamsid_L DBC-2500-013 jiangxiaolong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT1611SinsaKetteiSeikyuMeisaiTempEntity extends DbTableEntityBase<DbWT1611SinsaKetteiSeikyuMeisaiTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private int meisaiRirekiNo;
    @TempTableColumnOrder(2)
    private JigyoshaNo jigyoshoNo;
    @TempTableColumnOrder(3)
    private RString jigyoshoName;
    @TempTableColumnOrder(4)
    private FlexibleYearMonth serviceTeikyouYM;
    @TempTableColumnOrder(5)
    private ServiceShuruiCode serviceShuruiCode;
    @TempTableColumnOrder(6)
    private RString serviceShuruiMei;
    @TempTableColumnOrder(7)
    private Decimal kensu;
    @TempTableColumnOrder(8)
    private Decimal nissuKaisu;
    @TempTableColumnOrder(9)
    private Decimal tanisu;
    @TempTableColumnOrder(10)
    private Decimal kingaku;
    @TempTableColumnOrder(11)
    private Decimal kaigoKyufuhiSogoJigyohi;
    @TempTableColumnOrder(12)
    private Decimal riyoshaFutangaku;
    @TempTableColumnOrder(13)
    private Decimal kohiFutangaku;
}
