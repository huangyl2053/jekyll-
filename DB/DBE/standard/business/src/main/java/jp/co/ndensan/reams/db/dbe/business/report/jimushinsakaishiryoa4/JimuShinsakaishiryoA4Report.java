/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jimushinsakaishiryoa4;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaiWariateJohoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaishiryoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuSonotashiryoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuTuikaSiryoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.TokkiText1A4Business;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA4Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitexta4.TokkiA4Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jimushinsakaishiryoa4.JimuShinsakaishiryoA4ReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事務局審査会資料組み合わせ一覧A4版のReportクラスです。
 *
 * @reamsid_L DBE-0150-190 lishengli
 */
public class JimuShinsakaishiryoA4Report extends Report<JimuShinsakaishiryoA4ReportSource> {

    private static final int LENGTH_20 = 20;
    private static final int MAXCOUNT = 30;
    private static final RString テキスト全面イメージ = new RString("1");
    private final boolean is審査会対象一覧印刷済み;
    private final List<JimuShinsakaishiryoBusiness> shinsakaishiryoList;
    private final IchijihanteikekkahyoA4Entity ichijihanteiEntity;
    private final TokkiText1A4Business tokkiTextBusiness;
    private final JimuShinsakaiWariateJohoBusiness shinsakaiWariateJoho;
    private final JimuSonotashiryoBusiness sonotashiryoBusiness;
    private final JimuTuikaSiryoBusiness 審査会追加資料;
    private final RString 作成条件;
    private final RString 作成条件_追加分 = new RString("追加分");
    private static final RString 印字 = new RString("1");
    private final RString printHou;
    private final RString 両面 = new RString("2");

    /**
     * インスタンスを生成します。
     *
     * @param shinsakaishiryoList List<JimuShinsakaishiryoBusiness>
     * @param ichijihanteiEntity IchijihanteikekkahyoA4Entity
     * @param tokkiTextBusiness 特記事項の編集クラス
     * @param shinsakaiWariateJoho 主治医意見書のBusinessの編集クラス
     * @param sonotashiryoBusiness その他資料情報のBusinessの編集クラス
     * @param is審査会対象一覧印刷済み is審査会対象一覧印刷済み
     * @param jimuTuikaSiryoBusiness 審査会追加資料のBusinessの編集クラス
     * @param sakuseiJoken 作成条件
     * @param printHou 印刷方法
     */
    public JimuShinsakaishiryoA4Report(List<JimuShinsakaishiryoBusiness> shinsakaishiryoList,
            IchijihanteikekkahyoA4Entity ichijihanteiEntity, TokkiText1A4Business tokkiTextBusiness,
            JimuShinsakaiWariateJohoBusiness shinsakaiWariateJoho, JimuSonotashiryoBusiness sonotashiryoBusiness,
            boolean is審査会対象一覧印刷済み, JimuTuikaSiryoBusiness jimuTuikaSiryoBusiness, RString sakuseiJoken, RString printHou) {
        this.shinsakaishiryoList = shinsakaishiryoList;
        this.ichijihanteiEntity = ichijihanteiEntity;
        this.tokkiTextBusiness = tokkiTextBusiness;
        this.shinsakaiWariateJoho = shinsakaiWariateJoho;
        this.sonotashiryoBusiness = sonotashiryoBusiness;
        this.is審査会対象一覧印刷済み = is審査会対象一覧印刷済み;
        this.審査会追加資料 = jimuTuikaSiryoBusiness;
        this.作成条件 = sakuseiJoken;
        this.printHou = printHou;
    }

    @Override
    public void writeBy(ReportSourceWriter<JimuShinsakaishiryoA4ReportSource> reportSourceWriter) {
        if (!is審査会対象一覧印刷済み) {
            for (JimuShinsakaishiryoBusiness business : shinsakaishiryoList) {
                IJimuShinsakaishiryoA4Editor editor = new JimuShinsakaishiryoA4Group1Editor(business);
                IJimuShinsakaishiryoA4Builder builder = new JimuShinsakaishiryoA4Builder(editor);
                reportSourceWriter.writeLine(builder);
            }
        }
        if (ichijihanteiEntity != null) {
            for (int i = 0; i < LENGTH_20; i++) {
                IJimuShinsakaishiryoA4Editor editor = new JimuShinsakaishiryoA4Group2Editor(ichijihanteiEntity, i);
                IJimuShinsakaishiryoA4Builder builder = new JimuShinsakaishiryoA4Builder(editor);
                reportSourceWriter.writeLine(builder);
            }
        }
        List<TokkiA4Entity> 短冊情報リスト = new ArrayList<>();
        List<RString> 短冊リスト = new ArrayList<>();
        List<RString> テキスト全面List = new ArrayList<>();
        List<RString> イメージ全面List = new ArrayList<>();
        if (tokkiTextBusiness != null) {
            短冊情報リスト = tokkiTextBusiness.get短冊情報リスト();
            短冊リスト = get短冊リスト(短冊情報リスト);
            テキスト全面List = tokkiTextBusiness.getTokkiText();
            イメージ全面List = tokkiTextBusiness.getTokkiImg();
            if (テキスト全面イメージ.equals(tokkiTextBusiness.get特記パターン())) {
                IJimuShinsakaishiryoA4Editor editor1 = new JimuShinsakaishiryoA4Group3Editor(
                        tokkiTextBusiness, 短冊情報リスト, 短冊リスト, テキスト全面List, イメージ全面List, 0);
                IJimuShinsakaishiryoA4Builder builder = new JimuShinsakaishiryoA4Builder(editor1);
                reportSourceWriter.writeLine(builder);
            } else {
                for (int i = 0; i < 短冊リスト.size(); i++) {
                    短冊情報ページ1Editor(reportSourceWriter, i, 短冊情報リスト, 短冊リスト, テキスト全面List, イメージ全面List);
                }
            }
        }
        RString 印刷有無フラグ = DbBusinessConfig.get(ConfigNameDBE.特記と意見書の見開き印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (両面.equals(this.printHou) && 印字.equals(印刷有無フラグ)) {
            set主治医意見書(reportSourceWriter);
            set特記事項(reportSourceWriter, 短冊情報リスト, 短冊リスト, テキスト全面List, イメージ全面List);
        } else {
            set特記事項(reportSourceWriter, 短冊情報リスト, 短冊リスト, テキスト全面List, イメージ全面List);
            set主治医意見書(reportSourceWriter);
        }
        if (sonotashiryoBusiness != null && !sonotashiryoBusiness.getその他資料イメージパスリスト().isEmpty()) {
            List<RString> ファイルPathList = sonotashiryoBusiness.getその他資料イメージパスリスト();
            if (ファイルPathList != null && 0 < ファイルPathList.size()) {
                for (int i = 0; i < ファイルPathList.size(); i++) {
                    IJimuShinsakaishiryoA4Editor editor2 = new JimuShinsakaishiryoA4Group7Editor(sonotashiryoBusiness, i);
                    IJimuShinsakaishiryoA4Builder builder2 = new JimuShinsakaishiryoA4Builder(editor2);
                    reportSourceWriter.writeLine(builder2);
                }
            } else {
                IJimuShinsakaishiryoA4Editor editor2 = new JimuShinsakaishiryoA4Group7Editor(sonotashiryoBusiness, 0);
                IJimuShinsakaishiryoA4Builder builder2 = new JimuShinsakaishiryoA4Builder(editor2);
                reportSourceWriter.writeLine(builder2);
            }
        }
        get審査会追加資料(reportSourceWriter);
    }

    private void set特記事項(ReportSourceWriter<JimuShinsakaishiryoA4ReportSource> reportSourceWriter,
            List<TokkiA4Entity> 短冊情報リスト, List<RString> 短冊リスト, List<RString> テキスト全面List, List<RString> イメージ全面List) {
        if (tokkiTextBusiness != null) {
            if (テキスト全面イメージ.equals(tokkiTextBusiness.get特記パターン())) {
                テキスト全面Editor(reportSourceWriter, 短冊情報リスト, 短冊リスト, テキスト全面List, イメージ全面List);
            } else {
                for (int i = 0; i < 短冊リスト.size(); i++) {
                    短冊情報Editor(reportSourceWriter, i, 短冊情報リスト, 短冊リスト, テキスト全面List, イメージ全面List);
                }
            }
        }
    }

    private void set主治医意見書(ReportSourceWriter<JimuShinsakaishiryoA4ReportSource> reportSourceWriter) {
        if (shinsakaiWariateJoho != null && !RString.isNullOrEmpty(shinsakaiWariateJoho.get主治医意見書イメージ１())) {
            IJimuShinsakaishiryoA4Editor editor = new JimuShinsakaishiryoA4Group5Editor(shinsakaiWariateJoho);
            IJimuShinsakaishiryoA4Builder builder = new JimuShinsakaishiryoA4Builder(editor);
            reportSourceWriter.writeLine(builder);
            if (!RString.isNullOrEmpty(shinsakaiWariateJoho.get主治医意見書イメージ２())) {
                IJimuShinsakaishiryoA4Editor editor1 = new JimuShinsakaishiryoA4Group6Editor(shinsakaiWariateJoho);
                IJimuShinsakaishiryoA4Builder builder1 = new JimuShinsakaishiryoA4Builder(editor1);
                reportSourceWriter.writeLine(builder1);
            }
        }
    }

    private void get審査会追加資料(ReportSourceWriter<JimuShinsakaishiryoA4ReportSource> reportSourceWriter) {
        if (審査会追加資料 != null && 作成条件_追加分.equals(作成条件)) {
            IJimuShinsakaishiryoA4Editor editor = new JimuShinsakaishiryoA4Group8Editor(審査会追加資料);
            IJimuShinsakaishiryoA4Builder builder = new JimuShinsakaishiryoA4Builder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<RString> get短冊リスト(List<TokkiA4Entity> 短冊情報リスト) {
        List<RString> bodyList = new ArrayList<>();
        if (短冊情報リスト != null && !短冊情報リスト.isEmpty()) {
            for (TokkiA4Entity entity : 短冊情報リスト) {
                bodyList.add(entity.get事項番号());
                bodyList.add(entity.get項目名称());
            }
        }
        return bodyList;
    }

    private void テキスト全面Editor(ReportSourceWriter<JimuShinsakaishiryoA4ReportSource> reportSourceWriter,
            List<TokkiA4Entity> 短冊情報リスト, List<RString> 短冊リスト, List<RString> テキスト全面List, List<RString> イメージ全面List) {
        if (TokkijikoTextImageKubun.テキスト.getコード().equals(tokkiTextBusiness.get特記事項テキスト_イメージ区分())) {
            for (int i = 0; i < テキスト全面List.size(); i++) {
                if (0 < i) {
                    IJimuShinsakaishiryoA4Editor editor2 = new JimuShinsakaishiryoA4Group4Editor(
                            tokkiTextBusiness, 短冊情報リスト, 短冊リスト, テキスト全面List, イメージ全面List, i, i + 1);
                    IJimuShinsakaishiryoA4Builder builder2 = new JimuShinsakaishiryoA4Builder(editor2);
                    reportSourceWriter.writeLine(builder2);
                }
            }
        } else {
            for (int i = 0; i < イメージ全面List.size(); i++) {
                if (0 < i) {
                    IJimuShinsakaishiryoA4Editor editor2 = new JimuShinsakaishiryoA4Group4Editor(
                            tokkiTextBusiness, 短冊情報リスト, 短冊リスト, テキスト全面List, イメージ全面List, i, i + 1);
                    IJimuShinsakaishiryoA4Builder builder2 = new JimuShinsakaishiryoA4Builder(editor2);
                    reportSourceWriter.writeLine(builder2);
                }
            }
        }
    }

    private void 短冊情報Editor(ReportSourceWriter<JimuShinsakaishiryoA4ReportSource> reportSourceWriter, int i,
            List<TokkiA4Entity> 短冊情報リスト, List<RString> 短冊リスト, List<RString> テキスト全面List, List<RString> イメージ全面List) {
        if (MAXCOUNT <= i) {
            int page = (i + MAXCOUNT) / MAXCOUNT;
            IJimuShinsakaishiryoA4Editor editor2 = new JimuShinsakaishiryoA4Group4Editor(
                    tokkiTextBusiness, 短冊情報リスト, 短冊リスト, テキスト全面List, イメージ全面List, i, page);
            IJimuShinsakaishiryoA4Builder builder2 = new JimuShinsakaishiryoA4Builder(editor2);
            reportSourceWriter.writeLine(builder2);
        }
    }

    private void 短冊情報ページ1Editor(ReportSourceWriter<JimuShinsakaishiryoA4ReportSource> reportSourceWriter, int i,
            List<TokkiA4Entity> 短冊情報リスト, List<RString> 短冊リスト, List<RString> テキスト全面List, List<RString> イメージ全面List) {
        if (i < MAXCOUNT) {
            IJimuShinsakaishiryoA4Editor editor1 = new JimuShinsakaishiryoA4Group3Editor(
                    tokkiTextBusiness, 短冊情報リスト, 短冊リスト, テキスト全面List, イメージ全面List, i);
            IJimuShinsakaishiryoA4Builder builder = new JimuShinsakaishiryoA4Builder(editor1);
            reportSourceWriter.writeLine(builder);
        }
    }
}
