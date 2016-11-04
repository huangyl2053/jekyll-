/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinshinsakaishiryoa3;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaiWariateJohoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaishiryoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuSonotashiryoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuTuikaSiryoBusiness;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.TokkiJikou;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.jimutokkitext.JimuTokkiTextA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iinshinsakaishiryoa3.IinShinsakaishiryoA3ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 委員審査会資料組み合わせ一覧A3のReportクラスです。
 *
 * @reamsid_L DBE-0150-200 zhaoyao
 */
public class IinShinsakaishiryoA3Report extends Report<IinShinsakaishiryoA3ReportSource> {

    private static final int INT_25 = 25;
    private final List<JimuShinsakaishiryoBusiness> shinsakaishiryoList;
    private final IchijihanteikekkahyoA3Entity ichijihanteikekkahyoA3Entity;
    private final JimuTokkiTextA3Entity tokkiTextBusiness;
    private final JimuShinsakaiWariateJohoBusiness shinsakaiWariateJoho;
    private final JimuSonotashiryoBusiness sonotashiryoBusiness;
    private final List<JimuTuikaSiryoBusiness> tuikaSiryoBusinessList;
    private final RString reportId;
    private static final int MAXCOUNT = 30;
    private static final int PAGETWO_MAXCOUNT = 34;

    /**
     * インスタンスを生成します。
     *
     * @param shinsakaishiryoList List<JimuShinsakaishiryoBusiness>
     * @param ichijihanteikekkahyoA3Entity 委員用特記事項+一次判定結果票（A3版）のEntityクラス
     * @param tokkiTextBusiness 特記事項2枚目以降のBusinessの編集クラス
     * @param shinsakaiWariateJoho 主治医意見書のBusinessの編集クラス
     * @param sonotashiryoBusiness その他資料情報のBusinessの編集クラス
     * @param tuikaSiryoBusinessList 追加資料鑑情報のBusinessの編集クラス
     * @param reportId 帳票ＩＤ
     */
    public IinShinsakaishiryoA3Report(
            List<JimuShinsakaishiryoBusiness> shinsakaishiryoList,
            IchijihanteikekkahyoA3Entity ichijihanteikekkahyoA3Entity,
            JimuTokkiTextA3Entity tokkiTextBusiness,
            JimuShinsakaiWariateJohoBusiness shinsakaiWariateJoho,
            JimuSonotashiryoBusiness sonotashiryoBusiness,
            List<JimuTuikaSiryoBusiness> tuikaSiryoBusinessList,
            RString reportId) {
        this.shinsakaishiryoList = shinsakaishiryoList;
        this.ichijihanteikekkahyoA3Entity = ichijihanteikekkahyoA3Entity;
        this.tokkiTextBusiness = tokkiTextBusiness;
        this.shinsakaiWariateJoho = shinsakaiWariateJoho;
        this.sonotashiryoBusiness = sonotashiryoBusiness;
        this.tuikaSiryoBusinessList = tuikaSiryoBusinessList;
        this.reportId = reportId;
    }

    @Override
    protected void writeBy(ReportSourceWriter<IinShinsakaishiryoA3ReportSource> reportSourceWriter) {
        for (int i = 0; i < INT_25; i++) {
            IIinShinsakaishiryoA3Editor editor = new IinShinsakaishiryoA3Group1Editor(shinsakaishiryoList, i);
            IIinShinsakaishiryoA3Builder builder = new IinShinsakaishiryoA3Builder(editor);
            reportSourceWriter.writeLine(builder);
        }
        List<TokkiJikou> 短冊情報リスト = ichijihanteikekkahyoA3Entity.get特記事項_listChosa1();
        List<RString> 短冊リスト = get短冊リスト(短冊情報リスト);
        int totalPages = (int) Math.ceil((double) 短冊情報リスト.size() / PAGETWO_MAXCOUNT);
        for (int i = 0; i < MAXCOUNT; i++) {
            IIinShinsakaishiryoA3Editor editor = new IinShinsakaishiryoA3Group2Editor(ichijihanteikekkahyoA3Entity, 短冊リスト, i);
            IIinShinsakaishiryoA3Builder builder = new IinShinsakaishiryoA3Builder(editor);
            reportSourceWriter.writeLine(builder);
        }
        if (ReportIdDBE.DBE517915.getReportId().value().equals(reportId)) {
            IIinShinsakaishiryoA3Editor editor1 = new IinShinsakaishiryoA3Group4Editor(shinsakaiWariateJoho);
            IIinShinsakaishiryoA3Builder builder1 = new IinShinsakaishiryoA3Builder(editor1);
            reportSourceWriter.writeLine(builder1);
        }
        if (MAXCOUNT < 短冊リスト.size()) {
            for (int i = 0; i < 短冊リスト.size(); i++) {
                int page = (i + PAGETWO_MAXCOUNT) / PAGETWO_MAXCOUNT + 1;
                if (page <= totalPages) {
                    IIinShinsakaishiryoA3Editor editor = new IinShinsakaishiryoA3Group3Editor(tokkiTextBusiness, 短冊リスト, i, page);
                    IIinShinsakaishiryoA3Builder builder = new IinShinsakaishiryoA3Builder(editor);
                    reportSourceWriter.writeLine(builder);
                }
            }
        }
        if (ReportIdDBE.DBE517916.getReportId().value().equals(reportId)) {
            IIinShinsakaishiryoA3Editor editor1 = new IinShinsakaishiryoA3Group4Editor(shinsakaiWariateJoho);
            IIinShinsakaishiryoA3Builder builder1 = new IinShinsakaishiryoA3Builder(editor1);
            reportSourceWriter.writeLine(builder1);
        }
        IIinShinsakaishiryoA3Editor editor2 = new IinShinsakaishiryoA3Group5Editor(sonotashiryoBusiness);
        IIinShinsakaishiryoA3Builder builder2 = new IinShinsakaishiryoA3Builder(editor2);
        reportSourceWriter.writeLine(builder2);
        for (JimuTuikaSiryoBusiness tuikaSiryoBusiness : tuikaSiryoBusinessList) {
            IIinShinsakaishiryoA3Editor editor3 = new IinShinsakaishiryoA3Group6Editor(tuikaSiryoBusiness);
            IIinShinsakaishiryoA3Builder builder3 = new IinShinsakaishiryoA3Builder(editor3);
            reportSourceWriter.writeLine(builder3);
        }
    }

    private List<RString> get短冊リスト(List<TokkiJikou> 短冊情報リスト) {
        List<RString> bodyList = new ArrayList<>();
        if (!短冊情報リスト.isEmpty()) {
            for (TokkiJikou entity : 短冊情報リスト) {
                bodyList.add(entity.get事項番号());
                bodyList.add(entity.get項目名称());
            }
        }
        return bodyList;
    }
}
