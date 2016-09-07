/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.commonchilddiv.ImageDisplay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImagekanriJoho;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ImageDisplay.ImageDisplay.ImageDisplayDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ImageDisplay.ImageDisplay.ImageDisplayHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ImageDisplay.ImageDisplay.ImageDisplayValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteiimagesakujo.YokaigoninteiimagesakujoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 共有子Div 「ImageDisplay」のイベントを定義したDivControllerです。
 *
 * @reamsid_L DBE-3000-280 jinjue
 */
public class ImageDisplay {

    private static final RString イメージ区分_1 = new RString("1");
    private static final RString イメージ区分_2 = new RString("2");
    private static final RString イメージ区分_3 = new RString("3");
    private static RString imagePath = RString.EMPTY;
    private static final RString イメージファイルが存在区分_存在しない = new RString("1");
    private static final RString イメージパス = new RString("/db/dbe/image/");
    private static final RString ファイルまで = new RString("_BAK.png");

    /**
     * 画面初期化を表示します。
     *
     * @param div ImageDisplayDiv
     * @return ResponseData<ImageDisplayDiv>
     */
    public ResponseData<ImageDisplayDiv> onLoad(ImageDisplayDiv div) {
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
        HashMap<Integer, List<RString>> 初期化のイメージ = this.getFilePath(イメージ区分);
        ViewStateHolder.put(ViewStateKeys.イメージ情報_存在, 初期化のイメージ);
        if (!初期化のイメージ.isEmpty()) {
            RString 初期化のイメージ_1 = 初期化のイメージ.get(1).get(0);
            div.getImgGenbon().setSrc(初期化のイメージ_1);
            div.getImgMask().setSrc(初期化のイメージ.get(1).get(1));
            div.setHdnImageDisplay(イメージ区分_1);
            div.getBtnBefore().setDisabled(true);
            if (1 == 初期化のイメージ.size()) {
                div.getBtnAfterImg().setDisabled(true);
            }
        } else {
            div.getBtnBefore().setDisabled(true);
            div.getBtnAfterImg().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「次へボタン」の処理を実行します。
     *
     * @param div ImageDisplayDiv
     * @return ResponseData<ImageDisplayDiv>
     */
    public ResponseData<ImageDisplayDiv> onClick_btnAfterImg(ImageDisplayDiv div) {
        if (!RString.EMPTY.equals(div.getHdnImageDisplay())) {
            int index = Integer.parseInt(div.getHdnImageDisplay().toString());
            HashMap<Integer, List<RString>> 初期化のイメージ = ViewStateHolder.get(ViewStateKeys.イメージ情報_存在, HashMap.class);
            index = index + 1;
            if (index < 初期化のイメージ.size()) {
                div.getBtnBefore().setDisabled(false);
                div.setHdnImageDisplay(new RString(index));
                div.getImgGenbon().setSrc(初期化のイメージ.get(index).get(0));
                div.getImgMask().setSrc(初期化のイメージ.get(index).get(1));
            } else {
                div.getBtnAfterImg().setDisabled(true);
            }
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
            int index = Integer.parseInt(div.getHdnImageDisplay().toString());
            index = index - 1;
            HashMap<Integer, List<RString>> 初期化のイメージ = ViewStateHolder.get(ViewStateKeys.イメージ情報_存在, HashMap.class);
            if (index > 0) {
                div.getBtnAfterImg().setDisabled(false);
                div.setHdnImageDisplay(new RString(index));
                div.getImgGenbon().setSrc(初期化のイメージ.get(index).get(0));
                div.getImgMask().setSrc(初期化のイメージ.get(index).get(1));
            } else {
                div.getBtnBefore().setDisabled(true);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「戻るボタン」の処理を実行します。
     *
     * @param div ImageDisplayDiv
     * @return ResponseData<ImageDisplayDiv>
     */
    public ResponseData<ImageDisplayDiv> onClick_btnBack(ImageDisplayDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.確認_汎用.getMessage().getCode(),
                    UrQuestionMessages.確認_汎用.getMessage().replace("よろしいですか").evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.確認_汎用.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
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
        if (イメージ区分_1.equals(イメージ区分) && getHandler().is調査票概況のイメージファイルが存在しない(存在したイメージファイル名)) {
            getValidationHandler().調査票概況イメージファイル存在チェック();
            ValidationMessageControlPairs validPairs = getValidationHandler().調査票概況イメージファイル存在チェック();
            this.get_メッセージ(div, validPairs);
        } else if (イメージ区分_2.equals(イメージ区分) && イメージファイルが存在区分_存在しない.equals(getHandler().
                getその他資料のイメージファイルが存在区分(存在したイメージファイル名))) {
            ValidationMessageControlPairs validPairs = getValidationHandler().その他資料イメージファイル存在チェック();
            this.get_メッセージ(div, validPairs);
        } else if (イメージ区分_3.equals(イメージ区分) && イメージファイルが存在区分_存在しない.equals(getHandler().
                get主治医意見書のイメージファイルが存在区分(存在したイメージファイル名))) {
            ValidationMessageControlPairs validPairs = getValidationHandler().主治医意見書イメージファイル存在チェック();
            this.get_メッセージ(div, validPairs);
        }
    }

    private HashMap<Integer, List<RString>> getFilePath(RString イメージ区分) {
        imagePath = Path.combinePath(Path.getUserHomePath(), new RString("app/webapps/db#dbe/WEB-INF/image/"));
        List<RString> イメージ管理資料_2 = this.イメージ管理資料();
        List<RString> イメージ管理資料_3 = this.イメージ管理資料_3();
        HashMap<Integer, List<RString>> dataMap = new HashMap<>();
        int index = 1;
        ImagekanriJoho イメージ情報 = ViewStateHolder.get(ViewStateKeys.イメージ情報, ImagekanriJoho.class);
        if (イメージ区分_1.equals(イメージ区分)) {
            List<RString> イメージファイル = new ArrayList<>();
            RString ファイル = new RString("G0001.png");
            try {
                ReadOnlySharedFileEntryDescriptor descriptor_2
                        = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(ファイル),
                                イメージ情報.getイメージ共有ファイルID());
                SharedFile.copyToLocal(descriptor_2, new FilesystemPath(imagePath));
                イメージファイル.add(Path.combinePath(イメージパス, ファイル));
                イメージファイル.add(RString.EMPTY);
                dataMap.put(index, イメージファイル);
            } catch (Exception e) {
                if (イメージ区分_1.equals(イメージ区分_2)) {
                    return dataMap;
                }
            }
        } else if (イメージ区分_2.equals(イメージ区分)) {
            for (RString ファイル : イメージ管理資料_2) {
                List<RString> イメージファイル = new ArrayList<>();
                try {
                    ReadOnlySharedFileEntryDescriptor descriptor_2
                            = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(ファイル),
                                    イメージ情報.getイメージ共有ファイルID());
                    SharedFile.copyToLocal(descriptor_2, new FilesystemPath(imagePath.concat(ファイル)));
                    イメージファイル.add(Path.combinePath(イメージパス, ファイル));
                    if (ファイル.endsWith(ファイルまで.toString())) {
                        イメージファイル.add(Path.combinePath(イメージパス, ファイル.replace(ファイルまで.toString(), ".png")));
                    } else {
                        イメージファイル.add(RString.EMPTY);
                    }
                    dataMap.put(index, イメージファイル);
                    index = index + 1;
                } catch (Exception e) {
                    if (イメージ区分_1.equals(イメージ区分_2)) {
                        return dataMap;
                    }
                }
            }
        } else if (イメージ区分_3.equals(イメージ区分)) {
            for (RString ファイル : イメージ管理資料_3) {
                List<RString> イメージファイル = new ArrayList<>();
                try {
                    ReadOnlySharedFileEntryDescriptor descriptor_2
                            = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(ファイル),
                                    イメージ情報.getイメージ共有ファイルID());
                    SharedFile.copyToLocal(descriptor_2, new FilesystemPath(imagePath.concat(ファイル)));
                    イメージファイル.add(Path.combinePath(イメージパス, ファイル));
                    if (ファイル.endsWith(ファイルまで.toString())) {
                        イメージファイル.add(Path.combinePath(イメージパス, ファイル.replace(ファイルまで.toString(), ".png")));
                    } else {
                        イメージファイル.add(RString.EMPTY);
                    }
                    dataMap.put(index, イメージファイル);
                    index = index + 1;
                } catch (Exception e) {
                    if (イメージ区分_1.equals(イメージ区分_2)) {
                        return dataMap;
                    }
                }
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
        イメージ.add(new RString("E0001_BAK.png"));
        イメージ.add(new RString("E0002_BAK.png"));
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
