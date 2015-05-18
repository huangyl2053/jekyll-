/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import jp.co.ndensan.reams.db.dbb.business.FukaErrorInternalReport;
import jp.co.ndensan.reams.db.dbb.business.FukaErrorInternalReportItem;
import jp.co.ndensan.reams.db.dbb.business.FukaErrorInternalReportItemList;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.messagemapping.FukaErrorValidationMessageMapping;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0020002.FukaErrorReportViewDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0020002.FukaErrorShoriButtonDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0020002.dgFukaErrorList_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.mapper.FukaErrorGridMapper;
import jp.co.ndensan.reams.db.dbb.realservice.FukaErrorInternalReportService;
import jp.co.ndensan.reams.db.dbb.realservice.FukaErrorInternalReportItemValidationService;
import jp.co.ndensan.reams.db.dbb.realservice.report.FukaErrorListPrinter;
import jp.co.ndensan.reams.ur.urz.business.internalreport.IInternalReport;
import jp.co.ndensan.reams.ur.urz.business.internalreport.InternalReportConverterFactory;
import jp.co.ndensan.reams.ur.urz.business.internalreport.IInternalReportCsvConverter;
import jp.co.ndensan.reams.ur.urz.business.internalreport.IInternalReportCommon;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.IInternalReportKihonDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationHelper;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessages;
//import jp.co.ndensan.reams.ua.uax.model.validations.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.report.IReportPublishable;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;

/**
 * 賦課エラー修正画面の、エラー一覧を表示するパネルについての処理を行うクラスです。
 *
 * @author n8178 城間篤人
 */
public class FukaErrorReportView {

    private static final SubGyomuCode サブ業務コード;

    static {
        サブ業務コード = SubGyomuCode.DBB介護賦課;
    }

    /**
     * 画面の読み込み時に実行されるイベントです。<br/>
     * 賦課エラー一覧の、最新のリスト作成日時に対応する情報を、画面上に表示します。<br/>
     * また、次処理への遷移ボタンを、グリッドの1行目に表示されているエラー内容に合わせて表示します。
     *
     * @param div 賦課エラー一覧Div
     * @return 賦課エラー一覧Divを持つResponseData
     */
    public ResponseData onLoad(FukaErrorReportViewDiv div) {
        IInternalReportKihonDiv kihonDiv = div.getCcdFukaErrorCommon();

        FukaErrorInternalReport report = new FukaErrorInternalReportService().getFukaErrorInternalReport();
        kihonDiv.setKihonDataAndCreationDateTime(report);

        div.getDgFukaErrorList().setDataSource(FukaErrorGridMapper.toFukaErrorListGrid(report.get賦課エラーList()));
        div.getFukaErrorShoriButton().setDisabled(true);

        return _createResponseData(div);
    }

    /**
     * リスト作成日時DDLが選択している項目が変更された際に実行されるイベントです。<br/>
     * 選択した作成日時に合わせて賦おｎCh課エラー一覧のデータを取得し、グリッド上に表示しなおします。
     *
     * @param div 賦課エラー一覧Div
     * @return 賦課エラー一覧Divを持つResponseData
     */
    public ResponseData onChangeToDdlCreationDateTiem(FukaErrorReportViewDiv div) {
        IInternalReportKihonDiv kihonDiv = div.getCcdFukaErrorCommon();
        RDateTime creationDateTime = kihonDiv.getSelectedListCreationDateTime();

        FukaErrorInternalReport report = new FukaErrorInternalReportService().getFukaErrorInternalReport(creationDateTime);
        kihonDiv.setKihonData(report);
        div.getDgFukaErrorList().setDataSource(FukaErrorGridMapper.toFukaErrorListGrid(report.get賦課エラーList()));

        return _createResponseData(div);
    }

    /**
     * CSVダウンロードボタンをクリックした際に実行されるイベントです。<br/>
     * 現在賦課エラー一覧グリッドに表示されている情報をCSV化してダウンロードします。
     *
     * @param div 賦課エラー一覧Div
     * @param response IDownLoadServletResponse。ダウンロード処理の際、引数の最後にもたせる必要がある。
     * @return ダウンロードするCsvファイルの、ファイル名とByteデータを持つReponseData
     */
    //TODO n8178 城間篤人 uzのリリースが完了するまで、IDownLoadServletResponseが使用不可。リリース後コメントアウトをはずす 2014年10月末
    public IDownLoadServletResponse onClick_btnCsvDownload(FukaErrorReportViewDiv div, IDownLoadServletResponse response) {
        IInternalReportKihonDiv kihonDiv = div.getCcdFukaErrorCommon();

        IInternalReportCommon reportCommon = kihonDiv.getInternalReportCommon();
        FukaErrorInternalReportItemList reportItem = FukaErrorGridMapper.toFukaErrorReportItemList(div.getDgFukaErrorList().getDataSource());
        IInternalReport internalReport = new FukaErrorInternalReport(reportCommon, reportItem);

//        IInternalReportCsvConverter converter = InternalReportConverterFactory.createCsvConvertor(サブ業務コード);
        //createCsvConvertor の引数がなくなったため、修正
        IInternalReportCsvConverter converter = InternalReportConverterFactory.createCsvConvertor();

        byte[] csvByteData = converter.convertCsvByteData(internalReport);

        response.writeData(csvByteData);
        response.setFileName(converter.getFileName(internalReport));
        return response;
    }

    /**
     * 賦課エラー一覧グリッドから、1行選択した際に実行されるイベントです。<br/>
     * 選択した行のエラー内容に合わせて、修正処理へ遷移するボタンの表示非表示を切り替え、遷移可能な状態に切り替えます。
     *
     * @param div 賦課エラー一覧Div
     * @return 賦課エラー一覧Divを持つResponseData
     */
    public ResponseData onSelect_dgFukaErrorList(FukaErrorReportViewDiv div) {

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
            default:
                setButtonDisplayNone(buttonDiv);
                break;

        }

        div.getFukaErrorShoriButton().setDisabled(false);
        return _createResponseData(div);
    }

    private void setButtonDisplayNone(FukaErrorShoriButtonDiv buttonDiv) {
        buttonDiv.getBtnFukaKosei().setDisplayNone(true);
        buttonDiv.getBtnShikakuFuseigo().setDisplayNone(true);
    }

    /**
     * 資格不整合処理へ遷移するボタンをクリックした際、onClickEvent前に実行されるバリデーションチェックイベントです。
     *
     * @param div 賦課エラー一覧Div
     * @return 賦課エラー一覧Divを持つResponseData
     */
    public ResponseData onBeforeClick_btnShikakuFuseigo(FukaErrorReportViewDiv div) {
        ResponseData<FukaErrorReportViewDiv> response = new ResponseData<>();
        IValidationMessages validationMessages = validate(div);
        ValidationHelper.appendMessages(response, validationMessages, FukaErrorValidationMessageMapping.class);
        response.data = div;
        return response;
    }

    private IValidationMessages validate(FukaErrorReportViewDiv div) {
        dgFukaErrorList_Row row = div.getDgFukaErrorList().getSelectedItems().get(0);
        FukaErrorInternalReportItem item = FukaErrorGridMapper.toFukaErrorReportItem(row);

        FukaErrorInternalReportItemValidationService service = new FukaErrorInternalReportItemValidationService(item);
        return (IValidationMessages) service.validate();
    }

    /**
     * 資格不整合処理へ遷移するボタンをクリックした際に実行されるイベントです。
     *
     * @param div 賦課エラー一覧Div
     * @return 賦課エラー一覧Divを持つResponseData
     */
    public ResponseData onClick_btnShikakuFuseigo(FukaErrorReportViewDiv div) {
        //TODO n8178 城間篤人 画面遷移先に渡すデータなどの設定を行う。遷移先の画面ができてから実装を予定 2014年11月
        return _createResponseData(div);
    }

    /**
     * 資格不整合処理へ遷移するボタンをクリックした際、onClickEvent前に実行されるバリデーションチェックイベントです。
     *
     * @param div 賦課エラー一覧Div
     * @return 賦課エラー一覧Divを持つResponseData
     */
    public ResponseData onBeforeClick_btnFukaKosei(FukaErrorReportViewDiv div) {
        ResponseData<FukaErrorReportViewDiv> response = new ResponseData<>();
        IValidationMessages validationMessages = validate(div);
        ValidationHelper.appendMessages(response, validationMessages, FukaErrorValidationMessageMapping.class);
        response.data = div;
        return response;
    }

    /**
     * 資格不整合処理へ遷移するボタンをクリックした際に実行されるイベントです。
     *
     * @param div 賦課エラー一覧Div
     * @return 賦課エラー一覧Divを持つResponseData
     */
    public ResponseData onClick_btnFukaKosei(FukaErrorReportViewDiv div) {
        //TODO n8178 城間篤人 画面遷移先に渡すデータなどの設定を行う。遷移先の画面ができてから実装を予定 2014年11月
        return _createResponseData(div);
    }

    /**
     * 発行ボタンがクリックされた際に実行されるイベントです。<br/>
     * グリッド上に表示されている内部帳票の情報を、印刷可能なソースデータに変換してプレビュー画面に引き渡します。
     *
     * @param div 賦課エラー一覧パネル
     * @return 印刷可能なソースデータを持つResponseData
     */
    public ResponseData<SourceDataCollection> onClick_btnReportPublish(FukaErrorReportViewDiv div) {
        return new FukaErrorListPublisher().publish(div);
    }

    private static final class FukaErrorListPublisher implements IReportPublishable<FukaErrorReportViewDiv> {

        @Override
        public ResponseData<SourceDataCollection> publish(FukaErrorReportViewDiv div) {

            FukaErrorListPrinter printer = new FukaErrorListPrinter();
            IInternalReportKihonDiv kihonDiv = div.getCcdFukaErrorCommon();

            IInternalReportCommon reportCommon = kihonDiv.getInternalReportCommon();
            FukaErrorInternalReportItemList reportItemList = FukaErrorGridMapper.toFukaErrorReportItemList(div.getDgFukaErrorList().getDataSource());
            FukaErrorInternalReport report = new FukaErrorInternalReport(reportCommon, reportItemList);

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
