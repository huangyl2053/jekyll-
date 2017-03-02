/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5110001;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho.GogitaiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho.GogitaiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaiwariateiinjoho.GogitaiWariateIinJoho;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE511001.DBE511001_GogitaiIkkatuParameter;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeWarningMessages;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.gogitaijohosakusei.GogitaiJohoSakuseiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.DBE5110001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.GogitaiJohoSakuseiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.dgGogitaiIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.dgHoketsuShinsainList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.dgShinsainList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5110001.GogitaiJohoSakuseiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5110001.GogitaiJohoSakuseiValidationHandler;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohosakusei.GogitaiJohoSakuseiCSVShuturyokuEntity;
import jp.co.ndensan.reams.db.dbe.service.core.gogitaijoho.gogitaijoho.GogitaiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.gogitaijoho.gogitaiwariateiinjoho.GogitaiWariateIinJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.gogitaijohosakusei.GogitaiJohoSakuseiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.KyoyuFileName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
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
import jp.co.ndensan.reams.uz.uza.euc.api.EucOtherInfo;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 合議体情報作成のコントローラです。
 *
 * @reamsid_L DBE-0090-010 chengsanyuan
 */
public class GogitaiJohoSakusei {

    private static final RString JYOTAI_CODE_ADD = new RString("1");
    private static final RString JYOTAI_CODE_UPD = new RString("2");
    private static final RString JYOTAI_CODE_DEL = new RString("3");
    private static final RString JYOTAI_NAME_ADD = new RString("追加");
    private static final RString JYOTAI_NAME_UPD = new RString("修正");
    private static final RString JYOTAI_NAME_DEL = new RString("削除");
    private static final RString RAD_KEY_0 = new RString("key0");
    private static final RString CSVファイルID_合議体情報一覧 = new RString("DBE511001");
    private static final RString COMMON_BUTTON_FIELD_NAME = new RString("btnBatchRegister");
    private static final RString COMMON_BUTTON_UPDATE_NAME = new RString("btnupdate");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private final GogitaiJohoSakuseiFinder service;
    private final GogitaiJohoManager manager;
    private final RString 合議体情報作成 = new RString("合議体情報作成");
    private static final RString WORKFLOW_KEY_BATCH = new RString("Batch");
    private static final RString WORKFLOW_KEY_KANRYO = new RString("Kanryo");

    /**
     * コンストラクタです。
     *
     */
    public GogitaiJohoSakusei() {
        this.service = GogitaiJohoSakuseiFinder.createInstance();
        this.manager = GogitaiJohoManager.createInstance();
    }

    /**
     * 合議体情報作成初期化の設定します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onLoad(GogitaiJohoSakuseiDiv div) {
        FlowParameters fp = FlowParameters.of(new RString("key"), WORKFLOW_KEY_KANRYO);
        FlowParameterAccessor.merge(fp);
        getHandler(div).load();
        getHandler(div).init最大表示件数();
        boolean is現在有効な合議体のみ = false;
        if (RAD_KEY_0.equals(div.getRadHyojiJoken().getSelectedKey())) {
            is現在有効な合議体のみ = true;
        }
        int 最大表示件数 = div.getTxtDispMax().getValue().intValue();
        SearchResult<GogitaiJoho> resultList = service.getDateGridList(
                GogitaiJohoSakuseiParameter.createGogitaiJohoSakuseiParameter(
                        FlexibleDate.getNowDate(), is現在有効な合議体のみ, 0, FlexibleDate.EMPTY, FlexibleDate.EMPTY, RString.EMPTY, 最大表示件数));
        Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJoho = Models.create(resultList.records());
        ViewStateHolder.put(ViewStateKeys.合議体情報, gogitaiJoho);
        ViewStateHolder.put(ViewStateKeys.状態, RString.EMPTY);
        getHandler(div).合議体情報一覧初期設定(resultList.records());
        CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_UPDATE_NAME, true);
        return ResponseData.of(div).respond();
    }

    /**
     * 合議体情報作成条件をクリアの設定します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onClick_btnClear(GogitaiJohoSakuseiDiv div) {
        getHandler(div).init最大表示件数();
        div.getRadHyojiJoken().setSelectedKey(RAD_KEY_0);
        return ResponseData.of(div).respond();
    }

    /**
     * 検索するボタン押下の場合、合議体情報一覧のデータを設定します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onClick_btnKensaku(GogitaiJohoSakuseiDiv div) {
        boolean is現在有効な合議体のみ = false;
        if (RAD_KEY_0.equals(div.getRadHyojiJoken().getSelectedKey())) {
            is現在有効な合議体のみ = true;
        }
        int 最大表示件数 = div.getTxtDispMax().getValue().intValue();
        SearchResult<GogitaiJoho> resultList = service.getDateGridList(
                GogitaiJohoSakuseiParameter.createGogitaiJohoSakuseiParameter(
                        FlexibleDate.getNowDate(), is現在有効な合議体のみ, 0, FlexibleDate.EMPTY, FlexibleDate.EMPTY, RString.EMPTY, 最大表示件数));

        Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJoho = Models.create(resultList.records());
        ViewStateHolder.put(ViewStateKeys.合議体情報, gogitaiJoho);
        ViewStateHolder.put(ViewStateKeys.状態, RString.EMPTY);
        getHandler(div).合議体情報一覧初期設定(resultList.records());
        return ResponseData.of(div).respond();
    }

    /**
     * 「合議体を追加する」ボタンをクリックの場合、合議体情報編集エリアのデータを設定します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onClick_btnTsuika(GogitaiJohoSakuseiDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, JYOTAI_CODE_ADD);
        getHandler(div).合議体詳細情報新規モード設定();
        return ResponseData.of(div).respond();
    }

    /**
     * 「CSV出力する」ボタンをクリックの場合、CSVファイルを出力します。
     *
     * @param div 合議体情報作成Div
     * @param response IDownLoadServletResponse
     * @return IDownLoadServletResponse
     */
    public IDownLoadServletResponse onClick_btnCSVShutsuryoku(GogitaiJohoSakuseiDiv div, IDownLoadServletResponse response) {
        RString 出力名 = EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, CSVファイルID_合議体情報一覧);
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), 出力名);
//        PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(Code.EMPTY, RString.EMPTY, RString.EMPTY));
        try (CsvWriter<GogitaiJohoSakuseiCSVShuturyokuEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build()) {
//            List<dgGogitaiIchiran_Row> rowList = div.getGogitaiIchiran().getDgGogitaiIchiran().getDataSource();

            Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJohoModel = ViewStateHolder.get(ViewStateKeys.合議体情報, Models.class);
            Iterator<GogitaiJoho> 合議体情報 = gogitaiJohoModel.iterator();
            while (合議体情報.hasNext()) {
                GogitaiJoho gogitaiJoho = 合議体情報.next();
                GogitaiJohoSakuseiCSVShuturyokuEntity entity = new GogitaiJohoSakuseiCSVShuturyokuEntity();
                entity.setGogitaiNo(new RString(gogitaiJoho.get合議体番号()));
                entity.setGogitaiMei(gogitaiJoho.get合議体名称());
                entity.setGogitaiYukoKikanKaishiYMD(gogitaiJoho.get合議体有効期間開始年月日().seireki().separator(Separator.SLASH).toDateString());
                entity.setGogitaiYukoKikanShuryoYMD(gogitaiJoho.get合議体有効期間終了年月日().seireki().separator(Separator.SLASH).toDateString());
                entity.setGogitaiKaishiYoteiTime(gogitaiJoho.get合議体開始予定時刻());
                entity.setGogitaiShuryoYoteiTime(gogitaiJoho.get合議体終了予定時刻());
                entity.setShinsakaiKaisaiBasho(gogitaiJoho.get介護認定審査会開催場所コード());
                entity.setGogitaiSeishinkaSonzaiFlag(gogitaiJoho.is合議体精神科医存在フラグ() ? new RString("0") : new RString("1"));
                entity.setGogitaiDummyFlag(gogitaiJoho.is合議体ダミーフラグ() ? new RString("0") : new RString("1"));
                entity.setShinsakaiJidoWariateTeiin(new RString(gogitaiJoho.get介護認定審査会自動割当定員()));
                entity.setShinsakaiIinTeiin(new RString(gogitaiJoho.get介護認定審査会委員定員()));
                entity.setShinsakaiYoteiTeiin(new RString(gogitaiJoho.get介護認定審査会予定定員()));
                if (gogitaiJoho.getGogitaiWariateIinJohoList().isEmpty()) {
                    csvWriter.writeLine(entity);
                }
                for (GogitaiWariateIinJoho wariateIinJoho : gogitaiJoho.getGogitaiWariateIinJohoList()) {
                    entity.setShinsakaiIinCode(wariateIinJoho.get介護認定審査会委員コード());
                    entity.setSubstituteFlag(wariateIinJoho.is補欠() ? new RString("0") : new RString("1"));
                    entity.setGogitaichoKubunCode(wariateIinJoho.get合議体長区分コード().value());
                    csvWriter.writeLine(entity);
                }
            }

//            for (dgGogitaiIchiran_Row row : rowList) {
//                csvWriter.writeLine(editCSV(row));
//            }
            csvWriter.close();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(出力名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
//        AccessLogger.log(AccessLogType.照会, personalData);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(entry, 出力名), response);
    }

    /**
     * 合議体情報Gridの行クリックの場合、合議体情報編集エリアのデータを設定します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onSelect_dgGogitaiIchiranMeisai(GogitaiJohoSakuseiDiv div) {
        RString jyotai = ViewStateHolder.get(ViewStateKeys.状態, RString.class);

        if (!(JYOTAI_CODE_ADD.equals(jyotai) || JYOTAI_CODE_UPD.equals(jyotai))) {
            Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJohoModel = ViewStateHolder.get(ViewStateKeys.合議体情報, Models.class);
            GogitaiJohoIdentifier identifier = new GogitaiJohoIdentifier(
                    div.getDgGogitaiIchiran().getClickedItem().getGogitaiNumber().getValue().intValue(),
                    new FlexibleDate(div.getDgGogitaiIchiran().getClickedItem().getYukoKaishiYMD().getValue().toDateString()));
            GogitaiJoho gogitaiJoho = gogitaiJohoModel.get(identifier);

            List<GogitaiWariateIinJoho> shinsainList = gogitaiJoho.getGogitaiWariateIinJohoList();

            getHandler(div).合議体詳細情報データ設定(div.getDgGogitaiIchiran().getClickedItem(), shinsainList);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「合議体情報一覧の修正」アイコンをクリックの場合、合議体情報編集エリアのデータを設定します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onSelectByModifyButton_dgGogitaiIchiranMeisai(GogitaiJohoSakuseiDiv div) {

        dgGogitaiIchiran_Row selectedRow = div.getDgGogitaiIchiran().getClickedItem();
        ViewStateHolder.put(ViewStateKeys.番号, selectedRow.getId());
        Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJohoModel = ViewStateHolder.get(ViewStateKeys.合議体情報, Models.class);
        GogitaiJohoIdentifier identifier = new GogitaiJohoIdentifier(selectedRow.getGogitaiNumber().getValue().intValue(),
                new FlexibleDate(selectedRow.getYukoKaishiYMD().getValue().toDateString()));
        GogitaiJoho gogitaiJoho = gogitaiJohoModel.get(identifier);

        List<GogitaiWariateIinJoho> shinsainList = gogitaiJoho.getGogitaiWariateIinJohoList();

        getHandler(div).合議体詳細情報データ設定(selectedRow, shinsainList);
        getHandler(div).合議体詳細情報修正モード設定();
        if (JYOTAI_NAME_ADD.equals(selectedRow.getJyotai())) {
            div.getTxtYukoKaishiYMD().setDisabled(false);
        }
        ViewStateHolder.put(ViewStateKeys.状態, JYOTAI_CODE_UPD);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_UPDATE_NAME, true);
        return ResponseData.of(div).respond();
    }

    /**
     * 「合議体情報一覧の削除」アイコンをクリックの場合、合議体情報編集エリアのデータを設定します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onSelectByDeleteButton_dgGogitaiIchiranMeisai(GogitaiJohoSakuseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(getValidationHandler(div).使用状況チェック());
            if (validationMessages.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }

            ViewStateHolder.put(ViewStateKeys.状態, JYOTAI_CODE_DEL);
            if (JYOTAI_NAME_ADD.equals(div.getDgGogitaiIchiran().getClickedItem().getJyotai())) {
                div.getDgGogitaiIchiran().getDataSource().remove(div.getDgGogitaiIchiran().getClickedRowId());
            } else if (!JYOTAI_NAME_DEL.equals(div.getDgGogitaiIchiran().getClickedItem().getJyotai())) {
                div.getDgGogitaiIchiran().getClickedItem().setJyotai(JYOTAI_NAME_DEL);
                Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJohoModel = ViewStateHolder.get(ViewStateKeys.合議体情報, Models.class);
                GogitaiJohoIdentifier identifier = new GogitaiJohoIdentifier(
                        div.getDgGogitaiIchiran().getClickedItem().getGogitaiNumber().getValue().intValue(),
                        new FlexibleDate(div.getDgGogitaiIchiran().getClickedItem().getYukoKaishiYMD().getValue().toDateString()));
                GogitaiJoho gogitaiJoho = gogitaiJohoModel.get(identifier);
                gogitaiJoho = gogitaiJoho.deleted();
                gogitaiJohoModel.deleteOrRemove(identifier);
                gogitaiJohoModel.add(gogitaiJoho);
                ViewStateHolder.put(ViewStateKeys.合議体情報, gogitaiJohoModel);
            }
            getHandler(div).合議体詳細情報削除モード設定(false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_UPDATE_NAME, false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「割当審査会委員情報一覧」閉じるの場合、割当審査会委員情報一覧のデータを設定します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onOkClose_btnShinsainSelect(GogitaiJohoSakuseiDiv div) {
        RString 介護認定審査会委員コード = ViewStateHolder.get(
                ViewStateKeys.介護認定審査会委員コード, RString.class);
        RString 審査会委員名称 = ViewStateHolder.get(
                ViewStateKeys.審査会委員名称, RString.class);
        boolean flag = false;
        for (dgShinsainList_Row row : div.getDgShinsainList().getDataSource()) {
            if (row.getShinsakaiIinCode().equals(介護認定審査会委員コード)) {
                flag = true;
            }
        }
        for (dgHoketsuShinsainList_Row row : div.getDgHoketsuShinsainList().getDataSource()) {
            if (row.getHoketsuShinsakaiIinCode().equals(介護認定審査会委員コード)) {
                flag = true;
            }
        }
        if (!flag) {
            div.getDgShinsainList().getDataSource().add(
                    new dgShinsainList_Row(Boolean.FALSE, Boolean.FALSE, 介護認定審査会委員コード, 審査会委員名称, JYOTAI_CODE_ADD));
        } else {
            throw new ApplicationException(UrErrorMessages.設定不可.getMessage().replace("指定した審査会委員は既に割当されているため"));
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「割当審査会委員情報一覧」閉じるの場合、割当審査会委員情報一覧のデータを設定します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onOkClose_btnSubShinsainSelect(GogitaiJohoSakuseiDiv div) {
        RString 介護認定審査会委員コード = ViewStateHolder.get(
                ViewStateKeys.介護認定審査会委員コード, RString.class);
        RString 審査会委員名称 = ViewStateHolder.get(
                ViewStateKeys.審査会委員名称, RString.class);
        boolean flag = false;
        for (dgHoketsuShinsainList_Row row : div.getDgHoketsuShinsainList().getDataSource()) {
            if (row.getHoketsuShinsakaiIinCode().equals(介護認定審査会委員コード)) {
                flag = true;
            }
        }
        for (dgShinsainList_Row row : div.getDgShinsainList().getDataSource()) {
            if (row.getShinsakaiIinCode().equals(介護認定審査会委員コード)) {
                flag = true;
            }
        }
        if (!flag) {
            div.getDgHoketsuShinsainList().getDataSource().add(
                    new dgHoketsuShinsainList_Row(介護認定審査会委員コード, 審査会委員名称, JYOTAI_CODE_ADD));
        } else {
            throw new ApplicationException(UrErrorMessages.設定不可.getMessage().replace("指定した審査会委員は既に割当されているため"));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 割当審査員一覧Gridの削除ボタンをクリックの場合、選択のデータを削除します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onSelectByDeleteButton_dgShinsainListMeisai(GogitaiJohoSakuseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getDgShinsainList().getDataSource().remove(div.getDgShinsainList().getClickedRowId());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 割当補欠審査員一覧Gridの削除ボタンをクリックの場合、選択のデータを削除します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onSelectByDeleteButton_dgHoketsuShinsainListMeisai(GogitaiJohoSakuseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getDgHoketsuShinsainList().getDataSource().remove(div.getDgHoketsuShinsainList().getClickedRowId());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「入力内容を取消する」ボタンをクリックの場合、合議体情報編集エリアの値を破棄します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onClick_btnback(GogitaiJohoSakuseiDiv div) {
        Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJohoModel = ViewStateHolder.get(ViewStateKeys.合議体情報, Models.class);

        if (!ResponseHolder.isReRequest()) {
            RString jyotai = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
            if (合議体詳細情報変更有無判定(div, gogitaiJohoModel, jyotai)) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            }
        }
        if (ResponseHolder.getButtonType() != MessageDialogSelectedResult.No) {
            ViewStateHolder.put(ViewStateKeys.状態, RString.EMPTY);
            if (!div.getDgGogitaiIchiran().getSelectedItems().isEmpty()) {
                GogitaiJohoIdentifier identifier = new GogitaiJohoIdentifier(
                        div.getDgGogitaiIchiran().getSelectedItems().get(0).getGogitaiNumber().getValue().intValue(),
                        new FlexibleDate(div.getDgGogitaiIchiran().getSelectedItems().get(0).getYukoKaishiYMD().getValue().toDateString()));
                GogitaiJoho gogitaiJoho = gogitaiJohoModel.get(identifier);
                gogitaiJohoModel.add(gogitaiJoho.createBuilderForEdit().setState(EntityDataState.Unchanged).build());
                ViewStateHolder.put(ViewStateKeys.合議体情報, gogitaiJohoModel);
            }
            getHandler(div).合議体詳細情報初期状態設定();
            List<dgGogitaiIchiran_Row> ichiranList = div.getDgGogitaiIchiran().getDataSource();
            boolean notUpdate = true;
            for (dgGogitaiIchiran_Row row : ichiranList) {
                if (!RString.EMPTY.equals(row.getJyotai())) {
                    notUpdate = false;
                    break;
                }
            }
            if (notUpdate) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_UPDATE_NAME, true);
            } else {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_UPDATE_NAME, false);
            }
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「入力内容を更新する」ボタンをクリックの場合、合議体情報一覧を更新します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onClick_btnkosin(GogitaiJohoSakuseiDiv div) {
        RString jyotai = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();

            if (JYOTAI_CODE_ADD.equals(jyotai)) {
                validationMessages.add(getValidationHandler(div).gogitaiNoJuuhukuCheck());
            }
            if (!JYOTAI_CODE_DEL.equals(jyotai)) {
                validationMessages.add(getValidationHandler(div).gogitaichoPersonNumCheck());
                validationMessages.add(getValidationHandler(div).gogitaichoToFukuGogitaichoCheck());
                validationMessages.add(getValidationHandler(div).iinTeiinCheck());
                validationMessages.add(getValidationHandler(div).kaisaiBashoCodeCheck());
                validationMessages.add(getValidationHandler(div).kaishiToShuryoYMDCheck());
                validationMessages.add(getValidationHandler(div).kaishiYoteiToShuryoYoteiTimeCheck());
            }

            if (JYOTAI_CODE_ADD.equals(jyotai) || JYOTAI_CODE_UPD.equals(jyotai)) {
                validationMessages.add(getValidationHandler(div).yukoKikanCheck());
            }
//        validationMessages.add(getValidationHandler(div).shinsainListRequiredCheck());
//        validationMessages.add(getValidationHandler(div).shinsainPersonNumCheck());
            if (validationMessages.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            List<dgShinsainList_Row> rowList = div.getDgShinsainList().getDataSource();
            int 最低定員数 = DbBusinessConfig.get(ConfigNameDBE.審査会最低定員数, RDate.getNowDate()).toInt();
            if (最低定員数 > rowList.size()) {
                Message message = new WarningMessage(DbeWarningMessages.審査会最低定員数不足.getMessage().getCode(),
                        DbeWarningMessages.審査会最低定員数不足.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            return ResponseData.of(div).addMessage(UrQuestionMessages.確定の確認.getMessage()).respond();
        }
        if ((!new RString(UrQuestionMessages.確定の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) || ResponseHolder.isWarningIgnoredRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.確定の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.確定の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJohoModel = ViewStateHolder.get(ViewStateKeys.合議体情報, Models.class);
            ViewStateHolder.put(ViewStateKeys.合議体情報更新前, gogitaiJohoModel);
            if (JYOTAI_CODE_ADD.equals(jyotai)) {
                GogitaiJoho gogitaiJoho = new GogitaiJoho(
                        Integer.parseInt(div.getTxtGogitaiNumber().getValue().toString()),
                        new FlexibleDate(div.getTxtYukoKaishiYMD().getValue().toDateString()));
                gogitaiJoho = getHandler(div).合議体情報編集(gogitaiJoho);
                gogitaiJohoModel.add(gogitaiJoho);
                getHandler(div).合議体情報一覧更新(JYOTAI_NAME_ADD);
            } else if (JYOTAI_CODE_UPD.equals(jyotai)) {
                GogitaiJohoIdentifier identifier = new GogitaiJohoIdentifier(
                        Integer.parseInt(div.getTxtGogitaiNumber().getValue().toString()),
                        new FlexibleDate(div.getTxtYukoKaishiYMD().getValue().toDateString()));

                GogitaiJoho gogitaiJoho = getHandler(div).合議体情報編集(gogitaiJohoModel.get(identifier).modifiedModel());
                gogitaiJoho = gogitaiJoho.modifiedModel();
                gogitaiJohoModel.add(gogitaiJoho);
                getHandler(div).合議体情報一覧更新(JYOTAI_NAME_UPD);
            }
            for (dgGogitaiIchiran_Row row : div.getDgGogitaiIchiran().getDataSource()) {
                if (row.getJyotai() != null && !row.getJyotai().isEmpty()) {
                    CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_UPDATE_NAME, false);
                    break;
                }
            }
            ViewStateHolder.put(ViewStateKeys.状態, RString.EMPTY);
            ViewStateHolder.put(ViewStateKeys.合議体情報, gogitaiJohoModel);
            getHandler(div).合議体詳細情報初期状態設定();
        }
        return ResponseData.of(div).respond();

    }

    /**
     * 「保存する」ボタンをクリックの場合、合議体情報を更新します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onClick_btnupdate(GogitaiJohoSakuseiDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForUpdate();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJohoModel = ViewStateHolder.get(ViewStateKeys.合議体情報, Models.class);
            Iterator<GogitaiJoho> 合議体情報 = gogitaiJohoModel.iterator();
            while (合議体情報.hasNext()) {
                GogitaiJoho gogitaiJoho = 合議体情報.next();
                if (gogitaiJoho.toEntity().getState() == EntityDataState.Added) {
                    manager.save(gogitaiJoho);
                }
                if (gogitaiJoho.toEntity().getState() == EntityDataState.Deleted) {
                    gogitaiNOExitCheck(gogitaiJoho.get合議体番号());
                    manager.deletePhysicalWithoutGogitaiWariateIin(gogitaiJoho);
                }
                if (gogitaiJoho.toEntity().getState() == EntityDataState.Modified) {
                    manager.deletePhysicalGogitaiWariateIinJoho(koshinmaedate(gogitaiJoho));
                    manager.saveGogitaiJoho(gogitaiJoho);
                    GogitaiWariateIinJohoManager gogitaiWariateIinJohoManager = GogitaiWariateIinJohoManager.createInstance();
                    for (GogitaiWariateIinJoho gogitaiWariateIinJoho : gogitaiJohoModel.get(gogitaiJoho.identifier()).getGogitaiWariateIinJohoList()) {
                        gogitaiWariateIinJohoManager.save(gogitaiWariateIinJoho);
                    }
                }
            }

            div.getCcdKanryoMsg().setMessage(new RString(UrInformationMessages.正常終了.getMessage().
                    replace(合議体情報作成.toString()).evaluate()), RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBE5110001StateName.完了);

        }
        return ResponseData.of(div).setState(DBE5110001StateName.合議体情報作成);
    }

    private GogitaiJoho koshinmaedate(GogitaiJoho gogitaiJoho) {
        Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJohoModeltmp = ViewStateHolder.get(ViewStateKeys.合議体情報更新前, Models.class);
        Iterator<GogitaiJoho> 合議体情報tmp = gogitaiJohoModeltmp.iterator();
        while (合議体情報tmp.hasNext()) {
            GogitaiJoho gogitaiJohotmp = 合議体情報tmp.next();

            if (gogitaiJohotmp.get合議体番号() == gogitaiJoho.get合議体番号()
                    && gogitaiJohotmp.get合議体有効期間開始年月日().equals(gogitaiJoho.get合議体有効期間開始年月日())) {
                return gogitaiJohotmp.createBuilderForEdit().set介護認定審査会開催場所コード(gogitaiJoho.get介護認定審査会開催場所コード()).build();
            }

        }
        return gogitaiJoho;
    }

    /**
     * アップロードファイルを設定の場合、「一括登録する」ポタンを設定します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onClick_btnKakunin(GogitaiJohoSakuseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * アップロードファイルを設定の場合、「一括登録する」ポタンを設定します。
     *
     * @param div 合議体情報作成Div
     * @param files 画面から渡されるファイルデータ
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<GogitaiJohoSakuseiDiv> onClick_btnRegistUploadFile(GogitaiJohoSakuseiDiv div, FileData[] files) {
        for (FileData file : files) {
            copyFile(file, div);
        }
        return ResponseData.of(div).respond();
    }

    private boolean copyFile(FileData file, GogitaiJohoSakuseiDiv div) {
        FilesystemName sharedfileName = new FilesystemName(KyoyuFileName.合議体情報作成一括登録ファイル.get名称());
        List<RString> allGroups = new ArrayList<>();
        allGroups.add(new RString("*"));
        SharedFile.defineSharedFile(sharedfileName, 1, allGroups, null, false, null);
        FilesystemPath path = new FilesystemPath(file.getFilePath());
        RDateTime fileId = SharedFile.copyToSharedFile(path, sharedfileName);
        div.setHiddenFileId(new RString(fileId.toString()));
        div.setHiddenFileName(file.getFileName());
        return false;
    }

    /**
     * アップロードファイル設定後の場合、「一括登録する」ポタンに活性を設定します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> btnShow(GogitaiJohoSakuseiDiv div) {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_FIELD_NAME, false);
        return ResponseData.of(div).respond();
    }

    /**
     * 「一括登録する」ポタンをクリックの場合、DB一括登録バッチを起動します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiBatchParamter>
     */
    public ResponseData<DBE511001_GogitaiIkkatuParameter> onClick_btnBatchRegister(GogitaiJohoSakuseiDiv div) {
        FlowParameters fp = FlowParameters.of(new RString("key"), WORKFLOW_KEY_BATCH);
        FlowParameterAccessor.merge(fp);
//        ResponseData<DBE511001_GogitaiIkkatuParameter> responseData = new ResponseData<>();
        DBE511001_GogitaiIkkatuParameter batchParam = new DBE511001_GogitaiIkkatuParameter();
        batchParam.setSharedFileID(RDateTime.parse(div.getHiddenFileId().toString()));
        batchParam.setSharedFileName(KyoyuFileName.合議体情報作成一括登録ファイル.get名称());
        batchParam.setInputFileName(div.getHiddenFileName());
//        responseData.data = batchParam;
        return ResponseData.of(batchParam).respond();
    }

    private GogitaiJohoSakuseiHandler getHandler(GogitaiJohoSakuseiDiv div) {
        return new GogitaiJohoSakuseiHandler(div);
    }

    private GogitaiJohoSakuseiValidationHandler getValidationHandler(GogitaiJohoSakuseiDiv div) {
        return new GogitaiJohoSakuseiValidationHandler(div);
    }

    private void gogitaiNOExitCheck(int 合議体番号) {
        if (service.getGogitaiWariateIinJohoCount(合議体番号)
                && service.getShinsakaiKaisaiYoteiJohoCount(合議体番号)) {
            throw new ApplicationException(DbeErrorMessages.他の情報で使用している為削除不可.getMessage());
        }
    }

    private boolean 合議体詳細情報変更有無判定(GogitaiJohoSakuseiDiv div,
            Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJohoModel,
            RString jyotai) {
        if (JYOTAI_CODE_ADD.equals(jyotai)) {
            return getHandler(div).新規モード合議体詳細情報変更有無判定();
        }
        if (JYOTAI_CODE_UPD.equals(jyotai)) {
            GogitaiJohoIdentifier identifier = new GogitaiJohoIdentifier(Integer.parseInt(div.getTxtGogitaiNumber().getValue().toString()),
                    new FlexibleDate(div.getTxtYukoKaishiYMD().getValue().toDateString()));
            GogitaiJoho gogitaiJoho = gogitaiJohoModel.get(identifier);
            return getHandler(div).修正モード合議体詳細情報変更有無判定(gogitaiJoho);
        }
        return false;
    }

//    private GogitaiJohoSakuseiCSVShuturyokuEntity editCSV(dgGogitaiIchiran_Row row) {
//        GogitaiJohoSakuseiCSVShuturyokuEntity entity = new GogitaiJohoSakuseiCSVShuturyokuEntity();
//        entity.setGogitaiNo(new RString(row.getGogitaiNumber().getValue().toString()));
//        entity.setGogitaiMei(row.getGogitaiName());
//        entity.setGogitaiYukoKikanKaishiYMD(row.getYukoKaishiYMD().getValue().seireki().separator(Separator.SLASH).toDateString());
//        entity.setGogitaiYukoKikanShuryoYMD(row.getYukoShuryoYMD().getValue().seireki().separator(Separator.SLASH).toDateString());
//        entity.setGogitaiKaishiYoteiTime(時刻転換(row.getGogitaiKaishiYoteiTime().getValue()));
//        entity.setGogitaiShuryoYoteiTime(時刻転換(row.getGogitaiShuryoYoteiTime().getValue()));
//        entity.setShinsakaiKaisaiBasho(row.getKaisaiBasho());
//        entity.setGogitaiSeishinkaSonzaiFlag(row.getSeishinkaiSonzai() == true ? new RString("該当") : new RString("非該当"));
//        entity.setGogitaiDummyFlag(row.getGogitaiDummyFlag() == true ? new RString("該当") : new RString("非該当"));
//        return entity;
//    }
    private RString 時刻転換(RTime 時刻) {
        if (時刻 != null) {
            return new RString(時刻.toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
        }
        return RString.EMPTY;
    }
}
