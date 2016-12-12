/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5110001;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho.GogitaiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho.GogitaiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaiwariateiinjoho.GogitaiWariateIinJoho;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE511001.DBE511001_GogitaiIkkatuParameter;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.gogitaijohosakusei.GogitaiJohoSakuseiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.GogitaiJohoSakuseiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.dgGogitaiIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.dgHoketsuShinsainList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.dgShinsainList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5110001.GogitaiJohoSakuseiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5110001.GogitaiJohoSakuseiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.gogitaijoho.gogitaijoho.GogitaiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.gogitaijoho.gogitaiwariateiinjoho.GogitaiWariateIinJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.gogitaijohosakusei.GogitaiJohoSakuseiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.KyoyuFileName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohosakusei.GogitaiJohoSakuseiCSVEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;

/**
 * 合議体情報作成のコントローラです。
 *
 * @reamsid_L DBE-0090-010 chengsanyuan
 */
public class GogitaiJohoSakusei {

    private static final RString JYOTAI_CODE_ADD = new RString("1");
    private static final RString JYOTAI_CODE_UPD = new RString("2");
    private static final RString JYOTAI_NAME_ADD = new RString("追加");
    private static final RString JYOTAI_NAME_UPD = new RString("修正");
    private static final RString JYOTAI_NAME_DEL = new RString("削除");
    private static final RString RAD_KEY_0 = new RString("key0");
    private static final RString RAD_KEY_1 = new RString("key1");
    private static final RString OUTPUT_CSV_FILE_NAME = new RString("合議体情報.csv");
    private static final RString COMMON_BUTTON_FIELD_NAME = new RString("btnBatchRegister");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBE511001"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private FileSpoolManager fileSpoolManager;
    private final GogitaiJohoSakuseiFinder service;
    private final GogitaiJohoManager manager;

    /**
     * コンストラクタです。
     *
     */
    public GogitaiJohoSakusei() {
        this.service = GogitaiJohoSakuseiFinder.createInstance();
        this.manager = GogitaiJohoManager.createInstance();
    }

    /**
     * 合議体情報作成初期化の設定します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onLoad(GogitaiJohoSakuseiDiv div) {
        getHandler(div).load();
        getHandler(div).init最大表示件数();
        ViewStateHolder.put(ViewStateKeys.状態, RString.EMPTY);
        ViewStateHolder.put(ViewStateKeys.合議体情報, Models.create(new ArrayList<GogitaiJoho>()));
        return ResponseData.of(div).respond();
    }

    /**
     * 合議体情報作成条件をクリアの設定します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onClick_btnClear(GogitaiJohoSakuseiDiv div) {
        getHandler(div).init最大表示件数();
        div.getRadHyojiJoken().setSelectedKey(RAD_KEY_1);
        return ResponseData.of(div).respond();
    }

    /**
     * 検索するボタン押下の場合、合議体情報一覧のデータを設定します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onClick_btnKensaku(GogitaiJohoSakuseiDiv div) {
        boolean is現在有効な合議体のみ = false;
        if (RAD_KEY_0.equals(div.getRadHyojiJoken().getSelectedKey())) {
            is現在有効な合議体のみ = true;
        }
        int 最大表示件数 = div.getTxtDispMax().getValue().intValue();
        SearchResult<GogitaiJoho> resultList = service.getDateGridList(
                GogitaiJohoSakuseiParameter.createGogitaiJohoSakuseiParameter(
                        FlexibleDate.getNowDate(), is現在有効な合議体のみ, 0, FlexibleDate.EMPTY, RString.EMPTY, 最大表示件数));

        Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJoho = Models.create(resultList.records());
        ViewStateHolder.put(ViewStateKeys.合議体情報, gogitaiJoho);
        ViewStateHolder.put(ViewStateKeys.状態, RString.EMPTY);
        getHandler(div).合議体情報一覧初期設定(resultList.records());
        return ResponseData.of(div).respond();
    }

    /**
     * 「合議体を追加する」ボタンをクリックの場合、合議体情報編集エリアのデータを設定します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onClick_btnTsuika(GogitaiJohoSakuseiDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, JYOTAI_CODE_ADD);
        getHandler(div).合議体詳細情報新規モード設定();
        return ResponseData.of(div).respond();
    }

    /**
     * 「CSV出力する」ボタンをクリックの場合、CSVファイルを出力します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onClick_btnCSVShutsuryoku(GogitaiJohoSakuseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(getValidationHandler(div).gogitaiIchiranCheck());
            if (validationMessages.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                && new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            csvOutput(div);
            return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace("CSV出力")).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 合議体情報Gridの行クリックの場合、合議体情報編集エリアのデータを設定します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onSelect_dgGogitaiIchiranMeisai(GogitaiJohoSakuseiDiv div) {
        RString jyotai = ViewStateHolder.get(ViewStateKeys.状態, RString.class);

        if (!(JYOTAI_CODE_ADD.equals(jyotai) || JYOTAI_CODE_UPD.equals(jyotai))) {
            Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJohoModel = ViewStateHolder.get(ViewStateKeys.合議体情報, Models.class);
            GogitaiJohoIdentifier identifier = new GogitaiJohoIdentifier(
                    div.getDgGogitaiIchiran().getClickedItem().getGogitaiNumber().getValue().intValue(),
                    new FlexibleDate(div.getDgGogitaiIchiran().getClickedItem().getYukoKaishiYMD().getValue().toDateString()));
            GogitaiJoho gogitaiJoho = gogitaiJohoModel.get(identifier);

            List<GogitaiWariateIinJoho> shinsainList = gogitaiJoho.getGogitaiWariateIinJohoList();

            getHandler(div).合議体詳細情報データ設定(div.getDgGogitaiIchiran().getClickedItem(), shinsainList);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「合議体情報一覧の修正」アイコンをクリックの場合、合議体情報編集エリアのデータを設定します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onSelectByModifyButton_dgGogitaiIchiranMeisai(GogitaiJohoSakuseiDiv div) {

        Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJohoModel = ViewStateHolder.get(ViewStateKeys.合議体情報, Models.class);
        GogitaiJohoIdentifier identifier = new GogitaiJohoIdentifier(
                div.getDgGogitaiIchiran().getClickedItem().getGogitaiNumber().getValue().intValue(),
                new FlexibleDate(div.getDgGogitaiIchiran().getClickedItem().getYukoKaishiYMD().getValue().toDateString()));
        GogitaiJoho gogitaiJoho = gogitaiJohoModel.get(identifier);

        List<GogitaiWariateIinJoho> shinsainList = gogitaiJoho.getGogitaiWariateIinJohoList();

        getHandler(div).合議体詳細情報データ設定(div.getDgGogitaiIchiran().getClickedItem(), shinsainList);
        getHandler(div).合議体詳細情報修正モード設定();
        if (JYOTAI_NAME_ADD.equals(div.getDgGogitaiIchiran().getClickedItem().getJyotai())) {
            div.getTxtYukoKaishiYMD().setDisabled(false);
        }
        ViewStateHolder.put(ViewStateKeys.状態, JYOTAI_CODE_UPD);
        return ResponseData.of(div).respond();
    }

    /**
     * 「合議体情報一覧の削除」アイコンをクリックの場合、合議体情報編集エリアのデータを設定します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onSelectByDeleteButton_dgGogitaiIchiranMeisai(GogitaiJohoSakuseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            if (JYOTAI_NAME_ADD.equals(div.getDgGogitaiIchiran().getClickedItem().getJyotai())) {
                div.getDgGogitaiIchiran().getDataSource().remove(div.getDgGogitaiIchiran().getClickedRowId());
            } else {
                div.getDgGogitaiIchiran().getClickedItem().setJyotai(JYOTAI_NAME_DEL);
                Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJohoModel = ViewStateHolder.get(ViewStateKeys.合議体情報, Models.class);
                GogitaiJohoIdentifier identifier = new GogitaiJohoIdentifier(
                        div.getDgGogitaiIchiran().getClickedItem().getGogitaiNumber().getValue().intValue(),
                        new FlexibleDate(div.getDgGogitaiIchiran().getClickedItem().getYukoKaishiYMD().getValue().toDateString()));
                GogitaiJoho gogitaiJoho = gogitaiJohoModel.get(identifier);
                gogitaiJoho = gogitaiJoho.deleted();
                gogitaiJohoModel.deleteOrRemove(identifier);
                gogitaiJohoModel.add(gogitaiJoho);
                ViewStateHolder.put(ViewStateKeys.合議体情報, gogitaiJohoModel);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「審査会委員を選択する」ボタンをクリックの場合、認定審査会委員ガイドを表示します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onBefore_btnShinsainSelect(GogitaiJohoSakuseiDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「割当審査会委員情報一覧」閉じるの場合、割当審査会委員情報一覧のデータを設定します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onOkClose_btnShinsainSelect(GogitaiJohoSakuseiDiv div) {
        RString 介護認定審査会委員コード = ViewStateHolder.get(
                ViewStateKeys.介護認定審査会委員コード, RString.class);
        RString 審査会委員名称 = ViewStateHolder.get(
                ViewStateKeys.審査会委員名称, RString.class);
        boolean flag = false;
        for (dgShinsainList_Row row : div.getDgShinsainList().getDataSource()) {
            if (row.getShinsakaiIinCode().equals(介護認定審査会委員コード)) {
                flag = true;
            }
        }
        for (dgHoketsuShinsainList_Row row : div.getDgHoketsuShinsainList().getDataSource()) {
            if (row.getHoketsuShinsakaiIinCode().equals(介護認定審査会委員コード)) {
                flag = true;
            }
        }
        if (!flag) {
            div.getDgShinsainList().getDataSource().add(
                    new dgShinsainList_Row(Boolean.FALSE, Boolean.FALSE, 介護認定審査会委員コード, 審査会委員名称, JYOTAI_CODE_ADD));
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「補欠審査会委員を選択する」ボタンをクリックの場合、認定審査会委員ガイドを表示します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onBefore_btnSubShinsainSelect(GogitaiJohoSakuseiDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「割当審査会委員情報一覧」閉じるの場合、割当審査会委員情報一覧のデータを設定します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onOkClose_btnSubShinsainSelect(GogitaiJohoSakuseiDiv div) {
        RString 介護認定審査会委員コード = ViewStateHolder.get(
                ViewStateKeys.介護認定審査会委員コード, RString.class);
        RString 審査会委員名称 = ViewStateHolder.get(
                ViewStateKeys.審査会委員名称, RString.class);
        boolean flag = false;
        for (dgHoketsuShinsainList_Row row : div.getDgHoketsuShinsainList().getDataSource()) {
            if (row.getHoketsuShinsakaiIinCode().equals(介護認定審査会委員コード)) {
                flag = true;
            }
        }
        for (dgShinsainList_Row row : div.getDgShinsainList().getDataSource()) {
            if (row.getShinsakaiIinCode().equals(介護認定審査会委員コード)) {
                flag = true;
            }
        }
        if (!flag) {
            div.getDgHoketsuShinsainList().getDataSource().add(
                    new dgHoketsuShinsainList_Row(介護認定審査会委員コード, 審査会委員名称, JYOTAI_CODE_ADD));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 割当審査員一覧Gridの削除ボタンをクリックの場合、選択のデータを削除します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onSelectByDeleteButton_dgShinsainListMeisai(GogitaiJohoSakuseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getDgShinsainList().getDataSource().remove(div.getDgShinsainList().getClickedRowId());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 割当補欠審査員一覧Gridの削除ボタンをクリックの場合、選択のデータを削除します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onSelectByDeleteButton_dgHoketsuShinsainListMeisai(GogitaiJohoSakuseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getDgHoketsuShinsainList().getDataSource().remove(div.getDgHoketsuShinsainList().getClickedRowId());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「入力内容を取消する」ボタンをクリックの場合、合議体情報編集エリアの値を破棄します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onClick_btnback(GogitaiJohoSakuseiDiv div) {
        Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJohoModel = ViewStateHolder.get(ViewStateKeys.合議体情報, Models.class);

        if (!ResponseHolder.isReRequest()) {
            RString jyotai = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
            if (合議体詳細情報変更有無判定(div, gogitaiJohoModel, jyotai)) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            }
        }
        if (ResponseHolder.getButtonType() != MessageDialogSelectedResult.No) {
            ViewStateHolder.put(ViewStateKeys.状態, RString.EMPTY);
            getHandler(div).合議体詳細情報初期状態設定();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「入力内容を更新する」ボタンをクリックの場合、合議体情報一覧を更新します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onClick_btnkosin(GogitaiJohoSakuseiDiv div) {
        RString jyotai = ViewStateHolder.get(ViewStateKeys.状態, RString.class);

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();

        if (JYOTAI_CODE_ADD.equals(jyotai)) {
//            validationMessages.add(getValidationHandler(div).gogitaiNoKetaiCheck());
            validationMessages.add(getValidationHandler(div).gogitaiNoJuuhukuCheck());
        }
        validationMessages.add(getValidationHandler(div).gogitaichoPersonNumCheck());
        validationMessages.add(getValidationHandler(div).gogitaichoToFukuGogitaichoCheck());
        validationMessages.add(getValidationHandler(div).iinTeiinCheck());
        validationMessages.add(getValidationHandler(div).kaisaiBashoCodeCheck());
        validationMessages.add(getValidationHandler(div).kaishiToShuryoYMDCheck());
        validationMessages.add(getValidationHandler(div).kaishiYoteiToShuryoYoteiTimeCheck());
//        validationMessages.add(getValidationHandler(div).shinsainListRequiredCheck());
//        validationMessages.add(getValidationHandler(div).shinsainPersonNumCheck());
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }

        Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJohoModel = ViewStateHolder.get(ViewStateKeys.合議体情報, Models.class);

        if (JYOTAI_CODE_ADD.equals(jyotai)) {
            GogitaiJoho gogitaiJoho = new GogitaiJoho(
                    Integer.parseInt(div.getTxtGogitaiNumber().getValue().toString()),
                    new FlexibleDate(div.getTxtYukoKaishiYMD().getValue().toDateString()));
            gogitaiJoho = getHandler(div).合議体情報編集(gogitaiJoho);
            gogitaiJohoModel.add(gogitaiJoho);
            getHandler(div).合議体情報一覧更新(JYOTAI_NAME_ADD);
        } else if (JYOTAI_CODE_UPD.equals(jyotai)) {
            GogitaiJohoIdentifier identifier = new GogitaiJohoIdentifier(
                    Integer.parseInt(div.getTxtGogitaiNumber().getValue().toString()),
                    new FlexibleDate(div.getTxtYukoKaishiYMD().getValue().toDateString()));

            GogitaiJoho gogitaiJoho = getHandler(div).合議体情報編集(gogitaiJohoModel.get(identifier).modifiedModel());
            gogitaiJoho = gogitaiJoho.modifiedModel();
            gogitaiJohoModel.add(gogitaiJoho);
            getHandler(div).合議体情報一覧更新(JYOTAI_NAME_UPD);
        }
        ViewStateHolder.put(ViewStateKeys.状態, RString.EMPTY);
        ViewStateHolder.put(ViewStateKeys.合議体情報, gogitaiJohoModel);
        getHandler(div).合議体詳細情報初期状態設定();
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンをクリックの場合、合議体情報を更新します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onClick_btnupdate(GogitaiJohoSakuseiDiv div) {
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
            Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJohoModel = ViewStateHolder.get(ViewStateKeys.合議体情報, Models.class);
            Iterator<GogitaiJoho> 合議体情報 = gogitaiJohoModel.iterator();
            while (合議体情報.hasNext()) {
                GogitaiJoho gogitaiJoho = 合議体情報.next();
                if (gogitaiJoho.toEntity().getState() == EntityDataState.Added) {
                    manager.save(gogitaiJoho);
                }
                if (gogitaiJoho.toEntity().getState() == EntityDataState.Deleted) {
                    gogitaiNOExitCheck(gogitaiJoho.get合議体番号());
                    manager.deletePhysicalWithoutGogitaiWariateIin(gogitaiJoho);
                }
                if (gogitaiJoho.toEntity().getState() == EntityDataState.Modified) {
                    manager.saveWithDeletePhysical(gogitaiJoho);
                    GogitaiWariateIinJohoManager gogitaiWariateIinJohoManager = GogitaiWariateIinJohoManager.createInstance();
                    for (GogitaiWariateIinJoho gogitaiWariateIinJoho : gogitaiJohoModel.get(gogitaiJoho.identifier()).getGogitaiWariateIinJohoList()) {
                        gogitaiWariateIinJohoManager.save(gogitaiWariateIinJoho);
                    }
                }
            }
        }
        return onClick_btnKensaku(div);
    }

    /**
     * アップロードファイルを設定の場合、「一括登録する」ポタンを設定します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onClick_btnKakunin(GogitaiJohoSakuseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * アップロードファイルを設定の場合、「一括登録する」ポタンを設定します。
     *
     * @param div 合議体情報作成Div
     * @param files 画面から渡されるファイルデータ
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<GogitaiJohoSakuseiDiv> onClick_btnRegistUploadFile(GogitaiJohoSakuseiDiv div, FileData[] files) {
        for (FileData file : files) {
            copyFile(file, div);
        }
        return ResponseData.of(div).respond();
    }

    private boolean copyFile(FileData file, GogitaiJohoSakuseiDiv div) {
        FilesystemName sharedfileName = new FilesystemName(KyoyuFileName.合議体情報作成一括登録ファイル.get名称());
        List<RString> allGroups = new ArrayList<>();
        allGroups.add(new RString("*"));
        SharedFile.defineSharedFile(sharedfileName, 1, allGroups, null, false, null);
        FilesystemPath path = new FilesystemPath(file.getFilePath());
        RDateTime fileId = SharedFile.copyToSharedFile(path, sharedfileName);
        div.setHiddenFileId(new RString(fileId.toString()));
        div.setHiddenFileName(file.getFileName());
        return false;
    }

    /**
     * アップロードファイル設定後の場合、「一括登録する」ポタンに活性を設定します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> btnShow(GogitaiJohoSakuseiDiv div) {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_FIELD_NAME, false);
        return ResponseData.of(div).respond();
    }

    /**
     * 「一括登録する」ポタンをクリックの場合、DB一括登録バッチを起動します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiBatchParamter>
     */
    public ResponseData<DBE511001_GogitaiIkkatuParameter> onClick_btnBatchRegister(GogitaiJohoSakuseiDiv div) {
        ResponseData<DBE511001_GogitaiIkkatuParameter> responseData = new ResponseData<>();
        DBE511001_GogitaiIkkatuParameter batchParam = new DBE511001_GogitaiIkkatuParameter();
        batchParam.setSharedFileID(RDateTime.parse(div.getHiddenFileId().toString()));
        batchParam.setSharedFileName(KyoyuFileName.合議体情報作成一括登録ファイル.get名称());
        batchParam.setInputFileName(div.getHiddenFileName());
        responseData.data = batchParam;
        return responseData;
    }

    private GogitaiJohoSakuseiHandler getHandler(GogitaiJohoSakuseiDiv div) {
        return new GogitaiJohoSakuseiHandler(div);
    }

    private GogitaiJohoSakuseiValidationHandler getValidationHandler(GogitaiJohoSakuseiDiv div) {
        return new GogitaiJohoSakuseiValidationHandler(div);
    }

    private void gogitaiNOExitCheck(int 合議体番号) {
        if (service.getGogitaiWariateIinJohoCount(合議体番号)
                && service.getShinsakaiKaisaiYoteiJohoCount(合議体番号)) {
            throw new ApplicationException(DbeErrorMessages.他の情報で使用している為削除不可.getMessage());
        }
    }

    private boolean 合議体詳細情報変更有無判定(GogitaiJohoSakuseiDiv div,
            Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJohoModel,
            RString jyotai) {
        if (JYOTAI_CODE_ADD.equals(jyotai)) {
            return getHandler(div).新規モード合議体詳細情報変更有無判定();
        }
        if (JYOTAI_CODE_UPD.equals(jyotai)) {
            GogitaiJohoIdentifier identifier = new GogitaiJohoIdentifier(Integer.parseInt(div.getTxtGogitaiNumber().getValue().toString()),
                    new FlexibleDate(div.getTxtYukoKaishiYMD().getValue().toDateString()));
            GogitaiJoho gogitaiJoho = gogitaiJohoModel.get(identifier);
            return getHandler(div).修正モード合議体詳細情報変更有無判定(gogitaiJoho);
        }
        return false;
    }

    private void csvOutput(GogitaiJohoSakuseiDiv div) {
        boolean is現在有効な合議体のみ = false;
        if (RAD_KEY_0.equals(div.getRadHyojiJoken().getSelectedKey())) {
            is現在有効な合議体のみ = true;
        }
        SearchResult<GogitaiJohoSakuseiCSVEntity> resultList = service.getGogitaiJohoForCSV(
                GogitaiJohoSakuseiParameter.createGogitaiJohoSakuseiParameter(
                        FlexibleDate.getNowDate(), is現在有効な合議体のみ, 0, FlexibleDate.EMPTY, RString.EMPTY, 0));

        fileSpoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = fileSpoolManager.getEucOutputDirectry();
        RString eucFilePath = Path.combinePath(spoolWorkPath, OUTPUT_CSV_FILE_NAME);

        try (CsvWriter<GogitaiJohoSakuseiCSVEntity> eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                hasHeader(false).
                canAppend(false).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.SJIS).
                setNewLine(NewLine.CRLF).
                build()) {
            for (GogitaiJohoSakuseiCSVEntity result : resultList.records()) {
                eucCsvWriter.writeLine(result);
            }
        }

        fileSpoolManager.spool(eucFilePath);
    }

    private static final class EdittingRow {

        private final dgGogitaiIchiran_Row row;
        private final int index;

        private EdittingRow(dgGogitaiIchiran_Row row, int index) {
            this.row = row;
            this.index = index;
        }
    }

    private EdittingRow findEdittingRowOrThrowException(GogitaiJohoSakuseiDiv div, RString gogitaiNo, RDate yukoKaishiDate) {
        List<dgGogitaiIchiran_Row> dataSource = div.getDgGogitaiIchiran().getDataSource();
        int size = dataSource.size();
        for (int i = 0; i < size; i++) {
            dgGogitaiIchiran_Row row = dataSource.get(i);
            if (Objects.equals(gogitaiNo, row.getGogitaiNumber())
                    && Objects.equals(yukoKaishiDate, row.getYukoKaishiYMD().getValue())) {
                return new EdittingRow(row, i);
            }
        }
        throw new ApplicationException(new RStringBuilder()
                .append("編集中の合議体情報は存在しません。")
                .append(" 合議体番号：").append(div.getTxtGogitaiNumber())
                .append(" 有効開始日：").append(div.getTxtYukoKaishiYMD().getValue().seireki().toDateString())
                .toString());
    }
}
