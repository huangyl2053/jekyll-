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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 給付実績DC一時TBLテーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT111NKyufuJissekiDCEntity extends DbTableEntityBase<DbWT111NKyufuJissekiDCEntity> implements IDbAccessable {

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
    private RString kinkyuShobyoName1;
    @TempTableColumnOrder(13)
    private RString kinkyuShobyoName2;
    @TempTableColumnOrder(14)
    private RString kinkyuShobyoName3;
    @TempTableColumnOrder(15)
    private FlexibleDate kinkyuChiryoKaishiYMD1;
    @TempTableColumnOrder(16)
    private FlexibleDate kinkyuChiryoKaishiYMD2;
    @TempTableColumnOrder(17)
    private FlexibleDate kinkyuChiryoKaishiYMD3;
    @TempTableColumnOrder(18)
    private int oshinNissu;
    @TempTableColumnOrder(19)
    private RString oshinIryoKikanName;
    @TempTableColumnOrder(20)
    private int tsuinNissu;
    @TempTableColumnOrder(21)
    private RString tsuinIryoKikanName;
    @TempTableColumnOrder(22)
    private int kinkyuChiryoKanriTanisu;
    @TempTableColumnOrder(23)
    private int kinkyuChiryoKanriNissu;
    @TempTableColumnOrder(24)
    private int kinkyuChiryoKanriSubTotal;
    @TempTableColumnOrder(25)
    private int rehabilitationTensu;
    @TempTableColumnOrder(26)
    private int shochiTensu;
    @TempTableColumnOrder(27)
    private int shujutsuTensu;
    @TempTableColumnOrder(28)
    private int masuiTensu;
    @TempTableColumnOrder(29)
    private int hoshasenChiryoTensu;
    @TempTableColumnOrder(30)
    private RString tekiyo1;
    @TempTableColumnOrder(31)
    private RString tekiyo2;
    @TempTableColumnOrder(32)
    private RString tekiyo3;
    @TempTableColumnOrder(33)
    private RString tekiyo4;
    @TempTableColumnOrder(34)
    private RString tekiyo5;
    @TempTableColumnOrder(35)
    private RString tekiyo6;
    @TempTableColumnOrder(36)
    private RString tekiyo7;
    @TempTableColumnOrder(37)
    private RString tekiyo8;
    @TempTableColumnOrder(38)
    private RString tekiyo9;
    @TempTableColumnOrder(39)
    private RString tekiyo10;
    @TempTableColumnOrder(40)
    private RString tekiyo11;
    @TempTableColumnOrder(41)
    private RString tekiyo12;
    @TempTableColumnOrder(42)
    private RString tekiyo13;
    @TempTableColumnOrder(43)
    private RString tekiyo14;
    @TempTableColumnOrder(44)
    private RString tekiyo15;
    @TempTableColumnOrder(45)
    private RString tekiyo16;
    @TempTableColumnOrder(46)
    private RString tekiyo17;
    @TempTableColumnOrder(47)
    private RString tekiyo18;
    @TempTableColumnOrder(48)
    private RString tekiyo19;
    @TempTableColumnOrder(49)
    private RString tekiyo20;
    @TempTableColumnOrder(50)
    private int kinkyuShisetsuRyoyohiTotalTensu;
    @TempTableColumnOrder(51)
    private RString shoteiShikkanShisetsuRyoyohiShobyoName1;
    @TempTableColumnOrder(52)
    private RString shoteiShikkanShisetsuRyoyohiShobyoName2;
    @TempTableColumnOrder(53)
    private RString shoteiShikkanShisetsuRyoyohiShobyoName3;
    @TempTableColumnOrder(54)
    private FlexibleDate shoteiShikkanShisetsuRyoyohiKaishiYMD1;
    @TempTableColumnOrder(55)
    private FlexibleDate shoteiShikkanShisetsuRyoyohiKaishiYMD2;
    @TempTableColumnOrder(56)
    private FlexibleDate shoteiShikkanShisetsuRyoyohiKaishiYMD3;
    @TempTableColumnOrder(57)
    private int shoteiShikkanShisetsuRyoyohiTanisu;
    @TempTableColumnOrder(58)
    private int shoteiShikkanShisetsuRyoyohiNissu;
    @TempTableColumnOrder(59)
    private int shoteiShikkanShisetsuRyoyohiSubTotal;
    @TempTableColumnOrder(60)
    private int atoOshinNissu;
    @TempTableColumnOrder(61)
    private int atoTsuinNissu;
    @TempTableColumnOrder(62)
    private int atoKinkyuChiryoKanriTanisu;
    @TempTableColumnOrder(63)
    private int atoKinkyuChiryoKanriNissu;
    @TempTableColumnOrder(64)
    private int atoRehabilitationTensu;
    @TempTableColumnOrder(65)
    private int atoShochiTensu;
    @TempTableColumnOrder(66)
    private int atoShujutsuTensu;
    @TempTableColumnOrder(67)
    private int atoMasuiTensu;
    @TempTableColumnOrder(68)
    private int atoHoshasenChiryoTensu;
    @TempTableColumnOrder(69)
    private int atoShoteiShikkanShisetsuRyoyoHiTanisu;
    @TempTableColumnOrder(70)
    private int atoShoteiShikkanShisetsuRyoyoHiNissu;
    @TempTableColumnOrder(71)
    private int saishinsaKaisu;
    @TempTableColumnOrder(72)
    private int kagoKaisu;
    @TempTableColumnOrder(73)
    private FlexibleYearMonth shinsaYM;
    @TempTableColumnOrder(74)
    private RString seiriNo;
    @TempTableColumnOrder(75)
    private FlexibleYearMonth torikomiYM;
}
