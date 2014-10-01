/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.FukaErrorReport;
import jp.co.ndensan.reams.db.dbb.business.FukaErrorReportItem;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0020002.FukaErrorReportViewDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0020002.FukaErrorShoriButtonDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0020002.dgFukaErrorList_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.mapper.FukaErrorGridMapper;
import jp.co.ndensan.reams.db.dbb.realservice.FukaErrorReportService;
import jp.co.ndensan.reams.db.dbb.realservice.report.FukaErrorListPrinter;
import jp.co.ndensan.reams.ur.urz.business.internalreport.IInternalReport;
import jp.co.ndensan.reams.ur.urz.business.internalreport.InternalReportBatchInfo;
import jp.co.ndensan.reams.ur.urz.business.internalreport.InternalReportConverterFactory;
import jp.co.ndensan.reams.ur.urz.business.internalreport.InternalReportCsvConverter;
import jp.co.ndensan.reams.ur.urz.business.internalreport.InternalReportInfo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.divcontroller.controller.InternalReportKihon;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.InternalReportKihonDiv;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.report.IReportPublishable;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;

/**
 * 賦課エラー修正画面の、エラー一覧を表示するパネルについての処理を行うクラスです。
 *
 * @author n8178 城間篤人
 */
public class FukaErrorReportView {

    private static final SubGyomuCode サブ業務コード;
    private static final RString 内部帳票ID;

    static {
        サブ業務コード = SubGyomuCode.DBB介護賦課;
        内部帳票ID = new RString("FukaErrorList");
    }

    /**
     * 画面の読み込み時に実行されるイベントです。<br/>
     * 賦課エラー一覧の、最新のリスト作成日時に対応する情報を、画面上に表示します。<br/>
     * また、次処理への遷移ボタンを、グリッドの1行目に表示されているエラー内容に合わせて表示します。
     *
     * @param div 賦課エラー一覧Div
     * @return ResponseData
     */
    public ResponseData onLoad(FukaErrorReportViewDiv div) {
        ResponseData<FukaErrorReportViewDiv> response = new ResponseData<>();
        InternalReportKihonDiv kihonDiv = div.getCcdFukaErrorCommon();

        InternalReportKihon.setInternalReportKihonData(kihonDiv, サブ業務コード, 内部帳票ID);
        RDateTime creationDateTime = InternalReportKihon.getSelectedListCreationDateTime(kihonDiv);

        FukaErrorReport report = new FukaErrorReportService().getFukaErrorReport(creationDateTime);
        div.getDgFukaErrorList().setDataSource(FukaErrorGridMapper.toFukaErrorListGrid(report.getItemList()));

        response.data = div;
        return response;
    }

    /**
     * リスト作成日時DDLが選択している項目が変更された際に実行されるイベントです。<br/>
     * 選択した作成日時に合わせて賦課エラー一覧のデータを取得し、グリッド上に表示しなおします。
     *
     * @param div 賦課エラー一覧Div
     * @return ResponseData
     */
    public ResponseData onChangeToDdlCreationDateTiem(FukaErrorReportViewDiv div) {
        ResponseData<FukaErrorReportViewDiv> response = new ResponseData<>();
        InternalReportKihonDiv kihonDiv = div.getCcdFukaErrorCommon();
        RDateTime creationDateTime = InternalReportKihon.getSelectedListCreationDateTime(kihonDiv);

        FukaErrorReport report = new FukaErrorReportService().getFukaErrorReport(creationDateTime);
        div.getDgFukaErrorList().setDataSource(FukaErrorGridMapper.toFukaErrorListGrid(report.getItemList()));

        response.data = div;
        return response;
    }

    /**
     * CSVダウンロードボタンをクリックした際に実行されるイベントです。<br/>
     * 現在賦課エラー一覧グリッドに表示されている情報をCSV化してダウンロードします。
     *
     * @param div 賦課エラー一覧パネル
     * @return FileData
     */
    public IDownLoadServletResponse onClick_btnCsvDownload(FukaErrorReportViewDiv div, IDownLoadServletResponse response) {
//        FileData response = new FileData();
        InternalReportKihonDiv kihonDiv = div.getCcdFukaErrorCommon();

        InternalReportInfo reportInfo = InternalReportKihon.getInternalReportInfo(kihonDiv);
        InternalReportBatchInfo batchInfo = InternalReportKihon.getInternalReportBatchInfo(kihonDiv);
        List<FukaErrorReportItem> reportItem = FukaErrorGridMapper.toFukaErrorReportItemList(div.getDgFukaErrorList().getDataSource());
        IInternalReport internalReport = new FukaErrorReport(サブ業務コード, reportInfo, batchInfo, reportItem);

        InternalReportCsvConverter converter = InternalReportConverterFactory.createCsvConvertor(サブ業務コード);
        byte[] csvByteData = converter.convertCsvByteData(internalReport);

        response.writeData(csvByteData);
        response.setFileName(converter.getFileName(internalReport));
        return response;
    }

    /**
     * 賦課エラー一覧グリッドから、1行選択した際に実行されるイベントです。<br/>
     * 選択した行のエラー内容に合わせて、修正処理へ遷移するボタンの表示非表示を切り替えます。
     *
     * @param div 賦課エラー一覧パネル
     * @return ResponseData
     */
    public ResponseData onSelect_dgFukaErrorList(FukaErrorReportViewDiv div) {
        ResponseData<FukaErrorReportViewDiv> response = new ResponseData<>();

        FukaErrorShoriButtonDiv buttonDiv = div.getFukaErrorShoriButton();
        setButtonDisplayNone(buttonDiv);
        dgFukaErrorList_Row row = div.getDgFukaErrorList().getSelectedItems().get(0);
        switch (row.getErrorCode().toString()) {
            case "01":
                buttonDiv.getBtnFukaKosei().setDisplayNone(false);
                break;
            case "02":
                buttonDiv.getBtnShikakuFuseigo().setDisplayNone(false);
                break;
        }

        response.data = div;
        return response;
    }

    private void setButtonDisplayNone(FukaErrorShoriButtonDiv buttonDiv) {
        buttonDiv.getBtnFukaKosei().setDisplayNone(true);
        buttonDiv.getBtnShikakuFuseigo().setDisplayNone(true);
    }

    /**
     * 資格不整合処理へ遷移するボタンをクリックした際、onClickEvent前に実行されるバリデーションチェックイベントです。<br/>
     *
     * @param div 賦課エラー一覧パネル
     * @return ResponseData
     */
    public ResponseData onBeforeClick_btnShikakuFuseigo(FukaErrorReportViewDiv div) {
        ResponseData<FukaErrorReportViewDiv> response = new ResponseData<>();

        if (div.getDgFukaErrorList().getSelectedItems().isEmpty()) {
            response.addValidateMessage(UrErrorMessages.実行不可.getMessage().replace("処理対象が未選択のため、修正処理画面へ移動すること"));
            response.data = div;
            return response;
        }

        dgFukaErrorList_Row row = div.getDgFukaErrorList().getSelectedItems().get(0);
        RYear fukaNendo = row.getFukaNendo().getValue().getYear();
        RString tsuchishoNo = row.getTsuchishoNo();

        FukaErrorReportService service = new FukaErrorReportService();
        if (!service.canErrorShusei(fukaNendo, tsuchishoNo)) {
            response.addValidateMessage(UrErrorMessages.実行不可.getMessage().replace("未処理状態でないため、修正処理画面へ移動すること"));
        }

        response.data = div;
        return response;
    }

    /**
     * 資格不整合処理へ遷移するボタンをクリックした際に実行されるイベントです。<br/>
     *
     * @param div 賦課エラー一覧パネル
     * @return ResponseData
     */
    public ResponseData onClick_btnShikakuFuseigo(FukaErrorReportViewDiv div) {
        ResponseData<FukaErrorReportViewDiv> response = new ResponseData<>();
        //TODO n8178 城間篤人 画面遷移先に渡すデータなどの設定を行う。Model化後に対応したほうがよい？ 2014年10月3日まで
        response.data = div;
        return response;
    }

    /**
     * 資格不整合処理へ遷移するボタンをクリックした際、onClickEvent前に実行されるバリデーションチェックイベントです。<br/>
     *
     * @param div 賦課エラー一覧パネル
     * @return ResponseData
     */
    public ResponseData onBeforeClick_btnFukaKosei(FukaErrorReportViewDiv div) {
        ResponseData<FukaErrorReportViewDiv> response = new ResponseData<>();

        if (div.getDgFukaErrorList().getSelectedItems().isEmpty()) {
            response.addValidateMessage(UrErrorMessages.実行不可.getMessage().replace("処理対象が未選択のため、修正処理画面へ移動すること"));
            response.data = div;
            return response;
        }

        dgFukaErrorList_Row row = div.getDgFukaErrorList().getSelectedItems().get(0);
        RYear fukaNendo = row.getFukaNendo().getValue().getYear();
        RString tsuchishoNo = row.getTsuchishoNo();

        FukaErrorReportService service = new FukaErrorReportService();
        if (!service.canErrorShusei(fukaNendo, tsuchishoNo)) {
            response.addValidateMessage(UrErrorMessages.実行不可.getMessage().replace("選択した処理対象が未処理のものでないため、修正処理画面へ移動すること"));
        }

        response.data = div;
        return response;
    }

    /**
     * 資格不整合処理へ遷移するボタンをクリックした際に実行されるイベントです。<br/>
     *
     * @param div 賦課エラー一覧パネル
     * @return ResponseData
     */
    public ResponseData onClick_btnFukaKosei(FukaErrorReportViewDiv div) {
        ResponseData<FukaErrorReportViewDiv> response = new ResponseData<>();
        //TODO n8178 城間篤人 画面遷移先に渡すデータなどの設定を行う。Model化後に対応したほうがよい？ 2014年10月3日まで
        response.data = div;
        return response;
    }

    /**
     * 発行ボタンがクリックされた際に実行されるイベントです。<br/>
     * グリッド上に表示されている内部帳票の情報を、印刷可能なソースデータに変換してプレビュー画面に引き渡します。
     *
     * @param div 賦課エラー一覧パネル
     * @return ResponseData
     */
    public ResponseData<SourceDataCollection> onClick_btnReportPublish(FukaErrorReportViewDiv div) {
        return new FukaErrorListPublisher().publish(div);
    }

    private static final class FukaErrorListPublisher implements IReportPublishable<FukaErrorReportViewDiv> {

        @Override
        public ResponseData<SourceDataCollection> publish(FukaErrorReportViewDiv div) {
            FukaErrorListPrinter printer = new FukaErrorListPrinter();

            InternalReportInfo info = InternalReportKihon.getInternalReportInfo(div.getCcdFukaErrorCommon());
            InternalReportBatchInfo batchInfo = InternalReportKihon.getInternalReportBatchInfo(div.getCcdFukaErrorCommon());
            List<FukaErrorReportItem> reportItemList = FukaErrorGridMapper.toFukaErrorReportItemList(div.getDgFukaErrorList().getDataSource());
            FukaErrorReport report = new FukaErrorReport(サブ業務コード, info, batchInfo, reportItemList);

            SourceDataCollection sdc = printer.print(report);
            return _createResponseData(sdc);
        }
    }

    private static <T> ResponseData<T> _createResponseData(T setIntoData) {
        ResponseData<T> response = new ResponseData<>();
        response.data = setIntoData;
        return response;
    }

}
