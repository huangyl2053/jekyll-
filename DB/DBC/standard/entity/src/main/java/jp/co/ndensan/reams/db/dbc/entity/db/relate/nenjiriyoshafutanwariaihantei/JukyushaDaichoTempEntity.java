/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.nenjiriyoshafutanwariaihantei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 受給者台帳のEntity
 *
 * @reamsid_L DBC-4980-030 yuanzhenxia
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaDaichoTempEntity extends DbTableEntityBase<JukyushaDaichoTempEntity> implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private HihokenshaNo dbT4001JukyushaDaicho_hihokenshaNo;
    @PrimaryKey
    @TempTableColumnOrder(2)
    private ShikibetsuCode dbT4001JukyushaDaicho_shikibetsuCode;
    @PrimaryKey
    @TempTableColumnOrder(3)
    private LasdecCode shichosonCode;
    @PrimaryKey
    @TempTableColumnOrder(4)
    private RString rirekiNoRString;
    @PrimaryKey
    @TempTableColumnOrder(5)
    private RString edaban;
    @PrimaryKey
    @TempTableColumnOrder(6)
    private Code jukyuShinseiJiyu;
    @PrimaryKey
    @TempTableColumnOrder(7)
    private FlexibleDate jukyuShinseiYMD;
    @PrimaryKey
    @TempTableColumnOrder(8)
    private Code yokaigoJotaiKubunCode;
    @PrimaryKey
    @TempTableColumnOrder(9)
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    @PrimaryKey
    @TempTableColumnOrder(10)
    private FlexibleDate ninteiYukoKikanShuryoYMD;
    @PrimaryKey
    @TempTableColumnOrder(11)
    private FlexibleDate ninteiYMD;
    @PrimaryKey
    @TempTableColumnOrder(12)
    private boolean kyuSochishaFlag;
    @PrimaryKey
    @TempTableColumnOrder(13)
    private HihokenshaNo dbT1001HihokenshaDaicho_hihokenshaNo;
    @PrimaryKey
    @TempTableColumnOrder(14)
    private FlexibleDate idoYMD;
    @PrimaryKey
    @TempTableColumnOrder(5)
    private RString idoJiyuCode;
    @PrimaryKey
    @TempTableColumnOrder(16)
    private FlexibleDate shikakuShutokuYMD;
    @PrimaryKey
    @TempTableColumnOrder(17)
    private FlexibleDate shikakuShutokuTodokedeYMD;
    @PrimaryKey
    @TempTableColumnOrder(18)
    private FlexibleDate ichigoShikakuShutokuYMD;
    @PrimaryKey
    @TempTableColumnOrder(19)
    private RString hihokennshaKubunCode;
    @PrimaryKey
    @TempTableColumnOrder(20)
    private ShikibetsuCode uaFt200FindShikibetsuTaisho_shikibetsuCode;
    @PrimaryKey
    @TempTableColumnOrder(21)
    private SetaiCode setaiCode;
    @PrimaryKey
    @TempTableColumnOrder(22)
    private AtenaMeisho meisho;
    @PrimaryKey
    @TempTableColumnOrder(23)
    private FlexibleYear shotokuNendo;
    @PrimaryKey
    @TempTableColumnOrder(24)
    private int rirekiNoInt;
    @PrimaryKey
    @TempTableColumnOrder(25)
    private RString kazeiKubun;
    @PrimaryKey
    @TempTableColumnOrder(26)
    private RString kazeiKubunGemmenGo;
    @PrimaryKey
    @TempTableColumnOrder(27)
    private Decimal gokeiShotokuGaku;
    @PrimaryKey
    @TempTableColumnOrder(28)
    private Decimal nenkiniShunyuGaku;
    @PrimaryKey
    @TempTableColumnOrder(29)
    private Decimal nenkiniShotokuGaku;
    @PrimaryKey
    @TempTableColumnOrder(30)
    private Decimal kazeiShotokuGaku;
    @PrimaryKey
    @TempTableColumnOrder(31)
    private RString gekihenKanwaKubun;
    @PrimaryKey
    @TempTableColumnOrder(32)
    private RString dataKubun;

}
