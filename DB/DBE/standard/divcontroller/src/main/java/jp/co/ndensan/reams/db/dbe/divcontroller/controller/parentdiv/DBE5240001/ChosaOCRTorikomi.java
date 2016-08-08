/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5240001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosaocrtorikomi.ChosaOCRTorikomiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaikaisaikekkajoho.ShinsakaiKaisaiKekkaJoho2;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosaocrtorikomi.ChosaOCRTorikomiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5240001.ChosaOCRTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5240001.TorikomiData;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5240001.TorikomiDataCollection;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5240001.dgChosahyoTorikomiKekka_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5240001.ChosaOCRTorikomiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5240001.ChosaOCRTorikomiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.chosaocrtorikomi.ChosaOCRTorikomiFinder;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaikaisaikekkajoho.ShinsakaiKaisaiKekkaJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.Image;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ImageManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 介護認定審査会審査結果登録（OCR)のクラスです。
 *
 * @reamsid_L DBE-1560-010 suguangjun
 */
public class ChosaOCRTorikomi {

    private static final RString ファイル名 = new RString("OCRSHINSA.CSV");
    private static final int CSV項目数 = 38;
    private static final RString チェックOK = new RString("OK");
    private static final RString チェックNG = new RString("NG");
    private static final RString 記入無し = new RString("0");
    private RString 審査会開催番号;

    /**
     * 画面初期化処理です。
     *
     * @param div 介護認定審査会審査結果登録
     * @return ResponseData<ChosaOCRTorikomiDiv>
     */
    public ResponseData<ChosaOCRTorikomiDiv> onLoad(ChosaOCRTorikomiDiv div) {
        審査会開催番号 = ViewStateHolder.get(ViewStateKeys.審査会開催番号, RString.class);
        ChosaOCRTorikomiParameter parameter = ChosaOCRTorikomiParameter.createParam(審査会開催番号, RString.EMPTY, RString.EMPTY);
        List<ChosaOCRTorikomiBusiness> torikomiList
                = ChosaOCRTorikomiFinder.createInstance().getChosaOCRTorikomi(parameter).records();
        if (!torikomiList.isEmpty()) {
            getHandler(div).onLoad(torikomiList);
        }
        getHandler(div).setDisabledTrue();
        return ResponseData.of(div).respond();
    }

    /**
     * 「審査結果OCRを取込」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<ImageinputDiv>
     */
    public ResponseData<ChosaOCRTorikomiDiv> onClick_btnOCRTorikomi(ChosaOCRTorikomiDiv div) {
        csvCheck処理(getHandler(div).onClick_Ikensho(), div);
        return ResponseData.of(div).respond();
    }

    private void csvCheck処理(List<TorikomiData> dataList, ChosaOCRTorikomiDiv div) {
        if (dataList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace(ファイル名.toString()));
        }
        List<TorikomiData> dB更新用 = new ArrayList<>();
        for (TorikomiData csvData : dataList) {
            ChosaOCRTorikomiParameter param = ChosaOCRTorikomiParameter.createParam(ViewStateHolder.get(ViewStateKeys.審査会開催番号, RString.class),
                    csvData.get保険者番号(),
                    csvData.get被保険者番号());
            if (csvData.get項目数() != CSV項目数) {
                csvData.setOK_NG(チェックNG);
            } else {
                csvData.setOK_NG(チェックOK);
            }
            if (記入無し.equals(csvData.get非該当()) && 記入無し.equals(csvData.get要支援1()) && 記入無し.equals(csvData.get要支援2())
                    && 記入無し.equals(csvData.get要介護1()) && 記入無し.equals(csvData.get要介護2()) && 記入無し.equals(csvData.get要介護3())
                    && 記入無し.equals(csvData.get要介護4()) && 記入無し.equals(csvData.get要介護5())) {
                csvData.setOK_NG(チェックNG);
            } else {
                csvData.setOK_NG(チェックOK);
            }
            List<RString> 申請書管理番号 = ChosaOCRTorikomiFinder.createInstance().getShinseishoKanriNo(param);
            if (申請書管理番号.isEmpty()) {
                csvData.setOK_NG(チェックNG);
            } else {
                csvData.setOK_NG(チェックOK);
                List<ChosaOCRTorikomiBusiness> 関連データList
                        = ChosaOCRTorikomiFinder.createInstance().getChosahyoTorikomiKekka(param).records();
                for (ChosaOCRTorikomiBusiness 関連データ : 関連データList) {
                    csvData.set保険者(関連データ.get保険者());
                    csvData.set申請書管理番号(関連データ.get申請書管理番号());
                    csvData.set厚労省IF識別コード(関連データ.get厚労省IF識別コード());
                    csvData.set申請日(関連データ.get申請日());
                    csvData.set認定申請区分申請時コード(関連データ.get認定申請区分申請時コード());
                    csvData.set被保険者氏名(関連データ.get被保険者氏名());
                    csvData.set要介護認定一次判定結果コード(関連データ.get要介護認定一次判定結果コード());
                    csvData.set二次判定要介護状態区分コード(関連データ.get二次判定要介護状態区分コード());
                    csvData.set二次判定年月日(関連データ.get二次判定年月日());
                    csvData.set二次判定認定有効終了年月日(関連データ.get二次判定認定有効終了年月日());
                    csvData.set合議体番号(関連データ.get合議体番号());
                    csvData.set介護認定審査会開催予定場所コード(関連データ.get介護認定審査会開催予定場所コード());
                    dB更新用.add(csvData);
                }
            }
        }
        getHandler(div).set画面一覧(dB更新用);
        TorikomiDataCollection collection = new TorikomiDataCollection(dB更新用);
        ViewStateHolder.put(ViewStateKeys.介護認定審査会審査結果登録, collection);
    }

    /**
     * 「保存する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<ImageinputDiv>
     */
    public ResponseData<ChosaOCRTorikomiDiv> onClick_BtnSave(ChosaOCRTorikomiDiv div) {
        boolean 選択Flag = false;
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            for (dgChosahyoTorikomiKekka_Row row : div.getDgChosahyoTorikomiKekka().getDataSource()) {
                if (row.getSelected()) {
                    選択Flag = true;
                }
            }
            if (!選択Flag) {
                ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
                validationMessages.add(getValidationHandler().check一覧対象未選択());
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            db更新(div);
            onClick_btnOCRTorikomi(div);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「アップロードする」ボタンを押します。
     *
     * @param div 画面情報
     * @param files ファイル
     * @return ResponseData<ChosaOCRTorikomiDiv>
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<ChosaOCRTorikomiDiv> onclick_btnUpload(ChosaOCRTorikomiDiv div, FileData[] files) {
        boolean 選択Flag = false;
        for (dgChosahyoTorikomiKekka_Row row : div.getDgChosahyoTorikomiKekka().getDataSource()) {
            if (row.getSelected()) {
                選択Flag = true;
            }
        }
        if (!選択Flag) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(getValidationHandler().check一覧対象未選択());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        for (FileData file : files) {
            save共有フォルダ(div, new FilesystemPath(file.getFilePath()));
        }
        return ResponseData.of(div).respond();
    }

    private void save共有フォルダ(ChosaOCRTorikomiDiv div, FilesystemPath path) {
        List<TorikomiData> dataList = ViewStateHolder.get(ViewStateKeys.介護認定審査会審査結果登録, TorikomiDataCollection.class).getDataList();
        for (TorikomiData data : dataList) {
            for (dgChosahyoTorikomiKekka_Row row : div.getDgChosahyoTorikomiKekka().getDataSource()) {
                if (row.getSelected()) {
                    if (data.getイメージ共有ファイルID() == null) {
                        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName
                                .fromString(data.get保険者番号().concat(data.get被保険者番号())));
                        sfd = SharedFile.defineSharedFile(sfd);
                        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().dateToDelete(RDate.getNowDate().plusMonth(1));
                        SharedFileEntryDescriptor entity = SharedFile.copyToSharedFile(sfd, path, opts);
                        updateDbT5115(data.get申請書管理番号(), entity.getSharedFileId());
                    } else {
                        ReadOnlySharedFileEntryDescriptor or_sfd = new ReadOnlySharedFileEntryDescriptor(FilesystemName
                                .fromString(data.get保険者番号().concat(data.get被保険者番号())), data.getイメージ共有ファイルID());
                        SharedFile.appendNewFile(or_sfd, path, "");
                    }
                }
            }
        }
    }

    private void updateDbT5115(ShinseishoKanriNo 申請書管理番号, RDateTime イメージ共有ファイルID) {
        ImageManager mannger = new ImageManager();
        Image image = mannger.getイメージ情報(申請書管理番号);
        if (image == null) {
            image = new Image(申請書管理番号);
            image = image.createBuilderForEdit().setイメージ共有ファイルID(イメージ共有ファイルID).build();
        } else {
            image = image.createBuilderForEdit().setイメージ共有ファイルID(イメージ共有ファイルID).build().modifiedModel();
        }
        mannger.saveイメージ情報(image);
    }

    private void db更新(ChosaOCRTorikomiDiv div) {
        List<TorikomiData> dataList = ViewStateHolder.get(ViewStateKeys.介護認定審査会審査結果登録, TorikomiDataCollection.class).getDataList();
        for (dgChosahyoTorikomiKekka_Row row : div.getDgChosahyoTorikomiKekka().getDataSource()) {
            if (row.getSelected() && チェックOK.equals(row.getOkOrNg())) {
                for (TorikomiData data : dataList) {
//                    updateDbT5102(div, row, data);
//                    updateDbT5503(div, row, data);
                    updateDbT5511(div, row, data);
                }
            }
        }
    }

//    private void updateDbT5102(ChosaOCRTorikomiDiv div, dgChosahyoTorikomiKekka_Row row, TorikomiData data) {
//        NinteiKekkaJohoManager mange = new NinteiKekkaJohoManager();
//        NinteiKekkaJoho ninteiKekkaJoho = mange.get要介護認定結果情報(data.get申請書管理番号());
//        if (ninteiKekkaJoho == null) {
//            ninteiKekkaJoho = new NinteiKekkaJoho(data.get申請書管理番号());
//            ninteiKekkaJoho = getHandler(div).editNinteiKekkaJoho(ninteiKekkaJoho, row, data, 審査会開催番号);
//        } else {
//            ninteiKekkaJoho = getHandler(div).editNinteiKekkaJoho(ninteiKekkaJoho.modifiedModel(), row, data, 審査会開催番号);
//        }
//        mange.save要介護認定結果情報(ninteiKekkaJoho);
//    }
//
//    private void updateDbT5503(ChosaOCRTorikomiDiv div, dgChosahyoTorikomiKekka_Row row, TorikomiData data) {
//        NinteiKekkaJohoManager mange = new NinteiKekkaJohoManager();
//        NinteiKekkaJoho ninteiKekkaJoho = mange.get要介護認定結果情報(data.get申請書管理番号());
//        if (ninteiKekkaJoho == null) {
//            ninteiKekkaJoho = new NinteiKekkaJoho(data.get申請書管理番号());
//            ninteiKekkaJoho = getHandler(div).editNinteiKekkaJoho(ninteiKekkaJoho, row, data, 審査会開催番号);
//        } else {
//            ninteiKekkaJoho = new NinteiKekkaJoho(data.get申請書管理番号());
//            ninteiKekkaJoho = getHandler(div).editNinteiKekkaJoho(ninteiKekkaJoho.modifiedModel(), row, data, 審査会開催番号);
//        }
//        mange.save要介護認定結果情報(ninteiKekkaJoho);
//    }
    private void updateDbT5511(ChosaOCRTorikomiDiv div, dgChosahyoTorikomiKekka_Row row, TorikomiData data) {
        ShinsakaiKaisaiKekkaJohoManager mange = ShinsakaiKaisaiKekkaJohoManager.createInstance();
        ShinsakaiKaisaiKekkaJoho2 kekkaJoho = mange.get介護認定審査会開催結果情報(審査会開催番号);
        if (kekkaJoho == null) {
            kekkaJoho = new ShinsakaiKaisaiKekkaJoho2(審査会開催番号);
            kekkaJoho = getHandler(div).editShinsakaiKaisaiKekkaJoho(kekkaJoho, row, data);
        } else {
            kekkaJoho = getHandler(div).editShinsakaiKaisaiKekkaJoho(kekkaJoho.modifiedModel(), row, data);
        }
        mange.save介護認定審査会開催結果情報(kekkaJoho);
    }

    private ChosaOCRTorikomiHandler getHandler(ChosaOCRTorikomiDiv div) {
        return new ChosaOCRTorikomiHandler(div);
    }

    private ChosaOCRTorikomiValidationHandler getValidationHandler() {
        return new ChosaOCRTorikomiValidationHandler();
    }
}
