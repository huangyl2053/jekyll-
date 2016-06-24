/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyuufutaishoulist;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * ビジネス設計_DBCKD00006_高額給付対象一覧共有子Div（画面）
 *
 * @reamsid_L DBC-2020-060 quxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKyuufuTaishouListEntity {

    private RString 明細合計区分;
    private JigyoshaNo 事業者番号;
    private RString 事業者名;
    private ServiceCode サービス種類コード;
    private RString サービス種類;
    private Decimal サービス費用合計額;
    private Decimal 利用者負担額;
    private RString 高額給付根拠;
    private Decimal サービス費用合計額合計;
    private Decimal 利用者負担額合計;
    private Decimal 算定基準額;
    private Decimal 支払済金額合計;
    private Decimal 高額支給額;

}
