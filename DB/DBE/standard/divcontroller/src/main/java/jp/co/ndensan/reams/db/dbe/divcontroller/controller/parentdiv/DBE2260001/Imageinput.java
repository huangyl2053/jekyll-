/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2260001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE250002.DBE250002_ImageTorikomiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2260001.ImageinputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2260001.ImageinputHandler;
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
 * イメージ取込み（規定・規定外）のコントローラクラスです。
 *
 * @reamsid_L DBE-1580-010 dongyabin
 */
public class Imageinput {

    private static final RString イメージ取込み = new RString("イメージ取込み");
    private static final int DAY_COUNT_一週間 = 7;
    private static final RString バッチ実行ボタン名 = new RString("btnBatchRegister");
    private static final RString UICONTAINERID_DBEUC20701 = new RString("DBEUC20701");
    private static final RString WORKFLOW_KEY_BATCH = new RString("Batch");

    /**
     * 画面の初期化します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData<ImageinputDiv> onLoad(ImageinputDiv div) {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(バッチ実行ボタン名, true);
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
    public ResponseData<ImageinputDiv> onClick_btnUpload(ImageinputDiv div, FileData[] files) {
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

        div.setHdnSharedFileEntryInfo(SharedFileEntryDescriptorString);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(バッチ実行ボタン名, false);
        return ResponseData.of(div).respond();
    }

    /**
     * バッチパラメータのセット処理を行う。<br />
     *
     * @param div OCR取込画面情報
     * @return 画面情報より作成したバッチパラメータ情報
     */
    public ResponseData<DBE250002_ImageTorikomiParameter> onSetBatchParameterURL(ImageinputDiv div) {
        RString uiContainerID = ResponseHolder.getUIContainerId();
        if (UICONTAINERID_DBEUC20701.equals(uiContainerID)) {
            FlowParameters fp = FlowParameters.of(new RString("key"), WORKFLOW_KEY_BATCH);
            FlowParameterAccessor.merge(fp);
        }
        DBE250002_ImageTorikomiParameter parameter = getHandler(div).setバッチパラメータ();
        return ResponseData.of(parameter).respond();
    }

    private ImageinputHandler getHandler(ImageinputDiv div) {
        return new ImageinputHandler(div);
    }
}
