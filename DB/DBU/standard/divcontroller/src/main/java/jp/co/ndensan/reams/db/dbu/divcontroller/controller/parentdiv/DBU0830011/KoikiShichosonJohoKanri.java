package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0830011;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0830011.DBU0830011StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0830011.KoikiShichosonJohoKanriDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0830011.KoikiShichosonJohoKanriHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 広域システム管理のクラスです。
 *
 * @reamsid_L DBU-4010-010 duanzhanli
 */
public class KoikiShichosonJohoKanri {

    private static final LockingKey LOCKINGKEY = new LockingKey("DBU0830011");
    private static final QuestionMessage SYORIMESSAGE = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
            UrQuestionMessages.処理実行の確認.getMessage().evaluate());

    /**
     * 広域システム管理を初期化します。
     *
     * @param div KoikiShichosonJohoKanriDiv
     * @return ResponseData<KoikiShichosonJohoKanriDiv>
     */
    public ResponseData<KoikiShichosonJohoKanriDiv> onLoad(KoikiShichosonJohoKanriDiv div) {
        getHandler(div).onLoad();
        if (!RealInitialLocker.tryGetLock(LOCKINGKEY)) {
            throw new ApplicationException(UrErrorMessages.排他_他のユーザが使用中.getMessage());
        }
        return ResponseData.of(div).setState(DBU0830011StateName.初期状態);
    }

    /**
     * 適用情報Grid。
     *
     * @param div KoikiShichosonJohoKanriDiv
     * @return ResponseData<KoikiShichosonJohoKanriDiv>
     */
    public ResponseData<KoikiShichosonJohoKanriDiv> onClick_dgSelect(KoikiShichosonJohoKanriDiv div) {
        getHandler(div).適用情報の編集();
        return ResponseData.of(div).setState(DBU0830011StateName.メンテナンス状態);
    }

    /**
     * 保存するボタン押下、データがDBに更新します。
     *
     * @param requestDiv KoikiShichosonJohoKanriDiv
     * @return ResponseData<KoikiShichosonJohoKanriDiv>
     */
    public ResponseData<KoikiShichosonJohoKanriDiv> onClick_btnUpdate(KoikiShichosonJohoKanriDiv requestDiv) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(requestDiv).addMessage(SYORIMESSAGE).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(requestDiv).update市町村管理();
            RealInitialLocker.release(LOCKINGKEY);
            return ResponseData.of(requestDiv).setState(DBU0830011StateName.完了状態);
        }
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 戻るボタン押下、初期状態に戻る。
     *
     * @param requestDiv KoikiShichosonJohoKanriDiv
     * @return ResponseData<KoikiShichosonJohoKanriDiv>
     */
    public ResponseData<KoikiShichosonJohoKanriDiv> onClick_btnBack(KoikiShichosonJohoKanriDiv requestDiv) {
        getHandler(requestDiv).onLoad();
        return ResponseData.of(requestDiv).setState(DBU0830011StateName.初期状態);
    }

    /**
     * 完了するボタンを押下します。
     *
     * @param requestDiv KoikiShichosonJohoKanriDiv
     * @return ResponseData<KoikiShichosonJohoKanriDiv>
     */
    public ResponseData<KoikiShichosonJohoKanriDiv> onClick_btnComplete(KoikiShichosonJohoKanriDiv requestDiv) {
        RealInitialLocker.release(LOCKINGKEY);
        return ResponseData.of(requestDiv).respond();
    }

    private KoikiShichosonJohoKanriHandler getHandler(KoikiShichosonJohoKanriDiv div) {
        return new KoikiShichosonJohoKanriHandler(div);
    }
}
