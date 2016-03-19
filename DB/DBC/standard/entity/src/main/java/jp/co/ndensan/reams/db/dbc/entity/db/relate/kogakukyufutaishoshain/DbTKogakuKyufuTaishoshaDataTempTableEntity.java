/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishoshain;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 高額介護サービス費給付対象者一時テーブルのEntity
 *
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbTKogakuKyufuTaishoshaDataTempTableEntity implements IDbAccessable {

    @TableName
    public static final RString TABLE_NAME = new RString("DbTKogakuKyufuTaishoshaDataTempTable");
    @TempTableColumnOrder(1)
    private RString kokanShikibetsuNo;
    @TempTableColumnOrder(2)
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @TempTableColumnOrder(3)
    private HokenshaNo hokenshaNo;
    @TempTableColumnOrder(4)
    private RString hihokenshaName;
    @TempTableColumnOrder(5)
    private FlexibleDate sakuseiYMD;
    @TempTableColumnOrder(6)
    private RString kokukoRengoukaiNa;
    @TempTableColumnOrder(7)
    private RString No;
    @TempTableColumnOrder(8)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(9)
    private RString hiHokenshaSimei;
    @TempTableColumnOrder(10)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(11)
    private JigyoshaNo jigyoshaNo;
    @TempTableColumnOrder(12)
    private RString jigyoshaName;
    @TempTableColumnOrder(13)
    private ServiceShuruiCode serviceShuruiCode;
    @TempTableColumnOrder(14)
    private RString serviceShuruiName;
    @TempTableColumnOrder(15)
    private Decimal serviceHiyoGokeiGaku;
    @TempTableColumnOrder(16)
    private Decimal riyoshaFutanGaku;
    @TempTableColumnOrder(17)
    private RString bikou;
    @TempTableColumnOrder(18)
    private FlexibleDate shikakuSoshitsuYMD;
    @TempTableColumnOrder(19)
    private Decimal serviceHiyoGokeiGakuGokei;
    @TempTableColumnOrder(20)
    private Decimal riyoshaFutanGakuGokei;
    @TempTableColumnOrder(21)
    private Decimal santeiKijunGaku;
    @TempTableColumnOrder(22)
    private Decimal shiharaiSumiKingakuGokei;
    @TempTableColumnOrder(23)
    private Decimal kogakuShikyuGaku;
    @TempTableColumnOrder(24)
    private RString setaiShuyakuNo;

}
