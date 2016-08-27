/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariaihanteiichiran;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 利用者負担割合判定Entityクラスです。
 *
 * @reamsid_L DBC-4980-031 yuanzhenxia
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RiyoshaFutanWariaiHanteiEntity extends DbTableEntityBase<RiyoshaFutanWariaiHanteiEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private RString taisyouKubun;
    @TempTableColumnOrder(2)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(3)
    private Code koseiJiyu;
    @TempTableColumnOrder(4)
    private FlexibleYear nendo;
    @TempTableColumnOrder(5)
    private RString futanWariaiKubun;
    @TempTableColumnOrder(6)
    private Decimal honninGoukeiShotokuGaku;
    @TempTableColumnOrder(7)
    private int setaiIchigouHihokenshaSu;
    @TempTableColumnOrder(8)
    private FlexibleDate yukoKaishiYMD;
    @TempTableColumnOrder(9)
    private FlexibleDate yukoShuryoYMD;
    @TempTableColumnOrder(10)
    private Decimal nenkinShunyuGoukei;
    @TempTableColumnOrder(11)
    private Decimal sonotanoGoukeiShotokuKingakuGoukei;

}
