/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5110001;

import java.util.Iterator;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho.GogitaiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho.GogitaiJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho.GogitaiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaiwariateiinjoho.GogitaiWariateIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaiwariateiinjoho.GogitaiWariateIinJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijohosakusei.GogitaiJohoSakuseiRsult;
import jp.co.ndensan.reams.db.dbe.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbe.definition.core.gogitaijohosakusei.GogitaiJohoSakuseiParameter;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Hoshu.GogitaichoKubunCode;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.GogitaiJohoSakuseiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.dgGogitaiIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.dgHoketsuShinsainList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.dgShinsainList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5110001.GogitaiJohoSakuseiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5110001.GogitaiJohoSakuseiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.gogitaijoho.gogitaijoho.GogitaiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.gogitaijohosakusei.GogitaiJohoSakuseiFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
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
    private static final RString JYOTAI_CODE_DEL = new RString("3");
    private static final RString JYOTAI_NAME_DEL = new RString("削除");
    private static final RString SEISHINKAI_SONZAI_SURU = new RString("key0");
    private static final RString SEISHINKAI_SONZAI_SHINAI = new RString("key1");
    private static final RString DUMMY_FLAG_TUUJOU = new RString("key0");
    private static final RString DUMMY_FLAG_DAMI = new RString("key1");
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
        if (new RString("key0").equals(div.getRadHyojiJoken().getSelectedKey())) {
            is現在有効な合議体のみ = true;
        }
        SearchResult<GogitaiJohoSakuseiRsult> resultList = service.getDateGridList(
                GogitaiJohoSakuseiParameter.createGogitaiJohoSakuseiParameter(
                        FlexibleDate.getNowDate(), is現在有効な合議体のみ, 0, FlexibleDate.EMPTY));
        SearchResult<GogitaiJoho> gogitaiJohoList = service.getGogitaiJohoSakusei(is現在有効な合議体のみ);
        Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJoho = Models.create(gogitaiJohoList.records());
        ViewStateHolder.put(ViewStateKeys.合議体情報, gogitaiJoho);
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
        if (!(JYOTAI_NAME_ADD.equals(div.getDgGogitaiIchiran().getClickedItem().getJyotai())
                || JYOTAI_NAME_UPD.equals(div.getDgGogitaiIchiran().getClickedItem().getJyotai()))) {
            SearchResult<GogitaiJohoSakuseiRsult> resultList = service.getShinsainList(
                    GogitaiJohoSakuseiParameter.createGogitaiJohoSakuseiParameter(
                            FlexibleDate.EMPTY, false,
                            Integer.parseInt(div.getDgGogitaiIchiran().getClickedItem().getGogitaiNumber().toString()),
                            new FlexibleDate(div.getDgGogitaiIchiran().getClickedItem().getYukoKaishiYMD().getValue().toDateString().toString())));
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
            GogitaiJohoIdentifier identifier = new GogitaiJohoIdentifier(Integer.parseInt(div.getTxtGogitaiNumber().getValue().toString()),
                    new FlexibleDate(div.getTxtYukoKaishiYMD().getValue().toDateString()));
            GogitaiJoho gogitaiJoho = gogitaiJohoModel.get(identifier);
            if (!hasChanged(div, gogitaiJoho, jyotai)) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ViewStateHolder.put(ViewStateKeys.状態, JYOTAI_CODE_UPD);

            SearchResult<GogitaiJohoSakuseiRsult> resultList = service.getShinsainList(
                    GogitaiJohoSakuseiParameter.createGogitaiJohoSakuseiParameter(
                            FlexibleDate.EMPTY, false,
                            Integer.parseInt(div.getDgGogitaiIchiran().getClickedItem().getGogitaiNumber().toString()),
                            new FlexibleDate(div.getDgGogitaiIchiran().getClickedItem().getYukoKaishiYMD().getValue().toDateString().toString())));
            getHandler(div).setGogitaiShosai(div.getDgGogitaiIchiran().getClickedItem(), resultList.records());
            getHandler(div).setDisableByUpd();
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
            GogitaiJohoIdentifier identifier = new GogitaiJohoIdentifier(Integer.parseInt(div.getTxtGogitaiNumber().getValue().toString()),
                    new FlexibleDate(div.getTxtYukoKaishiYMD().getValue().toDateString()));
            GogitaiJoho gogitaiJoho = gogitaiJohoModel.get(identifier);
            if (!hasChanged(div, gogitaiJoho, jyotai)) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            }
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
        // TODO QA212
        return ResponseData.of(div).respond();
    }

    /**
     * 「審査会委員を選択する」ボタンをクリックの場合、割当補欠審査会委員情報一覧のデータを設定します。
     *
     * @param div 合議体情報作成Div
     * @return ResponseData<GogitaiJohoSakuseiDiv>
     */
    public ResponseData<GogitaiJohoSakuseiDiv> onClick_btnSubShinsainSelect(GogitaiJohoSakuseiDiv div) {
        // TODO QA212
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
            GogitaiJohoIdentifier identifier = new GogitaiJohoIdentifier(Integer.parseInt(div.getTxtGogitaiNumber().getValue().toString()),
                    new FlexibleDate(div.getTxtYukoKaishiYMD().getValue().toDateString()));
            GogitaiJoho gogitaiJoho = gogitaiJohoModel.get(identifier);
            if (!hasChanged(div, gogitaiJoho, jyotai)) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ViewStateHolder.put(ViewStateKeys.状態, RString.EMPTY);
            getHandler(div).cleanGogitaiShosai();
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
        Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJohoModel = ViewStateHolder.get(ViewStateKeys.合議体情報, Models.class);
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
        if (JYOTAI_CODE_ADD.equals(jyotai)) {
            dgGogitaiIchiran_Row row = new dgGogitaiIchiran_Row();
            GogitaiJoho gogitaiJoho = new GogitaiJoho(
                    Integer.parseInt(div.getTxtGogitaiNumber().getValue().toString()),
                    new FlexibleDate(div.getTxtYukoKaishiYMD().getValue().toDateString()));

            GogitaiJohoBuilder gogitaiJohoBuilder = getGogitaiJohoBuilder(gogitaiJoho, div, row);
            row.setJyotai(JYOTAI_NAME_ADD);

            for (dgShinsainList_Row shinsainRow : div.getDgShinsainList().getDataSource()) {
                GogitaiWariateIinJoho gogitaiWariateIinJoho = getGogitaiWariateIinJohoByShinsain(shinsainRow, div);
                gogitaiJohoBuilder.setGogitaiWariateIinJoho(gogitaiWariateIinJoho);
            }
            for (dgHoketsuShinsainList_Row hoketsuShinsainRow : div.getDgHoketsuShinsainList().getDataSource()) {
                GogitaiWariateIinJoho gogitaiWariateIinJoho = getGogitaiWariateIinJohoByHoketsu(hoketsuShinsainRow, div);
                gogitaiJohoBuilder.setGogitaiWariateIinJoho(gogitaiWariateIinJoho);
            }
            gogitaiJoho = gogitaiJohoBuilder.build();

            gogitaiJohoModel.add(gogitaiJoho);
            div.getDgGogitaiIchiran().getDataSource().add(row);
        }
        if (JYOTAI_CODE_UPD.equals(jyotai)) {
            GogitaiJohoIdentifier identifier = new GogitaiJohoIdentifier(Integer.parseInt(div.getTxtGogitaiNumber().getValue().toString()),
                    new FlexibleDate(div.getTxtYukoKaishiYMD().getValue().toDateString()));
            GogitaiJoho gogitaiJoho = gogitaiJohoModel.get(identifier);
            dgGogitaiIchiran_Row row = div.getDgGogitaiIchiran().getClickedItem();
            if (JYOTAI_NAME_ADD.equals(row.getJyotai())) {
                GogitaiJohoBuilder gogitaiJohoBuilder = getGogitaiJohoBuilder(gogitaiJoho, div, row);
                row.setJyotai(JYOTAI_NAME_ADD);
                for (dgShinsainList_Row shinsainRow : div.getDgShinsainList().getDataSource()) {
                    GogitaiWariateIinJoho gogitaiWariateIinJoho = getGogitaiWariateIinJohoByShinsain(shinsainRow, div);
                    gogitaiJohoBuilder.setGogitaiWariateIinJoho(gogitaiWariateIinJoho);
                }
                for (dgHoketsuShinsainList_Row hoketsuShinsainRow : div.getDgHoketsuShinsainList().getDataSource()) {
                    GogitaiWariateIinJoho gogitaiWariateIinJoho = getGogitaiWariateIinJohoByHoketsu(hoketsuShinsainRow, div);
                    gogitaiJohoBuilder.setGogitaiWariateIinJoho(gogitaiWariateIinJoho);
                }
                gogitaiJoho = gogitaiJohoBuilder.build();
                gogitaiJohoModel.deleteOrRemove(identifier);
                gogitaiJohoModel.add(gogitaiJoho);
                div.getDgGogitaiIchiran().getDataSource().set(div.getDgGogitaiIchiran().getClickedRowId(), row);
            } else {
                GogitaiJohoBuilder gogitaiJohoBuilder = getGogitaiJohoBuilder(gogitaiJoho, div, row);
                row.setJyotai(JYOTAI_NAME_UPD);
                for (dgShinsainList_Row shinsainRow : div.getDgShinsainList().getDataSource()) {
                    GogitaiWariateIinJoho gogitaiWariateIinJoho = getGogitaiWariateIinJohoByShinsain(shinsainRow, div);
                    gogitaiWariateIinJoho = gogitaiWariateIinJoho.modifiedModel();
                    gogitaiJohoBuilder.setGogitaiWariateIinJoho(gogitaiWariateIinJoho);
                }
                for (dgHoketsuShinsainList_Row hoketsuShinsainRow : div.getDgHoketsuShinsainList().getDataSource()) {
                    GogitaiWariateIinJoho gogitaiWariateIinJoho = getGogitaiWariateIinJohoByHoketsu(hoketsuShinsainRow, div);
                    gogitaiWariateIinJoho = gogitaiWariateIinJoho.modifiedModel();
                    gogitaiJohoBuilder.setGogitaiWariateIinJoho(gogitaiWariateIinJoho);
                }
                gogitaiJoho = gogitaiJohoBuilder.build();
                gogitaiJoho = gogitaiJoho.modifiedModel();
                gogitaiJohoModel.deleteOrRemove(identifier);
                gogitaiJohoModel.add(gogitaiJoho);
                div.getDgGogitaiIchiran().getDataSource().set(div.getDgGogitaiIchiran().getClickedRowId(), row);
            }
        }
        ViewStateHolder.put(ViewStateKeys.合議体情報, gogitaiJohoModel);
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
                    // TODO QA204
                    manager.deletePhysical(gogitaiJoho);
                }
                if (gogitaiJoho.toEntity().getState() == EntityDataState.Modified) {
                    manager.deletePhysical(gogitaiJoho);
//                    gogitaiJoho.toEntity()
                    manager.save(gogitaiJoho);
                }
            }

        }
        return ResponseData.of(div).respond();
    }

    private GogitaiJohoSakuseiHandler getHandler(GogitaiJohoSakuseiDiv div) {
        return new GogitaiJohoSakuseiHandler(div);
    }

    private GogitaiJohoSakuseiValidationHandler getValidationHandler(GogitaiJohoSakuseiDiv div) {
        return new GogitaiJohoSakuseiValidationHandler(div);
    }

    private boolean hasChanged(GogitaiJohoSakuseiDiv div,
            GogitaiJoho gogitaiJoho, RString jyotai) {
        if (JYOTAI_CODE_ADD.equals(jyotai)) {
            return getHandler(div).hasChangedByAdd();
        }
        if (JYOTAI_CODE_UPD.equals(jyotai)) {
            return getHandler(div).hasChangedByUpd(gogitaiJoho);
        }
        return true;
    }

    private GogitaiJohoBuilder getGogitaiJohoBuilder(GogitaiJoho gogitaiJoho, GogitaiJohoSakuseiDiv div, dgGogitaiIchiran_Row row) {
        GogitaiJohoBuilder gogitaiJohoBuilder = gogitaiJoho.createBuilderForEdit();
        row.setGogitaiNumber(div.getTxtGogitaiNumber().getValue());
        row.setGogitaiName(div.getTxtGogitaiMeisho().getValue());
        row.getGogitaiKaishiYoteiTime().setValue(div.getTxtKaishiYoteiTime().getValue());
        row.getGogitaiShuryoYoteiTime().setValue(div.getTxtShuryoYoteiTime().getValue());
        row.setKaisaiBashoCode(div.getDdlkaisaibasho().getSelectedKey());
        row.getIinTeiin().setValue(div.getTxtIinTeiin().getValue());
        row.getJidoWariateTeiin().setValue(div.getTxtJidoWariateTeiin().getValue());
        row.getYoteiTeiin().setValue(div.getTxtYoteiTeiin().getValue());
        row.getYukoKaishiYMD().setValue(div.getTxtYukoKaishiYMD().getValue());
        row.getYukoShuryoYMD().setValue(div.getTxtYukoShuryoYMD().getValue());
        if (DUMMY_FLAG_DAMI.equals(div.getRadDummyFlag().getSelectedKey())) {
            row.setGogitaiDummyFlag(true);
            gogitaiJohoBuilder.set合議体ダミーフラグ(true);
        } else {
            row.setGogitaiDummyFlag(false);
            gogitaiJohoBuilder.set合議体ダミーフラグ(false);
        }
        if (SEISHINKAI_SONZAI_SURU.equals(div.getRadSeishinkaiSonzai().getSelectedKey())) {
            row.setGogitaiDummyFlag(true);
            gogitaiJohoBuilder.set合議体精神科医存在フラグ(true);
        } else {
            row.setGogitaiDummyFlag(false);
            gogitaiJohoBuilder.set合議体精神科医存在フラグ(false);
        }
        gogitaiJohoBuilder.set合議体名称(div.getTxtGogitaiNumber().getValue());
        gogitaiJohoBuilder.set合議体開始予定時刻(new RString(div.getTxtKaishiYoteiTime().getValue().toString()));
        gogitaiJohoBuilder.set合議体終了予定時刻(new RString(div.getTxtShuryoYoteiTime().getValue().toString()));
        gogitaiJohoBuilder.set合議体有効期間終了年月日(new FlexibleDate(div.getTxtYukoShuryoYMD().getValue().toDateString()));
        gogitaiJohoBuilder.set介護認定審査会開催場所コード(div.getDdlkaisaibasho().getSelectedKey());
        gogitaiJohoBuilder.set介護認定審査会予定定員(div.getTxtYoteiTeiin().getValue().intValue());
        gogitaiJohoBuilder.set介護認定審査会自動割当定員(div.getTxtJidoWariateTeiin().getValue().intValue());
        gogitaiJohoBuilder.set介護認定審査会委員定員(div.getTxtIinTeiin().getValue().intValue());
        return gogitaiJohoBuilder;
    }

    private GogitaiWariateIinJoho getGogitaiWariateIinJohoByShinsain(dgShinsainList_Row shinsainRow, GogitaiJohoSakuseiDiv div) {
        GogitaiWariateIinJoho gogitaiWariateIinJoho = new GogitaiWariateIinJoho(Integer.parseInt(div.getTxtGogitaiNumber().getValue().toString()),
                new FlexibleDate(div.getTxtYukoKaishiYMD().getValue().toDateString()), shinsainRow.getShinsakaiIinCode());
        GogitaiWariateIinJohoBuilder gogitaiWariateIinJohoBuilder = gogitaiWariateIinJoho.createBuilderForEdit();
        gogitaiWariateIinJohoBuilder.set補欠(false);
        if (shinsainRow.getGogitaicho()) {
            gogitaiWariateIinJohoBuilder.set合議体長区分コード(new Code(GogitaichoKubunCode.合議体長.getコード()));
        } else if (shinsainRow.getFukuGogitaicho()) {
            gogitaiWariateIinJohoBuilder.set合議体長区分コード(new Code(GogitaichoKubunCode.副合議体長.getコード()));
        } else {
            gogitaiWariateIinJohoBuilder.set合議体長区分コード(new Code(GogitaichoKubunCode.通常.getコード()));
        }
        gogitaiWariateIinJohoBuilder.set合議体有効期間終了年月日(new FlexibleDate(div.getTxtYukoShuryoYMD().getValue().toDateString()));
        gogitaiWariateIinJoho = gogitaiWariateIinJohoBuilder.build();
        return gogitaiWariateIinJoho;
    }

    private GogitaiWariateIinJoho getGogitaiWariateIinJohoByHoketsu(dgHoketsuShinsainList_Row hoketsuShinsainRow, GogitaiJohoSakuseiDiv div) {
        GogitaiWariateIinJoho gogitaiWariateIinJoho = new GogitaiWariateIinJoho(Integer.parseInt(div.getTxtGogitaiNumber().getValue().toString()),
                new FlexibleDate(div.getTxtYukoKaishiYMD().getValue().toDateString()), hoketsuShinsainRow.getHoketsuShinsakaiIinCode());
        GogitaiWariateIinJohoBuilder gogitaiWariateIinJohoBuilder = gogitaiWariateIinJoho.createBuilderForEdit();
        gogitaiWariateIinJohoBuilder.set補欠(true);
        gogitaiWariateIinJohoBuilder.set合議体長区分コード(new Code(GogitaichoKubunCode.通常.getコード()));
        gogitaiWariateIinJohoBuilder.set合議体有効期間終了年月日(new FlexibleDate(div.getTxtYukoShuryoYMD().getValue().toDateString()));
        gogitaiWariateIinJoho = gogitaiWariateIinJohoBuilder.build();
        return gogitaiWariateIinJoho;
    }
}
