package jp.co.ndensan.reams.db.dbb.business.report.karisanteiidokekkaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.honsanteiidou.KeisanjohoAtenaKozaKouseizengoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.genendoidoukekkaichiran.KeisanjohoAtenaKozaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteiidokekkaichiran.KarisanteiIdoKekkaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 仮算定異動（一括）結果一覧表のReportです。
 *
 * @reamsid_L DBB-0850-030 zhaowei
 */
public class KarisanteiIdoKekkaIchiranReport extends Report<KarisanteiIdoKekkaIchiranSource> {

    private final List<KeisanjohoAtenaKozaKouseizengoEntity> 更正前後EntityList;
    private final YMDHMS 調定日時;
    private final FlexibleYear 賦課年度;
    private final Association association;
    private final List<RString> 住所編集List;
    private final List<RString> 出力順項目リスト;
    private final List<RString> 改頁項目リスト;

    /**
     *
     * @param 更正前後EntityList List<KeisanjohoAtenaKozaKouseizengoEntity>
     * @param 調定日時 YMDHMS
     * @param 賦課年度 FlexibleYear
     * @param association Association
     * @param 住所編集List List<RString>
     * @param 出力順項目リスト List<RString>
     * @param 改頁項目リスト List<RString>
     */
    public KarisanteiIdoKekkaIchiranReport(List<KeisanjohoAtenaKozaKouseizengoEntity> 更正前後EntityList,
            YMDHMS 調定日時, FlexibleYear 賦課年度, Association association, List<RString> 住所編集List,
            List<RString> 出力順項目リスト,
            List<RString> 改頁項目リスト) {
        this.更正前後EntityList = 更正前後EntityList;
        this.調定日時 = 調定日時;
        this.賦課年度 = 賦課年度;
        this.association = association;
        this.住所編集List = 住所編集List;
        this.出力順項目リスト = 出力順項目リスト;
        this.改頁項目リスト = 改頁項目リスト;
    }

    @Override
    public void writeBy(ReportSourceWriter<KarisanteiIdoKekkaIchiranSource> reportSourceWriter) {
        int i = 0;
        for (KeisanjohoAtenaKozaKouseizengoEntity 更正前後Entity : 更正前後EntityList) {
            KeisanjohoAtenaKozaEntity 更正前Entity = 更正前後Entity.get計算後情報_宛名_口座_更正前Entity();
            KeisanjohoAtenaKozaEntity 更正後Entity = 更正前後Entity.get計算後情報_宛名_口座_更正後Entity();
            IKarisanteiIdoKekkaIchiranEditor editor = new KarisanteiIdoKekkaIchiranEditor(
                    更正前Entity, 更正後Entity, 調定日時, 賦課年度, association, 住所編集List.get(i), 出力順項目リスト, 改頁項目リスト);
            i++;
            IKarisanteiIdoKekkaIchiranBuilder builder = new KarisanteiIdoKekkaIchiranBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
