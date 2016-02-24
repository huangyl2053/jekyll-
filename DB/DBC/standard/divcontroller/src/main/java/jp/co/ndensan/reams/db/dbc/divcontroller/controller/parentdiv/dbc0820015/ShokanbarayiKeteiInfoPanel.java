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
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * @author 徐浩
 */
public class ShokanbarayiKeteiInfoPanel {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 新規 = new RString("新規");

    /**
     * onLoad
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShokanbarayiKeteiInfoPanelDiv> onLoad(ShokanbarayiKeteiInfoPanelDiv div) {
        // TODO 引き継ぎデータの取得
        SyokanbaraihishikyushinseiketteParameter par = new SyokanbaraihishikyushinseiketteParameter(
                new HihokenshaNo("000000033"),
                new FlexibleYearMonth(new RString("200501")),
                new RString("0000000003"),
                new JigyoshaNo("0000000003"),
                new RString("0003"),
                new RString("0003"),
                new RString("10"));
        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, par);
        SyokanbaraihishikyushinseiketteParameter paramter = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                SyokanbaraihishikyushinseiketteParameter.class);
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
//        JigyoshaNo 事業者番号 = paramter.getJigyoshaNo();
//        RString 様式番号 = paramter.getYoshikiNo();
        RString 明細番号 = paramter.getMeisaiNo();
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.整理番号, 整理番号);
        SikibetuNokennsakuki key = new SikibetuNokennsakuki(new RString("0003"),
                new FlexibleYearMonth(new RString("200501")));
        ViewStateHolder.put(ViewStateKeys.識別番号検索キー, key);
        ViewStateHolder.put(ViewStateKeys.申請日, new RDate("20151129"));
//        RDate 申請日 = ViewStateHolder.get(ViewStateKeys.申請日, RDate.class);
        // 介護宛名情報のデータを取得する。
        // 介護資格系基本情報のデータを取得する。
        // 親画面の情報により、償還払い決定一覧を設定する
        div.getCcdShokanbaraiketteiJoho().loadInitialize(被保険者番号, サービス年月, 明細番号, 明細番号, 明細番号);
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
//            BusinessConfig.get(ConfigNameBCA.申告書_住所印字区分, SubGyomuCode.BCA法人住民税);
            RString 償還 = BusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還, SubGyomuCode.DBC介護給付);
            if (new RString("受託あり").equals(償還)) {
                div.getPanelTwo().getBtnShokanbariKeteiInfo().setDisabled(true);
            }
            div.getPanelTwo().getBtnKouza().setDisabled(true);
            div.getPanelTwo().getTxtShoriMode().setValue(新規);
        }
        if (修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            div.getPanelTwo().getBtnKouza().setDisabled(true);
            div.getPanelTwo().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.wareki()
                    .toDateString().toString()));
            div.getPanelTwo().getTxtSeiriBango().setValue(整理番号);
            div.getPanelTwo().getTxtShoriMode().setValue(修正);
        }
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
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
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        if (登録.equals(画面モード)) {
//            ViewStateHolder.put(ViewStateKeys.画面モード, 修正);
            return ResponseData.of(div).respond();
        } else {
//            ViewStateHolder.put(ViewStateKeys.画面モード, 画面モード);
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
//        IStateEnumerations 画面モード = ViewStateHolder.get(ViewStateKeys.状態, IStateEnumerations.class);
//        ViewStateHolder.put(ViewStateKeys.画面モード, 画面モード);
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
        // TODO　チェック処理
        getHandler(div).putViewState();
//        ViewStateHolder.put(ViewStateKeys.画面モード, 画面モード);
        return ResponseData.of(div).respond();
    }

//    public ResponseData<ShokanbarayiKeteiInfoPanelDiv> onClick_btnShokanbariKeteiInfo(
//            ShokanbarayiKeteiInfoPanelDiv div) {
//        return ResponseData.of(div).respond();
//    }
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
//                getHandler(div).内容の破棄();
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
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("Element1"), false);
        return ResponseData.of(div).respond();
    }

    private ShokanbarayiKeteiInfoPanelHandler getHandler(ShokanbarayiKeteiInfoPanelDiv div) {
        return ShokanbarayiKeteiInfoPanelHandler.of(div);
    }
}
