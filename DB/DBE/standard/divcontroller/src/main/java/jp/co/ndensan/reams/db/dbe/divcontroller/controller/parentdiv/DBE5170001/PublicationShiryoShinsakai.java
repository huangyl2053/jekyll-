/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5170001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiWariateJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.KaisaiYoteiJohoBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE517000.DBE517000_ShinsakaiShiryoParameter;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5170001.PublicationShiryoShinsakaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5170001.PublicationShiryoShinsakaiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5170001.PublicationShiryoShinsakaiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.NinteiKanryoJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ShinsakaiWariateJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.basic.shiryoshinsakai.ShiryoShinsakaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護認定審査会資料作成のコントローラです。
 *
 * @reamsid_L DBE-0150-010 linghuhang
 */
public class PublicationShiryoShinsakai {

    private final RString 印刷帳票_すべて選択 = new RString("0");
    private final RString マスキング完了処理_一次判定後 = new RString("1");

    /**
     * 画面初期化処理です。
     *
     * @param div PublicationShiryoShinsakaiDiv
     * @return ResponseData<PublicationShiryoShinsakaiDiv>
     */
    public ResponseData<PublicationShiryoShinsakaiDiv> onLoad(PublicationShiryoShinsakaiDiv div) {
        if (new RString(DbeErrorMessages.審査会割当未完了のため処理不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                || new RString(DbeErrorMessages.マスキング未完了のため処理不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnToPrint"), true);
            return ResponseData.of(div).respond();
        }
        RString 審査会一覧_開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);
        KaisaiYoteiJohoBusiness 開催予定情報
                = ShiryoShinsakaiFinder.createInstance().get開催予定情報(審査会一覧_開催番号);
        div.getTxtShinsakaiKaisaiNo().setValue(審査会一覧_開催番号);

        ShinsakaiWariateJohoManager 審査会割当情報Manager = InstanceProvider.create(ShinsakaiWariateJohoManager.class);
        List<ShinsakaiWariateJoho> 審査会割当情報リスト = 審査会割当情報Manager.get介護認定審査会割当情報By介護認定審査会開催番号(審査会一覧_開催番号);
        NinteiKanryoJohoManager 認定完了情報Manager = InstanceProvider.create(NinteiKanryoJohoManager.class);
        for (ShinsakaiWariateJoho 審査会割当情報 : 審査会割当情報リスト) {
            NinteiKanryoJoho 認定完了情報 = 認定完了情報Manager.get要介護認定完了情報(審査会割当情報.get申請書管理番号());
            if (マスキング完了処理_一次判定後.equals(DbBusinessConfig.get(ConfigNameDBE.マスキングチェックタイミング, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
                if ((審査会割当情報.get判定結果コード() == null || 審査会割当情報.get判定結果コード().isEmpty()) && 認定完了情報.get認定審査会割当完了年月日() == null) {
                    ErrorMessage message = new ErrorMessage(DbeErrorMessages.審査会割当未完了のため処理不可.getMessage().getCode(),
                            DbeErrorMessages.審査会割当未完了のため処理不可.getMessage().evaluate());
                    return ResponseData.of(div).addMessage(message).respond();
                }
            } else {
                if ((審査会割当情報.get判定結果コード() == null || 審査会割当情報.get判定結果コード().isEmpty()) && 認定完了情報.getマスキング完了年月日() == null) {
                    ErrorMessage message = new ErrorMessage(DbeErrorMessages.マスキング未完了のため処理不可.getMessage().getCode(),
                            DbeErrorMessages.マスキング未完了のため処理不可.getMessage().evaluate());
                    return ResponseData.of(div).addMessage(message).respond();
                }
            }
        }
        getHandler(div).onLoad(開催予定情報);
        if (div.getChkPrintChoyoJimu().getSelectedKeys().contains(印刷帳票_すべて選択)) {
            div.setHdnChkSubeteJimuFlag(new RString(Boolean.TRUE.toString()));
        } else {
            div.setHdnChkSubeteJimuFlag(new RString(Boolean.FALSE.toString()));
        }
        if (div.getChkPrintChohyoIin().getSelectedKeys().contains(印刷帳票_すべて選択)) {
            div.setHdnChkSubeteIinFlag(new RString(Boolean.TRUE.toString()));
        } else {
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
     * 審査会委員用印刷帳票チェックボックス2を変更する場合、表示項目を変更する。
     *
     * @param div PublicationShiryoShinsakaiDiv
     * @return ResponseData<PublicationShiryoShinsakaiDiv>
     */
    public ResponseData<PublicationShiryoShinsakaiDiv> onClick_chkPrintChohyoIin2(PublicationShiryoShinsakaiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            getHandler(div).onClick_chkPrintChohyoIin2();
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
        return ResponseData.of(getHandler(div).onClick_btnKogakuParamSave()).respond();
    }

    private PublicationShiryoShinsakaiHandler getHandler(PublicationShiryoShinsakaiDiv div) {
        return new PublicationShiryoShinsakaiHandler(div);
    }

    private PublicationShiryoShinsakaiValidationHandler getValidationHandler(PublicationShiryoShinsakaiDiv div) {
        return new PublicationShiryoShinsakaiValidationHandler(div);
    }
}
