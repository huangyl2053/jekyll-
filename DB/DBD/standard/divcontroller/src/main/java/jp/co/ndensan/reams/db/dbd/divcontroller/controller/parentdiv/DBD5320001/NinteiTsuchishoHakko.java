/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5320001;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.yokaigonintei.YokaigoNinteiTsutisho;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5320001.DBD5320001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5320001.DBD5320001TransitionEventName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5320001.NinteiTsuchishoHakkoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5320001.NinteiTsuchishoHakkoHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 要介護認定通知書発行画面のDivControllerです。
 *
 * @reamsid_L DBE-1430-010 lit
 */
public class NinteiTsuchishoHakko {

    /**
     * 要介護認定通知書発行キーのEnum
     */
    private enum 要介護認定通知書発行画面キー {

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
     * @param div NinteiTsuchishoHakkoDiv
     * @return ResponseData<NinteiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiTsuchishoHakkoDiv> onLoad(NinteiTsuchishoHakkoDiv div) {

        getHandler(div).onLoad();
        return ResponseData.of(div).setState(DBD5320001StateName.初始状態);
    }

    /**
     * 「条件をクリアする」ボタンの処理
     *
     * @param div NinteiTsuchishoHakkoDiv
     * @return ResponseData<NinteiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiTsuchishoHakkoDiv> onClick_btnJokenClear(NinteiTsuchishoHakkoDiv div) {
        getHandler(div).clearJoken();
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索する」ボタンの処理
     *
     * @param div NinteiTsuchishoHakkoDivDiv
     * @return ResponseData
     */
    public ResponseData<NinteiTsuchishoHakkoDiv> onClick_btnKensaku(NinteiTsuchishoHakkoDiv div) {
        // TODO. メッセージID：URZE00140（該当データが存在しません。）実装しない。
        List<YokaigoNinteiTsutisho> 画面更新用データ = getHandler(div).kensaku();
        ViewStateHolder.put(要介護認定通知書発行画面キー.画面更新用情報, (Serializable) 画面更新用データ);
        return ResponseData.of(div).setState(DBD5320001StateName.検索結果);
    }

    /**
     * データGridにチェックボックスのクリック処理
     *
     * @param div NinteiTsuchishoHakkoDivDiv
     * @return ResponseData
     */
    public ResponseData<NinteiTsuchishoHakkoDiv> onClick_btnGridSelect(NinteiTsuchishoHakkoDiv div) {
        boolean isSelected = !div.getDgTaishoshaIchiran().getSelectedItems().isEmpty();
        if (!isSelected) {
            return ResponseData.of(div).setState(DBD5320001StateName.検索結果);
        }

        if (getHandler(div).displayChohyoArea(isSelected)) {
            return ResponseData.of(div).setState(DBD5320001StateName.個別発行);
        } else {
            return ResponseData.of(div).setState(DBD5320001StateName.一括発行);
        }
    }

    /**
     * radPrintSelectのクリック処理
     *
     * @param div NinteiTsuchishoHakkoDivDiv
     * @return ResponseData
     */
    public ResponseData<NinteiTsuchishoHakkoDiv> onClick_radPrintSelect(NinteiTsuchishoHakkoDiv div) {
        getHandler(div).clearJoken();
        getHandler(div).clearChohyoArea();
        if (div.getRadPrintSelect().getSelectedKey().equals(NinteiTsuchishoHakkoHandler.RadioValue.個別発行を行う.getKey())) {
            return ResponseData.of(div).setState(DBD5320001StateName.初始状態);
        } else {
            return ResponseData.of(div).setState(DBD5320001StateName.一括発行);
        }
    }

    /**
     * 「認定結果通知書」エリアのOPEN処理
     *
     * @param div NinteiTsuchishoHakkoDiv
     * @return ResponseData<NinteiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiTsuchishoHakkoDiv> onOpen_NinteiKekkaTsuchi(NinteiTsuchishoHakkoDiv div) {
        // 選択したデータ条数のチェック
        getHandler(div).openChohyoPanel(NinteiTsuchishoHakkoHandler.PanelType.個別発行認定結果通知書パネル);

        return ResponseData.of(div).respond();
    }

    /**
     * 「サービス変更通知書」エリアのOPEN処理
     *
     * @param div NinteiTsuchishoHakkoDiv
     * @return ResponseData<NinteiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiTsuchishoHakkoDiv> onOpen_ServiceHenkoTsuchi(NinteiTsuchishoHakkoDiv div) {
        // 選択したデータ条数のチェック
        getHandler(div).openChohyoPanel(NinteiTsuchishoHakkoHandler.PanelType.個別発行サービス変更通知書パネル);

        return ResponseData.of(div).respond();
    }

    /**
     * 「要介護度変更通知書」エリアのOPEN処理
     *
     * @param div NinteiTsuchishoHakkoDiv
     * @return ResponseData<NinteiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiTsuchishoHakkoDiv> onOpen_YokaigodoHenkoTsuchi(NinteiTsuchishoHakkoDiv div) {
        // 選択したデータ条数のチェック
        getHandler(div).openChohyoPanel(NinteiTsuchishoHakkoHandler.PanelType.個別発行要介護度変更通知書パネル);

        return ResponseData.of(div).respond();
    }

    /**
     * 「認定却下通知書」エリアのOPEN処理
     *
     * @param div NinteiTsuchishoHakkoDiv
     * @return ResponseData<NinteiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiTsuchishoHakkoDiv> onOpen_NinteiKyakkaTshuchi(NinteiTsuchishoHakkoDiv div) {
        // 選択したデータ条数のチェック
        getHandler(div).openChohyoPanel(NinteiTsuchishoHakkoHandler.PanelType.個別発行認定却下通知書パネル);

        return ResponseData.of(div).respond();
    }

    /**
     * 「一括発行」エリアのOPEN処理
     *
     * @param div NinteiTsuchishoHakkoDiv
     * @return ResponseData<NinteiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiTsuchishoHakkoDiv> onOpen_IkkatsuHakko(NinteiTsuchishoHakkoDiv div) {
        getHandler(div).openChohyoPanel(NinteiTsuchishoHakkoHandler.PanelType.一括発行パネル);

        return ResponseData.of(div).respond();
    }

    /**
     * 「却下理由にコピー」ボタンの処理
     *
     * @param div NinteiTsuchishoHakkoDiv
     * @return ResponseData<NinteiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiTsuchishoHakkoDiv> onClick_btnCopyJiyuToRiyu(NinteiTsuchishoHakkoDiv div) {

        div.getTxtIdoJiyu().setValue(div.getTxtKyakkaRiyu().getValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 「通知書を発行する」個別発行ボタンの処理
     *
     * @param div NinteiTsuchishoHakkoDiv
     * @return ResponseData<NinteiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiTsuchishoHakkoDiv> onClick_btnUpdate(NinteiTsuchishoHakkoDiv div) {
        if (!ResponseHolder.isReRequest()) {
//            ValidationMessageControlPairs pairs = getValidationHandler(div).validate();
//            if (pairs.iterator().hasNext()) {
//                return ResponseData.of(div).addValidationMessages(pairs).respond();
//            }

            ViewStateHolder.put(要介護認定通知書発行画面キー.画面ダイアローグ番号, 1);
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
//
        int 画面ダイアローグ番号 = ViewStateHolder.get(要介護認定通知書発行画面キー.画面ダイアローグ番号, Integer.class);
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            if (画面ダイアローグ番号 == 1) {
                List<YokaigoNinteiTsutisho> 画面更新用情報 = ViewStateHolder.get(要介護認定通知書発行画面キー.画面更新用情報, List.class);
                getHandler(div).printAndSave(画面更新用情報);
                ViewStateHolder.put(要介護認定通知書発行画面キー.画面ダイアローグ番号, 2);
                return ResponseData.of(div).addMessage(UrInformationMessages.保存終了.getMessage()).respond();
            } else if (画面ダイアローグ番号 == 2) {
                return ResponseData.of(div).forwardWithEventName(DBD5320001TransitionEventName.完了).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「通知書を発行する」一括発行ボタンの処理
     *
     * @param div NinteiTsuchishoHakkoDiv
     * @return ResponseData<NinteiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiTsuchishoHakkoDiv> onClick_btnIkkatsuHakkoUpdate(NinteiTsuchishoHakkoDiv div) {
        if (!ResponseHolder.isReRequest()) {
//            ValidationMessageControlPairs pairs = getValidationHandler(div).validate();
//            if (pairs.iterator().hasNext()) {
//                return ResponseData.of(div).addValidationMessages(pairs).respond();
//            }

            ViewStateHolder.put(要介護認定通知書発行画面キー.画面ダイアローグ番号, 1);
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
//
        int 画面ダイアローグ番号 = ViewStateHolder.get(要介護認定通知書発行画面キー.画面ダイアローグ番号, Integer.class);
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            if (画面ダイアローグ番号 == 1) {
                List<YokaigoNinteiTsutisho> 画面更新用情報 = ViewStateHolder.get(要介護認定通知書発行画面キー.画面更新用情報, List.class);
                getHandler(div).printAndSave(画面更新用情報);
                ViewStateHolder.put(要介護認定通知書発行画面キー.画面ダイアローグ番号, 2);
                return ResponseData.of(div).addMessage(UrInformationMessages.保存終了.getMessage()).respond();
            } else if (画面ダイアローグ番号 == 2) {
                return ResponseData.of(div).forwardWithEventName(DBD5320001TransitionEventName.完了).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    private NinteiTsuchishoHakkoHandler getHandler(NinteiTsuchishoHakkoDiv div) {
        return new NinteiTsuchishoHakkoHandler(div);
    }

//    private NinteiShinseiTorokuTorikeshiShosaiValidationHandler getValidationHandler(NinteiTsuchishoHakkoDiv div) {
//        return new NinteiShinseiTorokuTorikeshiShosaiValidationHandler(div);
//    }
}
