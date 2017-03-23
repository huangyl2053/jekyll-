/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.NinteichosaItakusakiJohoRelate;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosairaijoho.ninteichosairaijoho.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosairaijoho.ninteichosairaijoho.NinteichosaIraiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosairaijoho.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE224001.DBE224001_NinteichosaDataOutputParameter;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeInformationMessages;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeQuestionMessages;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosairai.NinteichosaIraiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001.DBE2010001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001.NinteichosaIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001.NinteichosaIraiItiranCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2010001.NinteichosaIraiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2010001.NinteichosaIraiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosairai.NinteichosaIraiManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosairailist.NinteichosaIraiListManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosairaijoho.ninteishinseijoho.NinteiShinseiJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosairaijoho.ninteichosairaijoho.NinteichosaIraiJohoManager;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.business.core.ikenshoprint.IkenshoPrintParameterModel;
import jp.co.ndensan.reams.db.dbz.definition.core.gamensenikbn.GamenSeniKbn;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzQuestionMessages;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoGaikyoChosaManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
import jp.co.ndensan.reams.uz.uza.euc.api.EucOtherInfo;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
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
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 修正 = new RString("Modified");

    /**
     * 完了処理・認定調査依頼に初期化を設定します。
     *
     * @param requestDiv 完了処理・認定調査依頼Div
     * @return レスポンス
     */
    public ResponseData onLoad(NinteichosaIraiDiv requestDiv) {
        getHandler(requestDiv).onLoad(ResponseHolder.getState());
        ViewStateHolder.put(ViewStateKeys.状態, requestDiv.getRadShoriJyotai().getSelectedKey());
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
        ViewStateHolder.put(ViewStateKeys.状態, requestDiv.getRadShoriJyotai().getSelectedKey());
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 処理状態ラジオボタン変更イベントです。
     *
     * @param requestDiv NinteichosaIraiDiv
     * @return ResponseData
     */
    public ResponseData onChange_radShoriJyotai(NinteichosaIraiDiv requestDiv) {
        NinteichosaIraiHandler handler = getHandler(requestDiv);
        if (!handler.getChangedRow().isEmpty()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(requestDiv).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                requestDiv.getRadShoriJyotai().setSelectedKey(ViewStateHolder.get(ViewStateKeys.状態, RString.class));
                return ResponseData.of(requestDiv).respond();
            }
        }
        ViewStateHolder.put(ViewStateKeys.状態, requestDiv.getRadShoriJyotai().getSelectedKey());
        handler.initDataGrid();
        handler.set調査依頼完了ボタン使用可否();
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
        FileSpoolManager spoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                CSVファイルID_認定調査依頼一覧, UzUDE0831EucAccesslogFileType.Csv);
        RString 出力名 = EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, CSVファイルID_認定調査依頼一覧);
        RString filePath = Path.combinePath(spoolManager.getEucOutputDirectry(), 出力名);

        try (CsvWriter<NinteichosaIraiItiranCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build()) {
            List<dgNinteiTaskList_Row> dataList = requestDiv.getChosairaitaishoshaichiran().getDgNinteiTaskList().getSelectedItems();
            List<PersonalData> personalDataList = new ArrayList<>();
            for (dgNinteiTaskList_Row row : dataList) {

                csvWriter.writeLine(getCsvData(row));

                Optional<PersonalData> personalData = getHandler(requestDiv).getPersonalData(row.getGetShoKisaiHokenshaNo(), row.getHokenshaCode());
                personalDataList.add(personalData.get());
            }
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
            spoolManager.spool(filePath, accessLogUUID);
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
    public ResponseData onClick_btnJidoWaritsuke(NinteichosaIraiDiv requestDiv) {
        ValidationMessageControlPairs vallidation = getValidationHandler(requestDiv).入力チェック_btnJidoWaritsuke();
        ValidationMessageControlPair 自動割付可能チェック = 自動割付可能チェック(requestDiv);
        if (自動割付可能チェック != null) {
            vallidation.add(自動割付可能チェック);
        }
        if (vallidation.iterator().hasNext()) {
            return ResponseData.of(requestDiv).addValidationMessages(vallidation).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            if (is自動割付可能(requestDiv)) {
                調査機関自動割付処理(requestDiv);
                return ResponseData.of(requestDiv).respond();
            } else {
                return ResponseData.of(requestDiv).addMessage(new InformationMessage(
                        DbeInformationMessages.割付申請者人数が最大割付可能人数を超過.getMessage().getCode(),
                        DbeInformationMessages.割付申請者人数が最大割付可能人数を超過.getMessage().evaluate())).respond();
            }
        }
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「調査機関を割付ける（手動）」ボタンクリックイベントです。
     *
     * @param requestDiv NinteichosaIraiDiv
     * @return ResponseData
     */
    public ResponseData onClick_btnShudoWaritsuke(NinteichosaIraiDiv requestDiv) {
        ValidationMessageControlPairs vallidation = getValidationHandler(requestDiv).入力チェック_btnShudoWaritsuke();
        if (vallidation.iterator().hasNext()) {
            return ResponseData.of(requestDiv).addValidationMessages(vallidation).respond();
        }
        NinteichosaIraiHandler handler = getHandler(requestDiv);
        handler.set手動割付時使用可否(true);
        handler.clear認定調査依頼登録パネル();
        handler.set認定調査依頼登録パネル();
        return ResponseData.of(requestDiv).setState(DBE2010001StateName.手動割付内容入力);
    }

    /**
     * 「モバイル用データを出力する」ボタンを押下する場合、入力チェックを実行します。
     *
     * @param requestDiv 完了処理・認定調査依頼Div
     * @return レスポンス
     */
    public ResponseData onBefore_btnChosadataOutput(NinteichosaIraiDiv requestDiv) {
        boolean 未保存データ有 = false;
        if (!(new RString(DbzQuestionMessages.変更未保存の確認.getMessage().getCode()))
                .equals(ResponseHolder.getMessageCode())) {
            未保存データ有 = has未保存データ(requestDiv, 未保存データ有);
        }
        ValidationMessageControlPairs vallidation = getValidationHandler(requestDiv).入力チェック_btnChosainDataOutput(未保存データ有);
        if (vallidation.iterator().hasNext()) {
            return ResponseData.of(requestDiv).addValidationMessages(vallidation).respond();
        }

        return ResponseData.of(requestDiv).respond();
    }

    private boolean has未保存データ(NinteichosaIraiDiv requestDiv, boolean 未保存データ有) {
        for (dgNinteiTaskList_Row row : requestDiv.getDgNinteiTaskList().getSelectedItems()) {
            RString 状態 = new RString(row.getRowState().toString());
            if (状態.equals(修正)) {
                未保存データ有 = true;
                break;
            }
        }
        return 未保存データ有;
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
        List<dgNinteiTaskList_Row> rowList = requestDiv.getChosairaitaishoshaichiran().getDgNinteiTaskList().getSelectedItems();
        for (dgNinteiTaskList_Row row : rowList) {
            申請書管理番号リスト.add(row.getShinseishoKanriNo());
            被保険者番号リスト.add(row.getHihoNumber());
        }
        param.setShinseishoKanriNoList(申請書管理番号リスト);
        param.setHihokenshaNoList(被保険者番号リスト);
        param.setNinteiChosainCode(RString.EMPTY);
        param.setNinteichosaItakusakiCode(RString.EMPTY);
        param.setShichosonCode(requestDiv.getChosairaitaishoshaichiran().getDgNinteiTaskList()
                .getSelectedItems().get(0).getHokenshaCode());
        param.setAddedFileName(getモバイルデータ出力ファイル付加名称(rowList));
        param.setTempFilePath(Directory.createTmpDirectory());

        FlowParameters fp = FlowParameters.of(new RString("key"), "Batch");
        FlowParameterAccessor.merge(fp);

        return ResponseData.of(param).respond();
    }

    /**
     * 「割付ける」ボタンクリックイベントです。
     *
     * @param requestDiv NinteichosaIraiDiv
     * @return ResponseData
     */
    public ResponseData onClick_btnWaritsukeKakutei(NinteichosaIraiDiv requestDiv) {
        NinteichosaIraiHandler handler = getHandler(requestDiv);
        handler.set認定調査依頼情報();
        handler.set手動割付時使用可否(false);
        handler.clear認定調査依頼登録パネル();
        handler.clearチェック();
        handler.set認定調査自動割付ボタン();
        return ResponseData.of(requestDiv).setState(DBE2010001StateName.登録);
    }

    /**
     * 「割付けせずに戻る」ボタンクリックイベントです。
     *
     * @param requestDiv NinteichosaIraiDiv
     * @return ResponseData
     */
    public ResponseData onClick_btnWaritukenaideModoru(NinteichosaIraiDiv requestDiv) {
        NinteichosaIraiHandler handler = getHandler(requestDiv);
        handler.set手動割付時使用可否(false);
        handler.clear認定調査依頼登録パネル();
        handler.clearチェック();
        handler.set認定調査自動割付ボタン();
        return ResponseData.of(requestDiv).setState(DBE2010001StateName.登録);
    }

    /**
     * 「依頼書等を印刷する」ボタンを押下する場合、依頼書/認定調査票（OCR用紙）/主治医意見書印刷画面へ遷移する前に処理を実行します。
     *
     * @param requestDiv 完了処理・認定調査依頼Div
     * @return レスポンス
     */
    public ResponseData onBefore_btnTaOutput(NinteichosaIraiDiv requestDiv) {
        ValidationMessageControlPairs vallidation = getValidationHandler(requestDiv).入力チェック_btnTaOutput();
        if (vallidation.iterator().hasNext()) {
            return ResponseData.of(requestDiv).addValidationMessages(vallidation).respond();
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
        model.set市町村コード(requestDiv.getCcdHokenshaList().getSelectedItem().get市町村コード());
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
     * 対象者一覧データグリッドの取消ボタンクリックイベントです。
     *
     * @param requestDiv 完了処理・認定調査依頼Div
     * @return レスポンス
     */
    public ResponseData onClick_btnCancel(NinteichosaIraiDiv requestDiv) {
        getHandler(requestDiv).cancel割付け();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「調査依頼を保存する」ボタンクリックイベントです。
     *
     * @param requestDiv 完了処理・認定調査依頼Div
     * @return レスポンス
     */
    public ResponseData onClick_btnUpdate(NinteichosaIraiDiv requestDiv) {
        List<dgNinteiTaskList_Row> ModifyList = new ArrayList<>();
        ValidationMessageControlPairs vallidation = getValidationHandler(requestDiv).入力チェック_btnUpdate();
        if (vallidation.iterator().hasNext()) {
            return ResponseData.of(requestDiv).addValidationMessages(vallidation).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(requestDiv).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            NinteichosaIraiManager manager = NinteichosaIraiManager.createInstance();
            NinteiShinseiJohoManager ninteiShinseiJohoManager = NinteiShinseiJohoManager.createInstance();
            NinteichosaIraiJohoManager ninteichosaIraiJohoManager = NinteichosaIraiJohoManager.createInstance();
            NinteichosahyoGaikyoChosaManager ninteichosahyoGaikyoChosaManager = NinteichosahyoGaikyoChosaManager.createInstance();

            for (dgNinteiTaskList_Row row : requestDiv.getDgNinteiTaskList().getDataSource()) {
                RString 状態 = new RString(row.getRowState().toString());
                if (状態.equals(修正)) {
                    ModifyList.add(row);
                }
            }

            for (dgNinteiTaskList_Row row : ModifyList) {
                ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(row.getShinseishoKanriNo());
                RString 認定調査依頼履歴番号 = row.getNinteichosaIraiRirekiNo();
                Code 厚労省IF識別コード = new Code(row.getKoroshoIfShikibetsuCode());
                JigyoshaNo 認定調査委託先コード = new JigyoshaNo(row.getKonkaiChosaItakusakiCode());
                RString 認定調査員コード = row.getKonkaiChosainCode();
                RString 認定調査依頼区分コード = row.getChosaIraiKubunCode();
                List<NinteichosahyoGaikyoChosa> 認定調査票概況調査 = ninteichosahyoGaikyoChosaManager.get認定調査票_概況調査_子(申請書管理番号);
                Code 調査区分コード = (認定調査票概況調査.isEmpty())
                        ? ChosaKubun.新規調査.asCode()
                        : ChosaKubun.再調査.asCode();
                FlexibleDate 認定調査依頼年月日 = FlexibleDate.EMPTY;
                if (row.getNinteichosaIraiYmd().getValue() != null) {
                    認定調査依頼年月日 = new FlexibleDate(row.getNinteichosaIraiYmd().getValue().toDateString());
                }
                FlexibleDate 認定調査期限年月日 = FlexibleDate.EMPTY;
                if (row.getChosaIraiKigen().getValue() != null) {
                    認定調査期限年月日 = new FlexibleDate(row.getChosaIraiKigen().getValue().toDateString());
                }

                NinteichosaIraiParameter parameter = NinteichosaIraiParameter.createParameterBy申請書管理番号(申請書管理番号.value());
                NinteiShinseiJoho 認定調査依頼情報 = manager.get更新用認定調査依頼情報(parameter);
                認定調査依頼情報 = 認定調査依頼情報.createBuilderForEdit()
                        .set調査区分(調査区分コード)
                        .set認定調査委託先コード(new ChosaItakusakiCode(認定調査委託先コード.value()))
                        .set認定調査員コード(new ChosainCode(認定調査員コード))
                        .build().modifiedModel();
                ninteiShinseiJohoManager.save(認定調査依頼情報);

                if (RString.isNullOrEmpty(認定調査依頼履歴番号) || 認定調査依頼情報.getNinteichosaIraiJohoList().isEmpty()) {
                    NinteichosaIraiJoho 更新用認定調査依頼情報 = new NinteichosaIraiJoho(申請書管理番号, 1);
                    更新用認定調査依頼情報 = 更新用認定調査依頼情報.createBuilderForEdit()
                            .set厚労省IF識別コード(厚労省IF識別コード)
                            .set認定調査委託先コード(認定調査委託先コード)
                            .set認定調査員コード(認定調査員コード)
                            .set認定調査依頼区分コード(new Code(認定調査依頼区分コード))
                            .set認定調査回数(1)
                            .set認定調査依頼年月日(認定調査依頼年月日)
                            .set認定調査期限年月日(認定調査期限年月日)
                            .set論理削除フラグ(false)
                            .set認定調査督促年月日(FlexibleDate.EMPTY)
                            .set認定調査督促メモ(RString.EMPTY)
                            .build();
                    ninteichosaIraiJohoManager.save認定調査依頼情報(更新用認定調査依頼情報);
                } else {
                    NinteichosaIraiJohoIdentifier ninteichosaIraiJohoIdentifier
                            = new NinteichosaIraiJohoIdentifier(申請書管理番号, Integer.parseInt(認定調査依頼履歴番号.toString()));
                    NinteichosaIraiJoho 処理用認定調査依頼情報 = 認定調査依頼情報.getNinteichosaIraiJoho(ninteichosaIraiJohoIdentifier);

                    update認定調査依頼情報(処理用認定調査依頼情報,
                            ninteichosaIraiJohoManager);

                    insert認定調査依頼情報(申請書管理番号,
                            厚労省IF識別コード,
                            認定調査委託先コード,
                            認定調査員コード,
                            認定調査依頼区分コード,
                            認定調査依頼年月日,
                            認定調査期限年月日,
                            認定調査依頼履歴番号,
                            ninteichosaIraiJohoManager);
                }
            }

            if (!(new RString(UrInformationMessages.保存終了.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode()))) {
                return ResponseData.of(requestDiv).addMessage(UrInformationMessages.保存終了.getMessage()).respond();
            }

        }
        if (new RString(UrInformationMessages.保存終了.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())) {
            List<dgNinteiTaskList_Row> dataSource = new ArrayList<>();
            requestDiv.getDgNinteiTaskList().setDataSource(dataSource);
            getHandler(requestDiv).initDataGrid();
            ViewStateHolder.put(ViewStateKeys.状態, requestDiv.getRadShoriJyotai().getSelectedKey());
            return ResponseData.of(requestDiv).setState(DBE2010001StateName.登録);
        }
        return ResponseData.of(requestDiv).respond();
    }

    private void insert認定調査依頼情報(ShinseishoKanriNo 申請書管理番号,
            Code 厚労省IF識別コード,
            JigyoshaNo 認定調査委託先コード,
            RString 認定調査員コード,
            RString 認定調査依頼区分コード,
            FlexibleDate 認定調査依頼年月日,
            FlexibleDate 認定調査期限年月日,
            RString 認定調査依頼履歴番号,
            NinteichosaIraiJohoManager ninteichosaIraiJohoManager
    ) throws NumberFormatException, NullPointerException, IllegalArgumentException {
        NinteichosaIraiJoho 更新用認定調査依頼情報 = new NinteichosaIraiJoho(申請書管理番号, 認定調査依頼履歴番号.toInt() + 1);
        更新用認定調査依頼情報 = 更新用認定調査依頼情報.createBuilderForEdit()
                .set厚労省IF識別コード(厚労省IF識別コード)
                .set認定調査委託先コード(認定調査委託先コード)
                .set認定調査員コード(認定調査員コード)
                .set認定調査依頼区分コード(new Code(認定調査依頼区分コード))
                .set認定調査回数(1)
                .set認定調査依頼年月日(認定調査依頼年月日)
                .set認定調査期限年月日(認定調査期限年月日)
                .set論理削除フラグ(false)
                .build();

        if (RString.isNullOrEmpty(更新用認定調査依頼情報.get認定調査督促メモ())) {
            更新用認定調査依頼情報 = 更新用認定調査依頼情報.createBuilderForEdit().set認定調査督促メモ(RString.EMPTY).build();
        }
        if (更新用認定調査依頼情報.get認定調査督促年月日() == null) {
            更新用認定調査依頼情報 = 更新用認定調査依頼情報.createBuilderForEdit().set認定調査督促年月日(FlexibleDate.EMPTY).build();
        }
        if (更新用認定調査依頼情報.get認定調査回数() == 0) {
            更新用認定調査依頼情報 = 更新用認定調査依頼情報.createBuilderForEdit()
                    .set認定調査回数(Integer.parseInt(認定調査依頼履歴番号.toString()) + 1).build();
        }
        ninteichosaIraiJohoManager.save認定調査依頼情報(更新用認定調査依頼情報);
    }

    private void update認定調査依頼情報(NinteichosaIraiJoho 処理用認定調査依頼情報, NinteichosaIraiJohoManager ninteichosaIraiJohoManager) {
        NinteichosaIraiJoho 更新用認定調査依頼情報 = 処理用認定調査依頼情報.createBuilderForEdit()
                .set論理削除フラグ(true)
                .build();
        ninteichosaIraiJohoManager.save認定調査依頼情報(更新用認定調査依頼情報.modifiedModel());
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
            QuestionMessage message = new QuestionMessage(DbeQuestionMessages.完了日登録確認.getMessage().getCode(),
                    DbeQuestionMessages.完了日登録確認.getMessage().replace("認定調査依頼").evaluate());
            return ResponseData.of(requestDiv).addMessage(message).respond();
        }
        if (new RString(DbeQuestionMessages.完了日登録確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            要介護認定完了情報更新(requestDiv.getDgNinteiTaskList().getSelectedItems());
            requestDiv.getCcdKanryoMsg().setMessage(
                    new RString("基本運用・認定調査依頼の保存処理が完了しました。"),
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
     * 保険者リスト共有子Div変更時の動作です。
     *
     * @param requestDiv NinteichosaIraiDiv
     * @return ResponseData
     */
    public ResponseData onChange_ccdHokenshaList(NinteichosaIraiDiv requestDiv) {
        getHandler(requestDiv).initDataGrid();
        return ResponseData.of(requestDiv).respond();
    }

    private NinteichosaIraiItiranCsvEntity getCsvData(dgNinteiTaskList_Row row) {
        NinteichosaIraiItiranCsvEntity data = new NinteichosaIraiItiranCsvEntity(
                row.getJotai(),
                row.getShinseishoKanriNo(),
                row.getHokensha(),
                row.getNinteiShinseiDay().getValue() != null
                ? row.getNinteiShinseiDay().getValue().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString() : RString.EMPTY,
                row.getHihoNumber(),
                row.getHihoShimei(),
                get申請区分_申請時_コード(row.getShinseiKubunShinseiji()),
                row.getShinseiKubunShinseiji(),
                row.getChosaIraiSaichosaCount() != null ? new RString(row.getChosaIraiSaichosaCount().getValue().toString()) : RString.EMPTY,
                row.getChosaIraishoHakkoDay().getValue() != null
                ? row.getChosaIraishoHakkoDay().getValue().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString() : RString.EMPTY,
                row.getChousahyoOutput().getValue() != null
                ? row.getChousahyoOutput().getValue().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString() : RString.EMPTY,
                row.getChosaIraiDataShutsuryokuDay().getValue() != null
                ? row.getChosaIraiDataShutsuryokuDay().getValue().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString() : RString.EMPTY,
                row.getChosaIraiKigen().getValue() != null
                ? row.getChosaIraiKigen().getValue().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString() : RString.EMPTY,
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
                ? row.getChosaTokusokuHakkoDay().getValue().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString() : RString.EMPTY,
                row.getChosaTokusokuHoho(),
                row.getChosaTokusokuCount() != null ? new RString(row.getChosaTokusokuCount().getValue().toString()) : RString.EMPTY,
                row.getChosaIraiKigen().getValue() != null
                ? row.getChosaIraiKigen().getValue().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString() : RString.EMPTY,
                row.getChikuCode(),
                row.getChosaTokusokuChiku(),
                row.getShichosonName());
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
                validationMessage = getValidationHandler(requestDiv).認定調査委託先情報件数チェック(認定調査委託先情報件数);
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

    private boolean is自動割付可能(NinteichosaIraiDiv requestDiv) {
        List<dgNinteiTaskList_Row> selectedItems = requestDiv.getDgNinteiTaskList().getSelectedItems();
        List<NinteichosaItakusakiJohoRelate> 認定調査委託先And調査員情報リスト = NinteichosaIraiManager.createInstance()
                .get認定調査委託先And調査員情報リスト(selectedItems.get(0).getGetShoKisaiHokenshaNo(), selectedItems.get(0).getChikuCode());
        int 調査員情報Index = 0;
        NinteichosaItakusakiJohoRelate 認定調査委託先And調査員情報 = 認定調査委託先And調査員情報リスト.get(調査員情報Index);
        int 調査可能人数_月 = 認定調査委託先And調査員情報.getChosainJoho().get調査可能人数_月();
        for (int 要割付人数 = selectedItems.size(); 要割付人数 > 0; 要割付人数--) {
            if (調査可能人数_月 == 0) {
                for (int index = 調査員情報Index + 1; index < 認定調査委託先And調査員情報リスト.size(); index++) {
                    調査員情報Index = index;
                    if (認定調査委託先And調査員情報リスト.get(index).getChosainJoho().get調査可能人数_月() > 0) {
                        認定調査委託先And調査員情報 = 認定調査委託先And調査員情報リスト.get(index);
                        調査可能人数_月 = 認定調査委託先And調査員情報.getChosainJoho().get調査可能人数_月();
                        break;
                    }
                }
                if (調査員情報Index >= 認定調査委託先And調査員情報リスト.size()) {
                    return false;
                }
            }
            調査可能人数_月 = 調査可能人数_月 - 1;
        }
        return true;
    }

    private void 調査機関自動割付処理(NinteichosaIraiDiv requestDiv) {
        NinteichosaIraiHandler handler = getHandler(requestDiv);
        List<dgNinteiTaskList_Row> selectedItems = requestDiv.getDgNinteiTaskList().getSelectedItems();
        NinteichosaIraiManager manager = NinteichosaIraiManager.createInstance();
        List<NinteichosaItakusakiJohoRelate> 認定調査委託先And調査員情報リスト
                = manager.get認定調査委託先And調査員情報リスト(selectedItems.get(0).getGetShoKisaiHokenshaNo(), selectedItems.get(0).getChikuCode());
        int 調査員情報Index = 0;
        NinteichosaItakusakiJohoRelate 認定調査委託先And調査員情報 = 認定調査委託先And調査員情報リスト.get(調査員情報Index);
        int 調査可能人数_月 = 認定調査委託先And調査員情報.getChosainJoho().get調査可能人数_月();
        for (dgNinteiTaskList_Row row : selectedItems) {
            if (調査可能人数_月 == 0) {
                for (int index = 調査員情報Index + 1; index < 認定調査委託先And調査員情報リスト.size(); index++) {
                    調査員情報Index = index;
                    if (認定調査委託先And調査員情報リスト.get(index).getChosainJoho().get調査可能人数_月() > 0) {
                        認定調査委託先And調査員情報 = 認定調査委託先And調査員情報リスト.get(index);
                        調査可能人数_月 = 認定調査委託先And調査員情報.getChosainJoho().get調査可能人数_月();
                        break;
                    }
                }
            }
            int 認定調査依頼履歴番号 = manager.getMax認定調査依頼履歴番号(row.getShinseishoKanriNo());
            handler.set認定調査依頼情報(row, 認定調査委託先And調査員情報, 認定調査依頼履歴番号 + 1);
            調査可能人数_月 = 調査可能人数_月 - 1;
        }
    }

    private RString get申請区分_申請時_コード(RString 名称) {
        for (NinteiShinseiShinseijiKubunCode kubunCode : NinteiShinseiShinseijiKubunCode.values()) {
            if (kubunCode.get名称().equals(名称)) {
                return kubunCode.getコード();
            }
        }
        return RString.EMPTY;
    }

    private RString getモバイルデータ出力ファイル付加名称(List<dgNinteiTaskList_Row> rowList) {
        RString ファイル付加名称 = rowList.get(0).getKonkaiChosainCode();
        for (dgNinteiTaskList_Row row : rowList) {
            if (row.getKonkaiChosainCode().isEmpty() || !ファイル付加名称.equals(row.getKonkaiChosainCode())) {
                return row.getKonkaiChosaItakusakiCode();
            }
        }
        return ファイル付加名称;
    }

    private NinteichosaIraiHandler getHandler(NinteichosaIraiDiv div) {
        return new NinteichosaIraiHandler(div);
    }

    private NinteichosaIraiValidationHandler getValidationHandler(NinteichosaIraiDiv div) {
        return new NinteichosaIraiValidationHandler(div);
    }
}
