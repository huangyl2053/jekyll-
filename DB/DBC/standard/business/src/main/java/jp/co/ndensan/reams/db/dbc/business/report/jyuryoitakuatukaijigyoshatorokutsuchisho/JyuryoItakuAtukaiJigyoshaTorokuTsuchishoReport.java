/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jyuryoitakuatukaijigyoshatorokutsuchisho;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.hokenjuryoininharaitoriatsukai.HokenJuryoIninHaraiToriatsukaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.jyuryoitakuatukaijigyoshatorokutsuchishosource.JyuryoItakuAtukaiJigyoshaTorokuTsuchishoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.toiawasesaki.ToiawasesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC100032_介護保険受領委任払い取扱事業者登録通知書 Report
 *
 * @reamsid_L DBC-2120-050 sunhui
 */
public class JyuryoItakuAtukaiJigyoshaTorokuTsuchishoReport extends Report<JyuryoItakuAtukaiJigyoshaTorokuTsuchishoSource> {

    private final HokenJuryoIninHaraiToriatsukaiEntity target;
    private final NinshoshaSource sourceBuilder;
    private final ToiawasesakiSource toiawasesakiSource;
    private final RString 文書番号;
    private final RString 通知書定型文１;
    private final RString 通知書定型文2;

    /**
     * インスタンスを生成します。
     *
     * @param target HokenJuryoIninHaraiToriatsukaiEntity
     * @param sourceBuilder NinshoshaSource
     * @param toiawasesakiSource ToiawasesakiSource
     * @param 文書番号 RString
     * @param 通知書定型文１ RString
     * @param 通知書定型文2 RString
     */
    public JyuryoItakuAtukaiJigyoshaTorokuTsuchishoReport(
            HokenJuryoIninHaraiToriatsukaiEntity target,
            NinshoshaSource sourceBuilder,
            ToiawasesakiSource toiawasesakiSource,
            RString 文書番号,
            RString 通知書定型文１,
            RString 通知書定型文2) {
        this.target = target;
        this.sourceBuilder = sourceBuilder;
        this.toiawasesakiSource = toiawasesakiSource;
        this.文書番号 = 文書番号;
        this.通知書定型文１ = 通知書定型文１;
        this.通知書定型文2 = 通知書定型文2;
    }

    @Override
    public void writeBy(ReportSourceWriter<JyuryoItakuAtukaiJigyoshaTorokuTsuchishoSource> reportSourceWriter) {
        IJyuryoItakuAtukaiJigyoshaTorokuTsuchishoEditor editor
                = new JyuryoItakuAtukaiJigyoshaTorokuTsuchishoEditor(target, sourceBuilder, toiawasesakiSource,
                        文書番号, 通知書定型文１, 通知書定型文2);
        IJyuryoItakuAtukaiJigyoshaTorokuTsuchishoBuilder builder
                = new JyuryoItakuAtukaiJigyoshaTorokuTsuchishoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
