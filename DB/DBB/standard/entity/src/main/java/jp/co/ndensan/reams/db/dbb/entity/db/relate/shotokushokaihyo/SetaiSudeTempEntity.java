/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 世帯員所得情報Temp
 *
 * @reamsid_L DBB-1720-050 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SetaiSudeTempEntity {

    @TempTableColumnOrder(1)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(2)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(3)
    private FlexibleDate kijunYMD;
    @TempTableColumnOrder(4)
    private FlexibleYear shotokuNendo;
    @TempTableColumnOrder(5)
    private RString jushochiTokureiFlag;
    @TempTableColumnOrder(6)
    private SetaiCode setaiCode;
    @TempTableColumnOrder(7)
    private RString honninKubun;
    @TempTableColumnOrder(8)
    private RString kazeiKubun;
    @TempTableColumnOrder(9)
    private RString kazeiKubunGemmenGo;
    @TempTableColumnOrder(10)
    private RString gekihenKanwaKubun;
    @TempTableColumnOrder(11)
    private Decimal gokeiShotokuGaku;
    @TempTableColumnOrder(12)
    private Decimal nenkiniShunyuGaku;
    @TempTableColumnOrder(13)
    private Decimal nenkiniShotokuGaku;
    @TempTableColumnOrder(14)
    private Decimal kazeiShotokuGaku;
    @TempTableColumnOrder(15)
    private RString torokuGyomu;
    @TempTableColumnOrder(16)
    private RString hihokennshaKubunCode;
}
