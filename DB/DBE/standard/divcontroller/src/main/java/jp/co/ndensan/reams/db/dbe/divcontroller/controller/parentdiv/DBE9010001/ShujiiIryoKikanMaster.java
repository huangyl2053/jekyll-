/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE9010001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.ShichosonMeishoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiiryokikanjohomaster.KoseiShujiiIryoKikanMasterBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiiryokikanjohomaster.KoseiShujiiIryoKikanMasterMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiiryokikanjohomaster.KoseiShujiiIryoKikanMasterSearchParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9010001.DBE9010001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9010001.DBE9010001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9010001.KoseiShujiiIryoKikanMasterCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9010001.ShujiiIryoKikanMasterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9010001.dgShujiiIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE9010001.KoseiShujiiIryoKikanMasterHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE9010001.KoseiShujiiIryoKikanMasterValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shujiiiryokikanmaster.KoseiShujiiIryoKikanMasterFinder;
import jp.co.ndensan.reams.db.dbe.service.core.shujiiiryokikanmaster.ShujiiIryoKikanJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIryoKikanJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIryoKikanJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.definition.core.koseishichosonselector.KoseiShiChosonSelectorModel;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 主治医医療機関情報処理のクラスです。
 *
 * @reamsid_L DBE-0240-010 dongyabin
 */
public class ShujiiIryoKikanMaster {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString CSVファイル名 = new RString("主治医医療機関情報.csv");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString 医療機関コード_0000000000 = new RString("0000000000");
    private static final RString 構成市町村マスタ市町村コード重複種別
            = DbBusinessConfig.get(ConfigNameDBE.構成市町村マスタ市町村コード重複種別, new RDate("20000401"),
                    SubGyomuCode.DBE認定支援, new LasdecCode("000000"), new RString("構成市町村マスタ市町村コード重複種別"));
    private static final RString 四マスタ優先表示市町村識別ID
            = DbBusinessConfig.get(ConfigNameDBE.四マスタ優先表示市町村識別ID, new RDate("20000401"),
                    SubGyomuCode.DBE認定支援, new LasdecCode("000000"), new RString("四マスタ優先表示市町村識別ID"));

    /**
     * コンストラクタです。
     *
     */
    public ShujiiIryoKikanMaster() {
    }

    /**
     * 画面初期化処理です。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onLoad(ShujiiIryoKikanMasterDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, true);
        getHandler(div).clearKensakuJoken();
        return ResponseData.of(div).respond();
    }

    /**
     * 状態変更に従って、主治医医療機関一覧を表示する。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onStateChange(ShujiiIryoKikanMasterDiv div) {
        boolean changeFlag = Boolean.FALSE;
        for (dgShujiiIchiran_Row row : div.getShujiiIchiran().getDgShujiiIchiran().getDataSource()) {
            if (医療機関コード_0000000000.equals(row.getIryoKikanCode())) {
                row.setIryoKikanCode(RString.EMPTY);
            }
            if (!row.getJotai().isEmpty() && !row.getJotai().isNull()) {
                changeFlag = Boolean.TRUE;
            }
        }
        if (changeFlag) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), Boolean.FALSE);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), Boolean.TRUE);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * クリアボタン押下で検索条件入力項目をクリアします。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onClick_btnClearKensakuJoken(ShujiiIryoKikanMasterDiv div) {
        getHandler(div).clearKensakuJoken();
        return ResponseData.of(div).respond();
    }

    /**
     * 検索ボタン押下で検索条件に従い、 主治医医療機関情報を検索します。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onClick_btnSearchKoseiShujiiIryoKikan(
            ShujiiIryoKikanMasterDiv div) {
        searchKoseiShujiiIryoKikanInfo(div);
        if (div.getShujiiIchiran().getDgShujiiIchiran().getDataSource().isEmpty()) {
            getValidationHandler(div).validateBtnReSearchNoResult();
        }
        div.getShujiiIchiran().setDisabled(false);
        div.setHdnShichosonCode(div.getCcdHokenshaList().getSelectedItem().get市町村コード().value());
        div.setHdnShichosonName(div.getCcdHokenshaList().getSelectedItem().get市町村名称());
        return ResponseData.of(div).respond();
    }

    private void searchKoseiShujiiIryoKikanInfo(ShujiiIryoKikanMasterDiv div) {
        boolean jokyoFlag = false;
        if (div.getRadSearchJokyoFlag().getSelectedIndex() == 0) {
            jokyoFlag = true;
        }

        RString 主治医医療機関コードFrom = RString.EMPTY;
        RString 主治医医療機関コードTo = RString.EMPTY;

        if (!div.getTxtSearchShujiiIryokikanCodeFrom().getValue().isNullOrEmpty()
                && !div.getTxtSearchShujiiIryokikanCodeTo().getValue().isNullOrEmpty()) {
            if (Long.valueOf(div.getTxtSearchShujiiIryokikanCodeFrom().getValue().toString())
                    > Long.valueOf(div.getTxtSearchShujiiIryokikanCodeTo().getValue().toString())) {
                主治医医療機関コードFrom = div.getTxtSearchShujiiIryokikanCodeTo().getValue();
                主治医医療機関コードTo = div.getTxtSearchShujiiIryokikanCodeFrom().getValue();
            } else {
                主治医医療機関コードFrom = div.getTxtSearchShujiiIryokikanCodeFrom().getValue();
                主治医医療機関コードTo = div.getTxtSearchShujiiIryokikanCodeTo().getValue();
            }
        } else {
            主治医医療機関コードFrom = div.getTxtSearchShujiiIryokikanCodeFrom().getValue();
            主治医医療機関コードTo = div.getTxtSearchShujiiIryokikanCodeTo().getValue();
        }

        KoseiShujiiIryoKikanMasterMapperParameter parameter = KoseiShujiiIryoKikanMasterMapperParameter.
                createParam_SelectShujiiIryoKikanJohoList(div.getDdlKikanMeisho().getSelectedKey(),
                        div.getDdlKikanKanaMeisho().getSelectedKey(),
                        jokyoFlag,
                        div.getCcdHokenshaList().getSelectedItem().get市町村コード(),
                        主治医医療機関コードFrom,
                        主治医医療機関コードTo,
                        div.getTxtSearchShujiiIryokikanMeisho().getValue(),
                        div.getTxtSearchShujiiIryokikanKanaMeisho().getValue(),
                        四マスタ優先表示市町村識別ID,
                        div.getTxtSaidaiHyojiKensu().getValue(),
                        構成市町村マスタ市町村コード重複種別
                );
        SearchResult<KoseiShujiiIryoKikanMasterBusiness> 主治医医療機関情報一覧
                = KoseiShujiiIryoKikanMasterFinder.createInstance().getShujiKikanJohoIchiranList(parameter);
        getHandler(div).setShujiKikanJohoIchiran(主治医医療機関情報一覧, div.getTxtSaidaiHyojiKensu().getValue());
        List<ShujiiIryoKikanJoho> 主治医医療機関マスタList
                = KoseiShujiiIryoKikanMasterFinder.createInstance().getShujiiIryoKikanJohoList(parameter).records();
        ViewStateHolder.put(ViewStateKeys.主治医医療機関マスタ検索結果, Models.create(主治医医療機関マスタList));
    }

    /**
     * 追加ボタンが押下された場合、明細エリアを空白で表示します。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onClick_btnInsert(ShujiiIryoKikanMasterDiv div) {
        div.getShujiiJohoInput().setState(状態_追加);
        getHandler(div).setDisabledFalse();
        getHandler(div).clearShujiiIryoKikanJohoToMeisai();
        div.getShujiiJohoInput().setHiddenInputDiv(getHandler(div).getInputDiv());
        div.getShujiiJohoInput().getBtnRegisterKoza().setVisible(true);
        div.getShujiiJohoInput().getBtnRegisterKoza().setDisabled(false);
        div.getShujiiJohoInput().getBtnshujiiinsert().setDisabled(false);
        if (!div.getHdnShichosonCode().isEmpty() && !div.getHdnShichosonName().isEmpty()) {
            div.getShujiiJohoInput().getTxtShichoson().setValue(div.getHdnShichosonCode());
            div.getShujiiJohoInput().getTxtShichosonmei().setValue(div.getHdnShichosonName());
            div.getShujiiJohoInput().getTxtShichoson().setDisabled(Boolean.TRUE);
            div.getShujiiJohoInput().getBtnToSearchShichoson().setDisabled(Boolean.TRUE);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 市町村名を取得します。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onBlur_txtShichoson(ShujiiIryoKikanMasterDiv div) {

        RString shichoson = div.getShujiiJohoInput().getTxtShichoson().getValue();
        if (RString.isNullOrEmpty(shichoson)) {
            div.getShujiiJohoInput().getTxtShichosonmei().setValue(RString.EMPTY);
            return ResponseData.of(div).respond();
        }

        List<ShichosonMeishoBusiness> list = KoseiShujiiIryoKikanMasterFinder.createInstance().getShichosonMeisho(new LasdecCode(shichoson)).records();
        if (list.isEmpty()) {
            div.getShujiiJohoInput().getTxtShichosonmei().setValue(RString.EMPTY);
            return ResponseData.of(div).respond();
        }

        div.getShujiiJohoInput().getTxtShichosonmei().setValue(list.get(0).getShichosonMeisho());
        if (構成市町村マスタ市町村コード重複種別.equals(new RString("0"))) {
            return ResponseData.of(div).respond();
        }

        for (ShichosonMeishoBusiness item : list) {
            if (四マスタ優先表示市町村識別ID.equals(item.getShichosonShikibetuID())) {
                div.getShujiiJohoInput().getTxtShichosonmei().setValue(item.getShichosonMeisho());
                break;
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 修正アイコンを押下した場合、入力明細エリアに選択行の内容を表示し、項目を入力可能にします。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onSelectByModifyButton_dgShujiiIchiran(
            ShujiiIryoKikanMasterDiv div) {
        div.getShujiiJohoInput().setState(状態_修正);
        getHandler(div).setDisabledFalse();
        dgShujiiIchiran_Row row = div.getShujiiIchiran().getDgShujiiIchiran().getActiveRow();
        getHandler(div).setShujiiJohoToMeisai(row);
        div.getShujiiJohoInput().getTxtShichoson().setDisabled(true);
        div.getShujiiJohoInput().getBtnToSearchShichoson().setDisabled(true);
        div.getShujiiJohoInput().getTxtShichosonmei().setDisabled(true);
        div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().setDisabled(true);
        div.getShujiiJohoInput().getBtnKakutei().setDisabled(false);
        div.getShujiiJohoInput().setHiddenInputDiv(getHandler(div).getInputDiv());
        div.getShujiiJohoInput().getBtnRegisterKoza().setVisible(true);
        div.getShujiiJohoInput().getBtnRegisterKoza().setDisabled(false);
        div.getShujiiJohoInput().getBtnshujiiinsert().setDisabled(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 削除アイコンを押下した場合、入力明細エリアに選択行の内容を表示し、項目を入力不可にします。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onSelectByDeleteButton_dgShujiiIchiran(
            ShujiiIryoKikanMasterDiv div) {
        div.getShujiiJohoInput().setState(状態_削除);
        dgShujiiIchiran_Row row = div.getShujiiIchiran().getDgShujiiIchiran().getActiveRow();
        getHandler(div).setShujiiJohoToMeisai(row);
        getHandler(div).setDisabledTrue();
        div.getShujiiJohoInput().getBtnKakutei().setDisabled(false);
        div.getShujiiJohoInput().getBtnRegisterKoza().setVisible(true);
        div.getShujiiJohoInput().getBtnshujiiinsert().setDisabled(true);
        div.getShujiiJohoInput().getBtnRegisterKoza().setDisabled(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 選択行の内容を、明細エリアに表示します。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onSelectByDlbClick_dgShujiiIchiran(ShujiiIryoKikanMasterDiv div) {
        dgShujiiIchiran_Row row = div.getShujiiIchiran().getDgShujiiIchiran().getActiveRow();
        getHandler(div).setShujiiJohoToMeisai(row);
        if (状態_修正.equals(row.getJotai())) {
            div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().setDisabled(true);
            div.getShujiiJohoInput().getBtnRegisterKoza().setDisabled(false);
            div.getShujiiJohoInput().getBtnshujiiinsert().setDisabled(false);
        } else if (状態_削除.equals(row.getJotai())) {
            getHandler(div).setDisabledTrue();
            div.getShujiiJohoInput().getBtnRegisterKoza().setDisabled(true);
            div.getShujiiJohoInput().getBtnshujiiinsert().setDisabled(true);
        } else if (RString.EMPTY.equals(row.getJotai())) {
            getHandler(div).setDisabledTrue();
            div.getShujiiJohoInput().getBtnKakutei().setDisabled(true);
            div.getShujiiJohoInput().getBtnRegisterKoza().setDisabled(true);
            div.getShujiiJohoInput().getBtnshujiiinsert().setDisabled(true);
        }
        div.getShujiiJohoInput().getBtnRegisterKoza().setVisible(true);
        return ResponseData.of(div).respond();
    }

    /**
     * ＣＳＶを出力するボタンが押下された場合、ＣＳＶを出力します。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @param response IDownLoadServletResponse
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public IDownLoadServletResponse onClick_btnOutputCsv(ShujiiIryoKikanMasterDiv div, IDownLoadServletResponse response) {
        getValidationHandler(div).validateForOutputCsv();
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), CSVファイル名);
        try (CsvWriter<KoseiShujiiIryoKikanMasterCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.UTF_8withBOM).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(true).build()) {
            List<dgShujiiIchiran_Row> dataList = div.getShujiiIchiran().getDgShujiiIchiran().getDataSource();
            for (dgShujiiIchiran_Row row : dataList) {
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

    private KoseiShujiiIryoKikanMasterCsvEntity getCsvData(dgShujiiIchiran_Row row) {
        KoseiShujiiIryoKikanMasterCsvEntity data = new KoseiShujiiIryoKikanMasterCsvEntity(
                row.getShichosonCode(),
                row.getShichoson(),
                row.getShujiiIryoKikanCode().getValue(),
                row.getIryoKikanCode(),
                row.getShujiiIryoKikan(),
                row.getShujiiIryoKikankana(),
                row.getYubinNo(),
                row.getJusho(),
                row.getTelNo(),
                row.getFaxNo(),
                row.getDaihyosha(),
                row.getDaihyoshakana(),
                row.getJokyoFlag());
        return data;
    }

    /**
     * 医療機関検索ボタンが押下された場合、医療機関選択ダイアログを表示します。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onBeforeOpenDialog(ShujiiIryoKikanMasterDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 医療機関検索ボタンが押下された場合、医療機関選択ダイアログを表示します。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onOkClose(ShujiiIryoKikanMasterDiv div) {
        div.getShujiiJohoInput().getTxtiryokikanCode().setValue(div.getHdnTxtIryoKikanCode());
        return ResponseData.of(div).respond();
    }

    /**
     * 市町村検索ボタンが押下された場合、医療機関選択ダイアログを表示します。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onbtnBefore(ShujiiIryoKikanMasterDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 市町村検索ボタンが押下された場合、医療機関選択ダイアログを表示します。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onbtnOkClose(ShujiiIryoKikanMasterDiv div) {
        KoseiShiChosonSelectorModel model = ViewStateHolder
                .get(ViewStateKeys.引き継ぎデータ, KoseiShiChosonSelectorModel.class
                );
        div.getShujiiJohoInput()
                .getTxtShichosonmei().setValue(model.get市町村名称());
        div.getShujiiJohoInput()
                .getTxtShichoson().setValue(model.get市町村コード());
        return ResponseData.of(div)
                .respond();
    }

    /**
     * 口座情報を登録するボタンが押下された場合、口座情報画面へ遷移する。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onClick_Shujii(ShujiiIryoKikanMasterDiv div) {
        div.setHdnkey_ShikibetsuCode(SubGyomuCode.DBE認定支援.getColumnValue());
        div.setHdnkey_ShikibetsuCode(new RString("002"));
        return ResponseData.of(div).respond();
    }

    /**
     * 取消するボタンが押下された場合、入力明細エリアの入力内容を破棄し、主治医医療機関情報一覧エリアへ戻ります。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onClick_btnTorikeshi(ShujiiIryoKikanMasterDiv div) {
        boolean 状態 = ViewStateHolder.get(ViewStateKeys.状態, boolean.class);
        if ((状態_追加.equals(div.getShujiiJohoInput().getState())
                || 状態_修正.equals(div.getShujiiJohoInput().getState()))
                && getValidationHandler(div).isUpdate()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                div.getShujiiIchiran().setDisabled(false);
                change状態(状態, div);
                return ResponseData.of(div).setState(DBE9010001StateName.医療機関一覧);
            }
            return ResponseData.of(div).setState(DBE9010001StateName.医療機関詳細);
        }
        div.getShujiiIchiran().setDisabled(false);
        change状態(状態, div);
        return ResponseData.of(div).setState(DBE9010001StateName.医療機関一覧);
    }

    private void change状態(boolean 状態, ShujiiIryoKikanMasterDiv div) {
        if (!状態) {
            getHandler(div)
                    .setShujiiIryoKikanJohoToIchiran(状態_追加, 状態);
            ViewStateHolder.put(ViewStateKeys.状態, true);
        }
    }

    /**
     * 確定するボタンが押下された場合、入力明細エリアの入力内容を主治医医療機関情報一覧に反映させます。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onClick_btnKakutei(ShujiiIryoKikanMasterDiv div) {
        RString イベント状態 = div.getShujiiJohoInput().getState();
        boolean 状態 = ViewStateHolder.get(ViewStateKeys.状態, boolean.class);
        if (状態) {
            int shujiioCount = KoseiShujiiIryoKikanMasterFinder.createInstance().getShujiiIryoKikanJohoCount(
                    KoseiShujiiIryoKikanMasterSearchParameter.createParam_SelectShujiiIryoKikanJoho(
                            new LasdecCode(div.getShujiiJohoInput().getTxtShichoson().getValue()),
                            new ShujiiIryokikanCode(div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().getValue())));
            getValidationHandler(div).validateForKakutei(イベント状態, shujiioCount);
        }
        Models<ShujiiIryoKikanJohoIdentifier, ShujiiIryoKikanJoho> models
                = ViewStateHolder.get(ViewStateKeys.主治医医療機関マスタ検索結果, Models.class
                );
        if (状態_追加.equals(イベント状態)) {
            ShujiiIryoKikanJoho shujiiIryoKikanJoho = new ShujiiIryoKikanJoho(
                    new LasdecCode(div.getShujiiJohoInput().getTxtShichoson().getValue()),
                    new ShujiiIryokikanCode(div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().getValue()));
            shujiiIryoKikanJoho = getHandler(div).editShujiiIryoKikanJoho(shujiiIryoKikanJoho);
            models.add(shujiiIryoKikanJoho);
        } else if (状態_修正.equals(イベント状態)) {
            ShujiiIryoKikanJohoIdentifier key = new ShujiiIryoKikanJohoIdentifier(
                    new LasdecCode(div.getShujiiJohoInput().getTxtShichoson().getValue()),
                    new ShujiiIryokikanCode(div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().getValue()));
            ShujiiIryoKikanJoho shujiiIryoKikanJoho = getHandler(div).editShujiiIryoKikanJoho(models.get(key).
                    modifiedModel());
            models.deleteOrRemove(key);
            models.add(shujiiIryoKikanJoho);
        } else if (状態_削除.equals(イベント状態)) {
            ShujiiIryoKikanJohoIdentifier key = new ShujiiIryoKikanJohoIdentifier(
                    new LasdecCode(div.getShujiiJohoInput().getTxtShichoson().getValue()),
                    new ShujiiIryokikanCode(div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().getValue()));

            RString jotai = div.getShujiiIchiran().getDgShujiiIchiran().getActiveRow().getJotai();
            if (状態_追加.equals(jotai)) {
                models.deleteOrRemove(key);
            } else {
                ShujiiIryoKikanJoho shujiiIryoKikanJoho = getHandler(div).editShujiiIryoKikanJoho(models.get(key).
                        deleted());
                models.add(shujiiIryoKikanJoho);
            }
        }

        ViewStateHolder.put(ViewStateKeys.主治医医療機関マスタ検索結果, models);

        div.getShujiiIchiran()
                .setDisabled(false);

        if (状態) {
            getHandler(div)
                    .setShujiiIryoKikanJohoToIchiran(イベント状態, 状態);
        } else {
            getHandler(div)
                    .setShujiiIryoKikanJohoToIchiran(状態_追加, 状態);
            ViewStateHolder.put(ViewStateKeys.状態, true);
        }

        return ResponseData.of(div)
                .setState(DBE9010001StateName.医療機関一覧);
    }

    /**
     * 再検索するボタン押下で検索条件に従い、 主治医医療機関情報を検索します。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onClick_btnReSearch(ShujiiIryoKikanMasterDiv div) {
        List<dgShujiiIchiran_Row> ichiranList = div.getShujiiIchiran().getDgShujiiIchiran().getDataSource();
        boolean isUpdate = false;
        for (dgShujiiIchiran_Row row : ichiranList) {
            if (!RString.EMPTY.equals(row.getJotai())) {
                isUpdate = true;
                break;
            }
        }
        if (isUpdate) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.検索画面遷移の確認.getMessage().
                        getCode(),
                        UrQuestionMessages.検索画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.
                    getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                onLoad(div);
                div.getShujiiSearch().setDisabled(false);
                return ResponseData.of(div).setState(DBE9010001StateName.検索);
            }
        } else {
            onLoad(div);
            div.getShujiiSearch().setDisabled(false);
            return ResponseData.of(div).setState(DBE9010001StateName.検索);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 保存するボタン押下、データがDBに更新します。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onClick_btnSave(ShujiiIryoKikanMasterDiv div) {
        return getSave(div);
    }

    private ResponseData<ShujiiIryoKikanMasterDiv> getSave(ShujiiIryoKikanMasterDiv div) {
        getValidationHandler(div).validateForUpdate();
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            validateForDelete(div);
            Models<ShujiiIryoKikanJohoIdentifier, ShujiiIryoKikanJoho> models = ViewStateHolder.
                    get(ViewStateKeys.主治医医療機関マスタ検索結果, Models.class
                    );
            ShujiiIryoKikanJohoManager shujiiIryoKikanJohoManager = ShujiiIryoKikanJohoManager.createInstance();
            for (ShujiiIryoKikanJoho shujiiIryoKikanJoho : models) {
                shujiiIryoKikanJohoManager.saveOrDelete主治医医療機関情報(shujiiIryoKikanJoho);
            }

            div.getCcdKanryoMessage()
                    .setSuccessMessage(
                            new RString(UrInformationMessages.保存終了.getMessage().evaluate()), RString.EMPTY, RString.EMPTY);
            return ResponseData.of(div)
                    .setState(DBE9010001StateName.完了);
        }
        return ResponseData.of(div).respond();

    }

    private void validateForDelete(ShujiiIryoKikanMasterDiv div) {
        List<dgShujiiIchiran_Row> dataList = div.getShujiiIchiran().getDgShujiiIchiran().getDataSource();
        KoseiShujiiIryoKikanMasterFinder koseiShujiiIryoKikanMaster = KoseiShujiiIryoKikanMasterFinder.
                createInstance();
        for (dgShujiiIchiran_Row row : dataList) {
            if (状態_削除.equals(row.getJotai())) {
                KoseiShujiiIryoKikanMasterSearchParameter parameter = KoseiShujiiIryoKikanMasterSearchParameter.
                        createParam_SelectShujiiIryoKikanJoho(
                                new LasdecCode(row.getShichosonCode()),
                                new ShujiiIryokikanCode(row.getShujiiIryoKikanCode().getValue()));
                getValidationHandler(div).validateForDelete(
                        koseiShujiiIryoKikanMaster.getShujiiJohoCount(parameter));
            }
        }
    }

    /**
     * 主治医を登録ボタンボタン押下で、主治医マスタに戻ります。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onClick_btnBackShujiiMasterToToroku(ShujiiIryoKikanMasterDiv div) {
        ViewStateHolder.put(SaibanHanyokeyName.医療機関コード, div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().getValue());
        ViewStateHolder.put(ViewStateKeys.市町村コード, div.getShujiiJohoInput().getTxtShichoson().getValue());

        if (状態_追加.equals(div.getShujiiJohoInput().getState())) {
            RString イベント状態 = div.getShujiiJohoInput().getState();
            int shujiioCount = KoseiShujiiIryoKikanMasterFinder.createInstance().getShujiiIryoKikanJohoCount(
                    KoseiShujiiIryoKikanMasterSearchParameter.createParam_SelectShujiiIryoKikanJoho(
                            new LasdecCode(div.getShujiiJohoInput().getTxtShichoson().getValue()),
                            new ShujiiIryokikanCode(div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().getValue())));
            getValidationHandler(div).validateForKakutei(イベント状態, shujiioCount);
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.確認_汎用.getMessage().getCode(),
                        UrQuestionMessages.確認_汎用.getMessage().replace(new RString("医療機関情報を登録してから画面遷移して").toString()).evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.確認_汎用.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

                Models<ShujiiIryoKikanJohoIdentifier, ShujiiIryoKikanJoho> models = ViewStateHolder.
                        get(ViewStateKeys.主治医医療機関マスタ検索結果, Models.class);
                ShujiiIryoKikanJoho shujiiIryoKikanJoho = new ShujiiIryoKikanJoho(
                        new LasdecCode(div.getShujiiJohoInput().getTxtShichoson().getValue()),
                        new ShujiiIryokikanCode(div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().getValue()));
                shujiiIryoKikanJoho = getHandler(div).editShujiiIryoKikanJoho(shujiiIryoKikanJoho);
                ShujiiIryoKikanJohoManager shujiiIryoKikanJohoManager = ShujiiIryoKikanJohoManager.createInstance();
                shujiiIryoKikanJohoManager.saveOrDelete主治医医療機関情報(shujiiIryoKikanJoho);
                models.add(shujiiIryoKikanJoho);

                ViewStateHolder.put(ViewStateKeys.主治医医療機関マスタ検索結果, models);

                return ResponseData.of(div).forwardWithEventName(DBE9010001TransitionEventName.主治医マスタに遷移).respond();
            }

            return ResponseData.of(div).respond();
        }

        if (状態_削除.equals(div.getShujiiJohoInput().getState())
                || RString.EMPTY.equals(div.getShujiiJohoInput().getState())
                || ((状態_修正.equals(div.getShujiiJohoInput().getState())
                || 状態_追加.equals(div.getShujiiJohoInput().getState())
                && !getValidationHandler(div).isUpdate()))) {
            return ResponseData.of(div).forwardWithEventName(DBE9010001TransitionEventName.主治医マスタに遷移).respond();
        } else if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                    UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBE9010001TransitionEventName.主治医マスタに遷移).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 活性非活性の処理を行います。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onActive(ShujiiIryoKikanMasterDiv div) {
        if (状態_追加.equals(div.getShujiiJohoInput().getState())) {
            div.getShujiiJohoInput().setState(状態_修正);
            ViewStateHolder.put(ViewStateKeys.状態, false);
            getHandler(div).setDisabledFalse();
            div.getShujiiJohoInput().getTxtShichoson().setDisabled(true);
            div.getShujiiJohoInput().getBtnToSearchShichoson().setDisabled(true);
            div.getShujiiJohoInput().getTxtShichosonmei().setDisabled(true);
            div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().setDisabled(true);
            div.getShujiiJohoInput().getBtnKakutei().setDisabled(false);
            div.getShujiiJohoInput().setHiddenInputDiv(getHandler(div).getInputDiv());
            div.getShujiiJohoInput().getBtnRegisterKoza().setVisible(true);
        }
        return ResponseData.of(div).respond();
    }

    private KoseiShujiiIryoKikanMasterHandler getHandler(ShujiiIryoKikanMasterDiv div) {
        return new KoseiShujiiIryoKikanMasterHandler(div);
    }

    private KoseiShujiiIryoKikanMasterValidationHandler getValidationHandler(ShujiiIryoKikanMasterDiv div) {
        return new KoseiShujiiIryoKikanMasterValidationHandler(div);
    }
}
