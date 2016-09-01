/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5030001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5030001.DBD5030001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5030001.DBD5030001TransitionEventName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5030001.TsuchiShoriDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5030001.dgtsuchishohakko_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5030001.TsuchiShoHakkouCsvEntity;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5030001.TsuchiShoriHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5030001.TsuchiShoriValidationHandler;
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
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 完了処理・通知書発行画面のDivControllerです。
 *
 * @reamsid_L DBD-2040-010 chenxin
 */
public class TsuchiShori {

    private static final RString CSVファイル名 = new RString("通知書発行対象者一覧.csv");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");

    /**
     * 画面初期化
     *
     * @param div TsuchiShoriDiv
     * @return ResponseData<TsuchiShoriDiv>
     */
    public ResponseData<TsuchiShoriDiv> onLoad(TsuchiShoriDiv div) {
        List<dgtsuchishohakko_Row> 画面情報一覧 = getHandler().onLoad();
        div.getDgtsuchishohakko().setDataSource(画面情報一覧);
        AccessLogger.log(AccessLogType.照会, getHandler().アクセスログ情報(画面情報一覧));
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧を出力するボタンの押下チェック処理です。
     *
     * @param div TsuchiShoriDiv
     * @return ResponseData<TsuchiShoriDiv>
     */
    public ResponseData<TsuchiShoriDiv> onClick_btnCsvoutput(TsuchiShoriDiv div) {
        ValidationMessageControlPairs controlPairs選択行存在チェック = new ValidationMessageControlPairs();
        if (controlPairs選択行存在チェック.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs選択行存在チェック).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor通知書発行対象者一覧データの存在チェック(pairs, div);
        getValidationHandler().validateFor通知書発行対象者一覧データの行選択チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧を出力するボタン押下された場合、ＣＳＶを出力します。
     *
     * @param div TsuchiShoriDiv
     * @param response IDownLoadServletResponse
     * @return IDownLoadServletResponse
     */
    public IDownLoadServletResponse onClick_btnOutputCsv(TsuchiShoriDiv div, IDownLoadServletResponse response) {
        List<dgtsuchishohakko_Row> 画面更新情報 = div.getDgtsuchishohakko().getSelectedItems();
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), CSVファイル名);
        try (CsvWriter<TsuchiShoHakkouCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(true).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.UTF_8withBOM).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(true).build()) {
            for (dgtsuchishohakko_Row row : 画面更新情報) {
                csvWriter.writeLine(getHandler().converterDataSourceFromToCsvEntity(row));
            }
            csvWriter.close();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(CSVファイル名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        AccessLogger.log(AccessLogType.照会, getHandler().アクセスログ情報(画面更新情報));
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(entry, CSVファイル名), response);
    }

    /**
     * 通知書を発行するボタン押下
     *
     * @param div TsuchiShoriDiv
     * @return ResponseData<TsuchiShoriDiv>
     */
    public ResponseData<TsuchiShoriDiv> onClick_btnHakkou(TsuchiShoriDiv div) {
        ValidationMessageControlPairs controlPairs選択行存在チェック = new ValidationMessageControlPairs();
        if (controlPairs選択行存在チェック.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs選択行存在チェック).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.確認_汎用.getMessage().replace("遷移しますが")).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).forwardWithEventName(DBD5030001TransitionEventName.通知書発行).respond();
    }

    /**
     * 通知書発行を完了するボタン押下
     *
     * @param div TsuchiShoriDiv
     * @return ResponseData<TsuchiShoriDiv>
     */
    public ResponseData<TsuchiShoriDiv> onClick_btnKanryo(TsuchiShoriDiv div) {
        ValidationMessageControlPairs controlPairs選択行存在チェック = new ValidationMessageControlPairs();
        if (controlPairs選択行存在チェック.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs選択行存在チェック).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor通知書発行対象者一覧データの存在チェック(pairs, div);
        getValidationHandler().validateFor通知書発行対象者一覧データの行選択チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getValidationHandler().validateFor通知書発行対象者一覧選択行の完了処理事前チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        List<dgtsuchishohakko_Row> 画面更新情報 = div.getDgtsuchishohakko().getSelectedItems();
        getHandler().ＤＢ処理(画面更新情報);
        AccessLogger.log(AccessLogType.更新, getHandler().アクセスログ情報(画面更新情報));
        div.getCcdKanryoMessege().setMessage(new RString("完了処理・通知書発行の保存処理が完了しました。"), RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
        return ResponseData.of(div).setState(DBD5030001StateName.完了);
    }

    private TsuchiShoriHandler getHandler() {
        return new TsuchiShoriHandler();
    }

    private TsuchiShoriValidationHandler getValidationHandler() {
        return new TsuchiShoriValidationHandler();
    }
}
