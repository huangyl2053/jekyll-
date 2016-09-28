/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.hokenshadankaitemp;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 保険者設定段階Temp一時
 *
 * @reamsid_L DBB-1820-040 dingminghao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HokenshaDankaiTemp extends DbTableEntityBase<HokenshaDankaiTemp> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private HihokenshaNo 被保険者番号;
    @TempTableColumnOrder(2)
    private FlexibleDate 賦課基準日;
    @TempTableColumnOrder(3)
    private FlexibleDate 生保開始日;
    @TempTableColumnOrder(4)
    private FlexibleDate 生保終了日;
    @TempTableColumnOrder(5)
    private FlexibleDate 老年開始日;
    @TempTableColumnOrder(6)
    private FlexibleDate 老年終了日;
    @TempTableColumnOrder(7)
    private Decimal 年金収入額;
    @TempTableColumnOrder(8)
    private Decimal 合計所得金額;
    @TempTableColumnOrder(9)
    private RString 保険者設定段階1;
    @TempTableColumnOrder(10)
    private RString 保険者設定段階2;

}
