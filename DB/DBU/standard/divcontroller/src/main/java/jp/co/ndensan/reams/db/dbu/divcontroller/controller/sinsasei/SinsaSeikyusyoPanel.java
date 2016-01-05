/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.sinsasei;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.SinsaSeikyusyoJohoModel;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900011.DBU0900011TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900011.SinsaSeikyusyoJohoHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900011.SinsaSeikyusyoPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900011.grdSinsaSeikyusyoJoho_Row;
import jp.co.ndensan.reams.db.dbu.service.sinsasei.SinsaSeikyusyoJohoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 審査請求書登録_一覧情報の取得処理。
 */
public class SinsaSeikyusyoPanel {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString 照会 = new RString("照会");
    private static final RString 更新 = new RString("更新");

    /**
     * 審査請求書登録_一覧情報。
     *
     * @param div 審査請求書登録_一覧情報Div
     * @return ResponseData<SinsaSeikyusyoPanelDiv>
     */
    public ResponseData<SinsaSeikyusyoPanelDiv> onLoad(SinsaSeikyusyoPanelDiv div) {
        // 宛名基本情報を取得する。
        div.getAtenainfoCommonChildDiv1().load(ShikibetsuCode.EMPTY);
        // 資格系基本情報を取得。
        div.getShikakuKihonCommonChildDiv1().initialize(HihokenshaNo.EMPTY);
        // TODO 李卓軒　前画面引数不明
        ShikibetsuCode 識別コード = new ShikibetsuCode("456");
        HihokenshaNo 被保険者番号 = new HihokenshaNo("123");
//        ViewStateHolder.put(ViewStateKeys.状態, 照会);
        ViewStateHolder.put(ViewStateKeys.状態, 更新);

        List<SinsaSeikyusyoJohoModel> sinsaSeikyusyoJohoList
                = SinsaSeikyusyoJohoFinder.createInstance().getSinsaSeikyusyoJohoList(識別コード, 被保険者番号).records();
        getHandler(div).onLoad(sinsaSeikyusyoJohoList);
        return createResponse(div);

    }

    /**
     * 追加ボタン。<br/>
     *
     * @param div
     * @return レスポンス
     */
    public ResponseData<SinsaSeikyusyoPanelDiv> onClick_btnTuika(SinsaSeikyusyoPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.識別コード, ViewStateHolder.get(ViewStateKeys.識別コード, RString.class));
        ViewStateHolder.put(ViewStateKeys.被保険者番号, div.getShikakuKihonCommonChildDiv1().get被保険者番号());
        ViewStateHolder.put(ViewStateKeys.状態, 状態_追加);
        return ResponseData.of(div).forwardWithEventName(DBU0900011TransitionEventName.登録画面に遷移).parameter(状態_追加);
    }

    /**
     * 選択ボタン。<br/>
     *
     * @param div
     * @return レスポンス
     */
    public ResponseData<SinsaSeikyusyoPanelDiv> onClick_BtnSenTaKu(SinsaSeikyusyoPanelDiv div) {
        grdSinsaSeikyusyoJoho_Row grdSinsaSeikyusyoJoho_Row = div.getGrdSinsaSeikyusyoJoho().getSelectedItems().get(0);
        div.getGrdSinsaSeikyusyoJoho().getGridSetting().selectedRowCount();
        return createResponseData(div);
    }

    /**
     * 修正ボタン。<br/>
     *
     * @param sindiv
     * @return レスポンス
     */
    public ResponseData<SinsaSeikyusyoPanelDiv> onClick_btnShuuSei(SinsaSeikyusyoPanelDiv sindiv) {
        ViewStateHolder.put(ViewStateKeys.識別コード, ViewStateHolder.get(ViewStateKeys.識別コード, RString.class));
        ViewStateHolder.put(ViewStateKeys.被保険者番号, sindiv.getShikakuKihonCommonChildDiv1().get被保険者番号());
        ViewStateHolder.put(ViewStateKeys.状態, 状態_修正);
        sindiv.getGrdSinsaSeikyusyoJoho().getActiveRow().getTxtShinsaSeikyuTodokeYMD().getValue();
        return ResponseData.of(sindiv).forwardWithEventName(DBU0900011TransitionEventName.登録画面に遷移).parameter(状態_修正);
    }

    /**
     * 削除ボタン。<br/>
     *
     * @param sindiv
     * @return レスポンス
     */
    public ResponseData<SinsaSeikyusyoPanelDiv> onClick_btnSakuzyo(SinsaSeikyusyoPanelDiv sindiv) {
        ViewStateHolder.put(ViewStateKeys.識別コード, ViewStateHolder.get(ViewStateKeys.識別コード, RString.class));
        ViewStateHolder.put(ViewStateKeys.被保険者番号, sindiv.getShikakuKihonCommonChildDiv1().get被保険者番号());
        ViewStateHolder.put(ViewStateKeys.状態, 状態_削除);
        sindiv.getGrdSinsaSeikyusyoJoho().getActiveRow().getTxtShinsaSeikyuTodokeYMD().getValue();
        return ResponseData.of(sindiv).forwardWithEventName(DBU0900011TransitionEventName.登録画面に遷移).parameter(状態_削除);
    }
// TODO 弁明書の発行処理
//    /**
//     * 弁明書発行。<br/>
//     *
//     * @param sindiv
//     * @return レスポンス
//     */
//    public ResponseData<SinsaSeikyusyoPanelDiv> onClick_btnbennsho(SinsaSeikyusyoPanelDiv sindiv) {
//        grdSinsaSeikyusyoJoho_Row grdSinsaSeikyusyoJoho_Row = sindiv.getGrdSinsaSeikyusyoJoho().getSelectedItems().get(0);
//        ViewStateHolder.put(ViewStateKeys.識別コード, sindiv.getAtenainfoCommonChildDiv1().getName());
//        ViewStateHolder.put(ViewStateKeys.被保険者番号, sindiv.getShikakuKihonCommonChildDiv1().get被保険者番号());
//        sindiv.getGrdSinsaSeikyusyoJoho().getActiveRow().getTxtShinsaSeikyuTodokeYMD().getValue();
//        return ResponseData.of(sindiv).forwardWithEventName(DBU0900011TransitionEventName.登録画面に遷移).parameter(状態_削除);
//    }

    private SinsaSeikyusyoJohoHandler getHandler(SinsaSeikyusyoPanelDiv panel) {
        return new SinsaSeikyusyoJohoHandler(panel);
    }

    private ResponseData<SinsaSeikyusyoPanelDiv> createResponse(SinsaSeikyusyoPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    private ResponseData<SinsaSeikyusyoPanelDiv> createResponseData(SinsaSeikyusyoPanelDiv requestDiv) {
        ResponseData<SinsaSeikyusyoPanelDiv> response = new ResponseData();
        response.data = requestDiv;
        return response;
    }
}
