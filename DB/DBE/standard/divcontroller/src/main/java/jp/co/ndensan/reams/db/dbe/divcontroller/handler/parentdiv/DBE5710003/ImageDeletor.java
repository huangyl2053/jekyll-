/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5710003;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.util.DBEImageUtil;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImageFileItem;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImagekanriJoho;
import jp.co.ndensan.reams.db.dbe.definition.core.yokaigoninteiimagekanri.OperationTarget;
import jp.co.ndensan.reams.db.dbe.definition.core.yokaigoninteiimagekanri.OperationTargets;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedAppendOption;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.File;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定イメージ情報削除のHandlerクラスです。
 *
 * @reamsid_L DBE-1670-012 dingyi
 */
public final class ImageDeletor {

    private static final RString イメージファイル原本名 = new RString("_BAK");
    private static final RString イメージファイル拡張子 = new RString(".png");

    private ImageDeletor() {
    }

    /**
     * @param imageKanriJoho
     * @param targets
     */
    public static void deleteImageFiles(ImagekanriJoho imageKanriJoho, OperationTargets targets) {
        ReadOnlySharedFileEntryDescriptor descriptor = imageKanriJoho.toReadOnlySharedFileEntryDescriptor();
        RString localCopyPath = DBEImageUtil.copySharedFiles(descriptor.getSharedFileId(), descriptor.getSharedFileName().toRString());
        List<RString> imageFileList = imageKanriJoho.collectImageNames().asList();
        for (OperationTarget t : targets) {
            switch (t.type()) {
                case 調査票:
                    deleteGaikyoChosaImageFile(descriptor, localCopyPath, imageFileList, t.deletionMethod().isMaskedOnly());
                    continue;
                case 概況特記:
                    deleteGaikyoTokkiImageFile(descriptor, imageFileList, t.deletionMethod().isMaskedOnly());
                    continue;
                case 意見書:
                    deleteOpinionImageFile(descriptor, localCopyPath, imageFileList, t.deletionMethod().isMaskedOnly());
                    continue;
                case その他資料:
                    deleteOtherImageFile(descriptor, localCopyPath, imageFileList, t.deletionMethod().isMaskedOnly());
                default:
            }
        }
    }

    private static void deleteGaikyoChosaImageFile(ReadOnlySharedFileEntryDescriptor descriptor, RString localCopyPath,
            List<RString> deleteImageFileList, boolean isMaskOnly) {
        if (isMaskOnly) {
            List<RString> gaikyoChosaMaskImageFileList = ImageFileItem.getGaikyoChosaImageFileList_Mask();
            deleteMaskSharedFileInEntry(descriptor, localCopyPath, gaikyoChosaMaskImageFileList, deleteImageFileList);

            List<RString> tokkiJikoMaskImageList = ImageFileItem.getChosahyoTokkiImageFileList_Mask();
            deleteMaskSharedFileInEntry(descriptor, localCopyPath, tokkiJikoMaskImageList, deleteImageFileList);
        } else {
            List<RString> gaikyoChosaImageList = ImageFileItem.getGaikyoChosaImageFileList_ALL();
            deleteAllSharedFileInEntry(descriptor, gaikyoChosaImageList, deleteImageFileList);

            List<RString> tokkiJikoImageList = ImageFileItem.getChosahyoTokkiImageFileList_ALL();
            deleteAllSharedFileInEntry(descriptor, tokkiJikoImageList, deleteImageFileList);
        }
    }

    private static void deleteGaikyoTokkiImageFile(ReadOnlySharedFileEntryDescriptor descriptor, List<RString> deleteImageFileList,
            boolean isMaskOnly) {
        if (!isMaskOnly) {
            List<RString> gaikyoTokkiImageList = ImageFileItem.getGaikyoTokkiImageFileList_ALL();
            deleteAllSharedFileInEntry(descriptor, gaikyoTokkiImageList, deleteImageFileList);
        }
    }

    private static void deleteOpinionImageFile(ReadOnlySharedFileEntryDescriptor descriptor, RString localCopyPath,
            List<RString> deleteImageFileList, boolean isMaskOnly) {
        if (isMaskOnly) {
            List<RString> opinionMaskImageFileList = ImageFileItem.getOpinionImageFileList_Mask();
            deleteMaskSharedFileInEntry(descriptor, localCopyPath, opinionMaskImageFileList, deleteImageFileList);
        } else {
            List<RString> teikeigaiOpinionImageFileList = ImageFileItem.getOpinionTeikeigaiImageFileList_ALL();
            deleteAllSharedFileInEntry(descriptor, teikeigaiOpinionImageFileList, deleteImageFileList);

            List<RString> teikeiOpinionImageFileList = ImageFileItem.getOpinionTeikeiImageFileList_ALL();
            deleteAllSharedFileInEntry(descriptor, teikeiOpinionImageFileList, deleteImageFileList);
        }
    }

    private static void deleteOtherImageFile(ReadOnlySharedFileEntryDescriptor descriptor, RString localCopyPath,
            List<RString> deleteImageFileList, boolean isMaskOnly) {
        if (isMaskOnly) {
            List<RString> otherMaskImageFileList = ImageFileItem.getOtherFileImageFileList_Mask();
            deleteMaskSharedFileInEntry(descriptor, localCopyPath, otherMaskImageFileList, deleteImageFileList);
        } else {
            List<RString> otherImageFileList = ImageFileItem.getOtherFileImageFileList_ALL();
            deleteAllSharedFileInEntry(descriptor, otherImageFileList, deleteImageFileList);
        }
    }

    private static void deleteAllSharedFileInEntry(ReadOnlySharedFileEntryDescriptor descriptor, List<RString> deleteTargetImageFileList,
            List<RString> deleteImageFileList) {
        for (RString deleteTargetImageFile : deleteTargetImageFileList) {
            if (isExistsImageFile(deleteTargetImageFile, deleteImageFileList)) {
                SharedFile.deleteFileInEntry(descriptor, deleteTargetImageFile.concat(イメージファイル拡張子).toString());
            }
        }
    }

    private static void deleteMaskSharedFileInEntry(ReadOnlySharedFileEntryDescriptor descriptor, RString localCopyPath,
            List<RString> deleteTargetImageFileList, List<RString> deleteImageFileList) {
        for (RString deleteTargetImageFile : deleteTargetImageFileList) {
            if (isExistsMaskImageFile(deleteTargetImageFile, deleteImageFileList)) {
                appendNewImageFile(descriptor, localCopyPath,
                        deleteTargetImageFile.concat(イメージファイル原本名).concat(イメージファイル拡張子));
                SharedFile.deleteFileInEntry(descriptor,
                        deleteTargetImageFile.concat(イメージファイル原本名).concat(イメージファイル拡張子).toString());
            }
        }
    }

    private static void appendNewImageFile(ReadOnlySharedFileEntryDescriptor descriptor, RString localCopyPath, RString targetImageFile) {
        if (Directory.exists(Path.combinePath(localCopyPath, targetImageFile))) {
            boolean options = true;
            RString afterReNameImageFile = reName(targetImageFile);
            File.move(Path.combinePath(localCopyPath, targetImageFile), Path.combinePath(localCopyPath, afterReNameImageFile), options);
            SharedAppendOption option = new SharedAppendOption();
            option.overWrite(true);
            SharedFile.appendNewFile(descriptor, new FilesystemPath(Path.combinePath(localCopyPath, afterReNameImageFile)),
                    "", option);
        }
    }

    private static RString reName(RString targetName) {
        RString reNameTargetName = targetName.replace("_BAK", "");
        return reNameTargetName;
    }

    private static boolean isExistsImageFile(RString ファイル名, List<RString> 存在したイメージファイル名) {
        for (RString existImageFile : 存在したイメージファイル名) {
            if (existImageFile.contains(ファイル名)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isExistsMaskImageFile(RString ファイル名, List<RString> 存在したイメージファイル名) {
        for (RString existImageFile : 存在したイメージファイル名) {
            if (existImageFile.contains(ファイル名.concat(イメージファイル原本名))) {
                return true;
            }
        }
        return false;
    }
}
