/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.temptable;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 滞納者対策最大履歴番号一時テーブルEntity
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TainoMaxRirekiNoTempTableEntity extends DbTableEntityBase<TainoMaxRirekiNoTempTableEntity> implements IDbAccessable {

    /**
     * 納者対策最大履歴番号一時テーブル
     */
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = new RString("TainoCountermeasureMaxRirekiNoTempTable");
    }
    @TempTableColumnOrder(1)
    private RString shoKisaiHokenshaNo;
    @TempTableColumnOrder(2)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(3)
    private RString kanriKubun;
    @TempTableColumnOrder(4)
    private int maxRirekiNo;
}
