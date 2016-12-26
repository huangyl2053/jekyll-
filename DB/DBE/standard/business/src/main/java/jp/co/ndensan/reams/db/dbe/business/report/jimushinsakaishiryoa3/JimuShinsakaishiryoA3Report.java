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
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事務局審査会資料組み合わせ一覧A3版のReportクラスです。
 *
 * @reamsid_L DBE-0150-190 lishengli
 */
public class JimuShinsakaishiryoA3Report extends Report<JimuShinsakaishiryoA3ReportSource> {

    private static final RString テキスト全面イメージ = new RString("1");
    private static final int INT_25 = 25;
    private static final int PAGECOUN = 15;
    private static final int MAXCOUNT = 30;
    private static final int PAGETWO_MAXCOUNT = 34;
    private final boolean is審査会対象一覧印刷済み;
    private final List<JimuShinsakaishiryoBusiness> shinsakaishiryoList;
    private final IchijihanteikekkahyoA3Entity jimuTokkiTextA3Entity;
    private final JimuShinsakaiWariateJohoBusiness shinsakaiWariateJoho;
    private final JimuSonotashiryoBusiness sonotashiryoBusiness;
    private final RString reportId;
    private final JimuTuikaSiryoBusiness 審査会追加資料;
    private final RString 作成条件;
    private final RString 作成条件_追加分 = new RString("追加分");

    /**
     * インスタンスを生成します。
     *
     * @param shinsakaishiryoList List<JimuShinsakaishiryoBusiness>
     * @param jimuTokkiTextA3Entity IchijihanteikekkahyoA3Entity
     * @param shinsakaiWariateJoho 主治医意見書のBusinessの編集クラス
     * @param sonotashiryoBusiness その他資料情報のBusinessの編集クラス
     * @param jimuTuikaSiryoBusiness 審査会追加資料のBusinessの編集クラス
     * @param reportId 帳票ＩＤ
     * @param is審査会対象一覧印刷済み is審査会対象一覧印刷済み
     * @param sakuseiJoken 作成条件
     */
    public JimuShinsakaishiryoA3Report(List<JimuShinsakaishiryoBusiness> shinsakaishiryoList,
            IchijihanteikekkahyoA3Entity jimuTokkiTextA3Entity, JimuShinsakaiWariateJohoBusiness shinsakaiWariateJoho,
            JimuSonotashiryoBusiness sonotashiryoBusiness, JimuTuikaSiryoBusiness jimuTuikaSiryoBusiness, RString reportId,
            boolean is審査会対象一覧印刷済み, RString sakuseiJoken) {
        this.shinsakaishiryoList = shinsakaishiryoList;
        this.jimuTokkiTextA3Entity = jimuTokkiTextA3Entity;
        this.shinsakaiWariateJoho = shinsakaiWariateJoho;
        this.sonotashiryoBusiness = sonotashiryoBusiness;
        this.審査会追加資料 = jimuTuikaSiryoBusiness;
        this.reportId = reportId;
        this.is審査会対象一覧印刷済み = is審査会対象一覧印刷済み;
        this.作成条件 = sakuseiJoken;
    }

    @Override
    public void writeBy(ReportSourceWriter<JimuShinsakaishiryoA3ReportSource> reportSourceWriter) {
        if (!is審査会対象一覧印刷済み) {
            write審査対象者一覧(reportSourceWriter);
        }
        List<TokkiJikou> 短冊情報リスト = new ArrayList<>();
        List<RString> 短冊リスト = new ArrayList<>();
        if (jimuTokkiTextA3Entity != null) {
            短冊情報リスト = jimuTokkiTextA3Entity.get特記事項_listChosa1();
            短冊リスト = get短冊リスト(短冊情報リスト);
            for (int i = 0; i < MAXCOUNT; i++) {
                IJimuShinsakaishiryoA3Editor editor = new JimuShinsakaishiryoA3Group2Editor(jimuTokkiTextA3Entity, 短冊リスト, i);
                IJimuShinsakaishiryoA3Builder builder = new JimuShinsakaishiryoA3Builder(editor);
                reportSourceWriter.writeLine(builder);
            }
        }
        if (shinsakaiWariateJoho != null && ReportIdDBE.DBE517902.getReportId().value().equals(reportId)) {
            IJimuShinsakaishiryoA3Editor editor1 = new JimuShinsakaishiryoA3Group4Editor(shinsakaiWariateJoho, reportId);
            IJimuShinsakaishiryoA3Builder builder1 = new JimuShinsakaishiryoA3Builder(editor1);
            reportSourceWriter.writeLine(builder1);
        }
        if (jimuTokkiTextA3Entity != null) {
            List<RString> テキスト全面List = jimuTokkiTextA3Entity.get特記事項_tokkiText();
            List<RString> イメージ全面List = jimuTokkiTextA3Entity.get特記事項_tokkiImg();
            if (テキスト全面イメージ.equals(jimuTokkiTextA3Entity.get特記パターン())) {
                全面Editor(reportSourceWriter, 短冊リスト, テキスト全面List, イメージ全面List);
            } else if (MAXCOUNT < 短冊リスト.size()) {
                短冊Editor(reportSourceWriter, 短冊リスト, 短冊情報リスト);
            }
        }
        if (shinsakaiWariateJoho != null && ReportIdDBE.DBE517903.getReportId().value().equals(reportId)) {
            IJimuShinsakaishiryoA3Editor editor1 = new JimuShinsakaishiryoA3Group4Editor(shinsakaiWariateJoho, reportId);
            IJimuShinsakaishiryoA3Builder builder1 = new JimuShinsakaishiryoA3Builder(editor1);
            reportSourceWriter.writeLine(builder1);
        }
        if (sonotashiryoBusiness != null) {
            List<RString> ファイルPathList = sonotashiryoBusiness.getその他資料();
            if (ファイルPathList != null && 0 < ファイルPathList.size()) {
                for (int i = 0; i < (int) Math.ceil((double) ファイルPathList.size() / 2); i++) {
                    IJimuShinsakaishiryoA3Editor editor2 = new JimuShinsakaishiryoA3Group5Editor(sonotashiryoBusiness, i + 1);
                    IJimuShinsakaishiryoA3Builder builder2 = new JimuShinsakaishiryoA3Builder(editor2);
                    reportSourceWriter.writeLine(builder2);
                }
            } else {
                IJimuShinsakaishiryoA3Editor editor2 = new JimuShinsakaishiryoA3Group5Editor(sonotashiryoBusiness, 0);
                IJimuShinsakaishiryoA3Builder builder2 = new JimuShinsakaishiryoA3Builder(editor2);
                reportSourceWriter.writeLine(builder2);
            }
        }
        
        if (審査会追加資料 != null && 作成条件_追加分.equals(作成条件)) {
            IJimuShinsakaishiryoA3Editor editor = new JimuShinsakaishiryoA3Group6Editor(審査会追加資料);
            IJimuShinsakaishiryoA3Builder builder = new JimuShinsakaishiryoA3Builder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private void write審査対象者一覧(ReportSourceWriter<JimuShinsakaishiryoA3ReportSource> reportSourceWriter) {
        for (int i = 0; i < INT_25; i++) {
            if (i < shinsakaishiryoList.size()) {
                IJimuShinsakaishiryoA3Editor editor = new JimuShinsakaishiryoA3Group1Editor(shinsakaishiryoList, i);
                IJimuShinsakaishiryoA3Builder builder = new JimuShinsakaishiryoA3Builder(editor);
                reportSourceWriter.writeLine(builder);
            }
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

    private void 全面Editor(ReportSourceWriter<JimuShinsakaishiryoA3ReportSource> reportSourceWriter,
            List<RString> 短冊リスト, List<RString> テキスト全面List, List<RString> イメージ全面List) {
        if (TokkijikoTextImageKubun.テキスト.getコード().equals(jimuTokkiTextA3Entity.get特記事項テキスト_イメージ区分())) {
            int totalPages = (int) Math.ceil((double) (テキスト全面List.size() - 1) / 2) + 1;
            for (int i = 0; i < テキスト全面List.size(); i++) {
                if ((i + 2) <= totalPages) {
                    IJimuShinsakaishiryoA3Editor editor = new JimuShinsakaishiryoA3Group3Editor(
                            jimuTokkiTextA3Entity, 短冊リスト, i + 2, i + 2, reportId);
                    IJimuShinsakaishiryoA3Builder builder = new JimuShinsakaishiryoA3Builder(editor);
                    reportSourceWriter.writeLine(builder);
                }
            }
        } else {
            int totalPages = (int) Math.ceil((double) (イメージ全面List.size() - 1) / 2) + 1;
            for (int i = 0; i < イメージ全面List.size(); i++) {
                if ((i + 2) <= totalPages) {
                    IJimuShinsakaishiryoA3Editor editor = new JimuShinsakaishiryoA3Group3Editor(
                            jimuTokkiTextA3Entity, 短冊リスト, i + 2, i + 2, reportId);
                    IJimuShinsakaishiryoA3Builder builder = new JimuShinsakaishiryoA3Builder(editor);
                    reportSourceWriter.writeLine(builder);
                }
            }
        }
    }

    private void 短冊Editor(ReportSourceWriter<JimuShinsakaishiryoA3ReportSource> reportSourceWriter,
            List<RString> 短冊リスト, List<TokkiJikou> 短冊情報リスト) {
        int totalPages = (int) Math.ceil((double) (短冊情報リスト.size() - PAGECOUN) / PAGETWO_MAXCOUNT) + 1;
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
}
