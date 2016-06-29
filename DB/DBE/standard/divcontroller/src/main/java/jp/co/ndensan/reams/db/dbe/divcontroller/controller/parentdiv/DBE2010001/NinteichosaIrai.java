/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshoprint.IkenshoPrintParameterModel;
import jp.co.ndensan.reams.db.dbe.business.core.kanryouninteichosairai.NinteichosaIraiBusiness;
import jp.co.ndensan.reams.db.dbe.definition.core.gamensenikbn.GamenSeniKbn;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeInformationMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001.DBE2010001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001.DBE2010001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001.NinteichosaIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001.NinteichosaIraiItiranCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2060001.ChosaInputCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2010001.NinteichosaIraiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2010001.NinteichosaIraiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosairai.NinteichosaIraiManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosairailist.NinteichosaIraiListManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.definition.message.DbQuestionMessages;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping02A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping06A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping99A;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
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
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 完了処理・認定調査依頼のcontrollerクラスです。
 *
 * @reamsid_L DBE-0300-010 dingyi
 */
public class NinteichosaIrai {

    private static final RString CSVファイル名_認定調査依頼一覧 = new RString("NinteichosaIraiIchiranJoho.csv");
    private static final RString CSVファイル名_調査入力用データ = new RString("ChosaKekkaNyuryokuMobile.csv");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final LockingKey 前排他ロックキー = new LockingKey("ShinseishoKanriNo");

    /**
     * 完了処理・認定調査依頼に初期化を設定します。
     *
     * @param requestDiv 完了処理・認定調査依頼Div
     * @return レスポンス
     */
    public ResponseData onLoad(NinteichosaIraiDiv requestDiv) {
        if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
            requestDiv.setReadOnly(true);
            throw new ApplicationException(UrErrorMessages.排他_他のユーザが使用中.getMessage());
        }
        getHandler(requestDiv).onLoad();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「一覧を出力する」ボタンを押下する場合、入力チェックを実行します。
     *
     * @param requestDiv 完了処理・認定調査依頼Div
     * @return レスポンス
     */
    public ResponseData onBefore_btnDataOutput(NinteichosaIraiDiv requestDiv) {
        ValidationMessageControlPairs vallidation = getValidationHandler(requestDiv).入力チェック_btnDataOutput();
        if (vallidation.iterator().hasNext()) {
            return ResponseData.of(requestDiv).addValidationMessages(vallidation).respond();
        }
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「一覧を出力する」ボタンを押下する場合、認定調査依頼一覧データを作成します。
     *
     * @param requestDiv 完了処理・認定調査依頼Div
     * @param response IDownLoadServletResponse
     * @return IDownLoadServletResponse
     */
    public IDownLoadServletResponse onClick_btnDataOutput(NinteichosaIraiDiv requestDiv, IDownLoadServletResponse response) {
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), CSVファイル名_認定調査依頼一覧);
        PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(Code.EMPTY, RString.EMPTY, RString.EMPTY));
        try (CsvWriter<NinteichosaIraiItiranCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.UTF_8).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(false).build()) {
            List<dgNinteiTaskList_Row> dataList = requestDiv.getCcdTaskList().getCheckbox();
            for (dgNinteiTaskList_Row row : dataList) {
                personalData.addExpandedInfo(new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                        row.getShinseishoKanriNo()));
                csvWriter.writeLine(getCsvData(row));
            }
            csvWriter.close();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(CSVファイル名_認定調査依頼一覧));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        AccessLogger.log(AccessLogType.照会, personalData);
        return SharedFileDirectAccessDownload.directAccessDownload(
                new SharedFileDirectAccessDescriptor(entry, CSVファイル名_認定調査依頼一覧), response);
    }

    /**
     * 「調査機関を割付ける(自動)」ボタンを押下する場合、調査機関自動割付処理を実行します。
     *
     * @param requestDiv 完了処理・認定調査依頼Div
     * @return レスポンス
     */
    public ResponseData onClick_btnIraiAuto(NinteichosaIraiDiv requestDiv) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(requestDiv).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ValidationMessageControlPairs vallidation = getValidationHandler(requestDiv).入力チェック_btnIraiAuto();
            ValidationMessageControlPair 自動割付可能チェック = 自動割付可能チェック(requestDiv);
            if (自動割付可能チェック != null) {
                vallidation.add(自動割付可能チェック);
            }
            if (vallidation.iterator().hasNext()) {
                return ResponseData.of(requestDiv).addValidationMessages(vallidation).respond();
            }
            int 要割付人数 = 調査機関自動割付処理(requestDiv);
            if (要割付人数 > 0) {
                return ResponseData.of(requestDiv).addMessage(new InformationMessage(
                        DbeInformationMessages.割付申請者人数が最大割付可能人数を超過.getMessage().getCode(),
                        DbeInformationMessages.割付申請者人数が最大割付可能人数を超過.getMessage().evaluate())).respond();
            } else {
                RealInitialLocker.release(前排他ロックキー);
                getHandler(requestDiv).onLoad();
                return ResponseData.of(requestDiv).setState(DBE2010001StateName.登録);
            }
        }
        if (new RString(DbeInformationMessages.割付申請者人数が最大割付可能人数を超過.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            RealInitialLocker.release(前排他ロックキー);
            getHandler(requestDiv).onLoad();
            return ResponseData.of(requestDiv).setState(DBE2010001StateName.登録);
        }
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「モバイル用データを出力する」ボタンを押下する場合、入力チェックを実行します。
     *
     * @param requestDiv 完了処理・認定調査依頼Div
     * @return レスポンス
     */
    public ResponseData onBefore_btnChosadataOutput(NinteichosaIraiDiv requestDiv) {
        ValidationMessageControlPairs vallidation = getValidationHandler(requestDiv).入力チェック_btnDataOutput();
        if (vallidation.iterator().hasNext()) {
            return ResponseData.of(requestDiv).addValidationMessages(vallidation).respond();
        }
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「モバイル用データを出力する」ボタンを押下する場合、調査結果入力用データ（モバイル）を作成します。
     *
     * @param requestDiv 完了処理・認定調査依頼Div
     * @param response IDownLoadServletResponse
     * @return IDownLoadServletResponse
     */
    public IDownLoadServletResponse onClick_btnChosadataOutput(NinteichosaIraiDiv requestDiv, IDownLoadServletResponse response) {
        SearchResult<NinteichosaIraiBusiness> 調査入力用データ = NinteichosaIraiManager.createInstance().select調査結果入力用データ(
                get申請書管理番号リスト(requestDiv));
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), CSVファイル名_調査入力用データ);
        PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(Code.EMPTY, RString.EMPTY, RString.EMPTY));
        try (CsvWriter<ChosaInputCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.UTF_8).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(false).build()) {
            for (NinteichosaIraiBusiness data : 調査入力用データ.records()) {
                personalData.addExpandedInfo(new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                        data.get申請書管理番号().value()));
                csvWriter.writeLine(getChosaCsvData(data));
            }
            csvWriter.close();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(CSVファイル名_調査入力用データ));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        AccessLogger.log(AccessLogType.照会, personalData);
        return SharedFileDirectAccessDownload.directAccessDownload(
                new SharedFileDirectAccessDescriptor(entry, CSVファイル名_調査入力用データ), response);
    }

    /**
     * 「モバイル用データを出力する」ボタンを押下する場合、DB（認定調査依頼情報）データを更新します。
     *
     * @param requestDiv 完了処理・認定調査依頼Div
     * @return レスポンス
     */
    public ResponseData onFinish_btnChosadataOutput(NinteichosaIraiDiv requestDiv) {
        List<ShinseishoKanriNo> 申請書管理番号リスト = get申請書管理番号リスト(requestDiv);
        for (ShinseishoKanriNo 申請書管理番号 : 申請書管理番号リスト) {
            NinteichosaIraiManager.createInstance().update認定調査依頼情報(申請書管理番号.value());
        }
        RealInitialLocker.release(前排他ロックキー);
        getHandler(requestDiv).onLoad();
        return ResponseData.of(requestDiv).setState(DBE2010001StateName.登録);
    }

    /**
     * 「調査機関を割付ける(手動)」ボタンを押下する場合、認定調査依頼(手動)(DBE2010002)へ遷移します。
     *
     * @param requestDiv 完了処理・認定調査依頼Div
     * @return レスポンス
     */
    public ResponseData onClick_btnWaritukeShudo(NinteichosaIraiDiv requestDiv) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(requestDiv).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ValidationMessageControlPairs vallidation = getValidationHandler(requestDiv).入力チェック_btnWaritukeShudo();
            if (vallidation.iterator().hasNext()) {
                return ResponseData.of(requestDiv).addValidationMessages(vallidation).respond();
            }
            ViewStateHolder.put(ViewStateKeys.申請書管理番号,
                    new ShinseishoKanriNo(requestDiv.getCcdTaskList().getCheckbox().get(0).getShinseishoKanriNo()));
            RealInitialLocker.release(前排他ロックキー);
            return ResponseData.of(requestDiv).forwardWithEventName(DBE2010001TransitionEventName.認定調査依頼遷移).respond();
        }
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「依頼書等を印刷する」ボタンを押下する場合、依頼書/認定調査票（OCR用紙）/主治医意見書印刷画面へ遷移する前に処理を実行します。
     *
     * @param requestDiv 完了処理・認定調査依頼Div
     * @return レスポンス
     */
    public ResponseData onBefore_btnTaOutput(NinteichosaIraiDiv requestDiv) {
        ValidationMessageControlPairs vallidation = getValidationHandler(requestDiv).入力チェック_btnDataOutput();
        if (vallidation.iterator().hasNext()) {
            return ResponseData.of(requestDiv).addValidationMessages(vallidation).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(requestDiv).addMessage(DbQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            List<dgNinteiTaskList_Row> rowList = requestDiv.getCcdTaskList().getCheckbox();
            IkenshoPrintParameterModel model = new IkenshoPrintParameterModel();
            List<ShinseishoKanriNo> list = new ArrayList<>();
            for (dgNinteiTaskList_Row row : rowList) {
                if (!RString.isNullOrEmpty(row.getShinseishoKanriNo())) {
                    list.add(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
                }
            }
            model.set申請書管理番号リスト(list);
            model.set遷移元画面区分(GamenSeniKbn.認定調査依頼);
            requestDiv.setHiddenIuputModel(DataPassingConverter.serialize(model));
            RealInitialLocker.release(前排他ロックキー);
            return ResponseData.of(requestDiv).respond();
        }
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 依頼書/認定調査票（OCR用紙）/主治医意見書印刷画面を閉じる前に処理を実行します。
     *
     * @param requestDiv 完了処理・認定調査依頼Div
     * @return レスポンス
     */
    public ResponseData onOkClose_btnIraishoToOutput(NinteichosaIraiDiv requestDiv) {
        getHandler(requestDiv).onLoad();
        return ResponseData.of(requestDiv).setState(DBE2010001StateName.登録);
    }

    /**
     * 「調査依頼を完了する」ボタンを押下する場合、ＤＢに更新する処理を実行します。
     *
     * @param requestDiv 完了処理・認定調査依頼Div
     * @return レスポンス
     */
    public ResponseData onClick_btnChousaIraiKanryo(NinteichosaIraiDiv requestDiv) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(requestDiv).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ValidationMessageControlPairs vallidation = getValidationHandler(requestDiv).入力チェック_btnChousaIraiKanryo();
            if (vallidation.iterator().hasNext()) {
                return ResponseData.of(requestDiv).addValidationMessages(vallidation).respond();
            }
            if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
                requestDiv.setReadOnly(true);
                throw new ApplicationException(UrErrorMessages.排他_他のユーザが使用中.getMessage());
            }
            要介護認定完了情報更新(requestDiv.getCcdTaskList().getCheckbox());
            RealInitialLocker.release(前排他ロックキー);
            requestDiv.getCcdKanryoMsg().setMessage(
                    new RString("完了処理・認定調査依頼の保存処理が完了しました。"),
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(requestDiv).setState(DBE2010001StateName.完了);
        }
        return ResponseData.of(requestDiv).respond();
    }

    private NinteichosaIraiItiranCsvEntity getCsvData(dgNinteiTaskList_Row row) {
        NinteichosaIraiItiranCsvEntity data = new NinteichosaIraiItiranCsvEntity(
                row.getShinseishoKanriNo(),
                row.getHokensha(),
                row.getNinteiShinseiDay().getValue() != null
                ? row.getNinteiShinseiDay().getValue().wareki().eraType(EraType.KANJI_RYAKU).firstYear(
                        FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString() : RString.EMPTY,
                row.getHihoNumber(),
                row.getHihoShimei(),
                get申請区分_申請時_コード(row.getShinseiKubunShinseiji()),
                row.getShinseiKubunShinseiji(),
                row.getChosaIraiKanryoDay().getValue() != null
                ? row.getChosaIraiKanryoDay().getValue().wareki().eraType(EraType.KANJI_RYAKU).firstYear(
                        FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString() : RString.EMPTY,
                row.getChosaIraiSaichosaCount() != null ? new RString(row.getChosaIraiSaichosaCount().getValue().toString()) : RString.EMPTY,
                row.getChosaIraishoHakkoDay().getValue() != null
                ? row.getChosaIraishoHakkoDay().getValue().wareki().eraType(EraType.KANJI_RYAKU).firstYear(
                        FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString() : RString.EMPTY,
                row.getChousahyoOutput().getValue() != null
                ? row.getChousahyoOutput().getValue().wareki().eraType(EraType.KANJI_RYAKU).firstYear(
                        FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString() : RString.EMPTY,
                row.getChosaIraiDataShutsuryokuDay().getValue() != null
                ? row.getChosaIraiDataShutsuryokuDay().getValue().wareki().eraType(EraType.KANJI_RYAKU).firstYear(
                        FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString() : RString.EMPTY,
                row.getChosaIraiKigen().getValue() != null
                ? row.getChosaIraiKigen().getValue().wareki().eraType(EraType.KANJI_RYAKU).firstYear(
                        FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString() : RString.EMPTY,
                row.getChosaIraiKubun(),
                row.getKonkaiChosaItakusaki(),
                row.getKonkaiChosain(),
                row.getKonkaiChosaCount() != null ? new RString(row.getKonkaiChosaCount().getValue().toString()) : RString.EMPTY,
                row.getZenkaiChosaItakusaki(),
                row.getZenkaiChosain(),
                row.getZenzenkaiChosaItakusaki(),
                row.getZenzenkaiChosain(),
                row.getYubinNumber(),
                row.getJusho(),
                row.getNyushoShisetsu(),
                row.getChosaTokusokuHakkoDay().getValue() != null
                ? row.getChosaTokusokuHakkoDay().getValue().wareki().eraType(EraType.KANJI_RYAKU).firstYear(
                        FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString() : RString.EMPTY,
                row.getChosaTokusokuHoho(),
                row.getChosaTokusokuCount() != null ? new RString(row.getChosaTokusokuCount().getValue().toString()) : RString.EMPTY,
                row.getChosaIraiKigen().getValue() != null
                ? row.getChosaIraiKigen().getValue().wareki().eraType(EraType.KANJI_RYAKU).firstYear(
                        FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString() : RString.EMPTY,
                row.getChikuCode(),
                row.getChosaTokusokuChiku());
        return data;
    }

    private ChosaInputCsvEntity getChosaCsvData(NinteichosaIraiBusiness 調査入力用データ) {
        RString 厚労省IF識別コード = 調査入力用データ.get厚労省IF識別コード().value();
        RString 調査項目連番 = new RString(調査入力用データ.get調査項目連番());
        RString 調査項目文言 = get調査項目文言(厚労省IF識別コード, 調査項目連番);
        ChosaInputCsvEntity data = new ChosaInputCsvEntity(
                調査入力用データ.get申請書管理番号().value(),
                厚労省IF識別コード,
                KoroshoIfShikibetsuCode.toValue(厚労省IF識別コード).get名称(),
                調査入力用データ.get証記載保険者番号(),
                調査入力用データ.get被保険者番号(),
                get年月日共通ポリシー_パターン1(調査入力用データ.get認定申請年月日()),
                調査入力用データ.get認定申請区分_申請時コード().value(),
                NinteiShinseiShinseijiKubunCode.toValue(調査入力用データ.get認定申請区分_申請時コード().value()).get名称(),
                調査入力用データ.get被保険者氏名().value(),
                調査入力用データ.get被保険者氏名カナ().value(),
                get年月日共通ポリシー_パターン1(調査入力用データ.get生年月日()),
                new RString(調査入力用データ.get年齢()),
                Seibetsu.toValue(調査入力用データ.get性別().value()).get名称(),
                調査入力用データ.get郵便番号().value(),
                調査入力用データ.get住所().value(),
                調査入力用データ.get電話番号().value(),
                調査入力用データ.get保険者名(),
                get年月日共通ポリシー_パターン1(調査入力用データ.get認定調査依頼完了年月日()),
                new RString(調査入力用データ.get認定調査依頼履歴番号()),
                調査入力用データ.get認定調査委託先コード().value(),
                調査入力用データ.get調査委託先(),
                調査入力用データ.get認定調査員コード() != null ? 調査入力用データ.get認定調査員コード().value() : RString.EMPTY,
                調査入力用データ.get調査員氏名(),
                調査入力用データ.get概況特記テキスト_イメージ区分(),
                RString.isNullOrEmpty(調査入力用データ.get概況特記テキスト_イメージ区分()) ? RString.EMPTY : TokkijikoTextImageKubun.toValue(
                        調査入力用データ.get概況特記テキスト_イメージ区分()).get名称(),
                調査入力用データ.get認定調査依頼区分コード() != null ? 調査入力用データ.get認定調査依頼区分コード().value() : RString.EMPTY,
                調査入力用データ.get認定調査依頼区分コード() != null ? NinteiChousaIraiKubunCode.toValue(
                        調査入力用データ.get認定調査依頼区分コード().value()).get名称() : RString.EMPTY,
                new RString(調査入力用データ.get認定調査回数()),
                get年月日共通ポリシー_パターン1(調査入力用データ.get認定調査実施年月日()),
                get年月日共通ポリシー_パターン1(調査入力用データ.get認定調査受領年月日()),
                調査入力用データ.get認定調査区分コード() != null ? 調査入力用データ.get認定調査区分コード().value() : RString.EMPTY,
                調査入力用データ.get認定調査区分コード() != null ? ChosaKubun.toValue(
                        調査入力用データ.get認定調査区分コード().value()).get名称() : RString.EMPTY,
                調査入力用データ.get認定調査実施場所コード() != null ? 調査入力用データ.get認定調査実施場所コード().value() : RString.EMPTY,
                調査入力用データ.get認定調査実施場所コード() != null ? ChosaJisshiBashoCode.toValue(
                        調査入力用データ.get認定調査実施場所コード().value()).get名称() : RString.EMPTY,
                調査入力用データ.get認定調査実施場所名称(),
                調査入力用データ.get認定調査_サービス区分コード() != null ? 調査入力用データ.get認定調査_サービス区分コード().value() : RString.EMPTY,
                調査入力用データ.get認定調査_サービス区分コード() != null ? ServiceKubunCode.toValue(
                        調査入力用データ.get認定調査_サービス区分コード().value()).get名称() : RString.EMPTY,
                調査入力用データ.get利用施設名(),
                調査入力用データ.get利用施設住所(),
                調査入力用データ.get利用施設電話番号(),
                調査入力用データ.get利用施設郵便番号() != null ? 調査入力用データ.get利用施設郵便番号().value() : RString.EMPTY,
                調査入力用データ.get特記(),
                get年月日共通ポリシー_パターン1(調査入力用データ.get認定調査特記事項受付年月日()),
                get年月日共通ポリシー_パターン1(調査入力用データ.get認定調査特記事項受領年月日()),
                調査入力用データ.get住宅改修_改修箇所(),
                調査入力用データ.get市町村特別給付サービス種類名(),
                調査入力用データ.get介護保険給付以外の在宅サービス種類名(),
                調査入力用データ.get概況特記事項_主訴(),
                調査入力用データ.get概況特記事項_家族状況(),
                調査入力用データ.get概況特記事項_居住環境(),
                調査入力用データ.get概況特記事項_機器器械(),
                調査入力用データ.get認定調査特記事項番号(),
                new RString(調査入力用データ.get認定調査特記事項連番()),
                調査入力用データ.get原本マスク区分() != null ? 調査入力用データ.get原本マスク区分().value() : RString.EMPTY,
                調査入力用データ.get原本マスク区分() != null ? GenponMaskKubun.toValue(調査入力用データ.get原本マスク区分().value()).get名称() : RString.EMPTY,
                調査入力用データ.get特記事項(),
                new RString(調査入力用データ.getサービスの状況連番()),
                new RString(調査入力用データ.getサービスの状況()),
                new RString(調査入力用データ.getサービスの状況フラグ連番()),
                new RString(String.valueOf(調査入力用データ.isサービスの状況フラグ())),
                new RString(調査入力用データ.get記入項目連番()),
                調査入力用データ.getサービスの状況記入(),
                new RString(調査入力用データ.get施設利用連番()),
                new RString(String.valueOf(調査入力用データ.is施設利用フラグ())),
                調査入力用データ.get認知症高齢者の日常生活自立度コード() != null ? 調査入力用データ.get認知症高齢者の日常生活自立度コード().value() : RString.EMPTY,
                調査入力用データ.get認知症高齢者の日常生活自立度コード() != null ? GenponMaskKubun.toValue(
                        調査入力用データ.get認知症高齢者の日常生活自立度コード().value()).get名称() : RString.EMPTY,
                調査入力用データ.get障害高齢者の日常生活自立度コード() != null ? 調査入力用データ.get障害高齢者の日常生活自立度コード().value() : RString.EMPTY,
                調査入力用データ.get障害高齢者の日常生活自立度コード() != null ? GenponMaskKubun.toValue(
                        調査入力用データ.get障害高齢者の日常生活自立度コード().value()).get名称() : RString.EMPTY,
                調査項目連番,
                調査項目文言,
                調査入力用データ.get調査項目());
        return data;
    }

    private void 要介護認定完了情報更新(List<dgNinteiTaskList_Row> 選択されたデータ) {
        Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> 要介護認定完了情報Model
                = ViewStateHolder.get(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.class);
        for (dgNinteiTaskList_Row row : 選択されたデータ) {
            NinteiKanryoJohoIdentifier 要介護認定完了情報の識別子 = new NinteiKanryoJohoIdentifier(
                    new ShinseishoKanriNo(row.getShinseishoKanriNo()));
            NinteichosaIraiListManager.createInstance().save要介護認定完了情報(要介護認定完了情報Model.get(要介護認定完了情報の識別子).
                    createBuilderForEdit().set認定調査依頼完了年月日(FlexibleDate.getNowDate()).build().toEntity());
        }
    }

    private ValidationMessageControlPair 自動割付可能チェック(NinteichosaIraiDiv requestDiv) {
        List<dgNinteiTaskList_Row> 選択されたデータ = requestDiv.getCcdTaskList().getCheckbox();
        if (選択されたデータ != null && !選択されたデータ.isEmpty()) {
            int 認定調査委託先情報件数 = NinteichosaIraiManager.createInstance().select認定調査委託先情報(選択されたデータ.get(0).getHihoNumber());
            ValidationMessageControlPair validationMessage = getValidationHandler(requestDiv).認定調査委託先情報件数チェック(
                    認定調査委託先情報件数);
            if (validationMessage != null) {
                return validationMessage;
            }
            for (dgNinteiTaskList_Row row : 選択されたデータ) {
                int 調査可能人数 = NinteichosaIraiManager.createInstance().select調査可能人数(row.getHihoNumber(), row.getChikuCode());
                int 割付済人数 = NinteichosaIraiManager.createInstance().select割付済人数(row.getHihoNumber(), row.getChikuCode());
                validationMessage = getValidationHandler(requestDiv).割付申請者人数チェック(調査可能人数, 割付済人数);
                if (validationMessage != null) {
                    return validationMessage;
                }
            }
        }
        return null;
    }

    private int 調査機関自動割付処理(NinteichosaIraiDiv requestDiv) {
        List<dgNinteiTaskList_Row> 選択されたデータ = requestDiv.getCcdTaskList().getCheckbox();
        int tmp要割付人数 = 選択されたデータ.size();
        for (dgNinteiTaskList_Row row : 選択されたデータ) {
            tmp要割付人数 = NinteichosaIraiManager.createInstance().調査機関自動割付処理(row.getHihoNumber(), row.getChikuCode(),
                    row.getShinseishoKanriNo(), tmp要割付人数, RString.EMPTY);
        }
        return tmp要割付人数;
    }

    private List<ShinseishoKanriNo> get申請書管理番号リスト(NinteichosaIraiDiv requestDiv) {
        List<dgNinteiTaskList_Row> 選択されたデータ = requestDiv.getCcdTaskList().getCheckbox();
        List<ShinseishoKanriNo> 申請書管理番号リスト = new ArrayList<>();
        for (dgNinteiTaskList_Row row : 選択されたデータ) {
            申請書管理番号リスト.add(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        }
        return 申請書管理番号リスト;
    }

    private RString get調査項目文言(RString 厚労省IF識別コード, RString 調査項目連番) {
        RString 調査項目文言 = RString.EMPTY;
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード)) {
            調査項目文言 = NinteichosaKomokuMapping99A.toValue(調査項目連番).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード)) {
            調査項目文言 = NinteichosaKomokuMapping02A.toValue(調査項目連番).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード)) {
            調査項目文言 = NinteichosaKomokuMapping06A.toValue(調査項目連番).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード)) {
            調査項目文言 = NinteichosaKomokuMapping09A.toValue(調査項目連番).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード)) {
            調査項目文言 = NinteichosaKomokuMapping09B.toValue(調査項目連番).get名称();
        }
        return 調査項目文言;
    }

    private RString get申請区分_申請時_コード(RString 名称) {
        for (NinteiShinseiShinseijiKubunCode kubunCode : NinteiShinseiShinseijiKubunCode.values()) {
            if (kubunCode.get名称().equals(名称)) {
                return kubunCode.getコード();
            }
        }
        return RString.EMPTY;
    }

    private RString get年月日共通ポリシー_パターン1(FlexibleDate 年月日) {
        return 年月日 != null ? 年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(
                FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString() : RString.EMPTY;
    }

    private NinteichosaIraiHandler getHandler(NinteichosaIraiDiv div) {
        return new NinteichosaIraiHandler(div);
    }

    private NinteichosaIraiValidationHandler getValidationHandler(NinteichosaIraiDiv div) {
        return new NinteichosaIraiValidationHandler(div);
    }

}
