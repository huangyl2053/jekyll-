/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5170001;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.KaisaiYoteiJohoBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE517000.DBE517000_ShinsakaiShiryoParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5170001.PublicationShiryoShinsakaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5170001.PublicationShiryoShinsakaiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5170001.PublicationShiryoShinsakaiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.shiryoshinsakai.ShiryoShinsakaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 介護認定審査会資料作成のコントローラです。
 *
 * @reamsid_L DBE-0150-010 linghuhang
 */
public class PublicationShiryoShinsakai {

    private final RString 印刷帳票_すべて選択 = new RString("0");

    /**
     * 画面初期化処理です。
     *
     * @param div PublicationShiryoShinsakaiDiv
     * @return ResponseData<PublicationShiryoShinsakaiDiv>
     */
    public ResponseData<PublicationShiryoShinsakaiDiv> onLoad(PublicationShiryoShinsakaiDiv div) {
        RString 審査会一覧_開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);
        KaisaiYoteiJohoBusiness 開催予定情報
                = ShiryoShinsakaiFinder.createInstance().get開催予定情報(審査会一覧_開催番号);
        div.getTxtShinsakaiKaisaiNo().setValue(審査会一覧_開催番号);
        RStringBuilder builder = new RStringBuilder();
        builder.append(new RString("DBEShinsakaiNo"))
                .append(審査会一覧_開催番号);
        前排他キーのセット(builder.toRString());
        getHandler(div).onLoad(開催予定情報);
        if(div.getChkPrintChoyoJimu().getSelectedKeys().contains(印刷帳票_すべて選択)){
            div.setHdnChkSubeteJimuFlag(new RString(Boolean.TRUE.toString()));
        }else{
            div.setHdnChkSubeteJimuFlag(new RString(Boolean.FALSE.toString()));
        }
        if(div.getChkPrintChoyoJimu().getSelectedKeys().contains(印刷帳票_すべて選択)){
            div.setHdnChkSubeteIinFlag(new RString(Boolean.TRUE.toString()));
        }else{
            div.setHdnChkSubeteIinFlag(new RString(Boolean.FALSE.toString()));
        }
        
        return ResponseData.of(div).respond();
    }

    /**
     * 作成条件ラジオボタンを変更する場合、表示項目を変更する。
     *
     * @param div PublicationShiryoShinsakaiDiv
     * @return ResponseData<PublicationShiryoShinsakaiDiv>
     */
    public ResponseData<PublicationShiryoShinsakaiDiv> onClick_radSakuseiJoken(PublicationShiryoShinsakaiDiv div) {
        getHandler(div).活性と非活性設定();
        return ResponseData.of(div).respond();
    }

    /**
     * 出力スタイルを変更する場合、表示項目を変更する。
     *
     * @param div PublicationShiryoShinsakaiDiv
     * @return ResponseData<PublicationShiryoShinsakaiDiv>
     */
    public ResponseData<PublicationShiryoShinsakaiDiv> onClick_syutuHeDa(PublicationShiryoShinsakaiDiv div) {
        getHandler(div).onClick_syutuHeDa();
        return ResponseData.of(div).respond();
    }

    /**
     * 事務局用印刷帳票チェックボックスを変更する場合、表示項目を変更する。
     *
     * @param div PublicationShiryoShinsakaiDiv
     * @return ResponseData<PublicationShiryoShinsakaiDiv>
     */
    public ResponseData<PublicationShiryoShinsakaiDiv> onClick_chkPrintChoyoJimu(PublicationShiryoShinsakaiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            getHandler(div).onClick_chkPrintChoyoJimu();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 審査会委員用印刷帳票チェックボックスを変更する場合、表示項目を変更する。
     *
     * @param div PublicationShiryoShinsakaiDiv
     * @return ResponseData<PublicationShiryoShinsakaiDiv>
     */
    public ResponseData<PublicationShiryoShinsakaiDiv> onClick_chkPrintChohyoIin(PublicationShiryoShinsakaiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            getHandler(div).onClick_chkPrintChohyoIin();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」を押下場合、入力チェックを実行します。
     *
     * @param div PublicationShiryoShinsakaiDiv
     * @return ResponseData<PublicationShiryoShinsakaiDiv>
     */
    public ResponseData<PublicationShiryoShinsakaiDiv> onClick_btnCheck(PublicationShiryoShinsakaiDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).発行チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 実行するボタンを押下する場合、バッチ起動する。
     *
     * @param div PublicationShiryoShinsakaiDiv
     * @return ResponseData<ShiryoShinsakaiBatchParameter>
     */
    public ResponseData<DBE517000_ShinsakaiShiryoParameter> onClick_btnExecute(PublicationShiryoShinsakaiDiv div) {
        RString 審査会一覧_開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);
        RStringBuilder builder = new RStringBuilder();
        builder.append(new RString("DBEShinsakaiNo"))
                .append(審査会一覧_開催番号);
        前排他キーの解除(builder.toRString());
        return ResponseData.of(getHandler(div).onClick_btnKogakuParamSave()).respond();
    }

    private void 前排他キーのセット(RString 排他) {
        LockingKey 排他キー = new LockingKey(排他);
        if (!RealInitialLocker.tryGetLock(排他キー)) {
            ErrorMessage message = new ErrorMessage(UrErrorMessages.排他_バッチ実行中で更新不可.getMessage().getCode(),
                    UrErrorMessages.排他_バッチ実行中で更新不可.getMessage().evaluate());
            throw new ApplicationException(message);
        }
    }

    private void 前排他キーの解除(RString 排他) {
        LockingKey 排他キー = new LockingKey(排他);
        RealInitialLocker.release(排他キー);
    }

    private PublicationShiryoShinsakaiHandler getHandler(PublicationShiryoShinsakaiDiv div) {
        return new PublicationShiryoShinsakaiHandler(div);
    }

    private PublicationShiryoShinsakaiValidationHandler getValidationHandler(PublicationShiryoShinsakaiDiv div) {
        return new PublicationShiryoShinsakaiValidationHandler(div);
    }
}
