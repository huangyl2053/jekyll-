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
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 給付実績T1一時TBLテーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT111ZKyufuJissekiT1Entity extends DbTableEntityBase<DbWT111ZKyufuJissekiT1Entity> implements IDbAccessable {

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
    private ServiceShuruiCode serviceSyuruiCode;
    @TempTableColumnOrder(12)
    private Integer serviceJitsunissu;
    @TempTableColumnOrder(13)
    private Decimal planTanisu;
    @TempTableColumnOrder(14)
    private Decimal gendogakuKanriTaishoTanisu;
    @TempTableColumnOrder(15)
    private Decimal gendogakuKanritaishogaiTanisu;
    @TempTableColumnOrder(16)
    private Integer tankiNyushoPlanNissu;
    @TempTableColumnOrder(17)
    private Integer tankiNyushoJitsunissu;
    @TempTableColumnOrder(18)
    private Decimal hokenTanisuTotal;
    @TempTableColumnOrder(19)
    private Decimal hokenTanisuTani;
    @TempTableColumnOrder(20)
    private Decimal hokenSeikyugaku;
    @TempTableColumnOrder(21)
    private Decimal hokenRiyoshaFutangaku;
    @TempTableColumnOrder(22)
    private Decimal kohi1TanisuTotal;
    @TempTableColumnOrder(23)
    private Decimal kohi1Seikyugaku;
    @TempTableColumnOrder(24)
    private Decimal kohi1HonninFutangaku;
    @TempTableColumnOrder(25)
    private Decimal kohi2TanisuTotal;
    @TempTableColumnOrder(26)
    private Decimal kohi2Seikyugaku;
    @TempTableColumnOrder(27)
    private Decimal kohi2HonninFutangaku;
    @TempTableColumnOrder(28)
    private Decimal kohi3TanisuTotal;
    @TempTableColumnOrder(29)
    private Decimal kohi3Seikyugaku;
    @TempTableColumnOrder(30)
    private Decimal kohi3HonninFutangaku;
    @TempTableColumnOrder(31)
    private Decimal hokenDekidakaTanisuTotal;
    @TempTableColumnOrder(32)
    private Decimal hokenDekidakaSeikyugaku;
    @TempTableColumnOrder(33)
    private Decimal hokenDekidakaIryohiRiyoshaFutangaku;
    @TempTableColumnOrder(34)
    private Decimal kohi1DekidakaTanisuTotal;
    @TempTableColumnOrder(35)
    private Decimal kohi1DekidakaSeikyugaku;
    @TempTableColumnOrder(36)
    private Decimal kohi1DekidakaIryohiRiyoshaFutangaku;
    @TempTableColumnOrder(37)
    private Decimal kohi2DekidakaTanisuTotal;
    @TempTableColumnOrder(38)
    private Decimal kohi2DekidakaSeikyugaku;
    @TempTableColumnOrder(39)
    private Decimal kohi2DekidakaIryohiRiyoshaFutangaku;
    @TempTableColumnOrder(40)
    private Decimal kohi3DekidakaTanisuTotal;
    @TempTableColumnOrder(41)
    private Decimal kohi3DekidakaSeikyugaku;
    @TempTableColumnOrder(42)
    private Decimal kohi3DekidakaIryohiRiyoshaFutangaku;
    @TempTableColumnOrder(43)
    private Integer atoTankiNyushoJitsunissu;
    @TempTableColumnOrder(44)
    private Decimal atoHokenTanisuTotal;
    @TempTableColumnOrder(45)
    private Decimal atoHokenSeikyugaku;
    @TempTableColumnOrder(46)
    private Decimal atoKohi1TanisuTotal;
    @TempTableColumnOrder(47)
    private Decimal atoKohi1Seikyugaku;
    @TempTableColumnOrder(48)
    private Decimal atoKohi2TanisuTotal;
    @TempTableColumnOrder(49)
    private Decimal atoKohi2Seikyugaku;
    @TempTableColumnOrder(50)
    private Decimal atoKohi3TanisuTotal;
    @TempTableColumnOrder(51)
    private Decimal atoKohi3Seikyugaku;
    @TempTableColumnOrder(52)
    private Decimal atoHokenDekidakaTanisuTotal;
    @TempTableColumnOrder(53)
    private Decimal atoHokenDekidakaSeikyugaku;
    @TempTableColumnOrder(54)
    private Decimal atoKohi1DekidakaTanisuTotal;
    @TempTableColumnOrder(55)
    private Decimal atoKohi1DekidakaSeikyugaku;
    @TempTableColumnOrder(56)
    private Decimal atoKohi2DekidakaTanisuTotal;
    @TempTableColumnOrder(57)
    private Decimal atoKohi2DekidakaSeikyugaku;
    @TempTableColumnOrder(58)
    private Decimal atoKohi3DekidakaTanisuTotal;
    @TempTableColumnOrder(59)
    private Decimal atoKohi3DekidakaSeikyugaku;
    @TempTableColumnOrder(60)
    private Integer saishinsaKaisu;
    @TempTableColumnOrder(61)
    private Integer kagoKaisu;
    @TempTableColumnOrder(62)
    private FlexibleYearMonth shinsaYM;
    @TempTableColumnOrder(63)
    private RString seiriNo;
    @TempTableColumnOrder(64)
    private FlexibleYearMonth torikomiYM;
}
