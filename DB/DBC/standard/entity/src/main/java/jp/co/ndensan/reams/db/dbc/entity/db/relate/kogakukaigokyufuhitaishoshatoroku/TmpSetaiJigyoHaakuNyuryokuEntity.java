/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 世帯員所得情報事業高額一時Table
 *
 * @reamsid_L DBC-2010-090 jiangzongyue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TmpSetaiJigyoHaakuNyuryokuEntity {

    @TempTableColumnOrder(1)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(2)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(3)
    private ShikibetsuCode setaiInshikibetsuCode;
    @TempTableColumnOrder(4)
    private FlexibleDate kijunYMD;
    @TempTableColumnOrder(5)
    private FlexibleYear shotokuNendo;
    @TempTableColumnOrder(6)
    private RString jushochiTokureiFlag;
    @TempTableColumnOrder(7)
    private RString setaiCode;
    @TempTableColumnOrder(8)
    private RString honninKubun;
    @TempTableColumnOrder(9)
    private RString kazeiKubun;
    @TempTableColumnOrder(10)
    private RString kazeiKubunGemmenGo;
    @TempTableColumnOrder(11)
    private RString gekihenKanwaKubun;
    @TempTableColumnOrder(12)
    private RString gokeiShotokuGaku;
    @TempTableColumnOrder(13)
    private RString nenkiniShunyuGaku;
    @TempTableColumnOrder(14)
    private RString nenkiniShotokuGaku;
    @TempTableColumnOrder(15)
    private RString kazeiShotokuGaku;
    @TempTableColumnOrder(16)
    private RString torokuGyomu;
    @TempTableColumnOrder(17)
    private RString shichosonCode;
    @TempTableColumnOrder(18)
    private RString shoboKubun;
    @TempTableColumnOrder(19)
    private RString roreiFukushiKubun;
    @TempTableColumnOrder(20)
    private RString setaiinHihokenshaNo;
    @TempTableColumnOrder(21)
    private RString honninKazeiKubun;
    @TempTableColumnOrder(22)
    private RString setaiKazeiKubun;
}
