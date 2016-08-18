/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC2000023;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000023.DBC2000023StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000023.DBC2000023TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000023.RiyoshaFutanWariaiKoushiConfDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000023.RiyoshaFutanWariaiKoushiConfHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc2000022.FutanWariaiSokujiKouseiServiceData;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMNK2001_利用者負担割合即時更正_更新結果確認のクラスです。
 *
 * @reamsid_L DBC-5010-012 lijian
 */
public class RiyoshaFutanWariaiKoushiConf {

    private static final RString 発行する = new RString("btnPrint");

    /**
     * 画面初期化を実行します。
     *
     * @param div RiyoshaFutanWariaiKoushiConfDiv
     * @return ResponseData
     */
    public ResponseData<RiyoshaFutanWariaiKoushiConfDiv> onLoad(RiyoshaFutanWariaiKoushiConfDiv div) {
        FutanWariaiSokujiKouseiServiceData 引継ぎデータ
                = ViewStateHolder.get(ViewStateKeys.引き継ぎデータ, FutanWariaiSokujiKouseiServiceData.class);
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);

        getHandler(div).initialize(引継ぎデータ, 資格対象者);
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行する」ボタンを押下すると、ボタンを行する。
     *
     * @param div RiyoshaFutanWariaiKoushiConfDiv
     * @return ResponseData
     */
    public ResponseData<RiyoshaFutanWariaiKoushiConfDiv> onClick_btnPrint(RiyoshaFutanWariaiKoushiConfDiv div) {
        CommonButtonHolder.setIsClientValidateByCommonButtonFieldName(発行する, true);

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(DbcQuestionMessages.負担割合証単票発行確認.getMessage()
                    .getCode(),
                    DbcQuestionMessages.負担割合証単票発行確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(DbcQuestionMessages.負担割合証単票発行確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).setState(DBC2000023StateName.初期表示);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行する」ボタンを押下すると、ボタンを行する。
     *
     * @param div RiyoshaFutanWariaiKoushiConfDiv
     * @return ResponseData
     */
    public ResponseData<SourceDataCollection> onClick_btnReportPublish(RiyoshaFutanWariaiKoushiConfDiv div) {

        FutanWariaiSokujiKouseiServiceData 引継ぎデータ
                = ViewStateHolder.get(ViewStateKeys.引き継ぎデータ, FutanWariaiSokujiKouseiServiceData.class);
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);

        getHandler(div).updateDB(div, 引継ぎデータ);

        getHandler(div).insertDB(div, 引継ぎデータ, 資格対象者);

        return ResponseData.of(getHandler(div).getソースデータ取得(div, 引継ぎデータ, 資格対象者)).setState(DBC2000023StateName.初期表示);

    }

    /**
     * 「再検索」ボタンを押下すると、対象者検索画面に遷移する。
     *
     * @param div RiyoshaFutanWariaiKoushiConfDiv
     * @return ResponseData
     */
    public ResponseData<RiyoshaFutanWariaiKoushiConfDiv> onClick_btnReSearch(RiyoshaFutanWariaiKoushiConfDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC2000023TransitionEventName.再検索).respond();
    }

    /**
     * 「検索結果一覧へ」ボタンを押下すると、検索結果一覧画面に遷移する。
     *
     * @param div RiyoshaFutanWariaiKoushiConfDiv
     * @return ResponseData
     */
    public ResponseData<RiyoshaFutanWariaiKoushiConfDiv> onClick_btnListSearchResult(RiyoshaFutanWariaiKoushiConfDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC2000023TransitionEventName.検索結果一覧).respond();
    }

    private RiyoshaFutanWariaiKoushiConfHandler getHandler(RiyoshaFutanWariaiKoushiConfDiv div) {
        return new RiyoshaFutanWariaiKoushiConfHandler(div);
    }

}
