/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0820030;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820030.DBC0820030StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820030.DBC0820030TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820030.SeikyuGakuShukeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820030.dgdSeikyugakushukei_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820030.SeikyuGakuShukeiPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SikibetuNokennsakuki;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SyokanbaraihishikyushinseiketteParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 償還払い費支給申請決定_サービス提供証明書(請求額集計）
 *
 * @author 瞿暁東
 */
public class SeikyuGakuShukeiPanel {

    private static final RString 設定不可 = new RString("0");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");

    public ResponseData<SeikyuGakuShukeiDiv> onLoad(SeikyuGakuShukeiDiv div) {
        SyokanbaraihishikyushinseiketteParameter par = new SyokanbaraihishikyushinseiketteParameter(
                new HihokenshaNo("000000033"), new FlexibleYearMonth(new RString("200501")),
                new RString("0000000003"), new JigyoshaNo("0000000003"), new RString("0003"),
                new RString("0003"), new RString("10"));
        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, par);
        SyokanbaraihishikyushinseiketteParameter parameter = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                SyokanbaraihishikyushinseiketteParameter.class);
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        RString 様式番号 = parameter.getYoshikiNo();
        RString 明細番号 = parameter.getMeisaiNo();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.整理番号, 整理番号);
        SikibetuNokennsakuki key = new SikibetuNokennsakuki(new RString("0003"),
                new FlexibleYearMonth(new RString("200501")));
        ViewStateHolder.put(ViewStateKeys.識別番号検索キー, key);
        RString 申請日 = new RString("20151124");
        ServiceShuruiCode サービス種類コード = new ServiceShuruiCode("222222");
        getHandler(div).set申請共通エリア(サービス年月, 事業者番号, 申請日, 明細番号, 様式番号);
        List<ShokanShukeiEntity> entityList = ShokanbaraiJyokyoShokai.createInstance().getSeikyuShukeiData(
                被保険者番号,
                サービス年月,
                整理番号,
                事業者番号,
                様式番号,
                明細番号, null);
        if (entityList == null || entityList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setVisible(false);
        getHandler(div).initialize(entityList);
//        SikibetuNokennsakuki kennsakuki = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, SikibetuNokennsakuki.class);
//        DbT3118ShikibetsuNoKanriEntity entity = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
//                .getShikibetsuNoKanri(kennsakuki.getServiceTeikyoYM(), kennsakuki.getSikibetuNo());
//        if (entity == null) {
//            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
//        } else {
//            getHandler(div).getボタンを制御(entity);
//        }
//        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
//            div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setDisabled(true);
//        }
        return createResponse(div);
    }

    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnAdd(SeikyuGakuShukeiDiv div) {
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setVisible(true);
        ViewStateHolder.put(ViewStateKeys.状態, 登録);
        return createResponse(div);
    }

    public ResponseData<SeikyuGakuShukeiDiv> onClick_ddgDelete(SeikyuGakuShukeiDiv div) {
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setVisible(true);
        getHandler(div).set請求額集計登録();
        ViewStateHolder.put(ViewStateKeys.状態, 削除);
        return createResponse(div);
    }

    public ResponseData<SeikyuGakuShukeiDiv> onClick_ddgModify(SeikyuGakuShukeiDiv div) {
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setVisible(true);
        getHandler(div).set請求額集計登録();
        ViewStateHolder.put(ViewStateKeys.状態, 修正);
        return createResponse(div);
    }

    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnKeisan(SeikyuGakuShukeiDiv div) {
        getHandler(div).計算する();
        return createResponse(div);
    }

    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnClear(SeikyuGakuShukeiDiv div) {
        getHandler(div).clear請求額集計登録();
        return createResponse(div);
    }

    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnCancel(SeikyuGakuShukeiDiv div) {
        getHandler(div).clear請求額集計登録();
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setVisible(false);
        return createResponse(div);
    }

    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnFree(SeikyuGakuShukeiDiv div) {
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            // TODO 償還払支給申請_サービス提供証明書画面へ遷移する。
            return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.サービス計画費)
                    .parameter(new RString("サービス計画費"));
        }
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth(new RString("200405"));
        boolean flag = getHandler(div).get内容変更状態(サービス年月);
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
                return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.サービス計画費)
                        .parameter(new RString("サービス計画費"));
            } else {
                ResponseData.of(div).respond();
            }
        } else {
            // TODO 償還払支給申請_サービス提供証明書画面へ遷移する。
            return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.サービス計画費)
                    .parameter(new RString("サービス計画費"));
        }
        return createResponse(div);
    }

    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnConfirm(SeikyuGakuShukeiDiv div) {
        dgdSeikyugakushukei_Row row = getHandler(div).selectRow();
//        SyokanbaraihishikyushinseiketteParameter parameter = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
//                SyokanbaraihishikyushinseiketteParameter.class);
//        ShokanbaraiJutakuShikyuGendogakuHanteiCheck iCheck = new ShokanbaraiJutakuShikyuGendogakuHanteiCheck();
//        RString 様式番号 = parameter.getYoshikiNo();
//        Decimal 限度額対象単位 = div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTaishoTanyi().getValue();
//        ServiceShuruiCode サービス種類コード = new ServiceShuruiCode(
//                row.getDefaultDataName1().toString());
//        Decimal 限度額対象外単位 = div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTaishoGaiTanyi().getValue();
//        Decimal 保険分単位合計 = div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiHokenbun().getValue();
//        if (!div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTaishoTanyi().getValue().add(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().
//                getTxtTaishoGaiTanyi().getValue()).equals(div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKeikakuTanyi())) {
//            throw new ApplicationException(UrWarningMessages.保存の確認.getMessage());
//
//        } else if (iCheck.chkShokanbaraiJutakuShikyuGendogakuTaishoTani(様式番号, 限度額対象単位, サービス種類コード)) {
//            throw new ApplicationException(UrErrorMessages.入力値が不正.getMessage());
//        } else if (iCheck.chkShokanbaraiJutakuShikyuGendogakuTaniGokei(様式番号, 限度額対象外単位, 限度額対象単位, 保険分単位合計, サービス種類コード)) {
//            throw new ApplicationException(UrErrorMessages.入力値が不正.getMessage());
//        } else {
        getHandler(div).modifyRow(row);

//        }
        return createResponse(div);
    }

    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnSave(SeikyuGakuShukeiDiv div) {
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            getHandler(div).保存処理();

        } else {
            FlexibleYearMonth サービス年月 = new FlexibleYearMonth(new RString("200405"));
            boolean flag = getHandler(div).get内容変更状態(サービス年月);
            if (flag) {
                // TODO　保存処理
                getHandler(div).保存処理();
            } else {
                // TODO メッセージ
//            throw new ApplicationException(DBZ.InformationMessage.DBZI00006(内容が変更されていないため、保存はできません。));
            }
        }
        // TODO 「申請を保存する」ボタンを非活性にする。
        return ResponseData.of(div).setState(DBC0820030StateName.Default);

    }

    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnKihonInfo(SeikyuGakuShukeiDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    // 「給付費明細」ボタン
    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnKyufuMeisai(SeikyuGakuShukeiDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    //「特定診療費」ボタン
    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnTokuteiShinryouhii(SeikyuGakuShukeiDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    // 「サービス計画費」ボタン
    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnServiceKeikakuhi(SeikyuGakuShukeiDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    // 「特定入所者費用」ボタン
    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnTokuteiNyushosya(SeikyuGakuShukeiDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    // 「合計情報」ボタン
    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnGoukeiInfo(SeikyuGakuShukeiDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    // 「給付費明細（住特）」ボタン
    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnKyufuhiMeisaiJutoku(SeikyuGakuShukeiDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    // 「緊急時・所定疾患」ボタン
    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnKinkyujiShoteiShikan(SeikyuGakuShukeiDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    // 「緊急時施設療養費」ボタン
    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnKinkyushisetuRyoyouhi(SeikyuGakuShukeiDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    // 「食事費用」ボタン
    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnShokujihiyo(SeikyuGakuShukeiDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    // 「請求額集計」ボタン
    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnSeikyugakuShukei(SeikyuGakuShukeiDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    // 「社福軽減額」ボタン
    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnShafukukeigenGaku(SeikyuGakuShukeiDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    private SeikyuGakuShukeiPanelHandler getHandler(SeikyuGakuShukeiDiv div) {

        return new SeikyuGakuShukeiPanelHandler(div);
    }

    private ResponseData<SeikyuGakuShukeiDiv> createResponse(SeikyuGakuShukeiDiv div) {
        return ResponseData.of(div).respond();
    }

}
