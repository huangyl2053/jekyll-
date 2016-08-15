/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheijunka6tsuchishoikatsuhako;

import java.util.UUID;
import jp.co.ndensan.reams.ca.cax.definition.valueobject.code.ShiharaiHohoCodeValue;
import jp.co.ndensan.reams.ca.cax.definition.valueobject.code.ZennoKubunCodeValue;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaTorokuKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.YokinShubetsuPatternCodeValue;
import jp.co.ndensan.reams.ue.uex.definition.core.RenkeiShubetsu;
import jp.co.ndensan.reams.ue.uex.definition.core.SeibetsuCodeNenkinTokucho;
import jp.co.ndensan.reams.ue.uex.definition.core.TokubetsuChoshuSeidoCode;
import jp.co.ndensan.reams.ue.uex.definition.core.TsuchiNaiyoCode;
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
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.MailAddress;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShogakkokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 介護賦課一時テーブルのエンティティクラスです。
 *
 * @reamsid_L DBB-0820-040 xuyue
 */
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbT2002FukaTempTableEntity extends DbTableEntityBase<DbT2002FukaTempTableEntity> implements IDbAccessable {

    // 「更正後」計算後情報の全項目
    @TempTableColumnOrder(1)
    private RString koseigo_insertDantaiCd;
    @TempTableColumnOrder(2)
    private RDateTime koseigo_insertTimestamp;
    @TempTableColumnOrder(3)
    private RString koseigo_insertReamsLoginId;
    @TempTableColumnOrder(4)
    private UUID koseigo_insertContextId;
    @TempTableColumnOrder(5)
    private boolean koseigo_isDeleted;
    @TempTableColumnOrder(6)
    private int koseigo_updateCount;
    @TempTableColumnOrder(7)
    private RDateTime koseigo_lastUpdateTimestamp;
    @TempTableColumnOrder(8)
    private RString koseigo_lastUpdateReamsLoginId;
    @TempTableColumnOrder(9)
    @PrimaryKey
    private FlexibleYear koseigo_choteiNendo;
    @TempTableColumnOrder(10)
    @PrimaryKey
    private FlexibleYear koseigo_fukaNendo;
    @TempTableColumnOrder(11)
    @PrimaryKey
    private TsuchishoNo koseigo_tsuchishoNo;
    @TempTableColumnOrder(12)
    private RString koseigo_koseiZengoKubun;
    @TempTableColumnOrder(13)
    private RString koseigo_sakuseiShoriName;
    @TempTableColumnOrder(14)
    private int koseigo_fukaRirekiNo;
    @TempTableColumnOrder(15)
    private HihokenshaNo koseigo_hihokenshaNo;
    @TempTableColumnOrder(16)
    private ShikibetsuCode koseigo_shikibetsuCode;
    @TempTableColumnOrder(17)
    private SetaiCode koseigo_setaiCode;
    @TempTableColumnOrder(18)
    private int koseigo_setaiInsu;
    @TempTableColumnOrder(19)
    private FlexibleDate koseigo_shikakuShutokuYMD;
    @TempTableColumnOrder(20)
    private RString koseigo_shikakuShutokuJiyu;
    @TempTableColumnOrder(21)
    private FlexibleDate koseigo_shikakuSoshitsuYMD;
    @TempTableColumnOrder(22)
    private RString koseigo_shikakuSoshitsuJiyu;
    @TempTableColumnOrder(23)
    private RString koseigo_seihofujoShurui;
    @TempTableColumnOrder(24)
    private FlexibleDate koseigo_seihoKaishiYMD;
    @TempTableColumnOrder(25)
    private FlexibleDate koseigo_seihoHaishiYMD;
    @TempTableColumnOrder(26)
    private FlexibleDate koseigo_ronenKaishiYMD;
    @TempTableColumnOrder(27)
    private FlexibleDate koseigo_ronenHaishiYMD;
    @TempTableColumnOrder(28)
    private FlexibleDate koseigo_fukaYMD;
    @TempTableColumnOrder(29)
    private RString koseigo_kazeiKubun;
    @TempTableColumnOrder(30)
    private RString koseigo_setaikazeiKubun;
    @TempTableColumnOrder(31)
    private Decimal koseigo_gokeiShotokuGaku;
    @TempTableColumnOrder(32)
    private Decimal koseigo_nenkinShunyuGaku;
    @TempTableColumnOrder(33)
    private RString koseigo_hokenryoDankai;
    @TempTableColumnOrder(34)
    private RString koseigo_hokenryoDankai1;
    @TempTableColumnOrder(35)
    private Decimal koseigo_nengakuHokenryo1;
    @TempTableColumnOrder(36)
    private FlexibleYearMonth koseigo_tsukiwariStartYM1;
    @TempTableColumnOrder(37)
    private FlexibleYearMonth koseigo_tsukiwariEndYM1;
    @TempTableColumnOrder(38)
    private RString koseigo_hokenryoDankai2;
    @TempTableColumnOrder(39)
    private Decimal koseigo_nengakuHokenryo2;
    @TempTableColumnOrder(40)
    private FlexibleYearMonth koseigo_tsukiwariStartYM2;
    @TempTableColumnOrder(41)
    private FlexibleYearMonth koseigo_tsukiwariEndYM2;
    @TempTableColumnOrder(42)
    private YMDHMS koseigo_choteiNichiji;
    @TempTableColumnOrder(43)
    private RString koseigo_choteiJiyu1;
    @TempTableColumnOrder(44)
    private RString koseigo_choteiJiyu2;
    @TempTableColumnOrder(45)
    private RString koseigo_choteiJiyu3;
    @TempTableColumnOrder(46)
    private RString koseigo_choteiJiyu4;
    @TempTableColumnOrder(47)
    private RString koseigo_koseiM;
    @TempTableColumnOrder(48)
    private Decimal koseigo_gemmenMaeHokenryo;
    @TempTableColumnOrder(49)
    private Decimal koseigo_gemmenGaku;
    @TempTableColumnOrder(50)
    private Decimal koseigo_kakuteiHokenryo;
    @TempTableColumnOrder(51)
    private RString koseigo_hokenryoDankaiKarisanntei;
    @TempTableColumnOrder(52)
    private int koseigo_choshuHohoRirekiNo;
    @TempTableColumnOrder(53)
    private YMDHMS koseigo_idoKijunNichiji;
    @TempTableColumnOrder(54)
    private RString koseigo_kozaKubun;
    @TempTableColumnOrder(55)
    private RString koseigo_kyokaisoKubun;
    @TempTableColumnOrder(56)
    private RString koseigo_shokkenKubun;
    @TempTableColumnOrder(57)
    private LasdecCode koseigo_fukaShichosonCode;
    @TempTableColumnOrder(58)
    private Decimal koseigo_tkSaishutsuKampuGaku;
    @TempTableColumnOrder(59)
    private Decimal koseigo_fuSaishutsuKampuGaku;
    @TempTableColumnOrder(60)
    private Decimal koseigo_tkKibetsuGaku01;
    @TempTableColumnOrder(61)
    private Decimal koseigo_tkKibetsuGaku02;
    @TempTableColumnOrder(62)
    private Decimal koseigo_tkKibetsuGaku03;
    @TempTableColumnOrder(63)
    private Decimal koseigo_tkKibetsuGaku04;
    @TempTableColumnOrder(64)
    private Decimal koseigo_tkKibetsuGaku05;
    @TempTableColumnOrder(65)
    private Decimal koseigo_tkKibetsuGaku06;
    @TempTableColumnOrder(66)
    private Decimal koseigo_fuKibetsuGaku01;
    @TempTableColumnOrder(67)
    private Decimal koseigo_fuKibetsuGaku02;
    @TempTableColumnOrder(68)
    private Decimal koseigo_fuKibetsuGaku03;
    @TempTableColumnOrder(69)
    private Decimal koseigo_fuKibetsuGaku04;
    @TempTableColumnOrder(70)
    private Decimal koseigo_fuKibetsuGaku05;
    @TempTableColumnOrder(71)
    private Decimal koseigo_fuKibetsuGaku06;
    @TempTableColumnOrder(72)
    private Decimal koseigo_fuKibetsuGaku07;
    @TempTableColumnOrder(73)
    private Decimal koseigo_fuKibetsuGaku08;
    @TempTableColumnOrder(74)
    private Decimal koseigo_fuKibetsuGaku09;
    @TempTableColumnOrder(75)
    private Decimal koseigo_fuKibetsuGaku10;
    @TempTableColumnOrder(76)
    private Decimal koseigo_fuKibetsuGaku11;
    @TempTableColumnOrder(77)
    private Decimal koseigo_fuKibetsuGaku12;
    @TempTableColumnOrder(78)
    private Decimal koseigo_fuKibetsuGaku13;
    @TempTableColumnOrder(79)
    private Decimal koseigo_fuKibetsuGaku14;
    @TempTableColumnOrder(80)
    private RString koseigo_choshuHoho4gatsu;
    @TempTableColumnOrder(81)
    private RString koseigo_choshuHoho5gatsu;
    @TempTableColumnOrder(82)
    private RString koseigo_choshuHoho6gatsu;
    @TempTableColumnOrder(83)
    private RString koseigo_choshuHoho7gatsu;
    @TempTableColumnOrder(84)
    private RString koseigo_choshuHoho8gatsu;
    @TempTableColumnOrder(85)
    private RString koseigo_choshuHoho9gatsu;
    @TempTableColumnOrder(86)
    private RString koseigo_choshuHoho10gatsu;
    @TempTableColumnOrder(87)
    private RString koseigo_choshuHoho11gatsu;
    @TempTableColumnOrder(88)
    private RString koseigo_choshuHoho12gatsu;
    @TempTableColumnOrder(89)
    private RString koseigo_choshuHoho1gatsu;
    @TempTableColumnOrder(90)
    private RString koseigo_choshuHoho2gatsu;
    @TempTableColumnOrder(91)
    private RString koseigo_choshuHoho3gatsu;
    @TempTableColumnOrder(92)
    private RString koseigo_choshuHohoYoku4gatsu;
    @TempTableColumnOrder(93)
    private RString koseigo_choshuHohoYoku5gatsu;
    @TempTableColumnOrder(94)
    private RString koseigo_choshuHohoYoku6gatsu;
    @TempTableColumnOrder(95)
    private RString koseigo_choshuHohoYoku7gatsu;
    @TempTableColumnOrder(96)
    private RString koseigo_choshuHohoYoku8gatsu;
    @TempTableColumnOrder(97)
    private RString koseigo_choshuHohoYoku9gatsu;
    @TempTableColumnOrder(98)
    private RString koseigo_kariNenkinNo;
    @TempTableColumnOrder(99)
    private RString koseigo_kariNenkinCode;
    @TempTableColumnOrder(100)
    private RString koseigo_kariHosokuM;
    @TempTableColumnOrder(101)
    private RString koseigo_honNenkinNo;
    @TempTableColumnOrder(102)
    private RString koseigo_honNenkinCode;
    @TempTableColumnOrder(103)
    private RString koseigo_honHosokuM;
    @TempTableColumnOrder(104)
    private RString koseigo_yokunendoKariNenkinNo;
    @TempTableColumnOrder(105)
    private RString koseigo_yokunendoKariNenkinCode;
    @TempTableColumnOrder(106)
    private RString koseigo_yokunendoKariHosokuM;
    @TempTableColumnOrder(107)
    private boolean koseigo_iraiSohuzumiFlag;
    @TempTableColumnOrder(108)
    private boolean koseigo_tsuikaIraiSohuzumiFlag;
    @TempTableColumnOrder(109)
    private YMDHMS koseigo_tokuchoTeishiNichiji;
    @TempTableColumnOrder(110)
    private RString koseigo_tokuchoTeishiJiyuCode;
    @TempTableColumnOrder(111)
    private Decimal koseigo_tkShunyuGaku01;
    @TempTableColumnOrder(112)
    private Decimal koseigo_tkShunyuGaku02;
    @TempTableColumnOrder(113)
    private Decimal koseigo_tkShunyuGaku03;
    @TempTableColumnOrder(114)
    private Decimal koseigo_tkShunyuGaku04;
    @TempTableColumnOrder(115)
    private Decimal koseigo_tkShunyuGaku05;
    @TempTableColumnOrder(116)
    private Decimal koseigo_tkShunyuGaku06;
    @TempTableColumnOrder(117)
    private Decimal koseigo_fuShunyuGaku01;
    @TempTableColumnOrder(118)
    private Decimal koseigo_fuShunyuGaku02;
    @TempTableColumnOrder(119)
    private Decimal koseigo_fuShunyuGaku03;
    @TempTableColumnOrder(120)
    private Decimal koseigo_fuShunyuGaku04;
    @TempTableColumnOrder(121)
    private Decimal koseigo_fuShunyuGaku05;
    @TempTableColumnOrder(122)
    private Decimal koseigo_fuShunyuGaku06;
    @TempTableColumnOrder(123)
    private Decimal koseigo_fuShunyuGaku07;
    @TempTableColumnOrder(124)
    private Decimal koseigo_fuShunyuGaku08;
    @TempTableColumnOrder(125)
    private Decimal koseigo_fuShunyuGaku09;
    @TempTableColumnOrder(126)
    private Decimal koseigo_fuShunyuGaku10;
    @TempTableColumnOrder(127)
    private Decimal koseigo_fuShunyuGaku11;
    @TempTableColumnOrder(128)
    private Decimal koseigo_fuShunyuGaku12;
    @TempTableColumnOrder(129)
    private Decimal koseigo_fuShunyuGaku13;
    @TempTableColumnOrder(130)
    private Decimal koseigo_fuShunyuGaku14;

    // 「更正前」計算後情報の全項目
    @TempTableColumnOrder(131)
    private RString koseimae_insertDantaiCd;
    @TempTableColumnOrder(132)
    private RDateTime koseimae_insertTimestamp;
    @TempTableColumnOrder(133)
    private RString koseimae_insertReamsLoginId;
    @TempTableColumnOrder(134)
    private UUID koseimae_insertContextId;
    @TempTableColumnOrder(135)
    private boolean koseimae_isDeleted;
    @TempTableColumnOrder(136)
    private int koseimae_updateCount;
    @TempTableColumnOrder(137)
    private RDateTime koseimae_lastUpdateTimestamp;
    @TempTableColumnOrder(138)
    private RString koseimae_lastUpdateReamsLoginId;
    @TempTableColumnOrder(139)
    private FlexibleYear koseimae_choteiNendo;
    @TempTableColumnOrder(140)
    private FlexibleYear koseimae_fukaNendo;
    @TempTableColumnOrder(141)
    private TsuchishoNo koseimae_tsuchishoNo;
    @TempTableColumnOrder(142)
    private RString koseimae_koseiZengoKubun;
    @TempTableColumnOrder(143)
    private RString koseimae_sakuseiShoriName;
    @TempTableColumnOrder(144)
    private int koseimae_fukaRirekiNo;
    @TempTableColumnOrder(145)
    private HihokenshaNo koseimae_hihokenshaNo;
    @TempTableColumnOrder(146)
    private ShikibetsuCode koseimae_shikibetsuCode;
    @TempTableColumnOrder(147)
    private SetaiCode koseimae_setaiCode;
    @TempTableColumnOrder(148)
    private int koseimae_setaiInsu;
    @TempTableColumnOrder(149)
    private FlexibleDate koseimae_shikakuShutokuYMD;
    @TempTableColumnOrder(150)
    private RString koseimae_shikakuShutokuJiyu;
    @TempTableColumnOrder(151)
    private FlexibleDate koseimae_shikakuSoshitsuYMD;
    @TempTableColumnOrder(152)
    private RString koseimae_shikakuSoshitsuJiyu;
    @TempTableColumnOrder(153)
    private RString koseimae_seihofujoShurui;
    @TempTableColumnOrder(154)
    private FlexibleDate koseimae_seihoKaishiYMD;
    @TempTableColumnOrder(155)
    private FlexibleDate koseimae_seihoHaishiYMD;
    @TempTableColumnOrder(156)
    private FlexibleDate koseimae_ronenKaishiYMD;
    @TempTableColumnOrder(157)
    private FlexibleDate koseimae_ronenHaishiYMD;
    @TempTableColumnOrder(158)
    private FlexibleDate koseimae_fukaYMD;
    @TempTableColumnOrder(159)
    private RString koseimae_kazeiKubun;
    @TempTableColumnOrder(160)
    private RString koseimae_setaikazeiKubun;
    @TempTableColumnOrder(161)
    private Decimal koseimae_gokeiShotokuGaku;
    @TempTableColumnOrder(162)
    private Decimal koseimae_nenkinShunyuGaku;
    @TempTableColumnOrder(163)
    private RString koseimae_hokenryoDankai;
    @TempTableColumnOrder(164)
    private RString koseimae_hokenryoDankai1;
    @TempTableColumnOrder(165)
    private Decimal koseimae_nengakuHokenryo1;
    @TempTableColumnOrder(166)
    private FlexibleYearMonth koseimae_tsukiwariStartYM1;
    @TempTableColumnOrder(167)
    private FlexibleYearMonth koseimae_tsukiwariEndYM1;
    @TempTableColumnOrder(168)
    private RString koseimae_hokenryoDankai2;
    @TempTableColumnOrder(169)
    private Decimal koseimae_nengakuHokenryo2;
    @TempTableColumnOrder(170)
    private FlexibleYearMonth koseimae_tsukiwariStartYM2;
    @TempTableColumnOrder(171)
    private FlexibleYearMonth koseimae_tsukiwariEndYM2;
    @TempTableColumnOrder(172)
    private YMDHMS koseimae_choteiNichiji;
    @TempTableColumnOrder(173)
    private RString koseimae_choteiJiyu1;
    @TempTableColumnOrder(174)
    private RString koseimae_choteiJiyu2;
    @TempTableColumnOrder(175)
    private RString koseimae_choteiJiyu3;
    @TempTableColumnOrder(176)
    private RString koseimae_choteiJiyu4;
    @TempTableColumnOrder(177)
    private RString koseimae_koseiM;
    @TempTableColumnOrder(178)
    private Decimal koseimae_gemmenMaeHokenryo;
    @TempTableColumnOrder(179)
    private Decimal koseimae_gemmenGaku;
    @TempTableColumnOrder(180)
    private Decimal koseimae_kakuteiHokenryo;
    @TempTableColumnOrder(181)
    private RString koseimae_hokenryoDankaiKarisanntei;
    @TempTableColumnOrder(182)
    private int koseimae_choshuHohoRirekiNo;
    @TempTableColumnOrder(183)
    private YMDHMS koseimae_idoKijunNichiji;
    @TempTableColumnOrder(184)
    private RString koseimae_kozaKubun;
    @TempTableColumnOrder(185)
    private RString koseimae_kyokaisoKubun;
    @TempTableColumnOrder(186)
    private RString koseimae_shokkenKubun;
    @TempTableColumnOrder(187)
    private LasdecCode koseimae_fukaShichosonCode;
    @TempTableColumnOrder(188)
    private Decimal koseimae_tkSaishutsuKampuGaku;
    @TempTableColumnOrder(189)
    private Decimal koseimae_fuSaishutsuKampuGaku;
    @TempTableColumnOrder(190)
    private Decimal koseimae_tkKibetsuGaku01;
    @TempTableColumnOrder(191)
    private Decimal koseimae_tkKibetsuGaku02;
    @TempTableColumnOrder(192)
    private Decimal koseimae_tkKibetsuGaku03;
    @TempTableColumnOrder(193)
    private Decimal koseimae_tkKibetsuGaku04;
    @TempTableColumnOrder(194)
    private Decimal koseimae_tkKibetsuGaku05;
    @TempTableColumnOrder(195)
    private Decimal koseimae_tkKibetsuGaku06;
    @TempTableColumnOrder(196)
    private Decimal koseimae_fuKibetsuGaku01;
    @TempTableColumnOrder(197)
    private Decimal koseimae_fuKibetsuGaku02;
    @TempTableColumnOrder(198)
    private Decimal koseimae_fuKibetsuGaku03;
    @TempTableColumnOrder(199)
    private Decimal koseimae_fuKibetsuGaku04;
    @TempTableColumnOrder(200)
    private Decimal koseimae_fuKibetsuGaku05;
    @TempTableColumnOrder(201)
    private Decimal koseimae_fuKibetsuGaku06;
    @TempTableColumnOrder(202)
    private Decimal koseimae_fuKibetsuGaku07;
    @TempTableColumnOrder(203)
    private Decimal koseimae_fuKibetsuGaku08;
    @TempTableColumnOrder(204)
    private Decimal koseimae_fuKibetsuGaku09;
    @TempTableColumnOrder(205)
    private Decimal koseimae_fuKibetsuGaku10;
    @TempTableColumnOrder(206)
    private Decimal koseimae_fuKibetsuGaku11;
    @TempTableColumnOrder(207)
    private Decimal koseimae_fuKibetsuGaku12;
    @TempTableColumnOrder(208)
    private Decimal koseimae_fuKibetsuGaku13;
    @TempTableColumnOrder(209)
    private Decimal koseimae_fuKibetsuGaku14;
    @TempTableColumnOrder(210)
    private RString koseimae_choshuHoho4gatsu;
    @TempTableColumnOrder(211)
    private RString koseimae_choshuHoho5gatsu;
    @TempTableColumnOrder(212)
    private RString koseimae_choshuHoho6gatsu;
    @TempTableColumnOrder(213)
    private RString koseimae_choshuHoho7gatsu;
    @TempTableColumnOrder(214)
    private RString koseimae_choshuHoho8gatsu;
    @TempTableColumnOrder(215)
    private RString koseimae_choshuHoho9gatsu;
    @TempTableColumnOrder(216)
    private RString koseimae_choshuHoho10gatsu;
    @TempTableColumnOrder(217)
    private RString koseimae_choshuHoho11gatsu;
    @TempTableColumnOrder(218)
    private RString koseimae_choshuHoho12gatsu;
    @TempTableColumnOrder(219)
    private RString koseimae_choshuHoho1gatsu;
    @TempTableColumnOrder(220)
    private RString koseimae_choshuHoho2gatsu;
    @TempTableColumnOrder(221)
    private RString koseimae_choshuHoho3gatsu;
    @TempTableColumnOrder(222)
    private RString koseimae_choshuHohoYoku4gatsu;
    @TempTableColumnOrder(223)
    private RString koseimae_choshuHohoYoku5gatsu;
    @TempTableColumnOrder(224)
    private RString koseimae_choshuHohoYoku6gatsu;
    @TempTableColumnOrder(225)
    private RString koseimae_choshuHohoYoku7gatsu;
    @TempTableColumnOrder(226)
    private RString koseimae_choshuHohoYoku8gatsu;
    @TempTableColumnOrder(227)
    private RString koseimae_choshuHohoYoku9gatsu;
    @TempTableColumnOrder(228)
    private RString koseimae_kariNenkinNo;
    @TempTableColumnOrder(229)
    private RString koseimae_kariNenkinCode;
    @TempTableColumnOrder(230)
    private RString koseimae_kariHosokuM;
    @TempTableColumnOrder(231)
    private RString koseimae_honNenkinNo;
    @TempTableColumnOrder(232)
    private RString koseimae_honNenkinCode;
    @TempTableColumnOrder(233)
    private RString koseimae_honHosokuM;
    @TempTableColumnOrder(234)
    private RString koseimae_yokunendoKariNenkinNo;
    @TempTableColumnOrder(235)
    private RString koseimae_yokunendoKariNenkinCode;
    @TempTableColumnOrder(236)
    private RString koseimae_yokunendoKariHosokuM;
    @TempTableColumnOrder(237)
    private boolean koseimae_iraiSohuzumiFlag;
    @TempTableColumnOrder(238)
    private boolean koseimae_tsuikaIraiSohuzumiFlag;
    @TempTableColumnOrder(239)
    private YMDHMS koseimae_tokuchoTeishiNichiji;
    @TempTableColumnOrder(240)
    private RString koseimae_tokuchoTeishiJiyuCode;
    @TempTableColumnOrder(241)
    private Decimal koseimae_tkShunyuGaku01;
    @TempTableColumnOrder(242)
    private Decimal koseimae_tkShunyuGaku02;
    @TempTableColumnOrder(243)
    private Decimal koseimae_tkShunyuGaku03;
    @TempTableColumnOrder(244)
    private Decimal koseimae_tkShunyuGaku04;
    @TempTableColumnOrder(245)
    private Decimal koseimae_tkShunyuGaku05;
    @TempTableColumnOrder(246)
    private Decimal koseimae_tkShunyuGaku06;
    @TempTableColumnOrder(247)
    private Decimal koseimae_fuShunyuGaku01;
    @TempTableColumnOrder(248)
    private Decimal koseimae_fuShunyuGaku02;
    @TempTableColumnOrder(249)
    private Decimal koseimae_fuShunyuGaku03;
    @TempTableColumnOrder(250)
    private Decimal koseimae_fuShunyuGaku04;
    @TempTableColumnOrder(251)
    private Decimal koseimae_fuShunyuGaku05;
    @TempTableColumnOrder(252)
    private Decimal koseimae_fuShunyuGaku06;
    @TempTableColumnOrder(253)
    private Decimal koseimae_fuShunyuGaku07;
    @TempTableColumnOrder(254)
    private Decimal koseimae_fuShunyuGaku08;
    @TempTableColumnOrder(255)
    private Decimal koseimae_fuShunyuGaku09;
    @TempTableColumnOrder(256)
    private Decimal koseimae_fuShunyuGaku10;
    @TempTableColumnOrder(257)
    private Decimal koseimae_fuShunyuGaku11;
    @TempTableColumnOrder(258)
    private Decimal koseimae_fuShunyuGaku12;
    @TempTableColumnOrder(259)
    private Decimal koseimae_fuShunyuGaku13;
    @TempTableColumnOrder(260)
    private Decimal koseimae_fuShunyuGaku14;

    // 宛名情報の全項目
    @TempTableColumnOrder(261)
    private ShikibetsuCode atena_shikibetsuCode;
    @TempTableColumnOrder(262)
    private LasdecCode atena_genLasdecCode;
    @TempTableColumnOrder(263)
    private LasdecCode atena_kyuLasdecCode;
    @TempTableColumnOrder(264)
    private int atena_kyuLasdecCodeRenban;
    @TempTableColumnOrder(265)
    private GyomuCode atena_gyomuCode;
    @TempTableColumnOrder(266)
    private int atena_rirekiNo;
    @TempTableColumnOrder(267)
    private boolean atena_currentFlag;
    @TempTableColumnOrder(268)
    private RString atena_juminShubetsuCode;
    @TempTableColumnOrder(269)
    private KojinNo atena_kojinNo;
    @TempTableColumnOrder(270)
    private HojinNo atena_hojinNo;
    @TempTableColumnOrder(271)
    private FlexibleDate atena_shoriYMD;
    @TempTableColumnOrder(272)
    private RString atena_idoJiyuCode;
    @TempTableColumnOrder(273)
    private FlexibleDate atena_idoYMD;
    @TempTableColumnOrder(274)
    private RString atena_todokedeJiyuCode;
    @TempTableColumnOrder(275)
    private FlexibleDate atena_todokedeYMD;
    @TempTableColumnOrder(276)
    private Code atena_idoRiyuCode;
    @TempTableColumnOrder(277)
    private AtenaMeisho atena_meisho;
    @TempTableColumnOrder(278)
    private AtenaKanaMeisho atena_kanaMeisho;
    @TempTableColumnOrder(279)
    private RString atena_kannaiKangaiKubun;
    @TempTableColumnOrder(280)
    private YubinNo atena_yubinNo;
    @TempTableColumnOrder(281)
    private ChoikiCode atena_choikiCode;
    @TempTableColumnOrder(282)
    private ZenkokuJushoCode atena_zenkokuJushoCode;
    @TempTableColumnOrder(283)
    private AtenaJusho atena_jusho;
    @TempTableColumnOrder(284)
    private BanchiCode atena_banchiCode1;
    @TempTableColumnOrder(285)
    private BanchiCode atena_banchiCode2;
    @TempTableColumnOrder(286)
    private BanchiCode atena_banchiCode3;
    @TempTableColumnOrder(287)
    private BanchiCode atena_banchiCode4;
    @TempTableColumnOrder(288)
    private AtenaBanchi atena_banchi;
    @TempTableColumnOrder(289)
    private Katagaki atena_katagaki;
    @TempTableColumnOrder(290)
    private boolean atena_katagakiInjiFlag;
    @TempTableColumnOrder(291)
    private GyoseikuCode atena_gyoseikuCode;
    @TempTableColumnOrder(292)
    private RString atena_gyoseikuName;
    @TempTableColumnOrder(293)
    private ChikuCode atena_chikuCode1;
    @TempTableColumnOrder(294)
    private RString atena_chikuName1;
    @TempTableColumnOrder(295)
    private ChikuCode atena_chikuCode2;
    @TempTableColumnOrder(296)
    private RString atena_chikuName2;
    @TempTableColumnOrder(297)
    private ChikuCode atena_chikuCode3;
    @TempTableColumnOrder(298)
    private RString atena_chikuName3;
    @TempTableColumnOrder(299)
    private ShogakkokuCode atena_shogakkokuCode;
    @TempTableColumnOrder(300)
    private RString atena_shogakkokuName;
    @TempTableColumnOrder(301)
    private ChugakkokuCode atena_chugakkokuCode;
    @TempTableColumnOrder(302)
    private RString atena_chugakkokuName;
    @TempTableColumnOrder(303)
    private TohyokuCode atena_tohyokuCode;
    @TempTableColumnOrder(304)
    private RString atena_tohyokuName;
    @TempTableColumnOrder(305)
    private RString atena_juminJotaiCode;
    @TempTableColumnOrder(306)
    private SetaiCode atena_setaiCode;
    @TempTableColumnOrder(307)
    private FlexibleDate atena_seinengappiYMD;
    @TempTableColumnOrder(308)
    private RString atena_seinengappiFushoKubun;
    @TempTableColumnOrder(309)
    private RString atena_seibetsuCode;
    @TempTableColumnOrder(310)
    private TsuzukigaraCode atena_tsuzukigaraCode;
    @TempTableColumnOrder(311)
    private RString atena_tsuzukigara;
    @TempTableColumnOrder(312)
    private int atena_kazokuNo;
    @TempTableColumnOrder(313)
    private int atena_juminhyoHyojijun;
    @TempTableColumnOrder(314)
    private FlexibleDate atena_kikaYMD;
    @TempTableColumnOrder(315)
    private AtenaMeisho atena_kanjiShimei;
    @TempTableColumnOrder(316)
    private AtenaKanaMeisho atena_kanaShimei;
    @TempTableColumnOrder(317)
    private ZenkokuJushoCode atena_honsekiZenkokuJushoCode;
    @TempTableColumnOrder(318)
    private ChoikiCode atena_honsekiChoikiCode;
    @TempTableColumnOrder(319)
    private AtenaJusho atena_honsekiJusho;
    @TempTableColumnOrder(320)
    private AtenaBanchi atena_honsekiBanchi;
    @TempTableColumnOrder(321)
    private AtenaMeisho atena_hittosha;
    @TempTableColumnOrder(322)
    private AtenaMeisho atena_gaikokujinShimei;
    @TempTableColumnOrder(323)
    private AtenaMeisho atena_gaikokujinHeikimei;
    @TempTableColumnOrder(324)
    private AtenaKanaMeisho atena_gaikokujinKanaShimei;
    @TempTableColumnOrder(325)
    private AtenaMeisho atena_tsushomei;
    @TempTableColumnOrder(326)
    private RString atena_shimeiRiyoKubun;
    @TempTableColumnOrder(327)
    private AtenaKanaMeisho atena_kanaTsushomei;
    @TempTableColumnOrder(328)
    private AtenaKanaMeisho atena_katakanaHyoki;
    @TempTableColumnOrder(329)
    private Code atena_kokusekiChiikiCode;
    @TempTableColumnOrder(330)
    private Code atena_zairyuShikakuCode;
    @TempTableColumnOrder(331)
    private RString atena_zairyuKikanCode;
    @TempTableColumnOrder(332)
    private FlexibleDate atena_zairyuKikantoManryoYMD;
    @TempTableColumnOrder(333)
    private RString atena_zairyuCardtoNo;
    @TempTableColumnOrder(334)
    private FlexibleDate atena_zairyuCardtoYukoYMD;
    @TempTableColumnOrder(335)
    private RString atena_dai30Jono45niKiteisuruKubun;
    @TempTableColumnOrder(336)
    private ShikibetsuCode atena_setainushiShikibetsuCode;
    @TempTableColumnOrder(337)
    private AtenaMeisho atena_setainushiMei;
    @TempTableColumnOrder(338)
    private Code atena_hojinKeitaiCode;
    @TempTableColumnOrder(339)
    private RString atena_hojinKeitaiMeisho;
    @TempTableColumnOrder(340)
    private RString atena_hojinKeitaiRyakusho;
    @TempTableColumnOrder(341)
    private RString atena_hojinMeishoHenshuKubun;
    @TempTableColumnOrder(342)
    private RString atena_hojinKeitaiRyakushoKubun;
    @TempTableColumnOrder(343)
    private AtenaMeisho atena_hojinMeisho;
    @TempTableColumnOrder(344)
    private AtenaKanaMeisho atena_hojinKanaMeisho;
    @TempTableColumnOrder(345)
    private AtenaMeisho atena_hojinShitenMeisho;
    @TempTableColumnOrder(346)
    private AtenaKanaMeisho atena_hojinShitenKanaMeisho;
    @TempTableColumnOrder(347)
    private ShikibetsuCode atena_daihyoshaShikibetsuCode;
    @TempTableColumnOrder(348)
    private RString atena_daihyoshaJuminShubetsu;
    @TempTableColumnOrder(349)
    private AtenaMeisho atena_daihyoshaShimei;
    @TempTableColumnOrder(350)
    private AtenaKanaMeisho atena_daihyoshaKanaShimei;
    @TempTableColumnOrder(351)
    private AtenaMeisho atena_daihyoshaNihonjinShimei;
    @TempTableColumnOrder(352)
    private AtenaKanaMeisho atena_daihyoshaNihonjinKanaShimei;
    @TempTableColumnOrder(353)
    private AtenaMeisho atena_daihyoshaGaikokujinShimei;
    @TempTableColumnOrder(354)
    private AtenaMeisho atena_daihyoshaGaikokujinHeikimei;
    @TempTableColumnOrder(355)
    private AtenaKanaMeisho atena_daihyoshaGaikokujinKanaShimei;
    @TempTableColumnOrder(356)
    private AtenaMeisho atena_daihyoshaTsushomei;
    @TempTableColumnOrder(357)
    private RString atena_daihyoshaShimeiRiyoKubun;
    @TempTableColumnOrder(358)
    private AtenaKanaMeisho atena_daihyoshaKanaTsushomei;
    @TempTableColumnOrder(359)
    private RString atena_daihyoshaKannaiKangaiKubun;
    @TempTableColumnOrder(360)
    private YubinNo atena_daihyoshaYubinNo;
    @TempTableColumnOrder(361)
    private ChoikiCode atena_daihyoshaChoikiCode;
    @TempTableColumnOrder(362)
    private ZenkokuJushoCode atena_daihyoshaZenkokuJushoCode;
    @TempTableColumnOrder(363)
    private AtenaJusho atena_daihyoshaJusho;
    @TempTableColumnOrder(364)
    private BanchiCode atena_daihyoshaBanchiCode1;
    @TempTableColumnOrder(365)
    private BanchiCode atena_daihyoshaBanchiCode2;
    @TempTableColumnOrder(366)
    private BanchiCode atena_daihyoshaBanchiCode3;
    @TempTableColumnOrder(367)
    private BanchiCode atena_daihyoshaBanchiCode4;
    @TempTableColumnOrder(368)
    private AtenaBanchi atena_daihyoshaBanchi;
    @TempTableColumnOrder(369)
    private Katagaki atena_daihyoshaKatagaki;
    @TempTableColumnOrder(370)
    private Code atena_ninkachiendantaiTorokuShikakuKubun;
    @TempTableColumnOrder(371)
    private FlexibleDate atena_ninkachiendantaiNinkaYMD;
    @TempTableColumnOrder(372)
    private RString atena_kojinHojinKBN;
    @TempTableColumnOrder(373)
    private AtenaMeisho atena_kyoyushaMeisho;
    @TempTableColumnOrder(374)
    private AtenaKanaMeisho atena_kyoyushaKanaMeisho;
    @TempTableColumnOrder(375)
    private RString atena_torokuJiyuCode;
    @TempTableColumnOrder(376)
    private FlexibleDate atena_torokuIdoYMD;
    @TempTableColumnOrder(377)
    private FlexibleDate atena_torokuTodokedeYMD;
    @TempTableColumnOrder(378)
    private RString atena_juteiJiyuCode;
    @TempTableColumnOrder(379)
    private FlexibleDate atena_juteiIdoYMD;
    @TempTableColumnOrder(380)
    private FlexibleDate atena_juteiTodokedeYMD;
    @TempTableColumnOrder(381)
    private RString atena_shojoJiyuCode;
    @TempTableColumnOrder(382)
    private FlexibleDate atena_shojoIdoYMD;
    @TempTableColumnOrder(383)
    private FlexibleDate atena_shojoTodokedeYMD;
    @TempTableColumnOrder(384)
    private YubinNo atena_jutonaiYubinNo;
    @TempTableColumnOrder(385)
    private ChoikiCode atena_jutonaiChoikiCode;
    @TempTableColumnOrder(386)
    private RString atena_jutonaiJusho;
    @TempTableColumnOrder(387)
    private BanchiCode atena_jutonaiBanchiCode1;
    @TempTableColumnOrder(388)
    private BanchiCode atena_jutonaiBanchiCode2;
    @TempTableColumnOrder(389)
    private BanchiCode atena_jutonaiBanchiCode3;
    @TempTableColumnOrder(390)
    private BanchiCode atena_jutonaiBanchiCode4;
    @TempTableColumnOrder(391)
    private AtenaBanchi atena_jutonaiBanchi;
    @TempTableColumnOrder(392)
    private Katagaki atena_jutonaiKatagaki;
    @TempTableColumnOrder(393)
    private boolean atena_jutonaiKatagakiInjiFlag;
    @TempTableColumnOrder(394)
    private YubinNo atena_tennyumaeYubinNo;
    @TempTableColumnOrder(395)
    private ZenkokuJushoCode atena_tennyumaeZenkokuJushoCode;
    @TempTableColumnOrder(396)
    private AtenaJusho atena_tennyumaeJusho;
    @TempTableColumnOrder(397)
    private AtenaBanchi atena_tennyumaeBanchi;
    @TempTableColumnOrder(398)
    private Katagaki atena_tennyumaeKatagaki;
    @TempTableColumnOrder(399)
    private RString atena_tennyumaeSetainushimei;
    @TempTableColumnOrder(400)
    private AtenaMeisho atena_tennyumaeKyusei;
    @TempTableColumnOrder(401)
    private YubinNo atena_saishuJutochiYubinNo;
    @TempTableColumnOrder(402)
    private ZenkokuJushoCode atena_saishuJutochiZenkokuJushoCode;
    @TempTableColumnOrder(403)
    private AtenaJusho atena_saishuJutochiJusho;
    @TempTableColumnOrder(404)
    private AtenaBanchi atena_saishuJutochiBanchi;
    @TempTableColumnOrder(405)
    private Katagaki atena_saishuJutochiKatagaki;
    @TempTableColumnOrder(406)
    private RString atena_saishuJutochiSetainushimei;
    @TempTableColumnOrder(407)
    private FlexibleDate atena_tenshutsuYoteiIdoYMD;
    @TempTableColumnOrder(408)
    private YubinNo atena_tenshutsuYoteiYubinNo;
    @TempTableColumnOrder(409)
    private ZenkokuJushoCode atena_tenshutsuYoteiZenkokuJushoCode;
    @TempTableColumnOrder(410)
    private AtenaJusho atena_tenshutsuYoteiJusho;
    @TempTableColumnOrder(411)
    private AtenaBanchi atena_tenshutsuYoteiBanchi;
    @TempTableColumnOrder(412)
    private Katagaki atena_tenshutsuYoteiKatagaki;
    @TempTableColumnOrder(413)
    private RString atena_tenshutsuYoteiSetainushimei;
    @TempTableColumnOrder(414)
    private FlexibleDate atena_tenshutsuKakuteiIdoYMD;
    @TempTableColumnOrder(415)
    private FlexibleDate atena_tenshutsuKakuteiTsuchiYMD;
    @TempTableColumnOrder(416)
    private YubinNo atena_tenshutsuKakuteiYubinNo;
    @TempTableColumnOrder(417)
    private ZenkokuJushoCode atena_tenshutsuKakuteiZenkokuJushoCode;
    @TempTableColumnOrder(418)
    private AtenaJusho atena_tenshutsuKakuteiJusho;
    @TempTableColumnOrder(419)
    private AtenaBanchi atena_tenshutsuKakuteiBanchi;
    @TempTableColumnOrder(420)
    private Katagaki atena_tenshutsuKakuteiKatagaki;
    @TempTableColumnOrder(421)
    private RString atena_tenshutsuKakuteiSetainushimei;
    @TempTableColumnOrder(422)
    private RString atena_juminhyoUtsushiHakkoSeigyoKubun;
    @TempTableColumnOrder(423)
    private TelNo atena_renrakusaki1;
    @TempTableColumnOrder(424)
    private TelNo atena_kensakuRenrakusaki1;
    @TempTableColumnOrder(425)
    private Code atena_renrakusakiKubun1;
    @TempTableColumnOrder(426)
    private TelNo atena_renrakusaki2;
    @TempTableColumnOrder(427)
    private TelNo atena_kensakuRenrakusaki2;
    @TempTableColumnOrder(428)
    private Code atena_renrakusakiKubun2;
    @TempTableColumnOrder(429)
    private TelNo atena_renrakusaki3;
    @TempTableColumnOrder(430)
    private TelNo atena_kensakuRenrakusaki3;
    @TempTableColumnOrder(431)
    private Code atena_renrakusakiKubun3;
    @TempTableColumnOrder(432)
    private MailAddress atena_mailAddress;
    @TempTableColumnOrder(433)
    private RString atena_biko;
    @TempTableColumnOrder(434)
    private RString atena_kanaName;
    @TempTableColumnOrder(435)
    private RString atena_gaikokujinKanaName;
    @TempTableColumnOrder(436)
    private RString atena_kanaTsushoName;
    @TempTableColumnOrder(437)
    private RDateTime atena_lastUpdateTimestamp;
    @TempTableColumnOrder(438)
    private RString atena_lastUpdateReamsLoginId;
    @TempTableColumnOrder(439)
    private int atena_jutogaiKanriUpdateCount;
    @TempTableColumnOrder(440)
    private TorokuNo atena_jutogaiKanriTorokuNo;
    @TempTableColumnOrder(441)
    private int atena_jutogaiKojinKihonUpdateCount;
    @TempTableColumnOrder(442)
    private TorokuNo atena_jutogaiKojinKihonTorokuNo;
    @TempTableColumnOrder(443)
    private int atena_jutogaiNihonjinUpdateCount;
    @TempTableColumnOrder(444)
    private TorokuNo atena_jutogaiNihonjinTorokuNo;
    @TempTableColumnOrder(445)
    private int atena_jutogaiGaikokujinUpdateCount;
    @TempTableColumnOrder(446)
    private TorokuNo atena_jutogaiGaikokujinTorokuNo;
    @TempTableColumnOrder(447)
    private int atena_hojinUpdateCount;
    @TempTableColumnOrder(448)
    private TorokuNo atena_hojinTorokuNo;
    @TempTableColumnOrder(449)
    private int atena_kyoyushaUpdateCount;
    @TempTableColumnOrder(450)
    private TorokuNo atena_kyoyushaTorokuNo;
    @TempTableColumnOrder(451)
    private TorokuNo atena_shimeiSearchTorokuNo;
    @TempTableColumnOrder(452)
    private int atena_yusenShimeiUpdateCount;
    @TempTableColumnOrder(453)
    private RDateTime atena_yusenShimeiTimestamp;

    // 宛先情報の全項目
    @TempTableColumnOrder(454)
    private ShikibetsuCode atesaki_shikibetsuCode;
    @TempTableColumnOrder(455)
    private RString atesaki_atesakiShubetsu;
    @TempTableColumnOrder(456)
    private RString atesaki_gyomubetsuPrimaryKey;
    @TempTableColumnOrder(457)
    private GyomuCode atesaki_gyomuCode;
    @TempTableColumnOrder(458)
    private SubGyomuCode atesaki_subGyomuCode;
    @TempTableColumnOrder(459)
    private RString atesaki_gyomuGroupCode;
    @TempTableColumnOrder(460)
    private RString atesaki_gyomuGroupName;
    @TempTableColumnOrder(461)
    private RString atesaki_subGyomuGroupCode;
    @TempTableColumnOrder(462)
    private RString atesaki_subGyomuGroupName;
    @TempTableColumnOrder(463)
    private KamokuCode atesaki_kamokuCode;
    @TempTableColumnOrder(464)
    private RString atesaki_gyomuKoyuKey;
    @TempTableColumnOrder(465)
    private RString atesaki_kannaiKangaiKubun;
    @TempTableColumnOrder(466)
    private ZenkokuJushoCode atesaki_zenkokuJushoCode;
    @TempTableColumnOrder(467)
    private ChoikiCode atesaki_choikiCode;
    @TempTableColumnOrder(468)
    private AtenaJusho atesaki_jusho;
    @TempTableColumnOrder(469)
    private YubinNo atesaki_yubinNo;
    @TempTableColumnOrder(470)
    private BanchiCode atesaki_banchiCode1;
    @TempTableColumnOrder(471)
    private BanchiCode atesaki_banchiCode2;
    @TempTableColumnOrder(472)
    private BanchiCode atesaki_banchiCode3;
    @TempTableColumnOrder(473)
    private BanchiCode atesaki_banchiCode4;
    @TempTableColumnOrder(474)
    private AtenaBanchi atesaki_banchi;
    @TempTableColumnOrder(475)
    private boolean atesaki_katagakiInjiFlag;
    @TempTableColumnOrder(476)
    private Katagaki atesaki_katagaki;
    @TempTableColumnOrder(477)
    private GyoseikuCode atesaki_gyoseikuCode;
    @TempTableColumnOrder(478)
    private RString atesaki_gyoseiku;
    @TempTableColumnOrder(479)
    private ChikuCode atesaki_chikuCode1;
    @TempTableColumnOrder(480)
    private RString atesaki_chiku1;
    @TempTableColumnOrder(481)
    private ChikuCode atesaki_chikuCode2;
    @TempTableColumnOrder(482)
    private RString atesaki_chiku2;
    @TempTableColumnOrder(483)
    private ChikuCode atesaki_chikuCode3;
    @TempTableColumnOrder(484)
    private RString atesaki_chiku3;
    @TempTableColumnOrder(485)
    private RString atesaki_juminShubetsuCode;
    @TempTableColumnOrder(486)
    private RString atesaki_juminJotaiCode;
    @TempTableColumnOrder(487)
    private AtenaMeisho atesaki_kanjiShimei;
    @TempTableColumnOrder(488)
    private AtenaKanaMeisho atesaki_kanaShimei;
    @TempTableColumnOrder(489)
    private AtenaMeisho atesaki_gaikokujinShimei;
    @TempTableColumnOrder(490)
    private AtenaMeisho atesaki_gaikokujinHeikimei;
    @TempTableColumnOrder(491)
    private AtenaKanaMeisho atesaki_gaikokujinKanaShimei;
    @TempTableColumnOrder(492)
    private AtenaMeisho atesaki_tsushomei;
    @TempTableColumnOrder(493)
    private AtenaKanaMeisho atesaki_kanaTsushomei;
    @TempTableColumnOrder(494)
    private RString atesaki_shimeiRiyoKubun;
    @TempTableColumnOrder(495)
    private AtenaMeisho atesaki_kyoyushaMeisho;
    @TempTableColumnOrder(496)
    private AtenaKanaMeisho atesaki_kyoyushaKanaMeisho;
    @TempTableColumnOrder(497)
    private Code atesaki_hojinKeitaiCode;
    @TempTableColumnOrder(498)
    private RString atesaki_hojinMeiHenshuKubun;
    @TempTableColumnOrder(499)
    private RString atesaki_hojinKeitaiRyakushoKubun;
    @TempTableColumnOrder(500)
    private AtenaMeisho atesaki_hojinMeisho;
    @TempTableColumnOrder(501)
    private AtenaKanaMeisho atesaki_hojinKanaMeisho;
    @TempTableColumnOrder(502)
    private AtenaMeisho atesaki_hojinShitenMeisho;
    @TempTableColumnOrder(503)
    private AtenaKanaMeisho atesaki_hojinShitenKanaMeisho;
    @TempTableColumnOrder(504)
    private AtenaMeisho atesaki_sofusakiMeisho;
    @TempTableColumnOrder(505)
    private AtenaKanaMeisho atesaki_sofusakiKanaMeisho;
    @TempTableColumnOrder(506)
    private TelNo atesaki_renrakusaki1;
    @TempTableColumnOrder(507)
    private Code atesaki_renrakusakiKubun1;
    @TempTableColumnOrder(508)
    private TelNo atesaki_renrakusaki2;
    @TempTableColumnOrder(509)
    private Code atesaki_renrakusakiKubun2;
    @TempTableColumnOrder(510)
    private TelNo atesaki_renrakusaki3;
    @TempTableColumnOrder(511)
    private Code atesaki_renrakusakiKubun3;
    @TempTableColumnOrder(512)
    private MailAddress atesaki_mailAddress;
    @TempTableColumnOrder(513)
    private Code atesaki_dainoKankeiCode;
    @TempTableColumnOrder(514)
    private RString atesaki_biko;
    @TempTableColumnOrder(515)
    private RString atesaki_honninJuminShubetsuCode;
    @TempTableColumnOrder(516)
    private RString atesaki_honninJuminJotaiCode;
    @TempTableColumnOrder(517)
    private AtenaMeisho atesaki_honninKanjiShimei;
    @TempTableColumnOrder(518)
    private AtenaKanaMeisho atesaki_honninKanaShimei;
    @TempTableColumnOrder(519)
    private AtenaMeisho atesaki_honninGaikokujinShimei;
    @TempTableColumnOrder(520)
    private AtenaMeisho atesaki_honninGaikokujinHeikimei;
    @TempTableColumnOrder(521)
    private AtenaKanaMeisho atesaki_honninGaikokujinKanaShimei;
    @TempTableColumnOrder(522)
    private AtenaMeisho atesaki_honninTsushomei;
    @TempTableColumnOrder(523)
    private AtenaKanaMeisho atesaki_honninKanaTsushomei;
    @TempTableColumnOrder(524)
    private RString atesaki_honninShimeiRiyoKubun;
    @TempTableColumnOrder(525)
    private AtenaMeisho atesaki_honninKyoyushaMeisho;
    @TempTableColumnOrder(526)
    private AtenaKanaMeisho atesaki_honninKyoyushaKanaMeisho;
    @TempTableColumnOrder(527)
    private Code atesaki_honninHojinKeitaiCode;
    @TempTableColumnOrder(528)
    private RString atesaki_honninHojinMeiHenshuKubun;
    @TempTableColumnOrder(529)
    private RString atesaki_honninHojinKeitaiRyakushoKubun;
    @TempTableColumnOrder(530)
    private AtenaMeisho atesaki_honninHojinMeisho;
    @TempTableColumnOrder(531)
    private AtenaKanaMeisho atesaki_honninHojinKanaMeisho;
    @TempTableColumnOrder(532)
    private AtenaMeisho atesaki_honninHojinShitenMeisho;
    @TempTableColumnOrder(533)
    private AtenaKanaMeisho atesaki_honninHojinShitenKanaMeisho;
    @TempTableColumnOrder(534)
    private ShikibetsuCode atesaki_honninDaihyoshaShikibetsuCode;
    @TempTableColumnOrder(535)
    private RString atesaki_honninDaihyoshaJuminShubetsuCode;
    @TempTableColumnOrder(536)
    private AtenaMeisho atesaki_honninDaihyoshaShimei;
    @TempTableColumnOrder(537)
    private AtenaKanaMeisho atesaki_honninDaihyoshaKanaShimei;
    @TempTableColumnOrder(538)
    private AtenaMeisho atesaki_honninDaihyoshaNihonjinShimei;
    @TempTableColumnOrder(539)
    private AtenaKanaMeisho atesaki_honninDaihyoshaNihonjinKanaShimei;
    @TempTableColumnOrder(540)
    private AtenaMeisho atesaki_honninDaihyoshaGaikokujinShimei;
    @TempTableColumnOrder(541)
    private AtenaMeisho atesaki_honninDaihyoshaGaikokujinHeikimei;
    @TempTableColumnOrder(542)
    private AtenaKanaMeisho atesaki_honninDaihyoshaGaikokujinKanaShimei;
    @TempTableColumnOrder(543)
    private AtenaMeisho atesaki_honninDaihyoshaTsushomei;
    @TempTableColumnOrder(544)
    private RString atesaki_honninDaihyoshaShimeiRiyoKubun;
    @TempTableColumnOrder(545)
    private AtenaKanaMeisho atesaki_honninDaihyoshaKanaTsushomei;
    @TempTableColumnOrder(546)
    private ShikibetsuCode atesaki_setainushiShikibetsuCode;
    @TempTableColumnOrder(547)
    private RString atesaki_setainushiKannaiKangaiKubun;
    @TempTableColumnOrder(548)
    private ZenkokuJushoCode atesaki_setainushiZenkokuJushoCode;
    @TempTableColumnOrder(549)
    private ChoikiCode atesaki_setainushiChoikiCode;
    @TempTableColumnOrder(550)
    private AtenaJusho atesaki_setainushiJusho;
    @TempTableColumnOrder(551)
    private YubinNo atesaki_setainushiYubinNo;
    @TempTableColumnOrder(552)
    private BanchiCode atesaki_setainushiBanchiCode1;
    @TempTableColumnOrder(553)
    private BanchiCode atesaki_setainushiBanchiCode2;
    @TempTableColumnOrder(554)
    private BanchiCode atesaki_setainushiBanchiCode3;
    @TempTableColumnOrder(555)
    private BanchiCode atesaki_setainushiBanchiCode4;
    @TempTableColumnOrder(556)
    private AtenaBanchi atesaki_setainushiBanchi;
    @TempTableColumnOrder(557)
    private boolean atesaki_setainushiKatagakiInjiFlag;
    @TempTableColumnOrder(558)
    private Katagaki atesaki_setainushiKatagaki;
    @TempTableColumnOrder(559)
    private GyoseikuCode atesaki_setainushiGyoseikuCode;
    @TempTableColumnOrder(560)
    private RString atesaki_setainushiGyoseikuName;
    @TempTableColumnOrder(561)
    private ChikuCode atesaki_setainushiChikuCode1;
    @TempTableColumnOrder(562)
    private RString atesaki_setainushiChiku1;
    @TempTableColumnOrder(563)
    private ChikuCode atesaki_setainushiChikuCode2;
    @TempTableColumnOrder(564)
    private RString atesaki_setainushiChiku2;
    @TempTableColumnOrder(565)
    private ChikuCode atesaki_setainushiChikuCode3;
    @TempTableColumnOrder(566)
    private RString atesaki_setainushiChiku3;
    @TempTableColumnOrder(567)
    private RString atesaki_setainushiJuminShubetsuCode;
    @TempTableColumnOrder(568)
    private RString atesaki_setainushiJuminJotaiCode;
    @TempTableColumnOrder(569)
    private AtenaMeisho atesaki_setainushiKanjiShimei;
    @TempTableColumnOrder(570)
    private AtenaKanaMeisho atesaki_setainushiKanaShimei;
    @TempTableColumnOrder(571)
    private AtenaMeisho atesaki_setainushiGaikokujinShimei;
    @TempTableColumnOrder(572)
    private AtenaMeisho atesaki_setainushiGaikokujinHeikimei;
    @TempTableColumnOrder(573)
    private AtenaKanaMeisho atesaki_setainushiGaikokujinKanaShimei;
    @TempTableColumnOrder(574)
    private AtenaMeisho atesaki_setainushiTsushomei;
    @TempTableColumnOrder(575)
    private AtenaKanaMeisho atesaki_setainushiKanaTsushomei;
    @TempTableColumnOrder(576)
    private RString atesaki_setainushiShimeiRiyoKubun;
    @TempTableColumnOrder(577)
    private TelNo atesaki_setainushiRenrakusaki1;
    @TempTableColumnOrder(578)
    private Code atesaki_setainushiRenrakusakiKubun1;
    @TempTableColumnOrder(579)
    private TelNo atesaki_setainushiRenrakusaki2;
    @TempTableColumnOrder(580)
    private Code atesaki_setainushiRenrakusakiKubun2;
    @TempTableColumnOrder(581)
    private TelNo atesaki_setainushiRenrakusaki3;
    @TempTableColumnOrder(582)
    private Code atesaki_setainushiRenrakusakiKubun3;
    @TempTableColumnOrder(583)
    private MailAddress atesaki_setainushiMailAddress;
    @TempTableColumnOrder(589)
    private ShikibetsuCode atesaki_dainoninShikibetsuCode;

    // 納組情報の全項目
    @TempTableColumnOrder(590)
    private RString caT0714SeikyuHoho_insertDantaiCd;
    @TempTableColumnOrder(591)
    private RDateTime caT0714SeikyuHoho_insertTimestamp;
    @TempTableColumnOrder(592)
    private RString caT0714SeikyuHoho_insertReamsLoginId;
    @TempTableColumnOrder(593)
    private UUID caT0714SeikyuHoho_insertContextId;
    @TempTableColumnOrder(594)
    private boolean caT0714SeikyuHoho_isDeleted;
    @TempTableColumnOrder(595)
    private int caT0714SeikyuHoho_updateCount;
    @TempTableColumnOrder(596)
    private RDateTime caT0714SeikyuHohoi_lastUpdateTimestamp;
    @TempTableColumnOrder(597)
    private RString caT0714SeikyuHoho_lastUpdateReamsLoginId;
    @TempTableColumnOrder(598)
    private ShikibetsuCode caT0714SeikyuHoho_shikibetsuCode;
    @TempTableColumnOrder(599)
    private RString caT0714SeikyuHoho_gyomubetsuPrimaryKey;
    @TempTableColumnOrder(600)
    private RString caT0714SeikyuHoho_gyomuKoyuKey;
    @TempTableColumnOrder(601)
    private ShiharaiHohoCodeValue caT0714SeikyuHoho_shiharaiHoho;
    @TempTableColumnOrder(602)
    private ZennoKubunCodeValue caT0714SeikyuHoho_zennoKubun;
    @TempTableColumnOrder(603)
    private RString caT0714SeikyuHoho_creditKeizokuTorokuKey;
    @TempTableColumnOrder(604)
    private FlexibleDate caT0714SeikyuHoho_kaishiYMD;
    @TempTableColumnOrder(605)
    private FlexibleDate caT0714SeikyuHoho_shuryoYMD;
    @TempTableColumnOrder(606)
    private RString caT0714SeikyuHoho_nokumiShurui;
    @TempTableColumnOrder(607)
    private RString caT0714SeikyuHoho_nokumiCode;
    @TempTableColumnOrder(608)
    private long caT0714SeikyuHoho_creditKeiyakushaId;
    @TempTableColumnOrder(609)
    private long caT0714SeikyuHoho_kozaId;
    @TempTableColumnOrder(610)
    private RString caT0752Nokumi_insertDantaiCd;
    @TempTableColumnOrder(611)
    private RDateTime caT0752Nokumi_insertTimestamp;
    @TempTableColumnOrder(612)
    private RString caT0752Nokumi_insertReamsLoginId;
    @TempTableColumnOrder(613)
    private UUID caT0752Nokumi_insertContextId;
    @TempTableColumnOrder(614)
    private boolean caT0752Nokumi_isDeleted;
    @TempTableColumnOrder(615)
    private int caT0752Nokumi_updateCount;
    @TempTableColumnOrder(616)
    private RDateTime caT0752Nokumi_lastUpdateTimestamp;
    @TempTableColumnOrder(617)
    private RString caT0752Nokumi_lastUpdateReamsLoginId;
    @TempTableColumnOrder(618)
    private RString caT0752Nokumi_nokumiShurui;
    @TempTableColumnOrder(619)
    private RString caT0752Nokumi_nokumiCode;
    @TempTableColumnOrder(620)
    private RString caT0752Nokumi_meisho;
    @TempTableColumnOrder(621)
    private RString caT0752Nokumi_kanaMeisho;
    @TempTableColumnOrder(622)
    private AtenaKanaMeisho caT0752Nokumi_kensakuyoKanaMeisho;
    @TempTableColumnOrder(623)
    private ShikibetsuCode caT0752Nokumi_daihyoshaShikibetsuCode;
    @TempTableColumnOrder(624)
    private AtenaMeisho caT0752Nokumi_daihyoshaShimei;

    // 口座の全項目
    @TempTableColumnOrder(625)
    private RString uaT0310Koza_insertDantaiCd;
    @TempTableColumnOrder(626)
    private boolean uaT0310Koza_isDeleted;
    @TempTableColumnOrder(627)
    private long uaT0310Koza_kozaId;
    @TempTableColumnOrder(628)
    private ShikibetsuCode uaT0310Koza_shikibetsuCode;
    @TempTableColumnOrder(629)
    private RString uaT0310Koza_gyomubetsuPrimaryKey;
    @TempTableColumnOrder(630)
    private RString uaT0310Koza_gyomuKoyuKey;
    @TempTableColumnOrder(631)
    private KozaYotoKubunCodeValue uaT0310Koza_yotoKubun;
    @TempTableColumnOrder(632)
    private int uaT0310Koza_torokuRenban;
    @TempTableColumnOrder(633)
    private FlexibleDate uaT0310Koza_kaishiYMD;
    @TempTableColumnOrder(634)
    private FlexibleDate uaT0310Koza_shuryoYMD;
    @TempTableColumnOrder(635)
    private KinyuKikanCode uaT0310Koza_kinyuKikanCode;
    @TempTableColumnOrder(636)
    private KinyuKikanShitenCode uaT0310Koza_kinyuKikanShitenCode;
    @TempTableColumnOrder(637)
    private RString uaT0310Koza_yokinShubetsu;
    @TempTableColumnOrder(638)
    private RString uaT0310Koza_kozaNo;
    @TempTableColumnOrder(639)
    private RString uaT0310Koza_tsuchoKigo;
    @TempTableColumnOrder(640)
    private RString uaT0310Koza_tsuchoNo;
    @TempTableColumnOrder(641)
    private ShikibetsuCode uaT0310Koza_kozaMeigininShikibetsuCode;
    @TempTableColumnOrder(642)
    private AtenaKanaMeisho uaT0310Koza_kozaMeiginin;
    @TempTableColumnOrder(643)
    private AtenaMeisho uaT0310Koza_kozaMeigininKanji;
    @TempTableColumnOrder(644)
    private AtenaKanaMeisho uaT0310Koza_kensakuyoMeiginin;
    @TempTableColumnOrder(645)
    private RString uaT0310Koza_kozaHyojiKubun;
    @TempTableColumnOrder(646)
    private boolean uaT0310Koza_nayoseKubun;
    @TempTableColumnOrder(647)
    private boolean uaT0310Koza_zumitsuHakkoYohi;
    @TempTableColumnOrder(648)
    private boolean uaT0310Koza_kozaFurikaeKaishiTsuchiHakkozumi;
    @TempTableColumnOrder(649)
    private RString uaT0310Koza_kozaTorokuNo;
    @TempTableColumnOrder(650)
    private KozaTorokuKubunCodeValue uaT0310Koza_kozaTorokuKubunCode;
    @TempTableColumnOrder(651)
    private FlexibleDate uaT0310Koza_kozaKaishiUketsukeYMD;
    @TempTableColumnOrder(652)
    private FlexibleDate uaT0310Koza_kozaShuryoUketsukeYMD;
    @TempTableColumnOrder(653)
    private FlexibleDate uaT0310Koza_kozaTorokuYMD;
    @TempTableColumnOrder(654)
    private RString uaT0310Koza_temban;

    @TempTableColumnOrder(655)
    private RString uaT0302KinyuKikan_insertDantaiCd;
    @TempTableColumnOrder(656)
    private boolean uaT0302KinyuKikan_isDeleted;
    @TempTableColumnOrder(657)
    private KinyuKikanCode uaT0302KinyuKikan_kinyuKikanCode;
    @TempTableColumnOrder(658)
    private FlexibleDate uaT0302KinyuKikan_kaishiYMD;
    @TempTableColumnOrder(659)
    private FlexibleDate uaT0302KinyuKikan_shuryoYMD;
    @TempTableColumnOrder(660)
    private RString uaT0302KinyuKikan_name;
    @TempTableColumnOrder(661)
    private RString uaT0302KinyuKikan_kanaName;
    @TempTableColumnOrder(662)
    private YokinShubetsuPatternCodeValue uaT0302KinyuKikan_yokinShubetsuPatternCode;
    private int uaT0302KinyuKikan_hyojijun;

    @TempTableColumnOrder(663)
    private RString uaT0303KinyuKikanShiten_insertDantaiCd;
    @TempTableColumnOrder(664)
    private boolean uaT0303KinyuKikanShiten_isDeleted;
    @TempTableColumnOrder(665)
    private KinyuKikanCode uaT0303KinyuKikanShiten_kinyuKikanCode;
    @TempTableColumnOrder(666)
    private KinyuKikanShitenCode uaT0303KinyuKikanShiten_kinyuKikanShitenCode;
    @TempTableColumnOrder(667)
    private FlexibleDate uaT0303KinyuKikanShiten_kaishiYMD;
    @TempTableColumnOrder(668)
    private FlexibleDate uaT0303KinyuKikanShiten_shuryoYMD;
    @TempTableColumnOrder(669)
    private RString uaT0303KinyuKikanShiten_name;
    @TempTableColumnOrder(670)
    private RString uaT0303KinyuKikanShiten_kanaName;
    @TempTableColumnOrder(671)
    private int uaT0303KinyuKikanShiten_hyojijun;

    @TempTableColumnOrder(672)
    private RString uaT0301YokinShubetsuPattern_insertDantaiCd;
    @TempTableColumnOrder(673)
    private boolean uaT0301YokinShubetsuPattern_isDeleted;
    @TempTableColumnOrder(674)
    private YokinShubetsuPatternCodeValue uaT0301YokinShubetsuPattern_yokinShubetsuPatternCode;
    @TempTableColumnOrder(675)
    private RString uaT0301YokinShubetsuPattern_yokinShubetsuCode;
    @TempTableColumnOrder(676)
    private RString uaT0301YokinShubetsuPattern_yokinShubetsuMeisho;
    @TempTableColumnOrder(677)
    private RString uaT0301YokinShubetsuPattern_yokinShubetsuRyakusho;
    @TempTableColumnOrder(678)
    private int shunoKensu;

    // 「更正後」対象者（追加含む）情報
    @TempTableColumnOrder(680)
    private RString nenkinTokuchoKaifuJoho_insertDantaiCd;
    @TempTableColumnOrder(681)
    private RDateTime nenkinTokuchoKaifuJoho_insertTimestamp;
    @TempTableColumnOrder(682)
    private RString nenkinTokuchoKaifuJoho_insertReamsLoginId;
    @TempTableColumnOrder(683)
    private UUID nenkinTokuchoKaifuJoho_insertContextId;
    @TempTableColumnOrder(684)
    private boolean nenkinTokuchoKaifuJoho_isDeleted;
    @TempTableColumnOrder(685)
    private int nenkinTokuchoKaifuJoho_updateCount;
    @TempTableColumnOrder(686)
    private RDateTime nenkinTokuchoKaifuJoho_lastUpdateTimestamp;
    @TempTableColumnOrder(687)
    private RString nenkinTokuchoKaifuJoho_lastUpdateReamsLoginId;
    @TempTableColumnOrder(688)
    private GyomuCode nenkinTokuchoKaifuJoho_gyomuCode;
    @TempTableColumnOrder(689)
    private FlexibleYear nenkinTokuchoKaifuJoho_shoriNendo;
    @TempTableColumnOrder(690)
    private TsuchiNaiyoCode nenkinTokuchoKaifuJoho_tsuchiNaiyoCode;
    @TempTableColumnOrder(691)
    private FlexibleYearMonth nenkinTokuchoKaifuJoho_shoriTaishoYM;
    @TempTableColumnOrder(692)
    private RString nenkinTokuchoKaifuJoho_kisoNenkinNo;
    @TempTableColumnOrder(693)
    private RString nenkinTokuchoKaifuJoho_nenkinCode;
    @TempTableColumnOrder(694)
    private RString nenkinTokuchoKaifuJoho_koseiCityCode;
    @TempTableColumnOrder(695)
    private int nenkinTokuchoKaifuJoho_renban;
    @TempTableColumnOrder(696)
    private RDateTime nenkinTokuchoKaifuJoho_shoriTimestamp;
    @TempTableColumnOrder(697)
    private RenkeiShubetsu nenkinTokuchoKaifuJoho_renkeiShubetsu;
    @TempTableColumnOrder(698)
    private RString nenkinTokuchoKaifuJoho_hosokuTsuki;
    @TempTableColumnOrder(699)
    private RString nenkinTokuchoKaifuJoho_tenbikiTsuki;
    @TempTableColumnOrder(700)
    private ShikibetsuCode nenkinTokuchoKaifuJoho_shikibetsuCode;
    @TempTableColumnOrder(701)
    private RString nenkinTokuchoKaifuJoho_hihokenshaNo;
    @TempTableColumnOrder(702)
    private SetaiCode nenkinTokuchoKaifuJoho_kokuhoSetaiCode;
    @TempTableColumnOrder(703)
    private RString nenkinTokuchoKaifuJoho_dtCityCode;
    @TempTableColumnOrder(704)
    private Code nenkinTokuchoKaifuJoho_dtTokubetsuChoshuGimushaCode;
    @TempTableColumnOrder(705)
    private TsuchiNaiyoCode nenkinTokuchoKaifuJoho_dtTsuchiNaiyoCode;
    @TempTableColumnOrder(706)
    private RString nenkinTokuchoKaifuJoho_dtBaitaiCode;
    @TempTableColumnOrder(707)
    private TokubetsuChoshuSeidoCode nenkinTokuchoKaifuJoho_dtTokubetsuChoshuSeidoCode;
    @TempTableColumnOrder(708)
    private RString nenkinTokuchoKaifuJoho_dtSakuseiYMD;
    @TempTableColumnOrder(709)
    private RString nenkinTokuchoKaifuJoho_dtKisoNenkinNo;
    @TempTableColumnOrder(710)
    private RString nenkinTokuchoKaifuJoho_dtNenkinCode;
    @TempTableColumnOrder(711)
    private RString nenkinTokuchoKaifuJoho_dtYobi1;
    @TempTableColumnOrder(712)
    private RString nenkinTokuchoKaifuJoho_dtBirthDay;
    @TempTableColumnOrder(713)
    private SeibetsuCodeNenkinTokucho nenkinTokuchoKaifuJoho_dtSeibetsu;
    @TempTableColumnOrder(714)
    private RString nenkinTokuchoKaifuJoho_dtKanaShimei;
    @TempTableColumnOrder(715)
    private RString nenkinTokuchoKaifuJoho_dtShiftCode1;
    @TempTableColumnOrder(716)
    private RString nenkinTokuchoKaifuJoho_dtKanjiShimei;
    @TempTableColumnOrder(717)
    private RString nenkinTokuchoKaifuJoho_dtShiftCode2;
    @TempTableColumnOrder(718)
    private RString nenkinTokuchoKaifuJoho_dtYubinNo;
    @TempTableColumnOrder(719)
    private RString nenkinTokuchoKaifuJoho_dtKanaJusho;
    @TempTableColumnOrder(720)
    private RString nenkinTokuchoKaifuJoho_dtShiftCode3;
    @TempTableColumnOrder(721)
    private RString nenkinTokuchoKaifuJoho_dtKanjiJusho;
    @TempTableColumnOrder(722)
    private RString nenkinTokuchoKaifuJoho_dtShiftCode4;
    @TempTableColumnOrder(723)
    private RString nenkinTokuchoKaifuJoho_dtKakushuKubun;
    @TempTableColumnOrder(724)
    private RString nenkinTokuchoKaifuJoho_dtShoriKekka;
    @TempTableColumnOrder(725)
    private RString nenkinTokuchoKaifuJoho_dtKokiIkanCode;
    @TempTableColumnOrder(726)
    private RString nenkinTokuchoKaifuJoho_dtKakushuYMD;
    @TempTableColumnOrder(727)
    private RString nenkinTokuchoKaifuJoho_dtKakushuKingaku1;
    @TempTableColumnOrder(728)
    private RString nenkinTokuchoKaifuJoho_dtKakushuKingaku2;
    @TempTableColumnOrder(729)
    private RString nenkinTokuchoKaifuJoho_dtKakushuKingaku3;
    @TempTableColumnOrder(730)
    private RString nenkinTokuchoKaifuJoho_dtYobi2;
    @TempTableColumnOrder(731)
    private RString nenkinTokuchoKaifuJoho_dtKyosaiNenkinshoshoKigoNo;
    @TempTableColumnOrder(732)
    private RString nenkinTokuchoKaifuJoho_dtKakushuKingaku4;
    @TempTableColumnOrder(733)
    private RString nenkinTokuchoKaifuJoho_dtKakushuKingaku5;
    @TempTableColumnOrder(734)
    private RString nenkinTokuchoKaifuJoho_dtKakushuKingaku6;
    @TempTableColumnOrder(735)
    private RString nenkinTokuchoKaifuJoho_dtKakushuKingaku7;
    @TempTableColumnOrder(736)
    private RString nenkinTokuchoKaifuJoho_dtKakushuKingaku8;
    @TempTableColumnOrder(737)
    private RString nenkinTokuchoKaifuJoho_dtTeishiYM;
    @TempTableColumnOrder(738)
    private RString nenkinTokuchoKaifuJoho_dtYobi4Juminzei;
    @TempTableColumnOrder(739)
    private RString nenkinTokuchoKaifuJoho_dtKojinNo;

    // 更正前情報有無区分
    @TempTableColumnOrder(740)
    private RString koseimaeJohoUmuKubun;
    // 前年度・特徴期別金額06
    @TempTableColumnOrder(741)
    private RString zennendoTokuchoKibetsuKingaku06;
    // 被保険者区分
    @TempTableColumnOrder(742)
    private RString hihokenshaKubun;

}
