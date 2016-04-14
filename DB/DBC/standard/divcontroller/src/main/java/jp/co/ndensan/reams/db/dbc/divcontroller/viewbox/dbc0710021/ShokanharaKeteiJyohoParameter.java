/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0710021;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 遷移画面と支給申請一覧Entityクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanharaKeteiJyohoParameter implements Serializable {

    private RString 識別コード;
    private RString 被保険者番号;
    private RString サービス提供年月;
    private RString 整理番号;
    private RString 証明書;
    private Decimal 給付率;
    private RString 画面モード;
}
