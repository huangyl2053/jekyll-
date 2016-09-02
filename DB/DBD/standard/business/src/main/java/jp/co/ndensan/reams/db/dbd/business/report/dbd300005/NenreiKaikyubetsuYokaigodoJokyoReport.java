/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd300005;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd583001.ToukeiNinzuEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd300005.NenreiKaikyubetsuYokaigodoJokyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 年齢階級別要介護度状況（統計表）のReportです。
 *
 * @reamsid_L DBD-1790-040 donghj
 */
public final class NenreiKaikyubetsuYokaigodoJokyoReport extends Report<NenreiKaikyubetsuYokaigodoJokyoReportSource> {

    private final RString 市町村番号;
    private final RString 市町村名;
    private final RString 基準日;
    private final RString 地区;
    private final List<ToukeiNinzuEntity> 統計人数Entityリスト;

    /**
     * インスタンスを生成します。
     *
     * @param 市町村番号 RString
     * @param 市町村名 RString
     * @param 基準日 RString
     * @param 地区 RString
     * @param 統計人数Entityリスト List<ToukeiNinzuEntity>
     */
    public NenreiKaikyubetsuYokaigodoJokyoReport(RString 市町村番号, RString 市町村名, RString 基準日, RString 地区,
            List<ToukeiNinzuEntity> 統計人数Entityリスト) {
        this.市町村番号 = 市町村番号;
        this.市町村名 = 市町村名;
        this.基準日 = 基準日;
        this.地区 = 地区;
        this.統計人数Entityリスト = 統計人数Entityリスト;
    }

    @Override
    public void writeBy(ReportSourceWriter<NenreiKaikyubetsuYokaigodoJokyoReportSource> writer) {
        for (int index = 0; index < 統計人数Entityリスト.size(); index++) {
            INenreiKaikyubetsuYokaigodoJokyoEditor editor = new NenreiKaikyubetsuYokaigodoJokyoEditor(市町村番号,
                    市町村名, 基準日, 地区, 統計人数Entityリスト, index);
            INenreiKaikyubetsuYokaigodoJokyoBuilder builder = new NenreiKaikyubetsuYokaigodoJokyoBuilder(editor);
            writer.writeLine(builder);
        }

    }

}
