/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 処理結果リスト一時TBL
 *
 * @reamsid_L DBC-3340-030 jiangxiaolong
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT3470shoriKekkaListTempEntity extends DbTableEntityBase<DbWT3470shoriKekkaListTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private RString errorKubun;
    @TempTableColumnOrder(2)
    private ShoKisaiHokenshaNo shoHokanehshaNo;
    @TempTableColumnOrder(3)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(4)
    private FlexibleYearMonth key1;
    @TempTableColumnOrder(5)
    private FlexibleYearMonth key2;
    @TempTableColumnOrder(6)
    private RString key3;
    @TempTableColumnOrder(7)
    private RString key4;
    @TempTableColumnOrder(8)
    private RString key5;
    @TempTableColumnOrder(9)
    private RString hihokenshaKanaShimei;
    @TempTableColumnOrder(10)
    private RString hihokenshaShimei;
    @TempTableColumnOrder(11)
    private RString biko;
}
