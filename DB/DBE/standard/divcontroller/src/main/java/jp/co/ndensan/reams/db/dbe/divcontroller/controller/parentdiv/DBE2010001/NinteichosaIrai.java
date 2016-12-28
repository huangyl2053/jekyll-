/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairaishudou.NinnteiChousairaiShudouBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE224001.DBE224001_NinteichosaDataOutputParameter;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeInformationMessages;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninnteichousairaishudou.NinnteiChousairaiShudouParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001.DBE2010001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001.DBE2010001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001.NinteichosaIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001.NinteichosaIraiItiranCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2010001.NinteichosaIraiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2010001.NinteichosaIraiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ninnteichousairaishudou.NinnteiChousairaiShudouFinder;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosairai.NinteichosaIraiManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosairailist.NinteichosaIraiListManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.ikenshoprint.IkenshoPrintParameterModel;
import jp.co.ndensan.reams.db.dbz.definition.core.gamensenikbn.GamenSeniKbn;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
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
import jp.co.ndensan.reams.uz.uza.message.ButtonSelectPattern;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 完了処理・認定調査依頼のcontrollerクラスです。
 *
 * @reamsid_L DBE-0300-010 dingyi
 */
public class NinteichosaIrai {

    private static final RString CSVファイルID_認定調査依頼一覧 = new RString("DBE201001");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");

    /**
     * 完了処理・認定調査依頼に初期化を設定します。
     *
     * @param requestDiv 完了処理・認定調査依頼Div
     * @return レスポンス
     */
    public ResponseData onLoad(NinteichosaIraiDiv requestDiv) {
        getHandler(requestDiv).onLoad();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 再表示処理です。
     *
     * @param requestDiv NinteichosaIraiDiv
     * @return ResponseData
     */
    public ResponseData onActive(NinteichosaIraiDiv requestDiv) {
        getHandler(requestDiv).initDataGrid();
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
        RString 出力名 = EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, CSVファイルID_認定調査依頼一覧);
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), 出力名);
        PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(Code.EMPTY, RString.EMPTY, RString.EMPTY));
        try (CsvWriter<NinteichosaIraiItiranCsvEntity> csvWriter
                                                       = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS).
            setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(true).build()) {
            List<dgNinteiTaskList_Row> dataList = requestDiv.getDgNinteiTaskList().getSelectedItems();
            for (dgNinteiTaskList_Row row : dataList) {
                personalData.addExpandedInfo(new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                                                                     row.getShinseishoKanriNo()));
                csvWriter.writeLine(getCsvData(row));
                AccessLogger.log(AccessLogType.照会, personalData);
            }
            csvWriter.close();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(出力名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        return SharedFileDirectAccessDownload.directAccessDownload(
            new SharedFileDirectAccessDescriptor(entry, 出力名), response);
    }

    /**
     * 「調査機関を割付ける(自動)」ボタンを押下する場合、調査機関自動割付処理を実行します。
     *
     * @param requestDiv 完了処理・認定調査依頼Div
     * @return レスポンス
     */
    public ResponseData onClick_btnIraiAuto(NinteichosaIraiDiv requestDiv) {
        ValidationMessageControlPairs vallidation = getValidationHandler(requestDiv).入力チェック_btnIraiAuto();
        ValidationMessageControlPair 自動割付可能チェック = 自動割付可能チェック(requestDiv);
        if (自動割付可能チェック != null) {
            vallidation.add(自動割付可能チェック);
        }
        if (vallidation.iterator().hasNext()) {
            return ResponseData.of(requestDiv).addValidationMessages(vallidation).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                                                          UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(requestDiv).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
            .equals(ResponseHolder.getMessageCode())
            && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            int 要割付人数 = 調査機関自動割付処理(requestDiv);
            if (要割付人数 > 0) {
                return ResponseData.of(requestDiv).addMessage(new InformationMessage(
                    DbeInformationMessages.割付申請者人数が最大割付可能人数を超過.getMessage().getCode(),
                    DbeInformationMessages.割付申請者人数が最大割付可能人数を超過.getMessage().evaluate())).respond();
            } else {
                getHandler(requestDiv).initDataGrid();
                return ResponseData.of(requestDiv).setState(DBE2010001StateName.登録);
            }
        }
        if (new RString(DbeInformationMessages.割付申請者人数が最大割付可能人数を超過.getMessage().getCode())
            .equals(ResponseHolder.getMessageCode())
            && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(requestDiv).initDataGrid();
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
     * @return IDownLoadServletResponse
     */
    public ResponseData<DBE224001_NinteichosaDataOutputParameter> onClick_btnChosadataOutput(NinteichosaIraiDiv requestDiv) {

        DBE224001_NinteichosaDataOutputParameter param = new DBE224001_NinteichosaDataOutputParameter();
        List<RString> 申請書管理番号リスト = new ArrayList<>();
        List<RString> 被保険者番号リスト = new ArrayList<>();
        for (dgNinteiTaskList_Row row : requestDiv.getDgNinteiTaskList().getSelectedItems()) {
            申請書管理番号リスト.add(row.getShinseishoKanriNo());
        }
        param.setShinseishoKanriNoList(申請書管理番号リスト);
        param.setHihokenshaNoList(被保険者番号リスト);
        param.setNinteiChosainCode(RString.EMPTY);
        param.setNinteichosaItakusakiCode(RString.EMPTY);
        param.setShichosonCode(RString.EMPTY);

        FlowParameters fp = FlowParameters.of(new RString("key"), "Batch");
        FlowParameterAccessor.merge(fp);

        return ResponseData.of(param).respond();
    }

    /**
     * 「調査機関を割付ける(手動)」ボタンを押下する場合、認定調査依頼(手動)(DBE2010002)へ遷移します。
     *
     * @param requestDiv 完了処理・認定調査依頼Div
     * @return レスポンス
     */
    public ResponseData onClick_btnWaritukeShudo(NinteichosaIraiDiv requestDiv) {
        ValidationMessageControlPairs vallidation = getValidationHandler(requestDiv).入力チェック_btnWaritukeShudo();
        if (vallidation.iterator().hasNext()) {
            return ResponseData.of(requestDiv).addValidationMessages(vallidation).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                                                          UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(requestDiv).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
            .equals(ResponseHolder.getMessageCode())
            && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ViewStateHolder.put(ViewStateKeys.申請書管理番号,
                                new ShinseishoKanriNo(requestDiv.getDgNinteiTaskList().getSelectedItems().get(0).getShinseishoKanriNo()));
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
            Message message = UrQuestionMessages.処理実行の確認.getMessage();
            return ResponseData.of(requestDiv).addMessage(
                new QuestionMessage(message.getCode(), message.evaluate(), ButtonSelectPattern.OKCancel)).respond();
        }
        List<dgNinteiTaskList_Row> rowList = requestDiv.getDgNinteiTaskList().getSelectedItems();
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
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 依頼書/認定調査票（OCR用紙）/主治医意見書印刷画面を閉じる前に処理を実行します。
     *
     * @param requestDiv 完了処理・認定調査依頼Div
     * @return レスポンス
     */
    public ResponseData onOkClose_btnIraishoToOutput(NinteichosaIraiDiv requestDiv) {
        ValidationMessageControlPairs vallidation = getValidationHandler(requestDiv).check最大表示件数();
        if (vallidation.existsError()) {
            requestDiv.getTxtMaxCount().setValue(requestDiv.getMaxCount());
        }
        getHandler(requestDiv).initDataGrid();
        IkenshoPrintParameterModel model = DataPassingConverter.deserialize(requestDiv.getHiddenIuputModel(), IkenshoPrintParameterModel.class);
        if (model != null) {
            List<ShinseishoKanriNo> kanriNo = model.get申請書管理番号リスト();
            List<RString> kanriNoRString = new ArrayList<>();
            for (ShinseishoKanriNo no : kanriNo) {
                if (no != null && !no.isEmpty()) {
                    kanriNoRString.add(no.value());
                }
            }
            List<dgNinteiTaskList_Row> selected = new ArrayList<>();
            for (dgNinteiTaskList_Row row : requestDiv.getDgNinteiTaskList().getDataSource()) {
                if (kanriNoRString.contains(row.getShinseishoKanriNo())) {
                    selected.add(row);
                }
            }
            requestDiv.getDgNinteiTaskList().setSelectedItems(selected);
        }
        requestDiv.setHiddenIuputModel(RString.EMPTY);
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「調査依頼を完了する」ボタンを押下する場合、ＤＢに更新する処理を実行します。
     *
     * @param requestDiv 完了処理・認定調査依頼Div
     * @return レスポンス
     */
    public ResponseData onClick_btnChousaIraiKanryo(NinteichosaIraiDiv requestDiv) {
        ValidationMessageControlPairs vallidation = getValidationHandler(requestDiv).入力チェック_btnChousaIraiKanryo();
        if (vallidation.iterator().hasNext()) {
            return ResponseData.of(requestDiv).addValidationMessages(vallidation).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                                                          UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(requestDiv).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
            .equals(ResponseHolder.getMessageCode())
            && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            要介護認定完了情報更新(requestDiv.getDgNinteiTaskList().getSelectedItems());
            requestDiv.getCcdKanryoMsg().setMessage(
                new RString("完了処理・認定調査依頼の保存処理が完了しました。"),
                RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
            FlowParameters fp = FlowParameters.of(new RString("key"), "Kanryo");
            FlowParameterAccessor.merge(fp);
            return ResponseData.of(requestDiv).setState(DBE2010001StateName.完了);
        }
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 最大表示件数テキストボックスの値が変更された際の動作です。
     *
     * @param requestDiv NinteichosaIraiDiv
     * @return ResponseData
     */
    public ResponseData onChange_txtMaxCount(NinteichosaIraiDiv requestDiv) {
        getHandler(requestDiv).initDataGrid();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 継続ボタン押下動作です。
     *
     * @param requestDiv NinteichosaIraiDiv
     * @return ResponseData
     */
    public ResponseData onClick_btnContinue(NinteichosaIraiDiv requestDiv) {
        getHandler(requestDiv).initDataGrid();
        return ResponseData.of(requestDiv).setState(DBE2010001StateName.登録);
    }

    private NinteichosaIraiItiranCsvEntity getCsvData(dgNinteiTaskList_Row row) {
        NinteichosaIraiItiranCsvEntity data = new NinteichosaIraiItiranCsvEntity(
            row.getJotai(),
            row.getShinseishoKanriNo(),
            row.getHokensha(),
            row.getNinteiShinseiDay().getValue() != null
            ? row.getNinteiShinseiDay().getValue().wareki().eraType(EraType.KANJI_RYAKU).firstYear(
            FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString() : RString.EMPTY,
            row.getHihoNumber(),
            row.getHihoShimei(),
            get申請区分_申請時_コード(row.getShinseiKubunShinseiji()),
            row.getShinseiKubunShinseiji(),
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

    private void 要介護認定完了情報更新(List<dgNinteiTaskList_Row> 選択されたデータ) {
        Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> 要介護認定完了情報Model
                                                             = ViewStateHolder.get(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.class);
        FlexibleDate today = FlexibleDate.getNowDate();
        for (dgNinteiTaskList_Row row : 選択されたデータ) {
            NinteiKanryoJohoIdentifier 要介護認定完了情報の識別子 = new NinteiKanryoJohoIdentifier(
                new ShinseishoKanriNo(row.getShinseishoKanriNo()));
            NinteichosaIraiListManager.createInstance().save要介護認定完了情報(要介護認定完了情報Model.get(要介護認定完了情報の識別子).
                createBuilderForEdit().set認定調査依頼完了年月日(today).build().toEntity());
        }
    }

    private ValidationMessageControlPair 自動割付可能チェック(NinteichosaIraiDiv requestDiv) {
        List<dgNinteiTaskList_Row> 選択されたデータ = requestDiv.getDgNinteiTaskList().getSelectedItems();
        if (選択されたデータ != null && !選択されたデータ.isEmpty()) {
            ValidationMessageControlPair validationMessage;
            for (dgNinteiTaskList_Row row : 選択されたデータ) {
                int 認定調査委託先情報件数 = NinteichosaIraiManager.createInstance().select認定調査委託先情報(row.getGetShoKisaiHokenshaNo());
                validationMessage = getValidationHandler(requestDiv).認定調査委託先情報件数チェック(
                    認定調査委託先情報件数);
                if (validationMessage != null) {
                    return validationMessage;
                }
            }
            for (dgNinteiTaskList_Row row : 選択されたデータ) {
                int 調査可能人数 = NinteichosaIraiManager.createInstance().select調査可能人数(row.getGetShoKisaiHokenshaNo(), row.getChikuCode());
                int 割付済人数 = NinteichosaIraiManager.createInstance().select割付済人数(row.getGetShoKisaiHokenshaNo(), row.getChikuCode());
                validationMessage = getValidationHandler(requestDiv).割付申請者人数チェック(調査可能人数, 割付済人数);
                if (validationMessage != null) {
                    return validationMessage;
                }
            }
        }
        return null;
    }

    private int 調査機関自動割付処理(NinteichosaIraiDiv requestDiv) {
        List<dgNinteiTaskList_Row> 選択されたデータ = requestDiv.getDgNinteiTaskList().getSelectedItems();
        int tmp要割付人数 = 選択されたデータ.size();
        for (dgNinteiTaskList_Row row : 選択されたデータ) {
            NinnteiChousairaiShudouFinder finder = NinnteiChousairaiShudouFinder.createInstance();
            NinnteiChousairaiShudouParameter parameter = NinnteiChousairaiShudouParameter.createParameterBy申請書管理番号(row.getShinseishoKanriNo());
            List<NinnteiChousairaiShudouBusiness> 認定調査依頼List = finder.get認定調査依頼情報(parameter).records();
            RString 厚労省IF識別コード = RString.EMPTY;
            if (!認定調査依頼List.isEmpty()) {
                厚労省IF識別コード = 認定調査依頼List.get(0).get厚労省IF識別コード();
            }
            tmp要割付人数 = NinteichosaIraiManager.createInstance().調査機関自動割付処理(row.getGetShoKisaiHokenshaNo(), row.getChikuCode(),
                                                                          row.getShinseishoKanriNo(), tmp要割付人数, 厚労省IF識別コード.isEmpty() ? RString.EMPTY : 厚労省IF識別コード);
        }
        return tmp要割付人数;
    }

    private RString get申請区分_申請時_コード(RString 名称) {
        for (NinteiShinseiShinseijiKubunCode kubunCode : NinteiShinseiShinseijiKubunCode.values()) {
            if (kubunCode.get名称().equals(名称)) {
                return kubunCode.getコード();
            }
        }
        return RString.EMPTY;
    }

    private NinteichosaIraiHandler getHandler(NinteichosaIraiDiv div) {
        return new NinteichosaIraiHandler(div);
    }

    private NinteichosaIraiValidationHandler getValidationHandler(NinteichosaIraiDiv div) {
        return new NinteichosaIraiValidationHandler(div);
    }

    private enum viewstateKeys {

        選択値;
    }
}
