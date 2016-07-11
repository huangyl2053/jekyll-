/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2080001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshoiraitaishoichiran.ShinseishoKanriNoList;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2080001.DBE2080001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2080001.DBE2080001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2080001.MaskingDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2080001.MaskingHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2080001.MaskingIchiranCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2080001.MaskingValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ikenshoget.IkenshogetManager;
import jp.co.ndensan.reams.db.dbe.service.core.masking.MaskingManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFileDirectAccessDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFileDirectAccessDownload;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 完了処理・マスキングのクラスです。
 *
 * @reamsid_L DBE-2080-010 lishengli
 */
public class Masking {

    private static final LockingKey 排他キー = new LockingKey(new RString("ShinseishoKanriNo"));
    private static final RString CSVファイル名 = new RString("DBE2080001_MaskingIchiran.csv");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");

    /**
     * 完了処理・センター送信の初期化。(オンロード)<br/>
     *
     * @param div MaskingDiv
     * @return レスポンスデータ
     */
    public ResponseData<MaskingDiv> onLoad(MaskingDiv div) {
        if (!RealInitialLocker.tryGetLock(排他キー)) {
            throw new PessimisticLockingException();
        }
        getHandler(div).initialize();
        List<dgNinteiTaskList_Row> dgNinteiTaskList_RowList = div.getDgYokaigoNinteiTaskList().getDataSource();
        for (dgNinteiTaskList_Row row : dgNinteiTaskList_RowList) {
            AccessLogger.log(AccessLogType.照会, PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(new Code("0001"),
                    new RString("申請書管理番号"), row.getShinseishoKanriNo())));
        }
        return ResponseData.of(div).setState(DBE2080001StateName.登録);
    }

    /**
     * 一覧表を出力するボタンの押下チェック処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<MaskingDiv> onClick_BtnDataOutput(MaskingDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (new RString("0").equals(div.getDgYokaigoNinteiTaskList().一覧件数())) {
            getValidationHandler().マスキング完了対象者一覧データの存在チェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if (div.getDgYokaigoNinteiTaskList().getCheckbox() == null || div.getDgYokaigoNinteiTaskList().getCheckbox().isEmpty()) {
            getValidationHandler().マスキング完了対象者一覧データの行選択チェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧表を出力するボタンが押下された場合、ＣＳＶを出力します。
     *
     * @param div MaskingDiv
     * @param response IDownLoadServletResponse
     * @return IDownLoadServletResponse
     */
    public IDownLoadServletResponse onClick_btnOutputCsv(MaskingDiv div, IDownLoadServletResponse response) {
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), CSVファイル名);
        try (CsvWriter<MaskingIchiranCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.UTF_8withBOM).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(true).build()) {
            List<dgNinteiTaskList_Row> rowList = div.getDgYokaigoNinteiTaskList().getCheckbox();
            for (dgNinteiTaskList_Row row : rowList) {
                csvWriter.writeLine(getCsvData(row));
                AccessLogger.log(AccessLogType.照会, PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(new Code("0001"),
                        new RString("申請書管理番号"), row.getShinseishoKanriNo())));
            }
            csvWriter.close();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(CSVファイル名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(entry, CSVファイル名), response);
    }

    /**
     * マスキングボタンの押下処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<MaskingDiv> onClick_BtnMasking(MaskingDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            if (new RString("0").equals(div.getDgYokaigoNinteiTaskList().一覧件数())) {
                getValidationHandler().マスキング完了対象者一覧データの存在チェック(validationMessages);
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            if (div.getDgYokaigoNinteiTaskList().getCheckbox() == null || div.getDgYokaigoNinteiTaskList().getCheckbox().isEmpty()) {
                getValidationHandler().マスキング完了対象者一覧データの行選択チェック(validationMessages);
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            申請書管理番号リスト(div.getDgYokaigoNinteiTaskList().getCheckbox());
            RealInitialLocker.release(排他キー);
            return ResponseData.of(div).forwardWithEventName(DBE2080001TransitionEventName.マスキング).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * マスキングを完了するボタンの押下処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<MaskingDiv> onClick_BtnCompleteMasking(MaskingDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            if (new RString("0").equals(div.getDgYokaigoNinteiTaskList().一覧件数())) {
                getValidationHandler().マスキング完了対象者一覧データの存在チェック(validationMessages);
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            if (div.getDgYokaigoNinteiTaskList().getCheckbox() == null || div.getDgYokaigoNinteiTaskList().getCheckbox().isEmpty()) {
                getValidationHandler().マスキング完了対象者一覧データの行選択チェック(validationMessages);
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            List<dgNinteiTaskList_Row> rowList = div.getDgYokaigoNinteiTaskList().getCheckbox();
            for (dgNinteiTaskList_Row row : rowList) {
                Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> サービス一覧情報Model
                        = ViewStateHolder.get(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.class);
                RString 申請書管理番号 = row.getShinseishoKanriNo();
                if (!RString.isNullOrEmpty(申請書管理番号) && MaskingManager.createInstance().is更新(申請書管理番号)) {
                    NinteiKanryoJoho ninteiKanryoJoho = サービス一覧情報Model.get(
                            new NinteiKanryoJohoIdentifier(new ShinseishoKanriNo(申請書管理番号)));
                    ninteiKanryoJoho = getHandler(div).要介護認定完了情報更新(ninteiKanryoJoho);
                    IkenshogetManager.createInstance().要介護認定完了情報更新(ninteiKanryoJoho);
                    AccessLogger.log(AccessLogType.照会, PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(new Code("0001"),
                            new RString("申請書管理番号"), row.getShinseishoKanriNo())));
                }
            }
            RealInitialLocker.release(排他キー);
            div.getCcdKanryoMsg().setMessage(new RString("完了処理・マスキングの保存処理が完了しました。"),
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBE2080001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    private MaskingIchiranCsvEntity getCsvData(dgNinteiTaskList_Row row) {
        return new MaskingIchiranCsvEntity(row.getShinseishoKanriNo(),
                row.getHokensha(),
                getパターン1(row.getNinteiShinseiDay().getValue()),
                row.getHihoNumber(),
                row.getHihoShimei(),
                row.getShinseiKubunShinseiji(),
                getパターン1(row.getChosaIraiKanryoDay().getValue()),
                getパターン1(row.getChosahyoKanryoDay().getValue()),
                getパターン1(row.getIkenshoIraiKanryoDay().getValue()),
                getパターン1(row.getIkenshoNyushuKanryoDay().getValue()),
                getパターン1(row.getMaskingKanryoDay().getValue()));
    }

    private void 申請書管理番号リスト(List<dgNinteiTaskList_Row> 選択データ) {
        List<RString> 申請書管理番号リスト = new ArrayList<>();
        for (dgNinteiTaskList_Row データ : 選択データ) {
            申請書管理番号リスト.add(データ.getShinseishoKanriNo());
        }
        ShinseishoKanriNoList shinseishoKanriNoList = new ShinseishoKanriNoList();
        shinseishoKanriNoList.setShinseishoKanriNoS(申請書管理番号リスト);
        ViewStateHolder.put(ViewStateKeys.申請書管理番号リスト, shinseishoKanriNoList);
    }

    private RString getパターン1(RDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.wareki().toDateString();
    }

    private MaskingHandler getHandler(MaskingDiv div) {
        return new MaskingHandler(div);
    }

    private MaskingValidationHandler getValidationHandler() {
        return new MaskingValidationHandler();
    }
}
