/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 審査決定請求合計一時
 *
 * @reamsid_L DBC-2500-013 jiangxiaolong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT1613SinsaKetteiSeikyuGokeiTempEntity extends DbTableEntityBase<DbWT1613SinsaKetteiSeikyuGokeiTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private int gokeiRirekiNo;
    @TempTableColumnOrder(2)
    private HokenshaNo hokenshaNo;
    @TempTableColumnOrder(3)
    private RString hokenshaName;
    @TempTableColumnOrder(4)
    private FlexibleYearMonth shinsaYM;
    @TempTableColumnOrder(5)
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @TempTableColumnOrder(6)
    private RString kokuhorenName;
    @TempTableColumnOrder(7)
    private Decimal gokeiKensu;
    @TempTableColumnOrder(8)
    private Decimal gokeiTanisu;
    @TempTableColumnOrder(9)
    private Decimal gokeiKingaku;
    @TempTableColumnOrder(10)
    private Decimal gokeiKaigoKyufuhiSogoJigyohi;
    @TempTableColumnOrder(11)
    private Decimal gokeiRiyoshaFutangaku;
    @TempTableColumnOrder(12)
    private Decimal gokeiKohiFutangaku;
}
