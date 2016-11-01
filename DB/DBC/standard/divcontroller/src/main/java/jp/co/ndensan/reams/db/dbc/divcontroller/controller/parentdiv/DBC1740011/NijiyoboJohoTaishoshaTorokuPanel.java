/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1740011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.NijiYoboJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.business.core.nijiyobojigyotaishosha.NijiYoboJigyoTaishoshaHolder;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1740011.DBC1740011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1740011.DBC1740011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1740011.NijiyoboJohoTaishoshaTorokuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1740011.dgNijiyoboJohoTaishoIchiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1740011.NijiyoboJohoTaishoshaTorokuPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1740011.NijiyoboJohoTaishoshaTorokuPanelValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.basic.NijiYoboJigyoTaishoshaManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 総合事業（経過措置）対象者登録
 *
 * @reamsid_L DBC-2400-010 yuqingzhang
 */
public class NijiyoboJohoTaishoshaTorokuPanel {

    private static final RString 排他キー_前 = new RString("DBCHihokenshaNo");
    private static final RString 削除 = new RString("削除");
    private static final RString BTN_保存する = new RString("btnUpdate");
    private static final RString 引数_被保険者番号なし = new RString("被保険者番号なし");
    private static final RString FALSE_排他失敗 = new RString("false");

    private NijiyoboJohoTaishoshaTorokuPanelHandler getHandler(NijiyoboJohoTaishoshaTorokuPanelDiv div) {
        return new NijiyoboJohoTaishoshaTorokuPanelHandler(div);
    }

    private NijiyoboJohoTaishoshaTorokuPanelValidationHandler getValidationHandler(NijiyoboJohoTaishoshaTorokuPanelDiv div) {
        return new NijiyoboJohoTaishoshaTorokuPanelValidationHandler(div);
    }

    /**
     * 総合事業（経過措置）対象者登録画面 初期化を処理します。
     *
     * @param div NijiyoboJohoTaishoshaTorokuPanelDiv
     * @return 画面
     */
    public ResponseData<NijiyoboJohoTaishoshaTorokuPanelDiv> onLoad(NijiyoboJohoTaishoshaTorokuPanelDiv div) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(
                jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys.資格対象者, TaishoshaKey.class);
        if (null == 資格対象者 || null == 資格対象者.get被保険者番号()
                || RString.isNullOrEmpty(資格対象者.get被保険者番号().getColumnValue())) {
            throw new ApplicationException(DbzErrorMessages.理由付き登録不可.getMessage().
                    replace(引数_被保険者番号なし.toString()));
        }
        LockingKey 前排他キー = new LockingKey(排他キー_前.concat(資格対象者.get被保険者番号().getColumnValue()));
        if (!RealInitialLocker.tryGetLock(前排他キー)) {
            throw new PessimisticLockingException();
        }
        getHandler(div).排他失敗flagを設定する(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN_保存する, false);
        NijiYoboJigyoTaishoshaManager manager = new NijiYoboJigyoTaishoshaManager();
        List<NijiYoboJigyoTaishosha> 二次予防情報対象一覧List
                = manager.get二次予防事業対象者By被保険者番号(資格対象者.get被保険者番号());
        getHandler(div).onLoad(資格対象者, 二次予防情報対象一覧List);
        if (null != 二次予防情報対象一覧List && (!二次予防情報対象一覧List.isEmpty())) {
            ViewStateHolder.put(ViewStateHolderName.二次予防情報対象情報, new NijiYoboJigyoTaishoshaHolder(二次予防情報対象一覧List));
        }
        onState(div);
        アクセスログの出力_照会(資格対象者.get識別コード(), 資格対象者.get被保険者番号());
        return ResponseData.of(div).respond();
    }

    private void アクセスログの出力_照会(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        PersonalData personalData = PersonalData.of(識別コード,
                new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号.value()));
        AccessLogger.log(AccessLogType.照会, personalData);
    }

    /**
     * 総合事業（経過措置）対象者登録画面 「追加する」ボタンを処理します。
     *
     * @param div NijiyoboJohoTaishoshaTorokuPanelDiv
     * @return 画面
     */
    public ResponseData<NijiyoboJohoTaishoshaTorokuPanelDiv> onClick_btnAdd(NijiyoboJohoTaishoshaTorokuPanelDiv div) {
        getHandler(div).onClick_btnAdd();
        return ResponseData.of(div).respond();
    }

    /**
     * 総合事業（経過措置）対象者登録画面 データグリッド上の修正アイコンを処理します。
     *
     * @param div NijiyoboJohoTaishoshaTorokuPanelDiv
     * @return 画面
     */
    public ResponseData<NijiyoboJohoTaishoshaTorokuPanelDiv> onClick_dgModify(NijiyoboJohoTaishoshaTorokuPanelDiv div) {
        getHandler(div).onClick_dgModify();
        return ResponseData.of(div).respond();
    }

    /**
     * 総合事業（経過措置）対象者登録画面 データグリッド上の削除アイコンを処理します。
     *
     * @param div NijiyoboJohoTaishoshaTorokuPanelDiv
     * @return 画面
     */
    public ResponseData<NijiyoboJohoTaishoshaTorokuPanelDiv> onClick_dgDelete(NijiyoboJohoTaishoshaTorokuPanelDiv div) {
        getHandler(div).onClick_dgDelete();
        CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN_保存する, false);
        return ResponseData.of(div).respond();
    }

    /**
     * 総合事業（経過措置）対象者登録画面 「確定する」ボタンを処理します。
     *
     * @param div NijiyoboJohoTaishoshaTorokuPanelDiv
     * @return 画面
     */
    public ResponseData<NijiyoboJohoTaishoshaTorokuPanelDiv> onClick_btnConfim(NijiyoboJohoTaishoshaTorokuPanelDiv div) {
        ValidationMessageControlPairs pairs;
        if (!削除.equals(div.getOperateState())) {
            pairs = getValidationHandler(div).validate();
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        getHandler(div).onClick_btnConfim();
        return ResponseData.of(div).setState(DBC1740011StateName.Default);
    }

    /**
     * 総合事業（経過措置）対象者登録画面 「取消する」ボタンを処理します。
     *
     * @param div NijiyoboJohoTaishoshaTorokuPanelDiv
     * @return 画面
     */
    public ResponseData<NijiyoboJohoTaishoshaTorokuPanelDiv> onClick_btnCancel(NijiyoboJohoTaishoshaTorokuPanelDiv div) {
        getHandler(div).onClick_btnCancel();
        return ResponseData.of(div).setState(DBC1740011StateName.Default);
    }

    /**
     * 総合事業（経過措置）対象者登録画面 「保存する」ボタンを処理します。
     *
     * @param div NijiyoboJohoTaishoshaTorokuPanelDiv
     * @return 画面
     */
    public ResponseData<NijiyoboJohoTaishoshaTorokuPanelDiv> onClick_btnUpdate(NijiyoboJohoTaishoshaTorokuPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            NijiYoboJigyoTaishoshaHolder holder = ViewStateHolder.get(ViewStateHolderName.二次予防情報対象情報, NijiYoboJigyoTaishoshaHolder.class);
            getHandler(div).二次予防情報対象一覧のデータを保存する(
                    div.getNijiyoboJohoTaishoIchiran().getDgNijiyoboJohoTaishoIchiran().getDataSource(),
                    new HihokenshaNo(div.get被保険者番号()), holder);
            前排他のロックを解除し(div);
            アクセスログの出力_更新(new ShikibetsuCode(div.get識別コード()), new HihokenshaNo(div.get被保険者番号()));
            return ResponseData.of(div).setState(DBC1740011StateName.kanryo);
        }
        return ResponseData.of(div).respond();
    }

    private void アクセスログの出力_更新(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        PersonalData personalData = PersonalData.of(識別コード,
                new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号.value()));
        AccessLogger.log(AccessLogType.更新, personalData);
    }

    /**
     * 総合事業（経過措置）対象者登録画面 ボタンの制御を処理します。
     *
     * @param div NijiyoboJohoTaishoshaTorokuPanelDiv
     * @return 画面
     */
    public ResponseData<NijiyoboJohoTaishoshaTorokuPanelDiv> onState(NijiyoboJohoTaishoshaTorokuPanelDiv div) {
        boolean is非活性_保存するボタン = true;
        List<dgNijiyoboJohoTaishoIchiran_Row> rowList = div.getNijiyoboJohoTaishoIchiran().getDgNijiyoboJohoTaishoIchiran().getDataSource();
        boolean is一覧画面 = DBC1740011StateName.Default.getName().equals(ResponseHolder.getState())
                || DBC1740011StateName.NoChange.getName().equals(ResponseHolder.getState());
        boolean is二次予防情報対象一覧に適用期間がEMPTY = false;
        for (dgNijiyoboJohoTaishoIchiran_Row row : rowList) {
            if (RowState.Unchanged != row.getRowState()) {
                is非活性_保存するボタン = false;
            }
            if (null == row.getTekiyoKaishiYMD() || null == row.getTekiyoKaishiYMD().getValue()
                    || null == row.getTekiyoShuryoYMD() || null == row.getTekiyoShuryoYMD().getValue()) {
                is二次予防情報対象一覧に適用期間がEMPTY = true;
            }
        }
        CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN_保存する, is非活性_保存するボタン);
        getHandler(div).onState(is一覧画面 && is二次予防情報対象一覧に適用期間がEMPTY);
        return ResponseData.of(div).respond();
    }

    /**
     * 総合事業（経過措置）対象者登録画面 「再検索する」ボタンを処理します。
     *
     * @param div NijiyoboJohoTaishoshaTorokuPanelDiv
     * @return 画面
     */
    public ResponseData<NijiyoboJohoTaishoshaTorokuPanelDiv> onClick_btnResearch(NijiyoboJohoTaishoshaTorokuPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message1 = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message1).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && MessageDialogSelectedResult.Yes == ResponseHolder.getButtonType()) {
            前排他のロックを解除し(div);
            return ResponseData.of(div).forwardWithEventName(DBC1740011TransitionEventName.再検索).respond();
        }
        return ResponseData.of(div).respond();
    }

    private void 前排他のロックを解除し(NijiyoboJohoTaishoshaTorokuPanelDiv div) {
        if (FALSE_排他失敗.equals(div.get排他失敗flag()) && (!RString.isNullOrEmpty(div.get被保険者番号()))) {
            LockingKey 前排他キー = new LockingKey(排他キー_前.concat(div.get被保険者番号()));
            RealInitialLocker.release(前排他キー);
        }
    }

    /**
     * 総合事業（経過措置）対象者登録画面 「検索結果一覧へ」ボタンを処理します。
     *
     * @param div NijiyoboJohoTaishoshaTorokuPanelDiv
     * @return 画面
     */
    public ResponseData<NijiyoboJohoTaishoshaTorokuPanelDiv> onClick_btnSearchResult(NijiyoboJohoTaishoshaTorokuPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message2 = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message2).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && MessageDialogSelectedResult.Yes == ResponseHolder.getButtonType()) {
            前排他のロックを解除し(div);
            return ResponseData.of(div).forwardWithEventName(DBC1740011TransitionEventName.検索結果一覧).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 総合事業（経過措置）対象者登録画面 「完了する」ボタンを処理します。
     *
     * @param div NijiyoboJohoTaishoshaTorokuPanelDiv
     * @return 画面
     */
    public ResponseData<NijiyoboJohoTaishoshaTorokuPanelDiv> onClick_btnComplete(NijiyoboJohoTaishoshaTorokuPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC1740011TransitionEventName.完了).respond();
    }
}
