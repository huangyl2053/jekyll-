/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE1920001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE192001.DBE192001_NnteiShinseiInfoUploadParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.DBE1920001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.RenkeiDataTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.dgTorikomiTaisho_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1920001.RenkeiDataTorikomiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1920001.RenkeiDataTorikomiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.renkeidatatorikomi.RenkeiDataTorikomiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.message.DbxErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護認定申請連携データ取込のコントローラです。
 *
 * @reamsid_L DBE-1490-010 xuyannan
 */
public class RenkeiDataTorikomi {

    private static final RString 要介護認定申請連携データ取込みファイル名 = new RString("Z8NCI201.CSV");
    private static final RString 認定調査委託先データ取込みファイル名 = new RString("C1NCI101.CSV");
    private static final RString 認定調査員データ取込みファイル名 = new RString("C1NCI111.CSV");
    private static final RString 主治医医療機関データ取込みファイル名 = new RString("C1NCI121.CSV");
    private static final RString 主治医データ取込みファイル名 = new RString("C1NCI131.CSV");
    private static final int なし = 0;

    /**
     * 初期化の設定します。
     *
     * @param div RenkeiDataTorikomiDiv
     * @return ResponseData<RenkeiDataTorikomiDiv>
     */
    public ResponseData<RenkeiDataTorikomiDiv> onLoad(RenkeiDataTorikomiDiv div) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        RString path = RString.EMPTY;
        try {
            path = DbBusinessConfig.get(ConfigNameDBE.認定申請連携データ出力先, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        } catch (SystemException e) {
            throw new ApplicationException(DbxErrorMessages.業務コンフィグなし.getMessage().replace(ConfigNameDBE.認定申請連携データ出力先.name()));
        }

        getHandler(div).onLoad(RenkeiDataTorikomiFinder.createInstance().get法改正前Flag(FlexibleDate.getNowDate()), path);
        for (dgTorikomiTaisho_Row row : div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho().getDataSource()) {
            if (Integer.parseInt(row.getTotal().toString()) > なし) {
                RString error = RString.EMPTY;
                if (要介護認定申請連携データ取込みファイル名.equals(row.getFileName())) {
                    error = getValidationHandler(div).check認定申請情報ファイル(path, false);
                } else if (認定調査委託先データ取込みファイル名.equals(row.getFileName())) {
                    error = getValidationHandler(div).check認定調査委託先情報ファイル(path, false);
                } else if (認定調査員データ取込みファイル名.equals(row.getFileName())) {
                    error = getValidationHandler(div).check認定調査員情報ファイル(path, false);
                } else if (主治医医療機関データ取込みファイル名.equals(row.getFileName())) {
                    error = getValidationHandler(div).check主治医医療機関情報ファイル(path, false);
                } else if (主治医データ取込みファイル名.equals(row.getFileName())) {
                    error = getValidationHandler(div).check主治医情報ファイル(path, false);
                }
            }
            row.setSelectable(Boolean.FALSE);
        }
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).setState(DBE1920001StateName.初期表示);
    }

    /**
     * 「連携データの取込みを実行する」ボタンを押下します。
     *
     * @param div RenkeiDataTorikomiDiv
     * @param files 対象ファイル
     * @return ResponseData<RenkeiDataTorikomiDiv>
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<RenkeiDataTorikomiDiv> onClick_TorikomiBtn(RenkeiDataTorikomiDiv div, FileData[] files) {
        RString error = RString.EMPTY;
        RString 要介護認定申請 = DbBusinessConfig.get(
                ConfigNameDBE.要介護認定申請連携データ取込みファイル名, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        RString 認定調査委託先 = DbBusinessConfig.get(
                ConfigNameDBE.認定調査委託先データ取込みファイル名, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        RString 認定調査員 = DbBusinessConfig.get(
                ConfigNameDBE.認定調査員データ取込みファイル名, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        RString 主治医医療機関 = DbBusinessConfig.get(
                ConfigNameDBE.主治医医療機関データ取込みファイル名, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        RString 主治医 = DbBusinessConfig.get(
                ConfigNameDBE.主治医データ取込みファイル名, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        for (FileData file : files) {
            if (要介護認定申請.equals(file.getFileName())) {
                error = getValidationHandler(div).check認定申請情報ファイル(file.getFilePath(), true);
            } else if (認定調査委託先.equals(file.getFileName())) {
                error = getValidationHandler(div).check認定調査委託先情報ファイル(file.getFilePath(), true);
            } else if (認定調査員.equals(file.getFileName())) {
                error = getValidationHandler(div).check認定調査員情報ファイル(file.getFilePath(), true);
            } else if (主治医医療機関.equals(file.getFileName())) {
                error = getValidationHandler(div).check主治医医療機関情報ファイル(file.getFilePath(), true);
            } else if (主治医.equals(file.getFileName())) {
                error = getValidationHandler(div).check主治医情報ファイル(file.getFilePath(), true);
            }
        }
        RStringBuilder buider = new RStringBuilder();
        for (FileData file : files) {
            getHandler(div).upLoadFile(file, buider);
        }
        boolean flag = false;
        if (div.getDgTorikomiTaisho().getSelectedItems() != null && !div.getDgTorikomiTaisho().getSelectedItems().isEmpty()) {
            flag = true;
        }
        if (flag) {
            div.getUploadArea().getBtnDataTorikomi().setDisabled(false);
        }
        if (!RString.isNullOrEmpty(error)) {
            getValidationHandler(div).checkゼロ件ファイル(files);
        } else {
            div.setHiddenErrorFiles(error);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧を表示します。
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<RenkeiDataTorikomiDiv> onClick_SetItiran(RenkeiDataTorikomiDiv div) {
        getHandler(div).getFileData();
        return ResponseData.of(div).setState(DBE1920001StateName.一覧表示);
    }

    /**
     * 「実行する」ボタン押下前、チェック実施。
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<RenkeiDataTorikomiDiv> onClick_JikkouCheck(RenkeiDataTorikomiDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).checkSelected();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンを押下します。
     *
     * @param div RenkeiDataTorikomiDiv
     * @return ResponseData<RenkeiDataTorikomiBatchParamter>
     */
    public ResponseData<DBE192001_NnteiShinseiInfoUploadParameter> onClick_JikkouBtn(RenkeiDataTorikomiDiv div) {
        return ResponseData.of(getHandler(div).setBatchParameter()).respond();
    }

    /**
     * アップロード時のエラーチェックを行います。
     *
     * @param div RenkeiDataTorikomiDiv
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<RenkeiDataTorikomiDiv> afterUpload(RenkeiDataTorikomiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            Message error = getValidationHandler(div).getError();
            if (!error.equals(Message.NO_MESSAGE)) {
                return ResponseData.of(div).addMessage(error).respond();
            }
            Message message = getValidationHandler(div).getMessage();
            if (!message.equals(Message.NO_MESSAGE)) {
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    private RenkeiDataTorikomiHandler getHandler(RenkeiDataTorikomiDiv div) {
        return new RenkeiDataTorikomiHandler(div);
    }

    private RenkeiDataTorikomiValidationHandler getValidationHandler(RenkeiDataTorikomiDiv div) {
        return new RenkeiDataTorikomiValidationHandler(div);
    }
}
