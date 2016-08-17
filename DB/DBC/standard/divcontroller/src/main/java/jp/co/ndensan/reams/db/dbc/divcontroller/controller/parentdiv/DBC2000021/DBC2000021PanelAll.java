/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC2000021;

import jp.co.ndensan.reams.db.dbc.business.core.riyoshafutanwariaihanteimanager.RiyoshaFutanWariaiHanteiManagerResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000021.DBC2000021TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000021.DBC2000021PanelAllDiv;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000021.DBC2000021TransitionEventName.判定実行;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000021.PanelAllHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMNK2001_利用者負担割合即時更正_新規のクラスです。
 *
 * @reamsid_L DBC-5010-010 lihang
 */
public class DBC2000021PanelAll {

    /**
     * 画面を初期化します。
     *
     * @param div DBC2000021PanelAllDiv
     * @return ResponseData DBC2000021PanelAllDiv
     */
    public ResponseData<DBC2000021PanelAllDiv> onLoad(DBC2000021PanelAllDiv div) {
        TaishoshaKey 引継ぎデータ = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode 識別コード = 引継ぎデータ.get識別コード();
        HihokenshaNo 被保険者番号 = 引継ぎデータ.get被保険者番号();
        div.getCcdKaigoAtenaInfo().initialize(識別コード);
        div.getCcdKaigoShikakuKihon().initialize(識別コード);
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        getHandler(div).initialize(被保険者番号, 識別コード);
        return ResponseData.of(div).respond();
    }

    /**
     * 基準日を設定します
     *
     * @param div DBC2000021PanelAllDiv
     * @return ResponseData DBC2000021PanelAllDiv
     */
    public ResponseData<DBC2000021PanelAllDiv> onChange_ddlNendo(DBC2000021PanelAllDiv div) {
        getHandler(div).set基準日();
        return ResponseData.of(div).respond();
    }

    /**
     * 新規判定を実行します
     *
     * @param div DBC2000021PanelAllDiv
     * @return ResponseData DBC2000021PanelAllDiv
     */
    public ResponseData<DBC2000021PanelAllDiv> onClick_btnJikko(DBC2000021PanelAllDiv div) {

        if (!getHandler(div).is基準日は指定年度内()) {
            throw new ApplicationException(UrErrorMessages.未指定.getMessage().replace("基準日は指定年度内の日付を").evaluate());
        } else {
            HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getCcdKaigoShikakuKihon().get被保険者番号());
            FlexibleYear 年度 = new FlexibleYear(div.getDdlNendo().getSelectedKey());
            FlexibleDate 基準日 = new FlexibleDate(div.getTxtKijunbi().getValue().toDateString());
            RiyoshaFutanWariaiHanteiManagerResult 判定結果 = getHandler(div).hannTei(被保険者番号, 年度, 基準日);
            判定結果.set基準日(基準日);
            判定結果.set年度(年度);
            ViewStateHolder.put(ViewStateKeys.判定結果, 判定結果);
            return ResponseData.of(div).forwardWithEventName(判定実行).respond();
        }
    }

    /**
     * 再検索をします
     *
     * @param div DBC2000021PanelAllDiv
     * @return ResponseData DBC2000021PanelAllDiv
     */
    public ResponseData<DBC2000021PanelAllDiv> onClick_btnReSearch(DBC2000021PanelAllDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC2000021TransitionEventName.再検索).respond();
    }

    /**
     * 検索結果一覧に遷移します
     *
     *
     * @param div DBC2000021PanelAllDiv
     * @return ResponseData DBC2000021PanelAllDiv
     */
    public ResponseData<DBC2000021PanelAllDiv> onClick_btnSearchResult(DBC2000021PanelAllDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC2000021TransitionEventName.検索結果一覧).respond();
    }

    private PanelAllHandler getHandler(DBC2000021PanelAllDiv div) {
        return new PanelAllHandler(div);
    }
}
