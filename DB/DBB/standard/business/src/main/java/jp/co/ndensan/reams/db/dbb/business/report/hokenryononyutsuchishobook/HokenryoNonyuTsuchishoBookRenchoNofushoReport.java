/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook;

import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.HokenryoNonyuTsuchishoBookRenchoNofushoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 保険料納入通知書（仮算定）【ブックタイプ】納付書連帳
 */
public class HokenryoNonyuTsuchishoBookRenchoNofushoReport extends Report<HokenryoNonyuTsuchishoBookRenchoNofushoSource> {

    private final HokenryoNonyuTsuchishoBookItem item;

    /**
     * コンストラクタです。
     *
     * @param item HokenryoNonyuTsuchishoBookItem
     */
    protected HokenryoNonyuTsuchishoBookRenchoNofushoReport(HokenryoNonyuTsuchishoBookItem item) {
        this.item = item;
    }

    /**
     *
     * @param item
     * @return HokenryoNonyuTsuchishoBookNofushoReport
     * @throws NullPointerException 引数が{@code null}の時
     */
    public static HokenryoNonyuTsuchishoBookRenchoNofushoReport createFrom(HokenryoNonyuTsuchishoBookItem item) {
        return new HokenryoNonyuTsuchishoBookRenchoNofushoReport(item);
    }

    @Override
    public void writeBy(ReportSourceWriter<HokenryoNonyuTsuchishoBookRenchoNofushoSource> writer) {
        IHokenryoNonyuTsuchishoBookRenchoNofushoEditor editor = new HokenryoNonyuTsuchishoBookRenchoNofushoEditor(item, null, 1);
        IHokenryoNonyuTsuchishoBookRenchoNofushoBuilder builder = new HokenryoNonyuTsuchishoBookRenchoNofushoBuilder(editor);
        writer.writeLine(builder);
    }

}
