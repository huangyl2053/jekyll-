/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager;

import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.TorokuNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.BanchiCode;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.ChugakkokuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.MailAddress;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShogakkokuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.biz.TsuzukigaraCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 特徴仮算定計算後賦課情報Entity
 *
 * @reamsid_L DBB-0700-030 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoKariKeisangoFukaTempEntity implements IDbAccessable {

    @TempTableColumnOrder(1)
    @PrimaryKey
    private FlexibleYear choteiNendo;
    @TempTableColumnOrder(2)
    @PrimaryKey
    private FlexibleYear fukaNendo;
    @TempTableColumnOrder(3)
    @PrimaryKey
    private TsuchishoNo tsuchishoNo;
    @TempTableColumnOrder(4)
    @PrimaryKey
    private RString koseiZengoKubun;
    @TempTableColumnOrder(5)
    @PrimaryKey
    private RString sakuseiShoriName;
    @TempTableColumnOrder(6)
    private int fukaRirekiNo;
    @TempTableColumnOrder(7)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(8)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(9)
    private SetaiCode setaiCode;
    @TempTableColumnOrder(10)
    private int setaiInsu;
    @TempTableColumnOrder(11)
    private FlexibleDate shikakuShutokuYMD;
    @TempTableColumnOrder(12)
    private RString shikakuShutokuJiyu;
    @TempTableColumnOrder(13)
    private FlexibleDate shikakuSoshitsuYMD;
    @TempTableColumnOrder(14)
    private RString shikakuSoshitsuJiyu;
    @TempTableColumnOrder(15)
    private RString seihofujoShurui;
    @TempTableColumnOrder(16)
    private FlexibleDate seihoKaishiYMD;
    @TempTableColumnOrder(17)
    private FlexibleDate seihoHaishiYMD;
    @TempTableColumnOrder(18)
    private FlexibleDate ronenKaishiYMD;
    @TempTableColumnOrder(19)
    private FlexibleDate ronenHaishiYMD;
    @TempTableColumnOrder(20)
    private FlexibleDate fukaYMD;
    @TempTableColumnOrder(21)
    private RString kazeiKubun;
    @TempTableColumnOrder(22)
    private RString setaikazeiKubun;
    @TempTableColumnOrder(23)
    private Decimal gokeiShotokuGaku;
    @TempTableColumnOrder(24)
    private Decimal nenkinShunyuGaku;
    @TempTableColumnOrder(25)
    private RString hokenryoDankai;
    @TempTableColumnOrder(26)
    private RString hokenryoDankai1;
    @TempTableColumnOrder(27)
    private Decimal nengakuHokenryo1;
    @TempTableColumnOrder(28)
    private FlexibleYearMonth tsukiwariStartYM1;
    @TempTableColumnOrder(29)
    private FlexibleYearMonth tsukiwariEndYM1;
    @TempTableColumnOrder(30)
    private RString hokenryoDankai2;
    @TempTableColumnOrder(31)
    private Decimal nengakuHokenryo2;
    @TempTableColumnOrder(32)
    private FlexibleYearMonth tsukiwariStartYM2;
    @TempTableColumnOrder(33)
    private FlexibleYearMonth tsukiwariEndYM2;
    @TempTableColumnOrder(34)
    private YMDHMS choteiNichiji;
    @TempTableColumnOrder(35)
    private RString choteiJiyu1;
    @TempTableColumnOrder(36)
    private RString choteiJiyu2;
    @TempTableColumnOrder(37)
    private RString choteiJiyu3;
    @TempTableColumnOrder(38)
    private RString choteiJiyu4;
    @TempTableColumnOrder(39)
    private RString koseiM;
    @TempTableColumnOrder(40)
    private Decimal gemmenMaeHokenryo;
    @TempTableColumnOrder(41)
    private Decimal gemmenGaku;
    @TempTableColumnOrder(42)
    private Decimal kakuteiHokenryo;
    @TempTableColumnOrder(43)
    private RString hokenryoDankaiKarisanntei;
    @TempTableColumnOrder(44)
    private int choshuHohoRirekiNo;
    @TempTableColumnOrder(45)
    private YMDHMS idoKijunNichiji;
    @TempTableColumnOrder(46)
    private RString kozaKubun;
    @TempTableColumnOrder(47)
    private RString kyokaisoKubun;
    @TempTableColumnOrder(48)
    private RString shokkenKubun;
    @TempTableColumnOrder(49)
    private LasdecCode fukaShichosonCode;
    @TempTableColumnOrder(50)
    private Decimal tkSaishutsuKampuGaku;
    @TempTableColumnOrder(51)
    private Decimal fuSaishutsuKampuGaku;
    @TempTableColumnOrder(52)
    private Decimal tkKibetsuGaku01;
    @TempTableColumnOrder(53)
    private Decimal tkKibetsuGaku02;
    @TempTableColumnOrder(54)
    private Decimal tkKibetsuGaku03;
    @TempTableColumnOrder(55)
    private Decimal tkKibetsuGaku04;
    @TempTableColumnOrder(56)
    private Decimal tkKibetsuGaku05;
    @TempTableColumnOrder(57)
    private Decimal tkKibetsuGaku06;
    @TempTableColumnOrder(58)
    private Decimal fuKibetsuGaku01;
    @TempTableColumnOrder(59)
    private Decimal fuKibetsuGaku02;
    @TempTableColumnOrder(60)
    private Decimal fuKibetsuGaku03;
    @TempTableColumnOrder(61)
    private Decimal fuKibetsuGaku04;
    @TempTableColumnOrder(62)
    private Decimal fuKibetsuGaku05;
    @TempTableColumnOrder(63)
    private Decimal fuKibetsuGaku06;
    @TempTableColumnOrder(64)
    private Decimal fuKibetsuGaku07;
    @TempTableColumnOrder(65)
    private Decimal fuKibetsuGaku08;
    @TempTableColumnOrder(66)
    private Decimal fuKibetsuGaku09;
    @TempTableColumnOrder(67)
    private Decimal fuKibetsuGaku10;
    @TempTableColumnOrder(68)
    private Decimal fuKibetsuGaku11;
    @TempTableColumnOrder(69)
    private Decimal fuKibetsuGaku12;
    @TempTableColumnOrder(70)
    private Decimal fuKibetsuGaku13;
    @TempTableColumnOrder(71)
    private Decimal fuKibetsuGaku14;
    @TempTableColumnOrder(72)
    private RString choshuHoho4gatsu;
    @TempTableColumnOrder(73)
    private RString choshuHoho5gatsu;
    @TempTableColumnOrder(74)
    private RString choshuHoho6gatsu;
    @TempTableColumnOrder(75)
    private RString choshuHoho7gatsu;
    @TempTableColumnOrder(76)
    private RString choshuHoho8gatsu;
    @TempTableColumnOrder(77)
    private RString choshuHoho9gatsu;
    @TempTableColumnOrder(78)
    private RString choshuHoho10gatsu;
    @TempTableColumnOrder(79)
    private RString choshuHoho11gatsu;
    @TempTableColumnOrder(80)
    private RString choshuHoho12gatsu;
    @TempTableColumnOrder(81)
    private RString choshuHoho1gatsu;
    @TempTableColumnOrder(82)
    private RString choshuHoho2gatsu;
    @TempTableColumnOrder(83)
    private RString choshuHoho3gatsu;
    @TempTableColumnOrder(84)
    private RString choshuHohoYoku4gatsu;
    @TempTableColumnOrder(85)
    private RString choshuHohoYoku5gatsu;
    @TempTableColumnOrder(86)
    private RString choshuHohoYoku6gatsu;
    @TempTableColumnOrder(87)
    private RString choshuHohoYoku7gatsu;
    @TempTableColumnOrder(88)
    private RString choshuHohoYoku8gatsu;
    @TempTableColumnOrder(89)
    private RString choshuHohoYoku9gatsu;
    @TempTableColumnOrder(90)
    private RString kariNenkinNo;
    @TempTableColumnOrder(91)
    private RString kariNenkinCode;
    @TempTableColumnOrder(92)
    private RString kariHosokuM;
    @TempTableColumnOrder(93)
    private RString honNenkinNo;
    @TempTableColumnOrder(94)
    private RString honNenkinCode;
    @TempTableColumnOrder(95)
    private RString honHosokuM;
    @TempTableColumnOrder(96)
    private RString yokunendoKariNenkinNo;
    @TempTableColumnOrder(97)
    private RString yokunendoKariNenkinCode;
    @TempTableColumnOrder(98)
    private RString yokunendoKariHosokuM;
    @TempTableColumnOrder(99)
    private boolean iraiSohuzumiFlag;
    @TempTableColumnOrder(100)
    private boolean tsuikaIraiSohuzumiFlag;
    @TempTableColumnOrder(101)
    private YMDHMS tokuchoTeishiNichiji;
    @TempTableColumnOrder(102)
    private RString tokuchoTeishiJiyuCode;
    @TempTableColumnOrder(103)
    private Decimal tkShunyuGaku01;
    @TempTableColumnOrder(104)
    private Decimal tkShunyuGaku02;
    @TempTableColumnOrder(105)
    private Decimal tkShunyuGaku03;
    @TempTableColumnOrder(106)
    private Decimal tkShunyuGaku04;
    @TempTableColumnOrder(107)
    private Decimal tkShunyuGaku05;
    @TempTableColumnOrder(108)
    private Decimal tkShunyuGaku06;
    @TempTableColumnOrder(109)
    private Decimal fuShunyuGaku01;
    @TempTableColumnOrder(110)
    private Decimal fuShunyuGaku02;
    @TempTableColumnOrder(111)
    private Decimal fuShunyuGaku03;
    @TempTableColumnOrder(112)
    private Decimal fuShunyuGaku04;
    @TempTableColumnOrder(113)
    private Decimal fuShunyuGaku05;
    @TempTableColumnOrder(114)
    private Decimal fuShunyuGaku06;
    @TempTableColumnOrder(115)
    private Decimal fuShunyuGaku07;
    @TempTableColumnOrder(116)
    private Decimal fuShunyuGaku08;
    @TempTableColumnOrder(117)
    private Decimal fuShunyuGaku09;
    @TempTableColumnOrder(118)
    private Decimal fuShunyuGaku10;
    @TempTableColumnOrder(119)
    private Decimal fuShunyuGaku11;
    @TempTableColumnOrder(120)
    private Decimal fuShunyuGaku12;
    @TempTableColumnOrder(121)
    private Decimal fuShunyuGaku13;
    @TempTableColumnOrder(122)
    private Decimal fuShunyuGaku14;
    @TempTableColumnOrder(123)
    private RString dbT2015KeisangoJoho_insertDantaiCd;
    @TempTableColumnOrder(124)
    private RDateTime dbT2015KeisangoJoho_insertTimestamp;
    @TempTableColumnOrder(125)
    private RString dbT2015KeisangoJoho_insertReamsLoginId;
    @TempTableColumnOrder(126)
    private UUID dbT2015KeisangoJoho_insertContextId;
    @TempTableColumnOrder(127)
    private boolean dbT2015KeisangoJoho_isDeleted;
    @TempTableColumnOrder(128)
    private int dbT2015KeisangoJoho_updateCount;
    @TempTableColumnOrder(129)
    private RDateTime dbT2015KeisangoJoho_lastUpdateTimestamp;
    @TempTableColumnOrder(130)
    private RString dbT2015KeisangoJoho_lastUpdateReamsLoginId;

    // 宛名情報の全項目
    @TempTableColumnOrder(131)
    private ShikibetsuCode atena_shikibetsuCode;
    @TempTableColumnOrder(132)
    private LasdecCode atena_genLasdecCode;
    @TempTableColumnOrder(133)
    private LasdecCode atena_kyuLasdecCode;
    @TempTableColumnOrder(134)
    private int atena_kyuLasdecCodeRenban;
    @TempTableColumnOrder(135)
    private GyomuCode atena_gyomuCode;
    @TempTableColumnOrder(136)
    private int atena_rirekiNo;
    @TempTableColumnOrder(137)
    private boolean atena_currentFlag;
    @TempTableColumnOrder(138)
    private RString atena_juminShubetsuCode;
    @TempTableColumnOrder(139)
    private KojinNo atena_kojinNo;
    @TempTableColumnOrder(140)
    private HojinNo atena_hojinNo;
    @TempTableColumnOrder(141)
    private FlexibleDate atena_shoriYMD;
    @TempTableColumnOrder(142)
    private RString atena_idoJiyuCode;
    @TempTableColumnOrder(143)
    private FlexibleDate atena_idoYMD;
    @TempTableColumnOrder(144)
    private RString atena_todokedeJiyuCode;
    @TempTableColumnOrder(145)
    private FlexibleDate atena_todokedeYMD;
    @TempTableColumnOrder(146)
    private Code atena_idoRiyuCode;
    @TempTableColumnOrder(147)
    private AtenaMeisho atena_meisho;
    @TempTableColumnOrder(148)
    private AtenaKanaMeisho atena_kanaMeisho;
    @TempTableColumnOrder(149)
    private RString atena_kannaiKangaiKubun;
    @TempTableColumnOrder(150)
    private YubinNo atena_yubinNo;
    @TempTableColumnOrder(151)
    private ChoikiCode atena_choikiCode;
    @TempTableColumnOrder(152)
    private ZenkokuJushoCode atena_zenkokuJushoCode;
    @TempTableColumnOrder(153)
    private AtenaJusho atena_jusho;
    @TempTableColumnOrder(154)
    private BanchiCode atena_banchiCode1;
    @TempTableColumnOrder(155)
    private BanchiCode atena_banchiCode2;
    @TempTableColumnOrder(156)
    private BanchiCode atena_banchiCode3;
    @TempTableColumnOrder(157)
    private BanchiCode atena_banchiCode4;
    @TempTableColumnOrder(158)
    private AtenaBanchi atena_banchi;
    @TempTableColumnOrder(159)
    private Katagaki atena_katagaki;
    @TempTableColumnOrder(160)
    private boolean atena_katagakiInjiFlag;
    @TempTableColumnOrder(161)
    private GyoseikuCode atena_gyoseikuCode;
    @TempTableColumnOrder(162)
    private RString atena_gyoseikuName;
    @TempTableColumnOrder(163)
    private ChikuCode atena_chikuCode1;
    @TempTableColumnOrder(164)
    private RString atena_chikuName1;
    @TempTableColumnOrder(165)
    private ChikuCode atena_chikuCode2;
    @TempTableColumnOrder(166)
    private RString atena_chikuName2;
    @TempTableColumnOrder(167)
    private ChikuCode atena_chikuCode3;
    @TempTableColumnOrder(168)
    private RString atena_chikuName3;
    @TempTableColumnOrder(169)
    private ShogakkokuCode atena_shogakkokuCode;
    @TempTableColumnOrder(170)
    private RString atena_shogakkokuName;
    @TempTableColumnOrder(171)
    private ChugakkokuCode atena_chugakkokuCode;
    @TempTableColumnOrder(172)
    private RString atena_chugakkokuName;
    @TempTableColumnOrder(173)
    private TohyokuCode atena_tohyokuCode;
    @TempTableColumnOrder(174)
    private RString atena_tohyokuName;
    @TempTableColumnOrder(175)
    private RString atena_juminJotaiCode;
    @TempTableColumnOrder(176)
    private SetaiCode atena_setaiCode;
    @TempTableColumnOrder(177)
    private FlexibleDate atena_seinengappiYMD;
    @TempTableColumnOrder(178)
    private RString atena_seinengappiFushoKubun;
    @TempTableColumnOrder(179)
    private RString atena_seibetsuCode;
    @TempTableColumnOrder(180)
    private TsuzukigaraCode atena_tsuzukigaraCode;
    @TempTableColumnOrder(181)
    private RString atena_tsuzukigara;
    @TempTableColumnOrder(182)
    private int atena_kazokuNo;
    @TempTableColumnOrder(183)
    private int atena_juminhyoHyojijun;
    @TempTableColumnOrder(184)
    private FlexibleDate atena_kikaYMD;
    @TempTableColumnOrder(185)
    private AtenaMeisho atena_kanjiShimei;
    @TempTableColumnOrder(186)
    private AtenaKanaMeisho atena_kanaShimei;
    @TempTableColumnOrder(187)
    private ZenkokuJushoCode atena_honsekiZenkokuJushoCode;
    @TempTableColumnOrder(188)
    private ChoikiCode atena_honsekiChoikiCode;
    @TempTableColumnOrder(189)
    private AtenaJusho atena_honsekiJusho;
    @TempTableColumnOrder(190)
    private AtenaBanchi atena_honsekiBanchi;
    @TempTableColumnOrder(191)
    private AtenaMeisho atena_hittosha;
    @TempTableColumnOrder(192)
    private AtenaMeisho atena_gaikokujinShimei;
    @TempTableColumnOrder(193)
    private AtenaMeisho atena_gaikokujinHeikimei;
    @TempTableColumnOrder(194)
    private AtenaKanaMeisho atena_gaikokujinKanaShimei;
    @TempTableColumnOrder(195)
    private AtenaMeisho atena_tsushomei;
    @TempTableColumnOrder(196)
    private RString atena_shimeiRiyoKubun;
    @TempTableColumnOrder(197)
    private AtenaKanaMeisho atena_kanaTsushomei;
    @TempTableColumnOrder(198)
    private AtenaKanaMeisho atena_katakanaHyoki;
    @TempTableColumnOrder(199)
    private Code atena_kokusekiChiikiCode;
    @TempTableColumnOrder(200)
    private Code atena_zairyuShikakuCode;
    @TempTableColumnOrder(201)
    private RString atena_zairyuKikanCode;
    @TempTableColumnOrder(202)
    private FlexibleDate atena_zairyuKikantoManryoYMD;
    @TempTableColumnOrder(203)
    private RString atena_zairyuCardtoNo;
    @TempTableColumnOrder(204)
    private FlexibleDate atena_zairyuCardtoYukoYMD;
    @TempTableColumnOrder(205)
    private RString atena_dai30Jono45niKiteisuruKubun;
    @TempTableColumnOrder(206)
    private ShikibetsuCode atena_setainushiShikibetsuCode;
    @TempTableColumnOrder(207)
    private AtenaMeisho atena_setainushiMei;
    @TempTableColumnOrder(208)
    private Code atena_hojinKeitaiCode;
    @TempTableColumnOrder(209)
    private RString atena_hojinKeitaiMeisho;
    @TempTableColumnOrder(210)
    private RString atena_hojinKeitaiRyakusho;
    @TempTableColumnOrder(211)
    private RString atena_hojinMeishoHenshuKubun;
    @TempTableColumnOrder(212)
    private RString atena_hojinKeitaiRyakushoKubun;
    @TempTableColumnOrder(213)
    private AtenaMeisho atena_hojinMeisho;
    @TempTableColumnOrder(214)
    private AtenaKanaMeisho atena_hojinKanaMeisho;
    @TempTableColumnOrder(215)
    private AtenaMeisho atena_hojinShitenMeisho;
    @TempTableColumnOrder(216)
    private AtenaKanaMeisho atena_hojinShitenKanaMeisho;
    @TempTableColumnOrder(217)
    private ShikibetsuCode atena_daihyoshaShikibetsuCode;
    @TempTableColumnOrder(218)
    private RString atena_daihyoshaJuminShubetsu;
    @TempTableColumnOrder(219)
    private AtenaMeisho atena_daihyoshaShimei;
    @TempTableColumnOrder(220)
    private AtenaKanaMeisho atena_daihyoshaKanaShimei;
    @TempTableColumnOrder(221)
    private AtenaMeisho atena_daihyoshaNihonjinShimei;
    @TempTableColumnOrder(222)
    private AtenaKanaMeisho atena_daihyoshaNihonjinKanaShimei;
    @TempTableColumnOrder(223)
    private AtenaMeisho atena_daihyoshaGaikokujinShimei;
    @TempTableColumnOrder(224)
    private AtenaMeisho atena_daihyoshaGaikokujinHeikimei;
    @TempTableColumnOrder(225)
    private AtenaKanaMeisho atena_daihyoshaGaikokujinKanaShimei;
    @TempTableColumnOrder(226)
    private AtenaMeisho atena_daihyoshaTsushomei;
    @TempTableColumnOrder(227)
    private RString atena_daihyoshaShimeiRiyoKubun;
    @TempTableColumnOrder(228)
    private AtenaKanaMeisho atena_daihyoshaKanaTsushomei;
    @TempTableColumnOrder(229)
    private RString atena_daihyoshaKannaiKangaiKubun;
    @TempTableColumnOrder(230)
    private YubinNo atena_daihyoshaYubinNo;
    @TempTableColumnOrder(231)
    private ChoikiCode atena_daihyoshaChoikiCode;
    @TempTableColumnOrder(232)
    private ZenkokuJushoCode atena_daihyoshaZenkokuJushoCode;
    @TempTableColumnOrder(233)
    private AtenaJusho atena_daihyoshaJusho;
    @TempTableColumnOrder(234)
    private BanchiCode atena_daihyoshaBanchiCode1;
    @TempTableColumnOrder(235)
    private BanchiCode atena_daihyoshaBanchiCode2;
    @TempTableColumnOrder(236)
    private BanchiCode atena_daihyoshaBanchiCode3;
    @TempTableColumnOrder(237)
    private BanchiCode atena_daihyoshaBanchiCode4;
    @TempTableColumnOrder(238)
    private AtenaBanchi atena_daihyoshaBanchi;
    @TempTableColumnOrder(239)
    private Katagaki atena_daihyoshaKatagaki;
    @TempTableColumnOrder(240)
    private Code atena_ninkachiendantaiTorokuShikakuKubun;
    @TempTableColumnOrder(241)
    private FlexibleDate atena_ninkachiendantaiNinkaYMD;
    @TempTableColumnOrder(242)
    private RString atena_kojinHojinKBN;
    @TempTableColumnOrder(243)
    private AtenaMeisho atena_kyoyushaMeisho;
    @TempTableColumnOrder(244)
    private AtenaKanaMeisho atena_kyoyushaKanaMeisho;
    @TempTableColumnOrder(245)
    private RString atena_torokuJiyuCode;
    @TempTableColumnOrder(246)
    private FlexibleDate atena_torokuIdoYMD;
    @TempTableColumnOrder(247)
    private FlexibleDate atena_torokuTodokedeYMD;
    @TempTableColumnOrder(248)
    private RString atena_juteiJiyuCode;
    @TempTableColumnOrder(249)
    private FlexibleDate atena_juteiIdoYMD;
    @TempTableColumnOrder(250)
    private FlexibleDate atena_juteiTodokedeYMD;
    @TempTableColumnOrder(251)
    private RString atena_shojoJiyuCode;
    @TempTableColumnOrder(252)
    private FlexibleDate atena_shojoIdoYMD;
    @TempTableColumnOrder(253)
    private FlexibleDate atena_shojoTodokedeYMD;
    @TempTableColumnOrder(254)
    private YubinNo atena_jutonaiYubinNo;
    @TempTableColumnOrder(255)
    private ChoikiCode atena_jutonaiChoikiCode;
    @TempTableColumnOrder(256)
    private RString atena_jutonaiJusho;
    @TempTableColumnOrder(257)
    private BanchiCode atena_jutonaiBanchiCode1;
    @TempTableColumnOrder(258)
    private BanchiCode atena_jutonaiBanchiCode2;
    @TempTableColumnOrder(259)
    private BanchiCode atena_jutonaiBanchiCode3;
    @TempTableColumnOrder(260)
    private BanchiCode atena_jutonaiBanchiCode4;
    @TempTableColumnOrder(261)
    private AtenaBanchi atena_jutonaiBanchi;
    @TempTableColumnOrder(262)
    private Katagaki atena_jutonaiKatagaki;
    @TempTableColumnOrder(263)
    private boolean atena_jutonaiKatagakiInjiFlag;
    @TempTableColumnOrder(264)
    private YubinNo atena_tennyumaeYubinNo;
    @TempTableColumnOrder(265)
    private ZenkokuJushoCode atena_tennyumaeZenkokuJushoCode;
    @TempTableColumnOrder(266)
    private AtenaJusho atena_tennyumaeJusho;
    @TempTableColumnOrder(267)
    private AtenaBanchi atena_tennyumaeBanchi;
    @TempTableColumnOrder(268)
    private Katagaki atena_tennyumaeKatagaki;
    @TempTableColumnOrder(269)
    private RString atena_tennyumaeSetainushimei;
    @TempTableColumnOrder(270)
    private AtenaMeisho atena_tennyumaeKyusei;
    @TempTableColumnOrder(271)
    private YubinNo atena_saishuJutochiYubinNo;
    @TempTableColumnOrder(272)
    private ZenkokuJushoCode atena_saishuJutochiZenkokuJushoCode;
    @TempTableColumnOrder(273)
    private AtenaJusho atena_saishuJutochiJusho;
    @TempTableColumnOrder(274)
    private AtenaBanchi atena_saishuJutochiBanchi;
    @TempTableColumnOrder(275)
    private Katagaki atena_saishuJutochiKatagaki;
    @TempTableColumnOrder(276)
    private RString atena_saishuJutochiSetainushimei;
    @TempTableColumnOrder(277)
    private FlexibleDate atena_tenshutsuYoteiIdoYMD;
    @TempTableColumnOrder(278)
    private YubinNo atena_tenshutsuYoteiYubinNo;
    @TempTableColumnOrder(279)
    private ZenkokuJushoCode atena_tenshutsuYoteiZenkokuJushoCode;
    @TempTableColumnOrder(280)
    private AtenaJusho atena_tenshutsuYoteiJusho;
    @TempTableColumnOrder(281)
    private AtenaBanchi atena_tenshutsuYoteiBanchi;
    @TempTableColumnOrder(282)
    private Katagaki atena_tenshutsuYoteiKatagaki;
    @TempTableColumnOrder(283)
    private RString atena_tenshutsuYoteiSetainushimei;
    @TempTableColumnOrder(284)
    private FlexibleDate atena_tenshutsuKakuteiIdoYMD;
    @TempTableColumnOrder(285)
    private FlexibleDate atena_tenshutsuKakuteiTsuchiYMD;
    @TempTableColumnOrder(286)
    private YubinNo atena_tenshutsuKakuteiYubinNo;
    @TempTableColumnOrder(287)
    private ZenkokuJushoCode atena_tenshutsuKakuteiZenkokuJushoCode;
    @TempTableColumnOrder(288)
    private AtenaJusho atena_tenshutsuKakuteiJusho;
    @TempTableColumnOrder(289)
    private AtenaBanchi atena_tenshutsuKakuteiBanchi;
    @TempTableColumnOrder(290)
    private Katagaki atena_tenshutsuKakuteiKatagaki;
    @TempTableColumnOrder(291)
    private RString atena_tenshutsuKakuteiSetainushimei;
    @TempTableColumnOrder(292)
    private RString atena_juminhyoUtsushiHakkoSeigyoKubun;
    @TempTableColumnOrder(293)
    private TelNo atena_renrakusaki1;
    @TempTableColumnOrder(294)
    private TelNo atena_kensakuRenrakusaki1;
    @TempTableColumnOrder(295)
    private Code atena_renrakusakiKubun1;
    @TempTableColumnOrder(296)
    private TelNo atena_renrakusaki2;
    @TempTableColumnOrder(297)
    private TelNo atena_kensakuRenrakusaki2;
    @TempTableColumnOrder(298)
    private Code atena_renrakusakiKubun2;
    @TempTableColumnOrder(299)
    private TelNo atena_renrakusaki3;
    @TempTableColumnOrder(300)
    private TelNo atena_kensakuRenrakusaki3;
    @TempTableColumnOrder(301)
    private Code atena_renrakusakiKubun3;
    @TempTableColumnOrder(302)
    private MailAddress atena_mailAddress;
    @TempTableColumnOrder(303)
    private RString atena_biko;
    @TempTableColumnOrder(304)
    private RString atena_kanaName;
    @TempTableColumnOrder(305)
    private RString atena_gaikokujinKanaName;
    @TempTableColumnOrder(306)
    private RString atena_kanaTsushoName;
    @TempTableColumnOrder(307)
    private RDateTime atena_lastUpdateTimestamp;
    @TempTableColumnOrder(308)
    private RString atena_lastUpdateReamsLoginId;
    @TempTableColumnOrder(309)
    private int atena_jutogaiKanriUpdateCount;
    @TempTableColumnOrder(310)
    private TorokuNo atena_jutogaiKanriTorokuNo;
    @TempTableColumnOrder(311)
    private int atena_jutogaiKojinKihonUpdateCount;
    @TempTableColumnOrder(312)
    private TorokuNo atena_jutogaiKojinKihonTorokuNo;
    @TempTableColumnOrder(313)
    private int atena_jutogaiNihonjinUpdateCount;
    @TempTableColumnOrder(314)
    private TorokuNo atena_jutogaiNihonjinTorokuNo;
    @TempTableColumnOrder(315)
    private int atena_jutogaiGaikokujinUpdateCount;
    @TempTableColumnOrder(316)
    private TorokuNo atena_jutogaiGaikokujinTorokuNo;
    @TempTableColumnOrder(317)
    private int atena_hojinUpdateCount;
    @TempTableColumnOrder(318)
    private TorokuNo atena_hojinTorokuNo;
    @TempTableColumnOrder(319)
    private int atena_kyoyushaUpdateCount;
    @TempTableColumnOrder(320)
    private TorokuNo atena_kyoyushaTorokuNo;
    @TempTableColumnOrder(321)
    private TorokuNo atena_shimeiSearchTorokuNo;
    @TempTableColumnOrder(322)
    private int atena_yusenShimeiUpdateCount;
    @TempTableColumnOrder(323)
    private RDateTime atena_yusenShimeiTimestamp;
    @TempTableColumnOrder(324)
    private RString dbV2002Fuka_hokenryoDankai;
    @TempTableColumnOrder(325)
    private Decimal dbV2002Fuka_kakuteiHokenryo;
    @TempTableColumnOrder(326)
    private Code ueT0511_dtTokubetsuChoshuGimushaCode;
    @TempTableColumnOrder(327)
    private RString shutsuryokujunTemp_choshuHoho;
    @TempTableColumnOrder(328)
    private RString shutsuryokujunTemp_tokuchoKaisiTuki;

}
