/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2240001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE250001.DBE250001_NinteiChosaKekkaTorikomiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2240001.NinteiChosaOCRTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2240001.NinteiChosaKekkaTorikomiOcrHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2240001.NinteiChosaKekkaTorikomiOcrValidationHandler;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.ZipUtil;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 認定調査結果取込み（OCR）のコントローラクラスです。
 *
 * @reamsid_L DBE-1540-010 dongyabin
 */
public class NinteiChosaOCRTorikomi {

    private static final RString イメージ取込み = new RString("イメージ取込み");
    private static final int DAY_COUNT_一週間 = 7;
    private static final RString UICONTAINERID_DBEUC20601 = new RString("DBEUC20601");
    private static final RString WORKFLOW_KEY_BATCH = new RString("Batch");
    private static final RString BUTTON_BATCH_REGISTER = new RString("btnBatchRegister");
    private static final RString WORKFOLDERNAME = new RString("ninteishosaOCRDataTorikomiWork");

    /**
     * 画面の初期化します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData<NinteiChosaOCRTorikomiDiv> onLoad(NinteiChosaOCRTorikomiDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 「アップロードする」ボタンのイベント処理です。<br>
     * 指定されたファイルをサーバーへアップロードします。
     *
     * @param div イメージ取込み画面情報
     * @param files 選択されたファイル
     * @return 処理後の画面情報
     */
    public ResponseData<NinteiChosaOCRTorikomiDiv> onClick_btnUpload(NinteiChosaOCRTorikomiDiv div, FileData[] files) {
        SharedFileDescriptor sfd = new SharedFileDescriptor(
                GyomuCode.DB介護保険, FilesystemName.fromString(イメージ取込み));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts
                = new CopyToSharedFileOpts().dateToDelete(RDate.getNowDate().plusDay(DAY_COUNT_一週間)).isCompressedArchive(false);
        RString sharedFileEntryDescriptorString = RString.EMPTY;
        ValidationMessageControlPairs v;
        int zipCount = 1;
        for (FileData file : files) {
            RString outputPath = Directory.createWorkDirectory(WORKFOLDERNAME.toString());
            if (file.getFileName().endsWith(new RString(".zip"))
                    || file.getFileName().endsWith(new RString(".ZIP"))) {
                v = getValidationHandler(div).validationZip(zipCount++);
                if (v.iterator().hasNext()) {
                    Directory.deleteWorkDirectory(WORKFOLDERNAME.toString());
                    CommonButtonHolder.setDisabledByCommonButtonFieldName(BUTTON_BATCH_REGISTER, true);
                    return ResponseData.of(div).addValidationMessages(v).respond();
                }
                RString filter = new RString("*.{csv,CSV,ca3,CA3,png,PNG}");
                ZipUtil.extractAllFiles(file.getFilePath(), outputPath);
                for (RString filePath : Directory.getFiles(outputPath, filter, false)) {
                    sharedFileEntryDescriptorString = toSharedFile(sharedFileEntryDescriptorString, Path.combinePath(outputPath, filePath), sfd, opts);
                }
            Directory.deleteWorkDirectory(WORKFOLDERNAME.toString());
            } else {
                sharedFileEntryDescriptorString = toSharedFile(sharedFileEntryDescriptorString, file.getFilePath(), sfd, opts);
            }
        }

        v = getValidationHandler(div).validateUploadedFiles(sharedFileEntryDescriptorString);
        if (v.iterator().hasNext()) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(BUTTON_BATCH_REGISTER, true);
            return ResponseData.of(div).addValidationMessages(v).respond();
        }
        CommonButtonHolder.setDisabledByCommonButtonFieldName(BUTTON_BATCH_REGISTER, false);
        div.setHdnSharedFileEntryInfo(sharedFileEntryDescriptorString);
        return ResponseData.of(div).respond();
    }
    
    private RString toSharedFile(RString sharedFileEntryDescriptorString, RString filePath, SharedFileDescriptor sfd, CopyToSharedFileOpts opts) {
        if (sharedFileEntryDescriptorString.isEmpty()) {
            sharedFileEntryDescriptorString = new RString(SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts).toString());
        } else {
            ReadOnlySharedFileEntryDescriptor ro_sfd = new ReadOnlySharedFileEntryDescriptor(
                    GyomuCode.DB介護保険, FilesystemName.fromString(イメージ取込み),
                    SharedFileEntryDescriptor.fromString(sharedFileEntryDescriptorString.toString()).getSharedFileId());
            SharedFile.appendNewFile(ro_sfd, new FilesystemPath(filePath), "");
        }
        return sharedFileEntryDescriptorString;
    }

    /**
     * バッチパラメータのセット処理を行う。<br />
     *
     * @param div OCR取込画面情報
     * @return 画面情報より作成したバッチパラメータ情報
     */
    public ResponseData<DBE250001_NinteiChosaKekkaTorikomiParameter> onSetBatchParameterURL(NinteiChosaOCRTorikomiDiv div) {
        RString uiContainerID = ResponseHolder.getUIContainerId();
        if (UICONTAINERID_DBEUC20601.equals(uiContainerID)) {
            FlowParameters fp = FlowParameters.of(new RString("key"), WORKFLOW_KEY_BATCH);
            FlowParameterAccessor.merge(fp);
        }
        DBE250001_NinteiChosaKekkaTorikomiParameter parameter = getHandler(div).createBatchParameter();
        return ResponseData.of(parameter).respond();
    }

    private NinteiChosaKekkaTorikomiOcrHandler getHandler(NinteiChosaOCRTorikomiDiv div) {
        return new NinteiChosaKekkaTorikomiOcrHandler(div);
    }

    private NinteiChosaKekkaTorikomiOcrValidationHandler getValidationHandler(NinteiChosaOCRTorikomiDiv div) {
        return new NinteiChosaKekkaTorikomiOcrValidationHandler(div);
    }
}
