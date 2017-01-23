/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2040001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ninteishinseijoho.NinteiShinseiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.ikenshoprint.IkenshoPrintParameterModel;
import jp.co.ndensan.reams.db.dbz.definition.core.gamensenikbn.GamenSeniKbn;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2040001.DBE2040001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2040001.ShujiiIkenshoIraiTaishoIchiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2040001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2040001.ShujiiIkenshoIraiCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2040001.ShujiiIkenshoIraiTaishoIchiranHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2040001.ShujiiIkenshoIraiTaishoIchiranValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ikenshosakuseiirai.IkenshoSakuseiIraiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiKaisuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
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

    private static final RString CSVファイル名 = new RString("主治医意見書依頼一覧.csv");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString NOTREATED = new RString("未");
    private static final RString 未処理 = new RString("未処理");
    private static final RString 完了可能 = new RString("完了可能");

    /**
     * 完了処理・主治医意見書依頼の初期化処理です。
     *
     * @param div ShujiiIkenshoIraiTaishoIchiranDiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoIraiTaishoIchiranDiv> onLoad(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        ShujiiIkenshoIraiTaishoIchiranHandler handler = getHandler(div);
        handler.initialize();
        handler.set主治医意見書依頼完了対象者一覧データグリッド();
        if (ViewStateHolder.containsKey(ViewStateKeys.申請書管理番号.name())) {
            ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
            for (dgNinteiTaskList_Row row : div.getDgNinteiTaskList().getDataSource()) {
                if (row.getShinseishoKanriNo().equals(申請書管理番号.value())) {
                    row.setSelected(true);
                    ViewStateHolder.remove(ViewStateKeys.申請書管理番号);
                    break;
                }
            }
        }
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (IkenshoIraiKubun 主治医意見書依頼区分 : IkenshoIraiKubun.values()) {
            dataSource.add(new KeyValueDataSource(主治医意見書依頼区分.getコード(), 主治医意見書依頼区分.get名称()));
        }
        div.getDdlIraiKubun().setDataSource(dataSource);
        return ResponseData.of(div).respond();
    }

    /**
     * 処理状態が変更時、一覧の表示を制御します。<br/>
     * 未処理：key0 完了可能：key1 すべて：key2
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoIraiTaishoIchiranDiv> onChange_radShoriJyotai(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        getHandler(div).set主治医意見書依頼完了対象者一覧データグリッド();
        return ResponseData.of(div).respond();
    }

    /**
     * 画面の表示最大件数が変更時、再検索します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoIraiTaishoIchiranDiv> onChange_txtSaidaiHyojiKensu(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        getHandler(div).set主治医意見書依頼完了対象者一覧データグリッド();
        return ResponseData.of(div).respond();
    }

    /**
     * 保険者リスト共有子Div変更時の動作です。
     *
     * @param div ShujiiIkenshoIraiTaishoIchiranDiv
     * @return ResponseData
     */
    public ResponseData onChange_ccdHokenshaList(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        getHandler(div).set主治医意見書依頼完了対象者一覧データグリッド();
        return ResponseData.of(div).respond();
    }

    /**
     * 「一覧表を出力する」ボタンの押下チェック処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoIraiTaishoIchiranDiv> onClick_BtnYitiranSyuturyoku(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        ValidationMessageControlPairs vallidation = getValidationHandler(div).validateBtnYitiranSyuturyokuClick();
        if (vallidation.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(vallidation).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「一覧表を出力する」ボタンが押下された場合、ＣＳＶを出力します。
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
            List<dgNinteiTaskList_Row> rowList = getHandler(div).getSelectedItems();
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
     * 「意見書作成を依頼する」ボタンクリックイベントです。
     *
     * @param div ShujiiIkenshoIraiTaishoIchiranDiv
     * @return ResponseData
     */
    public ResponseData<ShujiiIkenshoIraiTaishoIchiranDiv> onClick_btnIraisuru(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        ValidationMessageControlPairs vallidation = getValidationHandler(div).validateBtnIraisuruClick();
        if (vallidation.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(vallidation).respond();
        }
        ShujiiIkenshoIraiTaishoIchiranHandler handler = getHandler(div);
        handler.set主治医意見書依頼完了対象者一覧パネル使用可否(true);
        handler.init意見書依頼登録パネル();
        return ResponseData.of(div).setState(DBE2040001StateName.依頼内容入力);
    }

    /**
     * 「依頼する」ボタンクリックイベントです。
     *
     * @param div ShujiiIkenshoIraiTaishoIchiranDiv
     * @return ResponseData
     */
    public ResponseData<ShujiiIkenshoIraiTaishoIchiranDiv> onClick_btnIraiKakutei(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        ValidationMessageControlPairs vallidation = getValidationHandler(div).validateBtnIraiKakuteiClick();
        if (vallidation.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(vallidation).respond();
        }
        ShujiiIkenshoIraiTaishoIchiranHandler handler = getHandler(div);
        handler.set主治医意見書依頼情報();
        handler.set主治医意見書依頼完了対象者一覧パネル使用可否(false);
        return ResponseData.of(div).setState(DBE2040001StateName.登録);
    }

    /**
     * 「依頼せずに戻る」ボタンクリックイベントです。
     *
     * @param div ShujiiIkenshoIraiTaishoIchiranDiv
     * @return ResponseData
     */
    public ResponseData<ShujiiIkenshoIraiTaishoIchiranDiv> onClick_btnIraisezuModoru(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        getHandler(div).set主治医意見書依頼完了対象者一覧パネル使用可否(false);
        return ResponseData.of(div).setState(DBE2040001StateName.登録);
    }

    /**
     * 依頼書/認定調査票（OCR用紙）/主治医意見書印刷画面開く前に処理します。
     *
     * @param div {@link ShujiiIkenshoIraiTaishoIchiranDiv}
     * @return ShujiiIkenshoIraiTaishoIchiranDiv
     */
    public ResponseData<ShujiiIkenshoIraiTaishoIchiranDiv> onBeforeOpenDialog_btnIraishoToOutput(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        ValidationMessageControlPairs vallidation = getValidationHandler(div).validateBtnIraishoToOutputClick();
        if (vallidation.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(vallidation).respond();
        }

        IkenshoPrintParameterModel model = new IkenshoPrintParameterModel();
        List<ShinseishoKanriNo> list = new ArrayList<>();
        for (dgNinteiTaskList_Row row : getHandler(div).getSelectedItems()) {
            if (!RString.isNullOrEmpty(row.getShinseishoKanriNo())) {
                list.add(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
            }
        }
        model.set申請書管理番号リスト(list);
        model.set市町村コード(div.getCcdHokenshaList().getSelectedItem().get市町村コード());
        model.set遷移元画面区分(GamenSeniKbn.主治医意見書依頼);
        div.setHiddenIuputModel(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * 依頼書/認定調査票（OCR用紙）/主治医意見書印刷画面閉じる前に処理します。
     *
     * @param div {@link ShujiiIkenshoIraiTaishoIchiranDiv}
     * @return ShujiiIkenshoIraiTaishoIchiranDiv
     */
    public ResponseData<ShujiiIkenshoIraiTaishoIchiranDiv> onOkClose_btnIraishoToOutput(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        getHandler(div).set主治医意見書依頼完了対象者一覧データグリッド();
        return ResponseData.of(div).respond();
    }

    /**
     * 対象者一覧データグリッドの取消ボタンクリックイベントです。
     *
     * @param div ShujiiIkenshoIraiTaishoIchiranDiv
     * @return ShujiiIkenshoIraiTaishoIchiranDiv
     */
    public ResponseData<ShujiiIkenshoIraiTaishoIchiranDiv> onClick_btnCancel(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        getHandler(div).cancel依頼();
        return ResponseData.of(div).respond();
    }

    /**
     * 「意見書依頼を保存する」ボタンの押下処理です。
     *
     * @param div {@link ShujiiIkenshoIraiTaishoIchiranDiv}
     * @return ShujiiIkenshoIraiTaishoIchiranDiv
     */
    public ResponseData<ShujiiIkenshoIraiTaishoIchiranDiv> onClick_btnUpdate(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        ValidationMessageControlPairs vallidation = getValidationHandler(div).validateBtnUpdateClick();
        if (vallidation.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(vallidation).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ShujiiIkenshoIraiTaishoIchiranHandler handler = getHandler(div);
            IkenshoSakuseiIraiManager manager = IkenshoSakuseiIraiManager.createInstance();
            for (dgNinteiTaskList_Row row : handler.getChangedRow()) {
                NinteiShinseiJoho 要介護認定申請情報 = manager.get要介護認定申請情報(row.getShinseishoKanriNo());
                NinteiShinseiJohoBuilder builder = 要介護認定申請情報.createBuilderForEdit()
                        .set主治医医療機関コード(div.getCcdShujiiInput().getIryoKikanCode())
                        .set主治医コード(div.getCcdShujiiInput().getShujiiCode())
                        .set指定医フラグ(div.getCcdShujiiInput().hasShiteii())
                        .setShujiiIkenshoIraiJoho(handler.create主治医意見書作成依頼(要介護認定申請情報, row));
                manager.saveList(builder.build().modifiedModel());
            }
            div.getCcdKanryoMsg().setMessage(
                    new RString("主治医意見書依頼の保存処理が完了しました。"),
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBE2040001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「意見書依頼を完了する」ボタンの押下処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoIraiTaishoIchiranDiv> onClick_btnChousaIraiKanryo(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        ValidationMessageControlPairs vallidation = getValidationHandler(div).validateBtnChousaIraiKanryoClick();
        if (vallidation.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(vallidation).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            for (dgNinteiTaskList_Row row : getHandler(div).getSelectedItems()) {
                Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> サービス一覧情報Model
                        = ViewStateHolder.get(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.class);
                RString 申請書管理番号 = row.getShinseishoKanriNo();
                if (!RString.isNullOrEmpty(申請書管理番号)) {
                    NinteiKanryoJoho ninteiKanryoJoho = サービス一覧情報Model.get(
                            new NinteiKanryoJohoIdentifier(new ShinseishoKanriNo(申請書管理番号)));
                    getHandler(div).要介護認定完了情報更新(ninteiKanryoJoho);
                }
            }
            div.getCcdKanryoMsg().setMessage(new RString("基本運用・主治医意見書依頼の保存処理が完了しました。"),
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBE2040001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 完了画面の「処理を継続する」を押し、完了処理・主治医意見書依頼の初期化する。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoIraiTaishoIchiranDiv> onClick_btnModoruShujiiIkenshoIraiTaishoIchiran(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        getHandler(div).set主治医意見書依頼完了対象者一覧データグリッド();
        return ResponseData.of(div).setState(DBE2040001StateName.登録);
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
                getパターン1(row.getIkenshoTokusokuHakkoDay().getValue()),
                row.getIkenshoTokusokuHoho(),
                row.getIkenshoTokusokuCount().getValue(),
                getパターン1(row.getIkenshoTokusokuLimit().getValue()),
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

    private ShujiiIkenshoIraiTaishoIchiranValidationHandler getValidationHandler(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        return new ShujiiIkenshoIraiTaishoIchiranValidationHandler(div);
    }

}
