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
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.TokkiJikou;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iinshinsakaishiryoa3.IinShinsakaishiryoA3ReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 委員審査会資料組み合わせ一覧A3のReportクラスです。
 *
 * @reamsid_L DBE-0150-200 zhaoyao
 */
public class IinShinsakaishiryoA3Report extends Report<IinShinsakaishiryoA3ReportSource> {

    private static final RString テキスト全面イメージ = new RString("1");
    private static final int INT_25 = 25;
    private final RString 作成条件_追加分 = new RString("追加分");
    private final boolean is審査会対象一覧印刷済み;
    private final List<JimuShinsakaishiryoBusiness> shinsakaishiryoList;
    private final IchijihanteikekkahyoA3Entity ichijihanteikekkahyoA3Entity;
    private final JimuShinsakaiWariateJohoBusiness shinsakaiWariateJoho;
    private final JimuSonotashiryoBusiness sonotashiryoBusiness;
    private final JimuTuikaSiryoBusiness 審査会追加資料;
    private final RString 作成条件;
    private static final RString 印字 = new RString("1");
    private final RString printHou;
    private final RString 両面 = new RString("2");
    private static final int PAGECOUN = 15;
    private static final int MAXCOUNT = 30;
    private static final int PAGETWO_MAXCOUNT = 34;
    private final int 審査番号;

    /**
     * インスタンスを生成します。
     *
     * @param shinsakaishiryoList List<JimuShinsakaishiryoBusiness>
     * @param ichijihanteikekkahyoA3Entity 委員用特記事項+一次判定結果票（A3版）のEntityクラス
     * @param shinsakaiWariateJoho 主治医意見書のBusinessの編集クラス
     * @param sonotashiryoBusiness その他資料情報のBusinessの編集クラス
     * @param jimuTuikaSiryoBusiness 審査会追加資料のBusinessの編集クラス
     * @param is審査会対象一覧印刷済み 審査会対象一覧ページを印刷したか
     * @param sakuseiJoken 作成条件
     * @param printHou 印刷方法
     * @param 審査番号 審査対象者の何人目か
     */
    public IinShinsakaishiryoA3Report(
            List<JimuShinsakaishiryoBusiness> shinsakaishiryoList,
            IchijihanteikekkahyoA3Entity ichijihanteikekkahyoA3Entity,
            JimuShinsakaiWariateJohoBusiness shinsakaiWariateJoho,
            JimuSonotashiryoBusiness sonotashiryoBusiness,
            JimuTuikaSiryoBusiness jimuTuikaSiryoBusiness,
            boolean is審査会対象一覧印刷済み,
            RString sakuseiJoken,
            RString printHou,
            int 審査番号) {
        this.shinsakaishiryoList = shinsakaishiryoList;
        this.ichijihanteikekkahyoA3Entity = ichijihanteikekkahyoA3Entity;
        this.shinsakaiWariateJoho = shinsakaiWariateJoho;
        this.sonotashiryoBusiness = sonotashiryoBusiness;
        this.審査会追加資料 = jimuTuikaSiryoBusiness;
        this.is審査会対象一覧印刷済み = is審査会対象一覧印刷済み;
        this.作成条件 = sakuseiJoken;
        this.printHou = printHou;
        this.審査番号 = 審査番号;
    }

    @Override
    public void writeBy(ReportSourceWriter<IinShinsakaishiryoA3ReportSource> reportSourceWriter) {
        if (!is審査会対象一覧印刷済み) {
            for (int i = 0; i < INT_25; i++) {
                if (i < shinsakaishiryoList.size()) {
                    IIinShinsakaishiryoA3Editor editor = new IinShinsakaishiryoA3Group1Editor(shinsakaishiryoList, i);
                    IIinShinsakaishiryoA3Builder builder = new IinShinsakaishiryoA3Builder(editor);
                    reportSourceWriter.writeLine(builder);
                }
            }
        }
        if (両面.equals(this.printHou) && !reportSourceWriter.pageCount().isOdd()) {
            set余白ページ(reportSourceWriter);
        }
        List<TokkiJikou> 短冊情報リスト = new ArrayList<>();
        List<RString> 短冊リスト = new ArrayList<>();
        if (ichijihanteikekkahyoA3Entity != null) {
            短冊情報リスト = ichijihanteikekkahyoA3Entity.get特記事項_listChosa1();
            短冊リスト = get短冊リスト(短冊情報リスト);
            for (int i = 0; i < MAXCOUNT; i++) {
                IIinShinsakaishiryoA3Editor editor = new IinShinsakaishiryoA3Group2Editor(ichijihanteikekkahyoA3Entity, 短冊リスト, i, 審査番号);
                IIinShinsakaishiryoA3Builder builder = new IinShinsakaishiryoA3Builder(editor);
                reportSourceWriter.writeLine(builder);
            }
        }
        
        RString 印刷有無フラグ = DbBusinessConfig.get(ConfigNameDBE.特記と意見書の見開き印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (両面.equals(this.printHou)) {
            if (印字.equals(印刷有無フラグ)) {
                set主治医意見書(reportSourceWriter, true);
                set特記事項2枚目(reportSourceWriter, 短冊リスト, 短冊情報リスト);
            } else {
                set特記事項2枚目(reportSourceWriter, 短冊リスト, 短冊情報リスト);
                set主治医意見書(reportSourceWriter, true);
            }
        } else {
            set特記事項2枚目(reportSourceWriter, 短冊リスト, 短冊情報リスト);
            set主治医意見書(reportSourceWriter, false);
        }
        if (sonotashiryoBusiness != null) {
            List<RString> ファイルPathList = sonotashiryoBusiness.getその他資料イメージパスリスト();
            if (1 < ファイルPathList.size()) {
                for (int i = 0; i < (int) Math.ceil((double) ファイルPathList.size() / 2); i++) {
                    IIinShinsakaishiryoA3Editor editor2 = new IinShinsakaishiryoA3Group5Editor(sonotashiryoBusiness, i + 1);
                    IIinShinsakaishiryoA3Builder builder2 = new IinShinsakaishiryoA3Builder(editor2);
                    reportSourceWriter.writeLine(builder2);
                }
            } else {
                IIinShinsakaishiryoA3Editor editor2 = new IinShinsakaishiryoA3Group5Editor(sonotashiryoBusiness, 0);
                IIinShinsakaishiryoA3Builder builder2 = new IinShinsakaishiryoA3Builder(editor2);
                reportSourceWriter.writeLine(builder2);
            }
        }
        if (審査会追加資料 != null && 作成条件_追加分.equals(作成条件)) {
            IIinShinsakaishiryoA3Editor editor = new IinShinsakaishiryoA3Group6Editor(審査会追加資料);
            IIinShinsakaishiryoA3Builder builder = new IinShinsakaishiryoA3Builder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private void set主治医意見書(ReportSourceWriter<IinShinsakaishiryoA3ReportSource> reportSourceWriter, boolean is両面印刷) {
        if (is両面印刷 && reportSourceWriter.pageCount().isOdd()) {
            set余白ページ(reportSourceWriter);
        }
        IIinShinsakaishiryoA3Editor editor1 = new IinShinsakaishiryoA3Group4Editor(shinsakaiWariateJoho);
        IIinShinsakaishiryoA3Builder builder1 = new IinShinsakaishiryoA3Builder(editor1);
        reportSourceWriter.writeLine(builder1);
    }
    
    private void set余白ページ(ReportSourceWriter<IinShinsakaishiryoA3ReportSource> reportSourceWriter) {
        IIinShinsakaishiryoA3Editor editor1 = new BlankPageEditor();
        IinShinsakaishiryoA3Builder builder1 = new IinShinsakaishiryoA3Builder(editor1);
        reportSourceWriter.writeLine(builder1);
    }

    private void set特記事項2枚目(ReportSourceWriter<IinShinsakaishiryoA3ReportSource> reportSourceWriter,
            List<RString> 短冊リスト, List<TokkiJikou> 短冊情報リスト) {
        if (ichijihanteikekkahyoA3Entity != null) {
            List<RString> テキスト全面List = ichijihanteikekkahyoA3Entity.get特記事項_tokkiText();
            List<RString> イメージ全面List = ichijihanteikekkahyoA3Entity.get特記事項_tokkiImg();
            if (テキスト全面イメージ.equals(ichijihanteikekkahyoA3Entity.get特記パターン())) {
                全面Editor(reportSourceWriter, 短冊リスト, テキスト全面List, イメージ全面List);
            } else if (MAXCOUNT < 短冊リスト.size()) {
                短冊Editor(reportSourceWriter, 短冊リスト, 短冊情報リスト);
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

    private void 全面Editor(ReportSourceWriter<IinShinsakaishiryoA3ReportSource> reportSourceWriter,
            List<RString> 短冊リスト, List<RString> テキスト全面List, List<RString> イメージ全面List) {
        if (TokkijikoTextImageKubun.テキスト.getコード().equals(ichijihanteikekkahyoA3Entity.get特記事項テキスト_イメージ区分())) {
            int totalPages = (int) Math.ceil((double) (テキスト全面List.size() - 1) / 2) + 1;
            for (int i = 0; i < テキスト全面List.size(); i++) {
                if ((i + 2) <= totalPages) {
                    IIinShinsakaishiryoA3Editor editor = new IinShinsakaishiryoA3Group3Editor(
                            ichijihanteikekkahyoA3Entity, 短冊リスト, i + 2, i + 2);
                    IIinShinsakaishiryoA3Builder builder = new IinShinsakaishiryoA3Builder(editor);
                    reportSourceWriter.writeLine(builder);
                }
            }
        } else {
            int totalPages = (int) Math.ceil((double) (イメージ全面List.size() - 1) / 2) + 1;
            for (int i = 0; i < イメージ全面List.size(); i++) {
                if ((i + 2) <= totalPages) {
                    IIinShinsakaishiryoA3Editor editor = new IinShinsakaishiryoA3Group3Editor(
                            ichijihanteikekkahyoA3Entity, 短冊リスト, i + 2, i + 2);
                    IIinShinsakaishiryoA3Builder builder = new IinShinsakaishiryoA3Builder(editor);
                    reportSourceWriter.writeLine(builder);
                }
            }
        }
    }

    private void 短冊Editor(ReportSourceWriter<IinShinsakaishiryoA3ReportSource> reportSourceWriter,
            List<RString> 短冊リスト, List<TokkiJikou> 短冊情報リスト) {
        int totalPages = (int) Math.ceil((double) (短冊情報リスト.size() - PAGECOUN) / PAGETWO_MAXCOUNT) + 1;
        for (int i = 0; i < 短冊リスト.size(); i++) {
            int page = (i + PAGETWO_MAXCOUNT) / PAGETWO_MAXCOUNT + 1;
            if (page <= totalPages) {
                IIinShinsakaishiryoA3Editor editor = new IinShinsakaishiryoA3Group3Editor(
                        ichijihanteikekkahyoA3Entity, 短冊リスト, i, page);
                IIinShinsakaishiryoA3Builder builder = new IinShinsakaishiryoA3Builder(editor);
                reportSourceWriter.writeLine(builder);
            }
        }
    }
}
