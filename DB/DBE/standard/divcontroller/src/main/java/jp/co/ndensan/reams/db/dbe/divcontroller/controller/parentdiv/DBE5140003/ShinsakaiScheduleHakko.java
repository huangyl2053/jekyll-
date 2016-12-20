/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5140003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjohogogitai.ShinsakaiIinJohoGoitaiBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE514001.DBE514001_ShinsakaiScheduleParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140003.ShinsakaiScheduleHakkoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140003.dgShinsakaiScheduleKagami_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5140003.ShinsakaiScheduleHakkoValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai1.ShinsakaiiinJohoManager;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 介護認定審査会開催予定登録3クラスです。
 *
 * @reamsid_L DBE-0130-030 yaodongsheng
 */
public class ShinsakaiScheduleHakko {

    private static final RString 介護認定審査会スケジュール表鑑 = new RString("key0");
    private static final RString JIKO_BTTON = new RString("btnHakko");

    /**
     * 画面初期化処理です。
     *
     * @param div 介護認定審査会開催予定登録3div
     * @return ResponseData<ShinsakaiScheduleHakkoDiv>
     */
    public ResponseData<ShinsakaiScheduleHakkoDiv> onLoad(ShinsakaiScheduleHakkoDiv div) {
        div.getShinsakaiScheduleSrch().getChkShinsakaiSchedule().getSelectedKeys().clear();
        div.getShinsakaiScheduleSrch().getChkShinsakaiScheduleKagami().getSelectedKeys().clear();
        div.getShinsakaiScheduleSrch().getTxtShinsakaiKaisaiYoteiKikan().clearFromValue();
        div.getShinsakaiScheduleSrch().getTxtShinsakaiKaisaiYoteiKikan().clearToValue();
        div.getShinsakaiScheduleSrch().getChkShinsakaiScheduleNenkan().setWidth(new RString("310px"));
        div.getShinsakaiScheduleSrch().getChkShinsakaiScheduleNenkan().getSelectedKeys().clear();
        div.getShinsakaiScheduleSrch().getTxtNendo().clearValue();
        CommonButtonHolder.setVisibleByCommonButtonFieldName(JIKO_BTTON, false);
        return ResponseData.of(div).respond();
    }

    /**
     * 介護認定審査会スケジュール表（鑑）チェックボックスを押下した際に実行します。
     *
     * @param div 介護認定審査会開催予定登録3div
     * @return ResponseData<ShinsakaiScheduleHakkoDiv>
     */
    public ResponseData<ShinsakaiScheduleHakkoDiv> onClick_btnCheckBoxJin(ShinsakaiScheduleHakkoDiv div) {
        List<RString> selectKey = div.getShinsakaiScheduleSrch().getChkShinsakaiScheduleKagami().getSelectedKeys();
        if (!selectKey.isEmpty() && 介護認定審査会スケジュール表鑑.equals(selectKey.get(0))) {
            ShinsakaiiinJohoManager shinsakaiiinJohoManager = InstanceProvider.create(ShinsakaiiinJohoManager.class);
            SearchResult<ShinsakaiIinJohoGoitaiBusiness> shoriDateKanri = shinsakaiiinJohoManager.search審査会委員情報();
            setDgShinsakaiScheduleKagami(shoriDateKanri, div);
            div.getDgShinsakaiScheduleKagami().setVisible(true);
        } else {
            div.getDgShinsakaiScheduleKagami().setVisible(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 発行ボタンを押下した際に実行します。
     *
     * @param div 介護認定審査会開催予定登録3div
     * @return ResponseData<ShinsakaiScheduleHakkoDiv>
     */
    public ResponseData<ShinsakaiScheduleHakkoDiv> onClick_btnKyotsu(ShinsakaiScheduleHakkoDiv div) {
        ShinsakaiScheduleHakkoValidationHandler validationHandler = new ShinsakaiScheduleHakkoValidationHandler(div);
        ValidationMessageControlPairs validPairs = getCheck(validationHandler);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 開催予定に戻るボタンを押下した際に実行します。
     *
     * @param div 介護認定審査会開催予定登録3div
     * @return ResponseData<ShinsakaiScheduleHakkoDiv>
     */
    public ResponseData<ShinsakaiScheduleHakkoDiv> onClick_btnBackToKaisaiYotei(ShinsakaiScheduleHakkoDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 介護認定審査会スケジュール表バッチを実行します。
     *
     * @param div 護認定審査会開催予定登録3div
     * @return ResponseData<KaigoNinteiShinsakaiScheduleBatchParamter>
     */
    public ResponseData<DBE514001_ShinsakaiScheduleParameter> onClick_btnHakko(ShinsakaiScheduleHakkoDiv div) {
        FlowParameterAccessor.merge(FlowParameters.of(new RString("key"), new RString("Batch")));
        return ResponseData.of(getParamter(div)).respond();
    }

    private void setDgShinsakaiScheduleKagami(SearchResult<ShinsakaiIinJohoGoitaiBusiness> shoriDateKanri, ShinsakaiScheduleHakkoDiv div) {
        List<dgShinsakaiScheduleKagami_Row> dgShinsakaiScheduleKagamiRow = new ArrayList<>();
        for (ShinsakaiIinJohoGoitaiBusiness shinsakai : shoriDateKanri.records()) {
            dgShinsakaiScheduleKagami_Row row = new dgShinsakaiScheduleKagami_Row();
            row.setSelected(Boolean.TRUE);
            row.setShinsakaiIinCode(shinsakai.get介護認定審査会委員コード());
            row.setShinsakaiIinName(shinsakai.get介護認定審査会委員氏名());
            row.getShozokuGogitaiBango().setValue(new Decimal(shinsakai.get合議体番号()));
            row.setShozokuGogitaiMeisho(shinsakai.get合議体名称());
            row.setJusho(shinsakai.get住所());
            dgShinsakaiScheduleKagamiRow.add(row);
        }
        div.getDgShinsakaiScheduleKagami().setDataSource(dgShinsakaiScheduleKagamiRow);
    }

    private DBE514001_ShinsakaiScheduleParameter getParamter(ShinsakaiScheduleHakkoDiv div) {
        List<dgShinsakaiScheduleKagami_Row> rowList = div.getDgShinsakaiScheduleKagami().getSelectedItems();
        List<RString> 審査会委員コードリスト = new ArrayList<>();
        for (dgShinsakaiScheduleKagami_Row row : rowList) {
            審査会委員コードリスト.add(row.getShinsakaiIinCode());
        }
        RString nendoParameter = RString.EMPTY;
        RString kubun = new RString("1");
        if (div.getShinsakaiScheduleSrch().getChkShinsakaiScheduleNenkan().isAllSelected()) {
            nendoParameter = div.getShinsakaiScheduleSrch().getTxtNendo().getValue().getYear().toDateString();
            kubun = new RString("2");
        }
        return new DBE514001_ShinsakaiScheduleParameter(
                div.getShinsakaiScheduleSrch().getTxtShinsakaiKaisaiYoteiKikan().getFromValue().toDateString(),
                div.getShinsakaiScheduleSrch().getTxtShinsakaiKaisaiYoteiKikan().getToValue().toDateString(),
                nendoParameter, kubun, 審査会委員コードリスト);
    }

    private ValidationMessageControlPairs getCheck(ShinsakaiScheduleHakkoValidationHandler validationHandler) {
        ValidationMessageControlPairs validPairs = validationHandler.介護認定審査会開催予定期間入力チェック();
        if (validPairs.iterator().hasNext()) {
            return validPairs;
        }
        validPairs = validationHandler.選択チェック();
        if (validPairs.iterator().hasNext()) {
            return validPairs;
        }
        validPairs = validationHandler.印刷対象介護認定審査会委員選択チェック();
        if (validPairs.iterator().hasNext()) {
            return validPairs;
        }
        validPairs = validationHandler.年間チェック();
        if (validPairs.iterator().hasNext()) {
            return validPairs;
        }
        return validPairs;
    }
}
