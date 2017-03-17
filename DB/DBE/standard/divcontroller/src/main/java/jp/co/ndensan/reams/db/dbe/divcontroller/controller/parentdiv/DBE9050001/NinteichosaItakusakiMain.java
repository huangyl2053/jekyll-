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
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosaitakusakimaster.SonotaKikanMasterMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosaitakusakimaster.SonotaKikanMasterSearchParameter;
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
import jp.co.ndensan.reams.db.dbe.service.core.ikensho.ninteichosaitakusakimaster.SonotaKikanMasterFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * その他機関処理のクラスです。
 *
 * @reamsid_L DBE-1360-010 suguangjun
 */
public class NinteichosaItakusakiMain {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString CSVファイル名 = new RString("その他機関情報.csv");
    private static final RString ROOTTITLE = new RString("その他機関マスタの保存処理が完了しました。");
    private static final RString OUTPUT_CSV_FILE_NAME = new RString("口座情報未登録機関一覧表（その他機関）.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString SELECTKEY_空白 = RString.EMPTY;

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
     * 金融機関コードのonBlur。
     *
     * @param div NinteichosaItakusakiMainDiv
     * @return ResponseData<NinteichosaItakusakiMainDiv>
     */
    public ResponseData<NinteichosaItakusakiMainDiv> onBlur_kinyuKikanCode(NinteichosaItakusakiMainDiv div) {
        getHandler(div).setKozaJoho();
        if (div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().get金融機関() != null) {
            div.getChosaitakusakiJohoInput().getKozaJoho().getDdlYokinShu().setSelectedKey(SELECTKEY_空白);
        }
        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtTenBan().clearValue();
        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtTenMei().clearValue();
        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtGinkoKozaNo().clearValue();
        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtKozaMeiginin().clearValue();
        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtKanjiMeiginin().clearValue();
        return ResponseData.of(div).respond();
    }

    /**
     * 店番のonBlur。
     *
     * @param div NinteichosaItakusakiMainDiv
     * @return ResponseData<NinteichosaItakusakiMainDiv>
     */
    public ResponseData<NinteichosaItakusakiMainDiv> onBlur_txtTenBan(NinteichosaItakusakiMainDiv div) {
        RString tenBan = div.getChosaitakusakiJohoInput().getKozaJoho().getTxtTenBan().getValue();
        if (!RString.isNullOrEmpty(tenBan)) {
            RString shitenMeisho = getHandler(div).getShitenMeisho(tenBan);
            if (!RString.EMPTY.equals(tenBan)) {
                div.getChosaitakusakiJohoInput().getKozaJoho().getTxtTenMei().
                        setValue(shitenMeisho);
            } else {
                div.getChosaitakusakiJohoInput().getKozaJoho().getTxtTenBan().clearValue();
                div.getChosaitakusakiJohoInput().getKozaJoho().getTxtTenMei().clearValue();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 金融機関のonOkClose
     *
     * @param div NinteichosaItakusakiMainDiv
     * @return ResponseData<NinteichosaItakusakiMainDiv>
     */
    public ResponseData<NinteichosaItakusakiMainDiv> onOkClose_KinyuKikan(NinteichosaItakusakiMainDiv div) {
        getHandler(div).setKozaJoho();
        if (div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().get金融機関() != null) {
            div.getChosaitakusakiJohoInput().getKozaJoho().getDdlYokinShu().setSelectedKey(SELECTKEY_空白);
        }
        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtTenBan().clearValue();
        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtTenMei().clearValue();
        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtGinkoKozaNo().clearValue();
        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtKozaMeiginin().clearValue();
        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtKanjiMeiginin().clearValue();
        return ResponseData.of(div).respond();
    }

    /**
     * 検索ボタン押下で検索条件に従い、その他機関情報を検索します。
     *
     * @param div NinteichosaItakusakiMainDiv
     * @return ResponseData<NinteichosaItakusakiMainDiv>
     */
    public ResponseData<NinteichosaItakusakiMainDiv> onClick_btnSearchShujii(NinteichosaItakusakiMainDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }
        RString kanCodeFrom = div.getChosainSearch().getTxtSearchSonotaKikanCodeFrom().getValue();
        RString kanCodeTo = div.getChosainSearch().getTxtSearchSonotaKikanCodeTo().getValue();
        RString kikanKubun = div.getChosainSearch().getDdlkikankubun().getSelectedKey();
        RString itakuKubun = div.getChosainSearch().getDdlitakukubun().getSelectedKey();
        ValidationMessageControlPairs validPairs = getValidationHandler(div).
                validateForSearchShujii(kanCodeFrom, kanCodeTo, kikanKubun, itakuKubun);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (searchChosainInfo(div) == 0) {
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
        }
        div.setHdnShichosonCode(div.getCcdhokensha().getSelectedItem().get証記載保険者番号().value());
        div.setHdnShichosonName(div.getCcdhokensha().getSelectedItem().get市町村名称());
        return ResponseData.of(div).setState(DBE9050001StateName.一覧);
    }

    private int searchChosainInfo(NinteichosaItakusakiMainDiv div) {
        boolean jokyoFlag = false;
        if (div.getRadSearchHaisiFlag().getSelectedIndex() == 0) {
            jokyoFlag = true;
        }
        SonotaKikanMasterMapperParameter parameter = SonotaKikanMasterMapperParameter.createSelectByKeyParam(jokyoFlag,
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
        List<SonotaKikanJohoEntity> sonotaKikanJohoList = SonotaKikanMasterFinder.createInstance().getSonotaKikanichiranList(parameter).records();

        boolean 検索条件初期値 = true;
        if (parameter.isUser機関カナ名称() || parameter.isUser機関の区分() || parameter.isUser機関コードFrom() || parameter.isUser機関コードTo()
                || parameter.isUser機関名称() || parameter.isUser調査委託区分() || !parameter.is状況フラグ()) {
            検索条件初期値 = false;
        }
        if (sonotaKikanJohoList.isEmpty() && !検索条件初期値) {
            ViewStateHolder.put(ViewStateKeys.その他機関マスタ検索結果, Models.create(new ArrayList<SonotaKikanJoho>()));
            return 0;
        }
        getHandler(div).setSonotaKikanichiran(sonotaKikanJohoList);
        ViewStateHolder.put(ViewStateKeys.その他機関マスタ検索結果, Models.create(toSonotaKikanJohos(sonotaKikanJohoList)));
        return sonotaKikanJohoList.size();
    }

    private static List<SonotaKikanJoho> toSonotaKikanJohos(List<SonotaKikanJohoEntity> entities) {
        List<SonotaKikanJoho> list = new ArrayList<>();
        for (SonotaKikanJohoEntity entity : entities) {
            list.add(new SonotaKikanJoho(entity.getEntity()));
        }
        return list;
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
        ViewStateHolder.put(ViewStateKeys.その他機関マスタ選択行, row);
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
        ViewStateHolder.put(ViewStateKeys.その他機関マスタ選択行, row);
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
        ViewStateHolder.put(ViewStateKeys.その他機関マスタ選択行, row);
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
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build()) {
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
        if (row.getWaritsukeTeiin().getValue() != null) {
            waritsukeTeiin = new RString(row.getWaritsukeTeiin().getValue().toString());
        }
        Code chikuCode = new Code(row.getChiku());
        RString chikuMei = new RString("");
        if (!Code.EMPTY.equals(chikuCode)) {
            chikuMei = CodeMaster.getCode(SubGyomuCode.DBE認定支援, DBECodeShubetsu.調査地区コード.getコード(), chikuCode).getコード名称();
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
                !RString.isNullOrEmpty(chikuMei)
                ? chikuMei
                : RString.EMPTY,
                row.getKikanKubun(),
                row.getJokyoFlag(),
                row.getKinyuKikanCode() != null
                ? row.getKinyuKikanCode()
                : RString.EMPTY,
                row.getKinyuKikanMeisho() != null
                ? row.getKinyuKikanMeisho()
                : RString.EMPTY,
                row.getKinyuKikanShitenCode() != null
                ? row.getKinyuKikanShitenCode()
                : RString.EMPTY,
                row.getShitenMeisho() != null
                ? row.getShitenMeisho()
                : RString.EMPTY,
                row.getYokinShu() != null
                ? row.getYokinShu()
                : RString.EMPTY,
                row.getYokinShuMei() != null
                ? row.getYokinShuMei()
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
        int sonotaKikanJohoCount = SonotaKikanMasterFinder.createInstance().getSonotaKikanJohoCount(SonotaKikanMasterSearchParameter.
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
            validPairs = validateForDelete(div);
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
            SonotaKikanJohoIdentifier key = new SonotaKikanJohoIdentifier(
                    new ShoKisaiHokenshaNo(div.getChosaitakusakiJohoInput().getCcdHokenshaJoho().getHokenjaNo()),
                    div.getChosaitakusakiJohoInput().getTxtSonotaKikanCode().getValue());
            dgSonotaKikanIchiran_Row row = new dgSonotaKikanIchiran_Row();
            row = ViewStateHolder.get(ViewStateKeys.その他機関マスタ選択行, dgSonotaKikanIchiran_Row.class);
            RString jotai = row.getJotai();
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
            Models<SonotaKikanJohoIdentifier, SonotaKikanJoho> models = ViewStateHolder.get(
                    ViewStateKeys.その他機関マスタ検索結果, Models.class);
            SonotaKikanJohoManager sonotaKikanJohoManager = new SonotaKikanJohoManager();
            for (SonotaKikanJoho sonotaKikanJoho : models) {
                sonotaKikanJohoManager.saveOrDeleteその他機関情報(sonotaKikanJoho);
            }
            div.getCcdKanryoMessage().setMessage(ROOTTITLE, RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBE9050001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    private ValidationMessageControlPairs validateForDelete(NinteichosaItakusakiMainDiv div) {
        SonotaKikanMasterFinder masterFinder = SonotaKikanMasterFinder.createInstance();
        SonotaKikanMasterSearchParameter parameter = SonotaKikanMasterSearchParameter.createParamForSelectByKey(
                new ShoKisaiHokenshaNo(div.getChosaitakusakiJohoInput().getCcdHokenshaJoho().getHokenjaNo()),
                div.getChosaitakusakiJohoInput().getTxtSonotaKikanCode().getValue());
        return getValidationHandler(div).validateForDelete(
                masterFinder.getKaigoNinteiShinsakaiCount(parameter));
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
            if (!DBE9050001StateName.一覧.toString().equals(ResponseHolder.getState().toString())) {
                getHandler(div).load();
            }
            return ResponseData.of(div).setState(DBE9020001StateName.検索);
        }
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
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build()) {
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
        Code chikuCode = new Code(row.getChiku());
        RString chikuMei = new RString("");
        if (!Code.EMPTY.equals(chikuCode)) {
            chikuMei = CodeMaster.getCode(SubGyomuCode.DBE認定支援, DBECodeShubetsu.調査地区コード.getコード(), chikuCode).getコード名称();
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
                !RString.isNullOrEmpty(chikuMei)
                ? chikuMei
                : RString.EMPTY,
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
}
