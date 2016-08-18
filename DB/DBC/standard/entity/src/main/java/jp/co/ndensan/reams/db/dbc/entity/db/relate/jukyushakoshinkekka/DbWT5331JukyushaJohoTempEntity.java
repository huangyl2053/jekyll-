/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakoshinkekka;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.seikyugakutsuchishofutanshain.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
public class DbWT5331JukyushaJohoTempEntity extends DbTableEntityBase<DbWT1511SeikyugakuTsuchishoTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private int renban;
    @TempTableColumnOrder(2)
    private RString kokanJohoShikibetsuNo;
    @TempTableColumnOrder(3)
    private FlexibleDate idoYmd;
    @TempTableColumnOrder(4)
    private RString idoKubunCode;
    @TempTableColumnOrder(5)
    private FlexibleDate teiseiYmd;
    @TempTableColumnOrder(6)
    private RString teiseiKubunCode;
    @TempTableColumnOrder(7)
    private RString idoJiyuKubun;
    @TempTableColumnOrder(8)
    private FlexibleDate seinengappiYmd;
    @TempTableColumnOrder(9)
    private RString seibetsuCode;
    @TempTableColumnOrder(10)
    private FlexibleDate shikakuShutokuYmd;
    @TempTableColumnOrder(11)
    private FlexibleDate shikakuSoshitsuYmd;
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
    private FlexibleDate shinseiYmd;
    @TempTableColumnOrder(18)
    private RString minashiYokaigoKubunCode;
    @TempTableColumnOrder(19)
    private RString yokaigoJotaiKubunCode;
    @TempTableColumnOrder(20)
    private FlexibleDate ninteiYukokikanFromYmd;
    @TempTableColumnOrder(21)
    private FlexibleDate ninteiYukokikanToYmd;
    @TempTableColumnOrder(22)
    private RString kyotakuServiceKubunCode;
    @TempTableColumnOrder(23)
    private RString kyotakuKaigoShienJigyoshoNo;
    @TempTableColumnOrder(24)
    private FlexibleDate kyotakuServiceTekiyoFromYmd;
    @TempTableColumnOrder(25)
    private FlexibleDate kyotakuServiceTekiyoToYmd;
    @TempTableColumnOrder(26)
    private Decimal homonShikyugendoKijungaku;
    @TempTableColumnOrder(27)
    private FlexibleDate homonJogenKanriTekiyoKikanFromYmd;
    @TempTableColumnOrder(28)
    private FlexibleDate homonJogenKanriTekiyoKikanToYmd;
    @TempTableColumnOrder(29)
    private Decimal tankiShikyugendoKijungaku;
    @TempTableColumnOrder(30)
    private FlexibleDate tankiJogenKanriTekiyoKikanFromYmd;
    @TempTableColumnOrder(31)
    private FlexibleDate tankiJogenKanriTekiyoKikanToYmd;
    @TempTableColumnOrder(32)
    private RString kohiFutanJogengakuGengakuUmu;
    @TempTableColumnOrder(33)
    private FlexibleDate shokanHaraikaFromYmd;
    @TempTableColumnOrder(34)
    private FlexibleDate shokanHaraikaToYmd;
    @TempTableColumnOrder(35)
    private FlexibleDate kyufuritsuHikisageFromYmd;
    @TempTableColumnOrder(36)
    private FlexibleDate kyufuritsuHikisageToYmd;
    @TempTableColumnOrder(37)
    private RString genmenShinseichuKubunCode;
    @TempTableColumnOrder(38)
    private RString riyoshaFutanKubunCode;
    @TempTableColumnOrder(39)
    private Decimal kyufuRitsu;
    @TempTableColumnOrder(40)
    private FlexibleDate riyoshaFutanTekiyoFromYmd;
    @TempTableColumnOrder(41)
    private FlexibleDate riyoshaFutanTekiyoToYmd;
    @TempTableColumnOrder(42)
    private RString hyojunFutanKubunCode;
    @TempTableColumnOrder(43)
    private Decimal futanGaku;
    @TempTableColumnOrder(44)
    private FlexibleDate futanGakuTekiyoFromYmd;
    @TempTableColumnOrder(45)
    private FlexibleDate futanGakuTekiyoToYmd;
    @TempTableColumnOrder(46)
    private RString tokuteiNyushoshaNinteiShinseichuKubunCode;
    @TempTableColumnOrder(47)
    private RString tokuteiNyushoshaKaigoServiceKubunCode;
    @TempTableColumnOrder(48)
    private RString kazeisoNoTokureiGengakuSochiTaishoKubun;
    @TempTableColumnOrder(49)
    private Decimal tokuteiNyushoshaShokuhiFutanGendoGaku;
    @TempTableColumnOrder(50)
    private Decimal kyojuhiUnitKoshitsuFutanGendoGaku;
    @TempTableColumnOrder(51)
    private Decimal kyojuhiUnitJunkoshitsuFutanGendoGaku;
    @TempTableColumnOrder(52)
    private Decimal kyojuhiTokuyotoFutanGenndoGaku;
    @TempTableColumnOrder(53)
    private Decimal kyojuhiRokenRyoyotoFutanGendoGaku;
    @TempTableColumnOrder(54)
    private Decimal kyojuhiTashoShitsuFutanGendoGaku;
    @TempTableColumnOrder(55)
    private FlexibleDate futanGendoGakuTekiyoFromYmd;
    @TempTableColumnOrder(56)
    private FlexibleDate futanGendoGakuTekiyoToYmd;
    @TempTableColumnOrder(57)
    private Decimal keigenRitsu;
    @TempTableColumnOrder(58)
    private FlexibleDate keigenRitsuTekiyoFromYmd;
    @TempTableColumnOrder(59)
    private FlexibleDate keigenRitsuTekiyoToYmd;
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
    private FlexibleDate nijiyoboJigyoYukokikanFromYmd;
    @TempTableColumnOrder(68)
    private FlexibleDate nijiyoboJigyoYukokikanToYmd;
    @TempTableColumnOrder(69)
    private RString jushochiTokureiTaishoshaKubunCode;
    @TempTableColumnOrder(70)
    private RString shisetsuShozaiHokenshaNo;
    @TempTableColumnOrder(71)
    private FlexibleDate jushochiTokureiTekiyoFromYmd;
    @TempTableColumnOrder(72)
    private FlexibleDate jushochiTokureiTekiyoToYmd;
    @TempTableColumnOrder(73)
    private Decimal kyojuhi1FutanGendogaku;
    @TempTableColumnOrder(74)
    private Decimal kyojuhi2FutanGendogaku;
    @TempTableColumnOrder(75)
    private Decimal kyojuhi3FutanGendogaku;
    @TempTableColumnOrder(76)
    private FlexibleDate niwariFutanTekiyoFromYmd;
    @TempTableColumnOrder(77)
    private FlexibleDate niwariFutanTekiyoToYmd;
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
