/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 受給者給付実績台帳のケアマネジメント費Entityクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
@OnNextSchema("rgdb")
public class CareManagementEntity extends DbTableEntityBase<CareManagementEntity> implements IDbAccessable {

    /**
     * TableNameを設定です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("tempCareManagement"));
    }
    @TempTableColumnOrder(1)
    private RString 入力識別番号;
    @TempTableColumnOrder(2)
    private RString 被保険者番号;
    @TempTableColumnOrder(3)
    private FlexibleYearMonth サービス提供年月;
    @TempTableColumnOrder(4)
    private RString 事業所番号;
    @TempTableColumnOrder(5)
    private RString 通し番号;
    @TempTableColumnOrder(6)
    private RString 明細行番号;
    @TempTableColumnOrder(7)
    private RString 指定基準該当等事業所区分コード;
    @TempTableColumnOrder(8)
    private Decimal 単位数単価;
    @TempTableColumnOrder(9)
    private FlexibleDate 居宅サービス計画作成依頼届出年月日;
    @TempTableColumnOrder(10)
    private RString サービスコード;
    @TempTableColumnOrder(11)
    private int 単位数;
    @TempTableColumnOrder(12)
    private int 回数;
    @TempTableColumnOrder(13)
    private int サービス単位数;
    @TempTableColumnOrder(14)
    private int サービス単位数合計;
    @TempTableColumnOrder(15)
    private int 請求金額;
    @TempTableColumnOrder(16)
    private int 利用者負担額;
    @TempTableColumnOrder(17)
    private RString 担当介護支援専門員番号;
    @TempTableColumnOrder(18)
    private RString 摘要;
    @TempTableColumnOrder(19)
    private int 後単位数;
    @TempTableColumnOrder(20)
    private int 後回数;
    @TempTableColumnOrder(21)
    private int 後サービス単位数;
    @TempTableColumnOrder(22)
    private int 後サービス単位数合計;
    @TempTableColumnOrder(23)
    private int 後請求金額;
    @TempTableColumnOrder(24)
    private int 後利用者負担額;
    @TempTableColumnOrder(25)
    private int 再審査回数;
    @TempTableColumnOrder(26)
    private int 過誤回数;
    @TempTableColumnOrder(27)
    private FlexibleYearMonth 審査年月;
    @TempTableColumnOrder(28)
    private RString 略称;
}
