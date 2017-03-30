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
import jp.co.ndensan.reams.db.dbe.definition.core.exclusion.LockingKeys;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5170001.PublicationShiryoShinsakaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5170001.PublicationShiryoShinsakaiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5170001.PublicationShiryoShinsakaiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.NinteiKanryoJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ShinsakaiWariateJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.basic.shiryoshinsakai.ShiryoShinsakaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinsakaiWariateJohoKenshu;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShinsakaiWariateJohoKenshuManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護認定審査会資料作成のコントローラです。
 *
 * @reamsid_L DBE-0150-010 linghuhang
 */
public class PublicationShiryoShinsakai {

    private final RString マスキング完了処理_審査会割当後 = new RString("2");
    private final RString 実行するボタン = new RString("btnToPrint");

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
        getHandler(div).onLoad(開催予定情報);
        if (!RealInitialLocker.tryGetLock(LockingKeys.介護認定審査会開催番号.appended(審査会一覧_開催番号))) {
            div.setReadOnly(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(実行するボタン, true);
            throw new PessimisticLockingException();
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
        getHandler(div).onChange作成条件();
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
        getHandler(div).onClickChk組み合わせ帳票_事務();
        return ResponseData.of(div).respond();
    }

    /**
     * 審査会委員用印刷帳票チェックボックスを変更する場合、表示項目を変更する。
     *
     * @param div PublicationShiryoShinsakaiDiv
     * @return ResponseData<PublicationShiryoShinsakaiDiv>
     */
    public ResponseData<PublicationShiryoShinsakaiDiv> onClick_chkPrintChohyoIin(PublicationShiryoShinsakaiDiv div) {
        getHandler(div).onClickChk組み合わせ帳票_委員();
        return ResponseData.of(div).respond();
    }

    /**
     * 審査会委員用印刷帳票チェックボックス2を変更する場合、表示項目を変更する。
     *
     * @param div PublicationShiryoShinsakaiDiv
     * @return ResponseData<PublicationShiryoShinsakaiDiv>
     */
    public ResponseData<PublicationShiryoShinsakaiDiv> onClick_chkPrintChohyoIin2(PublicationShiryoShinsakaiDiv div) {
        getHandler(div).onClickChk審査会資料以外帳票_委員();
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
        RString 審査会一覧_開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);
        ShinsakaiWariateJohoManager 審査会割当情報Manager = InstanceProvider.create(ShinsakaiWariateJohoManager.class);
        List<ShinsakaiWariateJoho> 審査会割当情報リスト = 審査会割当情報Manager.get介護認定審査会割当情報By介護認定審査会開催番号(審査会一覧_開催番号);
        ShinsakaiWariateJohoKenshuManager 審査会割当情報研修Manager = InstanceProvider.create(ShinsakaiWariateJohoKenshuManager.class);
        List<ShinsakaiWariateJohoKenshu> 審査会割当情報研修リスト = 審査会割当情報研修Manager.get審査会割当情報研修By審査会開催番号(審査会一覧_開催番号);
        NinteiKanryoJohoManager 認定完了情報Manager = InstanceProvider.create(NinteiKanryoJohoManager.class);
        ErrorMessage message;
        for (ShinsakaiWariateJoho 審査会割当情報 : 審査会割当情報リスト) {
            message = check概況調査情報(審査会割当情報.get申請書管理番号());
            if (message != null) {
                throw new ApplicationException(message);
            }
            if (div.getPublishingCondition().getChkTestPrint().getSelectedKeys().isEmpty()) {
                NinteiKanryoJoho 認定完了情報 = 認定完了情報Manager.get要介護認定完了情報(審査会割当情報.get申請書管理番号());
                if ((審査会割当情報.get判定結果コード() == null || 審査会割当情報.get判定結果コード().isEmpty()) && 認定完了情報.get認定審査会割当完了年月日() == null) {
                    throw new ApplicationException(DbeErrorMessages.審査会割当未完了のため処理不可.getMessage());
                }
                message = checkマスキング完了日(審査会割当情報.get申請書管理番号(), 審査会割当情報.get判定結果コード());
                if (message != null) {
                    throw new ApplicationException(message);
                }
            }
        }
        for (ShinsakaiWariateJohoKenshu 審査会割当情報研修 : 審査会割当情報研修リスト) {
            message = check概況調査情報(審査会割当情報研修.get申請書管理番号());
            if (message != null) {
                throw new ApplicationException(message);
            }
            if (div.getPublishingCondition().getChkTestPrint().getSelectedKeys().isEmpty()) {
                message = checkマスキング完了日(審査会割当情報研修.get申請書管理番号(), 審査会割当情報研修.get判定結果コード());
                if (message != null) {
                    throw new ApplicationException(message);
                }
            }
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

    private ErrorMessage check概況調査情報(ShinseishoKanriNo 申請書管理番号) {
        ErrorMessage message = null;
        NinteichosahyoGaikyoChosa 認定調査票概況調査情報
                = ShiryoShinsakaiFinder.createInstance().get認定調査票概況調査(申請書管理番号);
        if (認定調査票概況調査情報 != null) {
            if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(認定調査票概況調査情報.get厚労省IF識別コード().getColumnValue())
                    || KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(認定調査票概況調査情報.get厚労省IF識別コード().getColumnValue())
                    || KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(認定調査票概況調査情報.get厚労省IF識別コード().getColumnValue())) {
                message = new ErrorMessage(DbeErrorMessages.厚労省IF識別番号が09A以前.getMessage().getCode(),
                        DbeErrorMessages.厚労省IF識別番号が09A以前.getMessage().evaluate());
            }
        } else {
            message = new ErrorMessage(UrErrorMessages.存在しない.getMessage().getCode(),
                    UrErrorMessages.存在しない.getMessage().replace("概況調査情報").evaluate());
        }
        return message;
    }

    private ErrorMessage checkマスキング完了日(ShinseishoKanriNo 申請書管理番号, Code 判定結果コード) {
        ErrorMessage message = null;
        NinteiKanryoJohoManager 認定完了情報Manager = InstanceProvider.create(NinteiKanryoJohoManager.class);
        NinteiKanryoJoho 認定完了情報 = 認定完了情報Manager.get要介護認定完了情報(申請書管理番号);
        if (マスキング完了処理_審査会割当後.equals(DbBusinessConfig.get(ConfigNameDBE.マスキングチェックタイミング, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            if ((判定結果コード == null || 判定結果コード.isEmpty()) && 認定完了情報.getマスキング完了年月日() == null) {
                message = new ErrorMessage(DbeErrorMessages.マスキング未完了のため処理不可.getMessage().getCode(),
                        DbeErrorMessages.マスキング未完了のため処理不可.getMessage().evaluate());
            }
        }
        return message;
    }

    private PublicationShiryoShinsakaiHandler getHandler(PublicationShiryoShinsakaiDiv div) {
        return new PublicationShiryoShinsakaiHandler(div);
    }

    private PublicationShiryoShinsakaiValidationHandler getValidationHandler(PublicationShiryoShinsakaiDiv div) {
        return new PublicationShiryoShinsakaiValidationHandler(div);
    }
}
