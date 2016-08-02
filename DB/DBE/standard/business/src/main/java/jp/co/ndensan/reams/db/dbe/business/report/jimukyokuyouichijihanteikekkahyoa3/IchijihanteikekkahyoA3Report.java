/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jimukyokuyouichijihanteikekkahyoa3;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.TokkiJikou;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jimukyokuyouichijihanteikekkahyo.IchijihanteikekkahyoA3ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事務局用一次判定結果票A3のReportです。
 *
 * @reamsid_L DBE-0150-320 lishengli
 */
public class IchijihanteikekkahyoA3Report extends Report<IchijihanteikekkahyoA3ReportSource> {

    private static final int LENGTH_30 = 30;
    private final IchijihanteikekkahyoA3Entity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 事務局用一次判定結果票Entity
     */
    public IchijihanteikekkahyoA3Report(IchijihanteikekkahyoA3Entity entity) {
        this.entity = entity;
    }

    /**
     * 委員用一次判定結果票A3を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<IchijihanteikekkahyoA3ReportSource> reportSourceWriter) {
        List<RString> 特記事項List = getlistChosa1();
        for (int i = 0; i < LENGTH_30; i++) {
            IIchijihanteikekkahyoA3Editor headerEditor = new IchijihanteikekkahyoA3Editor(entity, 特記事項List, i);
            IIchijihanteikekkahyoA3Builder builder = new IchijihanteikekkahyoA3Builder(headerEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<RString> getlistChosa1() {
        List<RString> listChosa1 = new ArrayList<>();
        List<TokkiJikou> 特記事項List = entity.get特記事項_listChosa1();
        for (int i = 0; i < 特記事項List.size(); i++) {
            listChosa1.add(特記事項List.get(i).get事項番号());
            listChosa1.add(特記事項List.get(i).get項目名称());
        }
        return listChosa1;
    }
}
