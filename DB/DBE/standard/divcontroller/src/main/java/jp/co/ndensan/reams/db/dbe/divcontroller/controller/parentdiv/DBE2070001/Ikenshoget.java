/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2070001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2070001.DBE2070001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2070001.DBE2070001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2070001.IkenshogetDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2070001.IkenshoNyushuCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2070001.IkenshogetHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2070001.IkenshogetValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ikenshoget.IkenshogetManager;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiKaisuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
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
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 完了処理・主治医意見書入手のクラスです。
 *
 * @reamsid_L DBE-0330-010 lishengli
 */
public class Ikenshoget {

    private static final RString CSVファイル名 = new RString("ShujiiIkenshoNyushuIchiran.csv");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString SHINSEISHOKANRINO = new RString("ShinseishoKanriNo");

    /**
     * 完了処理・主治医意見書入手の初期化。(オンロード)<br/>
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<IkenshogetDiv> onLoad(IkenshogetDiv div) {
        getHandler(div).initialize();
        if (!前排他キーのセット(SHINSEISHOKANRINO)) {
            ErrorMessage errorMessage = new ErrorMessage(UrErrorMessages.排他_他のユーザが使用中.getMessage().getCode(),
                    UrErrorMessages.排他_他のユーザが使用中.getMessage().evaluate());
            throw new ApplicationException(errorMessage);
        }
        return ResponseData.of(div).setState(DBE2070001StateName.登録);
    }

    /**
     * 一覧表を出力するボタンの押下チェック処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<IkenshogetDiv> onClick_BtnYitiranSyuturyoku(IkenshogetDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (new RString("0").equals(div.getCcdTaskList().一览件数())) {
            主治医意見書入手一覧データの存在チェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if (div.getCcdTaskList().getCheckbox() == null || div.getCcdTaskList().getCheckbox().isEmpty()) {
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
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(false).build()) {
            List<dgNinteiTaskList_Row> rowList = div.getCcdTaskList().getCheckbox();
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
        outputJokenhyoFactory(div.getCcdTaskList().一览件数(), div);
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(entry, CSVファイル名), response);
    }

    private void outputJokenhyoFactory(RString 一览件数, IkenshogetDiv div) {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                new RString("主治医意見書入手一覧"),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString("56"),
                CSVファイル名,
                new RString("DBE207001"),
                get一览件数(一览件数),
                contribute(div));
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private RString get一览件数(RString 一览件数) {
        return DecimalFormatter.toコンマ区切りRString(new Decimal(一览件数.toString()), 0);
    }

    private List<RString> contribute(IkenshogetDiv div) {
        List<RString> 出力条件 = new ArrayList<>();
        for (dgNinteiTaskList_Row row : div.getCcdTaskList().getCheckbox()) {
            出力条件.add(get条件(new RString("申請書管理番号"), row.getShinseishoKanriNo()));
            出力条件.add(get条件(new RString("保険者"), row.getHokensha()));
            出力条件.add(get条件(new RString("認定申請日"), getパターン1(row.getNinteiShinseiDay().getValue())));
            出力条件.add(get条件(new RString("被保険者_被保番号"), row.getHihoNumber()));
            出力条件.add(get条件(new RString("被保険者_氏名"), row.getHihoShimei()));
            出力条件.add(get条件(new RString("申請区分_申請時コード"), getコード(row.getShinseiKubunShinseiji(), 1)));
            出力条件.add(get条件(new RString("申請区分_申請時"), row.getShinseiKubunShinseiji()));
            出力条件.add(get条件(new RString("意見書依頼_完了日"), getパターン1(row.getIkenshoIraiKanryoDay().getValue())));
            出力条件.add(get条件(new RString("意見書入手_完了日"), getパターン1(row.getIkenshoNyushuKanryoDay().getValue())));
            出力条件.add(get条件(new RString("意見書入手_意見書_定型_定形外"), getパターン1(row.getIkenshoNyushuTeikei().getValue())));
            出力条件.add(get条件(new RString("意見書依頼_初回_2回目コード"), getコード(row.getIkenshoIraiShokai(), 2)));
            出力条件.add(get条件(new RString("意見書依頼_初回_2回目"), row.getIkenshoIraiShokai()));
            出力条件.add(get条件(new RString("意見書督促_督促発行日"), getパターン1(row.getChosaTokusokuHakkoDay().getValue())));
            出力条件.add(get条件(new RString("意見書督促_方法"), row.getChosaTokusokuHoho()));
            出力条件.add(get条件(new RString("意見書督促_回数"), get意見書督促_回数(row.getChosaTokusokuCount().getValue())));
            出力条件.add(get条件(new RString("意見書督促_期限"), getパターン1(row.getChosaTokusokuLiit().getValue())));
            出力条件.add(get条件(new RString("経過日数"), new RString(RDate.getNowDate().getBetweenDays(row.getNinteiShinseiDay().getValue()))));
        }
        return 出力条件;
    }

    private RString get意見書督促_回数(Decimal 回数) {
        if (回数 == null) {
            return RString.EMPTY;
        }
        return new RString(回数.toString());
    }

    private RString get条件(RString バッチパラメータ名, RString 値) {
        RStringBuilder 条件 = new RStringBuilder();
        条件.append("【");
        条件.append(バッチパラメータ名);
        条件.append("】");
        条件.append(値);
        return 条件.toRString();
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
            前排他キーの解除(SHINSEISHOKANRINO);
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
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            if (new RString("0").equals(div.getCcdTaskList().一览件数())) {
                主治医意見書入手一覧データの存在チェック(validationMessages);
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            if (div.getCcdTaskList().getCheckbox() == null || div.getCcdTaskList().getCheckbox().isEmpty()) {
                主治医意見書入手一覧データの行選択チェック(validationMessages);
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            if (div.getCcdTaskList().getCheckbox().size() > 1) {
                主治医意見書入手一覧データの複数行選択チェック(validationMessages);
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            ViewStateHolder.put(ViewStateKeys.要介護認定申請検索_申請書管理番号, div.getCcdTaskList().getCheckbox().get(0).getShinseishoKanriNo());
            ViewStateHolder.put(ViewStateKeys.要介護認定申請検索_主治医意見書作成依頼履歴番号, div.getCcdTaskList().getCheckbox().get(0).getChosaIraiKubun());
            前排他キーの解除(SHINSEISHOKANRINO);
            return ResponseData.of(div).forwardWithEventName(DBE2070001TransitionEventName.主治医意見書入手へ遷移する).respond();
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
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            if (new RString("0").equals(div.getCcdTaskList().一览件数())) {
                主治医意見書入手一覧データの存在チェック(validationMessages);
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            if (div.getCcdTaskList().getCheckbox() == null || div.getCcdTaskList().getCheckbox().isEmpty()) {
                主治医意見書入手一覧データの行選択チェック(validationMessages);
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            boolean 完了条件 = get完了条件(div.getCcdTaskList().getCheckbox().get(0));
            if (完了条件) {
                主治医意見書入手一覧選択行の完了処理チェック(validationMessages);
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            if (div.getCcdTaskList().getCheckbox().get(0).getIkenshoNyushuKanryoDay().getValue() != null) {
                主治医意見書入手一覧選択行の完了処理事前チェック(validationMessages);
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            getHandler(div).要介護認定完了情報更新();
            前排他キーの解除(SHINSEISHOKANRINO);
            div.getCcdKanryoMsg().setMessage(new RString("完了処理・主治医意見書入手"),
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBE2070001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    private boolean get完了条件(dgNinteiTaskList_Row row) {
        RDate 意見書_定型_定形外 = row.getIkenshoNyushuTeikei().getValue();
        return 意見書_定型_定形外 == null || IkenshogetManager.createInstance().完了処理事前チェック(row.getShinseishoKanriNo());
    }

    private IkenshoNyushuCsvEntity getCsvData(dgNinteiTaskList_Row row) {
        return new IkenshoNyushuCsvEntity(row.getShinseishoKanriNo(),
                row.getHokensha(),
                getパターン1(row.getNinteiShinseiDay().getValue()),
                row.getHihoNumber(),
                row.getHihoShimei(),
                getコード(row.getShinseiKubunShinseiji(), 1),
                row.getShinseiKubunShinseiji(),
                getパターン1(row.getIkenshoIraiKanryoDay().getValue()),
                getパターン1(row.getIkenshoNyushuKanryoDay().getValue()),
                getパターン1(row.getIkenshoNyushuTeikei().getValue()),
                getコード(row.getIkenshoIraiShokai(), 2),
                row.getIkenshoIraiShokai(),
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
        return date.wareki().toDateString();
    }

    private RString getコード(RString 名称, int kubun) {
        if (名称 == null || !名称.isEmpty()) {
            return RString.EMPTY;
        }
        if (kubun == 1) {
            return NinteiShinseiShinseijiKubunCode.valueOf(名称.toString()).getコード();
        }
        return IkenshoSakuseiKaisuKubun.valueOf(名称.toString()).getコード();
    }

    private boolean 前排他キーのセット(RString 申請書管理番号) {
        LockingKey 排他キー = new LockingKey(申請書管理番号);
        return RealInitialLocker.tryGetLock(排他キー);
    }

    private void 前排他キーの解除(RString 申請書管理番号) {
        LockingKey 排他キー = new LockingKey(申請書管理番号);
        RealInitialLocker.release(排他キー);
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
