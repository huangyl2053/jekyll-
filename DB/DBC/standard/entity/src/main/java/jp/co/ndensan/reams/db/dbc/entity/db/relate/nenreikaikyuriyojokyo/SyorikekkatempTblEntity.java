/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikaikyuriyojokyo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 出力用一時デーブルクラスです。
 *
 * @reamsid_L DBC-3470-030 xuyongchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class SyorikekkatempTblEntity implements IDbAccessable {

    @TempTableColumnOrder(1)
    private RString shoriMei;
    @TempTableColumnOrder(2)
    private HihokenshaNo hiHokenshaNo;
    @TempTableColumnOrder(3)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(4)
    private RString hiHokenshaKana;
    @TempTableColumnOrder(5)
    private RString errorMsg;
    @TempTableColumnOrder(6)
    private RString bikou;

}
