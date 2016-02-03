/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.juryoininharaitoriatsu;

import jp.co.ndensan.reams.db.dba.entity.report.juryoininharaitoriatsu.JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 介護保険受領委任払い取扱事業者登録申請書の帳票を作成します。
 */
public final class JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishReport extends 
        Report<JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishoReportSource> {
    
    private final JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishItem item;
    
    private JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishReport(JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishItem item) {
        this.item = item;
    }
    
    /**
     * インスタンスを生成します。
     * @param item 介護保険資格取得・異動・喪失届Entityリスト
     * @return HihokenshashoHakkoIchiranHyoReport
     */
    public static JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishReport createReport(
            @NonNull JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishItem item) {
        return new JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishReport(item);
    }

    /**
     * 介護保険資格取得・異動・喪失届writeByします。
     * @param writer 介護保険資格取得・異動・喪失届作成_帳票クラスパラメータ
     */
    @Override
    public void writeBy(ReportSourceWriter<JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishoReportSource> writer) {
        IJuryoIninharaiToriatsukaiJigyoshaTorokuShinseishEditor joho = new JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishEditor(item);
        IJuryoIninharaiToriatsukaiJigyoshaTorokuShinseishBuilder builder = new JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishImpl(joho);
        writer.writeLine(builder);
    }
}
