/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2240001;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokihonchosa.NinteichosahyoKihonChosa;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosakekkatorikomiocr.NinteiOcrRelate;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE250001.DBE250001_NinteiChosaKekkaTorikomiParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosahyo.ninteichosahyokihonchosa.NinteichosahyoKihonChosaMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosakekkatorikomiocr.NinteiOcrMapperParamter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2240001.NinteiChosaOCRTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2240001.NinteiOcrTorokuDataCollection;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2240001.NinteiTorokuData;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2240001.NinteiChosaKekkaTorikomiOcrHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2240001.NinteiOcrDbT5210Handler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2240001.NinteiOcrDbT5211Handler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2240001.NinteiOcrValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahyokihonchosa.NinteichosahyoKihonChosaManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosakekkatorikomiocr.NinteiOcrFindler;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.Image;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.service.core.NinteiAccessLogger;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ImageManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoGaikyoChosaManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoServiceJokyoFlagManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoServiceJokyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoShisetsuRiyoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 認定調査結果取込み（OCR）のコントローラクラスです。
 *
 * @reamsid_L DBE-1540-010 dongyabin
 */
public class NinteiChosaOCRTorikomi {

    private static final RString 初期状態_メニューから = new RString("DBEMN41010");
    private static final RString チェックOK = new RString("OK");
    private static final RString チェックNG = new RString("NG");
    private static final RString ファイル名 = new RString("OCRCHOSA.CSV");
    private static final RString 実施場所_在宅 = new RString("1");
    private static final RString 実施場所_施設 = new RString("2");
    private static final RString 実施場所名_在宅 = new RString("在宅");
    private static final RString 実施場所名_施設 = new RString("施設");
    private static final RString 実施場所名_その他 = new RString("その他");
    private static final int CSV項目数 = 109;
    private static final RString イメージ取込み = new RString("イメージ取込み");
    private static final int DAY_COUNT_一週間 = 7;
    private static final RString UICONTAINERID_DBEUC20601 = new RString("DBEUC20601");
    private static final RString WORKFLOW_KEY_BATCH = new RString("Batch");

    /**
     * 画面の初期化します。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiChosaKekkaTorikomiOcrDiv>
     */
    public ResponseData<NinteiChosaOCRTorikomiDiv> onLoad(NinteiChosaOCRTorikomiDiv div) {
        getHandler(div).setサーバファイルパス();
        return ResponseData.of(div).respond();
    }

    /**
     * 「アップロードする」ボタンのイベント処理です。<br>
     * 指定されたファイルをサーバーへアップロードします。
     *
     * @param div イメージ取込み画面情報
     * @param files 選択されたファイル
     * @return 処理後の画面情報
     */
    public ResponseData<NinteiChosaOCRTorikomiDiv> onClick_btnUpload(NinteiChosaOCRTorikomiDiv div, FileData[] files) {
        SharedFileDescriptor sfd = new SharedFileDescriptor(
                GyomuCode.DB介護保険, FilesystemName.fromString(イメージ取込み));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts
                = new CopyToSharedFileOpts().dateToDelete(RDate.getNowDate().plusDay(DAY_COUNT_一週間)).isCompressedArchive(false);
        RString SharedFileEntryDescriptorString = RString.EMPTY;
        for (FileData file : files) {
            if (SharedFileEntryDescriptorString.isEmpty()) {
                SharedFileEntryDescriptorString = new RString(SharedFile.copyToSharedFile(sfd, new FilesystemPath(file.getFilePath()), opts).toString());
            } else {
                ReadOnlySharedFileEntryDescriptor ro_sfd = new ReadOnlySharedFileEntryDescriptor(
                        GyomuCode.DB介護保険, FilesystemName.fromString(イメージ取込み),
                        SharedFileEntryDescriptor.fromString(SharedFileEntryDescriptorString.toString()).getSharedFileId());
                SharedFile.appendNewFile(ro_sfd, new FilesystemPath(file.getFilePath()), "");
            }
        }
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnBatchRegister"), false);
        div.setHdnSharedFileEntryInfo(SharedFileEntryDescriptorString);
        return ResponseData.of(div).respond();
    }

    /**
     * バッチパラメータのセット処理を行う。<br />
     *
     * @param div OCR取込画面情報
     * @return 画面情報より作成したバッチパラメータ情報
     */
    public ResponseData<DBE250001_NinteiChosaKekkaTorikomiParameter> onSetBatchParameterURL(NinteiChosaOCRTorikomiDiv div) {
        RString uiContainerID = ResponseHolder.getUIContainerId();
        if (UICONTAINERID_DBEUC20601.equals(uiContainerID)) {
            FlowParameters fp = FlowParameters.of(new RString("key"), WORKFLOW_KEY_BATCH);
            FlowParameterAccessor.merge(fp);
        }
        DBE250001_NinteiChosaKekkaTorikomiParameter parameter = getHandler(div).setバッチパラメータ();
        return ResponseData.of(parameter).respond();
    }

    /**
     * 「調査票OCRを取込」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiChosaKekkaTorikomiOcrDiv>
     */
    public ResponseData<NinteiChosaOCRTorikomiDiv> onClick_BtnChosahyoTorikomi(NinteiChosaOCRTorikomiDiv div) {
        csvCheck処理(getHandler(div).onClick_BtnChosahyoTorikomi(), div);
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiChosaKekkaTorikomiOcrDiv>
     */
    public ResponseData<NinteiChosaOCRTorikomiDiv> onClick_BtnSave(NinteiChosaOCRTorikomiDiv div) {
        boolean 選択Flag = true;
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            if (!選択Flag) {
                ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
                validationMessages.add(getValidationHandler().check一覧対象未選択());
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            db更新(div);
            return ResponseData.of(div).addMessage(UrInformationMessages.保存終了.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「アップロードする」ボタンを押します。
     *
     * @param div 画面情報
     * @param files ファイル
     * @return ResponseData<NinteiChosaKekkaTorikomiOcrDiv>
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<NinteiChosaOCRTorikomiDiv> onclick_BtnUpload(NinteiChosaOCRTorikomiDiv div, FileData[] files) {
        for (FileData file : files) {
            if (file.getFileName().endsWith(new RString("CSV"))
                    || file.getFileName().endsWith(new RString("csv"))) {
                savaCsvファイル(file);
            } else {
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

    private void save共有フォルダ(NinteiChosaOCRTorikomiDiv div, FilesystemPath path) {
        List<NinteiTorokuData> csvData = ViewStateHolder.get(ViewStateKeys.認定調査結果取込み_OCR, NinteiOcrTorokuDataCollection.class).getDataList();
        for (NinteiTorokuData data : csvData) {
            if (data.getイメージ共有ファイルID() == null) {
                SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName
                        .fromString(data.get証記載保険者番号().concat(data.get被保険者番号())));
                sfd = SharedFile.defineSharedFile(sfd);
                CopyToSharedFileOpts opts = new CopyToSharedFileOpts().dateToDelete(RDate.getNowDate().plusMonth(1));
                SharedFileEntryDescriptor entity = SharedFile.copyToSharedFile(sfd, path, opts);
                updateDbT5115(new ShinseishoKanriNo(data.get申請書管理番号()), entity.getSharedFileId());
            } else {
                ReadOnlySharedFileEntryDescriptor or_sfd = new ReadOnlySharedFileEntryDescriptor(FilesystemName
                        .fromString(data.get証記載保険者番号().concat(data.get被保険者番号())), data.getイメージ共有ファイルID());
                SharedFile.appendNewFile(or_sfd, path, "");
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

    private void db更新(NinteiChosaOCRTorikomiDiv div) {
        List<NinteiTorokuData> csvData = ViewStateHolder.get(ViewStateKeys.認定調査結果取込み_OCR, NinteiOcrTorokuDataCollection.class).getDataList();
        for (NinteiTorokuData data : csvData) {
            updateDbT5202(data);
            updateDbT5207(data, div);
            updateDbT5208(data);
            updateDbT5210(data);
            update基本調査(data);
        }
    }

    private void updateDbT5202(NinteiTorokuData data) {
        NinteichosahyoGaikyoChosaManager service = new NinteichosahyoGaikyoChosaManager();
        List<NinteichosahyoGaikyoChosa> ninteichosahyoGaikyoChosaList = service.get認定調査票_概況調査_情報(new ShinseishoKanriNo(data.get申請書管理番号()),
                data.get認定調査依頼履歴番号()).records();
        if (ninteichosahyoGaikyoChosaList.isEmpty()) {
            NinteichosahyoGaikyoChosa ninteichosahyoGaikyoChosa = new NinteichosahyoGaikyoChosa(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), new RString("2"));
            ninteichosahyoGaikyoChosa = ninteichosahyoGaikyoChosa.createBuilderForEdit().set厚労省IF識別コード(
                    new Code(data.get厚労省IF識別コード())).build();
            ninteichosahyoGaikyoChosa = ninteichosahyoGaikyoChosa.createBuilderForEdit().set認定調査依頼区分コード(data
                    .get認定調査依頼区分コード()).build();
            ninteichosahyoGaikyoChosa = ninteichosahyoGaikyoChosa.createBuilderForEdit().set認定調査回数(data
                    .get認定調査回数()).build();
            if (!RString.isNullOrEmpty(data.get実施日時())) {
                ninteichosahyoGaikyoChosa = ninteichosahyoGaikyoChosa.createBuilderForEdit().set認定調査実施年月日(
                        new FlexibleDate(data.get実施日時())).build();
            }
            ninteichosahyoGaikyoChosa = ninteichosahyoGaikyoChosa.createBuilderForEdit().set認定調査受領年月日(
                    FlexibleDate.getNowDate()).build();
            ninteichosahyoGaikyoChosa = ninteichosahyoGaikyoChosa.createBuilderForEdit().set認定調査区分コード(
                    new Code(ChosaKubun.新規調査.getコード())).build();
            if (!RString.isNullOrEmpty(data.get認定調査委託先コード())) {
                ninteichosahyoGaikyoChosa = ninteichosahyoGaikyoChosa.createBuilderForEdit().set認定調査委託先コード(
                        new JigyoshaNo(data.get認定調査委託先コード())).build();
            }
            ninteichosahyoGaikyoChosa = ninteichosahyoGaikyoChosa.createBuilderForEdit().set認定調査員コード(
                    data.get認定調査員コード()).build();
            if (!RString.isNullOrEmpty(data.get実施場所コード())) {
                ninteichosahyoGaikyoChosa = ninteichosahyoGaikyoChosa.createBuilderForEdit().set認定調査実施場所コード(
                        new Code(data.get実施場所コード())).build();
                ninteichosahyoGaikyoChosa = ninteichosahyoGaikyoChosa.createBuilderForEdit().set認定調査実施場所名称(
                        set認定調査実施場所名称(data.get実施場所コード())).build();
            }
            if (!RString.isNullOrEmpty(data.get現在のサービス区分コード())) {
                ninteichosahyoGaikyoChosa = ninteichosahyoGaikyoChosa.createBuilderForEdit().
                        set認定調査_サービス区分コード(new Code(data.get現在のサービス区分コード())).build();
            }
            service.save認定調査票_概況調査_子(ninteichosahyoGaikyoChosa);
        }
        for (NinteichosahyoGaikyoChosa ninteichosahyoGaikyoChosa : ninteichosahyoGaikyoChosaList) {
            if (!RString.isNullOrEmpty(data.get実施日時())) {
                ninteichosahyoGaikyoChosa = ninteichosahyoGaikyoChosa.createBuilderForEdit().set認定調査実施年月日(
                        new FlexibleDate(data.get実施日時())).build();
            }
            if (!RString.isNullOrEmpty(data.get認定調査委託先コード())) {
                ninteichosahyoGaikyoChosa = ninteichosahyoGaikyoChosa.createBuilderForEdit().set認定調査委託先コード(
                        new JigyoshaNo(data.get認定調査委託先コード())).build();
            }
            ninteichosahyoGaikyoChosa = ninteichosahyoGaikyoChosa.createBuilderForEdit().set認定調査員コード(
                    data.get認定調査員コード()).build();
            if (!RString.isNullOrEmpty(data.get実施場所コード())) {
                ninteichosahyoGaikyoChosa = ninteichosahyoGaikyoChosa.createBuilderForEdit().set認定調査実施場所コード(
                        new Code(data.get実施場所コード())).build();
                ninteichosahyoGaikyoChosa = ninteichosahyoGaikyoChosa.createBuilderForEdit().set認定調査実施場所名称(
                        set認定調査実施場所名称(data.get実施場所コード())).build();
            }
            if (!RString.isNullOrEmpty(data.get現在のサービス区分コード())) {
                ninteichosahyoGaikyoChosa = ninteichosahyoGaikyoChosa.createBuilderForEdit().
                        set認定調査_サービス区分コード(new Code(data.get現在のサービス区分コード())).build();
            }
            service.save認定調査票_概況調査_子(ninteichosahyoGaikyoChosa.modifiedModel());
        }
    }

    private void updateDbT5207(NinteiTorokuData data, NinteiChosaOCRTorikomiDiv div) {
        NinteichosahyoServiceJokyoManager manager = new NinteichosahyoServiceJokyoManager();
        List<NinteichosahyoServiceJokyo> サービスの状況List = manager.selectサービスの状況(new ShinseishoKanriNo(
                data.get申請書管理番号()), data.get認定調査依頼履歴番号()).records();
        for (NinteichosahyoServiceJokyo ninteichosahyoServiceJokyo : getHandler(div).updateDbT5207(サービスの状況List, data)) {
            manager.save認定調査票_概況調査_サービスの状況(ninteichosahyoServiceJokyo);
        }
    }

    private void updateDbT5208(NinteiTorokuData data) {
        NinteichosahyoServiceJokyoFlagManager service = new NinteichosahyoServiceJokyoFlagManager();
        NinteichosahyoServiceJokyoFlag ninteichosahyoServiceJokyoFlag = service.get認定調査票_概況調査_サービスの状況フラグ(new ShinseishoKanriNo(
                data.get申請書管理番号()), data.get認定調査依頼履歴番号(), 1);
        if (ninteichosahyoServiceJokyoFlag == null) {
            ninteichosahyoServiceJokyoFlag = new NinteichosahyoServiceJokyoFlag(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), 1);
            ninteichosahyoServiceJokyoFlag = ninteichosahyoServiceJokyoFlag.createBuilderForEdit().setサービスの状況フラグ(実施場所_在宅
                    .equals(data.get住宅改修のあり_なし())).build();
            ninteichosahyoServiceJokyoFlag = ninteichosahyoServiceJokyoFlag.createBuilderForEdit().set厚労省IF識別コード(new Code(data
                    .get厚労省IF識別コード())).build();
        } else {
            ninteichosahyoServiceJokyoFlag = ninteichosahyoServiceJokyoFlag.createBuilderForEdit().setサービスの状況フラグ(実施場所_在宅
                    .equals(data.get住宅改修のあり_なし())).build().modifiedModel();
        }
        service.save認定調査票_概況調査_サービスの状況フラグ(ninteichosahyoServiceJokyoFlag);
    }

    private void updateDbT5210(NinteiTorokuData data) {
        NinteichosahyoShisetsuRiyoManager manager = new NinteichosahyoShisetsuRiyoManager();
        List<NinteichosahyoShisetsuRiyo> dbT5201List = manager.get連番除外の認定調査票_概況調査_施設利用(new ShinseishoKanriNo(
                data.get申請書管理番号()), data.get認定調査依頼履歴番号()).records();
        for (NinteichosahyoShisetsuRiyo joho : getDbT5210Handler().updateDbT5210(dbT5201List, data)) {
            manager.save認定調査票_概況調査_施設利用(joho);
        }
    }

    private void update基本調査(NinteiTorokuData data) {
        NinteichosahyoKihonChosaManager manager = NinteichosahyoKihonChosaManager.createInstance();
        NinteichosahyoKihonChosaMapperParameter param = NinteichosahyoKihonChosaMapperParameter.
                createSelectByKeyParam(new ShinseishoKanriNo(
                                data.get申請書管理番号()), data.get認定調査依頼履歴番号());
        NinteichosahyoKihonChosa joho = manager.get認定調査票_基本調査(param);
        if (joho == null) {
            joho = new NinteichosahyoKihonChosa(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号());
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            joho = joho.createBuilderForEdit().set認定調査_認知症高齢者の日常生活自立度コード(new Code(data.get認知症高齢者の日常生活自立度())).build();
            joho = joho.createBuilderForEdit().set認定調査_障害高齢者の日常生活自立度コード(new Code(data.
                    get障害高齢者の日常生活自立度_寝たきり度())).build();
        } else {
            joho = joho.createBuilderForEdit().set認定調査_認知症高齢者の日常生活自立度コード(new Code(data.get認知症高齢者の日常生活自立度())).build();
            joho = joho.createBuilderForEdit().set認定調査_障害高齢者の日常生活自立度コード(new Code(data.
                    get障害高齢者の日常生活自立度_寝たきり度())).build();
            joho = joho.modifiedModel();
        }
        joho = getDbT5211Handler().set_調査項目(joho, data);
        manager.save(joho);

    }

    private RString set認定調査実施場所名称(RString 実施場所コード) {
        if (実施場所_在宅.equals(実施場所コード)) {
            return 実施場所名_在宅;
        } else if (実施場所_施設.equals(実施場所コード)) {
            return 実施場所名_施設;
        } else {
            return 実施場所名_その他;
        }
    }

    private RString dateFormat(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        return new RDate(date.toString()).wareki().toDateString();
    }

    private void csvCheck処理(List<NinteiTorokuData> dataList, NinteiChosaOCRTorikomiDiv div) {
        if (dataList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace(ファイル名.toString()));
        }
        List<NinteiTorokuData> dB更新用 = new ArrayList<>();
        for (NinteiTorokuData csvData : dataList) {
            if (csvData.get項目数() != CSV項目数) {
                csvData.setOK_NG(チェックNG);
            } else {
                csvData.setOK_NG(チェックOK);
            }
            NinteiOcrMapperParamter paramter = NinteiOcrMapperParamter.createParamter(csvData.get保険者番号(),
                    csvData.get被保険者番号(),
                    csvData.get申請日());
            List<NinteiOcrRelate> 関連データList = NinteiOcrFindler.createInstance().get関連データ(paramter).records();
            for (NinteiOcrRelate 関連データ : 関連データList) {
                ShoKisaiHokenshaNo shoKisaiHokenshaNo = new ShoKisaiHokenshaNo(関連データ.get証記載保険者番号());
                NinteiAccessLogger ninteiAccessLogger = new NinteiAccessLogger(AccessLogType.照会, shoKisaiHokenshaNo, 関連データ.get被保険者番号());
                ninteiAccessLogger.log();
                NinteiTorokuData data = getHandler(div).setDB更新用データ(csvData);
                data.set証記載保険者番号(関連データ.get証記載保険者番号());
                data.set保険者(関連データ.get保険者());
                data.set申請区分(関連データ.get申請区分());
                data.set厚労省IF識別コード(関連データ.get厚労省IF識別コード().getコード());
                data.set申請書管理番号(関連データ.get申請書管理番号());
                data.set認定調査依頼履歴番号(関連データ.get認定調査依頼履歴番号());
                data.setイメージ共有ファイルID(関連データ.getイメージ共有ファイルID());
                data.set認定調査委託先コード(関連データ.get認定調査委託先コード());
                data.set認定調査員コード(関連データ.get認定調査員コード());
                data.set認定調査依頼区分コード(関連データ.get認定調査依頼区分コード());
                data.set認定調査回数(関連データ.get認定調査回数());
                dB更新用.add(data);
            }
        }
        NinteiOcrTorokuDataCollection collection = new NinteiOcrTorokuDataCollection(dB更新用);
        ViewStateHolder.put(ViewStateKeys.認定調査結果取込み_OCR, collection);
    }

    private NinteiChosaKekkaTorikomiOcrHandler getHandler(NinteiChosaOCRTorikomiDiv div) {
        return new NinteiChosaKekkaTorikomiOcrHandler(div);
    }

    private NinteiOcrValidationHandler getValidationHandler() {
        return new NinteiOcrValidationHandler();
    }

    private NinteiOcrDbT5210Handler getDbT5210Handler() {
        return new NinteiOcrDbT5210Handler();
    }

    private NinteiOcrDbT5211Handler getDbT5211Handler() {
        return new NinteiOcrDbT5211Handler();
    }
}
