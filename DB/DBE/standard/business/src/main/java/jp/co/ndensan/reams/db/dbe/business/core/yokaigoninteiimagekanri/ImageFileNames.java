/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.yokaigoninteiimagekanri.ImageFilesPresentState;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ファイル名の一覧です。
 */
public final class ImageFileNames {

    private final List<RString> imageFileNames;

    ImageFileNames(Collection<? extends RString> imageFileNames) {
        this.imageFileNames = Collections.unmodifiableList(new ArrayList<>(imageFileNames));
    }

    /**
     * 調査票特記のイメージファイル存在チェックを実行します。
     *
     * @return {@link ImageFilesPresentState}
     */
    public ImageFilesPresentState confirmChosahyoImagesPresent() {
        boolean notExistsImageFile = !existsImageFileList(ImageFileItem.getGaikyoChosaImageFileList_ALL(), imageFileNames);
        if (notExistsImageFile) {
            notExistsImageFile = !existsImageFileList(ImageFileItem.getChosahyoTokkiImageFileList_ALL(), imageFileNames);
        }
        if (notExistsImageFile) {
            return ImageFilesPresentState.存在しない;
        }
        if (existsMaskImageFileList(ImageFileItem.getGaikyoChosaImageFileList_Mask(), imageFileNames)) {
            return ImageFilesPresentState.マスキング有;
        }
        if (existsMaskImageFileList(ImageFileItem.getChosahyoTokkiImageFileList_Mask(), imageFileNames)) {
            return ImageFilesPresentState.マスキング有;
        }
        return ImageFilesPresentState.マスキング無;
    }

    //<editor-fold defaultstate="collapsed" desc="common method in this class">
    private static boolean existsImageFileList(List<RString> searchingFileNames, List<RString> presentImageNames) {
        for (RString ファイル名 : searchingFileNames) {
            if (existsImageFile(ファイル名, presentImageNames)) {
                return true;
            }
        }
        return false;
    }

    private static boolean existsImageFile(RString searchingFileName, List<RString> presentImageNames) {
        for (RString existImageFile : presentImageNames) {
            if (existImageFile.contains(searchingFileName)) {
                return true;
            }
        }
        return false;
    }

    private static boolean existsMaskImageFileList(List<RString> searchingFileNames, List<RString> presentImageNames) {
        for (RString ファイル名 : searchingFileNames) {
            if (existsMaskImageFile(ファイル名, presentImageNames)) {
                return true;
            }
        }
        return false;
    }

    private static final RString イメージファイル原本名 = new RString("_BAK");

    private static boolean existsMaskImageFile(RString searchingFileNames, List<RString> presentImageNames) {
        for (RString existImageFile : presentImageNames) {
            if (existImageFile.contains(searchingFileNames.concat(イメージファイル原本名))) {
                return true;
            }
        }
        return false;
    }
    //</editor-fold>

    /**
     * 調査票概況のイメージファイル存在チェックを実行します。
     *
     * @return {@link ImageFilesPresentState}
     */
    public ImageFilesPresentState confirmGaikyoTokkiImagesPresent() {
        if (existsImageFileList(ImageFileItem.getGaikyoTokkiImageFileList_ALL(), imageFileNames)) {
            return ImageFilesPresentState.マスキング無;
        } else {
            return ImageFilesPresentState.存在しない;
        }
    }

    /**
     * 主治医意見書のイメージファイル存在チェックを実行します。
     *
     * @return {@link ImageFilesPresentState}
     */
    public ImageFilesPresentState confirmIkenshoImagesPresent() {
        boolean notExistsImageFile = !existsImageFileList(ImageFileItem.getOpinionTeikeigaiImageFileList_ALL(), imageFileNames);
        if (notExistsImageFile) {
            notExistsImageFile = !existsImageFileList(ImageFileItem.getOpinionTeikeiImageFileList_ALL(), imageFileNames);
        }
        if (notExistsImageFile) {
            return ImageFilesPresentState.存在しない;
        }
        if (existsMaskImageFileList(ImageFileItem.getOpinionImageFileList_Mask(), imageFileNames)) {
            return ImageFilesPresentState.マスキング有;
        }
        return ImageFilesPresentState.マスキング無;
    }

    /**
     * その他資料のイメージファイル存在チェックを実行します。
     *
     * @return {@link ImageFilesPresentState}
     */
    public ImageFilesPresentState confirmSonotaShiryoImagesPresent() {
        boolean notExistsImageFile = !existsImageFileList(ImageFileItem.getOtherFileImageFileList_ALL(), imageFileNames);
        if (notExistsImageFile) {
            return ImageFilesPresentState.存在しない;
        }
        if (existsMaskImageFileList(ImageFileItem.getOtherFileImageFileList_Mask(), imageFileNames)) {
            return ImageFilesPresentState.マスキング有;
        }
        return ImageFilesPresentState.マスキング無;
    }

    /**
     * @return リスト形式
     */
    public List<RString> asList() {
        return this.imageFileNames;
    }

    /**
     * @return イメージファイルが一件も存在しない場合、{@code true}.
     */
    public boolean isEmpty() {
        return this.imageFileNames.isEmpty();
    }
}
