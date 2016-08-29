/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shikakushogohyojyoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.SeibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 資格照合表一時テーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2890-013 wangxue
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT1211ShikakuShogohyoTempEntity extends DbTableEntityBase<DbWT1211ShikakuShogohyoTempEntity>
        implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private int renban;
    @TempTableColumnOrder(2)
    private ServiceShuruiCode serviceShuruiCode;
    @TempTableColumnOrder(3)
    private RString serviceShuruiMei;
    @TempTableColumnOrder(4)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(5)
    private RString shubetsu;
    @TempTableColumnOrder(6)
    private JigyoshaNo jigyoshoNo;
    @TempTableColumnOrder(7)
    private RString jigyoshoMei;
    @TempTableColumnOrder(8)
    private FlexibleDate seinenYMD;
    @TempTableColumnOrder(9)
    private SeibetsuCode seibetsuCode;
    @TempTableColumnOrder(10)
    private Code yokaigoKubunCode;
    @TempTableColumnOrder(11)
    private RString kyusochiTokureiCode;
    @TempTableColumnOrder(12)
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    @TempTableColumnOrder(13)
    private FlexibleDate ninteiYukoKikanShuryoYMD;
    @TempTableColumnOrder(14)
    private FlexibleDate gendoGakuTekiyoKikanKaishiYMD;
    @TempTableColumnOrder(15)
    private FlexibleDate gendoGakuTekiyoKikanShuryoYMD;
    @TempTableColumnOrder(16)
    private Decimal shikyuGendoGaku;
    @TempTableColumnOrder(17)
    private Code kyotakuServicePlanSakuseiKubunCode;
    @TempTableColumnOrder(18)
    private JigyoshaNo shienJigyoshoNo;
    @TempTableColumnOrder(19)
    private Decimal getsuGakuShokujiFutanGaku;
    @TempTableColumnOrder(20)
    private Decimal nichiGakuShokujiFutanGaku;
    @TempTableColumnOrder(21)
    private Decimal shokuhiFutanGendoGaku;
    @TempTableColumnOrder(22)
    private Decimal kyojuhiFutanGendoGaku1;
    @TempTableColumnOrder(23)
    private Decimal kyojuhiFutanGendoGaku2;
    @TempTableColumnOrder(24)
    private Decimal kyojuhiFutanGendoGaku3;
    @TempTableColumnOrder(25)
    private Decimal kyojuhiFutanGendoGaku4;
    @TempTableColumnOrder(26)
    private Decimal kyojuhiFutanGendoGaku5;
    @TempTableColumnOrder(27)
    private Decimal tanisuTanka;
    @TempTableColumnOrder(28)
    private HokenKyufuRitsu hokenKyufuRitsu;
    @TempTableColumnOrder(29)
    private HokenKyufuRitsu kohi1KyufuRitsu;
    @TempTableColumnOrder(30)
    private HokenKyufuRitsu kohi2KyufuRitsu;
    @TempTableColumnOrder(31)
    private HokenKyufuRitsu kohi3KyufuRitsu;
    @TempTableColumnOrder(32)
    private int serviceNissuKaisu;
    @TempTableColumnOrder(33)
    private Decimal serviceTanisu;
    @TempTableColumnOrder(34)
    private Decimal tokuteiNyushoshaKaigoServiceGaku;
    @TempTableColumnOrder(35)
    private Decimal riyoshaFutanGaku;
    @TempTableColumnOrder(36)
    private Decimal shokujiFutanGaku;
    @TempTableColumnOrder(37)
    private HihokenshaNo hokenshaNo;
    @TempTableColumnOrder(38)
    private RString hokenshaName;
    @TempTableColumnOrder(39)
    private FlexibleYearMonth shinsaYM;

}
