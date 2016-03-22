/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0600031;

import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyushisei.FukushiYoguKonyuhiShikyuShiseiKetteDivEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.ShokanbaraiketteiJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600031.DBC0600031StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600031.DBC0600031TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600031.PnlKeteiJohoMsgDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei.FukushiyoguKonyuhiShikyuShinsei;
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
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 福祉用具購入費支給申請_決定情報登録
 */
public class PnlKeteiJohoMsg {

    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 修正 = new RString("修正");
    private static final RString 参照 = new RString("参照");
    // private static PnlKeteiJohoMsgDiv div1;
    /**
     * onLoad事件
     *
     * @param div 画面DIV
     * @return 福祉用具購入費支給申請の決定情報登録
     */
    public ResponseData<PnlKeteiJohoMsgDiv> onLoad(PnlKeteiJohoMsgDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, 修正);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, new HihokenshaNo("000000003"));
        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode(new RString("000000000000010")));
        ViewStateHolder.put(ViewStateKeys.サービス年月, new FlexibleYearMonth("198810"));
        ViewStateHolder.put(ViewStateKeys.整理番号, new RString("0000000001"));
        ViewStateHolder.put(ViewStateKeys.事業者番号, new RString("df"));
        ViewStateHolder.put(ViewStateKeys.給付率, new Decimal(1));
        ViewStateHolder.put(ViewStateKeys.証明書, new RString("証明書"));
        div.getKaigoCommonPanel().getCcdAtenaInfo().onLoad(ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class));
        div.getKaigoCommonPanel().getCcdShikakuKihon().onLoad(ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class));
        FlexibleYearMonth サービス年月1 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        Decimal 給付率1 = ViewStateHolder.get(ViewStateKeys.給付率, Decimal.class);
        RString 事業者番号1 = ViewStateHolder.get(ViewStateKeys.事業者番号, RString.class);
        RString 整理番号1 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        RString 証明書1 = ViewStateHolder.get(ViewStateKeys.証明書, RString.class);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtTeikyoYM().setValue(new RDate(サービス年月1.toString()));
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtKyufuritsu().setValue(給付率1);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSyomeisyo().setValue(事業者番号1);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSeiriNo().setValue(整理番号1);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtJigyoshaNo().setValue(証明書1);
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class)) || 修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getCcdKetteiList().loadInitialize(new HihokenshaNo("000000001"),
                    サービス年月1, 整理番号1, new RString("02"), 登録);
        } else {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getCcdKetteiList().loadInitialize(new HihokenshaNo("000000001"),
                    サービス年月1, 整理番号1, new RString("02"), 参照);
        }
        //div1 = div;
        return ResponseData.of(div).respond();
    }

    /**
     * 福祉用具購入費支給申請の取消する
     *
     * @param div 画面DIV
     * @return 福祉用具購入費支給申請一覧画面へ遷移
     */
    public ResponseData<PnlKeteiJohoMsgDiv> onClick_btnFree(PnlKeteiJohoMsgDiv div) {
        //  boolean flag = getHandler(div).is内容変更状態(div1);
        boolean flag = true;
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            return ResponseData.of(div).forwardWithEventName(DBC0600031TransitionEventName.一覧に戻る)
                    .parameter(new RString("一覧に戻る"));
        }
        if (flag && (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))
                || 修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class)))) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).forwardWithEventName(DBC0600031TransitionEventName.一覧に戻る)
                        .parameter(new RString("一覧に戻る"));
            }
        }
        if ((!flag && (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))))
                || (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class)))) {
            return ResponseData.of(div).forwardWithEventName(DBC0600031TransitionEventName.一覧に戻る)
                    .parameter(new RString("一覧に戻る"));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 福祉用具購入費支給申請の決定情報登録保存する」
     *
     * @param div 画面DIV
     * @return 福祉用具購入費支給申請の決定情報登録
     */
    public ResponseData<PnlKeteiJohoMsgDiv> onClick_btnUpdate(PnlKeteiJohoMsgDiv div) {
        FlexibleYearMonth サービス年月1 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        RString 事業者番号1 = ViewStateHolder.get(ViewStateKeys.事業者番号, RString.class);
        RString 整理番号1 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.
                    getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                FukushiyoguKonyuhiShikyuShinsei f = new FukushiyoguKonyuhiShikyuShinsei();
                f.delete(被保険者番号, サービス年月1, 整理番号1, new JigyoshaNo(事業者番号1.toString()), null, null);

                div.getCcdMessage().setMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()),
                        RString.EMPTY, RString.EMPTY, true);
                return ResponseData.of(div).setState(DBC0600031StateName.successSaved);
            }
        }
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))
                || 修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            return 登録修正Update(div);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 福祉用具購入費支給申請の決定情報登録明細情報
     *
     * @param div 画面DIV
     * @return 福祉用具購入費支給申請_明細登録へ遷移す
     */
    public ResponseData<PnlKeteiJohoMsgDiv> onClick_btnShinseJoho(PnlKeteiJohoMsgDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0600031TransitionEventName.明細情報)
                .parameter(new RString("明細情報"));
    }

//    private PnlKeteiJohoMsgHandler getHandler(PnlKeteiJohoMsgDiv div) {
//        return PnlKeteiJohoMsgHandler.of(div);
//    }
    /**
     * 登録修正Update
     *
     * @param div 画面DIV
     * @return 福祉用具購入費支給申請_明細登録へ遷移す
     */
    private ResponseData<PnlKeteiJohoMsgDiv> 登録修正Update(PnlKeteiJohoMsgDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleYearMonth サービス年月1 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        RString 事業者番号1 = ViewStateHolder.get(ViewStateKeys.事業者番号, RString.class);
        RString 整理番号1 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        // boolean flag = getHandler(div).is内容変更状態(div1);
        boolean flag = true;
        ShokanbaraiketteiJohoDiv adiv = (ShokanbaraiketteiJohoDiv) div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getCcdKetteiList();
        if (!flag) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
            }
        } else {
            if (adiv.getTxtKetebi().getValue() == null) {
                throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
            }
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                FukushiyoguKonyuhiShikyuShinsei f = new FukushiyoguKonyuhiShikyuShinsei();

                ShokanShukei shokanshukei = new ShokanShukei(被保険者番号, new FlexibleYearMonth(サービス年月1.toString()),
                        整理番号1, new JigyoshaNo(事業者番号1.toString()), null, null, null);
                ShokanHanteiKekka shokanhanteikekka = new ShokanHanteiKekka(被保険者番号, サービス年月1,
                        整理番号1);
                FukushiYoguKonyuhiShikyuShiseiKetteDivEntity entity = FukushiYoguKonyuhiShikyuShiseiKetteDivEntity.createEntity(
                        ViewStateHolder.get(ViewStateKeys.状態, RString.class), shokanhanteikekka, shokanshukei);
                f.updKetteJoho(entity);
                div.getCcdMessage().setMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()), RString.EMPTY, RString.EMPTY, true);
                return ResponseData.of(div).setState(DBC0600031StateName.successSaved);
            }
        }
        return ResponseData.of(div).respond();
    }
}
