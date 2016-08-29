/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.temptable;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 収納状況一時テーブルクラスです．
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShunoStatusTempTableEntity extends DbTableEntityBase<ShunoStatusTempTableEntity> implements IDbAccessable {

    /**
     * 収納状況一時テーブル名称
     */
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = new RString("ShunoStatusTempTable");
    }
    @TempTableColumnOrder(1)
    private FlexibleYear choteiNendo;
    @TempTableColumnOrder(2)
    private FlexibleYear fukaNendo;
    @TempTableColumnOrder(3)
    private TsuchishoNo tsuchishoNo;
    @TempTableColumnOrder(4)
    private int ki;
    @TempTableColumnOrder(5)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(6)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(7)
    private RDate nokigenYMD;
    @TempTableColumnOrder(8)
    private Decimal choteigaku;
    @TempTableColumnOrder(9)
    private FlexibleDate shunyuYMD;
    @TempTableColumnOrder(10)
    private Decimal shunyuGaku;
    @TempTableColumnOrder(11)
    private FlexibleDate dunningHakkoYMD;
    @TempTableColumnOrder(12)
    private FlexibleDate jikoKisambiYMD;
    @TempTableColumnOrder(13)
    private RString jikoKubun;
    @TempTableColumnOrder(14)
    private RString finshNoKubun;
    @TempTableColumnOrder(15)
    private Decimal miNoGaku;
    @TempTableColumnOrder(16)
    private RString jikoKisambiJiyu;
    @TempTableColumnOrder(17)
    private RString tainoKubun;
    @TempTableColumnOrder(18)
    private int longestTainoPeriod;
    @TempTableColumnOrder(19)
    private Decimal beforeTainoGaku;
    @TempTableColumnOrder(20)
    private RString beforeTainoKubun;
    @TempTableColumnOrder(21)
    private boolean pastYearflag;

}
