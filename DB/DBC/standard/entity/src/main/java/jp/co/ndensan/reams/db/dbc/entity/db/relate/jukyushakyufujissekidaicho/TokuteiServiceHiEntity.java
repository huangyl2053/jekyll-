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
 * 受給者給付実績台帳の特定入所者介護サービス費用Entityクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
@OnNextSchema("rgdb")
public class TokuteiServiceHiEntity extends DbTableEntityBase<TokuteiServiceHiEntity> implements IDbAccessable {

    /**
     * TableNameを設定です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("tempTokuteiServiceHi"));
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
    private RString 順次番号;
    @TempTableColumnOrder(7)
    private RString サービス種別コード;
    @TempTableColumnOrder(8)
    private RString サービス項目コード;
    @TempTableColumnOrder(9)
    private RString サービス内容;
    @TempTableColumnOrder(10)
    private Decimal 費用単価;
    @TempTableColumnOrder(11)
    private Decimal 後費用単価;
    @TempTableColumnOrder(12)
    private Decimal 負担限度額;
    @TempTableColumnOrder(13)
    private Integer 日数;
    @TempTableColumnOrder(14)
    private Integer 後日数;
    @TempTableColumnOrder(15)
    private Integer 公費１日数;
    @TempTableColumnOrder(16)
    private Integer 後公費１日数;
    @TempTableColumnOrder(17)
    private Integer 公費２日数;
    @TempTableColumnOrder(18)
    private Integer 後公費２日数;
    @TempTableColumnOrder(19)
    private Integer 公費３日数;
    @TempTableColumnOrder(20)
    private Integer 後公費３日数;
    @TempTableColumnOrder(21)
    private Decimal 費用額;
    @TempTableColumnOrder(22)
    private Decimal 後費用額;
    @TempTableColumnOrder(23)
    private Decimal 保険分請求額;
    @TempTableColumnOrder(24)
    private Decimal 後保険分請求額;
    @TempTableColumnOrder(25)
    private Decimal 公費１負担額明細;
    @TempTableColumnOrder(26)
    private Decimal 後公費１負担額明細;
    @TempTableColumnOrder(27)
    private Decimal 公費２負担額明細;
    @TempTableColumnOrder(28)
    private Decimal 後公費２負担額明細;
    @TempTableColumnOrder(29)
    private Decimal 公費３負担額明細;
    @TempTableColumnOrder(30)
    private Decimal 後公費３負担額明細;
    @TempTableColumnOrder(31)
    private Decimal 利用者負担額;
    @TempTableColumnOrder(32)
    private Decimal 後利用者負担額;
    @TempTableColumnOrder(33)
    private Integer 再審査回数;
    @TempTableColumnOrder(34)
    private Integer 過誤回数;
    @TempTableColumnOrder(35)
    private FlexibleYearMonth 審査年月;
    @TempTableColumnOrder(36)
    private Decimal 費用額合計;
    @TempTableColumnOrder(37)
    private Decimal 後費用額合計;
    @TempTableColumnOrder(38)
    private Decimal 保険分請求額合計;
    @TempTableColumnOrder(39)
    private Decimal 後保険分請求額合計;
    @TempTableColumnOrder(40)
    private Decimal 利用者負担額合計;
    @TempTableColumnOrder(41)
    private Decimal 後利用者負担額合計;
    @TempTableColumnOrder(42)
    private Decimal 公費１負担額合計;
    @TempTableColumnOrder(43)
    private Decimal 後公費１負担額合計;
    @TempTableColumnOrder(44)
    private Decimal 公費１保険分請求額合計;
    @TempTableColumnOrder(45)
    private Decimal 後公費１保険分請求額合計;
    @TempTableColumnOrder(46)
    private Decimal 公費１本人負担月額;
    @TempTableColumnOrder(47)
    private Decimal 後公費１本人負担月額;
    @TempTableColumnOrder(48)
    private Decimal 公費２負担額合計;
    @TempTableColumnOrder(49)
    private Decimal 後公費２負担額合計;
    @TempTableColumnOrder(50)
    private Decimal 公費２保険分請求額合計;
    @TempTableColumnOrder(51)
    private Decimal 後公費２保険分請求額合計;
    @TempTableColumnOrder(52)
    private Decimal 公費２本人負担月額;
    @TempTableColumnOrder(53)
    private Decimal 後公費２本人負担月額;
    @TempTableColumnOrder(54)
    private Decimal 公費３負担額合計;
    @TempTableColumnOrder(55)
    private Decimal 後公費３負担額合計;
    @TempTableColumnOrder(56)
    private Decimal 公費３保険分請求額合計;
    @TempTableColumnOrder(57)
    private Decimal 後公費３保険分請求額合計;
    @TempTableColumnOrder(58)
    private Decimal 公費３本人負担月額;
    @TempTableColumnOrder(59)
    private Decimal 後公費３本人負担月額;

}
