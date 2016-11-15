/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.dbjoho;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisai;
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
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShukei;

/**
 * ViewStateクラスです
 *
 * @reamsid_L DBC-1030-160 donghj
 */
public class DbJohoViewState implements Serializable {

    private ShokanShinsei 償還払支給申請;
    private List<ShokanKihon> 償還払請求基本データList;
    private List<ShokanMeisaiJushochiTokurei> 住所地特例データList;
    private List<ShokanMeisai> 償還払請求明細データList;
    private List<ShokanTokuteiShinryohi> 償還払請求特定診療費データList;
    private List<ShokanTokuteiShinryoTokubetsuRyoyo> 特別療養費データList;
    private List<ShokanServicePlan200904> 償還払請求サービス計画200904データList;
    private List<ShokanServicePlan200604> 償還払請求サービス計画200604データList;
    private List<ShokanServicePlan200004> 償還払請求サービス計画200004データList;
    private List<ShokanTokuteiNyushoshaKaigoServiceHiyo> 償還払請求特定入所者介護サービス費用データList;
    private List<ShokanShakaiFukushiHojinKeigengaku> 償還払請求社会福祉法人軽減額データList;
    private List<ShokanShoteiShikkanShisetsuRyoyo> 償還払請求所定疾患施設療養費等データList;
    private List<ShokanKinkyuShisetsuRyoyo> 償還払請求緊急時施設療養データList;
    private List<ShokanShukei> 償還払請求集計データList;
    private List<ShokanShokujiHiyo> 償還払請求食事費用データList;
    private ShokanHanteiKekka 償還払支給判定結果;

    /**
     * 償還払支給申請を取得します。
     *
     * @return 償還払支給申請
     */
    public ShokanShinsei getShokanShinsei() {
        return 償還払支給申請;
    }

    /**
     * 償還払請求基本データListを取得します。
     *
     * @return List<ShokanKihon>
     */
    public List<ShokanKihon> getShokanKihon() {
        return 償還払請求基本データList;
    }

    /**
     * 住所地特例データListを取得します。
     *
     * @return List<ShokanMeisaiJushochiTokurei>
     */
    public List<ShokanMeisaiJushochiTokurei> getShokanMeisaiJushochiTokurei() {
        return 住所地特例データList;
    }

    /**
     * 償還払請求明細データListを取得します。
     *
     * @return 償還払請求明細データList
     */
    public List<ShokanMeisai> getShokanMeisai() {
        return 償還払請求明細データList;
    }

    /**
     * 償還払請求特定診療費データListを取得します。
     *
     * @return 償還払請求特定診療費データList
     */
    public List<ShokanTokuteiShinryohi> getShokanTokuteiShinryohi() {
        return 償還払請求特定診療費データList;
    }

    /**
     * 特別療養費データListを取得します。
     *
     * @return 特別療養費データList
     */
    public List<ShokanTokuteiShinryoTokubetsuRyoyo> getShokanTokuteiShinryoTokubetsuRyoyo() {
        return 特別療養費データList;
    }

    /**
     * 償還払請求サービス計画200904データListを取得します。
     *
     * @return 償還払請求サービス計画200904データList
     */
    public List<ShokanServicePlan200904> getShokanServicePlan200904() {
        return 償還払請求サービス計画200904データList;
    }

    /**
     * 償還払請求サービス計画200604データListを取得します。
     *
     * @return 償還払請求サービス計画200604データList
     */
    public List<ShokanServicePlan200604> getShokanServicePlan200604() {
        return 償還払請求サービス計画200604データList;
    }

    /**
     * 償還払請求サービス計画200004データListを取得します。
     *
     * @return 償還払請求サービス計画200004データList
     */
    public List<ShokanServicePlan200004> getShokanServicePlan200004() {
        return 償還払請求サービス計画200004データList;
    }

    /**
     * 償還払請求特定入所者介護サービス費用データListを取得します。
     *
     * @return 償還払請求特定入所者介護サービス費用データList
     */
    public List<ShokanTokuteiNyushoshaKaigoServiceHiyo> getShokanTokuteiNyushoshaKaigoServiceHiyo() {
        return 償還払請求特定入所者介護サービス費用データList;
    }

    /**
     * 償還払請求社会福祉法人軽減額データListを取得します。
     *
     * @return 償還払請求社会福祉法人軽減額データList
     */
    public List<ShokanShakaiFukushiHojinKeigengaku> getShokanShakaiFukushiHojinKeigengaku() {
        return 償還払請求社会福祉法人軽減額データList;
    }

    /**
     * 償還払請求所定疾患施設療養費等データListを取得します。
     *
     * @return 償還払請求所定疾患施設療養費等データList
     */
    public List<ShokanShoteiShikkanShisetsuRyoyo> getShokanShoteiShikkanShisetsuRyoyo() {
        return 償還払請求所定疾患施設療養費等データList;
    }

    /**
     * 償還払請求緊急時施設療養データListを取得します。
     *
     * @return 償還払請求緊急時施設療養データList
     */
    public List<ShokanKinkyuShisetsuRyoyo> getShokanKinkyuShisetsuRyoyo() {
        return 償還払請求緊急時施設療養データList;
    }

    /**
     * 償還払請求集計データListを取得します。
     *
     * @return 償還払請求集計データList
     */
    public List<ShokanShukei> getShokanShukei() {
        return 償還払請求集計データList;
    }

    /**
     * 償還払請求食事費用データListを取得します。
     *
     * @return 償還払請求食事費用データList
     */
    public List<ShokanShokujiHiyo> getShokanShokujiHiyo() {
        return 償還払請求食事費用データList;
    }

    /**
     * 償還払支給判定結果を取得します。
     *
     * @return 償還払支給判定結果
     */
    public ShokanHanteiKekka getShokanHanteiKekka() {
        return 償還払支給判定結果;
    }

}
