/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TsuzukigaraCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * サービス明細中間一時TBLクラスです
 *
 * @reamsid_L DBC-3330-040 jiangxiaolong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT3470ServiceMeisaichukanTempEntity
        extends DbTableEntityBase<DbWT3470ServiceMeisaichukanTempEntity> implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private int renban;
    @TempTableColumnOrder(2)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(3)
    private RString juminShubetsuCode;
    @TempTableColumnOrder(4)
    private AtenaMeisho meisho;
    @TempTableColumnOrder(5)
    private AtenaKanaMeisho kanaMeisho;
    @TempTableColumnOrder(6)
    private FlexibleDate seinengappiYMD;
    @TempTableColumnOrder(7)
    private RString age;
    @TempTableColumnOrder(8)
    private RString seibetsu;
    @TempTableColumnOrder(9)
    private TsuzukigaraCode tsuzukigaraCode;
    @TempTableColumnOrder(10)
    private SetaiCode setaiCode;
    @TempTableColumnOrder(11)
    private AtenaMeisho setainushiMei;
    @TempTableColumnOrder(12)
    private ChoikiCode choikiCode;
    @TempTableColumnOrder(13)
    private YubinNo yubinNo;
    @TempTableColumnOrder(14)
    private RString jushoBanchiKatagaki;
    @TempTableColumnOrder(15)
    private RString jusho;
    @TempTableColumnOrder(16)
    private RString banchi;
    @TempTableColumnOrder(17)
    private RString katagaki;
    @TempTableColumnOrder(18)
    private GyoseikuCode gyoseikuCode;
    @TempTableColumnOrder(19)
    private RString gyoseikuName;
    @TempTableColumnOrder(20)
    private RString chikuCode1;
    @TempTableColumnOrder(21)
    private RString chikuCode2;
    @TempTableColumnOrder(22)
    private RString chikuCode3;
    @TempTableColumnOrder(23)
    private RString blank;
    @TempTableColumnOrder(24)
    private RString hihokennshaKubunCode;
    @TempTableColumnOrder(25)
    private LasdecCode shichosonCode;
    @TempTableColumnOrder(26)
    private RString koikinaiJushochiTokureiFlag;
    @TempTableColumnOrder(27)
    private LasdecCode koikinaiTokureiSochimotoShichosonCode;
    @TempTableColumnOrder(28)
    private LasdecCode kyuShichosonCode;
    @TempTableColumnOrder(29)
    private NyuryokuShikibetsuNo inputShikibetsuNo;
    @TempTableColumnOrder(30)
    private RString kyufuSakuseiKubunCode;
    @TempTableColumnOrder(31)
    private RString shokisaiHokenshaNo;
    @TempTableColumnOrder(32)
    private RString shokisaiHokenshaName;
    @TempTableColumnOrder(33)
    private HihokenshaNo hiHokenshaNo;
    @TempTableColumnOrder(34)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(35)
    private RString kyufuJissekiKubunCode;
    @TempTableColumnOrder(36)
    private JigyoshaNo jigyoshoNo;
    @TempTableColumnOrder(37)
    private RString jigyoshoName;
    @TempTableColumnOrder(38)
    private RString yoKaigoJotaiKubunCode;
    @TempTableColumnOrder(39)
    private RString kyuSochiNyushoshaTokureiCode;
    @TempTableColumnOrder(40)
    private FlexibleDate ninteiYukoKaishiYMD;
    @TempTableColumnOrder(41)
    private FlexibleDate ninteiYukoShuryoYMD;
    @TempTableColumnOrder(42)
    private RString rojinHokenShichosonNo;
    @TempTableColumnOrder(43)
    private RString rojinhokenJukyushaNo;
    @TempTableColumnOrder(44)
    private RString kyotakuServiceSakuseiKubunCode;
    @TempTableColumnOrder(45)
    private RString sakujigyoshoNo;
    @TempTableColumnOrder(46)
    private RString sakujigyoshoName;
    @TempTableColumnOrder(47)
    private FlexibleDate nyushoYMD;
    @TempTableColumnOrder(48)
    private FlexibleDate taishoYMD;
    @TempTableColumnOrder(49)
    private Decimal nyushoJitsunissu;
    @TempTableColumnOrder(50)
    private Decimal hokenKyufuritsu;
    @TempTableColumnOrder(51)
    private Decimal kohi1Kyufuritsu;
    @TempTableColumnOrder(52)
    private Decimal kohi2Kyufuritsu;
    @TempTableColumnOrder(53)
    private Decimal kohi3Kyufuritsu;
    @TempTableColumnOrder(54)
    private RString kokiHokenshaNo;
    @TempTableColumnOrder(55)
    private RString kokiHiHokenshaNo;
    @TempTableColumnOrder(56)
    private RString kokuhoHokenshaNo;
    @TempTableColumnOrder(57)
    private RString kokuhoHiHokenshashoNo;
    @TempTableColumnOrder(58)
    private RString kokuhoKojinNo;
    @TempTableColumnOrder(59)
    private ServiceShuruiCode serviceShuruiCode;
    @TempTableColumnOrder(60)
    private ServiceKomokuCode serviceKomokuCode;
    @TempTableColumnOrder(61)
    private RString serviceCode;
    @TempTableColumnOrder(62)
    private RString serviceName;
    @TempTableColumnOrder(63)
    private RString serviceCodeName;
    @TempTableColumnOrder(64)
    private Decimal atoTanisu;
    @TempTableColumnOrder(65)
    private Decimal atoNissuKaisu;
    @TempTableColumnOrder(66)
    private Decimal atoKohi1TaishoNissuKaisu;
    @TempTableColumnOrder(67)
    private Decimal atoKohi2TaishoNissukaisu;
    @TempTableColumnOrder(68)
    private Decimal atoKohi3TaishoNissuKaisu;
    @TempTableColumnOrder(69)
    private Decimal atoServiceTanisu;
    @TempTableColumnOrder(70)
    private Decimal atoKohi1TaishoServiceTanisu;
    @TempTableColumnOrder(71)
    private Decimal atoKohi2TaishoServiceTanisu;
    @TempTableColumnOrder(72)
    private Decimal atoKohi3TaishoServiceTanisu;
    @TempTableColumnOrder(73)
    private Decimal saishinsaKaisu;
    @TempTableColumnOrder(74)
    private Decimal kagoKaisu;
    @TempTableColumnOrder(75)
    private FlexibleYearMonth shinsaYM;
}
