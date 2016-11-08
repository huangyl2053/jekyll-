/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 明細・合計一覧Grid整理処理結果のオブジェクトクラスです。
 *
 * @reamsid_L DBC-1930-060 cuilin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJikoSakuseiResult implements Serializable {

    private RString 事業者;
    private RString サービス;
    private RString 単位;
    private RString 割引適用後率;
    private RString 割引適用後単位;
    private RString 回数;
    private Decimal サービス単位;
    private Decimal 種類限度超過単位;
    private Decimal 種類限度内単位;
    private RString 単位数単価;
    private Decimal 区分限度超過単位;
    private Decimal 区分限度内単位;
    private RString 給付率;
    private Decimal 給付計画単位数;
    private Decimal 費用総額;
    private Decimal 保険給付額;
    private Decimal 保険対象利用者負担額;
    private Decimal 全額利用者負担額;
    private JigyoshaNo 事業者コード;
    private ServiceShuruiCode サービス種類コード;
    private ServiceKomokuCode サービス項目コード;
    private RString ステータス;
    private boolean 合計フラグ;
    private RString 限度額対象外フラグ;
    private Decimal 定額利用者負担単価金額;
    private RString 利用者負担定率定額区分;
    private int 明細番号;
}
