/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikihon;

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
 * 給付実績基本一時テーブルです。
 *
 * @reamsid_L DBC-2460-010 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT1131KyufujissekiKihonTempEntity extends DbTableEntityBase<DbWT1131KyufujissekiKihonTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private KokanShikibetsuNo kokanShikibetsuNo;
    @TempTableColumnOrder(2)
    private NyuryokuShikibetsuNo inputShikibetsuNo;
    @TempTableColumnOrder(3)
    private RString recodeShubetsuCode;
    @TempTableColumnOrder(4)
    private HokenshaNo shokisaiHokenshaNo;
    @TempTableColumnOrder(5)
    private HihokenshaNo hiHokenshaNo;
    @TempTableColumnOrder(6)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(7)
    private JigyoshaNo jigyoshoNo;
    @TempTableColumnOrder(8)
    private RString kyufuSakuseiKubunCode;
    @TempTableColumnOrder(9)
    private RString kyufuJissekiKubunCode;
    @TempTableColumnOrder(10)
    private RString toshiNo;
    @TempTableColumnOrder(11)
    private RString kohi1FutanshaNo;
    @TempTableColumnOrder(12)
    private RString kohi1JukyushaNo;
    @TempTableColumnOrder(13)
    private RString kohi2FutanshaNo;
    @TempTableColumnOrder(14)
    private RString kohi2JukyushaNo;
    @TempTableColumnOrder(15)
    private RString kohi3FutanshaNo;
    @TempTableColumnOrder(16)
    private RString kohi3JukyushaNo;
    @TempTableColumnOrder(17)
    private FlexibleDate umareYMD;
    @TempTableColumnOrder(18)
    private RString seibetsuCode;
    @TempTableColumnOrder(19)
    private RString yoKaigoJotaiKubunCode;
    @TempTableColumnOrder(20)
    private RString kyuSochiNyushoshaTokureiCode;
    @TempTableColumnOrder(21)
    private FlexibleDate ninteiYukoKaishiYMD;
    @TempTableColumnOrder(22)
    private FlexibleDate ninteiYukoShuryoYMD;
    @TempTableColumnOrder(23)
    private RString rojinHokenShichosonNo;
    @TempTableColumnOrder(24)
    private RString rojinhokenJukyushaNo;
    @TempTableColumnOrder(25)
    private RString kokiHokenshaNo;
    @TempTableColumnOrder(26)
    private RString kokiHiHokenshaNo;
    @TempTableColumnOrder(27)
    private RString kokuhoHokenshaNo;
    @TempTableColumnOrder(28)
    private RString kokuhoHiHokenshashoNo;
    @TempTableColumnOrder(29)
    private RString kokuhoKojinNo;
    @TempTableColumnOrder(30)
    private RString kyotakuServiceSakuseiKubunCode;
    @TempTableColumnOrder(31)
    private JigyoshaNo kyotakuKaigoShienJigyoshoNo;
    @TempTableColumnOrder(32)
    private FlexibleDate kaishiYMD;
    @TempTableColumnOrder(33)
    private FlexibleDate chushiYMD;
    @TempTableColumnOrder(34)
    private RString chushiRiyuNyushomaeJyokyoCode;
    @TempTableColumnOrder(35)
    private FlexibleDate nyushoYMD;
    @TempTableColumnOrder(36)
    private FlexibleDate taishoYMD;
    @TempTableColumnOrder(37)
    private int nyushoJitsunissu;
    @TempTableColumnOrder(38)
    private int gaihakuNissu;
    @TempTableColumnOrder(39)
    private RString taishogoJotaiCode;
    @TempTableColumnOrder(40)
    private HokenKyufuRitsu hokenKyufuritsu;
    @TempTableColumnOrder(41)
    private HokenKyufuRitsu kohi1Kyufuritsu;
    @TempTableColumnOrder(42)
    private HokenKyufuRitsu kohi2Kyufuritsu;
    @TempTableColumnOrder(43)
    private HokenKyufuRitsu kohi3Kyufuritsu;
    @TempTableColumnOrder(44)
    private int maeHokenServiceTanisu;
    @TempTableColumnOrder(45)
    private Decimal maeHokenSeikyugaku;
    @TempTableColumnOrder(46)
    private int maeHokenRiyoshaFutangaku;
    @TempTableColumnOrder(47)
    private Decimal maeHokenKinkyuShisetsuRyoyoSeikyugaku;
    @TempTableColumnOrder(48)
    private Decimal maeHokenTokuteiShinryohiSeikyugaku;
    @TempTableColumnOrder(49)
    private int maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku;
    @TempTableColumnOrder(50)
    private int maeKohi1ServiceTanisu;
    @TempTableColumnOrder(51)
    private int maeKohi1Seikyugaku;
    @TempTableColumnOrder(52)
    private int maeKohi1RiyoshaFutangaku;
    @TempTableColumnOrder(53)
    private int maeKohi1KinkyuShisetsuRyoyoSeikyugaku;
    @TempTableColumnOrder(54)
    private int maeKohi1TokuteiShinryohiSeikyugaku;
    @TempTableColumnOrder(55)
    private int maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    @TempTableColumnOrder(56)
    private int maeKohi2ServiceTanisu;
    @TempTableColumnOrder(57)
    private int maeKohi2Seikyugaku;
    @TempTableColumnOrder(58)
    private int maeKohi2RiyoshaFutangaku;
    @TempTableColumnOrder(59)
    private int maeKohi2KinkyuShisetsuRyoyoSeikyugaku;
    @TempTableColumnOrder(60)
    private int maeKohi2TokuteiShinryohiSeikyugaku;
    @TempTableColumnOrder(61)
    private int maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    @TempTableColumnOrder(62)
    private int maeKohi3ServiceTanisu;
    @TempTableColumnOrder(63)
    private int maeKohi3Seikyugaku;
    @TempTableColumnOrder(64)
    private int maeKohi3RiyoshaFutangaku;
    @TempTableColumnOrder(65)
    private int maeKohi3KinkyuShisetsuRyoyoSeikyugaku;
    @TempTableColumnOrder(66)
    private int maeKohi3TokuteiShinryohiSeikyugaku;
    @TempTableColumnOrder(67)
    private int maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    @TempTableColumnOrder(68)
    private int atoHokenServiceTanisu;
    @TempTableColumnOrder(69)
    private Decimal atoHokenSeikyugaku;
    @TempTableColumnOrder(70)
    private int atoHokenRiyoshaFutangaku;
    @TempTableColumnOrder(71)
    private Decimal atoHokenKinkyuShisetsuRyoyoSeikyugaku;
    @TempTableColumnOrder(72)
    private Decimal atoHokenTokuteiShinryohiSeikyugaku;
    @TempTableColumnOrder(73)
    private int atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku;
    @TempTableColumnOrder(74)
    private int atoKohi1ServiceTanisu;
    @TempTableColumnOrder(75)
    private int atoKohi1Seikyugaku;
    @TempTableColumnOrder(76)
    private int atoKohi1RiyoshaFutangaku;
    @TempTableColumnOrder(77)
    private int atoKohi1KinkyuShisetsuRyoyoSeikyugaku;
    @TempTableColumnOrder(78)
    private int atoKohi1TokuteiShinryohiSeikyugaku;
    @TempTableColumnOrder(79)
    private int atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    @TempTableColumnOrder(80)
    private int atoKohi2ServiceTanisu;
    @TempTableColumnOrder(81)
    private int atoKohi2Seikyugaku;
    @TempTableColumnOrder(82)
    private int atoKohi2RiyoshaFutangaku;
    @TempTableColumnOrder(83)
    private int atoKohi2KinkyuShisetsuRyoyoSeikyugaku;
    @TempTableColumnOrder(84)
    private int atoKohi2TokuteiShinryohiSeikyugaku;
    @TempTableColumnOrder(85)
    private int atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    @TempTableColumnOrder(86)
    private int atoKohi3ServiceTanisu;
    @TempTableColumnOrder(87)
    private int atoKohi3Seikyugaku;
    @TempTableColumnOrder(88)
    private int atoKohi3RiyoshaFutangaku;
    @TempTableColumnOrder(89)
    private int atoKohi3KinkyuShisetsuRyoyoSeikyugaku;
    @TempTableColumnOrder(90)
    private int atoKohi3TokuteiShinryohiSeikyugaku;
    @TempTableColumnOrder(91)
    private int atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    @TempTableColumnOrder(92)
    private RString keikaiKubunCode;
    @TempTableColumnOrder(93)
    private FlexibleYearMonth shinsaYM;
    @TempTableColumnOrder(94)
    private RString seiriNo;
    @TempTableColumnOrder(95)
    private FlexibleYearMonth sofuYM;
    @TempTableColumnOrder(96)
    private FlexibleYearMonth torikomiYM;
    @TempTableColumnOrder(97)
    private RString dokujiSakuseiKubun;
    @TempTableColumnOrder(98)
    private boolean hokenshaHoyuKyufujissekiJohoSakujoFlag;
    @TempTableColumnOrder(99)
    @PrimaryKey
    private int renban;
    @TempTableColumnOrder(100)
    private boolean sofuJogaiFlag;
    @TempTableColumnOrder(101)
    private HokenshaNo hokenshaNo;
    @TempTableColumnOrder(102)
    private RString hokenshaName;
    @TempTableColumnOrder(103)
    private HihokenshaNo sofuHihokenshaNo;
    @TempTableColumnOrder(104)
    private RString meisaiSetteiKubun;
    @TempTableColumnOrder(105)
    private RString kinkyuShisetsuRyoyoSetteiKubun;
    @TempTableColumnOrder(106)
    private RString tokuteiShinryoSetteiKubun;
    @TempTableColumnOrder(107)
    private RString shokujiHiyosetteiKubun;
    @TempTableColumnOrder(108)
    private RString kyotakuKeikakuSetteiKubun;
    @TempTableColumnOrder(109)
    private RString fukushoyouguKonyuSetteiKubun;
    @TempTableColumnOrder(110)
    private RString jutakukaishuSetteiKubun;
    @TempTableColumnOrder(111)
    private RString tokuteishinryoTokubetsuryoyoSetteiKubun;
    @TempTableColumnOrder(112)
    private RString tokuteinyushoshaSetteiKubun;
    @TempTableColumnOrder(113)
    private RString shakaifukushiKeigenSetteiKubun;
    @TempTableColumnOrder(114)
    private RString shoteiShikkanSetteiKubun;
    @TempTableColumnOrder(115)
    private RString meisaiJushochitokureiSetteiKubun;
    @TempTableColumnOrder(116)
    private RString shukeiSetteiKubun;

}
