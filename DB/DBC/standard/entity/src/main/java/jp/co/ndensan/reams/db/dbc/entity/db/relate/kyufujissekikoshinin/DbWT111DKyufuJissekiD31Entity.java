/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 給付実績D3・1一時TBLテーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT111DKyufuJissekiD31Entity extends DbTableEntityBase<DbWT111DKyufuJissekiD31Entity> implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private int renban;
    @TempTableColumnOrder(2)
    private RString recordNo;
    @TempTableColumnOrder(3)
    private KokanShikibetsuNo kokanShikibetsuNo;
    @TempTableColumnOrder(4)
    private NyuryokuShikibetsuNo inputShikibetsuNo;
    @TempTableColumnOrder(5)
    private RString recodeShubetsuCode;
    @TempTableColumnOrder(6)
    private HokenshaNo shokisaiHokenshaNo;
    @TempTableColumnOrder(7)
    private HihokenshaNo hiHokenshaNo;
    @TempTableColumnOrder(8)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(9)
    private JigyoshaNo jigyoshoNo;
    @TempTableColumnOrder(10)
    private RString toshiNo;
    @TempTableColumnOrder(11)
    private RString recodeJunjiNo;
    @TempTableColumnOrder(12)
    private RString shobyoName;
    @TempTableColumnOrder(13)
    private int hokenShidoKanriryo;
    @TempTableColumnOrder(14)
    private int hokenTanjunXsen;
    @TempTableColumnOrder(15)
    private int hokenRehabilitation;
    @TempTableColumnOrder(16)
    private int hokenSeishinkaSemmonRyoho;
    @TempTableColumnOrder(17)
    private int hokenTotalTanisu;
    @TempTableColumnOrder(18)
    private int kohi1ShidoKanriryo;
    @TempTableColumnOrder(19)
    private int kohi1TanjunXsen;
    @TempTableColumnOrder(20)
    private int kohi1Rehabilitation;
    @TempTableColumnOrder(21)
    private int kohi1SeishinkaSemmonRyoho;
    @TempTableColumnOrder(22)
    private int kohi1TotalTanisu;
    @TempTableColumnOrder(23)
    private int kohi2ShidoKanriryo;
    @TempTableColumnOrder(24)
    private int kohi2TanjunXsen;
    @TempTableColumnOrder(25)
    private int kohi2Rehabilitation;
    @TempTableColumnOrder(26)
    private int kohi2SeishinkaSemmonRyoho;
    @TempTableColumnOrder(27)
    private int kohi2TotalTanisu;
    @TempTableColumnOrder(28)
    private int kohi3ShidoKanriryo;
    @TempTableColumnOrder(29)
    private int kohi3TanjunXsen;
    @TempTableColumnOrder(30)
    private int kohi3Rehabilitation;
    @TempTableColumnOrder(31)
    private int kohi3SeishinkaSemmonRyoho;
    @TempTableColumnOrder(32)
    private int kohi3TotalTanisu;
    @TempTableColumnOrder(33)
    private RString tekiyo1;
    @TempTableColumnOrder(34)
    private RString tekiyo2;
    @TempTableColumnOrder(35)
    private RString tekiyo3;
    @TempTableColumnOrder(36)
    private RString tekiyo4;
    @TempTableColumnOrder(37)
    private RString tekiyo5;
    @TempTableColumnOrder(38)
    private RString tekiyo6;
    @TempTableColumnOrder(39)
    private RString tekiyo7;
    @TempTableColumnOrder(40)
    private RString tekiyo8;
    @TempTableColumnOrder(41)
    private RString tekiyo9;
    @TempTableColumnOrder(42)
    private RString tekiyo10;
    @TempTableColumnOrder(43)
    private RString tekiyo11;
    @TempTableColumnOrder(44)
    private RString tekiyo12;
    @TempTableColumnOrder(45)
    private RString tekiyo13;
    @TempTableColumnOrder(46)
    private RString tekiyo14;
    @TempTableColumnOrder(47)
    private RString tekiyo15;
    @TempTableColumnOrder(48)
    private RString tekiyo16;
    @TempTableColumnOrder(49)
    private RString tekiyo17;
    @TempTableColumnOrder(50)
    private RString tekiyo18;
    @TempTableColumnOrder(51)
    private RString tekiyo19;
    @TempTableColumnOrder(52)
    private RString tekiyo20;
    @TempTableColumnOrder(53)
    private int atoHokenShidoKanriryo;
    @TempTableColumnOrder(54)
    private int atoHokenTanjunXsen;
    @TempTableColumnOrder(55)
    private int atoHokenRehabilitation;
    @TempTableColumnOrder(56)
    private int atoHokenSeishinkaSemmonRyoho;
    @TempTableColumnOrder(57)
    private int atoKohi1ShidoKanriryo;
    @TempTableColumnOrder(58)
    private int atoKohi1TanjunXsen;
    @TempTableColumnOrder(59)
    private int atoKohi1Rehabilitation;
    @TempTableColumnOrder(60)
    private int atoKohi1SeishinkaSemmonRyoho;
    @TempTableColumnOrder(61)
    private int atoKohi2ShidoKanriryo;
    @TempTableColumnOrder(62)
    private int atoKohi2TanjunXsen;
    @TempTableColumnOrder(63)
    private int atoKohi2Rehabilitation;
    @TempTableColumnOrder(64)
    private int atoKohi2SeishinkaSemmonRyoho;
    @TempTableColumnOrder(65)
    private int atoKohi3ShidoKanriryo;
    @TempTableColumnOrder(66)
    private int atoKohi3TanjunXsen;
    @TempTableColumnOrder(67)
    private int atoKohi3Rehabilitation;
    @TempTableColumnOrder(68)
    private int atoKohi3SeishinkaSemmonRyoho;
    @TempTableColumnOrder(69)
    private int saishinsaKaisu;
    @TempTableColumnOrder(70)
    private int kagoKaisu;
    @TempTableColumnOrder(71)
    private FlexibleYearMonth shinsaYM;
    @TempTableColumnOrder(72)
    private RString seiriNo;
    @TempTableColumnOrder(73)
    private FlexibleYearMonth torikomiYM;
}
