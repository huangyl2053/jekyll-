/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikaikyuriyojokyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
public class TmpSyuturyokuYoRelateEntity implements IDbAccessable {

    @TempTableColumnOrder(1)
    private RString serviceSyuruiCodeMei;
    @TempTableColumnOrder(2)
    private RString no;
    @TempTableColumnOrder(3)
    private RString pageNo;
    @TempTableColumnOrder(4)
    private RString kubun;
    @TempTableColumnOrder(5)
    private Decimal hiGaitou;
    @TempTableColumnOrder(6)
    private Decimal yoSien1;
    @TempTableColumnOrder(7)
    private Decimal yoSien2;
    @TempTableColumnOrder(8)
    private Decimal keikatekiYoSien;
    @TempTableColumnOrder(9)
    private Decimal youKaigo1;
    @TempTableColumnOrder(10)
    private Decimal youKaigo2;
    @TempTableColumnOrder(11)
    private Decimal youKaigo3;
    @TempTableColumnOrder(12)
    private Decimal youKaigo4;
    @TempTableColumnOrder(13)
    private Decimal youKaigo5;
    @TempTableColumnOrder(14)
    private Decimal goikei;
    @TempTableColumnOrder(15)
    private RString bikou;
}
