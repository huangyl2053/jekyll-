/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0820028;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShoteiShikkanShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820028.DBC0820028TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820028.KinkyujiShoteiShikanPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820028.dgdKinkyujiShoteiList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820028.KinkyujiShoteiShikanPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SikibetuNokennsakuki;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患）画面クラスです
 */
public class KinkyujiShoteiShikanPanel {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 登録_削除 = new RString("登録_削除");
    private static final RString 申請を保存する = new RString("Element1");

    /**
     * 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面初期化
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onLoad(KinkyujiShoteiShikanPanelDiv div) {
//        ViewStateHolder.put(ViewStateKeys.処理モード, 削除);
        ServiceTeiKyoShomeishoParameter parameter = new ServiceTeiKyoShomeishoParameter(
                new HihokenshaNo("000000003"), new FlexibleYearMonth(new RString("201601")),
                new RString("0000000003"), new JigyoshaNo("0000000003"), new RString("0003"),
                new RString("0003"), new RString("0035"));
        ViewStateHolder.put(ViewStateKeys.償還払費申請明細検索キー, parameter);

        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();

        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        RString 明細番号 = parameter.getMeisaiNo();
        RString 証明書 = parameter.getServiceYM();

        // TODO 申請書検索ViewSate．様式番号
        ViewStateHolder.put(ViewStateKeys.様式番号, new RString("0003"));
        RString 様式番号 = ViewStateHolder.get(
                ViewStateKeys.様式番号, RString.class);

        ViewStateHolder.put(ViewStateKeys.申請日, new RDate("20151123"));
        RDate 申請日 = ViewStateHolder.get(ViewStateKeys.申請日, RDate.class);

        //介護宛名情報」共有子Divの初期化
        ShikibetsuCode 識別コード = new ShikibetsuCode("000000000000010");
        div.getPanelCcd().getCcdKaigoAtenaInfo().onLoad(識別コード);
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            //介護資格系基本情報」共有子Div の初期化
            div.getPanelCcd().getCcdKaigoShikakuKihon().onLoad(被保険者番号);
        } else {
            div.getPanelCcd().getCcdKaigoAtenaInfo().setVisible(false);
        }

        getHandler(div).initPanelHead(サービス年月, 申請日, 事業者番号, 明細番号, 証明書, 様式番号);
        //緊急時・所定疾患一覧を取得する
        ShokanbaraiJyokyoShokai finder = ShokanbaraiJyokyoShokai.createInstance();
        ArrayList<ShokanShoteiShikkanShisetsuRyoyo> list = (ArrayList<ShokanShoteiShikkanShisetsuRyoyo>) finder.
                getShoteiShikanShisetsuRyoyohiEtcData(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
        getHandler(div).initDgdKinkyujiShoteiList(list);
        ViewStateHolder.put(ViewStateKeys.償還払請求所定疾患施設療養費等データ, list);

        SikibetuNokennsakuki key = new SikibetuNokennsakuki(new RString("1113"),
                new FlexibleYearMonth(new RString("200501")));
        ViewStateHolder.put(ViewStateKeys.識別番号検索キー, key);
        SikibetuNokennsakuki kennsakuki = ViewStateHolder.get(ViewStateKeys.識別番号検索キー,
                SikibetuNokennsakuki.class);
        ShikibetsuNoKanri 識別番号管理情報 = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                .getShikibetsuNoKanri(kennsakuki.getServiceTeikyoYM(), kennsakuki.getSikibetuNo());
        if (識別番号管理情報 != null) {
            getHandler(div).getボタンを制御(識別番号管理情報);
        } else {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }

        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            div.getBtnAdd().setDisabled(true);
            div.getDgdKinkyujiShoteiList().setReadOnly(true);
            div.getPanelDetail().setDisplayNone(true);
            ViewStateHolder.put(ViewStateKeys.状態, new RString(""));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 基本情報
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnKihonInfo(KinkyujiShoteiShikanPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 給付費明細
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnKyufuhiMeisai(KinkyujiShoteiShikanPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 特定診療費
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnTokuteiShinryohi(KinkyujiShoteiShikanPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * サービス計画費
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnServiceKeikakuhi(KinkyujiShoteiShikanPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 特定入所者費用
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnTokuteiNyushosya(KinkyujiShoteiShikanPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計情報
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnGoukeiInfo(KinkyujiShoteiShikanPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 給付費明細(住所地特例)
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnKyufuhiMeisaiJyuchi(
            KinkyujiShoteiShikanPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 緊急時施設療養費
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnKinkyujiShisetsuRyoyohi(
            KinkyujiShoteiShikanPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 食事費用
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnShokujiHiyo(KinkyujiShoteiShikanPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 請求額集計
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnSeikyugakuShukei(
            KinkyujiShoteiShikanPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 社福軽減額
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnShafukukeigenGaku(
            KinkyujiShoteiShikanPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 追加する
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnAdd(
            KinkyujiShoteiShikanPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, 登録);
        getHandler(div).initAdd();
        return ResponseData.of(div).respond();
    }

    /**
     * 修正ボタン
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnDgdModify(
            KinkyujiShoteiShikanPanelDiv div) {
        div.getPanelDetail().setDisplayNone(false);
        div.setRowId(new RString(String.valueOf(div.getDgdKinkyujiShoteiList().getClickedRowId())));
        dgdKinkyujiShoteiList_Row row = div.getDgdKinkyujiShoteiList().getClickedItem();
        getHandler(div).set登録(row);
        if (RowState.Added.equals(row.getRowState())) {
            ViewStateHolder.put(ViewStateKeys.状態, 登録);
        } else {
            ViewStateHolder.put(ViewStateKeys.状態, 修正);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 削除ボタン
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnDgdDelete(
            KinkyujiShoteiShikanPanelDiv div) {
        div.getPanelDetail().setDisplayNone(false);
        div.setRowId(new RString(String.valueOf(div.getDgdKinkyujiShoteiList().getClickedRowId())));
        dgdKinkyujiShoteiList_Row row = div.getDgdKinkyujiShoteiList().getClickedItem();
        getHandler(div).set登録(row);
        if (RowState.Added.equals(row.getRowState())) {
            ViewStateHolder.put(ViewStateKeys.状態, 登録_削除);
        } else {
            ViewStateHolder.put(ViewStateKeys.状態, 削除);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 計算する①
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnCal1(KinkyujiShoteiShikanPanelDiv div) {
        getHandler(div).cal1();
        return ResponseData.of(div).respond();
    }

    /**
     * 計算する②
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnCal2(KinkyujiShoteiShikanPanelDiv div) {
        getHandler(div).cal2();
        return ResponseData.of(div).respond();
    }

    /**
     * 計算する③
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnCal3(KinkyujiShoteiShikanPanelDiv div) {
        getHandler(div).cal3();
        return ResponseData.of(div).respond();
    }

    /**
     * クリアする
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnClear(KinkyujiShoteiShikanPanelDiv div) {
        getHandler(div).clear登録();
        return ResponseData.of(div).respond();
    }

    /**
     * 取消する
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnCancel(KinkyujiShoteiShikanPanelDiv div) {
        div.getBtnAdd().setDisabled(false);
        div.getPanelDetail().setDisplayNone(true);
        getHandler(div).clear登録();
        return ResponseData.of(div).respond();
    }

    /**
     * 確定する
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnConfirm(KinkyujiShoteiShikanPanelDiv div) {
        div.getBtnAdd().setDisabled(false);
        div.getPanelDetail().setDisplayNone(true);

        List<dgdKinkyujiShoteiList_Row> list = div.getDgdKinkyujiShoteiList().getDataSource();

        if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            dgdKinkyujiShoteiList_Row row = new dgdKinkyujiShoteiList_Row();
            getHandler(div).confirm(row);
            list.add(row);
        } else if (登録_削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            dgdKinkyujiShoteiList_Row row = getHandler(div).getSelectedRow();
            getHandler(div).confirm(row);
        } else {
            dgdKinkyujiShoteiList_Row row = getHandler(div).getSelectedRow();
            getHandler(div).confirm(row);
            list.set(Integer.parseInt(div.getRowId().toString()), row);
        }
        div.getDgdKinkyujiShoteiList().setDataSource(list);
        return ResponseData.of(div).respond();
    }

    /**
     * 申請を保存する
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnSave(KinkyujiShoteiShikanPanelDiv div) {
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            if (!ResponseHolder.isReRequest()) {
                getHandler(div).保存処理();
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().
                        replace(削除.toString())).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, true);
                return createResponse(div);
            }
        } else {
            boolean flag = getHandler(div).get内容変更状態();
            if (flag) {
                return 保存(div);
            } else {
                return 内容変更なしで(div);
            }
        }
        return ResponseData.of(div).addMessage(UrErrorMessages.異常終了.getMessage()).respond();
    }

    private ResponseData<KinkyujiShoteiShikanPanelDiv> 保存(KinkyujiShoteiShikanPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            getHandler(div).保存処理();
            return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().
                    replace(登録.toString())).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, true);
            return createResponse(div);
        }
        return createResponse(div);
    }

    private ResponseData<KinkyujiShoteiShikanPanelDiv> 内容変更なしで(KinkyujiShoteiShikanPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return createResponse(div);
        }
        return createResponse(div);
    }

    /**
     * 共通エリア_取消する
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時・所定疾患)画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanPanelDiv> onClick_btnFree(KinkyujiShoteiShikanPanelDiv div) {
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            // TODO 償還払支給申請_サービス提供証明書画面へ遷移する。
            return ResponseData.of(div).forwardWithEventName(DBC0820028TransitionEventName.サービス計画費)
                    .parameter(new RString("サービス計画費"));
        }
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
                return ResponseData.of(div).forwardWithEventName(DBC0820028TransitionEventName.サービス計画費)
                        .parameter(new RString("サービス計画費"));
            } else {
                ResponseData.of(div).respond();
            }
        } else {
            // TODO 償還払支給申請_サービス提供証明書画面へ遷移する。
            return ResponseData.of(div).forwardWithEventName(DBC0820028TransitionEventName.サービス計画費)
                    .parameter(new RString("サービス計画費"));
        }
        return ResponseData.of(div).respond();
    }

    private KinkyujiShoteiShikanPanelHandler getHandler(KinkyujiShoteiShikanPanelDiv div) {
        return KinkyujiShoteiShikanPanelHandler.of(div);
    }

    private ResponseData<KinkyujiShoteiShikanPanelDiv> createResponse(KinkyujiShoteiShikanPanelDiv div) {
        return ResponseData.of(div).respond();
    }

}
