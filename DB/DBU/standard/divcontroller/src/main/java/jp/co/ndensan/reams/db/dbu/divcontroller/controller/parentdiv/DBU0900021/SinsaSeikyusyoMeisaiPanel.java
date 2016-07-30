/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0900021;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900021.DBU0900021StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900021.DBU0900021TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900021.SinsaSeikyusyoMeisaiPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0900021.SinsaSeikyusyoMeisaiPanelHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0900021.SinsaSeikyusyoMeisaiValidationHandler;
import jp.co.ndensan.reams.db.dbu.service.core.sinsaseikyusyotoroku.SinsaSeikyusyoTorokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.FufukuMoshitate;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 審査請求書登録_登録のクラス。
 *
 * @reamsid_L DBU-1080-060 houtianpeng
 */
public class SinsaSeikyusyoMeisaiPanel {

    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 更新 = new RString("更新");

    /**
     * 審査請求書登録_登録の初期化。<br/>
     *
     * @param requestDiv SinsaSeikyusyoMeisaiPanelDiv
     * @return ResponseData<SinsaSeikyusyoMeisaiPanelDiv>
     */
    public ResponseData<SinsaSeikyusyoMeisaiPanelDiv> onLoad(SinsaSeikyusyoMeisaiPanelDiv requestDiv) {

        ResponseData<SinsaSeikyusyoMeisaiPanelDiv> responseData = new ResponseData<>();

        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get識別コード();
        requestDiv.getAtenaInfoCommonChildDiv().initialize(識別コード);
        requestDiv.getKaigoShikakuKihonCommonChildDiv().initialize(ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号());
        if (追加.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {

            createHandlerOf(requestDiv).追加_初期化の編集();
            createHandlerOf(requestDiv).初期画面値の保持();
            return ResponseData.of(requestDiv).setState(DBU0900021StateName.追加);
        }
        if (修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {

            FufukuMoshitate fufukuMoshitate = 資格系基本情報の取得();
            ViewStateHolder.put(ViewStateKeys.不服審査申立情報, fufukuMoshitate);
            createHandlerOf(requestDiv).修正_初期化の編集(fufukuMoshitate);
            createHandlerOf(requestDiv).初期画面値の保持();
            return ResponseData.of(requestDiv).setState(DBU0900021StateName.修正);
        }
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {

            FufukuMoshitate fufukuMoshitate = 資格系基本情報の取得();
            ViewStateHolder.put(ViewStateKeys.不服審査申立情報, fufukuMoshitate);
            createHandlerOf(requestDiv).削除_初期化の編集(fufukuMoshitate);
            return ResponseData.of(requestDiv).setState(DBU0900021StateName.削除);
        }
        responseData.data = requestDiv;
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 取消するボタンが押下された場合、明細画面を閉じて、審査請求書一覧画面に遷移する。
     *
     * @param div SinsaSeikyusyoMeisaiPanelDiv
     * @return ResponseData<SinsaSeikyusyoMeisaiPanelDiv>
     */
    public ResponseData<SinsaSeikyusyoMeisaiPanelDiv> onClick_btnTorikeshi(SinsaSeikyusyoMeisaiPanelDiv div) {
        RString 修正後の値 = createHandlerOf(div).修正後の値();
        if ((追加.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class)))
                && getValidationHandler(div).変更有無チェック(修正後の値)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                createHandlerOf(div).内容の破棄();
                return ResponseData.of(div).forwardWithEventName(DBU0900021TransitionEventName.一覧に戻る).respond();
            } else {
                return ResponseData.of(div).respond();
            }
        }
        if ((修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class)))
                && getValidationHandler(div).変更有無チェック(createHandlerOf(div).修正後の値())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                createHandlerOf(div).内容の破棄();
                return ResponseData.of(div).forwardWithEventName(DBU0900021TransitionEventName.一覧に戻る).respond();
            } else {
                return ResponseData.of(div).respond();
            }
        }
        if ((削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class)))) {
            return ResponseData.of(div).forwardWithEventName(DBU0900021TransitionEventName.一覧に戻る).respond();
        }
        return ResponseData.of(div).forwardWithEventName(DBU0900021TransitionEventName.一覧に戻る).respond();
    }

    /**
     * 完了するボタン押下、メニュー画面へ遷移します。
     *
     * @param div SinsaSeikyusyoMeisaiPanelDiv
     * @return ResponseData<SinsaSeikyusyoMeisaiPanelDiv>
     */
    public ResponseData<SinsaSeikyusyoMeisaiPanelDiv> onClick_btnFinish(SinsaSeikyusyoMeisaiPanelDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBU0900021TransitionEventName.処理完了).respond();
    }

    /**
     * 保存するボタン押下、データがDBに更新します。
     *
     * @param div SinsaSeikyusyoMeisaiPanelDiv
     * @return ResponseData<SinsaSeikyusyoMeisaiPanelDiv>
     */
    public ResponseData<SinsaSeikyusyoMeisaiPanelDiv> onClick_btnUpdate(SinsaSeikyusyoMeisaiPanelDiv div) {

        if (!重複チェック(div)) {

            return ResponseData.of(div).addValidationMessages(getValidationHandler(div).validateForUpdate(重複チェック(div))).respond();
        }
        if (追加.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))
                && getValidationHandler(div).変更有無チェック(createHandlerOf(div).修正後の値())) {

            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                        UrQuestionMessages.保存の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

                ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get識別コード();
                HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号();
                FufukuMoshitate fufukuMoshitate = new FufukuMoshitate(識別コード,
                        被保険者番号,
                        new FlexibleDate(div.getMeisaiPanel().getTxtdateTodokedebi().getValue() == null
                                ? RString.EMPTY : div.getMeisaiPanel().getTxtdateTodokedebi().getValue().toDateString()));
                登録処理(createHandlerOf(div).審査請求書登録の編集(fufukuMoshitate));
                div.getCcdKanryoMessage().setSuccessMessage(
                        new RString(UrInformationMessages.保存終了.getMessage().evaluate()), RString.EMPTY, RString.EMPTY);
                return ResponseData.of(div).setState(DBU0900021StateName.完了);
            }
        }
        if (修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))
                && getValidationHandler(div).変更有無チェック(createHandlerOf(div).修正後の値())) {

            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                        UrQuestionMessages.保存の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

                FufukuMoshitate fufukuMoshitate = ViewStateHolder.get(ViewStateKeys.不服審査申立情報, FufukuMoshitate.class);
                更新処理(createHandlerOf(div).審査請求書更新の編集(fufukuMoshitate));
                div.getCcdKanryoMessage().setSuccessMessage(
                        new RString(UrInformationMessages.正常終了.getMessage().replace(更新.toString()).evaluate()), RString.EMPTY, RString.EMPTY);
                return ResponseData.of(div).setState(DBU0900021StateName.完了);
            }
        }
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {

            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                        UrQuestionMessages.保存の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

                削除処理();
                div.getCcdKanryoMessage().setSuccessMessage(
                        new RString(UrInformationMessages.対象データ削除済み.getMessage().evaluate()), RString.EMPTY, RString.EMPTY);
                return ResponseData.of(div).setState(DBU0900021StateName.完了);
            }
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    private boolean 重複チェック(SinsaSeikyusyoMeisaiPanelDiv div) {

        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get識別コード();
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号();
        return SinsaSeikyusyoTorokuManager.createInstance().
                checkSinsaSeikyuTodokede(識別コード,
                        被保険者番号,
                        ViewStateHolder.get(ViewStateKeys.審査請求届出日, FlexibleDate.class) == null
                        ? new FlexibleDate(RString.EMPTY) : ViewStateHolder.get(ViewStateKeys.審査請求届出日, FlexibleDate.class),
                        ViewStateHolder.get(ViewStateKeys.状態, RString.class),
                        new FlexibleDate(div.getMeisaiPanel().getTxtdateTodokedebi().getValue() == null
                                ? RString.EMPTY : div.getMeisaiPanel().getTxtdateTodokedebi().getValue().toDateString()));
    }

    private void 削除処理() {

        SinsaSeikyusyoTorokuManager.createInstance().delSinsaSeikyusyomeisaiJoho(ViewStateHolder.get(ViewStateKeys.不服審査申立情報, FufukuMoshitate.class));
    }

    private void 更新処理(FufukuMoshitate fufukuMoshitate) {

        SinsaSeikyusyoTorokuManager.createInstance().updSinsaSeikyusyomeisaiJoho(fufukuMoshitate);
    }

    private void 登録処理(FufukuMoshitate fufukuMoshitate) {

        SinsaSeikyusyoTorokuManager.createInstance().intSinsaSeikyusyomeisaiJoho(fufukuMoshitate);
    }

    private FufukuMoshitate 資格系基本情報の取得() {

        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get識別コード();
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号();
        return SinsaSeikyusyoTorokuManager.createInstance().
                getSinsaSeikyusyoMeisaiJoho(識別コード,
                        被保険者番号,
                        ViewStateHolder.get(ViewStateKeys.審査請求届出日, FlexibleDate.class));
    }

    private SinsaSeikyusyoMeisaiPanelHandler createHandlerOf(SinsaSeikyusyoMeisaiPanelDiv requestDiv) {
        return new SinsaSeikyusyoMeisaiPanelHandler(requestDiv);
    }

    private SinsaSeikyusyoMeisaiValidationHandler getValidationHandler(SinsaSeikyusyoMeisaiPanelDiv div) {
        return new SinsaSeikyusyoMeisaiValidationHandler(div);
    }
}
