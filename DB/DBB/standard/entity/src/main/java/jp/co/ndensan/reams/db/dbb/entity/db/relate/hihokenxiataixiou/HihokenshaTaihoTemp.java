/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.hihokenxiataixiou;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 被保険者対象Temp一時
 *
 * @reamsid_L DBB-1820-040 dingminghao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaTaihoTemp extends DbTableEntityBase<HihokenshaTaihoTemp> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(2)
    private FlexibleDate idoYMD;
    @TempTableColumnOrder(3)
    private RString edaNo;
    @TempTableColumnOrder(4)
    private RString idoJiyuCode;
    @TempTableColumnOrder(5)
    private LasdecCode shichosonCode;
    @TempTableColumnOrder(6)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(7)
    private RString shikakuShutokuJiyuCode;
    @TempTableColumnOrder(8)
    private FlexibleDate shikakuShutokuYMD;
    @TempTableColumnOrder(9)
    private FlexibleDate shikakuShutokuTodokedeYMD;
    @TempTableColumnOrder(10)
    private FlexibleDate ichigoShikakuShutokuYMD;
    @TempTableColumnOrder(11)
    private RString hihokennshaKubunCode;
    @TempTableColumnOrder(12)
    private RString shikakuSoshitsuJiyuCode;
    @TempTableColumnOrder(13)
    private FlexibleDate shikakuSoshitsuYMD;
    @TempTableColumnOrder(14)
    private FlexibleDate shikakuSoshitsuTodokedeYMD;
    @TempTableColumnOrder(15)
    private RString shikakuHenkoJiyuCode;
    @TempTableColumnOrder(16)
    private FlexibleDate shikakuHenkoYMD;
    @TempTableColumnOrder(17)
    private FlexibleDate shikakuHenkoTodokedeYMD;
    @TempTableColumnOrder(18)
    private RString jushochitokureiTekiyoJiyuCode;
    @TempTableColumnOrder(19)
    private FlexibleDate jushochitokureiTekiyoYMD;
    @TempTableColumnOrder(20)
    private FlexibleDate tekiyoTodokedeYMD;
    @TempTableColumnOrder(21)
    private RString jushochitokureiKaijoJiyuCode;
    @TempTableColumnOrder(22)
    private FlexibleDate jushochitokureiKaijoYMD;
    @TempTableColumnOrder(23)
    private FlexibleDate tokureiKaijoTodokedeYMD;
    @TempTableColumnOrder(24)
    private RString jushochiTokureiFlag;
    @TempTableColumnOrder(25)
    private RString koikinaiJushochiTokureiFlag;
    @TempTableColumnOrder(26)
    private LasdecCode sochimotoShichosonCode;
    @TempTableColumnOrder(27)
    private LasdecCode kyuShichosonCode;
    @TempTableColumnOrder(28)
    private boolean logicalDeletedFlag;
    @TempTableColumnOrder(29)
    private RString outPutShichosonCode;
    @TempTableColumnOrder(30)
    private FlexibleDate hukaSystemDate;
    @TempTableColumnOrder(31)
    private FlexibleYear hukaNando;

}
