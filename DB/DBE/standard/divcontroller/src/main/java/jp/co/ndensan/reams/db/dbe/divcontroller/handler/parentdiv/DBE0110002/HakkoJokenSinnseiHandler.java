/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0110002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE011001.DBE011001_ShinseiInfoPrintParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110002.HakkoJokenSinnseiDiv;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請に関する帳票発行画面クラスです
 *
 * @reamsid_L DBE-1390-050 xuyongchao
 */
public class HakkoJokenSinnseiHandler {

    private static final RString SELECT_KEY0 = new RString("key0");
    private static final RString 処理日使用 = new RString("1");
    private static final RString 申請日使用 = new RString("2");
    private static final List<RString> SELECT_LIST = new ArrayList<>();
    private final HakkoJokenSinnseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public HakkoJokenSinnseiHandler(HakkoJokenSinnseiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param 要介護認定申請モニタリストフラグ 遷移元画面から受け取った引数
     * @param 要支援認定等申請者一覧フラグ 遷移元画面から受け取った引数
     */
    public void onLoad(boolean 要介護認定申請モニタリストフラグ, boolean 要支援認定等申請者一覧フラグ) {
        SELECT_LIST.clear();
        checkPanel(要介護認定申請モニタリストフラグ, 要支援認定等申請者一覧フラグ);
        if (要介護認定申請モニタリストフラグ) {
            SELECT_LIST.add(SELECT_KEY0);
            div.getChkMonitror().setSelectedItemsByKey(SELECT_LIST);
        }
        if (要支援認定等申請者一覧フラグ) {
            SELECT_LIST.add(SELECT_KEY0);
            div.getChkShinseishaIchiran().setSelectedItemsByKey(SELECT_LIST);
        }
        SELECT_LIST.clear();
    }

    /**
     * 作成条件活性または非活性処理です。
     *
     * @param 要介護認定申請モニタリストフラグ 遷移元画面から受け取った引数
     * @param 要支援認定等申請者一覧フラグ 遷移元画面から受け取った引数
     */
    public void checkPanel(boolean 要介護認定申請モニタリストフラグ, boolean 要支援認定等申請者一覧フラグ) {
        div.getTxtMonitorShinseiYMD().clearFromValue();
        div.getTxtMonitorShinseiYMD().clearToValue();
        div.getTxtMonitorShoriYMD().clearFromValue();
        div.getTxtMonitorShoriYMD().clearToValue();
        div.getTxtShinseishaShinseiYMD().clearFromValue();
        div.getTxtShinseishaShinseiYMD().clearToValue();
        div.getTxtShinseishaShoriYMD().clearFromValue();
        div.getTxtShinseishaShoriYMD().clearToValue();

        if (要介護認定申請モニタリストフラグ) {

            div.getMonitorJoken().setIsOpen(true);
            div.getRadMonitorJoken().setDisabled(false);
            div.getRadMonitorJoken().setSelectedKey(SELECT_KEY0);
            div.getTxtMonitorShoriYMD().setDisabled(false);
            div.getTxtMonitorShinseiYMD().setDisabled(true);
        } else {
            div.getMonitorJoken().setIsOpen(false);
            div.getRadMonitorJoken().setDisabled(true);
            div.getTxtMonitorShinseiYMD().setDisabled(true);
            div.getTxtMonitorShoriYMD().setDisabled(true);
        }

        if (要支援認定等申請者一覧フラグ) {

            div.getShinseishaIchiranJoken().setIsOpen(true);
            div.getRadShinseishaJoken().setDisabled(false);
            div.getRadShinseishaJoken().setSelectedKey(SELECT_KEY0);
            div.getTxtShinseishaShoriYMD().setDisabled(false);
            div.getTxtShinseishaShinseiYMD().setDisabled(true);
        } else {
            div.getShinseishaIchiranJoken().setIsOpen(false);
            div.getRadShinseishaJoken().setDisabled(true);
            div.getTxtShinseishaShinseiYMD().setDisabled(true);
            div.getTxtShinseishaShoriYMD().setDisabled(true);
        }

    }

    /**
     * バッチ用パラメータクラスを作成します。
     *
     * @return DBE011001_ShinseiInfoPrintParameter
     */
    public DBE011001_ShinseiInfoPrintParameter setBatchParameter() {
        DBE011001_ShinseiInfoPrintParameter parameter = new DBE011001_ShinseiInfoPrintParameter();
        if (div.getChkMonitror().getSelectedKeys().contains(SELECT_KEY0)) {
            parameter.setShinseimonitorflag(true);
        } else {
            parameter.setShinseimonitorflag(false);
        }

        if (div.getChkShinseishaIchiran().getSelectedKeys().contains(SELECT_KEY0)) {
            parameter.setYokaigoyoshienseiichiranflag(true);
        } else {
            parameter.setYokaigoyoshienseiichiranflag(false);
        }

        if (div.getChkMonitror().getSelectedKeys().contains(SELECT_KEY0)) {
            if (div.getRadMonitorJoken().getSelectedKey().contains(SELECT_KEY0)) {
                parameter.setMonitorsakuseijyouken(処理日使用);
                RDateTime rDataTimeFrom = RDateTime.of(div.getTxtMonitorShoriYMD().getFromValue().toDateString(), new RString(""));
                RDateTime rDataTimeTo = RDateTime.of(div.getTxtMonitorShoriYMD().getToValue().toDateString(), new RString(""));
                parameter.setMonitorshorikaFrom(rDataTimeFrom);
                parameter.setMonitorshorikaTo(rDataTimeTo);
            } else {
                parameter.setMonitorsakuseijyouken(申請日使用);
                FlexibleDate flexibledataFrom = new FlexibleDate(div.getTxtMonitorShinseiYMD().getFromValue().toDateString());
                FlexibleDate flexibledataTo = new FlexibleDate(div.getTxtMonitorShinseiYMD().getToValue().toDateString());
                parameter.setMonitorshinnseikaFrom(flexibledataFrom);
                parameter.setMonitorshinnseikaTo(flexibledataTo);
            }
        }

        if (div.getChkShinseishaIchiran().getSelectedKeys().contains(SELECT_KEY0)) {
            if (div.getRadShinseishaJoken().getSelectedKey().contains(SELECT_KEY0)) {
                parameter.setShinseishaichiransakuseijyouken(処理日使用);
                RDateTime rDataTimeFrom = RDateTime.of(div.getTxtShinseishaShoriYMD().getFromValue().toDateString(), new RString(""));
                RDateTime rDataTimeTo = RDateTime.of(div.getTxtShinseishaShoriYMD().getToValue().toDateString(), new RString(""));
                parameter.setShinseishashorikaFrom(rDataTimeFrom);
                parameter.setShinseishashorikaTo(rDataTimeTo);
            } else {
                parameter.setShinseishaichiransakuseijyouken(申請日使用);
                FlexibleDate flexibledataFrom = new FlexibleDate(div.getTxtShinseishaShinseiYMD().getFromValue().toDateString());
                FlexibleDate flexibledataTo = new FlexibleDate(div.getTxtShinseishaShinseiYMD().getToValue().toDateString());
                parameter.setShinseishashinnseikaFrom(flexibledataFrom);
                parameter.setShinseishashinnseikaTo(flexibledataTo);
            }
        }
        return parameter;
    }
}
