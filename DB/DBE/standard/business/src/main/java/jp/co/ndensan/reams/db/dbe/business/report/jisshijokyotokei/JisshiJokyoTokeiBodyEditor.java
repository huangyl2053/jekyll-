/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jisshijokyotokei;

import jp.co.ndensan.reams.db.dbe.business.core.jisshijokyotokei.JisshiJokyoTokeiDataChange;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jisshijokyotokei.JisshiJokyoTokeiReportSource;

/**
 * 要介護認定実施状況統計のEditorです。
 *
 * @reamsid_L DBE-1450-040 dongyabin
 */
public class JisshiJokyoTokeiBodyEditor implements IJisshiJokyoTokeiBodyEditor {

    private final JisshiJokyoTokeiDataChange item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link JohoTeikyoShiryoItem}
     */
    protected JisshiJokyoTokeiBodyEditor(JisshiJokyoTokeiDataChange item) {
        this.item = item;
    }

    @Override
    public JisshiJokyoTokeiReportSource edit(JisshiJokyoTokeiReportSource source) {
        return editSource(source);
    }

    private JisshiJokyoTokeiReportSource editSource(JisshiJokyoTokeiReportSource source) {
        source.listJisshiTokei_1 = item.getListJisshiTokei1();
        source.listJisshiTokei_2 = item.getListJisshiTokei2();
        source.listJisshiTokei_3 = item.getListJisshiTokei3();
        source.listJisshiTokei_4 = item.getListJisshiTokei4();
        source.listJisshiTokei_5 = item.getListJisshiTokei5();
        return source;
    }
}
