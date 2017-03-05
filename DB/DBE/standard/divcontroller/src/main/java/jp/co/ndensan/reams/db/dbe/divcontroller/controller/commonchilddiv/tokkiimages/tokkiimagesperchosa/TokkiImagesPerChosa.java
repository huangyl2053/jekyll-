/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.commonchilddiv.tokkiimages.tokkiimagesperchosa;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.TokkiImagesPerChosa.TokkiImagesPerChosaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.TokkiImagesPerKomoku.ITokkiImagesPerKomokuDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 *
 */
public class TokkiImagesPerChosa {

    /**
     *
     * @param div
     * @return
     */
    public ResponseData<TokkiImagesPerChosaDiv> onLoad(TokkiImagesPerChosaDiv div) {
        RString directoryPath = Directory.createTmpDirectory();
        SharedFile.copyToLocal(div.getSharedFileEntryDescriptor(), new FilesystemPath(directoryPath));
        div.initialize(directoryPath);
        return ResponseData.of(div).respond();
    }

    /**
     *
     * @param div
     * @return
     */
    public ResponseData<TokkiImagesPerChosaDiv> onClick_btnDisplay(TokkiImagesPerChosaDiv div) {
        if (!ResponseHolder.isReRequest() && isDirty(div.getEditing())) {
            return ResponseData.of(div)
                    .addMessage(UrQuestionMessages.入力内容の破棄.getMessage())
                    .respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        div.renderSelectedTokkiJiko();
        return ResponseData.of(div).respond();
    }

    private boolean isDirty(ITokkiImagesPerKomokuDiv k) {
        return k == null ? false : k.isDirty();
    }

    /**
     *
     * @param div
     * @return
     */
    public ResponseData<TokkiImagesPerChosaDiv> onClick_btnSave(TokkiImagesPerChosaDiv div) {
        ITokkiImagesPerKomokuDiv edited = div.getRepTokkiJikos().getRepeateData().get(0);

        return ResponseData.of(div).respond();
    }
}
