/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
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
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 高額サービス等支給（不支給）決定通知書情報一時TBLと事業高額決定通知書情報一時TBL作成する用エンティティクラスです。
 *
 * @reamsid_L DBC-2000-030 xicongwang
 */
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
@SuppressWarnings("PMD.UnusedPrivateField")
public class KetteiTsuchishoInfoTempEntity extends DbTableEntityBase<KetteiTsuchishoInfoTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(2)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(3)
    private int rirekiNo;
    @TempTableColumnOrder(4)
    private HokenshaNo shoKisaiHokenshaNo;
    @TempTableColumnOrder(5)
    private FlexibleDate uketsukeYMD;
    @TempTableColumnOrder(6)
    private RString shiharaiHohoKubunCode;
    @TempTableColumnOrder(7)
    private RString shiharaiBasho;
    @TempTableColumnOrder(8)
    private FlexibleDate shiharaiKaishiYMD;
    @TempTableColumnOrder(9)
    private FlexibleDate shiharaiShuryoYMD;
    @TempTableColumnOrder(10)
    private RString shiharaiKaishiTime;
    @TempTableColumnOrder(11)
    private RString shiharaiShuryoTime;
    @TempTableColumnOrder(12)
    private FlexibleDate ketteiYMD;
    @TempTableColumnOrder(13)
    private RString tsuchishoNo;
    @TempTableColumnOrder(14)
    private RString fushikyuRiyu;
    @TempTableColumnOrder(15)
    private RString shikyuKubunCode;
    @TempTableColumnOrder(16)
    private Decimal shikyuKingaku;

    @TempTableColumnOrder(17)
    private RString shikyuKingakuCode;

    @TempTableColumnOrder(18)
    private RString shinsaHohoKubun;
    @TempTableColumnOrder(19)
    private Decimal honninShiharaiGaku;
    @TempTableColumnOrder(20)
    private boolean jidoShokanTaishoFlag;
    @TempTableColumnOrder(21)
    private RString shinsaShikyuKubunCode;
    @TempTableColumnOrder(22)
    private Decimal kogakuShikyuGaku;

    @TempTableColumnOrder(23)
    private KinyuKikanCode kinyuKikanCode;
    @TempTableColumnOrder(24)
    private RString kikan_name;
    @TempTableColumnOrder(25)
    private KinyuKikanShitenCode kinyuKikanShitenCode;
    @TempTableColumnOrder(26)
    private RString kikanShiten_name;
    @TempTableColumnOrder(27)
    private RString yokinShubetsu;
    @TempTableColumnOrder(28)
    private RString yokinShubetsuRyakusho;
    @TempTableColumnOrder(29)
    private RString kozaNo;
    @TempTableColumnOrder(30)
    private ShikibetsuCode kozaMeigininShikibetsuCode;
    @TempTableColumnOrder(31)
    private FlexibleDate shuryoYMD;
    @TempTableColumnOrder(32)
    private RString tsuchoNo;

    @TempTableColumnOrder(33)
    private FlexibleDate shikakuSoshitsuYMD;
    @TempTableColumnOrder(34)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(35)
    private RString shikakuSoshitsuJiyuCode;

    @TempTableColumnOrder(36)
    private Code yokaigoJotaiKubunCode;
    @TempTableColumnOrder(37)
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    @TempTableColumnOrder(38)
    private FlexibleDate ninteiYukoKikanShuryoYMD;

    @TempTableColumnOrder(39)
    private ShikibetsuCode shikibetsuTaisho_shikibetsuCode;
    @TempTableColumnOrder(40)
    private LasdecCode shikibetsuTaisho_genLasdecCode;
    @TempTableColumnOrder(41)
    private LasdecCode shikibetsuTaisho_kyuLasdecCode;
    @TempTableColumnOrder(42)
    private int shikibetsuTaisho_kyuLasdecCodeRenban;
    @TempTableColumnOrder(43)
    private GyomuCode shikibetsuTaisho_gyomuCode;
    @TempTableColumnOrder(44)
    private int shikibetsuTaisho_rirekiNo;
    @TempTableColumnOrder(45)
    private boolean shikibetsuTaisho_currentFlag;
    @TempTableColumnOrder(46)
    private RString shikibetsuTaisho_juminShubetsuCode;
    @TempTableColumnOrder(47)
    private KojinNo shikibetsuTaisho_kojinNo;
    @TempTableColumnOrder(48)
    private HojinNo shikibetsuTaisho_hojinNo;
    @TempTableColumnOrder(49)
    private FlexibleDate shikibetsuTaisho_shoriYMD;
    @TempTableColumnOrder(50)
    private RString shikibetsuTaisho_idoJiyuCode;
    @TempTableColumnOrder(51)
    private FlexibleDate shikibetsuTaisho_idoYMD;
    @TempTableColumnOrder(52)
    private RString shikibetsuTaisho_todokedeJiyuCode;
    @TempTableColumnOrder(53)
    private FlexibleDate shikibetsuTaisho_todokedeYMD;
    @TempTableColumnOrder(54)
    private Code shikibetsuTaisho_idoRiyuCode;
    @TempTableColumnOrder(55)
    private AtenaMeisho shikibetsuTaisho_meisho;
    @TempTableColumnOrder(56)
    private AtenaKanaMeisho shikibetsuTaisho_kanaMeisho;
    @TempTableColumnOrder(57)
    private RString shikibetsuTaisho_shimeiRiyoKubun;
    @TempTableColumnOrder(58)
    private RString shikibetsuTaisho_kannaiKangaiKubun;
    @TempTableColumnOrder(59)
    private YubinNo shikibetsuTaisho_yubinNo;
    @TempTableColumnOrder(60)
    private ChoikiCode shikibetsuTaisho_choikiCode;
    @TempTableColumnOrder(61)
    private ZenkokuJushoCode shikibetsuTaisho_zenkokuJushoCode;
    @TempTableColumnOrder(62)
    private AtenaJusho shikibetsuTaisho_jusho;
    @TempTableColumnOrder(63)
    private BanchiCode shikibetsuTaisho_banchiCode1;
    @TempTableColumnOrder(64)
    private BanchiCode shikibetsuTaisho_banchiCode2;
    @TempTableColumnOrder(65)
    private BanchiCode shikibetsuTaisho_banchiCode3;
    @TempTableColumnOrder(66)
    private BanchiCode shikibetsuTaisho_banchiCode4;
    @TempTableColumnOrder(67)
    private AtenaBanchi shikibetsuTaisho_banchi;
    @TempTableColumnOrder(68)
    private Katagaki shikibetsuTaisho_katagaki;
    @TempTableColumnOrder(69)
    private boolean shikibetsuTaisho_katagakiInjiFlag;
    @TempTableColumnOrder(70)
    private GyoseikuCode shikibetsuTaisho_gyoseikuCode;
    @TempTableColumnOrder(71)
    private RString shikibetsuTaisho_gyoseikuName;
    @TempTableColumnOrder(72)
    private ChikuCode shikibetsuTaisho_chikuCode1;
    @TempTableColumnOrder(73)
    private RString shikibetsuTaisho_chikuName1;
    @TempTableColumnOrder(74)
    private ChikuCode shikibetsuTaisho_chikuCode2;
    @TempTableColumnOrder(75)
    private RString shikibetsuTaisho_chikuName2;
    @TempTableColumnOrder(76)
    private ChikuCode shikibetsuTaisho_chikuCode3;
    @TempTableColumnOrder(77)
    private RString shikibetsuTaisho_chikuName3;
    @TempTableColumnOrder(78)
    private ShogakkokuCode shikibetsuTaisho_shogakkokuCode;
    @TempTableColumnOrder(79)
    private RString shikibetsuTaisho_shogakkokuName;
    @TempTableColumnOrder(80)
    private ChugakkokuCode shikibetsuTaisho_chugakkokuCode;
    @TempTableColumnOrder(81)
    private RString shikibetsuTaisho_chugakkokuName;
    @TempTableColumnOrder(82)
    private TohyokuCode shikibetsuTaisho_tohyokuCode;
    @TempTableColumnOrder(83)
    private RString shikibetsuTaisho_tohyokuName;
    @TempTableColumnOrder(84)
    private RString shikibetsuTaisho_juminJotaiCode;
    @TempTableColumnOrder(85)
    private SetaiCode shikibetsuTaisho_setaiCode;
    @TempTableColumnOrder(86)
    private FlexibleDate shikibetsuTaisho_seinengappiYMD;
    @TempTableColumnOrder(87)
    private RString shikibetsuTaisho_seinengappiFushoKubun;
    @TempTableColumnOrder(88)
    private RString shikibetsuTaisho_seibetsuCode;
    @TempTableColumnOrder(89)
    private TsuzukigaraCode shikibetsuTaisho_tsuzukigaraCode;
    @TempTableColumnOrder(90)
    private RString shikibetsuTaisho_tsuzukigara;
    @TempTableColumnOrder(91)
    private int shikibetsuTaisho_kazokuNo;
    @TempTableColumnOrder(92)
    private int shikibetsuTaisho_juminhyoHyojijun;
    @TempTableColumnOrder(93)
    private FlexibleDate shikibetsuTaisho_kikaYMD;
    @TempTableColumnOrder(94)
    private AtenaMeisho shikibetsuTaisho_kanjiShimei;
    @TempTableColumnOrder(95)
    private AtenaKanaMeisho shikibetsuTaisho_kanaShimei;
    @TempTableColumnOrder(96)
    private ZenkokuJushoCode shikibetsuTaisho_honsekiZenkokuJushoCode;
    @TempTableColumnOrder(97)
    private ChoikiCode shikibetsuTaisho_honsekiChoikiCode;
    @TempTableColumnOrder(98)
    private AtenaJusho shikibetsuTaisho_honsekiJusho;
    @TempTableColumnOrder(99)
    private AtenaBanchi shikibetsuTaisho_honsekiBanchi;
    @TempTableColumnOrder(100)
    private AtenaMeisho shikibetsuTaisho_hittosha;
    @TempTableColumnOrder(101)
    private AtenaMeisho shikibetsuTaisho_gaikokujinShimei;
    @TempTableColumnOrder(102)
    private AtenaMeisho shikibetsuTaisho_gaikokujinHeikimei;
    @TempTableColumnOrder(103)
    private AtenaKanaMeisho shikibetsuTaisho_gaikokujinKanaShimei;
    @TempTableColumnOrder(104)
    private AtenaKanaMeisho shikibetsuTaisho_katakanaHyoki;
    @TempTableColumnOrder(105)
    private AtenaMeisho shikibetsuTaisho_tsushomei;
    @TempTableColumnOrder(106)
    private AtenaKanaMeisho shikibetsuTaisho_kanaTsushomei;
    @TempTableColumnOrder(107)
    private Code shikibetsuTaisho_kokusekiChiikiCode;
    @TempTableColumnOrder(108)
    private Code shikibetsuTaisho_zairyuShikakuCode;
    @TempTableColumnOrder(109)
    private RString shikibetsuTaisho_zairyuKikanCode;
    @TempTableColumnOrder(110)
    private FlexibleDate shikibetsuTaisho_zairyuKikantoManryoYMD;
    @TempTableColumnOrder(111)
    private RString shikibetsuTaisho_zairyuCardtoNo;
    @TempTableColumnOrder(112)
    private FlexibleDate shikibetsuTaisho_zairyuCardtoYukoYMD;
    @TempTableColumnOrder(113)
    private RString shikibetsuTaisho_dai30Jono45niKiteisuruKubun;
    @TempTableColumnOrder(114)
    private ShikibetsuCode shikibetsuTaisho_setainushiShikibetsuCode;
    @TempTableColumnOrder(115)
    private AtenaMeisho shikibetsuTaisho_setainushiMei;
    @TempTableColumnOrder(116)
    private Code shikibetsuTaisho_hojinKeitaiCode;
    @TempTableColumnOrder(117)
    private RString shikibetsuTaisho_hojinKeitaiMeisho;
    @TempTableColumnOrder(118)
    private RString shikibetsuTaisho_hojinKeitaiRyakusho;
    @TempTableColumnOrder(119)
    private RString shikibetsuTaisho_hojinMeishoHenshuKubun;
    @TempTableColumnOrder(120)
    private RString shikibetsuTaisho_hojinKeitaiRyakushoKubun;
    @TempTableColumnOrder(121)
    private AtenaMeisho shikibetsuTaisho_hojinMeisho;
    @TempTableColumnOrder(122)
    private AtenaKanaMeisho shikibetsuTaisho_hojinKanaMeisho;
    @TempTableColumnOrder(123)
    private AtenaMeisho shikibetsuTaisho_hojinShitenMeisho;
    @TempTableColumnOrder(124)
    private AtenaKanaMeisho shikibetsuTaisho_hojinShitenKanaMeisho;
    @TempTableColumnOrder(125)
    private ShikibetsuCode shikibetsuTaisho_daihyoshaShikibetsuCode;
    @TempTableColumnOrder(126)
    private AtenaMeisho shikibetsuTaisho_daihyoshaShimei;
    @TempTableColumnOrder(127)
    private AtenaKanaMeisho shikibetsuTaisho_daihyoshaKanaShimei;
    @TempTableColumnOrder(128)
    private RString shikibetsuTaisho_daihyoshaJuminShubetsu;
    @TempTableColumnOrder(129)
    private AtenaMeisho shikibetsuTaisho_daihyoshaNihonjinShimei;
    @TempTableColumnOrder(130)
    private AtenaKanaMeisho shikibetsuTaisho_daihyoshaNihonjinKanaShimei;
    @TempTableColumnOrder(131)
    private AtenaMeisho shikibetsuTaisho_daihyoshaGaikokujinShimei;
    @TempTableColumnOrder(132)
    private AtenaMeisho shikibetsuTaisho_daihyoshaGaikokujinHeikimei;
    @TempTableColumnOrder(133)
    private AtenaKanaMeisho shikibetsuTaisho_daihyoshaGaikokujinKanaShimei;
    @TempTableColumnOrder(134)
    private AtenaMeisho shikibetsuTaisho_daihyoshaTsushomei;
    @TempTableColumnOrder(135)
    private RString shikibetsuTaisho_daihyoshaShimeiRiyoKubun;
    @TempTableColumnOrder(136)
    private AtenaKanaMeisho shikibetsuTaisho_daihyoshaKanaTsushomei;
    @TempTableColumnOrder(137)
    private RString shikibetsuTaisho_daihyoshaKannaiKangaiKubun;
    @TempTableColumnOrder(138)
    private YubinNo shikibetsuTaisho_daihyoshaYubinNo;
    @TempTableColumnOrder(139)
    private ChoikiCode shikibetsuTaisho_daihyoshaChoikiCode;
    @TempTableColumnOrder(140)
    private ZenkokuJushoCode shikibetsuTaisho_daihyoshaZenkokuJushoCode;
    @TempTableColumnOrder(141)
    private AtenaJusho shikibetsuTaisho_daihyoshaJusho;
    @TempTableColumnOrder(142)
    private BanchiCode shikibetsuTaisho_daihyoshaBanchiCode1;
    @TempTableColumnOrder(143)
    private BanchiCode shikibetsuTaisho_daihyoshaBanchiCode2;
    @TempTableColumnOrder(144)
    private BanchiCode shikibetsuTaisho_daihyoshaBanchiCode3;
    @TempTableColumnOrder(145)
    private BanchiCode shikibetsuTaisho_daihyoshaBanchiCode4;
    @TempTableColumnOrder(146)
    private AtenaBanchi shikibetsuTaisho_daihyoshaBanchi;
    @TempTableColumnOrder(147)
    private Katagaki shikibetsuTaisho_daihyoshaKatagaki;
    @TempTableColumnOrder(148)
    private Code shikibetsuTaisho_ninkachiendantaiTorokuShikakuKubun;
    @TempTableColumnOrder(149)
    private FlexibleDate shikibetsuTaisho_ninkachiendantaiNinkaYMD;
    @TempTableColumnOrder(150)
    private RString shikibetsuTaisho_kojinHojinKBN;
    @TempTableColumnOrder(151)
    private AtenaMeisho shikibetsuTaisho_kyoyushaMeisho;
    @TempTableColumnOrder(152)
    private AtenaKanaMeisho shikibetsuTaisho_kyoyushaKanaMeisho;
    @TempTableColumnOrder(153)
    private RString shikibetsuTaisho_torokuJiyuCode;
    @TempTableColumnOrder(154)
    private FlexibleDate shikibetsuTaisho_torokuIdoYMD;
    @TempTableColumnOrder(155)
    private FlexibleDate shikibetsuTaisho_torokuTodokedeYMD;
    @TempTableColumnOrder(156)
    private RString shikibetsuTaisho_juteiJiyuCode;
    @TempTableColumnOrder(157)
    private FlexibleDate shikibetsuTaisho_juteiIdoYMD;
    @TempTableColumnOrder(158)
    private FlexibleDate shikibetsuTaisho_juteiTodokedeYMD;
    @TempTableColumnOrder(159)
    private RString shikibetsuTaisho_shojoJiyuCode;
    @TempTableColumnOrder(160)
    private FlexibleDate shikibetsuTaisho_shojoIdoYMD;
    @TempTableColumnOrder(161)
    private FlexibleDate shikibetsuTaisho_shojoTodokedeYMD;
    @TempTableColumnOrder(162)
    private YubinNo shikibetsuTaisho_jutonaiYubinNo;
    @TempTableColumnOrder(163)
    private ChoikiCode shikibetsuTaisho_jutonaiChoikiCode;
    @TempTableColumnOrder(164)
    private RString shikibetsuTaisho_jutonaiJusho;
    @TempTableColumnOrder(165)
    private BanchiCode shikibetsuTaisho_jutonaiBanchiCode1;
    @TempTableColumnOrder(166)
    private BanchiCode shikibetsuTaisho_jutonaiBanchiCode2;
    @TempTableColumnOrder(167)
    private BanchiCode shikibetsuTaisho_jutonaiBanchiCode3;
    @TempTableColumnOrder(168)
    private BanchiCode shikibetsuTaisho_jutonaiBanchiCode4;
    @TempTableColumnOrder(169)
    private AtenaBanchi shikibetsuTaisho_jutonaiBanchi;
    @TempTableColumnOrder(170)
    private Katagaki shikibetsuTaisho_jutonaiKatagaki;
    @TempTableColumnOrder(171)
    private boolean shikibetsuTaisho_jutonaiKatagakiInjiFlag;
    @TempTableColumnOrder(172)
    private YubinNo shikibetsuTaisho_tennyumaeYubinNo;
    @TempTableColumnOrder(173)
    private ZenkokuJushoCode shikibetsuTaisho_tennyumaeZenkokuJushoCode;
    @TempTableColumnOrder(174)
    private AtenaJusho shikibetsuTaisho_tennyumaeJusho;
    @TempTableColumnOrder(175)
    private AtenaBanchi shikibetsuTaisho_tennyumaeBanchi;
    @TempTableColumnOrder(176)
    private Katagaki shikibetsuTaisho_tennyumaeKatagaki;
    @TempTableColumnOrder(177)
    private RString shikibetsuTaisho_tennyumaeSetainushimei;
    @TempTableColumnOrder(178)
    private AtenaMeisho shikibetsuTaisho_tennyumaeKyusei;
    @TempTableColumnOrder(179)
    private YubinNo shikibetsuTaisho_saishuJutochiYubinNo;
    @TempTableColumnOrder(180)
    private ZenkokuJushoCode shikibetsuTaisho_saishuJutochiZenkokuJushoCode;
    @TempTableColumnOrder(181)
    private AtenaJusho shikibetsuTaisho_saishuJutochiJusho;
    @TempTableColumnOrder(182)
    private AtenaBanchi shikibetsuTaisho_saishuJutochiBanchi;
    @TempTableColumnOrder(183)
    private Katagaki shikibetsuTaisho_saishuJutochiKatagaki;
    @TempTableColumnOrder(184)
    private RString shikibetsuTaisho_saishuJutochiSetainushimei;
    @TempTableColumnOrder(185)
    private FlexibleDate shikibetsuTaisho_tenshutsuYoteiIdoYMD;
    @TempTableColumnOrder(186)
    private YubinNo shikibetsuTaisho_tenshutsuYoteiYubinNo;
    @TempTableColumnOrder(187)
    private ZenkokuJushoCode shikibetsuTaisho_tenshutsuYoteiZenkokuJushoCode;
    @TempTableColumnOrder(188)
    private AtenaJusho shikibetsuTaisho_tenshutsuYoteiJusho;
    @TempTableColumnOrder(189)
    private AtenaBanchi shikibetsuTaisho_tenshutsuYoteiBanchi;
    @TempTableColumnOrder(190)
    private Katagaki shikibetsuTaisho_tenshutsuYoteiKatagaki;
    @TempTableColumnOrder(191)
    private RString shikibetsuTaisho_tenshutsuYoteiSetainushimei;
    @TempTableColumnOrder(192)
    private FlexibleDate shikibetsuTaisho_tenshutsuKakuteiIdoYMD;
    @TempTableColumnOrder(193)
    private FlexibleDate shikibetsuTaisho_tenshutsuKakuteiTsuchiYMD;
    @TempTableColumnOrder(194)
    private YubinNo shikibetsuTaisho_tenshutsuKakuteiYubinNo;
    @TempTableColumnOrder(195)
    private ZenkokuJushoCode shikibetsuTaisho_tenshutsuKakuteiZenkokuJushoCode;
    @TempTableColumnOrder(196)
    private AtenaJusho shikibetsuTaisho_tenshutsuKakuteiJusho;
    @TempTableColumnOrder(197)
    private AtenaBanchi shikibetsuTaisho_tenshutsuKakuteiBanchi;
    @TempTableColumnOrder(198)
    private Katagaki shikibetsuTaisho_tenshutsuKakuteiKatagaki;
    @TempTableColumnOrder(199)
    private RString shikibetsuTaisho_tenshutsuKakuteiSetainushimei;
    @TempTableColumnOrder(200)
    private RString shikibetsuTaisho_juminhyoUtsushiHakkoSeigyoKubun;
    @TempTableColumnOrder(201)
    private TelNo shikibetsuTaisho_renrakusaki1;
    @TempTableColumnOrder(202)
    private TelNo shikibetsuTaisho_kensakuRenrakusaki1;
    @TempTableColumnOrder(203)
    private Code shikibetsuTaisho_renrakusakiKubun1;
    @TempTableColumnOrder(204)
    private TelNo shikibetsuTaisho_renrakusaki2;
    @TempTableColumnOrder(205)
    private TelNo shikibetsuTaisho_kensakuRenrakusaki2;
    @TempTableColumnOrder(206)
    private Code shikibetsuTaisho_renrakusakiKubun2;
    @TempTableColumnOrder(207)
    private TelNo shikibetsuTaisho_renrakusaki3;
    @TempTableColumnOrder(208)
    private TelNo shikibetsuTaisho_kensakuRenrakusaki3;
    @TempTableColumnOrder(209)
    private Code shikibetsuTaisho_renrakusakiKubun3;
    @TempTableColumnOrder(210)
    private MailAddress shikibetsuTaisho_mailAddress;
    @TempTableColumnOrder(211)
    private RString shikibetsuTaisho_biko;
    @TempTableColumnOrder(212)
    private RDateTime shikibetsuTaisho_lastUpdateTimestamp;
    @TempTableColumnOrder(213)
    private RString shikibetsuTaisho_lastUpdateReamsLoginId;
    @TempTableColumnOrder(214)
    private int shikibetsuTaisho_jutogaiKanriUpdateCount;
    @TempTableColumnOrder(215)
    private TorokuNo shikibetsuTaisho_jutogaiKanriTorokuNo;
    @TempTableColumnOrder(216)
    private int shikibetsuTaisho_jutogaiKojinKihonUpdateCount;
    @TempTableColumnOrder(217)
    private TorokuNo shikibetsuTaisho_jutogaiKojinKihonTorokuNo;
    @TempTableColumnOrder(218)
    private int shikibetsuTaisho_hojinUpdateCount;
    @TempTableColumnOrder(219)
    private TorokuNo shikibetsuTaisho_hojinTorokuNo;
    @TempTableColumnOrder(220)
    private int shikibetsuTaisho_kyoyushaUpdateCount;
    @TempTableColumnOrder(221)
    private TorokuNo shikibetsuTaisho_kyoyushaTorokuNo;
    @TempTableColumnOrder(222)
    private int shikibetsuTaisho_jutogaiNihonjinUpdateCount;
    @TempTableColumnOrder(223)
    private TorokuNo shikibetsuTaisho_jutogaiNihonjinTorokuNo;
    @TempTableColumnOrder(224)
    private int shikibetsuTaisho_jutogaiGaikokujinUpdateCount;
    @TempTableColumnOrder(225)
    private TorokuNo shikibetsuTaisho_jutogaiGaikokujinTorokuNo;
    @TempTableColumnOrder(226)
    private TorokuNo shikibetsuTaisho_shimeiSearchTorokuNo;
    @TempTableColumnOrder(227)
    private int shikibetsuTaisho_yusenShimeiUpdateCount;
    @TempTableColumnOrder(228)
    private RDateTime shikibetsuTaisho_yusenShimeiTimestamp;
    @TempTableColumnOrder(229)
    private RString shikibetsuTaisho_kanaName;
    @TempTableColumnOrder(230)
    private RString shikibetsuTaisho_gaikokujinKanaName;
    @TempTableColumnOrder(231)
    private RString shikibetsuTaisho_kanaTsushoName;

    @TempTableColumnOrder(232)
    private ShikibetsuCode atesaki_shikibetsuCode;
    @TempTableColumnOrder(233)
    private RString atesaki_atesakiShubetsu;
    @TempTableColumnOrder(234)
    private RString atesaki_gyomubetsuPrimaryKey;
    @TempTableColumnOrder(235)
    private GyomuCode atesaki_gyomuCode;
    @TempTableColumnOrder(236)
    private SubGyomuCode atesaki_subGyomuCode;
    @TempTableColumnOrder(237)
    private RString atesaki_gyomuGroupCode;
    @TempTableColumnOrder(238)
    private RString atesaki_gyomuGroupName;
    @TempTableColumnOrder(239)
    private RString atesaki_subGyomuGroupCode;
    @TempTableColumnOrder(240)
    private RString atesaki_subGyomuGroupName;
    @TempTableColumnOrder(241)
    private KamokuCode atesaki_kamokuCode;
    @TempTableColumnOrder(242)
    private RString atesaki_gyomuKoyuKey;
    @TempTableColumnOrder(243)
    private RString atesaki_kannaiKangaiKubun;
    @TempTableColumnOrder(244)
    private ZenkokuJushoCode atesaki_zenkokuJushoCode;
    @TempTableColumnOrder(245)
    private ChoikiCode atesaki_choikiCode;
    @TempTableColumnOrder(246)
    private AtenaJusho atesaki_jusho;
    @TempTableColumnOrder(247)
    private YubinNo atesaki_yubinNo;
    @TempTableColumnOrder(248)
    private BanchiCode atesaki_banchiCode1;
    @TempTableColumnOrder(249)
    private BanchiCode atesaki_banchiCode2;
    @TempTableColumnOrder(250)
    private BanchiCode atesaki_banchiCode3;
    @TempTableColumnOrder(251)
    private BanchiCode atesaki_banchiCode4;
    @TempTableColumnOrder(252)
    private AtenaBanchi atesaki_banchi;
    @TempTableColumnOrder(253)
    private boolean atesaki_katagakiInjiFlag;
    @TempTableColumnOrder(254)
    private Katagaki atesaki_katagaki;
    @TempTableColumnOrder(255)
    private GyoseikuCode atesaki_gyoseikuCode;
    @TempTableColumnOrder(256)
    private ChikuCode atesaki_chikuCode1;
    @TempTableColumnOrder(257)
    private RString atesaki_chiku1;
    @TempTableColumnOrder(258)
    private ChikuCode atesaki_chikuCode2;
    @TempTableColumnOrder(259)
    private RString atesaki_chiku2;
    @TempTableColumnOrder(260)
    private ChikuCode atesaki_chikuCode3;
    @TempTableColumnOrder(261)
    private RString atesaki_chiku3;
    @TempTableColumnOrder(262)
    private RString atesaki_gyoseiku;
    @TempTableColumnOrder(263)
    private RString atesaki_juminShubetsuCode;
    @TempTableColumnOrder(264)
    private RString atesaki_juminJotaiCode;
    @TempTableColumnOrder(265)
    private AtenaMeisho atesaki_kanjiShimei;
    @TempTableColumnOrder(266)
    private AtenaKanaMeisho atesaki_kanaShimei;
    @TempTableColumnOrder(267)
    private AtenaMeisho atesaki_gaikokujinShimei;
    @TempTableColumnOrder(268)
    private AtenaMeisho atesaki_gaikokujinHeikimei;
    @TempTableColumnOrder(269)
    private AtenaKanaMeisho atesaki_gaikokujinKanaShimei;
    @TempTableColumnOrder(270)
    private AtenaMeisho atesaki_tsushomei;
    @TempTableColumnOrder(271)
    private AtenaKanaMeisho atesaki_kanaTsushomei;
    @TempTableColumnOrder(272)
    private RString atesaki_shimeiRiyoKubun;
    @TempTableColumnOrder(273)
    private AtenaMeisho atesaki_kyoyushaMeisho;
    @TempTableColumnOrder(274)
    private AtenaKanaMeisho atesaki_kyoyushaKanaMeisho;
    @TempTableColumnOrder(275)
    private Code atesaki_hojinKeitaiCode;
    @TempTableColumnOrder(276)
    private RString atesaki_hojinMeiHenshuKubun;
    @TempTableColumnOrder(277)
    private RString atesaki_hojinKeitaiRyakushoKubun;
    @TempTableColumnOrder(278)
    private AtenaMeisho atesaki_hojinMeisho;
    @TempTableColumnOrder(279)
    private AtenaKanaMeisho atesaki_hojinKanaMeisho;
    @TempTableColumnOrder(280)
    private AtenaMeisho atesaki_hojinShitenMeisho;
    @TempTableColumnOrder(281)
    private AtenaKanaMeisho atesaki_hojinShitenKanaMeisho;
    @TempTableColumnOrder(282)
    private AtenaMeisho atesaki_sofusakiMeisho;
    @TempTableColumnOrder(283)
    private AtenaKanaMeisho atesaki_sofusakiKanaMeisho;
    @TempTableColumnOrder(284)
    private TelNo atesaki_renrakusaki1;
    @TempTableColumnOrder(285)
    private TelNo atesaki_renrakusaki2;
    @TempTableColumnOrder(286)
    private TelNo atesaki_renrakusaki3;
    @TempTableColumnOrder(287)
    private Code atesaki_renrakusakiKubun1;
    @TempTableColumnOrder(288)
    private Code atesaki_renrakusakiKubun2;
    @TempTableColumnOrder(289)
    private Code atesaki_renrakusakiKubun3;
    @TempTableColumnOrder(290)
    private MailAddress atesaki_mailAddress;
    @TempTableColumnOrder(291)
    private RString atesaki_biko;
    @TempTableColumnOrder(292)
    private Code atesaki_dainoKankeiCode;
    @TempTableColumnOrder(293)
    private RString atesaki_honninJuminShubetsuCode;
    @TempTableColumnOrder(294)
    private RString atesaki_honninJuminJotaiCode;
    @TempTableColumnOrder(295)
    private AtenaMeisho atesaki_honninKanjiShimei;
    @TempTableColumnOrder(296)
    private AtenaKanaMeisho atesaki_honninKanaShimei;
    @TempTableColumnOrder(297)
    private AtenaMeisho atesaki_honninGaikokujinShimei;
    @TempTableColumnOrder(298)
    private AtenaMeisho atesaki_honninGaikokujinHeikimei;
    @TempTableColumnOrder(299)
    private AtenaKanaMeisho atesaki_honninGaikokujinKanaShimei;
    @TempTableColumnOrder(300)
    private AtenaMeisho atesaki_honninTsushomei;
    @TempTableColumnOrder(301)
    private AtenaKanaMeisho atesaki_honninKanaTsushomei;
    @TempTableColumnOrder(302)
    private RString atesaki_honninShimeiRiyoKubun;
    @TempTableColumnOrder(303)
    private AtenaMeisho atesaki_honninKyoyushaMeisho;
    @TempTableColumnOrder(304)
    private AtenaKanaMeisho atesaki_honninKyoyushaKanaMeisho;
    @TempTableColumnOrder(305)
    private Code atesaki_honninHojinKeitaiCode;
    @TempTableColumnOrder(306)
    private RString atesaki_honninHojinMeiHenshuKubun;
    @TempTableColumnOrder(307)
    private RString atesaki_honninHojinKeitaiRyakushoKubun;
    @TempTableColumnOrder(308)
    private AtenaMeisho atesaki_honninHojinMeisho;
    @TempTableColumnOrder(309)
    private AtenaKanaMeisho atesaki_honninHojinKanaMeisho;
    @TempTableColumnOrder(310)
    private AtenaMeisho atesaki_honninHojinShitenMeisho;
    @TempTableColumnOrder(311)
    private AtenaKanaMeisho atesaki_honninHojinShitenKanaMeisho;
    @TempTableColumnOrder(312)
    private ShikibetsuCode atesaki_honninDaihyoshaShikibetsuCode;
    @TempTableColumnOrder(313)
    private RString atesaki_honninDaihyoshaJuminShubetsuCode;
    @TempTableColumnOrder(314)
    private AtenaMeisho atesaki_honninDaihyoshaShimei;
    @TempTableColumnOrder(315)
    private AtenaKanaMeisho atesaki_honninDaihyoshaKanaShimei;
    @TempTableColumnOrder(316)
    private AtenaMeisho atesaki_honninDaihyoshaNihonjinShimei;
    @TempTableColumnOrder(317)
    private AtenaKanaMeisho atesaki_honninDaihyoshaNihonjinKanaShimei;
    @TempTableColumnOrder(318)
    private AtenaMeisho atesaki_honninDaihyoshaGaikokujinShimei;
    @TempTableColumnOrder(319)
    private AtenaMeisho atesaki_honninDaihyoshaGaikokujinHeikimei;
    @TempTableColumnOrder(320)
    private AtenaKanaMeisho atesaki_honninDaihyoshaGaikokujinKanaShimei;
    @TempTableColumnOrder(321)
    private AtenaMeisho atesaki_honninDaihyoshaTsushomei;
    @TempTableColumnOrder(322)
    private RString atesaki_honninDaihyoshaShimeiRiyoKubun;
    @TempTableColumnOrder(323)
    private AtenaKanaMeisho atesaki_honninDaihyoshaKanaTsushomei;
    @TempTableColumnOrder(324)
    private ShikibetsuCode atesaki_setainushiShikibetsuCode;
    @TempTableColumnOrder(325)
    private RString atesaki_setainushiKannaiKangaiKubun;
    @TempTableColumnOrder(326)
    private ZenkokuJushoCode atesaki_setainushiZenkokuJushoCode;
    @TempTableColumnOrder(327)
    private ChoikiCode atesaki_setainushiChoikiCode;
    @TempTableColumnOrder(328)
    private AtenaJusho atesaki_setainushiJusho;
    @TempTableColumnOrder(329)
    private YubinNo atesaki_setainushiYubinNo;
    @TempTableColumnOrder(330)
    private BanchiCode atesaki_setainushiBanchiCode1;
    @TempTableColumnOrder(331)
    private BanchiCode atesaki_setainushiBanchiCode2;
    @TempTableColumnOrder(332)
    private BanchiCode atesaki_setainushiBanchiCode3;
    @TempTableColumnOrder(333)
    private BanchiCode atesaki_setainushiBanchiCode4;
    @TempTableColumnOrder(334)
    private AtenaBanchi atesaki_setainushiBanchi;
    @TempTableColumnOrder(335)
    private boolean atesaki_setainushiKatagakiInjiFlag;
    @TempTableColumnOrder(336)
    private Katagaki atesaki_setainushiKatagaki;
    @TempTableColumnOrder(337)
    private GyoseikuCode atesaki_setainushiGyoseikuCode;
    @TempTableColumnOrder(338)
    private RString atesaki_setainushiGyoseikuName;
    @TempTableColumnOrder(339)
    private RString atesaki_setainushiJuminShubetsuCode;
    @TempTableColumnOrder(340)
    private RString atesaki_setainushiJuminJotaiCode;
    @TempTableColumnOrder(341)
    private AtenaMeisho atesaki_setainushiKanjiShimei;
    @TempTableColumnOrder(342)
    private AtenaKanaMeisho atesaki_setainushiKanaShimei;
    @TempTableColumnOrder(343)
    private AtenaMeisho atesaki_setainushiGaikokujinShimei;
    @TempTableColumnOrder(344)
    private AtenaMeisho atesaki_setainushiGaikokujinHeikimei;
    @TempTableColumnOrder(345)
    private AtenaKanaMeisho atesaki_setainushiGaikokujinKanaShimei;
    @TempTableColumnOrder(346)
    private AtenaMeisho atesaki_setainushiTsushomei;
    @TempTableColumnOrder(347)
    private AtenaKanaMeisho atesaki_setainushiKanaTsushomei;
    @TempTableColumnOrder(348)
    private RString atesaki_setainushiShimeiRiyoKubun;
    @TempTableColumnOrder(349)
    private TelNo atesaki_setainushiRenrakusaki1;
    @TempTableColumnOrder(350)
    private TelNo atesaki_setainushiRenrakusaki2;
    @TempTableColumnOrder(351)
    private TelNo atesaki_setainushiRenrakusaki3;
    @TempTableColumnOrder(352)
    private Code atesaki_setainushiRenrakusakiKubun1;
    @TempTableColumnOrder(353)
    private Code atesaki_setainushiRenrakusakiKubun2;
    @TempTableColumnOrder(354)
    private Code atesaki_setainushiRenrakusakiKubun3;
    @TempTableColumnOrder(355)
    private MailAddress atesaki_setainushiMailAddress;
    @TempTableColumnOrder(356)
    private ShikibetsuCode atesaki_dainoninShikibetsuCode;
    @TempTableColumnOrder(357)
    private SetaiCode atesaki_honninSetaiCode;
    @TempTableColumnOrder(358)
    private SetaiCode atesaki_dainoninSetaiCode;
}
