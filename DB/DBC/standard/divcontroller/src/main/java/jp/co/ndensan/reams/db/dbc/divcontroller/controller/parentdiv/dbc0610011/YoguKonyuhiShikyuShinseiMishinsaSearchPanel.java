/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0610011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0610011.DBC0610011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0610011.YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0610011.YoguKonyuhiShikyuShinseiMishinsaSearchHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 福祉用具購入費支給申請審査 未審査支給申請一覧のパネルです。
 *
 * @author きょう亮
 */
public class YoguKonyuhiShikyuShinseiMishinsaSearchPanel {

    private final RString 保存 = new RString("btnSave");

    public ResponseData<YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv> onLoad(YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    public ResponseData<YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv> onClick_btnSearchMishinsa(
            YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv div) {
        getHandler(div).未審査分検索処理();
        div.getYoguKonyuhiShikyuShinseiMishinsaSearchCondition().setIsOpen(false);
        div.getYoguKonyuhiShikyuShinseiMishinsaResultList().setIsOpen(true);
        return ResponseData.of(div).respond();
    }

    public ResponseData<YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv> onClick_btnIkkatsuShinsa(
            YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv div) {
        getHandler(div).審査決定処理();
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存, false);
        return ResponseData.of(div).respond();
    }

    public ResponseData<YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv> onClick_btnModifyShinsei(
            YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv div) {
        getHandler(div).setViewState();
        // TODO 検索されたデータを一覧に表示する
        return ResponseData.of(div).forwardWithEventName(DBC0610011TransitionEventName.修正).respond();
    }

    public ResponseData<YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv> onClick_btnSave(
            YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv div) {
        RDate 決定日R = div.getYoguKonyuhiShikyuShinseiMishinsaResultList().getTextBoxDate2().getValue();
        getHandler(div).決定日入力チェック(決定日R);
        FlexibleDate 決定日 = new FlexibleDate(決定日R.toString());
        getHandler(div).選択チェック();
        if (!ResponseHolder.isReRequest()) {
        QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).保存処理(決定日);
        }
        div.getYoguKonyuhiShikyuShinseiMishinsaSearchCondition().setVisible(false);
        div.getYoguKonyuhiShikyuShinseiMishinsaResultList().setVisible(false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(保存, false);
        return ResponseData.of(div).respond();
        }

    private YoguKonyuhiShikyuShinseiMishinsaSearchHandler getHandler(YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv div) {
        return new YoguKonyuhiShikyuShinseiMishinsaSearchHandler(div);
    }
}
