/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 処理結果リスト一時TBLのentity
 *
 * @reamsid_L DBC-3490-050 yaoyahui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class SyorikekkatempTblEntity extends DbTableEntityBase<SyorikekkatempTblEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private RString errorkubun;
    @TempTableColumnOrder(2)
    private RString hiHokenshaNo;
    @TempTableColumnOrder(3)
    private FlexibleYearMonth ki1;
    @TempTableColumnOrder(4)
    private FlexibleDate ki2;
    @TempTableColumnOrder(5)
    private RString ki3;
    @TempTableColumnOrder(6)
    private RString ki4;
    @TempTableColumnOrder(7)
    private RString ki5;
    @TempTableColumnOrder(8)
    private RString errornaiyo;
    @TempTableColumnOrder(9)
    private RString biko;
}
