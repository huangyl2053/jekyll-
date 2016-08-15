/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE1920001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.renkeidatatorikomi.RenkeiDataTorikomiBatchParamter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.DBE1920001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.RenkeiDataTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.dgTorikomiTaisho_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1920001.RenkeiDataTorikomiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1920001.RenkeiDataTorikomiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.renkeidatatorikomi.RenkeiDataTorikomiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
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
    private static final RString あり = new RString("1");

    /**
     * 初期化の設定します。
     *
     * @param div RenkeiDataTorikomiDiv
     * @return ResponseData<RenkeiDataTorikomiDiv>
     */
    public ResponseData<RenkeiDataTorikomiDiv> onLoad(RenkeiDataTorikomiDiv div) {
        RString path = DbBusinessConfig.get(ConfigNameDBE.認定申請連携データ出力先, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        getHandler(div).onLoad(RenkeiDataTorikomiFinder.createInstance().get法改正前Flag(FlexibleDate.getNowDate()), path);
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        for (dgTorikomiTaisho_Row row : div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho().getDataSource()) {
            if (row.getTotal().equals(あり)) {
                if (要介護認定申請連携データ取込みファイル名.equals(row.getFileName())) {
                    validPairs = getValidationHandler(div).check認定申請情報ファイル(validPairs, path, false);
                } else if (認定調査委託先データ取込みファイル名.equals(row.getFileName())) {
                    validPairs = getValidationHandler(div).check認定調査委託先情報ファイル(validPairs, path, false);
                } else if (認定調査員データ取込みファイル名.equals(row.getFileName())) {
                    validPairs = getValidationHandler(div).check認定調査員情報ファイル(validPairs, path, false);
                } else if (主治医医療機関データ取込みファイル名.equals(row.getFileName())) {
                    validPairs = getValidationHandler(div).check主治医医療機関情報ファイル(validPairs, path, false);
                } else if (主治医データ取込みファイル名.equals(row.getFileName())) {
                    validPairs = getValidationHandler(div).check主治医情報ファイル(validPairs, path, false);
                }
            }
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
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
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
        boolean is認定申請情報ファイル = false;
        boolean is認定調査委託先情報ファイル = false;
        boolean is認定調査員情報ファイル = false;
        boolean is主治医医療機関情報ファイル = false;
        boolean is主治医情報ファイル = false;
        for (FileData file : files) {
            if (要介護認定申請.equals(file.getFileName())) {
                validPairs = getValidationHandler(div).check認定申請情報ファイル(validPairs, file.getFilePath(), true);
                is認定申請情報ファイル = true;
            } else if (認定調査委託先.equals(file.getFileName())) {
                validPairs = getValidationHandler(div).check認定調査委託先情報ファイル(validPairs, file.getFilePath(), true);
                is認定調査委託先情報ファイル = true;
            } else if (認定調査員.equals(file.getFileName())) {
                validPairs = getValidationHandler(div).check認定調査員情報ファイル(validPairs, file.getFilePath(), true);
                is認定調査員情報ファイル = true;
            } else if (主治医医療機関.equals(file.getFileName())) {
                validPairs = getValidationHandler(div).check主治医医療機関情報ファイル(validPairs, file.getFilePath(), true);
                is主治医医療機関情報ファイル = true;
            } else if (主治医.equals(file.getFileName())) {
                validPairs = getValidationHandler(div).check主治医情報ファイル(validPairs, file.getFilePath(), true);
                is主治医情報ファイル = true;
            }
        }
        validPairs = getValidationHandler(div).checkFileName(validPairs,
                is認定申請情報ファイル, is認定調査委託先情報ファイル, is認定調査員情報ファイル,
                is主治医医療機関情報ファイル, is主治医情報ファイル);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        for (FileData file : files) {
            getHandler(div).upLoadFile(new FilesystemPath(file.getFilePath()));
        }
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
    public ResponseData<RenkeiDataTorikomiBatchParamter> onClick_JikkouBtn(RenkeiDataTorikomiDiv div) {
        return ResponseData.of(getHandler(div).setBatchParameter()).respond();
    }

    private RenkeiDataTorikomiHandler getHandler(RenkeiDataTorikomiDiv div) {
        return new RenkeiDataTorikomiHandler(div);
    }

    private RenkeiDataTorikomiValidationHandler getValidationHandler(RenkeiDataTorikomiDiv div) {
        return new RenkeiDataTorikomiValidationHandler(div);
    }
}
