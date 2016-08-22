/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5240001;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosaocrtorikomi.ChosaOCRTorikomiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ninteikekkajoho.NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinsakaiwariateiinjoho.ShinsakaiWariateIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaikaisaikekkajoho.ShinsakaiKaisaiKekkaJoho2;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosaocrtorikomi.ChosaOCRTorikomiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5240001.ChosaOCRTorikomiMainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5240001.TorikomiData;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5240001.TorikomiEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5240001.TorikomiEntityCollection;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5240001.dgChosahyoTorikomiKekka_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5240001.ChosaOCRTorikomiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5240001.ChosaOCRTorikomiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.chosaocrtorikomi.ChosaOCRTorikomiFinder;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.ninteikekkajoho.NinteiKekkaJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.shinsakaiwariateiinjoho.ShinsakaiWariateIinJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaikaisaikekkajoho.ShinsakaiKaisaiKekkaJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.Image;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ImageManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
public class ChosaOCRTorikomiMain {

    private static final RString ファイル名 = new RString("OCRSHINSA.CSV");
    private static final int CSV項目数 = 38;
    private static final RString チェックOK = new RString("OK");
    private static final RString チェックNG = new RString("NG");
    private static final RString 記入無し = new RString("0");
    private static final RString INDEX_0 = new RString("0");
    private static final RString INDEX_1 = new RString("1");

    /**
     * 画面初期化処理です。
     *
     * @param div 介護認定審査会審査結果登録
     * @return ResponseData<ChosaOCRTorikomiMainDiv>
     */
    public ResponseData<ChosaOCRTorikomiMainDiv> onLoad(ChosaOCRTorikomiMainDiv div) {
        ViewStateHolder.put(ViewStateKeys.審査会開催番号, new RString("11256"));
        RString 審査会開催番号 = ViewStateHolder.get(ViewStateKeys.審査会開催番号, RString.class);
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
     * @return ResponseData<ChosaOCRTorikomiMainDiv>
     */
    public ResponseData<ChosaOCRTorikomiMainDiv> onClick_BtnOCRTorikomi(ChosaOCRTorikomiMainDiv div) {
        ViewStateHolder.put(ViewStateKeys.審査会開催番号, new RString("11256"));
        RString 審査会開催番号 = ViewStateHolder.get(ViewStateKeys.審査会開催番号, RString.class);
        List<TorikomiEntity> entityList = csvCheck処理(getHandler(div).onClick_Ikensho());
        if (entityList.isEmpty()) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(getValidationHandler().check一覧データの存在());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        int エラー件数 = 0;
        for (TorikomiEntity entity : entityList) {
            if (チェックNG.equals(entity.getOK_NG())) {
                エラー件数++;
            }
        }
        div.getTxtErrKensu().setValue(new Decimal(エラー件数));
        dB処理用(entityList, div, 審査会開催番号);
        return ResponseData.of(div).respond();
    }

    private List<TorikomiEntity> csvCheck処理(List<TorikomiData> dataList) {
        if (dataList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace(ファイル名.toString()));
        }
        List<TorikomiEntity> dB更新用 = new ArrayList<>();
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
                    if (関連データ.get証記載保険者番号().equals(csvData.get保険者番号()) && 関連データ.get被保険者番号().equals(csvData.get被保険者番号())) {
                        csvData.setNo(関連データ.getNo());
                        csvData.set保険者(関連データ.get保険者());
                        csvData.set申請書管理番号(関連データ.get申請書管理番号());
                        csvData.set厚労省IF識別コード(関連データ.get厚労省IF識別コード());
                        csvData.set認定申請年月日(関連データ.get認定申請年月日());
                        csvData.set認定申請区分申請時コード(関連データ.get認定申請区分申請時コード());
                        csvData.set被保険者氏名(関連データ.get被保険者氏名());
                        csvData.setDbt5101_被保険者番号(関連データ.get被保険者番号());
                        csvData.set証記載保険者番号(関連データ.get証記載保険者番号());
                        csvData.set要介護認定一次判定結果コード(関連データ.get要介護認定一次判定結果コード());
                        csvData.set二次判定要介護状態区分コード(関連データ.get二次判定要介護状態区分コード());
                        csvData.set二次判定年月日(関連データ.get二次判定年月日());
                        csvData.set二次判定認定有効終了年月日(関連データ.get二次判定認定有効終了年月日());
                        csvData.set合議体番号(関連データ.get合議体番号());
                        csvData.set介護認定審査会開催予定場所コード(関連データ.get介護認定審査会開催予定場所コード());
                    }
                    TorikomiEntity entity = getTorikomiEntity(csvData);
                    dB更新用.add(entity);
                }
            }
        }
        return dB更新用;
    }

    private void dB処理用(List<TorikomiEntity> dB更新用, ChosaOCRTorikomiMainDiv div, RString 審査会開催番号) {
        getHandler(div).set画面一覧(dB更新用, 審査会開催番号);
        TorikomiEntityCollection collection = new TorikomiEntityCollection(dB更新用);
        ViewStateHolder.put(ViewStateKeys.介護認定審査会審査結果登録, collection);
    }

    private TorikomiEntity getTorikomiEntity(TorikomiData data) {
        TorikomiEntity entity = new TorikomiEntity();
        entity.setOK_NG(data.getOK_NG());
        entity.setID1(data.getID1());
        entity.set審査会開催番号(data.get審査会開催番号());
        entity.set審査会開催日(data.get審査会開催日());
        entity.set開催開始時間(data.get開催開始時間());
        entity.set開催終了時間(data.get開催終了時間());
        entity.set実施人数(data.get実施人数());
        entity.set審査員コード1(data.get審査員コード1());
        if (!RString.isNullOrEmpty(data.get審査員1())) {
            entity.set審査員1出席状況(data.get審査員1().substring(0, 1));
        }
        if (!RString.isNullOrEmpty(data.get審査員1()) && data.get審査員1().length() >= 2) {
            entity.set審査員1審査員長フラグ(data.get審査員1().substring(0, 2));
        }
        entity.set審査員コード2(data.get審査員コード2());
        if (!RString.isNullOrEmpty(data.get審査員2())) {
            entity.set審査員2出席状況(data.get審査員2().substring(0, 1));
        }
        if (!RString.isNullOrEmpty(data.get審査員2()) && data.get審査員2().length() >= 2) {
            entity.set審査員2審査員長フラグ(data.get審査員2().substring(0, 2));
        }
        entity.set審査員コード3(data.get審査員コード3());
        if (!RString.isNullOrEmpty(data.get審査員3())) {
            entity.set審査員3出席状況(data.get審査員3().substring(0, 1));
        }
        if (!RString.isNullOrEmpty(data.get審査員3()) && data.get審査員3().length() >= 2) {
            entity.set審査員3審査員長フラグ(data.get審査員3().substring(0, 2));
        }
        entity.set審査員コード4(data.get審査員コード4());
        if (!RString.isNullOrEmpty(data.get審査員4())) {
            entity.set審査員4出席状況(data.get審査員4().substring(0, 1));
        }
        if (!RString.isNullOrEmpty(data.get審査員4()) && data.get審査員4().length() >= 2) {
            entity.set審査員4審査員長フラグ(data.get審査員4().substring(0, 2));
        }
        entity = getTorikomi(entity, data);
        entity.setID2(data.getID2());
        entity.set保険者番号(data.get保険者番号());
        entity.set被保険者番号(data.get被保険者番号());
        entity.set非該当(data.get非該当());
        entity.set要支援1(data.get要支援1());
        entity.set要支援2(data.get要支援2());
        entity.set要介護1(data.get要介護1());
        entity.set要介護2(data.get要介護2());
        entity.set要介護3(data.get要介護3());
        entity.set要介護4(data.get要介護4());
        entity.set要介護5(data.get要介護5());
        entity.set状態像1(data.get状態像1());
        entity.set状態像2(data.get状態像2());
        entity.set再調査(data.get再調査());
        entity.set取下げ(data.get取下げ());
        entity.set認定有効期間(data.get認定有効期間());
        entity.set申請日(data.get認定申請年月日());
        entity.set申請区分(data.get認定申請区分申請時コード());
        entity.set被保険者氏名(data.get被保険者氏名());
        entity.set一次判定結果(data.get要介護認定一次判定結果コード());
        entity.set保険者(data.get保険者());
        entity.set申請書管理番号(data.get申請書管理番号());
        entity.set厚労省IF識別コード(data.get厚労省IF識別コード());
        entity.set被保険者番号(data.get被保険者番号());
        entity.set証記載保険者番号(data.get証記載保険者番号());
        entity.set二次判定要介護状態区分コード(data.get二次判定要介護状態区分コード());
        entity.set二次判定年月日(data.get二次判定年月日());
        entity.set二次判定認定有効終了年月日(data.get二次判定認定有効終了年月日());
        entity.set合議体番号(data.get合議体番号());
        entity.set介護認定審査会開催予定場所コード(data.get介護認定審査会開催予定場所コード());
        return entity;
    }

    private TorikomiEntity getTorikomi(TorikomiEntity entity, TorikomiData data) {
        entity.set審査員コード5(data.get審査員コード5());
        if (!RString.isNullOrEmpty(data.get審査員5())) {
            entity.set審査員5出席状況(data.get審査員5().substring(0, 1));
        }
        if (!RString.isNullOrEmpty(data.get審査員5()) && data.get審査員5().length() >= 2) {
            entity.set審査員5審査員長フラグ(data.get審査員5().substring(0, 2));
        }
        entity.set審査員コード6(data.get審査員コード6());
        if (!RString.isNullOrEmpty(data.get審査員6())) {
            entity.set審査員6出席状況(data.get審査員6().substring(0, 1));
        }
        if (!RString.isNullOrEmpty(data.get審査員6()) && data.get審査員6().length() >= 2) {
            entity.set審査員6審査員長フラグ(data.get審査員6().substring(0, 2));
        }
        entity.set審査員コード7(data.get審査員コード7());
        if (!RString.isNullOrEmpty(data.get審査員7())) {
            entity.set審査員7出席状況(data.get審査員7().substring(0, 1));
        }
        if (!RString.isNullOrEmpty(data.get審査員7()) && data.get審査員7().length() >= 2) {
            entity.set審査員7審査員長フラグ(data.get審査員7().substring(0, 2));
        }
        entity.set審査員コード8(data.get審査員コード8());
        if (!RString.isNullOrEmpty(data.get審査員8())) {
            entity.set審査員8出席状況(data.get審査員8().substring(0, 1));
        }
        if (!RString.isNullOrEmpty(data.get審査員8()) && data.get審査員8().length() >= 2) {
            entity.set審査員8審査員長フラグ(data.get審査員8().substring(0, 2));
        }
        return entity;
    }

    /**
     * 「保存する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<ImageinputDiv>
     */
    public ResponseData<ChosaOCRTorikomiMainDiv> onClick_BtnSave(ChosaOCRTorikomiMainDiv div) {
        RString 審査会開催番号 = ViewStateHolder.get(ViewStateKeys.審査会開催番号, RString.class);
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
            db更新(div, 審査会開催番号);
            onClick_BtnOCRTorikomi(div);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「アップロードする」ボタンを押します。
     *
     * @param div 画面情報
     * @param files ファイル
     * @return ResponseData<ChosaOCRTorikomiMainDiv>
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<ChosaOCRTorikomiMainDiv> onclick_BtnUpload(ChosaOCRTorikomiMainDiv div, FileData[] files) {
        for (FileData file : files) {
            if (file.getFileName().endsWith(new RString("CSV"))) {
                savaCsvファイル(file);
            } else {
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
                save共有フォルダ(div, new FilesystemPath(file.getFilePath()));
            }
        }
        return ResponseData.of(div).respond();
    }

    private boolean savaCsvファイル(FileData file) {
        RString imagePath = Path.combinePath(Path.getRootPath(RString.EMPTY), DbBusinessConfig
                .get(ConfigNameDBE.OCRアップロード用ファイル格納パス, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        File localファイル = new File(file.getFilePath().toString());
        File サーバパス = new File(imagePath.toString());
        boolean fileFlag;
        boolean サーバFlag;
        File サーバ = new File(imagePath.toString(), file.getFileName().toString());
        if (!サーバパス.exists()) {
            fileFlag = サーバパス.mkdirs();
        } else {
            fileFlag = true;
        }
        if (サーバ.exists()) {
            サーバFlag = サーバ.delete();
        } else {
            サーバFlag = true;
        }
        if (サーバFlag && fileFlag) {
            return localファイル.renameTo(サーバ);
        }
        return true;
    }

    private void save共有フォルダ(ChosaOCRTorikomiMainDiv div, FilesystemPath path) {
        List<TorikomiEntity> dataList = ViewStateHolder.get(ViewStateKeys.介護認定審査会審査結果登録, TorikomiEntityCollection.class).getDataList();
        for (TorikomiEntity data : dataList) {
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

    private void db更新(ChosaOCRTorikomiMainDiv div, RString 審査会開催番号) {
        List<TorikomiEntity> dataList = ViewStateHolder.get(ViewStateKeys.介護認定審査会審査結果登録, TorikomiEntityCollection.class).getDataList();
        for (dgChosahyoTorikomiKekka_Row row : div.getDgChosahyoTorikomiKekka().getDataSource()) {
            if (row.getSelected() && チェックOK.equals(row.getOkOrNg())) {
                for (TorikomiEntity data : dataList) {
                    if (row.getShoKisaiHokenshaNo().equals(data.get保険者番号())
                            && row.getHihokenshaNo().equals(data.get被保険者番号())) {
                        updateDbT5102(div, row, data, 審査会開催番号);
                        updateDbT5503(div, row, data, 審査会開催番号);
                        updateDbT5511(div, row, data, 審査会開催番号);
                    }
                }
            }
        }
    }

    private void updateDbT5102(ChosaOCRTorikomiMainDiv div, dgChosahyoTorikomiKekka_Row row, TorikomiEntity data, RString 審査会開催番号) {
        NinteiKekkaJohoManager mange = new NinteiKekkaJohoManager();
        NinteiKekkaJoho ninteiKekkaJoho = mange.get要介護認定結果情報(data.get申請書管理番号());
        if (ninteiKekkaJoho == null) {
            ninteiKekkaJoho = new NinteiKekkaJoho(data.get申請書管理番号());
            ninteiKekkaJoho = getHandler(div).editNinteiKekkaJoho(ninteiKekkaJoho, row, data, 審査会開催番号);
        } else {
            ninteiKekkaJoho = getHandler(div).editNinteiKekkaJoho(ninteiKekkaJoho.modifiedModel(), row, data, 審査会開催番号);
        }
        mange.save要介護認定結果情報(ninteiKekkaJoho);
    }

    private void updateDbT5503(ChosaOCRTorikomiMainDiv div, dgChosahyoTorikomiKekka_Row row, TorikomiEntity data, RString 審査会開催番号) {
        List<RString> 審査員コードList = get審査員コードList(data);
        List<RString> 審査員長フラグList = get審査員長フラグList(data);
        List<RString> 審査員出席状況List = get審査員出席状況List(data);
        for (int i = 0; i < 審査員コードList.size(); i++) {
            ShinsakaiWariateIinJohoManager mange = new ShinsakaiWariateIinJohoManager();
            ShinsakaiWariateIinJoho shinsakaiWariateIinJoho = mange.get介護認定審査会割当委員情報(審査会開催番号, data.get審査員コード1());
            if (shinsakaiWariateIinJoho == null) {
                shinsakaiWariateIinJoho = new ShinsakaiWariateIinJoho(審査会開催番号, 審査員コードList.get(i));
                shinsakaiWariateIinJoho = getHandler(div).editShinsakaiWariateIinJoho(shinsakaiWariateIinJoho, row, data, 審査会開催番号);
                shinsakaiWariateIinJoho.createBuilderForEdit().set介護認定審査会議長区分コード(get介護認定審査会議長区分コード(審査員長フラグList.get(i)));
                shinsakaiWariateIinJoho.createBuilderForEdit().set委員出席(get委員出席(審査員出席状況List.get(i)));
            } else {
                shinsakaiWariateIinJoho = getHandler(div).editShinsakaiWariateIinJoho(shinsakaiWariateIinJoho.modifiedModel(), row, data, 審査会開催番号);
                shinsakaiWariateIinJoho.createBuilderForEdit().set介護認定審査会議長区分コード(get介護認定審査会議長区分コード(審査員長フラグList.get(i)));
                shinsakaiWariateIinJoho.createBuilderForEdit().set委員出席(get委員出席(審査員出席状況List.get(i)));
            }
            mange.save介護認定審査会割当委員情報(shinsakaiWariateIinJoho);
        }
    }

    private List<RString> get審査員コードList(TorikomiEntity data) {
        List<RString> 審査員コードList = new ArrayList<>();
        審査員コードList.add(data.get審査員コード1());
        審査員コードList.add(data.get審査員コード2());
        審査員コードList.add(data.get審査員コード3());
        審査員コードList.add(data.get審査員コード4());
        審査員コードList.add(data.get審査員コード5());
        審査員コードList.add(data.get審査員コード6());
        審査員コードList.add(data.get審査員コード7());
        審査員コードList.add(data.get審査員コード8());
        return 審査員コードList;
    }

    private List<RString> get審査員出席状況List(TorikomiEntity data) {
        List<RString> 審査員出席状況List = new ArrayList<>();
        審査員出席状況List.add(data.get審査員1出席状況());
        審査員出席状況List.add(data.get審査員2出席状況());
        審査員出席状況List.add(data.get審査員3出席状況());
        審査員出席状況List.add(data.get審査員4出席状況());
        審査員出席状況List.add(data.get審査員5出席状況());
        審査員出席状況List.add(data.get審査員6出席状況());
        審査員出席状況List.add(data.get審査員7出席状況());
        審査員出席状況List.add(data.get審査員8出席状況());
        return 審査員出席状況List;
    }

    private List<RString> get審査員長フラグList(TorikomiEntity data) {
        List<RString> 審査員長フラグList = new ArrayList<>();
        審査員長フラグList.add(data.get審査員1審査員長フラグ());
        審査員長フラグList.add(data.get審査員2審査員長フラグ());
        審査員長フラグList.add(data.get審査員3審査員長フラグ());
        審査員長フラグList.add(data.get審査員4審査員長フラグ());
        審査員長フラグList.add(data.get審査員5審査員長フラグ());
        審査員長フラグList.add(data.get審査員6審査員長フラグ());
        審査員長フラグList.add(data.get審査員7審査員長フラグ());
        審査員長フラグList.add(data.get審査員8審査員長フラグ());
        return 審査員長フラグList;
    }

    private Code get介護認定審査会議長区分コード(RString 審査員長フラグ) {
        Code 会議長区分コード = Code.EMPTY;
        if (INDEX_1.equals(審査員長フラグ)) {
            会議長区分コード = new Code("1");
        } else if (INDEX_0.equals(審査員長フラグ)) {
            会議長区分コード = new Code("0");
        }
        return 会議長区分コード;
    }

    private boolean get委員出席(RString 出席状況) {
        return INDEX_1.equals(出席状況);
    }

    private void updateDbT5511(ChosaOCRTorikomiMainDiv div, dgChosahyoTorikomiKekka_Row row, TorikomiEntity data, RString 審査会開催番号) {
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

    private ChosaOCRTorikomiHandler getHandler(ChosaOCRTorikomiMainDiv div) {
        return new ChosaOCRTorikomiHandler(div);
    }

    private ChosaOCRTorikomiValidationHandler getValidationHandler() {
        return new ChosaOCRTorikomiValidationHandler();
    }
}
