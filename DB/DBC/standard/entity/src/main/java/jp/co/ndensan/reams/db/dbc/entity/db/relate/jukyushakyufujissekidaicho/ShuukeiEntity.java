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
 * 受給者給付実績台帳の集計Entityクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
@OnNextSchema("rgdb")
public class ShuukeiEntity extends DbTableEntityBase<ShuukeiEntity> implements IDbAccessable {

    /**
     * TableNameを設定です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("tempShuukei"));
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
    private RString サービス種類名称1;
    @TempTableColumnOrder(8)
    private RString サービス種類名称2;
    @TempTableColumnOrder(9)
    private Integer サービス実日数;
    @TempTableColumnOrder(10)
    private Decimal 計画単位数;
    @TempTableColumnOrder(11)
    private Decimal 限度額管理対象単位数;
    @TempTableColumnOrder(12)
    private Decimal 限度額管理対象外単位数;
    @TempTableColumnOrder(13)
    private Decimal 請求点数合計;
    @TempTableColumnOrder(14)
    private Decimal 後点数合計;
    @TempTableColumnOrder(15)
    private Decimal 後請求点数単価;
    @TempTableColumnOrder(16)
    private Decimal 請求額;
    @TempTableColumnOrder(17)
    private Decimal 後保険請求分請求額;
    @TempTableColumnOrder(18)
    private Decimal 利用者負担額;
    @TempTableColumnOrder(19)
    private Decimal 出来高点数合計;
    @TempTableColumnOrder(20)
    private Decimal 後出来高点数合計;
    @TempTableColumnOrder(21)
    private Decimal 出来高請求額;
    @TempTableColumnOrder(22)
    private Decimal 後出来高請求額;
    @TempTableColumnOrder(23)
    private Decimal 出来高医療費利用者負担額;
    @TempTableColumnOrder(24)
    private Decimal 公費１点数合計;
    @TempTableColumnOrder(25)
    private Decimal 後公費１点数合計;
    @TempTableColumnOrder(26)
    private Decimal 公費１請求額;
    @TempTableColumnOrder(27)
    private Decimal 後公費１請求額;
    @TempTableColumnOrder(28)
    private Decimal 公費１公費分本人負担額;
    @TempTableColumnOrder(29)
    private Decimal 公費１出来高点数合計;
    @TempTableColumnOrder(30)
    private Decimal 後公費１出来高点数合計;
    @TempTableColumnOrder(31)
    private Decimal 公費１出来高請求額;
    @TempTableColumnOrder(32)
    private Decimal 後公費１出来高請求額;
    @TempTableColumnOrder(33)
    private Decimal 公費２点数合計;
    @TempTableColumnOrder(34)
    private Decimal 後公費２点数合計;
    @TempTableColumnOrder(35)
    private Decimal 公費２請求額;
    @TempTableColumnOrder(36)
    private Decimal 後公費２請求額;
    @TempTableColumnOrder(37)
    private Decimal 公費２公費分本人負担額;
    @TempTableColumnOrder(38)
    private Decimal 公費２出来高点数合計;
    @TempTableColumnOrder(39)
    private Decimal 後公費２出来高点数合計;
    @TempTableColumnOrder(40)
    private Decimal 公費２出来高請求額;
    @TempTableColumnOrder(41)
    private Decimal 後公費２出来高請求額;
    @TempTableColumnOrder(42)
    private Decimal 公費３点数合計;
    @TempTableColumnOrder(43)
    private Decimal 後公費３点数合計;
    @TempTableColumnOrder(44)
    private Decimal 公費３請求額;
    @TempTableColumnOrder(45)
    private Decimal 後公費３請求額;
    @TempTableColumnOrder(46)
    private Decimal 公費３公費分本人負担額;
    @TempTableColumnOrder(47)
    private Decimal 公費３出来高点数合計;
    @TempTableColumnOrder(48)
    private Decimal 後公費３出来高点数合計;
    @TempTableColumnOrder(49)
    private Decimal 公費３出来高請求額;
    @TempTableColumnOrder(50)
    private Decimal 後公費３出来高請求額;
    @TempTableColumnOrder(51)
    private Integer 再審査回数;
    @TempTableColumnOrder(52)
    private Integer 過誤回数;
    @TempTableColumnOrder(53)
    private FlexibleYearMonth 審査年月;
    @TempTableColumnOrder(54)
    private Integer 短期入所計画日数;
}
