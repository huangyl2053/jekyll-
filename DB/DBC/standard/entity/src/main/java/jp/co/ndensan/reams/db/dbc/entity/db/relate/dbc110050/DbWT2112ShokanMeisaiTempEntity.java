/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 償還明細一時ファイルTBLのEntityです。
 *
 * @reamsid_L DBC-2570-030 wangxue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT2112ShokanMeisaiTempEntity extends DbTableEntityBase<DbWT2112ShokanMeisaiTempEntity>
        implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    @TempTableColumnOrder(2)
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    @TempTableColumnOrder(3)
    private RString seiriNo;
    @PrimaryKey
    @TempTableColumnOrder(4)
    private RString dataKubun;
    @PrimaryKey
    @TempTableColumnOrder(5)
    private JigyoshaNo jigyoshaNo;
    @PrimaryKey
    @TempTableColumnOrder(6)
    private RString yoshikiNo;
    @PrimaryKey
    @TempTableColumnOrder(7)
    private RString meisaiNo;
    @PrimaryKey
    @TempTableColumnOrder(8)
    private RString renban;

    @TempTableColumnOrder(9)
    private int dbwt2111_renban;
    @TempTableColumnOrder(10)
    private HihokenshaNo dbwt2111_hiHokenshaNo;
    @TempTableColumnOrder(11)
    private FlexibleYearMonth dbwt2111_serviceTeikyoYM;
    @TempTableColumnOrder(12)
    private RString dbwt2111_seiriNo;
    @TempTableColumnOrder(13)
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @TempTableColumnOrder(14)
    private FlexibleDate uketsukeYMD;
    @TempTableColumnOrder(15)
    private FlexibleDate shinseiYMD;
    @TempTableColumnOrder(16)
    private RString shinseiRiyu;
    @TempTableColumnOrder(17)
    private RString shinseishaKubun;
    @TempTableColumnOrder(18)
    private RString shinseishaNameKanji;
    @TempTableColumnOrder(19)
    private RString shinseishaNameKana;
    @TempTableColumnOrder(20)
    private YubinNo shinseishaYubinNo;
    @TempTableColumnOrder(21)
    private RString shinseishaAddress;
    @TempTableColumnOrder(22)
    private TelNo shinseishaTelNo;
    @TempTableColumnOrder(23)
    private JigyoshaNo shinseiJigyoshaNo;
    @TempTableColumnOrder(24)
    private FlexibleDate riyushoSakuseiYMD;
    @TempTableColumnOrder(15)
    private RString riyushoSakuseishaName;
    @TempTableColumnOrder(26)
    private RString riyushoSakuseishaKanaName;
    @TempTableColumnOrder(27)
    private JigyoshaNo riyushoSakuseiJigyoshaNo;
    @TempTableColumnOrder(28)
    private Decimal shiharaiKingakuTotal;
    @TempTableColumnOrder(29)
    private Decimal hokenTaishoHiyogaku;
    @TempTableColumnOrder(30)
    private Decimal hokenKyufugaku;
    @TempTableColumnOrder(31)
    private Decimal dbwt2111_riyoshaFutangaku;
    @TempTableColumnOrder(32)
    private RString shikyuShinseiShinsaKubun;
    @TempTableColumnOrder(33)
    private RString shinsaHohoKubun;
    @TempTableColumnOrder(34)
    private RString sofuKubun;
    @TempTableColumnOrder(35)
    private FlexibleYearMonth sofuYM;
    @TempTableColumnOrder(36)
    private boolean kokuhorenSaisofuFlag;
    @TempTableColumnOrder(37)
    private RString shiharaiHohoKubunCode;
    @TempTableColumnOrder(38)
    private RString shiharaiBasho;
    @TempTableColumnOrder(39)
    private FlexibleDate shiharaiKaishiYMD;
    @TempTableColumnOrder(40)
    private FlexibleDate shiharaiShuryoYMD;
    @TempTableColumnOrder(41)
    private RString shiharaiKaishiTime;
    @TempTableColumnOrder(42)
    private RString shiharaiShuryoTime;
    @TempTableColumnOrder(43)
    private long kozaID;
    @TempTableColumnOrder(44)
    private RString juryoininKeiyakuNo;
    @TempTableColumnOrder(45)
    private RString jutakuShoyusha;
    @TempTableColumnOrder(46)
    private RString hihokenshaKankei;
    @TempTableColumnOrder(47)
    private boolean yokaigo3DankaiHenko;
    @TempTableColumnOrder(48)
    private boolean jutakuJushoHenko;
    @TempTableColumnOrder(49)
    private FlexibleDate shinsaYMD;
    @TempTableColumnOrder(50)
    private RString shinsaKekka;
    @TempTableColumnOrder(51)
    private FlexibleYearMonth dbwt2111_jizenServiceTeikyoYM;
    @TempTableColumnOrder(52)
    private RString dbwt2111_jizenSeiriNo;
    @TempTableColumnOrder(53)
    private RString kaishuShinseiKubun;
    @TempTableColumnOrder(54)
    private RString kaishuShinseiTorikeshijiyuCode;
    @TempTableColumnOrder(55)
    private FlexibleDate ryoshuYMD;
    @TempTableColumnOrder(56)
    private boolean sofuJogaiFlag;
    @TempTableColumnOrder(57)
    private HokenshaNo hokenshaNo;
    @TempTableColumnOrder(58)
    private RString hokenshaName;
    @TempTableColumnOrder(59)
    private boolean jukyushaDaichoFlag;
    @TempTableColumnOrder(60)
    private boolean kyuSochishaFlag;
    @TempTableColumnOrder(61)
    private RString yokaigoJotaiKubunCode;
    @TempTableColumnOrder(62)
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    @TempTableColumnOrder(63)
    private FlexibleDate ninteiYukoKikanShuryoYMD;

    @TempTableColumnOrder(64)
    private int exRenban;
    @TempTableColumnOrder(65)
    private HokenshaNo exHokenshaNo;
    @TempTableColumnOrder(66)
    private RString exHokenshaName;
    @TempTableColumnOrder(67)
    private ShoKisaiHokenshaNo exShoHokenshaNo;
    @TempTableColumnOrder(68)
    private HihokenshaNo exHihokenshaNo;
    @TempTableColumnOrder(69)
    private FlexibleYearMonth exServiceTeikyoYm;
    @TempTableColumnOrder(70)
    private boolean henkanFlag;
    @TempTableColumnOrder(71)
    private LasdecCode oldShichosonCode;
    @TempTableColumnOrder(72)
    private HihokenshaNo sofuHihokenshaNo;
    @TempTableColumnOrder(73)
    private LasdecCode shichosonCode;
    @TempTableColumnOrder(74)
    private RString kannaiKangaiKubun;
    @TempTableColumnOrder(75)
    private RString yubinNo;
    @TempTableColumnOrder(76)
    private RString choikiCode;
    @TempTableColumnOrder(77)
    private RString gyoseikuCode;
    @TempTableColumnOrder(78)
    private RString gyoseikuMei;
    @TempTableColumnOrder(79)
    private RString jusho;
    @TempTableColumnOrder(80)
    private RString banchi;
    @TempTableColumnOrder(81)
    private RString katagaki;
    @TempTableColumnOrder(82)
    private RString kanaMeisho;
    @TempTableColumnOrder(83)
    private RString meisho;
    @TempTableColumnOrder(84)
    private RString shimei50onKana;
    @TempTableColumnOrder(85)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(86)
    private FlexibleDate shikakuShutokuYmd;
    @TempTableColumnOrder(87)
    private RString shikakuShutokuJiyuCode;
    @TempTableColumnOrder(88)
    private FlexibleDate shikakuSoshitsuYmd;
    @TempTableColumnOrder(89)
    private RString shikakuSoshitsuJiyuCode;
    @TempTableColumnOrder(90)
    private RString setaiShuyakuNo;
    @TempTableColumnOrder(91)
    private FlexibleDate seinenYmd;
    @TempTableColumnOrder(92)
    private RString seibetsuCode;
    @TempTableColumnOrder(93)
    private FlexibleDate shichosonKanyuYmd;
    @TempTableColumnOrder(94)
    private FlexibleDate shichosonDattaiYmd;

    @TempTableColumnOrder(95)
    private RString kyuSochiNyushoshaTokureiCode;
    @TempTableColumnOrder(96)
    private RString kyotakuServiceSakuseiKubunCode;
    @TempTableColumnOrder(97)
    private JigyoshaNo kyotakuserviceJigyoshaNo;
    @TempTableColumnOrder(98)
    private FlexibleDate kaishiYMD;
    @TempTableColumnOrder(99)
    private FlexibleDate chushiYMD;
    @TempTableColumnOrder(100)
    private RString chushiRiyuNyushomaeJyokyoCode;
    @TempTableColumnOrder(101)
    private FlexibleDate nyushoYMD;
    @TempTableColumnOrder(102)
    private FlexibleDate taishoYMD;
    @TempTableColumnOrder(103)
    private int nyushoJitsuNissu;
    @TempTableColumnOrder(104)
    private int gaihakuNissu;
    @TempTableColumnOrder(105)
    private RString taishogoJotaiCode;
    @TempTableColumnOrder(106)
    private HokenKyufuRitsu hokenKyufuritsu;
    @TempTableColumnOrder(107)
    private int serviceTanisu;
    @TempTableColumnOrder(108)
    private Decimal hokenSeikyugaku;
    @TempTableColumnOrder(109)
    private int riyoshaFutangaku;
    @TempTableColumnOrder(110)
    private Decimal kinkyuShisetsuRyoyoSeikyugaku;
    @TempTableColumnOrder(111)
    private Decimal tokuteiShinryoSeikyugaku;
    @TempTableColumnOrder(112)
    private int tokuteiNyushoshaKaigoServiceSeikyugaku;

    @TempTableColumnOrder(113)
    private ServiceShuruiCode serviceShuruiCode;
    @TempTableColumnOrder(114)
    private ServiceKomokuCode serviceKomokuCode;
    @TempTableColumnOrder(115)
    private int tanisu;
    @TempTableColumnOrder(116)
    private int nissuKaisu;
    @TempTableColumnOrder(117)
    private RString tekiyo;

    @TempTableColumnOrder(118)
    private ShoKisaiHokenshaNo shisetsuShozaiHokenshaNo;

    @TempTableColumnOrder(119)
    private RString kinkyuShobyoName1;
    @TempTableColumnOrder(120)
    private RString kinkyuShobyoName2;
    @TempTableColumnOrder(121)
    private RString kinkyuShobyoName3;
    @TempTableColumnOrder(122)
    private FlexibleDate kinkyuChiryoKaishiYMD1;
    @TempTableColumnOrder(123)
    private FlexibleDate kinkyuChiryoKaishiYMD2;
    @TempTableColumnOrder(124)
    private FlexibleDate kinkyuChiryoKaishiYMD3;
    @TempTableColumnOrder(125)
    private int oshinNissu;
    @TempTableColumnOrder(126)
    private RString oshinIryoKikanName;
    @TempTableColumnOrder(127)
    private int tsuinNissu;
    @TempTableColumnOrder(128)
    private RString tsuinKikanName;
    @TempTableColumnOrder(129)
    private int kinkyuChiryoKanriTanisu;
    @TempTableColumnOrder(130)
    private int kinkyuChiryoKanriNissu;
    @TempTableColumnOrder(131)
    private int kinkyuChiryoKanriSubTotal;
    @TempTableColumnOrder(132)
    private int rehabilitationTanisu;
    @TempTableColumnOrder(133)
    private int shochiTanisu;
    @TempTableColumnOrder(134)
    private int shujutsuTanisu;
    @TempTableColumnOrder(135)
    private int masuiTanisu;
    @TempTableColumnOrder(136)
    private int hoshasenChiryoTanisu;
    @TempTableColumnOrder(137)
    private RString tekiyo1;
    @TempTableColumnOrder(138)
    private RString tekiyo2;
    @TempTableColumnOrder(139)
    private RString tekiyo3;
    @TempTableColumnOrder(140)
    private RString tekiyo4;
    @TempTableColumnOrder(141)
    private RString tekiyo5;
    @TempTableColumnOrder(142)
    private RString tekiyo6;
    @TempTableColumnOrder(143)
    private RString tekiyo7;
    @TempTableColumnOrder(144)
    private RString tekiyo8;
    @TempTableColumnOrder(145)
    private RString tekiyo9;
    @TempTableColumnOrder(146)
    private RString tekiyo10;
    @TempTableColumnOrder(147)
    private RString tekiyo11;
    @TempTableColumnOrder(148)
    private RString tekiyo12;
    @TempTableColumnOrder(149)
    private RString tekiyo13;
    @TempTableColumnOrder(150)
    private RString tekiyo14;
    @TempTableColumnOrder(151)
    private RString tekiyo15;
    @TempTableColumnOrder(152)
    private RString tekiyo16;
    @TempTableColumnOrder(153)
    private RString tekiyo17;
    @TempTableColumnOrder(154)
    private RString tekiyo18;
    @TempTableColumnOrder(155)
    private RString tekiyo19;
    @TempTableColumnOrder(156)
    private RString tekiyo20;
    @TempTableColumnOrder(157)
    private int kinkyuShisetsuRyoyohiTotalTanisu;

    @TempTableColumnOrder(158)
    private RString shoteiShikkanShobyoName1;
    @TempTableColumnOrder(159)
    private RString shoteiShikkanShobyoName2;
    @TempTableColumnOrder(160)
    private RString shoteiShikkanShobyoName3;
    @TempTableColumnOrder(161)
    private FlexibleDate shoteiShikkanShobyoKaishiYMD1;
    @TempTableColumnOrder(162)
    private FlexibleDate shoteiShikkanShobyoKaishiYMD2;
    @TempTableColumnOrder(163)
    private FlexibleDate shoteiShikkanShobyoKaishiYMD3;
    @TempTableColumnOrder(164)
    private int shoteiShikkanTanisu;
    @TempTableColumnOrder(165)
    private int shoteiShikkanNissu;
    @TempTableColumnOrder(166)
    private int shoteiShikkanSubTotal;

    @TempTableColumnOrder(167)
    private RString shobyoName;
    @TempTableColumnOrder(168)
    private int shidoKanriryoTanisu;
    @TempTableColumnOrder(169)
    private int tanjunXsenTanisu;
    @TempTableColumnOrder(170)
    private int seishinkaSemmonRyoyohouTanisu;
    @TempTableColumnOrder(171)
    private int sochiTanisu;
    @TempTableColumnOrder(172)
    private int totalTanisu;

    @TempTableColumnOrder(173)
    private int kihonTeikyoNissu;
    @TempTableColumnOrder(174)
    private int kihonTeikyoTanka;
    @TempTableColumnOrder(175)
    private int kihonTeikyoKingaku;
    @TempTableColumnOrder(176)
    private int tokubetsuTeikyoNissu;
    @TempTableColumnOrder(177)
    private int tokubetsuTeikyoTanka;
    @TempTableColumnOrder(178)
    private int tokubetsuTeikyoKingaku;
    @TempTableColumnOrder(179)
    private int shokujiTeikyoTotalNissu;
    @TempTableColumnOrder(180)
    private int shokujiTeikyohiTotal;
    @TempTableColumnOrder(181)
    private int getsugakuHyojunFutangaku;
    @TempTableColumnOrder(182)
    private int shokujiTeikyohiSeikyugaku;
    @TempTableColumnOrder(183)
    private int nichigakuHyojunFutangaku;
    @TempTableColumnOrder(184)
    private RString shikyuKubunCode;
    @TempTableColumnOrder(185)
    private int tensuKingaku;
    @TempTableColumnOrder(186)
    private int shikyuKingaku;
    @TempTableColumnOrder(187)
    private int zougenTen;
    @TempTableColumnOrder(188)
    private int sagakuKingaku;

    @TempTableColumnOrder(189)
    private RString shiteiKijunGaitoJigyoshaKubunCode;
    @TempTableColumnOrder(190)
    private FlexibleDate kyotakuServiceSakuseiIraiYMD;
    @TempTableColumnOrder(191)
    private ServiceCode serviceCode;
    @TempTableColumnOrder(192)
    private Decimal tanisuTanka;
    @TempTableColumnOrder(193)
    private int seikyuKingaku;
    @TempTableColumnOrder(194)
    private RString shinsaHohoKubunCode;
    @TempTableColumnOrder(195)
    private FlexibleYearMonth shinsaYM;
    @TempTableColumnOrder(196)
    private RString zougenRiyu;
    @TempTableColumnOrder(197)
    private RString fushikyuRiyu;
    @TempTableColumnOrder(198)
    private RString kounyuKaishuRireki;

    @TempTableColumnOrder(199)
    private RString tantokangoshienSemmoninNo;

    @TempTableColumnOrder(200)
    private FlexibleDate fukushiYoguHanbaiYMD;
    @TempTableColumnOrder(201)
    private RString fukushiYoguShohinName;
    @TempTableColumnOrder(202)
    private RString fukushiYoguShumokuCode;
    @TempTableColumnOrder(203)
    private RString fukushiYoguSeizoJigyoshaName;
    @TempTableColumnOrder(204)
    private RString fukushiYoguHanbaiJigyoshaName;
    @TempTableColumnOrder(205)
    private int kounyuKingaku;
    @TempTableColumnOrder(206)
    private RString hinmokuCode;

    @TempTableColumnOrder(207)
    private FlexibleDate jutakuKaishuChakkoYMD;
    @TempTableColumnOrder(208)
    private RString jutakuKaishuNaiyo;
    @TempTableColumnOrder(209)
    private RString jutakuKaishuJigyoshaName;
    @TempTableColumnOrder(210)
    private RString jutakuKaishuJutakuAddress;
    @TempTableColumnOrder(211)
    private int kaishuKingaku;
    @TempTableColumnOrder(212)
    private FlexibleDate jutakuKaishuKanseiYMD;
    @TempTableColumnOrder(213)
    private FlexibleYearMonth jizenServiceTeikyoYM;
    @TempTableColumnOrder(214)
    private RString jizenSeiriNo;

    @TempTableColumnOrder(215)
    private int serviceJitsunissu;
    @TempTableColumnOrder(216)
    private int planTanisu;
    @TempTableColumnOrder(217)
    private int gendogakuKanriTaishoTanisu;
    @TempTableColumnOrder(218)
    private int gendogakuKanriTaishogaiTanisu;
    @TempTableColumnOrder(219)
    private int tankiNyushoPlanNissu;
    @TempTableColumnOrder(220)
    private int tankiNyushoJitsunissu;
    @TempTableColumnOrder(221)
    private int tanisuTotal;
    @TempTableColumnOrder(222)
    private Decimal seikyugaku;
    @TempTableColumnOrder(223)
    private int dekidakaIryohiTanisuTotal;
    @TempTableColumnOrder(224)
    private Decimal dekidakaIryohiSeikyugaku;
    @TempTableColumnOrder(225)
    private Decimal dekidakaIryohiRiyoshaFutangaku;
    @TempTableColumnOrder(226)
    private int zougenten;
    @TempTableColumnOrder(227)
    private int seikyugakuSagakuKingaku;
    @TempTableColumnOrder(228)
    private int dekidakaSeikyugakuSagaku;
    @TempTableColumnOrder(229)
    private RString hushikyuRiyu;

    @TempTableColumnOrder(230)
    private int hiyoTanka;
    @TempTableColumnOrder(231)
    private int futanGendogaku;
    @TempTableColumnOrder(232)
    private int nissu;
    @TempTableColumnOrder(233)
    private int hiyogaku;
    @TempTableColumnOrder(234)
    private int hokenbunSeikyugaku;
    @TempTableColumnOrder(235)
    private int hiyogakuTotal;
    @TempTableColumnOrder(236)
    private int hokenbunSeikyugakuTotal;
    @TempTableColumnOrder(237)
    private int riyoshaFutangakuTotal;

    @TempTableColumnOrder(238)
    private Decimal keigenritsu;
    @TempTableColumnOrder(239)
    private int keigengaku;
    @TempTableColumnOrder(240)
    private int keigengoRiyoshaFutangaku;
    @TempTableColumnOrder(241)
    private RString biko;

    @TempTableColumnOrder(242)
    private RString shikibetsuNo;
    @TempTableColumnOrder(243)
    private int kaisu;
    @TempTableColumnOrder(244)
    private int serviceTanisuTotal;
}
