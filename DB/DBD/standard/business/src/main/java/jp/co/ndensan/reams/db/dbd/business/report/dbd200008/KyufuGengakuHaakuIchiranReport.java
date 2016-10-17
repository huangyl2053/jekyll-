/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200008;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakuhaakuichiran.KyufuGengakuHaakuIchiranEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakuhaakuichiran.ShunoJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200008.KyufuGengakuHaakuIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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

    private static final int INT_10 = 10;
    private static final int 行数14 = 14;
    private static final int 行数28 = 28;

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
        収納情報の出力設定();
        int 総行数 = 行数14;
        if (給付額減額把握リストEntity.get収納情報リスト().size() > INT_10) {
            総行数 = 行数28;
        }
        for (int 行数 = 0; 行数 < 総行数; 行数++) {
            IKyufuGengakuHaakuIchiranEditor bodyEditor = new KyufuGengakuHaakuIchiranEditor(
                    作成日時, 保険者番号, 保険者名称, 給付額減額把握リストEntity, iOutputOrder, 行数);
            IKyufuGengakuHaakuIchiranBuilder builder = new KyufuGengakuHaakuIchiranBuilder(bodyEditor);
            writer.writeLine(builder);
        }
    }

    private void 収納情報の出力設定() {
        List<ShunoJohoEntity> 収納情報リスト = 給付額減額把握リストEntity.get収納情報リスト();
        List<ShunoJohoEntity> 出力_収納情報リスト = new ArrayList<>();
        List<FlexibleYear> 賦課年度List = new ArrayList<>();
        for (ShunoJohoEntity 収納情報 : 収納情報リスト) {
            if (!賦課年度List.contains(収納情報.get賦課年度())) {
                add賦課年度List(賦課年度List, 収納情報.get賦課年度());
            }
        }
        for (FlexibleYear 賦課年度 : 賦課年度List) {
            List<ShunoJohoEntity> 賦課年度_収納情報リスト = get収納情報リストBy賦課年度(収納情報リスト, 賦課年度);
            出力_収納情報リスト.addAll(賦課年度_収納情報リスト);
        }
        給付額減額把握リストEntity.set収納情報リスト(出力_収納情報リスト);
    }

    private List<ShunoJohoEntity> get収納情報リストBy賦課年度(List<ShunoJohoEntity> 収納情報リスト, FlexibleYear 賦課年度) {
        List<ShunoJohoEntity> 賦課年度_収納情報リスト = new ArrayList<>();
        for (ShunoJohoEntity 収納情報 : 収納情報リスト) {
            if (賦課年度.equals(収納情報.get賦課年度())) {
                賦課年度_収納情報リスト.add(収納情報);
            }
        }
        return 賦課年度_収納情報リスト;
    }

    private void add賦課年度List(List<FlexibleYear> 賦課年度List, FlexibleYear 賦課年度) {
        if (賦課年度List.isEmpty()) {
            賦課年度List.add(賦課年度);
            return;
        }
        for (int index = 0; index < 賦課年度List.size(); index++) {
            if (賦課年度.isBefore(賦課年度List.get(index))) {
                賦課年度List.add(index, 賦課年度);
                return;
            } else if (index == 賦課年度List.size() - 1) {
                賦課年度List.add(賦課年度);
                return;
            }
        }
    }
}
