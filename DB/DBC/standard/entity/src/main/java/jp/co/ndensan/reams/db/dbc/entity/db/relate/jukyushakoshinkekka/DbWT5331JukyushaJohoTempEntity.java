/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakoshinkekka;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 受給者情報一時TBLテーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2730-010 chenjie
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT5331JukyushaJohoTempEntity extends DbTableEntityBase<DbWT5331JukyushaJohoTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private int renban;
    @TempTableColumnOrder(2)
    private RString kokanJohoShikibetsuNo;
    @TempTableColumnOrder(3)
    private FlexibleDate idoYmd;
    @TempTableColumnOrder(4)
    private RString idoKubunCode;
    @TempTableColumnOrder(5)
    private RString teiseiYmd;
    @TempTableColumnOrder(6)
    private RString teiseiKubunCode;
    @TempTableColumnOrder(7)
    private RString idoJiyuKubun;
    @TempTableColumnOrder(8)
    private RString seinengappiYmd;
    @TempTableColumnOrder(9)
    private RString seibetsuCode;
    @TempTableColumnOrder(10)
    private RString shikakuShutokuYmd;
    @TempTableColumnOrder(11)
    private RString shikakuSoshitsuYmd;
    @TempTableColumnOrder(12)
    private RString rojinHokenShichosonNo;
    @TempTableColumnOrder(13)
    private RString rojinHokenJukyushaNo;
    @TempTableColumnOrder(14)
    private RString koikiRengoHokenshaNo;
    @TempTableColumnOrder(15)
    private RString shinseiShubetsuCode;
    @TempTableColumnOrder(16)
    private RString henkoShinseichuKubunCode;
    @TempTableColumnOrder(17)
    private RString shinseiYmd;
    @TempTableColumnOrder(18)
    private RString minashiYokaigoKubunCode;
    @TempTableColumnOrder(19)
    private RString yokaigoJotaiKubunCode;
    @TempTableColumnOrder(20)
    private RString ninteiYukokikanFromYmd;
    @TempTableColumnOrder(21)
    private RString ninteiYukokikanToYmd;
    @TempTableColumnOrder(22)
    private RString kyotakuServiceKubunCode;
    @TempTableColumnOrder(23)
    private RString kyotakuKaigoShienJigyoshoNo;
    @TempTableColumnOrder(24)
    private RString kyotakuServiceTekiyoFromYmd;
    @TempTableColumnOrder(25)
    private RString kyotakuServiceTekiyoToYmd;
    @TempTableColumnOrder(26)
    private RString homonShikyugendoKijungaku;
    @TempTableColumnOrder(27)
    private RString homonJogenKanriTekiyoKikanFromYmd;
    @TempTableColumnOrder(28)
    private RString homonJogenKanriTekiyoKikanToYmd;
    @TempTableColumnOrder(29)
    private RString tankiShikyugendoKijungaku;
    @TempTableColumnOrder(30)
    private RString tankiJogenKanriTekiyoKikanFromYmd;
    @TempTableColumnOrder(31)
    private RString tankiJogenKanriTekiyoKikanToYmd;
    @TempTableColumnOrder(32)
    private RString kohiFutanJogengakuGengakuUmu;
    @TempTableColumnOrder(33)
    private RString shokanHaraikaFromYmd;
    @TempTableColumnOrder(34)
    private RString shokanHaraikaToYmd;
    @TempTableColumnOrder(35)
    private RString kyufuritsuHikisageFromYmd;
    @TempTableColumnOrder(36)
    private RString kyufuritsuHikisageToYmd;
    @TempTableColumnOrder(37)
    private RString genmenShinseichuKubunCode;
    @TempTableColumnOrder(38)
    private RString riyoshaFutanKubunCode;
    @TempTableColumnOrder(39)
    private RString kyufuRitsu;
    @TempTableColumnOrder(40)
    private RString riyoshaFutanTekiyoFromYmd;
    @TempTableColumnOrder(41)
    private RString riyoshaFutanTekiyoToYmd;
    @TempTableColumnOrder(42)
    private RString hyojunFutanKubunCode;
    @TempTableColumnOrder(43)
    private RString futanGaku;
    @TempTableColumnOrder(44)
    private RString futanGakuTekiyoFromYmd;
    @TempTableColumnOrder(45)
    private RString futanGakuTekiyoToYmd;
    @TempTableColumnOrder(46)
    private RString tokuteiNyushoshaNinteiShinseichuKubunCode;
    @TempTableColumnOrder(47)
    private RString tokuteiNyushoshaKaigoServiceKubunCode;
    @TempTableColumnOrder(48)
    private RString kazeisoNoTokureiGengakuSochiTaishoKubun;
    @TempTableColumnOrder(49)
    private RString tokuteiNyushoshaShokuhiFutanGendoGaku;
    @TempTableColumnOrder(50)
    private RString kyojuhiUnitKoshitsuFutanGendoGaku;
    @TempTableColumnOrder(51)
    private RString kyojuhiUnitJunkoshitsuFutanGendoGaku;
    @TempTableColumnOrder(52)
    private RString kyojuhiTokuyotoFutanGenndoGaku;
    @TempTableColumnOrder(53)
    private RString kyojuhiRokenRyoyotoFutanGendoGaku;
    @TempTableColumnOrder(54)
    private RString kyojuhiTashoShitsuFutanGendoGaku;
    @TempTableColumnOrder(55)
    private RString futanGendoGakuTekiyoFromYmd;
    @TempTableColumnOrder(56)
    private RString futanGendoGakuTekiyoToYmd;
    @TempTableColumnOrder(57)
    private RString keigenRitsu;
    @TempTableColumnOrder(58)
    private RString keigenRitsuTekiyoFromYmd;
    @TempTableColumnOrder(59)
    private RString keigenRitsuTekiyoToYmd;
    @TempTableColumnOrder(60)
    private RString shokiboKyotakuServiceRiyoUmu;
    @TempTableColumnOrder(61)
    private RString kokiHokenshaNo;
    @TempTableColumnOrder(62)
    private RString kokiHihokenshaNo;
    @TempTableColumnOrder(63)
    private RString kokuhoHokenshaNo;
    @TempTableColumnOrder(64)
    private RString kokuhoHihokenshashoNo;
    @TempTableColumnOrder(65)
    private RString atenaNo;
    @TempTableColumnOrder(66)
    private RString nijiyoboJigyoKubunCode;
    @TempTableColumnOrder(67)
    private RString nijiyoboJigyoYukokikanFromYmd;
    @TempTableColumnOrder(68)
    private RString nijiyoboJigyoYukokikanToYmd;
    @TempTableColumnOrder(69)
    private RString jushochiTokureiTaishoshaKubunCode;
    @TempTableColumnOrder(70)
    private RString shisetsuShozaiHokenshaNo;
    @TempTableColumnOrder(71)
    private RString jushochiTokureiTekiyoFromYmd;
    @TempTableColumnOrder(72)
    private RString jushochiTokureiTekiyoToYmd;
    @TempTableColumnOrder(73)
    private RString kyojuhi1FutanGendogaku;
    @TempTableColumnOrder(74)
    private RString kyojuhi2FutanGendogaku;
    @TempTableColumnOrder(75)
    private RString kyojuhi3FutanGendogaku;
    @TempTableColumnOrder(76)
    private RString niwariFutanTekiyoFromYmd;
    @TempTableColumnOrder(77)
    private RString niwariFutanTekiyoToYmd;
    @TempTableColumnOrder(78)
    private RString yuryoRojinHomeDoishoUmu;
    @TempTableColumnOrder(79)
    private RString tsugoKekkaKubun;
    @TempTableColumnOrder(80)
    private RString tsugoJohoKubun;
    @TempTableColumnOrder(81)
    private RString hokenshaNo;
    @TempTableColumnOrder(82)
    private RString hokenshaName;
    @TempTableColumnOrder(83)
    private FlexibleYearMonth torikomiYM;
}
