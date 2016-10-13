/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.henreihoryuin;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 請求一時TBL Entity。
 *
 * @reamsid_L DBC-2830-010 yaodongsheng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT7411SeikyuuTempEntity extends
        DbTableEntityBase<DbWT7411SeikyuuTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private int rirekiNo;
    @TempTableColumnOrder(2)
    private RString hokenshaNo;
    @TempTableColumnOrder(3)
    private RString hokenshaName;
    @TempTableColumnOrder(4)
    private FlexibleYearMonth shinsaYM;
    @TempTableColumnOrder(5)
    private RString kokuhorenName;
}
