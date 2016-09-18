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
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1740011.NijiyoboJohoTaishoshaTorokuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1740011.NijiyoboJohoTaishoshaTorokuPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1740011.NijiyoboJohoTaishoshaTorokuPanelValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.basic.NijiYoboJigyoTaishoshaManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
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
        if (!RString.isNullOrEmpty(資格対象者.get被保険者番号().getColumnValue())) {
            LockingKey 前排他キー = new LockingKey(排他キー_前.concat(資格対象者.get被保険者番号().getColumnValue()));
            if (!RealInitialLocker.tryGetLock(前排他キー)) {
                throw new PessimisticLockingException();
            }
        }
        NijiYoboJigyoTaishoshaManager manager = new NijiYoboJigyoTaishoshaManager();
        List<NijiYoboJigyoTaishosha> 二次予防情報対象一覧List
                = manager.get二次予防事業対象者By被保険者番号(資格対象者.get被保険者番号());
        getHandler(div).onLoad(資格対象者, 二次予防情報対象一覧List);
        if (null != 二次予防情報対象一覧List && (!二次予防情報対象一覧List.isEmpty())) {
            ViewStateHolder.put(ViewStateHolderName.二次予防情報対象情報, new NijiYoboJigyoTaishoshaHolder(二次予防情報対象一覧List));
        }
        return ResponseData.of(div).respond();
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
        return ResponseData.of(div).respond();
    }

    /**
     * 総合事業（経過措置）対象者登録画面 適用期間の変更を処理します。
     *
     * @param div NijiyoboJohoTaishoshaTorokuPanelDiv
     * @return 画面
     */
    public ResponseData<NijiyoboJohoTaishoshaTorokuPanelDiv> onChange_dateRange(NijiyoboJohoTaishoshaTorokuPanelDiv div) {
        getHandler(div).onChange_dateRange();
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
            getHandler(div).二次予防情報対象一覧のデータを保存する(div.getKihonnInfo().getDgKihonInfo().getDataSource(),
                    new HihokenshaNo(div.get被保険者番号()), holder);
            if (!RString.isNullOrEmpty(div.get被保険者番号())) {
                LockingKey 前排他キー = new LockingKey(排他キー_前.concat(div.get被保険者番号()));
                RealInitialLocker.release(前排他キー);
            }
            onLoad(div);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 総合事業（経過措置）対象者登録画面 「保存する」ボタンの制御を処理します。
     *
     * @param div NijiyoboJohoTaishoshaTorokuPanelDiv
     * @return 画面
     */
    public ResponseData<NijiyoboJohoTaishoshaTorokuPanelDiv> onState_btnSave(NijiyoboJohoTaishoshaTorokuPanelDiv div) {
        getHandler(div).onState_btnSave();
        return ResponseData.of(div).respond();
    }
}
