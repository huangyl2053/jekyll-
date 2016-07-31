/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki152;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki152.JigyohokokuCompYoshiki152Data;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki152.JigyohokokuCompYoshiki152ReportSource;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.hokenshajoho.HokenshaJohoConfig;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 介護事業状況報告月報・一般状況（様式1-5）_新様式のEditorです。
 *
 * @reamsid_L DBU-5540-050 dangjingjing
 */
public class JigyohokokuCompYoshiki152Editor implements IJigyohokokuCompYoshiki152Editor {

    private final JigyohokokuCompYoshiki152Data data;

    /**
     * インスタンスを生成します。
     *
     * @param data JigyohokokuCompYoshiki152Data
     */
    protected JigyohokokuCompYoshiki152Editor(JigyohokokuCompYoshiki152Data data) {
        this.data = data;
    }

    @Override
    public JigyohokokuCompYoshiki152ReportSource edit(JigyohokokuCompYoshiki152ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshiki152ReportSource editSource(JigyohokokuCompYoshiki152ReportSource source) {
        HokenshaJohoConfig hokenshaJohoConfig = new HokenshaJohoConfig();
        source.printTimeStamp = data.get処理日時();
        source.shukeiKubun = data.get集計区分();
        source.shuukeiHani = set集計範囲(data.get集計範囲());
        if (hokenshaJohoConfig.get保険者番号() != null) {
            source.hokenshaNo = hokenshaJohoConfig.get保険者番号().value();
        }
        source.kyufuKubun = data.get給付実績区分コード();
        if (hokenshaJohoConfig.get保険者名() != null) {
            source.hokenshaName = hokenshaJohoConfig.get保険者名().value();
        }
        return source;
    }

    private RString set集計範囲(RString 年報月報区分) {
        RStringBuilder 集計範囲 = new RStringBuilder();
        if (new RString("1").equals(年報月報区分)) {
            集計範囲.append(data.get集計年月());
        } else if (new RString("2").equals(年報月報区分)) {
            集計範囲.append(data.get集計期間FROM());
            集計範囲.append("~");
            集計範囲.append(data.get集計期間TO());
        }
        return 集計範囲.toRString();
    }
}
