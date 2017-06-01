/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE3100001;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbe.business.core.ichijihanteiresult.IchijiHanteiKekkaResultConveter;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiShoriKekka;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.definition.core.util.accesslog.ExpandedInformations;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeInformationMessages;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeQuestionMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3100001.DBE3100001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3100001.KanryoshoriIchijihanteiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3100001.dgHanteiTaishosha_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3100001.KanryoshoriCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3100001.KanryoshoriIchijihanteiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3100001.KanryoshoriIchijihanteiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.NinteiKanryoJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.ichijihanteikekkajohosearch.IchijiHanteiKekkaJohoSearchManager;
import jp.co.ndensan.reams.db.dbe.service.core.ichijipanteisyori.IChiJiPanTeiSyoRiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.service.core.DbAccessLogger;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.euc.api.EucOtherInfo;
import jp.co.ndensan.reams.uz.uza.euc.cooperation.EucDownload;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 完了処理・一次判定のクラスです。
 *
 * @reamsid_L DBE-2070-010 wangrenze
 */
public class KanryoshoriIchijihantei {

    private static final RString CSVファイルID = new RString("DBE310001");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");

    /**
     * 画面初期化。(オンロード)<br/>
     *
     * @param div KanryoshoriIchijihanteiDiv
     * @return レスポンスデータ
     */
    public ResponseData<KanryoshoriIchijihanteiDiv> onLoad(KanryoshoriIchijihanteiDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 処理対象を示すラジオボタンに変更があった場合に発生するイベントです。<br/>
     * 処理対象者の再検索を行います。
     *
     * @param div KanryoshoriIchijihanteiDiv
     * @return レスポンスデータ
     */
    public ResponseData<KanryoshoriIchijihanteiDiv> onChange_radStatus(KanryoshoriIchijihanteiDiv div) {
        return research(div);
    }

    /**
     * 処理対象者の最大表示件数に変更があった場合に発生するイベントです。<br/>
     * 処理対象者の再検索を行います。
     *
     * @param div KanryoshoriIchijihanteiDiv
     * @return レスポンスデータ
     */
    public ResponseData<KanryoshoriIchijihanteiDiv> onChange_txtMaxCount(KanryoshoriIchijihanteiDiv div) {
        return research(div);
    }

    /**
     * 保険者の値が変更された際の動作です。
     *
     * @param div KanryoshoriIchijihanteiDiv
     * @return レスポンスデータ
     */
    public ResponseData<KanryoshoriIchijihanteiDiv> onChange_ccdHokensha(KanryoshoriIchijihanteiDiv div) {
        return research(div);
    }

    private ResponseData<KanryoshoriIchijihanteiDiv> research(KanryoshoriIchijihanteiDiv div) {

        if (!ResponseHolder.isReRequest()) {
            Models<IchijiHanteiKekkaJohoIdentifier, IchijiHanteiKekkaJoho> models
                    = ViewStateHolder.get(ViewStateKeys.要介護認定一次判定結果情報, Models.class);
            if (models.hasAnyChanged()) {
                return ResponseData.of(div).addMessage(UrWarningMessages.未保存情報の破棄確認.getMessage().replace("一次判定結果")).respond();
            }

            getHandler(div).set対象者一覧();
            getHandler(div).set対象者数();
            getHandler(div).setHiddenSearchCondition();
        }

        if (new RString(UrWarningMessages.未保存情報の破棄確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            getHandler(div).set対象者一覧();
            getHandler(div).set対象者数();
            getHandler(div).setHiddenSearchCondition();
        } else if (new RString(UrWarningMessages.未保存情報の破棄確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            getHandler(div).resetSearchCondition();
        }

        getHandler(div).setCommonButtonDisabled();
        return ResponseData.of(div).respond();
    }

    /**
     * グリッドに用意されている取消BTNをクリックした場合に処理を行います。<br/>
     * クリックした行のデータを修正前の状態に戻します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<KanryoshoriIchijihanteiDiv> onCancel_dgHanteiTaishosha(KanryoshoriIchijihanteiDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }

        dgHanteiTaishosha_Row row = div.getIchijiHanteiShoriTaishoshaIchiran().getDgHanteiTaishosha().getClickedItem();
        if (!row.getRowState().equals(RowState.Modified)) {
            return ResponseData.of(div).addMessage(UrErrorMessages.項目に対する制約
                    .getMessage().replace("取消対象", "修正されたデータ")).respond();
        }
        getHandler(div).cancelModified(row);
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧表を出力するボタンの押下チェック処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<KanryoshoriIchijihanteiDiv> onBefore_Dataoutput(KanryoshoriIchijihanteiDiv div) {

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(getValidationHandler(div).一次判定完了対象者一覧データの存在チェック());
        validationMessages.add(getValidationHandler(div).一次判定完了対象者一覧データの行選択チェック());
        if (validationMessages.existsError()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一次判定一覧データの作成を行う。
     *
     * @param div KanryoshoriIchijihanteiDiv
     * @param response IDownLoadServletResponse
     * @return IDownLoadServletResponse
     */
    public IDownLoadServletResponse onClick_Btndataoutput(KanryoshoriIchijihanteiDiv div, IDownLoadServletResponse response) {
        RString CSVファイル名 = EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, CSVファイルID);
        FileSpoolManager fsmanager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, CSVファイルID, UzUDE0831EucAccesslogFileType.Csv);
        RString filePath = Path.combinePath(fsmanager.getEucOutputDirectry(), CSVファイル名);
        DbAccessLogger accessLog = new DbAccessLogger();
        try (CsvWriter<KanryoshoriCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build()) {
            List<dgHanteiTaishosha_Row> rowList = div.getIchijiHanteiShoriTaishoshaIchiran().getDgHanteiTaishosha().getSelectedItems();
            for (dgHanteiTaishosha_Row row : rowList) {
                csvWriter.writeLine(getHandler(div).getCsvData(row));
                ShoKisaiHokenshaNo shoKisaiHokenshaNo = new ShoKisaiHokenshaNo(row.getShoKisaiHokenshaNo());
                ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), row.getShinseishoKanriNo());
                accessLog.store(shoKisaiHokenshaNo, row.getHihokenNo(), expandedInfo);
            }
            csvWriter.close();
        }
        fsmanager.spool(filePath, accessLog.flushByEUC(UzUDE0835SpoolOutputType.EucOther));
        return EucDownload.directAccessDownload(SubGyomuCode.DBE認定支援, fsmanager.getSharedFileName(), fsmanager.getSharedFileId(), response);
    }

    /**
     * 一次判定ボタンを押下する。一次判定処理は隠しボタン側で行われるので、ここでは処理を行わない。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<KanryoshoriIchijihanteiDiv> onClick_BtnIchijiHantei(KanryoshoriIchijihanteiDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 判定結果を保存するBTNをクリックした際に実行する処理です。現在選択中の一次判定情報のうち、更新されているデータのみを保存します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<KanryoshoriIchijihanteiDiv> onClick_btnUpdateHanteiKekka(KanryoshoriIchijihanteiDiv div) {
        if (new RString(UrInformationMessages.保存終了.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return onLoad(div);
        }
        Models<IchijiHanteiKekkaJohoIdentifier, IchijiHanteiKekkaJoho> 要介護認定一次判定結果情報Models
                = ViewStateHolder.get(ViewStateKeys.要介護認定一次判定結果情報, Models.class);

        if (!ResponseHolder.isReRequest()) {

            if (要介護認定一次判定結果情報Models == null || 要介護認定一次判定結果情報Models.values().isEmpty()
                    || !要介護認定一次判定結果情報Models.hasAnyChanged()) {
                return ResponseData.of(div).addMessage(UrErrorMessages.保存データなし.getMessage()).respond();
            }
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }

        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            List<IchijiHanteiKekkaJoho> torokuTaishoList = new ArrayList<>();
            torokuTaishoList.addAll(要介護認定一次判定結果情報Models.values());
            IChiJiPanTeiSyoRiManager manager = IChiJiPanTeiSyoRiManager.createInstance();
            Set<IchijiHanteiKekkaJohoIdentifier> updated = manager.save要介護認定一次判定結果情報List(torokuTaishoList);
            accessLogByUpdating(div, asShinseishoKanriNos(updated));
            return ResponseData.of(div).addMessage(UrInformationMessages.保存終了.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    private static void accessLogByUpdating(KanryoshoriIchijihanteiDiv div, final Collection<? extends RString> shinseishoKanriNos) {
        DbAccessLogger logger = new DbAccessLogger();
        for (dgHanteiTaishosha_Row row : div.getIchijiHanteiShoriTaishoshaIchiran().getDgHanteiTaishosha().getDataSource()) {
            RString shinseishoKanriNo = row.getShinseishoKanriNo();
            if (!shinseishoKanriNos.contains(shinseishoKanriNo)) {
                continue;
            }
            logger.store(new ShoKisaiHokenshaNo(row.getShoKisaiHokenshaNo()), row.getHihokenNo(),
                    ExpandedInformations.fromValue(shinseishoKanriNo)
            );
        }
        logger.flushBy(AccessLogType.更新);
    }

    private static Set<RString> asShinseishoKanriNos(Iterable<? extends IchijiHanteiKekkaJohoIdentifier> identifiers) {
        Set<RString> set = new HashSet<>();
        for (IchijiHanteiKekkaJohoIdentifier i : identifiers) {
            set.add(i.get申請書管理番号().value());
        }
        return set;
    }

    /**
     * 一次判定を完了するボタンを押下する。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<KanryoshoriIchijihanteiDiv> onClick_BtnCompleteIchijiHantei(KanryoshoriIchijihanteiDiv div) {
        if (new RString(DbeErrorMessages.一次判定未処理.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ResponseData.of(div).respond();
        }

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();

        if (!ResponseHolder.isReRequest()) {
            validationMessages.add(getValidationHandler(div).一次判定完了対象者一覧データの存在チェック());
            validationMessages.add(getValidationHandler(div).一次判定完了対象者一覧データの行選択チェック());
            validationMessages.add(getValidationHandler(div).一次判定完了対象者一覧選択行の完了処理チェック());
            if (validationMessages.existsError()) {
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }

            QuestionMessage message = new QuestionMessage(DbeQuestionMessages.完了日登録確認.getMessage().getCode(),
                    DbeQuestionMessages.完了日登録確認.getMessage().replace("一次判定").evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }

        if (new RString(DbeQuestionMessages.完了日登録確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            List<ShinseishoKanriNo> noList = getHandler(div).getSelected申請書管理番号();

            NinteiKanryoJohoManager ninteiKanryoManager = NinteiKanryoJohoManager.createInstance();
            List<NinteiKanryoJoho> ninteiKanryoJohoList = ninteiKanryoManager.get要介護認定完了情報List(noList);
            List<NinteiKanryoJoho> outputNinteiKanryoJohoList = new ArrayList<>();

            FlexibleDate nowDate = FlexibleDate.getNowDate();
            for (NinteiKanryoJoho joho : ninteiKanryoJohoList) {
                outputNinteiKanryoJohoList.add(joho.createBuilderForEdit().set要介護認定一次判定完了年月日(nowDate).build());
            }
            ninteiKanryoManager.save要介護認定完了情報List(outputNinteiKanryoJohoList);
            accessLogByUpdating(div, asValues(noList));
            div.getCcdKanryoMessage().setMessage(new RString(DbeInformationMessages.基本運用_完了.getMessage().
                    replace("基本運用・一次判定").evaluate()), RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBE3100001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    private Set<RString> asValues(List<ShinseishoKanriNo> list) {
        Set<RString> set = new HashSet<>();
        for (ShinseishoKanriNo no : list) {
            set.add(no.value());
        }
        return set;
    }

    private KanryoshoriIchijihanteiHandler getHandler(KanryoshoriIchijihanteiDiv div) {
        return new KanryoshoriIchijihanteiHandler(div);
    }

    private KanryoshoriIchijihanteiValidationHandler getValidationHandler(KanryoshoriIchijihanteiDiv div) {
        return new KanryoshoriIchijihanteiValidationHandler(div);
    }

    /**
     * 一次判定処理前のチェック処理・引数作成処理を行います。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<KanryoshoriIchijihanteiDiv> onClick_btnIchijiHanteiValidate(KanryoshoriIchijihanteiDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(getValidationHandler(div).一次判定完了対象者一覧データの行選択チェック());
        if (validationMessages.existsError()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }

        List<ShinseishoKanriNo> 申請書管理番号List = getHandler(div).getSelected申請書管理番号();
        IchijiHanteiKekkaJohoSearchManager manager = IchijiHanteiKekkaJohoSearchManager.createIntance();
        div.setIchijiHanteiArgument(manager.get一次判定引数(申請書管理番号List));
        validationMessages.add(getValidationHandler(div).validate一次判定引数());
        if (validationMessages.existsError()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一次判定処理後の戻り値を判定する処理を行います。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<KanryoshoriIchijihanteiDiv> onClick_btnHanteishoriAto(KanryoshoriIchijihanteiDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }

        List<ShinseishoKanriNo> 申請書管理番号List = getHandler(div).getSelected申請書管理番号();
        RString result = div.getIchijiHanteiResult();
        if (RString.isNullOrEmpty(result)) {
            return ResponseData.of(div).addMessage(DbeErrorMessages.一次判定失敗.getMessage()).respond();
        }

        IchijiHanteiKekkaResultConveter converter = new IchijiHanteiKekkaResultConveter(申請書管理番号List, result);

        List<IchijiHanteiShoriKekka> kekkaList = converter.convert();
        if (kekkaList == null || kekkaList.isEmpty()) {
            return ResponseData.of(div).addMessage(DbeErrorMessages.一次判定失敗.getMessage()).respond();
        }
        getHandler(div).updateGridAndViewStateData(kekkaList);

        return ResponseData.of(div).addMessage(DbeInformationMessages.一次判定処理完了.getMessage()).respond();
    }

    /**
     * 一次判定処理後の戻り値を判定する処理を行います。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<KanryoshoriIchijihanteiDiv> onClick_btnSaishori(KanryoshoriIchijihanteiDiv div) {
        getHandler(div).initialize();

        return ResponseData.of(div).setState(DBE3100001StateName.初期表示);
    }

}
