/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820025;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiNyushoshaKaigoServiceHiyo;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820025.DBC0820025TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820025.TokuteiNyushoshaHiyoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820025.dgdTokuteiYichiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820025.TokuteiNyushoshaHiyoPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.SikibetuNokennsakuki;
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
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い費支給申請決定_サービス提供証明書(特定入所者費用）のクラスです。
 *
 * @reamsid_L DBC-1030-120 wangkanglei
 */
public class TokuteiNyushoshaHiyoPanel {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 申請を保存する = new RString("Element1");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onLoad(TokuteiNyushoshaHiyoPanelDiv div) {

        ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.get(ViewStateKeys.償還払費申請明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        HihokenshaNo 被保険者番号 = meisaiPar.get被保険者番号();
        FlexibleYearMonth サービス年月 = meisaiPar.getサービス年月();
        RString 整理番号 = meisaiPar.get整理番号();
        JigyoshaNo 事業者番号 = meisaiPar.get事業者番号();
        RString 様式番号 = meisaiPar.get様式番号();
        RString 明細番号 = meisaiPar.get明細番号();
        RDate 申請日 = meisaiPar.get申請日();
        ViewStateHolder.put(ViewStateKeys.サービス年月, サービス年月);
        ViewStateHolder.put(ViewStateKeys.様式番号, 様式番号);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.整理番号, 整理番号);
        ViewStateHolder.put(ViewStateKeys.申請年月日, 申請日);

        ShoukanharaihishinseikensakuParameter 償還払費申請検索 = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                ShoukanharaihishinseikensakuParameter.class);
        SikibetuNokennsakuki sikibetuKey = new SikibetuNokennsakuki(償還払費申請検索.getYoshikiNo(),
                償還払費申請検索.getServiceTeikyoYM());
        ViewStateHolder.put(ViewStateKeys.識別番号検索キー, sikibetuKey);

        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        div.getPanelCcd().getCcdKaigoAtenaInfo().onLoad(識別コード);
        if (!被保険者番号.isEmpty()) {
            div.getPanelCcd().getCcdKaigoShikakuKihon().onLoad(被保険者番号);
        } else {
            div.getPanelCcd().getCcdKaigoShikakuKihon().setVisible(false);
        }
        getHandler(div).set申請共通エリア(サービス年月, 事業者番号, 申請日, 明細番号, 様式番号);
        ArrayList<ShokanTokuteiNyushoshaKaigoServiceHiyo> serviceHiyoList
                = (ArrayList<ShokanTokuteiNyushoshaKaigoServiceHiyo>) ShokanbaraiJyokyoShokai.createInstance()
                .getTokuteyiNyushosyaKaigoserviceHiyo(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号,
                        null);
        getHandler(div).set特定入所者費用一覧グリッド(serviceHiyoList);
        ViewStateHolder.put(ViewStateKeys.償還払請求特定入所者介護サービス費用データ, serviceHiyoList);
        div.getPanelTokutei().getPanelMeisai().setVisible(false);

        SikibetuNokennsakuki kennsakuki = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, SikibetuNokennsakuki.class);
        ShikibetsuNoKanri shikibetsuNoKanri = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                .getShikibetsuNoKanri(kennsakuki.getServiceTeikyoYM(), kennsakuki.getSikibetuNo());
        if (shikibetsuNoKanri == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        } else {
            getHandler(div).getボタンを制御(shikibetsuNoKanri);
        }
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            div.getPanelTokutei().getBtnAdd().setDisabled(true);
            div.getPanelTokutei().getDgdTokuteiYichiran().setReadOnly(true);
        }
        return createResponse(div);
    }

    /**
     * 追加ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnAdd(TokuteiNyushoshaHiyoPanelDiv div) {
        div.getPanelTokutei().getPanelMeisai().setVisible(true);
        getHandler(div).readOnly特定入所者費登録エリア(false);
        ViewStateHolder.put(ViewStateKeys.状態, 登録);
        getHandler(div).clear特定入所者費登録エリア();
        return createResponse(div);
    }

    /**
     * グリッドの修正ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_dgdModify(TokuteiNyushoshaHiyoPanelDiv div) {
        div.getPanelTokutei().getPanelMeisai().setVisible(true);
        getHandler(div).readOnly特定入所者費登録エリア(false);
        getHandler(div).clear特定入所者費登録エリア();
        dgdTokuteiYichiran_Row row = div.getPanelTokutei().getDgdTokuteiYichiran().getClickedItem();
        getHandler(div).set特定入所者費登録エリア(row);
        ViewStateHolder.put(ViewStateKeys.状態, 修正);
        return createResponse(div);
    }

    /**
     * グリッドの削除ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_dgdDelete(TokuteiNyushoshaHiyoPanelDiv div) {
        div.getPanelTokutei().getPanelMeisai().setVisible(true);
        getHandler(div).readOnly特定入所者費登録エリア(true);
        getHandler(div).clear特定入所者費登録エリア();
        dgdTokuteiYichiran_Row row = div.getPanelTokutei().getDgdTokuteiYichiran().getClickedItem();
        getHandler(div).set特定入所者費登録エリア(row);
        ViewStateHolder.put(ViewStateKeys.状態, 削除);
        return createResponse(div);
    }

    /**
     * 特定入所者費登録エリアの「計算する」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnKeisan(TokuteiNyushoshaHiyoPanelDiv div) {
        getHandler(div).click計算結果();
        return createResponse(div);
    }

    /**
     * 特定入所者費登録エリアの「クリアする」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnClear(TokuteiNyushoshaHiyoPanelDiv div) {
        getHandler(div).clear特定入所者費登録エリア();
        return createResponse(div);
    }

    /**
     * 特定入所者費登録エリアの「取消する」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnCancel(TokuteiNyushoshaHiyoPanelDiv div) {
        getHandler(div).cancel特定入所者費登録エリア();
        div.getPanelTokutei().getPanelMeisai().setVisible(false);
        return createResponse(div);
    }

    /**
     * 特定入所者費登録エリアの「確定する」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnConfirm(TokuteiNyushoshaHiyoPanelDiv div) {
        dgdTokuteiYichiran_Row dgdRow;
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            dgdRow = new dgdTokuteiYichiran_Row();
        } else {
            dgdRow = getHandler(div).getSelectedRow();
        }
        getHandler(div).modifyRow(dgdRow);
        div.getPanelTokutei().getPanelMeisai().setVisible(false);
        return createResponse(div);
    }

    /**
     * 共通エリア「取消する」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnFree(TokuteiNyushoshaHiyoPanelDiv div) {
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            return ResponseData.of(div).forwardWithEventName(DBC0820025TransitionEventName.一覧に戻る).respond();
        }
        boolean flag = getHandler(div).isChange();
        if (flag) {
            return clear入力内容(div);
        } else {
            return ResponseData.of(div).forwardWithEventName(DBC0820025TransitionEventName.一覧に戻る).respond();
        }
    }

    private ResponseData<TokuteiNyushoshaHiyoPanelDiv> clear入力内容(TokuteiNyushoshaHiyoPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBC0820025TransitionEventName.一覧に戻る).respond();
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 「申請を保存する」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnSave(TokuteiNyushoshaHiyoPanelDiv div) {
        try {
            if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
                return 保存処理(div, 削除);
            } else {
                boolean flag = getHandler(div).isChange();
                if (flag) {
                    return 保存処理(div, 登録);
                } else {
                    return saveOut(div);
                }
            }
        } catch (Exception e) {
            e.toString();
            throw new ApplicationException(UrErrorMessages.異常終了.getMessage());
        }
    }

    private ResponseData<TokuteiNyushoshaHiyoPanelDiv> saveOut(TokuteiNyushoshaHiyoPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return createResponse(div);
        }
        return createResponse(div);
    }

    private ResponseData<TokuteiNyushoshaHiyoPanelDiv> 保存処理(TokuteiNyushoshaHiyoPanelDiv div, RString 状態) {
        if (!ResponseHolder.isReRequest()) {
            getHandler(div).保存処理();
            return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage()
                    .replace(状態.toString())).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, true);
            return createResponse(div);
        }
        return createResponse(div);
    }

    private TokuteiNyushoshaHiyoPanelHandler getHandler(TokuteiNyushoshaHiyoPanelDiv div) {
        return new TokuteiNyushoshaHiyoPanelHandler(div);
    }

    private ResponseData<TokuteiNyushoshaHiyoPanelDiv> createResponse(TokuteiNyushoshaHiyoPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「基本情報」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnKihoninfo(TokuteiNyushoshaHiyoPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「給付費明細」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnKyufuMeisai(TokuteiNyushoshaHiyoPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「特定診療費」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnTokuteiShinryouhi(TokuteiNyushoshaHiyoPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「サービス計画費」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnServiceKeikakuhi(TokuteiNyushoshaHiyoPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「合計情報」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnGokeiinfo(TokuteiNyushoshaHiyoPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「給付費明細（住特）」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnKyufuhiMeisaiJutoku(
            TokuteiNyushoshaHiyoPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「緊急時・所定疾患」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnKinkyujiShoteiShikan(
            TokuteiNyushoshaHiyoPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「緊急時施設療養費」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnKinkyujiShisetsu(TokuteiNyushoshaHiyoPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「食事費用」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnShokujihiyo(TokuteiNyushoshaHiyoPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「請求額集計」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnSeikyugaku(TokuteiNyushoshaHiyoPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「社福軽減額」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoPanelDiv> onClick_btnShafuku(TokuteiNyushoshaHiyoPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }
}
