/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ichijiteburu;

import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 日次進捗一時デーブルEntity
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NichijiShinchokuIchijiTeburuEntity extends DbTableEntityBase<NichijiShinchokuIchijiTeburuEntity> implements IDbAccessable {

    /**
     * テーブル名です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("NichijiShinchokuIchijiTeburuTemp"));
    }

    @TempTableColumnOrder(1)
    private RString koban;
    @TempTableColumnOrder(2)
    private RString sutetasu;
    @TempTableColumnOrder(3)
    private ShikibetsuCode shikibetsukodo;
    @TempTableColumnOrder(4)
    private RString hokenshabango;
    @TempTableColumnOrder(5)
    private RString hihokenjabango;
    @TempTableColumnOrder(6)
    private FlexibleDate ninteishinseibi;
    @TempTableColumnOrder(7)
    private RString edaban;
    @TempTableColumnOrder(8)
    private Code shinseikubunhorei;
    @TempTableColumnOrder(9)
    private Code shinseikubunshinseiji;
    @TempTableColumnOrder(10)
    private Code torisakubunkodo;
    @TempTableColumnOrder(11)
    private Code hihokenjakubun;
    @TempTableColumnOrder(12)
    private Code shinseidaikokubun;
    @TempTableColumnOrder(13)
    private FlexibleDate seinengappi;
    @TempTableColumnOrder(14)
    private int nenrei;
    @TempTableColumnOrder(15)
    private Code seibetsukodo;
    @TempTableColumnOrder(16)
    private AtenaKanaMeisho hihokenjakanashimei;
    @TempTableColumnOrder(17)
    private AtenaMeisho hihokenjakanjishimei;
    @TempTableColumnOrder(18)
    private YubinNo yubenbango;
    @TempTableColumnOrder(19)
    private AtenaJusho jusho;
    @TempTableColumnOrder(20)
    private TelNo tenwabango;
    @TempTableColumnOrder(21)
    private RString byoinshisetsutonomeisho;
    @TempTableColumnOrder(22)
    private RString byoinshisetsutonoshozaichi;
    @TempTableColumnOrder(23)
    private RString zenkainoninteishinsakaikekka;
    @TempTableColumnOrder(24)
    private FlexibleDate zenkainoninteiyukokigenkaishi;
    @TempTableColumnOrder(25)
    private FlexibleDate zenkainoninteiyukokigenshuryo;
    @TempTableColumnOrder(26)
    private RString shujiiiryokikanbango;
    @TempTableColumnOrder(27)
    private RString shujiibango;
    @TempTableColumnOrder(28)
    private FlexibleDate lkenshoiraibi;
    @TempTableColumnOrder(29)
    private FlexibleDate lkenshonyushubi;
    @TempTableColumnOrder(30)
    private RString lkensho_tankikioku;
    @TempTableColumnOrder(31)
    private RString lkensho_ninchinoryoku;
    @TempTableColumnOrder(32)
    private RString lkensho_dentatsunoryoku;
    @TempTableColumnOrder(33)
    private RString lkensho_shokujikoi;
    @TempTableColumnOrder(34)
    private RString lkensho_ninshishokoreishajiritsudo;
    @TempTableColumnOrder(35)
    private FlexibleDate chosairaibi;
    @TempTableColumnOrder(36)
    private FlexibleDate chosajisshibi;
    @TempTableColumnOrder(37)
    private RString shiteikyotakukaigoshienjigyoshatobango;
    @TempTableColumnOrder(38)
    private RString ltakukubun;
    @TempTableColumnOrder(39)
    private RString ninteichosainbango;
    @TempTableColumnOrder(40)
    private Code ninteichosainshikakukodo;
    @TempTableColumnOrder(41)
    private FlexibleDate lchijihanteibi;
    @TempTableColumnOrder(42)
    private RString lchijihanteikekka;
    @TempTableColumnOrder(43)
    private RString lchijihanteikekka_ninshishokasan;
    @TempTableColumnOrder(44)
    private RString yokaigoninteitokijunjikan;
    @TempTableColumnOrder(45)
    private RString yokaigoninteitokijunjikan_shokuji;
    @TempTableColumnOrder(46)
    private RString yokaigoninteitokijunjikan_haisetsu;
    @TempTableColumnOrder(47)
    private RString yokaigoninteitokijunjikan_ldo;
    @TempTableColumnOrder(48)
    private RString yokaigoninteitokijunjikan_seiketsuhoji;
    @TempTableColumnOrder(49)
    private RString yokaigoninteitokijunjikan_kansetsukea;
    @TempTableColumnOrder(50)
    private RString yokaigoninteitokijunjikan_bpsdkanren;
    @TempTableColumnOrder(51)
    private RString yokaigoninteitokijunjikan_kinokunren;
    @TempTableColumnOrder(52)
    private RString yokaigoninteitokijunjikan_lryokanren;
    @TempTableColumnOrder(53)
    private RString yokaigoninteitokijunjikan_ninshishokasan;
    @TempTableColumnOrder(54)
    private RString chukanhyokakomokutokuten_dai1gun;
    @TempTableColumnOrder(55)
    private RString chukanhyokakomokutokuten_dai2gun;
    @TempTableColumnOrder(56)
    private RString chukanhyokakomokutokuten_dai3gun;
    @TempTableColumnOrder(57)
    private RString chukanhyokakomokutokuten_dai4gun;
    @TempTableColumnOrder(58)
    private RString chukanhyokakomokutokuten_dai5gun;
    @TempTableColumnOrder(59)
    private Code lchijihanteikeikoku;
    @TempTableColumnOrder(60)
    private RString jotainoanteisei;
    @TempTableColumnOrder(61)
    private RString ninshishojiritsudoijonogaizensei;
    @TempTableColumnOrder(62)
    private RString ninchikinokyufukubun;
    @TempTableColumnOrder(63)
    private FlexibleDate ninteishinsakaishiryosakuseibi;
    @TempTableColumnOrder(64)
    private FlexibleDate ninteishinsakaiyoteibi;
    @TempTableColumnOrder(65)
    private RString gogitaibango;
    @TempTableColumnOrder(66)
    private RString shinsakaishiryobango;
    @TempTableColumnOrder(67)
    private FlexibleDate nijihanteibi;
    @TempTableColumnOrder(68)
    private RString nijihanteikekka;
    @TempTableColumnOrder(69)
    private FlexibleDate ninteiyukokigen_kaishi;
    @TempTableColumnOrder(70)
    private FlexibleDate ninteiyukokigen_shuryo;
    @TempTableColumnOrder(71)
    private Code tokuteishippeikodo;
    @TempTableColumnOrder(72)
    private RString yokaigo1nobaainojotaizo;
    @TempTableColumnOrder(73)
    private Code genzainosabisukubunkodo;
    @TempTableColumnOrder(74)
    private RString genzainojokyo;
    @TempTableColumnOrder(75)
    private RString homonkaigo_homuherupusabisu;
    @TempTableColumnOrder(76)
    private RString homonnyuyokukaigo;
    @TempTableColumnOrder(77)
    private RString homonkango;
    @TempTableColumnOrder(78)
    private RString homonrihabiriteshon;
    @TempTableColumnOrder(79)
    private RString kyotakuryoyokanrishido;
    @TempTableColumnOrder(80)
    private RString tsushokaigo_deisabisu;
    @TempTableColumnOrder(81)
    private RString tsushorihabiriteshon;
    @TempTableColumnOrder(82)
    private RString tankinyushoseikatsukaigo_shotosutei;
    @TempTableColumnOrder(83)
    private RString tankinyushoryoyokaigo;
    @TempTableColumnOrder(84)
    private RString tokuteishisetsunyukyoshaseikatsukaigo;
    @TempTableColumnOrder(85)
    private RString fukushiyogutaiyo;
    @TempTableColumnOrder(86)
    private RString tokuteifukushiyoguhanbai;
    @TempTableColumnOrder(87)
    private RString jutakukaishukaigokyufu;
    @TempTableColumnOrder(88)
    private RString yakantaiogatahomonkaigo;
    @TempTableColumnOrder(89)
    private RString ninchishotaiogatasushokaigo;
    @TempTableColumnOrder(90)
    private RString shokibotakinogatakyotakukaigo;
    @TempTableColumnOrder(91)
    private RString ninshishokaigo_gurupuhomu;
    @TempTableColumnOrder(92)
    private RString chiikimitchakugataseikatsukaigo;
    @TempTableColumnOrder(93)
    private RString mitchakugatarojinkaigo;
    @TempTableColumnOrder(94)
    private RString teikijunkai_zuijihomonkaigokango;
    @TempTableColumnOrder(95)
    private RString fukugogatasabisu;
    @TempTableColumnOrder(96)
    private RString kaigoyobohomonkaigo_homuherupusabisu;
    @TempTableColumnOrder(97)
    private RString kaigoyobohomonnyuyokukaigo;
    @TempTableColumnOrder(98)
    private RString kaigoyobohomonkango;
    @TempTableColumnOrder(99)
    private RString kaigoyobohomonrihabiriteshon;
    @TempTableColumnOrder(100)
    private RString kaigoyobokyotakuryoyokanrishido;
    @TempTableColumnOrder(101)
    private RString kaigoyobotsushokaigo_deisabisu;
    @TempTableColumnOrder(102)
    private RString kaigoyobotsushorihabiriteshon;
    @TempTableColumnOrder(103)
    private RString kaigoyobotankiseikatsukaigo;
    @TempTableColumnOrder(104)
    private RString kaigoyobotankinyushoryoyokaigo;
    @TempTableColumnOrder(105)
    private RString yobotokuteishisetsunyukyoshakaigo;
    @TempTableColumnOrder(106)
    private RString kaigoyobofukushiyogutaiyo;
    @TempTableColumnOrder(107)
    private RString tokuteikaigoyobofukushiyoguhanbai;
    @TempTableColumnOrder(108)
    private RString jutakukaishu_yobokyufu;
    @TempTableColumnOrder(109)
    private RString kaigoyoboninchishotaiogatatsushokaigo;
    @TempTableColumnOrder(110)
    private RString kaigoyoboshokibotakinogatakyotakukaigo;
    @TempTableColumnOrder(111)
    private RString yoboninshishokaigo_gurupuhomu;
    @TempTableColumnOrder(112)
    private RString mahi_hidari_joshi01;
    @TempTableColumnOrder(113)
    private RString mahi_migi_joshi01;
    @TempTableColumnOrder(114)
    private RString mahi_hidari_kashi01;
    @TempTableColumnOrder(115)
    private RString mahi_migi_kashi01;
    @TempTableColumnOrder(116)
    private RString mahi_sonohoka01;
    @TempTableColumnOrder(117)
    private RString koshuku_kenkansetsu01;
    @TempTableColumnOrder(118)
    private RString koshuku_kokansetsu01;
    @TempTableColumnOrder(119)
    private RString koshuku_hizakansetsu01;
    @TempTableColumnOrder(120)
    private RString koshuku_sonohoka01;
    @TempTableColumnOrder(121)
    private RString negaeri01;
    @TempTableColumnOrder(122)
    private RString okiagari01;
    @TempTableColumnOrder(123)
    private RString zaihoji01;
    @TempTableColumnOrder(124)
    private RString ryoashidenotagu01;
    @TempTableColumnOrder(125)
    private RString hoko01;
    @TempTableColumnOrder(126)
    private RString tachiagari01;
    @TempTableColumnOrder(127)
    private RString kataashidenotagu01;
    @TempTableColumnOrder(128)
    private RString araimi01;
    @TempTableColumnOrder(129)
    private RString tsumekiri01;
    @TempTableColumnOrder(130)
    private RString shiryoku01;
    @TempTableColumnOrder(131)
    private RString choryoku01;
    @TempTableColumnOrder(132)
    private RString ljo02;
    @TempTableColumnOrder(133)
    private RString ldo02;
    @TempTableColumnOrder(134)
    private RString enge02;
    @TempTableColumnOrder(135)
    private RString shokujisesshu02;
    @TempTableColumnOrder(136)
    private RString hainyo02;
    @TempTableColumnOrder(137)
    private RString haiben02;
    @TempTableColumnOrder(138)
    private RString kokuseiketsu02;
    @TempTableColumnOrder(139)
    private RString sengan02;
    @TempTableColumnOrder(140)
    private RString seihatsu02;
    @TempTableColumnOrder(141)
    private RString uwaginochakudatsu02;
    @TempTableColumnOrder(142)
    private RString zubontonochakudatsu02;
    @TempTableColumnOrder(143)
    private RString gaishutsuhindo02;
    @TempTableColumnOrder(144)
    private RString lshinodentatsu03;
    @TempTableColumnOrder(145)
    private RString mainichinonikkaorikai03;
    @TempTableColumnOrder(146)
    private RString seinengappioiu03;
    @TempTableColumnOrder(147)
    private RString tankikioku03;
    @TempTableColumnOrder(148)
    private RString jibunnonamaeoiu03;
    @TempTableColumnOrder(149)
    private RString imanokisetsuorikai03;
    @TempTableColumnOrder(150)
    private RString bashonorikai03;
    @TempTableColumnOrder(151)
    private RString haikai03;
    @TempTableColumnOrder(152)
    private RString gaishutsushitemodorenai03;
    @TempTableColumnOrder(153)
    private RString higaiteki04;
    @TempTableColumnOrder(154)
    private RString sakubanashi04;
    @TempTableColumnOrder(155)
    private RString kanjōgafuantei04;
    @TempTableColumnOrder(156)
    private RString chuyagyakuten04;
    @TempTableColumnOrder(157)
    private RString onajibanashiosuru04;
    @TempTableColumnOrder(158)
    private RString ogoewodasu04;
    @TempTableColumnOrder(159)
    private RString kaigoniteiko04;
    @TempTableColumnOrder(160)
    private RString ochitsukinashi04;
    @TempTableColumnOrder(161)
    private RString ichiridedetagaru04;
    @TempTableColumnOrder(162)
    private RString shushuheki04;
    @TempTableColumnOrder(163)
    private RString monoyairuiokowasu04;
    @TempTableColumnOrder(164)
    private RString hidoimonowasure04;
    @TempTableColumnOrder(165)
    private RString hitorigotohitoriwarai04;
    @TempTableColumnOrder(166)
    private RString jibungattenikodosuru04;
    @TempTableColumnOrder(167)
    private RString wagamatomaranai04;
    @TempTableColumnOrder(168)
    private RString kusurinonaifuku05;
    @TempTableColumnOrder(169)
    private RString kinsennokanri05;
    @TempTableColumnOrder(170)
    private RString nichijonoishikettei05;
    @TempTableColumnOrder(171)
    private RString shudanenofutekio05;
    @TempTableColumnOrder(172)
    private RString kaimono05;
    @TempTableColumnOrder(173)
    private RString kantannachori05;
    @TempTableColumnOrder(174)
    private RString tentekinokanri;
    @TempTableColumnOrder(175)
    private RString chushinjomyakueiyo;
    @TempTableColumnOrder(176)
    private RString toseki;
    @TempTableColumnOrder(177)
    private RString sutomanoshochi;
    @TempTableColumnOrder(178)
    private RString sansoryoho;
    @TempTableColumnOrder(179)
    private RString resupireta;
    @TempTableColumnOrder(180)
    private RString kikansekkainoshochitotsunokango;
    @TempTableColumnOrder(181)
    private RString keikaneiyo;
    @TempTableColumnOrder(182)
    private RString monitasokutei;
    @TempTableColumnOrder(183)
    private RString jiyokusounoshochi;
    @TempTableColumnOrder(184)
    private RString kateteru;
    @TempTableColumnOrder(185)
    private RString shogaikorei;
    @TempTableColumnOrder(186)
    private RString shajiritsudo;
    @TempTableColumnOrder(187)
    private RString ninshishokoreishajiritsudo;
    @TempTableColumnOrder(188)
    private RString zenkaikekka_mahi_hidari_joshi01;
    @TempTableColumnOrder(189)
    private RString zenkaikekka_mahi_migi_joshi01;
    @TempTableColumnOrder(190)
    private RString zenkaikekka_mahi_hidari_kashi01;
    @TempTableColumnOrder(191)
    private RString zenkaikekka_mahi_migi_kashi01;
    @TempTableColumnOrder(192)
    private RString zenkaikekka_mahi_sonohoka01;
    @TempTableColumnOrder(193)
    private RString zenkaikekka_koshuku_kenkansetsu01;
    @TempTableColumnOrder(194)
    private RString zenkaikekka_koshuku_kokansetsu01;
    @TempTableColumnOrder(195)
    private RString zenkaikekka_koshuku_hizakansetsu01;
    @TempTableColumnOrder(196)
    private RString zenkaikekka_koshuku_sonohoka01;
    @TempTableColumnOrder(197)
    private RString zenkaikekka_negaeri01;
    @TempTableColumnOrder(198)
    private RString zenkaikekka_okiagari01;
    @TempTableColumnOrder(199)
    private RString zenkaikekka_zaihoji01;
    @TempTableColumnOrder(200)
    private RString zenkaikekka_ryoashidenotagu01;
    @TempTableColumnOrder(201)
    private RString zenkaikekka_hoko01;
    @TempTableColumnOrder(202)
    private RString zenkaikekka_tachiagari01;
    @TempTableColumnOrder(203)
    private RString zenkaikekka_kataashidenotagu01;
    @TempTableColumnOrder(204)
    private RString zenkaikekka_araimi01;
    @TempTableColumnOrder(205)
    private RString zenkaikekka_tsumekiri01;
    @TempTableColumnOrder(206)
    private RString zenkaikekka_shiryoku01;
    @TempTableColumnOrder(207)
    private RString zenkaikekka_choryoku01;
    @TempTableColumnOrder(208)
    private RString zenkaikekka_ljo02;
    @TempTableColumnOrder(209)
    private RString zenkaikekka_ldo02;
    @TempTableColumnOrder(210)
    private RString zenkaikekka_enge02;
    @TempTableColumnOrder(211)
    private RString zenkaikekka_shokujisesshu02;
    @TempTableColumnOrder(212)
    private RString zenkaikekka_hainyo02;
    @TempTableColumnOrder(213)
    private RString zenkaikekka_haiben02;
    @TempTableColumnOrder(214)
    private RString zenkaikekka_kokuseiketsu02;
    @TempTableColumnOrder(215)
    private RString zenkaikekka_sengan02;
    @TempTableColumnOrder(216)
    private RString zenkaikekka_seihatsu02;
    @TempTableColumnOrder(217)
    private RString zenkaikekka_uwaginochakudatsu02;
    @TempTableColumnOrder(218)
    private RString zenkaikekka_zubontonochakudatsu02;
    @TempTableColumnOrder(219)
    private RString zenkaikekka_gaishutsuhindo02;
    @TempTableColumnOrder(220)
    private RString zenkaikekka_lshinodentatsu03;
    @TempTableColumnOrder(221)
    private RString zenkaikekka_mainichinonikkaorikai03;
    @TempTableColumnOrder(222)
    private RString zenkaikekka_seinengappioiu03;
    @TempTableColumnOrder(223)
    private RString zenkaikekka_tankikioku03;
    @TempTableColumnOrder(224)
    private RString zenkaikekka_jibunnonamaeoiu03;
    @TempTableColumnOrder(225)
    private RString zenkaikekka_imanokisetsuorikai03;
    @TempTableColumnOrder(226)
    private RString zenkaikekka_bashonorikai03;
    @TempTableColumnOrder(227)
    private RString zenkaikekka_haikai03;
    @TempTableColumnOrder(228)
    private RString zenkaikekka_gaishutsushitemodorenai03;
    @TempTableColumnOrder(229)
    private RString zenkaikekka_higaiteki04;
    @TempTableColumnOrder(230)
    private RString zenkaikekka_sakubanashi04;
    @TempTableColumnOrder(231)
    private RString zenkaikekka_kanjōgafuantei04;
    @TempTableColumnOrder(232)
    private RString zenkaikekka_chuyagyakuten04;
    @TempTableColumnOrder(233)
    private RString zenkaikekka_onajibanashiosuru04;
    @TempTableColumnOrder(234)
    private RString zenkaikekka_ogoewodasu04;
    @TempTableColumnOrder(235)
    private RString zenkaikekka_kaigoniteiko04;
    @TempTableColumnOrder(236)
    private RString zenkaikekka_ochitsukinashi04;
    @TempTableColumnOrder(237)
    private RString zenkaikekka_ichiridedetagaru04;
    @TempTableColumnOrder(238)
    private RString zenkaikekka_shushuheki04;
    @TempTableColumnOrder(239)
    private RString zenkaikekka_monoyairuiokowasu04;
    @TempTableColumnOrder(240)
    private RString zenkaikekka_hidoimonowasure04;
    @TempTableColumnOrder(241)
    private RString zenkaikekka_hitorigotohitoriwarai04;
    @TempTableColumnOrder(242)
    private RString zenkaikekka_jibungattenikodosuru04;
    @TempTableColumnOrder(243)
    private RString zenkaikekka_wagamatomaranai04;
    @TempTableColumnOrder(244)
    private RString zenkaikekka_Kusurinonaifuku05;
    @TempTableColumnOrder(245)
    private RString zenkaikekka_kinsennokanri05;
    @TempTableColumnOrder(246)
    private RString zenkaikekka_nichijonoishikettei05;
    @TempTableColumnOrder(247)
    private RString zenkaikekka_shudanenofutekio05;
    @TempTableColumnOrder(248)
    private RString zenkaikekka_kaimono05;
    @TempTableColumnOrder(249)
    private RString zenkaikekka_kantannachori05;
    @TempTableColumnOrder(250)
    private RString zenkaikekka_tentekinokanri;
    @TempTableColumnOrder(251)
    private RString zenkaikekka_chushinjomyakueiyo;
    @TempTableColumnOrder(252)
    private RString zenkaikekka_toseki;
    @TempTableColumnOrder(253)
    private RString zenkaikekka_sutomanoshochi;
    @TempTableColumnOrder(254)
    private RString zenkaikekka_sansoryoho;
    @TempTableColumnOrder(255)
    private RString zenkaikekka_resupireta;
    @TempTableColumnOrder(256)
    private RString zenkaikekka_kikansekkainoshochitotsunokango;
    @TempTableColumnOrder(257)
    private RString zenkaikekka_keikaneiyo;
    @TempTableColumnOrder(258)
    private RString zenkaikekka_monitasokutei;
    @TempTableColumnOrder(259)
    private RString zenkaikekka_jiyokusounoshochi;
    @TempTableColumnOrder(260)
    private RString zenkaikekka_kateteru;
    @TempTableColumnOrder(261)
    private RString zenkaikekka_shogaikorei;
    @TempTableColumnOrder(262)
    private RString zenkaikekka_shajiritsudo;
    @TempTableColumnOrder(263)
    private RString zenkaikekka_ninshishokoreishajiritsudo;
    @TempTableColumnOrder(264)
    private RString zenkaikekka_ichijihanteikekka;
    @TempTableColumnOrder(265)
    private RString zenkaikekka_ichijihanteikekka_ninshishokasan;
    @TempTableColumnOrder(266)
    private RString zenkaikekka_yokaigojikan;
    @TempTableColumnOrder(267)
    private RString zenkaikekka_yokaigojikan_shokuji;
    @TempTableColumnOrder(268)
    private RString zenkaikekka_yokaigojikan_haisetsu;
    @TempTableColumnOrder(269)
    private RString zenkaikekka_yokaigojikan_ldo;
    @TempTableColumnOrder(270)
    private RString zenkaikekka_yokaigojikan_seiketsuhoji;
    @TempTableColumnOrder(271)
    private RString zenkaikekka_yokaigojikan_kansetsukea;
    @TempTableColumnOrder(272)
    private RString zenkaikekka_yokaigojikan_kanren;
    @TempTableColumnOrder(273)
    private RString zenkaikekka_yokaigojikan_kinokunren;
    @TempTableColumnOrder(274)
    private RString zenkaikekka_yokaigojikan_iryokanren;
    @TempTableColumnOrder(275)
    private RString zenkaikekka_yokaigojikan_ninshishokasan;
    @TempTableColumnOrder(276)
    private RString zenkaikekka_chukanhyokakomokutokutendai1_gun;
    @TempTableColumnOrder(277)
    private RString zenkaikekka_chukanhyokakomokutokutendai2_gun;
    @TempTableColumnOrder(278)
    private RString zenkaikekka_chukanhyokakomokutokutendai3_gun;
    @TempTableColumnOrder(279)
    private RString zenkaikekka_chukanhyokakomokutokutendai4_gun;
    @TempTableColumnOrder(280)
    private RString zenkaikekka_chukanhyokakomokutokutendai5_gun;
    @TempTableColumnOrder(281)
    private Code zenkaikekka_kodo;
    @TempTableColumnOrder(282)
    private RString zenkaikekka_jotainoanteisei;
    @TempTableColumnOrder(283)
    private RString zenkaikekka_ninshishojiritsudo;
    @TempTableColumnOrder(284)
    private RString zenkaikekka_ninchikinokyufukubun;
    @TempTableColumnOrder(285)
    private FlexibleDate zenkaikekka_shinseibi;
    @TempTableColumnOrder(286)
    private FlexibleDate zenkaikekka_nijihanteibi;
    @TempTableColumnOrder(287)
    private Code zenkaikekka_genzainosabisukubunkodo;
    @TempTableColumnOrder(288)
    private RString zenkaikekka_genzainojokyo;
    @TempTableColumnOrder(289)
    private RString zenkaikekka_homonkaigo_homuherupusabisu;
    @TempTableColumnOrder(290)
    private RString zenkaikekka_homonnyuyokukaigo;
    @TempTableColumnOrder(291)
    private RString zenkaikekka_homonkango;
    @TempTableColumnOrder(292)
    private RString zenkaikekka_homonrihabiriteshon;
    @TempTableColumnOrder(293)
    private RString zenkaikekka_kyotakuryoyokanrishido;
    @TempTableColumnOrder(294)
    private RString zenkaikekka_tsushokaigo_deisabisu;
    @TempTableColumnOrder(295)
    private RString zenkaikekka_tsushorihabiriteshon;
    @TempTableColumnOrder(296)
    private RString zenkaikekka_tankinyushoseikatsukaigo_shotosutei;
    @TempTableColumnOrder(297)
    private RString zenkaikekka_tankinyushoryoyokaigo;
    @TempTableColumnOrder(298)
    private RString zenkaikekka_tokuteishisetsunyukyoshaseikatsukaigo;
    @TempTableColumnOrder(299)
    private RString zenkaikekka_fukushiyogutaiyo;
    @TempTableColumnOrder(300)
    private RString zenkaikekka_tokuteifukushiyoguhanbai;
    @TempTableColumnOrder(301)
    private RString zenkaikekka_jutakukaishukaigokyufu;
    @TempTableColumnOrder(302)
    private RString zenkaikekka_yakantaiogatahomonkaigo;
    @TempTableColumnOrder(303)
    private RString zenkaikekka_ninchishotaiogatasushokaigo;
    @TempTableColumnOrder(304)
    private RString zenkaikekka_shokibotakinogatakyotakukaigo;
    @TempTableColumnOrder(305)
    private RString zenkaikekka_ninshishokaigo_gurupuhomu;
    @TempTableColumnOrder(306)
    private RString zenkaikekka_chiikimitchakugataseikatsukaigo;
    @TempTableColumnOrder(307)
    private RString zenkaikekka_mitchakugatarojinkaigo;
    @TempTableColumnOrder(308)
    private RString zenkaikekka_teikijunkai_zuijihomonkaigokango;
    @TempTableColumnOrder(309)
    private RString zenkaikekka_fukugogatasabisu;
    @TempTableColumnOrder(310)
    private RString zenkaikekka_kaigoyobohomonkaigo_homuherupusabisu;
    @TempTableColumnOrder(311)
    private RString zenkaikekka_kaigoyobohomonnyuyokukaigo;
    @TempTableColumnOrder(312)
    private RString zenkaikekka_kaigoyobohomonkango;
    @TempTableColumnOrder(313)
    private RString zenkaikekka_kaigoyobohomonrihabiriteshon;
    @TempTableColumnOrder(314)
    private RString zenkaikekka_kaigoyobokyotakuryoyokanrishido;
    @TempTableColumnOrder(315)
    private RString zenkaikekka_kaigoyobotsushokaigo_deisabisu;
    @TempTableColumnOrder(316)
    private RString zenkaikekka_kaigoyobotsushorihabiriteshon;
    @TempTableColumnOrder(317)
    private RString zenkaikekka_kaigoyobotankiseikatsukaigo;
    @TempTableColumnOrder(318)
    private RString zenkaikekka_kaigoyobotankinyushoryoyokaigo;
    @TempTableColumnOrder(319)
    private RString zenkaikekka_yobotokuteishisetsunyukyoshakaigo;
    @TempTableColumnOrder(320)
    private RString zenkaikekka_kaigoyobofukushiyogutaiyo;
    @TempTableColumnOrder(321)
    private RString zenkaikekka_tokuteikaigoyobofukushiyoguhanbai;
    @TempTableColumnOrder(322)
    private RString zenkaikekka_jutakukaishu_yobokyufu;
    @TempTableColumnOrder(323)
    private RString zenkaikekka_kaigoyoboninchishotaiogatatsushokaigo;
    @TempTableColumnOrder(324)
    private RString zenkaikekka_kaigoyoboshokibotakinogatakyotakukaigo;
    @TempTableColumnOrder(325)
    private RString zenkaikekka_yoboninshishokaigo_gurupuhomu;
    @TempTableColumnOrder(326)
    private Code zenkaishikibetsukodo;
    @TempTableColumnOrder(327)
    private RString ninteishinsakaiikento;
    @TempTableColumnOrder(328)
    private RString komentoto;
}
