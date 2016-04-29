/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.ninteikoshintsuchisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.ninteikoshintsuchisho.NinteiKoshinTsuchishoItem;
import jp.co.ndensan.reams.db.dbd.business.report.ninteikoshintsuchisho.NinteiKoshinTsuchishoProperty;
import jp.co.ndensan.reams.db.dbd.business.report.ninteikoshintsuchisho.NinteiKoshinTsuchishoReport;
import jp.co.ndensan.reams.db.dbd.entity.report.ninteikoshintsuchisho.NinteiKoshinTsuchisho;
import jp.co.ndensan.reams.db.dbz.service.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 負担限度額認定更新のお知らせ通知書。
 *
 * @reamsid_L DBD-3570-040 liangbc
 */
public class NinteiKoshinTsuchishoService {

    /**
     * 帳票を出力
     *
     * @param targets パラメータ
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<NinteiKoshinTsuchishoItem> targets) {
        NinteiKoshinTsuchishoProperty property = new NinteiKoshinTsuchishoProperty();
        return new Printer<NinteiKoshinTsuchisho>().spool(property, toReports(targets));
    }

    private static List<NinteiKoshinTsuchishoReport> toReports(List<NinteiKoshinTsuchishoItem> targets) {
        List<NinteiKoshinTsuchishoReport> list = new ArrayList();
        for (NinteiKoshinTsuchishoItem item : targets) {
            item.set編集後宛先(JushoHenshu.createInstance().create編集後宛先(item.getIAtesaki(), item.get地方公共団体(), item.get帳票制御共通()));
            list.add(new NinteiKoshinTsuchishoReport(item));
        }
        return list;
    }

}
