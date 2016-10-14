/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100010;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
public class SeikyuMeisaiItiziEUCEntity extends DbTableEntityBase<SeikyuMeisaiItiziEUCEntity> implements IDbAccessable {

    /**
     * TableNameを設定です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("tempSeikyuMeisaiItiziData"));
    }
    @TempTableColumnOrder(1)
    private ShoKisaiHokenshaNo 証記載保険者番号;
    @TempTableColumnOrder(2)
    private HihokenshaNo 被保険者番号;
    @TempTableColumnOrder(3)
    private int 履歴番号;
    @TempTableColumnOrder(4)
    private ServiceCode サービスコード;
    @TempTableColumnOrder(5)
    private RString 介護住宅改修事業者名称;
    @TempTableColumnOrder(6)
    private FlexibleDate 介護住宅改修着工年月日;
    @TempTableColumnOrder(7)
    private RString 介護住宅改修住宅所有者;
    @TempTableColumnOrder(8)
    private RString 改修対象住宅住所;
    @TempTableColumnOrder(9)
    private RString 改修内容箇所及び規模;
    @TempTableColumnOrder(10)
    private FlexibleDate 介護住宅改修理由書作成年月日;
    @TempTableColumnOrder(11)
    private JigyoshaNo 介護住宅改修理由書作成事業者番号;
    @TempTableColumnOrder(12)
    private RString 介護住宅改修理由書作成者名;
    @TempTableColumnOrder(13)
    private RString 介護住宅改修理由書作成者名カナ;
    @TempTableColumnOrder(14)
    private FlexibleDate 介護住宅改修理由書作成申請年月日;
    @TempTableColumnOrder(15)
    private FlexibleDate 介護住宅改修理由書作成受付年月日;
    @TempTableColumnOrder(16)
    private RString 集計関連付け番号;
    @TempTableColumnOrder(17)
    private boolean 対象外フラグ;
}
