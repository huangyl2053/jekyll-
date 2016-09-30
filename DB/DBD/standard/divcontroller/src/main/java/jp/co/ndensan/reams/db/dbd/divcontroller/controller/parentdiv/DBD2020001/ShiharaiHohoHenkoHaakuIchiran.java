/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD2020001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD207011.DBD207011_ShiharaiHohoHenkoTainoshaHaakuListParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020001.ShiharaiHohoHenkoHakuListMainDiv;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * ビジネス設計_DBDBZ32001_1_支払方法変更滞納者把握リスト（画面）クラスです．
 *
 * @reamsid_L DBD-3650-030 x_lilh
 */
public class ShiharaiHohoHenkoHaakuIchiran {

    private static final RString SELECTED_VALUE = new RString("0");
    private static final RString UN_SELECTED_VALUE = new RString("1");
    private static final ReportId REPORTID = new ReportId("DBD200006_ShiharaiHohoHenkoHaakuIchiran");

    /**
     * コンストラクタです。
     */
    public ShiharaiHohoHenkoHaakuIchiran() {
    }

    /**
     * 支払方法変更滞納者把握リスト（画面）バッチパラメターを取得します．
     *
     * @param div ShiharaiHohoHenkoHakuListMainDiv
     * @return 支払方法変更滞納者把握リスト（画面）バッチパラメター
     */
    public DBD207011_ShiharaiHohoHenkoTainoshaHaakuListParameter createShiharaiHohoHenkoHaakuIchiranParameter(ShiharaiHohoHenkoHakuListMainDiv div) {
        DBD207011_ShiharaiHohoHenkoTainoshaHaakuListParameter parameter = new DBD207011_ShiharaiHohoHenkoTainoshaHaakuListParameter();
        parameter.setKijunYMD(div.getChushutsuJoken().getTxtKijunYMD().getValue());
        if (!div.getRadHihokenshaAll().getSelectedKey().isNullOrEmpty()) {
            parameter.setHihokenshaAll(SELECTED_VALUE);
        } else {
            parameter.setHihokenshaAll(UN_SELECTED_VALUE);
        }
        parameter.setTainoKikanHihokenshaAll(get滞納期間(div.getTxtTainoKikanHihokenshaAll().getValue()));
        parameter.setJukyushaAll(isCheckedValue(div.getChkJukyushaAll().getSelectedValues()));
        parameter.setTainoKikanJukyushaAll(get滞納期間(div.getTxtTainoKikanJukyushaAll().getValue()));

        parameter.setNinteiShinseisha(isCheckedValue(div.getChkNinteiShinseisha().getSelectedValues()));
        parameter.setTainoKikanNinteiShinseisha(get滞納期間(div.getTxtTainoKikanNinteiShinseisha().getValue()));

        parameter.setNinteiYMD(isCheckedValue(div.getChkNinteiYMD().getSelectedValues()));
        parameter.setTainoKikanNinteiYMD(get滞納期間(div.getTxtTainoKikanNinteiYMD().getValue()));
        parameter.setNinteiDateFrom(div.getTxtNinteiDateFrom().getValue());
        parameter.setNinteiYMDTo(div.getTxtNinteiYMDTo().getValue());

        parameter.setShokanShinseisha(isCheckedValue(div.getChkShokanShinseisha().getSelectedValues()));
        parameter.setTainoKikanShokanShinseisha(get滞納期間(div.getTxtTainoKikanShokanShinseisha().getValue()));

        parameter.setShokanKetteiYMD(isCheckedValue(div.getChkShokanKetteiYMD().getSelectedValues()));
        parameter.setTainoKikanShokanKettei(get滞納期間(div.getTxtTainoKikanShokanKettei().getValue()));
        parameter.setShokanKetteiYMDFrom(div.getTxtShokanKetteiYMDFrom().getValue());
        parameter.setShokanKetteiYMDTo(div.getTxtShokanKetteiYMDTo().getValue());
        parameter.setTab(div.getCcdChohyoShutsuryokujun().get出力順ID());
        parameter.setReportId(REPORTID);
        parameter.setReportTypeId(REPORTID);
        parameter.setReportCreateDateTime(RDateTime.now());
        return parameter;
    }

    private RString isCheckedValue(List<RString> isSelectedList) {
        if (isSelectedList != null && !isSelectedList.isEmpty()) {
            return SELECTED_VALUE;
        }
        return UN_SELECTED_VALUE;
    }

    private int get滞納期間(Decimal value) {
        if (value == null) {
            return Integer.parseInt(SELECTED_VALUE.toString());
        }
        return value.intValue();
    }
}
