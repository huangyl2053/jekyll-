/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0020002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.FukaErrorList;
import jp.co.ndensan.reams.db.dbb.business.fukaerror.FukaErrorListCsvItem;
import jp.co.ndensan.reams.db.dbb.business.fukaerror.FukaErrorListCsvItemList;
import jp.co.ndensan.reams.db.dbb.business.fukaerror.FukaErrorListCsvReport;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0020002.DBB0020002TransitionEventName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0020002.FukaErrorReportViewDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0020002.FukaErrorReportViewHandler;
import jp.co.ndensan.reams.db.dbb.service.core.fukaerror.FukaErrorListService;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.business.core.internalreportoutput.IInternalReport;
import jp.co.ndensan.reams.ur.urz.business.core.internalreportoutput.IInternalReportCommon;
import jp.co.ndensan.reams.ur.urz.business.core.internalreportoutput.IInternalReportCsvConverter;
import jp.co.ndensan.reams.ur.urz.business.core.internalreportoutput.InternalReportCommon;
import jp.co.ndensan.reams.ur.urz.business.core.internalreportoutput.InternalReportConverterFactory;
import jp.co.ndensan.reams.ur.urz.business.core.internalreportoutput.InternalReportShoriKubun;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.InternalReportKihon.IInternalReportKihonDiv;
import jp.co.ndensan.reams.ur.urz.service.core.internalreportoutput.InternalReportServiceFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;

/**
 * 賦課エラー修正画面の、エラー一覧を表示するパネルについての処理を行うクラスです。
 */
public class FukaErrorReportView {

    private static final RString BATCHID_FUKAERROR = new RString("FukaErrorBatchId");
    private static final RString REPORTID_FUKAERROR = new RString("DBB400001_FukaErrorIchiran");
    // TODO QA502 バッチ起動日時キーは提供しない
    private static final RString BATCHSTARTINGDATETIME = new RString("FukaErrorBatchStartingDateTime");

    /**
     * 画面初期化処理です。
     *
     * @param div 賦課エラー一覧Div
     * @return 賦課エラー一覧Divを持つResponseData
     */
    public ResponseData onLoad(FukaErrorReportViewDiv div) {

        RString batchID = FlowParameterAccessor.get().get(BATCHID_FUKAERROR, RString.class);
        IInternalReportKihonDiv kihonDiv = div.getCcdFukaErrorCommon();
        List<FukaErrorList> リスト作成日時 = FukaErrorListService.createInstance().getCreationDateTimeList(batchID).records();
        if (!リスト作成日時.isEmpty()) {
            RDateTime 最新リスト作成日時 = リスト作成日時.get(0).get内部帳票作成日時();
            InternalReportCommon fukaErrorBaseData = InternalReportCommon.newBuilder()
                    .setSubGyomuCode(SubGyomuCode.DBB介護賦課)
                    .setInternalReportId(REPORTID_FUKAERROR)
                    .setInternalReportCreationDateTime(最新リスト作成日時)
                    .setBatchId(batchID)
                    .setBatchStartingDateTime(FlowParameterAccessor.get().get(BATCHSTARTINGDATETIME, RDateTime.class))
                    .build();
            IInternalReportCommon fukaError = InternalReportServiceFactory.getInternalReportComponentsProvider().
                    createInternalReportCommonForReport(fukaErrorBaseData);

            List<FukaErrorList> 賦課エラー情報 = FukaErrorListService.createInstance().getFukaErrorList(最新リスト作成日時).records();
            kihonDiv.setKihonDataAndCreationDateTime(fukaError);
            createHandler(div).initialize(賦課エラー情報);
        } else {
            createHandler(div).initialize(new ArrayList<FukaErrorList>());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 選択した作成日時に合わせて賦課エラー一覧のデータを取得し、グリッド上に表示しなおします。
     *
     * @param div 賦課エラー一覧Div
     * @return 賦課エラー一覧Divを持つResponseData
     */
    public ResponseData onChange_DdlCreationDateTiem(FukaErrorReportViewDiv div) {
        List<FukaErrorList> 賦課エラー情報 = FukaErrorListService.createInstance().
                getFukaErrorList(div.getCcdFukaErrorCommon().getSelectedListCreationDateTime()).records();
        createHandler(div).initialize(賦課エラー情報);
        return ResponseData.of(div).respond();
    }

    /**
     * 賦課エラー一覧グリッドに表示されている情報をCSV化してダウンロードします。
     *
     * @param div 賦課エラー一覧Div
     * @param response IDownLoadServletResponse。ダウンロード処理の際、引数の最後にもたせる必要がある。
     * @return ダウンロードするCsvファイルの、ファイル名とByteデータを持つReponseData
     */
    public IDownLoadServletResponse onClick_btnCsvDownload(FukaErrorReportViewDiv div, IDownLoadServletResponse response) {
        IInternalReportKihonDiv kihonDiv = div.getCcdFukaErrorCommon();
        IInternalReportCommon reportCommon = kihonDiv.getInternalReportCommon();
        FukaErrorListCsvItemList reportItem = createHandler(div).toFukaErrorReportItemList();
        IInternalReport internalReport = new FukaErrorListCsvReport(reportCommon, reportItem);
        IInternalReportCsvConverter converter = InternalReportConverterFactory.createCsvConvertor();
        List<Byte> csvByteData = converter.convertCsvByteData(internalReport);
        for (Object obj : csvByteData.toArray()) {
            response.writeData(((String) obj).getBytes());
        }
        response.setFileName(converter.getFileName(internalReport));
        return response;
    }

    /**
     * 選択した行のエラー内容に合わせて、修正処理へ遷移するボタンの表示非表示を切り替え、遷移可能な状態に切り替えます。
     *
     * @param div 賦課エラー一覧Div
     * @return 賦課エラー一覧Divを持つResponseData
     */
    public ResponseData onSelect_dgFukaErrorList(FukaErrorReportViewDiv div) {

        createHandler(div).onSelect_dgFukaErrorList();
        return ResponseData.of(div).respond();
    }

    /**
     * 資格不整合処理へ遷移するボタンをクリックした際に実行されるイベントです。
     *
     * @param div 賦課エラー一覧Div
     * @return 賦課エラー一覧Divを持つResponseData
     */
    public ResponseData onClick_btnShikakuFuseigo(FukaErrorReportViewDiv div) {

        FukaErrorList fukaErrorList = ViewStateHolder.get(ViewStateKeys.賦課エラー一覧_賦課エラー情報, FukaErrorList.class);
        if (InternalReportShoriKubun.未処理.getCode().getKey().equals(fukaErrorList.get処理区分コード().value())) {
            return ResponseData.of(div).forwardWithEventName(DBB0020002TransitionEventName.資格不整合修正).
                    parameter(DBB0020002TransitionEventName.資格不整合修正.getName());
        } else {
            FukaErrorListCsvItem item = new FukaErrorListCsvItem(fukaErrorList);
            List<IValidationMessage> validationMessage = item.validate().getList();
            if (!validationMessage.isEmpty()) {
                return ResponseData.of(div).addValidationMessages(setMessage(validationMessage)).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 資格不整合処理へ遷移するボタンをクリックした際に実行されるイベントです。
     *
     * @param div 賦課エラー一覧Div
     * @return 賦課エラー一覧Divを持つResponseData
     */
    public ResponseData onClick_btnFukaKosei(FukaErrorReportViewDiv div) {

        FukaErrorList fukaErrorList = ViewStateHolder.get(ViewStateKeys.賦課エラー一覧_賦課エラー情報, FukaErrorList.class);
        if (InternalReportShoriKubun.未処理.getCode().getKey().equals(fukaErrorList.get処理区分コード().value())) {

            return ResponseData.of(div).forwardWithEventName(DBB0020002TransitionEventName.即時賦課更正).
                    parameter(DBB0020002TransitionEventName.即時賦課更正.getName());
        } else {
            FukaErrorListCsvItem item = new FukaErrorListCsvItem(fukaErrorList);
            List<IValidationMessage> validationMessage = item.validate().getList();
            if (!validationMessage.isEmpty()) {
                return ResponseData.of(div).addValidationMessages(setMessage(validationMessage)).respond();
            }
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 賦課エラー状況を更新します。
     *
     * @param div 賦課エラー一覧パネル
     * @return 賦課エラー一覧Divを持つResponseData
     */
    public ResponseData onClick_btnMishori(FukaErrorReportViewDiv div) {
        FukaErrorList errorList = ViewStateHolder.get(ViewStateKeys.賦課エラー一覧_賦課エラー情報, FukaErrorList.class);
        FukaErrorListService service = FukaErrorListService.createInstance();
        service.saveAs処理済み(errorList);
        createHandler(div).initialize(service.getFukaErrorList(errorList.get内部帳票作成日時()).records());
        return ResponseData.of(div).respond();
    }

    private ValidationMessageControlPairs setMessage(List<IValidationMessage> messages) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        for (IValidationMessage iValidationMessage : messages) {
            validationMessages.add(new ValidationMessageControlPair(iValidationMessage));
        }
        return validationMessages;
    }

    private FukaErrorReportViewHandler createHandler(FukaErrorReportViewDiv div) {
        return new FukaErrorReportViewHandler(div);
    }
}
