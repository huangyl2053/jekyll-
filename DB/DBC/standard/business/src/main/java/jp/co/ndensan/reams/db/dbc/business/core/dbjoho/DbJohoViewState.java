/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.dbjoho;

import java.io.Serializable;
import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisaiJushochiTokurei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200004;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200604;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200904;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShakaiFukushiHojinKeigengaku;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShoteiShikkanShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiNyushoshaKaigoServiceHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryoTokubetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryohi;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanMeisaiResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShukeiResult;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;

/**
 * ViewStateクラスです
 *
 * @reamsid_L DBC-1030-160 donghj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbJohoViewState implements Serializable {

    private ShokanShinsei 償還払支給申請;
    private ArrayList<ShokanKihon> 償還払請求基本データList;
    private ArrayList<ShokanMeisaiJushochiTokurei> 住所地特例データList;
    private ArrayList<ShokanMeisaiResult> 償還払請求明細データList;
    private ArrayList<ShokanTokuteiShinryohi> 償還払請求特定診療費データList;
    private ArrayList<ShokanTokuteiShinryoTokubetsuRyoyo> 特別療養費データList;
    private ArrayList<ShokanServicePlan200904> 償還払請求サービス計画200904データList;
    private ArrayList<ShokanServicePlan200604> 償還払請求サービス計画200604データList;
    private ArrayList<ShokanServicePlan200004> 償還払請求サービス計画200004データList;
    private ArrayList<ShokanTokuteiNyushoshaKaigoServiceHiyo> 償還払請求特定入所者介護サービス費用データList;
    private ArrayList<ShokanShakaiFukushiHojinKeigengaku> 償還払請求社会福祉法人軽減額データList;
    private ArrayList<ShokanShoteiShikkanShisetsuRyoyo> 償還払請求所定疾患施設療養費等データList;
    private ArrayList<ShokanKinkyuShisetsuRyoyo> 償還払請求緊急時施設療養データList;
    private ArrayList<ShokanShukeiResult> 償還払請求集計データList;
    private ArrayList<ShokanShokujiHiyo> 償還払請求食事費用データList;
    private ShokanHanteiKekka 償還払支給判定結果;

}
