/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2240001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE250001.DBE250001_NinteiChosaKekkaTorikomiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2240001.NinteiChosaOCRTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2240001.NinteiChosaKekkaTorikomiOcrHandler;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
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
        RString SharedFileEntryDescriptorString = RString.EMPTY;
        for (FileData file : files) {
            if (SharedFileEntryDescriptorString.isEmpty()) {
                SharedFileEntryDescriptorString = new RString(SharedFile.copyToSharedFile(sfd, new FilesystemPath(file.getFilePath()), opts).toString());
            } else {
                ReadOnlySharedFileEntryDescriptor ro_sfd = new ReadOnlySharedFileEntryDescriptor(
                        GyomuCode.DB介護保険, FilesystemName.fromString(イメージ取込み),
                        SharedFileEntryDescriptor.fromString(SharedFileEntryDescriptorString.toString()).getSharedFileId());
                SharedFile.appendNewFile(ro_sfd, new FilesystemPath(file.getFilePath()), "");
            }
        }
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnBatchRegister"), false);
        div.setHdnSharedFileEntryInfo(SharedFileEntryDescriptorString);
        return ResponseData.of(div).respond();
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
        DBE250001_NinteiChosaKekkaTorikomiParameter parameter = getHandler(div).setバッチパラメータ();
        return ResponseData.of(parameter).respond();
    }

    private NinteiChosaKekkaTorikomiOcrHandler getHandler(NinteiChosaOCRTorikomiDiv div) {
        return new NinteiChosaKekkaTorikomiOcrHandler(div);
    }
}
