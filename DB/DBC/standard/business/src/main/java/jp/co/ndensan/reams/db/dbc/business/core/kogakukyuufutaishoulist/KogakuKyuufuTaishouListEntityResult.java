/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogakukyuufutaishoulist;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuKyufuTaishoshaGokei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuKyufuTaishoshaMeisai;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBCKD00006_高額給付対象一覧共有子Div（画面）
 *
 * @reamsid_L DBC-2020-060 quxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKyuufuTaishouListEntityResult implements Serializable {

    private KogakuKyufuTaishoshaMeisai 給付対象者明細entity;
    private KogakuKyufuTaishoshaGokei 給付対象者合計entity;
    private RString 明細合計区分;
    private RString 事業者名;
    private RString サービス種類;
}
