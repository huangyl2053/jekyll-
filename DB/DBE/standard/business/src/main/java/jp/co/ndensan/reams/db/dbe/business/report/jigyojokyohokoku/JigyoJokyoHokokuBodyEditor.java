/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jigyojokyohokoku;

import jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku.JigyoJokyoHokokuDataChange;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jigyojokyohokoku.JigyoJokyoHokokuReportSource;

/**
 * 要介護認定事業状況報告のEditorです。
 *
 * @reamsid_L DBE-1450-100 dongyabin
 */
public class JigyoJokyoHokokuBodyEditor implements IJigyoJokyoHokokuBodyEditor {

    private final JigyoJokyoHokokuDataChange item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link JohoTeikyoShiryoItem}
     */
    protected JigyoJokyoHokokuBodyEditor(JigyoJokyoHokokuDataChange item) {
        this.item = item;
    }

    @Override
    public JigyoJokyoHokokuReportSource edit(JigyoJokyoHokokuReportSource source) {
        return editSource(source);
    }

    private JigyoJokyoHokokuReportSource editSource(JigyoJokyoHokokuReportSource source) {
        source.listJigyojokyoHokoku_1 = item.getListJigyojokyoHokoku1();
        source.listJigyojokyoHokoku_2 = item.getListJigyojokyoHokoku2();
        source.listJigyojokyoHokoku_3 = item.getListJigyojokyoHokoku3();
        source.listJigyojokyoHokoku_4 = item.getListJigyojokyoHokoku4();
        source.listJigyojokyoHokoku_5 = item.getListJigyojokyoHokoku5();
        source.listJigyojokyoHokoku_6 = item.getListJigyojokyoHokoku6();
        source.listJigyojokyoHokoku_7 = item.getListJigyojokyoHokoku7();
        source.listJigyojokyoHokoku_8 = item.getListJigyojokyoHokoku8();
        source.listJigyojokyoHokoku_9 = item.getListJigyojokyoHokoku9();
        source.listJigyojokyoHokoku_10 = item.getListJigyojokyoHokoku10();
        return source;
    }
}
