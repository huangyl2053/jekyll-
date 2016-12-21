/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2060001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.KanryoShoriStatus;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2060001.DBE2060001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2060001.DBE2060001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2060001.NinteichosaIraiListCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2060001.NinteichosaKekkaNyushuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2060001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2060001.NinteichosaKekkaNyushuHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2060001.NinteichosaKekkaNyushuValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
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
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 完了処理・認定調査結果入手のクラスです。
 *
 * @reamsid_L DBE-0310-010 dingyi
 */
public class NinteichosaKekkaNyushu {

    private static final RString CSVファイルID_認定調査結果入手 = new RString("DBE206001");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString CSV_WRITER_ENCLOSURE = new RString("\"");
    private static final LockingKey 前排他ロックキー = new LockingKey("ShinseishoKanriNo");

    /**
     * 完了処理・認定調査結果入手に初期化を設定します。
     *
     * @param requestDiv 完了処理・認定調査結果入手Div
     * @return レスポンス
     */
    public ResponseData onLoad(NinteichosaKekkaNyushuDiv requestDiv) {
        if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
            requestDiv.setReadOnly(true);
            throw new ApplicationException(UrErrorMessages.排他_他のユーザが使用中.getMessage());
        }
        getHandler(requestDiv).onLoad();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 状態区分ラジオボタンのonChangeイベントです。
     *
     * @param requestDiv 完了処理・認定調査結果入手Div
     * @return レスポンス
     */
    public ResponseData onChange_radJotaiKubun(NinteichosaKekkaNyushuDiv requestDiv) {
        NinteichosaKekkaNyushuHandler handler = getHandler(requestDiv);
        handler.checkAndSetMaxKensu();
        handler.initialDataGrid();
        handler.setCommonButtonAndTextBoxState();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 最大表示件数テキストボックスのonChangeイベントです。
     *
     * @param requestDiv 完了処理・認定調査結果入手Div
     * @return レスポンス
     */
    public ResponseData onChange_txtMaxKensu(NinteichosaKekkaNyushuDiv requestDiv) {
        getHandler(requestDiv).initialDataGrid();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「一覧を出力する」ボタンを押下する場合、入力チェックを実行します。
     *
     * @param requestDiv 完了処理・認定調査結果入手Div
     * @return レスポンス
     */
    public ResponseData onBefore_btnChosakekkaOutput(NinteichosaKekkaNyushuDiv requestDiv) {
        ValidationMessageControlPairs valid = getValidationHandler(requestDiv).入力チェック_btnChosakekkaOutput();
        if (valid.iterator().hasNext()) {
            return ResponseData.of(requestDiv).addValidationMessages(valid).respond();
        }
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「一覧を出力する」ボタンを押下する場合、認定調査票入手一覧データを作成します。
     *
     * @param requestDiv 完了処理・認定調査結果入手Div
     * @param response IDownLoadServletResponse
     * @return IDownLoadServletResponse
     */
    public IDownLoadServletResponse onClick_btnChosakekkaOutput(NinteichosaKekkaNyushuDiv requestDiv, IDownLoadServletResponse response) {
        RString 出力名 = EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, CSVファイルID_認定調査結果入手);
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), 出力名);
        PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(Code.EMPTY, RString.EMPTY, RString.EMPTY));
        try (CsvWriter<NinteichosaIraiListCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS).
                setEnclosure(CSV_WRITER_ENCLOSURE).setNewLine(NewLine.CRLF).hasHeader(true).build()) {
            List<dgNinteiTaskList_Row> dataList = requestDiv.getNinteichosakekkainput().getDgNinteiTaskList().getSelectedItems();
            for (dgNinteiTaskList_Row row : dataList) {
                personalData.addExpandedInfo(new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                        row.getShinseishoKanriNo()));
                csvWriter.writeLine(getCsvData(row));
            }
            csvWriter.close();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(出力名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        AccessLogger.log(AccessLogType.照会, personalData);
        return SharedFileDirectAccessDownload.directAccessDownload(
                new SharedFileDirectAccessDescriptor(entry, 出力名), response);
    }

    /**
     * 「調査結果を登録する」ボタンを押下する場合、認定調査結果登録画面(DBE2210001)へ遷移します。
     *
     * @param requestDiv 完了処理・認定調査結果入手Div
     * @return レスポンス
     */
    public ResponseData onClick_btnKekkaTouroku(NinteichosaKekkaNyushuDiv requestDiv) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs valid = getValidationHandler(requestDiv).入力チェック_btnKekkaTouroku();
            if (valid.iterator().hasNext()) {
                return ResponseData.of(requestDiv).addValidationMessages(valid).respond();
            }
        }

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(requestDiv).addMessage(UrQuestionMessages.確認_汎用.getMessage().replace("画面遷移しても")).respond();
        }

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ViewStateHolder.put(ViewStateKeys.申請書管理番号,
                    new ShinseishoKanriNo(requestDiv.getNinteichosakekkainput().getDgNinteiTaskList().getSelectedItems().get(0).getShinseishoKanriNo()));
            ViewStateHolder.put(ViewStateKeys.認定調査履歴番号, Integer.valueOf(
                    requestDiv.getNinteichosakekkainput().getDgNinteiTaskList().getSelectedItems().get(0).getNinteichosaIraiRirekiNo().toString()));
            RealInitialLocker.release(前排他ロックキー);
            return ResponseData.of(requestDiv).forwardWithEventName(DBE2060001TransitionEventName.調査結果登録遷移).respond();
        }
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「ＯＣＲ用紙を取込む」ボタンを押下する場合、認定調査結果取込み（OCR）画面(DBE2240001)へ遷移します。
     *
     * @param requestDiv 完了処理・認定調査結果入手Div
     * @return レスポンス
     */
    public ResponseData onClick_btnOCRTorikomi(NinteichosaKekkaNyushuDiv requestDiv) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(requestDiv).addMessage(UrQuestionMessages.確認_汎用.getMessage().replace("画面遷移しても")).respond();
        }

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            RealInitialLocker.release(前排他ロックキー);
            return ResponseData.of(requestDiv).forwardWithEventName(DBE2060001TransitionEventName.取込み_OCR_遷移).respond();
        }
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「調査票入手を完了する」ボタンを押下する場合、ＤＢに更新する処理を実行します。
     *
     * @param requestDiv 完了処理・認定調査結果入手Div
     * @return レスポンス
     */
    public ResponseData onClick_btnChousaResultKanryo(NinteichosaKekkaNyushuDiv requestDiv) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs valid = getValidationHandler(requestDiv).入力チェック_btnChousaResultKanryo();
            if (valid.iterator().hasNext()) {
                return ResponseData.of(requestDiv).addValidationMessages(valid).respond();
            }
        }

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(requestDiv).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
                requestDiv.setReadOnly(true);
                throw new ApplicationException(UrErrorMessages.排他_他のユーザが使用中.getMessage());
            }
            Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> 要介護認定完了情報Model
                    = ViewStateHolder.get(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.class);
            getHandler(requestDiv).onClick_btnChousaResultKanryo(要介護認定完了情報Model);
            RealInitialLocker.release(前排他ロックキー);
            requestDiv.getCcdKanryoMsg().setMessage(
                    new RString("完了処理・認定調査結果入手の保存処理が完了しました。"),
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(requestDiv).setState(DBE2060001StateName.完了);
        }
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「処理を継続する」ボタンを押下する場合、画面を再表示して登録状態に遷移します。
     *
     * @param requestDiv 完了処理・認定調査結果入手Div
     * @return レスポンス
     */
    public ResponseData onClick_btnContinue(NinteichosaKekkaNyushuDiv requestDiv) {
        getHandler(requestDiv).initialDataGrid();
        return ResponseData.of(requestDiv).setState(DBE2060001StateName.登録);
    }

    private NinteichosaIraiListCsvEntity getCsvData(dgNinteiTaskList_Row row) {
        return new NinteichosaIraiListCsvEntity(
                row.getShinseishoKanriNo(),
                get状態名称(row.getJotai()),
                row.getHokensha(),
                getDate32(row.getNinteiShinseiYMD().getValue()),
                row.getHihoNo(),
                row.getHihoShimei(),
                NinteiShinseiShinseijiKubunCode.valueOf(row.getShinseiKubunShinseiji().toString()).getコード(),
                NinteiShinseiShinseijiKubunCode.valueOf(row.getShinseiKubunShinseiji().toString()).get名称(),
                row.getChosaItakusakiCode(),
                row.getChosaItakusaki(),
                row.getChosainCode(),
                row.getChosain(),
                getDate32(row.getChosaJisshiYMD().getValue()),
                getDate32(row.getTokusokuHakkoYMD().getValue()),
                row.getTokusokuHoho(),
                new RString(row.getTokusokuKaisu().getValue().toString()),
                getDate32(row.getTokusokuKigen().getValue()),
                row.getChikuCode(),
                row.getTokusokuChiku()
        );
    }

    private RString getDate32(RDate date) {
        RString tmp = RString.EMPTY;
        if (date != null) {
            tmp = date.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        }
        return tmp;
    }

    private RString get状態名称(RString ryakusho) {
        if (KanryoShoriStatus.未処理.get略称().equals(ryakusho)) {
            return KanryoShoriStatus.未処理.toRString();
        } else if (KanryoShoriStatus.完了可能.get略称().equals(ryakusho)) {
            return KanryoShoriStatus.完了可能.toRString();
        }
        return RString.EMPTY;
    }

    private NinteichosaKekkaNyushuHandler getHandler(NinteichosaKekkaNyushuDiv div) {
        return new NinteichosaKekkaNyushuHandler(div);
    }

    private NinteichosaKekkaNyushuValidationHandler getValidationHandler(NinteichosaKekkaNyushuDiv div) {
        return new NinteichosaKekkaNyushuValidationHandler(div);
    }

}
