/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2020008;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.chosachikugroup.ChosaChikuGroupMaster;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chosachikugroup.ChosaChikuGroup;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chosachikugroup.ChosaChikuGroupIdentifier;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.chosachikugroup.ChosaChikuGroupMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020008.DBE2020008StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020008.NinteiChosaSchedule8MainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020008.dgChosaChikuGroupChosaChikuList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020008.dgChosaChikuGroupList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020008.NinteiChosaSchedule8MainHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020008.NinteiChosaSchedule8MainValidatisonHandler;
import jp.co.ndensan.reams.db.dbe.service.core.chosachikugroup.ChosaChikuGroupFinder;
import jp.co.ndensan.reams.db.dbe.service.core.ninteischedule.chosachikugroup.ChosaChikuGroupManager;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 *
 * 認定調査スケジュール登録8のコントローラです。
 */
public class NinteiChosaSchedule8Main {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");

    /**
     * onLoadの処理を行います。
     *
     * @param div 認定調査スケジュール登録8Div
     * @return ResponseData
     */
    public ResponseData<NinteiChosaSchedule8MainDiv> onLoad(NinteiChosaSchedule8MainDiv div) {
        ChosaChikuGroupFinder chosaChikuGroupFinder = ChosaChikuGroupFinder.createInstance();
        List<ChosaChikuGroup> entityList = chosaChikuGroupFinder.getChosaChikuGroupList().records();
        if (entityList.isEmpty()) {
            ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForChosaChikuGroup();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        getHandler(div).onLoad(entityList);
        return ResponseData.of(div).respond();
    }

    /**
     * 選択行の内容を、調査地区グループ一覧エリアに表示します。
     *
     * @param div NinteiChosaSchedule8MainDiv
     * @return ResponseData<NinteiChosaSchedule8MainDiv>
     */
    public ResponseData<NinteiChosaSchedule8MainDiv> onSelectByClick_dgChosaChikuGroup(NinteiChosaSchedule8MainDiv div) {
        dgChosaChikuGroupList_Row row = div.getChosaChikuGroupList().getDgChosaChikuGroupList().getActiveRow();
        ChosaChikuGroupFinder chosaChikuGroupFinder = ChosaChikuGroupFinder.createInstance();
        ChosaChikuGroupMapperParameter parameter = ChosaChikuGroupMapperParameter.
                createSelectByKeyParam(new Code(row.getChosaChikuGroupCode()), Code.EMPTY, LasdecCode.EMPTY);
        List<ChosaChikuGroupMaster> entityList = chosaChikuGroupFinder.getChosaChikuGroupChosaChikuList(parameter).records();
        if (entityList.isEmpty()) {
            ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForGroupChosaChiku();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        getHandler(div).setChosaChikuGroupChosaChikuList(entityList, row);
        List<ChosaChikuGroup> businessList = chosaChikuGroupFinder.getChosaChikuGroup(parameter).records();
        ViewStateHolder.put(ViewStateKeys.調査地区グループ調査地区一覧結果, Models.create(businessList));
        return ResponseData.of(div).respond();
    }

    /**
     * 選択ボタン押下 、調査地区グループ一覧エリアに表示します。
     *
     * @param div NinteiChosaSchedule8MainDiv
     * @return ResponseData<NinteiChosaSchedule8MainDiv>
     */
    public ResponseData<NinteiChosaSchedule8MainDiv> onSelect_dgChosaChikuGroup(NinteiChosaSchedule8MainDiv div) {
        dgChosaChikuGroupList_Row row = div.getChosaChikuGroupList().getDgChosaChikuGroupList().getActiveRow();
        ChosaChikuGroupFinder chosaChikuGroupFinder = ChosaChikuGroupFinder.createInstance();
        ChosaChikuGroupMapperParameter parameter = ChosaChikuGroupMapperParameter.
                createSelectByKeyParam(new Code(row.getChosaChikuGroupCode()), Code.EMPTY, LasdecCode.EMPTY);
        List<ChosaChikuGroupMaster> entityList = chosaChikuGroupFinder.getChosaChikuGroupChosaChikuList(parameter).records();
        if (entityList.isEmpty()) {
            ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForGroupChosaChiku();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        getHandler(div).setChosaChikuGroupChosaChikuList(entityList, row);
        List<ChosaChikuGroup> businessList = chosaChikuGroupFinder.getChosaChikuGroup(parameter).records();
        ViewStateHolder.put(ViewStateKeys.調査地区グループ調査地区一覧結果, Models.create(businessList));
        return ResponseData.of(div).setState(DBE2020008StateName.調査地区グループ調査地区一覧);
    }

    /**
     * 選択行の内容を、調査地区グループ一覧エリアに表示します。
     *
     * @param div NinteiChosaSchedule8MainDiv
     * @return ResponseData<NinteiChosaSchedule8MainDiv>
     */
    public ResponseData<NinteiChosaSchedule8MainDiv> onSelectByDlbClick_dgChosaChikuGroup(NinteiChosaSchedule8MainDiv div) {
        dgChosaChikuGroupList_Row row = div.getChosaChikuGroupList().getDgChosaChikuGroupList().getActiveRow();
        ChosaChikuGroupFinder chosaChikuGroupFinder = ChosaChikuGroupFinder.createInstance();
        ChosaChikuGroupMapperParameter parameter = ChosaChikuGroupMapperParameter.
                createSelectByKeyParam(new Code(row.getChosaChikuGroupCode()), Code.EMPTY, LasdecCode.EMPTY);
        List<ChosaChikuGroupMaster> entityList = chosaChikuGroupFinder.getChosaChikuGroupChosaChikuList(parameter).records();
        if (entityList.isEmpty()) {
            ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForChosaChikuGroup();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        if (!entityList.isEmpty()) {
            getHandler(div).setChosaChikuGroupChosaChikuList(entityList, row);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 追加ボタンが押下された場合、明細エリアを空白で表示します。
     *
     * @param div NinteiChosaSchedule8MainDiv
     * @return ResponseData<NinteiChosaSchedule8MainDiv>
     */
    public ResponseData<NinteiChosaSchedule8MainDiv> onClick_btnInsert(NinteiChosaSchedule8MainDiv div) {
        div.getChosaChikuGroupChosaChikuInput().setState(状態_追加);
        getHandler(div).setDisabledFalseToChosaChikuGroupChosaChikuInput();
        div.getChosaChikuGroupChosaChikuInput().getTxtChosaChikuMeisho1().setDisabled(true);
        div.getChosaChikuGroupChosaChikuInput().getTxtShichosonMeisho().setDisabled(true);
        getHandler(div).clearChosaChikuGroupChosaChikuInput();
        div.getChosaChikuGroupChosaChikuInput().setHiddenInputDiv(getHandler(div).getInputDiv());
        div.getChosaChikuGroupChosaChikuInput().getBtnKakutei().setDisabled(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 修正アイコンを押下した場合、入力明細エリアに選択行の内容を表示し、項目を入力可能にします。
     *
     * @param div NinteiChosaSchedule8MainDiv
     * @return ResponseData<NinteiChosaSchedule8MainDiv>
     */
    public ResponseData<NinteiChosaSchedule8MainDiv> onSelectByModifyButton_dgChosaChikuGroupChosaChiku(NinteiChosaSchedule8MainDiv div) {
        div.getChosaChikuGroupChosaChikuInput().setState(状態_修正);
        dgChosaChikuGroupChosaChikuList_Row row = div.getChosaChikuGroupChosaChikuList().getDgChosaChikuGroupChosaChikuList().getClickedItem();
        getHandler(div).setChosaChikuGroupChosaChikuInput(row);
        getHandler(div).setDisabledTrueToChosaChikuGroupChosaChikuInput();
        div.getChosaChikuGroupChosaChikuInput().getTxtYusenNo().setDisabled(false);
        div.getChosaChikuGroupChosaChikuInput().getBtnKakutei().setDisabled(false);
        div.getChosaChikuGroupChosaChikuInput().setHiddenInputDiv(getHandler(div).getInputDiv());
        return ResponseData.of(div).respond();
    }

    /**
     * 削除アイコンを押下した場合、入力明細エリアに選択行の内容を表示し、項目を入力不可にします。
     *
     * @param div NinteiChosaSchedule8MainDiv
     * @return ResponseData<NinteiChosaSchedule8MainDiv>
     */
    public ResponseData<NinteiChosaSchedule8MainDiv> onSelectByDeleteButton_dgChosaChikuGroupChosaChiku(NinteiChosaSchedule8MainDiv div) {
        div.getChosaChikuGroupChosaChikuInput().setState(状態_削除);
        dgChosaChikuGroupChosaChikuList_Row row = div.getChosaChikuGroupChosaChikuList().getDgChosaChikuGroupChosaChikuList().getActiveRow();
        getHandler(div).setChosaChikuGroupChosaChikuInput(row);
        getHandler(div).setDisabledTrueToChosaChikuGroupChosaChikuInput();
        div.getChosaChikuGroupChosaChikuInput().getBtnKakutei().setDisabled(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 選択行の内容を、調査地区グループ調査地区一覧エリアに表示します。
     *
     * @param div NinteiChosaSchedule8MainDiv
     * @return ResponseData<NinteiChosaSchedule8MainDiv>
     */
    public ResponseData<NinteiChosaSchedule8MainDiv> onSelectByDlbClick_dgChosaChikuGroupChosaChiku(NinteiChosaSchedule8MainDiv div) {
        dgChosaChikuGroupChosaChikuList_Row row = div.getChosaChikuGroupChosaChikuList().getDgChosaChikuGroupChosaChikuList().getActiveRow();
        getHandler(div).setChosaChikuGroupChosaChikuInput(row);
        if (状態_追加.equals(row.getJotai())) {
            getHandler(div).setDisabledFalseToChosaChikuGroupChosaChikuInput();
            div.getChosaChikuGroupChosaChikuInput().getTxtChosaChikuMeisho1().setDisabled(false);
            div.getChosaChikuGroupChosaChikuInput().getTxtShichosonMeisho().setDisabled(false);
        } else if (状態_修正.equals(row.getJotai())) {
            getHandler(div).setDisabledTrueToChosaChikuGroupChosaChikuInput();
            div.getChosaChikuGroupChosaChikuInput().getTxtYusenNo().setDisabled(false);
        } else if (状態_削除.equals(row.getJotai())) {
            getHandler(div).setDisabledTrueToChosaChikuGroupChosaChikuInput();
        } else if (RString.EMPTY.equals(row.getJotai())) {
            getHandler(div).setDisabledTrueToChosaChikuGroupChosaChikuInput();
            div.getChosaChikuGroupChosaChikuInput().getBtnKakutei().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 調査地区検索ボタンを押下します。
     *
     * @param div NinteiChosaSchedule8MainDiv
     * @return ResponseData<NinteiChosaSchedule8MainDiv>
     */
    public ResponseData<NinteiChosaSchedule8MainDiv> onClick_btnToSearchChosaChiku(NinteiChosaSchedule8MainDiv div) {
       // TODO  内部QA：863 Redmine：78577       (仕様書とRAMLファイルを変更,現時点対応不可)
        return ResponseData.of(div).respond();
    }

    /**
     * 市町村検索ボタンを押下します。
     *
     * @param div NinteiChosaSchedule8MainDiv
     * @return ResponseData<NinteiChosaSchedule8MainDiv>
     */
    public ResponseData<NinteiChosaSchedule8MainDiv> onClick_btnToSearchShichoson(NinteiChosaSchedule8MainDiv div) {
        // TODO  内部QA：863 Redmine：78577       (仕様書とRAMLファイルを変更,現時点対応不可)
        return ResponseData.of(div).respond();
    }

    /**
     * 調査地区名称を取得します。
     *
     * @param div NinteiChosaSchedule8MainDiv
     * @return ResponseData<NinteiChosaSchedule8MainDiv>
     */
    public ResponseData<NinteiChosaSchedule8MainDiv> onBlur_txtChosaChikuMeisho(NinteiChosaSchedule8MainDiv div) {
        getHandler(div).setTxtChosaChikuMeisho();
        return ResponseData.of(div).respond();
    }

    /**
     * 市町村名称を取得します。
     *
     * @param div NinteiChosaSchedule8MainDiv
     * @return ResponseData<NinteiChosaSchedule8MainDiv>
     */
    public ResponseData<NinteiChosaSchedule8MainDiv> onBlur_txtShichosonMeisho(NinteiChosaSchedule8MainDiv div) {
        ChosaChikuGroupFinder chosaChikuGroupFinder = ChosaChikuGroupFinder.createInstance();
        LasdecCode shichosonCode = div.getChosaChikuGroupChosaChikuInput().getTxtShichosonCode() == null
                ? LasdecCode.EMPTY : new LasdecCode(div.getChosaChikuGroupChosaChikuInput().getTxtShichosonCode().getValue());
        ChosaChikuGroupMapperParameter parameter = ChosaChikuGroupMapperParameter.
                createSelectByKeyParam(Code.EMPTY, Code.EMPTY, shichosonCode);
        RString shichosonMeisho = chosaChikuGroupFinder.getShichosonMeisho(parameter);
        div.getChosaChikuGroupChosaChikuInput().getTxtShichosonMeisho().setValue(nullToEmpty(shichosonMeisho));
        return ResponseData.of(div).respond();
    }

     private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }
     
    /**
     * 取消するボタンが押下された場合、入力明細エリアの入力内容を破棄し、調査地区グループ調査地区一覧エリアへ戻ります。
     *
     * @param div NinteiChosaSchedule8MainDiv
     * @return ResponseData<NinteiChosaSchedule8MainDiv>
     */
    public ResponseData<NinteiChosaSchedule8MainDiv> onClick_btnTorikeshi(NinteiChosaSchedule8MainDiv div) {
        if ((状態_追加.equals(div.getChosaChikuGroupChosaChikuInput().getState()) && getValidationHandler(div).isUpdate())
                || (状態_修正.equals(div.getChosaChikuGroupChosaChikuInput().getState()) && getValidationHandler(div).isUpdate())
                ) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).setState(DBE2020008StateName.調査地区グループ調査地区一覧);
            } else if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
         return ResponseData.of(div).setState(DBE2020008StateName.調査地区グループ調査地区一覧);
    }

    /**
     * 確定するボタンが押下された場合、入力明細エリアの入力内容を調査地区グループ調査地区一覧に反映させます。
     *
     * @param div NinteiChosaSchedule8MainDiv
     * @return ResponseData<NinteiChosaSchedule8MainDiv>
     */
    public ResponseData<NinteiChosaSchedule8MainDiv> onClick_btnKakutei(NinteiChosaSchedule8MainDiv div) {

        RString イベント状態 = div.getChosaChikuGroupChosaChikuInput().getState();
        int chosaChikuCount = ChosaChikuGroupFinder.createInstance().getChosaChikuGroupChosaChikuCount(ChosaChikuGroupMapperParameter.
                createSelectByKeyParam(new Code(div.getChosaChikuGroupChosaChikuList().getTxtChosaChikuCode().getValue().toString()),
                        new Code(div.getChosaChikuGroupChosaChikuInput().getTxtChosaChikuCode1().getValue()),
                        new LasdecCode(div.getChosaChikuGroupChosaChikuInput().getTxtShichosonCode().getValue())));
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForKakutei(イベント状態, chosaChikuCount);

        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        Models<ChosaChikuGroupIdentifier, ChosaChikuGroup> models = ViewStateHolder.get(ViewStateKeys.調査地区グループ調査地区一覧結果, Models.class);
        if (状態_追加.equals(イベント状態)) {
            ChosaChikuGroup chosaChikuGroup = new ChosaChikuGroup(
                    new Code(div.getChosaChikuGroupChosaChikuList().getTxtChosaChikuCode().getValue().toString()),
                    new Code(div.getChosaChikuGroupChosaChikuInput().getTxtChosaChikuCode1().getValue()),
                    new LasdecCode(div.getChosaChikuGroupChosaChikuInput().getTxtShichosonCode().getValue()));
            validPairs = validateForInsert(div);
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
            chosaChikuGroup = getHandler(div).editChosaChikuGroup(chosaChikuGroup);
            models.add(chosaChikuGroup);
        } else if (状態_修正.equals(イベント状態)) {
            ChosaChikuGroupIdentifier key = new ChosaChikuGroupIdentifier(
                    new Code(div.getChosaChikuGroupChosaChikuList().getTxtChosaChikuCode().getValue().toString()),
                    new Code(div.getChosaChikuGroupChosaChikuInput().getTxtChosaChikuCode1().getValue()),
                    new LasdecCode(div.getChosaChikuGroupChosaChikuInput().getTxtShichosonCode().getValue()));
            ChosaChikuGroup chosaChikuGroup = getHandler(div).editChosaChikuGroup(models.get(key).modifiedModel());
            models.deleteOrRemove(key);
            models.add(chosaChikuGroup);
        } else if (状態_削除.equals(イベント状態)) {
            ChosaChikuGroupIdentifier key = new ChosaChikuGroupIdentifier(
                    new Code(div.getChosaChikuGroupChosaChikuList().getTxtChosaChikuCode().getValue().toString()),
                    new Code(div.getChosaChikuGroupChosaChikuInput().getTxtChosaChikuCode1().getValue()),
                    new LasdecCode(div.getChosaChikuGroupChosaChikuInput().getTxtShichosonCode().getValue()));
            RString jotai = div.getChosaChikuGroupChosaChikuList().getDgChosaChikuGroupChosaChikuList().getActiveRow().getJotai();
            if (状態_追加.equals(jotai)) {
                models.deleteOrRemove(key);
            } else {
                ChosaChikuGroup chosaChikuGroup = getHandler(div).editChosaChikuGroup(models.get(key).deleted());
                models.add(chosaChikuGroup);
            }
        }
        ViewStateHolder.put(ViewStateKeys.調査地区グループ調査地区一覧結果, models);
        getHandler(div).setChosaChikuGroupToIchiran(イベント状態);
        return ResponseData.of(div).respond();
    }

    private ValidationMessageControlPairs validateForInsert(NinteiChosaSchedule8MainDiv div) {
        List<dgChosaChikuGroupChosaChikuList_Row> dataList = div.getChosaChikuGroupChosaChikuList()
                .getDgChosaChikuGroupChosaChikuList().getDataSource();
        for (dgChosaChikuGroupChosaChikuList_Row row : dataList) {
            if (row.getChosaChikuCode().equals(div.getChosaChikuGroupChosaChikuInput().getTxtChosaChikuCode1().getValue())
                    && row.getShichosonCode().equals(div.getChosaChikuGroupChosaChikuInput().getTxtShichosonCode().getValue())) {
                return getValidationHandler(div).validateForInsert();
            }
        }
        return new ValidationMessageControlPairs();
    }

    /**
     * 保存するボタン押下、データがDBに更新します。
     *
     * @param div NinteiChosaSchedule8MainDiv
     * @return ResponseData<NinteiChosaSchedule8MainDiv>
     */
    public ResponseData<NinteiChosaSchedule8MainDiv> onClick_btnUpdate(NinteiChosaSchedule8MainDiv div) {
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
            Models<ChosaChikuGroupIdentifier, ChosaChikuGroup> models = ViewStateHolder.get(
                    ViewStateKeys.調査地区グループ調査地区一覧結果, Models.class);
            ChosaChikuGroupManager chosaChikuGroupManager = new ChosaChikuGroupManager();
            for (ChosaChikuGroup chosaChikuGroup : models) {
                chosaChikuGroupManager.saveOrDelete調査地区グループマスタ(chosaChikuGroup);
            }
            div.getCcdKanryoMessage().setSuccessMessage(
                    new RString(UrInformationMessages.保存終了.getMessage().evaluate()), RString.EMPTY, RString.EMPTY);
            return ResponseData.of(div).setState(DBE2020008StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    private ValidationMessageControlPairs validateForDelete(NinteiChosaSchedule8MainDiv div) {
        List<dgChosaChikuGroupChosaChikuList_Row> dataList = div.getChosaChikuGroupChosaChikuList()
                .getDgChosaChikuGroupChosaChikuList().getDataSource();
        ChosaChikuGroupFinder chosaChikuGroupFinder = ChosaChikuGroupFinder.createInstance();
        for (dgChosaChikuGroupChosaChikuList_Row row : dataList) {
            if (状態_削除.equals(row.getJotai())) {
                ChosaChikuGroupMapperParameter parameter = ChosaChikuGroupMapperParameter.createSelectByKeyParam(
                        Code.EMPTY,
                        new Code(row.getChosaChikuCode()),
                        LasdecCode.EMPTY);
                return getValidationHandler(div).validateForUpdate(
                        chosaChikuGroupFinder.getChosaChikuGroupCount(parameter), 0);
            } else if (状態_追加.equals(row.getJotai())) {
                ChosaChikuGroupMapperParameter parameter = ChosaChikuGroupMapperParameter.createSelectByKeyParam(
                        Code.EMPTY,
                        new Code(row.getChosaChikuCode()),
                        new LasdecCode(row.getShichosonCode()));
                return getValidationHandler(div).validateForUpdate(0,
                        chosaChikuGroupFinder.getChosaChikuGroupChosaChikuToroukuCount(parameter));
            }
        }
        return new ValidationMessageControlPairs();
    }

    /**
     * 調査地区グループ一覧に戻ります。
     *
     * @param div NinteiChosaSchedule8MainDiv
     * @return ResponseData<NinteiChosaSchedule8MainDiv>
     */
    public ResponseData<NinteiChosaSchedule8MainDiv> onClick_btnChosaChikuGroupIchiran(NinteiChosaSchedule8MainDiv div) {
        if ((状態_追加.equals(div.getChosaChikuGroupChosaChikuInput().getState()) && getValidationHandler(div).isUpdate())
                || (状態_修正.equals(div.getChosaChikuGroupChosaChikuInput().getState()) && getValidationHandler(div).isUpdate())
                ) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                        UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                div.getChosaChikuGroupChosaChikuInput().setState(RString.EMPTY);
                return ResponseData.of(div).setState(DBE2020008StateName.調査地区グループ一覧);
            } else if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        return ResponseData.of(div).setState(DBE2020008StateName.調査地区グループ一覧);
    }

    /**
     * 調査地区一覧に戻ります。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<NinteiChosaSchedule8MainDiv> onClick_btnBackChosaChikuGroupChosaChikuIchiran(NinteiChosaSchedule8MainDiv div) {
        if ((状態_追加.equals(div.getChosaChikuGroupChosaChikuInput().getState()) && getValidationHandler(div).isUpdate())
                || (状態_修正.equals(div.getChosaChikuGroupChosaChikuInput().getState()) && getValidationHandler(div).isUpdate())
                ) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                        UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                div.getChosaChikuGroupChosaChikuInput().setState(RString.EMPTY);
                return ResponseData.of(div).setState(DBE2020008StateName.調査地区グループ調査地区一覧);
            } else if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        return ResponseData.of(div).setState(DBE2020008StateName.調査地区グループ調査地区一覧);
    }
    
     /**
     * 画面を閉じて、メニューに戻る。
     *
     * @param div NinteiChosaSchedule8MainDiv
     * @return ResponseData<NinteiChosaSchedule8MainDiv>
     */
    public ResponseData<NinteiChosaSchedule8MainDiv> onClick_complete(NinteiChosaSchedule8MainDiv div) {
         return ResponseData.of(div).setState(DBE2020008StateName.調査地区グループ一覧);
    }

    private NinteiChosaSchedule8MainHandler getHandler(NinteiChosaSchedule8MainDiv div) {
        return new NinteiChosaSchedule8MainHandler(div);
    }

    private NinteiChosaSchedule8MainValidatisonHandler getValidationHandler(NinteiChosaSchedule8MainDiv div) {
        return new NinteiChosaSchedule8MainValidatisonHandler(div);
    }
}
