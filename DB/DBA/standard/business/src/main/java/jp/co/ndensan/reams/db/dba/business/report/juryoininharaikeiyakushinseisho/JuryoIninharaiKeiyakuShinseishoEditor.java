/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.juryoininharaikeiyakushinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.juryoininharaikeiyakushinseisho.JuryoIninharaiKeiyakuShinseishoReportSource;

/**
 *
 * 介護保険受領委任払い契約申請書Editorです。
 */
    public class JuryoIninharaiKeiyakuShinseishoEditor implements IJuryoIninharaiKeiyakuShinseishoEditor {
    
    private final JuryoIninharaiKeiyakuShinseishoItem joho;
    
    /**
     * コンストラクタです。
     * @param joho 一覧表証発行者Entityリストです
     */
    public JuryoIninharaiKeiyakuShinseishoEditor(JuryoIninharaiKeiyakuShinseishoItem joho) {
        this.joho = joho;
    }

    /**
     * 介護保険受領委任払い契約申請書editです。
     * @param source 介護保険受領委任払い契約申請書Source
     * @return 要介護認定業務進捗状況一覧表
     */
    @Override
    public JuryoIninharaiKeiyakuShinseishoReportSource edit(JuryoIninharaiKeiyakuShinseishoReportSource source) {
        return editBody(source);
    }
    
    private JuryoIninharaiKeiyakuShinseishoReportSource editBody(JuryoIninharaiKeiyakuShinseishoReportSource source) {
        source.ninshoshaYakushokuMei = joho.getNinshoshaYakushokuMei();
        source.remban = joho.getRemban();
        source.tsuchiBun1 = joho.getTsuchiBun1();
        source.tsuchiBun2 = joho.getTsuchiBun2();
        source.tsuchiBun3 = joho.getTsuchiBun3();
        source.tsuchiBun4 = joho.getTsuchiBun4();
        source.title = joho.getTitle();
        return source;
    }
    
}
