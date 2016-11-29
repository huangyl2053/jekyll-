/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendoidoukekkaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kanendoidoukekkaichiran.KeisangojohoAtenaKozaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendoidoukekkaichiran.KanendoIdouKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    private final YMDHMS 調定日時;
    private final RString 出力順ID;
    private final Association association;
    private final RString 並び順の１件目;
    private final RString 並び順の２件目;
    private final RString 並び順の３件目;
    private final RString 並び順の４件目;
    private final RString 並び順の５件目;
    private final List<RString> 改頁項目List;
    private final ChohyoSeigyoKyotsu 帳票制御共通;

    /**
     * コンストラクタです。
     *
     * @param 更正前後EntityList KeisangojohoAtenaKozaKouseizengoEntityのList
     * @param 出力順ID RString
     * @param 調定日時 YMDHMS
     * @param association Association
     * @param 並び順の１件目 RString
     * @param 並び順の２件目 RString
     * @param 並び順の３件目 RString
     * @param 並び順の４件目 RString
     * @param 並び順の５件目 RString
     * @param 改頁項目List List<RString>
     * @param 帳票制御共通 帳票制御共通
     */
    public KanendoIdouKekkaIchiranReport(List<KeisangojohoAtenaKozaKouseizengoEntity> 更正前後EntityList,
            RString 出力順ID, YMDHMS 調定日時, Association association, RString 並び順の１件目, RString 並び順の２件目,
            RString 並び順の３件目, RString 並び順の４件目, RString 並び順の５件目, List<RString> 改頁項目List,
            ChohyoSeigyoKyotsu 帳票制御共通) {
        this.更正前後EntityList = 更正前後EntityList;
        this.出力順ID = 出力順ID;
        this.調定日時 = 調定日時;
        this.association = association;
        this.並び順の１件目 = 並び順の１件目;
        this.並び順の２件目 = 並び順の２件目;
        this.並び順の３件目 = 並び順の３件目;
        this.並び順の４件目 = 並び順の４件目;
        this.並び順の５件目 = 並び順の５件目;
        this.改頁項目List = 改頁項目List;
        this.帳票制御共通 = 帳票制御共通;
    }

    @Override
    public void writeBy(ReportSourceWriter<KanendoIdouKekkaIchiranSource> reportSourceWriter) {
        for (KeisangojohoAtenaKozaKouseizengoEntity 更正前後Entity : 更正前後EntityList) {
            KeisangojohoAtenaKozaEntity 更正前Entity = 更正前後Entity.get計算後情報_宛名_口座_更正前Entity();
            KeisangojohoAtenaKozaEntity 更正後Entity = 更正前後Entity.get計算後情報_宛名_口座_更正後Entity();
            KanendoIdouKekkaIchiranInputEntity inputEntity = new KanendoIdouKekkaIchiranInputEntity(
                    更正前Entity, 更正後Entity, 出力順ID, 調定日時, association, 並び順の１件目,
                    並び順の２件目, 並び順の３件目, 並び順の４件目, 並び順の５件目, 改頁項目List);
            IKanendoIdouKekkaIchiranEditor headerEditor = new KanendoIdouKekkaIchiranHeaderEditor(inputEntity);
            IKanendoIdouKekkaIchiranEditor bodyEditor = new KanendoIdouKekkaIchiranBodyEditor(inputEntity, 帳票制御共通);
            IKanendoIdouKekkaIchiranBuilder builder = new KanendoIdouKekkaIchiranBuilder(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
