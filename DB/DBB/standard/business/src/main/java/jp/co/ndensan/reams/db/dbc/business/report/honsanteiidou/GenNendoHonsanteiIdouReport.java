/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.honsanteiidou;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidogenendofuka.HonSanteiIdoGenendoFukaBatchParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.genendoidoukekkaichiran.KeisanjohoAtenaKozaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gennendohonsanteiidou.GenNendoHonsanteiIdouSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 本算定異動（現年度）結果一覧表帳票Report
 *
 * @reamsid_L DBB-0930-030 sunhui
 */
public class GenNendoHonsanteiIdouReport extends Report<GenNendoHonsanteiIdouSource> {

    private final List<KeisanjohoAtenaKozaKouseizengoEntity> 更正前後EntityList;
    private final HonSanteiIdoGenendoFukaBatchParameter バッチパラメータ;
    private final YMDHMS 調定日時;
    private final FlexibleYear 賦課年度;
    private final Association association;

    /**
     *
     * @param 更正前後EntityList List<KeisangojohoAtenaKozaKouseizengoEntity>
     * @param バッチパラメータ HonSanteiIdoGenendoFukaBatchParameter
     * @param 調定日時 YMDHMS
     * @param 賦課年度 FlexibleYear
     * @param association Association
     */
    public GenNendoHonsanteiIdouReport(List<KeisanjohoAtenaKozaKouseizengoEntity> 更正前後EntityList,
            HonSanteiIdoGenendoFukaBatchParameter バッチパラメータ, YMDHMS 調定日時, FlexibleYear 賦課年度, Association association) {
        this.更正前後EntityList = 更正前後EntityList;
        this.バッチパラメータ = バッチパラメータ;
        this.調定日時 = 調定日時;
        this.賦課年度 = 賦課年度;
        this.association = association;
    }

    @Override
    public void writeBy(ReportSourceWriter<GenNendoHonsanteiIdouSource> reportSourceWriter) {
        for (KeisanjohoAtenaKozaKouseizengoEntity 更正前後Entity : 更正前後EntityList) {
            KeisanjohoAtenaKozaEntity 更正前Entity = 更正前後Entity.get計算後情報_宛名_口座_更正前Entity();
            KeisanjohoAtenaKozaEntity 更正後Entity = 更正前後Entity.get計算後情報_宛名_口座_更正前Entity();
            IGenNendoHonsanteiIdouEditor header = new GenNendoHonsanteiIdouHeaderEditor(new GenendoIdouKekkaIchiranInputEntity(
                    更正前Entity, 更正後Entity, バッチパラメータ, 調定日時, 賦課年度, association));
            IGenNendoHonsanteiIdouEditor body = new GenNendoHonsanteiIdouBodyEditor(new GenendoIdouKekkaIchiranInputEntity(
                    更正前Entity, 更正後Entity, バッチパラメータ, 調定日時, 賦課年度, association));
            IGenNendoHonsanteiIdouBuilder builder = new GenNendoHonsanteiIdouBuilder(header, body);
            reportSourceWriter.writeLine(builder);
        }
    }

}
