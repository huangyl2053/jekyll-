/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE4010001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4010001.DBE4010001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4010001.DBE4010001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4010001.ShinsakaiTorokuCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4010001.ShinsakaiTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4010001.ShinsakaiTorokuHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4010001.ShinsakaiTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinsakaiYusenWaritsukeKubunCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 完了処理・介護認定審査会登録のコントローラです。
 *
 * @reamsid_L DBE-0340-010 linghuhang
 */
public class ShinsakaiToroku {

    private final RString 出力名 = new RString("審査会登録一覧.csv");
    private final RString 介護認定審査会登録 = new RString("完了処理・介護認定審査会登録");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");

    /**
     * 画面初期化処理です。
     *
     * @param div ShinsakaiTorokuDiv
     * @return ResponseData<ShinsakaiTorokuDiv>
     */
    public ResponseData<ShinsakaiTorokuDiv> onLoad(ShinsakaiTorokuDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧を出力するボタンを押下前、チェックの処理する。
     *
     * @param div ShinsakaiTorokuDiv
     * @return ResponseData<ShinsakaiTorokuDiv>
     */
    public ResponseData<ShinsakaiTorokuDiv> onClick_btnRyooutputBoffer(ShinsakaiTorokuDiv div) {
        ValidationMessageControlPairs 存在チェック結果 = getValidationHandler(div).存在チェック();
        ValidationMessageControlPairs validation = getValidationHandler(div).選択チェック(存在チェック結果);
        if (validation.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validation).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧を出力するボタンを押下するとき、介護認定審査会登録一覧データの作成を行う。
     *
     * @param div ShinsakaiTorokuDiv
     * @param response IDownLoadServletResponse
     * @return ResponseData<ShinsakaiTorokuDiv>
     */
    public IDownLoadServletResponse onClick_btnRyooutput(ShinsakaiTorokuDiv div, IDownLoadServletResponse response) {
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), 出力名);
        try (CsvWriter<ShinsakaiTorokuCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(true).build()) {
            List<dgNinteiTaskList_Row> dataList = div.getCcdTaskList().getCheckbox();
            for (dgNinteiTaskList_Row row : dataList) {
                csvWriter.writeLine(getCsvData(row));
            }
            csvWriter.close();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(出力名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(entry, 出力名), response);
    }

    /**
     * 審査会に割付するボタンを押下するとき、審査会対象者個別割付画面を表示します。
     *
     * @param div ShinsakaiTorokuDiv
     * @return ResponseData<ShinsakaiTorokuDiv>
     */
    public ResponseData<ShinsakaiTorokuDiv> onClick_btnShinsakai(ShinsakaiTorokuDiv div) {
        ValidationMessageControlPairs 存在チェック結果 = getValidationHandler(div).存在チェック();
        ValidationMessageControlPairs 選択チェック = getValidationHandler(div).選択チェック(存在チェック結果);
        ValidationMessageControlPairs validation = getValidationHandler(div).割付可能チェック(選択チェック);
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            if (validation.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validation).respond();
            } else {
                RString 申請書管理番号リスト = div.getCcdTaskList().getCheckbox().get(0).getShinseishoKanriNo();
                return ResponseData.of(div).forwardWithEventName(DBE4010001TransitionEventName.審査会対象者個別割付へ遷移する)
                        .parameter(申請書管理番号リスト);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 審査会登録を完了するボタンを押下するとき、ＤＢに更新します。
     *
     * @param div ShinsakaiTorokuDiv
     * @return ResponseData<ShinsakaiTorokuDiv>
     */
    public ResponseData<ShinsakaiTorokuDiv> onClick_btnShinsakaiToruku(ShinsakaiTorokuDiv div) {
        ValidationMessageControlPairs 存在チェック結果 = getValidationHandler(div).存在チェック();
        ValidationMessageControlPairs 選択チェック = getValidationHandler(div).選択チェック(存在チェック結果);
        ValidationMessageControlPairs 完了処理事前チェック = getValidationHandler(div).完了処理事前チェック(選択チェック);
        ValidationMessageControlPairs 完了済みデータチェック = getValidationHandler(div).完了済みデータチェック(完了処理事前チェック);
        ValidationMessageControlPairs validation = getValidationHandler(div).マスキング完了チェック(完了済みデータチェック);
        if (validation.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validation).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            if (validation.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validation).respond();
            } else {
                前排他キーのセット();
                getHandler(div).要介護認定完了更新();
                前排他キーの解除();
                div.getCcdKanryoMsg().setMessage(new RString(UrInformationMessages.正常終了.getMessage().
                        replace(介護認定審査会登録.toString()).evaluate()), RString.EMPTY, RString.EMPTY, true);
                return ResponseData.of(div).setState(DBE4010001StateName.完了);
            }
        }
        return ResponseData.of(div).setState(DBE4010001StateName.登録);
    }

    private void 前排他キーのセット() {
        LockingKey 排他キー = new LockingKey(new RString("ShinseishoKanriNo"));
        if (!RealInitialLocker.tryGetLock(排他キー)) {
            ErrorMessage message = new ErrorMessage(UrErrorMessages.排他_バッチ実行中で更新不可.getMessage().getCode(),
                    UrErrorMessages.排他_バッチ実行中で更新不可.getMessage().evaluate());
            throw new ApplicationException(message);
        }
    }

    private void 前排他キーの解除() {
        LockingKey 排他キー = new LockingKey(new RString("ShinseishoKanriNo"));
        RealInitialLocker.release(排他キー);
    }

    private ShinsakaiTorokuCsvEntity getCsvData(dgNinteiTaskList_Row row) {
        RString 申請時コード = RString.EMPTY;
        RString 優先割付者コード = RString.EMPTY;
        if (!RString.isNullOrEmpty(row.getShinseiKubunShinseiji())) {
            申請時コード = NinteiShinseiShinseijiKubunCode.valueOf(row.getShinseiKubunShinseiji().toString()).getコード();
        }
        if (!RString.isNullOrEmpty(row.getYusenWaritsukesha())) {
            優先割付者コード = ShinsakaiYusenWaritsukeKubunCode.valueOf(row.getYusenWaritsukesha().toString()).getコード();
        }
        ShinsakaiTorokuCsvEntity data = new ShinsakaiTorokuCsvEntity(
                row.getShinseishoKanriNo(),
                row.getHokensha(),
                日期転換(row.getNinteiShinseiDay().getValue()),
                row.getHihoNumber(),
                row.getHihoShimei(),
                申請時コード,
                row.getShinseiKubunShinseiji(),
                日期転換(row.getChosahyoKanryoDay().getValue()),
                日期転換(row.getIkenshoNyushuKanryoDay().getValue()),
                日期転換(row.getMaskingKanryoDay().getValue()),
                日期転換(row.getShinsakaiKanryoDay().getValue()),
                日期転換(row.getShinsakaiwaritukeDay().getValue()),
                日期転換(row.getShinsakaiKaisaiDay().getValue()),
                時刻転換(row.getShinsakaiKaisaiJikan().getValue()),
                優先割付者コード,
                row.getYusenWaritsukesha(),
                row.getKaisaiNumber(),
                row.getGogitai());
        return data;
    }

    private RString 日期転換(RDate 日期) {
        if (日期 != null) {
            return 日期.wareki().toDateString();
        }
        return RString.EMPTY;
    }

    private RString 時刻転換(RTime 時刻) {
        if (時刻 != null) {
            return new RString(時刻.toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
        }
        return RString.EMPTY;
    }

    private ShinsakaiTorokuHandler getHandler(ShinsakaiTorokuDiv div) {
        return new ShinsakaiTorokuHandler(div);
    }

    private ShinsakaiTorokuValidationHandler getValidationHandler(ShinsakaiTorokuDiv div) {
        return new ShinsakaiTorokuValidationHandler(div);
    }
}
