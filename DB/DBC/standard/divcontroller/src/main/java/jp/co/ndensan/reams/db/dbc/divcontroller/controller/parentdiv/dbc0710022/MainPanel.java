/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0710022;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.ShokanbaraiketteiJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710022.DBC0710022TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710022.MainPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 */
public class MainPanel {

    private static final RString 照会 = new RString("照会");
    private static final RString 修正 = new RString("修正");
    //  private static final RString 登録 = new RString("照会");
    //  private static final RString 参照 = new RString("参照");
    private static final RString 審査 = new RString("審査");
    // private static MainPanelDiv div1;
    /**
     * 住宅改修費支給申請_償還払決定情報登録のonLoad
     *
     * @param div 画面DIV
     * @return 住宅改修費支給申請_償還払決定情報登録
     */
    public ResponseData<MainPanelDiv> onLoad(MainPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, 照会);
        // div1 = div;
        //ViewStateより、引き継ぎデータEntityを取得する
        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode(new RString("123456")));
        ViewStateHolder.put(ViewStateKeys.サービス年月, new RDate("199506"));
        // ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        //  RDate サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, RDate.class);
        // div.getJutakuKaishuShinseiHihokenshaPanel().getKaigoAtenaInfo().load(識別コード);
        //div.getJutakuKaishuShinseiHihokenshaPanel().getKaigoShikakuKihon().initialize(HihokenshaNo.EMPTY);
//        JutakukaishuSikyuShinsei fu = JutakukaishuSikyuShinsei.createInstance();
//        List<DbT3118ShikibetsuNoKanriEntity> 様式名称 = fu.getYoshikiName(サービス年月);
//        List<KeyValueDataSource> sources = new ArrayList<>();
//        for (DbT3118ShikibetsuNoKanriEntity db : 様式名称) {
//            sources.add(new KeyValueDataSource(db.getShikibetsuNo(), db.getRyakusho()));
//        }
//        div.getDdlSyomeisyo().setDataSource(sources);
//        div.getDdlSyomeisyo().setSelectedKey(様式名称.get(1).getShikibetsuNo());//ViewStateHolder.get(ViewStateKeys.証明書, RDate.class)
        //  div.getJutakuKaishuShinseiInfoPanel().getCommHeadPanel().getTxtKyufuritsu().setValue(new Decimal(3));
        div.getJutakuKaishuShinseiInfoPanel().getCommHeadPanel().getTxtSeiriNo().setValue(new RString("44"));
        div.getJutakuKaishuShinseiInfoPanel().getCommHeadPanel().getTxtTeikyoYM().setValue(new RDate("199506"));
//          if(修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class)))
//          {        div.getJutakuKaishuShinseiInfoPanel().getShokanbaraiKetteiJyohoPanel().getCcdShokanbaraiketteiJoho().loadInitialize
//             (HihokenshaNo.EMPTY, FlexibleYearMonth.EMPTY, RString.EMPTY, new RString("01"),登録);
//           }
//           else
//             ｛
//             div.getJutakuKaishuShinseiInfoPanel().getShokanbaraiKetteiJyohoPanel().getCcdShokanbaraiketteiJoho().loadInitialize
//        (HihokenshaNo.EMPTY, FlexibleYearMonth.EMPTY, RString.EMPTY, new RString("01"),参照);
//               ｝
        //  handler.initializedgShikyuShinseiList(list);
        return ResponseData.of(div).respond();
    }

    /**
     * 住宅改修費支給申請_償還払決定情報登録の申請情報
     *
     * @param div 画面DIV
     * @return 住宅改修費支給申請_申請情報登録画面へ遷移
     */
    public ResponseData<MainPanelDiv> onClick_btnShinseiJyoho(MainPanelDiv div) {
        if (修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                ViewStateHolder.put(ViewStateKeys.識別コード, ViewStateHolder.get(ViewStateKeys.識別コード, RString.class));
                ViewStateHolder.put(ViewStateKeys.サービス年月, ViewStateHolder.get(ViewStateKeys.サービス年月, RString.class));
                ViewStateHolder.put(ViewStateKeys.被保険者番号, new RString("51"));
                ViewStateHolder.put(ViewStateKeys.整理番号, new RString("51"));
                ViewStateHolder.put(ViewStateKeys.状態, ViewStateHolder.get(ViewStateKeys.状態, RString.class));
                return ResponseData.of(div).forwardWithEventName(DBC0710022TransitionEventName.申請情報)
                        .parameter(new RString("申請情報"));
            }
        } else {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 住宅改修費支給申請_償還払決定情報登録の個人検索へ戻る
     *
     * @param div 画面DIV
     * @return 個人検索画面へ遷移
     */
    public ResponseData<MainPanelDiv> onClick_btnBackToSearch(MainPanelDiv div) {

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            //   InfomationMessages
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBC0710022TransitionEventName.検索に戻る)
                    .parameter(new RString("検索に戻る"));
        } else {
            return ResponseData.of(div).respond();
        }

    }

    /**
     * 住宅改修費支給申請_償還払決定情報登録の申請一覧へ戻る
     *
     * @param div 画面DIV
     * @return 償還払い状況照会画面
     */
    public ResponseData<MainPanelDiv> onClick_btnCancel(MainPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            if (照会.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
                return ResponseData.of(div).forwardWithEventName(DBC0710022TransitionEventName.申請情報)
                        .parameter(new RString("一覧に戻る"));
            } else if (審査.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
                return ResponseData.of(div).forwardWithEventName(DBC0710022TransitionEventName.検索に戻る)
                        .parameter(new RString("検索に戻る"));
            } else {
                return ResponseData.of(div).forwardWithEventName(DBC0710022TransitionEventName.一覧に戻る)
                        .parameter(new RString("一覧に戻る"));
            }
        } else {
            return ResponseData.of(div).respond();
        }

    }

    /**
     * 住宅改修費支給申請_償還払決定情報登録の申請を保存する
     *
     * @param div 画面DIV
     * @return 完了
     */
    public ResponseData<MainPanelDiv> onClick_btnAddShikyuShinsei(MainPanelDiv div) {

        ShokanbaraiketteiJohoDiv shokanbaraiketteiJohoDiv = (ShokanbaraiketteiJohoDiv) div.getJutakuKaishuShinseiInfoPanel()
                .getShokanbaraiKetteiJyohoPanel().getCcdShokanbaraiketteiJoho();
        if (shokanbaraiketteiJohoDiv.getTxtKetebi().getValue() == null) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        if (shokanbaraiketteiJohoDiv.getRdoShikyukubun().getSelectedIndex() == 1 && shokanbaraiketteiJohoDiv.
                getTxtFuSyikyuriyu1().getValue().toString().trim().equals("") && shokanbaraiketteiJohoDiv.getTxtFushikyuriyu2().
                getValue().toString().trim().equals("")) {
          //|| shokanbaraiketteiJohoDiv.getTxtFuSyikyuriyu1().getValue() == null

            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());

        }
        // boolean flag = getHandler(div).get内容変更状態(div1);
        boolean flag = true;
        if (flag) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                        UrQuestionMessages.保存の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                boolean flags = true;
                //boolean flags = JutakukaishuSikyuShinsei.updSyokanbaraiketeJoho(div);
                KaigoKanryoMessageDiv kaigokanryomessagediv = (KaigoKanryoMessageDiv) div.getJutakuShikyuShinseiKanryoPanel().getKanryoMessage();
                RString r1 = new RString("23");
                //  if (flags) {
                //      r1 = new RString(UrInformationMessages.保存終了.toString());
                //  } else {
                //     r1 = new RString(UrErrorMessages.異常終了.toString());
                // } // KaigoAtenaInfoDiv kaigoate = (KaigoAtenaInfoDiv) div.getJutakuKaishuShinseiHihokenshaPanel().getKaigoAtenaInfo();
                RString r2 = new RString("2f");
                RString r3 = new RString("3f");
                //氏名漢字
                kaigokanryomessagediv.setMessage(r1, r2, r3, flags);
            } else {
                return ResponseData.of(div).respond();
            }
        } else {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrInformationMessages.処理完了.getMessage()).respond();
            }
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 住宅改修費支給申請_償還払決定情報登録の申請を保存する
     *
     * @param div 画面DIV
     * @return 住宅改修費支給申請_償還払決定情報登録
     */
    public ResponseData<MainPanelDiv> btnComplete_btnComplete(MainPanelDiv div) {
        // return ResponseData.of(div).forwardWithEventName(DBC0710022TransitionEventName.申請情報)
        //  .parameter(new RString("申請情報"));
        return null;
    }

 //   private MainPanelHandler getHandler(MainPanelDiv div) {
    //     return MainPanelHandler.of(div);
    // }
}
