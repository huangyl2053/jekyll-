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
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho.GogitaiJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho.GogitaiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaiwariateiinjoho.GogitaiWariateIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaiwariateiinjoho.GogitaiWariateIinJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijohosakusei.GogitaiJohoSakuseiRsult;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.gogitaijohosakusei.GogitaiJohoSakuseiBatchParamter;
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
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 合議体情報作成のコントローラです。
 *
 * @reamsid_L DBE-0090-010 chengsanyuan
 */
public class GogitaiJohoSakusei {

    private static final RString JYOTAI_CODE_ADD = new RString("1");
    private static final RString JYOTAI_NAME_ADD = new RString("追加");
    private static final RString JYOTAI_CODE_UPD = new RString("2");
    private static final RString JYOTAI_NAME_UPD = new RString("修正");
    private static final RString JYOTAI_NAME_DEL = new RString("削除");
    private static final RString RAD_HYOJIJOKEN_ISNOW = new RString("key0");
    private static final RString OUTPUT_CSV_FILE_NAME = new RString("合議体情報.csv");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString COMMON_BUTTON_FIELD_NAME = new RString("btnBatchRegister");
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
        SearchResult<KeyValueDataSource> resultList = service.getKaisaiBashoList();
        GogitaiJohoSakuseiHandler handler = getHandler(div);
        handler.load(resultList.records());
        handler.init最大表示件数();
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
        div.getRadHyojiJoken().setSelectedKey(RAD_HYOJIJOKEN_ISNOW);
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
        if (RAD_HYOJIJOKEN_ISNOW.equals(div.getRadHyojiJoken().getSelectedKey())) {
            is現在有効な合議体のみ = true;
        }
        int 最大表示件数 = div.getTxtDispMax().getValue().intValue();
        SearchResult<GogitaiJohoSakuseiRsult> resultList = service.getDateGridList(
                GogitaiJohoSakuseiParameter.createGogitaiJohoSakuseiParameter(
                        FlexibleDate.getNowDate(), is現在有効な合議体のみ, 0, FlexibleDate.EMPTY, RString.EMPTY, 最大表示件数));
        SearchResult<GogitaiJoho> gogitaiJohoList = service.getGogitaiJohoSakusei(is現在有効な合議体のみ);
        Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJoho = Models.create(gogitaiJohoList.records());
        ViewStateHolder.put(ViewStateKeys.合議体情報, gogitaiJoho);
        ViewStateHolder.put(ViewStateKeys.状態, RString.EMPTY);
        getHandler(div).setDgGogitaiIchiran(resultList.records());
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
            SearchResult<GogitaiJohoSakuseiRsult> resultList = service.getShinsainList(
                    GogitaiJohoSakuseiParameter.createGogitaiJohoSakuseiParameter(
                            FlexibleDate.EMPTY, false,
                            Integer.parseInt(div.getDgGogitaiIchiran().getClickedItem().getGogitaiNumber().toString()),
                            new FlexibleDate(div.getDgGogitaiIchiran().getClickedItem().getYukoKaishiYMD().getValue().toDateString().toString()),
                            RString.EMPTY,
                            0));
            getHandler(div).setGogitaiShosai(div.getDgGogitaiIchiran().getClickedItem(), resultList.records());
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

        if (!ResponseHolder.isReRequest()) {
            RString jyotai = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
            if (!hasChanged(div, gogitaiJohoModel, jyotai)) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            }
            this.setGogitaiShosaiForUpd(div);
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            this.setGogitaiShosaiForUpd(div);
        }

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
                        Integer.parseInt(div.getDgGogitaiIchiran().getClickedItem().getGogitaiNumber().toString()),
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
     * 「合議体を追加する」ボタンをクリックの場合、合議体情報編集エリアのデータを設定します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onClick_btnTsuika(GogitaiJohoSakuseiDiv div) {
        Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJohoModel = ViewStateHolder.get(ViewStateKeys.合議体情報, Models.class);

        if (!ResponseHolder.isReRequest()) {
            RString jyotai = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
            if (!hasChanged(div, gogitaiJohoModel, jyotai)) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            }
            ViewStateHolder.put(ViewStateKeys.状態, JYOTAI_CODE_ADD);
            getHandler(div).setGogitaiShosaiByAdd();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ViewStateHolder.put(ViewStateKeys.状態, JYOTAI_CODE_ADD);
            getHandler(div).setGogitaiShosaiByAdd();
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
     * 「入力内容を取消する」ボタンをクリックの場合、合議体情報編集エリアの値を破棄します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onClick_btnback(GogitaiJohoSakuseiDiv div) {
        Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJohoModel = ViewStateHolder.get(ViewStateKeys.合議体情報, Models.class);
        if (!ResponseHolder.isReRequest()) {
            RString jyotai = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
            if (!hasChanged(div, gogitaiJohoModel, jyotai)) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            }
            ViewStateHolder.put(ViewStateKeys.状態, RString.EMPTY);
            getHandler(div).cleanGogitaiShosai();
            getHandler(div).setDisableByAdd(true);
            div.getBtnTsuika().setDisabled(false);
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ViewStateHolder.put(ViewStateKeys.状態, RString.EMPTY);
            getHandler(div).cleanGogitaiShosai();
            getHandler(div).setDisableByAdd(true);
            div.getBtnTsuika().setDisabled(false);
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
            validationMessages.add(getValidationHandler(div).gogitaiNoKetaiCheck());
            validationMessages.add(getValidationHandler(div).gogitaiNoJuuhukuCheck());
        }
        validationMessages.add(getValidationHandler(div).gogitaichoPersonNumCheck());
        validationMessages.add(getValidationHandler(div).gogitaichoToFukuGogitaichoCheck());
        validationMessages.add(getValidationHandler(div).iinTeiinCheck());
        validationMessages.add(getValidationHandler(div).kaisaiBashoCodeCheck());
        validationMessages.add(getValidationHandler(div).kaishiToShuryoYMDCheck());
        validationMessages.add(getValidationHandler(div).kaishiYoteiToShuryoYoteiTimeCheck());
        validationMessages.add(getValidationHandler(div).shinsainListRequiredCheck());
        validationMessages.add(getValidationHandler(div).shinsainPersonNumCheck());
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        setGogitaiShosaiByJyotai(div, jyotai);
        getHandler(div).cleanGogitaiShosai();
        getHandler(div).setDisableByAdd(true);
        div.getBtnTsuika().setDisabled(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンをクリックの場合、合議体情報を更新します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onClick_btnupdate(GogitaiJohoSakuseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

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
                    Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJohoModelForUpd
                            = ViewStateHolder.get(ViewStateKeys.合議体情報更新, Models.class);
                    GogitaiWariateIinJohoManager gogitaiWariateIinJohoManager = GogitaiWariateIinJohoManager.createInstance();
                    for (GogitaiWariateIinJoho gogitaiWariateIinJoho : gogitaiJohoModelForUpd.get(gogitaiJoho.identifier()).getGogitaiWariateIinJohoList()) {
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
    public ResponseData<GogitaiJohoSakuseiBatchParamter> onClick_btnBatchRegister(GogitaiJohoSakuseiDiv div) {
        ResponseData<GogitaiJohoSakuseiBatchParamter> responseData = new ResponseData<>();
        GogitaiJohoSakuseiBatchParamter batchParam = new GogitaiJohoSakuseiBatchParamter();
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

    private void setGogitaiShosaiForUpd(GogitaiJohoSakuseiDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, JYOTAI_CODE_UPD);

        SearchResult<GogitaiJohoSakuseiRsult> resultList = service.getShinsainList(
                GogitaiJohoSakuseiParameter.createGogitaiJohoSakuseiParameter(
                        FlexibleDate.EMPTY, false,
                        Integer.parseInt(div.getDgGogitaiIchiran().getClickedItem().getGogitaiNumber().toString()),
                        new FlexibleDate(div.getDgGogitaiIchiran().getClickedItem().getYukoKaishiYMD().getValue().toDateString().toString()),
                        RString.EMPTY,
                        0));
        getHandler(div).setGogitaiShosai(div.getDgGogitaiIchiran().getClickedItem(), resultList.records());
        getHandler(div).setDisableByUpd();
    }

    private boolean hasChanged(GogitaiJohoSakuseiDiv div,
            Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJohoModel, RString jyotai) {
        if (JYOTAI_CODE_ADD.equals(jyotai)) {
            return getHandler(div).hasChangedByAdd();
        }
        if (JYOTAI_CODE_UPD.equals(jyotai)) {
            GogitaiJohoIdentifier identifier = new GogitaiJohoIdentifier(Integer.parseInt(div.getTxtGogitaiNumber().getValue().toString()),
                    new FlexibleDate(div.getTxtYukoKaishiYMD().getValue().toDateString()));
            GogitaiJoho gogitaiJoho = gogitaiJohoModel.get(identifier);
            return getHandler(div).hasChangedByUpd(gogitaiJoho);
        }
        return true;
    }

    private void csvOutput(GogitaiJohoSakuseiDiv div) {
        boolean is現在有効な合議体のみ = false;
        if (RAD_HYOJIJOKEN_ISNOW.equals(div.getRadHyojiJoken().getSelectedKey())) {
            is現在有効な合議体のみ = true;
        }
        SearchResult<GogitaiJohoSakuseiRsult> resultList = service.getGogitaiJohoForCSV(
                GogitaiJohoSakuseiParameter.createGogitaiJohoSakuseiParameter(
                        FlexibleDate.getNowDate(), is現在有効な合議体のみ, 0, FlexibleDate.EMPTY, RString.EMPTY, 0));
        RString path = Path.getTmpDirectoryPath();

        try (CsvListWriter writer = new CsvListWriter.InstanceBuilder(Path.combinePath(path, OUTPUT_CSV_FILE_NAME))
                .canAppend(false)
                .hasHeader(false)
                .setDelimiter(CSV_WRITER_DELIMITER)
                .setEncode(Encode.SJIS)
                .setNewLine(NewLine.CRLF)
                .build()) {
            for (GogitaiJohoSakuseiRsult result : resultList.records()) {
                writer.writeLine(result.toList());
            }
            writer.close();
        }
    }

    private void setGogitaiShosaiByJyotai(GogitaiJohoSakuseiDiv div, RString jyotai) {
        Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJohoModel = ViewStateHolder.get(ViewStateKeys.合議体情報, Models.class);
        if (JYOTAI_CODE_ADD.equals(jyotai)) {
            dgGogitaiIchiran_Row row = new dgGogitaiIchiran_Row();
            GogitaiJoho gogitaiJoho = new GogitaiJoho(
                    Integer.parseInt(div.getTxtGogitaiNumber().getValue().toString()),
                    new FlexibleDate(div.getTxtYukoKaishiYMD().getValue().toDateString()));
            gogitaiJoho = setGogitaiJoho(div, row, gogitaiJoho);
            gogitaiJohoModel.add(gogitaiJoho);
            div.getDgGogitaiIchiran().getDataSource().add(row);
        }
        if (JYOTAI_CODE_UPD.equals(jyotai)) {
            GogitaiJohoIdentifier identifier = new GogitaiJohoIdentifier(
                    Integer.parseInt(div.getTxtGogitaiNumber().getValue().toString()),
                    new FlexibleDate(div.getTxtYukoKaishiYMD().getValue().toDateString()));
            GogitaiJoho gogitaiJoho = gogitaiJohoModel.get(identifier);
            // 暫定対応 ここから - 編集中のデータグリッドの要素に対して更新する処理。
            //  clickedItem を使ってしまっていた実装からの修正。時間がないので以下の様にしたが、本来であれば、編集中はDataGridを操作不可にするべき。
            EdittingRow edittingRow = findEdittingRowOrThrowException(div,
                    div.getTxtGogitaiNumber().getValue(),
                    div.getTxtYukoKaishiYMD().getValue());
            if (JYOTAI_NAME_ADD.equals(edittingRow.row.getJyotai())) {
                gogitaiJoho = setGogitaiJoho(div, edittingRow.row, gogitaiJoho);
                gogitaiJohoModel.add(gogitaiJoho);
                div.getDgGogitaiIchiran().getDataSource().set(edittingRow.index, edittingRow.row);
            } else {
                gogitaiJoho = setGogitaiJohoForUpd(div, edittingRow, gogitaiJoho);
                gogitaiJohoModel.add(gogitaiJoho);
            }
            // 暫定対応 ここまで
        }
        ViewStateHolder.put(ViewStateKeys.合議体情報, gogitaiJohoModel);
        ViewStateHolder.put(ViewStateKeys.状態, RString.EMPTY);
    }

    private GogitaiJoho setGogitaiJoho(GogitaiJohoSakuseiDiv div, dgGogitaiIchiran_Row row, GogitaiJoho gogitaiJoho) {

        GogitaiJohoBuilder gogitaiJohoBuilder = getHandler(div).getGogitaiJohoBuilder(gogitaiJoho.createBuilderForEdit(), row);
        row.setJyotai(JYOTAI_NAME_ADD);
        for (dgShinsainList_Row shinsainRow : div.getDgShinsainList().getDataSource()) {
            GogitaiWariateIinJoho gogitaiWariateIinJoho = new GogitaiWariateIinJoho(
                    Integer.parseInt(div.getTxtGogitaiNumber().getValue().toString()),
                    new FlexibleDate(div.getTxtYukoKaishiYMD().getValue().toDateString()),
                    shinsainRow.getShinsakaiIinCode());
            gogitaiWariateIinJoho = getHandler(div).getGogitaiWariateIinJohoByShinsain(shinsainRow, gogitaiWariateIinJoho.createBuilderForEdit());
            gogitaiJohoBuilder.setGogitaiWariateIinJoho(gogitaiWariateIinJoho);
        }
        for (dgHoketsuShinsainList_Row hoketsuShinsainRow : div.getDgHoketsuShinsainList().getDataSource()) {
            GogitaiWariateIinJoho gogitaiWariateIinJoho = new GogitaiWariateIinJoho(
                    Integer.parseInt(div.getTxtGogitaiNumber().getValue().toString()),
                    new FlexibleDate(div.getTxtYukoKaishiYMD().getValue().toDateString()),
                    hoketsuShinsainRow.getHoketsuShinsakaiIinCode());
            gogitaiWariateIinJoho = getHandler(div).getGogitaiWariateIinJohoByHoketsu(hoketsuShinsainRow, gogitaiWariateIinJoho.createBuilderForEdit());
            gogitaiJohoBuilder.setGogitaiWariateIinJoho(gogitaiWariateIinJoho);
        }
        gogitaiJoho = gogitaiJohoBuilder.build();

        return gogitaiJoho;
    }

    private static class EdittingRow {

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

    private GogitaiJoho setGogitaiJohoForUpd(GogitaiJohoSakuseiDiv div, EdittingRow edittingRow, GogitaiJoho gogitaiJoho) {

        Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJohoModelForUpd = ViewStateHolder.get(ViewStateKeys.合議体情報更新, Models.class);
        if (gogitaiJohoModelForUpd == null) {
            gogitaiJohoModelForUpd = Models.create(new ArrayList<GogitaiJoho>());
        }
        GogitaiJoho gogitaiJohoForUpd = new GogitaiJoho(gogitaiJoho.identifier().get合議体番号(), gogitaiJoho.identifier().get合議体有効期間開始年月日());
        GogitaiJohoBuilder gogitaiJohoBuilder = getHandler(div).getGogitaiJohoBuilder(gogitaiJoho.createBuilderForEdit(), edittingRow.row);
        edittingRow.row.setJyotai(JYOTAI_NAME_UPD);
        for (dgShinsainList_Row shinsainRow : div.getDgShinsainList().getDataSource()) {
            GogitaiWariateIinJohoIdentifier gogitaiWariateIinIdentifier
                    = new GogitaiWariateIinJohoIdentifier(Integer.parseInt(div.getTxtGogitaiNumber().getValue().toString()),
                            new FlexibleDate(div.getTxtYukoKaishiYMD().getValue().toDateString()), shinsainRow.getShinsakaiIinCode());
            GogitaiWariateIinJoho gogitaiWariateIinJohoForUpd = new GogitaiWariateIinJoho(
                    gogitaiWariateIinIdentifier.get合議体番号(),
                    gogitaiWariateIinIdentifier.get合議体有効期間開始年月日(),
                    gogitaiWariateIinIdentifier.get介護認定審査会委員コード());
            if (!JYOTAI_CODE_ADD.equals(shinsainRow.getState())) {
                GogitaiWariateIinJoho gogitaiWariateIinJoho = gogitaiJoho.getGogitaiWariateIinJoho(gogitaiWariateIinIdentifier);
                gogitaiWariateIinJoho = getHandler(div).getGogitaiWariateIinJohoByShinsain(shinsainRow, gogitaiWariateIinJoho.createBuilderForEdit());
                gogitaiWariateIinJoho = gogitaiWariateIinJoho.modifiedModel();
                gogitaiJohoBuilder.setGogitaiWariateIinJoho(gogitaiWariateIinJoho);
            }
            gogitaiWariateIinJohoForUpd = getHandler(div).getGogitaiWariateIinJohoByShinsain(shinsainRow, gogitaiWariateIinJohoForUpd.createBuilderForEdit());
            gogitaiJohoForUpd.createBuilderForEdit().setGogitaiWariateIinJoho(gogitaiWariateIinJohoForUpd).build();
        }
        for (dgHoketsuShinsainList_Row hoketsuShinsainRow : div.getDgHoketsuShinsainList().getDataSource()) {
            GogitaiWariateIinJohoIdentifier gogitaiWariateIinIdentifier
                    = new GogitaiWariateIinJohoIdentifier(Integer.parseInt(div.getTxtGogitaiNumber().getValue().toString()),
                            new FlexibleDate(div.getTxtYukoKaishiYMD().getValue().toDateString()), hoketsuShinsainRow.getHoketsuShinsakaiIinCode());
            GogitaiWariateIinJoho gogitaiWariateIinJohoForUpd = new GogitaiWariateIinJoho(
                    gogitaiWariateIinIdentifier.get合議体番号(),
                    gogitaiWariateIinIdentifier.get合議体有効期間開始年月日(),
                    gogitaiWariateIinIdentifier.get介護認定審査会委員コード());
            if (!JYOTAI_CODE_ADD.equals(hoketsuShinsainRow.getState())) {
                GogitaiWariateIinJoho gogitaiWariateIinJoho = gogitaiJoho.getGogitaiWariateIinJoho(gogitaiWariateIinIdentifier);
                gogitaiWariateIinJoho = getHandler(div).getGogitaiWariateIinJohoByHoketsu(hoketsuShinsainRow, gogitaiWariateIinJoho.createBuilderForEdit());
                gogitaiWariateIinJoho = gogitaiWariateIinJoho.modifiedModel();
                gogitaiJohoBuilder.setGogitaiWariateIinJoho(gogitaiWariateIinJoho);

            }
            gogitaiWariateIinJohoForUpd = getHandler(div).getGogitaiWariateIinJohoByHoketsu(hoketsuShinsainRow, gogitaiWariateIinJohoForUpd.createBuilderForEdit());
            gogitaiJohoForUpd.createBuilderForEdit().setGogitaiWariateIinJoho(gogitaiWariateIinJohoForUpd).build();

        }
        gogitaiJoho = gogitaiJohoBuilder.build();
        gogitaiJoho = gogitaiJoho.modifiedModel();
        div.getDgGogitaiIchiran().getDataSource().set(edittingRow.index, edittingRow.row);

        gogitaiJohoModelForUpd.add(gogitaiJohoForUpd);
        ViewStateHolder.put(ViewStateKeys.合議体情報更新, gogitaiJohoModelForUpd);
        return gogitaiJoho;
    }
}
