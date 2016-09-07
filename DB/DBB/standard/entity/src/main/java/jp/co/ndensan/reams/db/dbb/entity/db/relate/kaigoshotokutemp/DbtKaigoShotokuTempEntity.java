/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigoshotokutemp;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 介護所得TempのEntity
 *
 * @reamsid_L DBB-1690-070 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbtKaigoShotokuTempEntity extends DbTableEntityBase<DbtKaigoShotokuTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private LasdecCode 市町村コード;
    @TempTableColumnOrder(2)
    private RString 市町村識別ID;
    @TempTableColumnOrder(3)
    private FlexibleYear 所得年度;
    @TempTableColumnOrder(4)
    private RString 識別コード;
    @TempTableColumnOrder(5)
    private RString 履歴番号;
    @TempTableColumnOrder(6)
    private RString 課税区分_住民税減免前;
    @TempTableColumnOrder(7)
    private RString 課税区分_住民税減免後;
    @TempTableColumnOrder(8)
    private Decimal 合計所得金額;
    @TempTableColumnOrder(9)
    private Decimal 公的年金収入額;
    @TempTableColumnOrder(10)
    private Decimal 公的年金所得額;
    @TempTableColumnOrder(11)
    private Decimal 課税所得額;
    @TempTableColumnOrder(12)
    private RString 激変緩和措置区分;
    @TempTableColumnOrder(13)
    private RString 優先区分;
    @TempTableColumnOrder(14)
    private YMDHMS 処理日時;

}
