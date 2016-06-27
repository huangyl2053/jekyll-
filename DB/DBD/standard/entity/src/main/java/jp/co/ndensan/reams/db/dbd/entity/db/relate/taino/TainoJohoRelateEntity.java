/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.taino;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 滞納情報Entityのクラスです。
 *
 * @reamsid_L DBD-3620-060 liangbc
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TainoJohoRelateEntity {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private TsuchishoNo 通知書番号;
    private RString 期;
    private RString 徴収方法;
    private RDate 納期限;
    private Decimal 調定額;
    private List<ShunyuSummaryEntity> 収入リスト;
    private RDate 督促状発行年月日;
    private FlexibleDate 時効起算年月日;
    private RString 時効起算日区分;

}
