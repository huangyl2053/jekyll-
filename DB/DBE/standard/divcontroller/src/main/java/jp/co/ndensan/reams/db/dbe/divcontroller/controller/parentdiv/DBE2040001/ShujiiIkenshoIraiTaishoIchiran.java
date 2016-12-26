/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2040001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.ikenshoprint.IkenshoPrintParameterModel;
import jp.co.ndensan.reams.db.dbz.definition.core.gamensenikbn.GamenSeniKbn;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2040001.DBE2040001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2040001.DBE2040001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2040001.ShujiiIkenshoIraiTaishoIchiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2040001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2040001.ShujiiIkenshoIraiCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2040001.ShujiiIkenshoIraiTaishoIchiranHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2040001.ShujiiIkenshoIraiTaishoIchiranValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
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
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
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
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 完了処理・主治医意見書依頼のクラスです。
 *
 * @reamsid_L DBE-0320-010 lishengli
 */
public class ShujiiIkenshoIraiTaishoIchiran {

    private static final LockingKey 排他キー = new LockingKey(new RString("ShinseishoKanriNo"));
    private static final RString CSVファイル名 = new RString("ShujiiIkenshoIraiIchiran.csv");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString NOTREATED = new RString("未");
    private static final RString 未処理 = new RString("未処理");
    private static final RString 完了可能 = new RString("完了可能");
    
    /**
     * 完了処理・主治医意見書依頼の初期化。(オンロード)<br/>
     *
     * @param div ShujiiIkenshoIraiTaishoIchiranDiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoIraiTaishoIchiranDiv> onLoad(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        if (!RealInitialLocker.tryGetLock(排他キー)) {
            throw new PessimisticLockingException();
        }        
        RString 検索制御_最大取得件数上限 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 検索制御_最大取得件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
//        div.getTxtSaidaiHyojiKensu().setMaxValue(new Decimal(検索制御_最大取得件数上限.toString()));
//        div.getTxtSaidaiHyojiKensu().setValue(new Decimal(検索制御_最大取得件数.toString()));
        getHandler(div).initialize();
        return ResponseData.of(div).setState(DBE2040001StateName.登録);
    }

    /**
     * 処理状態が変更時、一覧の表示を制御します。 未処理：key0 完了可能：key1 すべて：key2
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoIraiTaishoIchiranDiv> onChange_radShoriJyotai(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        RString 検索制御_最大取得件数上限 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 検索制御_最大取得件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
//        if (div.getTxtSaidaiHyojiKensu().getValue() == null) {
//            div.getTxtSaidaiHyojiKensu().setMaxValue(new Decimal(検索制御_最大取得件数上限.toString()));
//            div.getTxtSaidaiHyojiKensu().setValue(new Decimal(検索制御_最大取得件数.toString()));
//        }
        getHandler(div).画面変更より最新データを検索();
        return ResponseData.of(div).respond();
    }
    
    /**
     * 画面の表示最大件数が変更時、再検索します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoIraiTaishoIchiranDiv> onChange_txtSaidaiHyojiKensu(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        getHandler(div).画面変更より最新データを検索();
        return ResponseData.of(div).respond();
    }
    
    /**
     * 完了画面の「処理を継続する」を押し、完了処理・主治医意見書依頼の初期化する。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoIraiTaishoIchiranDiv> onClick_btnModoruShujiiIkenshoIraiTaishoIchiran(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        onLoad(div);
        return ResponseData.of(div).setState(DBE2040001StateName.登録);
    }
    
    /**
     * 一覧表を出力するボタンの押下チェック処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoIraiTaishoIchiranDiv> onClick_BtnYitiranSyuturyoku(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (new RString("0").equals(getHandler(div).一覧件数())) {
            getValidationHandler().主治医意見書作成依頼一覧データの存在チェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if (getHandler(div).getCheckbox() == null || getHandler(div).getCheckbox().isEmpty()) {
            getValidationHandler().主治医意見書作成依頼一覧データの行選択チェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧表を出力するボタンが押下された場合、ＣＳＶを出力します。
     *
     * @param div ShujiiIkenshoIraiTaishoIchiranDiv
     * @param response IDownLoadServletResponse
     * @return IDownLoadServletResponse
     */
    public IDownLoadServletResponse onClick_btnOutputCsv(ShujiiIkenshoIraiTaishoIchiranDiv div, IDownLoadServletResponse response) {
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), CSVファイル名);
        PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(Code.EMPTY, RString.EMPTY, RString.EMPTY));
        try (CsvWriter<ShujiiIkenshoIraiCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(true).build()) {
            List<dgNinteiTaskList_Row> rowList = getHandler(div).getCheckbox();
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
     * 意見書作成を依頼するボタンの押下処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoIraiTaishoIchiranDiv> onClick_btnShujiiIrai(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (new RString("0").equals(getHandler(div).一覧件数())) {
            getValidationHandler().主治医意見書作成依頼一覧データの存在チェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if (getHandler(div).getCheckbox() == null || getHandler(div).getCheckbox().isEmpty()) {
            getValidationHandler().主治医意見書作成依頼一覧データの行選択チェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if (getHandler(div).getCheckbox().size() > 1) {
            getValidationHandler().主治医意見書作成依頼一覧データの複数行選択チェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        ViewStateHolder.put(ViewStateKeys.申請書管理番号, new ShinseishoKanriNo(getHandler(div).getCheckbox().get(0).getShinseishoKanriNo()));
        RealInitialLocker.release(排他キー);
        return ResponseData.of(div).forwardWithEventName(DBE2040001TransitionEventName.主治医意見書作成依頼画面へ遷移する).respond();
    }

    /**
     * 依頼書/認定調査票（OCR用紙）/主治医意見書印刷画面開く前に処理します。
     *
     * @param div {@link ShujiiIkenshoIraiTaishoIchiranDiv}
     * @return ShujiiIkenshoIraiTaishoIchiranDiv
     */
    public ResponseData<ShujiiIkenshoIraiTaishoIchiranDiv> onBeforeOpenDialog_btnIraishoToOutput(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (new RString("0").equals(getHandler(div).一覧件数())) {
            getValidationHandler().主治医意見書作成依頼一覧データの存在チェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if (getHandler(div).getCheckbox() == null || getHandler(div).getCheckbox().isEmpty()) {
            getValidationHandler().主治医意見書作成依頼一覧データの行選択チェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        List<dgNinteiTaskList_Row> rowList = getHandler(div).getCheckbox();
        for (dgNinteiTaskList_Row row : rowList) {
            if (row.getIkenshoIraiDay().getValue() == null) {
                getValidationHandler().医療機関_主治医が割りつけられていないチェック(validationMessages);
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
        }
        IkenshoPrintParameterModel model = new IkenshoPrintParameterModel();
        List<ShinseishoKanriNo> list = new ArrayList<>();
        for (dgNinteiTaskList_Row row : rowList) {
            if (!RString.isNullOrEmpty(row.getShinseishoKanriNo())) {
                list.add(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
            }
        }
        model.set申請書管理番号リスト(list);
        model.set遷移元画面区分(GamenSeniKbn.主治医意見書依頼);
        div.setHiddenIuputModel(DataPassingConverter.serialize(model));
        RealInitialLocker.release(排他キー);
        return ResponseData.of(div).respond();
    }

    /**
     * 依頼書/認定調査票（OCR用紙）/主治医意見書印刷画面閉じる前に処理します。
     *
     * @param div {@link ShujiiIkenshoIraiTaishoIchiranDiv}
     * @return ShujiiIkenshoIraiTaishoIchiranDiv
     */
    public ResponseData<ShujiiIkenshoIraiTaishoIchiranDiv> onOkClose_btnIraishoToOutput(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 意見書依頼を完了するボタンの押下処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoIraiTaishoIchiranDiv> onClick_btnChousaIraiKanryo(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (new RString("0").equals(getHandler(div).一覧件数())) {
            getValidationHandler().主治医意見書作成依頼一覧データの存在チェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if (getHandler(div).getCheckbox() == null || getHandler(div).getCheckbox().isEmpty()) {
            getValidationHandler().主治医意見書作成依頼一覧データの行選択チェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
            && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            List<dgNinteiTaskList_Row> rowList = getHandler(div).getCheckbox();
            for (dgNinteiTaskList_Row row : rowList) {
                if (RString.isNullOrEmpty(row.getKonkaiShujiiIryokikan()) || RString.isNullOrEmpty(row.getKonkaiShujii())) {
                    getValidationHandler().主治医意見書作成依頼一覧選択行の完了処理事前チェック(validationMessages);
                    return ResponseData.of(div).addValidationMessages(validationMessages).respond();
                }
                if (row.getIkenshoIraiDay().getValue() == null) {
                    getValidationHandler().依頼日が未確定の完了必須チェック(validationMessages);
                    return ResponseData.of(div).addValidationMessages(validationMessages).respond();
                }
                if (row.getIkenshoIraiKigen().getValue() == null) {
                    getValidationHandler().依頼期限が未確定の完了必須チェック(validationMessages);
                    return ResponseData.of(div).addValidationMessages(validationMessages).respond();
                }
                if (row.getIkenshoIraiIkenshoShutsuryokuDay().getValue() == null) {
                    getValidationHandler().意見書書発行日が未確定の完了必須チェック(validationMessages);
                    return ResponseData.of(div).addValidationMessages(validationMessages).respond();
                }
                if (row.getIkenshoIraiIraishoHakkoDay().getValue() == null) {
                    getValidationHandler().意見書出力年月日が未確定の完了必須チェック(validationMessages);
                    return ResponseData.of(div).addValidationMessages(validationMessages).respond();
                }
                Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> サービス一覧情報Model
                        = ViewStateHolder.get(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.class);
                RString 申請書管理番号 = row.getShinseishoKanriNo();
                if (!RString.isNullOrEmpty(申請書管理番号)) {
                    NinteiKanryoJoho ninteiKanryoJoho = サービス一覧情報Model.get(
                            new NinteiKanryoJohoIdentifier(new ShinseishoKanriNo(申請書管理番号)));
                    getHandler(div).要介護認定完了情報更新(ninteiKanryoJoho);
                }
            }
            RealInitialLocker.release(排他キー);
            div.getCcdKanryoMsg().setMessage(new RString("完了処理・主治医意見書依頼の保存処理が完了しました。"),
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBE2040001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    private ShujiiIkenshoIraiCsvEntity getCsvData(dgNinteiTaskList_Row row) {
        return new ShujiiIkenshoIraiCsvEntity(
                row.getShinseishoKanriNo(),
                処理区分変更(row.getJyotai()),
                row.getHokensha(),
                getパターン1(row.getNinteiShinseiDay().getValue()),
                row.getHihoNumber(),
                row.getHihoShimei(),
                getコード(row.getShinseiKubunShinseiji(), 1),
                row.getShinseiKubunShinseiji(),
                row.getIkenshoIraiIkenCount().getValue(),
                getパターン1(row.getIkenshoIraiDay().getValue()),
                getパターン1(row.getIkenshoIraiIraishoHakkoDay().getValue()),
                getパターン1(row.getIkenshoIraiIkenshoShutsuryokuDay().getValue()),
                getパターン1(row.getIkenshoIraiKigen().getValue()),
                getコード(row.getIkenshoIraiShokai(), 2),
                row.getIkenshoIraiShokai(),
                row.getKonkaiShujiiIryokikan(),
                row.getKonkaiShujii(),
                row.getZenkaiIryokikan(),
                row.getZenkaiShujii(),
                郵便番号編集(row.getYubinNumber()),
                row.getJusho(),
                row.getNyushoShisetsuCode(),
                row.getNyushoShisetsu(),
                RDate.getNowDate().getBetweenDays(row.getNinteiShinseiDay().getValue()));
    }

    private RString 郵便番号編集(RString 郵便番号) {
        if (!RString.isNullOrEmpty(郵便番号)) {
            return new YubinNo(郵便番号).getEditedYubinNo();
        }
        return RString.EMPTY;
    }
    
    private RString 処理区分変更(RString 処理区分) {
        if (NOTREATED.equals(処理区分)) {
            return 未処理;
        } else {
            return 完了可能;
        }
    }

    private RString getコード(RString 名称, int kubun) {
        if (名称 == null || 名称.isEmpty()) {
            return RString.EMPTY;
        }
        if (kubun == 1) {
            return NinteiShinseiShinseijiKubunCode.valueOf(名称.toString()).getコード();
        }
        return IkenshoSakuseiKaisuKubun.valueOf(名称.toString()).getコード();
    }

    private RString getパターン1(RDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.wareki().toDateString();
    }

    private ShujiiIkenshoIraiTaishoIchiranHandler getHandler(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        return new ShujiiIkenshoIraiTaishoIchiranHandler(div);
    }

    private ShujiiIkenshoIraiTaishoIchiranValidationHandler getValidationHandler() {
        return new ShujiiIkenshoIraiTaishoIchiranValidationHandler();
    }

}
