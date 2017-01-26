/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2070001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2070001.DBE2070001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2070001.DBE2070001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2070001.IkenshogetDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2070001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2070001.IkenshoNyushuCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2070001.IkenshogetHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2070001.IkenshogetValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ikenshoget.IkenshogetManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiKaisuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
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
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 完了処理・主治医意見書入手のクラスです。
 *
 * @reamsid_L DBE-0330-010 lishengli
 */
public class Ikenshoget {

    private static final RString CSVファイル名 = new RString("主治医意見書入手一覧.csv");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString UIContainer_DBEUC23101 = new RString("DBEUC23101");

    /**
     * 完了処理・主治医意見書入手の初期化。(オンロード)<br/>
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<IkenshogetDiv> onLoad(IkenshogetDiv div) {
        getHandler(div).initialize();
        if (UIContainer_DBEUC23101.equals(ResponseHolder.getUIContainerId())) {
            return ResponseData.of(div).setState(DBE2070001StateName.登録_完了可能);
        }
        return ResponseData.of(div).setState(DBE2070001StateName.登録);
    }

    /**
     * 状態ラジオボタンの押下チェック処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<IkenshogetDiv> onChange_jyotaiKubun(IkenshogetDiv div) {
        getHandler(div).setJyotaiKubun();
        return ResponseData.of(div).respond();
    }

    /**
     * 最大表示件数テキストボックスの値が変更された際の動作です。
     *
     * @param div IkenshogetDiv
     * @return ResponseData
     */
    public ResponseData onChange_txtMaxNumber(IkenshogetDiv div) {
        getHandler(div).意見書入手List();
        return ResponseData.of(div).respond();
    }

    /**
     * 保険者リスト共有子Div変更時の動作です。
     *
     * @param div ShujiiIkenshoIraiTaishoIchiranDiv
     * @return ResponseData
     */
    public ResponseData onChange_ccdHokenshaList(IkenshogetDiv div) {
        getHandler(div).意見書入手List();
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧表を出力するボタンの押下チェック処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<IkenshogetDiv> onClick_BtnYitiranSyuturyoku(IkenshogetDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (0 == div.getDgNinteiTaskList().getDataSource().size()) {
            主治医意見書入手一覧データの存在チェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if (div.getDgNinteiTaskList().getSelectedItems().isEmpty()) {
            主治医意見書入手一覧データの行選択チェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧表を出力するボタンが押下された場合、ＣＳＶを出力します。
     *
     * @param div IkenshogetDiv
     * @param response IDownLoadServletResponse
     * @return IDownLoadServletResponse
     */
    public IDownLoadServletResponse onClick_btnOutputCsv(IkenshogetDiv div, IDownLoadServletResponse response) {
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), CSVファイル名);
        PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(Code.EMPTY, RString.EMPTY, RString.EMPTY));
        try (CsvWriter<IkenshoNyushuCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.UTF_8withBOM).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(true).build()) {
            List<dgNinteiTaskList_Row> rowList = div.getDgNinteiTaskList().getSelectedItems();
            for (dgNinteiTaskList_Row row : rowList) {
                csvWriter.writeLine(getCsvData(row));
                personalData.addExpandedInfo(new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                        row.getShinseishoKanriNo()));
            }
            csvWriter.close();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(CSVファイル名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        AccessLogger.log(AccessLogType.照会, personalData);
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(entry, CSVファイル名), response);
    }

    /**
     * 意見書を取込むボタンの押下処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<IkenshogetDiv> onClick_BtnIkenshoTorikomi(IkenshogetDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBE2070001TransitionEventName.イメージ取込み_規定_規定外_画面へ遷移).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 意見書を登録するボタンの押下処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<IkenshogetDiv> onClick_BtnIkenshoToroku(IkenshogetDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getDgNinteiTaskList().getSelectedItems().isEmpty()) {
            主治医意見書入手一覧データの行選択チェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            if (0 == div.getDgNinteiTaskList().getDataSource().size()) {
                主治医意見書入手一覧データの存在チェック(validationMessages);
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            if (div.getDgNinteiTaskList().getSelectedItems().size() > 1) {
                主治医意見書入手一覧データの複数行選択チェック(validationMessages);
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            ViewStateHolder.put(ViewStateKeys.申請書管理番号, div.getDgNinteiTaskList().getSelectedItems().get(0).getShinseishoKanriNo());
            ViewStateHolder.put(ViewStateKeys.主治医意見書作成依頼履歴番号, div.getDgNinteiTaskList().getSelectedItems().get(0).getIkenshoIraiRirekiNo());
            return ResponseData.of(div).forwardWithEventName(DBE2070001TransitionEventName.主治医意見書入手へ遷移する).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 意見書を登録するボタンの押下処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<IkenshogetDiv> onClick_BtnIkenshoBack(IkenshogetDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).initialize();
            return ResponseData.of(div).setState(DBE2070001StateName.登録);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医意見書入手を完了するボタンの押下処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<IkenshogetDiv> onClick_BtnIkenshoKanryo(IkenshogetDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getDgNinteiTaskList().getSelectedItems().isEmpty()) {
            主治医意見書入手一覧データの行選択チェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if (0 == div.getDgNinteiTaskList().getDataSource().size()) {
            主治医意見書入手一覧データの存在チェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        boolean 完了条件 = get完了条件(div.getDgNinteiTaskList().getSelectedItems().get(0));
        if (完了条件) {
            主治医意見書入手一覧選択行の完了処理事前チェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if (div.getDgNinteiTaskList().getSelectedItems().get(0).getIkenshoNyushuKanryoDay().getValue() != null) {
            主治医意見書入手一覧選択行の完了処理チェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> サービス一覧情報Model
                    = ViewStateHolder.get(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.class);
            List<dgNinteiTaskList_Row> rowList = div.getDgNinteiTaskList().getSelectedItems();
            for (dgNinteiTaskList_Row row : rowList) {
                RString 申請書管理番号 = row.getShinseishoKanriNo();
                if (!RString.isNullOrEmpty(申請書管理番号)) {
                    NinteiKanryoJoho ninteiKanryoJoho = サービス一覧情報Model.get(
                            new NinteiKanryoJohoIdentifier(new ShinseishoKanriNo(申請書管理番号)));
                    getHandler(div).要介護認定完了情報更新(ninteiKanryoJoho);
                }
            }
            div.getCcdKanryoMsg().setMessage(new RString("基本運用・主治医意見書入手の保存処理が完了しました。"),
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
            FlowParameterAccessor.merge(FlowParameters.of(new RString("key"), new RString("Kanryo")));
            return ResponseData.of(div).setState(DBE2070001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    private boolean get完了条件(dgNinteiTaskList_Row row) {
        RDate 入手日 = row.getNyusyubi().getValue();
        return 入手日 == null || !IkenshogetManager.createInstance().完了処理事前チェック(row.getShinseishoKanriNo());
    }

    private IkenshoNyushuCsvEntity getCsvData(dgNinteiTaskList_Row row) {
        RString jyotaiKubun = null;
        if (row.getJyotai().equals(new RString("未"))) {
            jyotaiKubun = new RString("未処理");
        } else if (row.getJyotai().equals(new RString("可"))) {
            jyotaiKubun = new RString("完了可能");
        }
        return new IkenshoNyushuCsvEntity(
                row.getShinseishoKanriNo(),
                jyotaiKubun,
                row.getHokensha(),
                getパターン1(row.getNinteiShinseiDay().getValue()),
                row.getHihoNumber(),
                row.getHihoShimei(),
                getコード(row.getShinseiKubunShinseiji(), 1),
                row.getShinseiKubunShinseiji(),
                getパターン1(row.getKoshinKanryoDay().getValue()),
                getコード(row.getIkenshoIraiShokai(), 2),
                row.getIkenshoIraiShokai(),
                getパターン1(row.getIkenshoNyushuTeikei().getValue()),
                getパターン1(row.getNyusyubi().getValue()),
                getパターン1(row.getChosaTokusokuHakkoDay().getValue()),
                row.getChosaTokusokuHoho(),
                row.getChosaTokusokuCount().getValue(),
                getパターン1(row.getChosaTokusokuLiit().getValue()),
                RDate.getNowDate().getBetweenDays(row.getNinteiShinseiDay().getValue()));
    }

    private RString getパターン1(RDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
    }

    private RString getコード(RString 名称, int kubun) {
        if (名称 == null || 名称.isEmpty()) {
            return RString.EMPTY;
        }
        if (kubun == 1) {
            return NinteiShinseiShinseijiKubunCode.valueOf(名称.toString()).getコード();
        }
        return IkenshoSakuseiKaisuKubun.toCode(名称).getコード();
    }

    private ValidationMessageControlPairs 主治医意見書入手一覧データの存在チェック(ValidationMessageControlPairs message) {
        return getValidationHandler().主治医意見書入手一覧データの存在チェック(message);
    }

    private ValidationMessageControlPairs 主治医意見書入手一覧データの行選択チェック(ValidationMessageControlPairs message) {
        return getValidationHandler().主治医意見書入手一覧データの行選択チェック(message);
    }

    private ValidationMessageControlPairs 主治医意見書入手一覧データの複数行選択チェック(ValidationMessageControlPairs message) {
        return getValidationHandler().主治医意見書入手一覧データの複数行選択チェック(message);
    }

    private ValidationMessageControlPairs 主治医意見書入手一覧選択行の完了処理チェック(ValidationMessageControlPairs message) {
        return getValidationHandler().主治医意見書入手一覧選択行の完了処理チェック(message);
    }

    private ValidationMessageControlPairs 主治医意見書入手一覧選択行の完了処理事前チェック(ValidationMessageControlPairs message) {
        return getValidationHandler().主治医意見書入手一覧選択行の完了処理事前チェック(message);
    }

    private IkenshogetHandler getHandler(IkenshogetDiv div) {
        return new IkenshogetHandler(div);
    }

    private IkenshogetValidationHandler getValidationHandler() {
        return new IkenshogetValidationHandler();
    }

}
