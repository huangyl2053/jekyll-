/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE9050001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.SonotaKikanJoho;
import jp.co.ndensan.reams.db.dbe.business.core.basic.SonotaKikanJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosaitakusakimaster.NinteichosaMasterMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosaitakusakimaster.NinteichosaMasterSearchParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9020001.DBE9020001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9050001.DBE9050001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9050001.NinteichosaItakusakiCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9050001.NinteichosaItakusakiMainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9050001.dgSonotaKikanIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE9050001.NinteichosaItakusakiMainHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE9050001.NinteichosaMainValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.SonotaKikanJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.ikensho.ninteichosaitakusakimaster.NinteichosaMasterFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.service.core.koza.KozaManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
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
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * その他機関処理のクラスです。。
 *
 * @reamsid_L DBE-1360-010 suguangjun
 */
public class NinteichosaItakusakiMain {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString CSVファイル名 = new RString("その他機関情報.csv");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString ROOTTITLE = new RString("その他機関マスタの保存処理が完了しました。");

    /**
     * 画面初期化処理です。
     *
     * @param div NinteichosaItakusakiMainDiv
     * @return ResponseData<NinteichosaItakusakiMainDiv>
     */
    public ResponseData<NinteichosaItakusakiMainDiv> onLoad(NinteichosaItakusakiMainDiv div) {
        getHandler(div).load();
        return ResponseData.of(div).respond();
    }

    /**
     * クリアボタン押下で検索条件入力項目をクリアします。
     *
     * @param div NinteichosaItakusakiMainDiv
     * @return ResponseData<NinteichosaItakusakiMainDiv>
     */
    public ResponseData<NinteichosaItakusakiMainDiv> onClick_btnClearKensakuJoken(NinteichosaItakusakiMainDiv div) {
        getHandler(div).clearKensakuJoken();
        return ResponseData.of(div).respond();
    }

    /**
     * 検索ボタン押下で検索条件に従い、その他機関情報を検索します。
     *
     * @param div NinteichosaItakusakiMainDiv
     * @return ResponseData<NinteichosaItakusakiMainDiv>
     */
    public ResponseData<NinteichosaItakusakiMainDiv> onClick_btnSearchShujii(NinteichosaItakusakiMainDiv div) {
        RString kanCodeFrom = div.getChosainSearch().getTxtSearchSonotaKikanCodeFrom().getValue();
        RString kanCodeTo = div.getChosainSearch().getTxtSearchSonotaKikanCodeTo().getValue();
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForSearchShujii(kanCodeFrom, kanCodeTo);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        searchChosainInfo(div);
        return ResponseData.of(div).respond();
    }

    private void searchChosainInfo(NinteichosaItakusakiMainDiv div) {
        boolean jokyoFlag = false;
        if (div.getRadSearchHaisiFlag().getSelectedIndex() == 0) {
            jokyoFlag = true;
        }
        NinteichosaMasterMapperParameter parameter = NinteichosaMasterMapperParameter.createSelectByKeyParam(jokyoFlag,
                div.getChosainSearch().getCcdhokensha().getSelectedItem().get証記載保険者番号(),
                div.getChosainSearch().getTxtSearchSonotaKikanCodeFrom().getValue(),
                div.getChosainSearch().getTxtSearchSonotaKikanCodeTo().getValue(),
                div.getChosainSearch().getTxtSearchSonotaKikanMeisho().getValue(),
                div.getChosainSearch().getTxtSearchSonotaKikanKanaMeisho().getValue(),
                div.getChosainSearch().getDdlitakukubun().getSelectedKey(),
                div.getChosainSearch().getDdlkikankubun().getSelectedKey(),
                div.getChosainSearch().getTxtSaidaiHyojiKensu().getValue());
        List<SonotaKikanJoho> sonotaKikanJohoList = NinteichosaMasterFinder.createInstance().getSonotaKikanichiranList(parameter).records();
        if (sonotaKikanJohoList.isEmpty()) {
            ViewStateHolder.put(ViewStateKeys.その他機関マスタ検索結果, Models.create(new ArrayList<SonotaKikanJoho>()));
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        getHandler(div).setSonotaKikanichiran(sonotaKikanJohoList);
        List<SonotaKikanJoho> その他機関マスタList = NinteichosaMasterFinder.createInstance().getSonotaKikanJohoList(parameter).records();
        ViewStateHolder.put(ViewStateKeys.その他機関マスタ検索結果, Models.create(その他機関マスタList));
    }

    /**
     * 追加ボタンが押下された場合、明細エリアを空白で表示します。
     *
     * @param div NinteichosaItakusakiMainDiv
     * @return ResponseData<NinteichosaItakusakiMainDiv>
     */
    public ResponseData<NinteichosaItakusakiMainDiv> onClick_btnInsert(NinteichosaItakusakiMainDiv div) {
        div.getChosaitakusakiJohoInput().setState(状態_追加);
        getHandler(div).setDisabledFalseToShujiiJohoInputMeisai();
        div.getChosaitakusakiJohoInput().getCcdHokenshaJoho().setDisabled(false);
        div.getChosaitakusakiJohoInput().getBtnRegisterKoza().setDisabled(false);
        div.getChosaitakusakiJohoInput().getBtnKakutei().setDisabled(false);
        div.getChosaitakusakiJohoInput().getBtnTorikeshi().setDisabled(false);
        div.getChosaitakusakiJohoInput().getDdlItakusakikubun().setDataSource(getHandler(div).setItakukubun());
        div.getChosaitakusakiJohoInput().getDdlKikankubun().setDataSource(getHandler(div).setKikankubun());
        getHandler(div).clearChosaitakusakiJohoInput();
        div.getChosaitakusakiJohoInput().setHiddenInputDiv(getHandler(div).getInputDiv());
        return ResponseData.of(div).respond();
    }

    /**
     * 修正アイコンを押下した場合、入力明細エリアに選択行の内容を表示し、項目を入力可能にします。
     *
     * @param div NinteichosaItakusakiMainDiv
     * @return ResponseData<NinteichosaItakusakiMainDiv>
     */
    public ResponseData<NinteichosaItakusakiMainDiv> onSelectByModifyButton_dgSonotaKikanIchiran(NinteichosaItakusakiMainDiv div) {
        div.getChosaitakusakiJohoInput().setState(状態_修正);
        getHandler(div).setDisabledFalseToShujiiJohoInputMeisai();
        dgSonotaKikanIchiran_Row row = div.getSonotaKikanichiran().getDgSonotaKikanIchiran().getClickedItem();
        getHandler(div).setChosaitakusakiJohoInput(row);
        div.getChosaitakusakiJohoInput().getBtnRegisterKoza().setDisabled(false);
        div.getChosaitakusakiJohoInput().getBtnKakutei().setDisabled(false);
        div.getChosaitakusakiJohoInput().getBtnTorikeshi().setDisabled(false);
        div.getChosaitakusakiJohoInput().getCcdHokenshaJoho().setDisabled(true);
        div.getChosaitakusakiJohoInput().getTxtSonotaKikanCode().setDisabled(true);
        div.getChosaitakusakiJohoInput().setHiddenInputDiv(getHandler(div).getInputDiv());
        return ResponseData.of(div).respond();
    }

    /**
     * 削除アイコンを押下した場合、入力明細エリアに選択行の内容を表示し、項目を入力不可にします。
     *
     * @param div NinteichosaItakusakiMainDiv
     * @return ResponseData<NinteichosaItakusakiMainDiv>
     */
    public ResponseData<NinteichosaItakusakiMainDiv> onSelectByDeleteButton_dgSonotaKikanIchiran(NinteichosaItakusakiMainDiv div) {
        div.getChosaitakusakiJohoInput().setState(状態_削除);
        dgSonotaKikanIchiran_Row row = div.getSonotaKikanichiran().getDgSonotaKikanIchiran().getActiveRow();
        getHandler(div).setChosaitakusakiJohoInput(row);
        getHandler(div).setDisabledTrueToChosaitakusakiJohoInput();
        div.getChosaitakusakiJohoInput().getBtnRegisterKoza().setDisabled(true);
        div.getChosaitakusakiJohoInput().getBtnKakutei().setDisabled(false);
        div.getChosaitakusakiJohoInput().getBtnTorikeshi().setDisabled(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 選択行の内容を、明細エリアに表示します。
     *
     * @param div NinteichosaItakusakiMainDiv
     * @return ResponseData<NinteichosaItakusakiMainDiv>
     */
    public ResponseData<NinteichosaItakusakiMainDiv> onSelectByDlbClick_dgSonotaKikanIchiran(NinteichosaItakusakiMainDiv div) {
        dgSonotaKikanIchiran_Row row = div.getSonotaKikanichiran().getDgSonotaKikanIchiran().getActiveRow();
        getHandler(div).setChosaitakusakiJohoInput(row);
        if (状態_修正.equals(row.getJotai())) {
            div.getChosaitakusakiJohoInput().getCcdHokenshaJoho().setDisabled(true);
            div.getChosaitakusakiJohoInput().getTxtSonotaKikanCode().setDisabled(true);
            div.getChosaitakusakiJohoInput().getBtnRegisterKoza().setDisabled(false);
            div.getChosaitakusakiJohoInput().getBtnKakutei().setDisabled(false);
            div.getChosaitakusakiJohoInput().getBtnTorikeshi().setDisabled(false);
        } else if (状態_削除.equals(row.getJotai())) {
            getHandler(div).setDisabledTrueToChosaitakusakiJohoInput();
            div.getChosaitakusakiJohoInput().getBtnRegisterKoza().setDisabled(true);
            div.getChosaitakusakiJohoInput().getBtnKakutei().setDisabled(false);
            div.getChosaitakusakiJohoInput().getBtnTorikeshi().setDisabled(false);
        } else if (RString.EMPTY.equals(row.getJotai())) {
            getHandler(div).setDisabledTrueToChosaitakusakiJohoInput();
            div.getChosaitakusakiJohoInput().getBtnRegisterKoza().setDisabled(true);
            div.getChosaitakusakiJohoInput().getBtnKakutei().setDisabled(true);
            div.getChosaitakusakiJohoInput().getBtnTorikeshi().setDisabled(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * ＣＳＶを出力するボタンが押下された場合、ＣＳＶを出力します。
     *
     * @param div NinteichosaItakusakiMainDiv
     * @param response IDownLoadServletResponse
     * @return ResponseData<NinteichosaItakusakiMainDiv>
     */
    public IDownLoadServletResponse onClick_btnOutputCsv(NinteichosaItakusakiMainDiv div, IDownLoadServletResponse response) {
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), CSVファイル名);
        try (CsvWriter<NinteichosaItakusakiCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.UTF_8).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(true).build()) {
            List<dgSonotaKikanIchiran_Row> dataList = div.getSonotaKikanichiran().getDgSonotaKikanIchiran().getDataSource();
            for (dgSonotaKikanIchiran_Row row : dataList) {
                csvWriter.writeLine(getCsvData(row));
            }
            csvWriter.close();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(CSVファイル名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(entry, CSVファイル名), response);
    }

    private NinteichosaItakusakiCsvEntity getCsvData(dgSonotaKikanIchiran_Row row) {
        RString waritsukeTeiin = RString.EMPTY;
        if (row.getWaritsukeTeiin() != null) {
            waritsukeTeiin = new RString(row.getWaritsukeTeiin().getValue().toString());
        }
        NinteichosaItakusakiCsvEntity data = new NinteichosaItakusakiCsvEntity(
                row.getHokensha(),
                row.getSonotaKikanCode(),
                row.getKikanMeisho(),
                row.getKikanKana(),
                row.getYubinNo(),
                row.getJusho(),
                row.getJushoKana(),
                row.getTelNo(),
                row.getChosaItakuKubun(),
                waritsukeTeiin,
                row.getChiku(),
                row.getKikanKubun(),
                row.getJokyoFlag());
        return data;
    }

    /**
     * 取消するボタンが押下された場合、入力明細エリアの入力内容を破棄し、その他機関一覧エリアへ戻ります。
     *
     * @param div NinteichosaItakusakiMainDiv
     * @return ResponseData<NinteichosaItakusakiMainDiv>
     */
    public ResponseData<NinteichosaItakusakiMainDiv> onClick_btnTorikeshi(NinteichosaItakusakiMainDiv div) {
        if ((状態_追加.equals(div.getChosaitakusakiJohoInput().getState()) && getValidationHandler(div).isUpdate())
                || (状態_修正.equals(div.getChosaitakusakiJohoInput().getState()) && getValidationHandler(div).isUpdate())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).setState(DBE9050001StateName.一覧);
            } else if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        return ResponseData.of(div).setState(DBE9050001StateName.一覧);
    }

    /**
     * 確定するボタンが押下された場合、入力明細エリアの入力内容をその他機関一覧に反映させます。
     *
     * @param div NinteichosaItakusakiMainDiv
     * @return ResponseData<NinteichosaItakusakiMainDiv>
     */
    public ResponseData<NinteichosaItakusakiMainDiv> onClick_btnKakutei(NinteichosaItakusakiMainDiv div) {

        RString イベント状態 = div.getChosaitakusakiJohoInput().getState();
        int sonotaKikanJohoCount = NinteichosaMasterFinder.createInstance().getSonotaKikanJohoCount(NinteichosaMasterSearchParameter.
                createParamForSelectByKey(new ShoKisaiHokenshaNo(div.getChosaitakusakiJohoInput().getCcdHokenshaJoho().getHokenjaNo()),
                        div.getChosaitakusakiJohoInput().getTxtSonotaKikanCode().getValue())
        );
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForKakutei(イベント状態, sonotaKikanJohoCount);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        Models<SonotaKikanJohoIdentifier, SonotaKikanJoho> models = ViewStateHolder.get(ViewStateKeys.その他機関マスタ検索結果, Models.class);

        if (状態_追加.equals(イベント状態)) {
            SonotaKikanJoho sonotaKikanJoho = new SonotaKikanJoho(
                    new ShoKisaiHokenshaNo(div.getChosaitakusakiJohoInput().getCcdHokenshaJoho().getHokenjaNo()),
                    div.getChosaitakusakiJohoInput().getTxtSonotaKikanCode().getValue()
            );
            sonotaKikanJoho = getHandler(div).editSonotaKikanJoho(sonotaKikanJoho);
            models.add(sonotaKikanJoho);
        } else if (状態_修正.equals(イベント状態)) {
            SonotaKikanJohoIdentifier key = new SonotaKikanJohoIdentifier(
                    new ShoKisaiHokenshaNo(div.getChosaitakusakiJohoInput().getCcdHokenshaJoho().getHokenjaNo()),
                    div.getChosaitakusakiJohoInput().getTxtSonotaKikanCode().getValue());
            SonotaKikanJoho sonotaKikanJoho = getHandler(div).editSonotaKikanJoho(models.get(key).modifiedModel());
            models.deleteOrRemove(key);
            models.add(sonotaKikanJoho);
        } else if (状態_削除.equals(イベント状態)) {
            SonotaKikanJohoIdentifier key = new SonotaKikanJohoIdentifier(
                    new ShoKisaiHokenshaNo(div.getChosaitakusakiJohoInput().getCcdHokenshaJoho().getHokenjaNo()),
                    div.getChosaitakusakiJohoInput().getTxtSonotaKikanCode().getValue());
            RString jotai = div.getSonotaKikanichiran().getDgSonotaKikanIchiran().getActiveRow().getJotai();
            if (状態_追加.equals(jotai)) {
                models.deleteOrRemove(key);
            } else {
                SonotaKikanJoho sonotaKikanJoho = getHandler(div).editSonotaKikanJoho(models.get(key).deleted());
                models.add(sonotaKikanJoho);
            }
        }
        ViewStateHolder.put(ViewStateKeys.その他機関マスタ検索結果, models);
        div.getSonotaKikanichiran().setDisplayNone(false);
        getHandler(div).setSonotaKikanichiran(イベント状態);
        return ResponseData.of(div).setState(DBE9050001StateName.一覧);
    }

    /**
     * 保存するボタン押下、データがDBに更新します。
     *
     * @param div NinteichosaItakusakiMainDiv
     * @return ResponseData<NinteichosaItakusakiMainDiv>
     */
    public ResponseData<NinteichosaItakusakiMainDiv> onClick_btnUpdate(NinteichosaItakusakiMainDiv div) {
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
            validPairs = validateForDelete(div);
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
            Models<SonotaKikanJohoIdentifier, SonotaKikanJoho> models = ViewStateHolder.get(
                    ViewStateKeys.その他機関マスタ検索結果, Models.class);
            SonotaKikanJohoManager sonotaKikanJohoManager = new SonotaKikanJohoManager();
            for (SonotaKikanJoho sonotaKikanJoho : models) {
                sonotaKikanJohoManager.saveOrDeleteその他機関情報(sonotaKikanJoho);
            }
            List<dgSonotaKikanIchiran_Row> ichiranList = div.getSonotaKikanichiran().getDgSonotaKikanIchiran().getDataSource();
            for (dgSonotaKikanIchiran_Row row : ichiranList) {
                if (状態_削除.equals(row.getJotai())) {
                    KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
                    builder.set業務コード(GyomuCode.DB介護保険);
                    builder.setサブ業務コード(SubGyomuCode.DBE認定支援);
                    builder.set科目コード(new KamokuCode("004"));
                    List<RString> 業務固有キー = new ArrayList<>();
                    業務固有キー.add(new RString("その他機関コード"));
                    builder.set業務固有キーリスト(業務固有キー);
                    builder.set用途区分(new KozaYotoKubunCodeValue(new RString("1")));
                    IKozaSearchKey searchKey = builder.build();
                    KozaManager manager = KozaManager.createInstance();
                    List<Koza> kozaList = KozaManager.createInstance().get口座(searchKey);
                    for (Koza koza : kozaList) {
                        manager.save異動前後口座情報(koza, koza.deleted());
                    }
                }
            }
            div.getCcdKanryoMessage().setMessage(ROOTTITLE, RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBE9050001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    private ValidationMessageControlPairs validateForDelete(NinteichosaItakusakiMainDiv div) {
        List<dgSonotaKikanIchiran_Row> dataList = div.getSonotaKikanichiran().getDgSonotaKikanIchiran().getDataSource();
        NinteichosaMasterFinder masterFinder = NinteichosaMasterFinder.createInstance();
        for (dgSonotaKikanIchiran_Row row : dataList) {
            if (状態_削除.equals(row.getJotai())) {
                NinteichosaMasterSearchParameter parameter = NinteichosaMasterSearchParameter.createParamForSelectByKey(
                        new ShoKisaiHokenshaNo(row.getHokensha()),
                        row.getSonotaKikanCode());
                return getValidationHandler(div).validateForDelete(
                        masterFinder.getKaigoNinteiShinsakaiCount(parameter));
            }
        }
        return new ValidationMessageControlPairs();
    }

    /**
     * その他機関一覧に戻ります。
     *
     * @param div NinteichosaItakusakiMainDiv
     * @return ResponseData<NinteichosaItakusakiMainDiv>
     */
    public ResponseData<NinteichosaItakusakiMainDiv> onClick_btnBackSonotaIchiran(NinteichosaItakusakiMainDiv div) {
        if ((状態_追加.equals(div.getChosaitakusakiJohoInput().getState()) && getValidationHandler(div).isUpdate())
                || (状態_修正.equals(div.getChosaitakusakiJohoInput().getState()) && getValidationHandler(div).isUpdate())
                || (状態_削除.equals(div.getChosaitakusakiJohoInput().getState()) && getValidationHandler(div).isUpdate())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                        UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                div.getChosaitakusakiJohoInput().setState(RString.EMPTY);
                return ResponseData.of(div).setState(DBE9050001StateName.一覧);
            } else if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        return ResponseData.of(div).setState(DBE9050001StateName.一覧);
    }

    /**
     * 再検索するボタン押下で検索条件に従い、その他機関情報を検索します。
     *
     * @param div NinteichosaItakusakiMainDiv
     * @return ResponseData<NinteichosaItakusakiMainDiv>
     */
    public ResponseData<NinteichosaItakusakiMainDiv> onClick_btnReSearch(NinteichosaItakusakiMainDiv div) {

        List<dgSonotaKikanIchiran_Row> ichiranList = div.getSonotaKikanichiran().getDgSonotaKikanIchiran().getDataSource();
        boolean isUpdate = false;
        for (dgSonotaKikanIchiran_Row row : ichiranList) {
            if (!RString.EMPTY.equals(row.getJotai())) {
                isUpdate = true;
                break;
            }
        }
        if (isUpdate) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.検索画面遷移の確認.getMessage()
                        .getCode(),
                        UrQuestionMessages.検索画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).setState(DBE9050001StateName.検索);
            }
        } else {
            getHandler(div).load();
            return ResponseData.of(div).setState(DBE9020001StateName.検索);
        }
        getHandler(div).load();
        return ResponseData.of(div).respond();
    }

    /**
     * 口座情報を登録するボタンが押下された場合、口座情報画面へ遷移する。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<NinteichosaItakusakiMainDiv> onClick_btnRegisterKoza(NinteichosaItakusakiMainDiv div) {
        div.setHdnTxtSubGyomuCode(SubGyomuCode.DBE認定支援.value());
        div.setHdnTxtShikibetsuCode(new RString("004"));
        return ResponseData.of(div).respond();
    }

    private NinteichosaItakusakiMainHandler getHandler(NinteichosaItakusakiMainDiv div) {
        return new NinteichosaItakusakiMainHandler(div);
    }

    private NinteichosaMainValidationHandler getValidationHandler(NinteichosaItakusakiMainDiv div) {
        return new NinteichosaMainValidationHandler(div);
    }
}
