/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiin;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 高額合算給付実績一時テーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2700-030 wangxingpeng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT38P1KogakuGassanKyufuJissekiTempEntity extends
        DbTableEntityBase<DbWT38P1KogakuGassanKyufuJissekiTempEntity> implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private int renban;
    @TempTableColumnOrder(2)
    private KokanShikibetsuNo kokanJohoShikibetsuNo;
    @TempTableColumnOrder(3)
    private HihokenshaNo hihokenshaNoIn;
    @TempTableColumnOrder(4)
    private RString shikyuShinseiSeiriNo;
    @TempTableColumnOrder(5)
    private RString seiriNo;
    @TempTableColumnOrder(6)
    private RString jikoFutanSeiriNo;
    @TempTableColumnOrder(7)
    private RString hokenSeidoCode;
    @TempTableColumnOrder(8)
    private RString kyufuJissekiSakuseiKubunCode;
    @TempTableColumnOrder(9)
    private HokenshaNo shoKisaiHokenshaNo;
    @TempTableColumnOrder(10)
    private RString kokuho_HihokenshaShoKigo;
    @TempTableColumnOrder(11)
    private FlexibleDate shinseiYMD;
    @TempTableColumnOrder(12)
    private FlexibleDate ketteiYMD;
    @TempTableColumnOrder(13)
    private Decimal jikoFutanSogaku;
    @TempTableColumnOrder(14)
    private Decimal shikyuGaku;
    @TempTableColumnOrder(15)
    private FlexibleYearMonth shoriYM;
    @TempTableColumnOrder(16)
    private FlexibleYearMonth uketoriYM;
    @TempTableColumnOrder(17)
    private FlexibleYearMonth sofuYM;
    @TempTableColumnOrder(18)
    private RString dataKubun;

}
