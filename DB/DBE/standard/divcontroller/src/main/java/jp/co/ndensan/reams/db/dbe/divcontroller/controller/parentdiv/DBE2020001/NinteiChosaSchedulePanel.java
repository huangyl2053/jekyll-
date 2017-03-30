/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2020001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosaschedule.NinteichosaScheduleBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichousasukejuru.NinteiChousaSukejuruParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020001.DBE2020001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020001.NinteiChosaSchedulePanelDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020001.NinteiChosaScheduleHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020001.ValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.sukejurutouroku.SukejuruTourokuFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 認定調査スケジュール登録1の取得処理。
 *
 * @reamsid_L DBE-0020-010 lizhuoxuan
 */
public class NinteiChosaSchedulePanel {

    private static final RString 画面ステート_1 = new RString("1");
    private static final RString 画面ステート_2 = new RString("2");
    private static final RString 画面ステート_3 = new RString("3");
    private static final RString 遷移元画面番号 = new RString("01");
    private static final RString モード = new RString("1");

    /**
     * 認定調査スケジュール登録1_一覧情報。
     *
     * @param div 認定調査スケジュール登録1_一覧情報Div
     * @return ResponseData<NinteiChosaSchedulePanelDiv>
     */
    public ResponseData<NinteiChosaSchedulePanelDiv> onLoad(NinteiChosaSchedulePanelDiv div) {
        getHandler(div).initialize();
        return createResponse(div);
    }

     /**
     * onBlur_txtChoKaishiYM
     *
     * @param div 認定調査スケジュール登録1_一覧情報Div
     * @return ResponseData<NinteiChosaSchedulePanelDiv>
     */
    public ResponseData<NinteiChosaSchedulePanelDiv> onBlur_txtConfigurationYM(NinteiChosaSchedulePanelDiv div) {
        if (div.getSearchConditionPanel().getTxtConfigurationYM().getDomain().isEmpty()) {
            ValidationMessageControlPairs controlPairs = getValidationHandler(div).validate和暦に変換不可(
                div.getSearchConditionPanel().getTxtConfigurationYM());
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }
        return ResponseData.of(div).respond();
    }
    
    /**
     * 前月へ　ボタン。<br/>
     *
     * @param div NinteiChosaSchedulePanelDiv
     * @return ResponseData<NinteiChosaSchedulePanelDiv>
     */
    public ResponseData<NinteiChosaSchedulePanelDiv> onClick_btnPreviousMonth(NinteiChosaSchedulePanelDiv div) {
        FlexibleYearMonth beforeYearMonth = div.getSearchConditionPanel().getTxtConfigurationYM().getDomain().minusMonth(1);
        div.getSearchConditionPanel().getTxtConfigurationYM().setDomain(beforeYearMonth);
        return ResponseData.of(div).respond();
    }
    
    
    /**
     * 次月へ　ボタン。<br/>
     *
     * @param div NinteiChosaSchedulePanelDiv
     * @return ResponseData<NinteiChosaSchedulePanelDiv>
     */
    public ResponseData<NinteiChosaSchedulePanelDiv> onClick_btnNextMonth(NinteiChosaSchedulePanelDiv div) {
        FlexibleYearMonth beforeYearMonth = div.getSearchConditionPanel().getTxtConfigurationYM().getDomain().plusMonth(1);
        div.getSearchConditionPanel().getTxtConfigurationYM().setDomain(beforeYearMonth);
        return ResponseData.of(div).respond();
    }

    /**
     * 表示する　ボタン。<br/>
     *
     * @param div NinteiChosaSchedulePanelDiv
     * @return ResponseData<NinteiChosaSchedulePanelDiv>
     */
    public ResponseData<NinteiChosaSchedulePanelDiv> onClick_btnDisplay(NinteiChosaSchedulePanelDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }
        FlexibleYearMonth 対象年月 = div.getSearchConditionPanel().getTxtConfigurationYM().getDomain();
        FlexibleDate 対象年月初日 = new FlexibleDate(対象年月.getYearValue(), 対象年月.getMonthValue(), 1);
        FlexibleDate 対象年月末日 = new FlexibleDate(対象年月.getYearValue(), 対象年月.getMonthValue(), 対象年月.getLastDay());
        NinteiChousaSukejuruParameter parameter = NinteiChousaSukejuruParameter.createGamenParam(
                new RString(div.getSearchConditionPanel().getTxtConfigurationYM().getDomain().toString()),
                new RString(div.getSearchConditionPanel().getDdlTaishoChiku().getSelectedKey().toString()),
                new RString(対象年月初日.toString()),
                new RString(対象年月末日.toString()));
        SukejuruTourokuFinder 認定調査スケジュール登録Finder = SukejuruTourokuFinder.createInstance();
        List<NinteichosaScheduleBusiness> 認定調査スケジュールList = 認定調査スケジュール登録Finder.getcheMapper(parameter).records();
        if (認定調査スケジュールList == null || 認定調査スケジュールList.isEmpty()) {
            ValidationMessageControlPairs validationMessages = createHandlerOf(div).check_btnKakuninn(div);
            if (validationMessages.iterator().hasNext()) {
                div.getDgNinteiChosaSchedule().clearSource();
                return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
            }
        }
        getHandler(div).kennsaku(認定調査スケジュールList);
        return ResponseData.of(div).respond();
    }

    /**
     * 選択ボタン。<br/>
     *
     * @param ninteiDiv NinteiChosaSchedulePanelDiv
     * @return ResponseData<NinteiChosaSchedulePanelDiv>
     */
    public ResponseData<NinteiChosaSchedulePanelDiv> onClick_Btnsenntaku(NinteiChosaSchedulePanelDiv ninteiDiv) {
        ViewStateHolder.put(ViewStateKeys.設定日,
                new FlexibleDate(ninteiDiv.getDgNinteiChosaSchedule().getActiveRow().getDate().getValue().toDateString()));
        ViewStateHolder.put(ViewStateKeys.地区コード, ninteiDiv.getSearchConditionPanel().getDdlTaishoChiku().getSelectedKey());
        ViewStateHolder.put(ViewStateKeys.画面ステート, 画面ステート_1);
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_モード, モード);
        ViewStateHolder.put(ViewStateKeys.遷移元画面番号, 遷移元画面番号);
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
        ViewStateHolder.put(ViewStateKeys.地区コード, 地区コード);
        return ResponseData.of(ninteiDiv).forwardWithEventName(DBE2020001TransitionEventName.スケジュール印刷).respond();
    }

    /**
     * スケジュールを照会する　ボタン。<br/>
     *
     * @param ninteiDiv NinteiChosaSchedulePanelDiv
     * @return ResponseData<NinteiChosaSchedulePanelDiv>
     */
    public ResponseData<NinteiChosaSchedulePanelDiv> onClick_btnShowSchedule(NinteiChosaSchedulePanelDiv ninteiDiv) {
        ViewStateHolder.put(ViewStateKeys.地区コード, ninteiDiv.getSearchConditionPanel().getDdlTaishoChiku().getSelectedKey());
        ViewStateHolder.put(ViewStateKeys.画面ステート, 画面ステート_2);
        ViewStateHolder.put(ViewStateKeys.設定日, new FlexibleDate(RDate.getNowDate().toString()));
        return ResponseData.of(ninteiDiv).forwardWithEventName(DBE2020001TransitionEventName.照会モードへ移行).respond();
    }

    /**
     * 未定者管理へ　ボタン。<br/>
     *
     * @param ninteiDiv NinteiChosaSchedulePanelDiv
     * @return ResponseData<NinteiChosaSchedulePanelDiv>
     */
    public ResponseData<NinteiChosaSchedulePanelDiv> onClick_btnMiteishaKanri(NinteiChosaSchedulePanelDiv ninteiDiv) {
        ViewStateHolder.put(ViewStateKeys.地区コード, ninteiDiv.getSearchConditionPanel().getDdlTaishoChiku().getSelectedKey());
        ViewStateHolder.put(ViewStateKeys.画面ステート, 画面ステート_3);
        ViewStateHolder.put(ViewStateKeys.設定日, new FlexibleDate(RDate.getNowDate().toString()));
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
    
    private ValidationHandler getValidationHandler(NinteiChosaSchedulePanelDiv ninteidiv) {
        return new ValidationHandler(ninteidiv);
    }
}
