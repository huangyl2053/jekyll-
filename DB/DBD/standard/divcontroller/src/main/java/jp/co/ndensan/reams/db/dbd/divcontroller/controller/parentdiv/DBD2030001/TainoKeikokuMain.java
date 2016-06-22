/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD2030001;

import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoHanteiResult;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2030001.DBD2030001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2030001.DBD2030001TransitionEventName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2030001.TainoKeikokuMainDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD2030001.TainoKeikokuMainHandler;
import jp.co.ndensan.reams.db.dbd.service.core.taino.TainoJokyoResearcher;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 滞納警告のイベントを定義したDivControllerです。
 *
 * @reamsid_L DBD-4340-010 liangbc
 */
public class TainoKeikokuMain {

    /**
     * 支払方法変更管理リストDivの初期化を表します。
     *
     * @param div ShiharaiHohoKanriListMainDiv
     * @return ResponseData
     */
    public ResponseData<TainoKeikokuMainDiv> onLoad(TainoKeikokuMainDiv div) {
        TainoJokyoResearcher researcher = TainoJokyoResearcher.createInstance();
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号();
        TainoHanteiResult 滞納判定結果 = researcher.research滞納状況(被保険者番号, FlexibleDate.getNowDate());
        if (滞納判定結果.is警告対象()) {
            return ResponseData.of(div).setState(DBD2030001StateName.滞納警告表示);
        } else {
            return ResponseData.of(div).forwardWithEventName(DBD2030001TransitionEventName.次画面へ).respond();
        }

    }

    /**
     * 滞納警告表示状態に状態遷移した場合、滞納警告を表示する。
     *
     * @param div ShiharaiHohoKanriListMainDiv
     * @return ResponseData
     */
    public ResponseData<TainoKeikokuMainDiv> onStateTransition(TainoKeikokuMainDiv div) {
        if (DBD2030001StateName.滞納警告表示.getName().equals(ResponseHolder.getState())) {
            TainoJokyoResearcher researcher = TainoJokyoResearcher.createInstance();
            HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号();
            TainoHanteiResult 滞納判定結果 = researcher.research滞納状況(被保険者番号, FlexibleDate.getNowDate());
            getHandler(div).滞納警告情報の表示(滞納判定結果);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 画面遷移イベント「次画面へ」で遷移する。\
     *
     * @param div ShiharaiHohoKanriListMainDiv
     * @return ResponseData
     */
    public ResponseData<TainoKeikokuMainDiv> onClick_btnNext(TainoKeikokuMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBD2030001TransitionEventName.次画面へ).respond();
    }

    private TainoKeikokuMainHandler getHandler(TainoKeikokuMainDiv div) {
        return new TainoKeikokuMainHandler(div);
    }

}
