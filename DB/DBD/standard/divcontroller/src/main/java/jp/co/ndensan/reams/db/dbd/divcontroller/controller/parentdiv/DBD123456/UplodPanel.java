/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD123456;

import java.io.File;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD123456.UplodPanelDiv;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;

/**
 *
 * @author tianyh
 */
public class UplodPanel {

    /**
     * 連携データを取込みするを押下。
     *
     * @param div UplodPanelDiv
     * @param files FileData
     * @return ResponseData<YogaigoNinteiKekkaRenkeiDataTorikomiDiv>
     */
    public ResponseData<UplodPanelDiv> onClick_appurodo(UplodPanelDiv div, FileData... files) {
//        RString failname = div.getTextBoxUrl().getValue();
//        FilesystemName filesystemName = new FilesystemName(failname);
//        RString tmpPath = new RString("C:\\Users\\tianyh\\Desktop\\".concat(failname.toString()));
//        FilesystemPath filesystemPath = new FilesystemPath(tmpPath);
//        SharedFile.defineSharedFile(filesystemName);
//        SharedFile.copyToSharedFile(filesystemPath, filesystemName);

        for (FileData file : files) {
            File shareFile = new File(file.getFilePath().toString());
            RString localFilePath = new RString(shareFile.getPath());
            FilesystemPath path = new FilesystemPath(localFilePath);
            FilesystemName filesystemName = new FilesystemName(file.getFileName());
            SharedFileDescriptor sfd = SharedFile.defineSharedFile(filesystemName);
            CopyToSharedFileOpts opts = new CopyToSharedFileOpts();
            SharedFile.copyToSharedFile(sfd, path, opts);
        }
        return ResponseData.of(div).respond();
    }
}
