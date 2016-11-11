/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 受給者給付実績台帳の緊急時施設療養Entityクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
@OnNextSchema("rgdb")
public class KinkyuuziShisetuRyouyouEntity extends DbTableEntityBase<TokuteiServiceHiEntity> implements IDbAccessable {

    /**
     * TableNameを設定です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("tempKinkyuuziShisetuRyouyou"));
    }

    @TempTableColumnOrder(1)
    private RString 入力識別番号;
    @TempTableColumnOrder(2)
    private RString 被保険者番号;
    @TempTableColumnOrder(3)
    private FlexibleYearMonth サービス提供年月;
    @TempTableColumnOrder(4)
    private JigyoshaNo 事業所番号;
    @TempTableColumnOrder(5)
    private RString 通し番号;
    @TempTableColumnOrder(6)
    private RString 順次番号;
    @TempTableColumnOrder(7)
    private RString 緊急時傷病名１;
    @TempTableColumnOrder(8)
    private RString 緊急時傷病名２;
    @TempTableColumnOrder(9)
    private RString 緊急時傷病名３;
    @TempTableColumnOrder(10)
    private FlexibleDate 緊急時治療開始年月日１;
    @TempTableColumnOrder(11)
    private FlexibleDate 緊急時治療開始年月日２;
    @TempTableColumnOrder(12)
    private FlexibleDate 緊急時治療開始年月日３;
    @TempTableColumnOrder(13)
    private int 往診日数;
    @TempTableColumnOrder(14)
    private int 通院日数;
    @TempTableColumnOrder(15)
    private int 後往診日数;
    @TempTableColumnOrder(16)
    private int 後通院日数;
    @TempTableColumnOrder(17)
    private RString 往診医療機関名;
    @TempTableColumnOrder(18)
    private RString 通院医療機関名;
    @TempTableColumnOrder(19)
    private int 緊急時治療管理点数;
    @TempTableColumnOrder(20)
    private int 緊急時治療管理日数;
    @TempTableColumnOrder(21)
    private int 緊急時治療管理小計;
    @TempTableColumnOrder(22)
    private int リハビリテーション点数;
    @TempTableColumnOrder(23)
    private int 処置点数;
    @TempTableColumnOrder(24)
    private int 手術点数;
    @TempTableColumnOrder(25)
    private int 麻酔点数;
    @TempTableColumnOrder(26)
    private int 放射線治療点数;
    @TempTableColumnOrder(27)
    private int 後リハビリテーション点数;
    @TempTableColumnOrder(28)
    private int 後処置点数;
    @TempTableColumnOrder(29)
    private int 後手術点数;
    @TempTableColumnOrder(30)
    private int 後麻酔点数;
    @TempTableColumnOrder(31)
    private int 後放射線治療点数;
    @TempTableColumnOrder(32)
    private int 後緊急時治療管理点数;
    @TempTableColumnOrder(33)
    private int 後緊急時治療管理日数;
    @TempTableColumnOrder(34)
    private int 再審査回数;
    @TempTableColumnOrder(35)
    private int 過誤回数;
    @TempTableColumnOrder(36)
    private FlexibleYearMonth 審査年月;
    @TempTableColumnOrder(37)
    private RString 摘要１;
    @TempTableColumnOrder(38)
    private RString 摘要２;
    @TempTableColumnOrder(39)
    private RString 摘要３;
    @TempTableColumnOrder(40)
    private RString 摘要４;
    @TempTableColumnOrder(41)
    private RString 摘要５;
    @TempTableColumnOrder(42)
    private RString 摘要６;
    @TempTableColumnOrder(43)
    private RString 摘要７;
    @TempTableColumnOrder(44)
    private RString 摘要８;
    @TempTableColumnOrder(45)
    private RString 摘要９;
    @TempTableColumnOrder(46)
    private RString 摘要１０;
    @TempTableColumnOrder(47)
    private RString 摘要１１;
    @TempTableColumnOrder(48)
    private RString 摘要１２;
    @TempTableColumnOrder(49)
    private RString 摘要１３;
    @TempTableColumnOrder(50)
    private RString 摘要１４;
    @TempTableColumnOrder(51)
    private RString 摘要１５;
    @TempTableColumnOrder(52)
    private RString 摘要１６;
    @TempTableColumnOrder(53)
    private RString 摘要１７;
    @TempTableColumnOrder(54)
    private RString 摘要１８;
    @TempTableColumnOrder(55)
    private RString 摘要１９;
    @TempTableColumnOrder(56)
    private RString 摘要２０;
    @TempTableColumnOrder(57)
    private int 緊急時施設療養費合計点数;
    @TempTableColumnOrder(58)
    private RString 略称;

}
