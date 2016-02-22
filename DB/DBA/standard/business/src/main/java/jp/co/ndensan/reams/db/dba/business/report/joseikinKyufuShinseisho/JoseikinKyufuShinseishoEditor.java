/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.joseikinKyufuShinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.source.joseikinKyufuShinseisho.JoseikinKyufuShinseishoReportSource;

/**
 * 介護保険助成金給付申請書Editorです。
 */
public class JoseikinKyufuShinseishoEditor implements IJoseikinKyufuShinseishoEditor {

    private final JoseikinKyufuShinseishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link JoseikinKyufuShinseishoItem}
     */
    protected JoseikinKyufuShinseishoEditor(JoseikinKyufuShinseishoItem item) {
        this.item = item;
    }

	/**
     * 介護保険助成金給付申請書editです。
     * @param source 介護保険助成金給付申請書Source
     * @return 介護保険助成金給付申請書
     */
    @Override
    public JoseikinKyufuShinseishoReportSource edit(JoseikinKyufuShinseishoReportSource source) {
        return editSource(source);
    }

    private JoseikinKyufuShinseishoReportSource editSource(JoseikinKyufuShinseishoReportSource source) {

        source.birthYMD = item.getBirthYMD();
        source.hihokenJusho = item.getHihokenJusho();
        source.hihokenshaName = item.getHihokenshaName();
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.hokenshaNo = item.getHokenshaNo();
        source.remban = item.getRemban();
        source.seibetsu = item.getSeibetsu();
        source.telNo = item.getTelNo();
        source.tsuchiBun = item.getTsuchiBun();
        source.yubinNo = item.getYubinNo();

        return source;
    }
}
