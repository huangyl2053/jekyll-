/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jimushinsakaishiryoa3;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaiWariateJohoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaishiryoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuSonotashiryoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuTuikaSiryoBusiness;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.TokkiJikou;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jimushinsakaishiryoa3.JimuShinsakaishiryoA3ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事務局審査会資料組み合わせ一覧A3版のReportクラスです。
 *
 * @reamsid_L DBE-0150-200 lishengli
 */
public class JimuShinsakaishiryoA3Report extends Report<JimuShinsakaishiryoA3ReportSource> {

    private static final RString テキスト全面イメージ = new RString("1");
    private static final int INT_25 = 25;
    private static final int MAXCOUNT = 30;
    private static final int PAGETWO_MAXCOUNT = 34;
    private final List<JimuShinsakaishiryoBusiness> shinsakaishiryoList;
    private final IchijihanteikekkahyoA3Entity jimuTokkiTextA3Entity;
    private final JimuShinsakaiWariateJohoBusiness shinsakaiWariateJoho;
    private final JimuSonotashiryoBusiness sonotashiryoBusiness;
    private final List<JimuTuikaSiryoBusiness> tuikaSiryoBusinessList;
    private final RString reportId;

    /**
     * インスタンスを生成します。
     *
     * @param shinsakaishiryoList List<JimuShinsakaishiryoBusiness>
     * @param jimuTokkiTextA3Entity IchijihanteikekkahyoA3Entity
     * @param shinsakaiWariateJoho 主治医意見書のBusinessの編集クラス
     * @param sonotashiryoBusiness その他資料情報のBusinessの編集クラス
     * @param tuikaSiryoBusinessList 追加資料鑑情報のBusinessの編集クラス
     * @param reportId 帳票ＩＤ
     */
    public JimuShinsakaishiryoA3Report(List<JimuShinsakaishiryoBusiness> shinsakaishiryoList,
            IchijihanteikekkahyoA3Entity jimuTokkiTextA3Entity, JimuShinsakaiWariateJohoBusiness shinsakaiWariateJoho,
            JimuSonotashiryoBusiness sonotashiryoBusiness, List<JimuTuikaSiryoBusiness> tuikaSiryoBusinessList,
            RString reportId) {
        this.shinsakaishiryoList = shinsakaishiryoList;
        this.jimuTokkiTextA3Entity = jimuTokkiTextA3Entity;
        this.shinsakaiWariateJoho = shinsakaiWariateJoho;
        this.sonotashiryoBusiness = sonotashiryoBusiness;
        this.tuikaSiryoBusinessList = tuikaSiryoBusinessList;
        this.reportId = reportId;
    }

    @Override
    public void writeBy(ReportSourceWriter<JimuShinsakaishiryoA3ReportSource> reportSourceWriter) {
        for (int i = 0; i < INT_25; i++) {
            IJimuShinsakaishiryoA3Editor editor = new JimuShinsakaishiryoA3Group1Editor(shinsakaishiryoList, i);
            IJimuShinsakaishiryoA3Builder builder = new JimuShinsakaishiryoA3Builder(editor);
            reportSourceWriter.writeLine(builder);
        }
        List<TokkiJikou> 短冊情報リスト = jimuTokkiTextA3Entity.get特記事項_listChosa1();
        List<RString> 短冊リスト = get短冊リスト(短冊情報リスト);
        List<RString> テキスト全面List = jimuTokkiTextA3Entity.get特記事項_tokkiText();
        for (int i = 0; i < MAXCOUNT; i++) {
            IJimuShinsakaishiryoA3Editor editor = new JimuShinsakaishiryoA3Group2Editor(jimuTokkiTextA3Entity, 短冊リスト, i);
            IJimuShinsakaishiryoA3Builder builder = new JimuShinsakaishiryoA3Builder(editor);
            reportSourceWriter.writeLine(builder);
        }
        if (ReportIdDBE.DBE517902.getReportId().value().equals(reportId)) {
            IJimuShinsakaishiryoA3Editor editor1 = new JimuShinsakaishiryoA3Group4Editor(shinsakaiWariateJoho, reportId);
            IJimuShinsakaishiryoA3Builder builder1 = new JimuShinsakaishiryoA3Builder(editor1);
            reportSourceWriter.writeLine(builder1);
        }
        if (テキスト全面イメージ.equals(jimuTokkiTextA3Entity.get特記パターン())) {
            int totalPages = (int) Math.ceil((double) (テキスト全面List.size() - 1) / 2) + 1;
            for (int i = 0; i < テキスト全面List.size(); i++) {
                if ((i + 2) <= totalPages) {
                    IJimuShinsakaishiryoA3Editor editor = new JimuShinsakaishiryoA3Group3Editor(
                            jimuTokkiTextA3Entity, 短冊リスト, i + 2, i + 2, reportId);
                    IJimuShinsakaishiryoA3Builder builder = new JimuShinsakaishiryoA3Builder(editor);
                    reportSourceWriter.writeLine(builder);
                }
            }
        } else if (MAXCOUNT < 短冊リスト.size()) {
            int totalPages = (int) Math.ceil((double) 短冊情報リスト.size() / PAGETWO_MAXCOUNT);
            for (int i = 0; i < 短冊リスト.size(); i++) {
                int page = (i + PAGETWO_MAXCOUNT) / PAGETWO_MAXCOUNT + 1;
                if (page <= totalPages) {
                    IJimuShinsakaishiryoA3Editor editor = new JimuShinsakaishiryoA3Group3Editor(
                            jimuTokkiTextA3Entity, 短冊リスト, i, page, reportId);
                    IJimuShinsakaishiryoA3Builder builder = new JimuShinsakaishiryoA3Builder(editor);
                    reportSourceWriter.writeLine(builder);
                }
            }
        }
        if (ReportIdDBE.DBE517903.getReportId().value().equals(reportId)) {
            IJimuShinsakaishiryoA3Editor editor1 = new JimuShinsakaishiryoA3Group4Editor(shinsakaiWariateJoho, reportId);
            IJimuShinsakaishiryoA3Builder builder1 = new JimuShinsakaishiryoA3Builder(editor1);
            reportSourceWriter.writeLine(builder1);
        }
        IJimuShinsakaishiryoA3Editor editor2 = new JimuShinsakaishiryoA3Group5Editor(sonotashiryoBusiness);
        IJimuShinsakaishiryoA3Builder builder2 = new JimuShinsakaishiryoA3Builder(editor2);
        reportSourceWriter.writeLine(builder2);
        for (JimuTuikaSiryoBusiness tuikaSiryoBusiness : tuikaSiryoBusinessList) {
            IJimuShinsakaishiryoA3Editor editor3 = new JimuShinsakaishiryoA3Group6Editor(tuikaSiryoBusiness);
            IJimuShinsakaishiryoA3Builder builder3 = new JimuShinsakaishiryoA3Builder(editor3);
            reportSourceWriter.writeLine(builder3);
        }
    }

    private List<RString> get短冊リスト(List<TokkiJikou> 短冊情報リスト) {
        List<RString> bodyList = new ArrayList<>();
        if (短冊情報リスト != null && !短冊情報リスト.isEmpty()) {
            for (TokkiJikou entity : 短冊情報リスト) {
                bodyList.add(entity.get事項番号());
                bodyList.add(entity.get項目名称());
            }
        }
        return bodyList;
    }
}
