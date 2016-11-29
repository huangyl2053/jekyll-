/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD2020005;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD210010.DBD210010_KyufuSeigenTaishoshaListParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020005.KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付制限対象者一覧CSVのHandlerです。
 *
 * @reamsid_L DBD-4300-010 xuejm
 */
public class KyufuSeigenTaishoshaIchiranPanelBatchParameterHandler {

    private final KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv div;
    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private static final RString NO_1 = new RString("1");
    private static final RString NO_2 = new RString("2");
    private static final RString NO_3 = new RString("3");
    private static final RString 二号差止予告登録者 = new RString("key0");
    private static final RString 二号差止登録者 = new RString("key1");
    private static final RString 一号償還予告登録者 = new RString("key2");
    private static final RString 一号償還決定登録者 = new RString("key3");
    private static final RString 一号償還決定登録者_差止中あり = new RString("key4");
    private static final RString 一号償還決定登録者_保険料控除あり = new RString("key5");
    private static final RString 一号給付制限登録者 = new RString("key6");

    /**
     * 給付制限対象者一覧CSVコンストラクタです。
     *
     * @param div KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv
     */
    public KyufuSeigenTaishoshaIchiranPanelBatchParameterHandler(KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     */
    public void onLaod() {
        div.getTxtKijunbi().setValue(RDate.getNowDate());
        if (div.getRadKyuuhuSeigenShubetu().getSelectedKey().equals(KEY1)) {
            div.getChkKobetushitei().setDisabled(false);
            div.getChkKobetushitei().getSelectedItems().clear();
        } else {
            select_chkKobetushitei();
            div.getChkKobetushitei().setDisabled(true);
        }
        div.getCcdShuturyokujun().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200010.getReportId());
    }

    /**
     * 個給付制限種別を選択されたの処理です
     */
    public void onClick_radKyuuhuSeigenShubetu() {
        if (div.getRadKyuuhuSeigenShubetu().getSelectedKey().equals(KEY1)) {
            div.getChkKobetushitei().setDisabled(false);
            div.getChkKobetushitei().getSelectedItems().clear();
        } else {
            select_chkKobetushitei();
            div.getChkKobetushitei().setDisabled(true);
        }
    }

    /**
     * バッチパラメータを設定します。
     *
     * @param div KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv
     * @param parameter DBD210010_KyufuSeigenTaishoshaListParameter
     */
    public void onClick_btnBatchExecute(KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv div,
            DBD210010_KyufuSeigenTaishoshaListParameter parameter) {
        if (div.getRadKyuuhuSeigenShubetu().getSelectedKey().equals(KEY1)) {
            List<RString> keys = div.getChkKobetushitei().getSelectedKeys();
            parameter.set二号差止予告登録者(keys.contains(二号差止予告登録者));
            parameter.set二号差止登録者(keys.contains(二号差止登録者));
            parameter.set一号償還予告登録者(keys.contains(一号償還予告登録者));
            parameter.set一号償還決定登録者(keys.contains(一号償還決定登録者));
            parameter.set一号償還決定登録者_保険料控除あり(keys.contains(一号償還決定登録者_保険料控除あり));
            parameter.set一号償還決定登録者_差止中あり(keys.contains(一号償還決定登録者_差止中あり));
            parameter.set一号給付制限登録者(keys.contains(一号給付制限登録者));
        } else {
            parameter.set二号差止予告登録者(true);
            parameter.set二号差止登録者(true);
            parameter.set一号償還予告登録者(true);
            parameter.set一号償還決定登録者(true);
            parameter.set一号償還決定登録者_保険料控除あり(true);
            parameter.set一号償還決定登録者_差止中あり(true);
            parameter.set一号給付制限登録者(true);
        }
        if (div.getCcdShuturyokujun().getSelected出力順() != null) {
            parameter.set出力順設定リスト(div.getCcdShuturyokujun().getSelected出力順().get出力順ID());
        }
        if (div.getRadKyuuhuSeigenJoutai().getSelectedKey().equals(KEY0)) {
            parameter.set給付制限状態(NO_1);
        } else if (div.getRadKyuuhuSeigenJoutai().getSelectedKey().equals(KEY1)) {
            parameter.set給付制限状態(NO_2);
        } else {
            parameter.set給付制限状態(NO_3);
        }
        parameter.set基準日(div.getTxtKijunbi().getValue().toDateString());
    }

    private void select_chkKobetushitei() {
        List<RString> keys = new ArrayList<>();
        keys.add(二号差止予告登録者);
        keys.add(二号差止登録者);
        keys.add(一号償還予告登録者);
        keys.add(一号償還決定登録者);
        keys.add(一号償還決定登録者_差止中あり);
        keys.add(一号償還決定登録者_保険料控除あり);
        keys.add(一号給付制限登録者);
        div.getChkKobetushitei().setSelectedItemsByKey(keys);
    }
}
