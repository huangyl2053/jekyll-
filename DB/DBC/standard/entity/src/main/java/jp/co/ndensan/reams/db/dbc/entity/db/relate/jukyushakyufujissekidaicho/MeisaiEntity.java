/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 受給者給付実績台帳の明細Entityクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
@OnNextSchema("rgdb")
public class MeisaiEntity extends DbTableEntityBase<MeisaiEntity> implements IDbAccessable {

    /**
     * TableNameを設定です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("tempMeisai"));
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
    private RString サービス種類コード;
    @TempTableColumnOrder(7)
    private RString サービス項目コード;
    @TempTableColumnOrder(8)
    private RString サービス内容;
    @TempTableColumnOrder(9)
    private Decimal 単位数;
    @TempTableColumnOrder(10)
    private Decimal 後単位数;
    @TempTableColumnOrder(11)
    private RString 単位数識別;
    @TempTableColumnOrder(12)
    private Integer 日数回数;
    @TempTableColumnOrder(13)
    private Integer 後日数回数;
    @TempTableColumnOrder(14)
    private Decimal サービス単位数;
    @TempTableColumnOrder(15)
    private Decimal 後サービス単位数;
    @TempTableColumnOrder(16)
    private Integer 公費１対象日数回数;
    @TempTableColumnOrder(17)
    private Integer 後公費１対象日数回数;
    @TempTableColumnOrder(18)
    private Decimal 公費１対象サービス点数;
    @TempTableColumnOrder(19)
    private Decimal 後公費１対象サービス点数;
    @TempTableColumnOrder(20)
    private Integer 公費２対象日数回数;
    @TempTableColumnOrder(21)
    private Integer 後公費２対象日数回数;
    @TempTableColumnOrder(22)
    private Decimal 公費２対象サービス点数;
    @TempTableColumnOrder(23)
    private Decimal 後公費２対象サービス点数;
    @TempTableColumnOrder(24)
    private Integer 公費３対象日数回数;
    @TempTableColumnOrder(25)
    private Integer 後公費３対象日数回数;
    @TempTableColumnOrder(26)
    private Decimal 公費３対象サービス点数;
    @TempTableColumnOrder(27)
    private Decimal 後公費３対象サービス点数;
    @TempTableColumnOrder(28)
    private RString 摘要;
    @TempTableColumnOrder(29)
    private Integer 再審査回数;
    @TempTableColumnOrder(30)
    private Integer 過誤回数;
    @TempTableColumnOrder(31)
    private FlexibleYearMonth 審査年月;
}
