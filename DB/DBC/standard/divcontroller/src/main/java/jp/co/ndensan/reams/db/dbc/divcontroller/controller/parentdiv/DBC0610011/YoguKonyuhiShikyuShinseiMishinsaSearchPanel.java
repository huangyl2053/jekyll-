/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0610011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0610011.DBC0610011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0610011.DBC0610011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0610011.YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0610011.YoguKonyuhiShikyuShinseiMishinsaSearchHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 福祉用具購入費支給申請審査 未審査支給申請一覧のパネルです。
 *
 * @reamsid_L DBC-1021-090 gongliang
 */
public class YoguKonyuhiShikyuShinseiMishinsaSearchPanel {

    private final RString 保存 = new RString("btnSave");
    private final RString 審査 = new RString("審査");
    private final RString 保存MSG = new RString(" 福祉用具購入費支給申請審査結果を更新");

    /**
     * 画面初期化メソッドです。
     *
     * @param div YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv
     * @return 福祉用具購入費支給申請審査画面
     */
    public ResponseData<YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv> onLoad(YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv div) {
        if (審査.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            RDate 支給申請日To = ViewStateHolder.get(ViewStateKeys.支給申請日_TO, RDate.class);
            RDate 支給申請日From = ViewStateHolder.get(ViewStateKeys.支給申請日_FROM, RDate.class);
            div.getYoguKonyuhiShikyuShinseiMishinsaSearchCondition().getTxtShikyuShinseiDateRange().setToValue(支給申請日To);
            div.getYoguKonyuhiShikyuShinseiMishinsaSearchCondition().getTxtShikyuShinseiDateRange().setFromValue(支給申請日From);
            getHandler(div).未審査分検索処理(支給申請日From, 支給申請日To);
            div.getYoguKonyuhiShikyuShinseiMishinsaResultList().getTxtKetteiYMD().setValue(ViewStateHolder.get(ViewStateKeys.決定日, RDate.class));
            return ResponseData.of(div).setState(DBC0610011StateName.審査);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「未審査分を検索する」ボタンを押下した際に実行します。
     *
     * @param div YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv
     * @return 福祉用具購入費支給申請審査画面
     */
    public ResponseData<YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv> onClick_btnSearchMishinsa(
            YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv div) {
        RDate 支給申請日From = div.getYoguKonyuhiShikyuShinseiMishinsaSearchCondition().getTxtShikyuShinseiDateRange().getFromValue();
        RDate 支給申請日To = div.getYoguKonyuhiShikyuShinseiMishinsaSearchCondition().getTxtShikyuShinseiDateRange().getToValue();
        getHandler(div).未審査分検索処理(支給申請日From, 支給申請日To);
        ViewStateHolder.put(ViewStateKeys.支給申請日_FROM, 支給申請日From);
        ViewStateHolder.put(ViewStateKeys.支給申請日_TO, 支給申請日To);
        return ResponseData.of(div).respond();
    }

    /**
     * 支給申請内容を一括審査・決定するボタンを押下した際に実行します。
     *
     * @param div YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv
     * @return 福祉用具購入費支給申請審査画面
     */
    public ResponseData<YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv> onClick_btnIkkatsuShinsa(
            YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv div) {
        getHandler(div).審査決定処理();
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存, false);
        return ResponseData.of(div).respond();
    }

    /**
     * 申請グリッドの修正ボタンを押下した際に実行します。
     *
     * @param div YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv
     * @return 福祉用具購入費支給申請審査画面
     */
    public ResponseData<YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv> onClick_btnModifyShinsei(
            YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv div) {
        getHandler(div).setViewState();
        return ResponseData.of(div).forwardWithEventName(DBC0610011TransitionEventName.修正).respond();
    }

    /**
     * 保存ボタンを押下した際に実行します。
     *
     * @param div YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv
     * @return 福祉用具購入費支給申請審査画面
     */
    public ResponseData<YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv> onClick_btnSave(
            YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv div) {
        RDate 決定日R = div.getYoguKonyuhiShikyuShinseiMishinsaResultList().getTxtKetteiYMD().getValue();
        getHandler(div).決定日入力チェック(決定日R);
        getHandler(div).選択チェック();
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            FlexibleDate 決定日 = new FlexibleDate(決定日R.toString());
            div.getYoguKonyuhiShikyuShinseiMishinsaSearchCondition().setVisible(false);
            div.getYoguKonyuhiShikyuShinseiMishinsaResultList().setVisible(false);
            CommonButtonHolder.setVisibleByCommonButtonFieldName(保存, false);
            getHandler(div).保存処理(決定日);
            div.getCcdKaigoKanryoMessage().setSuccessMessage(new RString(
                    UrInformationMessages.正常終了.getMessage().replace(保存MSG.toString()).evaluate()));
            return ResponseData.of(div).setState(DBC0610011StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    private YoguKonyuhiShikyuShinseiMishinsaSearchHandler getHandler(YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv div) {
        return new YoguKonyuhiShikyuShinseiMishinsaSearchHandler(div);
    }
}
