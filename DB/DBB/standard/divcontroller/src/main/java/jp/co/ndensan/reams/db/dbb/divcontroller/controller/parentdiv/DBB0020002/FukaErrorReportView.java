/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0020002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.FukaErrorList;
import jp.co.ndensan.reams.db.dbb.business.core.basic.FukaErrorListIdentifier;
import jp.co.ndensan.reams.db.dbb.business.report.fukaerror.FukaErrorListCsvItem;
import jp.co.ndensan.reams.db.dbb.business.report.fukaerror.FukaErrorListCsvItemList;
import jp.co.ndensan.reams.db.dbb.business.report.fukaerror.FukaErrorListCsvReport;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0020002.DBB0020002TransitionEventName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0020002.FukaErrorReportViewDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0020002.dgFukaErrorList_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0020002.FukaErrorReportViewHandler;
import jp.co.ndensan.reams.db.dbb.service.core.fukaerror.FukaErrorListService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.business.core.internalreportoutput.IInternalReport;
import jp.co.ndensan.reams.ur.urz.business.core.internalreportoutput.IInternalReportCommon;
import jp.co.ndensan.reams.ur.urz.business.core.internalreportoutput.InternalReportCommon;
import jp.co.ndensan.reams.ur.urz.business.core.internalreportoutput.InternalReportShoriKubun;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.InternalReportKihon.IInternalReportKihonDiv;
import jp.co.ndensan.reams.ur.urz.service.core.internalreportoutput.InternalReportServiceFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
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
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;

/**
 * 賦課エラー修正画面の、エラー一覧を表示するパネルについての処理を行うクラスです。
 *
 * @reamsid_L DBB-0720-010 zuotao
 */
public class FukaErrorReportView {

    private static final RString BATCHID_FUKAERROR = new RString("FukaErrorBatchId");
    private static final RString REPORTID_FUKAERROR = new RString("DBB400001_FukaErrorIchiran");
    private static final RString BATCHSTARTINGDATETIME = new RString("FukaErrorBatchStartingDateTime");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString CSV_WRITER_LINE = new RString("_");
    private static final RString CSV = new RString(".csv");
    private static final RString DBBMN33004 = new RString("DBBMN33004");
    private static final RString DBBMN34004 = new RString("DBBMN34004");
    private static final RString DBBMN36004 = new RString("DBBMN36004");
    private static final RString DBBMN35006 = new RString("DBBMN35006");
    private static final RString DBBMN43004 = new RString("DBBMN43004");
    private static final RString DBBMN44004 = new RString("DBBMN44004");
    private static final RString DBBMN45004 = new RString("DBBMN45004");
    private static final RString 特徴仮算定賦課 = new RString("特徴仮算定賦課");
    private static final RString 普徴仮算定賦課 = new RString("普徴仮算定賦課");
    private static final RString 仮算定異動賦課 = new RString("仮算定異動賦課");
    private static final RString 特徴平準化計算_8月分 = new RString("特徴平準化計算_8月分");
    private static final RString 本算定賦課 = new RString("本算定賦課");
    private static final RString 異動賦課 = new RString("異動賦課");
    private static final RString 過年度賦課 = new RString("過年度賦課");
    private static final int TWO = 2;
    private static final RString 個人番号_利用有無名称 = new RString("個人番号利用有無");
    private static final RString 法人番号_利用有無名称 = new RString("法人番号利用有無");
    private static final RString 無し = new RString("無し");

    /**
     * 画面初期化処理です。
     *
     * @param div 賦課エラー一覧Div
     * @return 賦課エラー一覧Divを持つResponseData
     */
    public ResponseData onLoad(FukaErrorReportViewDiv div) {
        RString batchID = RString.EMPTY;
        RDateTime 基準日時 = RDateTime.MIN;
        RString menuId = getMenuId();
        if (!RString.isNullOrEmpty(menuId)) {
            ShoriDateKanri shori = FukaErrorListService.createInstance().getFukaBatchID(menuId);
            if (shori != null) {
                batchID = getバッチID変換(shori);
                基準日時 = shori.get基準日時().getRDateTime();
            }
        } else {
            batchID = FlowParameterAccessor.get().get(BATCHID_FUKAERROR, RString.class);
            基準日時 = FlowParameterAccessor.get().get(BATCHSTARTINGDATETIME, RDateTime.class);
        }
        IInternalReportKihonDiv kihonDiv = div.getCcdFukaErrorCommon();
        List<FukaErrorList> リスト作成日時 = FukaErrorListService.createInstance().getCreationDateTimeList(batchID).records();
        if (!リスト作成日時.isEmpty()) {
            RDateTime 最新リスト作成日時 = リスト作成日時.get(0).get内部帳票作成日時();
            InternalReportCommon fukaErrorBaseData = InternalReportCommon.newBuilder()
                    .setSubGyomuCode(SubGyomuCode.DBB介護賦課)
                    .setInternalReportId(REPORTID_FUKAERROR)
                    .setInternalReportCreationDateTime(最新リスト作成日時)
                    .setBatchId(batchID)
                    .setBatchStartingDateTime(基準日時)
                    .build();
            IInternalReportCommon fukaError = InternalReportServiceFactory.getInternalReportComponentsProvider().
                    createInternalReportCommonForReport(fukaErrorBaseData);

            List<FukaErrorList> 賦課エラー情報 = FukaErrorListService.createInstance().getFukaErrorList(最新リスト作成日時).records();
            kihonDiv.setKihonDataAndCreationDateTime(fukaError);
            createHandler(div).initialize(賦課エラー情報);
            ViewStateHolder.put(ViewStateKeys.賦課エラー一覧, Models.create(賦課エラー情報));
            List<PersonalData> personalDataList = new ArrayList<>();
            for (FukaErrorList errorList : 賦課エラー情報) {
                personalDataList.add(toPersonalData(errorList.get識別コード()));
            }
            AccessLogger.log(AccessLogType.照会, personalDataList);
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
        ViewStateHolder.put(ViewStateKeys.賦課エラー一覧, Models.create(賦課エラー情報));
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
        IInternalReportCommon reportCommon = div.getCcdFukaErrorCommon().getInternalReportCommon();
        FukaErrorListCsvItemList reportItem = createHandler(div).toFukaErrorReportItemList();
        IInternalReport internalReport = new FukaErrorListCsvReport(reportCommon, reportItem);
        RDateTime dateTime = internalReport.get内部帳票作成日時();
        RString dateString = dateTime.getDate().seireki().separator(Separator.HYPHEN).toDateString();
        RString timeString = createTimeString(dateTime.getTime());
        RStringBuilder fileName = new RStringBuilder();
        fileName.append(internalReport.get内部帳票名());
        fileName.append(CSV_WRITER_LINE).append(dateString);
        fileName.append(CSV_WRITER_LINE).append(timeString);
        fileName.append(CSV);
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), fileName.toRString());
        List<PersonalData> personalDataList = new ArrayList<>();
        try (CsvWriter<FukaErrorListCsvItem> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(false).build()) {
            for (FukaErrorListCsvItem item : reportItem) {
                personalDataList.add(toPersonalData(new ShikibetsuCode(item.get識別コード())));
                csvWriter.writeLine(item);
            }
            csvWriter.close();
        }
        AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(fileName.toRString()));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(entry, fileName.toRString()), response);
    }

    /**
     * 選択した行のエラー内容に合わせて、修正処理へ遷移するボタンの表示非表示を切り替え、遷移可能な状態に切り替えます。
     *
     * @param div 賦課エラー一覧Div
     * @return 賦課エラー一覧Divを持つResponseData
     */
    public ResponseData onSelect_dgFukaErrorList(FukaErrorReportViewDiv div) {

        createHandler(div).onSelect_dgFukaErrorList();
        Models<FukaErrorListIdentifier, FukaErrorList> models = ViewStateHolder.get(ViewStateKeys.賦課エラー一覧, Models.class);
        dgFukaErrorList_Row row = div.getDgFukaErrorList().getSelectedItems().get(0);
        ViewStateHolder.put(ViewStateKeys.賦課エラー情報, models.get(
                new FukaErrorListIdentifier(new SubGyomuCode(row.getSubGyomuCode()),
                        row.getNaibuChohyoId(), new FlexibleYear(row.getFukaNendo().getValue().getYear().toDateString()),
                        new TsuchishoNo(row.getTsuchishoNo()))));
        return ResponseData.of(div).respond();
    }

    /**
     * 資格不整合処理へ遷移するボタンをクリックした際に実行されるイベントです。
     *
     * @param div 賦課エラー一覧Div
     * @return 賦課エラー一覧Divを持つResponseData
     */
    public ResponseData onClick_btnShikakuFuseigo(FukaErrorReportViewDiv div) {

        FukaErrorList fukaErrorList = ViewStateHolder.get(ViewStateKeys.賦課エラー情報, FukaErrorList.class);
        if (InternalReportShoriKubun.未処理.getCode().getKey().equals(fukaErrorList.get処理区分コード().value())) {
            ViewStateHolder.put(ViewStateKeys.資格対象者,
                    new TaishoshaKey(fukaErrorList.get被保険者番号(), fukaErrorList.get識別コード(), SetaiCode.EMPTY));
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
     * 即時賦課更正処理へ遷移するボタンをクリックした際に実行されるイベントです。
     *
     * @param div 賦課エラー一覧Div
     * @return 賦課エラー一覧Divを持つResponseData
     */
    public ResponseData onClick_btnFukaKosei(FukaErrorReportViewDiv div) {

        FukaErrorList fukaErrorList = ViewStateHolder.get(ViewStateKeys.賦課エラー情報, FukaErrorList.class);
        if (InternalReportShoriKubun.未処理.getCode().getKey().equals(fukaErrorList.get処理区分コード().value())) {

            ViewStateHolder.put(ViewStateKeys.資格対象者,
                    new TaishoshaKey(fukaErrorList.get被保険者番号(), fukaErrorList.get識別コード(), SetaiCode.EMPTY));
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
        FukaErrorList errorList = ViewStateHolder.get(ViewStateKeys.賦課エラー情報, FukaErrorList.class);
        FukaErrorListService service = FukaErrorListService.createInstance();
        service.saveAs処理済み(errorList);
        List<FukaErrorList> 賦課エラー情報
                = FukaErrorListService.createInstance().getFukaErrorList(errorList.get内部帳票作成日時()).records();
        createHandler(div).initialize(賦課エラー情報);
        ViewStateHolder.put(ViewStateKeys.賦課エラー一覧, Models.create(賦課エラー情報));
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

    private static RString createTimeString(RTime time) {
        RString hour = new RString(Integer.toString(time.getHour()));
        RString minute = new RString(Integer.toString(time.getMinute()));
        RString second = new RString(Integer.toString(time.getSecond()));

        RStringBuilder builder = new RStringBuilder(hour.padZeroToLeft(TWO));
        builder.append("-").append(minute.padZeroToLeft(TWO))
                .append("-").append(second.padZeroToLeft(TWO));
        return builder.toRString();
    }

    private RString getバッチID変換(ShoriDateKanri shori) {
        if (特徴仮算定賦課.equals(shori.get処理名())) {
            return new RString("DBB011001_TokuchoKarisanteiFuka");
        }
        if (普徴仮算定賦課.equals(shori.get処理名())) {
            return new RString("DBB014001_FuchoKarisanteiFuka");
        }
        if (仮算定異動賦課.equals(shori.get処理名())) {
            return new RString("DBB015001_KarisanteiIdoFuka");
        }
        if (特徴平準化計算_8月分.equals(shori.get処理名())) {
            return new RString("DBB013001_TokuchoHeinjunka8Gatsu");
        }
        if (本算定賦課.equals(shori.get処理名())) {
            return new RString("DBB031001_HonsanteiFuka");
        }
        if (異動賦課.equals(shori.get処理名())) {
            return new RString("DBB051001_GennendoIdoFuka");
        }
        if (過年度賦課.equals(shori.get処理名())) {
            return new RString("DBB055001_KanendoIdoFuka");
        }
        return RString.EMPTY;
    }

    private RString getMenuId() {
        if (ResponseHolder.getMenuID().equals(DBBMN33004)) {
            return 特徴仮算定賦課;
        }
        if (ResponseHolder.getMenuID().equals(DBBMN34004)) {
            return 普徴仮算定賦課;
        }
        if (ResponseHolder.getMenuID().equals(DBBMN36004)) {
            return 仮算定異動賦課;
        }
        if (ResponseHolder.getMenuID().equals(DBBMN35006)) {
            return 特徴平準化計算_8月分;
        }
        if (ResponseHolder.getMenuID().equals(DBBMN43004)) {
            return 本算定賦課;
        }
        if (ResponseHolder.getMenuID().equals(DBBMN44004)) {
            return 異動賦課;
        }
        if (ResponseHolder.getMenuID().equals(DBBMN45004)) {
            return 過年度賦課;
        }
        return RString.EMPTY;
    }

    private PersonalData toPersonalData(ShikibetsuCode 識別コード) {
        ExpandedInformation expandedInfo1 = new ExpandedInformation(new Code("0001"), 個人番号_利用有無名称, 無し);
        ExpandedInformation expandedInfo2 = new ExpandedInformation(new Code("0002"), 法人番号_利用有無名称, 無し);
        return PersonalData.of(識別コード, expandedInfo1, expandedInfo2);
    }
}
