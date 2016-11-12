/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei;

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
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 給付実績基本一時テーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class DbWT1510KyufuJissekiKihonEntity extends DbTableEntityBase<DbWT1510KyufuJissekiKihonEntity> implements IDbAccessable {

    @PrimaryKey
    private KokanShikibetsuNo kokanShikibetsuNo;
    private NyuryokuShikibetsuNo inputShikibetsuNo;
    private RString recodeShubetsuCode;
    private HokenshaNo shokisaiHokenshaNo;
    private HihokenshaNo hiHokenshaNo;
    private FlexibleYearMonth serviceTeikyoYM;
    private JigyoshaNo jigyoshoNo;
    private RString kyufuSakuseiKubunCode;
    private RString kyufuJissekiKubunCode;
    private RString toshiNo;
    private RString kohi1FutanshaNo;
    private RString kohi1JukyushaNo;
    private RString kohi2FutanshaNo;
    private RString kohi2JukyushaNo;
    private RString kohi3FutanshaNo;
    private RString kohi3JukyushaNo;
    private FlexibleDate umareYMD;
    private RString seibetsuCode;
    private RString yoKaigoJotaiKubunCode;
    private RString kyuSochiNyushoshaTokureiCode;
    private FlexibleDate ninteiYukoKaishiYMD;
    private FlexibleDate ninteiYukoShuryoYMD;
    private RString rojinHokenShichosonNo;
    private RString rojinhokenJukyushaNo;
    private RString kokiHokenshaNo;
    private RString kokiHiHokenshaNo;
    private RString kokuhoHokenshaNo;
    private RString kokuhoHiHokenshashoNo;
    private RString kokuhoKojinNo;
    private RString kyotakuServiceSakuseiKubunCode;
    private JigyoshaNo kyotakuKaigoShienJigyoshoNo;
    private FlexibleDate kaishiYMD;
    private FlexibleDate chushiYMD;
    private RString chushiRiyuNyushomaeJyokyoCode;
    private FlexibleDate nyushoYMD;
    private FlexibleDate taishoYMD;
    private int nyushoJitsunissu;
    private int gaihakuNissu;
    private RString taishogoJotaiCode;
    private HokenKyufuRitsu hokenKyufuritsu;
    private HokenKyufuRitsu kohi1Kyufuritsu;
    private HokenKyufuRitsu kohi2Kyufuritsu;
    private HokenKyufuRitsu kohi3Kyufuritsu;
    private int maeHokenServiceTanisu;
    private Decimal maeHokenSeikyugaku;
    private int maeHokenRiyoshaFutangaku;
    private Decimal maeHokenKinkyuShisetsuRyoyoSeikyugaku;
    private Decimal maeHokenTokuteiShinryohiSeikyugaku;
    private int maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku;
    private int maeKohi1ServiceTanisu;
    private int maeKohi1Seikyugaku;
    private int maeKohi1RiyoshaFutangaku;
    private int maeKohi1KinkyuShisetsuRyoyoSeikyugaku;
    private int maeKohi1TokuteiShinryohiSeikyugaku;
    private int maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    private int maeKohi2ServiceTanisu;
    private int maeKohi2Seikyugaku;
    private int maeKohi2RiyoshaFutangaku;
    private int maeKohi2KinkyuShisetsuRyoyoSeikyugaku;
    private int maeKohi2TokuteiShinryohiSeikyugaku;
    private int maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    private int maeKohi3ServiceTanisu;
    private int maeKohi3Seikyugaku;
    private int maeKohi3RiyoshaFutangaku;
    private int maeKohi3KinkyuShisetsuRyoyoSeikyugaku;
    private int maeKohi3TokuteiShinryohiSeikyugaku;
    private int maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    private int atoHokenServiceTanisu;
    private Decimal atoHokenSeikyugaku;
    private int atoHokenRiyoshaFutangaku;
    private Decimal atoHokenKinkyuShisetsuRyoyoSeikyugaku;
    private Decimal atoHokenTokuteiShinryohiSeikyugaku;
    private int atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku;
    private int atoKohi1ServiceTanisu;
    private int atoKohi1Seikyugaku;
    private int atoKohi1RiyoshaFutangaku;
    private int atoKohi1KinkyuShisetsuRyoyoSeikyugaku;
    private int atoKohi1TokuteiShinryohiSeikyugaku;
    private int atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    private int atoKohi2ServiceTanisu;
    private int atoKohi2Seikyugaku;
    private int atoKohi2RiyoshaFutangaku;
    private int atoKohi2KinkyuShisetsuRyoyoSeikyugaku;
    private int atoKohi2TokuteiShinryohiSeikyugaku;
    private int atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    private int atoKohi3ServiceTanisu;
    private int atoKohi3Seikyugaku;
    private int atoKohi3RiyoshaFutangaku;
    private int atoKohi3KinkyuShisetsuRyoyoSeikyugaku;
    private int atoKohi3TokuteiShinryohiSeikyugaku;
    private int atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    private RString keikaiKubunCode;
    private FlexibleYearMonth shinsaYM;
    private RString seiriNo;
    private FlexibleYearMonth sofuYM;
    private FlexibleYearMonth torikomiYM;
    private RString dokujiSakuseiKubun;
    private boolean hokenshaHoyuKyufujissekiJohoSakujoFlag;
    private boolean shutsuryokuFlag;
    private RString meisaiSetteiKubun;
    private RString shokujiHiyosetteiKubun;
    private RString kyotakuKeikakuSetteiKubun;
    private RString fukushiyoguKonyuSetteiKubun;
    private RString jutakuKaishuSetteiKubun;
    private RString tokuteiNyushoshaSetteiKubun;
    private RString shakaiFukushiKeigenSetteiKubun;
    private RString shukeiSetteiKubun;
}
