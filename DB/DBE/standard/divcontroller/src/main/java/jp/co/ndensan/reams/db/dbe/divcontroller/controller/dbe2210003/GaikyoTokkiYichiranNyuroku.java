/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.dbe2210003;

import jp.co.ndensan.reams.db.dbe.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210003.DBE2210003TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210003.GaikyoTokkiYichiranNyurokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2210003.GaikyoTokkiYichiranNyurokuHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 認定調査結果登録3のクラス。
 *
 */
public class GaikyoTokkiYichiranNyuroku {

    private final int int3 = 3;
    private final int int4 = 4;
    private final int int5 = 5;

    /**
     * 認定調査結果登録3初期化の設定します。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onLoad(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        handler.onLoad();
        boolean gotLock = 前排他キーのセット();
        if (!gotLock) {
            ErrorMessage message = new ErrorMessage(UrErrorMessages.排他_バッチ実行中で更新不可.getMessage().getCode(),
                    UrErrorMessages.排他_バッチ実行中で更新不可.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「前へ」ボタンの操作処理を行う。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onClick_btnBeforeTokkiJiko(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        handler.onClick_btnBeforeTokkiJiko();

        return ResponseData.of(div).respond();
    }

    /**
     * 「次へ」ボタンの操作処理を行う。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onClick_btnAfterTokkiJiko(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        handler.onClick_btnAfterTokkiJiko();

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項番号1 lostfocus。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onBlur_ChosaKomokuNo1(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        handler.onBlur_ChosaKomokuNo1();

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項番号2 lostfocus。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onBlur_ChosaKomokuNo2(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        handler.onBlur_ChosaKomokuNo2();

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項番号3 lostfocus。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onBlur_ChosaKomokuNo3(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        handler.onBlur_ChosaKomokuNo3();

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項番号4 lostfocus。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onBlur_ChosaKomokuNo4(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        handler.onBlur_ChosaKomokuNo4();

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項番号5 lostfocus。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onBlur_ChosaKomokuNo5(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        handler.onBlur_ChosaKomokuNo5();

        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログが開かれる前のイベントメソッドです。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onBeforeOpenDialog_setDialogParameter(GaikyoTokkiYichiranNyurokuDiv div) {
        div.getTokkiNyuryoku().setHidden登録業務コード(SubGyomuCode.DBE認定支援.getColumnValue());
        div.getTokkiNyuryoku().setHidden登録グループコード(new RString("1"));
        return ResponseData.of(div).respond();
    }

    /**
     * 定型文ボタン１をタップ。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onOkClose_btnFirstTokkiJikoTeikeibun(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        div.getTokkiNyuryoku().getTxtFirstTokkiJiko().setValue(div.getTokkiNyuryoku().getHiddenサンプル文書());
        handler.tokkiJikoHasChanged(1, div.getTokkiNyuryoku().getHiddenサンプル文書());

        return ResponseData.of(div).respond();
    }

    /**
     * 定型文ボタン２をタップ。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onOkClose_btnSecondTokkiJikoTeikeibun(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        div.getTokkiNyuryoku().getTxtSecondTokkiJiko().setValue(div.getTokkiNyuryoku().getHiddenサンプル文書());
        handler.tokkiJikoHasChanged(2, div.getTokkiNyuryoku().getHiddenサンプル文書());

        return ResponseData.of(div).respond();
    }

    /**
     * 定型文ボタン３をタップ。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onOkClose_btnThirdTokkiJikoTeikeibun(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        div.getTokkiNyuryoku().getTxtThirdTokkiJiko().setValue(div.getTokkiNyuryoku().getHiddenサンプル文書());
        handler.tokkiJikoHasChanged(int3, div.getTokkiNyuryoku().getHiddenサンプル文書());

        return ResponseData.of(div).respond();
    }

    /**
     * 定型文ボタン４をタップ。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onOkClose_btnFourthTokkiJikoTeikeibun(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        div.getTokkiNyuryoku().getTxtFourthTokkiJiko().setValue(div.getTokkiNyuryoku().getHiddenサンプル文書());
        handler.tokkiJikoHasChanged(int4, div.getTokkiNyuryoku().getHiddenサンプル文書());

        return ResponseData.of(div).respond();
    }

    /**
     * 定型文ボタン５をタップ。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onOkClose_btnFifthTokkiJikoTeikeibun(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        div.getTokkiNyuryoku().getTxtFifthTokkiJiko().setValue(div.getTokkiNyuryoku().getHiddenサンプル文書());
        handler.tokkiJikoHasChanged(int5, div.getTokkiNyuryoku().getHiddenサンプル文書());

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項１が変更した処理。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onChange_txtFirstTokkiJiko(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        handler.tokkiJikoHasChanged(1, div.getTokkiNyuryoku().getTxtFirstTokkiJiko().getValue());

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項２が変更した処理。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onChange_txtSecondTokkiJiko(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        handler.tokkiJikoHasChanged(2, div.getTokkiNyuryoku().getTxtSecondTokkiJiko().getValue());

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項３が変更した処理。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onChange_txtThirdTokkiJiko(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        handler.tokkiJikoHasChanged(int3, div.getTokkiNyuryoku().getTxtThirdTokkiJiko().getValue());

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項４が変更した処理。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onChange_txtFourthTokkiJiko(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        handler.tokkiJikoHasChanged(int4, div.getTokkiNyuryoku().getTxtFourthTokkiJiko().getValue());

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項５が変更した処理。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onChange_txtFifthTokkiJiko(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        handler.tokkiJikoHasChanged(int5, div.getTokkiNyuryoku().getTxtFifthTokkiJiko().getValue());

        return ResponseData.of(div).respond();
    }

    /**
     * 「戻る」ボタンの操作処理を行う。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onClick_btnBack(GaikyoTokkiYichiranNyurokuDiv div) {

        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        boolean notEmpty = handler.onClick_btnBack();

        if (!ResponseHolder.isReRequest() && (notEmpty)) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                    UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBE2210003TransitionEventName.認定調査結果登録に戻る).respond();
        }
        return ResponseData.of(div).forwardWithEventName(DBE2210003TransitionEventName.認定調査結果登録に戻る).respond();
    }

    /**
     * 入力内容を取り消します。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onClick_btnCancel(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            handler.onClick_btnCancel();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「特記事項を保存する」ボタンの操作処理を行う。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onClick_Save(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            handler.onClick_Save();
            前排他キーの解除();
        }

        return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace("保存")).respond();

    }

    private boolean 前排他キーのセット() {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        LockingKey 排他キー = new LockingKey(SubGyomuCode.DBE認定支援.getGyomuCode().getColumnValue().concat(new RString("ShinseishoKanriNo"))
                .concat(temp_申請書管理番号.getColumnValue()));
        return RealInitialLocker.tryGetLock(排他キー);
    }

    private void 前排他キーの解除() {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        LockingKey 排他キー = new LockingKey(SubGyomuCode.DBE認定支援.getGyomuCode().getColumnValue().concat(new RString("ShinseishoKanriNo"))
                .concat(temp_申請書管理番号.getColumnValue()));
        RealInitialLocker.release(排他キー);
    }
}
