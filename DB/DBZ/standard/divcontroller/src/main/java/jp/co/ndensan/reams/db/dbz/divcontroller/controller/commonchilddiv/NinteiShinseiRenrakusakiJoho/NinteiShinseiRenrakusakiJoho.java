/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.NinteiShinseiRenrakusakiJoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.NinteiShinseiBusinessCollection;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiJoho.NinteiShinseiRenrakusakiJoho.NinteiShinseiRenrakusakiJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiJoho.NinteiShinseiRenrakusakiJoho.dgRenrakusakiIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.NinteiShinseiRenrakusakiJoho.NinteiShinseiRenrakusakiJohoHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.NinteiShinseiRenrakusakiJoho.NinteiShinseiValidationHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 認定申請連絡先情報のクラスです。
 *
 * @reamsid_L DBE-1300-100 dongyabin
 */
public class NinteiShinseiRenrakusakiJoho {

    /**
     * 認定申請連絡先情報の初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiShinseiRenrakusakiJohoDiv>
     */
    public ResponseData<NinteiShinseiRenrakusakiJohoDiv> intialize(NinteiShinseiRenrakusakiJohoDiv div) {
        getHandler(div).setClear();
        getHandler(div).onLoad();
        NinteiShinseiBusinessCollection deta = DataPassingConverter.deserialize(div.
                getNinteiShinseiBusinessCollection(), NinteiShinseiBusinessCollection.class);
        getHandler(div).setRenrakusaki(deta.getDbdBusiness());
        return ResponseData.of(div).respond();
    }

    /**
     * 新規追加するボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiShinseiRenrakusakiJohoDiv>
     */
    public ResponseData<NinteiShinseiRenrakusakiJohoDiv> onClilck_btnShinkiTsuika(NinteiShinseiRenrakusakiJohoDiv div) {
        div.setMode_ShoriType(NinteiShinseiRenrakusakiJohoDiv.ShoriType.InputMode);
        getHandler(div).set連絡先入力の各項目をクリア();
        div.getBtnShinkiTsuika().setDisabled(true);
        div.getDgRenrakusakiIchiran().setReadOnly(true);
        div.getBtnFukushaTsuika().setDisabled(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 選択行を複写して追加するボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiShinseiRenrakusakiJohoDiv>
     */
    public ResponseData<NinteiShinseiRenrakusakiJohoDiv> onClilck_btnFukushaTsuika(NinteiShinseiRenrakusakiJohoDiv div) {
        if (div.getDgRenrakusakiIchiran().getClickedItem() == null) {
            throw new ApplicationException(UrErrorMessages.対象行を選択.getMessage());
        }
        div.setMode_ShoriType(NinteiShinseiRenrakusakiJohoDiv.ShoriType.InputMode);
        getHandler(div).set連絡先入力();
        getHandler(div).set画面項目の使用可();
        div.getBtnShinkiTsuika().setDisabled(false);
        div.getDgRenrakusakiIchiran().setReadOnly(true);
        div.getBtnFukushaTsuika().setDisabled(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 前回を複写するボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiShinseiRenrakusakiJohoDiv>
     */
    public ResponseData<NinteiShinseiRenrakusakiJohoDiv> onClilck_btnZenkaiFukusha(NinteiShinseiRenrakusakiJohoDiv div) {
        NinteiShinseiBusinessCollection deta = DataPassingConverter.deserialize(div.
                getHdnZenkaiRenrakusakiJoho(), NinteiShinseiBusinessCollection.class);
        if (deta == null || deta.getDbdBusiness().isEmpty()) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(getMessage().check_前回情報());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.確認_汎用.getMessage()
                    .replace("前回の連絡先を複写します。現在の連絡先情報はクリアされます。")).respond();
        }
        if (new RString(UrQuestionMessages.確認_汎用.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes)) {
            div.getDgRenrakusakiIchiran().setDataSource(new ArrayList<dgRenrakusakiIchiran_Row>());
            getHandler(div).setRenrakusaki(deta.getDbdBusiness());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 連絡先一覧を選択します。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiShinseiRenrakusakiJohoDiv>
     */
    public ResponseData<NinteiShinseiRenrakusakiJohoDiv> onSelect_RenrakusakiIchiran(NinteiShinseiRenrakusakiJohoDiv div) {
        getHandler(div).set連絡先入力();
        getHandler(div).set画面ReadOnly();
        return ResponseData.of(div).respond();
    }

    /**
     * 連絡先一覧の修正ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiShinseiRenrakusakiJohoDiv>
     */
    public ResponseData<NinteiShinseiRenrakusakiJohoDiv> onClick_btnShusei(NinteiShinseiRenrakusakiJohoDiv div) {
        getHandler(div).set連絡先入力();
        div.setMode_ShoriType(NinteiShinseiRenrakusakiJohoDiv.ShoriType.KoshinMode);
        return ResponseData.of(div).respond();
    }

    /**
     * 連絡先一覧の削除ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiShinseiRenrakusakiJohoDiv>
     */
    public ResponseData<NinteiShinseiRenrakusakiJohoDiv> onClick_btnSakujo(NinteiShinseiRenrakusakiJohoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes)) {
            List<dgRenrakusakiIchiran_Row> dateSoruce = div.getDgRenrakusakiIchiran().getDataSource();
            dateSoruce.remove(div.getDgRenrakusakiIchiran().getActiveRow());
            div.getDgRenrakusakiIchiran().setDataSource(dateSoruce);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 登録するボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiShinseiRenrakusakiJohoDiv>
     */
    public ResponseData<NinteiShinseiRenrakusakiJohoDiv> onClick_btnToroku(NinteiShinseiRenrakusakiJohoDiv div) {
        div.getBtnShinkiTsuika().setDisabled(false);
        div.getDgRenrakusakiIchiran().setReadOnly(false);
        div.getBtnFukushaTsuika().setDisabled(false);
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(getMessage().check_登録する(div));
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        getHandler(div).setDataSourceを一覧();
        getHandler(div).setClear();
        return ResponseData.of(div).respond();
    }

    /**
     * 確定するボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiShinseiRenrakusakiJohoDiv>
     */
    public ResponseData<NinteiShinseiRenrakusakiJohoDiv> onClick_btnKakutei(NinteiShinseiRenrakusakiJohoDiv div) {
        NinteiShinseiBusinessCollection collection = new NinteiShinseiBusinessCollection();
        collection.setDbdBusiness(getHandler(div).setBusiness());
        div.setNinteiShinseiBusinessCollection(DataPassingConverter.serialize(collection));
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 戻るするボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiShinseiRenrakusakiJohoDiv>
     */
    public ResponseData<NinteiShinseiRenrakusakiJohoDiv> onClick_btnModoru(NinteiShinseiRenrakusakiJohoDiv div) {
        return ResponseData.of(div).dialogNGClose();
    }

    private NinteiShinseiRenrakusakiJohoHandler getHandler(NinteiShinseiRenrakusakiJohoDiv div) {
        return new NinteiShinseiRenrakusakiJohoHandler(div);
    }

    private NinteiShinseiValidationHandler getMessage() {
        return new NinteiShinseiValidationHandler();
    }
}
