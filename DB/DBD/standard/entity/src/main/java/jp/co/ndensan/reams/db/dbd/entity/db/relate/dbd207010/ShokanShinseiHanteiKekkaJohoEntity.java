/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成_バッチプロセス4SQL検索結果用償還について情報クラスです．
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanShinseiHanteiKekkaJohoEntity {

    private HihokenshaNo 償還払支給申請_被保険者番号;
    private FlexibleYearMonth 償還払支給申請_サービス提供年月;
    private Decimal 償還払支給判定結果_支払金額;
    private Decimal 償還払支給判定結果_差額金額合計;

}
