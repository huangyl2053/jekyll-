/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 給付実績DB一時TBLテーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT111MKyufuJissekiDBEntity extends DbTableEntityBase<DbWT111MKyufuJissekiDBEntity> implements IDbAccessable {

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
    private RString recordShubetsuCode;
    @TempTableColumnOrder(6)
    private HokenshaNo shokisaiHokenshaNo;
    @TempTableColumnOrder(7)
    private HihokenshaNo hiHokenshaNo;
    @TempTableColumnOrder(8)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(9)
    private JigyoshaNo jigyoshoNo;
    @TempTableColumnOrder(10)
    private RString shiteiKijungaitoJigyoshoKubunCode;
    @TempTableColumnOrder(11)
    private FlexibleDate kyotakuServiceSakuseiIraiYMD;
    @TempTableColumnOrder(12)
    private RString toshiNo;
    @TempTableColumnOrder(13)
    private RString servicePlanhiMeisaiLineNo;
    @TempTableColumnOrder(14)
    private Decimal tanisuTanka;
    @TempTableColumnOrder(15)
    private ServiceCode serviceCode;
    @TempTableColumnOrder(16)
    private int tanisu;
    @TempTableColumnOrder(17)
    private int kaisu;
    @TempTableColumnOrder(18)
    private int serviceTanisu;
    @TempTableColumnOrder(19)
    private int serivceTanisuTotal;
    @TempTableColumnOrder(20)
    private int seikyuKingaku;
    @TempTableColumnOrder(21)
    private RString tantoKaigoShienSemmoninNo;
    @TempTableColumnOrder(22)
    private RString tekiyo;
    @TempTableColumnOrder(23)
    private int riyoushaFutangaku;
    @TempTableColumnOrder(24)
    private int atoTanisu;
    @TempTableColumnOrder(25)
    private int atoKaisu;
    @TempTableColumnOrder(26)
    private int atoServiceTanisu;
    @TempTableColumnOrder(27)
    private int atoServiceTanisuTotal;
    @TempTableColumnOrder(28)
    private int atoSeikyuKingaku;
    @TempTableColumnOrder(29)
    private int atoRiyoshaFutangaku;
    @TempTableColumnOrder(30)
    private int saishinsaKaisu;
    @TempTableColumnOrder(31)
    private int kagoKaisu;
    @TempTableColumnOrder(32)
    private FlexibleYearMonth shinsaYM;
    @TempTableColumnOrder(33)
    private RString seiriNo;
    @TempTableColumnOrder(34)
    private FlexibleYearMonth torikomiYM;
}
