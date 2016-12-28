/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE1030001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1030001.DBE1030001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1030001.KanryoShoriShinsaUketsukeDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1030001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1030001.KanryoShoriCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1030001.KanryoShoriShinsaUketsukeHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1030001.KanryoShoriShinsaUketsukeValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.kanryoshorishinsauketsuke.KanryoShoriShinsaUketsukeManager;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
import jp.co.ndensan.reams.uz.uza.euc.api.EucOtherInfo;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
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
 * 完了処理・審査受付のクラスです。
 *
 * @reamsid_L DBE-2060-010 wangrenze
 */
public class KanryoShoriShinsaUketsuke {

    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString ROOTTITLE = new RString("基本運用・審査受付の保存処理が完了しました。");
    private static final RString EUC_ENTITYID = new RString("DBE103001");

    /**
     * 画面初期化。(オンロード)<br/>
     *
     * @param div KanryoShoriShinsaUketsukeDiv
     * @return レスポンスデータ
     */
    public ResponseData<KanryoShoriShinsaUketsukeDiv> onLoad(KanryoShoriShinsaUketsukeDiv div) {
        div.getNinteiShinseiJohoTorokuKanryo().getCcdHokensya().loadHokenshaList(GyomuBunrui.介護認定);
        getHandler(div).initialize();
        return ResponseData.of(div).setState(DBE1030001StateName.登録);
    }

    /**
     * 一覧を出力するボタンの押下チェック処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<KanryoShoriShinsaUketsukeDiv> onBefore_Dataoutput(KanryoShoriShinsaUketsukeDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        ValidationMessageControlPairs validPairs = getValidationHandler(div).一覧を出力するボタンの押下チェック処理(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 申請情報登録完了一覧データの作成を行う。
     *
     * @param div KanryoShoriShinsaUketsukeDiv
     * @param response IDownLoadServletResponse
     * @return IDownLoadServletResponse
     */
    public IDownLoadServletResponse onClick_Dataoutput(KanryoShoriShinsaUketsukeDiv div, IDownLoadServletResponse response) {
        RString CSVファイル名 = EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, EUC_ENTITYID);
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), CSVファイル名);
        PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(Code.EMPTY, RString.EMPTY, RString.EMPTY));
        try (CsvWriter<KanryoShoriCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.UTF_8withBOM).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(true).build()) {
            List<dgNinteiTaskList_Row> rowList = div.getDgNinteiTaskList().getSelectedItems();
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
     * 審査受付を完了するボタンを押下する。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<KanryoShoriShinsaUketsukeDiv> onClick_btnShinsakaiComplete(KanryoShoriShinsaUketsukeDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        ValidationMessageControlPairs validPairs = getValidationHandler(div).審査受付を完了するボタンを押下チェック処理(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            List<dgNinteiTaskList_Row> rowList = div.getDgNinteiTaskList().getSelectedItems();
            for (dgNinteiTaskList_Row row : rowList) {
                Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> サービス一覧情報Model
                        = ViewStateHolder.get(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.class);
                RString 申請書管理番号 = row.getShinseishoKanriNo();
                NinteiKanryoJoho ninteiKanryoJoho = null;
                if (!RString.isNullOrEmpty(申請書管理番号)) {
                    ninteiKanryoJoho = サービス一覧情報Model.get(
                            new NinteiKanryoJohoIdentifier(new ShinseishoKanriNo(申請書管理番号)));

                }

                if (ninteiKanryoJoho != null && !RString.isNullOrEmpty(申請書管理番号)) {
                    KanryoShoriShinsaUketsukeManager.createInstance().要介護認定完了情報更新(getHandler(div)
                            .要介護認定完了情報更新(ninteiKanryoJoho));
                } else {
                    KanryoShoriShinsaUketsukeManager.createInstance().要介護認定完了情報が追加(getHandler(div)
                            .要介護認定完了情報が追加(申請書管理番号));
                }
            }

            div.getCcdKanryoMsg().setMessage(ROOTTITLE, RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBE1030001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 最大表示件数テキストボックスの値が変更された際の動作です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<KanryoShoriShinsaUketsukeDiv> onChange_txtMaxCount(KanryoShoriShinsaUketsukeDiv div) {
        getHandler(div).initDataGrid();
        return ResponseData.of(div).respond();
    }

    /**
     * 保険者の値が変更された際の動作です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<KanryoShoriShinsaUketsukeDiv> onChange_ccdHokensha(KanryoShoriShinsaUketsukeDiv div) {
        getHandler(div).initDataGrid();
        return ResponseData.of(div).respond();
    }

    private KanryoShoriCsvEntity getCsvData(dgNinteiTaskList_Row row) {

        return new KanryoShoriCsvEntity(row.getShinseishoKanriNo(),
                row.getHokensha(),
                toSeireki(row.getNinteiShinseiDay().getValue()),
                row.getHihoNumber(),
                row.getHihoShimei(),
                row.getShinseiKubunShinseiji());
    }

    private RString toSeireki(RDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
    }

    private KanryoShoriShinsaUketsukeHandler getHandler(KanryoShoriShinsaUketsukeDiv div) {
        return new KanryoShoriShinsaUketsukeHandler(div);
    }

    private KanryoShoriShinsaUketsukeValidationHandler getValidationHandler(KanryoShoriShinsaUketsukeDiv div) {
        return new KanryoShoriShinsaUketsukeValidationHandler(div);
    }

}
