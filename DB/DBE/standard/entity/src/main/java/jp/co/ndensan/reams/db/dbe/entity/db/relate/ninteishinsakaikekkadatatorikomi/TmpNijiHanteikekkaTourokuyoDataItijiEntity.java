/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinsakaikekkadatatorikomi;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 二次判定結果登録用データ一時デーブルクラスです。
 *
 * @reamsid_L DBE-1841-020 xuyongchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class TmpNijiHanteikekkaTourokuyoDataItijiEntity implements IDbAccessable {

    @TempTableColumnOrder(1)
    private RString shinsakaiKaisaiNo;
    @TempTableColumnOrder(2)
    private int gogitaiNo;
    @TempTableColumnOrder(3)
    private FlexibleDate shinsakaiKaisaiYMD;
    @TempTableColumnOrder(4)
    private RString shinsakaiKaishiTime;
    @TempTableColumnOrder(5)
    private RString shinsakaiShuryoTime;
    @TempTableColumnOrder(6)
    private RString shinsakaiKaisaiBashoCode;
    @TempTableColumnOrder(7)
    private int shoyoJikanGokei;
    @TempTableColumnOrder(8)
    private int shinsakaiJisshiNinzu;
    @TempTableColumnOrder(9)
    private int shinsakaiOrder;
    @TempTableColumnOrder(10)
    private Code hanteiKekkaCode;
    @TempTableColumnOrder(11)
    private FlexibleDate nijiHanteiYMD;
    @TempTableColumnOrder(12)
    private Code nijiHanteiYokaigoJotaiKubunCode;
    @TempTableColumnOrder(13)
    private int nijiHanteiNinteiYukoKikan;
    @TempTableColumnOrder(14)
    private FlexibleDate nijiHanteiNinteiYukoKaishiYMD;
    @TempTableColumnOrder(15)
    private FlexibleDate nijiHanteiNinteiYukoShuryoYMD;
    @TempTableColumnOrder(16)
    private RString shinsakaiIken;
    @TempTableColumnOrder(17)
    private RString ichijiHanteiKekkaHenkoRiyu;
    @TempTableColumnOrder(18)
    private Code yokaigoJotaizoReiCode;
    @TempTableColumnOrder(19)
    private RString ninteishinsakaiIkenShurui;
    @TempTableColumnOrder(20)
    private RString shinsakaiMemo;
    @TempTableColumnOrder(21)
    private Code nijiHanteiKekkaInputHoho;
    @TempTableColumnOrder(22)
    private FlexibleDate nijiHanteiKekkaInputYMD;
    @TempTableColumnOrder(23)
    private Code ninteiShinseiHoreiKubunCode;
    @TempTableColumnOrder(24)
    private FlexibleDate ichiGojiHanteiYMD;
    @TempTableColumnOrder(25)
    private Code ichiGojiHanteiKekkaCode;
    @TempTableColumnOrder(26)
    private Code ichiGojiHanteiKekkaNinchishoKasanCode;
    @TempTableColumnOrder(27)
    private int kijunJikan;
    @TempTableColumnOrder(28)
    private int kijunJikanShokuji;
    @TempTableColumnOrder(29)
    private int kijunJikanHaisetsu;
    @TempTableColumnOrder(30)
    private int kijunJikanIdo;
    @TempTableColumnOrder(31)
    private int kijunJikanSeiketsuHoji;
    @TempTableColumnOrder(32)
    private int kijunJikanKansetsuCare;
    @TempTableColumnOrder(33)
    private int kijunJikanBPSDKanren;
    @TempTableColumnOrder(34)
    private int kijunJikanKinoKunren;
    @TempTableColumnOrder(35)
    private int kijunJikanIryoKanren;
    @TempTableColumnOrder(36)
    private int kijunJikanNinchishoKasan;
    @TempTableColumnOrder(37)
    private int chukanHyokaKomoku1gun;
    @TempTableColumnOrder(38)
    private int chukanHyokaKomoku2gun;
    @TempTableColumnOrder(39)
    private int chukanHyokaKomoku3gun;
    @TempTableColumnOrder(40)
    private int chukanHyokaKomoku4gun;
    @TempTableColumnOrder(41)
    private int chukanHyokaKomoku5gun;
    @TempTableColumnOrder(42)
    private Code ichiGojiHnateiKeikokuCode;
    @TempTableColumnOrder(43)
    private Code jotaiAnteiseiCode;
    @TempTableColumnOrder(44)
    private Decimal ninchishoJiritsudoIIijoNoGaizensei;
    @TempTableColumnOrder(45)
    private Code suiteiKyufuKubunCode;
    @TempTableColumnOrder(46)
    private ShinseishoKanriNo shinseishoKanriNo;
    @TempTableColumnOrder(47)
    private Code koroshoIfShikibetsuCode;
    @TempTableColumnOrder(48)
    private RString koroshoNinteiSoftVersion;
    @TempTableColumnOrder(49)
    private RString shoKisaiHokenshaNo;
    @TempTableColumnOrder(50)
    private RString hihokenshaNo;
    @TempTableColumnOrder(51)
    private FlexibleDate ninteiShinseiYMD;
    @TempTableColumnOrder(52)
    private Code ninteiShinseiShinseijiKubunCode;
    @TempTableColumnOrder(53)
    private RString ninteiShinseiShinseiji;
    @TempTableColumnOrder(54)
    private AtenaMeisho hihokenshaName;
    @TempTableColumnOrder(55)
    private AtenaKanaMeisho hihokenshaKana;
    @TempTableColumnOrder(56)
    private FlexibleDate seinengappiYMD;
    @TempTableColumnOrder(57)
    private int age;
    @TempTableColumnOrder(58)
    private Code seibetsu;
    @TempTableColumnOrder(59)
    private YubinNo yubinNo;
    @TempTableColumnOrder(60)
    private AtenaJusho jusho;
    @TempTableColumnOrder(61)
    private TelNo telNo;
    @TempTableColumnOrder(62)
    private RString hokenshaName;
    @TempTableColumnOrder(63)
    private FlexibleDate ichijiHanteiYMD;
    @TempTableColumnOrder(64)
    private Code ichijiHanteiKekkaCode;
    @TempTableColumnOrder(65)
    private FlexibleDate ninteichosaIraiKanryoYMD;
    @TempTableColumnOrder(66)
    private int ninteichosaIraiRirekiNo;
    @TempTableColumnOrder(67)
    private JigyoshaNo ninteichosaItakusakiCode;
    @TempTableColumnOrder(68)
    private RString ninteichosaItakusaki;
    @TempTableColumnOrder(69)
    private RString ninteiChosainCode;
    @TempTableColumnOrder(70)
    private RString ninteiChosainName;
    @TempTableColumnOrder(71)
    private Code gaikyoTokkiTextImageKubunCode;
    @TempTableColumnOrder(72)
    private RString gaikyoTokkiTextImageKubun;
    @TempTableColumnOrder(73)
    private Code ninteichosaIraiKubunCode;
    @TempTableColumnOrder(74)
    private RString ninteichosaIraiKubun;
    @TempTableColumnOrder(75)
    private int ninteichosaIraiKaisu;
    @TempTableColumnOrder(76)
    private FlexibleDate ninteichosaJisshiYMD;
    @TempTableColumnOrder(77)
    private FlexibleDate ninteichosaJuryoYMD;
    @TempTableColumnOrder(78)
    private Code ninteiChosaKubunCode;
    @TempTableColumnOrder(79)
    private RString ninteiChosaKubun;
    @TempTableColumnOrder(80)
    private Code chosaJisshiBashoCode;
    @TempTableColumnOrder(81)
    private RString chosaJisshiBasho;
    @TempTableColumnOrder(82)
    private RString chosaJisshiBashoMeisho;
    @TempTableColumnOrder(83)
    private Code serviceKubunCode;
    @TempTableColumnOrder(84)
    private RString serviceKubun;
    @TempTableColumnOrder(85)
    private RString riyoShisetsuShimei;
    @TempTableColumnOrder(86)
    private RString riyoShisetsuJusho;
    @TempTableColumnOrder(87)
    private RString riyoShisetsuTelNo;
    @TempTableColumnOrder(88)
    private YubinNo riyoShisetsuYubinNo;
    @TempTableColumnOrder(89)
    private RString tokki;
    @TempTableColumnOrder(90)
    private FlexibleDate tokkijikoUketsukeYMD;
    @TempTableColumnOrder(91)
    private FlexibleDate tokkijikoJuryoYMD;
    @TempTableColumnOrder(92)
    private RString jyutakuKaisyou;
    @TempTableColumnOrder(93)
    private RString serviceSyuruiMei;
    @TempTableColumnOrder(94)
    private RString zaitakuServiceSyuruiMei;
    @TempTableColumnOrder(95)
    private RString syuso;
    @TempTableColumnOrder(96)
    private RString kazokuJyokyo;
    @TempTableColumnOrder(97)
    private RString kyojyuKankyo;
    @TempTableColumnOrder(98)
    private RString kiki;
    @TempTableColumnOrder(99)
    private RString ninteiChosaTokkiJkouBangou;
    @TempTableColumnOrder(100)
    private RString ninteiChosaTokkiJkouRengon;
    @TempTableColumnOrder(101)
    private Code genbonMasutaKubunCode;
    @TempTableColumnOrder(102)
    private RString genbonMasutaKubun;
    @TempTableColumnOrder(103)
    private RString tokkiJkou;
    @TempTableColumnOrder(104)
    private RString jyokyoRengon;
    @TempTableColumnOrder(105)
    private RString jyokyo;
    @TempTableColumnOrder(106)
    private RString jyokyoFlagRengon;
    @TempTableColumnOrder(107)
    private boolean jyokyoFlag;
    @TempTableColumnOrder(108)
    private RString kiiKoumokuRengon;
    @TempTableColumnOrder(109)
    private RString jyokyokii;
    @TempTableColumnOrder(110)
    private RString sisetuRiyouRengon;
    @TempTableColumnOrder(111)
    private boolean sisetuRiyouFlag;
    @TempTableColumnOrder(112)
    private Code nintisyoJirituduCode;
    @TempTableColumnOrder(113)
    private RString nintisyoJiritudu;
    @TempTableColumnOrder(114)
    private Code syogaiJirituduCode;
    @TempTableColumnOrder(115)
    private RString syogaiJiritudu;
    @TempTableColumnOrder(116)
    private RString chosaKoumokuRengon;
    @TempTableColumnOrder(117)
    private RString chosaKoumokuBungen;
    @TempTableColumnOrder(118)
    private RString naiyou;

}
