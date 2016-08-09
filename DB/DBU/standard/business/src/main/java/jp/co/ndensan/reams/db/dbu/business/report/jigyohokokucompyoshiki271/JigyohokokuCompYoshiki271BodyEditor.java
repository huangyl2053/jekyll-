/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki271;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki271.JigyohokokuCompYoshiki271Change;
import jp.co.ndensan.reams.db.dbu.entity.report.ｊigyohokokucompyoshiki271.JigyohokokuCompYoshiki271ReportSource;

/**
 * 介護事業状況報告月報・保険給付決定状況（様式2-7-1）のEditorクラスです。
 *
 * @reamsid_L DBU-5580-040　wanghuafeng
 */
public class JigyohokokuCompYoshiki271BodyEditor implements IJigyohokokuCompYoshiki271Editor {

    private final JigyohokokuCompYoshiki271Change change;

    /**
     * インスタンスを生成します。
     *
     * @param change JigyohokokuCompYoshiki271Change
     */
    protected JigyohokokuCompYoshiki271BodyEditor(JigyohokokuCompYoshiki271Change change) {
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
        source.listUpper_1 = change.getListUpper_1();
        source.listUpper_2 = change.getListUpper_2();
        source.listUpper_3 = change.getListUpper_3();
        source.listLower_1 = change.getListLower_1();
        source.listLower_2 = change.getListLower_2();
        source.listLower_3 = change.getListLower_3();
        return source;
    }

}
