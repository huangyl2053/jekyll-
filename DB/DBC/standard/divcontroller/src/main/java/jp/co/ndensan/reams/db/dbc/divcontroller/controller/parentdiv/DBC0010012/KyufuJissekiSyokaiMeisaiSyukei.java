/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010012;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho2;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiPrmBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010012.KyufuJissekiSyokaiMeisaiSyukeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010012.KyufuJissekiSyokaiMeisaiSyukeiHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付実績照会_明細集計画面処理クラスです。
 *
 * @reamsid_L DBC-2970-040 wangxiaodong
 */
public class KyufuJissekiSyokaiMeisaiSyukei {

    /**
     * 画面の初期化メソッドです。
     *
     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
     * @return 給付実績照会_明細集計画面
     */
    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onLoad(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {

        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        NyuryokuShikibetsuNo 識別番号 = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, NyuryokuShikibetsuNo.class);
        KyufuJissekiSyokaiMeisaiSyukeiHandler handler = getHandler(div);
        HihokenshaNo 被保険者番号 = 給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号();
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        handler.onLoad(給付実績情報照会情報.getCsData_Z(), 給付実績情報照会情報.getCsData_B(), 給付実績情報照会情報.getCsData_N(),
                被保険者番号, 整理番号, サービス提供年月, 様式番号, 識別番号, 事業者番号);
        ShikibetsuNoKanri 識別番号管理 = KyufuJissekiShokaiFinder.createInstance().getShikibetsuBangoKanri(
                サービス提供年月, 識別番号).records().get(0);
        handler.setButton(識別番号管理, サービス提供年月);
        RString 実績区分コード = div.getCcdKyufuJissekiHeader().get実績区分コード();
        List<KyufuJissekiHedajyoho2> 事業者番号リスト = 給付実績情報照会情報.getCommonHeader().get給付実績ヘッダ情報2();
        handler.check事業者Btn(事業者番号リスト, 整理番号, 事業者番号, 様式番号, サービス提供年月.toDateString(), 実績区分コード);
        return ResponseData.of(div).respond();
    }

    /**
     * 「前月」ボタンをクリックします。
     *
     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
     * @return 給付実績照会_明細集計画面
     */
    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onClick_btnZengetsu(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        getHandler(div).change年月(new RString("前月"), 給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号(),
                給付実績情報照会情報.getCsData_Z(), 給付実績情報照会情報.getCsData_B(), 給付実績情報照会情報.getCsData_N(),
                給付実績情報照会情報.getCommonHeader().get給付実績ヘッダ情報2(),
                new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString()),
                ViewStateHolder.get(ViewStateKeys.整理番号, RString.class),
                ViewStateHolder.get(ViewStateKeys.識別番号検索キー, NyuryokuShikibetsuNo.class));
        return ResponseData.of(div).respond();
    }

    /**
     * 「次月」ボタンをクリックします。
     *
     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
     * @return 給付実績照会_明細集計画面
     */
    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onClick_btnJigetsu(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        getHandler(div).change年月(new RString("次月"), 給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号(),
                給付実績情報照会情報.getCsData_Z(), 給付実績情報照会情報.getCsData_B(), 給付実績情報照会情報.getCsData_N(),
                給付実績情報照会情報.getCommonHeader().get給付実績ヘッダ情報2(),
                new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString()),
                ViewStateHolder.get(ViewStateKeys.整理番号, RString.class),
                ViewStateHolder.get(ViewStateKeys.識別番号検索キー, NyuryokuShikibetsuNo.class));
        return ResponseData.of(div).respond();
    }

    /**
     * 「前事業者」ボタンをクリックします。
     *
     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
     * @return 給付実績照会_明細集計画面
     */
    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onClick_btnMaeJigyosha(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        getHandler(div).change事業者(new RString("前事業者"),
                給付実績情報照会情報.getCommonHeader().get給付実績ヘッダ情報2(),
                給付実績情報照会情報.getCsData_Z(), 給付実績情報照会情報.getCsData_B(), 給付実績情報照会情報.getCsData_N());
        return ResponseData.of(div).respond();
    }

    /**
     * 「次事業者」ボタンをクリックします。
     *
     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
     * @return 給付実績照会_明細集計画面
     */
    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onClick_btnAtoJigyosha(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        getHandler(div).change事業者(new RString("後事業者"),
                給付実績情報照会情報.getCommonHeader().get給付実績ヘッダ情報2(),
                給付実績情報照会情報.getCsData_Z(), 給付実績情報照会情報.getCsData_B(), 給付実績情報照会情報.getCsData_N());
        return ResponseData.of(div).respond();
    }

    private KyufuJissekiSyokaiMeisaiSyukeiHandler getHandler(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
        return new KyufuJissekiSyokaiMeisaiSyukeiHandler(div);
    }
}
