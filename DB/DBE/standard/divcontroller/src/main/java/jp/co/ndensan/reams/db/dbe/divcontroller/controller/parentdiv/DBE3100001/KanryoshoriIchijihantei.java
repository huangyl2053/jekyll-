/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE3100001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ichijihanteiresult.IchijiHanteiKekkaResultConveter;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiShoriKekka;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeInformationMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3100001.DBE3100001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3100001.KanryoshoriIchijihanteiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3100001.dgHanteiTaishosha_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3100001.KanryoshoriCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3100001.KanryoshoriIchijihanteiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3100001.KanryoshoriIchijihanteiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.NinteiKanryoJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.ichijihanteikekkajohosearch.IchijiHanteiKekkaJohoSearchManager;
import jp.co.ndensan.reams.db.dbe.service.core.ichijipanteisyori.IChiJiPanTeiSyoRiManager;
import jp.co.ndensan.reams.db.dbe.service.core.kanryoshoriichijihantei.KanryoshoriIchijihanteiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
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

    private static final RString CSVファイル名 = new RString("IchijiHanteiIchiran.csv");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final LockingKey LOCKINGKEY = new LockingKey(new RString("ShinseishoKanriNo"));
    private static final RString ROOTTITLE = new RString("完了処理・一次判定の保存処理が完了しました。");

    /**
     * 画面初期化。(オンロード)<br/>
     *
     * @param div KanryoshoriIchijihanteiDiv
     * @return レスポンスデータ
     */
    public ResponseData<KanryoshoriIchijihanteiDiv> onLoad(KanryoshoriIchijihanteiDiv div) {
        getHandler(div).initialize();

        if (!RealInitialLocker.tryGetLock(LOCKINGKEY)) {
            throw new PessimisticLockingException();
        }
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

        getHandler(div).setCommonButtonDisplayNone();
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
        getHandler(div).cancelModified();
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
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), CSVファイル名);
        KanryoshoriIchijihanteiHandler handler = getHandler(div);

        try (CsvWriter<KanryoshoriCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.UTF_8withBOM).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(true).build()) {

            List<dgHanteiTaishosha_Row> rowList = div.getIchijiHanteiShoriTaishoshaIchiran().getDgHanteiTaishosha().getSelectedItems();
            for (dgHanteiTaishosha_Row row : rowList) {
                csvWriter.writeLine(getHandler(div).getCsvData(row));

                handler.setLogOfPersonalData(row, AccessLogType.照会);
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

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }

        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            Models<IchijiHanteiKekkaJohoIdentifier, IchijiHanteiKekkaJoho> 要介護認定一次判定結果情報Models
                    = ViewStateHolder.get(ViewStateKeys.要介護認定一次判定結果情報, Models.class);

            if (要介護認定一次判定結果情報Models == null || 要介護認定一次判定結果情報Models.values().isEmpty()
                    || !要介護認定一次判定結果情報Models.hasAnyChanged()) {
                return ResponseData.of(div).addMessage(UrErrorMessages.保存データなし.getMessage()).respond();
            }

            List<IchijiHanteiKekkaJoho> torokuTaishoList = new ArrayList<>();
            torokuTaishoList.addAll(要介護認定一次判定結果情報Models.values());
            IChiJiPanTeiSyoRiManager manager = IChiJiPanTeiSyoRiManager.createInstance();
            manager.save要介護認定一次判定結果情報List(torokuTaishoList);

            //TODO n8178 城間 現在は固定のロックキーを使用している。テーブルをロックする・対象者ごとにロックするなどの方式に変える必要あり。
            RealInitialLocker.release(new LockingKey(LOCKINGKEY));

            div.getCcdKanryoMessage().setSuccessMessage(new RString("一次判定結果を保存しました。"));
            return ResponseData.of(div).setState(DBE3100001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一次判定を完了するボタンを押下する。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<KanryoshoriIchijihanteiDiv> onClick_BtnCompleteIchijiHantei(KanryoshoriIchijihanteiDiv div) {

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();

        if (!ResponseHolder.isReRequest()) {
            validationMessages.add(getValidationHandler(div).一次判定完了対象者一覧データの存在チェック());
            validationMessages.add(getValidationHandler(div).一次判定完了対象者一覧データの行選択チェック());
            if (validationMessages.existsError()) {
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }

            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }

        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            //TODOn8178 仮判定区分によるチェックも必要？
            validationMessages.add(getValidationHandler(div).一次判定完了対象者一覧選択行の完了処理チェック());
            if (validationMessages.existsError()) {
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }

            List<ShinseishoKanriNo> noList = getHandler(div).getSelected申請書管理番号();

            NinteiKanryoJohoManager ninteiKanryoManager = NinteiKanryoJohoManager.createInstance();
            List<NinteiKanryoJoho> ninteiKanryoJohoList = ninteiKanryoManager.get要介護認定完了情報List(noList);
            List<NinteiKanryoJoho> outputNinteiKanryoJohoList = new ArrayList<>();

            FlexibleDate nowDate = FlexibleDate.getNowDate();
            for (NinteiKanryoJoho joho : ninteiKanryoJohoList) {
                outputNinteiKanryoJohoList.add(joho.createBuilderForEdit().set要介護認定一次判定完了年月日(nowDate).build());
            }
            ninteiKanryoManager.save要介護認定完了情報List(outputNinteiKanryoJohoList);

            div.getCcdKanryoMessage().setSuccessMessage(new RString("一次判定を完了しました。"));

            RealInitialLocker.release(LOCKINGKEY);
            div.getCcdKanryoMessage().setMessage(ROOTTITLE, RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBE3100001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    private boolean is仮一次判定(RString 申請書管理番号) {
        return KanryoshoriIchijihanteiManager.createInstance().get仮一次判定区分(new ShinseishoKanriNo(申請書管理番号));
    }

    private KanryoshoriIchijihanteiHandler getHandler(KanryoshoriIchijihanteiDiv div) {
        return new KanryoshoriIchijihanteiHandler(div);
    }

    private KanryoshoriIchijihanteiValidationHandler getValidationHandler(KanryoshoriIchijihanteiDiv div) {
        return new KanryoshoriIchijihanteiValidationHandler(div);
    }

    /**
     * 一次判定を完了するボタンを押下する。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<KanryoshoriIchijihanteiDiv> onBeforeDialog_HanteiKekkaShokai(KanryoshoriIchijihanteiDiv div) {

        dgHanteiTaishosha_Row selectedRow = div.getIchijiHanteiShoriTaishoshaIchiran().getDgHanteiTaishosha().getClickedItem();
        if (selectedRow == null || RString.isNullOrEmpty(selectedRow.getShinseishoKanriNo())) {
            return ResponseData.of(div).respond();
        }

        ShinseishoKanriNo shinseishoKanriNo = new ShinseishoKanriNo(selectedRow.getShinseishoKanriNo());
        getHandler(div).setClickedIchijiHanteiData(shinseishoKanriNo);
        return ResponseData.of(div).respond();
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

        if (!RealInitialLocker.tryGetLock(LOCKINGKEY)) {
            throw new PessimisticLockingException();
        }
        return ResponseData.of(div).setState(DBE3100001StateName.初期表示);
    }

}
