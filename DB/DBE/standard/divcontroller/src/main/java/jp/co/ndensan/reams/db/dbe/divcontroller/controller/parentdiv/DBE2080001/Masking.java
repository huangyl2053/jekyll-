/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2080001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshoiraitaishoichiran.ShinseishoKanriNoList;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2080001.DBE2080001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2080001.DBE2080001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2080001.MaskingDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2080001.dgYokaigoNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2080001.MaskingHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2080001.MaskingIchiranCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2080001.MaskingValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ikenshoget.IkenshogetManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.KihonunyoShoriJotai;
import jp.co.ndensan.reams.db.dbz.service.core.DbAccessLogger;
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
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 完了処理・マスキングのクラスです。
 *
 * @reamsid_L DBE-2080-010 lishengli
 */
public class Masking {

    private static final RString CSVファイルID_マスキング一覧 = new RString("DBE208001");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString UICONTAINERID_DBEUC20801 = new RString("DBEUC20801");
    private static final RString 完了可能 = new RString("2");
    private static final RString 一次判定後 = new RString("1");
    private static final RString 審査会割当後 = new RString("2");
    private static final RString 完了ボタン = new RString("btnCompleteMasking");

    /**
     * 完了処理・センター送信の初期化。(オンロード)<br/>
     *
     * @param div MaskingDiv
     * @return レスポンスデータ
     */
    public ResponseData<MaskingDiv> onLoad(MaskingDiv div) {
        div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        if (ResponseHolder.getUIContainerId().equals(UICONTAINERID_DBEUC20801)) {
            div.getRadTaishoDataKubun().setSelectedKey(DbBusinessConfig.get(ConfigNameDBE.基本運用_対象者一覧表示区分, RDate.getNowDate(),
                    SubGyomuCode.DBE認定支援));
        } else {
            div.getRadTaishoDataKubun().setSelectedKey(完了可能);
            div.getRadTaishoDataKubun().setDisabled(true);
        }
        RString マスキングタイミング = DbBusinessConfig.get(ConfigNameDBE.マスキングチェックタイミング, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (一次判定後.equals(マスキングタイミング)) {
            CommonButtonHolder.setPrefixTextByCommonButtonFieldName(完了ボタン, new RString("申請を審査会登録に").toString());
        } else if (審査会割当後.equals(マスキングタイミング)) {
            CommonButtonHolder.setPrefixTextByCommonButtonFieldName(完了ボタン, new RString("申請を結果登録に").toString());
        }
        div.getTxtSaidaiHyojiKensu().setMaxValue(
                new Decimal(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getTxtSaidaiHyojiKensu().setValue(
                new Decimal(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 保険者リストDDLのonChangeイベントです。<br />
     * 一覧表の表示データを制御します。
     *
     * @param div MaskingDiv
     * @return レスポンスデータ
     */
    public ResponseData<MaskingDiv> onChange_ccdHokenshaList(MaskingDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧表の表示データを制御する処理です。
     *
     * @param div MaskingDiv
     * @return レスポンスデータ
     */
    public ResponseData<MaskingDiv> onChange_radTaishoDataKubun(MaskingDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧表の表示データを制御する処理です。
     *
     * @param div MaskingDiv
     * @return レスポンスデータ
     */
    public ResponseData<MaskingDiv> onChange_TxtSaidaiHyojiKensu(MaskingDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧表の表示データを制御する処理です。
     *
     * @param div MaskingDiv
     * @return レスポンスデータ
     */
    public ResponseData<MaskingDiv> onClick_btnShorikeizoku(MaskingDiv div) {
        getHandler(div).initialize();
        if (ResponseHolder.getUIContainerId().equals(UICONTAINERID_DBEUC20801)) {
            return ResponseData.of(div).setState(DBE2080001StateName.登録);
        } else {
            return ResponseData.of(div).setState(DBE2080001StateName.登録fromサブメニュー);
        }
    }

    /**
     * 一覧表を出力するボタンの押下チェック処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<MaskingDiv> onClick_BtnDataOutput(MaskingDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getDgYokaigoNinteiTaskList().getDataSource().isEmpty()) {
            getValidationHandler().マスキング完了対象者一覧データの存在チェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if (is選択なし(div.getDgYokaigoNinteiTaskList().getDataSource())) {
            getValidationHandler().マスキング完了対象者一覧データの行選択チェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧表を出力するボタンが押下された場合、ＣＳＶを出力します。
     *
     * @param div MaskingDiv
     * @param response IDownLoadServletResponse
     * @return IDownLoadServletResponse
     */
    public IDownLoadServletResponse onClick_btnOutputCsv(MaskingDiv div, IDownLoadServletResponse response) {
        RString 出力名 = EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, CSVファイルID_マスキング一覧);
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), 出力名);
        DbAccessLogger accessLog = new DbAccessLogger();
        try (CsvWriter<MaskingIchiranCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build()) {
            List<dgYokaigoNinteiTaskList_Row> rowList = div.getDgYokaigoNinteiTaskList().getDataSource();
            for (dgYokaigoNinteiTaskList_Row row : rowList) {
                if (row.getSelected()) {
                    ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                            row.getShinseishoKanriNo());
                    accessLog.store(new ShoKisaiHokenshaNo(row.getShoKisaiHokenshaNo()), row.getHihoNumber(), expandedInfo);
                    csvWriter.writeLine(getCsvData(row));
                }
            }
            csvWriter.close();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(出力名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        accessLog.flushBy(AccessLogType.照会);
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(entry, 出力名), response);
    }

    /**
     * マスキングボタンの押下処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<MaskingDiv> onClick_BtnMasking(MaskingDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getDgYokaigoNinteiTaskList().getDataSource().isEmpty()) {
            getValidationHandler().マスキング完了対象者一覧データの存在チェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if (is選択なし(div.getDgYokaigoNinteiTaskList().getDataSource())) {
            getValidationHandler().マスキング完了対象者一覧データの行選択チェック(validationMessages);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        申請書管理番号リスト(div.getDgYokaigoNinteiTaskList().getDataSource());
        return ResponseData.of(div).forwardWithEventName(DBE2080001TransitionEventName.マスキング).respond();

    }

    /**
     * マスキングを完了するボタンの押下処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<MaskingDiv> onClick_BtnCompleteMasking(MaskingDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            if (div.getDgYokaigoNinteiTaskList().getDataSource().isEmpty()) {
                getValidationHandler().マスキング完了対象者一覧データの存在チェック(validationMessages);
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            if (is選択なし(div.getDgYokaigoNinteiTaskList().getDataSource())) {
                getValidationHandler().マスキング完了対象者一覧データの行選択チェック(validationMessages);
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            for (dgYokaigoNinteiTaskList_Row row : div.getDgYokaigoNinteiTaskList().getDataSource()) {
                if (row.getSelected() && row.getJyuJiIiKenJyo().equals(RString.EMPTY)) {
                    getValidationHandler().マスキング完了対象者一覧データの完了可能チェック(validationMessages);
                    return ResponseData.of(div).addValidationMessages(validationMessages).respond();
                }
            }
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.確認_汎用.getMessage().getCode(),
                    UrQuestionMessages.確認_汎用.getMessage().replace("マスキングの完了日を登録します。").evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            List<dgYokaigoNinteiTaskList_Row> rowList = div.getDgYokaigoNinteiTaskList().getDataSource();
            List<PersonalData> personalDataList = new ArrayList<>();
            for (dgYokaigoNinteiTaskList_Row row : rowList) {
                if (!row.getSelected()) {
                    continue;
                }
                Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> サービス一覧情報Model
                        = ViewStateHolder.get(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.class);
                RString 申請書管理番号 = row.getShinseishoKanriNo();
                if (!RString.isNullOrEmpty(申請書管理番号) && row.getJyuJiIiKenJyo().equals(new RString("○"))) {
                    NinteiKanryoJoho ninteiKanryoJoho = サービス一覧情報Model.get(
                            new NinteiKanryoJohoIdentifier(new ShinseishoKanriNo(申請書管理番号)));
                    ninteiKanryoJoho = getHandler(div).要介護認定完了情報更新(ninteiKanryoJoho);
                    IkenshogetManager.createInstance().要介護認定完了情報更新(ninteiKanryoJoho);
                    PersonalData personalData = PersonalData.of(new ShikibetsuCode(row.getShoKisaiHokenshaNo().padZeroToLeft(6).substring(0, 5)
                            .concat(row.getHihoNumber())), new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                                    row.getShinseishoKanriNo()));
                    personalDataList.add(personalData);
                }
            }
            AccessLogger.log(AccessLogType.更新, personalDataList);
            div.getCcdKanryoMsg().setMessage(new RString("完了処理・マスキングの保存処理が完了しました。"),
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBE2080001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    private boolean is選択なし(List<dgYokaigoNinteiTaskList_Row> rowList) {
        for (dgYokaigoNinteiTaskList_Row row : rowList) {
            if (row.getSelected()) {
                return false;
            }
        }
        return true;
    }

    private MaskingIchiranCsvEntity getCsvData(dgYokaigoNinteiTaskList_Row row) {
        return new MaskingIchiranCsvEntity(
                row.getJohtai().equals(KihonunyoShoriJotai.未処理.get略称()) ? KihonunyoShoriJotai.未処理.get名称() : KihonunyoShoriJotai.処理可能.get名称(),
                row.getShinseishoKanriNo(),
                row.getHokensha(),
                getパターン1(row.getNinteiShinseiDay().getValue()),
                row.getHihoNumber(),
                row.getHihoShimei(),
                row.getShinseiKubunShinseiji(),
                getパターン1(row.getChosaIraiKanryoDay().getValue()),
                getパターン1(row.getChosahyoKanryoDay().getValue()),
                getパターン1(row.getIkenshoIraiKanryoDay().getValue()),
                getパターン1(row.getIkenshoNyushuKanryoDay().getValue()));
    }

    private void 申請書管理番号リスト(List<dgYokaigoNinteiTaskList_Row> 選択データ) {
        List<RString> 申請書管理番号リスト = new ArrayList<>();
        for (dgYokaigoNinteiTaskList_Row データ : 選択データ) {
            if (データ.getSelected()) {
                申請書管理番号リスト.add(データ.getShinseishoKanriNo());
            }
        }
        ShinseishoKanriNoList shinseishoKanriNoList = new ShinseishoKanriNoList();
        shinseishoKanriNoList.setShinseishoKanriNoS(申請書管理番号リスト);
        ViewStateHolder.put(ViewStateKeys.申請書管理番号リスト, shinseishoKanriNoList);
    }

    private RString getパターン1(RDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
    }

    private MaskingHandler getHandler(MaskingDiv div) {
        return new MaskingHandler(div);
    }

    private MaskingValidationHandler getValidationHandler() {
        return new MaskingValidationHandler();
    }
}
