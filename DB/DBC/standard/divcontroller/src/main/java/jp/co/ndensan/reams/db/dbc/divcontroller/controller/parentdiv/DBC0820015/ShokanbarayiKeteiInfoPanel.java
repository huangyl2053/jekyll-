/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820015;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraikettejoho.KetteJoho;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.ShokanbaraiketteiJoho.dgSyokanbaraikete_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820015.DBC0820015StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820015.DBC0820015TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820015.ShokanbarayiKeteiInfoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820015.ShokanbarayiKeteiInfoPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.SikibetuNokennsakuki;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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

/**
 * 償還払い費支給申請決定_償還払決定情報
 *
 * @reamsid_L DBC-1030-180 xuhao
 */
public class ShokanbarayiKeteiInfoPanel {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 申請を保存する = new RString("Element3");
    private static final RString 申請を削除する = new RString("btnDelete");
    private static final RString 証明書 = new RString("証明書");
    private static final int 定数_0 = 0;
    private static final int 定数_6 = 6;

    /**
     * onLoad
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShokanbarayiKeteiInfoPanelDiv> onLoad(ShokanbarayiKeteiInfoPanelDiv div) {
        ShoukanharaihishinseikensakuParameter paramter = ViewStateHolder.get(ViewStateKeys.申請検索キー,
                ShoukanharaihishinseikensakuParameter.class);
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.整理番号, 整理番号);
        SikibetuNokennsakuki sikibetuKey = new SikibetuNokennsakuki(paramter.getYoshikiNo(),
                paramter.getServiceTeikyoYM());
        ViewStateHolder.put(ViewStateKeys.識別番号検索キー, sikibetuKey);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        div.getPanelOne().getCcdKaigoAtenaInfo().initialize(識別コード);
        if (!被保険者番号.isEmpty()) {
            div.getPanelOne().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        } else {
            div.getPanelOne().getCcdKaigoShikakuKihon().setVisible(false);
        }
        div.getPanelTwo().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.wareki().toDateString().toString()));
        div.getPanelTwo().getTxtSeiriBango().setValue(整理番号);
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        getHandler(div).initialize(被保険者番号, サービス年月, 整理番号, 画面モード);
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.画面モード, RString.class))) {
            return ResponseData.of(div).setState(DBC0820015StateName.削除モード);
        }
        List<dgSyokanbaraikete_Row> 決定情報登録_償還払決定一覧 = div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv()
                .getDgSyokanbaraikete().getDataSource();
        KetteJoho 決定情報 = ViewStateHolder.get(ViewStateKeys.決定情報, KetteJoho.class);
        Map<RString, Integer> map_Row = new HashMap<>();
        for (dgSyokanbaraikete_Row list : 決定情報登録_償還払決定一覧) {
            map_Row.put(list.getNo(), list.getSagakuKingaku().getValue().intValue());
        }
        ViewStateHolder.put(ViewStateKeys.償還払決定一覧情報, (Serializable) map_Row);
        ViewStateHolder.put(ViewStateKeys.登録用決定情報, 決定情報);
        ViewStateHolder.put(ViewStateKeys.前回支払金額, div.getCcdShokanbaraiketteiJoho()
                .getShokanbaraiketteiJohoDiv().getTxtShiharaikingakugoke().getValue());
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnShinsei
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShokanbarayiKeteiInfoPanelDiv> onClick_btnShinsei(ShokanbarayiKeteiInfoPanelDiv div) {
        putViewState(div);
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        if (登録.equals(画面モード)) {
            ViewStateHolder.put(ViewStateKeys.画面モード, 修正);
            return ResponseData.of(div).forwardWithEventName(DBC0820015TransitionEventName.申請情報).respond();
        } else {
            ViewStateHolder.put(ViewStateKeys.画面モード, 画面モード);
            return ResponseData.of(div).forwardWithEventName(DBC0820015TransitionEventName.申請情報).respond();
        }
    }

    /**
     * onClick_btnKouza
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShokanbarayiKeteiInfoPanelDiv> onClick_btnKouza(ShokanbarayiKeteiInfoPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0820015TransitionEventName.口座情報).respond();
    }

    /**
     * onClick_btnServiceTeikyoShomeisyo
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShokanbarayiKeteiInfoPanelDiv> onClick_btnServiceTeikyoShomeisyo(
            ShokanbarayiKeteiInfoPanelDiv div) {
        ShoukanharaihishinseikensakuParameter paramter = ViewStateHolder.get(ViewStateKeys.申請検索キー,
                ShoukanharaihishinseikensakuParameter.class);
        if (getHandler(div).isチェック処理(paramter)) {
            putViewState(div);
            return ResponseData.of(div).forwardWithEventName(DBC0820015TransitionEventName.サービス提供証明書).respond();
        } else {
            throw new ApplicationException(UrErrorMessages.既に登録済.getMessage().replace(証明書.toString()));
        }
    }

    /**
     * onClick_CommonCancel
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShokanbarayiKeteiInfoPanelDiv> onClick_CommonCancel(ShokanbarayiKeteiInfoPanelDiv div) {
        ShoukanharaihishinseikensakuParameter paramter = ViewStateHolder.get(ViewStateKeys.申請検索キー,
                ShoukanharaihishinseikensakuParameter.class);
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.画面モード, RString.class))) {
            return ResponseData.of(div).forwardWithEventName(DBC0820015TransitionEventName.一覧に戻る).respond();
        }
        Map<RString, Integer> 償還払決定一覧 = ViewStateHolder.get(ViewStateKeys.償還払決定一覧情報, Map.class);
        KetteJoho 決定情報 = ViewStateHolder.get(ViewStateKeys.登録用決定情報, KetteJoho.class);
        boolean flag = getHandler(div).get内容変更状態(償還払決定一覧, 決定情報);
        if (flag) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
                getHandler(div).initialize(被保険者番号, サービス年月, 整理番号, 画面モード);
                return ResponseData.of(div).forwardWithEventName(DBC0820015TransitionEventName.一覧に戻る).respond();
            } else {
                return ResponseData.of(div).respond();
            }
        } else {
            return ResponseData.of(div).forwardWithEventName(DBC0820015TransitionEventName.一覧に戻る).respond();
        }
    }

    /**
     * onClick_CommonSave
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShokanbarayiKeteiInfoPanelDiv> onClick_CommonSave(ShokanbarayiKeteiInfoPanelDiv div) {
        Map<RString, Integer> 償還払決定一覧 = ViewStateHolder.get(ViewStateKeys.償還払決定一覧情報, Map.class);
        KetteJoho 決定情報 = ViewStateHolder.get(ViewStateKeys.登録用決定情報, KetteJoho.class);
        boolean flag = getHandler(div).get内容変更状態(償還払決定一覧, 決定情報);
        try {
            if (flag) {
                if (!ResponseHolder.isReRequest()) {
                    ShoukanharaihishinseikensakuParameter paramter = ViewStateHolder.get(ViewStateKeys.申請検索キー,
                            ShoukanharaihishinseikensakuParameter.class);
                    Decimal 支払金額合計初期 = ViewStateHolder.get(ViewStateKeys.前回支払金額, Decimal.class);
                    RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
                    ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
                    getHandler(div).登録Save(paramter, 支払金額合計初期, 画面モード, 識別コード);
                    return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage()
                            .replace(登録.toString())).respond();
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
        } catch (Exception e) {
            e.toString();
            throw new ApplicationException(UrErrorMessages.異常終了.getMessage());
        }
    }

    /**
     * onClick_CommonDelete
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShokanbarayiKeteiInfoPanelDiv> onClick_CommonDelete(ShokanbarayiKeteiInfoPanelDiv div) {
        try {
            if (!ResponseHolder.isReRequest()) {
                ShoukanharaihishinseikensakuParameter paramter = ViewStateHolder.get(ViewStateKeys.申請検索キー,
                        ShoukanharaihishinseikensakuParameter.class);
                ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
                getHandler(div).削除Save(paramter, 識別コード);
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage()
                        .replace(削除.toString())).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を削除する, true);
                return ResponseData.of(div).respond();
            }
            return ResponseData.of(div).respond();
        } catch (Exception e) {
            e.toString();
            throw new ApplicationException(UrErrorMessages.異常終了.getMessage());
        }
    }

    private ShokanbarayiKeteiInfoPanelHandler getHandler(ShokanbarayiKeteiInfoPanelDiv div) {
        return ShokanbarayiKeteiInfoPanelHandler.of(div);
    }

    private void putViewState(ShokanbarayiKeteiInfoPanelDiv div) {
        FlexibleYearMonth サービス提供年月 = null;
        RString 整理番号 = null;
        if (div.getPanelTwo().getTxtServiceTeikyoYM().getValue() != null) {
            サービス提供年月 = new FlexibleYearMonth(div.getPanelTwo().getTxtServiceTeikyoYM().getValue().toDateString()
                    .substring(定数_0, 定数_6));
        }
        if (div.getPanelTwo().getTxtSeiriBango().getValue() != null) {
            整理番号 = div.getPanelTwo().getTxtSeiriBango().getValue();
        }

        ShoukanharaihishinseikensakuParameter paramter = new ShoukanharaihishinseikensakuParameter(
                ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                サービス提供年月,
                整理番号, null, null, null, null);
        ViewStateHolder.put(ViewStateKeys.申請検索キー, paramter);
    }
}
