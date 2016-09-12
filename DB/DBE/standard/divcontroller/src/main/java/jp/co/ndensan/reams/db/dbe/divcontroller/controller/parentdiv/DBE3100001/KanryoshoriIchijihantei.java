/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE3100001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshoiraitaishoichiran.ShinseishoKanriNoList;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3100001.DBE3100001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3100001.DBE3100001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3100001.KanryoshoriIchijihanteiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3100001.KanryoshoriCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3100001.KanryoshoriIchijihanteiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3100001.KanryoshoriIchijihanteiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.kanryoshoriichijihantei.KanryoshoriIchijihanteiManager;
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
 * 完了処理・一次判定のクラスです。
 *
 * @reamsid_L DBE-2070-010 wangrenze
 */
public class KanryoshoriIchijihantei {

    private static final RString CSVファイル名 = new RString("IchijiHanteiIchiran.csv");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final LockingKey LOCKINGKEY = new LockingKey(new RString("ShinseishoKanriNo"));
    private static final RString ROOTTITLE = new RString("完了処理・一次判定の保存処理が完了しました。");

    /**
     * 画面初期化。(オンロード)<br/>
     *
     * @param div KanryoshoriIchijihanteiDiv
     * @return レスポンスデータ
     */
    public ResponseData<KanryoshoriIchijihanteiDiv> onLoad(KanryoshoriIchijihanteiDiv div) {
        getHandler(div).initialize();
        if (!RealInitialLocker.tryGetLock(LOCKINGKEY)) {
            throw new PessimisticLockingException();
        }
        List<dgNinteiTaskList_Row> dgNinteiTaskList_RowList = div.getCcdNinteiTaskList().getDataSource();
        for (dgNinteiTaskList_Row row : dgNinteiTaskList_RowList) {
            PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(new Code("0001"),
                    new RString("申請書管理番号"), row.getShinseishoKanriNo()));
            AccessLogger.log(AccessLogType.照会, personalData);
        }
        return ResponseData.of(div).setState(DBE3100001StateName.登録);
    }

    /**
     * 一覧表を出力するボタンの押下チェック処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<KanryoshoriIchijihanteiDiv> onBefore_Dataoutput(KanryoshoriIchijihanteiDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (new RString("0").equals(div.getCcdNinteiTaskList().一覧件数())) {
            getValidationHandler().一次判定完了対象者一覧データの存在チェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if (div.getCcdNinteiTaskList().getCheckbox() == null || div.getCcdNinteiTaskList().getCheckbox().isEmpty()) {
            getValidationHandler().一次判定完了対象者一覧データの行選択チェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一次判定一覧データの作成を行う。
     *
     * @param div KanryoshoriIchijihanteiDiv
     * @param response IDownLoadServletResponse
     * @return IDownLoadServletResponse
     */
    public IDownLoadServletResponse onClick_Btndataoutput(KanryoshoriIchijihanteiDiv div, IDownLoadServletResponse response) {
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), CSVファイル名);
        PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(Code.EMPTY, RString.EMPTY, RString.EMPTY));
        try (CsvWriter<KanryoshoriCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.UTF_8withBOM).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(true).build()) {
            List<dgNinteiTaskList_Row> rowList = div.getCcdNinteiTaskList().getCheckbox();
            for (dgNinteiTaskList_Row row : rowList) {
                csvWriter.writeLine(getCsvData(row));
                personalData.addExpandedInfo(new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                        row.getShinseishoKanriNo()));
            }
            csvWriter.close();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(CSVファイル名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        AccessLogger.log(AccessLogType.照会, personalData);
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(entry, CSVファイル名), response);
    }

    /**
     * 一次判定ボタンを押下する。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<KanryoshoriIchijihanteiDiv> onClick_BtnIchijiHantei(KanryoshoriIchijihanteiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            if (new RString("0").equals(div.getCcdNinteiTaskList().一覧件数())) {
                getValidationHandler().一次判定完了対象者一覧データの存在チェック(validationMessages);
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }

            if (div.getCcdNinteiTaskList().getCheckbox() == null || div.getCcdNinteiTaskList().getCheckbox().isEmpty()) {
                getValidationHandler().一次判定完了対象者一覧データの行選択チェック(validationMessages);
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }

            List<dgNinteiTaskList_Row> rowList = div.getCcdNinteiTaskList().getCheckbox();
            申請書管理番号リスト(rowList);
            RealInitialLocker.release(LOCKINGKEY);
            return ResponseData.of(div).forwardWithEventName(DBE3100001TransitionEventName.一次判定処理).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一次判定を完了するボタンを押下する。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<KanryoshoriIchijihanteiDiv> onClick_BtnCompleteIchijiHantei(KanryoshoriIchijihanteiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            if (new RString("0").equals(div.getCcdNinteiTaskList().一覧件数())) {
                getValidationHandler().一次判定完了対象者一覧データの存在チェック(validationMessages);
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            if (div.getCcdNinteiTaskList().getCheckbox() == null || div.getCcdNinteiTaskList().getCheckbox().isEmpty()) {
                getValidationHandler().一次判定完了対象者一覧データの行選択チェック(validationMessages);
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }

            List<dgNinteiTaskList_Row> rowList = div.getCcdNinteiTaskList().getCheckbox();
            for (dgNinteiTaskList_Row row : rowList) {

                if (row.getIchijiHanteiKanryoDay().getValue() != null) {
                    getValidationHandler().一次判定完了対象者一覧選択行の完了処理チェック(validationMessages);
                    return ResponseData.of(div).addValidationMessages(validationMessages).respond();
                }

                Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> サービス一覧情報Model
                        = ViewStateHolder.get(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.class);
                RString 申請書管理番号 = row.getShinseishoKanriNo();

                if (!RString.isNullOrEmpty(申請書管理番号) && !is仮一次判定(申請書管理番号)) {
                    NinteiKanryoJoho ninteiKanryoJoho = サービス一覧情報Model.get(
                            new NinteiKanryoJohoIdentifier(new ShinseishoKanriNo(申請書管理番号)));
                    KanryoshoriIchijihanteiManager.createInstance().要介護認定完了情報更新(getHandler(div)
                            .要介護認定完了情報更新(ninteiKanryoJoho));

                }
            }
            RealInitialLocker.release(LOCKINGKEY);
            div.getCcdKanryoMsg().setMessage(ROOTTITLE, RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBE3100001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    private KanryoshoriCsvEntity getCsvData(dgNinteiTaskList_Row row) {
        return new KanryoshoriCsvEntity(row.getShinseishoKanriNo(),
                row.getHokensha(),
                getパターン1(row.getNinteiShinseiDay().getValue()),
                row.getHihoNumber(),
                row.getHihoShimei(),
                row.getShinseiKubunShinseiji(),
                getパターン1(row.getChosahyoKanryoDay().getValue()),
                getパターン1(row.getIkenshoNyushuKanryoDay().getValue()),
                getパターン1(row.getIchijiHanteiKanryoDay().getValue()),
                getパターン1(row.getIchijiHanteiKanri().getValue()),
                getパターン1(row.getIchijiHantei().getValue()),
                row.getIchijiHanteiKekka(),
                row.getIchijiHanteiWarningCode()
        );

    }

    private RString getパターン1(RDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.wareki().toDateString();
    }

    private boolean is仮一次判定(RString 申請書管理番号) {

        return KanryoshoriIchijihanteiManager.createInstance().get仮一次判定区分(new ShinseishoKanriNo(申請書管理番号));
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

    private KanryoshoriIchijihanteiHandler getHandler(KanryoshoriIchijihanteiDiv div) {
        return new KanryoshoriIchijihanteiHandler(div);
    }

    private KanryoshoriIchijihanteiValidationHandler getValidationHandler() {
        return new KanryoshoriIchijihanteiValidationHandler();
    }

}
