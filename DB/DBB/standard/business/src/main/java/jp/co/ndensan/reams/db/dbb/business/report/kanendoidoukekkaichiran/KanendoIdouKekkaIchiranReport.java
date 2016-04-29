/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendoidoukekkaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidokanendofuka.HonSanteiIdoKanendoFukaBatchParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kanendoidoukekkaichiran.KeisangojohoAtenaKozaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendoidoukekkaichiran.KanendoIdouKekkaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBBRP45001_2_本算定異動（過年度）結果一覧表 Reportです。
 *
 * @reamsid_L DBB-0910-030 zhangrui
 *
 */
public class KanendoIdouKekkaIchiranReport extends Report<KanendoIdouKekkaIchiranSource> {

    private final List<KeisangojohoAtenaKozaKouseizengoEntity> 更正前後EntityList;
    private final HonSanteiIdoKanendoFukaBatchParameter バッチパラメータ;
    private final YMDHMS 調定日時;
    private final Association association;

    /**
     * コンストラクタです。
     *
     * @param 更正前後EntityList KeisangojohoAtenaKozaKouseizengoEntityのList
     * @param バッチパラメータ HonSanteiIdoKanendoFukaBatchParameter
     * @param 調定日時 YMDHMS
     * @param association Association
     */
    public KanendoIdouKekkaIchiranReport(List<KeisangojohoAtenaKozaKouseizengoEntity> 更正前後EntityList,
            HonSanteiIdoKanendoFukaBatchParameter バッチパラメータ, YMDHMS 調定日時, Association association) {
        this.更正前後EntityList = 更正前後EntityList;
        this.バッチパラメータ = バッチパラメータ;
        this.調定日時 = 調定日時;
        this.association = association;
    }

    @Override
    public void writeBy(ReportSourceWriter<KanendoIdouKekkaIchiranSource> reportSourceWriter) {
        for (KeisangojohoAtenaKozaKouseizengoEntity 更正前後Entity : 更正前後EntityList) {
            KeisangojohoAtenaKozaEntity 更正前Entity = 更正前後Entity.get計算後情報_宛名_口座_更正前Entity();
            KeisangojohoAtenaKozaEntity 更正後Entity = 更正前後Entity.get計算後情報_宛名_口座_更正前Entity();
            IKanendoIdouKekkaIchiranEditor headerEditor = new HeaderEditor(new KanendoIdouKekkaIchiranInputEntity(
                    更正前Entity, 更正後Entity, バッチパラメータ, 調定日時, association));
            IKanendoIdouKekkaIchiranEditor bodyEditor = new BodyEditor(new KanendoIdouKekkaIchiranInputEntity(
                    更正前Entity, 更正後Entity, バッチパラメータ, 調定日時, association));
            IKanendoIdouKekkaIchiranBuilder builder = new KanendoIdouKekkaIchiranBuilder(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
