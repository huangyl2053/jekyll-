/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519001.temp;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 広域要介護認定申請情報一時テーブル。
 *
 * @reamsid_L DBD-1480-040 liuyl
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KouikiyoukaigoNinteishinseiJouhouTempEntity
        extends DbTableEntityBase<KouikiyoukaigoNinteishinseiJouhouTempEntity> implements IDbAccessable {

    /**
     * 広域要介護認定申請情報一時テーブル名称
     */
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = new RString("KouikiyoukaigoNinteishinseiJouhouTemp");
    }
    @TempTableColumnOrder(1)
    private RString shikensharuNo;
    @TempTableColumnOrder(2)
    private RString kinouCode;
    @TempTableColumnOrder(3)
    private RString shikibetsuCode;
    @TempTableColumnOrder(4)
    private RString hokenshaNo;
    @TempTableColumnOrder(5)
    private RString hihokenshaNo;
    @TempTableColumnOrder(6)
    private RString ninteiShinseiYMD;
    @TempTableColumnOrder(7)
    private RString shuKiHojoKoumoku;
    @TempTableColumnOrder(8)
    private RString shinseiKubunHoureiCode;
    @TempTableColumnOrder(9)
    private RString shinseiKubunShinseijiCode;
    @TempTableColumnOrder(10)
    private RString torisageKubunCode;
    @TempTableColumnOrder(11)
    private RString hihokenshaKubunCodeo;
    @TempTableColumnOrder(12)
    private RString shinseiDaikouKubunCode;
    @TempTableColumnOrder(13)
    private RString seinengappiYMD;
    @TempTableColumnOrder(14)
    private RString age;
    @TempTableColumnOrder(15)
    private RString seibetsu;
    @TempTableColumnOrder(16)
    private RString shimeiKana;
    @TempTableColumnOrder(17)
    private RString shimei;
    @TempTableColumnOrder(18)
    private RString yuubinNo;
    @TempTableColumnOrder(19)
    private RString juusho;
    @TempTableColumnOrder(20)
    private RString honninRenrakusaki1;
    @TempTableColumnOrder(21)
    private RString byouinShisetsutouMeishou;
    @TempTableColumnOrder(22)
    private RString byouinShisetsutoujuusho;
    @TempTableColumnOrder(23)
    private RString zenkaiShinsakaiKekka;
    @TempTableColumnOrder(24)
    private RString zenkaiNinteiYuukoukaishikikan;
    @TempTableColumnOrder(25)
    private RString zenkaiNinteiYuukoushuuryoukikan;
    @TempTableColumnOrder(26)
    private RString shujiiIryoukikanCode;
    @TempTableColumnOrder(27)
    private RString shujiiNo;
    @TempTableColumnOrder(28)
    private RString ikenshoIraiYMD;
    @TempTableColumnOrder(29)
    private RString ikenshoNyuushuYMD;
    @TempTableColumnOrder(30)
    private RString ikenshoTankikioku;
    @TempTableColumnOrder(31)
    private RString ikenshoNinchinouryoku;
    @TempTableColumnOrder(32)
    private RString ikenshoDentatsuNouryoku;
    @TempTableColumnOrder(33)
    private RString ikenshoShokuji;
    @TempTableColumnOrder(34)
    private RString ninchiShouKoureishaDo;
    @TempTableColumnOrder(35)
    private RString zenkaikekkaMahizaJoushi;
    @TempTableColumnOrder(36)
    private RString zenkaikekkaMahiyuuJoushi;
    @TempTableColumnOrder(37)
    private RString zenkaikekkaMahizaKashi;
    @TempTableColumnOrder(38)
    private RString zenkaikekkaMahiyuuKashi;
    @TempTableColumnOrder(39)
    private RString zenkaikekkaMahiSonoTa;
    @TempTableColumnOrder(40)
    private RString zenkaiKekkaKoushukuKatakansetsu;
    @TempTableColumnOrder(41)
    private RString zenkaiKekkaKoushukuKokansetsu;
    @TempTableColumnOrder(42)
    private RString zenkaiKekkaKoushukuShitsukansetsu;
    @TempTableColumnOrder(43)
    private RString zenkaiKekkaKoushukuSonoTa;
    @TempTableColumnOrder(44)
    private RString zenkaiKekkaNegaeri;
    @TempTableColumnOrder(45)
    private RString zenkaiKekkaOkiagari;
    @TempTableColumnOrder(46)
    private RString zaihoji;
    @TempTableColumnOrder(47)
    private RString zenkaiKekkaRyouashideNoritsui;
    @TempTableColumnOrder(48)
    private RString zenkaiKekkaHokou;
    @TempTableColumnOrder(49)
    private RString zenkaiKekkaTachiagari;
    @TempTableColumnOrder(50)
    private RString zenkaiKekkaKataashiDeNoRitsui;
    @TempTableColumnOrder(51)
    private RString zenkaiKekkaSenShin;
    @TempTableColumnOrder(52)
    private RString zenkaiKekkaTsuMeKiri;
    @TempTableColumnOrder(53)
    private RString zenkaiKekkaShiryoku;
    @TempTableColumnOrder(54)
    private RString zenkaiKekkaChouryoku;
    @TempTableColumnOrder(55)
    private RString zenkaiKekkaIjou;
    @TempTableColumnOrder(56)
    private RString zenkaiKekkaIdou;
    @TempTableColumnOrder(57)
    private RString zenkaiKekkaEnKa;
    @TempTableColumnOrder(58)
    private RString zenkaiKekkaShokujiSesshu;
    @TempTableColumnOrder(59)
    private RString zenkaiKekkaShokuHainyou;
    @TempTableColumnOrder(60)
    private RString zenkaiKekkaHaiben;
    @TempTableColumnOrder(61)
    private RString zenkaiKekkakoukuuSeiketsu;
    @TempTableColumnOrder(62)
    private RString zenkaiKekkaSengan;
    @TempTableColumnOrder(63)
    private RString zenkaiKekkaSeihatsu;
    @TempTableColumnOrder(64)
    private RString zenkaiKekkajouinoChakudatsu;
    @TempTableColumnOrder(65)
    private RString zenkaiKekkaZuBontounoChakudatsu;
    @TempTableColumnOrder(66)
    private RString zenkaiKekkaSotodehindo;
    @TempTableColumnOrder(67)
    private RString zenkaiKekkaIshinoDentatsu;
    @TempTableColumnOrder(68)
    private RString zenkaiKekkaMainichinoNikkawoRikai;
    @TempTableColumnOrder(69)
    private RString zenkaiKekkaSeinengappiwoiu;
    @TempTableColumnOrder(70)
    private RString zenkaiKekkaTankikioku;
    @TempTableColumnOrder(71)
    private RString zenkaiKekkaJibunnoNamaewoiu;
    @TempTableColumnOrder(72)
    private RString zenkaiKekkaImanoKisetsuwoRikai;
    @TempTableColumnOrder(73)
    private RString zenkaiKekkaBashonoRikai;
    @TempTableColumnOrder(74)
    private RString zenkaiKekkaJoujinoHaikai;
    @TempTableColumnOrder(75)
    private RString zenkaiKekkaGaishutsushiteMotorenai;
    @TempTableColumnOrder(76)
    private RString zenkaiKekkaHigaiteki;
    @TempTableColumnOrder(77)
    private RString zenkaiKekkaSakuwa;
    @TempTableColumnOrder(78)
    private RString zenkaiKekkaKanjougaFuantei;
    @TempTableColumnOrder(79)
    private RString zenkaiKekkaChuuyagyakuten;
    @TempTableColumnOrder(80)
    private RString zenkaiKekkaOnnajiwawosuru;
    @TempTableColumnOrder(81)
    private RString zenkaiKekkaTaiseiwodasu;
    @TempTableColumnOrder(82)
    private RString zenkaiKekkaKaigoniTeikou;
    @TempTableColumnOrder(83)
    private RString zenkaiKekkaOchitsukinashi;
    @TempTableColumnOrder(84)
    private RString zenkaiKekkaHitorideDetagaru;
    @TempTableColumnOrder(85)
    private RString zenkaiKekkaShuushuuheki;
    @TempTableColumnOrder(86)
    private RString zenkaiKekkaMonoyaIruiwoKowasu;
    @TempTableColumnOrder(87)
    private RString zenkaiKekkaHidoimonowasure;
    @TempTableColumnOrder(88)
    private RString zenkaiKekkaHitorigotoHitoriwarai;
    @TempTableColumnOrder(89)
    private RString zenkaiKekkaJibunkatteniKoudousuru;
    @TempTableColumnOrder(90)
    private RString zenkaiKekkaWagamatomaranai;
    @TempTableColumnOrder(91)
    private RString zenkaiKekkaYakunoNaifuku;
    @TempTableColumnOrder(92)
    private RString zenkaiKekkaKinsennoKanri;
    @TempTableColumnOrder(93)
    private RString zenkaiKekkaNichijounoIshikettei;
    @TempTableColumnOrder(94)
    private RString zenkaiKekkaShuudanhenoFutekiou;
    @TempTableColumnOrder(95)
    private RString zenkaiKekkaKaimono;
    @TempTableColumnOrder(96)
    private RString zenkaiKekkaKantannaChouri;
    @TempTableColumnOrder(97)
    private RString zenkaiKekkaTentekiKanri;
    @TempTableColumnOrder(98)
    private RString zenkaiKekkaChuushinJoumyakuEiyou;
    @TempTableColumnOrder(99)
    private RString zenkaiKekkaTouseki;
    @TempTableColumnOrder(100)
    private RString zenkaiKekkaSutomanoShochi;
    @TempTableColumnOrder(101)
    private RString zenkaiKekkaSansoRyouhou;
    @TempTableColumnOrder(102)
    private RString zenkaiKekkaresupireta;
    @TempTableColumnOrder(103)
    private RString zenkaiKekkaKikanSekkainoShochi;
    @TempTableColumnOrder(104)
    private RString zenkaiKekkaToutsuunoKango;
    @TempTableColumnOrder(105)
    private RString zenkaiKekkaHeKanEiyou;
    @TempTableColumnOrder(106)
    private RString zenkaiKekkaMonitaSokutei;
    @TempTableColumnOrder(107)
    private RString zenkaiKekkaJokusounoShochi;
    @TempTableColumnOrder(108)
    private RString zenkaiKekkaKateteru;
    @TempTableColumnOrder(109)
    private RString zenkaiKekkaShougaiKoureishaJiritsudo;
    @TempTableColumnOrder(110)
    private RString zenkaiKekkaNinchiShouKoureishaJiritsudo;
    @TempTableColumnOrder(111)
    private RString zenkaiKekkaIchijiHanteikekka;
    @TempTableColumnOrder(112)
    private RString zenkaiKekkaNinchishoukazan;
    @TempTableColumnOrder(113)
    private RString zenkaiKekkaKijunJikan;
    @TempTableColumnOrder(114)
    private RString zenkaiKekkaKijunJikanShokuji;
    @TempTableColumnOrder(115)
    private RString zenkaiKekkaKijunJikanHaisetsu;
    @TempTableColumnOrder(116)
    private RString zenkaiKekkaKijunJikanIdou;
    @TempTableColumnOrder(117)
    private RString zenkaiKekkaKijunJikanSeiketsuhoji;
    @TempTableColumnOrder(118)
    private RString zenkaiKekkaKansetsukea;
    @TempTableColumnOrder(119)
    private RString zenkaiKekkaBPSDkanren;
    @TempTableColumnOrder(120)
    private RString zenkaiKekkaKinoukunren;
    @TempTableColumnOrder(121)
    private RString zenkaiKekkaIryoukanren;
    @TempTableColumnOrder(122)
    private RString zenkaiKekkaNinKunchiShouKazan;
    @TempTableColumnOrder(123)
    private RString zenkaiKekkaChuukanHyouka1;
    @TempTableColumnOrder(124)
    private RString zenkaiKekkaChuukanHyouka2;
    @TempTableColumnOrder(125)
    private RString zenkaiKekkaChuukanHyouka3;
    @TempTableColumnOrder(126)
    private RString zenkaiKekkaChuukanHyouka4;
    @TempTableColumnOrder(127)
    private RString zenkaiKekkaChuukanHyouka5;
    @TempTableColumnOrder(128)
    private RString zenkaiKekkaIchijiHanteiKeikokuCode;
    @TempTableColumnOrder(129)
    private RString zenkaiKekkaJoutainoAnteisei;
    @TempTableColumnOrder(130)
    private RString zenkaiKekkaNinchiShouJiritsudo2;
    @TempTableColumnOrder(131)
    private RString zenkaiKekkaJoutaiKubun;
    @TempTableColumnOrder(132)
    private RString zenkaiKekkaShinseiYMD;
    @TempTableColumnOrder(133)
    private RString zenkaiKekkaNijiHanteiYMD;
    @TempTableColumnOrder(134)
    private RString zenkaiKekkaGenzainosabisuKubunCode;
    @TempTableColumnOrder(135)
    private RString zenkaiKekkaGenzainoJoukyou;
    @TempTableColumnOrder(136)
    private RString zenkaiKekkaHoumonkaigohomuherupusabisu;
    @TempTableColumnOrder(137)
    private RString zenkaiKekkaHoumonNyuuyokuKaigo;
    @TempTableColumnOrder(138)
    private RString zenkaiKekkaHoumonkango;
    @TempTableColumnOrder(139)
    private RString zenkaiKekkaHoumonrihabiriteshon;
    @TempTableColumnOrder(140)
    private RString zenkaiKekkaKyotakuRyouyouKanrishidou;
    @TempTableColumnOrder(141)
    private RString zenkaiKekkaTsuushoKaigodeisabisu;
    @TempTableColumnOrder(142)
    private RString zenkaiKekkaTsuushorihabiriteshon;
    @TempTableColumnOrder(143)
    private RString zenkaiKekkaKaigoshotosutei;
    @TempTableColumnOrder(144)
    private RString zenkaiKekkaRyouyouKaigo;
    @TempTableColumnOrder(145)
    private RString zenkaiKekkaNyuukyoshaSeikatsukaigo;
    @TempTableColumnOrder(146)
    private RString zenkaiKekkaFukushiYouguTaiyo;
    @TempTableColumnOrder(147)
    private RString zenkaiKekkaTokuteiFukushiYouguHambai;
    @TempTableColumnOrder(148)
    private RString zenkaiKekkaJuutakuKaishuukaigoKyuufu;
    @TempTableColumnOrder(149)
    private RString zenkaiKekkaYakanTaiougataHoumonkaigo;
    @TempTableColumnOrder(150)
    private RString zenkaiKekkaNinchishouTaiougataTsuushoKaigo;
    @TempTableColumnOrder(151)
    private RString zenkaiKekkaShoukiboTakinouKeiKyotakuKaigo;
    @TempTableColumnOrder(152)
    private RString zenkaiKekkaNinchiShoutaiougata;
    @TempTableColumnOrder(153)
    private RString zenkaiKekkaSeikatsukaigo;
    @TempTableColumnOrder(154)
    private RString zenkaiKekkaChiikimitchakukeikaigoroujin;
    @TempTableColumnOrder(155)
    private RString zenkaiKekkaHoumonkaigokango;
    @TempTableColumnOrder(156)
    private RString zenkaiKekkaFukugougatasabisu;
    @TempTableColumnOrder(157)
    private RString zenkaiKekkaHomuherupusabisu;
    @TempTableColumnOrder(158)
    private RString zenkaiKekkaKaigoYobouHoumonNyuuyokukaigo;
    @TempTableColumnOrder(159)
    private RString zenkaiKekkaKaigoYobouHoumonkango;
    @TempTableColumnOrder(160)
    private RString zenkaiKekkaKaigoYobouHoumonrihabiriteshon;
    @TempTableColumnOrder(161)
    private RString zenkaiKekkaKaigoRyouyoukanriShidou;
    @TempTableColumnOrder(162)
    private RString zenkaiKekkaKaigoYobouTsuushoKaigodeisabisu;
    @TempTableColumnOrder(163)
    private RString zenkaiKekkaKaigoYobouTsuushorihabiriteshon;
    @TempTableColumnOrder(164)
    private RString zenkaiKekkaKaigoyobouTankiNyuushosei;
    @TempTableColumnOrder(165)
    private RString zenkaiKekkanyuushoRyouyoukaigo;
    @TempTableColumnOrder(166)
    private RString zenkaiKekkaKaigoYobouTokuteishisetsu;
    @TempTableColumnOrder(167)
    private RString zenkaiKekkaKaigoYobouFukushiYouguTaiyo;
    @TempTableColumnOrder(168)
    private RString zenkaiKekkaTokuteiKaigoYobouFukushi;
    @TempTableColumnOrder(169)
    private RString zenkaiKekkaJuutakuKaishuu;
    @TempTableColumnOrder(170)
    private RString zenkaiKekkaTsuushoKaigo;
    @TempTableColumnOrder(171)
    private RString zenkaiKekkaKyotakukaigo;
    @TempTableColumnOrder(172)
    private RString zenkaiKekkaKyoudouseikatsuKaigo;
    @TempTableColumnOrder(173)
    private RString zenkaiShikibetsuCode;
    @TempTableColumnOrder(174)
    private RString komento;
    @TempTableColumnOrder(175)
    private RString shichousonCode;
    @TempTableColumnOrder(176)
    private RString honninRenrakusaki2;
    @TempTableColumnOrder(177)
    private RString tokuteiShippeiCode;
    @TempTableColumnOrder(178)
    private RString nyuushoJigyoushoCode;
    @TempTableColumnOrder(179)
    private RString nyuushoShisetsukana;
    @TempTableColumnOrder(180)
    private RString nyuushoShisetsuYoubinNo;
    @TempTableColumnOrder(181)
    private RString nyuushoShisetsutelNo;
    @TempTableColumnOrder(182)
    private RString honninKinkyuurenrakuMeishou1;
    @TempTableColumnOrder(183)
    private RString honninKinkyuurenrakuJosho1;
    @TempTableColumnOrder(184)
    private RString honninKinkyuurenrakuNo1;
    @TempTableColumnOrder(185)
    private RString honninKinkyuurenrakuMeishou2;
    @TempTableColumnOrder(186)
    private RString honninKinkyuurenrakuJosho2;
    @TempTableColumnOrder(187)
    private RString honninKinkyuurenrakuNo2;
    @TempTableColumnOrder(188)
    private RString shinseishaKankeiCode;
    @TempTableColumnOrder(189)
    private RString honninKankei;
    @TempTableColumnOrder(190)
    private RString shinseishaShimei;
    @TempTableColumnOrder(191)
    private RString shinseishaShimeiKana;
    @TempTableColumnOrder(192)
    private RString shinseiJigyoushaName;
    @TempTableColumnOrder(193)
    private RString shinseiJigyoushaKana;
    @TempTableColumnOrder(194)
    private RString shinseishaYoubinNo;
    @TempTableColumnOrder(195)
    private RString shinseishaJosho;
    @TempTableColumnOrder(196)
    private RString shinseishaRenrakusaki;
    @TempTableColumnOrder(197)
    private RString chousaiCode;
}
