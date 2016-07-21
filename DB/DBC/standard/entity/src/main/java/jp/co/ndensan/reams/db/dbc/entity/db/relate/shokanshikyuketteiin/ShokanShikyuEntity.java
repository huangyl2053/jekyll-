/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3043ShokanShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3045ShokanServicePlan200004Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3046ShokanServicePlan200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3047ShokanServicePlan200904Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3053ShokanShukeiEntity;

/**
 * 被保険者一時償還払支給判定結果一時Entity項目定義クラスです。
 *
 * @reamsid_L DBC-0980-331 chenaoqi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ShokanShikyuEntity {

    private DbT3036ShokanHanteiKekkaEntity 償還払支給判定結果Entity;
    private DbT3045ShokanServicePlan200004Entity サービス計画200004Entity;
    private DbT3046ShokanServicePlan200604Entity サービス計画200604Entity;
    private DbT3047ShokanServicePlan200904Entity サービス計画200904Entity;
    private DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity 介護サービス費用Entity;
    private DbT3043ShokanShokujiHiyoEntity 償還払請求食事費用Entity;
    private DbT3053ShokanShukeiEntity 償還払請求集計Entity;
    private List<HihokenshaShokanEntity> 被保険者判定List;

}
