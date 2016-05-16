/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.honsanteikekkaicihiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteifuka.HonsanteiFukaExtraBatchParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.KeisangojohoAtenaKozaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.honsanteikekkaicihiran.HonsanteiKekkaIcihiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 「本算定賦課計算」のReportです。
 *
 * @reamsid_L DBB-0730-030 lijunjun
 */
public class HonsanteiKekkaIcihiranReport extends Report<HonsanteiKekkaIcihiranReportSource> {

    private final List<KeisangojohoAtenaKozaEntity> 計算後情報_宛名_口座EntityList;
    private final HonsanteiFukaExtraBatchParameter バッチパラメータ;
    private final FlexibleYear 賦課年度;
    private final RDate 調定日時;
    private final RString 市町村コード;
    private final RString 市町村名;
    private final RString 住所編集;

    /**
     * コンストラクタです。
     *
     * @param 計算後情報_宛名_口座EntityList List<KeisangojohoAtenaKozaEntity>
     * @param バッチパラメータ HonsanteiFukaBatchParameter
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 RDate
     * @param 市町村コード RString
     * @param 市町村名 RString
     * @param 住所編集 RString
     */
    public HonsanteiKekkaIcihiranReport(List<KeisangojohoAtenaKozaEntity> 計算後情報_宛名_口座EntityList,
            HonsanteiFukaExtraBatchParameter バッチパラメータ,
            FlexibleYear 賦課年度,
            RDate 調定日時,
            RString 市町村コード,
            RString 市町村名,
            RString 住所編集) {
        this.計算後情報_宛名_口座EntityList = 計算後情報_宛名_口座EntityList;
        this.バッチパラメータ = バッチパラメータ;
        this.賦課年度 = 賦課年度;
        this.調定日時 = 調定日時;
        this.市町村コード = 市町村コード;
        this.市町村名 = 市町村名;
        this.住所編集 = 住所編集;
    }

    @Override
    public void writeBy(ReportSourceWriter<HonsanteiKekkaIcihiranReportSource> writer) {
        IHonsanteiKekkaIcihiranEditor editor = new HonsanteiKekkaIcihiranEditor(
                計算後情報_宛名_口座EntityList, バッチパラメータ, 賦課年度, 調定日時, 市町村コード, 市町村名, 住所編集);
        IHonsanteiKekkaIcihiranBuilder builder = new HonsanteiKekkaIcihiranBuilder(editor);
        writer.writeLine(builder);
    }

}
