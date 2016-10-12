/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.temptable;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 滞納者対策情報一時テーブルクラスです．
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TainoCountermeasureTempTableEntity extends DbTableEntityBase<ShokanUnpaidTempTableEntity> implements IDbAccessable {

    /**
     * 滞納者対策情報一時テーブル名称
     */
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = new RString("TainoCountermeasureTempTable");
    }
    @TempTableColumnOrder(1)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(2)
    private FlexibleDate tekiyoKaishiYMD;
    @TempTableColumnOrder(3)
    private FlexibleDate tekiyoShuryoYMD;
    @TempTableColumnOrder(4)
    private FlexibleDate shuryoUketsukeYMD;
    @TempTableColumnOrder(5)
    private FlexibleDate yokokuHakkoYMD;
    @TempTableColumnOrder(6)
    private FlexibleDate bemmeiYMD;
    @TempTableColumnOrder(7)
    private FlexibleDate bemmeiUketsukeYMD;
    @TempTableColumnOrder(8)
    private FlexibleDate shokanYMD;
    @TempTableColumnOrder(9)
    private FlexibleDate shokanHakkoYMD;
    @TempTableColumnOrder(10)
    private int sashitomeProcessNumber;
    @TempTableColumnOrder(11)
    private Decimal sashitomeProcessKingaku;
    @TempTableColumnOrder(12)
    private FlexibleDate sashitomePaymentYMD;
    @TempTableColumnOrder(13)
    private int koujoNumber;
    @TempTableColumnOrder(14)
    private FlexibleDate kojoShoTeishutsuYMD;
    @TempTableColumnOrder(15)
    private RString torokuKubun;
    @TempTableColumnOrder(16)
    private RString shuryoKubun;

}
