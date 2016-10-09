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
 * 給付実績D9一時TBLテーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT111KKyufuJissekiD9Entity extends DbTableEntityBase<DbWT111KKyufuJissekiD9Entity> implements IDbAccessable {

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
    private ServiceShuruiCode serviceSyuruiCode;
    @TempTableColumnOrder(13)
    private ServiceKomokuCode serviceKomokuCode;
    @TempTableColumnOrder(14)
    private Decimal hiyoTanka;
    @TempTableColumnOrder(15)
    private Decimal futanGendogaku;
    @TempTableColumnOrder(16)
    private Integer nissu;
    @TempTableColumnOrder(17)
    private Integer kohi1Nissu;
    @TempTableColumnOrder(18)
    private Integer kohi2Nissu;
    @TempTableColumnOrder(19)
    private Integer kohi3Nissu;
    @TempTableColumnOrder(20)
    private Decimal hiyogaku;
    @TempTableColumnOrder(21)
    private Decimal hokenbunSeikyugaku;
    @TempTableColumnOrder(22)
    private Decimal kohi1Futangaku;
    @TempTableColumnOrder(23)
    private Decimal kohi2Futangaku;
    @TempTableColumnOrder(24)
    private Decimal kohi3Futangaku;
    @TempTableColumnOrder(25)
    private Decimal riyoshaFutangaku;
    @TempTableColumnOrder(26)
    private Decimal hiyogakuTotal;
    @TempTableColumnOrder(27)
    private Decimal hokenbunSeikyugakuTotal;
    @TempTableColumnOrder(28)
    private Decimal riyoshaFutangakuTotal;
    @TempTableColumnOrder(29)
    private Decimal kohi1FutangakuTotal;
    @TempTableColumnOrder(30)
    private Decimal kohi1Seikyugaku;
    @TempTableColumnOrder(31)
    private Decimal kohi1HonninFutanGetsugaku;
    @TempTableColumnOrder(32)
    private Decimal kohi2FutangakuTotal;
    @TempTableColumnOrder(33)
    private Decimal kohi2Seikyugaku;
    @TempTableColumnOrder(34)
    private Decimal kohi2HonninFutanGetsugaku;
    @TempTableColumnOrder(35)
    private Decimal kohi3FutangakuTotal;
    @TempTableColumnOrder(36)
    private Decimal kohi3Seikyugaku;
    @TempTableColumnOrder(37)
    private Decimal kohi3HonninFutanGetsugaku;
    @TempTableColumnOrder(38)
    private Decimal atoHiyoTanka;
    @TempTableColumnOrder(39)
    private Integer atoNissu;
    @TempTableColumnOrder(40)
    private Integer atoKohi1Nissu;
    @TempTableColumnOrder(41)
    private Integer atoKohi2Nissu;
    @TempTableColumnOrder(42)
    private Integer atoKohi3Nissu;
    @TempTableColumnOrder(43)
    private Decimal atoHiyogaku;
    @TempTableColumnOrder(44)
    private Decimal atoHokenbunSeikyugaku;
    @TempTableColumnOrder(45)
    private Decimal atoKohi1Futangaku;
    @TempTableColumnOrder(46)
    private Decimal atoKohi2Futangaku;
    @TempTableColumnOrder(47)
    private Decimal atoKohi3Futangaku;
    @TempTableColumnOrder(48)
    private Decimal atoRiyoshaFutangaku;
    @TempTableColumnOrder(49)
    private Decimal atoHiyogakuTotal;
    @TempTableColumnOrder(50)
    private Decimal atoHokenbunSeikyugakuTotal;
    @TempTableColumnOrder(51)
    private Decimal atoRiyoshaFutangakuTotal;
    @TempTableColumnOrder(52)
    private Decimal atoKohi1FutangakuTotal;
    @TempTableColumnOrder(53)
    private Decimal atoKohi1Seikyugaku;
    @TempTableColumnOrder(54)
    private Decimal atoKohi1HonninFutanGetsugaku;
    @TempTableColumnOrder(55)
    private Decimal atoKohi2FutangakuTotal;
    @TempTableColumnOrder(56)
    private Decimal atoKohi2Seikyugaku;
    @TempTableColumnOrder(57)
    private Decimal atoKohi2HonninFutanGetsugaku;
    @TempTableColumnOrder(58)
    private Decimal atoKohi3FutangakuTotal;
    @TempTableColumnOrder(59)
    private Decimal atoKohi3Seikyugaku;
    @TempTableColumnOrder(60)
    private Decimal atoKohi3HonninFutanGetsugaku;
    @TempTableColumnOrder(61)
    private Integer saishinsaKaisu;
    @TempTableColumnOrder(62)
    private Integer kagoKaisu;
    @TempTableColumnOrder(63)
    private FlexibleYearMonth shinsaYM;
    @TempTableColumnOrder(64)
    private RString seiriNo;
    @TempTableColumnOrder(65)
    private FlexibleYearMonth torikomiYM;
}
