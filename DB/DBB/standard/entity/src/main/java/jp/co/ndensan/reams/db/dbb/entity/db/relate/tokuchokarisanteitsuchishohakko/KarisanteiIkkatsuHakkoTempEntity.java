/*
 * To change this license header; choose License Headers in Project Properties.
 * To change this template file; choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteitsuchishohakko;

import java.util.UUID;
import jp.co.ndensan.reams.ca.cax.definition.valueobject.code.ShiharaiHohoCodeValue;
import jp.co.ndensan.reams.ca.cax.definition.valueobject.code.ZennoKubunCodeValue;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
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
 * 仮算定のデータのエンティティクラスです。
 *
 * @reamsid_L DBB-0790-030 chenaoqi
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KarisanteiIkkatsuHakkoTempEntity extends DbTableEntityBase<KarisanteiIkkatsuHakkoTempEntity>
        implements IDbAccessable {

    // 計算後情報の全項目
    @TempTableColumnOrder(1)
    private RString dbT2015KeisangoJoho_insertDantaiCd;
    @TempTableColumnOrder(2)
    private RDateTime dbT2015KeisangoJoho_insertTimestamp;
    @TempTableColumnOrder(3)
    private RString dbT2015KeisangoJoho_insertReamsLoginId;
    @TempTableColumnOrder(4)
    private UUID dbT2015KeisangoJoho_insertContextId;
    @TempTableColumnOrder(5)
    private boolean dbT2015KeisangoJoho_isDeleted;
    @TempTableColumnOrder(6)
    private int dbT2015KeisangoJoho_updateCount;
    @TempTableColumnOrder(7)
    private RDateTime dbT2015KeisangoJoho_lastUpdateTimestamp;
    @TempTableColumnOrder(8)
    private RString dbT2015KeisangoJoho_lastUpdateReamsLoginId;
    @TempTableColumnOrder(9)
    private FlexibleYear dbT2015KeisangoJoho_choteiNendo;
    @TempTableColumnOrder(10)
    private FlexibleYear dbT2015KeisangoJoho_fukaNendo;
    @TempTableColumnOrder(11)
    private TsuchishoNo dbT2015KeisangoJoho_tsuchishoNo;
    @TempTableColumnOrder(12)
    private RString dbT2015KeisangoJoho_koseiZengoKubun;
    @TempTableColumnOrder(13)
    private RString dbT2015KeisangoJoho_sakuseiShoriName;
    @TempTableColumnOrder(14)
    private int dbT2015KeisangoJoho_fukaRirekiNo;
    @TempTableColumnOrder(15)
    private HihokenshaNo dbT2015KeisangoJoho_hihokenshaNo;
    @TempTableColumnOrder(16)
    private ShikibetsuCode dbT2015KeisangoJoho_shikibetsuCode;
    @TempTableColumnOrder(17)
    private SetaiCode dbT2015KeisangoJoho_setaiCode;
    @TempTableColumnOrder(18)
    private int dbT2015KeisangoJoho_setaiInsu;
    @TempTableColumnOrder(19)
    private FlexibleDate dbT2015KeisangoJoho_shikakuShutokuYMD;
    @TempTableColumnOrder(20)
    private RString dbT2015KeisangoJoho_shikakuShutokuJiyu;
    @TempTableColumnOrder(21)
    private FlexibleDate dbT2015KeisangoJoho_shikakuSoshitsuYMD;
    @TempTableColumnOrder(22)
    private RString dbT2015KeisangoJoho_shikakuSoshitsuJiyu;
    @TempTableColumnOrder(23)
    private RString dbT2015KeisangoJoho_seihofujoShurui;
    @TempTableColumnOrder(24)
    private FlexibleDate dbT2015KeisangoJoho_seihoKaishiYMD;
    @TempTableColumnOrder(25)
    private FlexibleDate dbT2015KeisangoJoho_seihoHaishiYMD;
    @TempTableColumnOrder(26)
    private FlexibleDate dbT2015KeisangoJoho_ronenKaishiYMD;
    @TempTableColumnOrder(27)
    private FlexibleDate dbT2015KeisangoJoho_ronenHaishiYMD;
    @TempTableColumnOrder(28)
    private FlexibleDate dbT2015KeisangoJoho_fukaYMD;
    @TempTableColumnOrder(29)
    private RString dbT2015KeisangoJoho_kazeiKubun;
    @TempTableColumnOrder(30)
    private RString dbT2015KeisangoJoho_setaikazeiKubun;
    @TempTableColumnOrder(31)
    private Decimal dbT2015KeisangoJoho_gokeiShotokuGaku;
    @TempTableColumnOrder(32)
    private Decimal dbT2015KeisangoJoho_nenkinShunyuGaku;
    @TempTableColumnOrder(33)
    private RString dbT2015KeisangoJoho_hokenryoDankai;
    @TempTableColumnOrder(34)
    private RString dbT2015KeisangoJoho_hokenryoDankai1;
    @TempTableColumnOrder(35)
    private Decimal dbT2015KeisangoJoho_nengakuHokenryo1;
    @TempTableColumnOrder(36)
    private FlexibleYearMonth dbT2015KeisangoJoho_tsukiwariStartYM1;
    @TempTableColumnOrder(37)
    private FlexibleYearMonth dbT2015KeisangoJoho_tsukiwariEndYM1;
    @TempTableColumnOrder(38)
    private RString dbT2015KeisangoJoho_hokenryoDankai2;
    @TempTableColumnOrder(39)
    private Decimal dbT2015KeisangoJoho_nengakuHokenryo2;
    @TempTableColumnOrder(40)
    private FlexibleYearMonth dbT2015KeisangoJoho_tsukiwariStartYM2;
    @TempTableColumnOrder(41)
    private FlexibleYearMonth dbT2015KeisangoJoho_tsukiwariEndYM2;
    @TempTableColumnOrder(42)
    private YMDHMS dbT2015KeisangoJoho_choteiNichiji;
    @TempTableColumnOrder(43)
    private RString dbT2015KeisangoJoho_choteiJiyu1;
    @TempTableColumnOrder(44)
    private RString dbT2015KeisangoJoho_choteiJiyu2;
    @TempTableColumnOrder(45)
    private RString dbT2015KeisangoJoho_choteiJiyu3;
    @TempTableColumnOrder(46)
    private RString dbT2015KeisangoJoho_choteiJiyu4;
    @TempTableColumnOrder(47)
    private RString dbT2015KeisangoJoho_koseiM;
    @TempTableColumnOrder(48)
    private Decimal dbT2015KeisangoJoho_gemmenMaeHokenryo;
    @TempTableColumnOrder(49)
    private Decimal dbT2015KeisangoJoho_gemmenGaku;
    @TempTableColumnOrder(50)
    private Decimal dbT2015KeisangoJoho_kakuteiHokenryo;
    @TempTableColumnOrder(51)
    private RString dbT2015KeisangoJoho_hokenryoDankaiKarisanntei;
    @TempTableColumnOrder(52)
    private int dbT2015KeisangoJoho_choshuHohoRirekiNo;
    @TempTableColumnOrder(53)
    private YMDHMS dbT2015KeisangoJoho_idoKijunNichiji;
    @TempTableColumnOrder(54)
    private RString dbT2015KeisangoJoho_kozaKubun;
    @TempTableColumnOrder(55)
    private RString dbT2015KeisangoJoho_kyokaisoKubun;
    @TempTableColumnOrder(56)
    private RString dbT2015KeisangoJoho_shokkenKubun;
    @TempTableColumnOrder(57)
    private LasdecCode dbT2015KeisangoJoho_fukaShichosonCode;
    @TempTableColumnOrder(58)
    private Decimal dbT2015KeisangoJoho_tkSaishutsuKampuGaku;
    @TempTableColumnOrder(59)
    private Decimal dbT2015KeisangoJoho_fuSaishutsuKampuGaku;
    @TempTableColumnOrder(60)
    private Decimal dbT2015KeisangoJoho_tkKibetsuGaku01;
    @TempTableColumnOrder(61)
    private Decimal dbT2015KeisangoJoho_tkKibetsuGaku02;
    @TempTableColumnOrder(62)
    private Decimal dbT2015KeisangoJoho_tkKibetsuGaku03;
    @TempTableColumnOrder(63)
    private Decimal dbT2015KeisangoJoho_tkKibetsuGaku04;
    @TempTableColumnOrder(64)
    private Decimal dbT2015KeisangoJoho_tkKibetsuGaku05;
    @TempTableColumnOrder(65)
    private Decimal dbT2015KeisangoJoho_tkKibetsuGaku06;
    @TempTableColumnOrder(66)
    private Decimal dbT2015KeisangoJoho_fuKibetsuGaku01;
    @TempTableColumnOrder(67)
    private Decimal dbT2015KeisangoJoho_fuKibetsuGaku02;
    @TempTableColumnOrder(68)
    private Decimal dbT2015KeisangoJoho_fuKibetsuGaku03;
    @TempTableColumnOrder(69)
    private Decimal dbT2015KeisangoJoho_fuKibetsuGaku04;
    @TempTableColumnOrder(70)
    private Decimal dbT2015KeisangoJoho_fuKibetsuGaku05;
    @TempTableColumnOrder(71)
    private Decimal dbT2015KeisangoJoho_fuKibetsuGaku06;
    @TempTableColumnOrder(72)
    private Decimal dbT2015KeisangoJoho_fuKibetsuGaku07;
    @TempTableColumnOrder(73)
    private Decimal dbT2015KeisangoJoho_fuKibetsuGaku08;
    @TempTableColumnOrder(74)
    private Decimal dbT2015KeisangoJoho_fuKibetsuGaku09;
    @TempTableColumnOrder(75)
    private Decimal dbT2015KeisangoJoho_fuKibetsuGaku10;
    @TempTableColumnOrder(76)
    private Decimal dbT2015KeisangoJoho_fuKibetsuGaku11;
    @TempTableColumnOrder(77)
    private Decimal dbT2015KeisangoJoho_fuKibetsuGaku12;
    @TempTableColumnOrder(78)
    private Decimal dbT2015KeisangoJoho_fuKibetsuGaku13;
    @TempTableColumnOrder(79)
    private Decimal dbT2015KeisangoJoho_fuKibetsuGaku14;
    @TempTableColumnOrder(80)
    private RString dbT2015KeisangoJoho_choshuHoho4gatsu;
    @TempTableColumnOrder(81)
    private RString dbT2015KeisangoJoho_choshuHoho5gatsu;
    @TempTableColumnOrder(82)
    private RString dbT2015KeisangoJoho_choshuHoho6gatsu;
    @TempTableColumnOrder(83)
    private RString dbT2015KeisangoJoho_choshuHoho7gatsu;
    @TempTableColumnOrder(84)
    private RString dbT2015KeisangoJoho_choshuHoho8gatsu;
    @TempTableColumnOrder(85)
    private RString dbT2015KeisangoJoho_choshuHoho9gatsu;
    @TempTableColumnOrder(86)
    private RString dbT2015KeisangoJoho_choshuHoho10gatsu;
    @TempTableColumnOrder(87)
    private RString dbT2015KeisangoJoho_choshuHoho11gatsu;
    @TempTableColumnOrder(88)
    private RString dbT2015KeisangoJoho_choshuHoho12gatsu;
    @TempTableColumnOrder(89)
    private RString dbT2015KeisangoJoho_choshuHoho1gatsu;
    @TempTableColumnOrder(90)
    private RString dbT2015KeisangoJoho_choshuHoho2gatsu;
    @TempTableColumnOrder(91)
    private RString dbT2015KeisangoJoho_choshuHoho3gatsu;
    @TempTableColumnOrder(92)
    private RString dbT2015KeisangoJoho_choshuHohoYoku4gatsu;
    @TempTableColumnOrder(93)
    private RString dbT2015KeisangoJoho_choshuHohoYoku5gatsu;
    @TempTableColumnOrder(94)
    private RString dbT2015KeisangoJoho_choshuHohoYoku6gatsu;
    @TempTableColumnOrder(95)
    private RString dbT2015KeisangoJoho_choshuHohoYoku7gatsu;
    @TempTableColumnOrder(96)
    private RString dbT2015KeisangoJoho_choshuHohoYoku8gatsu;
    @TempTableColumnOrder(97)
    private RString dbT2015KeisangoJoho_choshuHohoYoku9gatsu;
    @TempTableColumnOrder(98)
    private RString dbT2015KeisangoJoho_kariNenkinNo;
    @TempTableColumnOrder(99)
    private RString dbT2015KeisangoJoho_kariNenkinCode;
    @TempTableColumnOrder(100)
    private RString dbT2015KeisangoJoho_kariHosokuM;
    @TempTableColumnOrder(101)
    private RString dbT2015KeisangoJoho_honNenkinNo;
    @TempTableColumnOrder(102)
    private RString dbT2015KeisangoJoho_honNenkinCode;
    @TempTableColumnOrder(103)
    private RString dbT2015KeisangoJoho_honHosokuM;
    @TempTableColumnOrder(104)
    private RString dbT2015KeisangoJoho_yokunendoKariNenkinNo;
    @TempTableColumnOrder(105)
    private RString dbT2015KeisangoJoho_yokunendoKariNenkinCode;
    @TempTableColumnOrder(106)
    private RString dbT2015KeisangoJoho_yokunendoKariHosokuM;
    @TempTableColumnOrder(107)
    private boolean dbT2015KeisangoJoho_iraiSohuzumiFlag;
    @TempTableColumnOrder(108)
    private boolean dbT2015KeisangoJoho_tsuikaIraiSohuzumiFlag;
    @TempTableColumnOrder(109)
    private YMDHMS dbT2015KeisangoJoho_tokuchoTeishiNichiji;
    @TempTableColumnOrder(110)
    private RString dbT2015KeisangoJoho_tokuchoTeishiJiyuCode;
    @TempTableColumnOrder(111)
    private Decimal dbT2015KeisangoJoho_tkShunyuGaku01;
    @TempTableColumnOrder(112)
    private Decimal dbT2015KeisangoJoho_tkShunyuGaku02;
    @TempTableColumnOrder(113)
    private Decimal dbT2015KeisangoJoho_tkShunyuGaku03;
    @TempTableColumnOrder(114)
    private Decimal dbT2015KeisangoJoho_tkShunyuGaku04;
    @TempTableColumnOrder(115)
    private Decimal dbT2015KeisangoJoho_tkShunyuGaku05;
    @TempTableColumnOrder(116)
    private Decimal dbT2015KeisangoJoho_tkShunyuGaku06;
    @TempTableColumnOrder(117)
    private Decimal dbT2015KeisangoJoho_fuShunyuGaku01;
    @TempTableColumnOrder(118)
    private Decimal dbT2015KeisangoJoho_fuShunyuGaku02;
    @TempTableColumnOrder(119)
    private Decimal dbT2015KeisangoJoho_fuShunyuGaku03;
    @TempTableColumnOrder(120)
    private Decimal dbT2015KeisangoJoho_fuShunyuGaku04;
    @TempTableColumnOrder(121)
    private Decimal dbT2015KeisangoJoho_fuShunyuGaku05;
    @TempTableColumnOrder(122)
    private Decimal dbT2015KeisangoJoho_fuShunyuGaku06;
    @TempTableColumnOrder(123)
    private Decimal dbT2015KeisangoJoho_fuShunyuGaku07;
    @TempTableColumnOrder(124)
    private Decimal dbT2015KeisangoJoho_fuShunyuGaku08;
    @TempTableColumnOrder(125)
    private Decimal dbT2015KeisangoJoho_fuShunyuGaku09;
    @TempTableColumnOrder(126)
    private Decimal dbT2015KeisangoJoho_fuShunyuGaku10;
    @TempTableColumnOrder(127)
    private Decimal dbT2015KeisangoJoho_fuShunyuGaku11;
    @TempTableColumnOrder(128)
    private Decimal dbT2015KeisangoJoho_fuShunyuGaku12;
    @TempTableColumnOrder(129)
    private Decimal dbT2015KeisangoJoho_fuShunyuGaku13;
    @TempTableColumnOrder(130)
    private Decimal dbT2015KeisangoJoho_fuShunyuGaku14;

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

    // 宛先情報の全項目
    @TempTableColumnOrder(324)
    private ShikibetsuCode atesaki_shikibetsuCode;
    @TempTableColumnOrder(325)
    private RString atesaki_atesakiShubetsu;
    @TempTableColumnOrder(326)
    private RString atesaki_gyomubetsuPrimaryKey;
    @TempTableColumnOrder(327)
    private GyomuCode atesaki_gyomuCode;
    @TempTableColumnOrder(328)
    private SubGyomuCode atesaki_subGyomuCode;
    @TempTableColumnOrder(329)
    private RString atesaki_gyomuGroupCode;
    @TempTableColumnOrder(330)
    private RString atesaki_gyomuGroupName;
    @TempTableColumnOrder(331)
    private RString atesaki_subGyomuGroupCode;
    @TempTableColumnOrder(332)
    private RString atesaki_subGyomuGroupName;
    @TempTableColumnOrder(333)
    private KamokuCode atesaki_kamokuCode;
    @TempTableColumnOrder(334)
    private RString atesaki_gyomuKoyuKey;
    @TempTableColumnOrder(335)
    private RString atesaki_kannaiKangaiKubun;
    @TempTableColumnOrder(336)
    private ZenkokuJushoCode atesaki_zenkokuJushoCode;
    @TempTableColumnOrder(337)
    private ChoikiCode atesaki_choikiCode;
    @TempTableColumnOrder(338)
    private AtenaJusho atesaki_jusho;
    @TempTableColumnOrder(339)
    private YubinNo atesaki_yubinNo;
    @TempTableColumnOrder(340)
    private BanchiCode atesaki_banchiCode1;
    @TempTableColumnOrder(341)
    private BanchiCode atesaki_banchiCode2;
    @TempTableColumnOrder(342)
    private BanchiCode atesaki_banchiCode3;
    @TempTableColumnOrder(343)
    private BanchiCode atesaki_banchiCode4;
    @TempTableColumnOrder(344)
    private AtenaBanchi atesaki_banchi;
    @TempTableColumnOrder(345)
    private boolean atesaki_katagakiInjiFlag;
    @TempTableColumnOrder(346)
    private Katagaki atesaki_katagaki;
    @TempTableColumnOrder(347)
    private GyoseikuCode atesaki_gyoseikuCode;
    @TempTableColumnOrder(348)
    private RString atesaki_gyoseiku;
    @TempTableColumnOrder(349)
    private ChikuCode atesaki_chikuCode1;
    @TempTableColumnOrder(350)
    private RString atesaki_chiku1;
    @TempTableColumnOrder(351)
    private ChikuCode atesaki_chikuCode2;
    @TempTableColumnOrder(352)
    private RString atesaki_chiku2;
    @TempTableColumnOrder(353)
    private ChikuCode atesaki_chikuCode3;
    @TempTableColumnOrder(354)
    private RString atesaki_chiku3;
    @TempTableColumnOrder(355)
    private RString atesaki_juminShubetsuCode;
    @TempTableColumnOrder(356)
    private RString atesaki_juminJotaiCode;
    @TempTableColumnOrder(357)
    private AtenaMeisho atesaki_kanjiShimei;
    @TempTableColumnOrder(358)
    private AtenaKanaMeisho atesaki_kanaShimei;
    @TempTableColumnOrder(359)
    private AtenaMeisho atesaki_gaikokujinShimei;
    @TempTableColumnOrder(360)
    private AtenaMeisho atesaki_gaikokujinHeikimei;
    @TempTableColumnOrder(361)
    private AtenaKanaMeisho atesaki_gaikokujinKanaShimei;
    @TempTableColumnOrder(362)
    private AtenaMeisho atesaki_tsushomei;
    @TempTableColumnOrder(363)
    private AtenaKanaMeisho atesaki_kanaTsushomei;
    @TempTableColumnOrder(364)
    private RString atesaki_shimeiRiyoKubun;
    @TempTableColumnOrder(365)
    private AtenaMeisho atesaki_kyoyushaMeisho;
    @TempTableColumnOrder(366)
    private AtenaKanaMeisho atesaki_kyoyushaKanaMeisho;
    @TempTableColumnOrder(367)
    private Code atesaki_hojinKeitaiCode;
    @TempTableColumnOrder(368)
    private RString atesaki_hojinMeiHenshuKubun;
    @TempTableColumnOrder(369)
    private RString atesaki_hojinKeitaiRyakushoKubun;
    @TempTableColumnOrder(370)
    private AtenaMeisho atesaki_hojinMeisho;
    @TempTableColumnOrder(371)
    private AtenaKanaMeisho atesaki_hojinKanaMeisho;
    @TempTableColumnOrder(372)
    private AtenaMeisho atesaki_hojinShitenMeisho;
    @TempTableColumnOrder(373)
    private AtenaKanaMeisho atesaki_hojinShitenKanaMeisho;
    @TempTableColumnOrder(374)
    private AtenaMeisho atesaki_sofusakiMeisho;
    @TempTableColumnOrder(375)
    private AtenaKanaMeisho atesaki_sofusakiKanaMeisho;
    @TempTableColumnOrder(376)
    private TelNo atesaki_renrakusaki1;
    @TempTableColumnOrder(377)
    private Code atesaki_renrakusakiKubun1;
    @TempTableColumnOrder(378)
    private TelNo atesaki_renrakusaki2;
    @TempTableColumnOrder(379)
    private Code atesaki_renrakusakiKubun2;
    @TempTableColumnOrder(380)
    private TelNo atesaki_renrakusaki3;
    @TempTableColumnOrder(381)
    private Code atesaki_renrakusakiKubun3;
    @TempTableColumnOrder(382)
    private MailAddress atesaki_mailAddress;
    @TempTableColumnOrder(383)
    private Code atesaki_dainoKankeiCode;
    @TempTableColumnOrder(384)
    private RString atesaki_biko;
    @TempTableColumnOrder(385)
    private RString atesaki_honninJuminShubetsuCode;
    @TempTableColumnOrder(386)
    private RString atesaki_honninJuminJotaiCode;
    @TempTableColumnOrder(387)
    private AtenaMeisho atesaki_honninKanjiShimei;
    @TempTableColumnOrder(388)
    private AtenaKanaMeisho atesaki_honninKanaShimei;
    @TempTableColumnOrder(389)
    private AtenaMeisho atesaki_honninGaikokujinShimei;
    @TempTableColumnOrder(390)
    private AtenaMeisho atesaki_honninGaikokujinHeikimei;
    @TempTableColumnOrder(391)
    private AtenaKanaMeisho atesaki_honninGaikokujinKanaShimei;
    @TempTableColumnOrder(392)
    private AtenaMeisho atesaki_honninTsushomei;
    @TempTableColumnOrder(393)
    private AtenaKanaMeisho atesaki_honninKanaTsushomei;
    @TempTableColumnOrder(394)
    private RString atesaki_honninShimeiRiyoKubun;
    @TempTableColumnOrder(395)
    private AtenaMeisho atesaki_honninKyoyushaMeisho;
    @TempTableColumnOrder(396)
    private AtenaKanaMeisho atesaki_honninKyoyushaKanaMeisho;
    @TempTableColumnOrder(397)
    private Code atesaki_honninHojinKeitaiCode;
    @TempTableColumnOrder(398)
    private RString atesaki_honninHojinMeiHenshuKubun;
    @TempTableColumnOrder(399)
    private RString atesaki_honninHojinKeitaiRyakushoKubun;
    @TempTableColumnOrder(400)
    private AtenaMeisho atesaki_honninHojinMeisho;
    @TempTableColumnOrder(401)
    private AtenaKanaMeisho atesaki_honninHojinKanaMeisho;
    @TempTableColumnOrder(402)
    private AtenaMeisho atesaki_honninHojinShitenMeisho;
    @TempTableColumnOrder(403)
    private AtenaKanaMeisho atesaki_honninHojinShitenKanaMeisho;
    @TempTableColumnOrder(404)
    private ShikibetsuCode atesaki_honninDaihyoshaShikibetsuCode;
    @TempTableColumnOrder(405)
    private RString atesaki_honninDaihyoshaJuminShubetsuCode;
    @TempTableColumnOrder(406)
    private AtenaMeisho atesaki_honninDaihyoshaShimei;
    @TempTableColumnOrder(407)
    private AtenaKanaMeisho atesaki_honninDaihyoshaKanaShimei;
    @TempTableColumnOrder(408)
    private AtenaMeisho atesaki_honninDaihyoshaNihonjinShimei;
    @TempTableColumnOrder(409)
    private AtenaKanaMeisho atesaki_honninDaihyoshaNihonjinKanaShimei;
    @TempTableColumnOrder(410)
    private AtenaMeisho atesaki_honninDaihyoshaGaikokujinShimei;
    @TempTableColumnOrder(411)
    private AtenaMeisho atesaki_honninDaihyoshaGaikokujinHeikimei;
    @TempTableColumnOrder(412)
    private AtenaKanaMeisho atesaki_honninDaihyoshaGaikokujinKanaShimei;
    @TempTableColumnOrder(413)
    private AtenaMeisho atesaki_honninDaihyoshaTsushomei;
    @TempTableColumnOrder(414)
    private RString atesaki_honninDaihyoshaShimeiRiyoKubun;
    @TempTableColumnOrder(415)
    private AtenaKanaMeisho atesaki_honninDaihyoshaKanaTsushomei;
    @TempTableColumnOrder(416)
    private ShikibetsuCode atesaki_setainushiShikibetsuCode;
    @TempTableColumnOrder(417)
    private RString atesaki_setainushiKannaiKangaiKubun;
    @TempTableColumnOrder(418)
    private ZenkokuJushoCode atesaki_setainushiZenkokuJushoCode;
    @TempTableColumnOrder(419)
    private ChoikiCode atesaki_setainushiChoikiCode;
    @TempTableColumnOrder(420)
    private AtenaJusho atesaki_setainushiJusho;
    @TempTableColumnOrder(421)
    private YubinNo atesaki_setainushiYubinNo;
    @TempTableColumnOrder(422)
    private BanchiCode atesaki_setainushiBanchiCode1;
    @TempTableColumnOrder(423)
    private BanchiCode atesaki_setainushiBanchiCode2;
    @TempTableColumnOrder(424)
    private BanchiCode atesaki_setainushiBanchiCode3;
    @TempTableColumnOrder(425)
    private BanchiCode atesaki_setainushiBanchiCode4;
    @TempTableColumnOrder(426)
    private AtenaBanchi atesaki_setainushiBanchi;
    @TempTableColumnOrder(427)
    private boolean atesaki_setainushiKatagakiInjiFlag;
    @TempTableColumnOrder(428)
    private Katagaki atesaki_setainushiKatagaki;
    @TempTableColumnOrder(429)
    private GyoseikuCode atesaki_setainushiGyoseikuCode;
    @TempTableColumnOrder(430)
    private RString atesaki_setainushiGyoseikuName;
    @TempTableColumnOrder(431)
    private ChikuCode atesaki_setainushiChikuCode1;
    @TempTableColumnOrder(432)
    private RString atesaki_setainushiChiku1;
    @TempTableColumnOrder(433)
    private ChikuCode atesaki_setainushiChikuCode2;
    @TempTableColumnOrder(434)
    private RString atesaki_setainushiChiku2;
    @TempTableColumnOrder(435)
    private ChikuCode atesaki_setainushiChikuCode3;
    @TempTableColumnOrder(436)
    private RString atesaki_setainushiChiku3;
    @TempTableColumnOrder(437)
    private RString atesaki_setainushiJuminShubetsuCode;
    @TempTableColumnOrder(438)
    private RString atesaki_setainushiJuminJotaiCode;
    @TempTableColumnOrder(439)
    private AtenaMeisho atesaki_setainushiKanjiShimei;
    @TempTableColumnOrder(440)
    private AtenaKanaMeisho atesaki_setainushiKanaShimei;
    @TempTableColumnOrder(441)
    private AtenaMeisho atesaki_setainushiGaikokujinShimei;
    @TempTableColumnOrder(442)
    private AtenaMeisho atesaki_setainushiGaikokujinHeikimei;
    @TempTableColumnOrder(443)
    private AtenaKanaMeisho atesaki_setainushiGaikokujinKanaShimei;
    @TempTableColumnOrder(444)
    private AtenaMeisho atesaki_setainushiTsushomei;
    @TempTableColumnOrder(445)
    private AtenaKanaMeisho atesaki_setainushiKanaTsushomei;
    @TempTableColumnOrder(446)
    private RString atesaki_setainushiShimeiRiyoKubun;
    @TempTableColumnOrder(447)
    private TelNo atesaki_setainushiRenrakusaki1;
    @TempTableColumnOrder(448)
    private Code atesaki_setainushiRenrakusakiKubun1;
    @TempTableColumnOrder(449)
    private TelNo atesaki_setainushiRenrakusaki2;
    @TempTableColumnOrder(450)
    private Code atesaki_setainushiRenrakusakiKubun2;
    @TempTableColumnOrder(451)
    private TelNo atesaki_setainushiRenrakusaki3;
    @TempTableColumnOrder(452)
    private Code atesaki_setainushiRenrakusakiKubun3;
    @TempTableColumnOrder(453)
    private MailAddress atesaki_setainushiMailAddress;
    @TempTableColumnOrder(459)
    private ShikibetsuCode atesaki_dainoninShikibetsuCode;

    // 納組情報の全項目
    @TempTableColumnOrder(460)
    private RString caT0714SeikyuHoho_insertDantaiCd;
    @TempTableColumnOrder(461)
    private RDateTime caT0714SeikyuHoho_insertTimestamp;
    @TempTableColumnOrder(462)
    private RString caT0714SeikyuHoho_insertReamsLoginId;
    @TempTableColumnOrder(463)
    private UUID caT0714SeikyuHoho_insertContextId;
    @TempTableColumnOrder(464)
    private boolean caT0714SeikyuHoho_isDeleted;
    @TempTableColumnOrder(465)
    private int caT0714SeikyuHoho_updateCount;
    @TempTableColumnOrder(466)
    private RDateTime caT0714SeikyuHohoi_lastUpdateTimestamp;
    @TempTableColumnOrder(467)
    private RString caT0714SeikyuHoho_lastUpdateReamsLoginId;
    @TempTableColumnOrder(468)
    private ShikibetsuCode caT0714SeikyuHoho_shikibetsuCode;
    @TempTableColumnOrder(469)
    private RString caT0714SeikyuHoho_gyomubetsuPrimaryKey;
    @TempTableColumnOrder(470)
    private RString caT0714SeikyuHoho_gyomuKoyuKey;
    @TempTableColumnOrder(471)
    private ShiharaiHohoCodeValue caT0714SeikyuHoho_shiharaiHoho;
    @TempTableColumnOrder(472)
    private ZennoKubunCodeValue caT0714SeikyuHoho_zennoKubun;
    @TempTableColumnOrder(473)
    private RString caT0714SeikyuHoho_creditKeizokuTorokuKey;
    @TempTableColumnOrder(474)
    private FlexibleDate caT0714SeikyuHoho_kaishiYMD;
    @TempTableColumnOrder(475)
    private FlexibleDate caT0714SeikyuHoho_shuryoYMD;
    @TempTableColumnOrder(476)
    private RString caT0714SeikyuHoho_nokumiShurui;
    @TempTableColumnOrder(477)
    private RString caT0714SeikyuHoho_nokumiCode;
    @TempTableColumnOrder(478)
    private long caT0714SeikyuHoho_creditKeiyakushaId;
    @TempTableColumnOrder(479)
    private long caT0714SeikyuHoho_kozaId;
    @TempTableColumnOrder(480)
    private RString caT0752Nokumi_insertDantaiCd;
    @TempTableColumnOrder(481)
    private RDateTime caT0752Nokumi_insertTimestamp;
    @TempTableColumnOrder(482)
    private RString caT0752Nokumi_insertReamsLoginId;
    @TempTableColumnOrder(483)
    private UUID caT0752Nokumi_insertContextId;
    @TempTableColumnOrder(484)
    private boolean caT0752Nokumi_isDeleted;
    @TempTableColumnOrder(485)
    private int caT0752Nokumi_updateCount;
    @TempTableColumnOrder(486)
    private RDateTime caT0752Nokumi_lastUpdateTimestamp;
    @TempTableColumnOrder(487)
    private RString caT0752Nokumi_lastUpdateReamsLoginId;
    @TempTableColumnOrder(488)
    private RString caT0752Nokumi_nokumiShurui;
    @TempTableColumnOrder(489)
    private RString caT0752Nokumi_nokumiCode;
    @TempTableColumnOrder(490)
    private RString caT0752Nokumi_meisho;
    @TempTableColumnOrder(491)
    private RString caT0752Nokumi_kanaMeisho;
    @TempTableColumnOrder(492)
    private AtenaKanaMeisho caT0752Nokumi_kensakuyoKanaMeisho;
    @TempTableColumnOrder(493)
    private ShikibetsuCode caT0752Nokumi_daihyoshaShikibetsuCode;
    @TempTableColumnOrder(494)
    private AtenaMeisho caT0752Nokumi_daihyoshaShimei;

    // 対象者（追加含む）情報
    @TempTableColumnOrder(495)
    private RString nenkinTokuchoKaifuJoho_insertDantaiCd;
    @TempTableColumnOrder(496)
    private RDateTime nenkinTokuchoKaifuJoho_insertTimestamp;
    @TempTableColumnOrder(497)
    private RString nenkinTokuchoKaifuJoho_insertReamsLoginId;
    @TempTableColumnOrder(498)
    private UUID nenkinTokuchoKaifuJoho_insertContextId;
    @TempTableColumnOrder(499)
    private boolean nenkinTokuchoKaifuJoho_isDeleted;
    @TempTableColumnOrder(500)
    private int nenkinTokuchoKaifuJoho_updateCount;
    @TempTableColumnOrder(501)
    private RDateTime nenkinTokuchoKaifuJoho_lastUpdateTimestamp;
    @TempTableColumnOrder(502)
    private RString nenkinTokuchoKaifuJoho_lastUpdateReamsLoginId;
    @TempTableColumnOrder(503)
    private GyomuCode nenkinTokuchoKaifuJoho_gyomuCode;
    @TempTableColumnOrder(504)
    private FlexibleYear nenkinTokuchoKaifuJoho_shoriNendo;
    @TempTableColumnOrder(505)
    private TsuchiNaiyoCode nenkinTokuchoKaifuJoho_tsuchiNaiyoCode;
    @TempTableColumnOrder(506)
    private FlexibleYearMonth nenkinTokuchoKaifuJoho_shoriTaishoYM;
    @TempTableColumnOrder(507)
    private RString nenkinTokuchoKaifuJoho_kisoNenkinNo;
    @TempTableColumnOrder(508)
    private RString nenkinTokuchoKaifuJoho_nenkinCode;
    @TempTableColumnOrder(509)
    private RString nenkinTokuchoKaifuJoho_koseiCityCode;
    @TempTableColumnOrder(510)
    private int nenkinTokuchoKaifuJoho_renban;
    @TempTableColumnOrder(511)
    private RDateTime nenkinTokuchoKaifuJoho_shoriTimestamp;
    @TempTableColumnOrder(512)
    private RString nenkinTokuchoKaifuJoho_renkeiShubetsu;
    @TempTableColumnOrder(513)
    private RString nenkinTokuchoKaifuJoho_hosokuTsuki;
    @TempTableColumnOrder(514)
    private RString nenkinTokuchoKaifuJoho_tenbikiTsuki;
    @TempTableColumnOrder(515)
    private ShikibetsuCode nenkinTokuchoKaifuJoho_shikibetsuCode;
    @TempTableColumnOrder(516)
    private RString nenkinTokuchoKaifuJoho_hihokenshaNo;
    @TempTableColumnOrder(517)
    private SetaiCode nenkinTokuchoKaifuJoho_kokuhoSetaiCode;
    @TempTableColumnOrder(518)
    private RString nenkinTokuchoKaifuJoho_dtCityCode;
    @TempTableColumnOrder(519)
    private RString nenkinTokuchoKaifuJoho_dtTokubetsuChoshuGimushaCode;
    @TempTableColumnOrder(520)
    private TsuchiNaiyoCode nenkinTokuchoKaifuJoho_dtTsuchiNaiyoCode;
    @TempTableColumnOrder(521)
    private RString nenkinTokuchoKaifuJoho_dtBaitaiCode;
    @TempTableColumnOrder(522)
    private TokubetsuChoshuSeidoCode nenkinTokuchoKaifuJoho_dtTokubetsuChoshuSeidoCode;
    @TempTableColumnOrder(523)
    private RString nenkinTokuchoKaifuJoho_dtSakuseiYMD;
    @TempTableColumnOrder(524)
    private RString nenkinTokuchoKaifuJoho_dtKisoNenkinNo;
    @TempTableColumnOrder(525)
    private RString nenkinTokuchoKaifuJoho_dtNenkinCode;
    @TempTableColumnOrder(526)
    private RString nenkinTokuchoKaifuJoho_dtYobi1;
    @TempTableColumnOrder(527)
    private RString nenkinTokuchoKaifuJoho_dtBirthDay;
    @TempTableColumnOrder(528)
    private SeibetsuCodeNenkinTokucho nenkinTokuchoKaifuJoho_dtSeibetsu;
    @TempTableColumnOrder(529)
    private RString nenkinTokuchoKaifuJoho_dtKanaShimei;
    @TempTableColumnOrder(530)
    private RString nenkinTokuchoKaifuJoho_dtShiftCode1;
    @TempTableColumnOrder(531)
    private RString nenkinTokuchoKaifuJoho_dtKanjiShimei;
    @TempTableColumnOrder(532)
    private RString nenkinTokuchoKaifuJoho_dtShiftCode2;
    @TempTableColumnOrder(533)
    private RString nenkinTokuchoKaifuJoho_dtYubinNo;
    @TempTableColumnOrder(534)
    private RString nenkinTokuchoKaifuJoho_dtKanaJusho;
    @TempTableColumnOrder(535)
    private RString nenkinTokuchoKaifuJoho_dtShiftCode3;
    @TempTableColumnOrder(536)
    private RString nenkinTokuchoKaifuJoho_dtKanjiJusho;
    @TempTableColumnOrder(537)
    private RString nenkinTokuchoKaifuJoho_dtShiftCode4;
    @TempTableColumnOrder(538)
    private RString nenkinTokuchoKaifuJoho_dtKakushuKubun;
    @TempTableColumnOrder(539)
    private RString nenkinTokuchoKaifuJoho_dtShoriKekka;
    @TempTableColumnOrder(540)
    private RString nenkinTokuchoKaifuJoho_dtKokiIkanCode;
    @TempTableColumnOrder(541)
    private RString nenkinTokuchoKaifuJoho_dtKakushuYMD;
    @TempTableColumnOrder(542)
    private RString nenkinTokuchoKaifuJoho_dtKakushuKingaku1;
    @TempTableColumnOrder(543)
    private RString nenkinTokuchoKaifuJoho_dtKakushuKingaku2;
    @TempTableColumnOrder(544)
    private RString nenkinTokuchoKaifuJoho_dtKakushuKingaku3;
    @TempTableColumnOrder(545)
    private RString nenkinTokuchoKaifuJoho_dtYobi2;
    @TempTableColumnOrder(546)
    private RString nenkinTokuchoKaifuJoho_dtKyosaiNenkinshoshoKigoNo;
    @TempTableColumnOrder(547)
    private RString nenkinTokuchoKaifuJoho_dtKakushuKingaku4;
    @TempTableColumnOrder(548)
    private RString nenkinTokuchoKaifuJoho_dtKakushuKingaku5;
    @TempTableColumnOrder(549)
    private RString nenkinTokuchoKaifuJoho_dtKakushuKingaku6;
    @TempTableColumnOrder(550)
    private RString nenkinTokuchoKaifuJoho_dtKakushuKingaku7;
    @TempTableColumnOrder(551)
    private RString nenkinTokuchoKaifuJoho_dtKakushuKingaku8;
    @TempTableColumnOrder(552)
    private RString nenkinTokuchoKaifuJoho_dtTeishiYM;
    @TempTableColumnOrder(553)
    private RString nenkinTokuchoKaifuJoho_dtYobi4Juminzei;
    @TempTableColumnOrder(554)
    private RString nenkinTokuchoKaifuJoho_dtKojinNo;

    @TempTableColumnOrder(555)
    private FlexibleYear dbT2002Fuka_choteiNendo;
    @TempTableColumnOrder(556)
    private FlexibleYear dbT2002Fuka_fukaNendo;
    @TempTableColumnOrder(557)
    private TsuchishoNo dbT2002Fuka_tsuchishoNo;
    @TempTableColumnOrder(558)
    private int dbT2002Fuka_rirekiNo;
    @TempTableColumnOrder(559)
    private HihokenshaNo dbT2002Fuka_hihokenshaNo;
    @TempTableColumnOrder(560)
    private ShikibetsuCode dbT2002Fuka_shikibetsuCode;
    @TempTableColumnOrder(561)
    private SetaiCode dbT2002Fuka_setaiCode;
    @TempTableColumnOrder(562)
    private int dbT2002Fuka_setaiInsu;
    @TempTableColumnOrder(563)
    private FlexibleDate dbT2002Fuka_shikakuShutokuYMD;
    @TempTableColumnOrder(564)
    private RString dbT2002Fuka_shikakuShutokuJiyu;
    @TempTableColumnOrder(565)
    private FlexibleDate dbT2002Fuka_shikakuSoshitsuYMD;
    @TempTableColumnOrder(566)
    private RString dbT2002Fuka_shikakuSoshitsuJiyu;
    @TempTableColumnOrder(567)
    private RString dbT2002Fuka_seihofujoShurui;
    @TempTableColumnOrder(568)
    private FlexibleDate dbT2002Fuka_seihoKaishiYMD;
    @TempTableColumnOrder(569)
    private FlexibleDate dbT2002Fuka_seihoHaishiYMD;
    @TempTableColumnOrder(570)
    private FlexibleDate dbT2002Fuka_ronenKaishiYMD;
    @TempTableColumnOrder(571)
    private FlexibleDate dbT2002Fuka_ronenHaishiYMD;
    @TempTableColumnOrder(572)
    private FlexibleDate dbT2002Fuka_fukaYMD;
    @TempTableColumnOrder(573)
    private RString dbT2002Fuka_kazeiKubun;
    @TempTableColumnOrder(574)
    private RString dbT2002Fuka_setaikazeiKubun;
    @TempTableColumnOrder(575)
    private Decimal dbT2002Fuka_gokeiShotokuGaku;
    @TempTableColumnOrder(576)
    private Decimal dbT2002Fuka_nenkinShunyuGaku;
    @TempTableColumnOrder(577)
    private RString dbT2002Fuka_hokenryoDankai;
    @TempTableColumnOrder(578)
    private RString dbT2002Fuka_hokenryoDankai1;
    @TempTableColumnOrder(579)
    private Decimal dbT2002Fuka_nengakuHokenryo1;
    @TempTableColumnOrder(582)
    private FlexibleYearMonth dbT2002Fuka_tsukiwariStartYM1;
    @TempTableColumnOrder(581)
    private FlexibleYearMonth dbT2002Fuka_tsukiwariEndYM1;
    @TempTableColumnOrder(582)
    private RString dbT2002Fuka_hokenryoDankai2;
    @TempTableColumnOrder(583)
    private Decimal dbT2002Fuka_nengakuHokenryo2;
    @TempTableColumnOrder(584)
    private FlexibleYearMonth dbT2002Fuka_tsukiwariStartYM2;
    @TempTableColumnOrder(585)
    private FlexibleYearMonth dbT2002Fuka_tsukiwariEndYM2;
    @TempTableColumnOrder(586)
    private YMDHMS dbT2002Fuka_choteiNichiji;
    @TempTableColumnOrder(587)
    private RString dbT2002Fuka_choteiJiyu1;
    @TempTableColumnOrder(588)
    private RString dbT2002Fuka_choteiJiyu2;
    @TempTableColumnOrder(589)
    private RString dbT2002Fuka_choteiJiyu3;
    @TempTableColumnOrder(590)
    private RString dbT2002Fuka_choteiJiyu4;
    @TempTableColumnOrder(591)
    private RString dbT2002Fuka_koseiM;
    @TempTableColumnOrder(592)
    private Decimal dbT2002Fuka_gemmenMaeHokenryo;
    @TempTableColumnOrder(593)
    private Decimal dbT2002Fuka_gemmenGaku;
    @TempTableColumnOrder(594)
    private Decimal dbT2002Fuka_kakuteiHokenryo;
    @TempTableColumnOrder(595)
    private RString dbT2002Fuka_hokenryoDankaiKarisanntei;
    @TempTableColumnOrder(596)
    private int dbT2002Fuka_choshuHohoRirekiNo;
    @TempTableColumnOrder(597)
    private YMDHMS dbT2002Fuka_idoKijunNichiji;
    @TempTableColumnOrder(598)
    private RString dbT2002Fuka_kozaKubun;
    @TempTableColumnOrder(599)
    private RString dbT2002Fuka_kyokaisoKubun;
    @TempTableColumnOrder(600)
    private RString dbT2002Fuka_shokkenKubun;
    @TempTableColumnOrder(601)
    private LasdecCode dbT2002Fuka_fukaShichosonCode;
    @TempTableColumnOrder(602)
    private Decimal dbT2002Fuka_tkSaishutsuKampuGaku;
    @TempTableColumnOrder(603)
    private Decimal dbT2002Fuka_fuSaishutsuKampuGaku;
    @TempTableColumnOrder(604)
    private RString dbT2002Fuka_insertDantaiCd;
    @TempTableColumnOrder(605)
    private RDateTime dbT2002Fuka_insertTimestamp;
    @TempTableColumnOrder(606)
    private RString dbT2002Fuka_insertReamsLoginId;
    @TempTableColumnOrder(607)
    private UUID dbT2002Fuka_insertContextId;
    @TempTableColumnOrder(608)
    private boolean dbT2002Fuka_isDeleted;
    @TempTableColumnOrder(609)
    private int dbT2002Fuka_updateCount;
    @TempTableColumnOrder(610)
    private RDateTime ddbT2002Fuka_lastUpdateTimestamp;
    @TempTableColumnOrder(611)
    private RString dbT2002Fuka_lastUpdateReamsLoginId;
    @TempTableColumnOrder(612)
    private FlexibleYear dbT2003Kibetsu_choteiNendo;
    @TempTableColumnOrder(613)
    private FlexibleYear dbT2003Kibetsu_fukaNendo;
    @TempTableColumnOrder(614)
    private TsuchishoNo dbT2003Kibetsu_tsuchishoNo;
    @TempTableColumnOrder(615)
    private int dbT2003Kibetsu_rirekiNo;
    @TempTableColumnOrder(616)
    private RString dbT2003Kibetsu_choshuHouhou;
    @TempTableColumnOrder(617)
    private int dbT2003Kibetsu_ki;
    @TempTableColumnOrder(618)
    private RString dbT2003Kibetsu_insertDantaiCd;
    @TempTableColumnOrder(619)
    private RDateTime dbT2003Kibetsu_insertTimestamp;
    @TempTableColumnOrder(620)
    private RString dbT2003Kibetsu_insertReamsLoginId;
    @TempTableColumnOrder(621)
    private UUID dbT2003Kibetsu_insertContextId;
    @TempTableColumnOrder(622)
    private boolean dbT2003Kibetsu_isDeleted;
    @TempTableColumnOrder(623)
    private int dbT2003Kibetsu_updateCount;
    @TempTableColumnOrder(624)
    private RDateTime dbT2003Kibetsu_lastUpdateTimestamp;
    @TempTableColumnOrder(625)
    private RString dbT2003Kibetsu_lastUpdateReamsLoginId;
    @TempTableColumnOrder(626)
    private Decimal dbT2003Kibetsu_choteiId;
    @TempTableColumnOrder(627)
    private RString urT0705ChoteiKyotsu_insertDantaiCd;
    @TempTableColumnOrder(628)
    private RDateTime urT0705ChoteiKyotsu_insertTimestamp;
    @TempTableColumnOrder(629)
    private RString urT0705ChoteiKyotsu_insertReamsLoginId;
    @TempTableColumnOrder(630)
    private UUID urT0705ChoteiKyotsu_insertContextId;
    @TempTableColumnOrder(631)
    private boolean isDeleted;
    @TempTableColumnOrder(632)
    private int urT0705ChoteiKyotsu_updateCount;
    @TempTableColumnOrder(633)
    private RDateTime urT0705ChoteiKyotsu_lastUpdateTimestamp;
    @TempTableColumnOrder(634)
    private RString urT0705ChoteiKyotsu_lastUpdateReamsLoginId;
    @TempTableColumnOrder(635)
    private Long urT0705ChoteiKyotsu_choteiId;
    @TempTableColumnOrder(636)
    private Long urT0705ChoteiKyotsu_shunoId;
    @TempTableColumnOrder(637)
    private RYear urT0705ChoteiKyotsu_kaikeiNendo;
    @TempTableColumnOrder(638)
    private RYear urT0705ChoteiKyotsu_shoriNendo;
    @TempTableColumnOrder(639)
    private int urT0705ChoteiKyotsu_shoriNo;
    @TempTableColumnOrder(640)
    private int urT0705ChoteiKyotsu_koseiKaisu;
    @TempTableColumnOrder(641)
    private RString urT0705ChoteiKyotsu_choteiJiyuCode;
    @TempTableColumnOrder(642)
    private RDate urT0705ChoteiKyotsu_choteiYMD;
    @TempTableColumnOrder(643)
    private Decimal urT0705ChoteiKyotsu_choteigaku;
    @TempTableColumnOrder(644)
    private Decimal urT0705ChoteiKyotsu_shohizei;
    @TempTableColumnOrder(645)
    private RDate urT0705ChoteiKyotsu_nokigenYMD;
    @TempTableColumnOrder(646)
    private RDate urT0705ChoteiKyotsu_hoteiNokigenToYMD;
    @TempTableColumnOrder(647)
    private boolean urT0705ChoteiKyotsu_fukaShoriJokyo;
    @TempTableColumnOrder(648)
    private RString hihokenshaKubun;
    @TempTableColumnOrder(649)
    private Decimal zennendoTokuchoKibetsuKingaku01;
    @TempTableColumnOrder(650)
    private Decimal zennendoTokuchoKibetsuKingaku02;
    @TempTableColumnOrder(651)
    private Decimal zennendoTokuchoKibetsuKingaku03;
    @TempTableColumnOrder(652)
    private Decimal zennendoTokuchoKibetsuKingaku04;
    @TempTableColumnOrder(653)
    private Decimal zennendoTokuchoKibetsuKingaku05;
    @TempTableColumnOrder(654)
    private Decimal zennendoTokuchoKibetsuKingaku06;

}
