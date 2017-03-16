/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.commonchilddiv.tokkiimages.tokkiimagesperchosa;

import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeNotificationMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.TokkiImagesPerChosa.TokkiImagesPerChosaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.TokkiImagesPerKomoku.ITokkiImagesPerKomokuDiv;
import jp.co.ndensan.reams.db.dbe.service.core.tokkiimages.TokkiRembanRenumberingService;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.ExclusiveLock;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * {@link TokkiImagesPerChosaDiv}のイベントを保持します。
 */
public class TokkiImagesPerChosa {

    /**
     * @param div {@link TokkiImagesPerChosaDiv}
     * @return response
     */
    public ResponseData<TokkiImagesPerChosaDiv> onLoad(TokkiImagesPerChosaDiv div) {
        div.initialize(copyToLocalDirectory(div.getSharedFileEntryDescriptor()));
        return ResponseData.of(div).respond();
    }

    private static RString copyToLocalDirectory(ReadOnlySharedFileEntryDescriptor rosfed) {
        RString directoryPath = Directory.createTmpDirectory();
        SharedFile.copyToLocal(rosfed, new FilesystemPath(directoryPath));
        return directoryPath;
    }

    /**
     * @param div {@link TokkiImagesPerChosaDiv}
     * @return response
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
     * @param div {@link TokkiImagesPerChosaDiv}
     * @return response
     */
    public ResponseData<TokkiImagesPerChosaDiv> onClick_btnSave(TokkiImagesPerChosaDiv div) {
        if (ExclusiveLock.isLocked(ResponseHolder.getUIContainerId())) {
            throw new ApplicationException(DbeErrorMessages.バッチとの機能間排他.getMessage());
        }

        ITokkiImagesPerKomokuDiv edited = div.getEditing();
        if (edited == null) {
            return ResponseData.of(div).respond();
        }
        ValidationMessageControlPairs result = edited.validate();
        if (result.existsError()) {
            return ResponseData.of(div).addValidationMessages(result).respond();
        }
        ReadOnlySharedFileEntryDescriptor rosfed = div.getSharedFileEntryDescriptor();
        TokkiRembanRenumberingService.createInstance().save(
                rosfed,
                div.getDirectoryPath(),
                edited.asRenumberingResult()
        );
        div.refresh(copyToLocalDirectory(rosfed));
        return ResponseData.of(div).addMessage(DbeNotificationMessages.保存完了.getMessage().replace("連番の変更を")).respond();
    }

    /**
     * @param div {@link TokkiImagesPerChosaDiv}
     * @return response
     */
    public ResponseData<TokkiImagesPerChosaDiv> onClick_btnReturn(TokkiImagesPerChosaDiv div) {
        return ResponseData.of(div).respond();
    }
}
