/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100010;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成のRelateEntityクラスです。
 *
 * @reamsid_L DBC-2860-030 suguangjun
 */
@SuppressWarnings("PMd.UnusedPrivateField")
@lombok.Setter
@lombok.Getter
@OnNextSchema("rgdb")
public class SeikyuShukeiItiziEUCEntity extends DbTableEntityBase<SeikyuShukeiItiziEUCEntity> implements IDbAccessable {

    /**
     * TableNameを設定です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("tempSeikyuShukeiItiziData"));
    }
    @TempTableColumnOrder(1)
    private ShoKisaiHokenshaNo 証記載保険者番号;
    @TempTableColumnOrder(2)
    private JigyoshaNo 介護住宅改修理由書作成事業者番号;
    @TempTableColumnOrder(3)
    private RString 集計関連付け番号;
    @TempTableColumnOrder(4)
    private int 履歴番号;
    @TempTableColumnOrder(5)
    private RDate 集計開始年月;
    @TempTableColumnOrder(6)
    private RDate 集計終了年月;
    @TempTableColumnOrder(7)
    private int 介護住宅改修理由書作成件数;
    @TempTableColumnOrder(8)
    private Decimal 介護住宅改修理由書作成単価;
    @TempTableColumnOrder(9)
    private Decimal 介護住宅改修理由書作成請求金額;
}
