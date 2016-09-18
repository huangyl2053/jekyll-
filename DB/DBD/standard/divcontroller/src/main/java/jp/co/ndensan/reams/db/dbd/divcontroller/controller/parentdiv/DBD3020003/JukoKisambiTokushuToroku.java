/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD3020003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.JikoKisambiKanri;
import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoKiSummary;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3020003.DBD3020003StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3020003.DBD3020003TransitionEventName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3020003.JukoKisambiTokushuTorokuDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD3020003.JukoKisambiTokushuTorokuHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD3020003.JukoKisambiTokushuTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 「時効起算日特殊登録」画面のControllerクラスです。
 *
 * @reamsid_L DBD-3820-010 huangh
 */
public class JukoKisambiTokushuToroku {

    private final RString 共通エリア_保存する = new RString("btnSave");

    /**
     * 時効起算日特殊登録の初期化。(オンロード)
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<JukoKisambiTokushuTorokuDiv> onLoad(JukoKisambiTokushuTorokuDiv div) {

        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        ShikibetsuCode 識別コード = taishoshaKey.get識別コード();
        ShoKisaiHokenshaNo 証記載保険者番号 = ViewStateHolder.get(ViewStateKeys.証記載保険者番号, ShoKisaiHokenshaNo.class);
        証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("880888"));
        div.setHdnShoKisaiHokenshaNo(証記載保険者番号 == null ? RString.EMPTY : 証記載保険者番号.getColumnValue());

        boolean データなし = true;
        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            div.getShunoJokyo().setDisabled(true);
            div.getJikoKisambi().setDisabled(true);
            div.getJikoKisambi().setIsOpen(false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(共通エリア_保存する, true);
            データなし = false;
        }

        if (!ResponseHolder.isReRequest() && !データなし) {
            return ResponseData.of(div).addMessage(DbdInformationMessages.受給共通_被保データなし.getMessage()).respond();
        }

        if (new RString(DbdInformationMessages.受給共通_被保データなし.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && MessageDialogSelectedResult.Yes == ResponseHolder.getButtonType()) {

            return ResponseData.of(div).forwardWithEventName(DBD3020003TransitionEventName.検索に戻る).respond();
        }

        List<TainoKiSummary> 滞納判定結果List = getHandler(div).initialize(被保険者番号, 識別コード);

        if (滞納判定結果List.isEmpty()) {
            div.getShunoJokyo().setDisabled(true);
            div.getJikoKisambi().setDisabled(true);
            div.getJikoKisambi().setIsOpen(false);
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }

        ViewStateHolder.put(ViewStateKeys.滞納判定結果, new ArrayList<>(滞納判定結果List));

        PersonalData personalData = PersonalData.of(識別コード, new ExpandedInformation(new Code("0003"),
                new RString("被保険者番号"), 被保険者番号.getColumnValue()));
        AccessLogger.log(AccessLogType.照会, personalData);

        boolean gotLock = 前排他キーのセット();
        if (!gotLock) {
            throw new PessimisticLockingException();
        }

        div.getDgShunoJokyo().setDisabled(false);
        div.getJikoKisambi().setIsOpen(false);
        div.getJikoKisambi().setDisabled(true);

        return ResponseData.of(div).respond();
    }

    /**
     * 検索するボタンです。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<JukoKisambiTokushuTorokuDiv> onClick_btnSearch(JukoKisambiTokushuTorokuDiv div) {

        if (!ResponseHolder.isReRequest()
                && getHandler(div).is変更判定for収納状況()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());

            return ResponseData.of(div).addMessage(message).respond();
        }

        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.No)) {
            return ResponseData.of(div).respond();
        }

        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        ShikibetsuCode 識別コード = taishoshaKey.get識別コード();
        List<TainoKiSummary> 滞納判定結果List = getHandler(div).initialize(被保険者番号, 識別コード);

        if (滞納判定結果List.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }

        ViewStateHolder.put(ViewStateKeys.滞納判定結果, new ArrayList<>(滞納判定結果List));

        div.getDgShunoJokyo().setDisabled(false);
        div.getJikoKisambi().setIsOpen(false);
        div.getJikoKisambi().setDisabled(true);
        return ResponseData.of(div).respond();
    }

    /**
     * gridのselect操作処理。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<JukoKisambiTokushuTorokuDiv> onClick_selectBySelectButton(JukoKisambiTokushuTorokuDiv div) {

        div.getDgShunoJokyo().setDisabled(true);
        div.getJikoKisambi().setIsOpen(true);
        div.getJikoKisambi().setDisabled(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(共通エリア_保存する, true);

        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();

        List<JikoKisambiKanri> 時効起算日管理List = ViewStateHolder.get(ViewStateKeys.時効起算日管理, new ArrayList<>().getClass());
        List<TainoKiSummary> 滞納判定結果List = ViewStateHolder.get(ViewStateKeys.滞納判定結果, new ArrayList<>().getClass());
        if (時効起算日管理List == null) {
            時効起算日管理List = new ArrayList<>();
        }
        List<JikoKisambiKanri> new時効起算日管理List
                = getHandler(div).onClick_selectBySelectButton(滞納判定結果List, 時効起算日管理List, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.時効起算日管理, new ArrayList<>(new時効起算日管理List));
        return ResponseData.of(div).respond();
    }

    /**
     * 再検索するボタンです。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<JukoKisambiTokushuTorokuDiv> onClick_btnResearch(JukoKisambiTokushuTorokuDiv div) {

        List<JikoKisambiKanri> 時効起算日管理List = ViewStateHolder.get(ViewStateKeys.時効起算日管理, new ArrayList<>().getClass());
        if (!ResponseHolder.isReRequest()
                && getHandler(div).is変更判定for時効起算日登録(時効起算日管理List)) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());

            return ResponseData.of(div).addMessage(message).respond();
        }

        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.No)) {
            return ResponseData.of(div).respond();
        }

        前排他キーの解除();
        return ResponseData.of(div).forwardWithEventName(DBD3020003TransitionEventName.検索に戻る).respond();
    }

    /**
     * クリアするボタンです。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<JukoKisambiTokushuTorokuDiv> onClick_btnClear(JukoKisambiTokushuTorokuDiv div) {

        List<JikoKisambiKanri> 時効起算日管理List = ViewStateHolder.get(ViewStateKeys.時効起算日管理, new ArrayList<>().getClass());
        if (!ResponseHolder.isReRequest()
                && getHandler(div).is変更判定for時効起算日登録(時効起算日管理List)) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());

            return ResponseData.of(div).addMessage(message).respond();
        }

        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.No)) {
            return ResponseData.of(div).respond();
        }

        return onClick_selectBySelectButton(div);
    }

    /**
     * 取消ボタンです。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<JukoKisambiTokushuTorokuDiv> onClick_btnTorikeshi(JukoKisambiTokushuTorokuDiv div) {

        List<JikoKisambiKanri> 時効起算日管理List = ViewStateHolder.get(ViewStateKeys.時効起算日管理, new ArrayList<>().getClass());
        if (!ResponseHolder.isReRequest()
                && getHandler(div).is変更判定for時効起算日登録(時効起算日管理List)) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());

            return ResponseData.of(div).addMessage(message).respond();
        }

        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.No)) {
            return ResponseData.of(div).respond();
        }

        div.getDgShunoJokyo().setDisabled(false);
        div.getJikoKisambi().setIsOpen(false);
        div.getJikoKisambi().setDisabled(true);

        return ResponseData.of(div).respond();
    }

    /**
     * 全行表示チェックボックスです。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<JukoKisambiTokushuTorokuDiv> onChange_chkZengyoHyoji(JukoKisambiTokushuTorokuDiv div) {

        getHandler(div).onChange_chkZengyoHyoji();
        return ResponseData.of(div).respond();
    }

    /**
     * 複写ボタンです。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<JukoKisambiTokushuTorokuDiv> onClick_btnIkkatsuFukusha(JukoKisambiTokushuTorokuDiv div) {

        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler(div).validateFor一括用特殊時効起算日の必須入力(pairs);
        getValidationHandler(div).validateFor一括用特殊時効起算日事由DDLの必須入力(pairs);

        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }

        getHandler(div).onClick_btnIkkatsuFukusha();
        return ResponseData.of(div).respond();
    }

    /**
     * 確定ボタンです。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<JukoKisambiTokushuTorokuDiv> onClick_btnKakutei(JukoKisambiTokushuTorokuDiv div) {

        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler(div).validateFor特殊時効起算日入力(pairs);

        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }

        List<JikoKisambiKanri> 時効起算日管理List = ViewStateHolder.get(ViewStateKeys.時効起算日管理, new ArrayList<>().getClass());
        List<JikoKisambiKanri> new時効起算日管理List = getHandler(div).onClick_btnKakutei(時効起算日管理List, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.時効起算日管理, new ArrayList<>(new時効起算日管理List));

        div.getDgShunoJokyo().setDisabled(false);
        div.getJikoKisambi().setIsOpen(false);
        div.getJikoKisambi().setDisabled(true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(共通エリア_保存する, false);
        return ResponseData.of(div).respond();
    }

    /**
     * 存するボタンです。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<JukoKisambiTokushuTorokuDiv> onClick_btnSave(JukoKisambiTokushuTorokuDiv div) {

        List<JikoKisambiKanri> 時効起算日管理List = ViewStateHolder.get(ViewStateKeys.時効起算日管理, new ArrayList<>().getClass());
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        ShikibetsuCode 識別コード = taishoshaKey.get識別コード();
        if (!getHandler(div).is変更判定for収納状況()) {

            throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
        }

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());

            return ResponseData.of(div).addMessage(message).respond();
        }

        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.No)) {
            return ResponseData.of(div).respond();
        }

        getHandler(div).onClick_btnSave(時効起算日管理List);

        PersonalData personalData = PersonalData.of(識別コード, new ExpandedInformation(new Code("0003"),
                new RString("被保険者番号"), 被保険者番号.getColumnValue()));
        AccessLogger.log(AccessLogType.更新, personalData);
        前排他キーの解除();
        div.getCcdKanryoMessage().setSuccessMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()));

        return ResponseData.of(div).setState(DBD3020003StateName.完了);
    }

    private JukoKisambiTokushuTorokuHandler getHandler(JukoKisambiTokushuTorokuDiv div) {
        return new JukoKisambiTokushuTorokuHandler(div);
    }

    private JukoKisambiTokushuTorokuValidationHandler getValidationHandler(JukoKisambiTokushuTorokuDiv div) {
        return new JukoKisambiTokushuTorokuValidationHandler(div);
    }

    private boolean 前排他キーのセット() {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        LockingKey 排他キー = new LockingKey(SubGyomuCode.DBD介護受給.getGyomuCode().getColumnValue()
                .concat(被保険者番号.getColumnValue()).concat(new RString("JikokisanbiToroku")));
        return RealInitialLocker.tryGetLock(排他キー);
    }

    private void 前排他キーの解除() {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        LockingKey 排他キー = new LockingKey(SubGyomuCode.DBD介護受給.getGyomuCode().getColumnValue()
                .concat(被保険者番号.getColumnValue()).concat(new RString("JikokisanbiToroku")));
        RealInitialLocker.release(排他キー);
    }
}
