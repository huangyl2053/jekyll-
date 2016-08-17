/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.temptable;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 氏名カナ突合結果件数一時テーブルEntityクラスです．
 *
 * @reamsid_L DBD-4910-040 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShimeiKanaTotsugoKensuTempTableEntity extends DbTableEntityBase<ShimeiKanaTotsugoKensuTempTableEntity> implements IDbAccessable {

    @TableName
    public static final RString TABLE_NAME = new RString("ShimeiKanaTotsugoKensuTempTable");

    @TempTableColumnOrder(1)
    private RString dtNennkinnHokenshaCode;
    @TempTableColumnOrder(2)
    private RString dtNennkinnCode;
    @TempTableColumnOrder(3)
    private RString dtKisoNennkinnNo;
    @TempTableColumnOrder(4)
    private RString dtTaisyoYear;
    @TempTableColumnOrder(5)
    private FlexibleDate dtCreateYMD;
    @TempTableColumnOrder(6)
    private int count;
}
