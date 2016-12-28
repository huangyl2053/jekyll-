/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.commonchilddiv.ImageDisplay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.util.DBEImageUtil;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImagekanriJoho;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ImageDisplay.ImageDisplay.ImageDisplayDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ImageDisplay.ImageDisplay.ImageDisplayHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ImageDisplay.ImageDisplay.ImageDisplayValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteiimagesakujo.YokaigoninteiimagesakujoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 共有子Div 「ImageDisplay」のイベントを定義したDivControllerです。
 *
 * @reamsid_L DBE-3000-280 jinjue
 */
public class ImageDisplay {

    private static final RString IMAGE_GAIKYOTOKKI = new RString("1");
    private static final RString IMAGE_TEIKEIOPINIONFILE = new RString("2");
    private static final RString IMAGE_OTHERFILE = new RString("3");
    private static final RString IMAGE_TEIKEIGAIOPINIONFILE = new RString("4");
    private static final RString イメージファイルが存在区分_存在しない = new RString("1");
    private static final RString ファイルまで = new RString("_BAK.png");
    private static final RString 意見書イメージ幅 = new RString(504);

    /**
     * 画面初期化を表示します。
     *
     * @param div ImageDisplayDiv
     * @return ResponseData<ImageDisplayDiv>
     */
    public ResponseData<ImageDisplayDiv> onLoad(ImageDisplayDiv div) {
        List<RString> originalImagePathList;
        List<RString> maskImagePathList;
        List<RString> originalImageBinaryList;
        List<RString> maskImageBinaryList;
        List<RString> originalTitleList;
        List<RString> maskTitleList;
        ImagekanriJoho イメージ情報 = ViewStateHolder.get(ViewStateKeys.イメージ情報, ImagekanriJoho.class);

        if (イメージ情報.getイメージ共有ファイルID() == null) {
            ValidationMessageControlPairs validPairs = getValidationHandler().イメージ存在チェック();
            this.get_メッセージ(div, validPairs);
        }

        RString イメージ区分 = ViewStateHolder.get(ViewStateKeys.イメージ区分, RString.class);
        ReadOnlySharedFileEntryDescriptor descriptor = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(
                イメージ情報.get証記載保険者番号().concat(イメージ情報.get被保険者番号())),
                イメージ情報.getイメージ共有ファイルID());

        List<RString> 存在したイメージファイル名 = YokaigoninteiimagesakujoManager.createInstance().get存在したイメージファイル名(descriptor);
        this.チェック(イメージ区分, div, 存在したイメージファイル名);

        RString toCopyPath = div.getHdnImageLocalCopyPath();
        if (IMAGE_TEIKEIOPINIONFILE.equals(イメージ区分)) {
            div.getCcdChosaTokkiShiryoShokai().setDisplayNone(true);
            HashMap<Integer, List<RString>> 初期化のイメージ = this.getFilePathMap(toCopyPath);
            ViewStateHolder.put(ViewStateKeys.イメージ情報_存在, 初期化のイメージ);
            List<RString> imageList = 初期化のイメージ.isEmpty() ? Collections.EMPTY_LIST : 初期化のイメージ.get(1);
            setOCROpinionFileController(div, 初期化のイメージ.size(), 1, imageList);
        } else {
            setOCROpinionFileController(div, 0, 0, Collections.EMPTY_LIST);
            originalImagePathList = getOriginalFilePathList(イメージ区分, toCopyPath);
            maskImagePathList = getMaskFilePathList(イメージ区分, toCopyPath, originalImagePathList);

            originalImageBinaryList = createImageBinaryList(originalImagePathList);
            maskImageBinaryList = createImageBinaryList(maskImagePathList);
            originalTitleList = getTitleList(originalImagePathList);
            maskTitleList = getTitleList(maskImagePathList);

            if (originalImageBinaryList != null && !RString.isNullOrEmpty(originalImageBinaryList.get(0))) {
                div.getCcdChosaTokkiShiryoShokai().setDisplayNone(false);
                div.getCcdChosaTokkiShiryoShokai().initialize(originalImageBinaryList, maskImageBinaryList, originalTitleList, maskTitleList);
            } else {
                div.getCcdChosaTokkiShiryoShokai().setDisplayNone(true);
                div.getLblNoImage().setDisplayNone(false);
            }
        }
        div.getBtnBack().setDisplayNone(false);
        return ResponseData.of(div).respond();
    }

    private void setOCROpinionFileController(
            ImageDisplayDiv div, int totalpage, int nowPage,
            List<RString> img) {
        setOCROpinionImage(div, img);
        boolean isNotDispPageChangeButton = totalpage <= 1;
        div.getBtnBefore().setDisplayNone(isNotDispPageChangeButton);
        div.getBtnAfterImg().setDisplayNone(isNotDispPageChangeButton);
        if (nowPage != 0) {
            div.getLblNoImage().setDisplayNone(!div.getImgMask().isDisplayNone());
        }
        if (isNotDispPageChangeButton) {
            return;
        }
        div.getBtnBefore().setDisabled(nowPage == 1);
        div.getBtnAfterImg().setDisabled(nowPage == totalpage);
        div.setHdnImageDisplay(new RString(nowPage));
    }

    private void setOCROpinionImage(ImageDisplayDiv div, List<RString> img) {
        if (img.isEmpty()) {
            div.getLblGenbon().setDisplayNone(true);
            div.getLblMask().setDisplayNone(true);
            div.getImgGenbon().setDisplayNone(true);
            div.getImgMask().setDisplayNone(true);
        } else {
            div.getImgGenbon().setSrc(img.get(0));
            div.getImgGenbon().setWidth(意見書イメージ幅);
            boolean isEmptyImgMask = true;
            if (img.size() > 1 && !RString.isNullOrEmpty(img.get(1))) {
                div.getImgMask().setSrc(img.get(1));
                div.getImgMask().setWidth(意見書イメージ幅);
                isEmptyImgMask = false;
            }
            div.getLblGenbon().setDisplayNone(false);
            div.getLblMask().setDisplayNone(false);
            div.getImgGenbon().setDisplayNone(false);
            div.getImgMask().setDisplayNone(isEmptyImgMask);
        }
    }

    private List<RString> createImageBinaryList(List<RString> imagePathList) {
        List<RString> imageBinaryList = new ArrayList<>();
        for (RString imagePath : imagePathList) {
            imageBinaryList.add(DBEImageUtil.sanitizePath(imagePath));
        }
        return imageBinaryList;
    }

    private List<RString> getTitleList(List<RString> 表示イメージ) {
        List<RString> titleList = new ArrayList<>();
        for (int index = 1; index <= 表示イメージ.size(); index++) {
            titleList.add(new RString(index).concat("枚目"));
        }
        return titleList;
    }

    private List<RString> getOriginalFilePathList(RString imageKubun, RString toCopyPath) {
        List<RString> imageFilePathList = new ArrayList<>();
        RString imageFilePath = RString.EMPTY;

        if (IMAGE_GAIKYOTOKKI.equals(imageKubun)) {
            RString imageFile = new RString("G0001.png");
            imageFilePathList.add(getFilePath(toCopyPath, imageFile));
        } else if (IMAGE_TEIKEIGAIOPINIONFILE.equals(imageKubun)) {
            RString imageFile1 = new RString("E0001.png");
            RString imageFile1_BAK = new RString("E0001_BAK.png");
            RString imageFile2 = new RString("E0002.png");
            RString imageFile2_BAK = new RString("E0002_BAK.png");

            imageFilePath = getFilePath(toCopyPath, imageFile1_BAK);
            if (RString.isNullOrEmpty(imageFilePath)) {
                imageFilePath = getFilePath(toCopyPath, imageFile1);
            }
            imageFilePathList.add(imageFilePath);

            imageFilePath = getFilePath(toCopyPath, imageFile2_BAK);
            if (RString.isNullOrEmpty(imageFilePath)) {
                imageFilePath = getFilePath(toCopyPath, imageFile2);
            }
            imageFilePathList.add(imageFilePath);
        } else if (IMAGE_OTHERFILE.equals(imageKubun)) {
            List<RString> imageFileList = getOtherFileList();
            for (int index = 1; index < 7; index++) {
                for (RString imageFile : imageFileList) {
                    if (imageFilePath.isEmpty()) {
                        imageFilePath = getFilePath(toCopyPath, replaceShareFileName(imageFile, index, true));
                        if (imageFilePath.isEmpty()) {
                            imageFilePath = getFilePath(toCopyPath, replaceShareFileName(imageFile, index, false));
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                imageFilePathList.add(imageFilePath);
                imageFilePath = RString.EMPTY;
            }
        }
        return imageFilePathList;
    }

    private List<RString> getOtherFileList() {
        List<RString> imageFileList = new ArrayList<>();
        imageFileList.add(new RString("F1401Axx.png"));
        imageFileList.add(new RString("F1401Bxx.png"));
        imageFileList.add(new RString("F1401Cxx.png"));
        imageFileList.add(new RString("F1401Dxx.png"));
        imageFileList.add(new RString("F1401Exx.png"));
        imageFileList.add(new RString("F1401Fxx.png"));
        return imageFileList;
    }

    private List<RString> getMaskFilePathList(RString imageKubun, RString toCopyPath, List<RString> originalImagePathList) {
        List<RString> imageFilePathList = new ArrayList<>();
        RString imageFilePath = RString.EMPTY;

        if (IMAGE_GAIKYOTOKKI.equals(imageKubun)) {
            imageFilePathList.add(RString.EMPTY);
        } else if (IMAGE_TEIKEIGAIOPINIONFILE.equals(imageKubun)) {
            RString imageFile1 = new RString("E0001.png");
            RString imageFile1_BAK = new RString("E0001_BAK.png");
            RString imageFile2 = new RString("E0002.png");
            RString imageFile2_BAK = new RString("E0002_BAK.png");
            if (Directory.exists(Path.combinePath(toCopyPath, imageFile1_BAK))) {
                imageFilePath = getFilePath(toCopyPath, imageFile1);
            }
            imageFilePathList.add(imageFilePath);

            imageFilePath = RString.EMPTY;
            if (Directory.exists(Path.combinePath(toCopyPath, imageFile2_BAK))) {
                imageFilePath = getFilePath(toCopyPath, imageFile2);
            }
            imageFilePathList.add(imageFilePath);

        } else if (IMAGE_OTHERFILE.equals(imageKubun)) {
            for (RString imageFile : originalImagePathList) {
                if (imageFile.contains(ファイルまで)) {
                    imageFilePathList.add(imageFile.replace(ファイルまで, new RString(".png")));
                } else {
                    imageFilePathList.add(RString.EMPTY);
                }
            }
        }
        return imageFilePathList;
    }

    private RString getFilePath(RString 出力イメージフォルダパス, RString ファイル名) {
        if (Directory.exists(Path.combinePath(出力イメージフォルダパス, ファイル名))) {
            return Path.combinePath(出力イメージフォルダパス, ファイル名);
        }
        return RString.EMPTY;
    }

    private RString replaceShareFileName(RString baseFileName, Integer remban, boolean isExistマスク) {
        RString fileName = baseFileName.replace("xx", new RString(remban.toString()).padZeroToLeft(2).toString());
        if (isExistマスク) {
            return fileName.replace(".png", "_BAK.png");
        }
        return fileName;
    }

    /**
     * 「次へボタン」の処理を実行します。
     *
     * @param div ImageDisplayDiv
     * @return ResponseData<ImageDisplayDiv>
     */
    public ResponseData<ImageDisplayDiv> onClick_btnAfterImg(ImageDisplayDiv div) {
        if (!RString.EMPTY.equals(div.getHdnImageDisplay())) {
            changePage(div, true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「前へボタン」の処理を実行します。
     *
     * @param div ImageDisplayDiv
     * @return ResponseData<ImageDisplayDiv>
     */
    public ResponseData<ImageDisplayDiv> onClick_btnBefore(ImageDisplayDiv div) {
        if (!RString.EMPTY.equals(div.getHdnImageDisplay())) {
            changePage(div, false);
        }
        return ResponseData.of(div).respond();
    }

    private void changePage(ImageDisplayDiv div, boolean isNext) {
        int index = Integer.parseInt(div.getHdnImageDisplay().toString());
        if (isNext) {
            index++;
        } else {
            index--;
        }
        HashMap<Integer, List<RString>> 初期化のイメージ = ViewStateHolder.get(ViewStateKeys.イメージ情報_存在, HashMap.class);
        setOCROpinionFileController(div, 初期化のイメージ.size(), index, 初期化のイメージ.get(index));
    }

    /**
     * 「戻るボタン」の処理を実行します。
     *
     * @param div ImageDisplayDiv
     * @return ResponseData<ImageDisplayDiv>
     */
    public ResponseData<ImageDisplayDiv> onClick_btnBack(ImageDisplayDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.確認_汎用.getMessage().replace("親画面へ戻ります。")).respond();
        }
        if (new RString(UrQuestionMessages.確認_汎用.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).dialogOKClose();
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<ImageDisplayDiv> get_メッセージ(ImageDisplayDiv div, ValidationMessageControlPairs validPairs) {
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    private void チェック(RString イメージ区分, ImageDisplayDiv div, List<RString> 存在したイメージファイル名) {
        if (IMAGE_GAIKYOTOKKI.equals(イメージ区分) && getHandler().is調査票概況のイメージファイルが存在しない(存在したイメージファイル名)) {
            getValidationHandler().調査票概況イメージファイル存在チェック();
            ValidationMessageControlPairs validPairs = getValidationHandler().調査票概況イメージファイル存在チェック();
            this.get_メッセージ(div, validPairs);
        } else if ((IMAGE_TEIKEIOPINIONFILE.equals(イメージ区分) || IMAGE_TEIKEIGAIOPINIONFILE.equals(イメージ区分))
                && イメージファイルが存在区分_存在しない.equals(getHandler().
                        get主治医意見書のイメージファイルが存在区分(存在したイメージファイル名))) {
            ValidationMessageControlPairs validPairs = getValidationHandler().主治医意見書イメージファイル存在チェック();
            this.get_メッセージ(div, validPairs);
        } else if (IMAGE_OTHERFILE.equals(イメージ区分) && イメージファイルが存在区分_存在しない.equals(getHandler().
                getその他資料のイメージファイルが存在区分(存在したイメージファイル名))) {
            ValidationMessageControlPairs validPairs = getValidationHandler().その他資料イメージファイル存在チェック();
            this.get_メッセージ(div, validPairs);
        }
    }

    private HashMap<Integer, List<RString>> getFilePathMap(RString toCopyPath) {
        List<RString> imageOpinionFileList = this.イメージ管理資料();
        HashMap<Integer, List<RString>> dataMap = new HashMap<>();
        int index = 1;
        for (RString imageFile : imageOpinionFileList) {
            List<RString> imageFileList = new ArrayList<>();
            boolean is画像あり = false;
            if (Directory.exists(Path.combinePath(toCopyPath, imageFile))) {
                imageFileList.add(Path.combinePath(toCopyPath, imageFile));
                is画像あり = true;
            }
            if (imageFile.endsWith(ファイルまで.toString()) && !imageFileList.isEmpty()) {
                imageFileList.add(Path.combinePath(toCopyPath, imageFile.replace(ファイルまで.toString(), ".png")));
                is画像あり = true;
            } else {
                imageFileList.add(RString.EMPTY);
            }
            if (is画像あり) {
                dataMap.put(index, createImageBinaryList(imageFileList));
                index = index + 1;
            }
        }
        return dataMap;
    }

    private List<RString> イメージ管理資料() {
        List<RString> イメージ = new ArrayList<>();
        イメージ.add(new RString("D1001.png"));
        イメージ.add(new RString("D1002.png"));
        イメージ.add(new RString("D1003.png"));
        イメージ.add(new RString("D1004.png"));
        イメージ.add(new RString("D1005_BAK.png"));
        イメージ.add(new RString("D1006.png"));
        イメージ.add(new RString("D1007.png"));
        イメージ.add(new RString("D1008_BAK.png"));
        イメージ.add(new RString("D1009.png"));
        イメージ.add(new RString("D1010.png"));
        イメージ.add(new RString("D1011.png"));
        イメージ.add(new RString("D1012.png"));
        イメージ.add(new RString("D1013.png"));
        イメージ.add(new RString("D1014.png"));
        イメージ.add(new RString("D1015.png"));
        イメージ.add(new RString("D1017.png"));
        イメージ.add(new RString("D1018.png"));
        イメージ.add(new RString("D1019.png"));
        イメージ.add(new RString("D1020.png"));
        イメージ.add(new RString("D1021.png"));
        イメージ.add(new RString("D1022.png"));
        イメージ.add(new RString("D1023.png"));
        イメージ.add(new RString("D1024.png"));
        イメージ.add(new RString("D1025.png"));
        イメージ.add(new RString("D1026_BAK.png"));
        イメージ.add(new RString("D1027_BAK.png"));
        イメージ.add(new RString("D1028.png"));
        イメージ.add(new RString("D1029.png"));
        イメージ.add(new RString("D1030.png"));
        イメージ.add(new RString("D1031.png"));
        return イメージ;
    }

    private List<RString> イメージ管理資料_3() {
        List<RString> イメージ = new ArrayList<>();
        イメージ.add(new RString("F1401A01_BAK.png"));
        イメージ.add(new RString("F1401B01_BAK.png"));
        イメージ.add(new RString("F1401C01_BAK.png"));
        イメージ.add(new RString("F1401D01_BAK.png"));
        イメージ.add(new RString("F1401E01_BAK.png"));
        イメージ.add(new RString("F1401F01_BAK.png"));
        イメージ.add(new RString("F1401A02_BAK.png"));
        イメージ.add(new RString("F1401B02_BAK.png"));
        イメージ.add(new RString("F1401C02_BAK.png"));
        イメージ.add(new RString("F1401D02_BAK.png"));
        イメージ.add(new RString("F1401E02_BAK.png"));
        イメージ.add(new RString("F1401F02_BAK.png"));
        イメージ.add(new RString("F1401A03_BAK.png"));
        イメージ.add(new RString("F1401B03_BAK.png"));
        イメージ.add(new RString("F1401C03_BAK.png"));
        イメージ.add(new RString("F1401D03_BAK.png"));
        イメージ.add(new RString("F1401E03_BAK.png"));
        イメージ.add(new RString("F1401F03_BAK.png"));
        イメージ.add(new RString("F1401A04_BAK.png"));
        イメージ.add(new RString("F1401B04_BAK.png"));
        イメージ.add(new RString("F1401C04_BAK.png"));
        イメージ.add(new RString("F1401D04_BAK.png"));
        イメージ.add(new RString("F1401E04_BAK.png"));
        イメージ.add(new RString("F1401F04_BAK.png"));
        イメージ.add(new RString("F1401A05_BAK.png"));
        イメージ.add(new RString("F1401B05_BAK.png"));
        イメージ.add(new RString("F1401C05_BAK.png"));
        イメージ.add(new RString("F1401D05_BAK.png"));
        イメージ.add(new RString("F1401E05_BAK.png"));
        イメージ.add(new RString("F1401F05_BAK.png"));
        イメージ.add(new RString("F1401A06_BAK.png"));
        イメージ.add(new RString("F1401B06_BAK.png"));
        イメージ.add(new RString("F1401C06_BAK.png"));
        イメージ.add(new RString("F1401D06_BAK.png"));
        イメージ.add(new RString("F1401E06_BAK.png"));
        イメージ.add(new RString("F1401F06_BAK.png"));
        return イメージ;
    }

    private ImageDisplayHandler getHandler() {
        return new ImageDisplayHandler();
    }

    private ImageDisplayValidationHandler getValidationHandler() {
        return new ImageDisplayValidationHandler();
    }
}
