/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogakukyuufutaishoulist;

import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuKyufuTaishoshaGokei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuKyufuTaishoshaMeisai;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBCKD00006_高額給付対象一覧共有子Div（画面）
 *
 * @reamsid_L DBC-2020-060 quxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyouKogakuKyuufuTaishouResult {

    private JigyoKogakuKyufuTaishoshaMeisai 給付対象者明細entity;
    private JigyoKogakuKyufuTaishoshaGokei 給付対象者合計entity;
    private RString 明細合計区分;
    private RString 事業者名;
    private RString サービス種類;

}
