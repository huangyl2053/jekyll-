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
import jp.co.ndensan.reams.db.dbe.entity.db.relate.sonotakikanmaster.SonotaKikanJohoCSVEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.sonotakikanmaster.SonotaKikanJohoEntity;
import jp.co.ndensan.reams.db.dbe.service.core.basic.SonotaKikanJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.ikensho.ninteichosaitakusakimaster.NinteichosaMasterFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikan;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikanShiten;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.service.core.kinyukikan.KinyuKikanManager;
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
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
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
    private static final RString OUTPUT_CSV_FILE_NAME = new RString("口座情報未登録機関一覧表（その他機関）.csv");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBE910081"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private FileSpoolManager fileSpoolManager;
    private static final RString 普通 = new RString("普通");
    private static final RString 当座 = new RString("当座");
    private static final RString 納税準備 = new RString("納税準備");
    private static final RString 貯蓄 = new RString("貯蓄");
    private static final RString その他 = new RString("その他");

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
        RString kikanKubun = div.getChosainSearch().getDdlkikankubun().getSelectedKey();
        RString itakuKubun = div.getChosainSearch().getDdlitakukubun().getSelectedKey();
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForSearchShujii(kanCodeFrom, kanCodeTo, kikanKubun, itakuKubun);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        searchChosainInfo(div);
        div.setHdnShichosonCode(div.getCcdhokensha().getSelectedItem().get証記載保険者番号().value());
        div.setHdnShichosonName(div.getCcdhokensha().getSelectedItem().get市町村名称());
        return ResponseData.of(div).setState(DBE9050001StateName.一覧);
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
                div.getChosainSearch().getTxtSaidaiHyojiKensu().getValue(),
                div.getDdlKikanMeisho().getSelectedKey(),
                div.getDdlKikanKanaMeisho().getSelectedKey());
        List<SonotaKikanJohoEntity> sonotaKikanJohoList = NinteichosaMasterFinder.createInstance().getSonotaKikanichiranList(parameter).records();

        boolean 検索条件初期値 = true;
        if (parameter.isUser機関カナ名称() || parameter.isUser機関の区分() || parameter.isUser機関コードFrom() || parameter.isUser機関コードTo()
                || parameter.isUser機関名称() || parameter.isUser調査委託区分() || !parameter.is廃止フラグ()) {
            検索条件初期値 = false;
        }

        if (sonotaKikanJohoList.isEmpty() && !検索条件初期値) {
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
        div.getChosaitakusakiJohoInput().getBtnKakutei().setDisabled(false);
        div.getChosaitakusakiJohoInput().getBtnTorikeshi().setDisabled(false);
        div.getChosaitakusakiJohoInput().getDdlItakusakikubun().setDataSource(getHandler(div).setItakukubun());
        div.getChosaitakusakiJohoInput().getDdlKikankubun().setDataSource(getHandler(div).setKikankubun());
        getHandler(div).clearChosaitakusakiJohoInput();
        if (!RString.isNullOrEmpty(div.getHdnShichosonCode()) && !RString.isNullOrEmpty(div.getHdnShichosonName())) {
            div.getChosaitakusakiJohoInput().getCcdHokenshaJoho().setHokenjaNo(div.getHdnShichosonCode());
            div.getChosaitakusakiJohoInput().getCcdHokenshaJoho().setHokenjaName(div.getHdnShichosonName());
            div.getChosaitakusakiJohoInput().getCcdHokenshaJoho().setDisabled(true);
        }
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
            div.getChosaitakusakiJohoInput().getBtnKakutei().setDisabled(false);
            div.getChosaitakusakiJohoInput().getBtnTorikeshi().setDisabled(false);
        } else if (状態_削除.equals(row.getJotai())) {
            getHandler(div).setDisabledTrueToChosaitakusakiJohoInput();
            div.getChosaitakusakiJohoInput().getBtnKakutei().setDisabled(false);
            div.getChosaitakusakiJohoInput().getBtnTorikeshi().setDisabled(false);
        } else if (RString.EMPTY.equals(row.getJotai())) {
            getHandler(div).setDisabledTrueToChosaitakusakiJohoInput();
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
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.UTF_8withBOM).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(true).build()) {
            List<dgSonotaKikanIchiran_Row> dataList = div.getSonotaKikanichiran().getDgSonotaKikanIchiran().getDataSource();
            KinyuKikanManager kinyuKikanManager = KinyuKikanManager.createInstance();
            List<KinyuKikan> 金融機関情報 = new ArrayList<>();
            金融機関情報 = kinyuKikanManager.getValidKinyuKikansOn(FlexibleDate.getNowDate());
            for (dgSonotaKikanIchiran_Row row : dataList) {
                RString 金融機関名称 = RString.EMPTY;
                RString 支店名 = RString.EMPTY;
                if (row.getKinyuKikanCode() != null && !row.getKinyuKikanCode().isEmpty()) {
                    金融機関名称 = getKinyuKikan(金融機関情報, row);
                }
                if (row.getKinyuKikanShitenCode() != null && !row.getKinyuKikanShitenCode().isEmpty()) {
                    支店名 = getKinyuShiten(金融機関情報, row);
                }
                csvWriter.writeLine(getCsvData(row, 金融機関名称, 支店名));
            }
            csvWriter.close();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(CSVファイル名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(entry, CSVファイル名), response);
    }

    private NinteichosaItakusakiCsvEntity getCsvData(dgSonotaKikanIchiran_Row row, RString 金融機関名称, RString 支店名) {
        RString waritsukeTeiin = RString.EMPTY;
        if (row.getWaritsukeTeiin().getValue() != null) {
            waritsukeTeiin = new RString(row.getWaritsukeTeiin().getValue().toString());
        }
        NinteichosaItakusakiCsvEntity data = new NinteichosaItakusakiCsvEntity(
                row.getHokenshaCode(),
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
                row.getJokyoFlag(),
                row.getKinyuKikanCode() != null
                ? row.getKinyuKikanCode()
                : RString.EMPTY,
                金融機関名称 != null
                ? row.getKinyuKikanMeisho()
                : RString.EMPTY,
                row.getKinyuKikanShitenCode() != null
                ? row.getKinyuKikanShitenCode()
                : RString.EMPTY,
                支店名 != null
                ? row.getShitenMeisho()
                : RString.EMPTY,
                row.getYokinShubetsu() != null
                ? row.getYokinShubetsu()
                : RString.EMPTY,
                row.getYokinShubetsu() != null
                ? set預金種別(row.getYokinShubetsu())
                : RString.EMPTY,
                row.getKozaNo() != null
                ? row.getKozaNo()
                : RString.EMPTY,
                row.getKozaMeigininKana() != null
                ? row.getKozaMeigininKana()
                : RString.EMPTY,
                row.getKozaMeiginin() != null
                ? row.getKozaMeiginin()
                : RString.EMPTY
        );
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
                getHandler(div).load();
                return ResponseData.of(div).setState(DBE9050001StateName.検索);
            }
        } else {
            getHandler(div).load();
            return ResponseData.of(div).setState(DBE9020001StateName.検索);
        }
//        getHandler(div).load();
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

    /**
     * 口座未登録csvを出力するボタンが押下された場合、ＣＳＶを出力します。
     *
     * @param div NinteichosaItakusakiMainDiv
     * @param response
     * @return IDownLoadServletResponse
     */
    public IDownLoadServletResponse onClick_btnCsvKozaNashi(NinteichosaItakusakiMainDiv div, IDownLoadServletResponse response) {

        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), OUTPUT_CSV_FILE_NAME);
        boolean is該当データなし = true;
        try (CsvWriter<SonotaKikanJohoCSVEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.UTF_8withBOM).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(true).build()) {
            List<dgSonotaKikanIchiran_Row> dataList = div.getSonotaKikanichiran().getDgSonotaKikanIchiran().getDataSource();
            for (dgSonotaKikanIchiran_Row row : dataList) {
                if (row.getKinyuKikanCode().isNull() || row.getKinyuKikanCode().isEmpty()) {
                    csvWriter.writeLine(getCsvDataSonota(row));
                    is該当データなし = false;
                }
            }
            if (is該当データなし) {
                csvWriter.writeLine(getCsvNonDataSonota());
            }

            csvWriter.close();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(OUTPUT_CSV_FILE_NAME));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(entry, OUTPUT_CSV_FILE_NAME), response);
    }

    private SonotaKikanJohoCSVEntity getCsvDataSonota(dgSonotaKikanIchiran_Row row) {
        RString waritsukeTeiin = RString.EMPTY;
        if (row.getWaritsukeTeiin().getValue() != null) {
            waritsukeTeiin = new RString(row.getWaritsukeTeiin().getValue().toString());
        }
        SonotaKikanJohoCSVEntity data = new SonotaKikanJohoCSVEntity(
                row.getHokenshaCode(),
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

    private SonotaKikanJohoCSVEntity getCsvNonDataSonota() {
        SonotaKikanJohoCSVEntity data = new SonotaKikanJohoCSVEntity(
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
        return data;
    }

//    /**
//     * 口座未登録csvを出力するボタンが押下された場合、ＣＳＶをSpoolします。
//     *
//     * @param div NinteichosaItakusakiMainDiv
//     * @return ResponseData<NinteichosaItakusakiMainDiv>
//     */
//    public ResponseData<NinteichosaItakusakiMainDiv> onClick_btnCsvSpool(NinteichosaItakusakiMainDiv div) {
//        if (!ResponseHolder.isReRequest()) {
//            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
//        }
//        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
//                && new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
//            csvOutput(div);
//            return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace("CSV出力")).respond();
//        }
//        return ResponseData.of(div).respond();
//
//    }
//
//    private void csvOutput(NinteichosaItakusakiMainDiv div) {
//        List<dgSonotaKikanIchiran_Row> dataList_EUC = div.getSonotaKikanichiran().getDgSonotaKikanIchiran().getDataSource();
//        List<SonotaKikanJohoCSVEntity> resultList = new ArrayList<>();
//        for (dgSonotaKikanIchiran_Row entity : dataList_EUC) {
//            if (entity.getKinyuKikanCode().isNull() || entity.getKinyuKikanCode().isEmpty()) {
//                SonotaKikanJohoCSVEntity tmpEntity = new SonotaKikanJohoCSVEntity();
//                tmpEntity.set証記載保険者番号(entity.getHokenshaCode());
//                tmpEntity.setその他機関コード(entity.getSonotaKikanCode());
//                tmpEntity.set機関名称(entity.getKikanMeisho());
//                tmpEntity.set機関名称カナ(entity.getKikanKana());
//                tmpEntity.set郵便番号(entity.getYubinNo());
//                tmpEntity.set住所(entity.getJusho());
//                tmpEntity.set電話番号(entity.getTelNo());
//                tmpEntity.set調査委託区分(set調査委託区分(entity));
//                tmpEntity.set機関の区分(set機関区分(entity));
//                resultList.add(tmpEntity);
//            }
//        }
//
//        fileSpoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
//        RString spoolWorkPath = fileSpoolManager.getEucOutputDirectry();
//        RString eucFilePath = Path.combinePath(spoolWorkPath, OUTPUT_CSV_FILE_NAME);
//
//        try (CsvWriter<SonotaKikanJohoCSVEntity> eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
//                hasHeader(true).
//                canAppend(false).
//                setDelimiter(EUC_WRITER_DELIMITER).
//                setEnclosure(EUC_WRITER_ENCLOSURE).
//                setEncode(Encode.SJIS).
//                setNewLine(NewLine.CRLF).
//                build()) {
//            for (SonotaKikanJohoCSVEntity result : resultList) {
//                eucCsvWriter.writeLine(result);
//            }
//        }
//
//        fileSpoolManager.spool(eucFilePath);
//    }
//
//    private RString set調査委託区分(dgSonotaKikanIchiran_Row entity) {
//        RStringBuilder 調査委託区分編集 = new RStringBuilder();
//        return entity.getChosaItakuKubun().isEmpty()
//                ? RString.EMPTY
//                : 調査委託区分編集
//                .append("(")
//                .append(ChosaItakuKubunCode.toValueFrom名称(entity.getChosaItakuKubun()).getコード())
//                .append(")")
//                .append(entity.getChosaItakuKubun())
//                .toRString();
//    }
//
//    private RString set機関区分(dgSonotaKikanIchiran_Row entity) {
//        RStringBuilder 機関区分編集 = new RStringBuilder();
//        return entity.getChosaItakuKubun().isEmpty()
//                ? RString.EMPTY
//                : 機関区分編集
//                .append("(")
//                .append(ChosaKikanKubun.valueOf(entity.getKikanKubun().toString()).getコード())
//                .append(")")
//                .append(entity.getKikanKubun())
//                .toRString();
//    }
//    private RString set調査委託区分(RString row調査委託区分) {
//        RStringBuilder 調査委託区分編集 = new RStringBuilder();
//        return row調査委託区分.isEmpty()
//                ? RString.EMPTY
//                : 調査委託区分編集
//                .append("(")
//                .append(ChosaItakuKubunCode.toValueFrom名称(row調査委託区分).getコード())
//                .append(")")
//                .append(row調査委託区分)
//                .toRString();
//    }
//    private RString set機関の区分(RString row機関の区分) {
//        RStringBuilder 機関区分編集 = new RStringBuilder();
//        return row機関の区分.isEmpty()
//                ? RString.EMPTY
//                : 機関区分編集
//                .append("(")
//                .append(ChosaKikanKubun.valueOf(row機関の区分.toString()).getコード())
//                .append(")")
//                .append(row機関の区分)
//                .toRString();
//    }
    private RString set預金種別(RString 預金種別コード) {
        if (!預金種別コード.isEmpty()) {
            switch (預金種別コード.toInt()) {
                case 1:
                    return 普通;
                case 2:
                    return 当座;
                case 3:
                    return 納税準備;
                case 4:
                    return 貯蓄;
                case 9:
                    return その他;
            }
        }
        return RString.EMPTY;

    }

    /**
     * 金融機関を取得します。
     *
     * @param 金融機関情報 List<KinyuKikan>
     * @param row dgSonotaKikanIchiran_Row
     * @return 金融機関_支店　List<RString>
     */
    private RString getKinyuKikan(List<KinyuKikan> 金融機関情報, dgSonotaKikanIchiran_Row row) {
        RString 金融機関 = RString.EMPTY;
        for (KinyuKikan kinyuKikanJoho : 金融機関情報) {
            if ((new RString(kinyuKikanJoho.get金融機関コード().toString())).equals(row.getKinyuKikanCode())) {
                金融機関 = kinyuKikanJoho.get金融機関名称();
            }
        }
        return 金融機関;
    }

    /**
     * 金融機関支店を取得します。
     *
     * @param 金融機関情報 List<KinyuKikan>
     * @param row dgSonotaKikanIchiran_Row
     * @return 支店名　RString
     */
    private RString getKinyuShiten(List<KinyuKikan> 金融機関情報, dgSonotaKikanIchiran_Row row) {
        List<KinyuKikanShiten> 支店リスト = new ArrayList<>();
        RString 支店名 = RString.EMPTY;
        for (KinyuKikan kinyuKikanJoho : 金融機関情報) {
            if ((new RString(kinyuKikanJoho.get金融機関コード().toString())).equals(row.getKinyuKikanCode())) {
                支店リスト = kinyuKikanJoho.get支店リスト();
            }
        }
        if (支店リスト != null && !支店リスト.isEmpty()) {
            支店名 = getShitenMeisho(支店リスト, row, 支店名);

        }

        return 支店名;
    }

    private RString getShitenMeisho(List<KinyuKikanShiten> 支店リスト, dgSonotaKikanIchiran_Row row, RString 支店名) {
        for (KinyuKikanShiten shiten : 支店リスト) {
            if (new RString(shiten.get支店コード().toString()).equals(row.getKinyuKikanShitenCode())) {
                支店名 = shiten.get支店名称();
            }
        }
        return 支店名;
    }
}
