/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200008;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakuhaakuichiran.KyufuGengakuHaakuIchiranEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200008.KyufuGengakuHaakuIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 給付額減額把握リストのReportです。
 *
 * @reamsid_L DBD-3610-060 b_liuyang2
 */
public final class KyufuGengakuHaakuIchiranReport extends Report<KyufuGengakuHaakuIchiranReportSource> {

    private final RDateTime 作成日時;
    private final HokenshaNo 保険者番号;
    private final RString 保険者名称;
    private final KyufuGengakuHaakuIchiranEntity 給付額減額把握リストEntity;
    private final IOutputOrder iOutputOrder;
    private static final int 行数14 = 14;

    /**
     * インスタンスを生成します。
     *
     * @param 作成日時 作成日時
     * @param 保険者番号 保険者番号
     * @param 保険者名称 保険者名称
     * @param 給付額減額把握リストEntity KyufuGengakuHaakuIchiranEntity
     * @param iOutputOrder IOutputOrder
     */
    public KyufuGengakuHaakuIchiranReport(RDateTime 作成日時, HokenshaNo 保険者番号, RString 保険者名称,
            KyufuGengakuHaakuIchiranEntity 給付額減額把握リストEntity, IOutputOrder iOutputOrder) {
        this.作成日時 = 作成日時;
        this.保険者名称 = 保険者名称;
        this.保険者番号 = 保険者番号;
        this.給付額減額把握リストEntity = 給付額減額把握リストEntity;
        this.iOutputOrder = iOutputOrder;
    }

    /**
     * writeBy
     *
     * @param writer ReportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<KyufuGengakuHaakuIchiranReportSource> writer) {
        for (int 行数 = 0; 行数 < 行数14; 行数++) {
            IKyufuGengakuHaakuIchiranEditor bodyEditor = new KyufuGengakuHaakuIchiranEditor(
                    作成日時, 保険者番号, 保険者名称, 給付額減額把握リストEntity, iOutputOrder, 行数);
            IKyufuGengakuHaakuIchiranBuilder builder = new KyufuGengakuHaakuIchiranBuilder(bodyEditor);
            writer.writeLine(builder);
        }
    }
}
