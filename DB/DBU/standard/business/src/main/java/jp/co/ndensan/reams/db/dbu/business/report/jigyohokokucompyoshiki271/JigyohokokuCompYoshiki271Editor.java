/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki271;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki271.JigyohokokuCompYoshiki271Change;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki271.JigyohokokuCompYoshiki271Data;
import jp.co.ndensan.reams.db.dbu.entity.report.ｊigyohokokucompyoshiki271.JigyohokokuCompYoshiki271ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 介護事業状況報告月報・保険給付決定状況（様式2-7-1）のEditorクラスです。
 *
 * @reamsid_L DBU-5580-040　wanghuafeng
 */
public class JigyohokokuCompYoshiki271Editor implements IJigyohokokuCompYoshiki271Editor {

    private final JigyohokokuCompYoshiki271Data data;
    private final JigyohokokuCompYoshiki271Change change;

    /**
     * インスタンスを生成します。
     *
     * @param data JigyohokokuCompYoshiki271Data
     * @param change JigyohokokuCompYoshiki271Change
     */
    protected JigyohokokuCompYoshiki271Editor(JigyohokokuCompYoshiki271Data data, JigyohokokuCompYoshiki271Change change) {
        this.data = data;
        this.change = change;
    }

    /**
     * レーポトソースのエディトです
     *
     * @param source JigyohokokuCompYoshiki271ReportSource
     * @return JigyohokokuCompYoshiki271ReportSource
     */
    @Override
    public JigyohokokuCompYoshiki271ReportSource edit(JigyohokokuCompYoshiki271ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshiki271ReportSource editSource(JigyohokokuCompYoshiki271ReportSource source) {

        source.printTimeStamp = data.get作成日時();
        source.shukeiKubun = data.get年報月報区分();
        source.shuukeiHani = set範囲(data.get集計年月());
        source.hokenshaNo = data.get保険者番号();
        source.hokenshaName = data.get保険者名();
        source.listUpper_1 = change.getListUpper_1();
        source.listUpper_2 = change.getListUpper_2();
        source.listUpper_3 = change.getListUpper_3();
        source.listLower_1 = change.getListLower_1();
        source.listLower_2 = change.getListLower_2();
        source.listLower_3 = change.getListLower_3();
        return source;
    }

    private RString set範囲(RString 集計範囲) {
        RStringBuilder 範囲_SB = new RStringBuilder();
        範囲_SB.append("（" + 集計範囲 + "分）");
        return 範囲_SB.toRString();
    }

}
