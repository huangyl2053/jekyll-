/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0600031;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.ShokanbaraiketteiJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600031.DBC0600031StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600031.DBC0600031TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600031.PnlKeteiJohoMsgDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0600031.PnlKeteiJohoMsgHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author yangchenbing
 */
public class PnlKeteiJohoMsg {

    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 修正 = new RString("修正");
    private static final RString 参照 = new RString("参照");
    private static RDate サービス年月;
    private static Decimal 給付率;
    private static RString 事業者番号;

    public ResponseData<PnlKeteiJohoMsgDiv> onLoad(PnlKeteiJohoMsgDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, 修正);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, new RString("51"));
        ViewStateHolder.put(ViewStateKeys.サービス年月, new RDate("199506"));
        ViewStateHolder.put(ViewStateKeys.事業者番号, new RString("51"));
        ViewStateHolder.put(ViewStateKeys.様式番号, new RString("df"));
        ViewStateHolder.put(ViewStateKeys.給付率, new Decimal(3));
        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode(new RString("123456")));
        //  div.getKaigoCommonPanel().getCcdAtenaInfo().load(ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class));
        // div.getKaigoCommonPanel().getCcdShikakuKihon().initialize(ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class));
        サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, RDate.class);
        給付率 = ViewStateHolder.get(ViewStateKeys.給付率, Decimal.class);
        事業者番号 = ViewStateHolder.get(ViewStateKeys.事業者番号, RString.class);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtTeikyoYM().setValue(サービス年月);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtKyufuritsu().setValue(給付率);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSyomeisyo().setValue(事業者番号);
        //div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSeiriNo().get   缺少整理番号
        //div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtJigyoshaNo().get 様式番号
//        if(削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))){
//          div.getYoguKonyuhiShikyuShinseiContentsPanel().getCcdKetteiList().loadInitialize(new HihokenshaNo(
//                  ViewStateHolder.get(ViewStateKeys.被保険者番号, RString.class)), new FlexibleYearMonth(
//                          サービス年月.toDateString()), 削除, new RString("02"),参照);}
//        else
//        { div.getYoguKonyuhiShikyuShinseiContentsPanel().getCcdKetteiList().loadInitialize(new HihokenshaNo(
//                  ViewStateHolder.get(ViewStateKeys.被保険者番号, RString.class)), new FlexibleYearMonth(
//                          サービス年月.toDateString()), 削除, new RString("02"),登録);}}
        return ResponseData.of(div).respond();
    }

    public ResponseData<PnlKeteiJohoMsgDiv> onClick_btnFree(PnlKeteiJohoMsgDiv div) {
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            //福祉用具購入費支給申請一覧画面へ遷移する。。
            return ResponseData.of(div).forwardWithEventName(DBC0600031TransitionEventName.一覧に戻る)
                    .parameter(new RString("一覧に戻る"));
        } else {
            // boolean flag = getHandler(div).get内容変更状態();
            boolean flag = true;
            if (flag) {
                if (!ResponseHolder.isReRequest()) {
                    QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                            UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                    return ResponseData.of(div).addMessage(message).respond();
                }
                if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                        .equals(ResponseHolder.getMessageCode())
                        && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                    //getHandler(div).内容の破棄();
                    //福祉用具購入費支給申請一覧画面へ遷移する。。
                    return ResponseData.of(div).forwardWithEventName(DBC0600031TransitionEventName.一覧に戻る)
                            .parameter(new RString("一覧に戻る"));
                } else {
                    return ResponseData.of(div).forwardWithEventName(DBC0600031TransitionEventName.処理完了)
                            .parameter(new RString("処理完了"));
                }
            } else {
                // TODO 償還払支給申請_サービス提供証明書画面へ遷移する。
                return ResponseData.of(div).forwardWithEventName(DBC0600031TransitionEventName.一覧に戻る)
                        .parameter(new RString("一覧に戻る"));
            }

        }

    }

    public ResponseData<PnlKeteiJohoMsgDiv> onClick_btnUpdate(PnlKeteiJohoMsgDiv div) {
        //決定日必須入力チェック
        ShokanbaraiketteiJohoDiv ADIV = (ShokanbaraiketteiJohoDiv) div.getYoguKonyuhiShikyuShinseiContentsPanel().getCcdKetteiList();

        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            if (ADIV.getTxtKetebi().getValue() == null) {
                throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
            }
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                //FukushiyoguKonyuhiShikyuGendogaku f=new FukushiyoguKonyuhiShikyuGendogaku();
                //f.delete(div);

            } else {
                return ResponseData.of(div).forwardWithEventName(DBC0600031TransitionEventName.処理完了)
                        .parameter(new RString("処理完了"));
            }
        } else {
            boolean flag = true;//页面内容已经变更
            if (flag) {
                if (ADIV.getTxtKetebi().getValue() == null) {
                    throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
                }
                if (!ResponseHolder.isReRequest()) {
                    return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
                }
                if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                        && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                    //FukushiyoguKonyuhiShikyuGendogaku f=new FukushiyoguKonyuhiShikyuGendogaku();
                    //f.updKetteJoho(div)

                } else {

                    return ResponseData.of(div).forwardWithEventName(DBC0600031TransitionEventName.処理完了)
                            .parameter(new RString("処理完了"));
                }
            } else {
                if (!ResponseHolder.isReRequest()) {
                    return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
                }
                return ResponseData.of(div).forwardWithEventName(DBC0600031TransitionEventName.処理完了)
                        .parameter(new RString("処理完了"));
            }

        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrInformationMessages.保存終了.getMessage()).respond();
        }
        return ResponseData.of(div).setState(DBC0600031StateName.successSaved);
    }

    /**
     *
     *
     *
     * @param div
     * @return
     */
    public ResponseData<PnlKeteiJohoMsgDiv> onClick_btnShinseJoho(PnlKeteiJohoMsgDiv div) {
        //福祉用具購入費支給申請_明細登録へ遷移する。
        return ResponseData.of(div).forwardWithEventName(DBC0600031TransitionEventName.明細情報)
                .parameter(new RString("明細情報"));
    }

    private PnlKeteiJohoMsgHandler getHandler(PnlKeteiJohoMsgDiv div) {
        return PnlKeteiJohoMsgHandler.of(div);
    }
}
