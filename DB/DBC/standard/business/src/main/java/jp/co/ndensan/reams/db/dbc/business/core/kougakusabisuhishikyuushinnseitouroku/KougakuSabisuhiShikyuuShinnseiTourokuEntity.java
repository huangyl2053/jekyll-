/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kougakusabisuhishikyuushinnseitouroku;

import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuShikyuHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuShikyuShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuShikyuHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuShikyuShinsei;

/**
 * ビジネス設計_DBCMN42001_高額サービス費支給申請登録（画面）
 *
 * @reamsid_L DBC-2020-070 quxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KougakuSabisuhiShikyuuShinnseiTourokuEntity {

    private KogakuShikyuShinsei 高額介護サービス費支給申請Entity;
    private KogakuShikyuHanteiKekka 高額介護サービス費支給判定結果Entity;
    private JigyoKogakuShikyuShinsei 事業高額介護サービス費支給申請Entity;
    private JigyoKogakuShikyuHanteiKekka 事業高額介護サービス費支給判定結果Entity;
}
