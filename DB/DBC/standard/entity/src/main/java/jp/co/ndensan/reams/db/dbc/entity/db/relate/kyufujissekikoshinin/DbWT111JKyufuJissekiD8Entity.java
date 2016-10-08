/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 給付実績D8一時TBLテーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT111JKyufuJissekiD8Entity extends DbTableEntityBase<DbWT111JKyufuJissekiD8Entity> implements IDbAccessable {

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
    private RString kyufuSakuseiKubunCode;
    @TempTableColumnOrder(10)
    private RString kyufuJissekiKubunCode;
    @TempTableColumnOrder(11)
    private RString toshiNo;
    @TempTableColumnOrder(12)
    private FlexibleDate uketsukeYMD;
    @TempTableColumnOrder(13)
    private FlexibleDate ketteiYMD;
    @TempTableColumnOrder(14)
    private RString kohi1FutanNo;
    @TempTableColumnOrder(15)
    private RString kohi2FutanNo;
    @TempTableColumnOrder(16)
    private RString kohi3FutanNo;
    @TempTableColumnOrder(17)
    private int riyoshaFutangaku;
    @TempTableColumnOrder(18)
    private int kohi1Futangaku;
    @TempTableColumnOrder(19)
    private int kohi2Futangaku;
    @TempTableColumnOrder(20)
    private int kohi3Futangaku;
    @TempTableColumnOrder(21)
    private int shikyugaku;
    @TempTableColumnOrder(22)
    private int kohi1Shikyugaku;
    @TempTableColumnOrder(23)
    private int kohi2Shikyugaku;
    @TempTableColumnOrder(24)
    private int kohi3Shikyugaku;
    @TempTableColumnOrder(25)
    private FlexibleYearMonth shinsaYM;
    @TempTableColumnOrder(26)
    private RString seiriNo;
    @TempTableColumnOrder(27)
    private FlexibleYearMonth sofuYM;
    @TempTableColumnOrder(28)
    private FlexibleYearMonth torikomiYM;
    @TempTableColumnOrder(29)
    private RString sakuseiKubun;
    @TempTableColumnOrder(30)
    private RString kanriNo;
    @TempTableColumnOrder(31)
    private boolean hokenshaHoyuKyufujissekiJohoSakujoZumiFlag;
}
