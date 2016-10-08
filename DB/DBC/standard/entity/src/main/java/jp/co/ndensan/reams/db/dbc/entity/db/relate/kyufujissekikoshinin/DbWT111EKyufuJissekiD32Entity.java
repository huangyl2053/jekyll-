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
 * 給付実績D3・2一時TBLテーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT111EKyufuJissekiD32Entity extends DbTableEntityBase<DbWT111EKyufuJissekiD32Entity> implements IDbAccessable {

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
    private RString recordShubetsuCode;
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
    private RString shikibetsuNo;
    @TempTableColumnOrder(14)
    private int tanisu;
    @TempTableColumnOrder(15)
    private int hokenKaisu;
    @TempTableColumnOrder(16)
    private int hokenServiceTanisu;
    @TempTableColumnOrder(17)
    private int hokenTotalTanisu;
    @TempTableColumnOrder(18)
    private int kohi1Kaisu;
    @TempTableColumnOrder(19)
    private int kohi1ServiceTanisu;
    @TempTableColumnOrder(20)
    private int kohi1TotalTanisu;
    @TempTableColumnOrder(21)
    private int kohi2Kaisu;
    @TempTableColumnOrder(22)
    private int kohi2ServiceTanisu;
    @TempTableColumnOrder(23)
    private int kohi2TotalTanisu;
    @TempTableColumnOrder(24)
    private int kohi3Kaisu;
    @TempTableColumnOrder(25)
    private int kohi3ServiceTanisu;
    @TempTableColumnOrder(26)
    private int kohi3TotalTanisu;
    @TempTableColumnOrder(27)
    private RString tekiyo;
    @TempTableColumnOrder(28)
    private int atoTanisu;
    @TempTableColumnOrder(29)
    private int atoHokenKaisu;
    @TempTableColumnOrder(30)
    private int atoHokenServiceTanisu;
    @TempTableColumnOrder(31)
    private int atoHokenTotalTanisu;
    @TempTableColumnOrder(32)
    private int atoKohi1Kaisu;
    @TempTableColumnOrder(33)
    private int atoKohi1ServiceTanisu;
    @TempTableColumnOrder(34)
    private int atoKohi1TotalTanisu;
    @TempTableColumnOrder(35)
    private int atoKohi2Kaisu;
    @TempTableColumnOrder(36)
    private int atoKohi2ServiceTanisu;
    @TempTableColumnOrder(37)
    private int atoKohi2TotalTanisu;
    @TempTableColumnOrder(38)
    private int atoKohi3Kaisu;
    @TempTableColumnOrder(39)
    private int atoKohi3ServiceTanisu;
    @TempTableColumnOrder(40)
    private int atoKohi3TotalTanisu;
    @TempTableColumnOrder(41)
    private int saishinsaKaisu;
    @TempTableColumnOrder(42)
    private int kagoKaisu;
    @TempTableColumnOrder(43)
    private FlexibleYearMonth shinsaYM;
    @TempTableColumnOrder(44)
    private RString seiriNo;
    @TempTableColumnOrder(45)
    private FlexibleYearMonth torikomiYM;
}
