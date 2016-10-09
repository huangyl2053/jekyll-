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
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 給付実績H1一時TBLテーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT111BKyufuJissekiD1Entity extends DbTableEntityBase<DbWT111BKyufuJissekiD1Entity> implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private int renban;
    @TempTableColumnOrder(2)
    private RString recordNo;
    @TempTableColumnOrder(3)
    private KokanShikibetsuNo kokanJohoShikibetsuNo;
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
    private ServiceShuruiCode serviceShuruiCode;
    @TempTableColumnOrder(12)
    private ServiceKomokuCode serviceKomokuCode;
    @TempTableColumnOrder(13)
    private Decimal tanisu;
    @TempTableColumnOrder(14)
    private int nissuKaisu;
    @TempTableColumnOrder(15)
    private int kohi1TaishoNissuKaisu;
    @TempTableColumnOrder(16)
    private int kohi2TaishoNissuKaisu;
    @TempTableColumnOrder(17)
    private int kohi3TaishoNissuKaisu;
    @TempTableColumnOrder(18)
    private Decimal serviceTanisu;
    @TempTableColumnOrder(19)
    private Decimal kohi1TaishoServiceTanisu;
    @TempTableColumnOrder(20)
    private Decimal kohi2TaishoServiceTanisu;
    @TempTableColumnOrder(21)
    private Decimal kohi3TaishoServiceTanisu;
    @TempTableColumnOrder(22)
    private RString tekiyo;
    @TempTableColumnOrder(23)
    private Decimal atoTanisu;
    @TempTableColumnOrder(24)
    private int atoNissuKaisu;
    @TempTableColumnOrder(25)
    private int atoKohi1TaishoNissuKaisu;
    @TempTableColumnOrder(26)
    private int atoKohi2TaishoNissukaisu;
    @TempTableColumnOrder(27)
    private int atoKohi3TaishoNissuKaisu;
    @TempTableColumnOrder(28)
    private Decimal atoServiceTanisu;
    @TempTableColumnOrder(29)
    private Decimal atoKohi1TaishoServiceTanisu;
    @TempTableColumnOrder(30)
    private Decimal atoKohi2TaishoServiceTanisu;
    @TempTableColumnOrder(31)
    private Decimal atoKohi3TaishoServiceTanisu;
    @TempTableColumnOrder(32)
    private int saishinsaKaisu;
    @TempTableColumnOrder(33)
    private int kagoKaisu;
    @TempTableColumnOrder(34)
    private FlexibleYearMonth shinsaYM;
    @TempTableColumnOrder(35)
    private RString seiriNo;
    @TempTableColumnOrder(36)
    private FlexibleYearMonth torikomiYM;
}
