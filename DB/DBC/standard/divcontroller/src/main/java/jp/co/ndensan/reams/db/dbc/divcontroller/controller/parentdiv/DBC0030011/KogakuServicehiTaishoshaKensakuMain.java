/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0030011;

import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakukaigoservice.TaishoshaKensakuHoho;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011.DBC0030011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011.DBC0030011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011.KogakuServicehiTaishoshaKensakuMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0030011.KogakuServicehiTaishoshaKensakuMainHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0030011.KogakuServicehiTaishoshaKensakuMainValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0030011.KogakuServiceData;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 高額介護サービス費照会（対象者検索）画面
 *
 * @reamsid_L DBC-3000-010 gongliang
 */
public class KogakuServicehiTaishoshaKensakuMain {

    private static final RString 指定R = new RString("指定");
    private static final RString 被保険者名R = new RString("被保険者名");
    private static final RString 被保険者番号R = new RString("被保険者番号");
    private static final RString 提供年月FROMR = new RString("提供年月From");
    private static final RString 提供年月TOR = new RString("提供年月To");
    private static final RString 申請年月FROMR = new RString("申請年月From");
    private static final RString 申請年月TOR = new RString("申請年月To");
    private static final RString 決定年月FROMR = new RString("決定年月From");
    private static final RString 決定年月TOR = new RString("決定年月To");
    private static final RString 提供年月R = new RString("提供年月");
    private static final RString 申請年月R = new RString("申請年月");
    private static final RString 決定年月R = new RString("決定年月");

    /**
     * 画面の初期化メソッドです。
     *
     * @param div KogakuServicehiTaishoshaKensakuMainDiv
     * @return 高額介護サービス費照会（対象者検索）画面
     */
    public ResponseData<KogakuServicehiTaishoshaKensakuMainDiv> onLoad(KogakuServicehiTaishoshaKensakuMainDiv div) {
        KogakuServicehiTaishoshaKensakuMainHandler handler = getHandler(div);
        handler.load検索条件エリア();
        handler.click条件をクリアする();
        return ResponseData.of(div).setState(DBC0030011StateName.検索条件);
    }

    /**
     * 「該当者検索」ボタンを押下した際に実行します。
     *
     * @param div KogakuServicehiTaishoshaKensakuMainDiv
     * @return 該当者検索画面
     */
    public ResponseData<KogakuServicehiTaishoshaKensakuMainDiv> onBeforeOpenDialog_btnSearchHihokensha(KogakuServicehiTaishoshaKensakuMainDiv div) {
        putViewState(div);
        return createResponse(div);
    }

    /**
     * 該当者検索画面から対象を選択して戻ってきた場合、onOkClose事件です。
     *
     * @param div KogakuServicehiTaishoshaKensakuMainDiv
     * @return 高額介護サービス費照会（対象者検索）画面
     */
    public ResponseData<KogakuServicehiTaishoshaKensakuMainDiv> onOkClose_btnSearchHihokensha(KogakuServicehiTaishoshaKensakuMainDiv div) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        getHandler(div).load該当者検索(資格対象者);
        return createResponse(div);
    }

    /**
     * 検索条件エリアの検索条件のonChange事件です。
     *
     * @param div KogakuServicehiTaishoshaKensakuMainDiv
     * @return 該当者検索画面
     */
    public ResponseData<KogakuServicehiTaishoshaKensakuMainDiv> onChange_radSearchKubun(KogakuServicehiTaishoshaKensakuMainDiv div) {
        getHandler(div).onChange検索条件エリア();
        return createResponse(div);
    }

    /**
     * 「条件をクリアする」ボタンを押下した際に実行します。
     *
     * @param div KogakuServicehiTaishoshaKensakuMainDiv
     * @return 高額介護サービス費照会（対象者検索）画面
     */
    public ResponseData<KogakuServicehiTaishoshaKensakuMainDiv> onClick_btnClear(KogakuServicehiTaishoshaKensakuMainDiv div) {
        getHandler(div).click条件をクリアする();
        return createResponse(div);
    }

    /**
     * 「該当者を検索する」ボタンを押下した際に実行します。
     *
     * @param div KogakuServicehiTaishoshaKensakuMainDiv
     * @return 高額介護サービス費照会（対象者検索）画面
     */
    public ResponseData<KogakuServicehiTaishoshaKensakuMainDiv> onClick_btnSearch(KogakuServicehiTaishoshaKensakuMainDiv div) {
        KogakuServicehiTaishoshaKensakuMainValidationHandler validationHandler = new KogakuServicehiTaishoshaKensakuMainValidationHandler(div);
        Map<RString, RString> mapStr = getHandler(div).get検索条件エリアRStr();
        ValidationMessageControlPairs pairs;
        if (TaishoshaKensakuHoho.被保険者指定.getコード().equals(mapStr.get(指定R))) {
            pairs = validationHandler.validate被保険者を指定入力();
        } else {
            pairs = validationHandler.validate年月を指定入力();
        }
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        RString メニューID = ResponseHolder.getMenuID();
        putViewState(div);
        KogakuServiceData 該当者一覧キー = getHandler(div).load該当者一覧情報(メニューID);
        if (該当者一覧キー != null) {
            ViewStateHolder.put(ViewStateKeys.該当者一覧キー, 該当者一覧キー);
            return ResponseData.of(div).forwardWithEventName(DBC0030011TransitionEventName.選択).respond();
        }
        return ResponseData.of(div).setState(DBC0030011StateName.該当者一覧);
    }

    /**
     * 「再検索する」ボタンを押下した際に実行します。
     *
     * @param div KogakuServicehiTaishoshaKensakuMainDiv
     * @return 高額介護サービス費照会（対象者検索）画面
     */
    public ResponseData<KogakuServicehiTaishoshaKensakuMainDiv> onClick_btnResearch(KogakuServicehiTaishoshaKensakuMainDiv div) {
        return ResponseData.of(div).setState(DBC0030011StateName.検索条件);
    }

    /**
     * データグリッドの「選択」ボタンを押下した際に実行します。
     *
     * @param div KogakuServicehiTaishoshaKensakuMainDiv
     * @return 高額介護サービス費照会画面
     */
    public ResponseData<KogakuServicehiTaishoshaKensakuMainDiv> onClick_ShowDetail(KogakuServicehiTaishoshaKensakuMainDiv div) {
        KogakuServiceData 該当者一覧キー = getHandler(div).onClick_選択();
        ViewStateHolder.put(ViewStateKeys.該当者一覧キー, 該当者一覧キー);
        putViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0030011TransitionEventName.選択).respond();
    }

    private void putViewState(KogakuServicehiTaishoshaKensakuMainDiv div) {
        Map<RString, RString> mapStr = getHandler(div).get検索条件エリアRStr();
        Map<RString, RDate> mapRDate = getHandler(div).get検索条件エリアRDate();
        if (TaishoshaKensakuHoho.被保険者指定.getコード().equals(mapStr.get(指定R))) {
            ViewStateHolder.put(ViewStateKeys.ラジオ_指定, TaishoshaKensakuHoho.被保険者指定.getコード());
        } else {
            ViewStateHolder.put(ViewStateKeys.ラジオ_指定, TaishoshaKensakuHoho.年月指定.getコード());
        }
        ViewStateHolder.put(ViewStateKeys.被保険者番号, mapStr.get(被保険者番号R));
        ViewStateHolder.put(ViewStateKeys.被保険者名, mapStr.get(被保険者名R));
        ViewStateHolder.put(ViewStateKeys.サービス提供年月From, mapRDate.get(提供年月FROMR));
        ViewStateHolder.put(ViewStateKeys.サービス提供年月To, mapRDate.get(提供年月TOR));
        ViewStateHolder.put(ViewStateKeys.申請年月From, mapRDate.get(申請年月FROMR));
        ViewStateHolder.put(ViewStateKeys.申請年月To, mapRDate.get(申請年月TOR));
        ViewStateHolder.put(ViewStateKeys.決定年月From, mapRDate.get(決定年月FROMR));
        ViewStateHolder.put(ViewStateKeys.決定年月To, mapRDate.get(決定年月TOR));
        ViewStateHolder.put(ViewStateKeys.サービス提供年月, mapRDate.get(提供年月R));
        ViewStateHolder.put(ViewStateKeys.申請年月, mapRDate.get(申請年月R));
        ViewStateHolder.put(ViewStateKeys.決定年月, mapRDate.get(決定年月R));
    }

//    private KogakuShokaiTaishoshaKensakuSearch set検索条件(KogakuServicehiTaishoshaKensakuMainDiv div) {
//        KogakuServicehiTaishoshaKensakuMainHandler handler = getHandler(div);
//        KogakuShokaiTaishoshaKensakuSearch searchCondition;
//        RString メニューID = ResponseHolder.getMenuID();
//        RString 指定_被保険者 = TaishoshaKensakuHoho.被保険者指定.getコード();
//        RString ラジオ_指定 = ViewStateHolder.get(ViewStateKeys.ラジオ_指定, RString.class);
//        RString 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, RString.class);
//        RString 被保険者名 = ViewStateHolder.get(ViewStateKeys.被保険者名, RString.class);
//        RDate 提供年月From = ViewStateHolder.get(ViewStateKeys.提供年月From, RDate.class);
//        RDate 提供年月To = ViewStateHolder.get(ViewStateKeys.提供年月To, RDate.class);
//        RDate 申請年月From = ViewStateHolder.get(ViewStateKeys.申請年月From, RDate.class);
//        RDate 申請年月To = ViewStateHolder.get(ViewStateKeys.申請年月To, RDate.class);
//        RDate 決定年月From = ViewStateHolder.get(ViewStateKeys.決定年月From, RDate.class);
//        RDate 決定年月To = ViewStateHolder.get(ViewStateKeys.決定年月To, RDate.class);
//        RDate 提供年月 = ViewStateHolder.get(ViewStateKeys.提供年月, RDate.class);
//        RDate 申請年月 = ViewStateHolder.get(ViewStateKeys.申請年月, RDate.class);
//        RDate 決定年月 = ViewStateHolder.get(ViewStateKeys.決定年月, RDate.class);
//        handler.set検索条件(指定_被保険者, 被保険者番号, 被保険者名, 提供年月From,
//                提供年月To, 申請年月From, 申請年月To, 決定年月From, 決定年月To, 提供年月, 申請年月, 決定年月);
//        if (指定_被保険者.equals(ラジオ_指定)) {
//            searchCondition = handler.getパラメータ(メニューID, 被保険者番号,
//                    提供年月From, 提供年月To, 申請年月From, 申請年月To, 決定年月From, 決定年月To);
//        } else {
//            searchCondition = handler.getパラメータ(メニューID, RString.EMPTY, 提供年月, 提供年月, 申請年月, 申請年月, 決定年月, 決定年月);
//        }
//        return searchCondition;
//    }
    private KogakuServicehiTaishoshaKensakuMainHandler getHandler(KogakuServicehiTaishoshaKensakuMainDiv div) {
        return new KogakuServicehiTaishoshaKensakuMainHandler(div);
    }

    private ResponseData<KogakuServicehiTaishoshaKensakuMainDiv> createResponse(KogakuServicehiTaishoshaKensakuMainDiv div) {
        return ResponseData.of(div).respond();
    }
}
