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
 * 給付実績D6一時TBLテーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT111HKyufuJissekiD6Entity extends DbTableEntityBase<DbWT111HKyufuJissekiD6Entity> implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private int renban;
    @TempTableColumnOrder(2)
    private RString recordNo;
    @TempTableColumnOrder(3)
    private KokanShikibetsuNo kokanJohoShikibetsuNo;
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
    private RString toshiNo;
    @TempTableColumnOrder(11)
    private RString meisaiNo;
    @TempTableColumnOrder(12)
    private ServiceCode serviceCode;
    @TempTableColumnOrder(13)
    private FlexibleDate fukushiyoguHanbaiYMD;
    @TempTableColumnOrder(14)
    private RString fukushiyoguShohinName;
    @TempTableColumnOrder(15)
    private RString fukushiyoguSyumokuCode;
    @TempTableColumnOrder(16)
    private RString fukushiyoguSeizoJigyoshaName;
    @TempTableColumnOrder(17)
    private RString fukushiyoguHanbaiJigyoshaName;
    @TempTableColumnOrder(18)
    private Decimal hanbaiKingaku;
    @TempTableColumnOrder(19)
    private RString tekiyo;
    @TempTableColumnOrder(20)
    private FlexibleYearMonth shinsaYM;
    @TempTableColumnOrder(21)
    private RString seiriNo;
    @TempTableColumnOrder(22)
    private FlexibleYearMonth torikomiYM;
}
