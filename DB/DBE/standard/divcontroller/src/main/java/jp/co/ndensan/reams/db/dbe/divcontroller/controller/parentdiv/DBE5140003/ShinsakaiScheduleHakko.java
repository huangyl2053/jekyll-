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
    private final RString 帳票出力区分1 = new RString("1");
    private final RString 帳票出力区分2 = new RString("2");
    private final RString 帳票出力区分3 = new RString("3");
    private final RString 帳票出力区分4 = new RString("4");
    private final RString スケジュール表 = new RString("key0");
    private final RString スケジュール表_年間 = new RString("key1");

    /**
     * 画面初期化処理です。
     *
     * @param div 介護認定審査会開催予定登録3div
     * @return ResponseData<ShinsakaiScheduleHakkoDiv>
     */
    public ResponseData<ShinsakaiScheduleHakkoDiv> onLoad(ShinsakaiScheduleHakkoDiv div) {
        div.getShinsakaiScheduleSrch().getRadPrintType().clearSelectedItem();
        div.getShinsakaiScheduleSrch().getTxtShinsakaiKaisaiYoteiKikan().clearFromValue();
        div.getShinsakaiScheduleSrch().getTxtShinsakaiKaisaiYoteiKikan().clearToValue();
        div.getShinsakaiScheduleSrch().getSchedulePrintOption().getTxtNendo().clearValue();
        div.getShinsakaiScheduleSrch().getChkShinsakaiScheduleKagami().setReadOnly(true);
        div.getShinsakaiScheduleSrch().getTxtNendo().setDisabled(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 開催予定期間を変更した際に実行します。
     *
     * @param div 介護認定審査会開催予定登録div
     * @return ResponseData<ShinsakaiScheduleHakkoDiv>
     */
    public ResponseData<ShinsakaiScheduleHakkoDiv> onChange_TxtShinsakaiKaisaiYoteiKikan(ShinsakaiScheduleHakkoDiv div) {
        RString 帳票種類 = div.getShinsakaiScheduleSrch().getRadPrintType().getSelectedKey();
        setShinsakaiIinIchiran(div, 帳票種類);
        return ResponseData.of(div).respond();
    }

    /**
     * 印刷帳票を選択したときに実行します。
     *
     * @param div 介護認定審査会開催予定登録div
     * @return ResponseData<ShinsakaiScheduleHakkoDiv>
     */
    public ResponseData<ShinsakaiScheduleHakkoDiv> onClick_radPrintType(ShinsakaiScheduleHakkoDiv div) {
        RString 帳票種類 = div.getShinsakaiScheduleSrch().getRadPrintType().getSelectedKey();
        if (!RString.isNullOrEmpty(帳票種類)) {
            if (スケジュール表.equals(帳票種類)) {
                setShinsakaiIinIchiran(div, 帳票種類);
                div.getShinsakaiScheduleSrch().getSchedulePrintOption().getTxtNendo().clearValue();
                div.getShinsakaiScheduleSrch().getSchedulePrintOption().getTxtNendo().setDisabled(true);
                div.getShinsakaiScheduleSrch().getSchedulePrintOption().getChkShinsakaiScheduleKagami().setReadOnly(false);
            } else if (スケジュール表_年間.equals(帳票種類)) {
                List<dgShinsakaiScheduleKagami_Row> dgShinsakaiScheduleKagamiRow = new ArrayList<>();
                div.getDgShinsakaiScheduleKagami().setDataSource(dgShinsakaiScheduleKagamiRow);
                div.getShinsakaiScheduleSrch().getTxtShinsakaiKaisaiYoteiKikan().clearFromValue();
                div.getShinsakaiScheduleSrch().getTxtShinsakaiKaisaiYoteiKikan().clearToValue();
                div.getDgShinsakaiScheduleKagami().setVisible(false);
                div.getShinsakaiScheduleSrch().getSchedulePrintOption().getChkShinsakaiScheduleKagami().getSelectedItems().clear();
                div.getShinsakaiScheduleSrch().getSchedulePrintOption().getTxtNendo().setDisabled(false);
                div.getShinsakaiScheduleSrch().getSchedulePrintOption().getChkShinsakaiScheduleKagami().setReadOnly(true);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 開催予定期間が入力されたとき実行されます。
     *
     * @param div 介護認定審査会開催予定登録div
     * @param 帳票種類 RString
     */
    private void setShinsakaiIinIchiran(ShinsakaiScheduleHakkoDiv div, RString 帳票種類) {
        if (div.getShinsakaiScheduleSrch().getTxtShinsakaiKaisaiYoteiKikan().getFromValue() != null
                && div.getShinsakaiScheduleSrch().getTxtShinsakaiKaisaiYoteiKikan().getToValue() != null
                && スケジュール表.equals(帳票種類)) {
            List<dgShinsakaiScheduleKagami_Row> dgShinsakaiScheduleKagamiRow = new ArrayList<>();
            div.getDgShinsakaiScheduleKagami().setDataSource(dgShinsakaiScheduleKagamiRow);
            RString 開催予定期間From = new RString(div.getShinsakaiScheduleSrch().getTxtShinsakaiKaisaiYoteiKikan().getFromValue().toString());
            RString 開催予定期間To = new RString(div.getShinsakaiScheduleSrch().getTxtShinsakaiKaisaiYoteiKikan().getToValue().toString());
            ShinsakaiiinJohoManager shinsakaiiinJohoManager = InstanceProvider.create(ShinsakaiiinJohoManager.class);
            SearchResult<ShinsakaiIinJohoGoitaiBusiness> shoriDateKanri = shinsakaiiinJohoManager.search審査会委員情報(開催予定期間From, 開催予定期間To);
            setDgShinsakaiScheduleKagami(shoriDateKanri, div);
            div.getDgShinsakaiScheduleKagami().setVisible(true);
        }
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
        RString kubun = 帳票出力区分1;
        if (スケジュール表_年間.equals(div.getShinsakaiScheduleSrch().getRadPrintType().getSelectedKey())) {
            nendoParameter = div.getShinsakaiScheduleSrch().getSchedulePrintOption().getTxtNendo().getValue().getYear().toDateString();
            kubun = 帳票出力区分2;
        } else if (スケジュール表.equals(div.getShinsakaiScheduleSrch().getRadPrintType().getSelectedKey())
                && !div.getShinsakaiScheduleSrch().getSchedulePrintOption().getChkShinsakaiScheduleKagami().isAllSelected()) {
            kubun = 帳票出力区分3;
        } else if (!スケジュール表.equals(div.getShinsakaiScheduleSrch().getRadPrintType().getSelectedKey())
                && div.getShinsakaiScheduleSrch().getSchedulePrintOption().getChkShinsakaiScheduleKagami().isAllSelected()) {
            kubun = 帳票出力区分4;
        }
        RString From期間 = null;
        RString To期間 = null;
        if (div.getShinsakaiScheduleSrch().getTxtShinsakaiKaisaiYoteiKikan().getFromValue() != null) {
            From期間 = div.getShinsakaiScheduleSrch().getTxtShinsakaiKaisaiYoteiKikan().getFromValue().toDateString();
        }
        if (div.getShinsakaiScheduleSrch().getTxtShinsakaiKaisaiYoteiKikan().getToValue() != null) {
            To期間 = div.getShinsakaiScheduleSrch().getTxtShinsakaiKaisaiYoteiKikan().getToValue().toDateString();
        }
        return new DBE514001_ShinsakaiScheduleParameter(
                From期間,
                To期間,
                nendoParameter, kubun, 審査会委員コードリスト);
    }

    private ValidationMessageControlPairs getCheck(ShinsakaiScheduleHakkoValidationHandler validationHandler) {

        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(validationHandler.選択チェック());
        validPairs.add(validationHandler.印刷対象介護認定審査会委員選択チェック());
        validPairs.add(validationHandler.年間チェック());
        validPairs.add(validationHandler.審査会開催予定期間入力チェック());
        return validPairs;
    }
}
