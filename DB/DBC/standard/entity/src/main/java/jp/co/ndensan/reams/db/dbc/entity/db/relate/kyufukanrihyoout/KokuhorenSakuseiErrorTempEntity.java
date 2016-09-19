/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 処理結果リスト一時TBLのEntity
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class KokuhorenSakuseiErrorTempEntity extends DbTableEntityBase<KokuhorenSakuseiErrorTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private RString errorKubun;
    @TempTableColumnOrder(2)
    private RString shoHokanehshaNo;
    @TempTableColumnOrder(3)
    private RString hihokenshaNo;
    @TempTableColumnOrder(4)
    private RString key1;
    @TempTableColumnOrder(5)
    private RString key2;
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
