/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0820023;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryoTokubetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryohi;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820023.DBC0820023TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820023.TokuteiShinryohiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820023.ddgToteishinryoTokubetushinryo_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820023.dgdTokuteiShinryohi_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820023.TokuteiShinryohiPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SikibetuNokennsakuki;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SyokanbaraihishikyushinseiketteParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 償還払い費支給申請決定_サービス提供証明書(特定診療費）のクラスです。
 */
public class TokuteiShinryohiPanel {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final FlexibleYearMonth 平成１５年３月 = new FlexibleYearMonth("200303");
    private static final FlexibleYearMonth 平成１５年４月 = new FlexibleYearMonth("200304");
    private static final RString 申請を保存する = new RString("Element3");

    /**
     * 画面初期化
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onLoad(TokuteiShinryohiPanelDiv div) {

        SyokanbaraihishikyushinseiketteParameter par = new SyokanbaraihishikyushinseiketteParameter(
                new HihokenshaNo("000000003"),
                new FlexibleYearMonth(new RString("200501")),
                new RString("0000000003"),
                new JigyoshaNo("0000000003"),
                new RString("2165"),
                new RString("0003"),
                new RString("10"));
        ViewStateHolder.put(ViewStateKeys.償還払費申請明細検索キー, par);
        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, par);
        SyokanbaraihishikyushinseiketteParameter paramter = ViewStateHolder.get(ViewStateKeys.償還払費申請明細検索キー,
                SyokanbaraihishikyushinseiketteParameter.class);
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        JigyoshaNo 事業者番号 = paramter.getJigyoshaNo();
        RString 様式番号 = paramter.getYoshikiNo();
        RString 明細番号 = paramter.getMeisaiNo();
        ViewStateHolder.put(ViewStateKeys.サービス年月, サービス年月);
        ViewStateHolder.put(ViewStateKeys.様式番号, 様式番号);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.整理番号, 整理番号);
        ViewStateHolder.put(ViewStateKeys.明細番号, 明細番号);
        SikibetuNokennsakuki key = new SikibetuNokennsakuki(new RString("0003"),
                new FlexibleYearMonth(new RString("200501")));
        ViewStateHolder.put(ViewStateKeys.識別番号検索キー, key);
        RString 申請日 = new RString("20151124");

        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode("000000000000010"));
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        div.getPanelOne().getCcdKaigoAtenaInfo().onLoad(識別コード);
        if (!被保険者番号.isEmpty()) {
            div.getPanelOne().getCcdKaigoShikakuKihon().onLoad(被保険者番号);
        } else {
            div.getPanelOne().getCcdKaigoShikakuKihon().setVisible(false);
        }
        getHandler(div).set申請共通エリア(サービス年月, 事業者番号, 申請日, 明細番号, 様式番号);

        if (サービス年月.isBeforeOrEquals(平成１５年３月)) {
            div.getDgdTokuteiShinryohi().setDisplayNone(true);
            div.getDdgToteishinryoTokubetushinryo().setVisible(true);
            div.getPanelFour().setVisible(false);
            div.getPanelFive().setDisplayNone(true);
            ArrayList<ShokanTokuteiShinryohi> shokanTokuteiShinryohiList = new ArrayList<>();
            if (明細番号 != null && !明細番号.isEmpty()) {
                shokanTokuteiShinryohiList = (ArrayList<ShokanTokuteiShinryohi>) ShokanbaraiJyokyoShokai.createInstance()
                        .getTokuteiShinryohiData(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
                isEmpty特定診療費データ(shokanTokuteiShinryohiList);
            }
            getHandler(div).set特定診療費一覧グリッド(shokanTokuteiShinryohiList);
            ViewStateHolder.put(ViewStateKeys.償還払請求特定診療費データ, shokanTokuteiShinryohiList);
        }
        if (平成１５年４月.isBeforeOrEquals(サービス年月)) {
            div.getDgdTokuteiShinryohi().setVisible(true);
            div.getDdgToteishinryoTokubetushinryo().setDisplayNone(true);
            div.getPanelFour().setDisplayNone(true);
            div.getPanelFive().setVisible(false);
            ArrayList<ShokanTokuteiShinryoTokubetsuRyoyo> shokanTokuteiShinryoTokubetsuRyoyoList = new ArrayList<>();
            if (明細番号 != null && !明細番号.isEmpty()) {
                shokanTokuteiShinryoTokubetsuRyoyoList
                        = (ArrayList<ShokanTokuteiShinryoTokubetsuRyoyo>) ShokanbaraiJyokyoShokai.createInstance()
                        .getTokuteyiShinnryouhiTokubeturyoyohi(被保険者番号, サービス年月, 整理番号, 事業者番号,
                                様式番号, 明細番号, null);
                isEmpty特別療養費一覧(shokanTokuteiShinryoTokubetsuRyoyoList);
            }
            getHandler(div).set特定診療費_特別診療費一覧グリッド(shokanTokuteiShinryoTokubetsuRyoyoList);
            ViewStateHolder.put(ViewStateKeys.償還払請求特定診療費_特別療養費一覧, shokanTokuteiShinryoTokubetsuRyoyoList);
        }
        SikibetuNokennsakuki kennsakuki = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, SikibetuNokennsakuki.class);
        ShikibetsuNoKanri shikibetsuNoKanri = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                .getShikibetsuNoKanri(kennsakuki.getServiceTeikyoYM(), kennsakuki.getSikibetuNo());
        if (shikibetsuNoKanri == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        }
        getHandler(div).getボタンを制御(shikibetsuNoKanri);
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            div.getPanelThree().setDisabled(true);
        }
        return createResponse(div);
    }

    private void isEmpty特別療養費一覧(ArrayList<ShokanTokuteiShinryoTokubetsuRyoyo> entityList) {
        if (entityList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        }
    }

    private void isEmpty特定診療費データ(ArrayList<ShokanTokuteiShinryohi> entityList) {
        if (entityList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        }
    }

    /**
     * 追加ボタンする
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnAdd(TokuteiShinryohiPanelDiv div) {
        FlexibleYearMonth サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        if (サービス年月.isBeforeOrEquals(平成１５年３月)) {
            div.getPanelFour().setVisible(true);
            getHandler(div).readOnly特定診療費登録(false);
            getHandler(div).clear特定診療費登録();
        }
        if (平成１５年４月.isBeforeOrEquals(サービス年月)) {
            div.getPanelFive().setVisible(true);
            getHandler(div).readOnly特定診療費_特別診療費登録(false);
            getHandler(div).clear特定診療費_特別診療費登録();
        }
        ViewStateHolder.put(ViewStateKeys.状態, 登録);
        return createResponse(div);
    }

    /**
     * グリッド(平成１５年３月以前)エリアの修正ボタン
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_ddgModify(TokuteiShinryohiPanelDiv div) {
        div.getPanelFour().setVisible(true);
        getHandler(div).readOnly特定診療費登録(false);
        getHandler(div).clear特定診療費登録();
        ddgToteishinryoTokubetushinryo_Row row = div.getDdgToteishinryoTokubetushinryo().getClickedItem();
        getHandler(div).set特定診療費登録(row);
        ViewStateHolder.put(ViewStateKeys.状態, 修正);
        return createResponse(div);
    }

    /**
     * グリッド(平成１５年３月以前)エリアの削除ボタン
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_ddgDelete(TokuteiShinryohiPanelDiv div) {
        div.getPanelFour().setVisible(true);
        getHandler(div).readOnly特定診療費登録(true);
        getHandler(div).clear特定診療費登録();
        ddgToteishinryoTokubetushinryo_Row row = div.getDdgToteishinryoTokubetushinryo().getClickedItem();
        getHandler(div).set特定診療費登録(row);
        ViewStateHolder.put(ViewStateKeys.状態, 削除);
        return createResponse(div);
    }

    /**
     * グリッド(平成１５年４月以降)の修正ボタン
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_dgdModify(TokuteiShinryohiPanelDiv div) {
        div.getPanelFive().setVisible(true);
        getHandler(div).readOnly特定診療費_特別診療費登録(false);
        getHandler(div).clear特定診療費_特別診療費登録();
        dgdTokuteiShinryohi_Row row = div.getDgdTokuteiShinryohi().getClickedItem();
        getHandler(div).set特定診療費_特別診療費登録(row);
        ViewStateHolder.put(ViewStateKeys.状態, 修正);
        return createResponse(div);
    }

    /**
     * グリッド(平成１５年４月以降)の削除ボタン
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_dgdDelete(TokuteiShinryohiPanelDiv div) {
        div.getPanelFive().setVisible(true);
        getHandler(div).readOnly特定診療費_特別診療費登録(true);
        getHandler(div).clear特定診療費_特別診療費登録();
        dgdTokuteiShinryohi_Row row = div.getDgdTokuteiShinryohi().getClickedItem();
        getHandler(div).set特定診療費_特別診療費登録(row);
        ViewStateHolder.put(ViewStateKeys.状態, 削除);
        return createResponse(div);
    }

    /**
     * 特定診療費登録エリアの「計算する」ボタン
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnKeisan(TokuteiShinryohiPanelDiv div) {
        getHandler(div).click計算結果();
        return createResponse(div);
    }

    /**
     * 特定診療費登録エリアの「クリアする」ボタン
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnClear(TokuteiShinryohiPanelDiv div) {
        getHandler(div).clear特定診療費登録();
        return createResponse(div);
    }

    /**
     * 特定診療費登録エリアの「取消する」ボタン
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnCancel(TokuteiShinryohiPanelDiv div) {
        getHandler(div).clear特定診療費登録();
        div.getPanelFour().setVisible(false);
        return createResponse(div);
    }

    /**
     * 特定診療費登録エリアの「確定する」ボタン
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnConfirm(TokuteiShinryohiPanelDiv div) {
        ddgToteishinryoTokubetushinryo_Row ddgRow;
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            ddgRow = new ddgToteishinryoTokubetushinryo_Row();
        } else {
            ddgRow = getHandler(div).getSelectedRow();
        }
        getHandler(div).modifyRow(ddgRow);
        return createResponse(div);
    }

    /**
     * 特定診療費・特別診療費登録エリアの「計算する」ボタン
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnCal(TokuteiShinryohiPanelDiv div) {
        getHandler(div).click計算結果2();
        return createResponse(div);
    }

    /**
     * 特定診療費・特別診療費登録エリアの「クリアする」ボタン
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnClear2(TokuteiShinryohiPanelDiv div) {
        getHandler(div).clear特定診療費_特別診療費登録();
        return createResponse(div);
    }

    /**
     * 特定診療費・特別診療費登録エリアの「取消する」ボタン
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnCancel2(TokuteiShinryohiPanelDiv div) {
        getHandler(div).clear特定診療費_特別診療費登録();
        div.getPanelFive().setVisible(false);
        return createResponse(div);
    }

    /**
     * 特定診療費・特別診療費登録エリアの「確定する」ボタン
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnConfirm2(TokuteiShinryohiPanelDiv div) {
        dgdTokuteiShinryohi_Row row;
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            row = new dgdTokuteiShinryohi_Row();
        } else {
            row = getHandler(div).getSelectedRow2();
        }
        getHandler(div).modifyRow2(row);
        return createResponse(div);
    }

    /**
     * 共通エリア「取消する」ボタン
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnFree(TokuteiShinryohiPanelDiv div) {
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            return ResponseData.of(div).forwardWithEventName(DBC0820023TransitionEventName.一覧に戻る).respond();
        }
        FlexibleYearMonth サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        boolean flag = getHandler(div).get内容変更状態(サービス年月);
        if (flag) {
            return clear入力内容(div);
        } else {
            return ResponseData.of(div).forwardWithEventName(DBC0820023TransitionEventName.一覧に戻る).respond();
        }
    }

    private ResponseData<TokuteiShinryohiPanelDiv> clear入力内容(TokuteiShinryohiPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBC0820023TransitionEventName.一覧に戻る).respond();
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 「申請を保存する」ボタン
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnSave(TokuteiShinryohiPanelDiv div) {
        FlexibleYearMonth サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            if (!ResponseHolder.isReRequest()) {
                getHandler(div).保存処理();
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage()
                        .replace(削除.toString())).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, true);
                return createResponse(div);
            }
        } else {
            boolean flag = getHandler(div).get内容変更状態(サービス年月);
            if (flag) {
                return 保存処理(div);
            } else {
                return saveOut(div);
            }
        }
        return ResponseData.of(div).addMessage(UrErrorMessages.異常終了.getMessage()).respond();
    }

    private ResponseData<TokuteiShinryohiPanelDiv> saveOut(TokuteiShinryohiPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return createResponse(div);
        }
        return createResponse(div);
    }

    private ResponseData<TokuteiShinryohiPanelDiv> 保存処理(TokuteiShinryohiPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            RString 明細番号 = getHandler(div).保存処理();
            div.getPanelTwo().getTxtMeisaibango().setValue(明細番号);
            return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage()
                    .replace(登録.toString())).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, true);
            return createResponse(div);
        }
        return createResponse(div);
    }

    private TokuteiShinryohiPanelHandler getHandler(TokuteiShinryohiPanelDiv div) {
        return new TokuteiShinryohiPanelHandler(div);
    }

    private ResponseData<TokuteiShinryohiPanelDiv> createResponse(TokuteiShinryohiPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「基本情報」ボタン
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnKihoninfo(TokuteiShinryohiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「給付費明細」ボタン
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnKyufuMeisai(TokuteiShinryohiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「サービス計画費」ボタン
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnServiceKeikakuhi(TokuteiShinryohiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「特定入所者費用」ボタン
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnTokuteinyushosha(TokuteiShinryohiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「合計情報」ボタン
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnGokeiinfo(TokuteiShinryohiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「給付費明細（住特）」ボタン
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnKyufuhiMeisaiJutoku(TokuteiShinryohiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「緊急時・所定疾患」ボタン
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnKinkyujiShoteiShikan(TokuteiShinryohiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「緊急時施設療養費」ボタン
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnKinkyujiShisetsu(TokuteiShinryohiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「食事費用」ボタン
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnShokujihiyo(TokuteiShinryohiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「請求額集計」ボタン
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnSeikyugaku(TokuteiShinryohiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「社福軽減額」ボタン
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnShafuku(TokuteiShinryohiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「識別コード入力補助ボタン」ボタン
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onBeforeOpenDialog_btnJigyosha(TokuteiShinryohiPanelDiv div) {
        FlexibleYearMonth サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        RString 識別コード = div.getPanelFive().getTxtShikibetsuCode().getValue();
        div.setHiddenYoshikiNo(DataPassingConverter.serialize(ViewStateHolder.get(ViewStateKeys.様式番号, RString.class)));
        div.setHiddenServiceTeikyoYM(DataPassingConverter.serialize(new RString(サービス年月.toString())));
        div.setHiddenShikibetsuCode(DataPassingConverter.serialize(識別コード));
        return createResponse(div);
    }

    /**
     * onOkClose_btnJigyosha
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onOkClose_btnJigyosha(TokuteiShinryohiPanelDiv div) {
        RString hiddenSelectCode = DataPassingConverter.deserialize(div.getHiddenSelectCode(), RString.class);
        RString hiddenSelectKoumoku = DataPassingConverter.deserialize(div.getHiddenSelectKoumoku(), RString.class);
        div.getPanelFive().getTxtShikibetsuCode().setValue(hiddenSelectCode);
        div.getPanelFive().getTxtName().setValue(hiddenSelectKoumoku);
        getHandler(div).set識別項目(hiddenSelectCode);
        return createResponse(div);
    }
}
