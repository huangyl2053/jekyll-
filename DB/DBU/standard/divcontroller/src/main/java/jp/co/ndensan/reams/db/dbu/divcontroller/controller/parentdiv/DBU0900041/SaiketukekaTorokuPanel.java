/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0900041;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900041.DBU0900041StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900041.DBU0900041TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900041.SaiketukekaTorokuPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0900041.SaiketukekaTorokuPanelHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0900041.SaiketukekaTorokuPanelHandler.Dbu900041Keys;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0900041.SaiketukekaTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbu.service.core.saiketukekatoroku.SaiketukekaToroku;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 裁決結果登録_登録のクラス。
 *
 * @reamsid_L DBU-1080-110 xuyue
 */
public class SaiketukekaTorokuPanel {

    private static final RString 削除 = new RString("削除");
    private static final RString 更新 = new RString("更新");

    /**
     * 裁決結果登録_登録の初期化。(オンロード)<br/>
     *
     * @param requestDiv SaiketukekaTorokuPanelDiv
     * @return ResponseData<SaiketukekaTorokuPanelDiv>
     */
    public ResponseData<SaiketukekaTorokuPanelDiv> onLoad(SaiketukekaTorokuPanelDiv requestDiv) {

        ResponseData<SaiketukekaTorokuPanelDiv> responseData = new ResponseData<>();

        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleDate 審査請求届出日 = ViewStateHolder.get(ViewStateKeys.審査請求届出日, FlexibleDate.class);

        if (更新.toString().equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class).toString())) {

            RString 修正前の値 = createHandlerOf(requestDiv).修正_初期化の編集(識別コード, 被保険者番号, 審査請求届出日);
            ViewStateHolder.put(Dbu900041Keys.修正前の値, 修正前の値);
            return ResponseData.of(requestDiv).setState(DBU0900041StateName.修正状態);
        }
        if (削除.toString().equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class).toString())) {

            createHandlerOf(requestDiv).削除_初期化の編集(識別コード, 被保険者番号, 審査請求届出日);
            return ResponseData.of(requestDiv).setState(DBU0900041StateName.削除状態);
        }
        responseData.data = requestDiv;
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 裁決結果登録_登録の初期化。(オンアクティブ)<br/>
     *
     * @param requestDiv SaiketukekaTorokuPanelDiv
     * @return ResponseData<SaiketukekaTorokuPanelDiv>
     */
    public ResponseData<SaiketukekaTorokuPanelDiv> onActive(SaiketukekaTorokuPanelDiv requestDiv) {
        return onLoad(requestDiv);
    }

    /**
     * 取消するボタンが押下された場合、明細画面を閉じて、裁決結果登録一覧画面に遷移します。
     *
     * @param div SaiketukekaTorokuPanelDiv
     * @return ResponseData<SaiketukekaTorokuPanelDiv>
     */
    public ResponseData<SaiketukekaTorokuPanelDiv> onClick_btnCancel(SaiketukekaTorokuPanelDiv div) {

        if ((更新.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class)))) {
            RString 修正前の値 = ViewStateHolder.get(SaiketukekaTorokuPanelHandler.Dbu900041Keys.修正前の値, RString.class) == null
                    ? RString.EMPTY : ViewStateHolder.get(SaiketukekaTorokuPanelHandler.Dbu900041Keys.修正前の値, RString.class);
            if (getValidationHandler().修正_変更有無チェック(createHandlerOf(div).get修正後の値(), 修正前の値)) {
                return 変更あり_修正処理の取消(div);
            } else {
                createHandlerOf(div).内容の破棄();
                return ResponseData.of(div).forwardWithEventName(DBU0900041TransitionEventName.一覧に戻る).respond();
            }
        }
        if ((削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class)))) {
            createHandlerOf(div).内容の破棄();
            return ResponseData.of(div).forwardWithEventName(DBU0900041TransitionEventName.一覧に戻る).respond();
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<SaiketukekaTorokuPanelDiv> 変更あり_修正処理の取消(SaiketukekaTorokuPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            createHandlerOf(div).内容の破棄();
            return ResponseData.of(div).forwardWithEventName(DBU0900041TransitionEventName.一覧に戻る).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 完了するボタン押下、メニュー画面へ遷移します。
     *
     * @param div SinsaSeikyusyoMeisaiPanelDiv
     * @return ResponseData<SinsaSeikyusyoMeisaiPanelDiv>
     */
    public ResponseData<SaiketukekaTorokuPanelDiv> onClick_btnFinish(SaiketukekaTorokuPanelDiv div) {
        createHandlerOf(div).内容の破棄();
        return ResponseData.of(div).forwardWithEventName(DBU0900041TransitionEventName.処理完了).respond();
    }

    /**
     * 保存するボタン押下、データがDBに更新します。
     *
     * @param div SaiketukekaTorokuPanelDiv
     * @return ResponseData<SaiketukekaTorokuPanelDiv>
     */
    public ResponseData<SaiketukekaTorokuPanelDiv> onClick_btnUpdate(SaiketukekaTorokuPanelDiv div) {

        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleDate 審査請求届出日 = ViewStateHolder.get(ViewStateKeys.審査請求届出日, FlexibleDate.class);

        if (更新.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {

            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            getValidationHandler().validateFor弁明書作成日の必須入力(pairs, div);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            RString 修正前の値 = ViewStateHolder.get(SaiketukekaTorokuPanelHandler.Dbu900041Keys.修正前の値, RString.class) == null
                    ? RString.EMPTY : ViewStateHolder.get(SaiketukekaTorokuPanelHandler.Dbu900041Keys.修正前の値, RString.class);
            boolean 変更あり = getValidationHandler().修正_変更有無チェック(createHandlerOf(div).get修正後の値(), 修正前の値);
            if (変更あり) {
                return 変更あり_修正処理(div);
            } else {
                return 変更なし_修正処理(div);
            }
        }

        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.削除の確認.getMessage().getCode(),
                        UrQuestionMessages.削除の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                削除処理(識別コード, 被保険者番号, 審査請求届出日);
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace(削除.toString())).respond();
            }
            if (new RString(UrInformationMessages.正常終了.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                div.getKaryoMessage().getCcdKaigoKanryoMessage().setMessage(
                        new RString(UrInformationMessages.処理完了.getMessage().evaluate()), RString.EMPTY, RString.EMPTY, true);
                return ResponseData.of(div).setState(DBU0900041StateName.完了状態);
            }
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<SaiketukekaTorokuPanelDiv> 変更あり_修正処理(SaiketukekaTorokuPanelDiv div) {

        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleDate 審査請求届出日 = ViewStateHolder.get(ViewStateKeys.審査請求届出日, FlexibleDate.class);

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            修正処理(div, 識別コード, 被保険者番号, 審査請求届出日);
            return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace(更新.toString())).respond();
        }
        if (new RString(UrInformationMessages.正常終了.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getKaryoMessage().getCcdKaigoKanryoMessage().setMessage(
                    new RString(UrInformationMessages.処理完了.getMessage().evaluate()), RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBU0900041StateName.完了状態);
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<SaiketukekaTorokuPanelDiv> 変更なし_修正処理(SaiketukekaTorokuPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        }
        if (new RString(DbzInformationMessages.内容変更なしで保存不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).setState(DBU0900041StateName.修正状態);
        }
        return ResponseData.of(div).respond();
    }

    private void 削除処理(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, FlexibleDate 審査請求届出日) {

        SaiketukekaToroku saiketukekaToroku = new SaiketukekaToroku();
        saiketukekaToroku.delSaiketukekaMeisaiJoho(識別コード, 被保険者番号, 審査請求届出日);
    }

    private void 修正処理(SaiketukekaTorokuPanelDiv div, ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, FlexibleDate 審査請求届出日) {

        RString 裁決結果 = div.getSaiketukekaMeisaiPanel().getTxtMultiLineSaiketukeka().getValue();
        RString 裁決理由 = div.getSaiketukekaMeisaiPanel().getTxtMultiLineSaiketuRiyu().getValue();
        FlexibleDate 弁明書作成日 = new FlexibleDate(div.getSaiketukekaMeisaiPanel().getTxtDateBenmeisyoSakuseibi().getValue().toDateString());

        SaiketukekaToroku saiketukekaToroku = new SaiketukekaToroku();
        saiketukekaToroku.updSaiketukekaMeisaiJoho(識別コード, 被保険者番号, 審査請求届出日, 裁決結果, 裁決理由, 弁明書作成日);
    }

    private SaiketukekaTorokuPanelHandler createHandlerOf(SaiketukekaTorokuPanelDiv requestDiv) {
        return new SaiketukekaTorokuPanelHandler(requestDiv);
    }

    private SaiketukekaTorokuValidationHandler getValidationHandler() {
        return new SaiketukekaTorokuValidationHandler();
    }
}
