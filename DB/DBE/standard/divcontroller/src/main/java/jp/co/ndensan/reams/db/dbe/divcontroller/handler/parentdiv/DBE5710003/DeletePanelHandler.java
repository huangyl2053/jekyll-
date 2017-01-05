/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5710003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImageFileItem;
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
public class DeletePanelHandler {

    private static final RString 確認メッセージ出力要 = new RString("1");
    private static final RString イメージファイルが存在区分_存在しない = new RString("1");
    private static final RString イメージファイルが存在区分_マスキング有 = new RString("2");
    private static final RString イメージファイル原本名 = new RString("_BAK");
    private static final RString イメージファイル拡張子 = new RString(".png");
    private static final RString SLASH = new RString("\\");

    /**
     * コンストラクタです。
     *
     */
    public DeletePanelHandler() {
    }

    /**
     * 「削除」ボタンを押下する場合、調査票特記のイメージファイル存在チェックを実行します。
     *
     * @param 存在したイメージファイル名 存在したイメージファイル名
     * @param 確認メッセージ出力区分 確認メッセージ出力区分
     * @return イメージファイルが存在区分
     */
    public RString get調査票特記のイメージファイルが存在区分(List<RString> 存在したイメージファイル名, RString 確認メッセージ出力区分) {
        boolean isNotExistsImageFile = !isExistsImageFileList(ImageFileItem.getGaikyoChosaImageFileList_ALL(), 存在したイメージファイル名);
        if (isNotExistsImageFile) {
            isNotExistsImageFile = !isExistsImageFileList(ImageFileItem.getChosahyoTokkiImageFileList_ALL(), 存在したイメージファイル名);
        }
        if (isNotExistsImageFile) {
            return イメージファイルが存在区分_存在しない;
        }
        if (確認メッセージ出力要.equals(確認メッセージ出力区分)) {
            return イメージファイルが存在区分_マスキング有;
        }
        if (isExistsMaskImageFileList(ImageFileItem.getGaikyoChosaImageFileList_Mask(), 存在したイメージファイル名)) {
            return イメージファイルが存在区分_マスキング有;
        }
        if (isExistsMaskImageFileList(ImageFileItem.getChosahyoTokkiImageFileList_Mask(), 存在したイメージファイル名)) {
            return イメージファイルが存在区分_マスキング有;
        }
        return RString.EMPTY;
    }

    /**
     * 「削除」ボタンを押下する場合、調査票概況のイメージファイル存在チェックを実行します。
     *
     * @param 存在したイメージファイル名 存在したイメージファイル名
     * @return 調査票概況のイメージファイルが存在しない：true、存在する：false
     */
    public boolean is調査票概況のイメージファイルが存在しない(List<RString> 存在したイメージファイル名) {
        return !isExistsImageFileList(ImageFileItem.getGaikyoTokkiImageFileList_ALL(), 存在したイメージファイル名);
    }

    /**
     * 「削除」ボタンを押下する場合、主治医意見書のイメージファイル存在チェックを実行します。
     *
     * @param 存在したイメージファイル名 存在したイメージファイル名
     * @param 確認メッセージ出力区分 確認メッセージ出力区分
     * @return イメージファイルが存在区分
     */
    public RString get主治医意見書のイメージファイルが存在区分(List<RString> 存在したイメージファイル名,
            RString 確認メッセージ出力区分) {
        boolean isNotExistsImageFile = !isExistsImageFileList(ImageFileItem.getOpinionTeikeigaiImageFileList_ALL(), 存在したイメージファイル名);
        if (isNotExistsImageFile) {
            isNotExistsImageFile = !isExistsImageFileList(ImageFileItem.getOpinionTeikeiImageFileList_ALL(), 存在したイメージファイル名);
        }
        if (isNotExistsImageFile) {
            return イメージファイルが存在区分_存在しない;
        }
        if (確認メッセージ出力要.equals(確認メッセージ出力区分)) {
            return イメージファイルが存在区分_マスキング有;
        }
        if (isExistsMaskImageFileList(ImageFileItem.getOpinionImageFileList_Mask(), 存在したイメージファイル名)) {
            return イメージファイルが存在区分_マスキング有;
        }
        return RString.EMPTY;
    }

    /**
     * 「削除」ボタンを押下する場合、その他資料のイメージファイル存在チェックを実行します。
     *
     * @param 存在したイメージファイル名 存在したイメージファイル名
     * @param 確認メッセージ出力区分 確認メッセージ出力区分
     * @return イメージファイルが存在区分
     */
    public RString getその他資料のイメージファイルが存在区分(List<RString> 存在したイメージファイル名,
            RString 確認メッセージ出力区分) {
        boolean isNotExistsImageFile = !isExistsImageFileList(ImageFileItem.getOtherFileImageFileList_ALL(), 存在したイメージファイル名);
        if (isNotExistsImageFile) {
            return イメージファイルが存在区分_存在しない;
        }
        if (確認メッセージ出力要.equals(確認メッセージ出力区分)) {
            return イメージファイルが存在区分_マスキング有;
        }
        if (isExistsMaskImageFileList(ImageFileItem.getOtherFileImageFileList_Mask(), 存在したイメージファイル名)) {
            return イメージファイルが存在区分_マスキング有;
        }
        return RString.EMPTY;
    }

    public void deleteGaikyoChosaImageFile(ReadOnlySharedFileEntryDescriptor descriptor, RString localCopyPath,
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

    public void deleteGaikyoTokkiImageFile(ReadOnlySharedFileEntryDescriptor descriptor, List<RString> deleteImageFileList,
            boolean isMaskOnly) {
        if (!isMaskOnly) {
            List<RString> gaikyoTokkiImageList = ImageFileItem.getGaikyoTokkiImageFileList_ALL();
            deleteAllSharedFileInEntry(descriptor, gaikyoTokkiImageList, deleteImageFileList);
        }
    }

    public void deleteOpinionImageFile(ReadOnlySharedFileEntryDescriptor descriptor, RString localCopyPath,
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

    public void deleteOtherImageFile(ReadOnlySharedFileEntryDescriptor descriptor, RString localCopyPath,
            List<RString> deleteImageFileList, boolean isMaskOnly) {
        if (isMaskOnly) {
            List<RString> otherMaskImageFileList = ImageFileItem.getOtherFileImageFileList_Mask();
            deleteMaskSharedFileInEntry(descriptor, localCopyPath, otherMaskImageFileList, deleteImageFileList);
        } else {
            List<RString> otherImageFileList = ImageFileItem.getOtherFileImageFileList_ALL();
            deleteAllSharedFileInEntry(descriptor, otherImageFileList, deleteImageFileList);
        }
    }

    private void deleteAllSharedFileInEntry(ReadOnlySharedFileEntryDescriptor descriptor, List<RString> deleteTargetImageFileList,
            List<RString> deleteImageFileList) {
        for (RString deleteTargetImageFile : deleteTargetImageFileList) {
            if (isExistsImageFile(deleteTargetImageFile, deleteImageFileList)) {
                SharedFile.deleteFileInEntry(descriptor, SLASH.concat(deleteTargetImageFile.concat(イメージファイル拡張子)).toString());
            }
        }
    }

    private void deleteMaskSharedFileInEntry(ReadOnlySharedFileEntryDescriptor descriptor, RString localCopyPath,
            List<RString> deleteTargetImageFileList, List<RString> deleteImageFileList) {
        for (RString deleteTargetImageFile : deleteTargetImageFileList) {
            if (isExistsMaskImageFile(deleteTargetImageFile, deleteImageFileList)) {
                appendNewImageFile(descriptor, localCopyPath,
                        SLASH.concat(deleteTargetImageFile.concat(イメージファイル原本名).concat(イメージファイル拡張子)));
                SharedFile.deleteFileInEntry(descriptor,
                        SLASH.concat(deleteTargetImageFile.concat(イメージファイル原本名).concat(イメージファイル拡張子)).toString());
            }
        }
    }

    private void appendNewImageFile(ReadOnlySharedFileEntryDescriptor descriptor, RString localCopyPath, RString targetImageFile) {
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

    private RString reName(RString targetName) {
        RString reNameTargetName = targetName.replace("_BAK", "");
        return reNameTargetName;
    }

    private boolean isExistsImageFileList(List<RString> ファイル名リスト, List<RString> 存在したイメージファイル名) {
        for (RString ファイル名 : ファイル名リスト) {
            if (isExistsImageFile(ファイル名, 存在したイメージファイル名)) {
                return true;
            }
        }
        return false;
    }

    private boolean isExistsImageFile(RString ファイル名, List<RString> 存在したイメージファイル名) {
        for (RString existImageFile : 存在したイメージファイル名) {
            if (existImageFile.contains(ファイル名)) {
                return true;
            }
        }
        return false;
    }

    private boolean isExistsMaskImageFileList(List<RString> ファイル名リスト, List<RString> 存在したイメージファイル名) {
        for (RString ファイル名 : ファイル名リスト) {
            if (isExistsMaskImageFile(ファイル名, 存在したイメージファイル名)) {
                return true;
            }
        }
        return false;
    }

    private boolean isExistsMaskImageFile(RString ファイル名, List<RString> 存在したイメージファイル名) {
        for (RString existImageFile : 存在したイメージファイル名) {
            if (existImageFile.contains(ファイル名.concat(イメージファイル原本名))) {
                return true;
            }
        }
        return false;
    }
}
