/*
 * To change this license header; choose License Headers in Project Properties.
 * To change this template file; choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.temptable;

import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 支払方法変更情報一時テーブルクラスです．
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHohoHenkoTempTableEntity extends DbTableEntityBase<ShiharaiHohoHenkoTempTableEntity> implements IDbAccessable {

    /**
     * 支払方法変更情報一時テーブル名称
     */
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = new RString("ShiharaiHohoHenkoTempTable");
    }
    //対象者情報一時テーブル
    @TempTableColumnOrder(1)
    private HihokenshaNo taisyo_hihokenshaNo;
    //被保険者台帳管理
    @TempTableColumnOrder(2)
    private RString dbT1001_insertDantaiCd;
    @TempTableColumnOrder(3)
    private RDateTime dbT1001_insertTimestamp;
    @TempTableColumnOrder(4)
    private RString dbT1001_insertReamsLoginId;
    @TempTableColumnOrder(5)
    private UUID dbT1001_insertContextId;
    @TempTableColumnOrder(6)
    private boolean dbT1001_isDeleted = false;
    @TempTableColumnOrder(7)
    private int dbT1001_updateCount = 0;
    @TempTableColumnOrder(8)
    private RDateTime dbT1001_lastUpdateTimestamp;
    @TempTableColumnOrder(9)
    private RString dbT1001_lastUpdateReamsLoginId;
    @TempTableColumnOrder(10)
    private HihokenshaNo dbT1001_hihokenshaNo;
    @TempTableColumnOrder(11)
    private FlexibleDate dbT1001_idoYMD;
    @TempTableColumnOrder(12)
    private RString dbT1001_edaNo;
    @TempTableColumnOrder(13)
    private RString dbT1001_idoJiyuCode;
    @TempTableColumnOrder(14)
    private LasdecCode dbT1001_shichosonCode;
    @TempTableColumnOrder(15)
    private ShikibetsuCode dbT1001_shikibetsuCode;
    @TempTableColumnOrder(16)
    private RString dbT1001_shikakuShutokuJiyuCode;
    @TempTableColumnOrder(17)
    private FlexibleDate dbT1001_shikakuShutokuYMD;
    @TempTableColumnOrder(18)
    private FlexibleDate dbT1001_shikakuShutokuTodokedeYMD;
    @TempTableColumnOrder(19)
    private FlexibleDate dbT1001_ichigoShikakuShutokuYMD;
    @TempTableColumnOrder(20)
    private RString dbT1001_hihokennshaKubunCode;
    @TempTableColumnOrder(21)
    private RString dbT1001_shikakuSoshitsuJiyuCode;
    @TempTableColumnOrder(22)
    private FlexibleDate dbT1001_shikakuSoshitsuYMD;
    @TempTableColumnOrder(23)
    private FlexibleDate dbT1001_shikakuSoshitsuTodokedeYMD;
    @TempTableColumnOrder(24)
    private RString dbT1001_shikakuHenkoJiyuCode;
    @TempTableColumnOrder(25)
    private FlexibleDate dbT1001_shikakuHenkoYMD;
    @TempTableColumnOrder(26)
    private FlexibleDate dbT1001_shikakuHenkoTodokedeYMD;
    @TempTableColumnOrder(27)
    private RString dbT1001_jushochitokureiTekiyoJiyuCode;
    @TempTableColumnOrder(28)
    private FlexibleDate dbT1001_jushochitokureiTekiyoYMD;
    @TempTableColumnOrder(29)
    private FlexibleDate dbT1001_jushochitokureiTekiyoTodokedeYMD;
    @TempTableColumnOrder(30)
    private RString dbT1001_jushochitokureiKaijoJiyuCode;
    @TempTableColumnOrder(31)
    private FlexibleDate dbT1001_jushochitokureiKaijoYMD;
    @TempTableColumnOrder(32)
    private FlexibleDate dbT1001_jushochitokureiKaijoTodokedeYMD;
    @TempTableColumnOrder(33)
    private RString dbT1001_jushochiTokureiFlag;
    @TempTableColumnOrder(34)
    private RString dbT1001_koikinaiJushochiTokureiFlag;
    @TempTableColumnOrder(35)
    private LasdecCode dbT1001_koikinaiTokureiSochimotoShichosonCode;
    @TempTableColumnOrder(36)
    private LasdecCode dbT1001_kyuShichosonCode;
    @TempTableColumnOrder(37)
    private boolean dbT1001_logicalDeletedFlag;
    //shikibetsuCode生保
    @TempTableColumnOrder(38)
    private RString seikatsuHogoJukyushaShikibetsuCode;
    //認定情報
    @TempTableColumnOrder(39)
    private RString dbT4001_insertDantaiCd;
    @TempTableColumnOrder(40)
    private RDateTime dbT4001_insertTimestamp;
    @TempTableColumnOrder(41)
    private RString dbT4001_insertReamsLoginId;
    @TempTableColumnOrder(42)
    private UUID dbT4001_insertContextId;
    @TempTableColumnOrder(43)
    private boolean dbT4001_isDeleted = false;
    @TempTableColumnOrder(44)
    private int dbT4001_updateCount = 0;
    @TempTableColumnOrder(45)
    private RDateTime dbT4001_lastUpdateTimestamp;
    @TempTableColumnOrder(46)
    private RString dbT4001_lastUpdateReamsLoginId;
    @TempTableColumnOrder(47)
    private LasdecCode dbT4001_shichosonCode;
    @TempTableColumnOrder(48)
    private HihokenshaNo dbT4001_hihokenshaNo;
    @TempTableColumnOrder(49)
    private RString dbT4001_rirekiNo;
    @TempTableColumnOrder(50)
    private RString dbT4001_edaban;
    @TempTableColumnOrder(51)
    private ShinseishoKanriNo dbT4001_shinseishoKanriNo;
    @TempTableColumnOrder(52)
    private RString dbT4001_shinseiJokyoKubun;
    @TempTableColumnOrder(53)
    private RString dbT4001_shishoCode;
    @TempTableColumnOrder(54)
    private boolean dbT4001_chokkinFlag;
    @TempTableColumnOrder(55)
    private ShikibetsuCode dbT4001_shikibetsuCode;
    @TempTableColumnOrder(56)
    private Code dbT4001_jukyuShinseiJiyu;
    @TempTableColumnOrder(57)
    private RString dbT4001_shinseiRiyu;
    @TempTableColumnOrder(58)
    private Code dbT4001_shinseishaKankeiCode;
    @TempTableColumnOrder(59)
    private RString dbT4001_homninKankei;
    @TempTableColumnOrder(60)
    private FlexibleDate dbT4001_jukyuShinseiYMD;
    @TempTableColumnOrder(61)
    private Code dbT4001_nigoTokuteiShippeiCode;
    @TempTableColumnOrder(62)
    private FlexibleDate dbT4001_shinsakaiIraiYMD;
    @TempTableColumnOrder(63)
    private Code dbT4001_yokaigoJotaiKubunCode;
    @TempTableColumnOrder(64)
    private FlexibleDate dbT4001_ninteiYukoKikanKaishiYMD;
    @TempTableColumnOrder(65)
    private FlexibleDate dbT4001_ninteiYukoKikanShuryoYMD;
    @TempTableColumnOrder(66)
    private FlexibleDate dbT4001_ninteiYMD;
    @TempTableColumnOrder(67)
    private Code dbT4001_minashiCode;
    @TempTableColumnOrder(68)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui01;
    @TempTableColumnOrder(69)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui02;
    @TempTableColumnOrder(70)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui03;
    @TempTableColumnOrder(71)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui04;
    @TempTableColumnOrder(72)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui05;
    @TempTableColumnOrder(73)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui06;
    @TempTableColumnOrder(74)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui07;
    @TempTableColumnOrder(75)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui08;
    @TempTableColumnOrder(76)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui09;
    @TempTableColumnOrder(77)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui10;
    @TempTableColumnOrder(78)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui11;
    @TempTableColumnOrder(79)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui12;
    @TempTableColumnOrder(80)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui13;
    @TempTableColumnOrder(81)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui14;
    @TempTableColumnOrder(82)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui15;
    @TempTableColumnOrder(83)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui16;
    @TempTableColumnOrder(84)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui17;
    @TempTableColumnOrder(85)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui18;
    @TempTableColumnOrder(86)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui19;
    @TempTableColumnOrder(87)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui20;
    @TempTableColumnOrder(88)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui21;
    @TempTableColumnOrder(89)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui22;
    @TempTableColumnOrder(90)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui23;
    @TempTableColumnOrder(91)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui24;
    @TempTableColumnOrder(92)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui25;
    @TempTableColumnOrder(93)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui26;
    @TempTableColumnOrder(94)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui27;
    @TempTableColumnOrder(95)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui28;
    @TempTableColumnOrder(96)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui29;
    @TempTableColumnOrder(97)
    private ServiceShuruiCode dbT4001_shiteiServiceShurui30;
    @TempTableColumnOrder(98)
    private FlexibleDate dbT4001_soshitsuYMD;
    @TempTableColumnOrder(99)
    private FlexibleDate dbT4001_chokkinIdoYMD;
    @TempTableColumnOrder(100)
    private Code dbT4001_chokkinIdoJiyuCode;
    @TempTableColumnOrder(101)
    private Code dbT4001_yukoMukoKubun;
    @TempTableColumnOrder(102)
    private Code dbT4001_dataKubun;
    @TempTableColumnOrder(103)
    private RString dbT4001_remban;
    @TempTableColumnOrder(104)
    private RString dbT4001_idoRiyu;
    @TempTableColumnOrder(105)
    private Code dbT4001_shinseishoKubun;
    @TempTableColumnOrder(106)
    private Code dbT4001_sakujoJiyuCode;
    @TempTableColumnOrder(107)
    private boolean dbT4001_yoshienshaNinteiShinseiFlag;
    @TempTableColumnOrder(108)
    private Decimal dbT4001_shikyuGendoTanisu;
    @TempTableColumnOrder(109)
    private FlexibleDate dbT4001_shikyuGendoKaishiYMD;
    @TempTableColumnOrder(110)
    private FlexibleDate dbT4001_shikyuGendoShuryoYMD;
    @TempTableColumnOrder(111)
    private int dbT4001_tankiSikyuGendoNissu;
    @TempTableColumnOrder(112)
    private FlexibleDate dbT4001_tankiShikyuGendoKaishiYMD;
    @TempTableColumnOrder(113)
    private FlexibleDate dbT4001_tankiShikyuGendoShuryoYMD;
    @TempTableColumnOrder(114)
    private FlexibleDate dbT4001_toshoNinteiYukoKaishiYMD;
    @TempTableColumnOrder(115)
    private FlexibleDate dbT4001_toshoNinteiYukoShuryoYMD;
    @TempTableColumnOrder(116)
    private FlexibleDate dbT4001_jukyuShikakuShomeishoHakkoYMD1;
    @TempTableColumnOrder(117)
    private FlexibleDate dbT4001_jukyuShikakuShomeishoHakkoYMD2;
    @TempTableColumnOrder(118)
    private FlexibleDate dbT4001_shindanMeireishoHakkoYMD;
    @TempTableColumnOrder(119)
    private FlexibleDate dbT4001_nigoShinseiJuriTsuchishoHakkoYMD;
    @TempTableColumnOrder(120)
    private FlexibleDate dbT4001_kubunHenkoTsuchishoHakkoYMD;
    @TempTableColumnOrder(121)
    private FlexibleDate dbT4001_serviceHenkoTsuchishoHakkoYMD;
    @TempTableColumnOrder(122)
    private FlexibleDate dbT4001_ninteiKyakkaTsuchishoHakkoYMD;
    @TempTableColumnOrder(123)
    private FlexibleDate dbT4001_ninteiTorikeshiTsuchishoHakkoYMD;
    @TempTableColumnOrder(124)
    private boolean dbT4001_shikakuShutokuMaeShinseiFlag;
    @TempTableColumnOrder(125)
    private boolean dbT4001_kyuSochishaFlag;
    @TempTableColumnOrder(126)
    private boolean dbT4001_logicalDeletedFlag;
    //賦課Newest.*;
    @TempTableColumnOrder(127)
    private RString dbT2002_insertDantaiCd;
    @TempTableColumnOrder(128)
    private RDateTime dbT2002_insertTimestamp;
    @TempTableColumnOrder(129)
    private RString dbT2002_insertReamsLoginId;
    @TempTableColumnOrder(130)
    private UUID dbT2002_insertContextId;
    @TempTableColumnOrder(131)
    private boolean dbT2002_isDeleted = false;
    @TempTableColumnOrder(132)
    private int dbT2002_updateCount = 0;
    @TempTableColumnOrder(133)
    private RDateTime dbT2002_lastUpdateTimestamp;
    @TempTableColumnOrder(134)
    private RString dbT2002_lastUpdateReamsLoginId;
    @TempTableColumnOrder(135)
    private FlexibleYear dbT2002_choteiNendo;
    @TempTableColumnOrder(136)
    private FlexibleYear dbT2002_fukaNendo;
    @TempTableColumnOrder(137)
    private TsuchishoNo dbT2002_tsuchishoNo;
    @TempTableColumnOrder(138)
    private int dbT2002_rirekiNo;
    @TempTableColumnOrder(139)
    private HihokenshaNo dbT2002_hihokenshaNo;
    @TempTableColumnOrder(140)
    private ShikibetsuCode dbT2002_shikibetsuCode;
    @TempTableColumnOrder(141)
    private SetaiCode dbT2002_setaiCode;
    @TempTableColumnOrder(142)
    private int dbT2002_setaiInsu;
    @TempTableColumnOrder(143)
    private FlexibleDate dbT2002_shikakuShutokuYMD;
    @TempTableColumnOrder(144)
    private RString dbT2002_shikakuShutokuJiyu;
    @TempTableColumnOrder(145)
    private FlexibleDate dbT2002_shikakuSoshitsuYMD;
    @TempTableColumnOrder(146)
    private RString dbT2002_shikakuSoshitsuJiyu;
    @TempTableColumnOrder(147)
    private RString dbT2002_seihofujoShurui;
    @TempTableColumnOrder(148)
    private FlexibleDate dbT2002_seihoKaishiYMD;
    @TempTableColumnOrder(149)
    private FlexibleDate dbT2002_seihoHaishiYMD;
    @TempTableColumnOrder(150)
    private FlexibleDate dbT2002_ronenKaishiYMD;
    @TempTableColumnOrder(151)
    private FlexibleDate dbT2002_ronenHaishiYMD;
    @TempTableColumnOrder(152)
    private FlexibleDate dbT2002_fukaYMD;
    @TempTableColumnOrder(153)
    private RString dbT2002_kazeiKubun;
    @TempTableColumnOrder(154)
    private RString dbT2002_setaikazeiKubun;
    @TempTableColumnOrder(155)
    private Decimal dbT2002_gokeiShotokuGaku;
    @TempTableColumnOrder(156)
    private Decimal dbT2002_nenkinShunyuGaku;
    @TempTableColumnOrder(157)
    private RString dbT2002_hokenryoDankai;
    @TempTableColumnOrder(158)
    private RString dbT2002_hokenryoDankai1;
    @TempTableColumnOrder(159)
    private Decimal dbT2002_nengakuHokenryo1;
    @TempTableColumnOrder(160)
    private FlexibleYearMonth dbT2002_tsukiwariStartYM1;
    @TempTableColumnOrder(161)
    private FlexibleYearMonth dbT2002_tsukiwariEndYM1;
    @TempTableColumnOrder(162)
    private RString dbT2002_hokenryoDankai2;
    @TempTableColumnOrder(163)
    private Decimal dbT2002_nengakuHokenryo2;
    @TempTableColumnOrder(164)
    private FlexibleYearMonth dbT2002_tsukiwariStartYM2;
    @TempTableColumnOrder(165)
    private FlexibleYearMonth dbT2002_tsukiwariEndYM2;
    @TempTableColumnOrder(166)
    private YMDHMS dbT2002_choteiNichiji;
    @TempTableColumnOrder(167)
    private RString dbT2002_choteiJiyu1;
    @TempTableColumnOrder(168)
    private RString dbT2002_choteiJiyu2;
    @TempTableColumnOrder(169)
    private RString dbT2002_choteiJiyu3;
    @TempTableColumnOrder(170)
    private RString dbT2002_choteiJiyu4;
    @TempTableColumnOrder(171)
    private RString dbT2002_koseiM;
    @TempTableColumnOrder(172)
    private Decimal dbT2002_gemmenMaeHokenryo;
    @TempTableColumnOrder(173)
    private Decimal dbT2002_gemmenGaku;
    @TempTableColumnOrder(174)
    private Decimal dbT2002_kakuteiHokenryo;
    @TempTableColumnOrder(175)
    private RString dbT2002_hokenryoDankaiKarisanntei;
    @TempTableColumnOrder(176)
    private int dbT2002_choshuHohoRirekiNo;
    @TempTableColumnOrder(177)
    private YMDHMS dbT2002_idoKijunNichiji;
    @TempTableColumnOrder(178)
    private RString dbT2002_kozaKubun;
    @TempTableColumnOrder(179)
    private RString dbT2002_kyokaisoKubun;
    @TempTableColumnOrder(180)
    private RString dbT2002_shokkenKubun;
    @TempTableColumnOrder(181)
    private LasdecCode dbT2002_fukaShichosonCode;
    @TempTableColumnOrder(182)
    private Decimal dbT2002_tkSaishutsuKampuGaku;
    @TempTableColumnOrder(183)
    private Decimal dbT2002_fuSaishutsuKampuGaku;
    //介護期別.*;
    @TempTableColumnOrder(184)
    private RString dbT2003_insertDantaiCd;
    @TempTableColumnOrder(185)
    private RDateTime dbT2003_insertTimestamp;
    @TempTableColumnOrder(186)
    private RString dbT2003_insertReamsLoginId;
    @TempTableColumnOrder(187)
    private UUID dbT2003_insertContextId;
    @TempTableColumnOrder(188)
    private boolean dbT2003_isDeleted = false;
    @TempTableColumnOrder(189)
    private int dbT2003_updateCount = 0;
    @TempTableColumnOrder(190)
    private RDateTime dbT2003_lastUpdateTimestamp;
    @TempTableColumnOrder(191)
    private RString dbT2003_lastUpdateReamsLoginId;
    @TempTableColumnOrder(192)
    private FlexibleYear dbT2003_choteiNendo;
    @TempTableColumnOrder(193)
    private FlexibleYear dbT2003_fukaNendo;
    @TempTableColumnOrder(194)
    private TsuchishoNo dbT2003_tsuchishoNo;
    @TempTableColumnOrder(195)
    private int dbT2003_rirekiNo;
    @TempTableColumnOrder(196)
    private RString dbT2003_choshuHouhou;
    @TempTableColumnOrder(197)
    private int dbT2003_ki;
    @TempTableColumnOrder(198)
    private Decimal dbT2003_choteiId;
    //調定共通_護継承.*;
    @TempTableColumnOrder(199)
    private RString urT0705_insertDantaiCd;
    @TempTableColumnOrder(200)
    private RDateTime urT0705_insertTimestamp;
    @TempTableColumnOrder(201)
    private RString urT0705_insertReamsLoginId;
    @TempTableColumnOrder(202)
    private UUID urT0705_insertContextId;
    @TempTableColumnOrder(203)
    private boolean urT0705_isDeleted = false;
    @TempTableColumnOrder(204)
    private int urT0705_updateCount = 0;
    @TempTableColumnOrder(205)
    private RDateTime urT0705_lastUpdateTimestamp;
    @TempTableColumnOrder(206)
    private RString urT0705_lastUpdateReamsLoginId;
    @TempTableColumnOrder(207)
    private Long urT0705_choteiId;
    @TempTableColumnOrder(208)
    private Long urT0705_shunoId;
    @TempTableColumnOrder(209)
    private RYear urT0705_kaikeiNendo;
    @TempTableColumnOrder(210)
    private RYear urT0705_shoriNendo;
    @TempTableColumnOrder(211)
    private int urT0705_shoriNo;
    @TempTableColumnOrder(212)
    private int urT0705_koseiKaisu;
    @TempTableColumnOrder(213)
    private RString urT0705_choteiJiyuCode;
    @TempTableColumnOrder(214)
    private RDate urT0705_choteiYMD;
    @TempTableColumnOrder(215)
    private Decimal urT0705_choteigaku;
    @TempTableColumnOrder(216)
    private Decimal urT0705_shohizei;
    @TempTableColumnOrder(217)
    private RDate urT0705_nokigenYMD;
    @TempTableColumnOrder(218)
    private RDate urT0705_hoteiNokigenToYMD;
    @TempTableColumnOrder(219)
    private boolean urT0705_fukaShoriJokyo;
    //時効起算日管理.*
    @TempTableColumnOrder(220)
    private RString dbT4023_insertDantaiCd;
    @TempTableColumnOrder(221)
    private RDateTime dbT4023_insertTimestamp;
    @TempTableColumnOrder(222)
    private RString dbT4023_insertReamsLoginId;
    @TempTableColumnOrder(223)
    private UUID dbT4023_insertContextId;
    @TempTableColumnOrder(224)
    private boolean dbT4023_isDeleted = false;
    @TempTableColumnOrder(225)
    private int dbT4023_updateCount = 0;
    @TempTableColumnOrder(226)
    private RDateTime dbT4023_lastUpdateTimestamp;
    @TempTableColumnOrder(227)
    private RString dbT4023_lastUpdateReamsLoginId;
    @TempTableColumnOrder(228)
    private ShoKisaiHokenshaNo dbT4023_shoKisaiHokenshaNo;
    @TempTableColumnOrder(229)
    private HihokenshaNo dbT4023_hihokenshaNo;
    @TempTableColumnOrder(230)
    private RYear dbT4023_choteiNendo;
    @TempTableColumnOrder(231)
    private RYear dbT4023_fukaNendo;
    @TempTableColumnOrder(232)
    private RString dbT4023_tokucho_FuchoKubun;
    @TempTableColumnOrder(233)
    private TsuchishoNo dbT4023_tsuchishoNo;
    @TempTableColumnOrder(234)
    private RString dbT4023_shuno_Ki_Tsuki;
    @TempTableColumnOrder(235)
    private int dbT4023_rirekiNo;
    @TempTableColumnOrder(236)
    private FlexibleDate dbT4023_jikoKisanYMD;
    @TempTableColumnOrder(237)
    private RString dbT4023_jikoKisanYMDKubun;
    @TempTableColumnOrder(238)
    private boolean dbT4023_logicalDeletedFlag;
    //CaT1018_督促状発行履歴.*
    @TempTableColumnOrder(239)
    private RString shunoId;
    @TempTableColumnOrder(240)
    private FlexibleDate tokusokujoHakkoYMD;
    //収入.*;
    @TempTableColumnOrder(241)
    private RString caTshunyuId;
    @TempTableColumnOrder(242)
    private RString caTshunoId;
    @TempTableColumnOrder(243)
    private Decimal caTshunyugaku;
    @TempTableColumnOrder(244)
    private FlexibleDate caTshunyuYMD;
    //宛名.*,
    @TempTableColumnOrder(245)
    private ShikibetsuCode uaFt200_shikibetsuCode;
    @TempTableColumnOrder(246)
    private AtenaKanaMeisho uaFt200_kanaMeisho;
    @TempTableColumnOrder(247)
    private AtenaMeisho uaFt200_meisho;
    @TempTableColumnOrder(248)
    private YubinNo uaFt200_yubinNo;
    @TempTableColumnOrder(249)
    private GyoseikuCode uaFt200_gyoseikuCode;
    @TempTableColumnOrder(250)
    private RString uaFt200_gyoseikuName;
    @TempTableColumnOrder(251)
    private RString uaFt200_idoJiyuCode;
    @TempTableColumnOrder(252)
    private AtenaJusho uaFt200_jusho;
    @TempTableColumnOrder(253)
    private SetaiCode uaFt200_setaiCode;
    //申請中
    @TempTableColumnOrder(254)
    private RString reqProcess;
}
