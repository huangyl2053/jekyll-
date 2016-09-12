package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0830011;

import jp.co.ndensan.reams.db.dbe.business.core.basic.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbe.business.core.basic.KoseiShichosonMasterBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.basic.KoseiShichosonMasterIdentifier;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0830011.DBU0830011StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0830011.KoikiShichosonJohoKanriDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0830011.dgKoikiShichosonSelect_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0830011.KoikiShichosonJohoKanriHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0830011.KoikiShichosonJohoKanriValidationHandler;
import jp.co.ndensan.reams.db.dbu.service.core.koikishichosonjohokanri.KoikiShichosonJohoKanriManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 広域システム管理のクラスです。
 *
 * @reamsid_L DBU-4010-010 duanzhanli
 */
public class KoikiShichosonJohoKanri {

    /**
     * 広域システム管理を初期化します。
     *
     * @param div KoikiShichosonJohoKanriDiv
     * @return ResponseData<KoikiShichosonJohoKanriDiv>
     */
    public ResponseData<KoikiShichosonJohoKanriDiv> onLoad(KoikiShichosonJohoKanriDiv div) {
        if (!RealInitialLocker.tryGetLock(new LockingKey(UrControlDataFactory.createInstance().getMenuID()))) {
            throw new PessimisticLockingException();
        }
        getHandler(div).onLoad(KoikiShichosonJohoKanriManager.createInstance().get広域市町村一覧().records());
        return ResponseData.of(div).setState(DBU0830011StateName.初期状態);
    }

    /**
     * 適用情報Grid。
     *
     * @param div KoikiShichosonJohoKanriDiv
     * @return ResponseData<KoikiShichosonJohoKanriDiv>
     */
    public ResponseData<KoikiShichosonJohoKanriDiv> onClick_dgSelect(KoikiShichosonJohoKanriDiv div) {
        dgKoikiShichosonSelect_Row row = getHandler(div).get適用情報一覧該当行();
        KoseiShichosonMaster master = KoikiShichosonJohoKanriManager.createInstance().getメンテナンス情報(row.getKoikiNaiNo()).records().get(0);
        ViewStateHolder.put(ViewStateKeys.広域内市町村情報, Models.create(KoikiShichosonJohoKanriManager.
                createInstance().getメンテナンス情報(row.getKoikiNaiNo()).records()));
        getHandler(div).適用情報の編集(row, master);
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
            return ResponseData.of(requestDiv).addMessage(new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate())).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            check(validationMessages, requestDiv);
            if (validationMessages.iterator().hasNext()) {
                return ResponseData.of(requestDiv).addValidationMessages(validationMessages).respond();
            } else {
                save市町村管理(requestDiv);
            }
            requestDiv.getKanryoMessage().getCcdKaigoKanryoMessage().setMessage(
                    new RString("広域市町村制御メンテナンス_保存処理は正常に行われました。"), RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(requestDiv).setState(DBU0830011StateName.完了状態);
        }
        return ResponseData.of(requestDiv).respond();
    }

    private void save市町村管理(KoikiShichosonJohoKanriDiv requestDiv) {
        Models<KoseiShichosonMasterIdentifier, KoseiShichosonMaster> 修正前市町村Models
                = ViewStateHolder.get(ViewStateKeys.広域内市町村情報, Models.class);
        KoseiShichosonMaster 修正前市町村 = 修正前市町村Models.get(new KoseiShichosonMasterIdentifier(
                getHandler(requestDiv).get市町村識別ID()));
        KoseiShichosonMasterBuilder 市町村管理Builder = 修正前市町村.createBuilderForEdit();
        KoikiShichosonJohoKanriManager.createInstance().save市町村Master(getHandler(requestDiv).get市町村管理情報(市町村管理Builder));
    }

    private void check(ValidationMessageControlPairs validationMessages, KoikiShichosonJohoKanriDiv requestDiv) {
        if (getHandler(requestDiv).is期間チェックフラグ()) {
            validationMessages.add(getValidationHandler().validateFor期間チェック(getHandler(requestDiv).get加入日(),
                    getHandler(requestDiv).get脱退日(), requestDiv));
        }
        if (getHandler(requestDiv).isUpdate()) {
            validationMessages.add(getValidationHandler().validateFor更新内容チェック());
        }
    }

    /**
     * 戻るボタン押下、初期状態に戻る。
     *
     * @param requestDiv KoikiShichosonJohoKanriDiv
     * @return ResponseData<KoikiShichosonJohoKanriDiv>
     */
    public ResponseData<KoikiShichosonJohoKanriDiv> onClick_btnBack(KoikiShichosonJohoKanriDiv requestDiv) {
        getHandler(requestDiv).onLoad(KoikiShichosonJohoKanriManager.createInstance().get広域市町村一覧().records());
        return ResponseData.of(requestDiv).setState(DBU0830011StateName.初期状態);
    }

    /**
     * 完了するボタンを押下します。
     *
     * @param requestDiv KoikiShichosonJohoKanriDiv
     * @return ResponseData<KoikiShichosonJohoKanriDiv>
     */
    public ResponseData<KoikiShichosonJohoKanriDiv> onClick_btnComplete(KoikiShichosonJohoKanriDiv requestDiv) {
        RealInitialLocker.release(new LockingKey(UrControlDataFactory.createInstance().getMenuID()));
        return ResponseData.of(requestDiv).respond();
    }

    private KoikiShichosonJohoKanriHandler getHandler(KoikiShichosonJohoKanriDiv div) {
        return new KoikiShichosonJohoKanriHandler(div);
    }

    private KoikiShichosonJohoKanriValidationHandler getValidationHandler() {
        return new KoikiShichosonJohoKanriValidationHandler();
    }
}
