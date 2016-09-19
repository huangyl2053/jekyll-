/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.honsanteikekkaicihiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.KeisangojohoAtenaKozaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.honsanteikekkaicihiran.HonsanteiKekkaIcihiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 「本算定賦課計算」のReportです。
 *
 * @reamsid_L DBB-0730-030 lijunjun
 */
public class HonsanteiKekkaIcihiranReport extends Report<HonsanteiKekkaIcihiranReportSource> {

    private final KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座Entity;
    private final FlexibleYear 賦課年度;
    private final YMDHMS 調定日時;
    private final RString 市町村コード;
    private final RString 市町村名;
    private final RString 住所編集;
    private final List<RString> 出力順項目リスト;
    private final List<RString> 改頁項目リスト;

    /**
     * コンストラクタです。
     *
     * @param 計算後情報_宛名_口座Entity KeisangojohoAtenaKozaEntity
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 市町村コード RString
     * @param 市町村名 RString
     * @param 住所編集 RString
     * @param 出力順項目リスト List<RString>
     * @param 改頁項目リスト List<RString>
     */
    public HonsanteiKekkaIcihiranReport(KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座Entity,
            FlexibleYear 賦課年度,
            YMDHMS 調定日時,
            RString 市町村コード,
            RString 市町村名,
            RString 住所編集,
            List<RString> 出力順項目リスト,
            List<RString> 改頁項目リスト) {
        this.計算後情報_宛名_口座Entity = 計算後情報_宛名_口座Entity;
        this.賦課年度 = 賦課年度;
        this.調定日時 = 調定日時;
        this.市町村コード = 市町村コード;
        this.市町村名 = 市町村名;
        this.住所編集 = 住所編集;
        this.出力順項目リスト = 出力順項目リスト;
        this.改頁項目リスト = 改頁項目リスト;
    }

    @Override
    public void writeBy(ReportSourceWriter<HonsanteiKekkaIcihiranReportSource> writer) {
        IHonsanteiKekkaIcihiranEditor editor = new HonsanteiKekkaIcihiranEditor(
                計算後情報_宛名_口座Entity, 賦課年度, 調定日時, 市町村コード, 市町村名, 住所編集, 出力順項目リスト, 改頁項目リスト);
        IHonsanteiKekkaIcihiranBuilder builder = new HonsanteiKekkaIcihiranBuilder(editor);
        writer.writeLine(builder);
    }

}
