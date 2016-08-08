/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki272;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki272.JigyohokokuCompYoshiki272Change;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki272.JigyohokokuCompYoshiki272Entity;
import jp.co.ndensan.reams.db.dbu.entity.report.ｊigyohokokucompyoshiki272.JigyohokokuCompYoshiki272ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 介護事業状況報告月報・保険給付決定状況（様式2-7） のレーポトです。
 *
 * @reamsid_L DBU-5590-050 wanghuafeng
 */
public class JigyohokokuCompYoshiki272Editor implements IJigyohokokuCompYoshiki272Editor {

    private final JigyohokokuCompYoshiki272Entity data;
    private final JigyohokokuCompYoshiki272Change change;
    private static final RString 月報 = new RString("1");
    private static final RString 年報 = new RString("2");

    /**
     * インスタンスを生成します。
     *
     * @param data JigyohokokuCompYoshiki272Entity
     * @param change JigyohokokuCompYoshiki272Change
     */
    protected JigyohokokuCompYoshiki272Editor(JigyohokokuCompYoshiki272Entity data, JigyohokokuCompYoshiki272Change change) {
        this.data = data;
        this.change = change;
    }

    /**
     * レーポトソースのエディトです
     *
     * @param source JigyohokokuCompYoshiki2_7_2ReportSource
     * @return JigyohokokuCompYoshiki2_7_2ReportSource
     */
    @Override
    public JigyohokokuCompYoshiki272ReportSource edit(JigyohokokuCompYoshiki272ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshiki272ReportSource editSource(JigyohokokuCompYoshiki272ReportSource source) {
        source.printTimeStamp = data.get作成日時();
        source.shukeiKubun = data.get年報月報区分();
        source.shuukeiHani = set集計範囲(data);
        source.hokenshaNo = data.get保険者番号();
        source.hokenshaName = data.get保険者名();
        source.listUpper_1 = change.getListUpper_1();
        source.listLower_1 = change.getListLower_1();
        return source;
    }

    private RString set集計範囲(JigyohokokuCompYoshiki272Entity data) {
        RStringBuilder 集計範囲_SB = new RStringBuilder();
        if (月報.equals(data.get年報月報区分())) {
            集計範囲_SB.append("（");
            集計範囲_SB.append(data.get集計年月());
            集計範囲_SB.append("分）");
        }
        if (年報.equals(data.get年報月報区分())) {
            集計範囲_SB.append("（");
            集計範囲_SB.append(data.get集計年度());
            集計範囲_SB.append("分）");
            集計範囲_SB.append(data.get集計期間FROM());
            集計範囲_SB.append(" ～ ");
            集計範囲_SB.append(data.get集計期間TO());
        }
        return 集計範囲_SB.toRString();
    }

}
