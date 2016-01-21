/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5110001;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho.GogitaiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho.GogitaiJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho.GogitaiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaiwariateiinjoho.GogitaiWariateIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaiwariateiinjoho.GogitaiWariateIinJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijohosakusei.GogitaiJohoSakuseiRsult;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.gogitaijohosakusei.GogitaiJohoSakuseiBatchParamter;
import jp.co.ndensan.reams.db.dbe.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.gogitaijohosakusei.GogitaiJohoSakuseiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.GogitaiJohoSakuseiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.dgGogitaiIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.dgHoketsuShinsainList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.dgShinsainList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5110001.GogitaiJohoSakuseiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5110001.GogitaiJohoSakuseiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.gogitaijoho.gogitaijoho.GogitaiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.gogitaijoho.gogitaiwariateiinjoho.GogitaiWariateIinJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.gogitaijohosakusei.GogitaiJohoSakuseiFinder;
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
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 */
public class GogitaiJohoSakusei {

    private static final RString JYOTAI_CODE_ADD = new RString("1");
    private static final RString JYOTAI_NAME_ADD = new RString("追加");
    private static final RString JYOTAI_CODE_UPD = new RString("2");
    private static final RString JYOTAI_NAME_UPD = new RString("修正");
    private static final RString JYOTAI_NAME_DEL = new RString("削除");
    private static final RString RAD_HYOJIJOKEN_ISNOW = new RString("key0");
    private static final RString SHARED_FILE_NAME = new RString("合議体情報");
    private static final RString OUTPUT_CSV_FILE_NAME = new RString("\\合議体情報.csv");
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
        getHandler(div).load(resultList.records());
        ViewStateHolder.put(ViewStateKeys.状態, RString.EMPTY);
        ViewStateHolder.put(ViewStateKeys.合議体情報, Models.create(new ArrayList<GogitaiJoho>()));
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
        SearchResult<GogitaiJohoSakuseiRsult> resultList = service.getDateGridList(
                GogitaiJohoSakuseiParameter.createGogitaiJohoSakuseiParameter(
                        FlexibleDate.getNowDate(), is現在有効な合議体のみ, 0, FlexibleDate.EMPTY, RString.EMPTY));
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
                            RString.EMPTY));
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
     * 「審査会委員を選択する」ボタンをクリックの場合、割当審査会委員情報一覧のデータを設定します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onClick_btnShinsainSelect(GogitaiJohoSakuseiDiv div) {
        // TODO QA217
        return ResponseData.of(div).respond();
    }

    /**
     * 「審査会委員を選択する」ボタンをクリックの場合、割当補欠審査会委員情報一覧のデータを設定します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onClick_btnSubShinsainSelect(GogitaiJohoSakuseiDiv div) {
        // TODO QA217
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
                    // TODO QA211
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
     * @param files 画面から渡されるファイルデータ
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<GogitaiJohoSakuseiDiv> onClick_btnIkkatsuToroku(GogitaiJohoSakuseiDiv div, FileData[] files) {
        for (FileData file : files) {
            copyFile(file, div);
        }
        return ResponseData.of(div).respond();
    }

    private boolean copyFile(FileData file, GogitaiJohoSakuseiDiv div) {
        FilesystemName sharedfileName = new FilesystemName(SHARED_FILE_NAME);
        List<RString> allGroups = new ArrayList();
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
        // TODO QA419待ち
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
        batchParam.setSharedFileName(SHARED_FILE_NAME);
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
                        RString.EMPTY));
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

    private GogitaiJoho setGogitaiJohoForUpd(GogitaiJohoSakuseiDiv div, dgGogitaiIchiran_Row row, GogitaiJoho gogitaiJoho) {

        Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJohoModelForUpd = ViewStateHolder.get(ViewStateKeys.合議体情報更新, Models.class);
        if (gogitaiJohoModelForUpd == null) {
            gogitaiJohoModelForUpd = Models.create(new ArrayList<GogitaiJoho>());
        }
        GogitaiJoho gogitaiJohoForUpd = new GogitaiJoho(gogitaiJoho.identifier().get合議体番号(), gogitaiJoho.identifier().get合議体有効期間開始年月日());
        GogitaiJohoBuilder gogitaiJohoBuilder = getHandler(div).getGogitaiJohoBuilder(gogitaiJoho.createBuilderForEdit(), row);
        row.setJyotai(JYOTAI_NAME_UPD);
        for (dgShinsainList_Row shinsainRow : div.getDgShinsainList().getDataSource()) {
            GogitaiWariateIinJohoIdentifier gogitaiWariateIinIdentifier
                    = new GogitaiWariateIinJohoIdentifier(Integer.parseInt(div.getTxtGogitaiNumber().getValue().toString()),
                            new FlexibleDate(div.getTxtYukoKaishiYMD().getValue().toDateString()), shinsainRow.getShinsakaiIinCode());
            GogitaiWariateIinJoho gogitaiWariateIinJohoForUpd = new GogitaiWariateIinJoho(
                    gogitaiWariateIinIdentifier.get合議体番号(),
                    gogitaiWariateIinIdentifier.get合議体有効期間開始年月日(),
                    gogitaiWariateIinIdentifier.get介護認定審査会委員コード());

            GogitaiWariateIinJoho gogitaiWariateIinJoho = gogitaiJoho.getGogitaiWariateIinJoho(gogitaiWariateIinIdentifier);
            gogitaiWariateIinJoho = getHandler(div).getGogitaiWariateIinJohoByShinsain(shinsainRow, gogitaiWariateIinJoho.createBuilderForEdit());
            gogitaiWariateIinJohoForUpd = getHandler(div).getGogitaiWariateIinJohoByShinsain(shinsainRow, gogitaiWariateIinJohoForUpd.createBuilderForEdit());
            gogitaiWariateIinJoho = gogitaiWariateIinJoho.modifiedModel();
            gogitaiJohoBuilder.setGogitaiWariateIinJoho(gogitaiWariateIinJoho);
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
            GogitaiWariateIinJoho gogitaiWariateIinJoho = gogitaiJoho.getGogitaiWariateIinJoho(gogitaiWariateIinIdentifier);
            gogitaiWariateIinJoho = getHandler(div).getGogitaiWariateIinJohoByHoketsu(hoketsuShinsainRow, gogitaiWariateIinJoho.createBuilderForEdit());
            gogitaiWariateIinJohoForUpd = getHandler(div).getGogitaiWariateIinJohoByHoketsu(hoketsuShinsainRow, gogitaiWariateIinJohoForUpd.createBuilderForEdit());
            gogitaiWariateIinJoho = gogitaiWariateIinJoho.modifiedModel();
            gogitaiJohoBuilder.setGogitaiWariateIinJoho(gogitaiWariateIinJoho);
            gogitaiJohoForUpd.createBuilderForEdit().setGogitaiWariateIinJoho(gogitaiWariateIinJohoForUpd).build();

        }
        gogitaiJoho = gogitaiJohoBuilder.build();
        gogitaiJoho = gogitaiJoho.modifiedModel();
        div.getDgGogitaiIchiran().getDataSource().set(div.getDgGogitaiIchiran().getClickedRowId(), row);

        gogitaiJohoModelForUpd.add(gogitaiJohoForUpd);
        ViewStateHolder.put(ViewStateKeys.合議体情報更新, gogitaiJohoModelForUpd);
        return gogitaiJoho;
    }

    private void csvOutput(GogitaiJohoSakuseiDiv div) {
        boolean is現在有効な合議体のみ = false;
        if (RAD_HYOJIJOKEN_ISNOW.equals(div.getRadHyojiJoken().getSelectedKey())) {
            is現在有効な合議体のみ = true;
        }
        SearchResult<GogitaiJohoSakuseiRsult> resultList = service.getGogitaiJohoForCSV(
                GogitaiJohoSakuseiParameter.createGogitaiJohoSakuseiParameter(
                        FlexibleDate.getNowDate(), is現在有効な合議体のみ, 0, FlexibleDate.EMPTY, RString.EMPTY));
        RString path = Path.getTmpDirectoryPath();
        try (CsvListWriter writer = new CsvListWriter.InstanceBuilder(path.concat(OUTPUT_CSV_FILE_NAME))
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
            dgGogitaiIchiran_Row row = div.getDgGogitaiIchiran().getClickedItem();
            if (JYOTAI_NAME_ADD.equals(row.getJyotai())) {
                gogitaiJoho = setGogitaiJoho(div, row, gogitaiJoho);
                gogitaiJohoModel.deleteOrRemove(identifier);
                gogitaiJohoModel.add(gogitaiJoho);
                div.getDgGogitaiIchiran().getDataSource().set(div.getDgGogitaiIchiran().getClickedRowId(), row);
            } else {
                gogitaiJoho = setGogitaiJohoForUpd(div, row, gogitaiJoho);
                gogitaiJohoModel.deleteOrRemove(identifier);
                gogitaiJohoModel.add(gogitaiJoho);
            }
        }
        ViewStateHolder.put(ViewStateKeys.合議体情報, gogitaiJohoModel);
        ViewStateHolder.put(ViewStateKeys.状態, RString.EMPTY);
    }
}
