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
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 */
public class PnlKeteiJohoMsg {

    private static final RString 削除 = new RString("削除");
    //  private static final RString 登録 = new RString("登録");
    private static final RString 修正 = new RString("修正");
    // private static final RString 参照 = new RString("参照");
    // private static RDate サービス年月1;
    // private static Decimal 給付率1;
    //private static RString 事業者番号1;

    /**
     * 福祉用具購入費支給申請の決定情報登録
     *
     * @param div 画面DIV
     * @return 福祉用具購入費支給申請の決定情報登録
     */
    public ResponseData<PnlKeteiJohoMsgDiv> onLoad(PnlKeteiJohoMsgDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, 修正);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, new HihokenshaNo("000000003"));
        // ViewStateHolder.put(ViewStateKeys.サービス年月, new RDate("199506"));
        //  ViewStateHolder.put(ViewStateKeys.事業者番号, new RString("51"));
        ViewStateHolder.put(ViewStateKeys.様式番号, new RString("df"));
        //ViewStateHolder.put(ViewStateKeys.給付率, new Decimal(3));
        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode(new RString("000000000000010")));
        //  div.getKaigoCommonPanel().getCcdAtenaInfo().load(ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class));
        // div.getKaigoCommonPanel().getCcdShikakuKihon().initialize(ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class));
        //  サービス年月1 = ViewStateHolder.get(ViewStateKeys.サービス年月, RDate.class);
        //  給付率1 = ViewStateHolder.get(ViewStateKeys.給付率, Decimal.class);
        // 事業者番号1 = ViewStateHolder.get(ViewStateKeys.事業者番号, RString.class);
        // div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtTeikyoYM().setValue(サービス年月1);
        //  div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtKyufuritsu().setValue(給付率1);
        //  div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSyomeisyo().setValue(事業者番号1);
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

    /**
     * 福祉用具購入費支給申請の取消する
     *
     * @param div 画面DIV
     * @return 福祉用具購入費支給申請一覧画面へ遷移
     */
    public ResponseData<PnlKeteiJohoMsgDiv> onClick_btnFree(PnlKeteiJohoMsgDiv div) {
        // boolean flag = getHandler(div).isget内容変更状態();
        boolean flag = true;
        // if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
        //福祉用具購入費支給申請一覧画面へ遷移する。。
        //   return ResponseData.of(div).forwardWithEventName(DBC0600031TransitionEventName.一覧に戻る)
        //          .parameter(new RString("一覧に戻る"));
        //  } else
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
            } //else {
            //   return ResponseData.of(div).forwardWithEventName(DBC0600031TransitionEventName.処理完了)
            //          .parameter(new RString("処理完了"));
            // }
        } else {
            // TODO 償還払支給申請_サービス提供証明書画面へ遷移する。
            return ResponseData.of(div).forwardWithEventName(DBC0600031TransitionEventName.一覧に戻る)
                    .parameter(new RString("一覧に戻る"));
        }
        return ResponseData.of(div).forwardWithEventName(DBC0600031TransitionEventName.一覧に戻る)
                .parameter(new RString("一覧に戻る"));
//なくても
    }

    /**
     * 福祉用具購入費支給申請の決定情報登録保存する」
     *
     * @param div 画面DIV
     * @return 福祉用具購入費支給申請の決定情報登録
     */
    public ResponseData<PnlKeteiJohoMsgDiv> onClick_btnUpdate(PnlKeteiJohoMsgDiv div) {
        //決定日必須入力チェック
        ShokanbaraiketteiJohoDiv adiv = (ShokanbaraiketteiJohoDiv) div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getCcdKetteiList();
        boolean flag = true;
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            if (adiv.getTxtKetebi().getValue() == null) {
                throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
            }
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.
                    getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                //FukushiyoguKonyuhiShikyuGendogaku f=new FukushiyoguKonyuhiShikyuGendogaku();
                return ResponseData.of(div).forwardWithEventName(DBC0600031TransitionEventName.明細情報)
                        .parameter(new RString("明細情報"));
                //なくても
                //  f.delete(div);
            } else {
                return ResponseData.of(div).forwardWithEventName(DBC0600031TransitionEventName.処理完了)
                        .parameter(new RString("処理完了"));
            }
        } else if (flag) {
            if (adiv.getTxtKetebi().getValue() == null) {
                throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
            }
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                // FukushiyoguKonyuhiShikyuGendogaku f=new FukushiyoguKonyuhiShikyuGendogaku();
                //f.updKetteJoho(div);
                flag = false;
                //なくても
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
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrInformationMessages.保存終了.getMessage()).respond();
        }
        return ResponseData.of(div).setState(DBC0600031StateName.successSaved);
    }

    /**
     * 福祉用具購入費支給申請の決定情報登録明細情報
     *
     * @param div 画面DIV
     * @return 福祉用具購入費支給申請_明細登録へ遷移す
     */
    public ResponseData<PnlKeteiJohoMsgDiv> onClick_btnShinseJoho(PnlKeteiJohoMsgDiv div) {
        //福祉用具購入費支給申請_明細登録へ遷移する。
        return ResponseData.of(div).forwardWithEventName(DBC0600031TransitionEventName.明細情報)
                .parameter(new RString("明細情報"));
    }

  //  private PnlKeteiJohoMsgHandler getHandler(PnlKeteiJohoMsgDiv div) {
    //     return PnlKeteiJohoMsgHandler.of(div);
    // }
}
