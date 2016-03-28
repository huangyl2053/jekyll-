/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0820015;

import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.config.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820015.ShokanbarayiKeteiInfoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820015.ShokanbarayiKeteiInfoPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SikibetuNokennsakuki;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SyokanbaraihishikyushinseiketteParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 償還払い費支給申請決定_償還払決定情報
 */
public class ShokanbarayiKeteiInfoPanel {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 新規 = new RString("新規");
    private static final RString 申請を保存する = new RString("Element3");

    /**
     * onLoad
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShokanbarayiKeteiInfoPanelDiv> onLoad(ShokanbarayiKeteiInfoPanelDiv div) {
        SyokanbaraihishikyushinseiketteParameter par = new SyokanbaraihishikyushinseiketteParameter(
                new HihokenshaNo("000000003"),
                new FlexibleYearMonth(new RString("201601")),
                new RString("0000000003"),
                new JigyoshaNo("0000000003"),
                new RString("0003"),
                new RString("0003"),
                Decimal.TEN);
        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, par);
        SyokanbaraihishikyushinseiketteParameter paramter = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                SyokanbaraihishikyushinseiketteParameter.class);
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.整理番号, 整理番号);
        SikibetuNokennsakuki key = new SikibetuNokennsakuki(new RString("0003"),
                new FlexibleYearMonth(new RString("200501")));
        ViewStateHolder.put(ViewStateKeys.識別番号検索キー, key);
        ViewStateHolder.put(ViewStateKeys.申請日, new RDate("20151129"));
        RString 業務区分 = new RString("03");
        RString 画面モード = new RString("モード_修正");
        ShikibetsuCode 識別コード = new ShikibetsuCode("000000000000010");
        div.getPanelOne().getCcdKaigoAtenaInfo().onLoad(識別コード);
        if (!被保険者番号.isEmpty()) {
            div.getPanelOne().getCcdKaigoShikakuKihon().onLoad(被保険者番号);
        } else {
            div.getPanelOne().getCcdKaigoShikakuKihon().setVisible(false);
        }
        div.getCcdShokanbaraiketteiJoho().loadInitialize(
                被保険者番号, サービス年月, 整理番号, 業務区分, 画面モード);
        div.getPanelTwo().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.wareki().toDateString().toString()));
        div.getPanelTwo().getTxtSeiriBango().setValue(整理番号);
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            RString 償還 = BusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還, SubGyomuCode.DBC介護給付);
            if (new RString("受託あり").equals(償還)) {
                div.getPanelTwo().getBtnShokanbariKeteiInfo().setDisabled(true);
            }
            div.getPanelTwo().getBtnKouza().setDisabled(true);
            div.getPanelTwo().getTxtShoriMode().setValue(新規);
        }
        if (修正.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            div.getPanelTwo().getBtnKouza().setDisabled(true);
            div.getPanelTwo().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.wareki()
                    .toDateString().toString()));
            div.getPanelTwo().getTxtSeiriBango().setValue(整理番号);
            div.getPanelTwo().getTxtShoriMode().setValue(修正);
        }
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("申請を保存する"), true);
            div.getPanelTwo().getBtnShinsei().setDisabled(true);
            div.getPanelTwo().getTxtShoriMode().setValue(削除);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnShinsei
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShokanbarayiKeteiInfoPanelDiv> onClick_btnShinsei(ShokanbarayiKeteiInfoPanelDiv div) {
        getHandler(div).putViewState();
        RString 画面モード = div.getPanelTwo().getTxtShoriMode().getValue();
        if (登録.equals(画面モード)) {
            ViewStateHolder.put(ViewStateKeys.画面モード, 修正);
            return ResponseData.of(div).respond();
        } else {
            ViewStateHolder.put(ViewStateKeys.画面モード, 画面モード);
            return ResponseData.of(div).respond();
        }
    }

    /**
     * onClick_btnKouza
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShokanbarayiKeteiInfoPanelDiv> onClick_btnKouza(ShokanbarayiKeteiInfoPanelDiv div) {
        RString 画面モード = div.getPanelTwo().getTxtShoriMode().getValue();
        ViewStateHolder.put(ViewStateKeys.画面モード, 画面モード);
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnServiceTeikyoShomeisyo
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShokanbarayiKeteiInfoPanelDiv> onClick_btnServiceTeikyoShomeisyo(
            ShokanbarayiKeteiInfoPanelDiv div) {
        if (getHandler(div).getチェック処理()) {
            getHandler(div).putViewState();
            RString 画面モード = div.getPanelTwo().getTxtShoriMode().getValue();
            ViewStateHolder.put(ViewStateKeys.画面モード, 画面モード);
            return ResponseData.of(div).respond();
        } else {
            throw new ApplicationException(UrErrorMessages.既に存在.getMessage());
        }
    }

    /**
     * onClick_CommonCancel
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShokanbarayiKeteiInfoPanelDiv> onClick_CommonCancel(ShokanbarayiKeteiInfoPanelDiv div) {
        boolean flag = getHandler(div).get内容変更状態();
        if (flag) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).respond();
            } else {
                return ResponseData.of(div).respond();
            }
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * onClick_CommonSave
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShokanbarayiKeteiInfoPanelDiv> onClick_CommonSave(ShokanbarayiKeteiInfoPanelDiv div) {
        boolean flag = true;
        getHandler(div).get内容変更状態();
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            if (!ResponseHolder.isReRequest()) {
                getHandler(div).削除Save();
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage()
                        .replace(削除.toString())).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, true);
                return ResponseData.of(div).respond();
            }
        } else if (flag) {
            if (!ResponseHolder.isReRequest()) {
                getHandler(div).登録Save();
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage()).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, true);
                return ResponseData.of(div).respond();
            }

        } else {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div)
                        .addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    private ShokanbarayiKeteiInfoPanelHandler getHandler(ShokanbarayiKeteiInfoPanelDiv div) {
        return ShokanbarayiKeteiInfoPanelHandler.of(div);
    }
}
