/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.servicenokanribangourendou;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業高額介護サービス費支給情報用のEntityクラスです。
 *
 * @reamsid_L DBC-4760-050 cuilin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServiceNoKanribangouRendouEntity {

    private HihokenshaNo 被保険者番号;
    private FlexibleDate 決定年月日;
    private Decimal 本人支払額;
    private RString 審査方法区分;
    private FlexibleDate 受付年月日;
    private RString 支払方法区分コード;
    private RString 支払場所;
    private FlexibleDate 支払期間開始年月日;
    private FlexibleDate 支払期間終了年月日;
    private RString 支払窓口開始時間;
    private RString 支払窓口終了時間;
    private long 口座ID;
    private TsuchishoNo 通知書番号;
    private Decimal 支給金額;
    private RString 支給区分コード;
    private RString 不支給理由;
}
