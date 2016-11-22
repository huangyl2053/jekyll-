/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 受給者給付実績台帳の特定診療費Entityクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
@OnNextSchema("rgdb")
public class TokuteiShinryouHiEntity extends DbTableEntityBase<TokuteiShinryouHiEntity> implements IDbAccessable {

    /**
     * TableNameを設定です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("tempTokuteiShinryouHi"));
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
    private RString 傷病名;
    @TempTableColumnOrder(8)
    private int 再審査回数;
    @TempTableColumnOrder(9)
    private int 過誤回数;
    @TempTableColumnOrder(10)
    private FlexibleYearMonth 審査年月;
    @TempTableColumnOrder(11)
    private RString 識別番号;
    @TempTableColumnOrder(12)
    private int 単位数;
    @TempTableColumnOrder(13)
    private int 後単位数;
    @TempTableColumnOrder(14)
    private RString 摘要;
    @TempTableColumnOrder(15)
    private int 回数;
    @TempTableColumnOrder(16)
    private int サービス点数;
    @TempTableColumnOrder(17)
    private int 合計点数;
    @TempTableColumnOrder(18)
    private int 後回数;
    @TempTableColumnOrder(19)
    private int 後サービス点数;
    @TempTableColumnOrder(20)
    private int 後合計点数;
    @TempTableColumnOrder(21)
    private int 公費１回数;
    @TempTableColumnOrder(22)
    private int 公費１サービス点数;
    @TempTableColumnOrder(23)
    private int 公費１合計点数;
    @TempTableColumnOrder(24)
    private int 後公費１回数;
    @TempTableColumnOrder(25)
    private int 後公費１サービス点数;
    @TempTableColumnOrder(26)
    private int 後公費１合計点数;
    @TempTableColumnOrder(27)
    private int 公費２回数;
    @TempTableColumnOrder(28)
    private int 公費２サービス点数;
    @TempTableColumnOrder(29)
    private int 公費２合計点数;
    @TempTableColumnOrder(30)
    private int 後公費２回数;
    @TempTableColumnOrder(31)
    private int 後公費２サービス点数;
    @TempTableColumnOrder(32)
    private int 後公費２合計点数;
    @TempTableColumnOrder(33)
    private int 公費３回数;
    @TempTableColumnOrder(34)
    private int 公費３サービス点数;
    @TempTableColumnOrder(35)
    private int 公費３合計点数;
    @TempTableColumnOrder(36)
    private int 後公費３回数;
    @TempTableColumnOrder(37)
    private int 後公費３サービス点数;
    @TempTableColumnOrder(38)
    private int 後公費３合計点数;
    @TempTableColumnOrder(39)
    private RString 略称;
    @TempTableColumnOrder(40)
    private RString サービス名称;

}
