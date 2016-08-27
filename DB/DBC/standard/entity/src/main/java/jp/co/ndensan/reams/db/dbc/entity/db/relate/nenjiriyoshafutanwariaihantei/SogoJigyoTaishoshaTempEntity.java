/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.nenjiriyoshafutanwariaihantei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 総合事業対象者台帳Entity
 *
 * @reamsid_L DBC-4980-030 yuanzhenxia
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogoJigyoTaishoshaTempEntity extends DbTableEntityBase<SogoJigyoTaishoshaTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private HihokenshaNo dbT3105SogoJigyoTaishosha_hihokenshaNo;
    @TempTableColumnOrder(2)
    private int dbT3105SogoJigyoTaishosha_rirekiNo;
    @TempTableColumnOrder(3)
    private FlexibleDate tekiyoKaishiYMD;
    @TempTableColumnOrder(4)
    private FlexibleDate tekiyoShuryoYMD;
    @TempTableColumnOrder(5)
    private FlexibleDate checklistJisshiYMD;
    @TempTableColumnOrder(6)
    private HihokenshaNo dbT1001HihokenshaDaicho_hihokenshaNo;
    @TempTableColumnOrder(7)
    private FlexibleDate idoYMD;
    @TempTableColumnOrder(8)
    private RString idoJiyuCode;
    @TempTableColumnOrder(9)
    private FlexibleDate shikakuShutokuYMD;
    @TempTableColumnOrder(10)
    private FlexibleDate shikakuShutokuTodokedeYMD;
    @TempTableColumnOrder(11)
    private FlexibleDate ichigoShikakuShutokuYMD;
    @TempTableColumnOrder(12)
    private RString hihokennshaKubunCode;
    @TempTableColumnOrder(13)
    private ShikibetsuCode uaFt200FindShikibetsuTaisho_shikibetsuCode;
    @TempTableColumnOrder(14)
    private SetaiCode setaiCode;
    @TempTableColumnOrder(15)
    private AtenaMeisho meisho;
    @TempTableColumnOrder(16)
    private FlexibleYear shotokuNendo;
    @TempTableColumnOrder(17)
    private int rirekiNoInt;
    @TempTableColumnOrder(18)
    private RString kazeiKubun;
    @TempTableColumnOrder(19)
    private RString kazeiKubunGemmenGo;
    @TempTableColumnOrder(20)
    private Decimal gokeiShotokuGaku;
    @TempTableColumnOrder(21)
    private Decimal nenkiniShunyuGaku;
    @TempTableColumnOrder(22)
    private Decimal nenkiniShotokuGaku;
    @TempTableColumnOrder(23)
    private Decimal kazeiShotokuGaku;
    @TempTableColumnOrder(24)
    private RString gekihenKanwaKubun;
    @TempTableColumnOrder(25)
    private RString dataKubun;
    @TempTableColumnOrder(26)
    private RString shikibetsuCode;

}
