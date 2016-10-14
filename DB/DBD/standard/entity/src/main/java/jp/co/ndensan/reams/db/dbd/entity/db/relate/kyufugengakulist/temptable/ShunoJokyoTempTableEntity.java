/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.temptable;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 収納状況一時テーブルEntity
 *
 * @reamsid_L DBD-3610-050 jinge
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShunoJokyoTempTableEntity extends DbTableEntityBase<ShunoJokyoTempTableEntity> implements IDbAccessable {

    /**
     * テーブル名です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("ShunoJokyoTemp"));
    }

    @PrimaryKey
    @TempTableColumnOrder(1)
    private HihokenshaNo tmp_hihokenshaNo;
    @TempTableColumnOrder(2)
    @PrimaryKey
    private FlexibleYear tmp_choteiNendo;
    @TempTableColumnOrder(3)
    @PrimaryKey
    private FlexibleYear tmp_fukaNendo;
    @TempTableColumnOrder(4)
    private RString tmp_tokucho_fuchoKubun;
    @TempTableColumnOrder(5)
    @PrimaryKey
    private TsuchishoNo tmp_tsuchishoNo;
    @TempTableColumnOrder(6)
    @PrimaryKey
    private int tmp_kibetsu;
    @TempTableColumnOrder(7)
    private Decimal tmp_choteigaku;
    @TempTableColumnOrder(8)
    private Decimal tmp_shunyugaku;
    @TempTableColumnOrder(9)
    private Decimal tmp_minogaku;
    @TempTableColumnOrder(10)
    private RDate tmp_nokigen;
    @TempTableColumnOrder(11)
    private RDate tmp_shunyuYMD;
    @TempTableColumnOrder(12)
    private RDate tmp_tokusokujoHakkoYMD;
    @TempTableColumnOrder(13)
    private FlexibleDate tmp_jikoKisanYMD;
    @TempTableColumnOrder(14)
    private RString tmp_jikoKisanJiyu;
    @TempTableColumnOrder(15)
    private RString tmp_minoKannoKubun;
    @TempTableColumnOrder(16)
    private RString tmp_jikoKubun;
}
