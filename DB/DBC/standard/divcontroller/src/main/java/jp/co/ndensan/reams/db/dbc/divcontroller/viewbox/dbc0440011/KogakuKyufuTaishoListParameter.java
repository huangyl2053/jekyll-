/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0440011;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 画面設計_DBCMN42001_高額サービス費支給申請登録
 *
 * @reamsid_L DBC-2020-040 quxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKyufuTaishoListParameter implements Serializable {

    private RString 明細合計区分;
    private RString 事業者コード;
    private RString 事業者名称;
    private RString サービス種類;
    private RString サービス種類名称;
    private Decimal サービス費用合計;
    private Decimal 利用者負担合計;
    private Decimal 算定基準額;
    private Decimal 支払済額;
    private RString 月遅れ区分;
    private RString 世帯所得区分;
    private RString 本人所得区分;
    private RString 合算区分;
    private RString 老齢福祉年金;
    private RString 利用者負担第２段階;
    private RString 激変緩和区分;
}
