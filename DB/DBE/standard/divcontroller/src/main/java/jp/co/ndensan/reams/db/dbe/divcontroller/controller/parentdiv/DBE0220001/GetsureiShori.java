/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE0220001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0220001.DBE0220001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0220001.DBE0220001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0220001.GetsureiShoriDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0220001.CenterSoshinIchiranCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0220001.GetsureiShoriHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0220001.GetsureiShoriValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ikenshoget.IkenshogetManager;
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
 * 完了処理・センター送信のクラスです。
 *
 * @reamsid_L DBE-1520-010 lishengli
 */
public class GetsureiShori {

    private static final LockingKey 排他キー = new LockingKey(new RString("ShinseishoKanriNo"));
    private static final RString CSVファイル名 = new RString("CenterSoshinIchiran.csv");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");

    /**
     * 完了処理・センター送信の初期化。(オンロード)<br/>
     *
     * @param div GetsureiShoriDiv
     * @return レスポンスデータ
     */
    public ResponseData<GetsureiShoriDiv> onLoad(GetsureiShoriDiv div) {
        if (!RealInitialLocker.tryGetLock(排他キー)) {
            throw new PessimisticLockingException();
        }
        getHandler(div).initialize();
        List<dgNinteiTaskList_Row> dgNinteiTaskList_RowList = div.getCcdNinteiTaskList().getDataSource();
        for (dgNinteiTaskList_Row row : dgNinteiTaskList_RowList) {
            PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(new Code("0001"),
                    new RString("申請書管理番号"), row.getShinseishoKanriNo()));
            personalData.addExpandedInfo(new ExpandedInformation(new Code("0002"), new RString("被保険者番号"),
                    row.getHihoNumber()));
            AccessLogger.log(AccessLogType.照会, personalData);
        }
        return ResponseData.of(div).setState(DBE0220001StateName.初期表示);
    }

    /**
     * 一覧表を出力するボタンの押下チェック処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<GetsureiShoriDiv> onClick_BtnDataOutput(GetsureiShoriDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (new RString("0").equals(div.getCcdNinteiTaskList().一覧件数())) {
            getValidationHandler().センター送信完了対象者一覧データの存在チェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if (div.getCcdNinteiTaskList().getCheckbox() == null || div.getCcdNinteiTaskList().getCheckbox().isEmpty()) {
            getValidationHandler().センター送信完了対象者一覧データの行選択チェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧表を出力するボタンが押下された場合、ＣＳＶを出力します。
     *
     * @param div GetsureiShoriDiv
     * @param response IDownLoadServletResponse
     * @return IDownLoadServletResponse
     */
    public IDownLoadServletResponse onClick_btnOutputCsv(GetsureiShoriDiv div, IDownLoadServletResponse response) {
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), CSVファイル名);
        try (CsvWriter<CenterSoshinIchiranCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.UTF_8withBOM).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(true).build()) {
            List<dgNinteiTaskList_Row> rowList = div.getCcdNinteiTaskList().getCheckbox();
            for (dgNinteiTaskList_Row row : rowList) {
                csvWriter.writeLine(getCsvData(row));
                PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(new Code("0001"),
                        new RString("申請書管理番号"), row.getShinseishoKanriNo()));
                personalData.addExpandedInfo(new ExpandedInformation(new Code("0002"), new RString("被保険者番号"),
                        row.getHihoNumber()));
                AccessLogger.log(AccessLogType.照会, personalData);
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
     * センター送信準備ボタンの押下処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<GetsureiShoriDiv> onClick_BtnCenterSoshin(GetsureiShoriDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            RealInitialLocker.release(排他キー);
            return ResponseData.of(div).forwardWithEventName(DBE0220001TransitionEventName.センター送信).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 月例処理を完了するボタンの押下処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<GetsureiShoriDiv> onClick_BtnCompleteGetsureiShori(GetsureiShoriDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            if (new RString("0").equals(div.getCcdNinteiTaskList().一覧件数())) {
                getValidationHandler().センター送信完了対象者一覧データの存在チェック(validationMessages);
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            if (div.getCcdNinteiTaskList().getCheckbox() == null || div.getCcdNinteiTaskList().getCheckbox().isEmpty()) {
                getValidationHandler().センター送信完了対象者一覧データの行選択チェック(validationMessages);
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            List<dgNinteiTaskList_Row> rowList = div.getCcdNinteiTaskList().getCheckbox();
            for (dgNinteiTaskList_Row row : rowList) {
                if (row.getCenterSoshinDay().getValue() == null) {
                    getValidationHandler().センター送信完了対象者一覧選択行の完了処理事前チェック(validationMessages);
                    return ResponseData.of(div).addValidationMessages(validationMessages).respond();
                }
                Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> サービス一覧情報Model
                        = ViewStateHolder.get(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.class);
                RString 申請書管理番号 = row.getShinseishoKanriNo();
                if (!RString.isNullOrEmpty(申請書管理番号)) {
                    NinteiKanryoJoho ninteiKanryoJoho = サービス一覧情報Model.get(
                            new NinteiKanryoJohoIdentifier(new ShinseishoKanriNo(申請書管理番号)));
                    ninteiKanryoJoho = getHandler(div).要介護認定完了情報更新(ninteiKanryoJoho);
                    IkenshogetManager.createInstance().要介護認定完了情報更新(ninteiKanryoJoho);
                }
                PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(new Code("0001"),
                        new RString("申請書管理番号"), row.getShinseishoKanriNo()));
                personalData.addExpandedInfo(new ExpandedInformation(new Code("0002"), new RString("被保険者番号"),
                        row.getHihoNumber()));
                AccessLogger.log(AccessLogType.更新, personalData);
            }
            RealInitialLocker.release(排他キー);
            div.getCcdKanryoMessege().setMessage(new RString("完了処理・センター送信の保存処理が完了しました。"),
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBE0220001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    private CenterSoshinIchiranCsvEntity getCsvData(dgNinteiTaskList_Row row) {
        return new CenterSoshinIchiranCsvEntity(
                row.getHokensha(),
                getパターン1(row.getNinteiShinseiDay().getValue()),
                row.getHihoNumber(),
                row.getHihoShimei(),
                row.getShinseiKubunShinseiji(),
                row.getShinseiKubunHorei(),
                getパターン1(row.getGetsureiShoriKanryoDay().getValue()),
                getパターン1(row.getCenterSoshinDay().getValue()));
    }

    private RString getパターン1(RDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.wareki().toDateString();
    }

    private GetsureiShoriHandler getHandler(GetsureiShoriDiv div) {
        return new GetsureiShoriHandler(div);
    }

    private GetsureiShoriValidationHandler getValidationHandler() {
        return new GetsureiShoriValidationHandler();
    }
}
