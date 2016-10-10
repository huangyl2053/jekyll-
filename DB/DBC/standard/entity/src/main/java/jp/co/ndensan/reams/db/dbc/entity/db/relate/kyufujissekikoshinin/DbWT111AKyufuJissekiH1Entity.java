/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 給付実績H1一時TBLテーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT111AKyufuJissekiH1Entity extends DbTableEntityBase<DbWT111AKyufuJissekiH1Entity> implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private int renban;
    @TempTableColumnOrder(2)
    private RString recordNo;
    @TempTableColumnOrder(3)
    private KokanShikibetsuNo kokanShikibetsuNo;
    @TempTableColumnOrder(4)
    private NyuryokuShikibetsuNo inputShikibetsuNo;
    @TempTableColumnOrder(5)
    private RString recodeShubetsuCode;
    @TempTableColumnOrder(6)
    private HokenshaNo shokisaiHokenshaNo;
    @TempTableColumnOrder(7)
    private HihokenshaNo hiHokenshaNo;
    @TempTableColumnOrder(8)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(9)
    private JigyoshaNo jigyoshoNo;
    @TempTableColumnOrder(10)
    private RString kyufuSakuseiKubunCode;
    @TempTableColumnOrder(11)
    private RString kyufuJissekiKubunCode;
    @TempTableColumnOrder(12)
    private RString toshiNo;
    @TempTableColumnOrder(13)
    private RString kohi1FutanshaNo;
    @TempTableColumnOrder(14)
    private RString kohi1JukyushaNo;
    @TempTableColumnOrder(15)
    private RString kohi2FutanshaNo;
    @TempTableColumnOrder(16)
    private RString kohi2JukyushaNo;
    @TempTableColumnOrder(17)
    private RString kohi3FutanshaNo;
    @TempTableColumnOrder(18)
    private RString kohi3JukyushaNo;
    @TempTableColumnOrder(19)
    private FlexibleDate umareYMD;
    @TempTableColumnOrder(20)
    private RString seibetsuCode;
    @TempTableColumnOrder(21)
    private RString yoKaigoJotaiKubunCode;
    @TempTableColumnOrder(22)
    private RString kyuSochiNyushoshaTokureiCode;
    @TempTableColumnOrder(23)
    private FlexibleDate ninteiYukoKaishiYMD;
    @TempTableColumnOrder(24)
    private FlexibleDate ninteiYukoShuryoYMD;
    @TempTableColumnOrder(25)
    private RString rojinHokenShichosonNo;
    @TempTableColumnOrder(26)
    private RString rojinhokenJukyushaNo;
    @TempTableColumnOrder(27)
    private RString kokiHokenshaNo;
    @TempTableColumnOrder(28)
    private RString kokiHiHokenshaNo;
    @TempTableColumnOrder(29)
    private RString kokuhoHokenshaNo;
    @TempTableColumnOrder(30)
    private RString kokuhoHiHokenshashoNo;
    @TempTableColumnOrder(31)
    private RString kokuhoKojinNo;
    @TempTableColumnOrder(32)
    private RString kyotakuServiceSakuseiKubunCode;
    @TempTableColumnOrder(33)
    private JigyoshaNo kyotakuKaigoShienJigyoshoNo;
    @TempTableColumnOrder(34)
    private FlexibleDate kaishiYMD;
    @TempTableColumnOrder(35)
    private FlexibleDate chushiYMD;
    @TempTableColumnOrder(36)
    private RString chushiRiyuNyushomaeJyokyoCode;
    @TempTableColumnOrder(37)
    private FlexibleDate nyushoYMD;
    @TempTableColumnOrder(38)
    private FlexibleDate taishoYMD;
    @TempTableColumnOrder(39)
    private int nyushoJitsunissu;
    @TempTableColumnOrder(40)
    private int gaihakuNissu;
    @TempTableColumnOrder(41)
    private RString taishogoJotaiCode;
    @TempTableColumnOrder(42)
    private HokenKyufuRitsu hokenKyufuritsu;
    @TempTableColumnOrder(43)
    private HokenKyufuRitsu kohi1Kyufuritsu;
    @TempTableColumnOrder(44)
    private HokenKyufuRitsu kohi2Kyufuritsu;
    @TempTableColumnOrder(45)
    private HokenKyufuRitsu kohi3Kyufuritsu;
    @TempTableColumnOrder(46)
    private int maeHokenServiceTanisu;
    @TempTableColumnOrder(47)
    private Decimal maeHokenSeikyugaku;
    @TempTableColumnOrder(48)
    private int maeHokenRiyoshaFutangaku;
    @TempTableColumnOrder(49)
    private Decimal maeHokenKinkyuShisetsuRyoyoSeikyugaku;
    @TempTableColumnOrder(50)
    private Decimal maeHokenTokuteiShinryohiSeikyugaku;
    @TempTableColumnOrder(51)
    private Decimal maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku;
    @TempTableColumnOrder(52)
    private int maeKohi1ServiceTanisu;
    @TempTableColumnOrder(53)
    private int maeKohi1Seikyugaku;
    @TempTableColumnOrder(54)
    private int maeKohi1RiyoshaFutangaku;
    @TempTableColumnOrder(55)
    private int maeKohi1KinkyuShisetsuRyoyoSeikyugaku;
    @TempTableColumnOrder(56)
    private int maeKohi1TokuteiShinryohiSeikyugaku;
    @TempTableColumnOrder(57)
    private int maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    @TempTableColumnOrder(58)
    private int maeKohi2ServiceTanisu;
    @TempTableColumnOrder(59)
    private int maeKohi2Seikyugaku;
    @TempTableColumnOrder(60)
    private int maeKohi2RiyoshaFutangaku;
    @TempTableColumnOrder(61)
    private int maeKohi2KinkyuShisetsuRyoyoSeikyugaku;
    @TempTableColumnOrder(62)
    private int maeKohi2TokuteiShinryohiSeikyugaku;
    @TempTableColumnOrder(63)
    private int maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    @TempTableColumnOrder(64)
    private int maeKohi3ServiceTanisu;
    @TempTableColumnOrder(65)
    private int maeKohi3Seikyugaku;
    @TempTableColumnOrder(66)
    private int maeKohi3RiyoshaFutangaku;
    @TempTableColumnOrder(67)
    private int maeKohi3KinkyuShisetsuRyoyoSeikyugaku;
    @TempTableColumnOrder(68)
    private int maeKohi3TokuteiShinryohiSeikyugaku;
    @TempTableColumnOrder(69)
    private int maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    @TempTableColumnOrder(70)
    private int atoHokenServiceTanisu;
    @TempTableColumnOrder(71)
    private Decimal atoHokenSeikyugaku;
    @TempTableColumnOrder(72)
    private int atoHokenRiyoshaFutangaku;
    @TempTableColumnOrder(73)
    private Decimal atoHokenKinkyuShisetsuRyoyoSeikyugaku;
    @TempTableColumnOrder(74)
    private Decimal atoHokenTokuteiShinryohiSeikyugaku;
    @TempTableColumnOrder(75)
    private int atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku;
    @TempTableColumnOrder(76)
    private int atoKohi1ServiceTanisu;
    @TempTableColumnOrder(77)
    private int atoKohi1Seikyugaku;
    @TempTableColumnOrder(78)
    private int atoKohi1RiyoshaFutangaku;
    @TempTableColumnOrder(79)
    private int atoKohi1KinkyuShisetsuRyoyoSeikyugaku;
    @TempTableColumnOrder(80)
    private int atoKohi1TokuteiShinryohiSeikyugaku;
    @TempTableColumnOrder(81)
    private int atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    @TempTableColumnOrder(82)
    private int atoKohi2ServiceTanisu;
    @TempTableColumnOrder(83)
    private int atoKohi2Seikyugaku;
    @TempTableColumnOrder(84)
    private int atoKohi2RiyoshaFutangaku;
    @TempTableColumnOrder(85)
    private int atoKohi2KinkyuShisetsuRyoyoSeikyugaku;
    @TempTableColumnOrder(86)
    private int atoKohi2TokuteiShinryohiSeikyugaku;
    @TempTableColumnOrder(87)
    private int atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    @TempTableColumnOrder(88)
    private int atoKohi3ServiceTanisu;
    @TempTableColumnOrder(89)
    private int atoKohi3Seikyugaku;
    @TempTableColumnOrder(90)
    private int atoKohi3RiyoshaFutangaku;
    @TempTableColumnOrder(91)
    private int atoKohi3KinkyuShisetsuRyoyoSeikyugaku;
    @TempTableColumnOrder(92)
    private int atoKohi3TokuteiShinryohiSeikyugaku;
    @TempTableColumnOrder(93)
    private int atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    @TempTableColumnOrder(94)
    private RString keikaiKubunCode;
    @TempTableColumnOrder(95)
    private FlexibleYearMonth shinsaYM;
    @TempTableColumnOrder(96)
    private RString seiriNo;
    @TempTableColumnOrder(97)
    private FlexibleYearMonth sofuYM;
    @TempTableColumnOrder(98)
    private FlexibleYearMonth torikomiYM;
    @TempTableColumnOrder(99)
    private RString dokujiSakuseiKubun;
    @TempTableColumnOrder(100)
    private boolean hokenshaHoyuKyufujissekiJohoSakujoFlag;

}
