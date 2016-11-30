/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5720001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD572001.DBD572001_JukyushaDaichoIdoCheckListParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5720001.JyukyushaDaichoIdoCheckListDiv;
import jp.co.ndensan.reams.db.dbd.service.core.jyukyushadaichoidodhecklist.JyukyushaDaichoIdoCheckListManager;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 受給者台帳異動チェックリスト画面のHandlerクラスです。
 *
 * @reamsid_L DBD-1770-010 donghj
 */
public class JyukyushaDaichoIdoCheckListHandler {

    private final JyukyushaDaichoIdoCheckListDiv div;
    private final RString rString = new RString("0:00:00");

    /**
     *
     * @param div JyukyushaDaichoIdoCheckListDiv
     */
    public JyukyushaDaichoIdoCheckListHandler(JyukyushaDaichoIdoCheckListDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     */
    public void onLoad() {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村セキュリティ情報 != null) {
            LasdecCode 市町村コード = 市町村セキュリティ情報.get市町村情報().get市町村コード();
            JyukyushaDaichoIdoCheckListManager manager = JyukyushaDaichoIdoCheckListManager.createInstance();
            ShoriDateKanri shoriDateKanri = manager.get対象期間前回(SubGyomuCode.DBD介護受給,
                    市町村コード, new RString("異動チェックリスト"), new RString("0001"), new FlexibleYear("0000"));
            if (shoriDateKanri != null) {
                div.getJhokenPancel().getTxtRangeZenkai().setFromDateValue(
                        new RDate(shoriDateKanri.get対象開始年月日().toString()));
                div.getJhokenPancel().getTxtRangeZenkai().setFromTimeValue(new RTime(shoriDateKanri.get対象開始日時().
                        getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
                div.getJhokenPancel().getTxtRangeZenkai().setToDateValue(
                        new RDate(shoriDateKanri.get対象終了年月日().toString()));
                div.getJhokenPancel().getTxtRangeZenkai().setToTimeValue(new RTime(shoriDateKanri.get対象終了日時().
                        getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
            }
            if (div.getJhokenPancel().getTxtRangeZenkai().getToDateValue() != null) {
                div.getJhokenPancel().getTxtRangeKonkai().setFromDateValue(
                        div.getJhokenPancel().getTxtRangeZenkai().getToDateValue());
            }
            if (div.getJhokenPancel().getTxtRangeZenkai().getToTimeValue() != null) {
                div.getJhokenPancel().getTxtRangeKonkai().setFromTimeValue(
                        div.getJhokenPancel().getTxtRangeZenkai().getToTimeValue().plusSeconds(1));
            }
        }

        RDateTime rDate = RDate.getNowDateTime();
        div.getJhokenPancel().getTxtRangeKonkai().setToDateValue(new RDate(rDate.getDate().toString()));
        div.getJhokenPancel().getTxtRangeKonkai().setToTimeValue(new RTime(rDate.getTime().
                toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
        div.getCcdShutsuryokujun().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200037.getReportId());

    }

    /**
     * 画面側からバッチパラメータを取得します。
     *
     * @return JyukyushaDaichoIdoCheckListParameter
     */
    public DBD572001_JukyushaDaichoIdoCheckListParameter getParameter() {
        DBD572001_JukyushaDaichoIdoCheckListParameter parameter = new DBD572001_JukyushaDaichoIdoCheckListParameter();
        parameter.set今回抽出開始年月日(div.getJhokenPancel().getTxtRangeKonkai().getFromDateValue());
        if (div.getJhokenPancel().getTxtRangeKonkai().getFromDateValue() != null
                && div.getJhokenPancel().getTxtRangeKonkai().getFromTimeValue() == null) {
            parameter.set今回抽出開始時分秒(new RTime(rString));
        } else {
            parameter.set今回抽出開始時分秒(div.getJhokenPancel().getTxtRangeKonkai().getFromTimeValue());
        }
        parameter.set今回抽出終了年月日(div.getJhokenPancel().getTxtRangeKonkai().getToDateValue());

        if (div.getJhokenPancel().getTxtRangeKonkai().getToDateValue() != null
                && div.getJhokenPancel().getTxtRangeKonkai().getToTimeValue() == null) {
            parameter.set今回抽出終了時分秒(new RTime(rString));
        } else {
            parameter.set今回抽出終了時分秒(div.getJhokenPancel().getTxtRangeKonkai().getToTimeValue());
        }
        parameter.set出力対象(div.getDdlShuturtokuTaisho().getSelectedValue());
        if (div.getCcdShutsuryokujun().getSelected出力順() != null) {
            parameter.set出力順ID(div.getCcdShutsuryokujun().getSelected出力順().get出力順ID());
        }

        return parameter;
    }

}
