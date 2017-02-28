/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.yokaigoninteijohoteikyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoikenitem.ShujiiIkenshoIkenItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyochosaitem.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokinyuitem.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyo.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyoflag.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.NinteichosaRelate;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.ichijihanteikekkahyo.IchijihanteikekkahyoEntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo02.NinteiChosaJohohyo02EntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo12.NinteiChosaJohohyo12EntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo22.NinteiChosaJohohyo22EntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo32.NinteiChosaJohohyo32EntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo42.NinteiChosaJohohyo42EntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo52.NinteiChosaJohohyo52EntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokkiimage.NinteiChosaTokkiImageEntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho1.ShujiiikenshoEntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.sonotashiryo.SonoTashiryoEntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.tokkitext1a4.TokkiImage1A4SeparateEditor;
import jp.co.ndensan.reams.db.dbe.business.report.tokkitext1a4.TokkiText1A4AllEditor;
import jp.co.ndensan.reams.db.dbe.business.report.tokkitext1a4.TokkiText1A4SeparateEditor;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki.JohoTeikyoIsshikiIchijihanteikekkahyoReport;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki.JohoTeikyoIsshikiNinteiChosaJohohyo02Report;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki.JohoTeikyoIsshikiNinteiChosaJohohyo12Report;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki.JohoTeikyoIsshikiNinteiChosaJohohyo22Report;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki.JohoTeikyoIsshikiNinteiChosaJohohyo32Report;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki.JohoTeikyoIsshikiNinteiChosaJohohyo42Report;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki.JohoTeikyoIsshikiNinteiChosaJohohyo52Report;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki.JohoTeikyoIsshikiNinteiChosaTokkiImageReport;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki.JohoTeikyoIsshikiProperty;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki.JohoTeikyoIsshikiShujiiikenshoReport;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki.JohoTeikyoIsshikiSonoTashiryoReport;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki.JohoTeikyoIsshikiTokkiImage1A4SeparateReport;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki.JohoTeikyoIsshikiTokkiText1A4Report;
import jp.co.ndensan.reams.db.dbe.entity.report.source.yokaigoninteijohoteikyoisshiki.YokaigoNinteiJohoTeikyoIsshikiReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.SharedFileEntryInfoEntity;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 要介護認定情報提供一式のPrinterクラスです。
 *
 * @author N3212 竹内 和紀
 */
public class YokaigoNinteiJohoTeikyoPrintService {

    private static final RString 総合事業未実施 = new RString("1");
    private static final RString 総合事業実施済 = new RString("2");
    private static final RString すべて = new RString("1");
    private static final RString FILENAME_A_BAK = new RString("F1401A01_BAK.png");
    private static final RString FILENAME_A = new RString("F1401A01.png");
    private static final RString FILENAME_B_BAK = new RString("F1401B02_BAK.png");
    private static final RString FILENAME_B = new RString("F1401B02.png");
    private static final RString FILENAME_C_BAK = new RString("F1401C03_BAK.png");
    private static final RString FILENAME_C = new RString("F1401C03.png");
    private static final RString FILENAME_D_BAK = new RString("F1401D04_BAK.png");
    private static final RString FILENAME_D = new RString("F1401D04.png");
    private static final RString FILENAME_E_BAK = new RString("F1401E05_BAK.png");
    private static final RString FILENAME_E = new RString("F1401E05.png");
    private static final RString FILENAME_F_BAK = new RString("F1401F06_BAK.png");
    private static final RString FILENAME_F = new RString("F1401F06.png");
    private static final RString マスキングあり = new RString("1");
    private static final RString SEPARATOR = new RString("/");

    private final ReportManager reportManager;

    /**
     * コンストラクタです。
     *
     * @param reportManager ReportManager
     */
    public YokaigoNinteiJohoTeikyoPrintService(ReportManager reportManager) {
        this.reportManager = reportManager;
    }

    /**
     * 要介護認定情報提供一式を印刷します。
     *
     * @param is認定調査票出力 is認定調査票出力
     * @param is特記事項出力 is特記事項出力
     * @param is主治医意見書出力 is主治医意見書出力
     * @param isその他資料出力 isその他資料出力
     * @param is一次判定結果出力 is一次判定結果出力
     * @param 認定調査票マスキング区分 認定調査票マスキング区分
     * @param 特記事項マスキング区分 特記事項マスキング区分
     * @param 主治医意見書マスキング区分 主治医意見書マスキング区分
     * @param その他資料マスキング区分 その他資料マスキング区分
     * @param 一次判定結果マスキング区分 一次判定結果マスキング区分
     * @param business YokaigoNinteiJohoTeikyoBusiness
     * @param イメージ共有ファイルID イメージ共有ファイルID
     * @param 認定調査票サービス状況List 認定調査票サービス状況List
     * @param 認定調査票サービス状況フラグList 認定調査票サービス状況フラグList
     * @param 認定調査票調査項目List 認定調査票調査項目List
     * @param 認定調査票記入項目List 認定調査票記入項目List
     * @param 総合事業開始区分 総合事業開始区分
     * @param 特記事項区分List 特記事項区分List
     * @param 特記事項List 特記事項List
     * @param 認定調査特記事項番号List 認定調査特記事項番号List
     * @param 前回認定調査票調査項目List 前回認定調査票調査項目List
     * @param 主治医意見書意見項目List 主治医意見書意見項目List
     * @param 前回主治医意見書意見項目List 前回主治医意見書意見項目List
     * @param 正常選択肢印刷有無 正常選択肢印刷有無
     * @param 認定調査前回結果印刷有無 認定調査前回結果印刷有無
     */
    public void print(boolean is認定調査票出力,
            boolean is特記事項出力,
            boolean is主治医意見書出力,
            boolean isその他資料出力,
            boolean is一次判定結果出力,
            RString 認定調査票マスキング区分,
            RString 特記事項マスキング区分,
            RString 主治医意見書マスキング区分,
            RString その他資料マスキング区分,
            RString 一次判定結果マスキング区分,
            YokaigoNinteiJohoTeikyoBusiness business,
            RDateTime イメージ共有ファイルID,
            List<NinteichosahyoServiceJokyo> 認定調査票サービス状況List,
            List<NinteichosahyoServiceJokyoFlag> 認定調査票サービス状況フラグList,
            List<NinteichosahyoChosaItem> 認定調査票調査項目List,
            List<NinteichosahyoKinyuItem> 認定調査票記入項目List,
            RString 総合事業開始区分,
            List<RString> 特記事項区分List,
            List<NinteichosaRelate> 特記事項List,
            List<RString> 認定調査特記事項番号List,
            List<NinteichosahyoChosaItem> 前回認定調査票調査項目List,
            List<ShujiiIkenshoIkenItem> 主治医意見書意見項目List,
            List<ShujiiIkenshoIkenItem> 前回主治医意見書意見項目List,
            RString 正常選択肢印刷有無,
            RString 認定調査前回結果印刷有無) {
        try (ReportAssembler<YokaigoNinteiJohoTeikyoIsshikiReportSource> assembler
                = createAssembler(new JohoTeikyoIsshikiProperty(), reportManager)) {
            if (is認定調査票出力) {
                print認定調査票(business, イメージ共有ファイルID, 認定調査票サービス状況List, 認定調査票サービス状況フラグList,
                        認定調査票調査項目List, 認定調査票記入項目List, 認定調査票マスキング区分, 総合事業開始区分, assembler);
            }
            if (is特記事項出力) {
                print特記事項(business, 特記事項区分List, 特記事項List, 特記事項マスキング区分, イメージ共有ファイルID, assembler);
            }
            if (is主治医意見書出力) {
                print主治医意見書(business, イメージ共有ファイルID, 主治医意見書マスキング区分, assembler);
            }
            if (isその他資料出力) {
                printその他資料(business, イメージ共有ファイルID, その他資料マスキング区分, assembler);
            }
            if (is一次判定結果出力) {
                print一次判定結果(business, 認定調査特記事項番号List, 認定調査票サービス状況List, 認定調査票サービス状況フラグList,
                        認定調査票調査項目List, 前回認定調査票調査項目List, 主治医意見書意見項目List, 前回主治医意見書意見項目List,
                        一次判定結果マスキング区分, 正常選択肢印刷有無, 認定調査前回結果印刷有無, assembler);
            }
        }
    }

    private void print認定調査票(YokaigoNinteiJohoTeikyoBusiness business,
            RDateTime イメージ共有ファイルID,
            List<NinteichosahyoServiceJokyo> 認定調査票サービス状況List,
            List<NinteichosahyoServiceJokyoFlag> 認定調査票サービス状況フラグList,
            List<NinteichosahyoChosaItem> 認定調査票調査項目List,
            List<NinteichosahyoKinyuItem> 認定調査票記入項目List,
            RString 認定調査票マスキング区分,
            RString 総合事業開始区分,
            ReportAssembler<YokaigoNinteiJohoTeikyoIsshikiReportSource> assembler) {
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(business.get厚労省IF識別コード())) {
            if (総合事業実施済.equals(総合事業開始区分)) {
                printNinteiChosaJohohyo09BSogojigyo(business, イメージ共有ファイルID, 認定調査票サービス状況List,
                        認定調査票サービス状況フラグList, 認定調査票調査項目List, 認定調査票記入項目List, 認定調査票マスキング区分, assembler);
            } else if (総合事業未実施.equals(総合事業開始区分)) {
                printNinteiChosaJohohyo09B(business, イメージ共有ファイルID, 認定調査票サービス状況List,
                        認定調査票サービス状況フラグList, 認定調査票調査項目List, 認定調査票記入項目List, 認定調査票マスキング区分, assembler);
            }
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(business.get厚労省IF識別コード())) {
            printNinteiChosaJohohyo09A(business, イメージ共有ファイルID, 認定調査票サービス状況List,
                    認定調査票サービス状況フラグList, 認定調査票調査項目List, 認定調査票記入項目List, 認定調査票マスキング区分, assembler);
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(business.get厚労省IF識別コード())) {
            printNinteiChosaJohohyo06A(business, イメージ共有ファイルID, 認定調査票サービス状況List,
                    認定調査票サービス状況フラグList, 認定調査票調査項目List, 認定調査票記入項目List, 認定調査票マスキング区分, assembler);
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(business.get厚労省IF識別コード())) {
            printNinteiChosaJohohyo02A(business, イメージ共有ファイルID, 認定調査票サービス状況List,
                    認定調査票サービス状況フラグList, 認定調査票調査項目List, 認定調査票記入項目List, 認定調査票マスキング区分, assembler);
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(business.get厚労省IF識別コード())) {
            printNinteiChosaJohohyo99A(business, イメージ共有ファイルID, 認定調査票サービス状況List,
                    認定調査票サービス状況フラグList, 認定調査票調査項目List, 認定調査票記入項目List, 認定調査票マスキング区分, assembler);
        }
    }

    private void printNinteiChosaJohohyo09BSogojigyo(YokaigoNinteiJohoTeikyoBusiness business,
            RDateTime イメージ共有ファイルID,
            List<NinteichosahyoServiceJokyo> 認定調査票サービス状況List,
            List<NinteichosahyoServiceJokyoFlag> 認定調査票サービス状況フラグList,
            List<NinteichosahyoChosaItem> 認定調査票調査項目List,
            List<NinteichosahyoKinyuItem> 認定調査票記入項目List,
            RString 認定調査票マスキング区分,
            ReportAssembler<YokaigoNinteiJohoTeikyoIsshikiReportSource> assembler) {
        ReportSourceWriter<YokaigoNinteiJohoTeikyoIsshikiReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
        JohoTeikyoIsshikiNinteiChosaJohohyo02Report report = new JohoTeikyoIsshikiNinteiChosaJohohyo02Report(
                NinteiChosaJohohyo02EntityEditor.edit(business.toEntity(), 認定調査票サービス状況List, 認定調査票サービス状況フラグList,
                        認定調査票調査項目List, 認定調査票記入項目List, イメージ共有ファイルID, 認定調査票マスキング区分));
        report.writeBy(reportSourceWriter);
    }

    private void printNinteiChosaJohohyo09B(YokaigoNinteiJohoTeikyoBusiness business,
            RDateTime イメージ共有ファイルID,
            List<NinteichosahyoServiceJokyo> 認定調査票サービス状況List,
            List<NinteichosahyoServiceJokyoFlag> 認定調査票サービス状況フラグList,
            List<NinteichosahyoChosaItem> 認定調査票調査項目List,
            List<NinteichosahyoKinyuItem> 認定調査票記入項目List,
            RString 認定調査票マスキング区分,
            ReportAssembler<YokaigoNinteiJohoTeikyoIsshikiReportSource> assembler) {
        ReportSourceWriter<YokaigoNinteiJohoTeikyoIsshikiReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
        JohoTeikyoIsshikiNinteiChosaJohohyo12Report report = new JohoTeikyoIsshikiNinteiChosaJohohyo12Report(
                NinteiChosaJohohyo12EntityEditor.edit(business.toEntity(), 認定調査票サービス状況List, 認定調査票サービス状況フラグList,
                        認定調査票調査項目List, 認定調査票記入項目List, イメージ共有ファイルID, 認定調査票マスキング区分));
        report.writeBy(reportSourceWriter);
    }

    private void printNinteiChosaJohohyo09A(YokaigoNinteiJohoTeikyoBusiness business,
            RDateTime イメージ共有ファイルID,
            List<NinteichosahyoServiceJokyo> 認定調査票サービス状況List,
            List<NinteichosahyoServiceJokyoFlag> 認定調査票サービス状況フラグList,
            List<NinteichosahyoChosaItem> 認定調査票調査項目List,
            List<NinteichosahyoKinyuItem> 認定調査票記入項目List,
            RString 認定調査票マスキング区分,
            ReportAssembler<YokaigoNinteiJohoTeikyoIsshikiReportSource> assembler) {
        ReportSourceWriter<YokaigoNinteiJohoTeikyoIsshikiReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
        JohoTeikyoIsshikiNinteiChosaJohohyo22Report report = new JohoTeikyoIsshikiNinteiChosaJohohyo22Report(
                NinteiChosaJohohyo22EntityEditor.edit(business.toEntity(), 認定調査票サービス状況List, 認定調査票サービス状況フラグList,
                        認定調査票調査項目List, 認定調査票記入項目List, イメージ共有ファイルID, 認定調査票マスキング区分));
        report.writeBy(reportSourceWriter);
    }

    private void printNinteiChosaJohohyo06A(YokaigoNinteiJohoTeikyoBusiness business,
            RDateTime イメージ共有ファイルID,
            List<NinteichosahyoServiceJokyo> 認定調査票サービス状況List,
            List<NinteichosahyoServiceJokyoFlag> 認定調査票サービス状況フラグList,
            List<NinteichosahyoChosaItem> 認定調査票調査項目List,
            List<NinteichosahyoKinyuItem> 認定調査票記入項目List,
            RString 認定調査票マスキング区分,
            ReportAssembler<YokaigoNinteiJohoTeikyoIsshikiReportSource> assembler) {
        ReportSourceWriter<YokaigoNinteiJohoTeikyoIsshikiReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
        JohoTeikyoIsshikiNinteiChosaJohohyo32Report report = new JohoTeikyoIsshikiNinteiChosaJohohyo32Report(
                NinteiChosaJohohyo32EntityEditor.edit(business.toEntity(), 認定調査票サービス状況List, 認定調査票サービス状況フラグList,
                        認定調査票調査項目List, 認定調査票記入項目List, イメージ共有ファイルID, 認定調査票マスキング区分));
        report.writeBy(reportSourceWriter);
    }

    private void printNinteiChosaJohohyo02A(YokaigoNinteiJohoTeikyoBusiness business,
            RDateTime イメージ共有ファイルID,
            List<NinteichosahyoServiceJokyo> 認定調査票サービス状況List,
            List<NinteichosahyoServiceJokyoFlag> 認定調査票サービス状況フラグList,
            List<NinteichosahyoChosaItem> 認定調査票調査項目List,
            List<NinteichosahyoKinyuItem> 認定調査票記入項目List,
            RString 認定調査票マスキング区分,
            ReportAssembler<YokaigoNinteiJohoTeikyoIsshikiReportSource> assembler) {
        ReportSourceWriter<YokaigoNinteiJohoTeikyoIsshikiReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
        JohoTeikyoIsshikiNinteiChosaJohohyo42Report report = new JohoTeikyoIsshikiNinteiChosaJohohyo42Report(
                NinteiChosaJohohyo42EntityEditor.edit(business.toEntity(), 認定調査票サービス状況List, 認定調査票サービス状況フラグList,
                        認定調査票調査項目List, 認定調査票記入項目List, イメージ共有ファイルID, 認定調査票マスキング区分));
        report.writeBy(reportSourceWriter);
    }

    private void printNinteiChosaJohohyo99A(YokaigoNinteiJohoTeikyoBusiness business,
            RDateTime イメージ共有ファイルID,
            List<NinteichosahyoServiceJokyo> 認定調査票サービス状況List,
            List<NinteichosahyoServiceJokyoFlag> 認定調査票サービス状況フラグList,
            List<NinteichosahyoChosaItem> 認定調査票調査項目List,
            List<NinteichosahyoKinyuItem> 認定調査票記入項目List,
            RString 認定調査票マスキング区分,
            ReportAssembler<YokaigoNinteiJohoTeikyoIsshikiReportSource> assembler) {
        ReportSourceWriter<YokaigoNinteiJohoTeikyoIsshikiReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
        JohoTeikyoIsshikiNinteiChosaJohohyo52Report report = new JohoTeikyoIsshikiNinteiChosaJohohyo52Report(
                NinteiChosaJohohyo52EntityEditor.edit(business.toEntity(), 認定調査票サービス状況List, 認定調査票サービス状況フラグList,
                        認定調査票調査項目List, 認定調査票記入項目List, イメージ共有ファイルID, 認定調査票マスキング区分));
        report.writeBy(reportSourceWriter);
    }

    private void print特記事項(YokaigoNinteiJohoTeikyoBusiness business,
            List<RString> 特記事項区分List,
            List<NinteichosaRelate> 特記事項List,
            RString 特記事項マスキング区分,
            RDateTime イメージ共有ファイルID,
            ReportAssembler<YokaigoNinteiJohoTeikyoIsshikiReportSource> assembler) {
        RString 情報提供資料の特記事項編集パターン
                = DbBusinessConfig.get(ConfigNameDBE.情報提供資料の特記事項編集パターン, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (特記事項区分List.contains(TokkijikoTextImageKubun.イメージ.getコード())) {
            FlexibleDate 特記事項判定日 = new FlexibleDate(DbBusinessConfig
                    .get(ConfigNameDBE.特記事項判定日, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
            if (business.toEntity().get認定申請年月日().isBeforeOrEquals(特記事項判定日)) {
                printNinteiChosaTokkiImage(business, 特記事項List, 特記事項マスキング区分, assembler);
            } else {
                printNinteiChosaTokkiImage1A4Separate(business, 特記事項List,
                        特記事項マスキング区分, イメージ共有ファイルID, 情報提供資料の特記事項編集パターン, assembler);
            }
        } else if (特記事項区分List.contains(TokkijikoTextImageKubun.テキスト.getコード())) {
            if (すべて.equals(情報提供資料の特記事項編集パターン)) {
                printTokkiText1A4All(business, 特記事項List, 特記事項マスキング区分, 情報提供資料の特記事項編集パターン, assembler);
            } else {
                printTokkiText1A4Separate(business, 特記事項List, 特記事項マスキング区分, 情報提供資料の特記事項編集パターン, assembler);
            }
        }
    }

    private void printNinteiChosaTokkiImage(YokaigoNinteiJohoTeikyoBusiness business,
            List<NinteichosaRelate> 特記事項List,
            RString 特記事項マスキング区分,
            ReportAssembler<YokaigoNinteiJohoTeikyoIsshikiReportSource> assembler) {
        ReportSourceWriter<YokaigoNinteiJohoTeikyoIsshikiReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
        JohoTeikyoIsshikiNinteiChosaTokkiImageReport report = new JohoTeikyoIsshikiNinteiChosaTokkiImageReport(
                NinteiChosaTokkiImageEntityEditor.edit(business.toEntity(), 特記事項List, 特記事項マスキング区分));
        report.writeBy(reportSourceWriter);
    }

    private void printNinteiChosaTokkiImage1A4Separate(YokaigoNinteiJohoTeikyoBusiness business,
            List<NinteichosaRelate> 特記事項List,
            RString 特記事項マスキング区分,
            RDateTime イメージ共有ファイルID,
            RString 情報提供資料の特記事項編集パターン,
            ReportAssembler<YokaigoNinteiJohoTeikyoIsshikiReportSource> assembler) {
        ReportSourceWriter<YokaigoNinteiJohoTeikyoIsshikiReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
        JohoTeikyoIsshikiTokkiImage1A4SeparateReport report = new JohoTeikyoIsshikiTokkiImage1A4SeparateReport(
                TokkiImage1A4SeparateEditor.edit(business.toEntity(), 特記事項List, 特記事項マスキング区分, イメージ共有ファイルID));
        report.writeBy(reportSourceWriter);
    }

    private void printTokkiText1A4All(YokaigoNinteiJohoTeikyoBusiness business,
            List<NinteichosaRelate> 特記事項List,
            RString 特記事項マスキング区分,
            RString 情報提供資料の特記事項編集パターン,
            ReportAssembler<YokaigoNinteiJohoTeikyoIsshikiReportSource> assembler) {
        ReportSourceWriter<YokaigoNinteiJohoTeikyoIsshikiReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
        JohoTeikyoIsshikiTokkiText1A4Report report
                = new JohoTeikyoIsshikiTokkiText1A4Report(TokkiText1A4AllEditor.edit(business.toEntity(), 特記事項List, 特記事項マスキング区分),
                        情報提供資料の特記事項編集パターン);
        report.writeBy(reportSourceWriter);
    }

    private void printTokkiText1A4Separate(YokaigoNinteiJohoTeikyoBusiness business,
            List<NinteichosaRelate> 特記事項List,
            RString 特記事項マスキング区分,
            RString 情報提供資料の特記事項編集パターン,
            ReportAssembler<YokaigoNinteiJohoTeikyoIsshikiReportSource> assembler) {
        ReportSourceWriter<YokaigoNinteiJohoTeikyoIsshikiReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
        JohoTeikyoIsshikiTokkiText1A4Report report
                = new JohoTeikyoIsshikiTokkiText1A4Report(TokkiText1A4SeparateEditor.edit(business.toEntity(), 特記事項List, 特記事項マスキング区分),
                        情報提供資料の特記事項編集パターン);
        report.writeBy(reportSourceWriter);
    }

    private void print主治医意見書(YokaigoNinteiJohoTeikyoBusiness business,
            RDateTime イメージ共有ファイルID,
            RString 主治医意見書マスキング区分,
            ReportAssembler<YokaigoNinteiJohoTeikyoIsshikiReportSource> assembler) {
        ReportSourceWriter<YokaigoNinteiJohoTeikyoIsshikiReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
        JohoTeikyoIsshikiShujiiikenshoReport report = new JohoTeikyoIsshikiShujiiikenshoReport(
                ShujiiikenshoEntityEditor.edit(business.toEntity(), イメージ共有ファイルID, 主治医意見書マスキング区分));
        report.writeBy(reportSourceWriter);
    }

    private void printその他資料(YokaigoNinteiJohoTeikyoBusiness business,
            RDateTime イメージ共有ファイルID,
            RString その他資料マスキング区分,
            ReportAssembler<YokaigoNinteiJohoTeikyoIsshikiReportSource> assembler) {
        if (イメージ共有ファイルID != null) {
            RString 共有フォルダ名 = business.get保険者番号().concat(business.get被保険者番号());
            ReadOnlySharedFileEntryDescriptor descriptor = get共有ファイルエントリ情報(共有フォルダ名, イメージ共有ファイルID);
            RString path = copySharedFiles(descriptor);
            RString イメージファイルパスA = getAイメージファイルパス(descriptor, path, その他資料マスキング区分);
            RString イメージファイルパスB = getBイメージファイルパス(descriptor, path, その他資料マスキング区分);
            RString イメージファイルパスC = getCイメージファイルパス(descriptor, path, その他資料マスキング区分);
            RString イメージファイルパスD = getDイメージファイルパス(descriptor, path, その他資料マスキング区分);
            RString イメージファイルパスE = getEイメージファイルパス(descriptor, path, その他資料マスキング区分);
            RString イメージファイルパスF = getFイメージファイルパス(descriptor, path, その他資料マスキング区分);
            ReportSourceWriter<YokaigoNinteiJohoTeikyoIsshikiReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            if (!イメージファイルパスA.isEmpty()) {
                JohoTeikyoIsshikiSonoTashiryoReport report
                        = new JohoTeikyoIsshikiSonoTashiryoReport(SonoTashiryoEntityEditor.edit(business.toEntity(), イメージファイルパスA));
                report.writeBy(reportSourceWriter);
            }
            if (!イメージファイルパスB.isEmpty()) {
                JohoTeikyoIsshikiSonoTashiryoReport report
                        = new JohoTeikyoIsshikiSonoTashiryoReport(SonoTashiryoEntityEditor.edit(business.toEntity(), イメージファイルパスB));
                report.writeBy(reportSourceWriter);
            }
            if (!イメージファイルパスC.isEmpty()) {
                JohoTeikyoIsshikiSonoTashiryoReport report
                        = new JohoTeikyoIsshikiSonoTashiryoReport(SonoTashiryoEntityEditor.edit(business.toEntity(), イメージファイルパスC));
                report.writeBy(reportSourceWriter);
            }
            if (!イメージファイルパスD.isEmpty()) {
                JohoTeikyoIsshikiSonoTashiryoReport report
                        = new JohoTeikyoIsshikiSonoTashiryoReport(SonoTashiryoEntityEditor.edit(business.toEntity(), イメージファイルパスD));
                report.writeBy(reportSourceWriter);
            }
            if (!イメージファイルパスE.isEmpty()) {
                JohoTeikyoIsshikiSonoTashiryoReport report
                        = new JohoTeikyoIsshikiSonoTashiryoReport(SonoTashiryoEntityEditor.edit(business.toEntity(), イメージファイルパスE));
                report.writeBy(reportSourceWriter);
            }
            if (!イメージファイルパスF.isEmpty()) {
                JohoTeikyoIsshikiSonoTashiryoReport report
                        = new JohoTeikyoIsshikiSonoTashiryoReport(SonoTashiryoEntityEditor.edit(business.toEntity(), イメージファイルパスF));
                report.writeBy(reportSourceWriter);
            }
        }

    }

    private void print一次判定結果(YokaigoNinteiJohoTeikyoBusiness business,
            List<RString> 認定調査特記事項番号List,
            List<NinteichosahyoServiceJokyo> 認定調査票サービス状況List,
            List<NinteichosahyoServiceJokyoFlag> 認定調査票サービス状況フラグList,
            List<NinteichosahyoChosaItem> 認定調査票調査項目List,
            List<NinteichosahyoChosaItem> 前回認定調査票調査項目List,
            List<ShujiiIkenshoIkenItem> 主治医意見書意見項目List,
            List<ShujiiIkenshoIkenItem> 前回主治医意見書意見項目List,
            RString 一次判定結果マスキング区分,
            RString 正常選択肢印刷有無,
            RString 認定調査前回結果印刷有無,
            ReportAssembler<YokaigoNinteiJohoTeikyoIsshikiReportSource> assembler) {
        ReportSourceWriter<YokaigoNinteiJohoTeikyoIsshikiReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
        JohoTeikyoIsshikiIchijihanteikekkahyoReport report
                = new JohoTeikyoIsshikiIchijihanteikekkahyoReport(IchijihanteikekkahyoEntityEditor.edit(business.toEntity(),
                                認定調査特記事項番号List, 認定調査票サービス状況List, 認定調査票サービス状況フラグList,
                                認定調査票調査項目List, 前回認定調査票調査項目List, 主治医意見書意見項目List, 前回主治医意見書意見項目List,
                                正常選択肢印刷有無, 認定調査前回結果印刷有無, 一次判定結果マスキング区分));
        report.writeBy(reportSourceWriter);
    }

    private RString getAイメージファイルパス(ReadOnlySharedFileEntryDescriptor descriptor, RString path, RString その他資料マスキング区分) {
        if (マスキングあり.equals(その他資料マスキング区分)) {
            RString fineFullPath = getFilePath(path, FILENAME_A);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        } else {
            List<SharedFileEntryInfoEntity> entryInfoList = SharedFile.getEntryInfo(descriptor);
            RString ファイル名 = (existマスキングファイル(entryInfoList, FILENAME_A_BAK)) ? FILENAME_A_BAK : FILENAME_A;
            RString fineFullPath = getFilePath(path, ファイル名);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        }
    }

    private RString getBイメージファイルパス(ReadOnlySharedFileEntryDescriptor descriptor, RString path, RString その他資料マスキング区分) {
        if (マスキングあり.equals(その他資料マスキング区分)) {
            RString fineFullPath = getFilePath(path, FILENAME_B);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        } else {
            List<SharedFileEntryInfoEntity> entryInfoList = SharedFile.getEntryInfo(descriptor);
            RString ファイル名 = (existマスキングファイル(entryInfoList, FILENAME_B_BAK)) ? FILENAME_B_BAK : FILENAME_B;
            RString fineFullPath = getFilePath(path, ファイル名);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        }
    }

    private RString getCイメージファイルパス(ReadOnlySharedFileEntryDescriptor descriptor, RString path, RString その他資料マスキング区分) {
        if (マスキングあり.equals(その他資料マスキング区分)) {
            RString fineFullPath = getFilePath(path, FILENAME_C);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        } else {
            List<SharedFileEntryInfoEntity> entryInfoList = SharedFile.getEntryInfo(descriptor);
            RString ファイル名 = (existマスキングファイル(entryInfoList, FILENAME_C_BAK)) ? FILENAME_C_BAK : FILENAME_C;
            RString fineFullPath = getFilePath(path, ファイル名);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        }
    }

    private RString getDイメージファイルパス(ReadOnlySharedFileEntryDescriptor descriptor, RString path, RString その他資料マスキング区分) {
        if (マスキングあり.equals(その他資料マスキング区分)) {
            RString fineFullPath = getFilePath(path, FILENAME_D);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        } else {
            List<SharedFileEntryInfoEntity> entryInfoList = SharedFile.getEntryInfo(descriptor);
            RString ファイル名 = (existマスキングファイル(entryInfoList, FILENAME_D_BAK)) ? FILENAME_D_BAK : FILENAME_D;
            RString fineFullPath = getFilePath(path, ファイル名);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        }
    }

    private RString getEイメージファイルパス(ReadOnlySharedFileEntryDescriptor descriptor, RString path, RString その他資料マスキング区分) {
        if (マスキングあり.equals(その他資料マスキング区分)) {
            RString fineFullPath = getFilePath(path, FILENAME_E);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        } else {
            List<SharedFileEntryInfoEntity> entryInfoList = SharedFile.getEntryInfo(descriptor);
            RString ファイル名 = (existマスキングファイル(entryInfoList, FILENAME_E_BAK)) ? FILENAME_E_BAK : FILENAME_E;
            RString fineFullPath = getFilePath(path, ファイル名);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        }
    }

    private RString getFイメージファイルパス(ReadOnlySharedFileEntryDescriptor descriptor, RString path, RString その他資料マスキング区分) {
        if (マスキングあり.equals(その他資料マスキング区分)) {
            RString fineFullPath = getFilePath(path, FILENAME_F);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        } else {
            List<SharedFileEntryInfoEntity> entryInfoList = SharedFile.getEntryInfo(descriptor);
            RString ファイル名 = (existマスキングファイル(entryInfoList, FILENAME_F_BAK)) ? FILENAME_F_BAK : FILENAME_F;
            RString fineFullPath = getFilePath(path, ファイル名);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        }
    }

    private boolean existマスキングファイル(List<SharedFileEntryInfoEntity> entryInfoList, RString ファイル名) {
        for (SharedFileEntryInfoEntity entryInfo : entryInfoList) {
            if (entryInfo.getFilesEntity().getPathname().endsWith(ファイル名)) {
                return true;
            }
        }
        return false;
    }

    private ReadOnlySharedFileEntryDescriptor get共有ファイルエントリ情報(RString 共有フォルダ名, RDateTime イメージ共有ファイルID) {
        return new ReadOnlySharedFileEntryDescriptor(new FilesystemName(共有フォルダ名), イメージ共有ファイルID);
    }

    private static RString copySharedFiles(ReadOnlySharedFileEntryDescriptor descriptor) {
        RString 出力イメージフォルダパス = Directory.createTmpDirectory();
        return new RString(SharedFile.copyToLocal(descriptor, new FilesystemPath(出力イメージフォルダパス)).getCanonicalPath());
    }

    private RString getFilePath(RString 出力イメージフォルダパス, RString ファイル名) {
        if (Directory.exists(Path.combinePath(出力イメージフォルダパス, SEPARATOR, ファイル名))) {
            return Path.combinePath(出力イメージフォルダパス, SEPARATOR, ファイル名);
        }
        return RString.EMPTY;
    }

    private static <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(
            IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }
}
