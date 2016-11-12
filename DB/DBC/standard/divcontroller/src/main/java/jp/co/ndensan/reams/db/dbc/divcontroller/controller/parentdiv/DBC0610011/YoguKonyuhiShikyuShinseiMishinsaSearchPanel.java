/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0610011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyuikkatushinsa.ShokanShinseiEntityResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0610011.DBC0610011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0610011.DBC0610011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0610011.YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0610011.dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0610011.YoguKonyuhiShikyuShinseiMishinsaSearchHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0610011.YoguKonyuhiShikyuShinseiMishinsaValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0600011.PnlTotalParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 福祉用具購入費支給申請審査 未審査支給申請一覧のパネルです。
 *
 * @reamsid_L DBC-1021-090 gongliang
 */
public class YoguKonyuhiShikyuShinseiMishinsaSearchPanel {

    private final RString 保存 = new RString("btnSave");
    private final RString 審査 = new RString("審査");
    private static final RString 参照 = new RString("参照");
    private final RString 保存MSG = new RString(" 福祉用具購入費支給申請審査結果の更新");

    /**
     * 画面初期化メソッドです。
     *
     * @param div YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv
     * @return 福祉用具購入費支給申請審査画面
     */
    public ResponseData<YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv> onLoad(YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv div) {
        if (審査.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            RDate 支給申請日To = ViewStateHolder.get(ViewStateKeys.支給申請日TO, RDate.class);
            RDate 支給申請日From = ViewStateHolder.get(ViewStateKeys.支給申請日FROM, RDate.class);
            div.getYoguKonyuhiShikyuShinseiMishinsaSearchCondition().getTxtShikyuShinseiDateRange().setToValue(支給申請日To);
            div.getYoguKonyuhiShikyuShinseiMishinsaSearchCondition().getTxtShikyuShinseiDateRange().setFromValue(支給申請日From);
            ArrayList<ShokanShinseiEntityResult> resultList = getHandler(div).未審査分検索処理(支給申請日From, 支給申請日To);
            ViewStateHolder.put(ViewStateKeys.福祉審査決定, resultList);
            div.getYoguKonyuhiShikyuShinseiMishinsaResultList().getTxtKetteiYMD().setValue(ViewStateHolder.get(ViewStateKeys.決定日, RDate.class));
            return ResponseData.of(div).setState(DBC0610011StateName.審査);
        }
        div.getYoguKonyuhiShikyuShinseiMishinsaResultList().getTxtKetteiYMD().setValue(RDate.getNowDate());
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
        ArrayList<ShokanShinseiEntityResult> resultList = getHandler(div).未審査分検索処理(支給申請日From, 支給申請日To);
        ViewStateHolder.put(ViewStateKeys.福祉審査決定, resultList);
        ViewStateHolder.put(ViewStateKeys.支給申請日FROM, 支給申請日From);
        ViewStateHolder.put(ViewStateKeys.支給申請日TO, 支給申請日To);
        return ResponseData.of(div).respond();
    }

    /**
     * 「未審査分を検索する」ボタンを押下した際に実行します。
     *
     * @param div YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv
     * @return 福祉用具購入費支給申請審査画面
     */
    public ResponseData<YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv> onStateTransition(
            YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv div) {
        if (審査.equals(ResponseHolder.getState())) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存, true);
        }
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
        ValidationMessageControlPairs validationMessages = new YoguKonyuhiShikyuShinseiMishinsaValidationHandler(div).validateデータ選択と決定日();
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
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
        dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row row = div.getYoguKonyuhiShikyuShinseiMishinsaResultList()
                .getDgYoguKonyuhiShisaMishinsaShikyuShinseiList().getActiveRow();
        HihokenshaNo 被保険者番号 = new HihokenshaNo(row.getTxtHihoNo().getValue());
        FlexibleYearMonth サービス提供年月 = row.getTxtTenkyoYM().getValue() == null
                ? FlexibleYearMonth.EMPTY
                : new FlexibleYearMonth(row.getTxtTenkyoYM().getValue().getYearMonth().toString());
        RString 整理番号 = row.getTxtSeiriNo().getValue();
        JigyoshaNo 事業者番号 = new JigyoshaNo(row.getTxtJigyoshaNo());
        RString 様式番号 = row.getTxtYoshikiNo();
        RString 明細番号 = row.getTxtMeisaiNo();
        ShikibetsuCode 識別コード = new ShikibetsuCode(row.getShikibetsuCode());
        RDate 決定日 = div.getYoguKonyuhiShikyuShinseiMishinsaResultList().getTxtKetteiYMD().getValue();
        ViewStateHolder.put(ViewStateKeys.状態, 参照);
        ViewStateHolder.put(ViewStateKeys.決定日, 決定日);
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        PnlTotalParameter param = new PnlTotalParameter(被保険者番号,
                サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        ViewStateHolder.put(ViewStateKeys.契約番号検索キー, param);
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
        ValidationMessageControlPairs validationMessages = new YoguKonyuhiShikyuShinseiMishinsaValidationHandler(div).validateデータ選択と決定日();
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        RDate 決定日R = div.getYoguKonyuhiShikyuShinseiMishinsaResultList().getTxtKetteiYMD().getValue();
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            FlexibleDate 決定日 = 決定日R == null
                    ? FlexibleDate.EMPTY
                    : new FlexibleDate(決定日R.toString());
            div.getYoguKonyuhiShikyuShinseiMishinsaSearchCondition().setVisible(false);
            div.getYoguKonyuhiShikyuShinseiMishinsaResultList().setVisible(false);
            CommonButtonHolder.setVisibleByCommonButtonFieldName(保存, false);
            List<ShokanShinseiEntityResult> entityList = ViewStateHolder.get(ViewStateKeys.福祉審査決定, List.class);
            getHandler(div).保存処理(決定日, entityList);
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
