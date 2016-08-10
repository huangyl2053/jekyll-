/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5720001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd5720001.JyukyushaDaichoIdoCheckListParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5720001.JyukyushaDaichoIdoCheckListDiv;
import jp.co.ndensan.reams.db.dbd.service.core.jyukyushadaichoidodhecklist.JyukyushaDaichoIdoCheckListManager;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
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
            JyukyushaDaichoIdoCheckListManager jyukyushaDaichoIdoCheckListManager
                    = JyukyushaDaichoIdoCheckListManager.createInstance();
            ShoriDateKanri shoriDateKanri = jyukyushaDaichoIdoCheckListManager.get対象期間前回(SubGyomuCode.DBD介護受給,
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
            } else {
                div.getJhokenPancel().getTxtRangeZenkai().setFromDateValue(null);
                div.getJhokenPancel().getTxtRangeZenkai().setFromTimeValue(null);
                div.getJhokenPancel().getTxtRangeZenkai().setToDateValue(null);
                div.getJhokenPancel().getTxtRangeZenkai().setToTimeValue(null);
            }
        } else {
            div.getJhokenPancel().getTxtRangeZenkai().setFromDateValue(null);
            div.getJhokenPancel().getTxtRangeZenkai().setFromTimeValue(null);
            div.getJhokenPancel().getTxtRangeZenkai().setToDateValue(null);
            div.getJhokenPancel().getTxtRangeZenkai().setToTimeValue(null);
        }

        if (div.getJhokenPancel().getTxtRangeZenkai().getFromDateValue() == null
                || div.getJhokenPancel().getTxtRangeZenkai().getFromDateValue().toDateString().isEmpty()) {
            div.getJhokenPancel().getTxtRangeKonkai().clearFromDateValue();
        } else {
            div.getJhokenPancel().getTxtRangeKonkai().setFromDateValue(div.getJhokenPancel().getTxtRangeZenkai().getFromDateValue());
        }
        if (div.getJhokenPancel().getTxtRangeZenkai().getFromTimeValue() == null
                || div.getJhokenPancel().getTxtRangeZenkai().getFromTimeValue().toString().isEmpty()) {
            div.getJhokenPancel().getTxtRangeKonkai().clearFromTimeValue();
        } else {
            div.getJhokenPancel().getTxtRangeKonkai().setFromTimeValue(div.getJhokenPancel().getTxtRangeZenkai().getFromTimeValue().plusSeconds(1));
        }

        RDateTime rDate = RDate.getNowDateTime();
        div.getJhokenPancel().getTxtRangeKonkai().setToDateValue(new RDate(rDate.getDate().toString()));
        div.getJhokenPancel().getTxtRangeKonkai().setToTimeValue(new RTime(rDate.getTime().
                toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
        ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBD介護受給,
                ReportIdDBD.DBD200037.getReportId());

    }

    /**
     * 画面側からバッチパラメータを取得します。
     *
     * @return JyukyushaDaichoIdoCheckListParameter
     */
    public JyukyushaDaichoIdoCheckListParameter getParameter() {
        JyukyushaDaichoIdoCheckListParameter parameter = new JyukyushaDaichoIdoCheckListParameter();
        parameter.set今回抽出開始年月日(div.getJhokenPancel().getTxtRangeKonkai().getFromDateValue());
        parameter.set今回抽出開始時分秒(div.getJhokenPancel().getTxtRangeKonkai().getFromTimeValue());
        if (div.getJhokenPancel().getTxtRangeKonkai().getFromDateValue() != null
                && div.getJhokenPancel().getTxtRangeKonkai().getFromTimeValue() == null) {
            parameter.set今回抽出開始時分秒(new RTime(new RString("0:00:00")));
        }
        parameter.set今回抽出終了年月日(div.getJhokenPancel().getTxtRangeKonkai().getToDateValue());
        parameter.set今回抽出終了時分秒(div.getJhokenPancel().getTxtRangeKonkai().getToTimeValue());
        if (div.getJhokenPancel().getTxtRangeKonkai().getToDateValue() != null
                && div.getJhokenPancel().getTxtRangeKonkai().getToTimeValue() == null) {
            parameter.set今回抽出終了時分秒(new RTime(new RString("0:00:00")));
        }
        if (div.getDdlShuturtokuTaisho().getSelectedValue().equals(ShuturtokuTaishoDDL.全て.get名称())) {
            parameter.set出力対象(ShuturtokuTaishoDDL.全て.get名称());
        } else if (div.getDdlShuturtokuTaisho().getSelectedValue().equals(ShuturtokuTaishoDDL.申請者異動以外全て.get名称())) {
            parameter.set出力対象(ShuturtokuTaishoDDL.申請者異動以外全て.get名称());
        } else if (div.getDdlShuturtokuTaisho().getSelectedValue().equals(ShuturtokuTaishoDDL.申請者異動のみ.get名称())) {
            parameter.set出力対象(ShuturtokuTaishoDDL.申請者異動のみ.get名称());
        }
        parameter.set出力順ID(div.getCcdShutsuryokujun().get出力順ID());
        return parameter;
    }

    /**
     * 出力対象DDLのenumクラスです。
     */
    private enum ShuturtokuTaishoDDL {

        /**
         * 全て
         */
        全て(new RString("0"), new RString("全て")),
        /**
         * 申請者異動以外全て
         */
        申請者異動以外全て(new RString("1"), new RString("申請者異動以外全て")),
        /**
         * 申請者異動のみ
         */
        申請者異動のみ(new RString("2"), new RString("申請者異動のみ"));

        private final RString code;
        private final RString shuturtokuTaisho;

        ShuturtokuTaishoDDL(RString code, RString shuturtokuTaisho) {
            this.code = code;
            this.shuturtokuTaisho = shuturtokuTaisho;
        }

        /**
         * 出力対象DDLLコードを返す。
         *
         * @return 出力対象DDLコード
         */
        public RString getコード() {
            return code;
        }

        /**
         * 出力対象DDL名称を返す。
         *
         * @return 出力対象DDL名称
         */
        public RString get名称() {
            return shuturtokuTaisho;
        }

    }

}
