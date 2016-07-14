/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA1040011;

import jp.co.ndensan.reams.db.dba.business.core.hihokenshadaicho.HihokenshaShutokuJyoho;
import jp.co.ndensan.reams.db.dba.definition.message.DbaErrorMessages;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1040011.DBA1040011StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1040011.DBA1040011TransitionEventName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1040011.ShikakuHenkouIdouDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1040011.ShikakuHenkouIdouHandler;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshadaicho.HihokenshaShikakuShutokuManager;
import jp.co.ndensan.reams.db.dba.service.core.shikakuhenkouidou.HihokenshaShikakuHenkoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 資格変更異動のコントローラです。
 *
 * @reamsid_L DBA-1370-030 chengsanyuan
 */
public class ShikakuHenkouIdou {

    private static final LockingKey 前排他ロックキー = new LockingKey("ShikakuHenkoIdo");
    private final HihokenshaShikakuHenkoManager henkoManager;
    private final HihokenshaShikakuShutokuManager shutokuManager;

    /**
     * コンストラクタです。
     *
     */
    public ShikakuHenkouIdou() {
        this.henkoManager = HihokenshaShikakuHenkoManager.createInstance();
        this.shutokuManager = HihokenshaShikakuShutokuManager.createInstance();
    }

    /**
     * 資格変更異動初期化の設定します。
     *
     * @param div 資格変更異動DIV
     * @return ResponseData<ShikakuHenkouIdouDiv>
     */
    public ResponseData<ShikakuHenkouIdouDiv> onLoad(ShikakuHenkouIdouDiv div) {
        TaishoshaKey key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        div.getCcdKaigoAtenaInfo().initialize(key.get識別コード());
        if (key.get被保険者番号() == null) {
            div.getCcdKaigoShikakuKihon().setVisible(true);
        } else {
            div.getCcdKaigoShikakuKihon().initialize(key.get被保険者番号());
        }
        HihokenshaShutokuJyoho hihokensha = shutokuManager.getSaishinDeta(
                key.get識別コード(), key.get被保険者番号());
        getHandler(div).load(hihokensha);
        if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
            div.setReadOnly(true);
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(new ValidationMessageControlPair(ShikakuHenkouValidationMessages.排他_他のユーザが使用中));
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 保存するボタン押下の場合、各タブのデータの登録、修正、削除など処理を実行する。
     *
     * @param div 資格変更異動DIV
     * @return ResponseData<ShikakuHenkouIdouDiv>
     */
    public ResponseData<ShikakuHenkouIdouDiv> onClick_btnUpdate(ShikakuHenkouIdouDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            saveGamenData(div);
        }
        if (ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.No)) {
            return ResponseData.of(div).respond();
        }
        RealInitialLocker.release(前排他ロックキー);
        div.getCcdKaigoKanryoMessage().setSuccessMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()));
        return ResponseData.of(div).setState(DBA1040011StateName.完了状態);
    }

    /**
     * 対象者検索に戻るボタン押下の場合、対象者検索画面に戻る
     *
     * @param div 資格変更異動DIV
     * @return ResponseData<ShikakuHenkouIdouDiv>
     */
    public ResponseData<ShikakuHenkouIdouDiv> onClick_btnReSearch(ShikakuHenkouIdouDiv div) {
        RealInitialLocker.release(前排他ロックキー);
        if (new RString("DBAMN61002").equals(ResponseHolder.getMenuID())) {
            return ResponseData.of(div).forwardWithEventName(DBA1040011TransitionEventName.再検索).parameter(new RString("広域内転居"));
        }
        return ResponseData.of(div).forwardWithEventName(DBA1040011TransitionEventName.再検索).respond();
    }

    private ShikakuHenkouIdouHandler getHandler(ShikakuHenkouIdouDiv div) {
        return new ShikakuHenkouIdouHandler(div);
    }

    private void saveGamenData(ShikakuHenkouIdouDiv div) {
        for (HihokenshaDaicho hihokensha : div.getCcdHihosyosai().getGridData().records()) {
            if (hihokensha.isAdded()) {
                DbaErrorMessages error = henkoManager.shikakuHenkoTorokuCheck(
                        hihokensha.get識別コード(), hihokensha.get被保険者番号(), hihokensha.get資格変更年月日(),
                        ShikakuHenkoJiyu.toValue(hihokensha.get資格変更事由コード()),
                        div.getCcdKaigoAtenaInfo().getShokaiData().getTxtSeinengappiYMD().getValue());
                if (error != null) {
                    throw new ApplicationException(error.getMessage());
                }
                henkoManager.saveHihokenshaHenko(hihokensha);
            }
        }
        div.getCcdHihosyosai().施設入退所保存処理();
    }

    private static enum ShikakuHenkouValidationMessages implements IValidationMessage {

        排他_他のユーザが使用中(UrErrorMessages.排他_他のユーザが使用中);
        private final Message message;

        private ShikakuHenkouValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
