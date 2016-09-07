/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kougakusabisuhishousainaiyou;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.DbT3058KogakuShikyuShinsaKettei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuKyufuTaishoshaGokei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuShikyuHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuShikyuShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuKyufuTaishoshaGokei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuShikyuHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuShikyuShinsaKettei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuShikyuShinsei;

/**
 * ビジネス設計_KogakuServicehiDetail_高額サービス費詳細内容入力共有子Div
 *
 * @reamsid_L DBC-4380-020 quxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KougakuSabisuhiShousaiNaiyouResult implements Serializable {

    private KogakuShikyuShinsei 高額介護サービス費支給申請Entity;
    private KogakuShikyuHanteiKekka 高額介護サービス費支給判定結果Entity;
    private KogakuKyufuTaishoshaGokei 高額介護サービス費支給対象者合計Entity;
    private DbT3058KogakuShikyuShinsaKettei 高額介護サービス費支給審査決定Entity;
    private JigyoKogakuShikyuShinsei 事業高額介護サービス費支給申請Entity;
    private JigyoKogakuShikyuHanteiKekka 事業高額介護サービス費支給判定結果Entity;
    private JigyoKogakuKyufuTaishoshaGokei 事業高額介護サービス費支給対象者合計Entity;
    private KogakuShikyuShinsaKettei 事業高額介護サービス費支給審査決定Entity;
}
