/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD511002.DBD511002_KoshinOshiraseTsuchiParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5010001.DBD5010001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5010001.KoshinTaishoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5010001.KoshinTaishoCsvEntity;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5010001.KoshinTaishoValidationHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5010001.SelectSyuuShadeTaCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.koshinTaisho.SelectSyuuShadeTaEntity;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBD5010001_完了処理・更新管理のDivControllerです。
 *
 * @author_L DBD-2030-010 x_youyj
 */
public class KoshinTaisho {

    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString CSVファイル名 = new RString("更新管理対象者一覧.csv");
    private static final RString CSV調査ファイル名 = new RString("調査データ（モバイル用）.csv");
    private static final RString 更新対象モード = new RString("更新対象モード");
    private static final RString ONE = new RString("1");

    /**
     * 画面初期化
     *
     * @param div KoshinTaishoDiv
     * @return ResponseData<KoshinTaishoDiv>
     */
    public ResponseData<KoshinTaishoDiv> onLoad(KoshinTaishoDiv div) {
        div.getCcdChohyoShutsuryokuJun().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD511002.getReportId());
        div.getCcdKoshinTaisho().initialize(更新対象モード);
        List<RString> selectedKey = new ArrayList<>();
        selectedKey.add(new RString("0"));
        div.getChkOutPutSelect().setSelectedItemsByKey(selectedKey);
        div.getTxtKikan().setFromValue(RDate.getNowDate());
        div.getTxtKikan().setToValue(RDate.getNowDate());
        div.getTxtHakobi().setValue(new FlexibleDate(RDate.getNowDate().toDateString()));
        AccessLogger.log(AccessLogType.照会, new KoshinTaishoValidationHandler().アクセスログ情報(div));
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧を出力するボタン
     *
     * @param div KoshinTaishoDiv
     * @param response IDownLoadServletResponse
     * @return IDownLoadServletResponse
     */
    public IDownLoadServletResponse onClick_btndataoutput(KoshinTaishoDiv div, IDownLoadServletResponse response) {

        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), CSVファイル名);
        KoshinTaishoCsvEntity entity = new KoshinTaishoCsvEntity();
        try (CsvWriter<KoshinTaishoCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(true).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.UTF_8withBOM).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(true).build()) {
            for (dgNinteiTaskList_Row row : div.getCcdKoshinTaisho().getDataSource()) {
                csvWriter.writeLine(new KoshinTaishoValidationHandler().setCsvEntity(entity, row));
            }
            csvWriter.close();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(CSVファイル名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        AccessLogger.log(AccessLogType.照会, new KoshinTaishoValidationHandler().アクセスログ情報(div));
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(entry, CSVファイル名), response);
    }

    /**
     * 調査用データと一覧を出力するボタンチック
     *
     * @param div KoshinTaishoDiv
     * @return ResponseData<KoshinTaishoDiv>
     */
    public ResponseData<KoshinTaishoDiv> onBeforeClick_NyuriKu(KoshinTaishoDiv div) {

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.No)) {
            return ResponseData.of(div).respond();
        }
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        KoshinTaishoValidationHandler validationHandler = new KoshinTaishoValidationHandler();
        validationHandler.更新管理完了対象者一覧データの存在チェック(pairs, div);
        validationHandler.更新管理完了対象者一覧データの行選択チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査票を印刷する
     *
     * @param div KoshinTaishoDiv
     * @return ResponseData<KoshinTaishoDiv>
     */
    public ResponseData<KoshinTaishoDiv> onClick_kakuteibutton(KoshinTaishoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.No)) {
            return ResponseData.of(div).respond();
        }
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        KoshinTaishoValidationHandler validationHandler = new KoshinTaishoValidationHandler();
        validationHandler.更新管理完了対象者一覧データの存在チェック(pairs, div);
        validationHandler.更新管理完了対象者一覧データの行選択チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
//        div.getCcdChosaIraiAndChosahyoAndIkenshoPrint();
        return ResponseData.of(div).respond();
    }

    /**
     * 調査用データを出力するボタン
     *
     * @param div KoshinTaishoDiv
     * @param response IDownLoadServletResponse
     * @return IDownLoadServletResponse
     */
    public IDownLoadServletResponse onClick_syuShayoubutton(KoshinTaishoDiv div, IDownLoadServletResponse response) {
        KoshinTaishoValidationHandler validationHandler = new KoshinTaishoValidationHandler();
        List<SelectSyuuShadeTaEntity> 調査データ情報List = validationHandler.csvSyuShayou(div);

        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), CSV調査ファイル名);
        try (CsvWriter<SelectSyuuShadeTaCsvEntity> csvdeTeWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(true).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(true).build()) {
            if (調査データ情報List == null || 調査データ情報List.size() <= 0) {
                SelectSyuuShadeTaCsvEntity selectnullEntity = new SelectSyuuShadeTaCsvEntity();
                csvdeTeWriter.writeLine(selectnullEntity);
            } else {
                for (SelectSyuuShadeTaEntity entity : 調査データ情報List) {
                    csvdeTeWriter.writeLine(validationHandler.setdetaEntity(entity));
                }
                csvdeTeWriter.close();
            }
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(CSV調査ファイル名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        validationHandler.koushiDb(div);
        AccessLogger.log(AccessLogType.照会, new KoshinTaishoValidationHandler().アクセスログ情報(div));
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(entry, CSV調査ファイル名), response);
    }

    /**
     * 帳票印刷処理を実行するボタン
     *
     * @param div KoshinTaishoDiv
     * @return ResponseData<NinshiuUpdatebatctParameter>
     */
    public ResponseData<DBD511002_KoshinOshiraseTsuchiParameter> onClick_cyoupuButton(KoshinTaishoDiv div) {
        KoshinTaishoValidationHandler validationHandler = new KoshinTaishoValidationHandler();
        DBD511002_KoshinOshiraseTsuchiParameter parameter = new DBD511002_KoshinOshiraseTsuchiParameter();
        validationHandler.onCilck_btnBatchRegister(parameter, div);
        return ResponseData.of(parameter).respond();
    }

    /**
     * バッチ起動前のチェックです。
     *
     * @param div KoshinTaishoDiv
     * @return ResponseData<KoshinTaishoDiv>
     */
    public ResponseData<KoshinTaishoDiv> onBeforeCilck_btnBatchRegister(KoshinTaishoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.No)) {
            return ResponseData.of(div).respond();
        }
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        KoshinTaishoValidationHandler validationHandler = new KoshinTaishoValidationHandler();
        validationHandler.更新管理完了対象者一覧データの存在チェック(pairs, div);
        validationHandler.更新管理完了対象者一覧データの行選択チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 更新管理を完了するボタン
     *
     * @param div KoshinTaishoDiv
     * @return ResponseData<KoshinTaishoDiv>
     */
    public ResponseData<KoshinTaishoDiv> onClick_koshinnKannRibutton(KoshinTaishoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.No)) {
            return ResponseData.of(div).respond();
        }
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        KoshinTaishoValidationHandler validationHandler = new KoshinTaishoValidationHandler();
        validationHandler.更新管理完了対象者一覧データの存在チェック(pairs, div);
        validationHandler.更新管理完了対象者一覧データの行選択チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        validationHandler.更新管理完了対象者一覧選択行の完了処理事前チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        validationHandler.youKihoKoushiDb(div);
        div.getCcdKanryoMessege().setMessage(new RString(div.getTitle() + "の保存処理が完了しました。"),
                RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
        AccessLogger.log(AccessLogType.更新, new KoshinTaishoValidationHandler().アクセスログ情報(div));
        return ResponseData.of(div).setState(DBD5010001StateName.完了);
    }

    /**
     * 帳票発行欄の出力対象をチック
     *
     * @param div KoshinTaishoDiv
     * @return ResponseData<KoshinTaishoDiv>
     */
    public ResponseData<KoshinTaishoDiv> onChange_SyutsurikuTaiyou(KoshinTaishoDiv div) {
        div.getTxtHakobi().setValue(new FlexibleDate(RDate.getNowDate().toDateString()));
        div.getTxtHakobi().setDisabled(false);
        if (div.getChkOutPutSelect().getSelectedKeys().size() > 0) {
            for (int i = 0; i < div.getChkOutPutSelect().getSelectedKeys().size(); i++) {
                if (div.getChkOutPutSelect().getSelectedKeys().get(i).equals(ONE)) {
                    div.getTxtHakobi().setDisabled(true);
                    div.getTxtHakobi().clearValue();
                }
            }
        }
        return ResponseData.of(div).respond();
    }
}
