/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100010;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成のRelateEntityクラスです。
 *
 * @reamsid_L DBC-2860-030 suguangjun
 */
@SuppressWarnings("PMd.UnusedPrivateField")
@lombok.Setter
@lombok.Getter
@OnNextSchema("rgdb")
public class TempSeikyuShukeiItiziDataEntity {

    private ShoKisaiHokenshaNo 証記載保険者番号;
    private JigyoshaNo 介護住宅改修理由書作成事業者番号;
    private RString 集計関連付け番号;
    private int 履歴番号;
    private RDate 集計開始年月;
    private RDate 集計終了年月;
    private int 介護住宅改修理由書作成件数;
    private Decimal 介護住宅改修理由書作成単価;
    private Decimal 介護住宅改修理由書作成請求金額;
}
