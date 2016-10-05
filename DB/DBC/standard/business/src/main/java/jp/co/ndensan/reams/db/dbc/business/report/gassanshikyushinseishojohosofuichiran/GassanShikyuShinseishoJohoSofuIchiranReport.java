/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanshikyushinseishojohosofuichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060.KogakugassanShikyushinseishoOutFileEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.gassanshikyushinseishojohosofuichiran.GassanShikyuShinseishoJohoSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200027_高額合算支給申請書情報送付一覧表 のReportSourceクラスです。
 *
 * @reamsid_L DBC-2630-040 zhengshenlei
 */
public class GassanShikyuShinseishoJohoSofuIchiranReport extends Report<GassanShikyuShinseishoJohoSofuIchiranSource> {

    private final KogakugassanShikyushinseishoOutFileEntity entity;
    private final YMDHMS システム日時;
    private final FlexibleYearMonth 処理年月;
    private final int 連番;
    private final boolean flag;

    /**
     * コンストラクタです
     *
     * @param entity KogakugassanShikyushinseishoOutFileEntity
     * @param システム日時 YMDHMS
     * @param 処理年月 FlexibleYearMonth
     * @param 連番 int
     * @param flag boolean
     */
    public GassanShikyuShinseishoJohoSofuIchiranReport(
            KogakugassanShikyushinseishoOutFileEntity entity,
            YMDHMS システム日時,
            FlexibleYearMonth 処理年月,
            int 連番,
            boolean flag) {
        this.entity = entity;
        this.システム日時 = システム日時;
        this.処理年月 = 処理年月;
        this.連番 = 連番;
        this.flag = flag;
    }

    @Override
    public void writeBy(ReportSourceWriter<GassanShikyuShinseishoJohoSofuIchiranSource> writer) {
        IGassanShikyuShinseishoJohoSofuIchiranEditor editor = new GassanShikyuShinseishoJohoSofuIchiranEditor(entity, システム日時, 処理年月, 連番, flag);
        IGassanShikyuShinseishoJohoSofuIchiranBuilder builder = new GassanShikyuShinseishoJohoSofuIchiranBuilder(editor);
        writer.writeLine(builder);
    }

}
