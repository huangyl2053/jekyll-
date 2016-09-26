/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd300001;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.jukyushagemmenjisshijokyo.JukyushaGemmenJisshiJokyoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd300001.JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 受給者減免月別申請・認定状況表のReportです。
 *
 * @reamsid_L DBD-3770-040 b_liuyang2
 */
public final class JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoReport extends
        Report<JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoReportSource> {

    private final Association association;
    private final FlexibleYear 対象年度;
    private final JukyushaGemmenJisshiJokyoEntity データリスト;
    private final RString 保険者番号;
    private final RString 保険者名;

    /**
     * インスタンスを生成します。
     *
     * @param association Association
     * @param 対象年度 FlexibleDate
     * @param データリスト JukyushaGemmenJisshiJokyoEntity
     * @param 保険者番号 RString
     * @param 保険者名 RString
     */
    public JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoReport(Association association, FlexibleYear 対象年度,
            JukyushaGemmenJisshiJokyoEntity データリスト, RString 保険者番号, RString 保険者名) {
        this.association = association;
        this.対象年度 = 対象年度;
        this.データリスト = データリスト;
        this.保険者番号 = 保険者番号;
        this.保険者名 = 保険者名;
    }

    /**
     * writeBy
     *
     * @param writer ReportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoReportSource> writer) {
        IJukyushaGemmenTsukibetsuShinseiNinteiJokyohyoEditor bodyEditor
                = new JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoEditor(association, 対象年度, データリスト, 保険者番号, 保険者名);
        IJukyushaGemmenTsukibetsuShinseiNinteiJokyohyoBuilder builder
                = new JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoBuilder(bodyEditor);
        writer.writeLine(builder);
    }
}
