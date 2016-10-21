/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 被保険者一時TBLのEntity
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class HihokenshaTempEntity extends DbTableEntityBase<HihokenshaTempEntity> implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private Decimal exRenban;
    @TempTableColumnOrder(2)
    private RString exHokenshaNo;
    @TempTableColumnOrder(3)
    private RString exHokenshaName;
    @TempTableColumnOrder(4)
    private RString exShoHokenshaNo;
    @TempTableColumnOrder(5)
    private RString exHihokenshaNo;
    @TempTableColumnOrder(6)
    private FlexibleYearMonth exServiceTeikyoYm;
    @TempTableColumnOrder(7)
    private boolean henkanFlag;
    @TempTableColumnOrder(8)
    private RString oldShichosonCode;
    @TempTableColumnOrder(9)
    private RString sofuHihokenshaNo;
    @TempTableColumnOrder(10)
    private RString shichosonCode;
    @TempTableColumnOrder(11)
    private RString kannaiKangaiKubun;
    @TempTableColumnOrder(12)
    private RString yubinNo;
    @TempTableColumnOrder(13)
    private RString choikiCode;
    @TempTableColumnOrder(14)
    private RString gyoseikuCode;
    @TempTableColumnOrder(15)
    private RString gyoseikuMei;
    @TempTableColumnOrder(16)
    private RString jusho;
    @TempTableColumnOrder(17)
    private RString banchi;
    @TempTableColumnOrder(18)
    private RString katagaki;
    @TempTableColumnOrder(19)
    private RString kanaMeisho;
    @TempTableColumnOrder(20)
    private RString meisho;
    @TempTableColumnOrder(21)
    private RString shimei50onKana;
    @TempTableColumnOrder(22)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(23)
    private FlexibleDate shikakuShutokuYmd;
    @TempTableColumnOrder(24)
    private RString shikakuShutokuJiyuCode;
    @TempTableColumnOrder(25)
    private FlexibleDate shikakuSoshitsuYmd;
    @TempTableColumnOrder(26)
    private RString shikakuSoshitsuJiyuCode;
    @TempTableColumnOrder(27)
    private RString setaiShuyakuNo;
    @TempTableColumnOrder(28)
    private FlexibleDate seinenYmd;
    @TempTableColumnOrder(29)
    private RString seibetsuCode;
    @TempTableColumnOrder(30)
    private FlexibleDate shichosonKanyuYmd;
    @TempTableColumnOrder(31)
    private FlexibleDate shichosonDattaiYmd;

}
