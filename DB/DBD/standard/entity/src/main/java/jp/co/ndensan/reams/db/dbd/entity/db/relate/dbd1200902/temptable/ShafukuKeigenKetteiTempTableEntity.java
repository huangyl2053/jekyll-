/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd1200902.temptable;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author admin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShafukuKeigenKetteiTempTableEntity extends DbTableEntityBase<ShafukuKeigenKetteiTempTableEntity> implements IDbAccessable {

    public static final RString TABLE_NAME = new RString("ShafukuKeigenKetteiTempTable");

    @TempTableColumnOrder(1)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(2)
    private boolean ninteishoHakkoZumi;
    @TempTableColumnOrder(3)
    private boolean tsuchiHakkoZumi;
    @TempTableColumnOrder(4)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(5)
    private FlexibleDate shinseiYMD;
    @TempTableColumnOrder(6)
    private FlexibleDate ketteiYMD;
    @TempTableColumnOrder(7)
    private FlexibleDate tekiyoYMD;
    @TempTableColumnOrder(8)
    private FlexibleDate yukoKigenYMD;
    @TempTableColumnOrder(9)
    private RString ketteiKubun;

    @TempTableColumnOrder(10)
    private Decimal keigenritsu;
    @TempTableColumnOrder(11)
    private Decimal keigenritsu_Bunshi;
    @TempTableColumnOrder(12)
    private Decimal keigenritsu_Bumbo;
    @TempTableColumnOrder(13)
    private boolean kyotakuServiceGentei;
    @TempTableColumnOrder(14)
    private boolean kyojuhiShokuhiNomi;
    @TempTableColumnOrder(15)
    private boolean kyusochishaUnitTypeKoshitsuNomi;
}
