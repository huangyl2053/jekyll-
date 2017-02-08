/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE0900002;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.ShinseiIchiran;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE090002.DBE090002_NinteikekkaJohoteikyoParameter;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeQuestionMessages;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeWarningMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0900002.YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0900002.YokaigoNinteiJohoTeikyoIkkatsuHakkoHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0900002.YokaigoNinteiJohoTeikyoIkkatsuHakkoValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 要介護認定情報提供一括発行Divの制御クラスです。
 *
 * @author N3212 竹内 和紀
 */
public class YokaigoNinteiJohoTeikyoIkkatsuHakko {

    /**
     * ページロードイベントです。
     *
     * @param div YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv> onLoad(YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 検索するボタンクリックイベントです。
     *
     * @param div YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv> onClick_btnSearch(YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv div) {
        ValidationMessageControlPairs validationMessageControlPairs = getValidationHandler(div).validate検索();
        if (validationMessageControlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessageControlPairs).respond();
        }
        YokaigoNinteiJohoTeikyoIkkatsuHakkoHandler handler = getHandler(div);
        SearchResult<ShinseiIchiran> 申請一覧 = YokaigoNinteiJohoTeikyoFinder.createInstance().get申請一覧(handler.createSearchParameter());
        if (申請一覧.totalCount() == 0) {
            throw new ApplicationException(UrErrorMessages.対象者が存在しない.getMessage());
        }
        handler.set申請一覧データグリッド(申請一覧);
        return ResponseData.of(div).respond();
    }

    /**
     * 条件をクリアするボタンクリックイベントです。
     *
     * @param div YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv> onClick_btnClear(YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv div) {
        getHandler(div).clear検索条件();
        return ResponseData.of(div).respond();
    }

    /**
     * 台帳ボタンクリックイベントです。
     *
     * @param div YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv> onClick_btnKojinJokyoShokai(YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv div) {
        ViewStateHolder.put(ViewStateKeys.申請書管理番号, div.getDgShinseiList().getClickedItem().getShinseishoKanriNo());
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査票チェックボックスのチェンジイベントです。
     *
     * @param div YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv> onChange_chkNinteiChosahyo(YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv div) {
        getHandler(div).setRadNinteiChosaMasking();
        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項チェックボックスのチェンジイベントです。
     *
     * @param div YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv> onChange_chkTokkiJiko(YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv div) {
        getHandler(div).setRadTokkiJikoMasking();
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医意見書チェックボックスのチェンジイベントです。
     *
     * @param div YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv> onChange_chkShujiiIkensho(YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv div) {
        getHandler(div).setRadShujiiMasking();
        return ResponseData.of(div).respond();
    }

    /**
     * その他資料チェックボックスのチェンジイベントです。
     *
     * @param div YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv> onChange_chkSonotaShiryo(YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv div) {
        getHandler(div).setRadSonotaShiryoMasking();
        return ResponseData.of(div).respond();
    }

    /**
     * 一次判定結果チェックボックスのチェンジイベントです。
     *
     * @param div YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv> onChange_chkIchijiHanteiKekka(YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv div) {
        getHandler(div).setRadIchijiHanteiMasking();
        return ResponseData.of(div).respond();
    }

    /**
     * 実行するボタンクリックイベントです。
     *
     * @param div YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv> onClick_btnBatchRegister(YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs validationMessageControlPairs = getValidationHandler(div).validateバッチ実行();
            if (validationMessageControlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validationMessageControlPairs).respond();
            }

            YokaigoNinteiJohoTeikyoIkkatsuHakkoHandler handler = getHandler(div);
            List<RString> 被保険者番号List;
            if (handler.is主治医意見書のみ選択()) {
                被保険者番号List = handler.get主治医の同意がない被保険者番号List();
                if (!被保険者番号List.isEmpty()) {
                    RStringBuilder builder = new RStringBuilder();
                    for (RString 被保険者番号 : 被保険者番号List) {
                        builder.append("<br/>")
                                .append("被保険者番号：")
                                .append(被保険者番号);
                    }
                    throw new ApplicationException(DbeErrorMessages.主治医未同意のため発行不可.getMessage().replace(builder.toString()));
                }
            }

            被保険者番号List = handler.get二次判定結果が決定していない被保険者番号List();
            if (!被保険者番号List.isEmpty()) {
                QuestionMessage message = new QuestionMessage(DbeQuestionMessages.二次判定結果が決定していませんが印刷.getMessage().getCode(),
                        DbeQuestionMessages.二次判定結果が決定していませんが印刷.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }

            被保険者番号List = handler.get印刷済の被保険者番号List();
            if (!被保険者番号List.isEmpty()) {
                WarningMessage message = new WarningMessage(DbeWarningMessages.既に印刷済.getMessage().getCode(),
                        DbeWarningMessages.既に印刷済.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
        }

        if (new RString(DbeQuestionMessages.二次判定結果が決定していませんが印刷.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            } else {
                List<RString> 被保険者番号List = getHandler(div).get印刷済の被保険者番号List();
                if (!被保険者番号List.isEmpty()) {
                    WarningMessage message = new WarningMessage(DbeWarningMessages.既に印刷済.getMessage().getCode(),
                            DbeWarningMessages.既に印刷済.getMessage().evaluate());
                    return ResponseData.of(div).addMessage(message).respond();
                }
            }
        }

        if (new RString(DbeWarningMessages.既に印刷済.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * バッチパラメータを設定します。
     *
     * @param div YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<DBE090002_NinteikekkaJohoteikyoParameter> getParameter(YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv div) {
        DBE090002_NinteikekkaJohoteikyoParameter parameter = getHandler(div).createBatchParameter();
        return ResponseData.of(parameter).respond();
    }

    private YokaigoNinteiJohoTeikyoIkkatsuHakkoHandler getHandler(YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv div) {
        return new YokaigoNinteiJohoTeikyoIkkatsuHakkoHandler(div);
    }

    private YokaigoNinteiJohoTeikyoIkkatsuHakkoValidationHandler getValidationHandler(YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv div) {
        return new YokaigoNinteiJohoTeikyoIkkatsuHakkoValidationHandler(div);
    }
}
