/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2020001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020001.DBE2020001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020001.NinteiChosaSchedulePanelDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020001.NinteiChosaScheduleHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Seireki;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 認定調査スケジュール登録1の取得処理。
 */
public class NinteiChosaSchedulePanel {

    private static final RString 画面ステート_1 = new RString("1");
    private static final RString 画面ステート_2 = new RString("2");
    private static final RString 画面ステート_3 = new RString("3");
    private static final RString 初期状態 = new RString("初期状態");
    private static final RString 遷移元画面番号 = new RString("01");
    private static final RString モード = new RString("1");
    private static final int 月_12 = 12;

    /**
     * 認定調査スケジュール登録1_一覧情報。
     *
     * @param div 認定調査スケジュール登録1_一覧情報Div
     * @return ResponseData<NinteiChosaSchedulePanelDiv>
     */
    public ResponseData<NinteiChosaSchedulePanelDiv> onLoad(NinteiChosaSchedulePanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, 初期状態);
        getHandler(div).initialize();
        return createResponse(div);
    }

    /**
     * 前月へ　ボタン。<br/>
     *
     * @param ninteiDiv NinteiChosaSchedulePanelDiv
     * @return ResponseData<NinteiChosaSchedulePanelDiv>
     */
    public ResponseData<NinteiChosaSchedulePanelDiv> onClick_btnPreviousMonth(NinteiChosaSchedulePanelDiv ninteiDiv) {
        if (ninteiDiv.getSearchConditionPanel().getTxtSetteiYM().getValue() == null
                || ninteiDiv.getSearchConditionPanel().getTxtSetteiYM().getValue().isEmpty()) {
            return createResponseData(ninteiDiv);
        }
        Seireki date1 = ninteiDiv.getSearchConditionPanel().getTxtSetteiYM().getValue().seireki();
        FlexibleDate date;
        if (Integer.parseInt(date1.getMonth().toString()) == 1) {
            date = new FlexibleDate(Integer.parseInt(date1.getYear().toString()) - 1, 月_12, 1);
        } else {
            date = new FlexibleDate(Integer.parseInt(date1.getYear().toString()), Integer.parseInt(date1.getMonth().toString()) - 1, 1);
        }
        ninteiDiv.getSearchConditionPanel().getTxtSetteiYM().setValue(date);
        return createResponseData(ninteiDiv);
    }

    /**
     * 次月へ　ボタン。<br/>
     *
     * @param ninteiDiv NinteiChosaSchedulePanelDiv
     * @return ResponseData<NinteiChosaSchedulePanelDiv>
     */
    public ResponseData<NinteiChosaSchedulePanelDiv> onClick_btnNextMonth(NinteiChosaSchedulePanelDiv ninteiDiv) {
        if (ninteiDiv.getSearchConditionPanel().getTxtSetteiYM().getValue() == null
                || ninteiDiv.getSearchConditionPanel().getTxtSetteiYM().getValue().isEmpty()) {
            return createResponseData(ninteiDiv);
        }
        Seireki date2 = ninteiDiv.getSearchConditionPanel().getTxtSetteiYM().getValue().seireki();
        FlexibleDate date;
        if (Integer.parseInt(date2.getMonth().toString()) == 月_12) {
            date = new FlexibleDate(Integer.parseInt(date2.getYear().toString()) + 1, 01, 1);
        } else {
            date = new FlexibleDate(Integer.parseInt(date2.getYear().toString()), Integer.parseInt(date2.getMonth().toString()) + 1, 1);
        }
        ninteiDiv.getSearchConditionPanel().getTxtSetteiYM().setValue(date);
        return createResponseData(ninteiDiv);
    }

    /**
     * 表示する　ボタン。<br/>
     *
     * @param ninteiDiv NinteiChosaSchedulePanelDiv
     * @return ResponseData<NinteiChosaSchedulePanelDiv>
     */
    public ResponseData<NinteiChosaSchedulePanelDiv> onClick_btnDisplay(NinteiChosaSchedulePanelDiv ninteiDiv) {
        createHandlerOf(ninteiDiv).kennsaku();
        return createResponseData(ninteiDiv);
    }

    /**
     * 選択ボタン。<br/>
     *
     * @param ninteiDiv NinteiChosaSchedulePanelDiv
     * @return ResponseData<NinteiChosaSchedulePanelDiv>
     */
    public ResponseData<NinteiChosaSchedulePanelDiv> onClick_Btnsenntaku(NinteiChosaSchedulePanelDiv ninteiDiv) {
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_設定日, ninteiDiv.getSearchConditionPanel().getTxtSetteiYM().getValue());
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_地区コード, ninteiDiv.getSearchConditionPanel().getDdlTaishoChiku().getSelectedKey());
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_画面ステート, 画面ステート_1);
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_モード, モード);
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_遷移元画面番号, 遷移元画面番号);
        return ResponseData.of(ninteiDiv).forwardWithEventName(DBE2020001TransitionEventName.更新モードへ移行).respond();
    }

    /**
     * スケジュール表を印刷する　ボタン。<br/>
     *
     * @param ninteiDiv NinteiChosaSchedulePanelDiv
     * @return ResponseData<NinteiChosaSchedulePanelDiv>
     */
    public ResponseData<NinteiChosaSchedulePanelDiv> onClick_btnPrintSchedule(NinteiChosaSchedulePanelDiv ninteiDiv) {
        RString 地区コード = ninteiDiv.getDdlTaishoChiku().getSelectedKey();
        if (RString.isNullOrEmpty(地区コード)) {
            地区コード = RString.EMPTY;
        }
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_地区コード, 地区コード);
        return ResponseData.of(ninteiDiv).forwardWithEventName(DBE2020001TransitionEventName.スケジュール印刷).respond();
    }

    /**
     * スケジュールを照会する　ボタン。<br/>
     *
     * @param ninteiDiv NinteiChosaSchedulePanelDiv
     * @return ResponseData<NinteiChosaSchedulePanelDiv>
     */
    public ResponseData<NinteiChosaSchedulePanelDiv> onClick_btnShowSchedule(NinteiChosaSchedulePanelDiv ninteiDiv) {
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_地区コード, ninteiDiv.getSearchConditionPanel().getDdlTaishoChiku().getSelectedKey());
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_画面ステート, 画面ステート_2);
        return ResponseData.of(ninteiDiv).forwardWithEventName(DBE2020001TransitionEventName.照会モードへ移行).respond();
    }

    /**
     * 未定者管理へ　ボタン。<br/>
     *
     * @param ninteiDiv NinteiChosaSchedulePanelDiv
     * @return ResponseData<NinteiChosaSchedulePanelDiv>
     */
    public ResponseData<NinteiChosaSchedulePanelDiv> onClick_btnMiteishaKanri(NinteiChosaSchedulePanelDiv ninteiDiv) {
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_地区コード, ninteiDiv.getSearchConditionPanel().getDdlTaishoChiku().getSelectedKey());
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_画面ステート, 画面ステート_3);
        return ResponseData.of(ninteiDiv).forwardWithEventName(DBE2020001TransitionEventName.未定モードへ移行).respond();
    }

    private NinteiChosaScheduleHandler getHandler(NinteiChosaSchedulePanelDiv panel) {
        return new NinteiChosaScheduleHandler(panel);
    }

    private ResponseData<NinteiChosaSchedulePanelDiv> createResponse(NinteiChosaSchedulePanelDiv div) {
        return ResponseData.of(div).respond();
    }

    private ResponseData<NinteiChosaSchedulePanelDiv> createResponseData(NinteiChosaSchedulePanelDiv requestDiv) {
        ResponseData<NinteiChosaSchedulePanelDiv> response = new ResponseData();
        response.data = requestDiv;
        return response;
    }

    private NinteiChosaScheduleHandler createHandlerOf(NinteiChosaSchedulePanelDiv fukuDiv) {
        return new NinteiChosaScheduleHandler(fukuDiv);
    }
}
