/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki153;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki153.JigyohokokuCompYoshiki153Variables;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki153.JigyohokokuCompYoshiki153ReportSource;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.hokenshajoho.HokenshaJohoConfig;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 介護事業状況報告月報・一般状況（様式1-5）のReportSourceクラスです。
 *
 * @reamsid_L DBU-5550-050 dangjingjing
 */
public class JigyohokokuCompYoshiki153Editor implements IJigyohokokuCompYoshiki153Editor {

    private final JigyohokokuCompYoshiki153Variables variables;

    /**
     * インスタンスを生成します。
     *
     * @param variables JigyohokokuCompYoshiki153Variables
     */
    protected JigyohokokuCompYoshiki153Editor(JigyohokokuCompYoshiki153Variables variables) {
        this.variables = variables;
    }

    @Override
    public JigyohokokuCompYoshiki153ReportSource edit(JigyohokokuCompYoshiki153ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshiki153ReportSource editSource(JigyohokokuCompYoshiki153ReportSource source) {
        HokenshaJohoConfig hokenshaJohoConfig = new HokenshaJohoConfig();
        source.printTimeStamp = variables.get処理日時();
        source.shukeiKubun = set集計範囲(variables.get年報月報区分());
        source.shuukeiHani = variables.get集計期間FROM();
        source.shuukeiHani = variables.get集計期間TO();
        source.shuukeiHani = variables.get集計年月();
        if (hokenshaJohoConfig.get保険者番号() != null) {
            source.hokenshaNo = hokenshaJohoConfig.get保険者番号().value();
        }
        source.kyufuKubun = variables.get給付実績区分コード();

        if (hokenshaJohoConfig.get保険者名() != null) {
            source.hokenshaName = hokenshaJohoConfig.get保険者名().value();
        }
        return source;
    }

    private RString set集計範囲(RString 年報月報区分) {
        RStringBuilder 集計範囲 = new RStringBuilder();
        if (new RString("1").equals(年報月報区分)) {
            集計範囲.append(variables.get集計年月());
        } else if (new RString("2").equals(年報月報区分)) {
            集計範囲.append(variables.get集計期間FROM());
            集計範囲.append(new RString("~"));
            集計範囲.append(variables.get集計期間TO());
        }
        return 集計範囲.toRString();
    }
}
