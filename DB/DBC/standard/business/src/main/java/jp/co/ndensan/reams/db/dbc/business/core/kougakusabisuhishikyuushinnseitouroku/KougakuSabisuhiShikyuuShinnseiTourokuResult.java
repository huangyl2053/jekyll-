/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kougakusabisuhishikyuushinnseitouroku;

import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuKyufuTaishoshaGokei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuKyufuTaishoshaMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuKyufuTaishoshaGokei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuKyufuTaishoshaMeisai;

/**
 * ビジネス設計_DBCMN42001_高額サービス費支給申請登録（画面）
 *
 * @reamsid_L DBC-2020-070 quxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KougakuSabisuhiShikyuuShinnseiTourokuResult {

    private KogakuKyufuTaishoshaMeisai 高額介護サービス費給付対象者明細Entity;
    private KogakuKyufuTaishoshaGokei 高額介護サービス費支給対象者合計Entity;
    private JigyoKogakuKyufuTaishoshaMeisai 事業高額介護サービス費給付対象者明細Entity;
    private JigyoKogakuKyufuTaishoshaGokei 事業高額介護サービス費支給対象者合計Entity;

}
