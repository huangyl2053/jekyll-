/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.commonchilddiv.ShinshinIken;

import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShinshinIken.ShinshinIken.ShinshinIkenDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.ShinshinIken.ShinshinIkenBakHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.ShinshinIken.ShinshinIkenHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.ShinshinIken.ShinshinIkenValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 心身の意見入力のクラスです。
 *
 * @reamsid_L DBE-3000-120 dongyabin
 */
public class ShinshinIken {

    /**
     * 心身の意見入力の初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<ShinshinIkenDiv>
     */
    public ResponseData<ShinshinIkenDiv> onLoad(ShinshinIkenDiv div) {
        ViewStateHolder.put(ViewStateKeys.要介護認定主治医意見書情報, getHandler(div).onLoad());
        getHandler(div).setSelectKey();
        return ResponseData.of(div).respond();
    }

    /**
     * 認知症周辺症状チェックボックスのChange処理です。
     *
     * @param div 画面情報
     * @return ResponseData<ShinshinIkenDiv>
     */
    public ResponseData<ShinshinIkenDiv> changeChkNinchishoShuhenShojoUmu(ShinshinIkenDiv div) {
        getHandler(div).changeChkNinchishoShuhenShojoUmu();
        return ResponseData.of(div).respond();
    }

    /**
     * その他認知症周辺症状チェックボックスのChange処理です。
     *
     * @param div 画面情報
     * @return ResponseData<ShinshinIkenDiv>
     */
    public ResponseData<ShinshinIkenDiv> changeChkNinchishoShuhenShojoSonota(ShinshinIkenDiv div) {
        getHandler(div).changeChkNinchishoShuhenShojoSonota();
        return ResponseData.of(div).respond();
    }

    /**
     * その他の精神神経症状チェックボックスのChange処理です。
     *
     * @param div 画面情報
     * @return ResponseData<ShinshinIkenDiv>
     */
    public ResponseData<ShinshinIkenDiv> changeChkSonotaShojo(ShinshinIkenDiv div) {
        getHandler(div).changeChkSonotaShojo();
        return ResponseData.of(div).respond();
    }

    /**
     * 専門医受診の有無チェックボックスのChange処理です。
     *
     * @param div 画面情報
     * @return ResponseData<ShinshinIkenDiv>
     */
    public ResponseData<ShinshinIkenDiv> changeChkSenmonJushin(ShinshinIkenDiv div) {
        getHandler(div).changeChkSenmonJushin();
        return ResponseData.of(div).respond();
    }

    /**
     * 四肢欠損チェックボックスのChange処理です。
     *
     * @param div 画面情報
     * @return ResponseData<ShinshinIkenDiv>
     */
    public ResponseData<ShinshinIkenDiv> changeChkShishiKesson(ShinshinIkenDiv div) {
        getHandler(div).changeChkShishiKesson();
        return ResponseData.of(div).respond();
    }

    /**
     * 麻痺チェックボックスのChange処理です。
     *
     * @param div 画面情報
     * @return ResponseData<ShinshinIkenDiv>
     */
    public ResponseData<ShinshinIkenDiv> changeChkMahi(ShinshinIkenDiv div) {
        getHandler(div).changeChkMahi();
        return ResponseData.of(div).respond();
    }

    /**
     * 右上肢チェックボックスのChange処理です。
     *
     * @param div 画面情報
     * @return ResponseData<ShinshinIkenDiv>
     */
    public ResponseData<ShinshinIkenDiv> changeChkMigiJoshiMahi(ShinshinIkenDiv div) {
        getHandler(div).changeChkMigiJoshiMahi();
        return ResponseData.of(div).respond();
    }

    /**
     * 左上肢チェックボックスのChange処理です。
     *
     * @param div 画面情報
     * @return ResponseData<ShinshinIkenDiv>
     */
    public ResponseData<ShinshinIkenDiv> changeChkHidariJoshiMahi(ShinshinIkenDiv div) {
        getHandler(div).changeChkHidariJoshiMahi();
        return ResponseData.of(div).respond();
    }

    /**
     * 右下肢チェックボックスのChange処理です。
     *
     * @param div 画面情報
     * @return ResponseData<ShinshinIkenDiv>
     */
    public ResponseData<ShinshinIkenDiv> changeChkMigiKashiMahi(ShinshinIkenDiv div) {
        getHandler(div).changeChkMigiKashiMahi();
        return ResponseData.of(div).respond();
    }

    /**
     * 左下肢チェックボックスのChange処理です。
     *
     * @param div 画面情報
     * @return ResponseData<ShinshinIkenDiv>
     */
    public ResponseData<ShinshinIkenDiv> changeChkHidariKashiMahi(ShinshinIkenDiv div) {
        getHandler(div).changeChkHidariKashiMahi();
        return ResponseData.of(div).respond();
    }

    /**
     * その他麻痺チェックボックスのChange処理です。
     *
     * @param div 画面情報
     * @return ResponseData<ShinshinIkenDiv>
     */
    public ResponseData<ShinshinIkenDiv> changeChkSonotaMahi(ShinshinIkenDiv div) {
        getHandler(div).changeChkSonotaMahi();
        return ResponseData.of(div).respond();
    }

    /**
     * 筋力の低下チェックボックスのChange処理です。
     *
     * @param div 画面情報
     * @return ResponseData<ShinshinIkenDiv>
     */
    public ResponseData<ShinshinIkenDiv> changeChkKinryokuTeika(ShinshinIkenDiv div) {
        getHandler(div).changeChkKinryokuTeika();
        return ResponseData.of(div).respond();
    }

    /**
     * 関節の拘縮チェックボックスのChange処理です。
     *
     * @param div 画面情報
     * @return ResponseData<ShinshinIkenDiv>
     */
    public ResponseData<ShinshinIkenDiv> changeChkKansetsuKoshuku(ShinshinIkenDiv div) {
        getHandler(div).changeChkKansetsuKoshuku();
        return ResponseData.of(div).respond();
    }

    /**
     * 関節の痛みチェックボックスのChange処理です。
     *
     * @param div 画面情報
     * @return ResponseData<ShinshinIkenDiv>
     */
    public ResponseData<ShinshinIkenDiv> changeChkKansetsuItami(ShinshinIkenDiv div) {
        getHandler(div).changeChkKansetsuItami();
        return ResponseData.of(div).respond();
    }

    /**
     * 失調不随意運動チェックボックスのChange処理です。
     *
     * @param div 画面情報
     * @return ResponseData<ShinshinIkenDiv>
     */
    public ResponseData<ShinshinIkenDiv> changeChkShicchoFuzuii(ShinshinIkenDiv div) {
        getHandler(div).changeChkShicchoFuzuii();
        return ResponseData.of(div).respond();
    }

    /**
     * 褥瘡チェックボックスのChange処理です。
     *
     * @param div 画面情報
     * @return ResponseData<ShinshinIkenDiv>
     */
    public ResponseData<ShinshinIkenDiv> changeChkJokuso(ShinshinIkenDiv div) {
        getHandler(div).changeChkJokuso();
        return ResponseData.of(div).respond();
    }

    /**
     * その他皮膚疾患チェックボックスのChange処理です。
     *
     * @param div 画面情報
     * @return ResponseData<ShinshinIkenDiv>
     */
    public ResponseData<ShinshinIkenDiv> changeChkSonotaHifuShikkan(ShinshinIkenDiv div) {
        getHandler(div).changeChkSonotaHifuShikkan();
        return ResponseData.of(div).respond();
    }

    /**
     * 確定ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<ShinshinIkenDiv>
     */
    public ResponseData<ShinshinIkenDiv> onClickBtnKakutei(ShinshinIkenDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForKakutei();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (div.getSelectKeys().equals(getHandler(div).getSelectKey())) {
            return ResponseData.of(div).dialogOKClose();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.確定の確認.getMessage().getCode(),
                    UrQuestionMessages.確定の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.確定の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            ViewStateHolder.put(ViewStateKeys.意見書情報, getHandlerBak(div).onClickBtnKakutei());
            return ResponseData.of(div).dialogOKClose();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 取消ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<ShinshinIkenDiv>
     */
    public ResponseData<ShinshinIkenDiv> onClickBtnCancel(ShinshinIkenDiv div) {
        if (div.getSelectKeys().equals(getHandler(div).getSelectKey())) {
            return ResponseData.of(div).dialogOKClose();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                    UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).dialogOKClose();
        }
        return ResponseData.of(div).respond();
    }

    private ShinshinIkenHandler getHandler(ShinshinIkenDiv div) {
        return new ShinshinIkenHandler(div,
                ViewStateHolder.get(ViewStateKeys.意見書情報, NinteiShinseiJoho.class),
                ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class),
                ViewStateHolder.get(ViewStateKeys.主治医意見書作成依頼履歴番号, RString.class),
                ViewStateHolder.get(ViewStateKeys.要介護認定主治医意見書情報, ShujiiIkenshoJoho.class));
    }

    private ShinshinIkenValidationHandler getValidationHandler(ShinshinIkenDiv div) {
        return new ShinshinIkenValidationHandler(div);
    }

    private ShinshinIkenBakHandler getHandlerBak(ShinshinIkenDiv div) {
        return new ShinshinIkenBakHandler(div,
                ViewStateHolder.get(ViewStateKeys.意見書情報, NinteiShinseiJoho.class),
                ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class),
                ViewStateHolder.get(ViewStateKeys.主治医意見書作成依頼履歴番号, RString.class),
                ViewStateHolder.get(ViewStateKeys.要介護認定主治医意見書情報, ShujiiIkenshoJoho.class));
    }
}
