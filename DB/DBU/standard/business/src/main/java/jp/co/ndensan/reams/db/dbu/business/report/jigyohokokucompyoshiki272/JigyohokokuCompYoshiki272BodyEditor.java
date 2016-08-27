/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki272;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki272.JigyohokokuCompYoshiki272Change;
import jp.co.ndensan.reams.db.dbu.entity.report.ｊigyohokokucompyoshiki272.JigyohokokuCompYoshiki272ReportSource;

/**
 * 介護事業状況報告月報・保険給付決定状況（様式2-7） のBodyEditorです。
 *
 * @reamsid_L DBU-5590-050 wanghuafeng
 */
public class JigyohokokuCompYoshiki272BodyEditor implements IJigyohokokuCompYoshiki272Editor {

    private final JigyohokokuCompYoshiki272Change change;

    /**
     * インスタンスを生成します。
     *
     * @param change JigyohokokuCompYoshiki272Change
     */
    protected JigyohokokuCompYoshiki272BodyEditor(JigyohokokuCompYoshiki272Change change) {
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
        source.listUpper_1 = change.getListUpper_1();
        source.listLower_1 = change.getListLower_1();
        return source;
    }

}
