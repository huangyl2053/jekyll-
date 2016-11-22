/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 受給者給付実績台帳の所定疾患施設療養費Entityクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
@OnNextSchema("rgdb")
public class ShoteiShikkanEntity extends DbTableEntityBase<ShoteiShikkanEntity> implements IDbAccessable {

    /**
     * TableNameを設定です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("tempShoteiShikkan"));
    }
    @TempTableColumnOrder(1)
    private RString 入力識別番号;
    @TempTableColumnOrder(2)
    private RString 被保険者番号;
    @TempTableColumnOrder(3)
    private RString サービス提供年月;
    @TempTableColumnOrder(4)
    private RString 事業所番号;
    @TempTableColumnOrder(5)
    private RString 通し番号;
    @TempTableColumnOrder(6)
    private RString 緊急時施設療養情報レコード順次番号;
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
    private RString 往診医療機関名;
    @TempTableColumnOrder(15)
    private int 通院日数;
    @TempTableColumnOrder(16)
    private RString 通院医療機関名;
    @TempTableColumnOrder(17)
    private int 緊急時治療管理単位数;
    @TempTableColumnOrder(18)
    private int 緊急時治療管理日数;
    @TempTableColumnOrder(19)
    private int 緊急時治療管理小計;
    @TempTableColumnOrder(20)
    private int リハビリテーション点数;
    @TempTableColumnOrder(21)
    private int 処置点数;
    @TempTableColumnOrder(22)
    private int 手術点数;
    @TempTableColumnOrder(23)
    private int 麻酔点数;
    @TempTableColumnOrder(24)
    private int 放射線治療点数;
    @TempTableColumnOrder(25)
    private RString 摘要１;
    @TempTableColumnOrder(26)
    private RString 摘要２;
    @TempTableColumnOrder(27)
    private RString 摘要３;
    @TempTableColumnOrder(28)
    private RString 摘要４;
    @TempTableColumnOrder(29)
    private RString 摘要５;
    @TempTableColumnOrder(30)
    private RString 摘要６;
    @TempTableColumnOrder(31)
    private RString 摘要７;
    @TempTableColumnOrder(32)
    private RString 摘要８;
    @TempTableColumnOrder(33)
    private RString 摘要９;
    @TempTableColumnOrder(34)
    private RString 摘要１０;
    @TempTableColumnOrder(35)
    private RString 摘要１１;
    @TempTableColumnOrder(36)
    private RString 摘要１２;
    @TempTableColumnOrder(37)
    private RString 摘要１３;
    @TempTableColumnOrder(38)
    private RString 摘要１４;
    @TempTableColumnOrder(39)
    private RString 摘要１５;
    @TempTableColumnOrder(40)
    private RString 摘要１６;
    @TempTableColumnOrder(41)
    private RString 摘要１７;
    @TempTableColumnOrder(42)
    private RString 摘要１８;
    @TempTableColumnOrder(43)
    private RString 摘要１９;
    @TempTableColumnOrder(44)
    private RString 摘要２０;
    @TempTableColumnOrder(45)
    private int 緊急時施設療養費合計点数;
    @TempTableColumnOrder(46)
    private RString 所定疾患施設療養費傷病名１;
    @TempTableColumnOrder(47)
    private RString 所定疾患施設療養費傷病名２;
    @TempTableColumnOrder(48)
    private RString 所定疾患施設療養費傷病名３;
    @TempTableColumnOrder(49)
    private FlexibleDate 所定疾患施設療養費開始年月日１;
    @TempTableColumnOrder(50)
    private FlexibleDate 所定疾患施設療養費開始年月日２;
    @TempTableColumnOrder(51)
    private FlexibleDate 所定疾患施設療養費開始年月日３;
    @TempTableColumnOrder(52)
    private int 所定疾患施設療養費単位数;
    @TempTableColumnOrder(53)
    private int 所定疾患施設療養費日数;
    @TempTableColumnOrder(54)
    private int 所定疾患施設療養費小計;
    @TempTableColumnOrder(55)
    private int 後往診日数;
    @TempTableColumnOrder(56)
    private int 後通院日数;
    @TempTableColumnOrder(57)
    private int 後緊急時治療管理単位数;
    @TempTableColumnOrder(58)
    private int 後緊急時治療管理日数;
    @TempTableColumnOrder(59)
    private int 後リハビリテーション点数;
    @TempTableColumnOrder(60)
    private int 後処置点数;
    @TempTableColumnOrder(61)
    private int 後手術点数;
    @TempTableColumnOrder(62)
    private int 後麻酔点数;
    @TempTableColumnOrder(63)
    private int 後放射線治療点数;
    @TempTableColumnOrder(64)
    private int 後所定疾患施設療養費単位数;
    @TempTableColumnOrder(65)
    private int 後所定疾患施設療養費日数;
    @TempTableColumnOrder(66)
    private int 再審査回数;
    @TempTableColumnOrder(67)
    private int 過誤回数;
    @TempTableColumnOrder(68)
    private FlexibleYearMonth 審査年月;
    @TempTableColumnOrder(69)
    private RString 名称;

}
