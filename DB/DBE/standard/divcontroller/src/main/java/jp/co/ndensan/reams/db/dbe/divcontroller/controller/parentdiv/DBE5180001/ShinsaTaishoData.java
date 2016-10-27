/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5180001;

import jp.co.ndensan.reams.db.dbe.business.core.shinsataishodataoutput.ISaikaiObjectOutPutBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.shinsataishodataoutput.ShinsaTaishoDataOutPutBatchParammeter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5180001.ShinsaTaishoDataDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5180001.ShinsaTaishoDataValidationHandler;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFileDirectAccessDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFileDirectAccessDownload;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.ZipUtil;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 介護認定審査会審査対象データ出力（モバイル）クラスです。
 *
 * @reamsid_L DBE-1840-010 yaoyahui
 */
public class ShinsaTaishoData {

    private static final RString モード = new RString("dataShutsuryoku");
    private static final RString 書庫化ファイル名 = new RString("Image.zip");

    /**
     * 介護認定審査会審査対象データ出力（モバイル）Divを初期化します。
     *
     * @param div 介護認定審査会審査対象データ出力（モバイル）Div
     * @return ResponseData<ShinsaTaishoDataDiv> 介護認定審査会審査対象データ出力（モバイル）Div
     */
    public ResponseData<ShinsaTaishoDataDiv> onLoad(ShinsaTaishoDataDiv div) {
        div.getCcdShinsakaiIchiranList().initialize(モード);
        return ResponseData.of(div).respond();
    }

    /**
     * 審査会データ空チェックを実施します。
     *
     * @param div 介護認定審査会審査対象データ出力（モバイル）Div
     * @return ResponseData<ShinsaTaishoDataDiv>
     */
    public ResponseData<ShinsaTaishoDataDiv> onClick_Check(ShinsaTaishoDataDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).データの選択チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * パラメーターを作成します。
     *
     * @param div バッチパラメータ情報Div
     * @return ResponseData<ShinsaTaishoDataOutPutBatchParammeter>
     */
    public ResponseData<ShinsaTaishoDataOutPutBatchParammeter> onClick_btnAction(ShinsaTaishoDataDiv div) {
        ShinsaTaishoDataOutPutBatchParammeter parameter = new ShinsaTaishoDataOutPutBatchParammeter();
        parameter.setKaisaiBangou(div.getCcdShinsakaiIchiranList().get開催番号List().get(0));
        return ResponseData.of(parameter).respond();
    }

    /**
     * イメージファイルをdownLoadします。
     *
     * @param div 要介護認定イメージ情報出力画面
     * @param response IDownLoadServletResponse
     * @return ResponseData
     */
    public IDownLoadServletResponse onclick_btnDownLoad(ShinsaTaishoDataDiv div, IDownLoadServletResponse response) {
        ISaikaiObjectOutPutBusiness entity = getValidationHandler(div).get審査対象Entity(div.getCcdShinsakaiIchiranList().get開催番号List().get(0));
        ReadOnlySharedFileEntryDescriptor ro_sfed = new ReadOnlySharedFileEntryDescriptor(
                new FilesystemName(entity.get証記載保険者番号().concat(entity.get被保険者番号())), entity.getイメージ共有ファイルID());
        RString zipPath = Path.combinePath(Path.getTmpDirectoryPath(), 書庫化ファイル名);
        ZipUtil.createFromFolder(zipPath, ro_sfed.getDirectAccessPath());
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(書庫化ファイル名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(zipPath), opts);
        SharedFileDirectAccessDescriptor sfdad = new SharedFileDirectAccessDescriptor(entry, 書庫化ファイル名);
        return SharedFileDirectAccessDownload.directAccessDownload(sfdad, response);
    }

    private ShinsaTaishoDataValidationHandler getValidationHandler(ShinsaTaishoDataDiv div) {
        return new ShinsaTaishoDataValidationHandler(div);
    }
}
