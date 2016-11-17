/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820031;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShakaiFukushiHojinKeigengakuResult;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraihishikyushinseikette.ShafukukeigenServiceResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820031.DBC0820031StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820031.DBC0820031TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820031.ShafukuKeigenGakuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820031.ShafukuKeigenGakuPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseikensakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.SikibetuNokennsakuki;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShakaiFukushiHojinRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い費支給申請決定_サービス提供証明書(社福軽減額）のクラスです。
 *
 * @reamsid_L DBC-1030-080 xuhao
 */
public class ShafukuKeigenGakuPanel {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 申請を削除する = new RString("btnDelete");
    private static final RString 申請を保存する = new RString("Element1");

    /**
     * onLoad
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onLoad(ShafukuKeigenGakuPanelDiv div) {
        ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        HihokenshaNo 被保険者番号 = meisaiPar.get被保険者番号();
        FlexibleYearMonth サービス年月 = meisaiPar.getサービス年月();
        RString 整理番号 = meisaiPar.get整理番号();
        JigyoshaNo 事業者番号 = meisaiPar.get事業者番号();
        RString 様式番号 = meisaiPar.get様式番号();
        RString 明細番号 = meisaiPar.get明細番号();
        RDate 申請日 = meisaiPar.get申請日();
        ViewStateHolder.put(ViewStateKeys.サービス年月, サービス年月);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.整理番号, 整理番号);
        ShoukanharaihishinseikensakuParameter 償還払費申請検索 = ViewStateHolder.get(ViewStateKeys.申請検索キー,
                ShoukanharaihishinseikensakuParameter.class);
        SikibetuNokennsakuki sikibetuKey = new SikibetuNokennsakuki(償還払費申請検索.getYoshikiNo(),
                償還払費申請検索.getServiceTeikyoYM());
        ViewStateHolder.put(ViewStateKeys.識別番号検索キー, sikibetuKey);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        div.getPanelCcd().getCcdKaigoAtenaInfo().initialize(識別コード);
        if (!被保険者番号.isEmpty()) {
            div.getPanelCcd().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        } else {
            div.getPanelCcd().getCcdKaigoShikakuKihon().setVisible(false);
        }

        ArrayList<ShokanShakaiFukushiHojinKeigengakuResult> hojinKeigengakuEntityList
                = (ArrayList<ShokanShakaiFukushiHojinKeigengakuResult>) ShokanbaraiJyokyoShokai.createInstance()
                .getSeikyuShakaifukushiHoujinKeigengaku(
                        被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
        ViewStateHolder.put(ViewStateKeys.社福軽減額一覧情報, hojinKeigengakuEntityList);
        getHandler(div).initialize(hojinKeigengakuEntityList);
        div.getPanelHead().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.wareki().toDateString().toString()));
        div.getPanelHead().getTxtShinseiYMD().setValue(new RDate(申請日.toString()));
        div.getPanelHead().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelHead().getTxtMeisaiBango().setValue(明細番号);
        div.getPanelHead().getTxtShomeisho().setValue(様式番号);
        div.getTxtRiyoshaFutangakuTotal().setReadOnly(false);

        ArrayList<ShafukukeigenServiceResult> shokanShukeiList
                = (ArrayList<ShafukukeigenServiceResult>) SyokanbaraihiShikyuShinseiKetteManager.createInstance().
                getShafukukeigenServiceList(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        if (shokanShukeiList == null || shokanShukeiList.isEmpty()) {
            RString サービス種類meg = new RString("償還払集計情報");
            throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage()
                    .replace(サービス種類meg.toString()));
        }
        ViewStateHolder.put(ViewStateKeys.サービス種類集計情報, shokanShukeiList);
        List<KeyValueDataSource> サービス種類 = new ArrayList<>();
        サービス種類.add(new KeyValueDataSource(new RString(""), new RString("")));
        for (ShafukukeigenServiceResult entity : shokanShukeiList) {
            サービス種類.add(new KeyValueDataSource(new RString(entity.getEntity().getServiceShuruiMeisho().toString()),
                    entity.getEntity().getServiceShuruiCode().getColumnValue()));
        }
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getDdlServiceShurui().setDataSource(サービス種類);

        List<ShakaiFukushiHojinRiyoshaFutanKeigen> 軽減額List = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                .getShafukukeigenKeigenrichiList(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        if (軽減額List == null || 軽減額List.isEmpty()) {
            RString 軽減額meg = new RString("社会福祉法人等利用者負担軽減");
            throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage()
                    .replace(軽減額meg.toString()));
        }
        List<KeyValueDataSource> 軽減率 = new ArrayList<>();
        軽減率.add(new KeyValueDataSource(new RString(""), new RString("")));
        for (int i = 0; i < 軽減額List.size(); i++) {
            Decimal 軽減率分子 = 軽減額List.get(i).get軽減率分子();
            Decimal 軽減率分母 = 軽減額List.get(i).get軽減率分母();
            Decimal 軽減額 = new Decimal(0);
            if (軽減率分母 != Decimal.ZERO) {
                軽減額 = 軽減率分子.divide(軽減率分母);
            }
            軽減額 = 軽減額.roundHalfUpTo(1);
            軽減率.add(new KeyValueDataSource(new RString(Integer.toString(i)),
                    new RString(Float.toString(軽減額.floatValue()))));
        }
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getDdlKengenritsu().setDataSource(軽減率);

        SikibetuNokennsakuki kennsakuki = ViewStateHolder.get(ViewStateKeys.識別番号検索キー,
                SikibetuNokennsakuki.class);
        ShikibetsuNoKanri entity = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                .getShikibetsuNoKanri(kennsakuki.getServiceTeikyoYM(), kennsakuki.getSikibetuNo());
        if (entity == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        } else {
            getHandler(div).getボタンを制御(entity, meisaiPar);
        }
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setVisible(false);
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku().setDisabled(true);
            div.getPanelShafukukenngengaku().getBtnAdd().setDisabled(true);
            return ResponseData.of(div).setState(DBC0820031StateName.削除モード);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnAdd
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnAdd(ShafukuKeigenGakuPanelDiv div) {
        getHandler(div).initializeByCancel();
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setVisible(true);
        ViewStateHolder.put(ViewStateKeys.状態, 登録);
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_dgModify
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_dgModify(ShafukuKeigenGakuPanelDiv div) {
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setVisible(true);
        ViewStateHolder.put(ViewStateKeys.状態, 修正);
        getHandler(div).initializeByModify();
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_dgDelete
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_dgDelete(ShafukuKeigenGakuPanelDiv div) {
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setVisible(true);
        ViewStateHolder.put(ViewStateKeys.状態, 削除);
        getHandler(div).initializeByDelete();
        return ResponseData.of(div).respond();
    }

    /**
     * onChange_serviceShurui
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onChange_serviceShurui(ShafukuKeigenGakuPanelDiv div) {
        List<ShafukukeigenServiceResult> list = ViewStateHolder.get(ViewStateKeys.サービス種類集計情報, List.class);
        RString value = div.getPanelShafukukenngengaku().getDdlServiceShurui().getSelectedValue();
        for (ShafukukeigenServiceResult entity : list) {
            if (value.equals(entity.getEntity().getServiceShuruiCode().getColumnValue())) {
                div.getPanelShafukukenngengaku().getTxtRiyoshaFutangakuTotal()
                        .setValue(new Decimal(entity.getEntity().getRiyoshaFutangaku()));
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_Calculation
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_Calculation(ShafukuKeigenGakuPanelDiv div) {
        getHandler(div).initializeByCalculation();
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_Clean
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_Clean(ShafukuKeigenGakuPanelDiv div) {
        getHandler(div).initializeByClean();
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_Cancel
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_Cancel(ShafukuKeigenGakuPanelDiv div) {
        getHandler(div).initializeByCancel();
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_Confirm
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_Confirm(ShafukuKeigenGakuPanelDiv div) {
        RString state = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        getHandler(div).initializeByConfirm(state);
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_CommonCancel
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_CommonCancel(ShafukuKeigenGakuPanelDiv div) {
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.一覧に戻る).respond();
        }
        boolean flag = getHandler(div).is内容変更状態();
        if (flag) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                List<ShokanShakaiFukushiHojinKeigengakuResult> list = ViewStateHolder.get(ViewStateKeys.社福軽減額一覧情報, List.class);
                getHandler(div).内容の破棄(list);
                return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.一覧に戻る).respond();
            }
        } else {
            return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.一覧に戻る).respond();
        }
        return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.一覧に戻る).respond();
    }

    /**
     * onClick_CommonSave
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_CommonSave(ShafukuKeigenGakuPanelDiv div) {
        boolean flag = getHandler(div).is内容変更状態();
        try {
            if (flag) {
                if (!ResponseHolder.isReRequest()) {
                    ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                            ShoukanharaihishinseimeisaikensakuParameter.class);
                    List<ShokanShakaiFukushiHojinKeigengakuResult> hojinKeigengakuEntityList = ViewStateHolder.get(
                            ViewStateKeys.社福軽減額一覧情報, List.class);
                    getHandler(div).登録Save(meisaiPar, hojinKeigengakuEntityList);
                    return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage()
                            .replace(登録.toString())).respond();
                }
                if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                    CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, true);
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
     * 申請を削除する
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_CommonDelete(ShafukuKeigenGakuPanelDiv div) {
        try {
            if (!ResponseHolder.isReRequest()) {
                ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                        ShoukanharaihishinseimeisaikensakuParameter.class);
                getHandler(div).削除Save(meisaiPar);
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage()
                        .replace(削除.toString())).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を削除する, true);
            }
            return ResponseData.of(div).respond();
        } catch (Exception e) {
            e.toString();
            throw new ApplicationException(UrErrorMessages.異常終了.getMessage());
        }
    }

    /**
     * 「基本情報」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnKihoninfo(ShafukuKeigenGakuPanelDiv div) {
        putViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.基本情報).respond();
    }

    /**
     * 「給付費明細」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnKyufuMeisai(ShafukuKeigenGakuPanelDiv div) {
        putViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.給付費明細).respond();
    }

    /**
     * 「特定診療費」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnTokuteiShiryohi(ShafukuKeigenGakuPanelDiv div) {
        putViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.特定診療費).respond();
    }

    /**
     * 「サービス計画費」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnServiceKeikakuhi(ShafukuKeigenGakuPanelDiv div) {
        putViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.サービス計画費).respond();
    }

    /**
     * 「特定入所者費用」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnTokuteinyushosha(ShafukuKeigenGakuPanelDiv div) {
        putViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 「合計情報」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnGokeiinfo(ShafukuKeigenGakuPanelDiv div) {
        putViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.合計情報).respond();
    }

    /**
     * 「給付費明細（住特）」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnKyufuhiMeisaiJutoku(ShafukuKeigenGakuPanelDiv div) {
        putViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.給付費明細_住特).respond();
    }

    /**
     * 「緊急時・所定疾患」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnKinkyujiShoteiShikan(ShafukuKeigenGakuPanelDiv div) {
        putViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.緊急時_所定疾患).respond();
    }

    /**
     * 「緊急時施設療養費」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnKinkyujiShisetsu(ShafukuKeigenGakuPanelDiv div) {
        putViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.緊急時施設療養費).respond();
    }

    /**
     * 「食事費用」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnShokujihiyo(ShafukuKeigenGakuPanelDiv div) {
        putViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.食事費用).respond();
    }

    /**
     * 「請求額集計」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnSeikyugaku(ShafukuKeigenGakuPanelDiv div) {
        putViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.請求額集計).respond();
    }

    private ShafukuKeigenGakuPanelHandler getHandler(ShafukuKeigenGakuPanelDiv div) {
        return ShafukuKeigenGakuPanelHandler.of(div);
    }

    private void putViewState(ShafukuKeigenGakuPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.処理モード, ViewStateHolder.get(ViewStateKeys.処理モード, RString.class));
        ViewStateHolder.put(ViewStateKeys.申請日, div.getPanelHead().getTxtShinseiYMD().getValue());
        ShoukanharaihishinseikensakuParameter paramter = new ShoukanharaihishinseikensakuParameter(
                ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class),
                ViewStateHolder.get(ViewStateKeys.整理番号, RString.class),
                new JigyoshaNo(div.getPanelHead().getTxtJigyoshaBango().getValue()),
                div.getPanelHead().getTxtShomeisho().getValue(),
                div.getPanelHead().getTxtMeisaiBango().getValue(),
                null);
        ViewStateHolder.put(ViewStateKeys.申請検索キー, paramter);
    }
}
