/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5140002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJoho2;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJoho2Builder;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJoho2Identifier;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinwaritsuke.ShinsakaiKaisaiYoteiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinwaritsuke.ShinsakaiiinJoho;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140002.DBE5140002TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140002.ShinsakaiIinWaritsukeDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140002.dgShinsakaiIinIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140002.dgShinsakaiIinKoseiIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5140002.ShinsakaiIinWaritsukeHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5140002.ShinsakaiIinWaritsukeValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai2.ShinsakaiKaisaiYoteiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai2.ShinsakaiiinJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 介護認定審査会割当委員情報更新のコントローラです。
 *
 * @reamsid_L DBE-0130-020 xuyannan
 */
public class ShinsakaiIinWaritsuke {

    private static final int 時刻桁数 = 4;
    private final RString 開催番号;
    private final RString 開催年月日;
    private final ShinsakaiKaisaiYoteiJohoManager kaisaiYoteiJohomanager;
    private final ShinsakaiiinJohoManager iinJohomanager;

    /**
     * コンストラクタです。
     */
    public ShinsakaiIinWaritsuke() {
        開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);
        開催年月日 = ViewStateHolder.get(ViewStateKeys.開催年月日, RString.class);
        kaisaiYoteiJohomanager = ShinsakaiKaisaiYoteiJohoManager.createInstance();
        iinJohomanager = ShinsakaiiinJohoManager.createInstance();
    }

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<ShinsakaiIinWaritsukeDiv> onLoad(ShinsakaiIinWaritsukeDiv div) {
        List<ShinsakaiKaisaiYoteiJoho> kaisaiYoteiJohoList = kaisaiYoteiJohomanager
                .search審査会開催予定情報Of開催番号(開催番号).records();
        getHandler(div).onLoad(kaisaiYoteiJohoList, 開催番号);
        List<ShinsakaiiinJoho> iinJoholist = iinJohomanager.search審査会委員情報Of開催番号(開催番号, 開催年月日).records();
        getHandler(div).setDataGrid(iinJoholist);
        Models<ShinsakaiWariateIinJoho2Identifier, ShinsakaiWariateIinJoho2> models
                = Models.create(iinJohomanager.searchByKaisaiNo(開催番号).records());
        ViewStateHolder.put(ViewStateKeys.介護認定審査会割当委員情報_一覧, models);
        return ResponseData.of(div).respond();
    }

    /**
     * 「構成一覧に割り付ける」ボタン押下、「介護認定審査会委員構成一覧」に移動処理します。
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<ShinsakaiIinWaritsukeDiv> onClick_WaritukeruBtn(ShinsakaiIinWaritsukeDiv div) {
        List<dgShinsakaiIinIchiran_Row> selectedItems = div.getDgShinsakaiIinIchiran().getSelectedItems();
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForWaritukeruBtn();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        for (dgShinsakaiIinIchiran_Row row : selectedItems) {
            getHandler(div).set介護認定審査会委員構成一覧(row);
            div.getDgShinsakaiIinIchiran().getDataSource().remove(row);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「構成一覧から解除する」ボタン押下、「介護認定審査会委員一覧」に移動処理します。
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<ShinsakaiIinWaritsukeDiv> onClick_KaijoBtn(ShinsakaiIinWaritsukeDiv div) {
        List<dgShinsakaiIinKoseiIchiran_Row> selectedItems = div.getDgShinsakaiIinKoseiIchiran().getSelectedItems();
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForKaijoBtn();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        List<dgShinsakaiIinIchiran_Row> 既存Data退避 = div.getDgShinsakaiIinIchiran().getDataSource();
        div.getDgShinsakaiIinIchiran().setDataSource(new ArrayList<dgShinsakaiIinIchiran_Row>());
        for (dgShinsakaiIinKoseiIchiran_Row row : selectedItems) {
            getHandler(div).set介護認定審査会委員一覧(row);
            div.getDgShinsakaiIinKoseiIchiran().getDataSource().remove(row);
        }
        div.getDgShinsakaiIinIchiran().getDataSource().addAll(selectedItems.size(), 既存Data退避);
        return ResponseData.of(div).respond();
    }

    /**
     * 「全体を表示する」ボタン押下、介護認定審査会委員一覧Grid検索します。
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<ShinsakaiIinWaritsukeDiv> onClick_ZenntaiBtn(ShinsakaiIinWaritsukeDiv div) {
        List<ShinsakaiiinJoho> iinJoholist = iinJohomanager.searchAll審査会委員情報(
                div.getTxtKaisaiYoteibi().getValue().toDateString()).records();
        getHandler(div).setAllDataGrid(iinJoholist);
        return ResponseData.of(div).respond();
    }

    /**
     * 「開催予定に戻る」ボタン押下、元画面へ移転します。
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<ShinsakaiIinWaritsukeDiv> onClick_ModoruBtn(ShinsakaiIinWaritsukeDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタン押下、更新実施。
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<ShinsakaiIinWaritsukeDiv> onClick_HozonnBtn(ShinsakaiIinWaritsukeDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForHozonnBtn();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).前排他制御処理();
            Models<ShinsakaiWariateIinJoho2Identifier, ShinsakaiWariateIinJoho2> models
                    = ViewStateHolder.get(ViewStateKeys.介護認定審査会割当委員情報_一覧, Models.class);
            for (ShinsakaiWariateIinJoho2 iinJoho : models) {
                iinJohomanager.deletePhysicalByKaisaiNo(iinJoho.toEntity());
            }
            List<dgShinsakaiIinKoseiIchiran_Row> koseiIchiranGridList
                    = div.getDgShinsakaiIinKoseiIchiran().getDataSource();
            for (dgShinsakaiIinKoseiIchiran_Row row : koseiIchiranGridList) {
                ShinsakaiWariateIinJoho2 wariateIinJoho = new ShinsakaiWariateIinJoho2(開催番号, row.getShinsakaiIinCode());
                ShinsakaiWariateIinJoho2Builder builder = wariateIinJoho.createBuilderForEdit();
                builder.set介護認定審査会開催年月日(new FlexibleDate(div.getTxtKaisaiYoteibi().getValue().toDateString()));
                builder.set介護認定審査会議長区分コード(new Code(row.getGogitaichoKubun()));
                builder.set委員出席(true);
                builder.set委員遅刻有無(false);
                builder.set委員出席時間(new RString(
                        div.getTxtKaishiYoteiTime().getValue().toString().replace(":", "").substring(0, 時刻桁数)));
                builder.set委員早退有無(false);
                builder.set委員退席時間(new RString(
                        div.getTxtShuryoYoteiTime().getValue().toString().replace(":", "").substring(0, 時刻桁数)));
                builder.build().isAdded();
                iinJohomanager.save(builder.build().toEntity());
            }
            getHandler(div).前排他解除処理();
        }
        return ResponseData.of(div).forwardWithEventName(DBE5140002TransitionEventName.開催予定登録に戻る).respond();
    }

    private ShinsakaiIinWaritsukeHandler getHandler(ShinsakaiIinWaritsukeDiv div) {
        return new ShinsakaiIinWaritsukeHandler(div);
    }

    private ShinsakaiIinWaritsukeValidationHandler getValidationHandler(ShinsakaiIinWaritsukeDiv div) {
        return new ShinsakaiIinWaritsukeValidationHandler(div);
    }
}
