/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishoshain;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 高額介護サービス費給付対象者一時テーブルのEntity
 *
 * @reamsid_L DBC-0980-370 chenaoqi
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbTKogakuKyufuTaishoshaDataTempTableEntity
        extends DbTableEntityBase<DbTKogakuKyufuTaishoshaDataTempTableEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private RString kokanShikibetsuNo;
    @TempTableColumnOrder(2)
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @TempTableColumnOrder(3)
    private RString hihokenshaName;
    @TempTableColumnOrder(4)
    private FlexibleDate sakuseiYMD;
    @TempTableColumnOrder(5)
    private RString kokukoRengoukaiNa;
    @TempTableColumnOrder(6)
    private RString no;
    @TempTableColumnOrder(7)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(8)
    private RString hiHokenshaSimei;
    @TempTableColumnOrder(9)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(10)
    private JigyoshaNo jigyoshaNo;
    @TempTableColumnOrder(11)
    private RString jigyoshaName;
    @TempTableColumnOrder(12)
    private ServiceShuruiCode serviceShuruiCode;
    @TempTableColumnOrder(13)
    private RString serviceShuruiName;
    @TempTableColumnOrder(14)
    private Decimal serviceHiyoGokeiGaku;
    @TempTableColumnOrder(15)
    private Decimal riyoshaFutanGaku;
    @TempTableColumnOrder(16)
    private RString bikou;
    @TempTableColumnOrder(17)
    private FlexibleDate shikakuSoshitsuYMD;
    @TempTableColumnOrder(18)
    private Decimal serviceHiyoGokeiGakuGokei;
    @TempTableColumnOrder(19)
    private Decimal riyoshaFutanGakuGokei;
    @TempTableColumnOrder(20)
    private Decimal santeiKijunGaku;
    @TempTableColumnOrder(21)
    private Decimal shiharaiSumiKingakuGokei;
    @TempTableColumnOrder(22)
    private Decimal kogakuShikyuGaku;
    @TempTableColumnOrder(23)
    private HihokenshaNo setaiShuyakuNo;

}
