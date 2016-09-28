/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 出力用一時TBLEntity
 *
 * @reamsid_L DBC-3490-050 yaoyahui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class ShikakutempTblEntity extends DbTableEntityBase<ShikakutempTblEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    @PrimaryKey
    private RString serviceshurui;
    @TempTableColumnOrder(2)
    @PrimaryKey
    private RString pageNO;
    @TempTableColumnOrder(3)
    private RString hokenseiteitoku;
    @TempTableColumnOrder(4)
    @PrimaryKey
    private RString shotoku;
    @TempTableColumnOrder(5)
    @PrimaryKey
    private RString shukeinaiyou;
    @TempTableColumnOrder(6)
    private Decimal yoshien1;
    @TempTableColumnOrder(7)
    private Decimal yoshien2;
    @TempTableColumnOrder(8)
    private Decimal keikanoyokaigo;
    @TempTableColumnOrder(9)
    private Decimal yokaigo1;
    @TempTableColumnOrder(10)
    private Decimal yokaigo2;
    @TempTableColumnOrder(11)
    private Decimal yokaigo3;
    @TempTableColumnOrder(12)
    private Decimal yokaigo4;
    @TempTableColumnOrder(13)
    private Decimal yokaigo5;
    @TempTableColumnOrder(14)
    private Decimal gokeichi;
    @TempTableColumnOrder(15)
    private int shotokuCd;
}
