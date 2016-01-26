/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.dbe2210002;

import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.gaikyotokki.GaikyoTokki;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.gaikyotokki.GaikyoTokkiBuilder;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210002.DBE2210002TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210002.GaikyoTokkiNyurokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.dbe2210002.GaikyoTokkiNyurokuHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.gaikyotokki.GaikyoTokkiManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 概況特記登録のクラス。
 */
public class GaikyoTokkiNyuroku {

    private static final RString 保存 = new RString("保存");
    private static final RString 登録グループコード_1 = new RString("1");

    /**
     * コントロールdivが「生成」された際の処理です。(オンロード)<br/>
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<GaikyoTokkiNyurokuDiv> onLoad(GaikyoTokkiNyurokuDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * コントロールdivが「生成」された際の処理です。(オンアクティブ)<br/>
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<GaikyoTokkiNyurokuDiv> onActive(GaikyoTokkiNyurokuDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 「前回値をコピーする」ボタンを押して、前回概況情報を取得して、画面にセットします。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiNyurokuDiv> onClick_btnZenkaiCopy(GaikyoTokkiNyurokuDiv div) {

        if (!ResponseHolder.isReRequest() && (!div.getTxtJutakuKaishu().getValue().isEmpty()
                || !div.getTxtChosaTaishoShuso().getValue().isEmpty()
                || !div.getTxtChosaTishoKazokuJokyo().getValue().isEmpty()
                || !div.getTxtChosaTaishoKyojuKankyo().getValue().isEmpty()
                || !div.getTxtNichijoShiyoKikiUmu().getValue().isEmpty())) {
            WarningMessage message = new WarningMessage(UrWarningMessages.未保存情報の破棄確認.getMessage().getCode(),
                    UrWarningMessages.未保存情報の破棄確認.getMessage().replace(new RString("既に記載した概況情報").toString()).evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrWarningMessages.未保存情報の破棄確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).zenkaiCopy();
            return ResponseData.of(div).respond();
        }
        getHandler(div).zenkaiCopy();
        return ResponseData.of(div).respond();
    }

    /**
     * 調査結果を保存します。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiNyurokuDiv> onClick_btnUpdate(GaikyoTokkiNyurokuDiv div) {

        // TODO 未入力の判断 QA 74885

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            LockingKey 排他キー = new LockingKey(SubGyomuCode.DBE認定支援.getGyomuCode().getColumnValue().concat(new RString("ShinseishoKanriNo"))
                    .concat(getHandler(div).getTemp_申請書管理番号().getColumnValue()));
            boolean getLock = RealInitialLocker.tryGetLock(排他キー);
            if (getLock) {
                調査結果保存(div);
                RealInitialLocker.release(排他キー);
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace(保存.toString())).respond();
            } else {
                throw new ApplicationException(UrErrorMessages.排他_バッチ実行中で更新不可.getMessage());
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 概況調査入力（DBE2210001）へ遷移します。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiNyurokuDiv> onClick_btnBack(GaikyoTokkiNyurokuDiv div) {

        if (!ResponseHolder.isReRequest() && (!div.getTxtJutakuKaishu().getValue().isEmpty()
                || !div.getTxtChosaTaishoShuso().getValue().isEmpty()
                || !div.getTxtChosaTishoKazokuJokyo().getValue().isEmpty()
                || !div.getTxtChosaTaishoKyojuKankyo().getValue().isEmpty()
                || !div.getTxtNichijoShiyoKikiUmu().getValue().isEmpty())) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                    UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBE2210002TransitionEventName.認定調査結果登録へ戻る).respond();
        }
        return ResponseData.of(div).forwardWithEventName(DBE2210002TransitionEventName.認定調査結果登録へ戻る).respond();
    }

    /**
     * 入力内容を取り消します。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiNyurokuDiv> onClick_btnCancel(GaikyoTokkiNyurokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).clearData();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログが開かれる前のイベントメソッドです。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiNyurokuDiv> onBeforeOpenDialog_setDialogParameter(GaikyoTokkiNyurokuDiv div) {
        div.setHidden登録業務コード(GyomuCode.DB介護保険.getColumnValue());
        div.setHidden登録グループコード(登録グループコード_1);
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログで選択された定型文情報を住宅改修txtへセットします。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiNyurokuDiv> onOkClose_btnSelectJutakuKaishu(GaikyoTokkiNyurokuDiv div) {
        div.getTxtJutakuKaishu().setValue(div.getHiddenサンプル文書());
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログで選択された定型文情報を調査対象者の主訴txtへセットします。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiNyurokuDiv> onOkClose_btnSelectChosaTishoShuso(GaikyoTokkiNyurokuDiv div) {
        div.getTxtChosaTaishoShuso().setValue(div.getHiddenサンプル文書());
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログで選択された定型文情報を調査対象者の家族状況txtへセットします。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiNyurokuDiv> onOkClose_btnSelectChosaTaishoKazokuJokyo(GaikyoTokkiNyurokuDiv div) {
        div.getTxtChosaTishoKazokuJokyo().setValue(div.getHiddenサンプル文書());
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログで選択された定型文情報を調査対象者の居住環境txtへセットします。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiNyurokuDiv> onOkClose_btnSelectChosaTaishoKyojuKankyo(GaikyoTokkiNyurokuDiv div) {
        div.getTxtChosaTaishoKyojuKankyo().setValue(div.getHiddenサンプル文書());
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログで選択された定型文情報を機器・器械txtへセットします。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiNyurokuDiv> onOkClose_btnSelectNichijoShiyoKikiUmu(GaikyoTokkiNyurokuDiv div) {
        div.getTxtNichijoShiyoKikiUmu().setValue(div.getHiddenサンプル文書());
        return ResponseData.of(div).respond();
    }

    private void 調査結果保存(GaikyoTokkiNyurokuDiv div) {

        GaikyoTokkiManager manager = new GaikyoTokkiManager();
        GaikyoTokki 認定調査票_概況特記 = manager.get認定調査票_概況特記(getHandler(div).getTemp_申請書管理番号(), getHandler(div).getTemp_認定調査履歴番号());
        GaikyoTokkiBuilder builder = 認定調査票_概況特記.createBuilderForEdit();

        // TODO QA 74645 住宅改修
        builder.set概況特記事項_主訴(div.getTxtChosaTaishoShuso().getValue());
        builder.set概況特記事項_家族状況(div.getTxtChosaTishoKazokuJokyo().getValue());
        builder.set概況特記事項_居住環境(div.getTxtChosaTaishoKyojuKankyo().getValue());
        builder.set概況特記事項_機器_器械(div.getTxtNichijoShiyoKikiUmu().getValue());

        manager.save認定調査票_概況特記(builder.build());
    }

    private GaikyoTokkiNyurokuHandler getHandler(GaikyoTokkiNyurokuDiv div) {
        return new GaikyoTokkiNyurokuHandler(div);
    }

}
