/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0820031;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShakaiFukushiHojinKeigengakuResult;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraihishikyushinseikette.ShafukukeigenServiceResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820031.DBC0820031TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820031.ShafukuKeigenGakuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820031.ShafukuKeigenGakuPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SikibetuNokennsakuki;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SyokanbaraihishikyushinseiketteParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShakaiFukushiHojinRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
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
 */
public class ShafukuKeigenGakuPanel {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 申請を保存する = new RString("Element1");

    /**
     * onLoad
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onLoad(ShafukuKeigenGakuPanelDiv div) {
        // TODO「介護宛名情報」共有子Divの初期化
        // TODO 「介護資格系基本情報」共有子Div の初期化
        SyokanbaraihishikyushinseiketteParameter par = new SyokanbaraihishikyushinseiketteParameter(
                new HihokenshaNo("000000003"),
                new FlexibleYearMonth(new RString("201601")),
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
        JigyoshaNo 事業者番号 = paramter.getJigyoshaNo();
        RString 様式番号 = paramter.getYoshikiNo();
        RString 明細番号 = paramter.getMeisaiNo();
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.整理番号, 整理番号);
        SikibetuNokennsakuki key = new SikibetuNokennsakuki(new RString("0004"),
                new FlexibleYearMonth(new RString("201601")));
        ViewStateHolder.put(ViewStateKeys.識別番号検索キー, key);
        RString 申請日 = new RString("20151127");

        ArrayList<ShokanShakaiFukushiHojinKeigengakuResult> hojinKeigengakuEntityList
                = (ArrayList<ShokanShakaiFukushiHojinKeigengakuResult>) ShokanbaraiJyokyoShokai.createInstance()
                .getSeikyuShakaifukushiHoujinKeigengaku(
                        被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
        if (hojinKeigengakuEntityList == null || hojinKeigengakuEntityList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        ViewStateHolder.put(ViewStateKeys.情報, hojinKeigengakuEntityList);
        getHandler(div).initialize(hojinKeigengakuEntityList);
        div.getPanelHead().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.wareki().toDateString().toString()));
        div.getPanelHead().getTxtShinseiYMD().setValue(new RDate(申請日.toString()));
        div.getPanelHead().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelHead().getTxtMeisaiBango().setValue(明細番号);
        div.getPanelHead().getTxtShomeisho().setValue(様式番号);

        ArrayList<ShafukukeigenServiceResult> shokanShukeiList = (ArrayList<ShafukukeigenServiceResult>) SyokanbaraihiShikyuShinseiKetteManager.createInstance().
                getShafukukeigenServiceList(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        if (shokanShukeiList == null || shokanShukeiList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage());
        }
        ViewStateHolder.put(ViewStateKeys.サービス種類集計情報, shokanShukeiList);
        List<KeyValueDataSource> サービス種類 = new ArrayList<>();
        for (ShafukukeigenServiceResult entity : shokanShukeiList) {
            サービス種類.add(new KeyValueDataSource(new RString(entity.getServiceShuruiMeisho().toString()),
                    entity.getServiceShuruiCode().getColumnValue()));
        }
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getDdlServiceShurui().setDataSource(サービス種類);

        List<ShakaiFukushiHojinRiyoshaFutanKeigen> 軽減額List = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                .getShafukukeigenKeigenrichiList(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        if (軽減額List == null || 軽減額List.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage());
        }
        List<KeyValueDataSource> 軽減率 = new ArrayList<>();
        for (int i = 0; i < 軽減額List.size(); i++) {
            Decimal 軽減率分子 = 軽減額List.get(i).get軽減率分子();
            Decimal 軽減率分母 = 軽減額List.get(i).get軽減率分母();
            Decimal 軽減額 = 軽減率分子.divide(軽減率分母);
            軽減率.add(new KeyValueDataSource(new RString(Integer.toString(i)), new RString(Float.toString(軽減額.floatValue()))));
        }
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getDdlKengenritsu().setDataSource(軽減率);
        // 識別番号管理情報取得
        SikibetuNokennsakuki kennsakuki = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, SikibetuNokennsakuki.class);
        ShikibetsuNoKanri entity = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                .getShikibetsuNoKanri(kennsakuki.getServiceTeikyoYM(), kennsakuki.getSikibetuNo());
        if (entity == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        } else {
            getHandler(div).getボタンを制御(entity);
        }
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setVisible(false);
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku().setDisabled(true);
            div.getPanelShafukukenngengaku().getBtnAdd().setDisabled(true);
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
            if (value.equals(entity.getServiceShuruiCode().getColumnValue())) {
                div.getPanelShafukukenngengaku().getTxtRiyoshaFutangakuTotal()
                        .setValue(new Decimal(entity.getRiyoshaFutangaku()));
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
        getHandler(div).initializeByConfirm();
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
            // TODO 償還払支給申請_サービス提供証明書画面へ遷移する。
            return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.サービス計画費)
                    .parameter(new RString("サービス計画費"));
//            return ResponseData.of(div).respond();
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
                getHandler(div).内容の破棄();
                return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.サービス計画費)
                        .parameter(new RString("サービス計画費"));
            } else {
                ResponseData.of(div).respond();
            }
        } else {
            return ResponseData.of(div).forwardWithEventName(DBC0820031TransitionEventName.サービス計画費)
                    .parameter(new RString("サービス計画費"));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_CommonSave
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_CommonSave(ShafukuKeigenGakuPanelDiv div) {
//        ViewStateHolder.put(ViewStateKeys.処理モード, 削除);
        boolean flag = getHandler(div).is内容変更状態();
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            if (!ResponseHolder.isReRequest()) {
                getHandler(div).削除Save();
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage()
                        .replace(削除.toString())).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, true);
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage()
                        .replace(登録.toString())).respond();
            }
        } else if (flag) {
            if (!ResponseHolder.isReRequest()) {
                getHandler(div).登録Save();
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage()).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
//                    CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, true);
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

    /**
     * 「基本情報」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnKihoninfo(ShafukuKeigenGakuPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 「給付費明細」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnKyufuMeisai(ShafukuKeigenGakuPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 「特定診療費」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnTokuteiShiryohi(ShafukuKeigenGakuPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 「サービス計画費」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnServiceKeikakuhi(ShafukuKeigenGakuPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 「特定入所者費用」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnTokuteinyushosha(ShafukuKeigenGakuPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 「合計情報」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnGokeiinfo(ShafukuKeigenGakuPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 「給付費明細（住特）」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnKyufuhiMeisaiJutoku(ShafukuKeigenGakuPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 「緊急時・所定疾患」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnKinkyujiShoteiShikan(ShafukuKeigenGakuPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 「緊急時施設療養費」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnKinkyujiShisetsu(ShafukuKeigenGakuPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 「食事費用」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnShokujihiyo(ShafukuKeigenGakuPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 「請求額集計」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnSeikyugaku(ShafukuKeigenGakuPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    // 「社福軽減額」ボタン
//    public ResponseData<ShafukuKeigenGakuPanelDiv> onClick_btnShafuku(ShafukuKeigenGakuPanelDiv div) {
//        getHandler(div).putViewState();
//        return ResponseData.of(div).respond();
//    }
    private ShafukuKeigenGakuPanelHandler getHandler(ShafukuKeigenGakuPanelDiv div) {
        return ShafukuKeigenGakuPanelHandler.of(div);
    }
}
