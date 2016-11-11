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
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 受給者給付実績台帳の福祉用具Entityクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HukushiYouguEntity extends DbTableEntityBase<HukushiYouguEntity> implements IDbAccessable {

    /**
     * TableNameを設定です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("tempHukushiYougu"));
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
    private RString 明細番号;
    @TempTableColumnOrder(7)
    private RString サービスコード;
    @TempTableColumnOrder(8)
    private FlexibleDate 福祉用具購入年月日;
    @TempTableColumnOrder(9)
    private RString 摘要;
    @TempTableColumnOrder(10)
    private FlexibleYearMonth 審査年月;
    @TempTableColumnOrder(11)
    private RString 福祉用具商品名;
    @TempTableColumnOrder(12)
    private RString 福祉用具製造事業者名;
    @TempTableColumnOrder(13)
    private RString 福祉用具販売事業者名;
    @TempTableColumnOrder(14)
    private RString 福祉用具種目コード;
    @TempTableColumnOrder(15)
    private Decimal 購入金額;
    @TempTableColumnOrder(15)
    private RString 略称;
}
