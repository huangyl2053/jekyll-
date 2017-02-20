/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5220001;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE518002.DBE518002_NinteiShinsaIraiIfTorikomiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5220001.NinteiShinsakaiKekkaDataTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5220001.NinteiShinsakaiKekkaDataTorikomiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5220001.NinteiShinsakaiKekkaDataTorikomiValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.ZipUtil;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBE5220001_介護認定審査会審査結果データ取込み（モバイル）画面クラスです
 *
 * @reamsid_L DBE-1841-010 xuyongchao
 */
public class NinteiShinsakaiKekkaDataTorikomi {

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiShinsakaiKekkaDataTorikomiDiv>
     */
    public ResponseData<NinteiShinsakaiKekkaDataTorikomiDiv> onLoad(NinteiShinsakaiKekkaDataTorikomiDiv div) {
        getHandler(div).setOnLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 実行ボタン処理です。
     *
     * @param div 画面情報
     * @return NinteiShinsakaiKekkaDataTorikomiDiv
     */
    public ResponseData<DBE518002_NinteiShinsaIraiIfTorikomiParameter> onClick_Jikkou(NinteiShinsakaiKekkaDataTorikomiDiv div) {
        return ResponseData.of(getHandler(div).setBatchParameter()).respond();
    }

    /**
     * 「アップロードする」ボタンを押します。
     *
     * @param div 画面情報
     * @param files ファイル
     * @return ResponseData<NinteiShinsakaiKekkaDataTorikomiDiv>
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<NinteiShinsakaiKekkaDataTorikomiDiv> onclick_BtnUpload(NinteiShinsakaiKekkaDataTorikomiDiv div, FileData[] files) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        ValidationMessageControlPairs fileNumCheck = getValidationHandler(div).validateFileNum(validationMessages, files);
        if (fileNumCheck.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(fileNumCheck).respond();
        }
        for (File file : unzipped(files[0].getFilePath())) {
            ValidationMessageControlPairs validPairs = getValidationHandler(div).一致性チェック(validationMessages, file);
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
            savaCsvファイル(file, div);
        }
        return ResponseData.of(div).respond();
    }

    private static List<File> unzipped(RString zipFilePath) {
        RString outputFolderPath = Directory.createTmpDirectory();
        ZipUtil.extractAllFiles(zipFilePath, outputFolderPath);
        return Arrays.asList(new File(outputFolderPath.toString()).listFiles());
    }

    /**
     * 入力チェックです。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiShinsakaiKekkaDataTorikomiDiv>
     */
    public ResponseData<NinteiShinsakaiKekkaDataTorikomiDiv> onClick_Check(NinteiShinsakaiKekkaDataTorikomiDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        ValidationMessageControlPairs validPairs = getValidationHandler(div).データ件数チェック(validationMessages);
        validPairs = getValidationHandler(div).回数チェック(validPairs);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    private boolean savaCsvファイル(File local, NinteiShinsakaiKekkaDataTorikomiDiv div) {
        RString path = Path.combinePath(Path.getRootPath(RString.EMPTY), DbBusinessConfig
                .get(ConfigNameDBE.OCRアップロード用ファイル格納パス, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        File サーバ = new File(path.toString());
        boolean mkdirsFlag = false;
        boolean delFileFlag = false;
        File tmpfile;
        if (!サーバ.exists()) {
            mkdirsFlag = サーバ.mkdirs();
        } else {
            mkdirsFlag = true;
        }
        if (mkdirsFlag) {
            tmpfile = new File(サーバ, getHandler(div).getFileName(local).toString());
            if (tmpfile.exists()) {
                delFileFlag = tmpfile.delete();
            } else {
                delFileFlag = true;
            }
            if (delFileFlag) {
                return local.renameTo(tmpfile);
            }
        }
        return true;
    }

    private NinteiShinsakaiKekkaDataTorikomiHandler getHandler(NinteiShinsakaiKekkaDataTorikomiDiv div) {
        return new NinteiShinsakaiKekkaDataTorikomiHandler(div);
    }

    private NinteiShinsakaiKekkaDataTorikomiValidationHandler getValidationHandler(NinteiShinsakaiKekkaDataTorikomiDiv div) {
        return new NinteiShinsakaiKekkaDataTorikomiValidationHandler(div);
    }
}
