/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0600031;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KojinKakuteiKey;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiPrmBusiness;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbu.business.core.kyufujoho.KyufuJohoBusiness;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kyufujoho.KounyukingakuParamter;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kyufujoho.KyufuJohoParamter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600031.DBU0600031TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600031.KyufuJohoDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0600031.KyufuJohoHandler;
import jp.co.ndensan.reams.db.dbu.service.core.kyufujoho.KyufuJohoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 総合照会_給付情報のDivControllerです。
 *
 * @reamsid_L DBU-4100-040 wanghuafeng
 */
public class KyufuJoho {

    private static final int YEAR_3 = 3;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private final TaishoshaKey key;
    private final KyufuJohoFinder kyufujohofinder;

    /**
     * インスタンスです。
     */
    public KyufuJoho() {
        key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        this.kyufujohofinder = KyufuJohoFinder.createInstance();
    }

    /**
     * 画面の初期化です。
     *
     * @param div KyufuJohoDiv
     * @return ResponseData<KyufuJohoDiv>
     */
    public ResponseData<KyufuJohoDiv> onLoad(KyufuJohoDiv div) {

        getHandler(div).onLoad(key);
        getHandler(div).set居宅サービス計画情報(kyufujohofinder.get居宅サービス計画情報(KyufuJohoParamter.
                createParameter(key.get被保険者番号().value(), RString.EMPTY, new ArrayList())));
        set福祉用具販売費情報(div);
        set住宅改修費情報(div);
        set利用状況情報(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 再検索するボタンを押下します。
     *
     * @param div KyufuJohoDiv
     * @return ResponseData<KyufuJohoDiv>
     */
    public ResponseData<KyufuJohoDiv> onClick_KensakuModoru(KyufuJohoDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBU0600031TransitionEventName.対象者検索に戻る).respond();
    }

    /**
     * 受給者情報を表示するボタンを押下します。
     *
     * @param div KyufuJohoDiv
     * @return ResponseData<KyufuJohoDiv>
     */
    public ResponseData<KyufuJohoDiv> onClick_btnJukyuInfo(KyufuJohoDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 資格情報を表示するボタンを押下します。
     *
     * @param div KyufuJohoDiv
     * @return ResponseData<KyufuJohoDiv>
     */
    public ResponseData<KyufuJohoDiv> onClick_btnShikakuInfo(KyufuJohoDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 賦課情報を表示するボタンを押下します。
     *
     * @param div KyufuJohoDiv
     * @return ResponseData<KyufuJohoDiv>
     */
    public ResponseData<KyufuJohoDiv> onClick_btnFukaInfo(KyufuJohoDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 住民固有情報を表示するボタンを押下します。
     *
     * @param div KyufuJohoDiv
     * @return ResponseData<KyufuJohoDiv>
     */
    public ResponseData<KyufuJohoDiv> onClick_btnJuminInfo(KyufuJohoDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 居宅サービス計画情報を表示するボタンを押下します。
     *
     * @param div KaigoSikakuTokusouDiv
     * @return ResponseData<KaigoSikakuTokusouDiv>
     */
    public ResponseData<KyufuJohoDiv> onClick_btnKyotakuSabisu(KyufuJohoDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 償還払い情報を表示するボタンを押下します。
     *
     * @param div KyufuJohoDiv
     * @return ResponseData<KyufuJohoDiv>
     */
    public ResponseData<KyufuJohoDiv> onClick_btnShoukanHaraiJoho(KyufuJohoDiv div) {
        KounyukingakuParamter konnendo = getHandler(div).set今年度抽出範囲(key);
        KyufuJohoBusiness 償還払請求基本 = kyufujohofinder.getViewState償還払い状況照会(konnendo);
        ServiceTeiKyoShomeishoParameter parameter = new ServiceTeiKyoShomeishoParameter(new HihokenshaNo(償還払請求基本.get被保険者番号()),
                new FlexibleYearMonth(償還払請求基本.getサービス提供年月().toString()),
                償還払請求基本.get整理番号(),
                new JigyoshaNo(償還払請求基本.get事業所番号()),
                RString.EMPTY,
                償還払請求基本.get明細番号(),
                RString.EMPTY);
        ViewStateHolder.put(ViewStateKeys.基本情報パラメータ, parameter);
        ViewStateHolder.put(ViewStateKeys.様式番号, 償還払請求基本.get様式番号());
        return ResponseData.of(div).respond();
    }

    /**
     * 高額介護サービス情報を表示するボタンを押下します。
     *
     * @param div KaigoSikakuTokusouDiv
     * @return ResponseData<KaigoSikakuTokusouDiv>
     */
    public ResponseData<KyufuJohoDiv> onClick_btnKougakuSabisu(KyufuJohoDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 給付実績情報を表示するボタンを押下します。
     *
     * @param div KaigoSikakuTokusouDiv
     * @return ResponseData<KaigoSikakuTokusouDiv>
     */
    public ResponseData<KyufuJohoDiv> onClick_btnKyufuZisseki(KyufuJohoDiv div) {
        RDate date = RDate.getNowDate();
        List<KyufuJohoBusiness> 給付実績基本集計 = kyufujohofinder.getサービス利用状況情報(KyufuJohoParamter.createParameter(
                key.get被保険者番号().value(), new RString((date.getYearMonth().minusMonth(YEAR_3).toString())),
                setサービス分類コード(div))).records();
        ViewStateHolder.put(ViewStateKeys.サービス提供年月, 給付実績基本集計.get(0).getサービス提供年月());
        KyufuJissekiPrmBusiness kyufujissekiprmbusiness = new KyufuJissekiPrmBusiness();
        DbT3017KyufujissekiKihonEntity dbt3017kyufujissekikihonentity = new DbT3017KyufujissekiKihonEntity();
        if (給付実績基本集計.size() > 0) {
            dbt3017kyufujissekikihonentity.setSeiriNo(給付実績基本集計.get(0).get整理番号());
            dbt3017kyufujissekikihonentity.setInputShikibetsuNo(new NyuryokuShikibetsuNo(給付実績基本集計.get(0).get識別番号()));
        }
        KyufujissekiKihon kyufujissekikihon = new KyufujissekiKihon(dbt3017kyufujissekikihonentity);
        List<KyufujissekiKihon> 給付実績基本情報 = new ArrayList();
        給付実績基本情報.add(kyufujissekikihon);
//        kyufujissekiprmbusiness.setCsData_A(給付実績基本情報);
        KojinKakuteiKey kojinkakuteikey = new KojinKakuteiKey();
        kojinkakuteikey.set被保険者番号(new HihokenshaNo(給付実績基本集計.get(0).get被保険者番号().toString()));
        kyufujissekiprmbusiness.setKojinKakuteiKey(kojinkakuteikey);
        ViewStateHolder.put(ViewStateKeys.給付実績情報照会情報, kyufujissekiprmbusiness);
        return ResponseData.of(div).respond();
    }

    private KyufuJohoHandler getHandler(KyufuJohoDiv div) {
        return new KyufuJohoHandler(div);
    }

    private void set福祉用具販売費情報(KyufuJohoDiv div) {
        KounyukingakuParamter maenendo = getHandler(div).set前年度抽出範囲(key);
        KounyukingakuParamter konnendo = getHandler(div).set今年度抽出範囲(key);
        getHandler(div).set前年度情報(kyufujohofinder.get購入金額(maenendo), INDEX_1);
        getHandler(div).set前年度情報(kyufujohofinder.get請求負担額(maenendo), INDEX_2);
        getHandler(div).set今年度情報(kyufujohofinder.get購入金額(konnendo), INDEX_1);
        getHandler(div).set今年度情報(kyufujohofinder.get請求負担額(konnendo), INDEX_2);
    }

    private void set住宅改修費情報(KyufuJohoDiv div) {
        getHandler(div).set住宅改修費用合計(kyufujohofinder.get住宅改修費用合計(KounyukingakuParamter.createParameter(
                key.get被保険者番号().value(), RString.EMPTY, RString.EMPTY, ShikyuFushikyuKubun.支給.getコード())));
        getHandler(div).set住宅改修請求負担額(kyufujohofinder.get住宅改修請求負担額(KounyukingakuParamter.createParameter(
                key.get被保険者番号().value(), RString.EMPTY, RString.EMPTY, ShikyuFushikyuKubun.支給.getコード())));
    }

    private List<RString> setサービス分類コード(KyufuJohoDiv div) {
        return getHandler(div).get分類コード();
    }

    private void set利用状況情報(KyufuJohoDiv div) {
        RDate date = RDate.getNowDate();
        getHandler(div).set利用状況情報(kyufujohofinder.getサービス利用状況情報(KyufuJohoParamter.createParameter(
                key.get被保険者番号().value(), new RString((date.getYearMonth().minusMonth(YEAR_3).toString())),
                setサービス分類コード(div))).records());
    }
}
