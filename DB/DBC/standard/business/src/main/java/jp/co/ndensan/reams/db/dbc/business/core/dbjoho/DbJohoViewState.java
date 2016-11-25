/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.dbjoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShoteiShikkanShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiNyushoshaKaigoServiceHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryoTokubetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryohi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoHenkoFlag;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoNyuryokuFlag;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanMeisaiJushochiTokureiResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanMeisaiResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200004Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200604Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200904Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShakaiFukushiHojinKeigengakuResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShukeiResult;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShomeishoGridList;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKanryoKubunType;
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
    private ArrayList<ShokanMeisaiJushochiTokureiResult> 住所地特例データList;
    private ArrayList<ShokanMeisaiResult> 償還払請求明細データList;
    private ArrayList<ShokanTokuteiShinryohi> 償還払請求特定診療費データList;
    private ArrayList<ShokanTokuteiShinryoTokubetsuRyoyo> 特別療養費データList;
    private ArrayList<ShokanServicePlan200904Result> 償還払請求サービス計画200904データResultList;
    private ArrayList<ShokanServicePlan200604Result> 償還払請求サービス計画200604データResultList;
    private ArrayList<ShokanServicePlan200004Result> 償還払請求サービス計画200004データResultList;
    private ArrayList<ShokanTokuteiNyushoshaKaigoServiceHiyo> 償還払請求特定入所者介護サービス費用データList;
    private ArrayList<ShokanShakaiFukushiHojinKeigengakuResult> 償還払請求社会福祉法人軽減額データList;
    private ArrayList<ShokanShoteiShikkanShisetsuRyoyo> 償還払請求所定疾患施設療養費等データList;
    private ArrayList<ShokanKinkyuShisetsuRyoyo> 償還払請求緊急時施設療養データList;
    private ArrayList<ShokanShukeiResult> 償還払請求集計データList;
    private ArrayList<ShokanShokujiHiyo> 償還払請求食事費用データList;
    private ShokanHanteiKekka 償還払支給判定結果;
    private Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuFlag> 証明書入力済フラグMap;
    private Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoHenkoFlag> 証明書変更済フラグMap;
    private Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuKanryoKubunType> 証明書入力完了フラグMap;
    private ArrayList<ShomeishoGridList> 証明書グリッドリスト;

    /**
     * サービス計画200904データを取得する。
     *
     * @param 明細キー ShoukanharaihishinseimeisaikensakuParameter
     * @return サービス計画200904データ
     */
    public List<ShokanServicePlan200904Result> get償還払請求サービス計画200904データResultList(
            ShoukanharaihishinseimeisaikensakuParameter 明細キー) {
        List<ShokanServicePlan200904Result> entity200904ResultList = new ArrayList<>();
        if (null == 償還払請求サービス計画200904データResultList) {
            return entity200904ResultList;
        }
        for (ShokanServicePlan200904Result entity200904Result : 償還払請求サービス計画200904データResultList) {
            if (明細キー.get被保険者番号().equals(entity200904Result.getEntity().get被保険者番号())
                    && 明細キー.getサービス年月().equals(entity200904Result.getEntity().getサービス提供年月())
                    && 明細キー.get整理番号().equals(entity200904Result.getEntity().get整理番号())
                    && 明細キー.get事業者番号().equals(entity200904Result.getEntity().get事業者番号())
                    && 明細キー.get様式番号().equals(entity200904Result.getEntity().get様式番号())
                    && 明細キー.get明細番号().equals(entity200904Result.getEntity().get明細番号())) {
                entity200904ResultList.add(entity200904Result);
            }
        }
        return entity200904ResultList;
    }

    /**
     * サービス計画200904データを追加する。
     *
     * @param entity200904ResultList 200904データResultList
     */
    public void add償還払請求サービス計画200904データResult(List<ShokanServicePlan200904Result> entity200904ResultList) {
        if (null == 償還払請求サービス計画200904データResultList) {
            償還払請求サービス計画200904データResultList = new ArrayList<>();
        }
        償還払請求サービス計画200904データResultList.addAll(entity200904ResultList);
    }

    /**
     * サービス計画200604データを取得する。
     *
     * @param 明細キー ShoukanharaihishinseimeisaikensakuParameter
     * @return サービス計画200604データ
     */
    public ShokanServicePlan200604Result get償還払請求サービス計画200604データResult(
            ShoukanharaihishinseimeisaikensakuParameter 明細キー) {
        if (null == 償還払請求サービス計画200604データResultList) {
            return null;
        }
        for (ShokanServicePlan200604Result entity200604Result : 償還払請求サービス計画200604データResultList) {
            if (明細キー.get被保険者番号().equals(entity200604Result.getEntity().get被保険者番号())
                    && 明細キー.getサービス年月().equals(entity200604Result.getEntity().getサービス提供年月())
                    && 明細キー.get整理番号().equals(entity200604Result.getEntity().get整理番号())
                    && 明細キー.get事業者番号().equals(entity200604Result.getEntity().get事業者番号())
                    && 明細キー.get様式番号().equals(entity200604Result.getEntity().get様式番号())
                    && 明細キー.get明細番号().equals(entity200604Result.getEntity().get明細番号())) {
                return entity200604Result;
            }
        }
        return null;
    }

    /**
     * サービス計画200604データを追加する。
     *
     * @param entity200604Result 200604データResult
     */
    public void add償還払請求サービス計画200604データResult(ShokanServicePlan200604Result entity200604Result) {
        if (null == 償還払請求サービス計画200604データResultList) {
            償還払請求サービス計画200604データResultList = new ArrayList<>();
        }
        償還払請求サービス計画200604データResultList.add(entity200604Result);
    }

    /**
     * サービス計画200004データを取得する。
     *
     * @param 明細キー ShoukanharaihishinseimeisaikensakuParameter
     * @return サービス計画200004データ
     */
    public ShokanServicePlan200004Result get償還払請求サービス計画200004データResult(
            ShoukanharaihishinseimeisaikensakuParameter 明細キー) {
        if (null == 償還払請求サービス計画200004データResultList) {
            return null;
        }
        for (ShokanServicePlan200004Result entity200004Result : 償還払請求サービス計画200004データResultList) {
            if (明細キー.get被保険者番号().equals(entity200004Result.getEntity().get被保険者番号())
                    && 明細キー.getサービス年月().equals(entity200004Result.getEntity().getサービス提供年月())
                    && 明細キー.get整理番号().equals(entity200004Result.getEntity().get整理番号())
                    && 明細キー.get事業者番号().equals(entity200004Result.getEntity().get事業者番号())
                    && 明細キー.get様式番号().equals(entity200004Result.getEntity().get様式番号())
                    && 明細キー.get明細番号().equals(entity200004Result.getEntity().get明細番号())) {
                return entity200004Result;
            }
        }
        return null;
    }

    /**
     * サービス計画200004データを追加する。
     *
     * @param entity200004Result 200004データResult
     */
    public void add償還払請求サービス計画200004データResult(ShokanServicePlan200004Result entity200004Result) {
        if (null == 償還払請求サービス計画200004データResultList) {
            償還払請求サービス計画200004データResultList = new ArrayList<>();
        }
        償還払請求サービス計画200004データResultList.add(entity200004Result);
    }

}
