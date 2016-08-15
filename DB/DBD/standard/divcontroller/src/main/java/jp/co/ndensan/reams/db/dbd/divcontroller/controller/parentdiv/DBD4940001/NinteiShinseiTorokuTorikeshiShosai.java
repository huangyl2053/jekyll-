/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD4940001;

import jp.co.ndensan.reams.db.dbd.business.core.yokaigonintei.YokaigoNinteiJoho;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4940001.DBD4940001TransitionEventName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4940001.NinteiShinseiTorokuTorikeshiShosaiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4940001.NinteiShinseiTorokuTorikeshiShosaiHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4940001.NinteiShinseiTorokuTorikeshiShosaiValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.ShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 要介護認定取消詳細画面のDivControllerです。
 *
 * @reamsid_L DBD-2090-010 lit
 */
public class NinteiShinseiTorokuTorikeshiShosai {

    /**
     * 要介護認定処理画面キーのEnum
     */
    private enum 要介護認定取消画面キー {

        /**
         * 画面更新用情報
         */
        画面更新用情報,
        /**
         * 画面ダイアローグ番号
         */
        画面ダイアローグ番号;
    }

    /**
     * 画面初期化
     *
     * @param div NinteiShinseiTorokuTorikeshiShosaiDiv
     * @return ResponseData<NinteiShinseiTorokuTorikeshiShosaiDiv>
     */
    public ResponseData<NinteiShinseiTorokuTorikeshiShosaiDiv> onLoad(NinteiShinseiTorokuTorikeshiShosaiDiv div) {

        TaishoshaKey key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        RString 被保険者番号 = RString.EMPTY;
        if (null != key && null != key.get被保険者番号()) {
            被保険者番号 = key.get被保険者番号().value();
        }

        YokaigoNinteiJoho 画面更新用情報 = getHandler(div).onLoad(被保険者番号);
        ViewStateHolder.put(要介護認定取消画面キー.画面更新用情報, 画面更新用情報);
        return ResponseData.of(div).respond();
    }

    /**
     * 「医療保険」ボタンの処理
     *
     * @param div NinteiShinseiTorokuTorikeshiShosaiDiv
     * @return ResponseData<NinteiShinseiTorokuTorikeshiShosaiDiv>
     */
    public ResponseData<NinteiShinseiTorokuTorikeshiShosaiDiv> onBeforeOpenDialog_btnIryohokenGuide(NinteiShinseiTorokuTorikeshiShosaiDiv div) {
        // TODO. 実装しない。
//        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
//        getHandler(div).onBeforeOpenDialog_btnDispGemmenJoho(taishoshaKey);
        return ResponseData.of(div).respond();
    }

    /**
     * 「医療保険」ダイアログのOKボタンを押した後のメソッドです。
     *
     * @param div NinteiShinseiTorokuTorikeshiShosaiDivDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseiTorokuTorikeshiShosaiDiv> onOkClose_btnIryohokenGuide(NinteiShinseiTorokuTorikeshiShosaiDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「施設入所」ボタンの処理
     *
     * @param div NinteiShinseiTorokuTorikeshiShosaiDiv
     * @return ResponseData<NinteiShinseiTorokuTorikeshiShosaiDiv>
     */
    public ResponseData<NinteiShinseiTorokuTorikeshiShosaiDiv> onBeforeOpenDialog_btnNyuinAndShisetsuNyusho(NinteiShinseiTorokuTorikeshiShosaiDiv div) {

        div.setHdnSyokikaMode(new RString(ShisetsuNyutaishoRirekiKanriDiv.DisplayMode.照会.toString()));

        return ResponseData.of(div).respond();
    }

    /**
     * 「施設入所」ダイアログのOKボタンを押した後のメソッドです。
     *
     * @param div NinteiShinseiTorokuTorikeshiShosaiDivDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseiTorokuTorikeshiShosaiDiv> onOkClose_btnNyuinAndShisetsuNyusho(NinteiShinseiTorokuTorikeshiShosaiDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「調査状況」ボタンの処理
     *
     * @param div NinteiShinseiTorokuTorikeshiShosaiDiv
     * @return ResponseData<NinteiShinseiTorokuTorikeshiShosaiDiv>
     */
    public ResponseData<NinteiShinseiTorokuTorikeshiShosaiDiv> onBeforeOpenDialog_btnChosaJokyo(NinteiShinseiTorokuTorikeshiShosaiDiv div) {
        // TODO. 実装しない。

        RString 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, RString.class);
        //List<YokaigoRirekiJoho> 今回前回履歴情報 = getHandler(div).get今回前回履歴情報(被保険者番号);

//        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
//        getHandler(div).onBeforeOpenDialog_btnDispGemmenJoho(taishoshaKey);
        return ResponseData.of(div).respond();
    }

    /**
     * 「調査状況」ダイアログのOKボタンを押した後のメソッドです。
     *
     * @param div NinteiShinseiTorokuTorikeshiShosaiDivDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseiTorokuTorikeshiShosaiDiv> onOkClose_btnChosaJokyo(NinteiShinseiTorokuTorikeshiShosaiDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「滞納状況」ボタンの処理
     *
     * @param div NinteiShinseiTorokuTorikeshiShosaiDiv
     * @return ResponseData<NinteiShinseiTorokuTorikeshiShosaiDiv>
     */
    public ResponseData<NinteiShinseiTorokuTorikeshiShosaiDiv> onBeforeOpenDialog_btnTainoJokyo(NinteiShinseiTorokuTorikeshiShosaiDiv div) {
        // TODO. 実装しない。
//        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
//        getHandler(div).onBeforeOpenDialog_btnDispGemmenJoho(taishoshaKey);
        return ResponseData.of(div).respond();
    }

    /**
     * 「滞納状況」ダイアログのOKボタンを押した後のメソッドです。
     *
     * @param div NinteiShinseiTorokuTorikeshiShosaiDivDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseiTorokuTorikeshiShosaiDiv> onOkClose_btnTainoJokyo(NinteiShinseiTorokuTorikeshiShosaiDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「一覧へ戻る」ボタンの処理
     *
     * @param div ShokkenTorikeshiIchibuSoshituDiv
     * @return ResponseData<ShokkenTorikeshiIchibuSoshituDiv>
     */
    public ResponseData<NinteiShinseiTorokuTorikeshiShosaiDiv> onClick_btnBack(NinteiShinseiTorokuTorikeshiShosaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBD4940001TransitionEventName.一覧へ戻る).respond();
    }

    /**
     * 「保存する」ボタンの処理
     *
     * @param div NinteiShinseiTorokuTorikeshiShosaiDiv
     * @return ResponseData<NinteiShinseiTorokuTorikeshiShosaiDiv>
     */
    public ResponseData<NinteiShinseiTorokuTorikeshiShosaiDiv> onClick_btnUpdate(NinteiShinseiTorokuTorikeshiShosaiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs pairs = getValidationHandler(div).validate();
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }

            ViewStateHolder.put(要介護認定取消画面キー.画面ダイアローグ番号, 1);
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }

        int 画面ダイアローグ番号 = ViewStateHolder.get(要介護認定取消画面キー.画面ダイアローグ番号, Integer.class);
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            if (画面ダイアローグ番号 == 1) {
                YokaigoNinteiJoho 画面更新用情報 = ViewStateHolder.get(要介護認定取消画面キー.画面更新用情報, YokaigoNinteiJoho.class);
                getHandler(div).save(画面更新用情報);
                ViewStateHolder.put(要介護認定取消画面キー.画面ダイアローグ番号, 2);
                return ResponseData.of(div).addMessage(UrInformationMessages.保存終了.getMessage()).respond();
            } else if (画面ダイアローグ番号 == 2) {
                return ResponseData.of(div).forwardWithEventName(DBD4940001TransitionEventName.完了).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    private NinteiShinseiTorokuTorikeshiShosaiHandler getHandler(NinteiShinseiTorokuTorikeshiShosaiDiv div) {
        return new NinteiShinseiTorokuTorikeshiShosaiHandler(div);
    }

    private NinteiShinseiTorokuTorikeshiShosaiValidationHandler getValidationHandler(NinteiShinseiTorokuTorikeshiShosaiDiv div) {
        return new NinteiShinseiTorokuTorikeshiShosaiValidationHandler(div);
    }
}
