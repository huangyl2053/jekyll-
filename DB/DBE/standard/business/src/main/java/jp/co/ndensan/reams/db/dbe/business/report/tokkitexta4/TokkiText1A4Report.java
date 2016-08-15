/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkitexta4;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.TokkiText1A4Business;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitexta4.TokkiA4Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkitexta4.TokkiText1A4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 特記事項（A4版）のReportです。
 *
 * @reamsid_L DBE-0150-340 wangrenze
 */
public class TokkiText1A4Report extends Report<TokkiText1A4ReportSource> {

    private static final int MAXCOUNT = 30;
    private final TokkiText1A4Business data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdata
     */
    public TokkiText1A4Report(TokkiText1A4Business data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokkiText1A4ReportSource> reportSourceWriter) {
        List<TokkiA4Entity> 短冊情報リスト = data.get短冊情報リスト();
        for (int i = 0; i < MAXCOUNT; i++) {
            ITokkiText1A4Editor editor = new TokkiText1A4Editor(data, 短冊情報リスト, i);
            ITokkiText1A4Builder builder = new TokkiText1A4Builder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
