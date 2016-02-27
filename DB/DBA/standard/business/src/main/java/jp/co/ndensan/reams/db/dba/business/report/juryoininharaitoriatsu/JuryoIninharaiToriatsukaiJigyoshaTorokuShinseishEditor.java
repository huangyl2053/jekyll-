/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.juryoininharaitoriatsu;

import jp.co.ndensan.reams.db.dba.entity.report.juryoininharaitoriatsu.JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishoReportSource;

/**
 *
 * 介護保険受領委任払い取扱事業者登録申請書のEditorです。
 */
public class JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishEditor implements
            IJuryoIninharaiToriatsukaiJigyoshaTorokuShinseishEditor {
    
    private final JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishItem joho;
    
    /**
     * コンストラクタです。
     * @param joho 一覧表証発行者Entityリストです
     */
    public JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishEditor(JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishItem joho) {
        this.joho = joho;
    }

    /**
     * 被保険者証発行一覧表editです。
     * @param source 被保険者証発行一覧表Source
     * @return 要介護認定業務進捗状況一覧表
     */
    @Override
    public JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishoReportSource edit(
            JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishoReportSource source) {
        return editBody(source);
    }
    
    private JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishoReportSource editBody(
            JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishoReportSource source) {
        source.ninshoshaYakushokuMei = joho.getNinshoshaYakushokuMei();
        return source;
    }
    
}
