/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE9020001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.ShichosonMeishoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.syujii.shujiijoho.ShujiiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.syujii.shujiijoho.ShujiiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9020001.DBE9020001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9020001.DBE9020001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9020001.ShujiiMasterCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9020001.ShujiiMasterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9020001.dgShujiiIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE9020001.ShujiiMasterHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE9020001.ShujiiMasterValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.shujiijoho.ShujiiMasterFinder;
import jp.co.ndensan.reams.db.dbe.service.core.syujii.shujiijoho.ShujiiJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiinput.ShujiiIryokikanandshujiiDataPassModel;
import jp.co.ndensan.reams.db.dbz.definition.core.koseishichosonselector.KoseiShiChosonSelectorModel;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuideDiv.TaishoMode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
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
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiijoho.ShujiiMasterMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiijoho.ShujiiMasterSearchParameter;
import jp.co.ndensan.reams.db.dbe.service.core.shujiiiryokikanmaster.KoseiShujiiIryoKikanMasterFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;

/**
 * 主治医マスタ処理のクラスです。。
 *
 * @reamsid_L DBE-0250-010 suguangjun
 */
public class ShujiiMaster {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString CSVファイル名 = new RString("主治医情報.csv");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
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
    public ShujiiMaster() {
    }

    /**
     * 画面初期化処理です。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<ShujiiMasterDiv> onLoad(ShujiiMasterDiv div) {
        getHandler(div).load();
        getHandler(div).clearKensakuJoken();

        RString 主治医医療機関コード = ViewStateHolder.get(SaibanHanyokeyName.医療機関コード, RString.class);

        if (!RString.isNullOrEmpty(主治医医療機関コード)) {
            LasdecCode 市町村コード = new LasdecCode(ViewStateHolder.get(ViewStateKeys.市町村コード, RString.class));
            div.getShujiiSearch().getTxtSearchShujiiIryokikanCodeFrom().setValue(主治医医療機関コード);
            div.getShujiiSearch().getTxtSearchShujiiIryokikanCodeTo().setValue(主治医医療機関コード);
            div.getShujiiSearch().getCcdHokenshaList().setSelectedShichosonIfExist(市町村コード);
            searchChosainInfo(div);
            return ResponseData.of(div).setState(DBE9020001StateName.主治医一覧_医療機関登録から遷移);
        }

        return ResponseData.of(div).setState(DBE9020001StateName.検索);
    }

    /**
     * クリアボタン押下で検索条件入力項目をクリアします。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<ShujiiMasterDiv> onClick_btnClearKensakuJoken(ShujiiMasterDiv div) {
        getHandler(div).clearKensakuJoken();
        return ResponseData.of(div).respond();
    }

    /**
     * 検索ボタン押下で検索条件に従い、主治医情報を検索します。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<ShujiiMasterDiv> onClick_btnSearchShujii(ShujiiMasterDiv div) {
        searchChosainInfo(div);
        if (div.getShujiiIchiran().getDgShujiiIchiran().getDataSource().isEmpty()) {
            return ResponseData.of(div).addValidationMessages(getValidationHandler(div).validateBtnReSearchNoResult()).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 再検索するボタン押下で検索条件に従い、主治医情報を検索します。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<ShujiiMasterDiv> onClick_btnReSearch(ShujiiMasterDiv div) {

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
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.検索画面遷移の確認.getMessage()
                        .getCode(),
                        UrQuestionMessages.検索画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                div.getShujiiSearch().setDisabled(false);
                return ResponseData.of(div).setState(DBE9020001StateName.検索);
            }
        } else {
            div.getShujiiSearch().setDisplayNone(false);
            div.getShujiiSearch().setDisabled(false);
            getHandler(div).load();
            getHandler(div).clearKensakuJoken();
            return ResponseData.of(div).setState(DBE9020001StateName.検索);
        }
        getHandler(div).load();
        getHandler(div).clearKensakuJoken();
        return ResponseData.of(div).respond();
    }

    private void searchChosainInfo(ShujiiMasterDiv div) {
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

        RString 主治医コードFrom = RString.EMPTY;
        RString 主治医コードTo = RString.EMPTY;

        if (!div.getTxtSearchShujiiCodeFrom().getValue().isNullOrEmpty()
            && !div.getTxtSearchShujiiCodeTo().getValue().isNullOrEmpty()) {
            if (Long.valueOf(div.getTxtSearchShujiiCodeFrom().getValue().toString())
                > Long.valueOf(div.getTxtSearchShujiiCodeTo().getValue().toString())) {
                主治医コードFrom = div.getTxtSearchShujiiCodeTo().getValue();
                主治医コードTo = div.getTxtSearchShujiiCodeFrom().getValue();
            } else {
                主治医コードFrom = div.getTxtSearchShujiiCodeFrom().getValue();
                主治医コードTo = div.getTxtSearchShujiiCodeTo().getValue();
            }
        } else {
            主治医コードFrom = div.getTxtSearchShujiiCodeFrom().getValue();
            主治医コードTo = div.getTxtSearchShujiiCodeTo().getValue();
        }

        ShujiiMasterMapperParameter parameter = ShujiiMasterMapperParameter.createSelectByKeyParam(
                div.getCcdHokenshaList().getSelectedItem().get市町村コード(),
                jokyoFlag,
                主治医医療機関コードFrom,
                主治医医療機関コードTo,
                div.getTxtSearchShujiiIryokikanMeisho().getValue(),
                div.getDdlKikanMeisho().getSelectedKey(),
                div.getTxtSearchShujiiIryokikanKanaMeisho().getValue(),
                div.getDdlKikanKanaMeisho().getSelectedKey(),
                主治医コードFrom,
                主治医コードTo,
                div.getTxtSearchShujiiShimei().getValue(),
                div.getDdlShujiiMeisho().getSelectedKey(),
                new AtenaKanaMeisho(div.getTxtSearchShujiiKanaShimei().getValue()),
                div.getDdlShujiiKanaMeisho().getSelectedKey(),
                div.getTxtSaidaiHyojiKensu().getValue(),
                四マスタ優先表示市町村識別ID,
                構成市町村マスタ市町村コード重複種別);
        ShujiiMasterFinder shujiiMasterFinder = ShujiiMasterFinder.createInstance();
        List<jp.co.ndensan.reams.db.dbe.business.core.shujiijoho.ShujiiMaster> 主治医情報List
                = shujiiMasterFinder.getShujiiIchiranList(
                        parameter).records();

        div.getShujiiSearch().setDisabled(true);
        div.getShujiiIchiran().setDisabled(false);
        getHandler(div).setShujiiIchiran(主治医情報List);
        List<ShujiiJoho> 主治医マスタList = shujiiMasterFinder.getShujiiJohoList(parameter).records();
        ViewStateHolder.put(ViewStateKeys.主治医マスタ検索結果, Models.create(主治医マスタList));
    }

    /**
     * 追加ボタンが押下された場合、明細エリアを空白で表示します。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<ShujiiMasterDiv> onClick_btnInsert(ShujiiMasterDiv div) {
        div.getShujiiJohoInput().setState(状態_追加);
        div.getShujiiIchiran().setDisabled(true);
        getHandler(div).setDisabledFalseToShujiiJohoInputMeisai();
        div.getShujiiJohoInput().getTxtShichosonmei().setDisabled(true);
        div.getShujiiJohoInput().getTxtShujiiIryoKikanMei().setDisabled(true);
        div.getShujiiJohoInput().getBtnKakutei().setDisabled(false);
        div.getShujiiJohoInput().getBtnToSearchShichoson().setDisabled(false);
        div.getShujiiJohoInput().getBtnToSearchIryoKikan().setDisabled(false);
        getHandler(div).clearShujiiJohoInputMeisai();
        div.getShujiiJohoInput().setHiddenInputDiv(getHandler(div).getInputDiv());

        RString 主治医医療機関コード = ViewStateHolder.get(SaibanHanyokeyName.医療機関コード, RString.class);

        if (!RString.isNullOrEmpty(主治医医療機関コード)) {
            RString 市町村コード = ViewStateHolder.get(ViewStateKeys.市町村コード, RString.class);
            div.getShujiiJohoInput().getTxtShichoson().setValue(市町村コード);
            div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().setValue(主治医医療機関コード);
            onBlur_txtShichoson(div);
            onBlur_txtSearchShujiiIryokikanMeisho(div);
            return ResponseData.of(div).setState(DBE9020001StateName.主治医登録_医療機関登録から遷移);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * ＣＳＶを出力するボタンが押下された場合、ＣＳＶを出力します。
     *
     * @param div ShujiiMasterDiv
     * @param response IDownLoadServletResponse
     * @return ResponseData<ShujiiMasterDiv>
     */
    public IDownLoadServletResponse onClick_btnOutputCsv(ShujiiMasterDiv div, IDownLoadServletResponse response) {
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), CSVファイル名);
        try (CsvWriter<ShujiiMasterCsvEntity> csvWriter
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

    private ShujiiMasterCsvEntity getCsvData(dgShujiiIchiran_Row row) {
        ShujiiMasterCsvEntity data = new ShujiiMasterCsvEntity(
                row.getShichosonCode(),
                row.getShichoson(),
                row.getShujiiCode().getValue(),
                row.getShujiiShimei(),
                row.getShujiiKanaShimei(),
                row.getShujiiIryoKikanCode().getValue(),
                row.getShujiiIryoKikan(),
                row.getShinryoka(),
                row.getShiteii(),
                row.getJokyoFlag(),
                row.getYubinNo(),
                row.getJusho(),
                row.getTelNo(),
                row.getFaxNo(),
                row.getSeibetsu());
        return data;
    }

    /**
     * 取消するボタンが押下された場合、入力明細エリアの入力内容を破棄し、主治医一覧エリアへ戻ります。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<ShujiiMasterDiv> onClick_btnTorikeshi(ShujiiMasterDiv div) {

        RString 主治医医療機関コード = ViewStateHolder.get(SaibanHanyokeyName.医療機関コード, RString.class);

        if ((状態_追加.equals(div.getShujiiJohoInput().getState()) && getValidationHandler(div).isUpdate())
            || (状態_修正.equals(div.getShujiiJohoInput().getState()) && getValidationHandler(div).isUpdate())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                responseWithSettingState(div, 主治医医療機関コード);
            } else if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                       && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        return responseWithSettingState(div, 主治医医療機関コード);
    }

    private ResponseData<ShujiiMasterDiv> responseWithSettingState(ShujiiMasterDiv div, RString 主治医医療機関コード) {
        div.getShujiiIchiran().setDisabled(false);
        if (!RString.isNullOrEmpty(主治医医療機関コード)) {
            return ResponseData.of(div).setState(DBE9020001StateName.主治医一覧_医療機関登録から遷移);
        }
        return ResponseData.of(div).setState(DBE9020001StateName.主治医一覧);
    }

    /**
     * 確定するボタンが押下された場合、入力明細エリアの入力内容を主治医一覧に反映させます。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<ShujiiMasterDiv> onClick_btnKakutei(ShujiiMasterDiv div) {

        RString イベント状態 = div.getShujiiJohoInput().getState();
        int shujiiJohoCount = ShujiiMasterFinder.createInstance().getShujiiJohoCount(ShujiiMasterSearchParameter.
                createParamForSelectShujiiJoho(new LasdecCode(div.getShujiiJohoInput().getTxtShichoson().getValue()),
                        div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().getValue(),
                        div.getShujiiJohoInput().getTxtShujiiCode().getValue()));
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForKakutei(イベント状態, shujiiJohoCount);

        if (validPairs.iterator().hasNext()) {
            div.getShujiiIchiran().setDisabled(false);
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        Models<ShujiiJohoIdentifier, ShujiiJoho> models = ViewStateHolder.get(ViewStateKeys.主治医マスタ検索結果, Models.class);

        if (状態_追加.equals(イベント状態)) {
            ShujiiJoho shujiiJoho = new ShujiiJoho(
                    new LasdecCode(div.getShujiiJohoInput().getTxtShichoson().getValue()),
                    div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().getValue(),
                    div.getShujiiJohoInput().getTxtShujiiCode().getValue()
            );
            shujiiJoho = getHandler(div).editShujiiJoho(shujiiJoho);
            models.add(shujiiJoho);
        } else if (状態_修正.equals(イベント状態)) {
            ShujiiJohoIdentifier key = new ShujiiJohoIdentifier(
                    new LasdecCode(div.getShujiiJohoInput().getTxtShichoson().getValue()),
                    div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().getValue(),
                    div.getShujiiJohoInput().getTxtShujiiCode().getValue());
            ShujiiJoho shujiiJoho = getHandler(div).editShujiiJoho(models.get(key).modifiedModel());
            models.deleteOrRemove(key);
            models.add(shujiiJoho);
        } else if (状態_削除.equals(イベント状態)) {
            ShujiiJohoIdentifier key = new ShujiiJohoIdentifier(
                    new LasdecCode(div.getShujiiJohoInput().getTxtShichoson().getValue()),
                    div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().getValue(),
                    div.getShujiiJohoInput().getTxtShujiiCode().getValue());
            RString jotai = div.getShujiiIchiran().getDgShujiiIchiran().getActiveRow().getJotai();
            if (状態_追加.equals(jotai)) {
                models.deleteOrRemove(key);
            } else {
                ShujiiJoho shujiiJoho = getHandler(div).editShujiiJoho(models.get(key).deleted());
                models.add(shujiiJoho);
            }
        }
        ViewStateHolder.put(ViewStateKeys.主治医マスタ検索結果, models);
        div.getShujiiIchiran().setDisabled(false);
        getHandler(div).setShujiiJohoToIchiran(イベント状態);
        RString 主治医医療機関コード = ViewStateHolder.get(SaibanHanyokeyName.医療機関コード, RString.class);
        if (!RString.isNullOrEmpty(主治医医療機関コード)) {
            return ResponseData.of(div).setState(DBE9020001StateName.主治医一覧_医療機関登録から遷移);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 選択行の内容を、明細エリアに表示します。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<ShujiiMasterDiv> onSelectByDlbClick_dgShujiiIchiran(ShujiiMasterDiv div) {
        dgShujiiIchiran_Row row = div.getShujiiIchiran().getDgShujiiIchiran().getActiveRow();
        getHandler(div).setShujiiJohoToMeisai(row);
        if (状態_修正.equals(row.getJotai())) {
            div.getShujiiJohoInput().getTxtShichoson().setDisabled(true);
            div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().setDisabled(true);
            div.getShujiiJohoInput().getTxtShujiiCode().setDisabled(true);
        } else if (状態_削除.equals(row.getJotai())) {
            getHandler(div).setDisabledTrueToShujiiJohoInputMeisai();
            div.getShujiiJohoInput().getBtnToSearchShichoson().setDisabled(true);
            div.getShujiiJohoInput().getBtnToSearchIryoKikan().setDisabled(true);
        } else if (RString.EMPTY.equals(row.getJotai())) {
            getHandler(div).setDisabledTrueToShujiiJohoInputMeisai();
            div.getShujiiJohoInput().getBtnKakutei().setDisabled(true);
            div.getShujiiJohoInput().getBtnToSearchShichoson().setDisabled(true);
            div.getShujiiJohoInput().getBtnToSearchIryoKikan().setDisabled(true);
        }
        div.getShujiiIchiran().setDisabled(true);
        RString 主治医医療機関コード = ViewStateHolder.get(SaibanHanyokeyName.医療機関コード, RString.class);
        if (!RString.isNullOrEmpty(主治医医療機関コード)) {
            return ResponseData.of(div).setState(DBE9020001StateName.主治医登録_医療機関登録から遷移);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 修正アイコンを押下した場合、入力明細エリアに選択行の内容を表示し、項目を入力可能にします。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<ShujiiMasterDiv> onSelectByModifyButton_dgShujiiIchiran(ShujiiMasterDiv div) {
        div.getShujiiJohoInput().setState(状態_修正);
        getHandler(div).setDisabledFalseToShujiiJohoInputMeisai();
        dgShujiiIchiran_Row row = div.getShujiiIchiran().getDgShujiiIchiran().getClickedItem();
        getHandler(div).setShujiiJohoToMeisai(row);
        div.getShujiiJohoInput().getTxtShichoson().setDisabled(true);
        div.getShujiiJohoInput().getBtnToSearchShichoson().setDisabled(true);
        div.getShujiiJohoInput().getTxtShichosonmei().setDisabled(true);
        div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().setDisabled(true);
        div.getShujiiJohoInput().getBtnToSearchIryoKikan().setDisabled(true);
        div.getShujiiJohoInput().getTxtShujiiIryoKikanMei().setDisabled(true);
        div.getShujiiJohoInput().getTxtShujiiCode().setDisabled(true);
        div.getShujiiJohoInput().getBtnKakutei().setDisabled(false);
        div.getShujiiIchiran().setDisabled(true);
        div.getShujiiJohoInput().setHiddenInputDiv(getHandler(div).getInputDiv());
        RString 主治医医療機関コード = ViewStateHolder.get(SaibanHanyokeyName.医療機関コード, RString.class);
        if (!RString.isNullOrEmpty(主治医医療機関コード)) {
            return ResponseData.of(div).setState(DBE9020001StateName.主治医登録_医療機関登録から遷移);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 削除アイコンを押下した場合、入力明細エリアに選択行の内容を表示し、項目を入力不可にします。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<ShujiiMasterDiv> onSelectByDeleteButton_dgShujiiIchiran(ShujiiMasterDiv div) {
        div.getShujiiJohoInput().setState(状態_削除);
        dgShujiiIchiran_Row row = div.getShujiiIchiran().getDgShujiiIchiran().getActiveRow();
        getHandler(div).setShujiiJohoToMeisai(row);
        getHandler(div).setDisabledTrueToShujiiJohoInputMeisai();
        div.getShujiiJohoInput().getBtnKakutei().setDisabled(false);
        div.getShujiiJohoInput().getBtnToSearchShichoson().setDisabled(true);
        div.getShujiiJohoInput().getBtnToSearchIryoKikan().setDisabled(true);
        div.getShujiiIchiran().setDisabled(true);
        RString 主治医医療機関コード = ViewStateHolder.get(SaibanHanyokeyName.医療機関コード, RString.class);
        if (!RString.isNullOrEmpty(主治医医療機関コード)) {
            return ResponseData.of(div).setState(DBE9020001StateName.主治医登録_医療機関登録から遷移);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 市町村名を取得します。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<ShujiiMasterDiv> onBlur_txtShichoson(ShujiiMasterDiv div) {
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
     * 主治医医療機関名を取得します。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<ShujiiMasterDiv> onBlur_txtSearchShujiiIryokikanMeisho(ShujiiMasterDiv div) {
        RString txtShujiiIryoKikanCode = div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().getValue();
        if (!RString.isNullOrEmpty(txtShujiiIryoKikanCode)) {
            RString shujiiIryoKikanMei = ShujiiMasterFinder.createInstance().getShujiiIryoKikanJoho(
                    ShujiiMasterSearchParameter.createParamForSelectShujiiJoho(
                            new LasdecCode(div.getShujiiJohoInput().getTxtShichoson().getValue()),
                            div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().getValue(),
                            div.getShujiiJohoInput().getTxtShujiiCode().getValue()));

            if (!RString.isNullOrEmpty(shujiiIryoKikanMei)) {
                div.getShujiiJohoInput().getTxtShujiiIryoKikanMei().setValue(shujiiIryoKikanMei);
            } else {
                div.getShujiiJohoInput().getTxtShujiiIryoKikanMei().setValue(RString.EMPTY);
            }
        } else {
            div.getShujiiJohoInput().getTxtShujiiIryoKikanMei().setValue(RString.EMPTY);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 市町村検索ボタンを押下します。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<ShujiiMasterDiv> onClick_btnToSearchShichoson(ShujiiMasterDiv div) {
        KoseiShiChosonSelectorModel model = ViewStateHolder.get(ViewStateKeys.引き継ぎデータ, KoseiShiChosonSelectorModel.class);
        div.getShujiiJohoInput().getTxtShichoson().setValue(model.get市町村コード());
        div.getShujiiJohoInput().getTxtShichosonmei().setValue(model.get市町村名称());
        return ResponseData.of(div).respond();
    }

    /**
     * 市町村検索ボタンを押下します。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<ShujiiMasterDiv> onClick_ShichosonOpen(ShujiiMasterDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医医療機関検索ボタンを押下します。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<ShujiiMasterDiv> onClick_btnToSearchIryoKikan(ShujiiMasterDiv div) {
        ShujiiIryokikanandshujiiDataPassModel dataPassModel = DataPassingConverter.deserialize(
                div.getHdnDataPass(), ShujiiIryokikanandshujiiDataPassModel.class);
        div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().setValue(dataPassModel.get主治医医療機関コード());
        div.getShujiiJohoInput().getTxtShujiiIryoKikanMei().setValue(dataPassModel.get主治医医療機関名称());
        div.getShujiiJohoInput().getTxtShichoson().setValue(dataPassModel.get市町村コード());
        onBlur_txtShichoson(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医医療機関検索ボタンを押下します。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<ShujiiMasterDiv> onClick_IryoKikanOpen(ShujiiMasterDiv div) {
        ShujiiIryokikanandshujiiDataPassModel dataPassModel = new ShujiiIryokikanandshujiiDataPassModel();
        dataPassModel.setサブ業務コード(SubGyomuCode.DBE認定支援.value());
        dataPassModel.set市町村コード(div.getShujiiJohoInput().getTxtShichoson().getValue());
        dataPassModel.set対象モード(new RString(TaishoMode.IryoKikanMode.toString()));
        div.setHdnDataPass(DataPassingConverter.serialize(dataPassModel));
        return ResponseData.of(div).respond();
    }

    /**
     * 保存するボタン押下、データがDBに更新します。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<ShujiiMasterDiv> onClick_btnUpdate(ShujiiMasterDiv div) {
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
            Models<ShujiiJohoIdentifier, ShujiiJoho> models = ViewStateHolder.get(
                    ViewStateKeys.主治医マスタ検索結果, Models.class);
            ShujiiJohoManager shujiiJohoManager = new ShujiiJohoManager();
            for (ShujiiJoho shujiiJoho : models) {
                shujiiJohoManager.saveOrDelete主治医情報(shujiiJoho);
            }
            div.getCcdKanryoMessage().setSuccessMessage(
                    new RString(UrInformationMessages.保存終了.getMessage().evaluate()), RString.EMPTY, RString.EMPTY);
            RString 主治医医療機関コード = ViewStateHolder.get(SaibanHanyokeyName.医療機関コード, RString.class);
            if (!RString.isNullOrEmpty(主治医医療機関コード)) {
                return ResponseData.of(div).setState(DBE9020001StateName.完了_医療機関登録から遷移);
            }
            return ResponseData.of(div).setState(DBE9020001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    private ValidationMessageControlPairs validateForDelete(ShujiiMasterDiv div) {
        List<dgShujiiIchiran_Row> dataList = div.getShujiiIchiran().getDgShujiiIchiran().getDataSource();
        ShujiiMasterFinder shujiiMasterFinder = ShujiiMasterFinder.createInstance();
        for (dgShujiiIchiran_Row row : dataList) {
            if (状態_削除.equals(row.getJotai())) {
                ShujiiMasterSearchParameter parameter = ShujiiMasterSearchParameter.createParamForSelectShujiiJoho(
                        new LasdecCode(row.getShichosonCode()),
                        row.getShujiiIryoKikanCode().getValue(),
                        row.getShujiiCode().getValue());
                return getValidationHandler(div).validateForUpdate(
                        shujiiMasterFinder.getNinteiShinseiJohoCount(parameter),
                        shujiiMasterFinder.getIkenshoIraiJohoCount(parameter));
            }
        }
        return new ValidationMessageControlPairs();
    }

    /**
     * 一覧に戻ります。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<ShujiiMasterDiv> onClick_btnBackIchiran(ShujiiMasterDiv div) {
        div.getShujiiIchiran().setDisabled(false);
        ViewStateHolder.put(ViewStateKeys.状態, RString.EMPTY);
        return ResponseData.of(div).respond();
    }

    /**
     * 検索に戻ります。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<ShujiiMasterDiv> onClick_btnBackSearch(ShujiiMasterDiv div) {
        div.getShujiiSearch().setDisabled(false);
        div.getShujiiIchiran().setDisabled(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 医療機関登録に戻ります。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<ShujiiMasterDiv> onClick_btnBackIryokikanToIchiran(ShujiiMasterDiv div) {
        List<dgShujiiIchiran_Row> ichiranList = div.getShujiiIchiran().getDgShujiiIchiran().getDataSource();
        boolean isUpdate = false;
        for (dgShujiiIchiran_Row row : ichiranList) {
            if (!RString.EMPTY.equals(row.getJotai())) {
                isUpdate = true;
                break;
            }
        }
        if (!isUpdate) {
            return ResponseData.of(div).forwardWithEventName(DBE9020001TransitionEventName.医療機関登録へ戻る).respond();
        } else if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                    UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
            && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBE9020001TransitionEventName.医療機関登録へ戻る).respond();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 医療機関登録に戻ります。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<ShujiiMasterDiv> onClick_btnBackIryokikanToComplete(ShujiiMasterDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBE9020001TransitionEventName.医療機関登録へ戻る).respond();
    }

    /**
     * 医療機関登録から一覧に戻ります。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<ShujiiMasterDiv> onClick_btnBackIchiran_Iryokikan(ShujiiMasterDiv div) {
        return ResponseData.of(div).setState(DBE9020001StateName.主治医登録_医療機関登録から遷移);
    }

    private ShujiiMasterHandler getHandler(ShujiiMasterDiv div) {
        return new ShujiiMasterHandler(div);
    }

    private ShujiiMasterValidationHandler getValidationHandler(ShujiiMasterDiv div) {
        return new ShujiiMasterValidationHandler(div);
    }
}
