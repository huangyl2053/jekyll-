/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakkoichiran;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 給付費通知書作成(一括)Entityクラスです。
 *
 * @reamsid_L DBC-2280-030 lizhuoxuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuhiTuchiHakkoIchiranRelateEntity extends DbTableEntityBase<KyufuhiTuchiHakkoIchiranRelateEntity>
        implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private RString rekodoShubetsu;
    @TempTableColumnOrder(2)
    private RString rekodoNo;
    @TempTableColumnOrder(3)
    private RString koukanJouhouSikibetuNo;
    @TempTableColumnOrder(4)
    private RString tyouhyouRekodoShubetsu;
    @TempTableColumnOrder(5)
    private RString hokenShaNo;
    @TempTableColumnOrder(6)
    private RString shokisaiHokenshaNo;
    @TempTableColumnOrder(7)
    private RString hiHokenshaNo;
    @TempTableColumnOrder(8)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(9)
    private RString jigyoshoNo;
    @TempTableColumnOrder(10)
    private RString jigyoshoKanji;
    @TempTableColumnOrder(11)
    private RString serviceShuruiCode;
    @TempTableColumnOrder(12)
    private RString serviceKomokuCode;
    @TempTableColumnOrder(13)
    private RString serviceRyakushou;
    @TempTableColumnOrder(14)
    private RString cctaCode;
    @TempTableColumnOrder(15)
    private RString fukushiYouguKaHinmokuCode;
    @TempTableColumnOrder(16)
    private RString fukushiYouguShouhin;
    @TempTableColumnOrder(17)
    private Decimal hiyouGaku;
    @TempTableColumnOrder(18)
    private RString kibouKouriKakaku;
    @TempTableColumnOrder(19)
    private Decimal zenkokuSeikyuKensu;
    @TempTableColumnOrder(20)
    private Decimal zenkokuSaiteiHiyouGaku;
    @TempTableColumnOrder(21)
    private Decimal zenkokuShikiHiyouGaku;
    @TempTableColumnOrder(22)
    private Decimal zenkokuSaikouHiyouGaku;
    @TempTableColumnOrder(23)
    private Decimal zenkokuHeikinHiyouGaku;
    @TempTableColumnOrder(24)
    private Decimal todoufukenSeikyuKensu;
    @TempTableColumnOrder(25)
    private Decimal todoufukenSaiteiHiyouGaku;
    @TempTableColumnOrder(26)
    private Decimal todoufukenShikiHiyouGaku;
    @TempTableColumnOrder(27)
    private Decimal todoufukenSaikouHiyouGaku;
    @TempTableColumnOrder(28)
    private Decimal todoufukenHeikinHiyouGaku;
    @TempTableColumnOrder(29)
    private Decimal hokenShaSeikyuKensu;
    @TempTableColumnOrder(30)
    private Decimal hokenShaSaiteiHiyouGaku;
    @TempTableColumnOrder(31)
    private Decimal hokenShaShikiHiyouGaku;
    @TempTableColumnOrder(32)
    private Decimal hokenShaSaikouHiyouGaku;
    @TempTableColumnOrder(33)
    private Decimal hokenShaHeikinHiyouGaku;
    @TempTableColumnOrder(34)
    private RString zenkokuTanisuHani1;
    @TempTableColumnOrder(35)
    private RString zenkokuTanisuHani2;
    @TempTableColumnOrder(36)
    private RString zenkokuTanisuHani3;
    @TempTableColumnOrder(37)
    private RString zenkokuTanisuHani4;
    @TempTableColumnOrder(38)
    private RString zenkokuTanisuHani5;
    @TempTableColumnOrder(39)
    private RString zenkokuTanisuHani6;
    @TempTableColumnOrder(40)
    private RString zenkokuTanisuHani7;
    @TempTableColumnOrder(41)
    private RString zenkokuTanisuHani8;
    @TempTableColumnOrder(42)
    private RString zenkokuTanisuHani9;
    @TempTableColumnOrder(43)
    private RString zenkokuTanisuHani10;
    @TempTableColumnOrder(44)
    private Decimal zenkokuTanisuHani1Dosu;
    @TempTableColumnOrder(45)
    private Decimal zenkokuTanisuHani2Dosu;
    @TempTableColumnOrder(46)
    private Decimal zenkokuTanisuHani3Dosu;
    @TempTableColumnOrder(47)
    private Decimal zenkokuTanisuHani4Dosu;
    @TempTableColumnOrder(48)
    private Decimal zenkokuTanisuHani5Dosu;
    @TempTableColumnOrder(49)
    private Decimal zenkokuTanisuHani6Dosu;
    @TempTableColumnOrder(50)
    private Decimal zenkokuTanisuHani7Dosu;
    @TempTableColumnOrder(51)
    private Decimal zenkokuTanisuHani8Dosu;
    @TempTableColumnOrder(52)
    private Decimal zenkokuTanisuHani9Dosu;
    @TempTableColumnOrder(53)
    private Decimal zenkokuTanisuHani10Dosu;
    @TempTableColumnOrder(54)
    private RString todoufukenTanisuHani1;
    @TempTableColumnOrder(55)
    private RString todoufukenTanisuHani2;
    @TempTableColumnOrder(56)
    private RString todoufukenTanisuHani3;
    @TempTableColumnOrder(57)
    private RString todoufukenTanisuHani4;
    @TempTableColumnOrder(58)
    private RString todoufukenTanisuHani5;
    @TempTableColumnOrder(59)
    private RString todoufukenTanisuHani6;
    @TempTableColumnOrder(60)
    private RString todoufukenTanisuHani7;
    @TempTableColumnOrder(61)
    private RString todoufukenTanisuHani8;
    @TempTableColumnOrder(62)
    private RString todoufukenTanisuHani9;
    @TempTableColumnOrder(63)
    private RString todoufukenTanisuHani10;
    @TempTableColumnOrder(64)
    private Decimal todoufukenTanisuHani1Dosu;
    @TempTableColumnOrder(65)
    private Decimal todoufukenTanisuHani2Dosu;
    @TempTableColumnOrder(66)
    private Decimal todoufukenTanisuHani3Dosu;
    @TempTableColumnOrder(67)
    private Decimal todoufukenTanisuHani4Dosu;
    @TempTableColumnOrder(68)
    private Decimal todoufukenTanisuHani5Dosu;
    @TempTableColumnOrder(69)
    private Decimal todoufukenTanisuHani6Dosu;
    @TempTableColumnOrder(70)
    private Decimal todoufukenTanisuHani7Dosu;
    @TempTableColumnOrder(71)
    private Decimal todoufukenTanisuHani8Dosu;
    @TempTableColumnOrder(72)
    private Decimal todoufukenTanisuHani9Dosu;
    @TempTableColumnOrder(73)
    private Decimal todoufukenTanisuHani10Dosu;
}
