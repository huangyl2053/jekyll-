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
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 受給者給付実績台帳の社会福祉法人軽減額Entityクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShakaiHukushiHouzinKeigenEntity extends DbTableEntityBase<ShakaiHukushiHouzinKeigenEntity> implements IDbAccessable {

    /**
     * TableNameを設定です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("tempShakaiHukushiHouzinKeigen"));
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
    private Decimal 軽減率;
    @TempTableColumnOrder(8)
    private Decimal 受領すべき利用者負担の総額;
    @TempTableColumnOrder(9)
    private Decimal 軽減額;
    @TempTableColumnOrder(10)
    private Decimal 軽減後利用者負担額;
    @TempTableColumnOrder(11)
    private RString 備考;
    @TempTableColumnOrder(12)
    private Decimal 後受領すべき利用者負担の総額;
    @TempTableColumnOrder(13)
    private Decimal 後軽減額;
    @TempTableColumnOrder(14)
    private Decimal 後軽減後利用者負担額;
    @TempTableColumnOrder(15)
    private Integer 再審査回数;
    @TempTableColumnOrder(16)
    private Integer 過誤回数;
    @TempTableColumnOrder(17)
    private FlexibleYearMonth 審査年月;
    @TempTableColumnOrder(18)
    private RString 略称;
}
