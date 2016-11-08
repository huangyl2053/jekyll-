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
 * 受給者給付実績台帳の住宅改修Entityクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
@OnNextSchema("rgdb")
public class JuutakuKaishuuEntity extends DbTableEntityBase<JuutakuKaishuuEntity> implements IDbAccessable {

    /**
     * TableNameを設定です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("tempJuutakuKaishuu"));
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
    private FlexibleDate 住宅改修着工年月日;
    @TempTableColumnOrder(9)
    private Decimal 改修金額;
    @TempTableColumnOrder(10)
    private FlexibleYearMonth 審査年月;
    @TempTableColumnOrder(11)
    private RString 住宅改修事業者名;
    @TempTableColumnOrder(12)
    private RString 住宅改修住宅住所;
}
