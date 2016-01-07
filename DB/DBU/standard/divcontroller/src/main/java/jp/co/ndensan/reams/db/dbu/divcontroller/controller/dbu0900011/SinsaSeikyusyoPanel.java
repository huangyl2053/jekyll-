/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.dbu0900011;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900011.DBU0900011TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900011.SinsaSeikyusyoPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.dbu0900011.SinsaSeikyusyoJohoHandler;
import jp.co.ndensan.reams.db.dbu.service.sinsasei.SinsaSeikyusyoJohoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.FufukuMoshitate;
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
    private static final RString 識別コード = new RString("識別コード");
    private static final RString 被保険者番号 = new RString("被保険者番号");

    /**
     * 審査請求書登録_一覧情報。
     *
     * @param div 審査請求書登録_一覧情報Div
     * @return ResponseData<SinsaSeikyusyoPanelDiv>
     */
    public ResponseData<SinsaSeikyusyoPanelDiv> onLoad(SinsaSeikyusyoPanelDiv div) {
        // TODO QA415 共有子Divのload事件問題が存在する。
//        // 宛名基本情報を取得する。
//        div.getAtenainfoCommonChildDiv1().load(ShikibetsuCode.EMPTY);
////        div.getAtenainfoCommonChildDiv1().load(new ShikibetsuCode(new RString("123401234000011")));
//        // 資格系基本情報を取得。
//        div.getShikakuKihonCommonChildDiv1().initialize(HihokenshaNo.EMPTY);
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
//        ViewStateHolder.put(ViewStateKeys.状態, 照会);
        ViewStateHolder.put(ViewStateKeys.状態, 更新);
        List<FufukuMoshitate> sinsaSeikyusyoJohoList
                = SinsaSeikyusyoJohoFinder.createInstance().getSinsaSeikyusyoJohoList(ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class),
                        ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class)).records();
        getHandler(div).onLoad(sinsaSeikyusyoJohoList);
        return createResponse(div);
    }

    /**
     * 追加ボタン。<br/>
     *
     * @param div
     * @return ResponseData<SinsaSeikyusyoPanelDiv>
     */
    public ResponseData<SinsaSeikyusyoPanelDiv> onClick_btnTuika(SinsaSeikyusyoPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.識別コード, ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class));
        ViewStateHolder.put(ViewStateKeys.被保険者番号, ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class));
        ViewStateHolder.put(ViewStateKeys.状態, 状態_追加);
        // TODO QA72883
        return ResponseData.of(div).forwardWithEventName(DBU0900011TransitionEventName.登録画面に遷移).parameter(状態_追加);
    }

    // TODO 弁明書発行実装しない、「選択ボタン」利用しない。
//    /**
//     * 選択ボタン。<br/>
//     *
//     * @param div
//     * @return ResponseData<SinsaSeikyusyoPanelDiv>
//     */
//    public ResponseData<SinsaSeikyusyoPanelDiv> onClick_BtnSenTaKu(SinsaSeikyusyoPanelDiv div) {
//        grdSinsaSeikyusyoJoho_Row grdSinsaSeikyusyoJoho_Row = div.getGrdSinsaSeikyusyoJoho().getSelectedItems().get(0);
//        div.getGrdSinsaSeikyusyoJoho().getGridSetting().selectedRowCount();
//        return createResponseData(div);
//    }
    /**
     * 修正ボタン。<br/>
     *
     * @param sindiv
     * @return ResponseData<SinsaSeikyusyoPanelDiv>
     */
    public ResponseData<SinsaSeikyusyoPanelDiv> onClick_btnShuuSei(SinsaSeikyusyoPanelDiv sindiv) {
        ViewStateHolder.put(ViewStateKeys.識別コード, ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class));
        ViewStateHolder.put(ViewStateKeys.被保険者番号, ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class));
        ViewStateHolder.put(ViewStateKeys.状態, 状態_修正);
        ViewStateHolder.put(ViewStateKeys.審査請求届出日,
                sindiv.getGrdSinsaSeikyusyoJoho().getActiveRow().getTxtShinsaSeikyuTodokeYMD().getValue());
        // TODO QA72883
        return ResponseData.of(sindiv).forwardWithEventName(DBU0900011TransitionEventName.登録画面に遷移).parameter(状態_修正);
    }

    /**
     * 削除ボタン。<br/>
     *
     * @param sindiv
     * @return ResponseData<SinsaSeikyusyoPanelDiv>
     */
    public ResponseData<SinsaSeikyusyoPanelDiv> onClick_btnSakuzyo(SinsaSeikyusyoPanelDiv sindiv) {
        ViewStateHolder.put(ViewStateKeys.識別コード, ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class));
        ViewStateHolder.put(ViewStateKeys.被保険者番号, ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class));
        ViewStateHolder.put(ViewStateKeys.状態, 状態_削除);
        ViewStateHolder.put(ViewStateKeys.審査請求届出日,
                sindiv.getGrdSinsaSeikyusyoJoho().getActiveRow().getTxtShinsaSeikyuTodokeYMD().getValue());
        // TODO QA72883
        return ResponseData.of(sindiv).forwardWithEventName(DBU0900011TransitionEventName.登録画面に遷移).parameter(状態_削除);
    }
    // TODO 弁明書の発行処理 該当機能実装しない。
//    /**
//     * 弁明書発行。<br/>
//     *
//     * @param sindiv
//     * @return ResponseData<SinsaSeikyusyoPanelDiv>
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
