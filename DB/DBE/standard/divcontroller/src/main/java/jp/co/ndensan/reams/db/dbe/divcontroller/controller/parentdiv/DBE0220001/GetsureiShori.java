/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE0220001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.KanryoShoriStatus;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0220001.DBE0220001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0220001.DBE0220001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0220001.GetsureiShoriDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0220001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0220001.CenterSoshinIchiranCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0220001.GetsureiShoriHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0220001.GetsureiShoriValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ikenshoget.IkenshogetManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.GeTuReiSyoRiBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.ShinSaKaiBusiness;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigoninteitasklist.YokaigoNinteiTaskListParameter;
import jp.co.ndensan.reams.db.dbz.service.core.yokaigoninteitasklist.YokaigoNinteiTaskListFinder;
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
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 完了処理・センター送信のクラスです。
 *
 * @reamsid_L DBE-1520-010 lishengli
 */
public class GetsureiShori {

    private static final LockingKey 排他キー = new LockingKey(new RString("ShinseishoKanriNo"));
    private static final RString UICONTAINERID_DBEUC56101 = new RString("DBEUC56101");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_ENTITY_ID = new RString("DBE202001");
    private static final RString KEY = new RString("key");
    private static final RString WORKFLOW_KEY_KANRYO = new RString("Kanryo");

    /**
     * 完了処理・センター送信の初期化。(オンロード)<br/>
     *
     * @param div GetsureiShoriDiv
     * @return レスポンスデータ
     */
    public ResponseData<GetsureiShoriDiv> onLoad(GetsureiShoriDiv div) {
        RDate 基準日 = RDate.getNowDate();
        RString 状態区分 = DbBusinessConfig.get(ConfigNameDBE.基本運用_対象者一覧表示区分, 基準日, SubGyomuCode.DBE認定支援);
        RString 最大取得件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, 基準日, SubGyomuCode.DBU介護統計報告);
        RString 最大取得件数上限 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限, 基準日, SubGyomuCode.DBU介護統計報告);
        状態区分 = RString.isNullOrEmpty(状態区分) ? KanryoShoriStatus.すべて.getコード() : 状態区分;

        YokaigoNinteiTaskListParameter 検索条件 = getHandler(div).create検索条件(状態区分, toDecimal(最大取得件数));
        YokaigoNinteiTaskListFinder finder = YokaigoNinteiTaskListFinder.createInstance();
        SearchResult<GeTuReiSyoRiBusiness> 検索結果 = finder.get月例処理モード(検索条件);
        ShinSaKaiBusiness 認定完了情報 = finder.get前月例処理(検索条件);
        getHandler(div).initialize(状態区分, toDecimal(最大取得件数), toDecimal(最大取得件数上限));
        getHandler(div).set対象者一覧(検索結果);
        getHandler(div).set検索結果表示時の制御(状態区分);

        if (認定完了情報 == null || 認定完了情報.get要介護認定完了情報Lsit() == null || 認定完了情報.get要介護認定完了情報Lsit().isEmpty()) {
            ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(new ArrayList()));
        } else {
            ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(認定完了情報.get要介護認定完了情報Lsit()));
        }
        return ResponseData.of(div).setState(DBE0220001StateName.初期表示);
    }

    /**
     * 画面再表示時の動作です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData onActive(GetsureiShoriDiv div) {
        RString 状態区分 = div.getRadJyotaiKubun().getSelectedKey();
        Decimal 最大取得件数 = div.getTxtDispMax().getValue();
        Decimal 最大取得件数上限 = div.getTxtDispMax().getMaxValue();

        ValidationMessageControlPairs vallidation = getValidationHandler(div).check最大表示件数(最大取得件数, 最大取得件数上限);
        if (vallidation.existsError()) {
            最大取得件数 = new Decimal(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString());
            div.getTxtDispMax().setValue(最大取得件数);
        }
        YokaigoNinteiTaskListParameter 検索条件 = getHandler(div).create検索条件(状態区分, 最大取得件数);
        YokaigoNinteiTaskListFinder finder = YokaigoNinteiTaskListFinder.createInstance();
        SearchResult<GeTuReiSyoRiBusiness> 検索結果 = finder.get月例処理モード(検索条件);
        ShinSaKaiBusiness 認定完了情報 = finder.get前月例処理(検索条件);
        getHandler(div).set対象者一覧(検索結果);
        getHandler(div).set検索結果表示時の制御(状態区分);

        if (認定完了情報 == null || 認定完了情報.get要介護認定完了情報Lsit() == null || 認定完了情報.get要介護認定完了情報Lsit().isEmpty()) {
            ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(new ArrayList()));
        } else {
            ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(認定完了情報.get要介護認定完了情報Lsit()));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 状態ラジオボタンの押下チェック処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<GetsureiShoriDiv> onChange_jyotaiKubun(GetsureiShoriDiv div) {
        return onActive(div);
    }

    /**
     * 最大表示件数テキストボックスの値が変更された際の動作です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData onChange_txtMaxCount(GetsureiShoriDiv div) {
        return onActive(div);
    }

    /**
     * 一覧表を出力するボタンの押下チェック処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<GetsureiShoriDiv> onClick_BtnDataOutput(GetsureiShoriDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getDgNinteiTaskList().getDataSource().isEmpty()) {
            validationMessages.add(getValidationHandler(div).センター送信完了対象者一覧データの存在チェック());
        }
        if (div.getDgNinteiTaskList().getSelectedItems() == null || div.getDgNinteiTaskList().getSelectedItems().isEmpty()) {
            validationMessages.add(getValidationHandler(div).センター送信完了対象者一覧データの行選択チェック());
        }
        if (validationMessages.existsError()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧表を出力するボタンが押下された場合、ＣＳＶを出力します。
     *
     * @param div GetsureiShoriDiv
     * @param response IDownLoadServletResponse
     * @return IDownLoadServletResponse
     */
    public IDownLoadServletResponse onClick_btnOutputCsv(GetsureiShoriDiv div, IDownLoadServletResponse response) {
        RString CSVファイル名 = EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, EUC_ENTITY_ID);
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), CSVファイル名);
        try (CsvWriter<CenterSoshinIchiranCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(true).build()) {
            List<dgNinteiTaskList_Row> rowList = div.getDgNinteiTaskList().getSelectedItems();
            for (dgNinteiTaskList_Row row : rowList) {
                csvWriter.writeLine(getCsvData(row));
                PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(new Code("0001"),
                        new RString("申請書管理番号"), row.getShinseishoKanriNo()));
                personalData.addExpandedInfo(new ExpandedInformation(new Code("0002"), new RString("被保険者番号"),
                        row.getHihoNumber()));
                AccessLogger.log(AccessLogType.照会, personalData);
            }
            csvWriter.close();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(CSVファイル名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(entry, CSVファイル名), response);
    }

    /**
     * センター送信準備ボタンの押下処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<GetsureiShoriDiv> onClick_BtnCenterSoshin(GetsureiShoriDiv div) {
        RealInitialLocker.release(排他キー);
        return ResponseData.of(div).forwardWithEventName(DBE0220001TransitionEventName.センター送信).respond();
    }

    public ResponseData<GetsureiShoriDiv> onClick_shorikeizoku(GetsureiShoriDiv div) {
        onLoad(div);
        return ResponseData.of(div).setState(DBE0220001StateName.初期表示);
    }

    /**
     * 月例処理を完了するボタンの押下処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<GetsureiShoriDiv> onClick_BtnCompleteGetsureiShori(GetsureiShoriDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getDgNinteiTaskList().getDataSource().isEmpty()) {
            validationMessages.add(getValidationHandler(div).センター送信完了対象者一覧データの存在チェック());
        }
        if (div.getDgNinteiTaskList().getSelectedItems() == null || div.getDgNinteiTaskList().getSelectedItems().isEmpty()) {
            validationMessages.add(getValidationHandler(div).センター送信完了対象者一覧データの行選択チェック());
        }
        if (is未送信データ存在(div.getDgNinteiTaskList().getSelectedItems())) {
            validationMessages.add(getValidationHandler(div).センター送信完了対象者一覧選択行の完了処理事前チェック());
        }
        if (validationMessages.existsError()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
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
                if (!RString.isNullOrEmpty(申請書管理番号)) {
                    NinteiKanryoJoho ninteiKanryoJoho = サービス一覧情報Model.get(
                            new NinteiKanryoJohoIdentifier(new ShinseishoKanriNo(申請書管理番号)));
                    ninteiKanryoJoho = getHandler(div).要介護認定完了情報更新(ninteiKanryoJoho);
                    IkenshogetManager.createInstance().要介護認定完了情報更新(ninteiKanryoJoho);
                }
                PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(new Code("0001"),
                        new RString("申請書管理番号"), row.getShinseishoKanriNo()));
                personalData.addExpandedInfo(new ExpandedInformation(new Code("0002"), new RString("被保険者番号"),
                        row.getHihoNumber()));
                AccessLogger.log(AccessLogType.更新, personalData);
            }
            RealInitialLocker.release(排他キー);
            div.getCcdKanryoMsg().setMessage(new RString("完了処理・センター送信の保存処理が完了しました。"),
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
            RString uiContainerID = ResponseHolder.getUIContainerId();
            if (UICONTAINERID_DBEUC56101.equals(uiContainerID)) {
                FlowParameters fp = FlowParameters.of(KEY, WORKFLOW_KEY_KANRYO);
                FlowParameterAccessor.merge(fp);
            }
            return ResponseData.of(div).setState(DBE0220001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    private boolean is未送信データ存在(List<dgNinteiTaskList_Row> rows) {
        for (dgNinteiTaskList_Row row : rows) {
            if (row.getCenterSoshinDay().getValue() == null) {
                return true;
            }
        }
        return false;
    }

    private CenterSoshinIchiranCsvEntity getCsvData(dgNinteiTaskList_Row row) {
        return new CenterSoshinIchiranCsvEntity(
                get状態名称(row.getJyotai()),
                row.getHokensha(),
                to西暦(row.getNinteiShinseiDay().getValue()),
                row.getHihoNumber(),
                row.getHihoShimei(),
                row.getShinseiKubunShinseiji(),
                row.getShinseiKubunHorei(),
                to西暦(row.getGetsureiShoriKanryoDay().getValue()),
                to西暦(row.getCenterSoshinDay().getValue()));
    }

    private RString get状態名称(RString ryakusho) {
        if (KanryoShoriStatus.未処理.get略称().equals(ryakusho)) {
            return KanryoShoriStatus.未処理.toRString();
        } else if (KanryoShoriStatus.完了可能.get略称().equals(ryakusho)) {
            return KanryoShoriStatus.完了可能.toRString();
        }
        return RString.EMPTY;
    }

    private RString to西暦(RDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
    }

    private GetsureiShoriHandler getHandler(GetsureiShoriDiv div) {
        return new GetsureiShoriHandler(div);
    }

    private GetsureiShoriValidationHandler getValidationHandler(GetsureiShoriDiv div) {
        return new GetsureiShoriValidationHandler(div);
    }

    private Decimal toDecimal(RString string) {
        if (Decimal.canConvert(string)) {
            return new Decimal(string.toString());
        }
        return null;
    }
}
