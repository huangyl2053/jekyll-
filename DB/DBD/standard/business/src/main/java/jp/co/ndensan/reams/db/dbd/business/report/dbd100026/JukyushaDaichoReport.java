/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100026;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.TyohyoShutuRyokuYoJukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100026.JukyushaDaichoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 受給者台帳のReportです。
 *
 * @reamsid_L DBD-1760-040 b_liuyang2
 */
public final class JukyushaDaichoReport extends Report<JukyushaDaichoReportSource> {

    private final TyohyoShutuRyokuYoJukyushaDaichoEntity 帳票出力用受給者台帳;

    /**
     * インスタンスを生成します。
     *
     * @param 帳票出力用受給者台帳 TyohyoShutuRyokuYoJukyushaDaichoEntity
     * @return 受給者台帳
     */
    public static JukyushaDaichoReport createReport(TyohyoShutuRyokuYoJukyushaDaichoEntity 帳票出力用受給者台帳) {
        return new JukyushaDaichoReport(帳票出力用受給者台帳);
    }

    private JukyushaDaichoReport(TyohyoShutuRyokuYoJukyushaDaichoEntity 帳票出力用受給者台帳) {
        this.帳票出力用受給者台帳 = 帳票出力用受給者台帳;

    }

    /**
     * writeBy
     *
     * @param writer ReportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<JukyushaDaichoReportSource> writer) {
        IJukyushaDaichoEditor bodyEditor = new JukyushaDaichoEditor(帳票出力用受給者台帳);
        IJukyushaDaichoBuilder builder = new JukyushaDaichoBuilder(bodyEditor);
        writer.writeLine(builder);
    }
}
