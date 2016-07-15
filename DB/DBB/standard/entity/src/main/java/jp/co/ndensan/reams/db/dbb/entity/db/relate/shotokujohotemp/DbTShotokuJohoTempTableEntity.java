/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohotemp;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 所得情報TempのEntity
 *
 * @reamsid_L DBB-1690-070 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbTShotokuJohoTempTableEntity extends DbTableEntityBase<DbTShotokuJohoTempTableEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private LasdecCode 市町村コード;
    @TempTableColumnOrder(2)
    private RString 識別ＩＤ;
    @TempTableColumnOrder(3)
    private YMDHMS タイムスタンプ;
    @TempTableColumnOrder(4)
    private RString 最終レコード区分;
    @TempTableColumnOrder(5)
    private RString 連番;
    @TempTableColumnOrder(6)
    private RString ＦＩＬＬＥＲ;
    @TempTableColumnOrder(7)
    private FlexibleYear 賦課年度;
    @TempTableColumnOrder(8)
    private RString 住民ｺｰﾄﾞ;
    @TempTableColumnOrder(9)
    private RString 所得把握区分_申告区分;
    @TempTableColumnOrder(10)
    private RString 非課税区分;
    @TempTableColumnOrder(11)
    private RString 住民税所得割;
    @TempTableColumnOrder(12)
    private RString 住民税均等割;
    @TempTableColumnOrder(13)
    private Decimal 合計所得金額;
    @TempTableColumnOrder(14)
    private Decimal 給与収入額;
    @TempTableColumnOrder(15)
    private Decimal 公的年金等収入額;
    @TempTableColumnOrder(16)
    private Decimal 公的年金等所得額;
    @TempTableColumnOrder(17)
    private RString その他所得１;
    @TempTableColumnOrder(18)
    private RString その他所得２;
    @TempTableColumnOrder(19)
    private RString 予備;
    @TempTableColumnOrder(20)
    private RString 激変緩和区分;
    @TempTableColumnOrder(21)
    private RString データ種類;
    @TempTableColumnOrder(22)
    private Decimal 所得税;
    @TempTableColumnOrder(23)
    private YMDHMS 更新日時;
}
