/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 宛名シール作成 処理結果リスト一時TBLEntity。
 *
 * @reamsid_L DBA-1210-030 zhengsongling
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class ShorikekkarisutoichijiTBLEntity extends DbTableEntityBase<ShorikekkarisutoichijiTBLEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private RString errorCode;
    @TempTableColumnOrder(2)
    private RString ariShikusaihokenshaBongou;
    @TempTableColumnOrder(3)
    private RString hihoKenshaNo;
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
    private RString kanaShimei;
    @TempTableColumnOrder(10)
    private RString shiMei;
    @TempTableColumnOrder(11)
    private RString biKou;
}
