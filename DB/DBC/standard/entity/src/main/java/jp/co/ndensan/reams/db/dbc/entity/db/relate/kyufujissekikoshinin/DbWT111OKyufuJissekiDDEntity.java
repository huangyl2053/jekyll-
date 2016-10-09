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
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 給付実績DD一時TBLテーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT111OKyufuJissekiDDEntity extends DbTableEntityBase<DbWT111OKyufuJissekiDDEntity> implements IDbAccessable {

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
    private ServiceShuruiCode serviceShuruiCode;
    @TempTableColumnOrder(12)
    private ServiceKomokuCode serviceKomokuCode;
    @TempTableColumnOrder(13)
    private Decimal tanisu;
    @TempTableColumnOrder(14)
    private Decimal nissuKaisu;
    @TempTableColumnOrder(15)
    private Decimal kohi1TaishoNissuKaisu;
    @TempTableColumnOrder(16)
    private Decimal kohi2TaishoNissuKaisu;
    @TempTableColumnOrder(17)
    private Decimal kohi3TaishoNissuKaisu;
    @TempTableColumnOrder(18)
    private int serviceTanisu;
    @TempTableColumnOrder(19)
    private int kohi1TaishoServiceTanisu;
    @TempTableColumnOrder(20)
    private int kohi2TaishoServiceTanisu;
    @TempTableColumnOrder(21)
    private int kohi3TaishoServiceTanisu;
    @TempTableColumnOrder(22)
    private ShoKisaiHokenshaNo shisetsuShozaiHokenshaNo;
    @TempTableColumnOrder(23)
    private RString tekiyo;
    @TempTableColumnOrder(24)
    private Decimal atoTanisu;
    @TempTableColumnOrder(25)
    private Decimal atoNissuKaisu;
    @TempTableColumnOrder(26)
    private Decimal atoKohi1TaishoNissuKaisu;
    @TempTableColumnOrder(27)
    private Decimal atoKohi2TaishoNissukaisu;
    @TempTableColumnOrder(28)
    private Decimal atoKohi3TaishoNissuKaisu;
    @TempTableColumnOrder(29)
    private int atoServiceTanisu;
    @TempTableColumnOrder(30)
    private int atoKohi1TaishoServiceTanisu;
    @TempTableColumnOrder(31)
    private int atoKohi2TaishoServiceTanisu;
    @TempTableColumnOrder(32)
    private int atoKohi3TaishoServiceTanisu;
    @TempTableColumnOrder(33)
    private Decimal saishinsaKaisu;
    @TempTableColumnOrder(34)
    private Decimal kagoKaisu;
    @TempTableColumnOrder(35)
    private FlexibleYearMonth shinsaYM;
    @TempTableColumnOrder(36)
    private RString seiriNo;
    @TempTableColumnOrder(37)
    private FlexibleYearMonth torikomiYM;
}
