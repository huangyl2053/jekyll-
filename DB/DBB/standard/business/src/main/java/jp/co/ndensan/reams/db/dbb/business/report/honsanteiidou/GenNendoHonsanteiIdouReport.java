/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.honsanteiidou;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.genendoidoukekkaichiran.KeisanjohoAtenaKozaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.source.gennendohonsanteiidou.GenNendoHonsanteiIdouSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 本算定異動（現年度）結果一覧表帳票Report
 *
 * @reamsid_L DBB-0930-030 sunhui
 */
public class GenNendoHonsanteiIdouReport extends Report<GenNendoHonsanteiIdouSource> {

    private final List<KeisanjohoAtenaKozaKouseizengoEntity> 更正前後EntityList;
    private final RString 並び順の１件目;
    private final RString 並び順の２件目;
    private final RString 並び順の３件目;
    private final RString 並び順の４件目;
    private final RString 並び順の５件目;
    private final YMDHMS 調定日時;
    private final FlexibleYear 賦課年度;
    private final Association association;
    private final List<RString> 住所編集List;

    /**
     *
     * @param 更正前後EntityList List<KeisangojohoAtenaKozaKouseizengoEntity>
     * @param 調定日時 YMDHMS
     * @param 賦課年度 FlexibleYear
     * @param association Association
     * @param 住所編集List List<RString>
     * @param 並び順の１件目 RString
     * @param 並び順の２件目 RString
     * @param 並び順の３件目 RString
     * @param 並び順の４件目 RString
     * @param 並び順の５件目 RString
     */
    public GenNendoHonsanteiIdouReport(List<KeisanjohoAtenaKozaKouseizengoEntity> 更正前後EntityList,
            YMDHMS 調定日時, FlexibleYear 賦課年度, Association association, List<RString> 住所編集List,
            RString 並び順の１件目, RString 並び順の２件目,
            RString 並び順の３件目, RString 並び順の４件目, RString 並び順の５件目) {
        this.更正前後EntityList = 更正前後EntityList;
        this.並び順の１件目 = 並び順の１件目;
        this.並び順の２件目 = 並び順の２件目;
        this.並び順の３件目 = 並び順の３件目;
        this.並び順の４件目 = 並び順の４件目;
        this.並び順の５件目 = 並び順の５件目;
        this.調定日時 = 調定日時;
        this.賦課年度 = 賦課年度;
        this.association = association;
        this.住所編集List = 住所編集List;
    }

    @Override
    public void writeBy(ReportSourceWriter<GenNendoHonsanteiIdouSource> reportSourceWriter) {

        int i = 0;
        for (KeisanjohoAtenaKozaKouseizengoEntity 更正前後Entity : 更正前後EntityList) {
            KeisanjohoAtenaKozaEntity 更正前Entity = 更正前後Entity.get計算後情報_宛名_口座_更正前Entity();
            KeisanjohoAtenaKozaEntity 更正後Entity = 更正前後Entity.get計算後情報_宛名_口座_更正後Entity();
            IGenNendoHonsanteiIdouEditor header = new GenNendoHonsanteiIdouHeaderEditor();
            IGenNendoHonsanteiIdouEditor body = new GenNendoHonsanteiIdouBodyEditor(
                    new GenendoIdouKekkaIchiranInputEntity(
                            更正前Entity, 更正後Entity, 調定日時, 賦課年度, association, 住所編集List.get(i), 並び順の１件目,
                            並び順の２件目, 並び順の３件目, 並び順の４件目, 並び順の５件目));
            i++;
            IGenNendoHonsanteiIdouBuilder builder = new GenNendoHonsanteiIdouBuilder(header, body);
            reportSourceWriter.writeLine(builder);
        }
    }

}
